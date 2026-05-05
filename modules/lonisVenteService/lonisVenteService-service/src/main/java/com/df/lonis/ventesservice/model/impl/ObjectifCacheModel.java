/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model.impl;

import com.df.lonis.ventesservice.model.Objectif;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Objectif in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ObjectifCacheModel
	implements CacheModel<Objectif>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ObjectifCacheModel)) {
			return false;
		}

		ObjectifCacheModel objectifCacheModel = (ObjectifCacheModel)object;

		if (id == objectifCacheModel.id) {
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
		sb.append(", type=");
		sb.append(type);
		sb.append(", periode=");
		sb.append(periode);
		sb.append(", valeurCible=");
		sb.append(valeurCible);
		sb.append(", valeurReelle=");
		sb.append(valeurReelle);
		sb.append(", mois=");
		sb.append(mois);
		sb.append(", trimestre=");
		sb.append(trimestre);
		sb.append(", annee=");
		sb.append(annee);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Objectif toEntityModel() {
		ObjectifImpl objectifImpl = new ObjectifImpl();

		objectifImpl.setId(id);
		objectifImpl.setCommercialId(commercialId);

		if (type == null) {
			objectifImpl.setType("");
		}
		else {
			objectifImpl.setType(type);
		}

		if (periode == null) {
			objectifImpl.setPeriode("");
		}
		else {
			objectifImpl.setPeriode(periode);
		}

		objectifImpl.setValeurCible(valeurCible);
		objectifImpl.setValeurReelle(valeurReelle);
		objectifImpl.setMois(mois);
		objectifImpl.setTrimestre(trimestre);
		objectifImpl.setAnnee(annee);

		if (createdAt == Long.MIN_VALUE) {
			objectifImpl.setCreatedAt(null);
		}
		else {
			objectifImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			objectifImpl.setUpdatedAt(null);
		}
		else {
			objectifImpl.setUpdatedAt(new Date(updatedAt));
		}

		objectifImpl.resetOriginalValues();

		return objectifImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		commercialId = objectInput.readLong();
		type = objectInput.readUTF();
		periode = objectInput.readUTF();

		valeurCible = objectInput.readInt();

		valeurReelle = objectInput.readInt();

		mois = objectInput.readInt();

		trimestre = objectInput.readInt();

		annee = objectInput.readInt();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(commercialId);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (periode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(periode);
		}

		objectOutput.writeInt(valeurCible);

		objectOutput.writeInt(valeurReelle);

		objectOutput.writeInt(mois);

		objectOutput.writeInt(trimestre);

		objectOutput.writeInt(annee);
		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);
	}

	public long id;
	public long commercialId;
	public String type;
	public String periode;
	public int valeurCible;
	public int valeurReelle;
	public int mois;
	public int trimestre;
	public int annee;
	public long createdAt;
	public long updatedAt;

}