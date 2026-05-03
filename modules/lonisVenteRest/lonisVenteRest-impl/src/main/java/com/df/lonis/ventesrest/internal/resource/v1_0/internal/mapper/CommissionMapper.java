package com.df.lonis.ventesrest.internal.resource.v1_0.internal.mapper;

import com.df.lonis.ventesrest.dto.v1_0.Commission;
import com.df.lonis.ventesrest.dto.v1_0.CommissionDetail;
import org.osgi.service.component.annotations.Component;

@Component(service = CommissionMapper.class)
public class CommissionMapper {
    public Commission toDto(
            com.df.lonis.ventesservice.model.Commission commission) {

        Commission dto = new Commission();
        dto.setId(commission.getId());
        dto.setCode(commission.getCode());
        dto.setLibelle(commission.getLibelle());
        dto.setTerminalId(commission.getTerminalId());
        dto.setNombreTerminaux(commission.getNombreTerminal());
        dto.setPaye(commission.getPaye());
        dto.setStatus(commission.getStatus());
        dto.setCreatedAt(commission.getCreatedAt());
        return dto;
    }

    public CommissionDetail toDtoDetail(
            com.df.lonis.ventesservice.model.Commission commission) {

        CommissionDetail dto = new CommissionDetail();
        dto.setId(commission.getId());
        dto.setPaye(commission.getPaye());
        dto.setStatus(commission.getStatus());
        return dto;
    }
}
