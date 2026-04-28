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
 * The table class for the &quot;produits&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Produit
 * @generated
 */
public class ProduitTable extends BaseTable<ProduitTable> {

	public static final ProduitTable INSTANCE = new ProduitTable();

	public final Column<ProduitTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProduitTable, String> code = createColumn(
		"code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProduitTable, String> libelle = createColumn(
		"libelle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProduitTable, String> abreviation = createColumn(
		"abreviation", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProduitTable, Boolean> active = createColumn(
		"active", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ProduitTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProduitTable, Date> updatedAt = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ProduitTable() {
		super("produits", ProduitTable::new);
	}

}