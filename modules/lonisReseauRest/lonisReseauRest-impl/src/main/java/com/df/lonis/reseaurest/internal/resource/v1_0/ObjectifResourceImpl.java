package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Objectif;
import com.df.lonis.reseaurest.internal.backend.BackendJsonUtil;
import com.df.lonis.reseaurest.internal.backend.service.BackendObjectifService;
import com.df.lonis.reseaurest.resource.v1_0.ObjectifResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Collection;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/objectif.properties",
		scope = ServiceScope.PROTOTYPE,
		service = ObjectifResource.class
)
public class ObjectifResourceImpl extends BaseObjectifResourceImpl {

	@Override
	public Page<Objectif> getObjectifsPage(
			Long commercialId, Integer annee, Integer mois,
			String search, Filter filter, Pagination pagination, Sort[] sorts) {

		BackendJsonUtil.Page<Objectif> result = _backend.list(
				commercialId, annee, mois,
				pagination.getPage() - 1, pagination.getPageSize(),
				ReseauPaginationSort.toSortParam(sorts));
		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public Objectif postObjectif(Objectif body) {
		return _backend.create(body);
	}

	@Override
	public Objectif putObjectif(Long objectifId, Objectif body) {
		return _backend.update(objectifId, body);
	}

	@Override
	public Page<Objectif> getCommercialObjectifsPage(Long commercialId) {
		return Page.of(_backend.listByCommercial(commercialId));
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Objectif>,
					UnsafeFunction<Objectif, Objectif, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	@Reference
	private BackendObjectifService _backend;
}
