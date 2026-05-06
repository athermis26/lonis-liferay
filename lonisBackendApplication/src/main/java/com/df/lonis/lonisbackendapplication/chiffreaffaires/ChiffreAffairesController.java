package com.df.lonis.lonisbackendapplication.chiffreaffaires;

import com.df.lonis.lonisbackendapplication.chiffreaffaires.ChiffreAffairesDtos.ChiffreAffaireResponse;
import com.df.lonis.lonisbackendapplication.common.PageResponse;
import com.df.lonis.lonisbackendapplication.common.SortParser;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chiffres-affaires")
public class ChiffreAffairesController {

	private final ChiffreAffairesService service;

	public ChiffreAffairesController(ChiffreAffairesService service) {
		this.service = service;
	}

	/** GET /api/v1/chiffres-affaires — historique paginé, enrichi avec terminal/concess./produit/site. */
	@GetMapping
	public PageResponse<ChiffreAffaireResponse> list(
			@RequestParam(required = false) String search,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int pageSize,
			@RequestParam(defaultValue = "date,desc") String sort) {

		return PageResponse.of(
				service.listEnriched(PageRequest.of(page, pageSize, SortParser.parse(sort))));
	}
}
