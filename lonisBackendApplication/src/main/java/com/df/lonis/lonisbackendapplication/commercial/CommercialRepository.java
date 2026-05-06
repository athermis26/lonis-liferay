package com.df.lonis.lonisbackendapplication.commercial;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommercialRepository extends JpaRepository<Commercial, Long> {

	Optional<Commercial> findByMatricule(String matricule);

	Page<Commercial> findBySuperviseurId(Long superviseurId, Pageable pageable);

	Page<Commercial> findByNomContainingIgnoreCaseOrPrenomsContainingIgnoreCaseOrMatriculeContainingIgnoreCase(
			String nom, String prenoms, String matricule, Pageable pageable);
}
