/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model.impl;

import com.df.lonis.ventesservice.model.ChiffreAffaires;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ChiffreAffaires in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChiffreAffairesCacheModel
	implements CacheModel<ChiffreAffaires>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChiffreAffairesCacheModel)) {
			return false;
		}

		ChiffreAffairesCacheModel chiffreAffairesCacheModel =
			(ChiffreAffairesCacheModel)object;

		if (id == chiffreAffairesCacheModel.id) {
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
		sb.append(", terminalId=");
		sb.append(terminalId);
		sb.append(", brut=");
		sb.append(brut);
		sb.append(", paiement=");
		sb.append(paiement);
		sb.append(", annulation=");
		sb.append(annulation);
		sb.append(", remboursement=");
		sb.append(remboursement);
		sb.append(", ventes=");
		sb.append(ventes);
		sb.append(", balance=");
		sb.append(balance);
		sb.append(", deposit=");
		sb.append(deposit);
		sb.append(", date=");
		sb.append(date);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChiffreAffaires toEntityModel() {
		ChiffreAffairesImpl chiffreAffairesImpl = new ChiffreAffairesImpl();

		chiffreAffairesImpl.setId(id);
		chiffreAffairesImpl.setTerminalId(terminalId);
		chiffreAffairesImpl.setBrut(brut);
		chiffreAffairesImpl.setPaiement(paiement);
		chiffreAffairesImpl.setAnnulation(annulation);
		chiffreAffairesImpl.setRemboursement(remboursement);
		chiffreAffairesImpl.setVentes(ventes);
		chiffreAffairesImpl.setBalance(balance);
		chiffreAffairesImpl.setDeposit(deposit);

		if (date == Long.MIN_VALUE) {
			chiffreAffairesImpl.setDate(null);
		}
		else {
			chiffreAffairesImpl.setDate(new Date(date));
		}

		if (createdAt == Long.MIN_VALUE) {
			chiffreAffairesImpl.setCreatedAt(null);
		}
		else {
			chiffreAffairesImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			chiffreAffairesImpl.setUpdatedAt(null);
		}
		else {
			chiffreAffairesImpl.setUpdatedAt(new Date(updatedAt));
		}

		chiffreAffairesImpl.resetOriginalValues();

		return chiffreAffairesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		terminalId = objectInput.readLong();

		brut = objectInput.readLong();

		paiement = objectInput.readLong();

		annulation = objectInput.readLong();

		remboursement = objectInput.readLong();

		ventes = objectInput.readLong();

		balance = objectInput.readLong();

		deposit = objectInput.readLong();
		date = objectInput.readLong();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(terminalId);

		objectOutput.writeLong(brut);

		objectOutput.writeLong(paiement);

		objectOutput.writeLong(annulation);

		objectOutput.writeLong(remboursement);

		objectOutput.writeLong(ventes);

		objectOutput.writeLong(balance);

		objectOutput.writeLong(deposit);
		objectOutput.writeLong(date);
		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);
	}

	public long id;
	public long terminalId;
	public long brut;
	public long paiement;
	public long annulation;
	public long remboursement;
	public long ventes;
	public long balance;
	public long deposit;
	public long date;
	public long createdAt;
	public long updatedAt;

}