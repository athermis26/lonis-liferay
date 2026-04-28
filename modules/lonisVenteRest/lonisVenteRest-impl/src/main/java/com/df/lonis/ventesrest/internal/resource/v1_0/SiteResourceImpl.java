package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Site;
import com.df.lonis.ventesrest.resource.v1_0.SiteResource;

import com.df.lonis.ventesservice.service.SiteLocalService;
import com.df.lonis.ventesservice.service.SiteLocalServiceUtil;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Collection;
import java.util.List;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/site.properties",
	scope = ServiceScope.PROTOTYPE, service = SiteResource.class
)
public class SiteResourceImpl extends BaseSiteResourceImpl {
	@Override
	public Page<Site> getSitesPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		List<com.df.lonis.ventesservice.model.Site> entries = _siteLocalService.getSites(pagination.getStartPosition(), pagination.getEndPosition());

		return Page.of(
				entries.stream().map(this::_toDto).collect(java.util.stream.Collectors.toList()), pagination, _siteLocalService.getSitesCount()
		);
	}

	@Override
	public Page<Site> getAllSites() throws Exception {
		List<com.df.lonis.ventesservice.model.Site> entries = _siteLocalService.getSites(-1, -1);
		return Page.of(
				entries.stream().map(this::_toDto).collect(java.util.stream.Collectors.toList())
		);
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Site>, UnsafeFunction<Site, Site, Exception>, Exception> contextBatchUnsafeBiConsumer) {

	}

	private Site _toDto(com.df.lonis.ventesservice.model.Site entry) {
		Site dto = new Site();
		dto.setId(entry.getId());
		dto.setCode(entry.getCode());
		dto.setLibelle(entry.getLibelle());
		dto.setCodeProvince(entry.getCodeProvinov());
		dto.setParentId(entry.getParentId());
		dto.setStatus(entry.getStatus());
		dto.setType(entry.getType());
		dto.setCreatedAt(entry.getCreatedAt());
		dto.setUpdatedAt(entry.getUpdatedAt());

		return dto;
	}

	@Reference
	private SiteLocalService _siteLocalService;
}