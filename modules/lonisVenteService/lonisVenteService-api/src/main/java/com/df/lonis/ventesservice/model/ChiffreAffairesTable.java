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
 * The table class for the &quot;chiffre_affaires&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ChiffreAffaires
 * @generated
 */
public class ChiffreAffairesTable extends BaseTable<ChiffreAffairesTable> {

	public static final ChiffreAffairesTable INSTANCE =
		new ChiffreAffairesTable();

	public final Column<ChiffreAffairesTable, Long> id = createColumn(
		"id", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ChiffreAffairesTable, Long> terminalId = createColumn(
		"terminal_id", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ChiffreAffairesTable, Long> brut = createColumn(
		"brut", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ChiffreAffairesTable, Long> paiement = createColumn(
		"paiement", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ChiffreAffairesTable, Long> annulation = createColumn(
		"annulation", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ChiffreAffairesTable, Long> remboursement =
		createColumn(
			"remboursement", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ChiffreAffairesTable, Long> ventes = createColumn(
		"ventes", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ChiffreAffairesTable, Long> balance = createColumn(
		"balance", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ChiffreAffairesTable, Long> deposit = createColumn(
		"deposit", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ChiffreAffairesTable, Date> date = createColumn(
		"date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ChiffreAffairesTable, Date> createdAt = createColumn(
		"created_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ChiffreAffairesTable, Date> updatedAt = createColumn(
		"updated_at", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ChiffreAffairesTable() {
		super("chiffre_affaires", ChiffreAffairesTable::new);
	}

}