package com.df.lonis.ventesrest.internal.resource.v1_0.internal.mapper;

import com.df.lonis.ventesrest.dto.v1_0.ChiffreAffaire;

import com.df.lonis.ventesservice.model.ChiffreAffaires;
import com.df.lonis.ventesservice.model.Terminal;
import com.df.lonis.ventesservice.service.TerminalLocalService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = ChiffreAffaireMapper.class)
public class ChiffreAffaireMapper {

    public ChiffreAffaire toDto(ChiffreAffaires entry) {
        if (entry == null) {
            return null;
        }

        ChiffreAffaire dto = new ChiffreAffaire();
        dto.setId(entry.getId());
        dto.setBalance(entry.getBalance());
        dto.setBrut(entry.getBrut());
        dto.setAnnulation(entry.getAnnulation());
        dto.setRembourcement(entry.getRemboursement());
        dto.setPaiement(entry.getPaiement());
        dto.setVentes(entry.getVentes());
        dto.setDeposite(entry.getDeposit());
        dto.setChiffreAffaire(
                entry.getBrut() - entry.getAnnulation() - entry.getRemboursement());
        dto.setDate(entry.getDate());
        dto.setCreatedAt(entry.getCreatedAt());
        dto.setUpdatedAt(entry.getUpdatedAt());

        _enrichWithTerminal(dto, entry.getTerminalId());

        return dto;
    }

    /**
     * Agrege les ChiffreAffaires par terminalId.
     * Retourne un DTO par terminal avec les montants sommes.
     */
    public List<ChiffreAffaire> toDtoAggrege(List<ChiffreAffaires> entries) {
        if ((entries == null) || entries.isEmpty()) {
            return new ArrayList<>();
        }

        Map<Long, ChiffreAffaire> parTerminal = new LinkedHashMap<>();

        for (ChiffreAffaires e : entries) {
            long terminalId = e.getTerminalId();

            ChiffreAffaire dto = parTerminal.get(terminalId);

            if (dto == null) {
                dto = new ChiffreAffaire();
                dto.setBrut(0L);
                dto.setPaiement(0L);
                dto.setAnnulation(0L);
                dto.setRembourcement(0L);
                dto.setVentes(0L);
                dto.setBalance(0L);
                dto.setDeposite(0L);
                dto.setChiffreAffaire(0L);

                _enrichWithTerminal(dto, terminalId);

                parTerminal.put(terminalId, dto);
            }
            dto.setId(e.getId());
            dto.setBrut(dto.getBrut() + e.getBrut());
            dto.setPaiement(dto.getPaiement() + e.getPaiement());
            dto.setAnnulation(dto.getAnnulation() + e.getAnnulation());
            dto.setRembourcement(dto.getRembourcement() + e.getRemboursement());
            dto.setVentes(dto.getVentes() + e.getVentes());
            dto.setBalance(dto.getBalance() + e.getBalance());
            dto.setDeposite(dto.getDeposite() + e.getDeposit());

            // Garde la date la plus recente
            if ((dto.getDate() == null) ||
                    ((e.getDate() != null) && e.getDate().after(dto.getDate()))) {

                dto.setDate(e.getDate());
            }
        }

        // chiffreAffaire = brut - annulation - remboursement (calcule final)
        for (ChiffreAffaire dto : parTerminal.values()) {
            dto.setChiffreAffaire(
                    dto.getBrut() - dto.getAnnulation() - dto.getRembourcement());
        }

        List<ChiffreAffaire> result = new ArrayList<>(parTerminal.values());

        // Tri optionnel par CA decroissant
        result.sort(
                Comparator.comparingLong(
                        ChiffreAffaire::getChiffreAffaire).reversed());

        return result;
    }

    private void _enrichWithTerminal(ChiffreAffaire dto, long terminalId) {
        Terminal t = _terminalLocalService.fetchTerminal(terminalId);
        if (t == null) {
            return;
        }

        com.df.lonis.ventesrest.dto.v1_0.Terminal terminalDto =
                _terminalMapper.toDto(t);

        dto.setCodeTerminal(t.getCodeTerminal());

        if (terminalDto != null) {
            dto.setConcessionnaireNomPrenom(
                    terminalDto.getConcessionnaireNomPrenom());
            dto.setProduitType(terminalDto.getProduitType());
            dto.setSite(terminalDto.getSiteLibelle());
        }
    }

    @Reference
    private TerminalLocalService _terminalLocalService;

    @Reference
    private TerminalMapper _terminalMapper;

}