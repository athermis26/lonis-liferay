package com.df.lonis.ventesrest.internal.backend.service;

import com.df.lonis.ventesrest.dto.v1_0.Produit;
import com.df.lonis.ventesrest.internal.backend.BackendHttpClient;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;

import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = BackendProduitService.class)
public class BackendProduitService {

	@Reference
	private BackendHttpClient _client;

	public List<Produit> listAll() {
		String body = _client.get("/api/v1/produits", null);
		return BackendJsonUtil.list(body, BackendProduitService::toProduit);
	}

	public static Produit toProduit(JSONObject obj) {
		if (obj == null) return null;
		Produit dto = new Produit();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setCode(BackendJsonUtil.str(obj, "code"));
		dto.setLibelle(BackendJsonUtil.str(obj, "libelle"));
		dto.setAbreviation(BackendJsonUtil.str(obj, "abreviation"));
		dto.setActive(BackendJsonUtil.bool(obj, "active"));
		dto.setCreatedAt(BackendJsonUtil.date(obj, "createdAt"));
		dto.setUpdatedAt(BackendJsonUtil.date(obj, "updatedAt"));
		return dto;
	}
}
