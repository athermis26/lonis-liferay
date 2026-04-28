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
 * This class is a wrapper for {@link Commission}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Commission
 * @generated
 */
public class CommissionWrapper
	extends BaseModelWrapper<Commission>
	implements Commission, ModelWrapper<Commission> {

	public CommissionWrapper(Commission commission) {
		super(commission);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("code", getCode());
		attributes.put("terminalId", getTerminalId());
		attributes.put("nombreTerminal", getNombreTerminal());
		attributes.put("paye", isPaye());
		attributes.put("libelle", getLibelle());
		attributes.put("status", getStatus());
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

		Long terminalId = (Long)attributes.get("terminalId");

		if (terminalId != null) {
			setTerminalId(terminalId);
		}

		Integer nombreTerminal = (Integer)attributes.get("nombreTerminal");

		if (nombreTerminal != null) {
			setNombreTerminal(nombreTerminal);
		}

		Boolean paye = (Boolean)attributes.get("paye");

		if (paye != null) {
			setPaye(paye);
		}

		String libelle = (String)attributes.get("libelle");

		if (libelle != null) {
			setLibelle(libelle);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
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
	public Commission cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the code of this commission.
	 *
	 * @return the code of this commission
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the created at of this commission.
	 *
	 * @return the created at of this commission
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the ID of this commission.
	 *
	 * @return the ID of this commission
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the libelle of this commission.
	 *
	 * @return the libelle of this commission
	 */
	@Override
	public String getLibelle() {
		return model.getLibelle();
	}

	/**
	 * Returns the nombre terminal of this commission.
	 *
	 * @return the nombre terminal of this commission
	 */
	@Override
	public int getNombreTerminal() {
		return model.getNombreTerminal();
	}

	/**
	 * Returns the paye of this commission.
	 *
	 * @return the paye of this commission
	 */
	@Override
	public boolean getPaye() {
		return model.getPaye();
	}

	/**
	 * Returns the primary key of this commission.
	 *
	 * @return the primary key of this commission
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this commission.
	 *
	 * @return the status of this commission
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the terminal ID of this commission.
	 *
	 * @return the terminal ID of this commission
	 */
	@Override
	public long getTerminalId() {
		return model.getTerminalId();
	}

	/**
	 * Returns the updated at of this commission.
	 *
	 * @return the updated at of this commission
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns <code>true</code> if this commission is paye.
	 *
	 * @return <code>true</code> if this commission is paye; <code>false</code> otherwise
	 */
	@Override
	public boolean isPaye() {
		return model.isPaye();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the code of this commission.
	 *
	 * @param code the code of this commission
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the created at of this commission.
	 *
	 * @param createdAt the created at of this commission
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the ID of this commission.
	 *
	 * @param id the ID of this commission
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the libelle of this commission.
	 *
	 * @param libelle the libelle of this commission
	 */
	@Override
	public void setLibelle(String libelle) {
		model.setLibelle(libelle);
	}

	/**
	 * Sets the nombre terminal of this commission.
	 *
	 * @param nombreTerminal the nombre terminal of this commission
	 */
	@Override
	public void setNombreTerminal(int nombreTerminal) {
		model.setNombreTerminal(nombreTerminal);
	}

	/**
	 * Sets whether this commission is paye.
	 *
	 * @param paye the paye of this commission
	 */
	@Override
	public void setPaye(boolean paye) {
		model.setPaye(paye);
	}

	/**
	 * Sets the primary key of this commission.
	 *
	 * @param primaryKey the primary key of this commission
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this commission.
	 *
	 * @param status the status of this commission
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the terminal ID of this commission.
	 *
	 * @param terminalId the terminal ID of this commission
	 */
	@Override
	public void setTerminalId(long terminalId) {
		model.setTerminalId(terminalId);
	}

	/**
	 * Sets the updated at of this commission.
	 *
	 * @param updatedAt the updated at of this commission
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
	protected CommissionWrapper wrap(Commission commission) {
		return new CommissionWrapper(commission);
	}

}