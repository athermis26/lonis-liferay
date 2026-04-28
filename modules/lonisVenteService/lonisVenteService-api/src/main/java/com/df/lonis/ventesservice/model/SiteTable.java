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
 * The table class for the &quot;sites&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Site
 * @generated
 */
public class SiteTable extends BaseTable<SiteTable> {

	public static final SiteTable INSTANCE = new SiteTable();

	public final Column<SiteTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SiteTable, String> libelle = createColumn(
		"libelle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SiteTable, Integer> type = createColumn(
		"type", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SiteTable, Long> parentId = createColumn(
		"parent_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SiteTable, String> code = createColumn(
		"code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SiteTable, String> codeProvinov = createColumn(
		"code_provinov", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SiteTable, Boolean> status = createColumn(
		"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<SiteTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SiteTable, Date> updatedAt = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private SiteTable() {
		super("sites", SiteTable::new);
	}

}