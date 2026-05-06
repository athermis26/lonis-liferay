package com.df.lonis.lonisbackendapplication.terminal;

import com.df.lonis.lonisbackendapplication.produit.ProduitDtos.ProduitResponse;
import com.df.lonis.lonisbackendapplication.site.SiteDtos.SiteResponse;

import java.time.Instant;
import java.util.List;

public final class TerminalDtos {

	private TerminalDtos() {}

	/** Schéma {@code Terminal} (vente) — enrichi avec libellés joints. */
	public record TerminalResponse(
			Long id,
			String codeTerminal,
			Long concessionnaireId,
			String concessionnaireNomPrenom,
			String produitType,
			String siteLibelle,
			String concessionnaireCode,
			Long produitId,
			String concessionnaireProduitCode,
			Long siteId,
			ProduitResponse produit,
			SiteResponse site,
			Long solde,
			Instant createdAt,
			Instant updatedAt
	) {}

	/** Schéma {@code TerminalDetail}. */
	public record TerminalDetailResponse(
			Long id,
			String codeTerminal,
			String concessionnaireProduitCode,
			Long siteId,
			Long solde,
			Long chiffreAffaires,
			Long totalOperations,
			Long totalPaiements
	) {}

	/** Schéma {@code TerminalActivite} (top-actifs). */
	public record TerminalActiviteResponse(
			Long terminalId,
			String codeTerminal,
			String concessionnaireProduitCode,
			Long concessionnaireId,
			String concessionnaireNomPrenom,
			String produitCode,
			String produitLibelle,
			String siteLibelle,
			Long solde,
			Long nombreOperations,
			Long nombreRechargements,
			Long chiffreAffaires
	) {}

	/** Schéma {@code TerminauxConcessionnaire}. */
	public record TerminauxConcessionnaireResponse(
			Long soldeTotal,
			Long totalOperations,
			Long totalPaiements,
			Long chiffreAffaires,
			List<TerminalDetailResponse> terminalDetails
	) {}
}
