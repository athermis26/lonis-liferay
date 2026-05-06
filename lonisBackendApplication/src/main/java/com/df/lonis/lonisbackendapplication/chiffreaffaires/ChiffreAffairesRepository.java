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

	/**
	 * Recherche dans une période. Les paramètres dateDebut/dateFin peuvent être null
	 * (pas de borne). On utilise du SQL natif avec {@code CAST(? AS timestamp)} pour
	 * éviter le bug PostgreSQL 42P18 ("could not determine data type of parameter").
	 */
	@Query(
			value = """
					SELECT * FROM chiffre_affaires
					WHERE (CAST(:dateDebut AS timestamp) IS NULL OR date >= :dateDebut)
					  AND (CAST(:dateFin   AS timestamp) IS NULL OR date <= :dateFin)
					""",
			countQuery = """
					SELECT count(*) FROM chiffre_affaires
					WHERE (CAST(:dateDebut AS timestamp) IS NULL OR date >= :dateDebut)
					  AND (CAST(:dateFin   AS timestamp) IS NULL OR date <= :dateFin)
					""",
			nativeQuery = true)
	Page<ChiffreAffaires> findInPeriod(
			@Param("dateDebut") Instant dateDebut,
			@Param("dateFin") Instant dateFin,
			Pageable pageable);

	@Query(
			value = """
					SELECT COALESCE(SUM(ventes), 0) FROM chiffre_affaires
					WHERE (CAST(:dateDebut AS timestamp) IS NULL OR date >= :dateDebut)
					  AND (CAST(:dateFin   AS timestamp) IS NULL OR date <= :dateFin)
					""",
			nativeQuery = true)
	Long sumVentes(@Param("dateDebut") Instant dateDebut, @Param("dateFin") Instant dateFin);

	@Query(
			value = """
					SELECT COALESCE(SUM(paiement), 0) FROM chiffre_affaires
					WHERE (CAST(:dateDebut AS timestamp) IS NULL OR date >= :dateDebut)
					  AND (CAST(:dateFin   AS timestamp) IS NULL OR date <= :dateFin)
					""",
			nativeQuery = true)
	Long sumPaiements(@Param("dateDebut") Instant dateDebut, @Param("dateFin") Instant dateFin);

	/**
	 * Agrégation par terminal — retourne 3 colonnes (terminalId, chiffreAffaires, soldeTotal)
	 * mappées dans le service via {@link TerminalAggregate}.
	 */
    @Query(
            value = """
        SELECT terminal_id,
               COALESCE(SUM(ventes), 0)  AS chiffre_affaires,
               COALESCE(SUM(balance), 0) AS solde_total
        FROM chiffre_affaires
        WHERE terminal_id IS NOT NULL
          AND (CAST(:dateDebut AS timestamp) IS NULL OR date >= :dateDebut)
          AND (CAST(:dateFin   AS timestamp) IS NULL OR date <= :dateFin)
        GROUP BY terminal_id
        ORDER BY SUM(ventes) DESC
        """,
            nativeQuery = true)
    List<Object[]> aggregateByTerminalRaw(
            @Param("dateDebut") Instant dateDebut,
            @Param("dateFin") Instant dateFin);

	/** Wrapper qui mappe le résultat natif vers {@link TerminalAggregate}. */
	default List<TerminalAggregate> aggregateByTerminal(Instant dateDebut, Instant dateFin) {
		return aggregateByTerminalRaw(dateDebut, dateFin).stream()
				.map(row -> new TerminalAggregate(
						((Number) row[0]).longValue(),
						((Number) row[1]).longValue(),
						((Number) row[2]).longValue()))
				.toList();
	}
}
