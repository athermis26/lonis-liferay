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
 * This class is a wrapper for {@link ConcessionnaireProduit}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConcessionnaireProduit
 * @generated
 */
public class ConcessionnaireProduitWrapper
	extends BaseModelWrapper<ConcessionnaireProduit>
	implements ConcessionnaireProduit, ModelWrapper<ConcessionnaireProduit> {

	public ConcessionnaireProduitWrapper(
		ConcessionnaireProduit concessionnaireProduit) {

		super(concessionnaireProduit);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("concessionnaireId", getConcessionnaireId());
		attributes.put("produitId", getProduitId());
		attributes.put("siteId", getSiteId());
		attributes.put("code", getCode());
		attributes.put("concessionnaireCode", getConcessionnaireCode());
		attributes.put("active", isActive());
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

		Long concessionnaireId = (Long)attributes.get("concessionnaireId");

		if (concessionnaireId != null) {
			setConcessionnaireId(concessionnaireId);
		}

		Long produitId = (Long)attributes.get("produitId");

		if (produitId != null) {
			setProduitId(produitId);
		}

		Long siteId = (Long)attributes.get("siteId");

		if (siteId != null) {
			setSiteId(siteId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String concessionnaireCode = (String)attributes.get(
			"concessionnaireCode");

		if (concessionnaireCode != null) {
			setConcessionnaireCode(concessionnaireCode);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
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
	public ConcessionnaireProduit cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the active of this concessionnaire produit.
	 *
	 * @return the active of this concessionnaire produit
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the code of this concessionnaire produit.
	 *
	 * @return the code of this concessionnaire produit
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the concessionnaire code of this concessionnaire produit.
	 *
	 * @return the concessionnaire code of this concessionnaire produit
	 */
	@Override
	public String getConcessionnaireCode() {
		return model.getConcessionnaireCode();
	}

	/**
	 * Returns the concessionnaire ID of this concessionnaire produit.
	 *
	 * @return the concessionnaire ID of this concessionnaire produit
	 */
	@Override
	public long getConcessionnaireId() {
		return model.getConcessionnaireId();
	}

	/**
	 * Returns the created at of this concessionnaire produit.
	 *
	 * @return the created at of this concessionnaire produit
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the ID of this concessionnaire produit.
	 *
	 * @return the ID of this concessionnaire produit
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this concessionnaire produit.
	 *
	 * @return the primary key of this concessionnaire produit
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the produit ID of this concessionnaire produit.
	 *
	 * @return the produit ID of this concessionnaire produit
	 */
	@Override
	public long getProduitId() {
		return model.getProduitId();
	}

	/**
	 * Returns the site ID of this concessionnaire produit.
	 *
	 * @return the site ID of this concessionnaire produit
	 */
	@Override
	public long getSiteId() {
		return model.getSiteId();
	}

	/**
	 * Returns the updated at of this concessionnaire produit.
	 *
	 * @return the updated at of this concessionnaire produit
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns <code>true</code> if this concessionnaire produit is active.
	 *
	 * @return <code>true</code> if this concessionnaire produit is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this concessionnaire produit is active.
	 *
	 * @param active the active of this concessionnaire produit
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the code of this concessionnaire produit.
	 *
	 * @param code the code of this concessionnaire produit
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the concessionnaire code of this concessionnaire produit.
	 *
	 * @param concessionnaireCode the concessionnaire code of this concessionnaire produit
	 */
	@Override
	public void setConcessionnaireCode(String concessionnaireCode) {
		model.setConcessionnaireCode(concessionnaireCode);
	}

	/**
	 * Sets the concessionnaire ID of this concessionnaire produit.
	 *
	 * @param concessionnaireId the concessionnaire ID of this concessionnaire produit
	 */
	@Override
	public void setConcessionnaireId(long concessionnaireId) {
		model.setConcessionnaireId(concessionnaireId);
	}

	/**
	 * Sets the created at of this concessionnaire produit.
	 *
	 * @param createdAt the created at of this concessionnaire produit
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the ID of this concessionnaire produit.
	 *
	 * @param id the ID of this concessionnaire produit
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this concessionnaire produit.
	 *
	 * @param primaryKey the primary key of this concessionnaire produit
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the produit ID of this concessionnaire produit.
	 *
	 * @param produitId the produit ID of this concessionnaire produit
	 */
	@Override
	public void setProduitId(long produitId) {
		model.setProduitId(produitId);
	}

	/**
	 * Sets the site ID of this concessionnaire produit.
	 *
	 * @param siteId the site ID of this concessionnaire produit
	 */
	@Override
	public void setSiteId(long siteId) {
		model.setSiteId(siteId);
	}

	/**
	 * Sets the updated at of this concessionnaire produit.
	 *
	 * @param updatedAt the updated at of this concessionnaire produit
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
	protected ConcessionnaireProduitWrapper wrap(
		ConcessionnaireProduit concessionnaireProduit) {

		return new ConcessionnaireProduitWrapper(concessionnaireProduit);
	}

}