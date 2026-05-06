package com.df.lonis.lonisbackendapplication.visite;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface VisiteRepository extends JpaRepository<Visite, Long> {

	List<Visite> findByCommercialId(Long commercialId);

	List<Visite> findByTerminalId(Long terminalId);

	/**
	 * Recherche multi-critères. Tous les paramètres sont nullable et utilisent
	 * du SQL natif avec {@code CAST(? AS …)} pour éviter le bug Postgres 42P18
	 * sur la déduction de type quand le paramètre est null.
	 */
	@Query(
			value = """
					SELECT * FROM visites
					WHERE (CAST(:commercialId AS bigint)  IS NULL OR commercial_id = :commercialId)
					  AND (CAST(:terminalId   AS bigint)  IS NULL OR terminal_id   = :terminalId)
					  AND (CAST(:statut       AS varchar) IS NULL OR statut        = :statut)
					  AND (CAST(:dateDebut    AS timestamp) IS NULL OR date_visite >= :dateDebut)
					  AND (CAST(:dateFin      AS timestamp) IS NULL OR date_visite <= :dateFin)
					""",
			countQuery = """
					SELECT count(*) FROM visites
					WHERE (CAST(:commercialId AS bigint)  IS NULL OR commercial_id = :commercialId)
					  AND (CAST(:terminalId   AS bigint)  IS NULL OR terminal_id   = :terminalId)
					  AND (CAST(:statut       AS varchar) IS NULL OR statut        = :statut)
					  AND (CAST(:dateDebut    AS timestamp) IS NULL OR date_visite >= :dateDebut)
					  AND (CAST(:dateFin      AS timestamp) IS NULL OR date_visite <= :dateFin)
					""",
			nativeQuery = true)
	Page<Visite> search(
			@Param("commercialId") Long commercialId,
			@Param("terminalId") Long terminalId,
			@Param("statut") String statut,
			@Param("dateDebut") Instant dateDebut,
			@Param("dateFin") Instant dateFin,
			Pageable pageable);

	long countByCommercialIdAndStatut(Long commercialId, String statut);
}
