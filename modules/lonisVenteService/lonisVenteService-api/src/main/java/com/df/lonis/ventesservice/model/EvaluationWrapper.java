/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Evaluation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Evaluation
 * @generated
 */
public class EvaluationWrapper
	extends BaseModelWrapper<Evaluation>
	implements Evaluation, ModelWrapper<Evaluation> {

	public EvaluationWrapper(Evaluation evaluation) {
		super(evaluation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("commercialId", getCommercialId());
		attributes.put("nbVisitesPrevues", getNbVisitesPrevues());
		attributes.put("nbVisitesEffectuees", getNbVisitesEffectuees());
		attributes.put("tauxRealisation", getTauxRealisation());
		attributes.put("rang", getRang());
		attributes.put("periode", getPeriode());
		attributes.put("mois", getMois());
		attributes.put("trimestre", getTrimestre());
		attributes.put("annee", getAnnee());
		attributes.put("createdAt", getCreatedAt());
		attributes.put("updatedAt", getUpdatedAt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long commercialId = (Long)attributes.get("commercialId");

		if (commercialId != null) {
			setCommercialId(commercialId);
		}

		Integer nbVisitesPrevues = (Integer)attributes.get("nbVisitesPrevues");

		if (nbVisitesPrevues != null) {
			setNbVisitesPrevues(nbVisitesPrevues);
		}

		Integer nbVisitesEffectuees = (Integer)attributes.get(
			"nbVisitesEffectuees");

		if (nbVisitesEffectuees != null) {
			setNbVisitesEffectuees(nbVisitesEffectuees);
		}

		Double tauxRealisation = (Double)attributes.get("tauxRealisation");

		if (tauxRealisation != null) {
			setTauxRealisation(tauxRealisation);
		}

		Integer rang = (Integer)attributes.get("rang");

		if (rang != null) {
			setRang(rang);
		}

		String periode = (String)attributes.get("periode");

		if (periode != null) {
			setPeriode(periode);
		}

		Integer mois = (Integer)attributes.get("mois");

		if (mois != null) {
			setMois(mois);
		}

		Integer trimestre = (Integer)attributes.get("trimestre");

		if (trimestre != null) {
			setTrimestre(trimestre);
		}

		Integer annee = (Integer)attributes.get("annee");

		if (annee != null) {
			setAnnee(annee);
		}

		Date createdAt = (Date)attributes.get("createdAt");

		if (createdAt != null) {
			setCreatedAt(createdAt);
		}

		Date updatedAt = (Date)attributes.get("updatedAt");

		if (updatedAt != null) {
			setUpdatedAt(updatedAt);
		}
	}

	@Override
	public Evaluation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the annee of this evaluation.
	 *
	 * @return the annee of this evaluation
	 */
	@Override
	public int getAnnee() {
		return model.getAnnee();
	}

	/**
	 * Returns the commercial ID of this evaluation.
	 *
	 * @return the commercial ID of this evaluation
	 */
	@Override
	public long getCommercialId() {
		return model.getCommercialId();
	}

	/**
	 * Returns the created at of this evaluation.
	 *
	 * @return the created at of this evaluation
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the ID of this evaluation.
	 *
	 * @return the ID of this evaluation
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the mois of this evaluation.
	 *
	 * @return the mois of this evaluation
	 */
	@Override
	public int getMois() {
		return model.getMois();
	}

	/**
	 * Returns the nb visites effectuees of this evaluation.
	 *
	 * @return the nb visites effectuees of this evaluation
	 */
	@Override
	public int getNbVisitesEffectuees() {
		return model.getNbVisitesEffectuees();
	}

	/**
	 * Returns the nb visites prevues of this evaluation.
	 *
	 * @return the nb visites prevues of this evaluation
	 */
	@Override
	public int getNbVisitesPrevues() {
		return model.getNbVisitesPrevues();
	}

	/**
	 * Returns the periode of this evaluation.
	 *
	 * @return the periode of this evaluation
	 */
	@Override
	public String getPeriode() {
		return model.getPeriode();
	}

	/**
	 * Returns the primary key of this evaluation.
	 *
	 * @return the primary key of this evaluation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rang of this evaluation.
	 *
	 * @return the rang of this evaluation
	 */
	@Override
	public int getRang() {
		return model.getRang();
	}

	/**
	 * Returns the taux realisation of this evaluation.
	 *
	 * @return the taux realisation of this evaluation
	 */
	@Override
	public double getTauxRealisation() {
		return model.getTauxRealisation();
	}

	/**
	 * Returns the trimestre of this evaluation.
	 *
	 * @return the trimestre of this evaluation
	 */
	@Override
	public int getTrimestre() {
		return model.getTrimestre();
	}

	/**
	 * Returns the updated at of this evaluation.
	 *
	 * @return the updated at of this evaluation
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the annee of this evaluation.
	 *
	 * @param annee the annee of this evaluation
	 */
	@Override
	public void setAnnee(int annee) {
		model.setAnnee(annee);
	}

	/**
	 * Sets the commercial ID of this evaluation.
	 *
	 * @param commercialId the commercial ID of this evaluation
	 */
	@Override
	public void setCommercialId(long commercialId) {
		model.setCommercialId(commercialId);
	}

	/**
	 * Sets the created at of this evaluation.
	 *
	 * @param createdAt the created at of this evaluation
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the ID of this evaluation.
	 *
	 * @param id the ID of this evaluation
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the mois of this evaluation.
	 *
	 * @param mois the mois of this evaluation
	 */
	@Override
	public void setMois(int mois) {
		model.setMois(mois);
	}

	/**
	 * Sets the nb visites effectuees of this evaluation.
	 *
	 * @param nbVisitesEffectuees the nb visites effectuees of this evaluation
	 */
	@Override
	public void setNbVisitesEffectuees(int nbVisitesEffectuees) {
		model.setNbVisitesEffectuees(nbVisitesEffectuees);
	}

	/**
	 * Sets the nb visites prevues of this evaluation.
	 *
	 * @param nbVisitesPrevues the nb visites prevues of this evaluation
	 */
	@Override
	public void setNbVisitesPrevues(int nbVisitesPrevues) {
		model.setNbVisitesPrevues(nbVisitesPrevues);
	}

	/**
	 * Sets the periode of this evaluation.
	 *
	 * @param periode the periode of this evaluation
	 */
	@Override
	public void setPeriode(String periode) {
		model.setPeriode(periode);
	}

	/**
	 * Sets the primary key of this evaluation.
	 *
	 * @param primaryKey the primary key of this evaluation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rang of this evaluation.
	 *
	 * @param rang the rang of this evaluation
	 */
	@Override
	public void setRang(int rang) {
		model.setRang(rang);
	}

	/**
	 * Sets the taux realisation of this evaluation.
	 *
	 * @param tauxRealisation the taux realisation of this evaluation
	 */
	@Override
	public void setTauxRealisation(double tauxRealisation) {
		model.setTauxRealisation(tauxRealisation);
	}

	/**
	 * Sets the trimestre of this evaluation.
	 *
	 * @param trimestre the trimestre of this evaluation
	 */
	@Override
	public void setTrimestre(int trimestre) {
		model.setTrimestre(trimestre);
	}

	/**
	 * Sets the updated at of this evaluation.
	 *
	 * @param updatedAt the updated at of this evaluation
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected EvaluationWrapper wrap(Evaluation evaluation) {
		return new EvaluationWrapper(evaluation);
	}

}