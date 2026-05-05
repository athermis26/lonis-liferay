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
 * The table class for the &quot;site_commerciaux&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see SiteCommercial
 * @generated
 */
public class SiteCommercialTable extends BaseTable<SiteCommercialTable> {

	public static final SiteCommercialTable INSTANCE =
		new SiteCommercialTable();

	public final Column<SiteCommercialTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SiteCommercialTable, Long> siteId = createColumn(
		"site_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SiteCommercialTable, Long> commercialId = createColumn(
		"commercial_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SiteCommercialTable, Date> dateDebut = createColumn(
		"date_debut", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SiteCommercialTable, Date> dateFin = createColumn(
		"date_fin", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SiteCommercialTable, Boolean> isPrincipal =
		createColumn(
			"is_principal", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<SiteCommercialTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private SiteCommercialTable() {
		super("site_commerciaux", SiteCommercialTable::new);
	}

}