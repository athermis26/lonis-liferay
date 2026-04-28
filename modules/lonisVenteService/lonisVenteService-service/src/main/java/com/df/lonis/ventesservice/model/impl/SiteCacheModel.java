/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model.impl;

import com.df.lonis.ventesservice.model.Site;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Site in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SiteCacheModel implements CacheModel<Site>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SiteCacheModel)) {
			return false;
		}

		SiteCacheModel siteCacheModel = (SiteCacheModel)object;

		if (id == siteCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", libelle=");
		sb.append(libelle);
		sb.append(", type=");
		sb.append(type);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", codeProvinov=");
		sb.append(codeProvinov);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Site toEntityModel() {
		SiteImpl siteImpl = new SiteImpl();

		siteImpl.setId(id);

		if (libelle == null) {
			siteImpl.setLibelle("");
		}
		else {
			siteImpl.setLibelle(libelle);
		}

		siteImpl.setType(type);
		siteImpl.setParentId(parentId);

		if (code == null) {
			siteImpl.setCode("");
		}
		else {
			siteImpl.setCode(code);
		}

		if (codeProvinov == null) {
			siteImpl.setCodeProvinov("");
		}
		else {
			siteImpl.setCodeProvinov(codeProvinov);
		}

		siteImpl.setStatus(status);

		if (createdAt == Long.MIN_VALUE) {
			siteImpl.setCreatedAt(null);
		}
		else {
			siteImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			siteImpl.setUpdatedAt(null);
		}
		else {
			siteImpl.setUpdatedAt(new Date(updatedAt));
		}

		siteImpl.resetOriginalValues();

		return siteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		libelle = objectInput.readUTF();

		type = objectInput.readInt();

		parentId = objectInput.readLong();
		code = objectInput.readUTF();
		codeProvinov = objectInput.readUTF();

		status = objectInput.readBoolean();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (libelle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(libelle);
		}

		objectOutput.writeInt(type);

		objectOutput.writeLong(parentId);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (codeProvinov == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codeProvinov);
		}

		objectOutput.writeBoolean(status);
		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);
	}

	public long id;
	public String libelle;
	public int type;
	public long parentId;
	public String code;
	public String codeProvinov;
	public boolean status;
	public long createdAt;
	public long updatedAt;

}