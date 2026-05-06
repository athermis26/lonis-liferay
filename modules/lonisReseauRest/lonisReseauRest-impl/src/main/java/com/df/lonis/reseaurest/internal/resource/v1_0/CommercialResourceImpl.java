package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Commercial;
import com.df.lonis.reseaurest.dto.v1_0.CommercialRequestBody;
import com.df.lonis.reseaurest.internal.backend.BackendJsonUtil;
import com.df.lonis.reseaurest.internal.backend.service.BackendCommercialService;
import com.df.lonis.reseaurest.resource.v1_0.CommercialResource;

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
		properties = "OSGI-INF/liferay/rest/v1_0/commercial.properties",
		scope = ServiceScope.PROTOTYPE,
		service = CommercialResource.class
)
public class CommercialResourceImpl extends BaseCommercialResourceImpl {

	@Override
	public Page<Commercial> getCommerciauxPage(
			Long superviseurId, String search, Filter filter,
			Pagination pagination, Sort[] sorts) {

		BackendJsonUtil.Page<Commercial> result = _backend.list(
				superviseurId, search,
				pagination.getPage() - 1, pagination.getPageSize(),
				ReseauPaginationSort.toSortParam(sorts));
		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public Commercial postCommercial(CommercialRequestBody body) {
		return _backend.create(body);
	}

	@Override
	public Commercial getCommercial(Long commercialId) {
		return _backend.getById(commercialId);
	}

	@Override
	public Commercial putCommercial(Long commercialId, Commercial body) {
		return _backend.update(commercialId, body);
	}

	@Override
	public Response deleteCommercial(Long commercialId) {
		_backend.delete(commercialId);
		return Response.noContent().build();
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Commercial>,
					UnsafeFunction<Commercial, Commercial, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	@Reference
	private BackendCommercialService _backend;
}
