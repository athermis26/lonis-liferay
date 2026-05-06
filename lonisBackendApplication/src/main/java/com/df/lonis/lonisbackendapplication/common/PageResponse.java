package com.df.lonis.lonisbackendapplication.common;

import org.springframework.data.domain.Page;

import java.util.List;

public record PageResponse<T>(
		List<T> items,
		int page,
		int pageSize,
		long totalItems,
		int totalPages
) {
	public static <T> PageResponse<T> of(Page<T> page) {
		return new PageResponse<>(
				page.getContent(),
				page.getNumber(),
				page.getSize(),
				page.getTotalElements(),
				page.getTotalPages()
		);
	}
}
