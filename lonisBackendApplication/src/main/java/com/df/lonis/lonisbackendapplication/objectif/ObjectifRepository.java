package com.df.lonis.lonisbackendapplication.objectif;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectifRepository extends JpaRepository<Objectif, Long> {

	List<Objectif> findByCommercialId(Long commercialId);

	@Query("""
			SELECT o FROM Objectif o
			WHERE (:commercialId IS NULL OR o.commercialId = :commercialId)
			  AND (:annee IS NULL OR o.annee = :annee)
			  AND (:mois  IS NULL OR o.mois  = :mois)
			""")
	Page<Objectif> search(
			@Param("commercialId") Long commercialId,
			@Param("annee") Integer annee,
			@Param("mois") Integer mois,
			Pageable pageable);
}
