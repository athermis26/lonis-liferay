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
 * This class is a wrapper for {@link Site}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Site
 * @generated
 */
public class SiteWrapper
	extends BaseModelWrapper<Site> implements ModelWrapper<Site>, Site {

	public SiteWrapper(Site site) {
		super(site);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("libelle", getLibelle());
		attributes.put("type", getType());
		attributes.put("parentId", getParentId());
		attributes.put("code", getCode());
		attributes.put("codeProvinov", getCodeProvinov());
		attributes.put("status", isStatus());
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

		String libelle = (String)attributes.get("libelle");

		if (libelle != null) {
			setLibelle(libelle);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String codeProvinov = (String)attributes.get("codeProvinov");

		if (codeProvinov != null) {
			setCodeProvinov(codeProvinov);
		}

		Boolean status = (Boolean)attributes.get("status");

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
	public Site cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the code of this site.
	 *
	 * @return the code of this site
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the code provinov of this site.
	 *
	 * @return the code provinov of this site
	 */
	@Override
	public String getCodeProvinov() {
		return model.getCodeProvinov();
	}

	/**
	 * Returns the created at of this site.
	 *
	 * @return the created at of this site
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the ID of this site.
	 *
	 * @return the ID of this site
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the libelle of this site.
	 *
	 * @return the libelle of this site
	 */
	@Override
	public String getLibelle() {
		return model.getLibelle();
	}

	/**
	 * Returns the parent ID of this site.
	 *
	 * @return the parent ID of this site
	 */
	@Override
	public long getParentId() {
		return model.getParentId();
	}

	/**
	 * Returns the primary key of this site.
	 *
	 * @return the primary key of this site
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this site.
	 *
	 * @return the status of this site
	 */
	@Override
	public boolean getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the type of this site.
	 *
	 * @return the type of this site
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the updated at of this site.
	 *
	 * @return the updated at of this site
	 */
	@Override
	public Date getUpdatedAt() {
		return model.getUpdatedAt();
	}

	/**
	 * Returns <code>true</code> if this site is status.
	 *
	 * @return <code>true</code> if this site is status; <code>false</code> otherwise
	 */
	@Override
	public boolean isStatus() {
		return model.isStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the code of this site.
	 *
	 * @param code the code of this site
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the code provinov of this site.
	 *
	 * @param codeProvinov the code provinov of this site
	 */
	@Override
	public void setCodeProvinov(String codeProvinov) {
		model.setCodeProvinov(codeProvinov);
	}

	/**
	 * Sets the created at of this site.
	 *
	 * @param createdAt the created at of this site
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the ID of this site.
	 *
	 * @param id the ID of this site
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the libelle of this site.
	 *
	 * @param libelle the libelle of this site
	 */
	@Override
	public void setLibelle(String libelle) {
		model.setLibelle(libelle);
	}

	/**
	 * Sets the parent ID of this site.
	 *
	 * @param parentId the parent ID of this site
	 */
	@Override
	public void setParentId(long parentId) {
		model.setParentId(parentId);
	}

	/**
	 * Sets the primary key of this site.
	 *
	 * @param primaryKey the primary key of this site
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this site is status.
	 *
	 * @param status the status of this site
	 */
	@Override
	public void setStatus(boolean status) {
		model.setStatus(status);
	}

	/**
	 * Sets the type of this site.
	 *
	 * @param type the type of this site
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the updated at of this site.
	 *
	 * @param updatedAt the updated at of this site
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
	protected SiteWrapper wrap(Site site) {
		return new SiteWrapper(site);
	}

}