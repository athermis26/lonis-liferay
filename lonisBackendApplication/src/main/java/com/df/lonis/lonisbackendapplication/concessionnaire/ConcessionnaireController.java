package com.df.lonis.lonisbackendapplication.concessionnaire;

import com.df.lonis.lonisbackendapplication.chiffreaffaires.ChiffreAffaires;
import com.df.lonis.lonisbackendapplication.chiffreaffaires.ChiffreAffairesRepository;
import com.df.lonis.lonisbackendapplication.chiffreaffaires.TerminalAggregate;
import com.df.lonis.lonisbackendapplication.commission.Commission;
import com.df.lonis.lonisbackendapplication.commission.CommissionDtos.CommissionResponse;
import com.df.lonis.lonisbackendapplication.commission.CommissionRepository;
import com.df.lonis.lonisbackendapplication.common.NotFoundException;
import com.df.lonis.lonisbackendapplication.common.PageResponse;
import com.df.lonis.lonisbackendapplication.common.SortParser;
import com.df.lonis.lonisbackendapplication.concessionnaire.ConcessionnaireDtos.ConcessionnaireActiviteResponse;
import com.df.lonis.lonisbackendapplication.concessionnaire.ConcessionnaireDtos.ConcessionnaireDetailResponse;
import com.df.lonis.lonisbackendapplication.concessionnaire.ConcessionnaireDtos.ConcessionnaireProduitResponse;
import com.df.lonis.lonisbackendapplication.concessionnaire.ConcessionnaireDtos.ConcessionnaireRequest;
import com.df.lonis.lonisbackendapplication.concessionnaire.ConcessionnaireDtos.ConcessionnaireResponse;
import com.df.lonis.lonisbackendapplication.concessionnaire.ConcessionnaireDtos.ConcessionnaireStatsResponse;
import com.df.lonis.lonisbackendapplication.operation.OperationRepository;
import com.df.lonis.lonisbackendapplication.terminal.Terminal;
import com.df.lonis.lonisbackendapplication.terminal.TerminalDtos.TerminalResponse;
import com.df.lonis.lonisbackendapplication.terminal.TerminalEnricher;
import com.df.lonis.lonisbackendapplication.terminal.TerminalRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Endpoints concessionnaire « vente ».
 *
 * <p>Le contrat OpenAPI Liferay utilise la racine plurielle {@code /concessionnaires}
 * et la racine singulière {@code /concessionnaire} (POST). Les deux sont exposés ici
 * pour que le mapping Liferay soit trivial.</p>
 */
@RestController
@RequestMapping("/api/v1")
public class ConcessionnaireController {

	private final ConcessionnaireService service;
	private final ConcessionnaireRepository repository;
	private final ConcessionnaireProduitRepository produitLinkRepository;
	private final TerminalRepository terminalRepository;
	private final TerminalEnricher terminalEnricher;
	private final OperationRepository operationRepository;
	private final CommissionRepository commissionRepository;
	private final ChiffreAffairesRepository chiffreAffairesRepository;

	public ConcessionnaireController(
			ConcessionnaireService service,
			ConcessionnaireRepository repository,
			ConcessionnaireProduitRepository produitLinkRepository,
			TerminalRepository terminalRepository,
			TerminalEnricher terminalEnricher,
			OperationRepository operationRepository,
			CommissionRepository commissionRepository,
			ChiffreAffairesRepository chiffreAffairesRepository) {
		this.service = service;
		this.repository = repository;
		this.produitLinkRepository = produitLinkRepository;
		this.terminalRepository = terminalRepository;
		this.terminalEnricher = terminalEnricher;
		this.operationRepository = operationRepository;
		this.commissionRepository = commissionRepository;
		this.chiffreAffairesRepository = chiffreAffairesRepository;
	}

	// ──────────────────────────────────────────────
	// LISTE / DÉTAIL
	// ──────────────────────────────────────────────

	/** GET /api/v1/concessionnaires — liste paginée. */
	@GetMapping("/concessionnaires")
	public PageResponse<ConcessionnaireResponse> list(
			@RequestParam(required = false) String search,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int pageSize,
			@RequestParam(defaultValue = "nom,asc") String sort) {

		Page<Concessionnaire> result = service.search(search,
				PageRequest.of(page, pageSize, SortParser.parse(sort)));
		return PageResponse.of(result.map(ConcessionnaireResponse::from));
	}

