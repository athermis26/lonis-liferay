/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;concessionnaires&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Concessionnaire
 * @generated
 */
public class ConcessionnaireTable extends BaseTable<ConcessionnaireTable> {

	public static final ConcessionnaireTable INSTANCE =
		new ConcessionnaireTable();

	public final Column<ConcessionnaireTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ConcessionnaireTable, String> uid = createColumn(
		"uid", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConcessionnaireTable, String> nom = createColumn(
		"nom", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConcessionnaireTable, String> prenoms = createColumn(
		"prenoms", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConcessionnaireTable, String> telephone = createColumn(
		"telephone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConcessionnaireTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ConcessionnaireTable() {
		super("concessionnaires", ConcessionnaireTable::new);
	}

}