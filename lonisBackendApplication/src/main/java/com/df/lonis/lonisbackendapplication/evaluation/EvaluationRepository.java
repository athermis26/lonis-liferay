package com.df.lonis.lonisbackendapplication.evaluation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

	List<Evaluation> findByCommercialIdAndAnneeOrderByAnneeDesc(Long commercialId, int annee);

	List<Evaluation> findByCommercialIdOrderByAnneeDescMoisDesc(Long commercialId);

	/**
	 * Classement annuel — annee est obligatoire. Les autres params nullable utilisent
	 * du SQL natif avec {@code CAST(? AS …)} pour éviter Postgres 42P18.
	 */
	@Query(
			value = """
					SELECT * FROM evaluations
					WHERE annee = :annee
					  AND (CAST(:periode AS varchar) IS NULL OR periode = :periode)
					  AND (CAST(:mois    AS integer) IS NULL OR mois    = :mois)
					  AND (CAST(:trimestre AS integer) IS NULL OR trimestre = :trimestre)
					ORDER BY taux_realisation DESC
					""",
			countQuery = """
					SELECT count(*) FROM evaluations
					WHERE annee = :annee
					  AND (CAST(:periode AS varchar) IS NULL OR periode = :periode)
					  AND (CAST(:mois    AS integer) IS NULL OR mois    = :mois)
					  AND (CAST(:trimestre AS integer) IS NULL OR trimestre = :trimestre)
					""",
			nativeQuery = true)
	Page<Evaluation> classement(
			@Param("annee") int annee,
			@Param("periode") String periode,
			@Param("mois") Integer mois,
			@Param("trimestre") Integer trimestre,
			Pageable pageable);
}
