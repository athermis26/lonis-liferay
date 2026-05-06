package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.SiteCommercial;
import com.df.lonis.reseaurest.internal.backend.BackendJsonUtil;
import com.df.lonis.reseaurest.internal.backend.service.BackendSiteCommercialService;
import com.df.lonis.reseaurest.resource.v1_0.SiteCommercialResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Collection;

import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/site-commercial.properties",
		scope = ServiceScope.PROTOTYPE,
		service = SiteCommercialResource.class
)
public class SiteCommercialResourceImpl extends BaseSiteCommercialResourceImpl {

	@Override
	public Page<SiteCommercial> getCommercialSitesPage(Long commercialId) {
		return Page.of(_backend.listByCommercial(commercialId));
	}

	@Override
	public SiteCommercial postCommercialSite(Long commercialId, SiteCommercial body) {
		return _backend.create(commercialId, body);
	}

	@Override
	public Response deleteCommercialSite(Long commercialId, Long siteId) {
		_backend.deleteAffectation(commercialId, siteId);
		return Response.noContent().build();
	}

	@Override
	public Page<SiteCommercial> getSiteCommerciauxPage(
			Long siteId, String search, Filter filter, Pagination pagination, Sort[] sorts) {

		BackendJsonUtil.Page<SiteCommercial> result = _backend.listBySite(
				siteId, pagination.getPage() - 1, pagination.getPageSize());
		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<SiteCommercial>,
					UnsafeFunction<SiteCommercial, SiteCommercial, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	@Reference
	private BackendSiteCommercialService _backend;
}
