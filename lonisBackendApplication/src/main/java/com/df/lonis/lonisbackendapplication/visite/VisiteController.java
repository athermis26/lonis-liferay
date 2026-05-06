package com.df.lonis.lonisbackendapplication.visite;

import com.df.lonis.lonisbackendapplication.common.NotFoundException;
import com.df.lonis.lonisbackendapplication.common.PageResponse;
import com.df.lonis.lonisbackendapplication.common.SortParser;
import com.df.lonis.lonisbackendapplication.visite.VisiteDtos.VisiteRequest;
import com.df.lonis.lonisbackendapplication.visite.VisiteDtos.VisiteResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Transactional
public class VisiteController {

	private final VisiteRepository repository;

	public VisiteController(VisiteRepository repository) {
		this.repository = repository;
	}

	/** GET /api/v1/visites */
	@GetMapping("/visites")
	@Transactional(readOnly = true)
	public PageResponse<VisiteResponse> list(
			@RequestParam(required = false) Long commercialId,
			@RequestParam(required = false) Long terminalId,
			@RequestParam(required = false) String statut,
			@RequestParam(required = false) String dateDebut,
			@RequestParam(required = false) String dateFin,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int pageSize,
			@RequestParam(defaultValue = "dateVisite,desc") String sort) {

		Page<Visite> result = repository.search(
				commercialId, terminalId, statut,
				parseDate(dateDebut, false),
				parseDate(dateFin, true),
				PageRequest.of(page, pageSize, SortParser.parse(sort)));
		return PageResponse.of(result.map(VisiteResponse::from));
	}

	/** GET /api/v1/visites/{id} */
	@GetMapping("/visites/{visiteId}")
	@Transactional(readOnly = true)
	public VisiteResponse getOne(@PathVariable Long visiteId) {
		return VisiteResponse.from(getOrThrow(visiteId));
	}

	/** POST /api/v1/visites */
	@PostMapping("/visites")
	public ResponseEntity<VisiteResponse> create(@Valid @RequestBody VisiteRequest req) {
		Visite v = new Visite();
		apply(v, req);
		repository.save(v);
		return ResponseEntity.status(201).body(VisiteResponse.from(v));
	}

	/** GET /api/v1/visites/temps-reel — visites EFFECTUEE des dernières 24h. */
	@GetMapping("/visites/temps-reel")
	@Transactional(readOnly = true)
	public List<VisiteResponse> tempsReel() {
		Instant since = Instant.now().minusSeconds(24 * 3600);
		return repository.search(null, null, "EFFECTUEE", since, null,
						PageRequest.of(0, 500, SortParser.parse("dateVisite,desc")))
				.getContent().stream().map(VisiteResponse::from).toList();
	}

	/** GET /api/v1/commerciaux/{id}/visites */
	@GetMapping("/commerciaux/{commercialId}/visites")
	@Transactional(readOnly = true)
	public List<VisiteResponse> listByCommercial(@PathVariable Long commercialId) {
		return repository.findByCommercialId(commercialId).stream()
				.map(VisiteResponse::from).toList();
	}

	/** GET /api/v1/commerciaux/{id}/visites/planning — planning prévu vs réalisé. */
	@GetMapping("/commerciaux/{commercialId}/visites/planning")
	@Transactional(readOnly = true)
	public List<VisiteResponse> planning(@PathVariable Long commercialId) {
		// Pour l'instant : retourne toutes les visites du commercial.
		// Le tri PLANIFIEE/EFFECTUEE/MANQUEE peut se faire côté client.
		return repository.findByCommercialId(commercialId).stream()
				.map(VisiteResponse::from).toList();
	}

	// ──────────────────────────────────────────────
	// Helpers
	// ──────────────────────────────────────────────

	private Visite getOrThrow(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Visite " + id + " introuvable"));
	}

	private void apply(Visite v, VisiteRequest req) {
		v.setCommercialId(req.commercialId());
		v.setTerminalId(req.terminalId());
		v.setLatitude(req.latitude());
		v.setLongitude(req.longitude());
		if (req.statut() != null && !req.statut().isBlank()) v.setStatut(req.statut());
		v.setTypeControle(req.typeControle());
		v.setDateVisite(req.dateVisite() == null ? Instant.now() : req.dateVisite());
		v.setCompteRendu(req.compteRendu());
	}

	private static Instant parseDate(String iso, boolean endOfDay) {
		if (iso == null || iso.isBlank()) return null;
		try {
			return Instant.parse(iso);
		}
		catch (DateTimeParseException ignored) {
			try {
				LocalDate d = LocalDate.parse(iso);
				return endOfDay ? d.plusDays(1).atStartOfDay(ZoneOffset.UTC).toInstant()
						: d.atStartOfDay(ZoneOffset.UTC).toInstant();
			}
			catch (DateTimeParseException e) {
				return null;
			}
		}
	}
}
