package com.df.lonis.ventesrest.internal.backend.service;

import com.df.lonis.ventesrest.dto.v1_0.Site;
import com.df.lonis.ventesrest.internal.backend.BackendHttpClient;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil.Page;

import com.liferay.portal.kernel.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = BackendSiteService.class)
public class BackendSiteService {

	@Reference
	private BackendHttpClient _client;

	public Page<Site> list(String search, int page, int pageSize, String sort) {
		Map<String, Object> params = new LinkedHashMap<>();
		if (search != null && !search.isBlank()) params.put("search", search);
		params.put("page", page);
		params.put("pageSize", pageSize);
		if (sort != null && !sort.isBlank()) params.put("sort", sort);

		return BackendJsonUtil.page(_client.get("/api/v1/sites", params), BackendSiteService::toSite);
	}

	public List<Site> listAll() {
		return BackendJsonUtil.list(_client.get("/api/v1/sites-all", null), BackendSiteService::toSite);
	}

	public static Site toSite(JSONObject obj) {
		if (obj == null) return null;
		Site dto = new Site();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setLibelle(BackendJsonUtil.str(obj, "libelle"));
		dto.setType(BackendJsonUtil.intVal(obj, "type"));
		dto.setParentId(BackendJsonUtil.longVal(obj, "parentId"));
		dto.setCode(BackendJsonUtil.str(obj, "code"));
		dto.setCodeProvince(BackendJsonUtil.str(obj, "codeProvince"));
		dto.setStatus(BackendJsonUtil.bool(obj, "status"));
		dto.setCreatedAt(BackendJsonUtil.date(obj, "createdAt"));
		dto.setUpdatedAt(BackendJsonUtil.date(obj, "updatedAt"));
		return dto;
	}
}
