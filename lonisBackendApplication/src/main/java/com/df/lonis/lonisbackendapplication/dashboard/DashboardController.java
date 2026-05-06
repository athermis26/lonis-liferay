package com.df.lonis.lonisbackendapplication.dashboard;

import com.df.lonis.lonisbackendapplication.chiffreaffaires.ChiffreAffairesRepository;
import com.df.lonis.lonisbackendapplication.concessionnaire.ConcessionnaireRepository;
import com.df.lonis.lonisbackendapplication.terminal.TerminalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardController {

	private final ConcessionnaireRepository concessionnaireRepository;
	private final TerminalRepository terminalRepository;
	private final ChiffreAffairesRepository chiffreAffairesRepository;

	public DashboardController(
			ConcessionnaireRepository concessionnaireRepository,
			TerminalRepository terminalRepository,
			ChiffreAffairesRepository chiffreAffairesRepository) {
		this.concessionnaireRepository = concessionnaireRepository;
		this.terminalRepository = terminalRepository;
		this.chiffreAffairesRepository = chiffreAffairesRepository;
	}

	/**
	 * GET /api/v1/dashboard/kpis — agrège totaux concessionnaires, terminaux, CA, paiements.
	 *
	 * @param periode {@code today | week | month | year} — fenêtre de calcul du CA et paiements
	 *                (les totaux concessionnaires/terminaux sont absolus).
	 */
	@GetMapping("/kpis")
	public DashboardKpisResponse kpis(@RequestParam(defaultValue = "month") String periode) {

		Instant dateDebut = startOf(periode);
		Long ventes = chiffreAffairesRepository.sumVentes(dateDebut, null);
		Long paiements = chiffreAffairesRepository.sumPaiements(dateDebut, null);

		return new DashboardKpisResponse(
				concessionnaireRepository.count(),
				terminalRepository.count(),
				ventes == null ? 0L : ventes,
				paiements == null ? 0L : paiements
		);
	}

	private static Instant startOf(String periode) {
		LocalDate today = LocalDate.now(ZoneOffset.UTC);
		LocalDate from = switch (periode == null ? "" : periode.toLowerCase()) {
			case "today" -> today;
			case "week" -> today.minus(7, ChronoUnit.DAYS);
			case "year" -> today.withDayOfYear(1);
			case "all"  -> null;
			default     -> today.withDayOfMonth(1);
		};
		return from == null ? null : from.atStartOfDay(ZoneOffset.UTC).toInstant();
	}

	/** Schéma {@code DashboardKpis}. */
	public record DashboardKpisResponse(
			Long totalConcessionnaires,
			Long totalPointsDeVente,
			Long chiffreAffairesTotal,
			Long paiementsTotal
	) {}
}
