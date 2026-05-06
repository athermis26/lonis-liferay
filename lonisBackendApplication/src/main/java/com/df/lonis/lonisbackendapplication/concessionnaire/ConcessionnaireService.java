package com.df.lonis.lonisbackendapplication.concessionnaire;

import com.df.lonis.lonisbackendapplication.common.NotFoundException;
import com.df.lonis.lonisbackendapplication.concessionnaire.ConcessionnaireDtos.ConcessionnaireRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class ConcessionnaireService {

	private final ConcessionnaireRepository repository;

	public ConcessionnaireService(ConcessionnaireRepository repository) {
		this.repository = repository;
	}

	@Transactional(readOnly = true)
	public Page<Concessionnaire> search(String search, Pageable pageable) {
		if (!StringUtils.hasText(search)) {
			return repository.findAll(pageable);
		}
		return repository
				.findByNomContainingIgnoreCaseOrPrenomsContainingIgnoreCaseOrEmailContainingIgnoreCase(
						search, search, search, pageable);
	}

	@Transactional(readOnly = true)
	public Concessionnaire getById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Concessionnaire " + id + " introuvable"));
	}

	public Concessionnaire create(ConcessionnaireRequest request) {
		Concessionnaire entity = new Concessionnaire();
		entity.setUid(request.uid());
		entity.setNom(request.nom());
		// Le contrat client expose à la fois "prenom" (singular) et "prenoms" — on accepte les deux.
		entity.setPrenoms(StringUtils.hasText(request.prenoms()) ? request.prenoms() : request.prenom());
		entity.setTelephone(request.telephone());
		entity.setEmail(request.email());
		return repository.save(entity);
	}
}
