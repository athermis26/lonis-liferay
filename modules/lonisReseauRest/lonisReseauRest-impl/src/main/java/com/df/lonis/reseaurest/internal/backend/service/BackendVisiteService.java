package com.df.lonis.reseaurest.internal.backend.service;

import com.df.lonis.reseaurest.dto.v1_0.Visite;
import com.df.lonis.reseaurest.dto.v1_0.VisiteRequestBody;
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

@Component(immediate = true, service = BackendVisiteService.class)
public class BackendVisiteService {

	@Reference
	private BackendHttpClient _client;

	public Page<Visite> list(
			Long commercialId, Long terminalId, String statut,
			String dateDebut, String dateFin,
			int page, int pageSize, String sort) {

		Map<String, Object> params = new LinkedHashMap<>();
		if (commercialId != null) params.put("commercialId", commercialId);
		if (terminalId != null) params.put("terminalId", terminalId);
		if (statut != null && !statut.isBlank()) params.put("statut", statut);
		if (dateDebut != null) params.put("dateDebut", dateDebut);
		if (dateFin != null) params.put("dateFin", dateFin);
		params.put("page", page);
		params.put("pageSize", pageSize);
		if (sort != null && !sort.isBlank()) params.put("sort", sort);

		return BackendJsonUtil.page(_client.get("/api/v1/visites", params), this::toVisite);
	}

	public Visite getById(long id) {
		return toVisite(BackendJsonUtil.obj(_client.get("/api/v1/visites/" + id, null)));
	}

	public Visite create(VisiteRequestBody body) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("commercialId", body.getCommercialId());
		json.put("terminalId", body.getTerminalId());
		if (body.getLatitude() != null) json.put("latitude", body.getLatitude());
		if (body.getLongitude() != null) json.put("longitude", body.getLongitude());
		if (body.getStatut() != null) json.put("statut", body.getStatut().getValue());
		if (body.getTypeControle() != null) json.put("typeControle", body.getTypeControle().getValue());
		if (body.getDateVisite() != null) json.put("dateVisite", body.getDateVisite().toInstant().toString());
		if (body.getCompteRendu() != null) json.put("compteRendu", body.getCompteRendu());
		return toVisite(BackendJsonUtil.obj(_client.post("/api/v1/visites", json.toString())));
	}

	public List<Visite> tempsReel() {
		return BackendJsonUtil.list(_client.get("/api/v1/visites/temps-reel", null), this::toVisite);
	}

	public List<Visite> listByCommercial(long commercialId) {
		return BackendJsonUtil.list(
				_client.get("/api/v1/commerciaux/" + commercialId + "/visites", null),
				this::toVisite);
	}

	public List<Visite> planning(long commercialId) {
		return BackendJsonUtil.list(
				_client.get("/api/v1/commerciaux/" + commercialId + "/visites/planning", null),
				this::toVisite);
	}

	public Visite toVisite(JSONObject obj) {
		if (obj == null) return null;
		Visite dto = new Visite();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setCommercialId(BackendJsonUtil.longVal(obj, "commercialId"));
		dto.setTerminalId(BackendJsonUtil.longVal(obj, "terminalId"));
		dto.setLatitude(BackendJsonUtil.dbl(obj, "latitude"));
		dto.setLongitude(BackendJsonUtil.dbl(obj, "longitude"));

		String statut = BackendJsonUtil.str(obj, "statut");
		if (statut != null) {
			try { dto.setStatut(Visite.Statut.create(statut)); } catch (IllegalArgumentException ignored) {}
		}
		String tc = BackendJsonUtil.str(obj, "typeControle");
		if (tc != null) {
			try { dto.setTypeControle(Visite.TypeControle.create(tc)); } catch (IllegalArgumentException ignored) {}
		}
		dto.setDateVisite(BackendJsonUtil.date(obj, "dateVisite"));
		dto.setCompteRendu(BackendJsonUtil.str(obj, "compteRendu"));
		return dto;
	}
}
