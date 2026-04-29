package com.df.lonis.ventesrest.internal.resource.v1_0.mapper;

import com.df.lonis.ventesrest.dto.v1_0.Site;
import org.osgi.service.component.annotations.Component;

@Component(service = SiteMapper.class)
public class SiteMapper {
    public Site toDto(com.df.lonis.ventesservice.model.Site entry) {
        Site dto = new Site();
        dto.setId(entry.getId());
        dto.setCode(entry.getCode());
        dto.setLibelle(entry.getLibelle());
        dto.setCodeProvince(entry.getCodeProvinov());
        dto.setParentId(entry.getParentId());
        dto.setStatus(entry.getStatus());
        dto.setType(entry.getType());
        dto.setCreatedAt(entry.getCreatedAt());
        dto.setUpdatedAt(entry.getUpdatedAt());

        return dto;
    }
}
