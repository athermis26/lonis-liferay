package com.df.lonis.lonisbackendapplication.chiffreaffaires;

import com.df.lonis.lonisbackendapplication.chiffreaffaires.ChiffreAffairesDtos.ChiffreAffaireResponse;
import com.df.lonis.lonisbackendapplication.concessionnaire.Concessionnaire;
import com.df.lonis.lonisbackendapplication.concessionnaire.ConcessionnaireRepository;
import com.df.lonis.lonisbackendapplication.produit.Produit;
import com.df.lonis.lonisbackendapplication.produit.ProduitRepository;
import com.df.lonis.lonisbackendapplication.site.Site;
import com.df.lonis.lonisbackendapplication.site.SiteRepository;
import com.df.lonis.lonisbackendapplication.terminal.Terminal;
import com.df.lonis.lonisbackendapplication.terminal.TerminalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Enrichit les chiffres d'affaires avec les libellés issus des tables associées
 * (Terminal, Concessionnaire, Produit, Site) en mode batch — pas de N+1.
 */
@Service
@Transactional(readOnly = true)
public class ChiffreAffairesService {

	private final ChiffreAffairesRepository repository;
	private final TerminalRepository terminalRepository;
	private final ConcessionnaireRepository concessionnaireRepository;
	private final ProduitRepository produitRepository;
	private final SiteRepository siteRepository;

	public ChiffreAffairesService(
			ChiffreAffairesRepository repository,
			TerminalRepository terminalRepository,
			ConcessionnaireRepository concessionnaireRepository,
			ProduitRepository produitRepository,
			SiteRepository siteRepository) {
		this.repository = repository;
		this.terminalRepository = terminalRepository;
		this.concessionnaireRepository = concessionnaireRepository;
		this.produitRepository = produitRepository;
		this.siteRepository = siteRepository;
	}

	public Page<ChiffreAffaireResponse> listEnriched(Pageable pageable) {
		Page<ChiffreAffaires> page = repository.findAll(pageable);
		return new PageImpl<>(enrich(page.getContent()), pageable, page.getTotalElements());
	}

	private List<ChiffreAffaireResponse> enrich(List<ChiffreAffaires> items) {
		if (items.isEmpty()) return List.of();

		Set<Long> terminalIds = items.stream()
				.map(ChiffreAffaires::getTerminalId).collect(Collectors.toSet());

		Map<Long, Terminal> terminals = byId(
				terminalRepository.findAllById(terminalIds), Terminal::getId);

		Set<Long> concessIds = terminals.values().stream()
				.map(Terminal::getConcessionnaireId).filter(java.util.Objects::nonNull)
				.collect(Collectors.toSet());
		Set<Long> produitIds = terminals.values().stream()
				.map(Terminal::getProduitId).filter(java.util.Objects::nonNull)
				.collect(Collectors.toSet());
		Set<Long> siteIds = terminals.values().stream()
				.map(Terminal::getSiteId).filter(java.util.Objects::nonNull)
				.collect(Collectors.toSet());

		Map<Long, Concessionnaire> concessionnaires = byId(
				concessionnaireRepository.findAllById(concessIds), Concessionnaire::getId);
		Map<Long, Produit> produits = byId(
				produitRepository.findAllById(produitIds), Produit::getId);
		Map<Long, Site> sites = byId(
				siteRepository.findAllById(siteIds), Site::getId);

		return items.stream()
				.map(ca -> toDto(ca, terminals, concessionnaires, produits, sites))
				.toList();
	}

	private static <T> Map<Long, T> byId(List<T> list, Function<T, Long> idFn) {
		return list.stream().collect(Collectors.toMap(idFn, Function.identity()));
	}

	private ChiffreAffaireResponse toDto(
			ChiffreAffaires ca,
			Map<Long, Terminal> terminals,
			Map<Long, Concessionnaire> concessionnaires,
			Map<Long, Produit> produits,
			Map<Long, Site> sites) {

		Terminal t = terminals.get(ca.getTerminalId());
		String codeTerminal = t == null ? null : t.getCodeTerminal();

		Concessionnaire c = (t == null) ? null : concessionnaires.get(t.getConcessionnaireId());
		String concessNomPrenom = (c == null) ? null
				: ((c.getNom() == null ? "" : c.getNom())
				+ (c.getPrenoms() == null ? "" : " " + c.getPrenoms())).trim();

		Produit p = (t == null) ? null : produits.get(t.getProduitId());
		String codeProduit = p == null ? null : p.getCode();
		String produitType = p == null ? null : p.getLibelle();

		Site s = (t == null) ? null : sites.get(t.getSiteId());
		String siteLibelle = s == null ? null : s.getLibelle();

		long chiffreAffaire = ca.getVentes(); // alias métier sur le champ ventes

		return new ChiffreAffaireResponse(
				ca.getId(), codeTerminal, concessNomPrenom, codeProduit, produitType,
				siteLibelle,
				ca.getBrut(), ca.getPaiement(), ca.getAnnulation(), ca.getRemboursement(),
				ca.getVentes(), ca.getBalance(), ca.getDeposit(), chiffreAffaire,
				ca.getDate(), ca.getCreatedAt(), ca.getUpdatedAt()
		);
	}
}
