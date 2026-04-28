/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model.impl;

import com.df.lonis.ventesservice.model.Operation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Operation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OperationCacheModel
	implements CacheModel<Operation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OperationCacheModel)) {
			return false;
		}

		OperationCacheModel operationCacheModel = (OperationCacheModel)object;

		if (id == operationCacheModel.id) {
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
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(id);
		sb.append(", code=");
		sb.append(code);
		sb.append(", libelle=");
		sb.append(libelle);
		sb.append(", reference=");
		sb.append(reference);
		sb.append(", montant=");
		sb.append(montant);
		sb.append(", montantReel=");
		sb.append(montantReel);
		sb.append(", statut=");
		sb.append(statut);
		sb.append(", terminalId=");
		sb.append(terminalId);
		sb.append(", guichet=");
		sb.append(guichet);
		sb.append(", dateOperation=");
		sb.append(dateOperation);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Operation toEntityModel() {
		OperationImpl operationImpl = new OperationImpl();

		operationImpl.setId(id);

		if (code == null) {
			operationImpl.setCode("");
		}
		else {
			operationImpl.setCode(code);
		}

		if (libelle == null) {
			operationImpl.setLibelle("");
		}
		else {
			operationImpl.setLibelle(libelle);
		}

		if (reference == null) {
			operationImpl.setReference("");
		}
		else {
			operationImpl.setReference(reference);
		}

		operationImpl.setMontant(montant);
		operationImpl.setMontantReel(montantReel);

		if (statut == null) {
			operationImpl.setStatut("");
		}
		else {
			operationImpl.setStatut(statut);
		}

		operationImpl.setTerminalId(terminalId);

		if (guichet == null) {
			operationImpl.setGuichet("");
		}
		else {
			operationImpl.setGuichet(guichet);
		}

		if (dateOperation == Long.MIN_VALUE) {
			operationImpl.setDateOperation(null);
		}
		else {
			operationImpl.setDateOperation(new Date(dateOperation));
		}

		if (createdAt == Long.MIN_VALUE) {
			operationImpl.setCreatedAt(null);
		}
		else {
			operationImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			operationImpl.setUpdatedAt(null);
		}
		else {
			operationImpl.setUpdatedAt(new Date(updatedAt));
		}

		operationImpl.resetOriginalValues();

		return operationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		code = objectInput.readUTF();
		libelle = objectInput.readUTF();
		reference = objectInput.readUTF();

		montant = objectInput.readLong();

		montantReel = objectInput.readLong();
		statut = objectInput.readUTF();

		terminalId = objectInput.readLong();
		guichet = objectInput.readUTF();
		dateOperation = objectInput.readLong();
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

		if (reference == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reference);
		}

		objectOutput.writeLong(montant);

		objectOutput.writeLong(montantReel);

		if (statut == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statut);
		}

		objectOutput.writeLong(terminalId);

		if (guichet == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(guichet);
		}

		objectOutput.writeLong(dateOperation);
		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);
	}

	public long id;
	public String code;
	public String libelle;
	public String reference;
	public long montant;
	public long montantReel;
	public String statut;
	public long terminalId;
	public String guichet;
	public long dateOperation;
	public long createdAt;
	public long updatedAt;

}