package com.df.lonis.reseaurest.internal.resource.v1_0.internal.mapper;

import com.df.lonis.reseaurest.dto.v1_0.Terminal;
import com.df.lonis.reseaurest.dto.v1_0.TerminalPutRequestBody;
import com.df.lonis.reseaurest.dto.v1_0.TerminalRequestBody;

import org.osgi.service.component.annotations.Component;

/**
 * @author HP
 */
@Component(service = TerminalMapper.class)
public class TerminalMapper {

	public Terminal toDto(com.df.lonis.ventesservice.model.Terminal entry) {
		if (entry == null) {
			return null;
		}

		Terminal dto = new Terminal();
		dto.setId(entry.getId());
		dto.setCodeTerminal(entry.getCodeTerminal());
		dto.setConcessionnaireId(entry.getConcessionnaireId());
		dto.setSiteId(entry.getSiteId());
		dto.setLatitude(entry.getLatitude());
		dto.setLongitude(entry.getLongitude());
		dto.setAdresse(entry.getAdresse());

		if (entry.getStatutValidation() != null) {
			dto.setStatutValidation(
				Terminal.StatutValidation.create(entry.getStatutValidation()));
		}
		return dto;
	}

	public void applyRequestBody(
		com.df.lonis.ventesservice.model.Terminal entry,
		TerminalRequestBody body) {

		if (body == null) {
			return;
		}
		if (body.getConcessionnaireId() != null) {
			entry.setConcessionnaireId(body.getConcessionnaireId());
		}
		if (body.getSiteId() != null) {
			entry.setSiteId(body.getSiteId());
		}
		if (body.getLatitude() != null) {
			entry.setLatitude(body.getLatitude());
		}
		if (body.getLongitude() != null) {
			entry.setLongitude(body.getLongitude());
		}
		if (body.getAdresse() != null) {
			entry.setAdresse(body.getAdresse());
		}
	}

	public void applyPutRequestBody(
		com.df.lonis.ventesservice.model.Terminal entry,
		TerminalPutRequestBody body) {

		if (body == null) {
			return;
		}
		if (body.getConcessionnaireId() != null) {
			entry.setConcessionnaireId(body.getConcessionnaireId());
		}
		if (body.getSiteId() != null) {
			entry.setSiteId(body.getSiteId());
		}
		if (body.getLatitude() != null) {
			entry.setLatitude(body.getLatitude());
		}
		if (body.getLongitude() != null) {
			entry.setLongitude(body.getLongitude());
		}
		if (body.getAdresse() != null) {
			entry.setAdresse(body.getAdresse());
		}
	}

	public void applyDto(
		com.df.lonis.ventesservice.model.Terminal entry, Terminal dto) {

		if (dto == null) {
			return;
		}
		if (dto.getConcessionnaireId() != null) {
			entry.setConcessionnaireId(dto.getConcessionnaireId());
		}
		if (dto.getSiteId() != null) {
			entry.setSiteId(dto.getSiteId());
		}
		if (dto.getLatitude() != null) {
			entry.setLatitude(dto.getLatitude());
		}
		if (dto.getLongitude() != null) {
			entry.setLongitude(dto.getLongitude());
		}
		if (dto.getAdresse() != null) {
			entry.setAdresse(dto.getAdresse());
		}
		if (dto.getStatutValidation() != null) {
			entry.setStatutValidation(dto.getStatutValidation().getValue());
		}
	}

}
