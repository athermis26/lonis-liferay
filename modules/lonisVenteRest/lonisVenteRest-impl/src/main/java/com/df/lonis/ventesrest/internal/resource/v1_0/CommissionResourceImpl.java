package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Commission;
import com.df.lonis.ventesrest.dto.v1_0.CommissionDetail;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportColumn;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportResponseUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.mapper.CommissionMapper;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.mapper.TerminalMapper;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.GenericODataFilterVisitor;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.ODataFilterApplier;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.ODataFilterUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0.CommissionEntityModel;
import com.df.lonis.ventesrest.resource.v1_0.CommissionResource;

import com.df.lonis.ventesservice.model.Concessionnaire;
import com.df.lonis.ventesservice.service.CommissionLocalService;
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
	properties = "OSGI-INF/liferay/rest/v1_0/commission.properties",
	scope = ServiceScope.PROTOTYPE, service = CommissionResource.class
)
public class CommissionResourceImpl extends BaseCommissionResourceImpl {

	@Override
	public Page<Commission> getCommissionsPage(String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		List<GenericODataFilterVisitor.Criterion> criteria =
			ODataFilterUtil.extractCriteria(
				contextUriInfo, _filterParserProvider, _entityModel);

		DynamicQuery dq = _commissionLocalService.dynamicQuery();
		ODataFilterApplier.apply(dq, criteria, _FIELD_TYPES);
		dq.setLimit(
			pagination.getStartPosition(), pagination.getEndPosition());

		List<com.df.lonis.ventesservice.model.Commission> entries =
			_commissionLocalService.dynamicQuery(dq);

		DynamicQuery countDq = _commissionLocalService.dynamicQuery();
		ODataFilterApplier.apply(countDq, criteria, _FIELD_TYPES);
		long total = _commissionLocalService.dynamicQueryCount(countDq);

		return Page.of(
			entries.stream(
			).map(
				_commissionMapper::toDto
			).collect(
				Collectors.toList()
			),
			pagination, total);
	}

	@Override
	public CommissionDetail getCommission(Long id) {
		com.df.lonis.ventesservice.model.Commission commission = _commissionLocalService.fetchCommission(id);

		if (commission == null) {
			throw new NotFoundException("Commission introuvable: " + id);
		}

		return _commissionMapper.toDtoDetail(commission);
	}

	@Override
	public Response exportCommissions(String format, Filter filter)
		throws Exception {

		List<GenericODataFilterVisitor.Criterion> criteria =
			ODataFilterUtil.extractCriteria(
				contextUriInfo, _filterParserProvider, _entityModel);

		DynamicQuery dq = _commissionLocalService.dynamicQuery();
		ODataFilterApplier.apply(dq, criteria, _FIELD_TYPES);

		List<com.df.lonis.ventesservice.model.Commission> entries =
			_commissionLocalService.dynamicQuery(dq);

		List<ExportColumn<com.df.lonis.ventesservice.model.Commission>>
			columns = Arrays.asList(
				new ExportColumn<>(
					"Code",
					com.df.lonis.ventesservice.model.Commission::getCode),
				new ExportColumn<>(
					"Libelle",
					com.df.lonis.ventesservice.model.Commission::getLibelle),
				new ExportColumn<>(
					"Terminal ID",
					com.df.lonis.ventesservice.model.Commission::getTerminalId),
				new ExportColumn<>(
					"Nb terminaux",
					com.df.lonis.ventesservice.model.Commission::
						getNombreTerminal),
				new ExportColumn<>(
					"Paye",
					com.df.lonis.ventesservice.model.Commission::getPaye),
				new ExportColumn<>(
					"Statut",
					com.df.lonis.ventesservice.model.Commission::getStatus),
				new ExportColumn<>(
					"Cree le",
					com.df.lonis.ventesservice.model.Commission::getCreatedAt));

		return ExportResponseUtil.build(
			format, "commissions", "Commissions", entries, columns);
	}

	@Override
	public Page<Commission> getConcessionnaireCommissions(
			Long id, Pagination pagination)
		throws Exception {

		Concessionnaire concessionnaire =
			_concessionnaireLocalService.fetchConcessionnaire(id);

		if (concessionnaire == null) {
			throw new NotFoundException("Concessionnaire introuvable: " + id);
		}

		// Logique a brancher quand on aura un finder commission par
		// concessionnaire (via terminalIds par exemple).
		return Page.of(java.util.Collections.emptyList(), pagination, 0);
	}

	@Override
	public EntityModel getEntityModel(
		Map<String, List<String>> multivaluedMap) {

		return _entityModel;
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
		UnsafeBiConsumer
			<Collection<Commission>,
			 UnsafeFunction<Commission, Commission, Exception>,
			 Exception> contextBatchUnsafeBiConsumer) {
	}

	private static final Map<String, Class<?>> _FIELD_TYPES = new HashMap<>();

	static {
		_FIELD_TYPES.put("id", Long.class);
		_FIELD_TYPES.put("code", String.class);
		_FIELD_TYPES.put("terminalId", Long.class);
		_FIELD_TYPES.put("status", String.class);
		_FIELD_TYPES.put("paye", Boolean.class);
		_FIELD_TYPES.put("createdAt", Date.class);
	}

	private final EntityModel _entityModel = new CommissionEntityModel();

	@Reference
	private CommissionMapper _commissionMapper;

	@Reference
	private CommissionLocalService _commissionLocalService;

	@Reference
	private ConcessionnaireLocalService _concessionnaireLocalService;

	@Reference
	private FilterParserProvider _filterParserProvider;

	@Reference
	private TerminalMapper _terminalMapper;

	@Reference
	private TerminalLocalService _terminalLocalService;
}
