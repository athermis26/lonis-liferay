package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.liferay.portal.kernel.search.Sort;

/**
 * Convertit les Sort[] de Liferay vers le format {@code "champ,asc|desc"} attendu par le backend.
 */
final class ReseauPaginationSort {

	private ReseauPaginationSort() {}

	static String toSortParam(Sort[] sorts) {
		if (sorts == null || sorts.length == 0 || sorts[0] == null) return null;
		StringBuilder sb = new StringBuilder();
		for (Sort s : sorts) {
			if (s == null) continue;
			if (sb.length() > 0) sb.append(';');
			sb.append(s.getFieldName())
					.append(',').append(s.isReverse() ? "desc" : "asc");
		}
		return sb.length() == 0 ? null : sb.toString();
	}
}
