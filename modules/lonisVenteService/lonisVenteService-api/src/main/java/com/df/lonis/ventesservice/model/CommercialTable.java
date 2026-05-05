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
 * The table class for the &quot;commerciaux&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Commercial
 * @generated
 */
public class CommercialTable extends BaseTable<CommercialTable> {

	public static final CommercialTable INSTANCE = new CommercialTable();

	public final Column<CommercialTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CommercialTable, String> nom = createColumn(
		"nom", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommercialTable, String> prenoms = createColumn(
		"prenoms", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommercialTable, String> telephone = createColumn(
		"telephone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommercialTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommercialTable, String> matricule = createColumn(
		"matricule", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommercialTable, String> statut = createColumn(
		"statut", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommercialTable, Long> superviseurId = createColumn(
		"superviseur_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommercialTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CommercialTable, Date> updatedAt = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CommercialTable() {
		super("commerciaux", CommercialTable::new);
	}

}