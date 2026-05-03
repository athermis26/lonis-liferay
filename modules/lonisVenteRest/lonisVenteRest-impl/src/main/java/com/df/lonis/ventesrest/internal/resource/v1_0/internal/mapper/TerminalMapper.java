package com.df.lonis.ventesrest.internal.resource.v1_0.internal.mapper;

import com.df.lonis.ventesrest.dto.v1_0.Terminal;
import com.df.lonis.ventesservice.model.*;
import com.df.lonis.ventesservice.service.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;

@Component(service = TerminalMapper.class)
public class TerminalMapper {
    public Terminal toDto(com.df.lonis.ventesservice.model.Terminal entry) {
        Terminal dto = new Terminal();
        dto.setId(entry.getId());
        dto.setCodeTerminal(entry.getCodeTerminal());
        dto.setConcessionnaireCode(entry.getConcessionnaireCode());
        dto.setConcessionnaireId(entry.getConcessionnaireId());
//		dto.setProduitId(entry.getProduitId());
//		dto.setConcessionnaireProduitCode(entry.getConcessionnaireProduitCode());
//		dto.setSiteId(entry.getSiteId());
        dto.setCreatedAt(entry.getCreatedAt());
        dto.setUpdatedAt(entry.getUpdatedAt());

        long soldeTotal = 0L;

        List<ChiffreAffaires> cas = _chiffreAffairesLocalService.findByTerminalId(entry.getId());

        Concessionnaire c = _concessionnaireLocalService.fetchConcessionnaire(entry.getConcessionnaireId());

        ConcessionnaireProduit cp = _concessionnaireProduitLocalService.findByCode(entry.getConcessionnaireProduitCode());

        Produit p = _produitLocalService.fetchProduit(cp.getProduitId());

        Site s = _siteLocalService.fetchSite(entry.getSiteId());

        for (ChiffreAffaires ca : cas) {
            soldeTotal += ca.getBalance();
        }

        dto.setConcessionnaireNomPrenom(c.getNom() + " " + c.getPrenoms());

        dto.setProduitType(p.getLibelle());

        dto.setSiteLibelle(s.getLibelle());

        dto.setSolde(soldeTotal);

        return dto;
    }

    @Reference
    private ChiffreAffairesLocalService _chiffreAffairesLocalService;

    @Reference
    private ConcessionnaireProduitLocalService _concessionnaireProduitLocalService;

    @Reference
    private ConcessionnaireLocalService _concessionnaireLocalService;

    @Reference
    private ProduitLocalService _produitLocalService;

    @Reference
    private SiteLocalService _siteLocalService;
}
