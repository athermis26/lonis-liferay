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
 * This class is a wrapper for {@link Visite}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Visite
 * @generated
 */
public class VisiteWrapper
	extends BaseModelWrapper<Visite> implements ModelWrapper<Visite>, Visite {

	public VisiteWrapper(Visite visite) {
		super(visite);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("commercialId", getCommercialId());
		attributes.put("terminalId", getTerminalId());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("statut", getStatut());
		attributes.put("typeControle", getTypeControle());
		attributes.put("dateVisite", getDateVisite());
		attributes.put("compteRendu", getCompteRendu());
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

		Long terminalId = (Long)attributes.get("terminalId");

		if (terminalId != null) {
			setTerminalId(terminalId);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String statut = (String)attributes.get("statut");

		if (statut != null) {
			setStatut(statut);
		}

		String typeControle = (String)attributes.get("typeControle");

		if (typeControle != null) {
			setTypeControle(typeControle);
		}

		Date dateVisite = (Date)attributes.get("dateVisite");

		if (dateVisite != null) {
			setDateVisite(dateVisite);
		}

		String compteRendu = (String)attributes.get("compteRendu");

		if (compteRendu != null) {
			setCompteRendu(compteRendu);
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
	public Visite cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the commercial ID of this visite.
	 *
	 * @return the commercial ID of this visite
	 */
	@Override
	public long getCommercialId() {
		return model.getCommercialId();
	}

	/**
	 * Returns the compte rendu of this visite.
	 *
	 * @return the compte rendu of this visite
	 */
	@Override
	public String getCompteRendu() {
		return model.getCompteRendu();
	}

	/**
	 * Returns the created at of this visite.
	 *
	 * @return the created at of this visite
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the date visite of this visite.
	 *
	 * @return the date visite of this visite
	 */
	@Override
	public Date getDateVisite() {
		return model.getDateVisite();
	}

	/**
	 * Returns the ID of this visite.
	 *
	 * @return the ID of this visite
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the latitude of this visite.
	 *
	 * @return the latitude of this visite
	 */
	@Override
	public Double getLatitude() {
		return model.getLatitude();
	}

	/**
	 * Returns the longitude of this visite.
	 *
	 * @return the longitude of this visite
	 */
	@Override
	public Double getLongitude() {
		return model.getLongitude();
	}

	/**
	 * Returns the primary key of this visite.
	 *
	 * @return the primary key of this visite
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the statut of this visite.
	 *
	 * @return the statut of this visite
	 */
	@Override
	public String getStatut() {
		return model.getStatut();
	}

	/**
	 * Returns the terminal ID of this visite.
	 *
	 * @return the terminal ID of this visite
	 */
	@Override
	public long getTerminalId() {
		return model.getTerminalId();
	}

	/**
	 * Returns the type controle of this visite.
	 *
	 * @return the type controle of this visite
	 */
	@Override
	public String getTypeControle() {
		return model.getTypeControle();
	}

	/**
	 * Returns the updated at of this visite.
	 *
	 * @return the updated at of this visite
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
	 * Sets the commercial ID of this visite.
	 *
	 * @param commercialId the commercial ID of this visite
	 */
	@Override
	public void setCommercialId(long commercialId) {
		model.setCommercialId(commercialId);
	}

	/**
	 * Sets the compte rendu of this visite.
	 *
	 * @param compteRendu the compte rendu of this visite
	 */
	@Override
	public void setCompteRendu(String compteRendu) {
		model.setCompteRendu(compteRendu);
	}

	/**
	 * Sets the created at of this visite.
	 *
	 * @param createdAt the created at of this visite
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the date visite of this visite.
	 *
	 * @param dateVisite the date visite of this visite
	 */
	@Override
	public void setDateVisite(Date dateVisite) {
		model.setDateVisite(dateVisite);
	}

	/**
	 * Sets the ID of this visite.
	 *
	 * @param id the ID of this visite
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the latitude of this visite.
	 *
	 * @param latitude the latitude of this visite
	 */
	@Override
	public void setLatitude(Double latitude) {
		model.setLatitude(latitude);
	}

	/**
	 * Sets the longitude of this visite.
	 *
	 * @param longitude the longitude of this visite
	 */
	@Override
	public void setLongitude(Double longitude) {
		model.setLongitude(longitude);
	}

	/**
	 * Sets the primary key of this visite.
	 *
	 * @param primaryKey the primary key of this visite
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the statut of this visite.
	 *
	 * @param statut the statut of this visite
	 */
	@Override
	public void setStatut(String statut) {
		model.setStatut(statut);
	}

	/**
	 * Sets the terminal ID of this visite.
	 *
	 * @param terminalId the terminal ID of this visite
	 */
	@Override
	public void setTerminalId(long terminalId) {
		model.setTerminalId(terminalId);
	}

	/**
	 * Sets the type controle of this visite.
	 *
	 * @param typeControle the type controle of this visite
	 */
	@Override
	public void setTypeControle(String typeControle) {
		model.setTypeControle(typeControle);
	}

	/**
	 * Sets the updated at of this visite.
	 *
	 * @param updatedAt the updated at of this visite
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
	protected VisiteWrapper wrap(Visite visite) {
		return new VisiteWrapper(visite);
	}

}