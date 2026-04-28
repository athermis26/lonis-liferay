/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model.impl;

import com.df.lonis.ventesservice.model.Concessionnaire;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Concessionnaire in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ConcessionnaireCacheModel
	implements CacheModel<Concessionnaire>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConcessionnaireCacheModel)) {
			return false;
		}

		ConcessionnaireCacheModel concessionnaireCacheModel =
			(ConcessionnaireCacheModel)object;

		if (id == concessionnaireCacheModel.id) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", uid=");
		sb.append(uid);
		sb.append(", nom=");
		sb.append(nom);
		sb.append(", prenoms=");
		sb.append(prenoms);
		sb.append(", telephone=");
		sb.append(telephone);
		sb.append(", email=");
		sb.append(email);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Concessionnaire toEntityModel() {
		ConcessionnaireImpl concessionnaireImpl = new ConcessionnaireImpl();

		concessionnaireImpl.setId(id);

		if (uid == null) {
			concessionnaireImpl.setUid("");
		}
		else {
			concessionnaireImpl.setUid(uid);
		}

		if (nom == null) {
			concessionnaireImpl.setNom("");
		}
		else {
			concessionnaireImpl.setNom(nom);
		}

		if (prenoms == null) {
			concessionnaireImpl.setPrenoms("");
		}
		else {
			concessionnaireImpl.setPrenoms(prenoms);
		}

		if (telephone == null) {
			concessionnaireImpl.setTelephone("");
		}
		else {
			concessionnaireImpl.setTelephone(telephone);
		}

		if (email == null) {
			concessionnaireImpl.setEmail("");
		}
		else {
			concessionnaireImpl.setEmail(email);
		}

		concessionnaireImpl.resetOriginalValues();

		return concessionnaireImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		uid = objectInput.readUTF();
		nom = objectInput.readUTF();
		prenoms = objectInput.readUTF();
		telephone = objectInput.readUTF();
		email = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (uid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uid);
		}

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
	}

	public long id;
	public String uid;
	public String nom;
	public String prenoms;
	public String telephone;
	public String email;

}