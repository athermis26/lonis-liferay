package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Evaluation;
import com.df.lonis.reseaurest.internal.resource.v1_0.internal.mapper.EvaluationMapper;
import com.df.lonis.reseaurest.internal.resource.v1_0.internal.util.PeriodeUtil;
import com.df.lonis.reseaurest.resource.v1_0.EvaluationResource;

import com.df.lonis.ventesservice.service.CommercialLocalService;
import com.df.lonis.ventesservice.service.EvaluationLocalService;
import com.df.lonis.ventesservice.service.ObjectifLocalService;
import com.df.lonis.ventesservice.service.VisiteLocalService;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/evaluation.properties",
	scope = ServiceScope.PROTOTYPE, service = EvaluationResource.class
)
public class EvaluationResourceImpl extends BaseEvaluationResourceImpl {

	/**
	 * Classement: tri par tauxRealisation desc + recalcul du rang.
	 */
	@Override
	public Page<Evaluation> getEvaluationsClassementPage(
			Integer annee, Integer mois, Integer trimestre, String periode)
		throws Exception {

		DynamicQuery dq = _evaluationLocalService.dynamicQuery();
		dq.add(PropertyFactoryUtil.forName("annee").eq(annee));

		if (mois != null) {
			dq.add(PropertyFactoryUtil.forName("mois").eq(mois));
		}
		if (trimestre != null) {
			dq.add(PropertyFactoryUtil.forName("trimestre").eq(trimestre));
		}
		if ((periode != null) && !periode.isEmpty()) {
			dq.add(PropertyFactoryUtil.forName("periode").eq(periode));
		}

		List<com.df.lonis.ventesservice.model.Evaluation> entries =
			_evaluationLocalService.dynamicQuery(dq);

		// Tri par tauxRealisation desc
		entries.sort(
			Comparator.comparingDouble(
				com.df.lonis.ventesservice.model.Evaluation::
					getTauxRealisation
			).reversed());

		// Recalcul des rangs et persistance
		for (int i = 0; i < entries.size(); i++) {
			com.df.lonis.ventesservice.model.Evaluation e = entries.get(i);
			if (e.getRang() != (i + 1)) {
				e.setRang(i + 1);
				_evaluationLocalService.updateEvaluation(e);
			}
		}

		return Page.of(
			entries.stream(
			).map(
				_evaluationMapper::toDto
			).collect(
				Collectors.toList()
			));
	}

	@Override
	public Page<Evaluation> getCommercialEvaluationsPage(
			Long commercialId, Integer annee, Integer mois)
		throws Exception {

		DynamicQuery dq = _evaluationLocalService.dynamicQuery();
		dq.add(
			PropertyFactoryUtil.forName("commercialId").eq(commercialId));

		if (annee != null) {
			dq.add(PropertyFactoryUtil.forName("annee").eq(annee));
		}
		if (mois != null) {
			dq.add(PropertyFactoryUtil.forName("mois").eq(mois));
		}

		List<com.df.lonis.ventesservice.model.Evaluation> entries =
			_evaluationLocalService.dynamicQuery(dq);

		return Page.of(
			entries.stream(
			).map(
				_evaluationMapper::toDto
			).collect(
				Collectors.toList()
			));
	}

