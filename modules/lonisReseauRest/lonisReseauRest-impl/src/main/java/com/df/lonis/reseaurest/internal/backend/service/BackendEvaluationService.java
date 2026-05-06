package com.df.lonis.reseaurest.internal.backend.service;

import com.df.lonis.reseaurest.dto.v1_0.Evaluation;
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

@Component(immediate = true, service = BackendEvaluationService.class)
public class BackendEvaluationService {

	@Reference
	private BackendHttpClient _client;

	public Page<Evaluation> classement(
			int annee, Integer mois, Integer trimestre, String periode,
			int page, int pageSize) {

		Map<String, Object> params = new LinkedHashMap<>();
		params.put("annee", annee);
		if (mois != null) params.put("mois", mois);
		if (trimestre != null) params.put("trimestre", trimestre);
		if (periode != null) params.put("periode", periode);
		params.put("page", page);
		params.put("pageSize", pageSize);

		return BackendJsonUtil.page(
				_client.get("/api/v1/evaluations/classement", params),
				BackendEvaluationService::toEvaluation);
	}

	public List<Evaluation> listByCommercial(long commercialId, Integer annee, Integer mois) {
		Map<String, Object> params = new LinkedHashMap<>();
		if (annee != null) params.put("annee", annee);
		if (mois != null) params.put("mois", mois);
		return BackendJsonUtil.list(
				_client.get("/api/v1/commerciaux/" + commercialId + "/evaluations", params),
				BackendEvaluationService::toEvaluation);
	}

	/** Réponse: {@code {"message":"...", "nbEvaluationsGenerees":N}}. */
	public GenererResponse generer(int annee, Integer mois, Integer trimestre, String periode) {
		JSONObject body = JSONFactoryUtil.createJSONObject();
		body.put("annee", annee);
		if (mois != null) body.put("mois", mois);
		if (trimestre != null) body.put("trimestre", trimestre);
		body.put("periode", periode);

		JSONObject obj = BackendJsonUtil.obj(_client.post("/api/v1/evaluations/generer", body.toString()));
		return new GenererResponse(
				BackendJsonUtil.str(obj, "message"),
				BackendJsonUtil.intVal(obj, "nbEvaluationsGenerees"));
	}

	public static Evaluation toEvaluation(JSONObject obj) {
		if (obj == null) return null;
		Evaluation dto = new Evaluation();
		dto.setId(BackendJsonUtil.longVal(obj, "id"));
		dto.setCommercialId(BackendJsonUtil.longVal(obj, "commercialId"));
		dto.setNom(BackendJsonUtil.str(obj, "nom"));
		dto.setPrenoms(BackendJsonUtil.str(obj, "prenoms"));
		dto.setNbVisitesPrevues(BackendJsonUtil.intVal(obj, "nbVisitesPrevues"));
		dto.setNbVisitesEffectuees(BackendJsonUtil.intVal(obj, "nbVisitesEffectuees"));
		dto.setTauxRealisation(BackendJsonUtil.dbl(obj, "tauxRealisation"));
		dto.setRang(BackendJsonUtil.intVal(obj, "rang"));
		String periode = BackendJsonUtil.str(obj, "periode");
		if (periode != null) {
			try { dto.setPeriode(Evaluation.Periode.create(periode)); } catch (IllegalArgumentException ignored) {}
		}
		dto.setMois(BackendJsonUtil.intVal(obj, "mois"));
		dto.setTrimestre(BackendJsonUtil.intVal(obj, "trimestre"));
		dto.setAnnee(BackendJsonUtil.intVal(obj, "annee"));
		dto.setCreatedAt(BackendJsonUtil.date(obj, "createdAt"));
		return dto;
	}

	/** Petit conteneur pour la réponse de l'endpoint {@code /evaluations/generer}. */
	public static final class GenererResponse {
		private final String message;
		private final Integer nbEvaluationsGenerees;

		public GenererResponse(String message, Integer nbEvaluationsGenerees) {
			this.message = message;
			this.nbEvaluationsGenerees = nbEvaluationsGenerees;
		}

		public String message() { return message; }
		public Integer nbEvaluationsGenerees() { return nbEvaluationsGenerees; }
	}
}
