package com.df.lonis.lonisbackendapplication.concessionnaire;

import com.df.lonis.lonisbackendapplication.terminal.TerminalDtos.TerminalResponse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.List;

public final class ConcessionnaireDtos {

	private ConcessionnaireDtos() {}

	/** Schéma {@code Concessionnaire} (liste). */
	public record ConcessionnaireResponse(
			Long id,
			String uid,
			String nom,
			String prenoms,
			String telephone,
			String email
	) {
		public static ConcessionnaireResponse from(Concessionnaire c) {
			return new ConcessionnaireResponse(
					c.getId(), c.getUid(), c.getNom(), c.getPrenoms(),
					c.getTelephone(), c.getEmail()
			);
		}
	}

	/** Schéma {@code ConcessionnaireBody} (POST /concessionnaire). */
	public record ConcessionnaireRequest(
			String uid,
			@NotBlank String nom,
			String prenom,
			String prenoms,
			String telephone,
			@Email String email
	) {}

	/** Schéma {@code ConcessionnaireProduit}. */
	public record ConcessionnaireProduitResponse(
			Long id,
			Long concessionnaireId,
			Long produitId,
			Long siteId,
			String code,
			String concessionnaireCode,
			Boolean active,
			Instant createdAt,
			Instant updatedAt
	) {
		public static ConcessionnaireProduitResponse from(ConcessionnaireProduit cp) {
			return new ConcessionnaireProduitResponse(
					cp.getId(), cp.getConcessionnaireId(), cp.getProduitId(),
					cp.getSiteId(), cp.getCode(), cp.getConcessionnaireCode(),
					cp.isActive(), cp.getCreatedAt(), cp.getUpdatedAt()
			);
		}
	}

	/** Schéma {@code ConcessionnaireStats}. */
	public record ConcessionnaireStatsResponse(
			Integer totalProduits,
			Integer totalTerminaux,
			Long totalOperations,
			Long totalPaiements,
			Long chiffreAffaires
	) {}

	/** Schéma {@code ConcessionnaireDetail} (vue 360°). */
	public record ConcessionnaireDetailResponse(
			Long id,
			String uid,
			String nom,
			String prenoms,
			String telephone,
			String email,
			ConcessionnaireStatsResponse stats,
			List<ConcessionnaireProduitResponse> concessionnaireProduits,
			List<TerminalResponse> concessionnaireTerminals,
			Long soldeTotal
	) {}

	/** Schéma {@code ConcessionnaireActivite} (top-actifs). */
	public record ConcessionnaireActiviteResponse(
			Long concessionnaireId,
			String uid,
			String nom,
			String prenoms,
			String telephone,
			Integer nombreTerminaux,
			Long nombreOperations,
			Long chiffreAffaires,
			Long soldeTotal,
			List<String> concessionnaireCodes
	) {}
}
