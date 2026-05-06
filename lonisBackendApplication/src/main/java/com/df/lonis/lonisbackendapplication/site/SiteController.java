package com.df.lonis.lonisbackendapplication.site;

import com.df.lonis.lonisbackendapplication.common.PageResponse;
import com.df.lonis.lonisbackendapplication.common.SortParser;
import com.df.lonis.lonisbackendapplication.site.SiteDtos.SiteResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SiteController {

	private final SiteRepository repository;

	public SiteController(SiteRepository repository) {
		this.repository = repository;
	}

	/** GET /api/v1/sites — paginé. */
	@GetMapping("/sites")
	public PageResponse<SiteResponse> list(
			@RequestParam(required = false) String search,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int pageSize,
			@RequestParam(defaultValue = "libelle,asc") String sort) {

		Page<Site> result;
		if (search != null && !search.isBlank()) {
			result = repository.findByLibelleContainingIgnoreCaseOrCodeContainingIgnoreCase(
					search, search, PageRequest.of(page, pageSize, SortParser.parse(sort)));
		}
		else {
			result = repository.findAll(PageRequest.of(page, pageSize, SortParser.parse(sort)));
		}
		return PageResponse.of(result.map(SiteResponse::from));
	}

	/** GET /api/v1/sites-all — non paginé. */
	@GetMapping("/sites-all")
	public List<SiteResponse> listAll() {
		return repository.findAll().stream().map(SiteResponse::from).toList();
	}
}
