package com.df.lonis.reseaurest.internal.backend.service;

import com.df.lonis.reseaurest.dto.v1_0.Terminal;
import com.df.lonis.reseaurest.dto.v1_0.TerminalPutRequestBody;
import com.df.lonis.reseaurest.dto.v1_0.TerminalRequestBody;
import com.df.lonis.reseaurest.dto.v1_0.Visite;
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

@Component(immediate = true, service = BackendTerminalService.class)
public class BackendTerminalService {

	@Reference
	private BackendHttpClient _client;

	@Reference
	private BackendVisiteService _visiteService;

	public Page<Terminal> list(
			Long siteId, String statutValidation, String search,
			int page, int pageSize, String sort) {

		Map<String, Object> params = new LinkedHashMap<>();
		if (siteId != null) params.put("siteId", siteId);
		if (statutValidation != null && !statutValidation.isBlank()) params.put("statutValidation", statutValidation);
		if (search != null && !search.isBlank()) params.put("search", search);
		params.put("page", page);
		params.put("pageSize", pageSize);
		if (sort != null && !sort.isBlank()) params.put("sort", sort);

		return BackendJsonUtil.page(_client.get("/api/v1/terminals", params), BackendTerminalService::toTerminal);
	}

	public Terminal getById(long id) {
		return toTerminal(BackendJsonUtil.obj(_client.get("/api/v1/terminals/" + id, null)));
	}

	public Terminal create(TerminalRequestBody body) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("concessionnaireId", body.getConcessionnaireId());
		json.put("siteId", body.getSiteId());
		if (body.getLatitude() != null) json.put("latitude", body.getLatitude());
		if (body.getLongitude() != null) json.put("longitude", body.getLongitude());
		if (body.getAdresse() != null) json.put("adresse", body.getAdresse());
		return toTerminal(BackendJsonUtil.obj(_client.post("/api/v1/terminals", json.toString())));
	}

	public Terminal update(long id, TerminalPutRequestBody body) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		if (body.getConcessionnaireId() != null) json.put("concessionnaireId", body.getConcessionnaireId());
		if (body.getSiteId() != null) json.put("siteId", body.getSiteId());
		if (body.getLatitude() != null) json.put("latitude", body.getLatitude());
		if (body.getLongitude() != null) json.put("longitude", body.getLongitude());
		if (body.getAdresse() != null) json.put("adresse", body.getAdresse());
		return toTerminal(BackendJsonUtil.obj(_client.put("/api/v1/terminals/" + id, json.toString())));
	}

	public Page<Terminal> aValider(int page, int pageSize, String sort) {
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("page", page);
		params.put("pageSize", pageSize);
		if (sort != null && !sort.isBlank()) params.put("sort", sort);
		return BackendJsonUtil.page(_client.get("/api/v1/terminals/a-valider", params), BackendTerminalService::toTerminal);
	}

	public Terminal valider(long id) {
		return toTerminal(BackendJsonUtil.obj(_client.patch("/api/v1/terminals/" + id + "/valider", "{}")));
	}

	public Terminal rejeter(long id, String motif) {
		JSONObject json = JSONFactoryUtil.createJSONObject();
		if (motif != null) json.put("motif", motif);
		return toTerminal(BackendJsonUtil.obj(_client.patch("/api/v1/terminals/" + id + "/rejeter", json.toString())));
	}

	public Page<Terminal> cartographie(int page, int pageSize) {
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("page", page);
		params.put("pageSize", pageSize);
		return BackendJsonUtil.page(_client.get("/api/v1/terminals/cartographie", params), BackendTerminalService::toTerminal);
	}

	public List<Terminal> cartographieTop20() {
		return BackendJsonUtil.list(
				_client.get("/api/v1/terminals/cartographie/top20", null),
				BackendTerminalService::toTerminal);
	}

	public List<Visite> listVisites(long terminalId) {
		return BackendJsonUtil.list(
				_client.get("/api/v1/terminals/" + terminalId + "/visites", null),
				_visiteService::toVisite);
	}

	public static Terminal toTerminal(JSONObject obj) {
		if (obj == null) return null;
		Terminal dto = new Terminal();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setCodeTerminal(BackendJsonUtil.str(obj, "codeTerminal"));
		dto.setConcessionnaireId(BackendJsonUtil.longVal(obj, "concessionnaireId"));
		dto.setSiteId(BackendJsonUtil.longVal(obj, "siteId"));
		dto.setLatitude(BackendJsonUtil.dbl(obj, "latitude"));
		dto.setLongitude(BackendJsonUtil.dbl(obj, "longitude"));
		dto.setAdresse(BackendJsonUtil.str(obj, "adresse"));
		String statut = BackendJsonUtil.str(obj, "statutValidation");
		if (statut != null) {
			try {
				dto.setStatutValidation(Terminal.StatutValidation.create(statut));
			}
			catch (IllegalArgumentException ignored) {
				// Statut inconnu — on laisse null pour ne pas casser le client.
			}
		}
		return dto;
	}
}
