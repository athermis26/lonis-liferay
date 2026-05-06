package com.df.lonis.lonisbackendapplication.concessionnaire;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConcessionnaireRepository extends JpaRepository<Concessionnaire, Long> {

	Optional<Concessionnaire> findByUid(String uid);

	Page<Concessionnaire> findByNomContainingIgnoreCaseOrPrenomsContainingIgnoreCaseOrEmailContainingIgnoreCase(
			String nom, String prenoms, String email, Pageable pageable);
}
