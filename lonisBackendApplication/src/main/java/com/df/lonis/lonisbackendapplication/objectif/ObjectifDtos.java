package com.df.lonis.lonisbackendapplication.objectif;

public final class ObjectifDtos {

	private ObjectifDtos() {}

	/** Schéma {@code Objectif} (utilisé en lecture, création et mise à jour). */
	public record ObjectifResponse(
			Long id,
			Long commercialId,
			String type,
			String periode,
			Integer valeurCible,
			Integer valeurReelle,
			Integer mois,
			Integer trimestre,
			Integer annee
	) {
		public static ObjectifResponse from(Objectif o) {
			return new ObjectifResponse(
					o.getId(), o.getCommercialId(), o.getType(), o.getPeriode(),
					o.getValeurCible(), o.getValeurReelle(),
					o.getMois(), o.getTrimestre(), o.getAnnee()
			);
		}
	}
}
