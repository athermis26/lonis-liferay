package com.df.lonis.lonisbackendapplication.terminal;

import com.df.lonis.lonisbackendapplication.chiffreaffaires.ChiffreAffaires;
import com.df.lonis.lonisbackendapplication.chiffreaffaires.ChiffreAffairesRepository;
import com.df.lonis.lonisbackendapplication.concessionnaire.Concessionnaire;
import com.df.lonis.lonisbackendapplication.concessionnaire.ConcessionnaireRepository;
import com.df.lonis.lonisbackendapplication.produit.Produit;
import com.df.lonis.lonisbackendapplication.produit.ProduitDtos.ProduitResponse;
import com.df.lonis.lonisbackendapplication.produit.ProduitRepository;
import com.df.lonis.lonisbackendapplication.site.Site;
import com.df.lonis.lonisbackendapplication.site.SiteDtos.SiteResponse;
import com.df.lonis.lonisbackendapplication.site.SiteRepository;
import com.df.lonis.lonisbackendapplication.terminal.TerminalDtos.TerminalResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Enrichit les terminaux avec les libellés joints (concessionnaire, produit, site)
 * et le solde calculé à partir des chiffres d'affaires. Lookups en mode batch — pas de N+1.
 */
@Service
@Transactional(readOnly = true)
public class TerminalEnricher {

	private final ConcessionnaireRepository concessionnaireRepository;
	private final ProduitRepository produitRepository;
	private final SiteRepository siteRepository;
	private final ChiffreAffairesRepository chiffreAffairesRepository;

	public TerminalEnricher(
			ConcessionnaireRepository concessionnaireRepository,
			ProduitRepository produitRepository,
			SiteRepository siteRepository,
			ChiffreAffairesRepository chiffreAffairesRepository) {
		this.concessionnaireRepository = concessionnaireRepository;
		this.produitRepository = produitRepository;
		this.siteRepository = siteRepository;
		this.chiffreAffairesRepository = chiffreAffairesRepository;
	}

	public List<TerminalResponse> enrich(Collection<Terminal> terminals) {
		if (terminals.isEmpty()) return List.of();

		Set<Long> concessIds = terminals.stream()
				.map(Terminal::getConcessionnaireId).filter(Objects::nonNull).collect(Collectors.toSet());
		Set<Long> produitIds = terminals.stream()
				.map(Terminal::getProduitId).filter(Objects::nonNull).collect(Collectors.toSet());
		Set<Long> siteIds = terminals.stream()
				.map(Terminal::getSiteId).filter(Objects::nonNull).collect(Collectors.toSet());
		Set<Long> terminalIds = terminals.stream()
				.map(Terminal::getId).collect(Collectors.toSet());

		Map<Long, Concessionnaire> concessionnaires = byId(
				concessionnaireRepository.findAllById(concessIds), Concessionnaire::getId);
		Map<Long, Produit> produits = byId(
				produitRepository.findAllById(produitIds), Produit::getId);
		Map<Long, Site> sites = byId(
				siteRepository.findAllById(siteIds), Site::getId);

		// Solde par terminal = somme(balance) sur les CA des terminaux concernés
		Map<Long, Long> soldeByTerminal = terminalIds.isEmpty()
				? Map.of()
				: chiffreAffairesRepository.findByTerminalIdIn(terminalIds).stream()
						.collect(Collectors.groupingBy(
								ChiffreAffaires::getTerminalId,
								Collectors.summingLong(ChiffreAffaires::getBalance)));

		return terminals.stream()
				.map(t -> toDto(t, concessionnaires, produits, sites, soldeByTerminal))
				.toList();
	}

	private TerminalResponse toDto(
			Terminal t,
			Map<Long, Concessionnaire> concessionnaires,
			Map<Long, Produit> produits,
			Map<Long, Site> sites,
			Map<Long, Long> soldeByTerminal) {

		Concessionnaire c = concessionnaires.get(t.getConcessionnaireId());
		String concessNomPrenom = (c == null) ? null
				: ((c.getNom() == null ? "" : c.getNom())
				+ (c.getPrenoms() == null ? "" : " " + c.getPrenoms())).trim();

		Produit p = produits.get(t.getProduitId());
		Site s = sites.get(t.getSiteId());

		return new TerminalResponse(
				t.getId(),
				t.getCodeTerminal(),
				t.getConcessionnaireId(),
				concessNomPrenom,
				p == null ? null : p.getLibelle(),
				s == null ? null : s.getLibelle(),
				t.getConcessionnaireCode(),
				t.getProduitId(),
				t.getConcessionnaireProduitCode(),
				t.getSiteId(),
				p == null ? null : ProduitResponse.from(p),
				s == null ? null : SiteResponse.from(s),
				soldeByTerminal.getOrDefault(t.getId(), 0L),
				t.getCreatedAt(),
				t.getUpdatedAt()
		);
	}

	private static <T> Map<Long, T> byId(List<T> list, Function<T, Long> idFn) {
		return list.stream().collect(Collectors.toMap(idFn, Function.identity()));
	}
}
