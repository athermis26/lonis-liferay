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
 * The extended model interface for the Concessionnaire service. Represents a row in the &quot;concessionnaires&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ConcessionnaireModel
 * @generated
 */
@ImplementationClassName(
	"com.df.lonis.ventesservice.model.impl.ConcessionnaireImpl"
)
@ProviderType
public interface Concessionnaire extends ConcessionnaireModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.df.lonis.ventesservice.model.impl.ConcessionnaireImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Concessionnaire, Long> ID_ACCESSOR =
		new Accessor<Concessionnaire, Long>() {

			@Override
			public Long get(Concessionnaire concessionnaire) {
				return concessionnaire.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Concessionnaire> getTypeClass() {
				return Concessionnaire.class;
			}

		};

}