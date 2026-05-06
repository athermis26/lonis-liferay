package com.df.lonis.lonisbackendapplication.evaluation;

import com.df.lonis.lonisbackendapplication.commercial.Commercial;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public final class EvaluationDtos {

	private EvaluationDtos() {}

	/** Schéma {@code Evaluation}. */
	public record EvaluationResponse(
			Long id,
			Long commercialId,
			String nom,
			String prenoms,
			Integer nbVisitesPrevues,
			Integer nbVisitesEffectuees,
			Double tauxRealisation,
			Integer rang,
			String periode,
			Integer mois,
			Integer trimestre,
			Integer annee,
			Instant createdAt
	) {
		public static EvaluationResponse from(Evaluation e, Commercial c) {
			return new EvaluationResponse(
					e.getId(), e.getCommercialId(),
					c == null ? null : c.getNom(),
					c == null ? null : c.getPrenoms(),
					e.getNbVisitesPrevues(), e.getNbVisitesEffectuees(),
					e.getTauxRealisation(), e.getRang(),
					e.getPeriode(), e.getMois(), e.getTrimestre(), e.getAnnee(),
					e.getCreatedAt()
			);
		}
	}

	/** Body POST {@code /evaluations/generer}. */
	public record GenererRequest(
			@NotNull Integer annee,
			Integer mois,
			Integer trimestre,
			@NotNull String periode
	) {}

	/** Réponse POST {@code /evaluations/generer}. */
	public record GenererResponse(String message, Integer nbEvaluationsGenerees) {}
}
