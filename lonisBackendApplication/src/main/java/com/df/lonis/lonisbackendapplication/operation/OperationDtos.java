package com.df.lonis.lonisbackendapplication.operation;

import java.time.Instant;

public final class OperationDtos {

	private OperationDtos() {}

	/** Représentation paginée (correspond au schéma {@code Operation}). */
	public record OperationResponse(
			Long id,
			String code,
			String reference,
			Long montant,
			Long montantReel,
			String statut,
			Long terminalId,
			String codeTerminal,
			String guichet,
			Instant dateOperation,
			String libelle
	) {
		public static OperationResponse from(Operation o, String codeTerminal) {
			return new OperationResponse(
					o.getId(), o.getCode(), o.getReference(),
					o.getMontant(), o.getMontantReel(), o.getStatut(),
					o.getTerminalId(), codeTerminal, o.getGuichet(),
					o.getDateOperation(), o.getLibelle()
			);
		}
	}

	/** Détail (correspond au schéma {@code OperationDetail}). */
	public record OperationDetailResponse(
			Long id,
			String codeOperation,
			String codeTerminal,
			String reference,
			Instant dateHeure,
			String libelle,
			Long montant,
			Long montantReel,
			String statut,
			String guichet
	) {
		public static OperationDetailResponse from(Operation o, String codeTerminal) {
			return new OperationDetailResponse(
					o.getId(), o.getCode(), codeTerminal, o.getReference(),
					o.getDateOperation(), o.getLibelle(),
					o.getMontant(), o.getMontantReel(), o.getStatut(), o.getGuichet()
			);
		}
	}
}
