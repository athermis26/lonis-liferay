package com.df.lonis.ventesrest.internal.backend.service;

import com.df.lonis.ventesrest.dto.v1_0.Commission;
import com.df.lonis.ventesrest.dto.v1_0.CommissionDetail;
import com.df.lonis.ventesrest.internal.backend.BackendHttpClient;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil.Page;

import com.liferay.portal.kernel.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = BackendCommissionService.class)
public class BackendCommissionService {

	@Reference
	private BackendHttpClient _client;

	public Page<Commission> list(String search, int page, int pageSize, String sort) {
		Map<String, Object> params = new LinkedHashMap<>();
		if (search != null && !search.isBlank()) params.put("search", search);
		params.put("page", page);
		params.put("pageSize", pageSize);
		if (sort != null && !sort.isBlank()) params.put("sort", sort);

		return BackendJsonUtil.page(
				_client.get("/api/v1/commissions", params), BackendCommissionService::toCommission);
	}

	public CommissionDetail getById(long id) {
		return toDetail(BackendJsonUtil.obj(_client.get("/api/v1/commissions/" + id, null)));
	}

	public Page<Commission> listByConcessionnaire(
			long concessionnaireId, int page, int pageSize, String sort) {

		Map<String, Object> params = new LinkedHashMap<>();
		params.put("page", page);
		params.put("pageSize", pageSize);
		if (sort != null && !sort.isBlank()) params.put("sort", sort);

		return BackendJsonUtil.page(
				_client.get("/api/v1/concessionnaires/" + concessionnaireId + "/commissions", params),
				BackendCommissionService::toCommission);
	}

	public static Commission toCommission(JSONObject obj) {
		Commission dto = new Commission();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setCode(BackendJsonUtil.str(obj, "code"));
		dto.setTerminalId(BackendJsonUtil.longVal(obj, "terminalId"));
		dto.setCodeTerminal(BackendJsonUtil.str(obj, "codeTerminal"));
		dto.setNombreTerminaux(BackendJsonUtil.intVal(obj, "nombreTerminaux"));
		dto.setPaye(BackendJsonUtil.bool(obj, "paye"));
		dto.setLibelle(BackendJsonUtil.str(obj, "libelle"));
		dto.setStatus(BackendJsonUtil.str(obj, "status"));
		dto.setCreatedAt(BackendJsonUtil.date(obj, "createdAt"));
		dto.setUpdatedAt(BackendJsonUtil.date(obj, "updatedAt"));
		return dto;
	}

	private static CommissionDetail toDetail(JSONObject obj) {
		CommissionDetail dto = new CommissionDetail();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setCodeTerminal(BackendJsonUtil.str(obj, "codeTerminal"));
		dto.setDateVersement(BackendJsonUtil.date(obj, "dateVersement"));
		dto.setChiffreAffaires(BackendJsonUtil.longVal(obj, "chiffreAffaires"));
		dto.setCommissionVersee(BackendJsonUtil.longVal(obj, "commissionVersee"));
		dto.setTypeVersement(BackendJsonUtil.str(obj, "typeVersement"));
		dto.setCompteReception(BackendJsonUtil.str(obj, "compteReception"));
		dto.setPaye(BackendJsonUtil.bool(obj, "paye"));
		dto.setStatus(BackendJsonUtil.str(obj, "status"));
		return dto;
	}
}
