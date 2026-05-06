package com.df.lonis.reseaurest.internal.backend.service;

import com.df.lonis.reseaurest.dto.v1_0.SiteCommercial;
import com.df.lonis.reseaurest.internal.backend.BackendHttpClient;
import com.df.lonis.reseaurest.internal.backend.BackendJsonUtil;
import com.df.lonis.reseaurest.internal.backend.BackendJsonUtil.Page;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = BackendSiteCommercialService.class)
public class BackendSiteCommercialService {

	@Reference
	private BackendHttpClient _client;

	public List<SiteCommercial> listByCommercial(long commercialId) {
		return BackendJsonUtil.list(
				_client.get("/api/v1/commerciaux/" + commercialId + "/sites", null),
				BackendSiteCommercialService::toSiteCommercial);
	}

	public SiteCommercial create(long commercialId, SiteCommercial body) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("siteId", body.getSiteId());
		json.put("commercialId", commercialId);
		if (body.getDateDebut() != null) json.put("dateDebut", body.getDateDebut().toInstant().toString().substring(0, 10));
		if (body.getDateFin() != null) json.put("dateFin", body.getDateFin().toInstant().toString().substring(0, 10));
		if (body.getIsPrincipal() != null) json.put("isPrincipal", body.getIsPrincipal());

		return toSiteCommercial(BackendJsonUtil.obj(
				_client.post("/api/v1/commerciaux/" + commercialId + "/sites", json.toString())));
	}

	public void deleteAffectation(long commercialId, long siteId) {
		_client.delete("/api/v1/commerciaux/" + commercialId + "/sites/" + siteId);
	}

	public Page<SiteCommercial> listBySite(long siteId, int page, int pageSize) {
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("page", page);
		params.put("pageSize", pageSize);
		return BackendJsonUtil.page(
				_client.get("/api/v1/sites/" + siteId + "/commerciaux", params),
				BackendSiteCommercialService::toSiteCommercial);
	}

	public static SiteCommercial toSiteCommercial(JSONObject obj) {
		if (obj == null) return null;
		SiteCommercial dto = new SiteCommercial();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setSiteId(BackendJsonUtil.longVal(obj, "siteId"));
		dto.setCommercialId(BackendJsonUtil.longVal(obj, "commercialId"));
		dto.setDateDebut(BackendJsonUtil.date(obj, "dateDebut"));
		dto.setDateFin(BackendJsonUtil.date(obj, "dateFin"));
		dto.setIsPrincipal(BackendJsonUtil.bool(obj, "isPrincipal"));
		return dto;
	}
}
