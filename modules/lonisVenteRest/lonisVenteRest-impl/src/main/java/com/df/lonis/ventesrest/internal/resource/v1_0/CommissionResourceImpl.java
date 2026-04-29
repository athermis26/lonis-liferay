package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Commission;
import com.df.lonis.ventesrest.dto.v1_0.CommissionDetail;
import com.df.lonis.ventesrest.resource.v1_0.CommissionResource;

import com.df.lonis.ventesservice.model.Concessionnaire;
import com.df.lonis.ventesservice.service.CommissionLocalService;
import com.df.lonis.ventesservice.service.ConcessionnaireLocalService;
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
	properties = "OSGI-INF/liferay/rest/v1_0/commission.properties",
	scope = ServiceScope.PROTOTYPE, service = CommissionResource.class
)
public class CommissionResourceImpl extends BaseCommissionResourceImpl {

	@Override
	public Page<Commission> getCommissionsPage(String search, Long siteId, String periode, Pagination pagination) throws Exception {
		List<com.df.lonis.ventesservice.model.Commission> entries = _commissionLocalService.getCommissions(
				pagination.getStartPosition(),
				pagination.getEndPosition()
		);

		int total = _commissionLocalService.getCommissionsCount();

		return Page.of(
				entries.stream().map(this::_toDto).collect(Collectors.toList()), pagination, total
		);
	}

	@Override
	public CommissionDetail getCommission(Long id) throws Exception {
		com.df.lonis.ventesservice.model.Commission commission = _commissionLocalService.fetchCommission(id);

		if (commission == null) {
			throw new NotFoundException("Commission introuvable: " + id);
		}

//		return super.getCommission(id);
		return _toDtoDetail(commission);
	}

	@Override
	public Commission getConcessionnaireCommissions(String uid, String concessionnaireProduitCode, String periode, Pagination pagination) throws Exception {
		Concessionnaire concessionnaire = _concessionnaireLocalService.fetchByUid(uid);

		if (concessionnaire == null) {
			throw new NotFoundException("Concessionnaire introuvable: " + uid);
		}

//		List<com.df.lonis.ventesservice.model.Commission> commissions = _commissionLocalService.

		return super.getConcessionnaireCommissions(uid, concessionnaireProduitCode, periode, pagination);
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Commission>, UnsafeFunction<Commission, Commission, Exception>, Exception> contextBatchUnsafeBiConsumer) {

	}

	// ───────── DTO mappers ─────────

	private Commission _toDto(com.df.lonis.ventesservice.model.Commission commission) {
		Commission dto = new Commission();
		dto.setId(commission.getId());
		dto.setCode(commission.getCode());
		dto.setLibelle(commission.getLibelle());
		dto.setTerminalId(commission.getTerminalId());
		dto.setNombreTerminaux(commission.getNombreTerminal());
		dto.setPaye(commission.getPaye());
		dto.setStatus(commission.getStatus());
		dto.setCreatedAt(commission.getCreatedAt());


		return dto;
	}

	private CommissionDetail _toDtoDetail(com.df.lonis.ventesservice.model.Commission commission) {
		CommissionDetail dto = new CommissionDetail();
		dto.setId(commission.getId());
//		dto.setCodeTerminal(commission.getCode());
		dto.setPaye(commission.getPaye());
		dto.setStatus(commission.getStatus());

		return dto;
	}

	@Reference
	private CommissionLocalService _commissionLocalService;

	@Reference
	private ConcessionnaireLocalService _concessionnaireLocalService;
}