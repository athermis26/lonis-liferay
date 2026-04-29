package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Operation;
import com.df.lonis.ventesrest.dto.v1_0.OperationDetail;
import com.df.lonis.ventesrest.internal.resource.v1_0.mapper.OperationMapper;
import com.df.lonis.ventesrest.resource.v1_0.OperationResource;

import com.df.lonis.ventesservice.service.OperationLocalService;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.ws.rs.NotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/operation.properties",
	scope = ServiceScope.PROTOTYPE, service = OperationResource.class
)
public class OperationResourceImpl extends BaseOperationResourceImpl {
	@Override
	public Page<Operation> getOperationsPage(String search, Long siteId, String periode, Pagination pagination) throws Exception {
		List<com.df.lonis.ventesservice.model.Operation> entries = _operationLocalService.getOperations(pagination.getStartPosition(), pagination.getEndPosition());

		return Page.of(
				entries.stream().map(_operationMapper::toDto).collect(Collectors.toList()), pagination, _operationLocalService.getOperationsCount()
		);
	}

	@Override
	public OperationDetail getOperation(Long operationId) throws Exception {
		com.df.lonis.ventesservice.model.Operation entry = _operationLocalService.getOperation(operationId);

		if (entry == null) {
			throw new NotFoundException("Opération non trouvée !");
		}

        return _operationMapper.toDtoDetail(entry);
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Operation>, UnsafeFunction<Operation, Operation, Exception>, Exception> contextBatchUnsafeBiConsumer) {

	}

	@Reference
	private OperationMapper _operationMapper;

	@Reference
	private OperationLocalService _operationLocalService;
}