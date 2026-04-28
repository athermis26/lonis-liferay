/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model.impl;

import com.df.lonis.ventesservice.model.Produit;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Produit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProduitCacheModel implements CacheModel<Produit>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProduitCacheModel)) {
			return false;
		}

		ProduitCacheModel produitCacheModel = (ProduitCacheModel)object;

		if (id == produitCacheModel.id) {
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", libelle=");
		sb.append(libelle);
		sb.append(", abreviation=");
		sb.append(abreviation);
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
	public Produit toEntityModel() {
		ProduitImpl produitImpl = new ProduitImpl();

		produitImpl.setId(id);

		if (code == null) {
			produitImpl.setCode("");
		}
		else {
			produitImpl.setCode(code);
		}

		if (libelle == null) {
			produitImpl.setLibelle("");
		}
		else {
			produitImpl.setLibelle(libelle);
		}

		if (abreviation == null) {
			produitImpl.setAbreviation("");
		}
		else {
			produitImpl.setAbreviation(abreviation);
		}

		produitImpl.setActive(active);

		if (createdAt == Long.MIN_VALUE) {
			produitImpl.setCreatedAt(null);
		}
		else {
			produitImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			produitImpl.setUpdatedAt(null);
		}
		else {
			produitImpl.setUpdatedAt(new Date(updatedAt));
		}

		produitImpl.resetOriginalValues();

		return produitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		code = objectInput.readUTF();
		libelle = objectInput.readUTF();
		abreviation = objectInput.readUTF();

		active = objectInput.readBoolean();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (libelle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(libelle);
		}

		if (abreviation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(abreviation);
		}

		objectOutput.writeBoolean(active);
		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);
	}

	public long id;
	public String code;
	public String libelle;
	public String abreviation;
	public boolean active;
	public long createdAt;
	public long updatedAt;

}