package com.df.lonis.reseaurest.internal.backend.service;

import com.df.lonis.reseaurest.dto.v1_0.Commercial;
import com.df.lonis.reseaurest.dto.v1_0.CommercialRequestBody;
import com.df.lonis.reseaurest.internal.backend.BackendHttpClient;
import com.df.lonis.reseaurest.internal.backend.BackendJsonUtil;
import com.df.lonis.reseaurest.internal.backend.BackendJsonUtil.Page;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = BackendCommercialService.class)
public class BackendCommercialService {

	@Reference
	private BackendHttpClient _client;

	public Page<Commercial> list(
			Long superviseurId, String search, int page, int pageSize, String sort) {

		Map<String, Object> params = new LinkedHashMap<>();
		if (superviseurId != null) params.put("superviseurId", superviseurId);
		if (search != null && !search.isBlank()) params.put("search", search);
		params.put("page", page);
		params.put("pageSize", pageSize);
		if (sort != null && !sort.isBlank()) params.put("sort", sort);

		return BackendJsonUtil.page(_client.get("/api/v1/commerciaux", params), BackendCommercialService::toCommercial);
	}

	public Commercial getById(long id) {
		return toCommercial(BackendJsonUtil.obj(_client.get("/api/v1/commerciaux/" + id, null)));
	}

	public Commercial create(CommercialRequestBody body) {
		return toCommercial(BackendJsonUtil.obj(_client.post("/api/v1/commerciaux", toJson(body).toString())));
	}

	public Commercial update(long id, Commercial body) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("nom", body.getNom());
		json.put("prenoms", body.getPrenoms());
		json.put("telephone", body.getTelephone());
		json.put("email", body.getEmail());
		json.put("matricule", body.getMatricule());
		json.put("statut", body.getStatut());
		if (body.getSuperviseurId() != null) json.put("superviseurId", body.getSuperviseurId());
		return toCommercial(BackendJsonUtil.obj(_client.put("/api/v1/commerciaux/" + id, json.toString())));
	}

	public void delete(long id) {
		_client.delete("/api/v1/commerciaux/" + id);
	}

	private static JSONObject toJson(CommercialRequestBody body) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("nom", body.getNom());
		json.put("prenoms", body.getPrenoms());
		json.put("telephone", body.getTelephone());
		json.put("email", body.getEmail());
		json.put("matricule", body.getMatricule());
		json.put("statut", body.getStatut());
		if (body.getSuperviseurId() != null) json.put("superviseurId", body.getSuperviseurId());
		return json;
	}

	public static Commercial toCommercial(JSONObject obj) {
		if (obj == null) return null;
		Commercial dto = new Commercial();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setNom(BackendJsonUtil.str(obj, "nom"));
		dto.setPrenoms(BackendJsonUtil.str(obj, "prenoms"));
		dto.setTelephone(BackendJsonUtil.str(obj, "telephone"));
		dto.setEmail(BackendJsonUtil.str(obj, "email"));
		dto.setMatricule(BackendJsonUtil.str(obj, "matricule"));
		dto.setStatut(BackendJsonUtil.str(obj, "statut"));
		dto.setSuperviseurId(BackendJsonUtil.longVal(obj, "superviseurId"));
		dto.setAgenceId(BackendJsonUtil.longVal(obj, "agenceId"));
		return dto;
	}
}
