package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.DashboardKpis;
import com.df.lonis.ventesrest.internal.backend.service.BackendDashboardService;
import com.df.lonis.ventesrest.resource.v1_0.DashboardResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/dashboard.properties",
		scope = ServiceScope.PROTOTYPE,
		service = DashboardResource.class
)
public class DashboardResourceImpl extends BaseDashboardResourceImpl {

	@Override
	public DashboardKpis getDashboardKpis(String periode) {
		return _backend.getKpis(periode);
	}

	@Reference
	private BackendDashboardService _backend;
}
