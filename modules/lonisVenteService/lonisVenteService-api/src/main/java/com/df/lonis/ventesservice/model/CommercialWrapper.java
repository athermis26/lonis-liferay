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
 * This class is a wrapper for {@link Commercial}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Commercial
 * @generated
 */
public class CommercialWrapper
	extends BaseModelWrapper<Commercial>
	implements Commercial, ModelWrapper<Commercial> {

	public CommercialWrapper(Commercial commercial) {
		super(commercial);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nom", getNom());
		attributes.put("prenoms", getPrenoms());
		attributes.put("telephone", getTelephone());
		attributes.put("email", getEmail());
		attributes.put("matricule", getMatricule());
		attributes.put("statut", getStatut());
		attributes.put("superviseurId", getSuperviseurId());
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

		String matricule = (String)attributes.get("matricule");

		if (matricule != null) {
			setMatricule(matricule);
		}

		String statut = (String)attributes.get("statut");

		if (statut != null) {
			setStatut(statut);
		}

		Long superviseurId = (Long)attributes.get("superviseurId");

		if (superviseurId != null) {
			setSuperviseurId(superviseurId);
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
	public Commercial cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the created at of this commercial.
	 *
	 * @return the created at of this commercial
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the email of this commercial.
	 *
	 * @return the email of this commercial
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the ID of this commercial.
	 *
	 * @return the ID of this commercial
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the matricule of this commercial.
	 *
	 * @return the matricule of this commercial
	 */
	@Override
	public String getMatricule() {
		return model.getMatricule();
	}

	/**
	 * Returns the nom of this commercial.
	 *
	 * @return the nom of this commercial
	 */
	@Override
	public String getNom() {
		return model.getNom();
	}

	/**
	 * Returns the prenoms of this commercial.
	 *
	 * @return the prenoms of this commercial
	 */
	@Override
	public String getPrenoms() {
		return model.getPrenoms();
	}

	/**
	 * Returns the primary key of this commercial.
	 *
	 * @return the primary key of this commercial
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the statut of this commercial.
	 *
	 * @return the statut of this commercial
	 */
	@Override
	public String getStatut() {
		return model.getStatut();
	}

	/**
	 * Returns the superviseur ID of this commercial.
	 *
	 * @return the superviseur ID of this commercial
	 */
	@Override
	public long getSuperviseurId() {
		return model.getSuperviseurId();
	}

	/**
	 * Returns the telephone of this commercial.
	 *
	 * @return the telephone of this commercial
	 */
	@Override
	public String getTelephone() {
		return model.getTelephone();
	}

	/**
	 * Returns the updated at of this commercial.
	 *
	 * @return the updated at of this commercial
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
	 * Sets the created at of this commercial.
	 *
	 * @param createdAt the created at of this commercial
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the email of this commercial.
	 *
	 * @param email the email of this commercial
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the ID of this commercial.
	 *
	 * @param id the ID of this commercial
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the matricule of this commercial.
	 *
	 * @param matricule the matricule of this commercial
	 */
	@Override
	public void setMatricule(String matricule) {
		model.setMatricule(matricule);
	}

	/**
	 * Sets the nom of this commercial.
	 *
	 * @param nom the nom of this commercial
	 */
	@Override
	public void setNom(String nom) {
		model.setNom(nom);
	}

	/**
	 * Sets the prenoms of this commercial.
	 *
	 * @param prenoms the prenoms of this commercial
	 */
	@Override
	public void setPrenoms(String prenoms) {
		model.setPrenoms(prenoms);
	}

	/**
	 * Sets the primary key of this commercial.
	 *
	 * @param primaryKey the primary key of this commercial
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the statut of this commercial.
	 *
	 * @param statut the statut of this commercial
	 */
	@Override
	public void setStatut(String statut) {
		model.setStatut(statut);
	}

	/**
	 * Sets the superviseur ID of this commercial.
	 *
	 * @param superviseurId the superviseur ID of this commercial
	 */
	@Override
	public void setSuperviseurId(long superviseurId) {
		model.setSuperviseurId(superviseurId);
	}

	/**
	 * Sets the telephone of this commercial.
	 *
	 * @param telephone the telephone of this commercial
	 */
	@Override
	public void setTelephone(String telephone) {
		model.setTelephone(telephone);
	}

	/**
	 * Sets the updated at of this commercial.
	 *
	 * @param updatedAt the updated at of this commercial
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
	protected CommercialWrapper wrap(Commercial commercial) {
		return new CommercialWrapper(commercial);
	}

}