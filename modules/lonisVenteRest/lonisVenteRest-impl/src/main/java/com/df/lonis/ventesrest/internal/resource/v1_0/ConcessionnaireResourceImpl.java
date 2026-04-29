package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Concessionnaire;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireDetail;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireProduit;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireStats;
import com.df.lonis.ventesrest.dto.v1_0.Produit;
import com.df.lonis.ventesrest.dto.v1_0.Site;
import com.df.lonis.ventesrest.resource.v1_0.ConcessionnaireResource;

import com.df.lonis.ventesservice.model.Terminal;
import com.df.lonis.ventesservice.service.ChiffreAffairesLocalService;
import com.df.lonis.ventesservice.service.ConcessionnaireLocalService;
import com.df.lonis.ventesservice.service.ConcessionnaireProduitLocalService;
import com.df.lonis.ventesservice.service.OperationLocalService;
import com.df.lonis.ventesservice.service.ProduitLocalService;
import com.df.lonis.ventesservice.service.SiteLocalService;
import com.df.lonis.ventesservice.service.TerminalLocalService;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author HP
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/concessionnaire.properties",
		scope = ServiceScope.PROTOTYPE,
		service = ConcessionnaireResource.class
)
public class ConcessionnaireResourceImpl extends BaseConcessionnaireResourceImpl {

	@Override
	public Page<Concessionnaire> getConcessionnairesPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
			throws Exception {

		List<com.df.lonis.ventesservice.model.Concessionnaire> entries =
				_concessionnaireLocalService.getConcessionnaires(
						pagination.getStartPosition(), pagination.getEndPosition());

		int total = _concessionnaireLocalService.getConcessionnairesCount();

		return Page.of(
				entries.stream().map(this::_toDto).collect(Collectors.toList()),
				pagination, total);
	}

	@Override
	public ConcessionnaireDetail getConcessionnaireById(Long id) {

		com.df.lonis.ventesservice.model.Concessionnaire entry = _concessionnaireLocalService.fetchConcessionnaire(id);

		if (entry == null) {
			throw new NotFoundException("Concessionnaire introuvable: " + id);
		}

		List<com.df.lonis.ventesservice.model.ConcessionnaireProduit> cps =
				_concessionnaireProduitLocalService.findByConcessionnaireId(
						entry.getId());

		List<Terminal> terminaux = _terminalLocalService.findByConcessionnaireId(entry.getId());

		ConcessionnaireProduit[] cpDtos = cps.stream()
				.map(this::_toDtoProduit)
				.toArray(ConcessionnaireProduit[]::new);

		com.df.lonis.ventesrest.dto.v1_0.Terminal[] terminauxDtos = terminaux.stream().map(this::_toDtoTerminal).toArray(com.df.lonis.ventesrest.dto.v1_0.Terminal[]::new);

		return _toDtoDetail(entry, cps, cpDtos, terminauxDtos);
	}

	@Override
	public Page<ConcessionnaireProduit> getConcessionnaireProduits(Long uid)
			throws Exception {

		com.df.lonis.ventesservice.model.Concessionnaire entry = _concessionnaireLocalService.fetchConcessionnaire(uid);

		if (entry == null) {
			throw new NotFoundException("Concessionnaire introuvable: " + uid);
		}

		List<com.df.lonis.ventesservice.model.ConcessionnaireProduit> cps =
				_concessionnaireProduitLocalService.findByConcessionnaireId(
						entry.getId());

		return Page.of(
				cps.stream().map(this::_toDtoProduit).collect(Collectors.toList()));
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Concessionnaire>,
					UnsafeFunction<Concessionnaire, Concessionnaire, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	// ───────── DTO mappers ─────────

	private Concessionnaire _toDto(
			com.df.lonis.ventesservice.model.Concessionnaire entry) {

		Concessionnaire dto = new Concessionnaire();
		dto.setId(entry.getId());
		dto.setUid(entry.getUid());
		dto.setNom(entry.getNom());
		dto.setPrenoms(entry.getPrenoms());
		dto.setTelephone(entry.getTelephone());
		dto.setEmail(entry.getEmail());
		return dto;
	}

	private ConcessionnaireDetail _toDtoDetail(
			com.df.lonis.ventesservice.model.Concessionnaire entry,
			List<com.df.lonis.ventesservice.model.ConcessionnaireProduit> cps,
			ConcessionnaireProduit[] cpDtos, com.df.lonis.ventesrest.dto.v1_0.Terminal[] terminalDtos) {

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
				chiffreAffaires += ca.getVentes();
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

	private ConcessionnaireProduit _toDtoProduit(
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
		com.df.lonis.ventesservice.model.Produit p =
				_produitLocalService.fetchProduit(entry.getProduitId());
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

	private com.df.lonis.ventesrest.dto.v1_0.Terminal _toDtoTerminal(
			com.df.lonis.ventesservice.model.Terminal entry) {
		com.df.lonis.ventesrest.dto.v1_0.Terminal dto = new com.df.lonis.ventesrest.dto.v1_0.Terminal();

		dto.setId(entry.getId());
		dto.setConcessionnaireId(entry.getConcessionnaireId());
		dto.setCreatedAt(entry.getCreatedAt());
		dto.setUpdatedAt(entry.getUpdatedAt());

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