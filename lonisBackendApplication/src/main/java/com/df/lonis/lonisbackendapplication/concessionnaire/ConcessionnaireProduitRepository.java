package com.df.lonis.lonisbackendapplication.concessionnaire;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConcessionnaireProduitRepository extends JpaRepository<ConcessionnaireProduit, Long> {

	List<ConcessionnaireProduit> findByConcessionnaireId(Long concessionnaireId);

	List<ConcessionnaireProduit> findByProduitId(Long produitId);

	Optional<ConcessionnaireProduit> findByCode(String code);
}
