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
 * The table class for the &quot;terminals&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Terminal
 * @generated
 */
public class TerminalTable extends BaseTable<TerminalTable> {

	public static final TerminalTable INSTANCE = new TerminalTable();

	public final Column<TerminalTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TerminalTable, String> codeTerminal = createColumn(
		"code_terminal", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TerminalTable, Long> concessionnaireId = createColumn(
		"concessionnaire_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TerminalTable, String> concessionnaireCode =
		createColumn(
			"concessionnaire_code", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TerminalTable, Long> produitId = createColumn(
		"produit_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TerminalTable, String> concessionnaireProduitCode =
		createColumn(
			"concessionnaire_produit_code", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<TerminalTable, Long> siteId = createColumn(
		"site_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<TerminalTable, Double> latitude = createColumn(
		"latitude", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<TerminalTable, Double> longitude = createColumn(
		"longitude", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<TerminalTable, String> adresse = createColumn(
		"adresse", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TerminalTable, String> statutValidation = createColumn(
		"statut_validation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TerminalTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TerminalTable, Date> updatedAt = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private TerminalTable() {
		super("terminals", TerminalTable::new);
	}

}