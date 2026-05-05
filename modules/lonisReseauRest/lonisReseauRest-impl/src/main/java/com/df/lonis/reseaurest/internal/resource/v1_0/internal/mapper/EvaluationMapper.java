package com.df.lonis.reseaurest.internal.resource.v1_0.internal.mapper;

import com.df.lonis.reseaurest.dto.v1_0.Evaluation;

import com.df.lonis.ventesservice.service.CommercialLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author HP
 */
@Component(service = EvaluationMapper.class)
public class EvaluationMapper {

	public Evaluation toDto(
		com.df.lonis.ventesservice.model.Evaluation entry) {

		if (entry == null) {
			return null;
		}

		Evaluation dto = new Evaluation();
		dto.setId(entry.getId());
		dto.setCommercialId(entry.getCommercialId());
		dto.setNbVisitesPrevues(entry.getNbVisitesPrevues());
		dto.setNbVisitesEffectuees(entry.getNbVisitesEffectuees());
		dto.setTauxRealisation(entry.getTauxRealisation());
		dto.setRang(entry.getRang());
		dto.setMois(entry.getMois());
		dto.setTrimestre(entry.getTrimestre());
		dto.setAnnee(entry.getAnnee());
		dto.setCreatedAt(entry.getCreatedAt());

		if (entry.getPeriode() != null) {
			dto.setPeriode(Evaluation.Periode.create(entry.getPeriode()));
		}

		// Enrichir avec nom + prenoms du commercial
		com.df.lonis.ventesservice.model.Commercial c =
			_commercialLocalService.fetchCommercial(entry.getCommercialId());

		if (c != null) {
			dto.setNom(c.getNom());
			dto.setPrenoms(c.getPrenoms());
		}

		return dto;
	}

	@Reference
	private CommercialLocalService _commercialLocalService;

}
