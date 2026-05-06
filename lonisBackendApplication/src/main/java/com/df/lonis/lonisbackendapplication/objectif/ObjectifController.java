package com.df.lonis.lonisbackendapplication.objectif;

import com.df.lonis.lonisbackendapplication.common.NotFoundException;
import com.df.lonis.lonisbackendapplication.common.PageResponse;
import com.df.lonis.lonisbackendapplication.common.SortParser;
import com.df.lonis.lonisbackendapplication.objectif.ObjectifDtos.ObjectifResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Transactional
public class ObjectifController {

	private final ObjectifRepository repository;

	public ObjectifController(ObjectifRepository repository) {
		this.repository = repository;
	}

	/** GET /api/v1/objectifs */
	@GetMapping("/objectifs")
	@Transactional(readOnly = true)
	public PageResponse<ObjectifResponse> list(
			@RequestParam(required = false) Long commercialId,
			@RequestParam(required = false) Integer annee,
			@RequestParam(required = false) Integer mois,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int pageSize,
			@RequestParam(defaultValue = "annee,desc") String sort) {

		Page<Objectif> result = repository.search(
				commercialId, annee, mois,
				PageRequest.of(page, pageSize, SortParser.parse(sort)));
		return PageResponse.of(result.map(ObjectifResponse::from));
	}

	/** POST /api/v1/objectifs */
	@PostMapping("/objectifs")
	public ResponseEntity<ObjectifResponse> create(@RequestBody Objectif body) {
		body.setId(null);
		repository.save(body);
		return ResponseEntity.status(201).body(ObjectifResponse.from(body));
	}

	/** PUT /api/v1/objectifs/{id} */
	@PutMapping("/objectifs/{objectifId}")
	public ObjectifResponse update(@PathVariable Long objectifId, @RequestBody Objectif body) {
		Objectif o = getOrThrow(objectifId);
		if (body.getCommercialId() != null) o.setCommercialId(body.getCommercialId());
		if (body.getType() != null) o.setType(body.getType());
		if (body.getPeriode() != null) o.setPeriode(body.getPeriode());
		o.setValeurCible(body.getValeurCible());
		o.setValeurReelle(body.getValeurReelle());
		o.setMois(body.getMois());
		o.setTrimestre(body.getTrimestre());
		o.setAnnee(body.getAnnee());
		repository.save(o);
		return ObjectifResponse.from(o);
	}

	/** GET /api/v1/commerciaux/{id}/objectifs */
	@GetMapping("/commerciaux/{commercialId}/objectifs")
	@Transactional(readOnly = true)
	public List<ObjectifResponse> listByCommercial(@PathVariable Long commercialId) {
		return repository.findByCommercialId(commercialId).stream()
				.map(ObjectifResponse::from).toList();
	}

	private Objectif getOrThrow(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Objectif " + id + " introuvable"));
	}
}
