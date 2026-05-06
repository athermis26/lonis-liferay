package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;

/**
 * Convertit les paramètres de pagination/tri Liferay vers le format attendu par
 * le backend Spring Boot (numéro de page 0-based, sort sous forme {@code "champ,asc|desc"}).
 */
final class PaginationSort {

	private PaginationSort() {}

	static String toSortParam(Sort[] sorts) {
		if (sorts == null || sorts.length == 0 || sorts[0] == null) return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sorts.length; i++) {
			Sort s = sorts[i];
			if (s == null) continue;
			if (sb.length() > 0) sb.append(';');
			sb.append(s.getFieldName())
					.append(',').append(s.isReverse() ? "desc" : "asc");
		}
		return sb.length() == 0 ? null : sb.toString();
	}
}
