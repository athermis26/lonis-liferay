package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Commission;
import com.df.lonis.ventesrest.dto.v1_0.CommissionDetail;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;
import com.df.lonis.ventesrest.internal.backend.service.BackendCommissionService;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportColumn;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportResponseUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0.CommissionEntityModel;
import com.df.lonis.ventesrest.resource.v1_0.CommissionResource;

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

/**
 * Implémentation {@link CommissionResource} en proxy vers le backend Spring Boot.
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/commission.properties",
		scope = ServiceScope.PROTOTYPE,
		service = CommissionResource.class
)
public class CommissionResourceImpl extends BaseCommissionResourceImpl {

	private static final int EXPORT_PAGE_SIZE = 10_000;

	@Override
	public Page<Commission> getCommissionsPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts) {

		BackendJsonUtil.Page<Commission> result = _backend.list(
				search,
				pagination.getPage() - 1,
				pagination.getPageSize(),
				PaginationSort.toSortParam(sorts));

		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public CommissionDetail getCommission(Long id) {
		return _backend.getById(id);
	}

	@Override
	public Page<Commission> getConcessionnaireCommissions(Long id, Pagination pagination) {
		BackendJsonUtil.Page<Commission> result = _backend.listByConcessionnaire(
				id,
				pagination.getPage() - 1,
				pagination.getPageSize(),
				null);
		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public Response exportCommissions(String format, Filter filter) throws Exception {
		List<Commission> entries = _backend.list(null, 0, EXPORT_PAGE_SIZE, null).items();

		List<ExportColumn<Commission>> columns = Arrays.asList(
				new ExportColumn<>("Code",         Commission::getCode),
				new ExportColumn<>("Libelle",      Commission::getLibelle),
				new ExportColumn<>("Terminal",     Commission::getCodeTerminal),
				new ExportColumn<>("Nb terminaux", Commission::getNombreTerminaux),
				new ExportColumn<>("Paye",         Commission::getPaye),
				new ExportColumn<>("Statut",       Commission::getStatus),
				new ExportColumn<>("Cree le",      Commission::getCreatedAt));

		return ExportResponseUtil.build(
				format, "commissions", "Commissions", entries, columns);
	}

	@Override
	public EntityModel getEntityModel(Map<String, List<String>> multivaluedMap) {
		return _entityModel;
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Commission>,
					UnsafeFunction<Commission, Commission, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	private final EntityModel _entityModel = new CommissionEntityModel();

	@Reference
	private BackendCommissionService _backend;
}
