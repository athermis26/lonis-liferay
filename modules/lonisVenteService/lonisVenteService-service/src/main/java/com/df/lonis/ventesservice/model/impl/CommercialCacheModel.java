/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model.impl;

import com.df.lonis.ventesservice.model.Commercial;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Commercial in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CommercialCacheModel
	implements CacheModel<Commercial>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CommercialCacheModel)) {
			return false;
		}

		CommercialCacheModel commercialCacheModel =
			(CommercialCacheModel)object;

		if (id == commercialCacheModel.id) {
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
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", nom=");
		sb.append(nom);
		sb.append(", prenoms=");
		sb.append(prenoms);
		sb.append(", telephone=");
		sb.append(telephone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", matricule=");
		sb.append(matricule);
		sb.append(", statut=");
		sb.append(statut);
		sb.append(", superviseurId=");
		sb.append(superviseurId);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Commercial toEntityModel() {
		CommercialImpl commercialImpl = new CommercialImpl();

		commercialImpl.setId(id);

		if (nom == null) {
			commercialImpl.setNom("");
		}
		else {
			commercialImpl.setNom(nom);
		}

		if (prenoms == null) {
			commercialImpl.setPrenoms("");
		}
		else {
			commercialImpl.setPrenoms(prenoms);
		}

		if (telephone == null) {
			commercialImpl.setTelephone("");
		}
		else {
			commercialImpl.setTelephone(telephone);
		}

		if (email == null) {
			commercialImpl.setEmail("");
		}
		else {
			commercialImpl.setEmail(email);
		}

		if (matricule == null) {
			commercialImpl.setMatricule("");
		}
		else {
			commercialImpl.setMatricule(matricule);
		}

		if (statut == null) {
			commercialImpl.setStatut("");
		}
		else {
			commercialImpl.setStatut(statut);
		}

		commercialImpl.setSuperviseurId(superviseurId);

		if (createdAt == Long.MIN_VALUE) {
			commercialImpl.setCreatedAt(null);
		}
		else {
			commercialImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			commercialImpl.setUpdatedAt(null);
		}
		else {
			commercialImpl.setUpdatedAt(new Date(updatedAt));
		}

		commercialImpl.resetOriginalValues();

		return commercialImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		nom = objectInput.readUTF();
		prenoms = objectInput.readUTF();
		telephone = objectInput.readUTF();
		email = objectInput.readUTF();
		matricule = objectInput.readUTF();
		statut = objectInput.readUTF();

		superviseurId = objectInput.readLong();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (nom == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nom);
		}

		if (prenoms == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prenoms);
		}

		if (telephone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(telephone);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (matricule == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(matricule);
		}

		if (statut == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statut);
		}

		objectOutput.writeLong(superviseurId);
		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);
	}

	public long id;
	public String nom;
	public String prenoms;
	public String telephone;
	public String email;
	public String matricule;
	public String statut;
	public long superviseurId;
	public long createdAt;
	public long updatedAt;

}