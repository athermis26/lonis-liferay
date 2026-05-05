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
 * This class is a wrapper for {@link Terminal}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Terminal
 * @generated
 */
public class TerminalWrapper
	extends BaseModelWrapper<Terminal>
	implements ModelWrapper<Terminal>, Terminal {

	public TerminalWrapper(Terminal terminal) {
		super(terminal);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("codeTerminal", getCodeTerminal());
		attributes.put("concessionnaireId", getConcessionnaireId());
		attributes.put("concessionnaireCode", getConcessionnaireCode());
		attributes.put("produitId", getProduitId());
		attributes.put(
			"concessionnaireProduitCode", getConcessionnaireProduitCode());
		attributes.put("siteId", getSiteId());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("adresse", getAdresse());
		attributes.put("statutValidation", getStatutValidation());
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

		String codeTerminal = (String)attributes.get("codeTerminal");

		if (codeTerminal != null) {
			setCodeTerminal(codeTerminal);
		}

		Long concessionnaireId = (Long)attributes.get("concessionnaireId");

		if (concessionnaireId != null) {
			setConcessionnaireId(concessionnaireId);
		}

		String concessionnaireCode = (String)attributes.get(
			"concessionnaireCode");

		if (concessionnaireCode != null) {
			setConcessionnaireCode(concessionnaireCode);
		}

		Long produitId = (Long)attributes.get("produitId");

		if (produitId != null) {
			setProduitId(produitId);
		}

		String concessionnaireProduitCode = (String)attributes.get(
			"concessionnaireProduitCode");

		if (concessionnaireProduitCode != null) {
			setConcessionnaireProduitCode(concessionnaireProduitCode);
		}

		Long siteId = (Long)attributes.get("siteId");

		if (siteId != null) {
			setSiteId(siteId);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String adresse = (String)attributes.get("adresse");

		if (adresse != null) {
			setAdresse(adresse);
		}

		String statutValidation = (String)attributes.get("statutValidation");

		if (statutValidation != null) {
			setStatutValidation(statutValidation);
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
	public Terminal cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the adresse of this terminal.
	 *
	 * @return the adresse of this terminal
	 */
	@Override
	public String getAdresse() {
		return model.getAdresse();
	}

	/**
	 * Returns the code terminal of this terminal.
	 *
	 * @return the code terminal of this terminal
	 */
	@Override
	public String getCodeTerminal() {
		return model.getCodeTerminal();
	}

	/**
	 * Returns the concessionnaire code of this terminal.
	 *
	 * @return the concessionnaire code of this terminal
	 */
	@Override
	public String getConcessionnaireCode() {
		return model.getConcessionnaireCode();
	}

	/**
	 * Returns the concessionnaire ID of this terminal.
	 *
	 * @return the concessionnaire ID of this terminal
	 */
	@Override
	public long getConcessionnaireId() {
		return model.getConcessionnaireId();
	}

	/**
	 * Returns the concessionnaire produit code of this terminal.
	 *
	 * @return the concessionnaire produit code of this terminal
	 */
	@Override
	public String getConcessionnaireProduitCode() {
		return model.getConcessionnaireProduitCode();
	}

	/**
	 * Returns the created at of this terminal.
	 *
	 * @return the created at of this terminal
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the ID of this terminal.
	 *
	 * @return the ID of this terminal
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the latitude of this terminal.
	 *
	 * @return the latitude of this terminal
	 */
	@Override
	public Double getLatitude() {
		return model.getLatitude();
	}

	/**
	 * Returns the longitude of this terminal.
	 *
	 * @return the longitude of this terminal
	 */
	@Override
	public Double getLongitude() {
		return model.getLongitude();
	}

	/**
	 * Returns the primary key of this terminal.
	 *
	 * @return the primary key of this terminal
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the produit ID of this terminal.
	 *
	 * @return the produit ID of this terminal
	 */
	@Override
	public long getProduitId() {
		return model.getProduitId();
	}

	/**
	 * Returns the site ID of this terminal.
	 *
	 * @return the site ID of this terminal
	 */
	@Override
	public long getSiteId() {
		return model.getSiteId();
	}

	/**
	 * Returns the statut validation of this terminal.
	 *
	 * @return the statut validation of this terminal
	 */
	@Override
	public String getStatutValidation() {
		return model.getStatutValidation();
	}

	/**
	 * Returns the updated at of this terminal.
	 *
	 * @return the updated at of this terminal
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
	 * Sets the adresse of this terminal.
	 *
	 * @param adresse the adresse of this terminal
	 */
	@Override
	public void setAdresse(String adresse) {
		model.setAdresse(adresse);
	}

	/**
	 * Sets the code terminal of this terminal.
	 *
	 * @param codeTerminal the code terminal of this terminal
	 */
	@Override
	public void setCodeTerminal(String codeTerminal) {
		model.setCodeTerminal(codeTerminal);
	}

	/**
	 * Sets the concessionnaire code of this terminal.
	 *
	 * @param concessionnaireCode the concessionnaire code of this terminal
	 */
	@Override
	public void setConcessionnaireCode(String concessionnaireCode) {
		model.setConcessionnaireCode(concessionnaireCode);
	}

	/**
	 * Sets the concessionnaire ID of this terminal.
	 *
	 * @param concessionnaireId the concessionnaire ID of this terminal
	 */
	@Override
	public void setConcessionnaireId(long concessionnaireId) {
		model.setConcessionnaireId(concessionnaireId);
	}

	/**
	 * Sets the concessionnaire produit code of this terminal.
	 *
	 * @param concessionnaireProduitCode the concessionnaire produit code of this terminal
	 */
	@Override
	public void setConcessionnaireProduitCode(
		String concessionnaireProduitCode) {

		model.setConcessionnaireProduitCode(concessionnaireProduitCode);
	}

	/**
	 * Sets the created at of this terminal.
	 *
	 * @param createdAt the created at of this terminal
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the ID of this terminal.
	 *
	 * @param id the ID of this terminal
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the latitude of this terminal.
	 *
	 * @param latitude the latitude of this terminal
	 */
	@Override
	public void setLatitude(Double latitude) {
		model.setLatitude(latitude);
	}

	/**
	 * Sets the longitude of this terminal.
	 *
	 * @param longitude the longitude of this terminal
	 */
	@Override
	public void setLongitude(Double longitude) {
		model.setLongitude(longitude);
	}

	/**
	 * Sets the primary key of this terminal.
	 *
	 * @param primaryKey the primary key of this terminal
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the produit ID of this terminal.
	 *
	 * @param produitId the produit ID of this terminal
	 */
	@Override
	public void setProduitId(long produitId) {
		model.setProduitId(produitId);
	}

	/**
	 * Sets the site ID of this terminal.
	 *
	 * @param siteId the site ID of this terminal
	 */
	@Override
	public void setSiteId(long siteId) {
		model.setSiteId(siteId);
	}

	/**
	 * Sets the statut validation of this terminal.
	 *
	 * @param statutValidation the statut validation of this terminal
	 */
	@Override
	public void setStatutValidation(String statutValidation) {
		model.setStatutValidation(statutValidation);
	}

	/**
	 * Sets the updated at of this terminal.
	 *
	 * @param updatedAt the updated at of this terminal
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
	protected TerminalWrapper wrap(Terminal terminal) {
		return new TerminalWrapper(terminal);
	}

}