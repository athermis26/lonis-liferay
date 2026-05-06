package com.df.lonis.lonisbackendapplication.terminal;

import com.df.lonis.lonisbackendapplication.chiffreaffaires.ChiffreAffairesRepository;
import com.df.lonis.lonisbackendapplication.chiffreaffaires.TerminalAggregate;
import com.df.lonis.lonisbackendapplication.common.PageResponse;
import com.df.lonis.lonisbackendapplication.common.SortParser;
import com.df.lonis.lonisbackendapplication.concessionnaire.Concessionnaire;
import com.df.lonis.lonisbackendapplication.concessionnaire.ConcessionnaireRepository;
import com.df.lonis.lonisbackendapplication.operation.OperationRepository;
import com.df.lonis.lonisbackendapplication.produit.Produit;
import com.df.lonis.lonisbackendapplication.produit.ProduitRepository;
import com.df.lonis.lonisbackendapplication.site.Site;
import com.df.lonis.lonisbackendapplication.site.SiteRepository;
import com.df.lonis.lonisbackendapplication.terminal.TerminalDtos.TerminalActiviteResponse;
import com.df.lonis.lonisbackendapplication.terminal.TerminalDtos.TerminalResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Endpoints "vente" sur les terminaux. Les flows réseau (validation,
 * cartographie, visites) seront ajoutés dans le Lot 2 sous {@code /api/v1/terminals}.
 */
@RestController
@RequestMapping("/api/v1/terminaux")
public class TerminalController {

	private final TerminalRepository terminalRepository;
	private final TerminalEnricher enricher;
	private final ChiffreAffairesRepository chiffreAffairesRepository;
	private final OperationRepository operationRepository;
	private final ConcessionnaireRepository concessionnaireRepository;
	private final ProduitRepository produitRepository;
	private final SiteRepository siteRepository;

	public TerminalController(
			TerminalRepository terminalRepository,
			TerminalEnricher enricher,
			ChiffreAffairesRepository chiffreAffairesRepository,
			OperationRepository operationRepository,
			ConcessionnaireRepository concessionnaireRepository,
			ProduitRepository produitRepository,
			SiteRepository siteRepository) {
		this.terminalRepository = terminalRepository;
		this.enricher = enricher;
		this.chiffreAffairesRepository = chiffreAffairesRepository;
		this.operationRepository = operationRepository;
		this.concessionnaireRepository = concessionnaireRepository;
		this.produitRepository = produitRepository;
		this.siteRepository = siteRepository;
	}

	/** GET /api/v1/terminaux — liste paginée enrichie (concessionnaire, produit, site, solde). */
	@GetMapping
	public PageResponse<TerminalResponse> list(
			@RequestParam(required = false) String search,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "20") int pageSize,
			@RequestParam(defaultValue = "codeTerminal,asc") String sort) {

		Page<Terminal> result = (search != null && !search.isBlank())
				? terminalRepository.findByCodeTerminalContainingIgnoreCase(
						search, PageRequest.of(page, pageSize, SortParser.parse(sort)))
				: terminalRepository.findAll(
						PageRequest.of(page, pageSize, SortParser.parse(sort)));

		List<TerminalResponse> enriched = enricher.enrich(result.getContent());
		return PageResponse.of(new PageImpl<>(enriched, result.getPageable(), result.getTotalElements()));
	}

	/** GET /api/v1/terminaux/top-actifs — top N par chiffre d'affaires. */
	@GetMapping("/top-actifs")
	public List<TerminalActiviteResponse> topActifs(
			@RequestParam(defaultValue = "10") int limit) {

		List<TerminalAggregate> aggregates = chiffreAffairesRepository.aggregateByTerminal(null, null);
		if (aggregates.isEmpty()) return List.of();

		List<Long> topIds = aggregates.stream().limit(limit).map(TerminalAggregate::terminalId).toList();
		Map<Long, TerminalAggregate> aggByTerminal = aggregates.stream()
				.collect(Collectors.toMap(TerminalAggregate::terminalId, Function.identity()));

		List<Terminal> terminals = terminalRepository.findAllById(topIds);
		Map<Long, Terminal> tById = terminals.stream()
				.collect(Collectors.toMap(Terminal::getId, Function.identity()));

		Map<Long, Concessionnaire> concessionnaires = concessionnaireRepository.findAllById(
				terminals.stream().map(Terminal::getConcessionnaireId).filter(Objects::nonNull).toList()
		).stream().collect(Collectors.toMap(Concessionnaire::getId, Function.identity()));

		Map<Long, Produit> produits = produitRepository.findAllById(
				terminals.stream().map(Terminal::getProduitId).filter(Objects::nonNull).toList()
		).stream().collect(Collectors.toMap(Produit::getId, Function.identity()));

		Map<Long, Site> sites = siteRepository.findAllById(
				terminals.stream().map(Terminal::getSiteId).filter(Objects::nonNull).toList()
		).stream().collect(Collectors.toMap(Site::getId, Function.identity()));

		// Préserver l'ordre déjà trié par CA décroissant
		return topIds.stream()
				.map(id -> toActivite(tById.get(id), aggByTerminal.get(id), concessionnaires, produits, sites))
				.filter(Objects::nonNull)
				.toList();
	}

	private TerminalActiviteResponse toActivite(
			Terminal t,
			TerminalAggregate agg,
			Map<Long, Concessionnaire> concessionnaires,
			Map<Long, Produit> produits,
			Map<Long, Site> sites) {

		if (t == null) return null;

		Concessionnaire c = concessionnaires.get(t.getConcessionnaireId());
		String nomPrenom = (c == null) ? null
				: ((c.getNom() == null ? "" : c.getNom())
				+ (c.getPrenoms() == null ? "" : " " + c.getPrenoms())).trim();

		Produit p = produits.get(t.getProduitId());
		Site s = sites.get(t.getSiteId());

		return new TerminalActiviteResponse(
				t.getId(),
				t.getCodeTerminal(),
				t.getConcessionnaireProduitCode(),
				t.getConcessionnaireId(),
				nomPrenom,
				p == null ? null : p.getCode(),
				p == null ? null : p.getLibelle(),
				s == null ? null : s.getLibelle(),
				agg == null ? 0L : agg.soldeTotal(),
				operationRepository.countByTerminalId(t.getId()),
				0L,                                       // nombreRechargements (TODO règle métier)
				agg == null ? 0L : agg.chiffreAffaires()
		);
	}
}
