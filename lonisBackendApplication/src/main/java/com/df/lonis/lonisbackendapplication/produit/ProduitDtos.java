package com.df.lonis.lonisbackendapplication.produit;

import java.time.Instant;

public final class ProduitDtos {

	private ProduitDtos() {}

	/** Schéma {@code Produit}. */
	public record ProduitResponse(
			Long id,
			String code,
			String libelle,
			String abreviation,
			Boolean active,
			Instant createdAt,
			Instant updatedAt
	) {
		public static ProduitResponse from(Produit p) {
			return new ProduitResponse(
					p.getId(), p.getCode(), p.getLibelle(), p.getAbreviation(),
					p.isActive(), p.getCreatedAt(), p.getUpdatedAt()
			);
		}
	}
}
