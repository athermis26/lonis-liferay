package com.df.lonis.lonisbackendapplication.terminal;

import com.df.lonis.lonisbackendapplication.chiffreaffaires.ChiffreAffairesRepository;
import com.df.lonis.lonisbackendapplication.chiffreaffaires.TerminalAggregate;
import com.df.lonis.lonisbackendapplication.common.NotFoundException;
import com.df.lonis.lonisbackendapplication.common.PageResponse;
import com.df.lonis.lonisbackendapplication.common.SortParser;
import com.df.lonis.lonisbackendapplication.terminal.TerminalReseauDtos.TerminalCreateRequest;
import com.df.lonis.lonisbackendapplication.terminal.TerminalReseauDtos.TerminalRejetRequest;
import com.df.lonis.lonisbackendapplication.terminal.TerminalReseauDtos.TerminalReseauResponse;
import com.df.lonis.lonisbackendapplication.terminal.TerminalReseauDtos.TerminalUpdateRequest;
import com.df.lonis.lonisbackendapplication.visite.Visite;
import com.df.lonis.lonisbackendapplication.visite.VisiteRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Endpoints "réseau" sur les terminaux : enrôlement, validation, cartographie.
 *
 * <p>Note : ces endpoints exposent une vue DIFFÉRENTE du Terminal (latitude/longitude/
 * adresse/statutValidation) par rapport aux endpoints {@code /api/v1/terminaux} (vente)
 * qui retournent un Terminal enrichi (concessionnaireNomPrenom, produit, site, solde).</p>
 */
@RestController
@RequestMapping("/api/v1")
@Transactional
public class TerminalReseauController {

	private final TerminalRepository repository;
	private final VisiteRepository visiteRepository;
	private final ChiffreAffairesRepository chiffreAffairesRepository;

	public TerminalReseauController(
			TerminalRepository repository,
			VisiteRepository visiteRepository,
			ChiffreAffairesRepository chiffreAffairesRepository) {
		this.repository = repository;
		this.visiteRepository = visiteRepository;
		this.chiffreAffairesRepository = chiffreAffairesRepository;
	}

	// ──────────────────────────────────────────────
	// CRUD
	// ──────────────────────────────────────────────

	/** GET /api/v1/terminals — liste paginée filtrable par site/statut. */
	@GetMapping("/terminals")
	@Transactional(readOnly = true)
	public PageResponse<TerminalReseauResponse> list(
			@RequestParam(required = false) Long siteId,
			@RequestParam(required = false) String statutValidation,
			@RequestParam(required = false) String search,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int pageSize,
			@RequestParam(defaultValue = "codeTerminal,asc") String sort) {

		Page<Terminal> result;
		if (statutValidation != null && !statutValidation.isBlank()) {
			result = repository.findByStatutValidation(statutValidation,
					PageRequest.of(page, pageSize, SortParser.parse(sort)));
		}
		else if (siteId != null) {
			List<Terminal> bySite = repository.findBySiteId(siteId);
			int from = Math.min(page * pageSize, bySite.size());
			int to   = Math.min(from + pageSize, bySite.size());
			result = new PageImpl<>(bySite.subList(from, to),
					PageRequest.of(page, pageSize, SortParser.parse(sort)), bySite.size());
		}
		else if (search != null && !search.isBlank()) {
			result = repository.findByCodeTerminalContainingIgnoreCase(
					search, PageRequest.of(page, pageSize, SortParser.parse(sort)));
		}
		else {
			result = repository.findAll(PageRequest.of(page, pageSize, SortParser.parse(sort)));
		}

		return PageResponse.of(result.map(TerminalReseauResponse::from));
	}

	/** GET /api/v1/terminals/{id} */
	@GetMapping("/terminals/{terminalId}")
	@Transactional(readOnly = true)
	public TerminalReseauResponse getOne(@PathVariable Long terminalId) {
		return TerminalReseauResponse.from(getOrThrow(terminalId));
	}

	/** POST /api/v1/terminals — enrôlement. */
	@PostMapping("/terminals")
	public ResponseEntity<TerminalReseauResponse> create(@Valid @RequestBody TerminalCreateRequest req) {
		Terminal t = new Terminal();
		t.setCodeTerminal(generateCode());
		t.setConcessionnaireId(req.concessionnaireId());
		t.setSiteId(req.siteId());
		t.setLatitude(req.latitude());
		t.setLongitude(req.longitude());
		t.setAdresse(req.adresse());
		t.setStatutValidation("EN_ATTENTE");
		repository.save(t);
		return ResponseEntity.status(201).body(TerminalReseauResponse.from(t));
	}

