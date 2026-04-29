package com.df.lonis.ventesrest.internal.resource.v1_0.mapper;

import com.df.lonis.ventesrest.dto.v1_0.Operation;
import com.df.lonis.ventesrest.dto.v1_0.OperationDetail;
import org.osgi.service.component.annotations.Component;

@Component(service = OperationMapper.class)
public class OperationMapper {
    public Operation toDto(com.df.lonis.ventesservice.model.Operation entry) {
        Operation dto = new Operation();
        dto.setId(entry.getId());
        dto.setCode(entry.getCode());
        dto.setLibelle(entry.getLibelle());
        dto.setReference(entry.getReference());
        dto.setMontant(entry.getMontant());
        dto.setMontantReel(entry.getMontantReel());
        dto.setStatut(entry.getStatut());
        dto.setTerminalId(entry.getTerminalId());
        dto.setGuichet(entry.getGuichet());
        dto.setDateOperation(entry.getDateOperation());

        return dto;
    }

    public OperationDetail toDtoDetail(com.df.lonis.ventesservice.model.Operation entry) {
        OperationDetail operationDetail = new OperationDetail();
        operationDetail.setId(entry.getId());
        operationDetail.setCodeOperation(entry.getCode());
        operationDetail.setLibelle(entry.getLibelle());
        operationDetail.setReference(entry.getReference());
        operationDetail.setMontant(entry.getMontant());
        operationDetail.setMontantReel(entry.getMontantReel());
        operationDetail.setStatut(entry.getStatut());
        operationDetail.setGuichet(entry.getGuichet());
        operationDetail.setDateHeure(entry.getDateOperation());

        return operationDetail;
    }
}
