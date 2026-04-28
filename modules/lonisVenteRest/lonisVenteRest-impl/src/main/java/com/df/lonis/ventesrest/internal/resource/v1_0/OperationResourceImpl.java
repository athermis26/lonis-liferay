package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Operation;
import com.df.lonis.ventesrest.dto.v1_0.OperationDetail;
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
				entries.stream().map(this::_toDto).collect(Collectors.toList()), pagination, _operationLocalService.getOperationsCount()
		);
	}

	@Override
	public OperationDetail getOperation(Long operationId) throws Exception {
		com.df.lonis.ventesservice.model.Operation entry = _operationLocalService.getOperation(operationId);

		if (entry == null) {
			throw new NotFoundException("Opération non trouvée !");
		}

        return _toDtoDetail(entry);
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Operation>, UnsafeFunction<Operation, Operation, Exception>, Exception> contextBatchUnsafeBiConsumer) {

	}

	private Operation _toDto(com.df.lonis.ventesservice.model.Operation entry) {
		Operation dto = new Operation();
		dto.setId(entry.getId());
		dto.setCode(entry.getCode());
		dto.setLibelle(entry.getLibelle());
		dto.setReference(entry.getReference());
		dto.setMontant(entry.getMontant());
		dto.setMontantReel(entry.getMontantReel());
		dto.setStatut(entry.getStatut());
		dto.setTerminalId(entry.getTerminalId());
		dto.setGuichet(entry.getGuichet());
		dto.setDateOperation(entry.getDateOperation());

		return dto;
	}

	private OperationDetail _toDtoDetail(com.df.lonis.ventesservice.model.Operation entry) {
		OperationDetail operationDetail = new OperationDetail();
		operationDetail.setId(entry.getId());
		operationDetail.setCodeOperation(entry.getCode());
		operationDetail.setLibelle(entry.getLibelle());
		operationDetail.setReference(entry.getReference());
		operationDetail.setMontant(entry.getMontant());
		operationDetail.setMontantReel(entry.getMontantReel());
		operationDetail.setStatut(entry.getStatut());
		operationDetail.setGuichet(entry.getGuichet());
		operationDetail.setDateHeure(entry.getDateOperation());

		return operationDetail;
	}

	@Reference
	private OperationLocalService _operationLocalService;
}