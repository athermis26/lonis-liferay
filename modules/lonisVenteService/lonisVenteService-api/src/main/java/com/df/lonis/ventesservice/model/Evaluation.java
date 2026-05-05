/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Evaluation service. Represents a row in the &quot;evaluations&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EvaluationModel
 * @generated
 */
@ImplementationClassName("com.df.lonis.ventesservice.model.impl.EvaluationImpl")
@ProviderType
public interface Evaluation extends EvaluationModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.df.lonis.ventesservice.model.impl.EvaluationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Evaluation, Long> ID_ACCESSOR =
		new Accessor<Evaluation, Long>() {

			@Override
			public Long get(Evaluation evaluation) {
				return evaluation.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Evaluation> getTypeClass() {
				return Evaluation.class;
			}

		};

}