package com.df.lonis.ventesrest.internal.backend.service;

import com.df.lonis.ventesrest.dto.v1_0.Concessionnaire;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireActivite;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireBody;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireDetail;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireProduit;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireStats;
import com.df.lonis.ventesrest.dto.v1_0.Terminal;
import com.df.lonis.ventesrest.internal.backend.BackendHttpClient;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil.Page;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Passerelle vers les endpoints {@code /api/v1/concessionnaire(s)} du backend Spring Boot.
 */
@Component(immediate = true, service = BackendConcessionnaireService.class)
public class BackendConcessionnaireService {

	@Reference
	private BackendHttpClient _client;

	@Reference
	private BackendTerminalService _terminalService;

	// ──────────────────────────────────────────────
	// LISTE / DÉTAIL
	// ──────────────────────────────────────────────

	public Page<Concessionnaire> list(String search, int page, int pageSize, String sort) {
		Map<String, Object> params = new LinkedHashMap<>();
		if (search != null && !search.isBlank()) params.put("search", search);
		params.put("page", page);
		params.put("pageSize", pageSize);
		if (sort != null && !sort.isBlank()) params.put("sort", sort);

		String body = _client.get("/api/v1/concessionnaires", params);
		return BackendJsonUtil.page(body, BackendConcessionnaireService::toConcessionnaire);
	}

	public ConcessionnaireDetail getById(long id) {
		String body = _client.get("/api/v1/concessionnaires/" + id, null);
		return toDetail(BackendJsonUtil.obj(body));
	}

	public Concessionnaire create(ConcessionnaireBody body) {
		JSONObject json = com.liferay.portal.kernel.json.JSONFactoryUtil.createJSONObject();
		json.put("nom", body.getNom());
		json.put("prenom", body.getPrenom());
		String response = _client.post("/api/v1/concessionnaire", json.toString());
		return toConcessionnaire(BackendJsonUtil.obj(response));
	}

	// ──────────────────────────────────────────────
	// PRODUITS LIÉS / DÉTACHEMENT
	// ──────────────────────────────────────────────

	public List<ConcessionnaireProduit> listProduits(long concessionnaireId) {
		String body = _client.get(
				"/api/v1/concessionnaires/" + concessionnaireId + "/produits", null);
		return BackendJsonUtil.list(body, BackendConcessionnaireService::toProduitLink);
	}

	public void deleteProduitLink(long concessionnaireId, long concessionnaireProduitId) {
		_client.delete("/api/v1/concessionnaires/" + concessionnaireId
				+ "/produits/" + concessionnaireProduitId);
	}

	// ──────────────────────────────────────────────
	// COMMISSIONS / TERMINAUX DU CONCESSIONNAIRE
	// ──────────────────────────────────────────────

	public List<Terminal> listTerminaux(
			long concessionnaireId,
			String concessionnaireProduitCode,
			String dateDebut, String dateFin) {

		Map<String, Object> params = new LinkedHashMap<>();
		if (concessionnaireProduitCode != null) params.put("concessionnaireProduitCode", concessionnaireProduitCode);
		if (dateDebut != null) params.put("dateDebut", dateDebut);
		if (dateFin != null) params.put("dateFin", dateFin);

		String body = _client.get(
				"/api/v1/concessionnaires/" + concessionnaireId + "/terminaux", params);
		return BackendJsonUtil.list(body, _terminalService::toTerminalDto);
	}

	// ──────────────────────────────────────────────
	// TOP-ACTIFS
	// ──────────────────────────────────────────────

	public List<ConcessionnaireActivite> topActifs(int limit) {
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("limit", limit);
		String body = _client.get("/api/v1/concessionnaires/top-actifs", params);
		return BackendJsonUtil.list(body, BackendConcessionnaireService::toActivite);
	}

	// ──────────────────────────────────────────────
	// MAPPING JSON → DTO Liferay
	// ──────────────────────────────────────────────

	static Concessionnaire toConcessionnaire(JSONObject obj) {
		Concessionnaire dto = new Concessionnaire();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setUid(BackendJsonUtil.str(obj, "uid"));
		dto.setNom(BackendJsonUtil.str(obj, "nom"));
		dto.setPrenoms(BackendJsonUtil.str(obj, "prenoms"));
		dto.setTelephone(BackendJsonUtil.str(obj, "telephone"));
		dto.setEmail(BackendJsonUtil.str(obj, "email"));
		return dto;
	}

