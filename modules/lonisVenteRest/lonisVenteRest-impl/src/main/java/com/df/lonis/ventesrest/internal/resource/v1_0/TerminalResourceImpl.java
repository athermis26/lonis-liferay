package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Terminal;
import com.df.lonis.ventesrest.dto.v1_0.TerminalActivite;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;
import com.df.lonis.ventesrest.internal.backend.service.BackendConcessionnaireService;
import com.df.lonis.ventesrest.internal.backend.service.BackendTerminalService;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportColumn;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportResponseUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0.TerminalEntityModel;
import com.df.lonis.ventesrest.resource.v1_0.TerminalResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/terminal.properties",
		scope = ServiceScope.PROTOTYPE,
		service = TerminalResource.class
)
public class TerminalResourceImpl extends BaseTerminalResourceImpl {

	@Override
	public Page<Terminal> getTerminauxPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts) {

		BackendJsonUtil.Page<Terminal> result = _backend.list(
				search,
				pagination.getPage() - 1,
				pagination.getPageSize(),
				PaginationSort.toSortParam(sorts));
		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public Response exportTerminaux(String format, Filter filter) throws Exception {

		// On récupère toute la liste depuis le backend (pageSize large), puis on délègue à l'exporter.
		List<Terminal> entries = _backend.list(null, 0, 10_000, null).items();

		List<ExportColumn<Terminal>> columns = Arrays.asList(
				new ExportColumn<>("Code Terminal",   Terminal::getCodeTerminal),
				new ExportColumn<>("Concessionnaire", Terminal::getConcessionnaireNomPrenom),
				new ExportColumn<>("Code C.P.",       Terminal::getConcessionnaireProduitCode),
				new ExportColumn<>("Site",            Terminal::getSiteLibelle),
				new ExportColumn<>("Solde",           Terminal::getSolde),
				new ExportColumn<>("Cree le",         Terminal::getCreatedAt));

		return ExportResponseUtil.build(format, "terminaux", "Terminaux", entries, columns);
	}

	@Override
	public Page<Terminal> getConcessionnaireTerminaux(
			Long id, String concessionnaireProduitCode, String dateDebut, String dateFin) {

		List<Terminal> terminaux = _concessionnaireBackend.listTerminaux(
				id, concessionnaireProduitCode, dateDebut, dateFin);
		return Page.of(terminaux);
	}

	@Override
	public Page<TerminalActivite> getTopTerminauxActifs(Integer limit, Filter filter) {
		int n = (limit == null || limit <= 0) ? 10 : limit;
		return Page.of(_backend.topActifs(n));
	}

	@Override
	public EntityModel getEntityModel(Map<String, List<String>> multivaluedMap) {
		return _entityModel;
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Terminal>,
					UnsafeFunction<Terminal, Terminal, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	private final EntityModel _entityModel = new TerminalEntityModel();

	@Reference
	private BackendTerminalService _backend;

	@Reference
	private BackendConcessionnaireService _concessionnaireBackend;
}
