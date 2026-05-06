package com.df.lonis.lonisbackendapplication.operation;

import com.df.lonis.lonisbackendapplication.common.NotFoundException;
import com.df.lonis.lonisbackendapplication.common.PageResponse;
import com.df.lonis.lonisbackendapplication.common.SortParser;
import com.df.lonis.lonisbackendapplication.operation.OperationDtos.OperationDetailResponse;
import com.df.lonis.lonisbackendapplication.operation.OperationDtos.OperationResponse;
import com.df.lonis.lonisbackendapplication.terminal.Terminal;
import com.df.lonis.lonisbackendapplication.terminal.TerminalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationController {

	private final OperationRepository repository;
	private final TerminalRepository terminalRepository;

	public OperationController(OperationRepository repository, TerminalRepository terminalRepository) {
		this.repository = repository;
		this.terminalRepository = terminalRepository;
	}

	/** GET /api/v1/operations — historique paginé. */
	@GetMapping
	public PageResponse<OperationResponse> list(
			@RequestParam(required = false) String search,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(defaultValue = "dateOperation,desc") String sort) {

		Page<Operation> result;
		if (search != null && !search.isBlank()) {
			result = repository
					.findByReferenceContainingIgnoreCaseOrCodeContainingIgnoreCaseOrLibelleContainingIgnoreCase(
							search, search, search,
							PageRequest.of(page, pageSize, SortParser.parse(sort)));
		}
		else {
			result = repository.findAll(PageRequest.of(page, pageSize, SortParser.parse(sort)));
		}

		return PageResponse.of(result.map(o -> OperationResponse.from(o, codeTerminal(o.getTerminalId()))));
	}

	/** GET /api/v1/operations/{operationId} — détail. */
	@GetMapping("/{operationId}")
	public OperationDetailResponse getOne(@PathVariable Long operationId) {
		Operation o = repository.findById(operationId)
				.orElseThrow(() -> new NotFoundException("Operation " + operationId + " introuvable"));
		return OperationDetailResponse.from(o, codeTerminal(o.getTerminalId()));
	}

	private String codeTerminal(Long terminalId) {
		if (terminalId == null) return null;
		return terminalRepository.findById(terminalId)
				.map(Terminal::getCodeTerminal)
				.orElse(null);
	}
}
