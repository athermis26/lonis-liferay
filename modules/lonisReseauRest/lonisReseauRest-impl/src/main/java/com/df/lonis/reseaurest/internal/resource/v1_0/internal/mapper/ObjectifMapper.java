package com.df.lonis.reseaurest.internal.resource.v1_0.internal.mapper;

import com.df.lonis.reseaurest.dto.v1_0.Objectif;

import org.osgi.service.component.annotations.Component;

/**
 * @author HP
 */
@Component(service = ObjectifMapper.class)
public class ObjectifMapper {

	public Objectif toDto(com.df.lonis.ventesservice.model.Objectif entry) {
		if (entry == null) {
			return null;
		}

		Objectif dto = new Objectif();
		dto.setId(entry.getId());
		dto.setCommercialId(entry.getCommercialId());
		dto.setValeurCible(entry.getValeurCible());
		dto.setValeurReelle(entry.getValeurReelle());
		dto.setMois(entry.getMois());
		dto.setTrimestre(entry.getTrimestre());
		dto.setAnnee(entry.getAnnee());

		if (entry.getType() != null) {
			dto.setType(Objectif.Type.create(entry.getType()));
		}
		if (entry.getPeriode() != null) {
			dto.setPeriode(Objectif.Periode.create(entry.getPeriode()));
		}
		return dto;
	}

	public void apply(
		com.df.lonis.ventesservice.model.Objectif entry, Objectif dto) {

		if (dto == null) {
			return;
		}
		if (dto.getCommercialId() != null) {
			entry.setCommercialId(dto.getCommercialId());
		}
		if (dto.getType() != null) {
			entry.setType(dto.getType().getValue());
		}
		if (dto.getPeriode() != null) {
			entry.setPeriode(dto.getPeriode().getValue());
		}
		if (dto.getValeurCible() != null) {
			entry.setValeurCible(dto.getValeurCible());
		}
		if (dto.getValeurReelle() != null) {
			entry.setValeurReelle(dto.getValeurReelle());
		}
		if (dto.getMois() != null) {
			entry.setMois(dto.getMois());
		}
		if (dto.getTrimestre() != null) {
			entry.setTrimestre(dto.getTrimestre());
		}
		if (dto.getAnnee() != null) {
			entry.setAnnee(dto.getAnnee());
		}
	}

}
