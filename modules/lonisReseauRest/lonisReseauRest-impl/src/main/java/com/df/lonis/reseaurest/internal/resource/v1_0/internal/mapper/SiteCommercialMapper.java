package com.df.lonis.reseaurest.internal.resource.v1_0.internal.mapper;

import com.df.lonis.reseaurest.dto.v1_0.SiteCommercial;

import org.osgi.service.component.annotations.Component;

/**
 * @author HP
 */
@Component(service = SiteCommercialMapper.class)
public class SiteCommercialMapper {

	public SiteCommercial toDto(
		com.df.lonis.ventesservice.model.SiteCommercial entry) {

		if (entry == null) {
			return null;
		}

		SiteCommercial dto = new SiteCommercial();
		dto.setId(entry.getId());
		dto.setSiteId(entry.getSiteId());
		dto.setCommercialId(entry.getCommercialId());
		dto.setDateDebut(entry.getDateDebut());
		dto.setDateFin(entry.getDateFin());
		dto.setIsPrincipal(entry.getIsPrincipal());
		return dto;
	}

}
