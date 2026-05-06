package com.df.lonis.reseaurest.internal.backend.service;

import com.df.lonis.reseaurest.dto.v1_0.Objectif;
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

@Component(immediate = true, service = BackendObjectifService.class)
public class BackendObjectifService {

	@Reference
	private BackendHttpClient _client;

	public Page<Objectif> list(
			Long commercialId, Integer annee, Integer mois,
			int page, int pageSize, String sort) {

		Map<String, Object> params = new LinkedHashMap<>();
		if (commercialId != null) params.put("commercialId", commercialId);
		if (annee != null) params.put("annee", annee);
		if (mois != null) params.put("mois", mois);
		params.put("page", page);
		params.put("pageSize", pageSize);
		if (sort != null && !sort.isBlank()) params.put("sort", sort);
		return BackendJsonUtil.page(
				_client.get("/api/v1/objectifs", params), BackendObjectifService::toObjectif);
	}

	public Objectif create(Objectif body) {
		return toObjectif(BackendJsonUtil.obj(_client.post("/api/v1/objectifs", toJson(body).toString())));
	}

	public Objectif update(long id, Objectif body) {
		return toObjectif(BackendJsonUtil.obj(_client.put("/api/v1/objectifs/" + id, toJson(body).toString())));
	}

	public List<Objectif> listByCommercial(long commercialId) {
		return BackendJsonUtil.list(
				_client.get("/api/v1/commerciaux/" + commercialId + "/objectifs", null),
				BackendObjectifService::toObjectif);
	}

	private static JSONObject toJson(Objectif body) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		if (body.getCommercialId() != null) json.put("commercialId", body.getCommercialId());
		if (body.getType() != null) json.put("type", body.getType().getValue());
		if (body.getPeriode() != null) json.put("periode", body.getPeriode().getValue());
		if (body.getValeurCible() != null) json.put("valeurCible", body.getValeurCible());
		if (body.getValeurReelle() != null) json.put("valeurReelle", body.getValeurReelle());
		if (body.getMois() != null) json.put("mois", body.getMois());
		if (body.getTrimestre() != null) json.put("trimestre", body.getTrimestre());
		if (body.getAnnee() != null) json.put("annee", body.getAnnee());
		return json;
	}

	public static Objectif toObjectif(JSONObject obj) {
		if (obj == null) return null;
		Objectif dto = new Objectif();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setCommercialId(BackendJsonUtil.longVal(obj, "commercialId"));

		String type = BackendJsonUtil.str(obj, "type");
		if (type != null) {
			try { dto.setType(Objectif.Type.create(type)); } catch (IllegalArgumentException ignored) {}
		}
		String periode = BackendJsonUtil.str(obj, "periode");
		if (periode != null) {
			try { dto.setPeriode(Objectif.Periode.create(periode)); } catch (IllegalArgumentException ignored) {}
		}

		dto.setValeurCible(BackendJsonUtil.intVal(obj, "valeurCible"));
		dto.setValeurReelle(BackendJsonUtil.intVal(obj, "valeurReelle"));
		dto.setMois(BackendJsonUtil.intVal(obj, "mois"));
		dto.setTrimestre(BackendJsonUtil.intVal(obj, "trimestre"));
		dto.setAnnee(BackendJsonUtil.intVal(obj, "annee"));
		return dto;
	}
}