	static ConcessionnaireProduit toProduitLink(JSONObject obj) {
		ConcessionnaireProduit dto = new ConcessionnaireProduit();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setConcessionnaireId(BackendJsonUtil.longVal(obj, "concessionnaireId"));
		dto.setProduitId(BackendJsonUtil.longVal(obj, "produitId"));
		dto.setSiteId(BackendJsonUtil.longVal(obj, "siteId"));
		dto.setCode(BackendJsonUtil.str(obj, "code"));
		dto.setConcessionnaireCode(BackendJsonUtil.str(obj, "concessionnaireCode"));
		dto.setActive(BackendJsonUtil.bool(obj, "active"));
		// produit + site + chiffreAffaires : optionnels selon contexte
		return dto;
	}

	private ConcessionnaireDetail toDetail(JSONObject obj) {
		ConcessionnaireDetail dto = new ConcessionnaireDetail();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setUid(BackendJsonUtil.str(obj, "uid"));
		dto.setNom(BackendJsonUtil.str(obj, "nom"));
		dto.setPrenoms(BackendJsonUtil.str(obj, "prenoms"));
		dto.setTelephone(BackendJsonUtil.str(obj, "telephone"));
		dto.setEmail(BackendJsonUtil.str(obj, "email"));
		dto.setSoldeTotal(BackendJsonUtil.longVal(obj, "soldeTotal"));

		JSONObject statsJson = obj.has("stats") ? obj.getJSONObject("stats") : null;
		if (statsJson != null) {
			ConcessionnaireStats stats = new ConcessionnaireStats();
			stats.setTotalProduits(BackendJsonUtil.intVal(statsJson, "totalProduits"));
			stats.setTotalTerminaux(BackendJsonUtil.intVal(statsJson, "totalTerminaux"));
			stats.setTotalOperations(BackendJsonUtil.longVal(statsJson, "totalOperations"));
			stats.setTotalPaiements(BackendJsonUtil.longVal(statsJson, "totalPaiements"));
			stats.setChiffreAffaires(BackendJsonUtil.longVal(statsJson, "chiffreAffaires"));
			dto.setStats(stats);
		}

		JSONArray produitsArr = obj.has("concessionnaireProduits")
				? obj.getJSONArray("concessionnaireProduits") : null;
		if (produitsArr != null) {
			ConcessionnaireProduit[] produits = new ConcessionnaireProduit[produitsArr.length()];
			for (int i = 0; i < produitsArr.length(); i++) {
				produits[i] = toProduitLink(produitsArr.getJSONObject(i));
			}
			dto.setConcessionnaireProduits(produits);
		}

		JSONArray terminauxArr = obj.has("concessionnaireTerminals")
				? obj.getJSONArray("concessionnaireTerminals") : null;
		if (terminauxArr != null) {
			Terminal[] terminaux = new Terminal[terminauxArr.length()];
			for (int i = 0; i < terminauxArr.length(); i++) {
				terminaux[i] = _terminalService.toTerminalDto(terminauxArr.getJSONObject(i));
			}
			dto.setConcessionnaireTerminals(terminaux);
		}

		return dto;
	}

	private static ConcessionnaireActivite toActivite(JSONObject obj) {
		ConcessionnaireActivite dto = new ConcessionnaireActivite();
		dto.setConcessionnaireId(BackendJsonUtil.longVal(obj, "concessionnaireId"));
		dto.setUid(BackendJsonUtil.str(obj, "uid"));
		dto.setNom(BackendJsonUtil.str(obj, "nom"));
		dto.setPrenoms(BackendJsonUtil.str(obj, "prenoms"));
		dto.setTelephone(BackendJsonUtil.str(obj, "telephone"));
		dto.setNombreTerminaux(BackendJsonUtil.intVal(obj, "nombreTerminaux"));
		dto.setNombreOperations(BackendJsonUtil.longVal(obj, "nombreOperations"));
		dto.setChiffreAffaires(BackendJsonUtil.longVal(obj, "chiffreAffaires"));
		dto.setSoldeTotal(BackendJsonUtil.longVal(obj, "soldeTotal"));
		dto.setConcessionnaireCodes(BackendJsonUtil.strArr(obj, "concessionnaireCodes"));
		return dto;
	}
}
