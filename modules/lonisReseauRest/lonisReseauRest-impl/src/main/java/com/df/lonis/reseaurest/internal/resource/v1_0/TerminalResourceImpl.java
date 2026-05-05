package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Terminal;
import com.df.lonis.reseaurest.dto.v1_0.TerminalRequestBody;
import com.df.lonis.reseaurest.dto.v1_0.Visite;
import com.df.lonis.reseaurest.internal.resource.v1_0.internal.mapper.TerminalMapper;
import com.df.lonis.reseaurest.internal.resource.v1_0.internal.mapper.VisiteMapper;
import com.df.lonis.reseaurest.resource.v1_0.TerminalResource;

import com.df.lonis.ventesservice.service.TerminalLocalService;
import com.df.lonis.ventesservice.service.VisiteLocalService;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Collection;
import java.util.Date;
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
	properties = "OSGI-INF/liferay/rest/v1_0/terminal.properties",
	scope = ServiceScope.PROTOTYPE, service = TerminalResource.class
)
public class TerminalResourceImpl extends BaseTerminalResourceImpl {

	// ───────── Liste paginee ─────────

	@Override
	public Page<Terminal> getTerminalsPage(
			Long siteId, String statutValidation, String search, Filter filter,
			Pagination pagination, Sort[] sorts)
		throws Exception {

		DynamicQuery dq = _terminalLocalService.dynamicQuery();
		_applyFilters(dq, siteId, statutValidation, search);
		dq.setLimit(
			pagination.getStartPosition(), pagination.getEndPosition());

		List<com.df.lonis.ventesservice.model.Terminal> entries =
			_terminalLocalService.dynamicQuery(dq);

		DynamicQuery countDq = _terminalLocalService.dynamicQuery();
		_applyFilters(countDq, siteId, statutValidation, search);
		long total = _terminalLocalService.dynamicQueryCount(countDq);

		return Page.of(
			entries.stream(
			).map(
				_terminalMapper::toDto
			).collect(
				Collectors.toList()
			),
			pagination, total);
	}

	// ───────── CRUD ─────────

	@Override
	public Terminal postTerminal(TerminalRequestBody body) throws Exception {
		// id-type="identity" => la BDD genere l'ID a l'INSERT
		com.df.lonis.ventesservice.model.Terminal entry =
			_terminalLocalService.createTerminal(0);

		_terminalMapper.applyRequestBody(entry, body);

		entry.setStatutValidation(_STATUT_EN_ATTENTE);
		entry.setCreatedAt(new Date());
		entry.setUpdatedAt(new Date());

		entry = _terminalLocalService.addTerminal(entry);

		// Code automatique base sur l'ID genere par la BDD
		if ((entry.getCodeTerminal() == null) ||
			entry.getCodeTerminal().isEmpty()) {

			entry.setCodeTerminal(String.valueOf(entry.getId()));
			entry = _terminalLocalService.updateTerminal(entry);
		}

		return _terminalMapper.toDto(entry);
	}

	@Override
	public Terminal getTerminal(Long terminalId) throws Exception {
		com.df.lonis.ventesservice.model.Terminal entry =
			_terminalLocalService.fetchTerminal(terminalId);

		if (entry == null) {
			throw new NotFoundException("Terminal introuvable: " + terminalId);
		}

		return _terminalMapper.toDto(entry);
	}

	@Override
	public Terminal putTerminal(Long terminalId, Terminal body)
		throws Exception {

		com.df.lonis.ventesservice.model.Terminal entry =
			_terminalLocalService.fetchTerminal(terminalId);

		if (entry == null) {
			throw new NotFoundException("Terminal introuvable: " + terminalId);
		}

		_terminalMapper.applyDto(entry, body);
		entry.setUpdatedAt(new Date());

		entry = _terminalLocalService.updateTerminal(entry);

		return _terminalMapper.toDto(entry);
	}

	// ───────── Validation workflow ─────────

