package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Terminal;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportColumn;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportResponseUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.mapper.TerminalMapper;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.GenericODataFilterVisitor;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.ODataFilterApplier;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.ODataFilterUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0.TerminalEntityModel;
import com.df.lonis.ventesrest.resource.v1_0.TerminalResource;

import com.df.lonis.ventesservice.service.ConcessionnaireLocalService;
import com.df.lonis.ventesservice.service.TerminalLocalService;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.filter.FilterParserProvider;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

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

	@Override
	public Page<Terminal> getTerminauxPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		List<GenericODataFilterVisitor.Criterion> criteria =
			ODataFilterUtil.extractCriteria(
				contextUriInfo, _filterParserProvider, _entityModel);

		DynamicQuery dq = _terminalLocalService.dynamicQuery();
		ODataFilterApplier.apply(dq, criteria, _FIELD_TYPES);
		dq.setLimit(
			pagination.getStartPosition(), pagination.getEndPosition());

		List<com.df.lonis.ventesservice.model.Terminal> entries =
			_terminalLocalService.dynamicQuery(dq);

		DynamicQuery countDq = _terminalLocalService.dynamicQuery();
		ODataFilterApplier.apply(countDq, criteria, _FIELD_TYPES);
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
	public Response exportTerminaux(String format, Filter filter)
		throws Exception {

		List<GenericODataFilterVisitor.Criterion> criteria =
			ODataFilterUtil.extractCriteria(
				contextUriInfo, _filterParserProvider, _entityModel);

		DynamicQuery dq = _terminalLocalService.dynamicQuery();
		ODataFilterApplier.apply(dq, criteria, _FIELD_TYPES);

		List<com.df.lonis.ventesservice.model.Terminal> entries =
			_terminalLocalService.dynamicQuery(dq);

		List<ExportColumn<com.df.lonis.ventesservice.model.Terminal>>
			columns = Arrays.asList(
				new ExportColumn<>(
					"Code Terminal",
					com.df.lonis.ventesservice.model.Terminal::getCodeTerminal),
				new ExportColumn<>(
					"Concessionnaire",
					com.df.lonis.ventesservice.model.Terminal::
						getConcessionnaireCode),
				new ExportColumn<>(
					"Code C.P.",
					com.df.lonis.ventesservice.model.Terminal::
						getConcessionnaireProduitCode),
				new ExportColumn<>(
					"Site ID",
					com.df.lonis.ventesservice.model.Terminal::getSiteId),
				new ExportColumn<>(
					"Cree le",
					com.df.lonis.ventesservice.model.Terminal::getCreatedAt));

		return ExportResponseUtil.build(
			format, "terminaux", "Terminaux", entries, columns);
	}

	@Override
	public Page<Terminal> getConcessionnaireTerminaux(
		Long id, String concessionnaireProduitCode, String dateDebut,
		String dateFin) {

		com.df.lonis.ventesservice.model.Concessionnaire c =
			_concessionnaireLocalService.fetchConcessionnaire(id);

		if (c == null) {
			throw new NotFoundException("Concessionnaire introuvable: " + id);
		}

		List<com.df.lonis.ventesservice.model.Terminal> entries =
			_terminalLocalService.findByConcessionnaireId(id);

		return Page.of(
			entries.stream(
			).map(
				_terminalMapper::toDto
			).collect(
				Collectors.toList()
			));
	}

	@Override
	public EntityModel getEntityModel(
		Map<String, List<String>> multivaluedMap) {

		return _entityModel;
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
		UnsafeBiConsumer
			<Collection<Terminal>,
			 UnsafeFunction<Terminal, Terminal, Exception>,
			 Exception> contextBatchUnsafeBiConsumer) {
	}

	private static final Map<String, Class<?>> _FIELD_TYPES = new HashMap<>();

	static {
		_FIELD_TYPES.put("id", Long.class);
		_FIELD_TYPES.put("codeTerminal", String.class);
		_FIELD_TYPES.put("concessionnaireId", Long.class);
		_FIELD_TYPES.put("concessionnaireCode", String.class);
		_FIELD_TYPES.put("produitId", Long.class);
		_FIELD_TYPES.put("siteId", Long.class);
		_FIELD_TYPES.put("concessionnaireProduitCode", String.class);
		_FIELD_TYPES.put("createdAt", Date.class);
	}

	private final EntityModel _entityModel = new TerminalEntityModel();

	@Reference
	private ConcessionnaireLocalService _concessionnaireLocalService;

	@Reference
	private FilterParserProvider _filterParserProvider;

	@Reference
	private TerminalLocalService _terminalLocalService;

	@Reference
	private TerminalMapper _terminalMapper;

}
