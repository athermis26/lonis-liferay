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
 * This class is a wrapper for {@link ChiffreAffaires}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChiffreAffaires
 * @generated
 */
public class ChiffreAffairesWrapper
	extends BaseModelWrapper<ChiffreAffaires>
	implements ChiffreAffaires, ModelWrapper<ChiffreAffaires> {

	public ChiffreAffairesWrapper(ChiffreAffaires chiffreAffaires) {
		super(chiffreAffaires);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("terminalId", getTerminalId());
		attributes.put("brut", getBrut());
		attributes.put("paiement", getPaiement());
		attributes.put("annulation", getAnnulation());
		attributes.put("remboursement", getRemboursement());
		attributes.put("ventes", getVentes());
		attributes.put("balance", getBalance());
		attributes.put("deposit", getDeposit());
		attributes.put("date", getDate());
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

		Long terminalId = (Long)attributes.get("terminalId");

		if (terminalId != null) {
			setTerminalId(terminalId);
		}

		Long brut = (Long)attributes.get("brut");

		if (brut != null) {
			setBrut(brut);
		}

		Long paiement = (Long)attributes.get("paiement");

		if (paiement != null) {
			setPaiement(paiement);
		}

		Long annulation = (Long)attributes.get("annulation");

		if (annulation != null) {
			setAnnulation(annulation);
		}

		Long remboursement = (Long)attributes.get("remboursement");

		if (remboursement != null) {
			setRemboursement(remboursement);
		}

		Long ventes = (Long)attributes.get("ventes");

		if (ventes != null) {
			setVentes(ventes);
		}

		Long balance = (Long)attributes.get("balance");

		if (balance != null) {
			setBalance(balance);
		}

		Long deposit = (Long)attributes.get("deposit");

		if (deposit != null) {
			setDeposit(deposit);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
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
	public ChiffreAffaires cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the annulation of this chiffre affaires.
	 *
	 * @return the annulation of this chiffre affaires
	 */
	@Override
	public long getAnnulation() {
		return model.getAnnulation();
	}

	/**
	 * Returns the balance of this chiffre affaires.
	 *
	 * @return the balance of this chiffre affaires
	 */
	@Override
	public long getBalance() {
		return model.getBalance();
	}

	/**
	 * Returns the brut of this chiffre affaires.
	 *
	 * @return the brut of this chiffre affaires
	 */
	@Override
	public long getBrut() {
		return model.getBrut();
	}

	/**
	 * Returns the created at of this chiffre affaires.
	 *
	 * @return the created at of this chiffre affaires
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the date of this chiffre affaires.
	 *
	 * @return the date of this chiffre affaires
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the deposit of this chiffre affaires.
	 *
	 * @return the deposit of this chiffre affaires
	 */
	@Override
	public long getDeposit() {
		return model.getDeposit();
	}

	/**
	 * Returns the ID of this chiffre affaires.
	 *
	 * @return the ID of this chiffre affaires
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the paiement of this chiffre affaires.
	 *
	 * @return the paiement of this chiffre affaires
	 */
	@Override
	public long getPaiement() {
		return model.getPaiement();
	}

	/**
	 * Returns the primary key of this chiffre affaires.
	 *
	 * @return the primary key of this chiffre affaires
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the remboursement of this chiffre affaires.
	 *
	 * @return the remboursement of this chiffre affaires
	 */
	@Override
	public long getRemboursement() {
		return model.getRemboursement();
	}

	/**
	 * Returns the terminal ID of this chiffre affaires.
	 *
	 * @return the terminal ID of this chiffre affaires
	 */
	@Override
	public long getTerminalId() {
		return model.getTerminalId();
	}

	/**
	 * Returns the updated at of this chiffre affaires.
	 *
	 * @return the updated at of this chiffre affaires
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns the ventes of this chiffre affaires.
	 *
	 * @return the ventes of this chiffre affaires
	 */
	@Override
	public long getVentes() {
		return model.getVentes();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the annulation of this chiffre affaires.
	 *
	 * @param annulation the annulation of this chiffre affaires
	 */
	@Override
	public void setAnnulation(long annulation) {
		model.setAnnulation(annulation);
	}

	/**
	 * Sets the balance of this chiffre affaires.
	 *
	 * @param balance the balance of this chiffre affaires
	 */
	@Override
	public void setBalance(long balance) {
		model.setBalance(balance);
	}

	/**
	 * Sets the brut of this chiffre affaires.
	 *
	 * @param brut the brut of this chiffre affaires
	 */
	@Override
	public void setBrut(long brut) {
		model.setBrut(brut);
	}

	/**
	 * Sets the created at of this chiffre affaires.
	 *
	 * @param createdAt the created at of this chiffre affaires
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the date of this chiffre affaires.
	 *
	 * @param date the date of this chiffre affaires
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the deposit of this chiffre affaires.
	 *
	 * @param deposit the deposit of this chiffre affaires
	 */
	@Override
	public void setDeposit(long deposit) {
		model.setDeposit(deposit);
	}

	/**
	 * Sets the ID of this chiffre affaires.
	 *
	 * @param id the ID of this chiffre affaires
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the paiement of this chiffre affaires.
	 *
	 * @param paiement the paiement of this chiffre affaires
	 */
	@Override
	public void setPaiement(long paiement) {
		model.setPaiement(paiement);
	}

	/**
	 * Sets the primary key of this chiffre affaires.
	 *
	 * @param primaryKey the primary key of this chiffre affaires
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the remboursement of this chiffre affaires.
	 *
	 * @param remboursement the remboursement of this chiffre affaires
	 */
	@Override
	public void setRemboursement(long remboursement) {
		model.setRemboursement(remboursement);
	}

	/**
	 * Sets the terminal ID of this chiffre affaires.
	 *
	 * @param terminalId the terminal ID of this chiffre affaires
	 */
	@Override
	public void setTerminalId(long terminalId) {
		model.setTerminalId(terminalId);
	}

	/**
	 * Sets the updated at of this chiffre affaires.
	 *
	 * @param updatedAt the updated at of this chiffre affaires
	 */
	@Override
	public void setUpdatedAt(Date updatedAt) {
		model.setUpdatedAt(updatedAt);
	}

	/**
	 * Sets the ventes of this chiffre affaires.
	 *
	 * @param ventes the ventes of this chiffre affaires
	 */
	@Override
	public void setVentes(long ventes) {
		model.setVentes(ventes);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ChiffreAffairesWrapper wrap(ChiffreAffaires chiffreAffaires) {
		return new ChiffreAffairesWrapper(chiffreAffaires);
	}

}