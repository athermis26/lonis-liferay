package com.df.lonis.ventesrest.internal.backend.service;

import com.df.lonis.ventesrest.dto.v1_0.ChiffreAffaire;
import com.df.lonis.ventesrest.internal.backend.BackendHttpClient;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil.Page;

import com.liferay.portal.kernel.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = BackendChiffreAffairesService.class)
public class BackendChiffreAffairesService {

	@Reference
	private BackendHttpClient _client;

	public Page<ChiffreAffaire> list(String search, int page, int pageSize, String sort) {
		Map<String, Object> params = new LinkedHashMap<>();
		if (search != null && !search.isBlank()) params.put("search", search);
		params.put("page", page);
		params.put("pageSize", pageSize);
		if (sort != null && !sort.isBlank()) params.put("sort", sort);

		return BackendJsonUtil.page(
				_client.get("/api/v1/chiffres-affaires", params),
				BackendChiffreAffairesService::toChiffreAffaire);
	}

	public static ChiffreAffaire toChiffreAffaire(JSONObject obj) {
		ChiffreAffaire dto = new ChiffreAffaire();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setCodeTerminal(BackendJsonUtil.str(obj, "codeTerminal"));
		dto.setConcessionnaireNomPrenom(BackendJsonUtil.str(obj, "concessionnaireNomPrenom"));
		dto.setCodeProduit(BackendJsonUtil.str(obj, "codeProduit"));
		dto.setProduitType(BackendJsonUtil.str(obj, "produitType"));
		dto.setSite(BackendJsonUtil.str(obj, "site"));
		dto.setBrut(BackendJsonUtil.longVal(obj, "brut"));
		dto.setPaiement(BackendJsonUtil.longVal(obj, "paiement"));
		dto.setAnnulation(BackendJsonUtil.longVal(obj, "annulation"));
		dto.setRembourcement(BackendJsonUtil.longVal(obj, "rembourcement"));
		dto.setVentes(BackendJsonUtil.longVal(obj, "ventes"));
		dto.setBalance(BackendJsonUtil.longVal(obj, "balance"));
		dto.setDeposite(BackendJsonUtil.longVal(obj, "deposite"));
		dto.setChiffreAffaire(BackendJsonUtil.longVal(obj, "chiffreAffaire"));
		dto.setDate(BackendJsonUtil.date(obj, "date"));
		dto.setCreatedAt(BackendJsonUtil.date(obj, "createdAt"));
		dto.setUpdatedAt(BackendJsonUtil.date(obj, "updatedAt"));
		return dto;
	}
}
