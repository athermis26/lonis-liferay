package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Concessionnaire;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireDetail;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireProduit;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireStats;
import com.df.lonis.ventesrest.dto.v1_0.Produit;
import com.df.lonis.ventesrest.dto.v1_0.Site;
import com.df.lonis.ventesrest.internal.resource.v1_0.mapper.ConcessionnaireMapper;
import com.df.lonis.ventesrest.internal.resource.v1_0.mapper.ConcessionnaireProduitMapper;
import com.df.lonis.ventesrest.internal.resource.v1_0.mapper.TerminalMapper;
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
			String search, Filter filter, Pagination pagination, Sort[] sorts) {

		List<com.df.lonis.ventesservice.model.Concessionnaire> entries =
				_concessionnaireLocalService.getConcessionnaires(
						pagination.getStartPosition(), pagination.getEndPosition());

		int total = _concessionnaireLocalService.getConcessionnairesCount();

		return Page.of(
				entries.stream().map(_concessionnaireMapper::toDto).collect(Collectors.toList()),
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
				.map(_concessionnaireProduitMapper::toDtoProduit)
				.toArray(ConcessionnaireProduit[]::new);

		com.df.lonis.ventesrest.dto.v1_0.Terminal[] terminauxDtos = terminaux.stream().map(_terminalMapper::toDto).toArray(com.df.lonis.ventesrest.dto.v1_0.Terminal[]::new);

		return _concessionnaireMapper.toDtoDetail(entry, cps, cpDtos, terminauxDtos);
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
				cps.stream().map(_concessionnaireProduitMapper::toDtoProduit).collect(Collectors.toList()));
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Concessionnaire>,
					UnsafeFunction<Concessionnaire, Concessionnaire, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

//	Les Mappers
	@Reference
	private ConcessionnaireMapper _concessionnaireMapper;

	@Reference
	private ConcessionnaireProduitMapper _concessionnaireProduitMapper;

	@Reference
	private TerminalMapper _terminalMapper;

//	Les Services
	@Reference
	private ConcessionnaireLocalService _concessionnaireLocalService;

	@Reference
	private ConcessionnaireProduitLocalService _concessionnaireProduitLocalService;

	@Reference
	private TerminalLocalService _terminalLocalService;

}