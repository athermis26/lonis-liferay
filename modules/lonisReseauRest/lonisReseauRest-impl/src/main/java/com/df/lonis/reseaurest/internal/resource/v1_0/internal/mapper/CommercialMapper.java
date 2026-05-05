package com.df.lonis.reseaurest.internal.resource.v1_0.internal.mapper;

import com.df.lonis.reseaurest.dto.v1_0.Commercial;
import com.df.lonis.reseaurest.dto.v1_0.CommercialRequestBody;

import org.osgi.service.component.annotations.Component;

/**
 * @author HP
 */
@Component(service = CommercialMapper.class)
public class CommercialMapper {

	public Commercial toDto(
		com.df.lonis.ventesservice.model.Commercial entry) {

		if (entry == null) {
			return null;
		}

		Commercial dto = new Commercial();
		dto.setId(entry.getId());
		dto.setNom(entry.getNom());
		dto.setPrenoms(entry.getPrenoms());
		dto.setTelephone(entry.getTelephone());
		dto.setEmail(entry.getEmail());
		dto.setMatricule(entry.getMatricule());
		dto.setStatut(entry.getStatut());
		dto.setSuperviseurId(entry.getSuperviseurId());
		return dto;
	}

	public void applyRequestBody(
		com.df.lonis.ventesservice.model.Commercial entry,
		CommercialRequestBody body) {

		if (body == null) {
			return;
		}
		if (body.getNom() != null) {
			entry.setNom(body.getNom());
		}
		if (body.getPrenoms() != null) {
			entry.setPrenoms(body.getPrenoms());
		}
		if (body.getTelephone() != null) {
			entry.setTelephone(body.getTelephone());
		}
		if (body.getEmail() != null) {
			entry.setEmail(body.getEmail());
		}
		if (body.getMatricule() != null) {
			entry.setMatricule(body.getMatricule());
		}
		if (body.getStatut() != null) {
			entry.setStatut(body.getStatut());
		}
	}

	public void applyDto(
		com.df.lonis.ventesservice.model.Commercial entry, Commercial dto) {

		if (dto == null) {
			return;
		}
		if (dto.getNom() != null) {
			entry.setNom(dto.getNom());
		}
		if (dto.getPrenoms() != null) {
			entry.setPrenoms(dto.getPrenoms());
		}
		if (dto.getTelephone() != null) {
			entry.setTelephone(dto.getTelephone());
		}
		if (dto.getEmail() != null) {
			entry.setEmail(dto.getEmail());
		}
		if (dto.getMatricule() != null) {
			entry.setMatricule(dto.getMatricule());
		}
		if (dto.getStatut() != null) {
			entry.setStatut(dto.getStatut());
		}
		if (dto.getSuperviseurId() != null) {
			entry.setSuperviseurId(dto.getSuperviseurId());
		}
	}

}
