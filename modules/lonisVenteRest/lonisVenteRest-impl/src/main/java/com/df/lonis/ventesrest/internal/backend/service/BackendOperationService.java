package com.df.lonis.ventesrest.internal.backend.service;

import com.df.lonis.ventesrest.dto.v1_0.Operation;
import com.df.lonis.ventesrest.dto.v1_0.OperationDetail;
import com.df.lonis.ventesrest.internal.backend.BackendHttpClient;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil.Page;

import com.liferay.portal.kernel.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = BackendOperationService.class)
public class BackendOperationService {

	@Reference
	private BackendHttpClient _client;

	public Page<Operation> list(String search, int page, int pageSize, String sort) {
		Map<String, Object> params = new LinkedHashMap<>();
		if (search != null && !search.isBlank()) params.put("search", search);
		params.put("page", page);
		params.put("pageSize", pageSize);
		if (sort != null && !sort.isBlank()) params.put("sort", sort);

		return BackendJsonUtil.page(
				_client.get("/api/v1/operations", params), BackendOperationService::toOperation);
	}

	public OperationDetail getById(long id) {
		String body = _client.get("/api/v1/operations/" + id, null);
		return toDetail(BackendJsonUtil.obj(body));
	}

	public static Operation toOperation(JSONObject obj) {
		Operation dto = new Operation();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setCode(BackendJsonUtil.str(obj, "code"));
		dto.setReference(BackendJsonUtil.str(obj, "reference"));
		dto.setMontant(BackendJsonUtil.longVal(obj, "montant"));
		dto.setMontantReel(BackendJsonUtil.longVal(obj, "montantReel"));
		dto.setStatut(BackendJsonUtil.str(obj, "statut"));
		dto.setTerminalId(BackendJsonUtil.longVal(obj, "terminalId"));
		dto.setCodeTerminal(BackendJsonUtil.str(obj, "codeTerminal"));
		dto.setGuichet(BackendJsonUtil.str(obj, "guichet"));
		dto.setDateOperation(BackendJsonUtil.date(obj, "dateOperation"));
		dto.setLibelle(BackendJsonUtil.str(obj, "libelle"));
		return dto;
	}

	private static OperationDetail toDetail(JSONObject obj) {
		OperationDetail dto = new OperationDetail();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setCodeOperation(BackendJsonUtil.str(obj, "codeOperation"));
		dto.setCodeTerminal(BackendJsonUtil.str(obj, "codeTerminal"));
		dto.setReference(BackendJsonUtil.str(obj, "reference"));
		dto.setDateHeure(BackendJsonUtil.date(obj, "dateHeure"));
		dto.setLibelle(BackendJsonUtil.str(obj, "libelle"));
		dto.setMontant(BackendJsonUtil.longVal(obj, "montant"));
		dto.setMontantReel(BackendJsonUtil.longVal(obj, "montantReel"));
		dto.setStatut(BackendJsonUtil.str(obj, "statut"));
		dto.setGuichet(BackendJsonUtil.str(obj, "guichet"));
		return dto;
	}
}
