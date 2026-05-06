package com.df.lonis.lonisbackendapplication.produit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	Optional<Produit> findByCode(String code);

	Page<Produit> findByLibelleContainingIgnoreCaseOrCodeContainingIgnoreCase(
			String libelle, String code, Pageable pageable);
}
