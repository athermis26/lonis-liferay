package com.df.lonis.lonisbackendapplication.commission;

import com.df.lonis.lonisbackendapplication.chiffreaffaires.ChiffreAffaires;
import com.df.lonis.lonisbackendapplication.chiffreaffaires.ChiffreAffairesRepository;
import com.df.lonis.lonisbackendapplication.commission.CommissionDtos.CommissionDetailResponse;
import com.df.lonis.lonisbackendapplication.commission.CommissionDtos.CommissionResponse;
import com.df.lonis.lonisbackendapplication.common.NotFoundException;
import com.df.lonis.lonisbackendapplication.common.PageResponse;
import com.df.lonis.lonisbackendapplication.common.SortParser;
import com.df.lonis.lonisbackendapplication.terminal.Terminal;
import com.df.lonis.lonisbackendapplication.terminal.TerminalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/commissions")
public class CommissionController {

	private final CommissionRepository repository;
	private final TerminalRepository terminalRepository;
	private final ChiffreAffairesRepository chiffreAffairesRepository;

	public CommissionController(
			CommissionRepository repository,
			TerminalRepository terminalRepository,
			ChiffreAffairesRepository chiffreAffairesRepository) {
		this.repository = repository;
		this.terminalRepository = terminalRepository;
		this.chiffreAffairesRepository = chiffreAffairesRepository;
	}

	/** GET /api/v1/commissions — historique global paginé. */
	@GetMapping
	public PageResponse<CommissionResponse> list(
			@RequestParam(required = false) String search,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "createdAt,desc") String sort) {

		Page<Commission> result;
		if (search != null && !search.isBlank()) {
			result = repository.findByCodeContainingIgnoreCaseOrLibelleContainingIgnoreCase(
					search, search, PageRequest.of(page, pageSize, SortParser.parse(sort)));
		}
		else {
			result = repository.findAll(PageRequest.of(page, pageSize, SortParser.parse(sort)));
		}
		return PageResponse.of(result.map(c -> CommissionResponse.from(c, codeTerminal(c.getTerminalId()))));
	}

	/** GET /api/v1/commissions/{id} — détail. */
	@GetMapping("/{id}")
	public CommissionDetailResponse getOne(@PathVariable Long id) {
		Commission c = repository.findById(id)
				.orElseThrow(() -> new NotFoundException("Commission " + id + " introuvable"));
		long ca = chiffreAffairesRepository.findByTerminalId(c.getTerminalId()).stream()
				.mapToLong(ChiffreAffaires::getVentes).sum();
		return CommissionDetailResponse.from(c, codeTerminal(c.getTerminalId()), ca);
	}

	private String codeTerminal(Long terminalId) {
		if (terminalId == null) return null;
		return terminalRepository.findById(terminalId)
				.map(Terminal::getCodeTerminal)
				.orElse(null);
	}
}
