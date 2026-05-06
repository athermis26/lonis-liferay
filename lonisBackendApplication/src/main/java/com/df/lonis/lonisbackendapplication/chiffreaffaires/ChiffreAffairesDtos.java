package com.df.lonis.lonisbackendapplication.chiffreaffaires;

import java.time.Instant;

public final class ChiffreAffairesDtos {

	private ChiffreAffairesDtos() {}

	/** Ligne enrichie pour la liste paginée (correspond au schéma {@code ChiffreAffaire}). */
	public record ChiffreAffaireResponse(
			Long id,
			String codeTerminal,
			String concessionnaireNomPrenom,
			String codeProduit,
			String produitType,
			String site,
			Long brut,
			Long paiement,
			Long annulation,
			Long rembourcement,
			Long ventes,
			Long balance,
			Long deposite,
			Long chiffreAffaire,
			Instant date,
			Instant createdAt,
			Instant updatedAt
	) {}
}
