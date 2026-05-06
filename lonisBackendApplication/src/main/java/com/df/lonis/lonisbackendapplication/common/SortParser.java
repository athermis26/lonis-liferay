package com.df.lonis.lonisbackendapplication.common;

import org.springframework.data.domain.Sort;

/**
 * Parse les paramètres de tri sous forme {@code "champ,asc"} / {@code "champ,desc"}.
 * Supporte plusieurs critères séparés par {@code ;} (ex : {@code "nom,asc;date,desc"}).
 */
public final class SortParser {

	private SortParser() {}

	public static Sort parse(String sort) {
		if (sort == null || sort.isBlank()) {
			return Sort.unsorted();
		}
		Sort result = null;
		for (String token : sort.split(";")) {
			String[] parts = token.split(",");
			String field = parts[0].trim();
			if (field.isEmpty()) continue;
			Sort.Direction dir = (parts.length > 1 && "desc".equalsIgnoreCase(parts[1].trim()))
					? Sort.Direction.DESC : Sort.Direction.ASC;
			Sort piece = Sort.by(dir, field);
			result = (result == null) ? piece : result.and(piece);
		}
		return result == null ? Sort.unsorted() : result;
	}
}
