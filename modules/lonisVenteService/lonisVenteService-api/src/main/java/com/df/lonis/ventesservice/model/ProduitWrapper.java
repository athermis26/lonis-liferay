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
 * This class is a wrapper for {@link Produit}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Produit
 * @generated
 */
public class ProduitWrapper
	extends BaseModelWrapper<Produit>
	implements ModelWrapper<Produit>, Produit {

	public ProduitWrapper(Produit produit) {
		super(produit);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("code", getCode());
		attributes.put("libelle", getLibelle());
		attributes.put("abreviation", getAbreviation());
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String libelle = (String)attributes.get("libelle");

		if (libelle != null) {
			setLibelle(libelle);
		}

		String abreviation = (String)attributes.get("abreviation");

		if (abreviation != null) {
			setAbreviation(abreviation);
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
	public Produit cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the abreviation of this produit.
	 *
	 * @return the abreviation of this produit
	 */
	@Override
	public String getAbreviation() {
		return model.getAbreviation();
	}

	/**
	 * Returns the active of this produit.
	 *
	 * @return the active of this produit
	 */
	@Override
	public boolean getActive() {
		return model.getActive();
	}

	/**
	 * Returns the code of this produit.
	 *
	 * @return the code of this produit
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the created at of this produit.
	 *
	 * @return the created at of this produit
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the ID of this produit.
	 *
	 * @return the ID of this produit
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the libelle of this produit.
	 *
	 * @return the libelle of this produit
	 */
	@Override
	public String getLibelle() {
		return model.getLibelle();
	}

	/**
	 * Returns the primary key of this produit.
	 *
	 * @return the primary key of this produit
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the updated at of this produit.
	 *
	 * @return the updated at of this produit
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns <code>true</code> if this produit is active.
	 *
	 * @return <code>true</code> if this produit is active; <code>false</code> otherwise
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
	 * Sets the abreviation of this produit.
	 *
	 * @param abreviation the abreviation of this produit
	 */
	@Override
	public void setAbreviation(String abreviation) {
		model.setAbreviation(abreviation);
	}

	/**
	 * Sets whether this produit is active.
	 *
	 * @param active the active of this produit
	 */
	@Override
	public void setActive(boolean active) {
		model.setActive(active);
	}

	/**
	 * Sets the code of this produit.
	 *
	 * @param code the code of this produit
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the created at of this produit.
	 *
	 * @param createdAt the created at of this produit
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the ID of this produit.
	 *
	 * @param id the ID of this produit
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the libelle of this produit.
	 *
	 * @param libelle the libelle of this produit
	 */
	@Override
	public void setLibelle(String libelle) {
		model.setLibelle(libelle);
	}

	/**
	 * Sets the primary key of this produit.
	 *
	 * @param primaryKey the primary key of this produit
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the updated at of this produit.
	 *
	 * @param updatedAt the updated at of this produit
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
	protected ProduitWrapper wrap(Produit produit) {
		return new ProduitWrapper(produit);
	}

}