	/**
	 * Genere les evaluations d'une periode pour tous les commerciaux.
	 * Body attendu: { annee, mois, trimestre, periode (MENSUEL|TRIMESTRIEL) }
	 */
//	@Override
//	public javax.ws.rs.core.Response postEvaluationsGenerer(Object object)
//		throws Exception {
//
//		Map<String, Object> body = _toMap(object);
//
//		Integer annee = _toInt(body.get("annee"));
//		Integer mois = _toInt(body.get("mois"));
//		Integer trimestre = _toInt(body.get("trimestre"));
//		String periode = (String)body.get("periode");
//
//		if ((annee == null) || (periode == null)) {
//			throw new javax.ws.rs.BadRequestException(
//				"annee et periode sont requis");
//		}
//
//		PeriodeUtil.Range range = PeriodeUtil.range(
//			periode, annee, mois, trimestre);
//
//		List<com.df.lonis.ventesservice.model.Commercial> commerciaux =
//			_commercialLocalService.getCommercials(-1, -1);
//
//		int count = 0;
//
//		for (com.df.lonis.ventesservice.model.Commercial c : commerciaux) {
//			// Objectif de la periode
//			com.df.lonis.ventesservice.model.Objectif objectif = null;
//			if (mois != null) {
//				objectif = _objectifLocalService.fetchByC_A_M(
//					c.getId(), annee, mois);
//			}
//
//			int valeurCible = (objectif == null) ? 0 : objectif.getValeurCible();
//
//			// Visites EFFECTUEES sur la periode
//			int nbEffectuees =
//				_visiteLocalService.countByCommercialIdAndPeriode(
//					c.getId(), _STATUT_EFFECTUEE, range.debut, range.fin);
//
//			double taux = (valeurCible > 0)
//				? (nbEffectuees * 100.0) / valeurCible
//				: 0.0;
//
//			// Upsert sur (commercial, annee, mois, periode)
//			com.df.lonis.ventesservice.model.Evaluation eval =
//				_evaluationLocalService.fetchByC_A_M_P(
//					c.getId(), annee, (mois == null) ? 0 : mois, periode);
//
//			if (eval == null) {
//				eval = _evaluationLocalService.createEvaluation(0);
//				eval.setCommercialId(c.getId());
//				eval.setAnnee(annee);
//				eval.setMois((mois == null) ? 0 : mois);
//				eval.setTrimestre((trimestre == null) ? 0 : trimestre);
//				eval.setPeriode(periode);
//				eval.setCreatedAt(new Date());
//			}
//
//			eval.setNbVisitesPrevues(valeurCible);
//			eval.setNbVisitesEffectuees(nbEffectuees);
//			eval.setTauxRealisation(taux);
//			eval.setUpdatedAt(new Date());
//
//			if (eval.getId() == 0) {
//				_evaluationLocalService.addEvaluation(eval);
//			}
//			else {
//				_evaluationLocalService.updateEvaluation(eval);
//			}
//
//			count++;
//		}
//
//		// Recalcul des rangs
//		_recalculerRangs(annee, mois, trimestre, periode);
//
//		Map<String, Object> result = new java.util.HashMap<>();
//		result.put("message", "Evaluations generees avec succes");
//		result.put("nbEvaluationsGenerees", count);
//
//		return javax.ws.rs.core.Response.ok(result).build();
//	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
		UnsafeBiConsumer
			<Collection<Evaluation>,
			 UnsafeFunction<Evaluation, Evaluation, Exception>,
			 Exception> contextBatchUnsafeBiConsumer) {
	}

	private void _recalculerRangs(
			Integer annee, Integer mois, Integer trimestre, String periode)
		throws Exception {

		DynamicQuery dq = _evaluationLocalService.dynamicQuery();
		dq.add(PropertyFactoryUtil.forName("annee").eq(annee));
		if (mois != null) {
			dq.add(PropertyFactoryUtil.forName("mois").eq(mois));
		}
		if (trimestre != null) {
			dq.add(PropertyFactoryUtil.forName("trimestre").eq(trimestre));
		}
		if (periode != null) {
			dq.add(PropertyFactoryUtil.forName("periode").eq(periode));
		}

		List<com.df.lonis.ventesservice.model.Evaluation> entries =
			_evaluationLocalService.dynamicQuery(dq);

		entries.sort(
			Comparator.comparingDouble(
				com.df.lonis.ventesservice.model.Evaluation::
					getTauxRealisation
			).reversed());

		for (int i = 0; i < entries.size(); i++) {
			com.df.lonis.ventesservice.model.Evaluation e = entries.get(i);
			e.setRang(i + 1);
			_evaluationLocalService.updateEvaluation(e);
		}
	}

	private Integer _toInt(Object o) {
		if (o == null) {
			return null;
		}
		if (o instanceof Integer) {
			return (Integer)o;
		}
		try {
			return Integer.valueOf(o.toString());
		}
		catch (NumberFormatException nfe) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private Map<String, Object> _toMap(Object o) {
		if (o instanceof Map) {
			return (Map<String, Object>)o;
		}
		return new java.util.HashMap<>();
	}

	private static final String _STATUT_EFFECTUEE = "EFFECTUEE";

	@Reference
	private CommercialLocalService _commercialLocalService;

	@Reference
	private EvaluationLocalService _evaluationLocalService;

	@Reference
	private EvaluationMapper _evaluationMapper;

	@Reference
	private ObjectifLocalService _objectifLocalService;

	@Reference
	private VisiteLocalService _visiteLocalService;

}
