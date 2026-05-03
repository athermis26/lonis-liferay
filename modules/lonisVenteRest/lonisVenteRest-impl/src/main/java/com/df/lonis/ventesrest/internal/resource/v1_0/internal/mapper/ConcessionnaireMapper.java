package com.df.lonis.ventesrest.internal.resource.v1_0.internal.mapper;

import com.df.lonis.ventesrest.dto.v1_0.Concessionnaire;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireDetail;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireStats;
import com.df.lonis.ventesservice.model.ConcessionnaireProduit;
import com.df.lonis.ventesservice.service.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(service = ConcessionnaireMapper.class)
public class ConcessionnaireMapper {
    public Concessionnaire toDto(com.df.lonis.ventesservice.model.Concessionnaire entry) {

        Concessionnaire dto = new Concessionnaire();
        dto.setId(entry.getId());
        dto.setUid(entry.getUid());
        dto.setNom(entry.getNom());
        dto.setPrenoms(entry.getPrenoms());
        dto.setTelephone(entry.getTelephone());
        dto.setEmail(entry.getEmail());
        return dto;
    }

    public ConcessionnaireDetail toDtoDetail(
            com.df.lonis.ventesservice.model.Concessionnaire entry,
            List<ConcessionnaireProduit> cps,
            com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireProduit[] cpDtos, com.df.lonis.ventesrest.dto.v1_0.Terminal[] terminalDtos) {

        ConcessionnaireDetail dto = new ConcessionnaireDetail();
        dto.setId(entry.getId());
        dto.setUid(entry.getUid());
        dto.setNom(entry.getNom());
        dto.setPrenoms(entry.getPrenoms());
        dto.setTelephone(entry.getTelephone());
        dto.setEmail(entry.getEmail());
        dto.setConcessionnaireProduits(cpDtos);
        dto.setConcessionnaireTerminals(terminalDtos);

        // Agrégats sur tous les terminaux du concessionnaire
        List<com.df.lonis.ventesservice.model.Terminal> terminaux = _terminalLocalService.findByConcessionnaireId(entry.getId());

        long totalOperations = 0L;
        long chiffreAffaires = 0L;
        long soldeTotal = 0L;
        long totalPaiements = 0L;

        for (com.df.lonis.ventesservice.model.Terminal t : terminaux) {
            totalOperations += _operationLocalService.countByTerminalId(t.getId());

            List<com.df.lonis.ventesservice.model.ChiffreAffaires> cas = _chiffreAffairesLocalService.findByTerminalId(t.getId());

            for (com.df.lonis.ventesservice.model.ChiffreAffaires ca : cas) {
                chiffreAffaires += ca.getBrut() - ca.getAnnulation() - ca.getRemboursement();
                soldeTotal += ca.getBalance();
                totalPaiements += ca.getPaiement();
            }
        }

        ConcessionnaireStats stats = new ConcessionnaireStats();
        stats.setTotalProduits(cps.size());
        stats.setTotalTerminaux(terminaux.size());
        stats.setTotalOperations(totalOperations);
        stats.setTotalPaiements(totalPaiements);
        stats.setChiffreAffaires(chiffreAffaires);

        dto.setStats(stats);
        dto.setSoldeTotal(soldeTotal);

        return dto;
    }

    @Reference
    private ChiffreAffairesLocalService _chiffreAffairesLocalService;

    @Reference
    private TerminalLocalService _terminalLocalService;

    @Reference
    private OperationLocalService _operationLocalService;
}
