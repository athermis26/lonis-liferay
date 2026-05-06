package com.df.lonis.lonisbackendapplication.produit;

import com.df.lonis.lonisbackendapplication.produit.ProduitDtos.ProduitResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProduitController {

	private final ProduitRepository repository;

	public ProduitController(ProduitRepository repository) {
		this.repository = repository;
	}

	/** GET /api/v1/produits — liste non paginée (correspond au contrat client). */
	@GetMapping("/produits")
	public List<ProduitResponse> list() {
		return repository.findAll().stream().map(ProduitResponse::from).toList();
	}
}
