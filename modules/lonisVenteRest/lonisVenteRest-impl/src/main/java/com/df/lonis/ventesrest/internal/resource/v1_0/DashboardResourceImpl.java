package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.DashboardKpis;
import com.df.lonis.ventesrest.resource.v1_0.DashboardResource;

import com.df.lonis.ventesservice.model.ChiffreAffaires;
import com.df.lonis.ventesservice.service.ChiffreAffairesLocalService;
import com.df.lonis.ventesservice.service.ConcessionnaireLocalService;
import com.df.lonis.ventesservice.service.TerminalLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.List;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/dashboard.properties",
	scope = ServiceScope.PROTOTYPE, service = DashboardResource.class
)
public class DashboardResourceImpl extends BaseDashboardResourceImpl {

	@Override
	public DashboardKpis getDashboardKpis(String periode) {

		long totalConcessionnaire = 0L;
		long totalTerminal = 0L;
		long totalChiffreAffaire = 0L;
		long totalPaiement = 0L;

		List<ChiffreAffaires> cas = _chiffreAffairesLocalService.getChiffreAffaireses(-1, -1);

		for (ChiffreAffaires chiffreAffaire : cas) {
			totalChiffreAffaire += (chiffreAffaire.getBrut() - chiffreAffaire.getAnnulation() - chiffreAffaire.getRemboursement());
			totalPaiement += chiffreAffaire.getPaiement();
		}
		
		DashboardKpis dashboardKpis = new DashboardKpis();

		dashboardKpis.setTotalConcessionnaires((long) _concessionnaireLocalService.getConcessionnairesCount());
		dashboardKpis.setTotalPointsDeVente((long) _terminalLocalService.getTerminalsCount());
		dashboardKpis.setPaiementsTotal(totalPaiement);
		dashboardKpis.setChiffreAffairesTotal(totalChiffreAffaire);



		return dashboardKpis;
	}

	@Reference
	private ConcessionnaireLocalService _concessionnaireLocalService;

	@Reference
	private TerminalLocalService _terminalLocalService;

	@Reference
	private ChiffreAffairesLocalService _chiffreAffairesLocalService;
}