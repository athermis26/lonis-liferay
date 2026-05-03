package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Operation;
import com.df.lonis.ventesrest.dto.v1_0.OperationDetail;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportColumn;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportResponseUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.mapper.OperationMapper;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.GenericODataFilterVisitor;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.ODataFilterApplier;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.ODataFilterUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0.OperationEntityModel;
import com.df.lonis.ventesrest.resource.v1_0.OperationResource;

import com.df.lonis.ventesservice.service.OperationLocalService;

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
	properties = "OSGI-INF/liferay/rest/v1_0/operation.properties",
	scope = ServiceScope.PROTOTYPE, service = OperationResource.class
)
public class OperationResourceImpl extends BaseOperationResourceImpl {

	@Override
	public Page<Operation> getOperationsPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		List<GenericODataFilterVisitor.Criterion> criteria =
			ODataFilterUtil.extractCriteria(
				contextUriInfo, _filterParserProvider, _entityModel);

		DynamicQuery dq = _operationLocalService.dynamicQuery();
		ODataFilterApplier.apply(dq, criteria, _FIELD_TYPES);
		dq.setLimit(
			pagination.getStartPosition(), pagination.getEndPosition());

		List<com.df.lonis.ventesservice.model.Operation> entries =
			_operationLocalService.dynamicQuery(dq);

		DynamicQuery countDq = _operationLocalService.dynamicQuery();
		ODataFilterApplier.apply(countDq, criteria, _FIELD_TYPES);
		long total = _operationLocalService.dynamicQueryCount(countDq);

		return Page.of(
			entries.stream(
			).map(
				_operationMapper::toDto
			).collect(
				Collectors.toList()
			),
			pagination, total);
	}

	@Override
	public Response exportOperations(String format, Filter filter)
		throws Exception {

		List<GenericODataFilterVisitor.Criterion> criteria =
			ODataFilterUtil.extractCriteria(
				contextUriInfo, _filterParserProvider, _entityModel);

		DynamicQuery dq = _operationLocalService.dynamicQuery();
		ODataFilterApplier.apply(dq, criteria, _FIELD_TYPES);

		List<com.df.lonis.ventesservice.model.Operation> entries =
			_operationLocalService.dynamicQuery(dq);

		List<ExportColumn<com.df.lonis.ventesservice.model.Operation>>
			columns = Arrays.asList(
				new ExportColumn<>(
					"Code", com.df.lonis.ventesservice.model.Operation::getCode),
				new ExportColumn<>(
					"Reference",
					com.df.lonis.ventesservice.model.Operation::getReference),
				new ExportColumn<>(
					"Montant",
					com.df.lonis.ventesservice.model.Operation::getMontant),
				new ExportColumn<>(
					"Montant reel",
					com.df.lonis.ventesservice.model.Operation::getMontantReel),
				new ExportColumn<>(
					"Statut",
					com.df.lonis.ventesservice.model.Operation::getStatut),
				new ExportColumn<>(
					"Terminal",
					com.df.lonis.ventesservice.model.Operation::getTerminalId),
				new ExportColumn<>(
					"Guichet",
					com.df.lonis.ventesservice.model.Operation::getGuichet),
				new ExportColumn<>(
					"Date",
					com.df.lonis.ventesservice.model.Operation::
						getDateOperation));

		return ExportResponseUtil.build(
			format, "operations", "Operations", entries, columns);
	}

	@Override
	public OperationDetail getOperation(Long operationId) throws Exception {
		com.df.lonis.ventesservice.model.Operation entry =
			_operationLocalService.fetchOperation(operationId);

		if (entry == null) {
			throw new NotFoundException(
				"Operation introuvable: " + operationId);
		}

		return _operationMapper.toDtoDetail(entry);
	}

	@Override
	public EntityModel getEntityModel(
		Map<String, List<String>> multivaluedMap) {

		return _entityModel;
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
		UnsafeBiConsumer
			<Collection<Operation>,
			 UnsafeFunction<Operation, Operation, Exception>,
			 Exception> contextBatchUnsafeBiConsumer) {
	}

	private static final Map<String, Class<?>> _FIELD_TYPES = new HashMap<>();

	static {
		_FIELD_TYPES.put("id", Long.class);
		_FIELD_TYPES.put("code", String.class);
		_FIELD_TYPES.put("reference", String.class);
		_FIELD_TYPES.put("montant", Long.class);
		_FIELD_TYPES.put("montantReel", Long.class);
		_FIELD_TYPES.put("statut", String.class);
		_FIELD_TYPES.put("terminalId", Long.class);
		_FIELD_TYPES.put("guichet", String.class);
		_FIELD_TYPES.put("dateOperation", Date.class);
	}

	private final EntityModel _entityModel = new OperationEntityModel();

	@Reference
	private FilterParserProvider _filterParserProvider;

	@Reference
	private OperationLocalService _operationLocalService;

	@Reference
	private OperationMapper _operationMapper;

}
