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

	@Query("""
			SELECT v FROM Visite v
			WHERE (:commercialId IS NULL OR v.commercialId = :commercialId)
			  AND (:terminalId   IS NULL OR v.terminalId   = :terminalId)
			  AND (:statut       IS NULL OR v.statut       = :statut)
			  AND (:dateDebut    IS NULL OR v.dateVisite   >= :dateDebut)
			  AND (:dateFin      IS NULL OR v.dateVisite   <= :dateFin)
			""")
	Page<Visite> search(
			@Param("commercialId") Long commercialId,
			@Param("terminalId") Long terminalId,
			@Param("statut") String statut,
			@Param("dateDebut") Instant dateDebut,
			@Param("dateFin") Instant dateFin,
			Pageable pageable);

	long countByCommercialIdAndStatut(Long commercialId, String statut);
}
