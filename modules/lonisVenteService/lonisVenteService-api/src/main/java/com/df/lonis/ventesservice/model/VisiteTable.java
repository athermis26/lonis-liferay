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
 * The table class for the &quot;visites&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Visite
 * @generated
 */
public class VisiteTable extends BaseTable<VisiteTable> {

	public static final VisiteTable INSTANCE = new VisiteTable();

	public final Column<VisiteTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<VisiteTable, Long> commercialId = createColumn(
		"commercial_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VisiteTable, Long> terminalId = createColumn(
		"terminal_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VisiteTable, Double> latitude = createColumn(
		"latitude", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<VisiteTable, Double> longitude = createColumn(
		"longitude", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<VisiteTable, String> statut = createColumn(
		"statut", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VisiteTable, String> typeControle = createColumn(
		"type_controle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VisiteTable, Date> dateVisite = createColumn(
		"date_visite", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VisiteTable, String> compteRendu = createColumn(
		"compte_rendu", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VisiteTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VisiteTable, Date> updatedAt = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private VisiteTable() {
		super("visites", VisiteTable::new);
	}

}