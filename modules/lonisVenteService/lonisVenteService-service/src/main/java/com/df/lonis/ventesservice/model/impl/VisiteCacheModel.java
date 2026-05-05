/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model.impl;

import com.df.lonis.ventesservice.model.Visite;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Visite in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VisiteCacheModel implements CacheModel<Visite>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VisiteCacheModel)) {
			return false;
		}

		VisiteCacheModel visiteCacheModel = (VisiteCacheModel)object;

		if (id == visiteCacheModel.id) {
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
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", commercialId=");
		sb.append(commercialId);
		sb.append(", terminalId=");
		sb.append(terminalId);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", statut=");
		sb.append(statut);
		sb.append(", typeControle=");
		sb.append(typeControle);
		sb.append(", dateVisite=");
		sb.append(dateVisite);
		sb.append(", compteRendu=");
		sb.append(compteRendu);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Visite toEntityModel() {
		VisiteImpl visiteImpl = new VisiteImpl();

		visiteImpl.setId(id);
		visiteImpl.setCommercialId(commercialId);
		visiteImpl.setTerminalId(terminalId);
		visiteImpl.setLatitude(latitude);
		visiteImpl.setLongitude(longitude);

		if (statut == null) {
			visiteImpl.setStatut("");
		}
		else {
			visiteImpl.setStatut(statut);
		}

		if (typeControle == null) {
			visiteImpl.setTypeControle("");
		}
		else {
			visiteImpl.setTypeControle(typeControle);
		}

		if (dateVisite == Long.MIN_VALUE) {
			visiteImpl.setDateVisite(null);
		}
		else {
			visiteImpl.setDateVisite(new Date(dateVisite));
		}

		if (compteRendu == null) {
			visiteImpl.setCompteRendu("");
		}
		else {
			visiteImpl.setCompteRendu(compteRendu);
		}

		if (createdAt == Long.MIN_VALUE) {
			visiteImpl.setCreatedAt(null);
		}
		else {
			visiteImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			visiteImpl.setUpdatedAt(null);
		}
		else {
			visiteImpl.setUpdatedAt(new Date(updatedAt));
		}

		visiteImpl.resetOriginalValues();

		return visiteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		commercialId = objectInput.readLong();

		terminalId = objectInput.readLong();

		latitude = objectInput.readDouble();

		longitude = objectInput.readDouble();
		statut = objectInput.readUTF();
		typeControle = objectInput.readUTF();
		dateVisite = objectInput.readLong();
		compteRendu = objectInput.readUTF();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(commercialId);

		objectOutput.writeLong(terminalId);

		objectOutput.writeDouble(latitude);

		objectOutput.writeDouble(longitude);

		if (statut == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statut);
		}

		if (typeControle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(typeControle);
		}

		objectOutput.writeLong(dateVisite);

		if (compteRendu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(compteRendu);
		}

		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);
	}

	public long id;
	public long commercialId;
	public long terminalId;
	public double latitude;
	public double longitude;
	public String statut;
	public String typeControle;
	public long dateVisite;
	public String compteRendu;
	public long createdAt;
	public long updatedAt;

}