/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.model.ConcessionnaireProduitTable;
import com.df.lonis.ventesservice.model.impl.ConcessionnaireProduitImpl;
import com.df.lonis.ventesservice.model.impl.ConcessionnaireProduitModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from ConcessionnaireProduit.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=com.df.lonis.ventesservice.model.impl.ConcessionnaireProduitImpl",
		"table.name=concessionnaire_produit"
	},
	service = ArgumentsResolver.class
)
public class ConcessionnaireProduitModelArgumentsResolver
	implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		ConcessionnaireProduitModelImpl concessionnaireProduitModelImpl =
			(ConcessionnaireProduitModelImpl)baseModel;

		long columnBitmask = concessionnaireProduitModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				concessionnaireProduitModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					concessionnaireProduitModelImpl.getColumnBitmask(
						columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				concessionnaireProduitModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return ConcessionnaireProduitImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return ConcessionnaireProduitTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		ConcessionnaireProduitModelImpl concessionnaireProduitModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					concessionnaireProduitModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = concessionnaireProduitModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}