	/** POST /api/v1/concessionnaire — création (path singulier comme dans l'OpenAPI Liferay). */
	@PostMapping("/concessionnaire")
	public ResponseEntity<ConcessionnaireResponse> create(@Valid @RequestBody ConcessionnaireRequest request) {
		Concessionnaire c = service.create(request);
		return ResponseEntity.status(201).body(ConcessionnaireResponse.from(c));
	}

	/** GET /api/v1/concessionnaires/{id} — vue 360°. */
	@GetMapping("/concessionnaires/{id}")
	public ConcessionnaireDetailResponse getOne(@PathVariable Long id) {
		Concessionnaire c = service.getById(id);

		List<ConcessionnaireProduit> produitsLinks = produitLinkRepository.findByConcessionnaireId(id);
		List<ConcessionnaireProduitResponse> produitsDtos = produitsLinks.stream()
				.map(ConcessionnaireProduitResponse::from).toList();

		List<Terminal> terminaux = terminalRepository.findByConcessionnaireId(id);
		List<TerminalResponse> terminauxDtos = terminalEnricher.enrich(terminaux);

		long totalOperations = terminaux.stream()
				.mapToLong(t -> operationRepository.countByTerminalId(t.getId())).sum();

		List<ChiffreAffaires> ca = terminaux.stream()
				.flatMap(t -> chiffreAffairesRepository.findByTerminalId(t.getId()).stream())
				.toList();
		long chiffreAffaires = ca.stream().mapToLong(ChiffreAffaires::getVentes).sum();
		long totalPaiements = ca.stream().mapToLong(ChiffreAffaires::getPaiement).sum();
		long soldeTotal     = ca.stream().mapToLong(ChiffreAffaires::getBalance).sum();

		ConcessionnaireStatsResponse stats = new ConcessionnaireStatsResponse(
				produitsLinks.size(),
				terminaux.size(),
				totalOperations,
				totalPaiements,
				chiffreAffaires
		);

		return new ConcessionnaireDetailResponse(
				c.getId(), c.getUid(), c.getNom(), c.getPrenoms(),
				c.getTelephone(), c.getEmail(),
				stats, produitsDtos, terminauxDtos, soldeTotal
		);
	}

	// ──────────────────────────────────────────────
	// PRODUITS LIÉS
	// ──────────────────────────────────────────────

	/** GET /api/v1/concessionnaires/{id}/produits */
	@GetMapping("/concessionnaires/{id}/produits")
	public List<ConcessionnaireProduitResponse> listProduits(@PathVariable Long id) {
		service.getById(id);  // 404 si absent
		return produitLinkRepository.findByConcessionnaireId(id).stream()
				.map(ConcessionnaireProduitResponse::from).toList();
	}

	/** DELETE /api/v1/concessionnaires/{id}/produits/{cpId} — délier un produit. */
	@DeleteMapping("/concessionnaires/{id}/produits/{concessionnaireProduitId}")
	public ResponseEntity<Void> deleteProduitLink(
			@PathVariable Long id,
			@PathVariable Long concessionnaireProduitId) {

		ConcessionnaireProduit cp = produitLinkRepository.findById(concessionnaireProduitId)
				.orElseThrow(() -> new NotFoundException(
						"ConcessionnaireProduit " + concessionnaireProduitId + " introuvable"));
		if (!Objects.equals(cp.getConcessionnaireId(), id)) {
			throw new NotFoundException(
					"Le produit " + concessionnaireProduitId
							+ " n'appartient pas au concessionnaire " + id);
		}
		produitLinkRepository.delete(cp);
		return ResponseEntity.noContent().build();
	}

	// ──────────────────────────────────────────────
	// TERMINAUX / COMMISSIONS DU CONCESSIONNAIRE
	// ──────────────────────────────────────────────

