/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.model.ChiffreAffairesTable;
import com.df.lonis.ventesservice.model.impl.ChiffreAffairesImpl;
import com.df.lonis.ventesservice.model.impl.ChiffreAffairesModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from ChiffreAffaires.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=com.df.lonis.ventesservice.model.impl.ChiffreAffairesImpl",
		"table.name=chiffre_affaires"
	},
	service = ArgumentsResolver.class
)
public class ChiffreAffairesModelArgumentsResolver
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

		ChiffreAffairesModelImpl chiffreAffairesModelImpl =
			(ChiffreAffairesModelImpl)baseModel;

		long columnBitmask = chiffreAffairesModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(chiffreAffairesModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					chiffreAffairesModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(ChiffreAffairesPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(chiffreAffairesModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return ChiffreAffairesImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return ChiffreAffairesTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		ChiffreAffairesModelImpl chiffreAffairesModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = chiffreAffairesModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = chiffreAffairesModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= ChiffreAffairesModelImpl.getColumnBitmask(
			"date");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}