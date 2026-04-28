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
 * The extended model interface for the ConcessionnaireProduit service. Represents a row in the &quot;concessionnaire_produit&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ConcessionnaireProduitModel
 * @generated
 */
@ImplementationClassName(
	"com.df.lonis.ventesservice.model.impl.ConcessionnaireProduitImpl"
)
@ProviderType
public interface ConcessionnaireProduit
	extends ConcessionnaireProduitModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.df.lonis.ventesservice.model.impl.ConcessionnaireProduitImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ConcessionnaireProduit, Long> ID_ACCESSOR =
		new Accessor<ConcessionnaireProduit, Long>() {

			@Override
			public Long get(ConcessionnaireProduit concessionnaireProduit) {
				return concessionnaireProduit.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ConcessionnaireProduit> getTypeClass() {
				return ConcessionnaireProduit.class;
			}

		};

}