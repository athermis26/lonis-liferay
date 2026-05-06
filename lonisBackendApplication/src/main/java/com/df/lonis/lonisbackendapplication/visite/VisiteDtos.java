package com.df.lonis.lonisbackendapplication.visite;

import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public final class VisiteDtos {

	private VisiteDtos() {}

	/** Schéma {@code Visite}. */
	public record VisiteResponse(
			Long id,
			Long commercialId,
			Long terminalId,
			Double latitude,
			Double longitude,
			String statut,
			String typeControle,
			Instant dateVisite,
			String compteRendu
	) {
		public static VisiteResponse from(Visite v) {
			return new VisiteResponse(
					v.getId(), v.getCommercialId(), v.getTerminalId(),
					v.getLatitude(), v.getLongitude(),
					v.getStatut(), v.getTypeControle(),
					v.getDateVisite(), v.getCompteRendu()
			);
		}
	}

	/** Schéma {@code VisiteRequestBody}. */
	public record VisiteRequest(
			@NotNull Long commercialId,
			@NotNull Long terminalId,
			Double latitude,
			Double longitude,
			String statut,
			String typeControle,
			Instant dateVisite,
			String compteRendu
	) {}
}
