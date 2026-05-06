package com.df.lonis.lonisbackendapplication.terminal;

import jakarta.validation.constraints.NotNull;

/**
 * Vues DTO « réseau » du Terminal — alignées sur le contrat OpenAPI {@code lonisReseauRest}.
 */
public final class TerminalReseauDtos {

	private TerminalReseauDtos() {}

	/** Schéma {@code Terminal} (réseau). */
	public record TerminalReseauResponse(
			Long id,
			String codeTerminal,
			Long concessionnaireId,
			Long siteId,
			Double latitude,
			Double longitude,
			String adresse,
			String statutValidation
	) {
		public static TerminalReseauResponse from(Terminal t) {
			return new TerminalReseauResponse(
					t.getId(), t.getCodeTerminal(), t.getConcessionnaireId(),
					t.getSiteId(), t.getLatitude(), t.getLongitude(),
					t.getAdresse(), t.getStatutValidation()
			);
		}
	}

	/** Schéma {@code TerminalRequestBody} (POST). */
	public record TerminalCreateRequest(
			@NotNull Long concessionnaireId,
			@NotNull Long siteId,
			Double latitude,
			Double longitude,
			String adresse
	) {}

	/** Schéma {@code TerminalPutRequestBody} (PUT). */
	public record TerminalUpdateRequest(
			Long concessionnaireId,
			Long siteId,
			Double latitude,
			Double longitude,
			String adresse
	) {}

	/** Body JSON {@code {"motif":"..."}} pour le rejet. */
	public record TerminalRejetRequest(String motif) {}
}
