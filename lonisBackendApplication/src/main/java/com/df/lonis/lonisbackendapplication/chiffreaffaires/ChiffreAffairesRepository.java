package com.df.lonis.lonisbackendapplication.chiffreaffaires;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ChiffreAffairesRepository extends JpaRepository<ChiffreAffaires, Long> {

	List<ChiffreAffaires> findByTerminalId(Long terminalId);

	List<ChiffreAffaires> findByTerminalIdIn(java.util.Collection<Long> terminalIds);

	List<ChiffreAffaires> findByTerminalIdAndDateGreaterThanEqual(Long terminalId, Instant date);

	@Query("""
			SELECT ca FROM ChiffreAffaires ca
			WHERE (:dateDebut IS NULL OR ca.date >= :dateDebut)
			  AND (:dateFin IS NULL OR ca.date <= :dateFin)
			""")
	Page<ChiffreAffaires> findInPeriod(
			@Param("dateDebut") Instant dateDebut,
			@Param("dateFin") Instant dateFin,
			Pageable pageable);

	@Query("""
			SELECT COALESCE(SUM(ca.ventes), 0) FROM ChiffreAffaires ca
			WHERE (:dateDebut IS NULL OR ca.date >= :dateDebut)
			  AND (:dateFin IS NULL OR ca.date <= :dateFin)
			""")
	Long sumVentes(@Param("dateDebut") Instant dateDebut, @Param("dateFin") Instant dateFin);

	@Query("""
			SELECT COALESCE(SUM(ca.paiement), 0) FROM ChiffreAffaires ca
			WHERE (:dateDebut IS NULL OR ca.date >= :dateDebut)
			  AND (:dateFin IS NULL OR ca.date <= :dateFin)
			""")
	Long sumPaiements(@Param("dateDebut") Instant dateDebut, @Param("dateFin") Instant dateFin);

	@Query("""
			SELECT new com.df.lonis.lonisbackendapplication.chiffreaffaires.TerminalAggregate(
			  ca.terminalId,
			  COALESCE(SUM(ca.ventes), 0),
			  COALESCE(SUM(ca.balance), 0))
			FROM ChiffreAffaires ca
			WHERE (:dateDebut IS NULL OR ca.date >= :dateDebut)
			  AND (:dateFin IS NULL OR ca.date <= :dateFin)
			GROUP BY ca.terminalId
			ORDER BY SUM(ca.ventes) DESC
			""")
	List<TerminalAggregate> aggregateByTerminal(
			@Param("dateDebut") Instant dateDebut,
			@Param("dateFin") Instant dateFin);
}
