package com.df.lonis.reseaurest.internal.resource.v1_0.internal.mapper;

import com.df.lonis.reseaurest.dto.v1_0.Visite;
import com.df.lonis.reseaurest.dto.v1_0.VisiteRequestBody;

import org.osgi.service.component.annotations.Component;

/**
 * @author HP
 */
@Component(service = VisiteMapper.class)
public class VisiteMapper {

	public Visite toDto(com.df.lonis.ventesservice.model.Visite entry) {
		if (entry == null) {
			return null;
		}

		Visite dto = new Visite();
		dto.setId(entry.getId());
		dto.setCommercialId(entry.getCommercialId());
		dto.setTerminalId(entry.getTerminalId());
		dto.setLatitude(entry.getLatitude());
		dto.setLongitude(entry.getLongitude());
		dto.setDateVisite(entry.getDateVisite());
		dto.setCompteRendu(entry.getCompteRendu());

		if (entry.getStatut() != null) {
			dto.setStatut(Visite.Statut.create(entry.getStatut()));
		}
		if (entry.getTypeControle() != null) {
			dto.setTypeControle(
				Visite.TypeControle.create(entry.getTypeControle()));
		}
		return dto;
	}

	public void apply(
		com.df.lonis.ventesservice.model.Visite entry, Visite dto) {

		if (dto == null) {
			return;
		}
		if (dto.getCommercialId() != null) {
			entry.setCommercialId(dto.getCommercialId());
		}
		if (dto.getTerminalId() != null) {
			entry.setTerminalId(dto.getTerminalId());
		}
		if (dto.getLatitude() != null) {
			entry.setLatitude(dto.getLatitude());
		}
		if (dto.getLongitude() != null) {
			entry.setLongitude(dto.getLongitude());
		}
		if (dto.getStatut() != null) {
			entry.setStatut(dto.getStatut().getValue());
		}
		if (dto.getTypeControle() != null) {
			entry.setTypeControle(dto.getTypeControle().getValue());
		}
		if (dto.getDateVisite() != null) {
			entry.setDateVisite(dto.getDateVisite());
		}
		if (dto.getCompteRendu() != null) {
			entry.setCompteRendu(dto.getCompteRendu());
		}
	}

	public void applyRequestBody(
		com.df.lonis.ventesservice.model.Visite entry, VisiteRequestBody body) {

		if (body == null) {
			return;
		}
		if (body.getCommercialId() != null) {
			entry.setCommercialId(body.getCommercialId());
		}
		if (body.getTerminalId() != null) {
			entry.setTerminalId(body.getTerminalId());
		}
		if (body.getLatitude() != null) {
			entry.setLatitude(body.getLatitude());
		}
		if (body.getLongitude() != null) {
			entry.setLongitude(body.getLongitude());
		}
		if (body.getStatut() != null) {
			entry.setStatut(body.getStatut().getValue());
		}
		if (body.getTypeControle() != null) {
			entry.setTypeControle(body.getTypeControle().getValue());
		}
		if (body.getDateVisite() != null) {
			entry.setDateVisite(body.getDateVisite());
		}
		if (body.getCompteRendu() != null) {
			entry.setCompteRendu(body.getCompteRendu());
		}
	}

}
