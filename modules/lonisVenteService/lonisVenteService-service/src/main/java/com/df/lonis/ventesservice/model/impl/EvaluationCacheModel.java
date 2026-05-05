/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model.impl;

import com.df.lonis.ventesservice.model.Evaluation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Evaluation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EvaluationCacheModel
	implements CacheModel<Evaluation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EvaluationCacheModel)) {
			return false;
		}

		EvaluationCacheModel evaluationCacheModel =
			(EvaluationCacheModel)object;

		if (id == evaluationCacheModel.id) {
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
		sb.append(", commercialId=");
		sb.append(commercialId);
		sb.append(", nbVisitesPrevues=");
		sb.append(nbVisitesPrevues);
		sb.append(", nbVisitesEffectuees=");
		sb.append(nbVisitesEffectuees);
		sb.append(", tauxRealisation=");
		sb.append(tauxRealisation);
		sb.append(", rang=");
		sb.append(rang);
		sb.append(", periode=");
		sb.append(periode);
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
	public Evaluation toEntityModel() {
		EvaluationImpl evaluationImpl = new EvaluationImpl();

		evaluationImpl.setId(id);
		evaluationImpl.setCommercialId(commercialId);
		evaluationImpl.setNbVisitesPrevues(nbVisitesPrevues);
		evaluationImpl.setNbVisitesEffectuees(nbVisitesEffectuees);
		evaluationImpl.setTauxRealisation(tauxRealisation);
		evaluationImpl.setRang(rang);

		if (periode == null) {
			evaluationImpl.setPeriode("");
		}
		else {
			evaluationImpl.setPeriode(periode);
		}

		evaluationImpl.setMois(mois);
		evaluationImpl.setTrimestre(trimestre);
		evaluationImpl.setAnnee(annee);

		if (createdAt == Long.MIN_VALUE) {
			evaluationImpl.setCreatedAt(null);
		}
		else {
			evaluationImpl.setCreatedAt(new Date(createdAt));
		}

		if (updatedAt == Long.MIN_VALUE) {
			evaluationImpl.setUpdatedAt(null);
		}
		else {
			evaluationImpl.setUpdatedAt(new Date(updatedAt));
		}

		evaluationImpl.resetOriginalValues();

		return evaluationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		commercialId = objectInput.readLong();

		nbVisitesPrevues = objectInput.readInt();

		nbVisitesEffectuees = objectInput.readInt();

		tauxRealisation = objectInput.readDouble();

		rang = objectInput.readInt();
		periode = objectInput.readUTF();

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

		objectOutput.writeInt(nbVisitesPrevues);

		objectOutput.writeInt(nbVisitesEffectuees);

		objectOutput.writeDouble(tauxRealisation);

		objectOutput.writeInt(rang);

		if (periode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(periode);
		}

		objectOutput.writeInt(mois);

		objectOutput.writeInt(trimestre);

		objectOutput.writeInt(annee);
		objectOutput.writeLong(createdAt);
		objectOutput.writeLong(updatedAt);
	}

	public long id;
	public long commercialId;
	public int nbVisitesPrevues;
	public int nbVisitesEffectuees;
	public double tauxRealisation;
	public int rang;
	public String periode;
	public int mois;
	public int trimestre;
	public int annee;
	public long createdAt;
	public long updatedAt;

}