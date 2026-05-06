package com.df.lonis.lonisbackendapplication.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;

public final class SortParser {

	private static final Logger log = LoggerFactory.getLogger(SortParser.class);

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
			try {
				Sort piece = Sort.by(dir, field);
				result = (result == null) ? piece : result.and(piece);
			} catch (Exception e) {
				log.warn("Champ de tri ignoré: {}", field);
			}
		}
		return result == null ? Sort.unsorted() : result;
	}
}