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
 * This class is a wrapper for {@link Operation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Operation
 * @generated
 */
public class OperationWrapper
	extends BaseModelWrapper<Operation>
	implements ModelWrapper<Operation>, Operation {

	public OperationWrapper(Operation operation) {
		super(operation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("code", getCode());
		attributes.put("libelle", getLibelle());
		attributes.put("reference", getReference());
		attributes.put("montant", getMontant());
		attributes.put("montantReel", getMontantReel());
		attributes.put("statut", getStatut());
		attributes.put("terminalId", getTerminalId());
		attributes.put("guichet", getGuichet());
		attributes.put("dateOperation", getDateOperation());
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

		String reference = (String)attributes.get("reference");

		if (reference != null) {
			setReference(reference);
		}

		Long montant = (Long)attributes.get("montant");

		if (montant != null) {
			setMontant(montant);
		}

		Long montantReel = (Long)attributes.get("montantReel");

		if (montantReel != null) {
			setMontantReel(montantReel);
		}

		String statut = (String)attributes.get("statut");

		if (statut != null) {
			setStatut(statut);
		}

		Long terminalId = (Long)attributes.get("terminalId");

		if (terminalId != null) {
			setTerminalId(terminalId);
		}

		String guichet = (String)attributes.get("guichet");

		if (guichet != null) {
			setGuichet(guichet);
		}

		Date dateOperation = (Date)attributes.get("dateOperation");

		if (dateOperation != null) {
			setDateOperation(dateOperation);
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
	public Operation cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the code of this operation.
	 *
	 * @return the code of this operation
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the created at of this operation.
	 *
	 * @return the created at of this operation
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the date operation of this operation.
	 *
	 * @return the date operation of this operation
	 */
	@Override
	public Date getDateOperation() {
		return model.getDateOperation();
	}

	/**
	 * Returns the guichet of this operation.
	 *
	 * @return the guichet of this operation
	 */
	@Override
	public String getGuichet() {
		return model.getGuichet();
	}

	/**
	 * Returns the ID of this operation.
	 *
	 * @return the ID of this operation
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the libelle of this operation.
	 *
	 * @return the libelle of this operation
	 */
	@Override
	public String getLibelle() {
		return model.getLibelle();
	}

	/**
	 * Returns the montant of this operation.
	 *
	 * @return the montant of this operation
	 */
	@Override
	public long getMontant() {
		return model.getMontant();
	}

	/**
	 * Returns the montant reel of this operation.
	 *
	 * @return the montant reel of this operation
	 */
	@Override
	public long getMontantReel() {
		return model.getMontantReel();
	}

	/**
	 * Returns the primary key of this operation.
	 *
	 * @return the primary key of this operation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reference of this operation.
	 *
	 * @return the reference of this operation
	 */
	@Override
	public String getReference() {
		return model.getReference();
	}

	/**
	 * Returns the statut of this operation.
	 *
	 * @return the statut of this operation
	 */
	@Override
	public String getStatut() {
		return model.getStatut();
	}

	/**
	 * Returns the terminal ID of this operation.
	 *
	 * @return the terminal ID of this operation
	 */
	@Override
	public long getTerminalId() {
		return model.getTerminalId();
	}

	/**
	 * Returns the updated at of this operation.
	 *
	 * @return the updated at of this operation
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
	 * Sets the code of this operation.
	 *
	 * @param code the code of this operation
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the created at of this operation.
	 *
	 * @param createdAt the created at of this operation
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the date operation of this operation.
	 *
	 * @param dateOperation the date operation of this operation
	 */
	@Override
	public void setDateOperation(Date dateOperation) {
		model.setDateOperation(dateOperation);
	}

	/**
	 * Sets the guichet of this operation.
	 *
	 * @param guichet the guichet of this operation
	 */
	@Override
	public void setGuichet(String guichet) {
		model.setGuichet(guichet);
	}

	/**
	 * Sets the ID of this operation.
	 *
	 * @param id the ID of this operation
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the libelle of this operation.
	 *
	 * @param libelle the libelle of this operation
	 */
	@Override
	public void setLibelle(String libelle) {
		model.setLibelle(libelle);
	}

	/**
	 * Sets the montant of this operation.
	 *
	 * @param montant the montant of this operation
	 */
	@Override
	public void setMontant(long montant) {
		model.setMontant(montant);
	}

	/**
	 * Sets the montant reel of this operation.
	 *
	 * @param montantReel the montant reel of this operation
	 */
	@Override
	public void setMontantReel(long montantReel) {
		model.setMontantReel(montantReel);
	}

	/**
	 * Sets the primary key of this operation.
	 *
	 * @param primaryKey the primary key of this operation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reference of this operation.
	 *
	 * @param reference the reference of this operation
	 */
	@Override
	public void setReference(String reference) {
		model.setReference(reference);
	}

	/**
	 * Sets the statut of this operation.
	 *
	 * @param statut the statut of this operation
	 */
	@Override
	public void setStatut(String statut) {
		model.setStatut(statut);
	}

	/**
	 * Sets the terminal ID of this operation.
	 *
	 * @param terminalId the terminal ID of this operation
	 */
	@Override
	public void setTerminalId(long terminalId) {
		model.setTerminalId(terminalId);
	}

	/**
	 * Sets the updated at of this operation.
	 *
	 * @param updatedAt the updated at of this operation
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
	protected OperationWrapper wrap(Operation operation) {
		return new OperationWrapper(operation);
	}

}