package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Operation;
import com.df.lonis.ventesrest.dto.v1_0.OperationDetail;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;
import com.df.lonis.ventesrest.internal.backend.service.BackendOperationService;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportColumn;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportResponseUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0.OperationEntityModel;
import com.df.lonis.ventesrest.resource.v1_0.OperationResource;

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
 * Implémentation {@link OperationResource} en proxy vers le backend Spring Boot.
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/operation.properties",
		scope = ServiceScope.PROTOTYPE,
		service = OperationResource.class
)
public class OperationResourceImpl extends BaseOperationResourceImpl {

	private static final int EXPORT_PAGE_SIZE = 10_000;

	@Override
	public Page<Operation> getOperationsPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts) {

		BackendJsonUtil.Page<Operation> result = _backend.list(
				search,
				pagination.getPage() - 1,
				pagination.getPageSize(),
				PaginationSort.toSortParam(sorts));

		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public OperationDetail getOperation(Long operationId) {
		return _backend.getById(operationId);
	}

	@Override
	public Response exportOperations(String format, Filter filter) throws Exception {
		List<Operation> entries = _backend.list(null, 0, EXPORT_PAGE_SIZE, null).items();

		List<ExportColumn<Operation>> columns = Arrays.asList(
				new ExportColumn<>("Code",         Operation::getCode),
				new ExportColumn<>("Reference",    Operation::getReference),
				new ExportColumn<>("Montant",      Operation::getMontant),
				new ExportColumn<>("Montant reel", Operation::getMontantReel),
				new ExportColumn<>("Statut",       Operation::getStatut),
				new ExportColumn<>("Terminal",     Operation::getCodeTerminal),
				new ExportColumn<>("Guichet",      Operation::getGuichet),
				new ExportColumn<>("Date",         Operation::getDateOperation));

		return ExportResponseUtil.build(
				format, "operations", "Operations", entries, columns);
	}

	@Override
	public EntityModel getEntityModel(Map<String, List<String>> multivaluedMap) {
		return _entityModel;
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Operation>,
					UnsafeFunction<Operation, Operation, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	private final EntityModel _entityModel = new OperationEntityModel();

	@Reference
	private BackendOperationService _backend;
}
