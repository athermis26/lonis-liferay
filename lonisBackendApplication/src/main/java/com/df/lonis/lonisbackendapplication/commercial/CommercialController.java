package com.df.lonis.lonisbackendapplication.commercial;

import com.df.lonis.lonisbackendapplication.commercial.CommercialDtos.CommercialRequest;
import com.df.lonis.lonisbackendapplication.commercial.CommercialDtos.CommercialResponse;
import com.df.lonis.lonisbackendapplication.commercial.CommercialDtos.SiteCommercialRequest;
import com.df.lonis.lonisbackendapplication.commercial.CommercialDtos.SiteCommercialResponse;
import com.df.lonis.lonisbackendapplication.common.NotFoundException;
import com.df.lonis.lonisbackendapplication.common.PageResponse;
import com.df.lonis.lonisbackendapplication.common.SortParser;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Transactional
public class CommercialController {

	private final CommercialRepository repository;
	private final SiteCommercialRepository siteCommercialRepository;

	public CommercialController(
			CommercialRepository repository,
			SiteCommercialRepository siteCommercialRepository) {
		this.repository = repository;
		this.siteCommercialRepository = siteCommercialRepository;
	}

	// ──────────────────────────────────────────────
	// COMMERCIAUX
	// ──────────────────────────────────────────────

	/** GET /api/v1/commerciaux */
	@GetMapping("/commerciaux")
	@Transactional(readOnly = true)
	public PageResponse<CommercialResponse> list(
			@RequestParam(required = false) Long superviseurId,
			@RequestParam(required = false) String search,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int pageSize,
			@RequestParam(defaultValue = "nom,asc") String sort) {

		Page<Commercial> result;
		if (superviseurId != null) {
			result = repository.findBySuperviseurId(
					superviseurId, PageRequest.of(page, pageSize, SortParser.parse(sort)));
		}
		else if (search != null && !search.isBlank()) {
			result = repository
					.findByNomContainingIgnoreCaseOrPrenomsContainingIgnoreCaseOrMatriculeContainingIgnoreCase(
							search, search, search,
							PageRequest.of(page, pageSize, SortParser.parse(sort)));
		}
		else {
			result = repository.findAll(PageRequest.of(page, pageSize, SortParser.parse(sort)));
		}
		return PageResponse.of(result.map(CommercialResponse::from));
	}

	/** GET /api/v1/commerciaux/{id} */
	@GetMapping("/commerciaux/{commercialId}")
	@Transactional(readOnly = true)
	public CommercialResponse getOne(@PathVariable Long commercialId) {
		return CommercialResponse.from(getOrThrow(commercialId));
	}

	/** POST /api/v1/commerciaux */
	@PostMapping("/commerciaux")
	public ResponseEntity<CommercialResponse> create(@Valid @RequestBody CommercialRequest req) {
		Commercial c = new Commercial();
		applyRequest(c, req);
		repository.save(c);
		return ResponseEntity.status(201).body(CommercialResponse.from(c));
	}

	/** PUT /api/v1/commerciaux/{id} */
	@PutMapping("/commerciaux/{commercialId}")
	public CommercialResponse update(
			@PathVariable Long commercialId, @Valid @RequestBody CommercialRequest req) {
		Commercial c = getOrThrow(commercialId);
		applyRequest(c, req);
		repository.save(c);
		return CommercialResponse.from(c);
	}

	/** DELETE /api/v1/commerciaux/{id} */
	@DeleteMapping("/commerciaux/{commercialId}")
	public ResponseEntity<Void> delete(@PathVariable Long commercialId) {
		repository.delete(getOrThrow(commercialId));
		return ResponseEntity.noContent().build();
	}

	// ──────────────────────────────────────────────
	// AFFECTATIONS (SiteCommercial)
	// ──────────────────────────────────────────────

	/** GET /api/v1/commerciaux/{id}/sites */
	@GetMapping("/commerciaux/{commercialId}/sites")
	@Transactional(readOnly = true)
	public List<SiteCommercialResponse> listSites(@PathVariable Long commercialId) {
		getOrThrow(commercialId);
		return siteCommercialRepository.findByCommercialId(commercialId).stream()
				.map(SiteCommercialResponse::from).toList();
	}

	/** POST /api/v1/commerciaux/{id}/sites */
	@PostMapping("/commerciaux/{commercialId}/sites")
	public ResponseEntity<SiteCommercialResponse> createSite(
			@PathVariable Long commercialId, @RequestBody SiteCommercialRequest req) {

		getOrThrow(commercialId);
		SiteCommercial sc = new SiteCommercial();
		sc.setCommercialId(commercialId);
		sc.setSiteId(req.siteId());
		sc.setDateDebut(req.dateDebut() == null ? LocalDate.now() : req.dateDebut());
		sc.setDateFin(req.dateFin());
		sc.setPrincipal(Boolean.TRUE.equals(req.isPrincipal()));
		siteCommercialRepository.save(sc);
		return ResponseEntity.status(201).body(SiteCommercialResponse.from(sc));
	}

	/** DELETE /api/v1/commerciaux/{id}/sites/{siteId} */
	@DeleteMapping("/commerciaux/{commercialId}/sites/{siteId}")
	public ResponseEntity<Void> deleteSite(
			@PathVariable Long commercialId, @PathVariable Long siteId) {

		SiteCommercial sc = siteCommercialRepository
				.findBySiteIdAndCommercialId(siteId, commercialId)
				.orElseThrow(() -> new NotFoundException(
						"Affectation introuvable pour commercial=" + commercialId
								+ ", site=" + siteId));
		siteCommercialRepository.delete(sc);
		return ResponseEntity.noContent().build();
	}

	/** GET /api/v1/sites/{siteId}/commerciaux */
	@GetMapping("/sites/{siteId}/commerciaux")
	@Transactional(readOnly = true)
	public PageResponse<SiteCommercialResponse> listBySite(
			@PathVariable Long siteId,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int pageSize) {

		Page<SiteCommercial> result = siteCommercialRepository.findBySiteId(
				siteId, PageRequest.of(page, pageSize));
		return PageResponse.of(result.map(SiteCommercialResponse::from));
	}

	// ──────────────────────────────────────────────
	// Helpers
	// ──────────────────────────────────────────────

	private Commercial getOrThrow(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Commercial " + id + " introuvable"));
	}

	private void applyRequest(Commercial c, CommercialRequest req) {
		c.setNom(req.nom());
		c.setPrenoms(req.prenoms());
		c.setTelephone(req.telephone());
		c.setEmail(req.email());
		if (req.matricule() != null && !req.matricule().isBlank()) c.setMatricule(req.matricule());
		if (req.statut() != null && !req.statut().isBlank()) c.setStatut(req.statut());
		c.setSuperviseurId(req.superviseurId());
	}
}
