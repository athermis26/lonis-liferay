/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.persistence.impl;

import com.df.lonis.ventesservice.model.ConcessionnaireTable;
import com.df.lonis.ventesservice.model.impl.ConcessionnaireImpl;
import com.df.lonis.ventesservice.model.impl.ConcessionnaireModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from Concessionnaire.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=com.df.lonis.ventesservice.model.impl.ConcessionnaireImpl",
		"table.name=concessionnaires"
	},
	service = ArgumentsResolver.class
)
public class ConcessionnaireModelArgumentsResolver
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

		ConcessionnaireModelImpl concessionnaireModelImpl =
			(ConcessionnaireModelImpl)baseModel;

		long columnBitmask = concessionnaireModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(concessionnaireModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					concessionnaireModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(ConcessionnairePersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(concessionnaireModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return ConcessionnaireImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return ConcessionnaireTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		ConcessionnaireModelImpl concessionnaireModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = concessionnaireModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = concessionnaireModelImpl.getColumnValue(
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

		orderByColumnsBitmask |= ConcessionnaireModelImpl.getColumnBitmask(
			"nom");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}