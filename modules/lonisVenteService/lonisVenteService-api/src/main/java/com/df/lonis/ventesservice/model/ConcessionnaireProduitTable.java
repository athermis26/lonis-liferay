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
 * The table class for the &quot;concessionnaire_produit&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ConcessionnaireProduit
 * @generated
 */
public class ConcessionnaireProduitTable
	extends BaseTable<ConcessionnaireProduitTable> {

	public static final ConcessionnaireProduitTable INSTANCE =
		new ConcessionnaireProduitTable();

	public final Column<ConcessionnaireProduitTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ConcessionnaireProduitTable, Long> concessionnaireId =
		createColumn(
			"concessionnaire_id", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ConcessionnaireProduitTable, Long> produitId =
		createColumn(
			"produit_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ConcessionnaireProduitTable, Long> siteId =
		createColumn("site_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ConcessionnaireProduitTable, String> code =
		createColumn("code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ConcessionnaireProduitTable, String>
		concessionnaireCode = createColumn(
			"concessionnaire_code", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ConcessionnaireProduitTable, Boolean> active =
		createColumn(
			"active", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ConcessionnaireProduitTable, Date> createdAt =
		createColumn(
			"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ConcessionnaireProduitTable, Date> updatedAt =
		createColumn(
			"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ConcessionnaireProduitTable() {
		super("concessionnaire_produit", ConcessionnaireProduitTable::new);
	}

}