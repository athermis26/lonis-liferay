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
 * This class is a wrapper for {@link SiteCommercial}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteCommercial
 * @generated
 */
public class SiteCommercialWrapper
	extends BaseModelWrapper<SiteCommercial>
	implements ModelWrapper<SiteCommercial>, SiteCommercial {

	public SiteCommercialWrapper(SiteCommercial siteCommercial) {
		super(siteCommercial);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("siteId", getSiteId());
		attributes.put("commercialId", getCommercialId());
		attributes.put("dateDebut", getDateDebut());
		attributes.put("dateFin", getDateFin());
		attributes.put("isPrincipal", isIsPrincipal());
		attributes.put("createdAt", getCreatedAt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long siteId = (Long)attributes.get("siteId");

		if (siteId != null) {
			setSiteId(siteId);
		}

		Long commercialId = (Long)attributes.get("commercialId");

		if (commercialId != null) {
			setCommercialId(commercialId);
		}

		Date dateDebut = (Date)attributes.get("dateDebut");

		if (dateDebut != null) {
			setDateDebut(dateDebut);
		}

		Date dateFin = (Date)attributes.get("dateFin");

		if (dateFin != null) {
			setDateFin(dateFin);
		}

		Boolean isPrincipal = (Boolean)attributes.get("isPrincipal");

		if (isPrincipal != null) {
			setIsPrincipal(isPrincipal);
		}

		Date createdAt = (Date)attributes.get("createdAt");

		if (createdAt != null) {
			setCreatedAt(createdAt);
		}
	}

	@Override
	public SiteCommercial cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the commercial ID of this site commercial.
	 *
	 * @return the commercial ID of this site commercial
	 */
	@Override
	public long getCommercialId() {
		return model.getCommercialId();
	}

	/**
	 * Returns the created at of this site commercial.
	 *
	 * @return the created at of this site commercial
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the date debut of this site commercial.
	 *
	 * @return the date debut of this site commercial
	 */
	@Override
	public Date getDateDebut() {
		return model.getDateDebut();
	}

	/**
	 * Returns the date fin of this site commercial.
	 *
	 * @return the date fin of this site commercial
	 */
	@Override
	public Date getDateFin() {
		return model.getDateFin();
	}

	/**
	 * Returns the ID of this site commercial.
	 *
	 * @return the ID of this site commercial
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the is principal of this site commercial.
	 *
	 * @return the is principal of this site commercial
	 */
	@Override
	public boolean getIsPrincipal() {
		return model.getIsPrincipal();
	}

	/**
	 * Returns the primary key of this site commercial.
	 *
	 * @return the primary key of this site commercial
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the site ID of this site commercial.
	 *
	 * @return the site ID of this site commercial
	 */
	@Override
	public long getSiteId() {
		return model.getSiteId();
	}

	/**
	 * Returns <code>true</code> if this site commercial is is principal.
	 *
	 * @return <code>true</code> if this site commercial is is principal; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsPrincipal() {
		return model.isIsPrincipal();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the commercial ID of this site commercial.
	 *
	 * @param commercialId the commercial ID of this site commercial
	 */
	@Override
	public void setCommercialId(long commercialId) {
		model.setCommercialId(commercialId);
	}

	/**
	 * Sets the created at of this site commercial.
	 *
	 * @param createdAt the created at of this site commercial
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the date debut of this site commercial.
	 *
	 * @param dateDebut the date debut of this site commercial
	 */
	@Override
	public void setDateDebut(Date dateDebut) {
		model.setDateDebut(dateDebut);
	}

	/**
	 * Sets the date fin of this site commercial.
	 *
	 * @param dateFin the date fin of this site commercial
	 */
	@Override
	public void setDateFin(Date dateFin) {
		model.setDateFin(dateFin);
	}

	/**
	 * Sets the ID of this site commercial.
	 *
	 * @param id the ID of this site commercial
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets whether this site commercial is is principal.
	 *
	 * @param isPrincipal the is principal of this site commercial
	 */
	@Override
	public void setIsPrincipal(boolean isPrincipal) {
		model.setIsPrincipal(isPrincipal);
	}

	/**
	 * Sets the primary key of this site commercial.
	 *
	 * @param primaryKey the primary key of this site commercial
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the site ID of this site commercial.
	 *
	 * @param siteId the site ID of this site commercial
	 */
	@Override
	public void setSiteId(long siteId) {
		model.setSiteId(siteId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SiteCommercialWrapper wrap(SiteCommercial siteCommercial) {
		return new SiteCommercialWrapper(siteCommercial);
	}

}