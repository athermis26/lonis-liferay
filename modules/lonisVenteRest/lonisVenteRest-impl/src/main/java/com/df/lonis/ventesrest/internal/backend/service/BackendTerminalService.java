package com.df.lonis.ventesrest.internal.backend.service;

import com.df.lonis.ventesrest.dto.v1_0.Terminal;
import com.df.lonis.ventesrest.dto.v1_0.TerminalActivite;
import com.df.lonis.ventesrest.internal.backend.BackendHttpClient;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil.Page;

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

	public Page<Terminal> list(String search, int page, int pageSize, String sort) {
		Map<String, Object> params = new LinkedHashMap<>();
		if (search != null && !search.isBlank()) params.put("search", search);
		params.put("page", page);
		params.put("pageSize", pageSize);
		if (sort != null && !sort.isBlank()) params.put("sort", sort);

		return BackendJsonUtil.page(_client.get("/api/v1/terminaux", params), this::toTerminalDto);
	}

	public List<TerminalActivite> topActifs(int limit) {
		Map<String, Object> params = new LinkedHashMap<>();
		params.put("limit", limit);
		return BackendJsonUtil.list(
				_client.get("/api/v1/terminaux/top-actifs", params),
				BackendTerminalService::toActivite);
	}

	public Terminal toTerminalDto(JSONObject obj) {
		if (obj == null) return null;
		Terminal dto = new Terminal();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setCodeTerminal(BackendJsonUtil.str(obj, "codeTerminal"));
		dto.setConcessionnaireId(BackendJsonUtil.longVal(obj, "concessionnaireId"));
		dto.setConcessionnaireNomPrenom(BackendJsonUtil.str(obj, "concessionnaireNomPrenom"));
		dto.setProduitType(BackendJsonUtil.str(obj, "produitType"));
		dto.setSiteLibelle(BackendJsonUtil.str(obj, "siteLibelle"));
		dto.setConcessionnaireCode(BackendJsonUtil.str(obj, "concessionnaireCode"));
		dto.setProduitId(BackendJsonUtil.longVal(obj, "produitId"));
		dto.setConcessionnaireProduitCode(BackendJsonUtil.str(obj, "concessionnaireProduitCode"));
		dto.setSiteId(BackendJsonUtil.longVal(obj, "siteId"));
		dto.setSolde(BackendJsonUtil.longVal(obj, "solde"));
		dto.setCreatedAt(BackendJsonUtil.date(obj, "createdAt"));
		dto.setUpdatedAt(BackendJsonUtil.date(obj, "updatedAt"));

		// Sous-objets imbriqués
		if (obj.has("produit") && !obj.isNull("produit")) {
			dto.setProduit(BackendProduitService.toProduit(obj.getJSONObject("produit")));
		}
		if (obj.has("site") && !obj.isNull("site")) {
			dto.setSite(BackendSiteService.toSite(obj.getJSONObject("site")));
		}
		return dto;
	}

	public static TerminalActivite toActivite(JSONObject obj) {
		TerminalActivite dto = new TerminalActivite();
		dto.setTerminalId(BackendJsonUtil.longVal(obj, "terminalId"));
		dto.setCodeTerminal(BackendJsonUtil.str(obj, "codeTerminal"));
		dto.setConcessionnaireProduitCode(BackendJsonUtil.str(obj, "concessionnaireProduitCode"));
		dto.setConcessionnaireId(BackendJsonUtil.longVal(obj, "concessionnaireId"));
		dto.setConcessionnaireNomPrenom(BackendJsonUtil.str(obj, "concessionnaireNomPrenom"));
		dto.setProduitCode(BackendJsonUtil.str(obj, "produitCode"));
		dto.setProduitLibelle(BackendJsonUtil.str(obj, "produitLibelle"));
		dto.setSiteLibelle(BackendJsonUtil.str(obj, "siteLibelle"));
		dto.setSolde(BackendJsonUtil.longVal(obj, "solde"));
		dto.setNombreOperations(BackendJsonUtil.longVal(obj, "nombreOperations"));
		dto.setNombreRechargements(BackendJsonUtil.longVal(obj, "nombreRechargements"));
		dto.setChiffreAffaires(BackendJsonUtil.longVal(obj, "chiffreAffaires"));
		return dto;
	}
}
