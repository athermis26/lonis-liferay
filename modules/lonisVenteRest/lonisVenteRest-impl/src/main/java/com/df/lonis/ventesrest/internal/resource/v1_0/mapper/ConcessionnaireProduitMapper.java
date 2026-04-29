package com.df.lonis.ventesrest.internal.resource.v1_0.mapper;

import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireProduit;
import com.df.lonis.ventesrest.dto.v1_0.Produit;
import com.df.lonis.ventesrest.dto.v1_0.Site;
import com.df.lonis.ventesservice.service.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = ConcessionnaireProduitMapper.class)
public class ConcessionnaireProduitMapper {
    public ConcessionnaireProduit toDtoProduit(
            com.df.lonis.ventesservice.model.ConcessionnaireProduit entry) {

        ConcessionnaireProduit dto = new ConcessionnaireProduit();
        dto.setId(entry.getId());
        dto.setConcessionnaireId(entry.getConcessionnaireId());
        dto.setConcessionnaireCode(entry.getConcessionnaireCode());
        dto.setProduitId(entry.getProduitId());
        dto.setSiteId(entry.getSiteId());
        dto.setCode(entry.getCode());
        dto.setActive(entry.getActive());
        dto.setChiffreAffaires(0L);

        // Produit imbriqué
        com.df.lonis.ventesservice.model.Produit p = _produitLocalService.fetchProduit(entry.getProduitId());
        if (p != null) {
            Produit pd = new Produit();
            pd.setId(p.getId());
            pd.setCode(p.getCode());
            pd.setLibelle(p.getLibelle());
            pd.setAbreviation(p.getAbreviation());
            pd.setActive(p.getActive());
            pd.setCreatedAt(p.getCreatedAt());
            pd.setUpdatedAt(p.getUpdatedAt());
            dto.setProduit(pd);
        }

        // Site imbriqué
        com.df.lonis.ventesservice.model.Site s =
                _siteLocalService.fetchSite(entry.getSiteId());
        if (s != null) {
            Site sd = new Site();
            sd.setId(s.getId());
            sd.setLibelle(s.getLibelle());
            sd.setType(s.getType());
            sd.setParentId(s.getParentId());
            sd.setCode(s.getCode());
            sd.setCodeProvince(s.getCodeProvinov());
            sd.setStatus(s.getStatus());
            sd.setCreatedAt(s.getCreatedAt());
            sd.setUpdatedAt(s.getUpdatedAt());
            dto.setSite(sd);
        }

        return dto;
    }

    @Reference
    private ChiffreAffairesLocalService _chiffreAffairesLocalService;

    @Reference
    private ConcessionnaireLocalService _concessionnaireLocalService;

    @Reference
    private ConcessionnaireProduitLocalService _concessionnaireProduitLocalService;

    @Reference
    private OperationLocalService _operationLocalService;

    @Reference
    private ProduitLocalService _produitLocalService;

    @Reference
    private SiteLocalService _siteLocalService;

    @Reference
    private TerminalLocalService _terminalLocalService;
}
