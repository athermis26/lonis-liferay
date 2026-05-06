package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Site;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;
import com.df.lonis.ventesrest.internal.backend.service.BackendSiteService;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0.SiteEntityModel;
import com.df.lonis.ventesrest.resource.v1_0.SiteResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/site.properties",
		scope = ServiceScope.PROTOTYPE,
		service = SiteResource.class
)
public class SiteResourceImpl extends BaseSiteResourceImpl {

	@Override
	public Page<Site> getSitesPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts) {

		BackendJsonUtil.Page<Site> result = _backend.list(
				search,
				pagination.getPage() - 1,
				pagination.getPageSize(),
				PaginationSort.toSortParam(sorts));
		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public Page<Site> getAllSites() {
		return Page.of(_backend.listAll());
	}

	@Override
	public EntityModel getEntityModel(Map<String, List<String>> multivaluedMap) {
		return _entityModel;
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Site>,
					UnsafeFunction<Site, Site, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	private final EntityModel _entityModel = new SiteEntityModel();

	@Reference
	private BackendSiteService _backend;
}
