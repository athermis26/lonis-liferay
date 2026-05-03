package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Site;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.mapper.SiteMapper;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.GenericODataFilterVisitor;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.ODataFilterApplier;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.ODataFilterUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0.SiteEntityModel;
import com.df.lonis.ventesrest.resource.v1_0.SiteResource;

import com.df.lonis.ventesservice.service.SiteLocalService;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.filter.FilterParserProvider;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/site.properties",
	scope = ServiceScope.PROTOTYPE, service = SiteResource.class
)
public class SiteResourceImpl extends BaseSiteResourceImpl {

	@Override
	public Page<Site> getSitesPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		List<GenericODataFilterVisitor.Criterion> criteria =
			ODataFilterUtil.extractCriteria(
				contextUriInfo, _filterParserProvider, _entityModel);

		DynamicQuery dq = _siteLocalService.dynamicQuery();
		ODataFilterApplier.apply(dq, criteria, _FIELD_TYPES);
		dq.setLimit(
			pagination.getStartPosition(), pagination.getEndPosition());

		List<com.df.lonis.ventesservice.model.Site> entries =
			_siteLocalService.dynamicQuery(dq);

		DynamicQuery countDq = _siteLocalService.dynamicQuery();
		ODataFilterApplier.apply(countDq, criteria, _FIELD_TYPES);
		long total = _siteLocalService.dynamicQueryCount(countDq);

		return Page.of(
			entries.stream(
			).map(
				_siteMapper::toDto
			).collect(
				Collectors.toList()
			),
			pagination, total);
	}

	@Override
	public Page<Site> getAllSites() throws Exception {
		List<com.df.lonis.ventesservice.model.Site> entries =
			_siteLocalService.getSites(-1, -1);

		return Page.of(
			entries.stream(
			).map(
				_siteMapper::toDto
			).collect(
				Collectors.toList()
			));
	}

	@Override
	public EntityModel getEntityModel(
		Map<String, List<String>> multivaluedMap) {

		return _entityModel;
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
		UnsafeBiConsumer
			<Collection<Site>, UnsafeFunction<Site, Site, Exception>,
			 Exception> contextBatchUnsafeBiConsumer) {
	}

	private static final Map<String, Class<?>> _FIELD_TYPES = new HashMap<>();

	static {
		_FIELD_TYPES.put("id", Long.class);
		_FIELD_TYPES.put("libelle", String.class);
		_FIELD_TYPES.put("type", Integer.class);
		_FIELD_TYPES.put("parentId", Long.class);
		_FIELD_TYPES.put("code", String.class);
		_FIELD_TYPES.put("codeProvinov", String.class);
		_FIELD_TYPES.put("status", Boolean.class);
	}

	private final EntityModel _entityModel = new SiteEntityModel();

	@Reference
	private FilterParserProvider _filterParserProvider;

	@Reference
	private SiteLocalService _siteLocalService;

	@Reference
	private SiteMapper _siteMapper;

}
