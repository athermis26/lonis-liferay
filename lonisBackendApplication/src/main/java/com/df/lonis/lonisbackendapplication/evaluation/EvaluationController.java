package com.df.lonis.lonisbackendapplication.evaluation;

import com.df.lonis.lonisbackendapplication.commercial.Commercial;
import com.df.lonis.lonisbackendapplication.commercial.CommercialRepository;
import com.df.lonis.lonisbackendapplication.common.PageResponse;
import com.df.lonis.lonisbackendapplication.evaluation.EvaluationDtos.EvaluationResponse;
import com.df.lonis.lonisbackendapplication.evaluation.EvaluationDtos.GenererRequest;
import com.df.lonis.lonisbackendapplication.evaluation.EvaluationDtos.GenererResponse;
import com.df.lonis.lonisbackendapplication.objectif.Objectif;
import com.df.lonis.lonisbackendapplication.objectif.ObjectifRepository;
import com.df.lonis.lonisbackendapplication.visite.VisiteRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@Transactional
public class EvaluationController {

	private final EvaluationRepository repository;
	private final CommercialRepository commercialRepository;
	private final ObjectifRepository objectifRepository;
	private final VisiteRepository visiteRepository;

	public EvaluationController(
			EvaluationRepository repository,
			CommercialRepository commercialRepository,
			ObjectifRepository objectifRepository,
			VisiteRepository visiteRepository) {
		this.repository = repository;
		this.commercialRepository = commercialRepository;
		this.objectifRepository = objectifRepository;
		this.visiteRepository = visiteRepository;
	}

	/** GET /api/v1/evaluations/classement */
	@GetMapping("/evaluations/classement")
	@Transactional(readOnly = true)
	public PageResponse<EvaluationResponse> classement(
			@RequestParam int annee,
			@RequestParam(required = false) Integer mois,
			@RequestParam(required = false) Integer trimestre,
			@RequestParam(required = false) String periode,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int pageSize) {

		var pageEval = repository.classement(annee, periode, mois, trimestre,
				PageRequest.of(page, pageSize));

		// Hydratation nom/prenoms
		Map<Long, Commercial> byId = commercialRepository.findAllById(
				pageEval.getContent().stream().map(Evaluation::getCommercialId).toList()
		).stream().collect(Collectors.toMap(Commercial::getId, Function.identity()));

		var mapped = pageEval.getContent().stream()
				.map(e -> EvaluationResponse.from(e, byId.get(e.getCommercialId())))
				.toList();

		return PageResponse.of(new PageImpl<>(mapped, pageEval.getPageable(), pageEval.getTotalElements()));
	}

	/** GET /api/v1/commerciaux/{id}/evaluations */
	@GetMapping("/commerciaux/{commercialId}/evaluations")
	@Transactional(readOnly = true)
	public List<EvaluationResponse> listByCommercial(
			@PathVariable Long commercialId,
			@RequestParam(required = false) Integer annee,
			@RequestParam(required = false) Integer mois) {

		Commercial c = commercialRepository.findById(commercialId).orElse(null);

		List<Evaluation> evals = (annee != null)
				? repository.findByCommercialIdAndAnneeOrderByAnneeDesc(commercialId, annee)
				: repository.findByCommercialIdOrderByAnneeDescMoisDesc(commercialId);

		if (mois != null) {
			evals = evals.stream()
					.filter(e -> e.getMois() != null && e.getMois().equals(mois))
					.toList();
		}

		Commercial finalC = c;
		return evals.stream().map(e -> EvaluationResponse.from(e, finalC)).toList();
	}

	/**
	 * POST /api/v1/evaluations/generer — calcule pour chaque commercial le ratio
	 * visites effectuées / objectif visites de la période, et persiste une {@link Evaluation}.
	 */
	@PostMapping("/evaluations/generer")
	public GenererResponse generer(@Valid @RequestBody GenererRequest req) {

		List<Commercial> commerciaux = commercialRepository.findAll();
		List<Evaluation> generated = new java.util.ArrayList<>();

		for (Commercial c : commerciaux) {
			int prevues = objectifRepository.findByCommercialId(c.getId()).stream()
					.filter(o -> "VISITE".equals(o.getType()))
					.filter(o -> o.getAnnee() == req.annee())
					.filter(o -> req.mois() == null
							|| (o.getMois() != null && o.getMois().equals(req.mois())))
					.mapToInt(Objectif::getValeurCible).sum();

			int effectuees = (int) visiteRepository.countByCommercialIdAndStatut(c.getId(), "EFFECTUEE");

			double taux = prevues == 0 ? 0d : ((double) effectuees / prevues) * 100;

			Evaluation e = new Evaluation();
			e.setCommercialId(c.getId());
			e.setNbVisitesPrevues(prevues);
			e.setNbVisitesEffectuees(effectuees);
			e.setTauxRealisation(taux);
			e.setPeriode(req.periode());
			e.setMois(req.mois());
			e.setTrimestre(req.trimestre());
			e.setAnnee(req.annee());
			generated.add(e);
		}

		// Calcul du rang : trier par taux DESC et assigner 1, 2, 3, ...
		generated.sort(Comparator.comparingDouble(Evaluation::getTauxRealisation).reversed());
		for (int i = 0; i < generated.size(); i++) {
			generated.get(i).setRang(i + 1);
		}

		repository.saveAll(generated);

		return new GenererResponse(
				"Évaluations générées pour la période "
						+ req.periode() + " " + req.annee()
						+ (req.mois() != null ? " mois=" + req.mois() : "")
						+ (req.trimestre() != null ? " T" + req.trimestre() : ""),
				generated.size()
		);
	}
}
