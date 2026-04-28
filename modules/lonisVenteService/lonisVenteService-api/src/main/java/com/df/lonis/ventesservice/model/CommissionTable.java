/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;commissions&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Commission
 * @generated
 */
public class CommissionTable extends BaseTable<CommissionTable> {

	public static final CommissionTable INSTANCE = new CommissionTable();

	public final Column<CommissionTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CommissionTable, String> code = createColumn(
		"code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommissionTable, Long> terminalId = createColumn(
		"terminal_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommissionTable, Integer> nombreTerminal = createColumn(
		"nombre_terminal", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CommissionTable, Boolean> paye = createColumn(
		"paye", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CommissionTable, String> libelle = createColumn(
		"libelle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommissionTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommissionTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CommissionTable, Date> updatedAt = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CommissionTable() {
		super("commissions", CommissionTable::new);
	}

}