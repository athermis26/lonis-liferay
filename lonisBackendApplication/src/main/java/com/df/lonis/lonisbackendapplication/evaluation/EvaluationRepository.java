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

	@Query("""
			SELECT e FROM Evaluation e
			WHERE e.annee = :annee
			  AND (:periode IS NULL OR e.periode = :periode)
			  AND (:mois IS NULL OR e.mois = :mois)
			  AND (:trimestre IS NULL OR e.trimestre = :trimestre)
			ORDER BY e.tauxRealisation DESC
			""")
	Page<Evaluation> classement(
			@Param("annee") int annee,
			@Param("periode") String periode,
			@Param("mois") Integer mois,
			@Param("trimestre") Integer trimestre,
			Pageable pageable);
}
