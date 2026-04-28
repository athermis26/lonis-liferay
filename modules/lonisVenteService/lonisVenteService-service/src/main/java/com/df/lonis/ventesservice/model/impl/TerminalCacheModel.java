/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model.impl;

import com.df.lonis.ventesservice.model.Terminal;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Terminal in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TerminalCacheModel
	implements CacheModel<Terminal>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TerminalCacheModel)) {
			return false;
		}

		TerminalCacheModel terminalCacheModel = (TerminalCacheModel)object;

		if (id == terminalCacheModel.id) {
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
		sb.append(", codeTerminal=");
		sb.append(codeTerminal);
		sb.append(", concessionnaireId=");
		sb.append(concessionnaireId);
		sb.append(", concessionnaireCode=");
		sb.append(concessionnaireCode);
		sb.append(", produitId=");
		sb.append(produitId);
		sb.append(", concessionnaireProduitCode=");
		sb.append(concessionnaireProduitCode);
		sb.append(", siteId=");
		sb.append(siteId);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append(", updatedAt=");
		sb.append(updatedAt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Terminal toEntityModel() {
		TerminalImpl terminalImpl = new TerminalImpl();

		terminalImpl.setId(id);

		if (codeTerminal == null) {
			terminalImpl.setCodeTerminal("");
		}
		else {
			terminalImpl.setCodeTerminal(codeTerminal);
		}

		terminalImpl.setConcessionnaireId(concessionnaireId);

		if (concessionnaireCode == null) {
			terminalImpl.setConcessionnaireCode("");
		}
		else {
			terminalImpl.setConcessionnaireCode(concessionnaireCode);
		}

		terminalImpl.setProduitId(produitId);

		if (concessionnaireProduitCode == null) {
			terminalImpl.setConcessionnaireProduitCode("");
		}
		else {
			terminalImpl.setConcessionnaireProduitCode(
				concessionnaireProduitCode);
		}

		terminalImpl.setSiteId(siteId);

		if (createdAt == Long.MIN_VALUE) {
			terminalImpl.setCreatedAt(null);
		}
		else {
			terminalImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			terminalImpl.setUpdatedAt(null);
		}
		else {
			terminalImpl.setUpdatedAt(new Date(updatedAt));
		}

		terminalImpl.resetOriginalValues();

		return terminalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		codeTerminal = objectInput.readUTF();

		concessionnaireId = objectInput.readLong();
		concessionnaireCode = objectInput.readUTF();

		produitId = objectInput.readLong();
		concessionnaireProduitCode = objectInput.readUTF();

		siteId = objectInput.readLong();
		createdAt = objectInput.readLong();
		updatedAt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (codeTerminal == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codeTerminal);
		}

		objectOutput.writeLong(concessionnaireId);

		if (concessionnaireCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(concessionnaireCode);
		}

		objectOutput.writeLong(produitId);

		if (concessionnaireProduitCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(concessionnaireProduitCode);
		}

		objectOutput.writeLong(siteId);
		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);
	}

	public long id;
	public String codeTerminal;
	public long concessionnaireId;
	public String concessionnaireCode;
	public long produitId;
	public String concessionnaireProduitCode;
	public long siteId;
	public long createdAt;
	public long updatedAt;

}