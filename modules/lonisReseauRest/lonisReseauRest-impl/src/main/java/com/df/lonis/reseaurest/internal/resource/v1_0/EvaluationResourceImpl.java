package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Evaluation;
import com.df.lonis.reseaurest.internal.backend.BackendJsonUtil;
import com.df.lonis.reseaurest.internal.backend.service.BackendEvaluationService;
import com.df.lonis.reseaurest.resource.v1_0.EvaluationResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/evaluation.properties",
		scope = ServiceScope.PROTOTYPE,
		service = EvaluationResource.class
)
public class EvaluationResourceImpl extends BaseEvaluationResourceImpl {

	@Override
	public Page<Evaluation> getEvaluationsClassementPage(
			Integer annee, Integer mois, Integer trimestre, String periode) {

		if (annee == null) {
			throw new BadRequestException("annee est requis");
		}
		BackendJsonUtil.Page<Evaluation> result = _backend.classement(
				annee, mois, trimestre, periode, 0, 100);
		return Page.of(result.items());
	}

	@Override
	public Page<Evaluation> getCommercialEvaluationsPage(
			Long commercialId, Integer annee, Integer mois) {

		return Page.of(_backend.listByCommercial(commercialId, annee, mois));
	}

	@Override
	public Response postEvaluationsGenerer(Object object) {
		Map<String, Object> body = toMap(object);
		Integer annee = toInt(body.get("annee"));
		Integer mois = toInt(body.get("mois"));
		Integer trimestre = toInt(body.get("trimestre"));
		String periode = body.get("periode") == null ? null : body.get("periode").toString();

		if (annee == null || periode == null) {
			throw new BadRequestException("annee et periode sont requis");
		}

		BackendEvaluationService.GenererResponse response = _backend.generer(
				annee, mois, trimestre, periode);

		Map<String, Object> result = new HashMap<>();
		result.put("message", response.message());
		result.put("nbEvaluationsGenerees", response.nbEvaluationsGenerees());
		return Response.ok(result).build();
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Evaluation>,
					UnsafeFunction<Evaluation, Evaluation, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	@SuppressWarnings("unchecked")
	private static Map<String, Object> toMap(Object o) {
		return (o instanceof Map) ? (Map<String, Object>) o : new HashMap<>();
	}

	private static Integer toInt(Object o) {
		if (o == null) return null;
		if (o instanceof Number) return ((Number) o).intValue();
		try { return Integer.valueOf(o.toString()); }
		catch (NumberFormatException nfe) { return null; }
	}

	@Reference
	private BackendEvaluationService _backend;
}
