package com.df.lonis.ventesrest.internal.resource.v1_0.mapper;

import com.df.lonis.ventesrest.dto.v1_0.Produit;
import org.osgi.service.component.annotations.Component;

@Component(service = ProduitMapper.class)
public class ProduitMapper {
    public Produit toDto(com.df.lonis.ventesservice.model.Produit entry) {
        Produit dto = new Produit();
        dto.setId(entry.getId());
        dto.setCode(entry.getCode());
        dto.setAbreviation(entry.getAbreviation());
        dto.setLibelle(entry.getLibelle());
        dto.setActive(entry.isActive());
        dto.setCreatedAt(entry.getCreatedAt());
        dto.setUpdatedAt(entry.getUpdatedAt());

        return dto;
    }
}
