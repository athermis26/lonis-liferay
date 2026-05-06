package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Concessionnaire;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireActivite;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireBody;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireDetail;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireProduit;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;
import com.df.lonis.ventesrest.internal.backend.service.BackendConcessionnaireService;
import com.df.lonis.ventesrest.resource.v1_0.ConcessionnaireResource;

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

/**
 * Implémentation {@link ConcessionnaireResource} en proxy vers le backend Spring Boot.
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/concessionnaire.properties",
		scope = ServiceScope.PROTOTYPE,
		service = ConcessionnaireResource.class
)
public class ConcessionnaireResourceImpl extends BaseConcessionnaireResourceImpl {

	@Override
	public Page<Concessionnaire> getConcessionnairesPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts) {

		BackendJsonUtil.Page<Concessionnaire> result = _backend.list(
				search,
				pagination.getPage() - 1,
				pagination.getPageSize(),
				PaginationSort.toSortParam(sorts));

		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public Concessionnaire addConcessionnaire(ConcessionnaireBody body) {
		return _backend.create(body);
	}

	@Override
	public ConcessionnaireDetail getConcessionnaireById(Long id) {
		return _backend.getById(id);
	}

	@Override
	public Page<ConcessionnaireProduit> getConcessionnaireProduits(Long id) {
		return Page.of(_backend.listProduits(id));
	}

	@Override
	public Response deleteConcessionnaireProduit(Long id, Long concessionnaireProduitId) {
		_backend.deleteProduitLink(id, concessionnaireProduitId);
		return Response.noContent().build();
	}

	@Override
	public Page<ConcessionnaireActivite> getTopConcessionnairesActifs(
			Integer limit, Filter filter) {

		int n = (limit == null || limit <= 0) ? 10 : limit;
		return Page.of(_backend.topActifs(n));
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Concessionnaire>,
					UnsafeFunction<Concessionnaire, Concessionnaire, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	@Reference
	private BackendConcessionnaireService _backend;
}