	/** GET /api/v1/concessionnaires/{id}/terminaux */
	@GetMapping("/concessionnaires/{id}/terminaux")
	public List<TerminalResponse> listTerminaux(
			@PathVariable Long id,
			@RequestParam(required = false) String concessionnaireProduitCode,
			@RequestParam(required = false) String dateDebut,
			@RequestParam(required = false) String dateFin) {

		service.getById(id);
		List<Terminal> terminaux = terminalRepository.findByConcessionnaireId(id);
		if (concessionnaireProduitCode != null && !concessionnaireProduitCode.isBlank()) {
			terminaux = terminaux.stream()
					.filter(t -> concessionnaireProduitCode.equals(t.getConcessionnaireProduitCode()))
					.toList();
		}
		// Note : dateDebut / dateFin filtrent les CA dans l'enrichissement futur si besoin.
		return terminalEnricher.enrich(terminaux);
	}

	/** GET /api/v1/concessionnaires/{id}/commissions */
	@GetMapping("/concessionnaires/{id}/commissions")
	public PageResponse<CommissionResponse> listCommissions(
			@PathVariable Long id,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "createdAt,desc") String sort) {

		service.getById(id);
		List<Long> terminalIds = terminalRepository.findByConcessionnaireId(id).stream()
				.map(Terminal::getId).toList();
		if (terminalIds.isEmpty()) {
			return PageResponse.of(Page.empty());
		}

		Page<Commission> commissions = commissionRepository.findByTerminalIdIn(
				terminalIds, PageRequest.of(page, pageSize, SortParser.parse(sort)));

		Map<Long, String> codeByTerminal = terminalRepository.findAllById(terminalIds).stream()
				.collect(Collectors.toMap(Terminal::getId, Terminal::getCodeTerminal));

		return PageResponse.of(commissions.map(c ->
				CommissionResponse.from(c, codeByTerminal.get(c.getTerminalId()))));
	}

	// ──────────────────────────────────────────────
	// TOP-ACTIFS
	// ──────────────────────────────────────────────

	/** GET /api/v1/concessionnaires/top-actifs */
	@GetMapping("/concessionnaires/top-actifs")
	public List<ConcessionnaireActiviteResponse> topActifs(
			@RequestParam(defaultValue = "10") int limit) {

		List<TerminalAggregate> aggregates = chiffreAffairesRepository.aggregateByTerminal(null, null);
		if (aggregates.isEmpty()) return List.of();

		List<Long> terminalIds = aggregates.stream().map(TerminalAggregate::terminalId).toList();
		Map<Long, Terminal> terminalsById = terminalRepository.findAllById(terminalIds).stream()
				.collect(Collectors.toMap(Terminal::getId, Function.identity()));

		// Agréger par concessionnaire
		Map<Long, long[]> statsByConcess = aggregates.stream().collect(Collectors.toMap(
				agg -> {
					Terminal t = terminalsById.get(agg.terminalId());
					return t == null ? null : t.getConcessionnaireId();
				},
				agg -> new long[] { agg.chiffreAffaires(), agg.soldeTotal() },
				(a, b) -> new long[] { a[0] + b[0], a[1] + b[1] }));
		statsByConcess.remove(null);

		List<Map.Entry<Long, long[]>> top = statsByConcess.entrySet().stream()
				.sorted((a, b) -> Long.compare(b.getValue()[0], a.getValue()[0]))
				.limit(limit)
				.toList();

		Map<Long, Concessionnaire> concessionnaires = repository
				.findAllById(top.stream().map(Map.Entry::getKey).toList()).stream()
				.collect(Collectors.toMap(Concessionnaire::getId, Function.identity()));

		return top.stream().map(entry -> {
			Long concessId = entry.getKey();
			long[] arr = entry.getValue();
			Concessionnaire c = concessionnaires.get(concessId);
			if (c == null) return null;

			List<Terminal> ts = terminalRepository.findByConcessionnaireId(concessId);
			long nbOps = ts.stream().mapToLong(t -> operationRepository.countByTerminalId(t.getId())).sum();
			List<String> codes = produitLinkRepository.findByConcessionnaireId(concessId).stream()
					.map(ConcessionnaireProduit::getConcessionnaireCode)
					.filter(Objects::nonNull).distinct().toList();

			return new ConcessionnaireActiviteResponse(
					concessId, c.getUid(), c.getNom(), c.getPrenoms(), c.getTelephone(),
					ts.size(), nbOps, arr[0], arr[1], codes
			);
		}).filter(Objects::nonNull).toList();
	}
}