	@Override
	public Page<Terminal> getTerminalsAValiderPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		return getTerminalsPage(
			null, _STATUT_EN_ATTENTE, search, filter, pagination, sorts);
	}

	@Override
	public Terminal patchTerminalValider(Long terminalId) throws Exception {
		return _setStatut(terminalId, _STATUT_VALIDE);
	}

	@Override
	public Terminal patchTerminalRejeter(Long terminalId, Object motif)
		throws Exception {

		return _setStatut(terminalId, _STATUT_REJETE);
	}

	// ───────── Cartographie ─────────

	@Override
	public Page<Terminal> getTerminalsCartographie(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		// Seuls les terminaux geolocalises (lat/lng non null) ET valides
		DynamicQuery dq = _terminalLocalService.dynamicQuery();
		dq.add(PropertyFactoryUtil.forName("latitude").isNotNull());
		dq.add(PropertyFactoryUtil.forName("longitude").isNotNull());
		dq.add(
			PropertyFactoryUtil.forName(
				"statutValidation"
			).eq(
				_STATUT_VALIDE
			));
		_applyFilters(dq, null, null, search);

		dq.setLimit(
			pagination.getStartPosition(), pagination.getEndPosition());

		List<com.df.lonis.ventesservice.model.Terminal> entries =
			_terminalLocalService.dynamicQuery(dq);

		DynamicQuery countDq = _terminalLocalService.dynamicQuery();
		countDq.add(PropertyFactoryUtil.forName("latitude").isNotNull());
		countDq.add(PropertyFactoryUtil.forName("longitude").isNotNull());
		countDq.add(
			PropertyFactoryUtil.forName(
				"statutValidation"
			).eq(
				_STATUT_VALIDE
			));
		_applyFilters(countDq, null, null, search);

		long total = _terminalLocalService.dynamicQueryCount(countDq);

		return Page.of(
			entries.stream(
			).map(
				_terminalMapper::toDto
			).collect(
				Collectors.toList()
			),
			pagination, total);
	}

	@Override
	public Page<Terminal> getTerminalsCartographieTop20(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		// Top 20 = simple cap a 20 sur la cartographie. Le tri par CA reel
		// necessiterait une jointure avec chiffre_affaires (a faire plus tard).
		DynamicQuery dq = _terminalLocalService.dynamicQuery();
		dq.add(PropertyFactoryUtil.forName("latitude").isNotNull());
		dq.add(PropertyFactoryUtil.forName("longitude").isNotNull());
		dq.add(
			PropertyFactoryUtil.forName(
				"statutValidation"
			).eq(
				_STATUT_VALIDE
			));
		dq.setLimit(0, 20);

		List<com.df.lonis.ventesservice.model.Terminal> entries =
			_terminalLocalService.dynamicQuery(dq);

		return Page.of(
			entries.stream(
			).map(
				_terminalMapper::toDto
			).collect(
				Collectors.toList()
			));
	}

	// ───────── Visites ─────────

	@Override
	public Page<Visite> getTerminalVisitesPage(
			Long terminalId, String search, Filter filter,
			Pagination pagination, Sort[] sorts)
		throws Exception {

		List<com.df.lonis.ventesservice.model.Visite> entries =
			_visiteLocalService.findByTerminalId(
				terminalId, pagination.getStartPosition(),
				pagination.getEndPosition());

		long total = _visiteLocalService.countByTerminalId(terminalId);

		return Page.of(
			entries.stream(
			).map(
				_visiteMapper::toDto
			).collect(
				Collectors.toList()
			),
			pagination, total);
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
		UnsafeBiConsumer
			<Collection<Terminal>,
			 UnsafeFunction<Terminal, Terminal, Exception>,
			 Exception> contextBatchUnsafeBiConsumer) {
	}

	// ───────── Helpers ─────────

	private void _applyFilters(
		DynamicQuery dq, Long siteId, String statutValidation, String search) {

		if (siteId != null) {
			dq.add(PropertyFactoryUtil.forName("siteId").eq(siteId));
		}
		if ((statutValidation != null) && !statutValidation.isEmpty()) {
			dq.add(
				PropertyFactoryUtil.forName(
					"statutValidation"
				).eq(
					statutValidation
				));
		}
		if ((search != null) && !search.isEmpty()) {
			String like = "%" + search.toLowerCase() + "%";
			dq.add(
				RestrictionsFactoryUtil.disjunction(
				).add(
					RestrictionsFactoryUtil.ilike("codeTerminal", like)
				).add(
					RestrictionsFactoryUtil.ilike("adresse", like)
				).add(
					RestrictionsFactoryUtil.ilike("concessionnaireCode", like)
				));
		}
	}

	private Terminal _setStatut(Long terminalId, String statut)
		throws Exception {

		com.df.lonis.ventesservice.model.Terminal entry =
			_terminalLocalService.fetchTerminal(terminalId);

		if (entry == null) {
			throw new NotFoundException("Terminal introuvable: " + terminalId);
		}

		entry.setStatutValidation(statut);
		entry.setUpdatedAt(new Date());
		entry = _terminalLocalService.updateTerminal(entry);

		return _terminalMapper.toDto(entry);
	}

	private static final String _STATUT_EN_ATTENTE = "EN_ATTENTE";
	private static final String _STATUT_REJETE = "REJETE";
	private static final String _STATUT_VALIDE = "VALIDE";

	@Reference
	private TerminalLocalService _terminalLocalService;

	@Reference
	private TerminalMapper _terminalMapper;

	@Reference
	private VisiteLocalService _visiteLocalService;

	@Reference
	private VisiteMapper _visiteMapper;

}
