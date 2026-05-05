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
 * The table class for the &quot;objectifs&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Objectif
 * @generated
 */
public class ObjectifTable extends BaseTable<ObjectifTable> {

	public static final ObjectifTable INSTANCE = new ObjectifTable();

	public final Column<ObjectifTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ObjectifTable, Long> commercialId = createColumn(
		"commercial_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ObjectifTable, String> type = createColumn(
		"type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ObjectifTable, String> periode = createColumn(
		"periode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ObjectifTable, Integer> valeurCible = createColumn(
		"valeur_cible", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ObjectifTable, Integer> valeurReelle = createColumn(
		"valeur_reelle", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ObjectifTable, Integer> mois = createColumn(
		"mois", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ObjectifTable, Integer> trimestre = createColumn(
		"trimestre", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ObjectifTable, Integer> annee = createColumn(
		"annee", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ObjectifTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ObjectifTable, Date> updatedAt = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ObjectifTable() {
		super("objectifs", ObjectifTable::new);
	}

}