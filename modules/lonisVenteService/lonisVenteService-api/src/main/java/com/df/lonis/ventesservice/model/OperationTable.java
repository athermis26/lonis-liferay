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
 * The table class for the &quot;operations&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Operation
 * @generated
 */
public class OperationTable extends BaseTable<OperationTable> {

	public static final OperationTable INSTANCE = new OperationTable();

	public final Column<OperationTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<OperationTable, String> code = createColumn(
		"code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OperationTable, String> libelle = createColumn(
		"libelle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OperationTable, String> reference = createColumn(
		"reference", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OperationTable, Long> montant = createColumn(
		"montant", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OperationTable, Long> montantReel = createColumn(
		"montant_reel", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OperationTable, String> statut = createColumn(
		"statut", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OperationTable, Long> terminalId = createColumn(
		"terminal_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OperationTable, String> guichet = createColumn(
		"guichet", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OperationTable, Date> dateOperation = createColumn(
		"date_operation", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OperationTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OperationTable, Date> updatedAt = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private OperationTable() {
		super("operations", OperationTable::new);
	}

}