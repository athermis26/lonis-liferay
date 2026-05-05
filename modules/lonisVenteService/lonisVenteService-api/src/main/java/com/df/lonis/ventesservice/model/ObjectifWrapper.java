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
 * This class is a wrapper for {@link Objectif}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Objectif
 * @generated
 */
public class ObjectifWrapper
	extends BaseModelWrapper<Objectif>
	implements ModelWrapper<Objectif>, Objectif {

	public ObjectifWrapper(Objectif objectif) {
		super(objectif);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("commercialId", getCommercialId());
		attributes.put("type", getType());
		attributes.put("periode", getPeriode());
		attributes.put("valeurCible", getValeurCible());
		attributes.put("valeurReelle", getValeurReelle());
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

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String periode = (String)attributes.get("periode");

		if (periode != null) {
			setPeriode(periode);
		}

		Integer valeurCible = (Integer)attributes.get("valeurCible");

		if (valeurCible != null) {
			setValeurCible(valeurCible);
		}

		Integer valeurReelle = (Integer)attributes.get("valeurReelle");

		if (valeurReelle != null) {
			setValeurReelle(valeurReelle);
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
	public Objectif cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the annee of this objectif.
	 *
	 * @return the annee of this objectif
	 */
	@Override
	public int getAnnee() {
		return model.getAnnee();
	}

	/**
	 * Returns the commercial ID of this objectif.
	 *
	 * @return the commercial ID of this objectif
	 */
	@Override
	public long getCommercialId() {
		return model.getCommercialId();
	}

	/**
	 * Returns the created at of this objectif.
	 *
	 * @return the created at of this objectif
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the ID of this objectif.
	 *
	 * @return the ID of this objectif
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the mois of this objectif.
	 *
	 * @return the mois of this objectif
	 */
	@Override
	public int getMois() {
		return model.getMois();
	}

	/**
	 * Returns the periode of this objectif.
	 *
	 * @return the periode of this objectif
	 */
	@Override
	public String getPeriode() {
		return model.getPeriode();
	}

	/**
	 * Returns the primary key of this objectif.
	 *
	 * @return the primary key of this objectif
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the trimestre of this objectif.
	 *
	 * @return the trimestre of this objectif
	 */
	@Override
	public int getTrimestre() {
		return model.getTrimestre();
	}

	/**
	 * Returns the type of this objectif.
	 *
	 * @return the type of this objectif
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the updated at of this objectif.
	 *
	 * @return the updated at of this objectif
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns the valeur cible of this objectif.
	 *
	 * @return the valeur cible of this objectif
	 */
	@Override
	public int getValeurCible() {
		return model.getValeurCible();
	}

	/**
	 * Returns the valeur reelle of this objectif.
	 *
	 * @return the valeur reelle of this objectif
	 */
	@Override
	public int getValeurReelle() {
		return model.getValeurReelle();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the annee of this objectif.
	 *
	 * @param annee the annee of this objectif
	 */
	@Override
	public void setAnnee(int annee) {
		model.setAnnee(annee);
	}

	/**
	 * Sets the commercial ID of this objectif.
	 *
	 * @param commercialId the commercial ID of this objectif
	 */
	@Override
	public void setCommercialId(long commercialId) {
		model.setCommercialId(commercialId);
	}

	/**
	 * Sets the created at of this objectif.
	 *
	 * @param createdAt the created at of this objectif
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the ID of this objectif.
	 *
	 * @param id the ID of this objectif
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the mois of this objectif.
	 *
	 * @param mois the mois of this objectif
	 */
	@Override
	public void setMois(int mois) {
		model.setMois(mois);
	}

	/**
	 * Sets the periode of this objectif.
	 *
	 * @param periode the periode of this objectif
	 */
	@Override
	public void setPeriode(String periode) {
		model.setPeriode(periode);
	}

	/**
	 * Sets the primary key of this objectif.
	 *
	 * @param primaryKey the primary key of this objectif
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the trimestre of this objectif.
	 *
	 * @param trimestre the trimestre of this objectif
	 */
	@Override
	public void setTrimestre(int trimestre) {
		model.setTrimestre(trimestre);
	}

	/**
	 * Sets the type of this objectif.
	 *
	 * @param type the type of this objectif
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the updated at of this objectif.
	 *
	 * @param updatedAt the updated at of this objectif
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	/**
	 * Sets the valeur cible of this objectif.
	 *
	 * @param valeurCible the valeur cible of this objectif
	 */
	@Override
	public void setValeurCible(int valeurCible) {
		model.setValeurCible(valeurCible);
	}

	/**
	 * Sets the valeur reelle of this objectif.
	 *
	 * @param valeurReelle the valeur reelle of this objectif
	 */
	@Override
	public void setValeurReelle(int valeurReelle) {
		model.setValeurReelle(valeurReelle);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ObjectifWrapper wrap(Objectif objectif) {
		return new ObjectifWrapper(objectif);
	}

}