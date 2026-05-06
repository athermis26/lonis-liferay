package com.df.lonis.lonisbackendapplication.commercial;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public final class CommercialDtos {

	private CommercialDtos() {}

	/** Schéma {@code Commercial}. */
	public record CommercialResponse(
			Long id,
			String nom,
			String prenoms,
			String telephone,
			String email,
			String matricule,
			String statut,
			Long superviseurId,
			Long agenceId
	) {
		public static CommercialResponse from(Commercial c) {
			return new CommercialResponse(
					c.getId(), c.getNom(), c.getPrenoms(), c.getTelephone(),
					c.getEmail(), c.getMatricule(), c.getStatut(),
					c.getSuperviseurId(), c.getAgenceId()
			);
		}
	}

	/** Schéma {@code CommercialRequestBody}. */
	public record CommercialRequest(
			@NotBlank String nom,
			String prenoms,
			String telephone,
			String email,
			String matricule,
			String statut,
			Long superviseurId
	) {}

	/** Schéma {@code SiteCommercial}. */
	public record SiteCommercialResponse(
			Long id,
			Long siteId,
			Long commercialId,
			LocalDate dateDebut,
			LocalDate dateFin,
			Boolean isPrincipal
	) {
		public static SiteCommercialResponse from(SiteCommercial sc) {
			return new SiteCommercialResponse(
					sc.getId(), sc.getSiteId(), sc.getCommercialId(),
					sc.getDateDebut(), sc.getDateFin(), sc.isPrincipal()
			);
		}
	}

	/** Body POST {@code /commerciaux/{id}/sites}. */
	public record SiteCommercialRequest(
			Long siteId,
			Long commercialId,
			LocalDate dateDebut,
			LocalDate dateFin,
			Boolean isPrincipal
	) {}
}
