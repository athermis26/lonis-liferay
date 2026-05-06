package com.df.lonis.ventesrest.internal.backend.service;

import com.df.lonis.ventesrest.dto.v1_0.DashboardKpis;
import com.df.lonis.ventesrest.internal.backend.BackendHttpClient;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;

import com.liferay.portal.kernel.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = BackendDashboardService.class)
public class BackendDashboardService {

	@Reference
	private BackendHttpClient _client;

	public DashboardKpis getKpis(String periode) {
		Map<String, Object> params = new LinkedHashMap<>();
		if (periode != null && !periode.isBlank()) params.put("periode", periode);

		JSONObject obj = BackendJsonUtil.obj(_client.get("/api/v1/dashboard/kpis", params));

		DashboardKpis dto = new DashboardKpis();
		dto.setTotalConcessionnaires(BackendJsonUtil.longVal(obj, "totalConcessionnaires"));
		dto.setTotalPointsDeVente(BackendJsonUtil.longVal(obj, "totalPointsDeVente"));
		dto.setChiffreAffairesTotal(BackendJsonUtil.longVal(obj, "chiffreAffairesTotal"));
		dto.setPaiementsTotal(BackendJsonUtil.longVal(obj, "paiementsTotal"));
		return dto;
	}
}
