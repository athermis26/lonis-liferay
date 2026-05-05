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
 * The table class for the &quot;evaluations&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Evaluation
 * @generated
 */
public class EvaluationTable extends BaseTable<EvaluationTable> {

	public static final EvaluationTable INSTANCE = new EvaluationTable();

	public final Column<EvaluationTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EvaluationTable, Long> commercialId = createColumn(
		"commercial_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EvaluationTable, Integer> nbVisitesPrevues =
		createColumn(
			"nb_visites_prevues", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<EvaluationTable, Integer> nbVisitesEffectuees =
		createColumn(
			"nb_visites_effectuees", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<EvaluationTable, Double> tauxRealisation = createColumn(
		"taux_realisation", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<EvaluationTable, Integer> rang = createColumn(
		"rang", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EvaluationTable, String> periode = createColumn(
		"periode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EvaluationTable, Integer> mois = createColumn(
		"mois", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EvaluationTable, Integer> trimestre = createColumn(
		"trimestre", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EvaluationTable, Integer> annee = createColumn(
		"annee", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EvaluationTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EvaluationTable, Date> updatedAt = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private EvaluationTable() {
		super("evaluations", EvaluationTable::new);
	}

}