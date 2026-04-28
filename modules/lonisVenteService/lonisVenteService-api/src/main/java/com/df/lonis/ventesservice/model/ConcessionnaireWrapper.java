/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Concessionnaire}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Concessionnaire
 * @generated
 */
public class ConcessionnaireWrapper
	extends BaseModelWrapper<Concessionnaire>
	implements Concessionnaire, ModelWrapper<Concessionnaire> {

	public ConcessionnaireWrapper(Concessionnaire concessionnaire) {
		super(concessionnaire);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("uid", getUid());
		attributes.put("nom", getNom());
		attributes.put("prenoms", getPrenoms());
		attributes.put("telephone", getTelephone());
		attributes.put("email", getEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String uid = (String)attributes.get("uid");

		if (uid != null) {
			setUid(uid);
		}

		String nom = (String)attributes.get("nom");

		if (nom != null) {
			setNom(nom);
		}

		String prenoms = (String)attributes.get("prenoms");

		if (prenoms != null) {
			setPrenoms(prenoms);
		}

		String telephone = (String)attributes.get("telephone");

		if (telephone != null) {
			setTelephone(telephone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}
	}

	@Override
	public Concessionnaire cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the email of this concessionnaire.
	 *
	 * @return the email of this concessionnaire
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the ID of this concessionnaire.
	 *
	 * @return the ID of this concessionnaire
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the nom of this concessionnaire.
	 *
	 * @return the nom of this concessionnaire
	 */
	@Override
	public String getNom() {
		return model.getNom();
	}

	/**
	 * Returns the prenoms of this concessionnaire.
	 *
	 * @return the prenoms of this concessionnaire
	 */
	@Override
	public String getPrenoms() {
		return model.getPrenoms();
	}

	/**
	 * Returns the primary key of this concessionnaire.
	 *
	 * @return the primary key of this concessionnaire
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the telephone of this concessionnaire.
	 *
	 * @return the telephone of this concessionnaire
	 */
	@Override
	public String getTelephone() {
		return model.getTelephone();
	}

	/**
	 * Returns the uid of this concessionnaire.
	 *
	 * @return the uid of this concessionnaire
	 */
	@Override
	public String getUid() {
		return model.getUid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the email of this concessionnaire.
	 *
	 * @param email the email of this concessionnaire
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the ID of this concessionnaire.
	 *
	 * @param id the ID of this concessionnaire
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the nom of this concessionnaire.
	 *
	 * @param nom the nom of this concessionnaire
	 */
	@Override
	public void setNom(String nom) {
		model.setNom(nom);
	}

	/**
	 * Sets the prenoms of this concessionnaire.
	 *
	 * @param prenoms the prenoms of this concessionnaire
	 */
	@Override
	public void setPrenoms(String prenoms) {
		model.setPrenoms(prenoms);
	}

	/**
	 * Sets the primary key of this concessionnaire.
	 *
	 * @param primaryKey the primary key of this concessionnaire
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the telephone of this concessionnaire.
	 *
	 * @param telephone the telephone of this concessionnaire
	 */
	@Override
	public void setTelephone(String telephone) {
		model.setTelephone(telephone);
	}

	/**
	 * Sets the uid of this concessionnaire.
	 *
	 * @param uid the uid of this concessionnaire
	 */
	@Override
	public void setUid(String uid) {
		model.setUid(uid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ConcessionnaireWrapper wrap(Concessionnaire concessionnaire) {
		return new ConcessionnaireWrapper(concessionnaire);
	}

}