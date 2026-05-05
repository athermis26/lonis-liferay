/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model.impl;

import com.df.lonis.ventesservice.model.SiteCommercial;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SiteCommercial in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SiteCommercialCacheModel
	implements CacheModel<SiteCommercial>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SiteCommercialCacheModel)) {
			return false;
		}

		SiteCommercialCacheModel siteCommercialCacheModel =
			(SiteCommercialCacheModel)object;

		if (id == siteCommercialCacheModel.id) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", siteId=");
		sb.append(siteId);
		sb.append(", commercialId=");
		sb.append(commercialId);
		sb.append(", dateDebut=");
		sb.append(dateDebut);
		sb.append(", dateFin=");
		sb.append(dateFin);
		sb.append(", isPrincipal=");
		sb.append(isPrincipal);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SiteCommercial toEntityModel() {
		SiteCommercialImpl siteCommercialImpl = new SiteCommercialImpl();

		siteCommercialImpl.setId(id);
		siteCommercialImpl.setSiteId(siteId);
		siteCommercialImpl.setCommercialId(commercialId);

		if (dateDebut == Long.MIN_VALUE) {
			siteCommercialImpl.setDateDebut(null);
		}
		else {
			siteCommercialImpl.setDateDebut(new Date(dateDebut));
		}

		if (dateFin == Long.MIN_VALUE) {
			siteCommercialImpl.setDateFin(null);
		}
		else {
			siteCommercialImpl.setDateFin(new Date(dateFin));
		}

		siteCommercialImpl.setIsPrincipal(isPrincipal);

		if (createdAt == Long.MIN_VALUE) {
			siteCommercialImpl.setCreatedAt(null);
		}
		else {
			siteCommercialImpl.setCreatedAt(new Date(createdAt));
		}

		siteCommercialImpl.resetOriginalValues();

		return siteCommercialImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		siteId = objectInput.readLong();

		commercialId = objectInput.readLong();
		dateDebut = objectInput.readLong();
		dateFin = objectInput.readLong();

		isPrincipal = objectInput.readBoolean();
		createdAt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(siteId);

		objectOutput.writeLong(commercialId);
		objectOutput.writeLong(dateDebut);
		objectOutput.writeLong(dateFin);

		objectOutput.writeBoolean(isPrincipal);
		objectOutput.writeLong(createdAt);
	}

	public long id;
	public long siteId;
	public long commercialId;
	public long dateDebut;
	public long dateFin;
	public boolean isPrincipal;
	public long createdAt;

}