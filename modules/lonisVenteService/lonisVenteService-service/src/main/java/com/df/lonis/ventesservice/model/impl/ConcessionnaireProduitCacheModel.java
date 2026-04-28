/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model.impl;

import com.df.lonis.ventesservice.model.ConcessionnaireProduit;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ConcessionnaireProduit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ConcessionnaireProduitCacheModel
	implements CacheModel<ConcessionnaireProduit>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConcessionnaireProduitCacheModel)) {
			return false;
		}

		ConcessionnaireProduitCacheModel concessionnaireProduitCacheModel =
			(ConcessionnaireProduitCacheModel)object;

		if (id == concessionnaireProduitCacheModel.id) {
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
		sb.append(", concessionnaireId=");
		sb.append(concessionnaireId);
		sb.append(", produitId=");
		sb.append(produitId);
		sb.append(", siteId=");
		sb.append(siteId);
		sb.append(", code=");
		sb.append(code);
		sb.append(", concessionnaireCode=");
		sb.append(concessionnaireCode);
		sb.append(", active=");
		sb.append(active);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConcessionnaireProduit toEntityModel() {
		ConcessionnaireProduitImpl concessionnaireProduitImpl =
			new ConcessionnaireProduitImpl();

		concessionnaireProduitImpl.setId(id);
		concessionnaireProduitImpl.setConcessionnaireId(concessionnaireId);
		concessionnaireProduitImpl.setProduitId(produitId);
		concessionnaireProduitImpl.setSiteId(siteId);

		if (code == null) {
			concessionnaireProduitImpl.setCode("");
		}
		else {
			concessionnaireProduitImpl.setCode(code);
		}

		if (concessionnaireCode == null) {
			concessionnaireProduitImpl.setConcessionnaireCode("");
		}
		else {
			concessionnaireProduitImpl.setConcessionnaireCode(
				concessionnaireCode);
		}

		concessionnaireProduitImpl.setActive(active);

		if (createdAt == Long.MIN_VALUE) {
			concessionnaireProduitImpl.setCreatedAt(null);
		}
		else {
			concessionnaireProduitImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			concessionnaireProduitImpl.setUpdatedAt(null);
		}
		else {
			concessionnaireProduitImpl.setUpdatedAt(new Date(updatedAt));
		}

		concessionnaireProduitImpl.resetOriginalValues();

		return concessionnaireProduitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		concessionnaireId = objectInput.readLong();

		produitId = objectInput.readLong();

		siteId = objectInput.readLong();
		code = objectInput.readUTF();
		concessionnaireCode = objectInput.readUTF();

		active = objectInput.readBoolean();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(concessionnaireId);

		objectOutput.writeLong(produitId);

		objectOutput.writeLong(siteId);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (concessionnaireCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(concessionnaireCode);
		}

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);
	}

	public long id;
	public long concessionnaireId;
	public long produitId;
	public long siteId;
	public String code;
	public String concessionnaireCode;
	public boolean active;
	public long createdAt;
	public long updatedAt;

}