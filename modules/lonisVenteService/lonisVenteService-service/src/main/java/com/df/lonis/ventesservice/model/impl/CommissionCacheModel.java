/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model.impl;

import com.df.lonis.ventesservice.model.Commission;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Commission in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CommissionCacheModel
	implements CacheModel<Commission>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CommissionCacheModel)) {
			return false;
		}

		CommissionCacheModel commissionCacheModel =
			(CommissionCacheModel)object;

		if (id == commissionCacheModel.id) {
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", terminalId=");
		sb.append(terminalId);
		sb.append(", nombreTerminal=");
		sb.append(nombreTerminal);
		sb.append(", paye=");
		sb.append(paye);
		sb.append(", libelle=");
		sb.append(libelle);
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
	public Commission toEntityModel() {
		CommissionImpl commissionImpl = new CommissionImpl();

		commissionImpl.setId(id);

		if (code == null) {
			commissionImpl.setCode("");
		}
		else {
			commissionImpl.setCode(code);
		}

		commissionImpl.setTerminalId(terminalId);
		commissionImpl.setNombreTerminal(nombreTerminal);
		commissionImpl.setPaye(paye);

		if (libelle == null) {
			commissionImpl.setLibelle("");
		}
		else {
			commissionImpl.setLibelle(libelle);
		}

		if (status == null) {
			commissionImpl.setStatus("");
		}
		else {
			commissionImpl.setStatus(status);
		}

		if (createdAt == Long.MIN_VALUE) {
			commissionImpl.setCreatedAt(null);
		}
		else {
			commissionImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			commissionImpl.setUpdatedAt(null);
		}
		else {
			commissionImpl.setUpdatedAt(new Date(updatedAt));
		}

		commissionImpl.resetOriginalValues();

		return commissionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		code = objectInput.readUTF();

		terminalId = objectInput.readLong();

		nombreTerminal = objectInput.readInt();

		paye = objectInput.readBoolean();
		libelle = objectInput.readUTF();
		status = objectInput.readUTF();
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

		objectOutput.writeLong(terminalId);

		objectOutput.writeInt(nombreTerminal);

		objectOutput.writeBoolean(paye);

		if (libelle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(libelle);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);
	}

	public long id;
	public String code;
	public long terminalId;
	public int nombreTerminal;
	public boolean paye;
	public String libelle;
	public String status;
	public long createdAt;
	public long updatedAt;

}