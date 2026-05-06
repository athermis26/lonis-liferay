package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Terminal;
import com.df.lonis.reseaurest.dto.v1_0.TerminalPutRequestBody;
import com.df.lonis.reseaurest.dto.v1_0.TerminalRequestBody;
import com.df.lonis.reseaurest.dto.v1_0.Visite;
import com.df.lonis.reseaurest.internal.backend.BackendJsonUtil;
import com.df.lonis.reseaurest.internal.backend.service.BackendTerminalService;
import com.df.lonis.reseaurest.resource.v1_0.TerminalResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Collection;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/terminal.properties",
		scope = ServiceScope.PROTOTYPE,
		service = TerminalResource.class
)
public class TerminalResourceImpl extends BaseTerminalResourceImpl {

	// ─── Liste & CRUD ───

	@Override
	public Page<Terminal> getTerminalsPage(
			Long siteId, String statutValidation, String search, Filter filter,
			Pagination pagination, Sort[] sorts) {

		BackendJsonUtil.Page<Terminal> result = _backend.list(
				siteId, statutValidation, search,
				pagination.getPage() - 1, pagination.getPageSize(),
				ReseauPaginationSort.toSortParam(sorts));
		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public Terminal getTerminal(Long terminalId) {
		return _backend.getById(terminalId);
	}

	@Override
	public Terminal postTerminal(TerminalRequestBody body) {
		return _backend.create(body);
	}

	@Override
	public Terminal putTerminal(Long terminalId, Terminal body) {
		// Le contrat OpenAPI accepte un Terminal complet en PUT — on adapte vers TerminalPutRequestBody.
		TerminalPutRequestBody put = new TerminalPutRequestBody();
		put.setConcessionnaireId(body.getConcessionnaireId());
		put.setSiteId(body.getSiteId());
		put.setLatitude(body.getLatitude());
		put.setLongitude(body.getLongitude());
		put.setAdresse(body.getAdresse());
		return _backend.update(terminalId, put);
	}

	// ─── Validation workflow ───

	@Override
	public Page<Terminal> getTerminalsAValiderPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts) {

		BackendJsonUtil.Page<Terminal> result = _backend.aValider(
				pagination.getPage() - 1, pagination.getPageSize(),
				ReseauPaginationSort.toSortParam(sorts));
		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public Terminal patchTerminalValider(Long terminalId) {
		return _backend.valider(terminalId);
	}

	@Override
	public Terminal patchTerminalRejeter(Long terminalId, Object body) {
		// Le motif arrive comme JSON {"motif":"..."} — on tente de l'extraire si présent.
		String motif = null;
		if (body instanceof java.util.Map) {
			Object v = ((java.util.Map<?, ?>) body).get("motif");
			motif = v == null ? null : v.toString();
		}
		return _backend.rejeter(terminalId, motif);
	}

	// ─── Cartographie ───

	@Override
	public Page<Terminal> getTerminalsCartographie(
			String search, Filter filter, Pagination pagination, Sort[] sorts) {

		BackendJsonUtil.Page<Terminal> result = _backend.cartographie(
				pagination.getPage() - 1, pagination.getPageSize());
		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public Page<Terminal> getTerminalsCartographieTop20(
			String search, Filter filter, Pagination pagination, Sort[] sorts) {

		List<Terminal> top = _backend.cartographieTop20();
		return Page.of(top);
	}

	// ─── Visites d'un terminal ───

	@Override
	public Page<Visite> getTerminalVisitesPage(
			Long terminalId, String search, Filter filter,
			Pagination pagination, Sort[] sorts) {

		List<Visite> visites = _backend.listVisites(terminalId);
		return Page.of(visites);
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Terminal>,
					UnsafeFunction<Terminal, Terminal, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	@Reference
	private BackendTerminalService _backend;
}