	/** PUT /api/v1/terminals/{id} */
	@PutMapping("/terminals/{terminalId}")
	public TerminalReseauResponse update(
			@PathVariable Long terminalId,
			@Valid @RequestBody TerminalUpdateRequest req) {

		Terminal t = getOrThrow(terminalId);
		if (req.concessionnaireId() != null) t.setConcessionnaireId(req.concessionnaireId());
		if (req.siteId() != null) t.setSiteId(req.siteId());
		if (req.latitude() != null) t.setLatitude(req.latitude());
		if (req.longitude() != null) t.setLongitude(req.longitude());
		if (req.adresse() != null) t.setAdresse(req.adresse());
		repository.save(t);
		return TerminalReseauResponse.from(t);
	}

	// ──────────────────────────────────────────────
	// VALIDATION (workflow d'enrôlement)
	// ──────────────────────────────────────────────

	/** GET /api/v1/terminals/a-valider — terminaux en attente de validation. */
	@GetMapping("/terminals/a-valider")
	@Transactional(readOnly = true)
	public PageResponse<TerminalReseauResponse> aValider(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int pageSize,
			@RequestParam(defaultValue = "createdAt,asc") String sort) {

		Page<Terminal> result = repository.findByStatutValidation(
				"EN_ATTENTE", PageRequest.of(page, pageSize, SortParser.parse(sort)));
		return PageResponse.of(result.map(TerminalReseauResponse::from));
	}

	/** PATCH /api/v1/terminals/{id}/valider */
	@PatchMapping("/terminals/{terminalId}/valider")
	public TerminalReseauResponse valider(@PathVariable Long terminalId) {
		Terminal t = getOrThrow(terminalId);
		t.setStatutValidation("VALIDE");
		repository.save(t);
		return TerminalReseauResponse.from(t);
	}

	/** PATCH /api/v1/terminals/{id}/rejeter — body : {@code {"motif":"..."}}. */
	@PatchMapping("/terminals/{terminalId}/rejeter")
	public TerminalReseauResponse rejeter(
			@PathVariable Long terminalId,
			@RequestBody(required = false) TerminalRejetRequest body) {

		Terminal t = getOrThrow(terminalId);
		t.setStatutValidation("REJETE");
		// Le motif n'est pas stocké actuellement (pas de colonne dédiée).
		// TODO : ajouter une colonne `motif_rejet` si l'audit le demande.
		repository.save(t);
		return TerminalReseauResponse.from(t);
	}

	// ──────────────────────────────────────────────
	// CARTOGRAPHIE
	// ──────────────────────────────────────────────

	/** GET /api/v1/terminals/cartographie — terminaux validés avec coordonnées. */
	@GetMapping("/terminals/cartographie")
	@Transactional(readOnly = true)
	public PageResponse<TerminalReseauResponse> cartographie(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "200") int pageSize) {

		Page<Terminal> result = repository.findByStatutValidation(
				"VALIDE", PageRequest.of(page, pageSize));
		return PageResponse.of(result.map(TerminalReseauResponse::from));
	}

	/** GET /api/v1/terminals/cartographie/top20 — top 20 par CA pour la carte. */
	@GetMapping("/terminals/cartographie/top20")
	@Transactional(readOnly = true)
	public List<TerminalReseauResponse> cartographieTop20() {
		List<TerminalAggregate> aggregates = chiffreAffairesRepository.aggregateByTerminal(null, null);
		List<Long> topIds = aggregates.stream().limit(20).map(TerminalAggregate::terminalId).toList();
		return repository.findAllById(topIds).stream().map(TerminalReseauResponse::from).toList();
	}

	// ──────────────────────────────────────────────
	// VISITES D'UN TERMINAL
	// ──────────────────────────────────────────────

	/** GET /api/v1/terminals/{id}/visites */
	@GetMapping("/terminals/{terminalId}/visites")
	@Transactional(readOnly = true)
	public List<Visite> listVisites(@PathVariable Long terminalId) {
		getOrThrow(terminalId);
		return visiteRepository.findByTerminalId(terminalId);
	}

	// ──────────────────────────────────────────────
	// Helpers
	// ──────────────────────────────────────────────

	private Terminal getOrThrow(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Terminal " + id + " introuvable"));
	}

	private String generateCode() {
		return "T" + System.currentTimeMillis();
	}
}
