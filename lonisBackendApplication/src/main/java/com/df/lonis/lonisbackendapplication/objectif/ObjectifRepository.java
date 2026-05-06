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

	/**
	 * SQL natif avec {@code CAST(? AS …)} pour éviter Postgres 42P18 quand un
	 * paramètre est null.
	 */
	@Query(
			value = """
					SELECT * FROM objectifs
					WHERE (CAST(:commercialId AS bigint)  IS NULL OR commercial_id = :commercialId)
					  AND (CAST(:annee        AS integer) IS NULL OR annee = :annee)
					  AND (CAST(:mois         AS integer) IS NULL OR mois  = :mois)
					""",
			countQuery = """
					SELECT count(*) FROM objectifs
					WHERE (CAST(:commercialId AS bigint)  IS NULL OR commercial_id = :commercialId)
					  AND (CAST(:annee        AS integer) IS NULL OR annee = :annee)
					  AND (CAST(:mois         AS integer) IS NULL OR mois  = :mois)
					""",
			nativeQuery = true)
	Page<Objectif> search(
			@Param("commercialId") Long commercialId,
			@Param("annee") Integer annee,
			@Param("mois") Integer mois,
			Pageable pageable);
}
