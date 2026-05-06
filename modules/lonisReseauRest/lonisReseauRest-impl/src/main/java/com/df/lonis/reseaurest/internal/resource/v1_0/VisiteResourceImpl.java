package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Visite;
import com.df.lonis.reseaurest.dto.v1_0.VisiteRequestBody;
import com.df.lonis.reseaurest.internal.backend.BackendJsonUtil;
import com.df.lonis.reseaurest.internal.backend.service.BackendVisiteService;
import com.df.lonis.reseaurest.resource.v1_0.VisiteResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/visite.properties",
		scope = ServiceScope.PROTOTYPE,
		service = VisiteResource.class
)
public class VisiteResourceImpl extends BaseVisiteResourceImpl {

	@Override
	public Page<Visite> getVisitesPage(
			Long commercialId, Long terminalId, String statut,
			Date dateDebut, Date dateFin, String search, Filter filter,
			Pagination pagination, Sort[] sorts) {

		BackendJsonUtil.Page<Visite> result = _backend.list(
				commercialId, terminalId, statut,
				toIso(dateDebut), toIso(dateFin),
				pagination.getPage() - 1, pagination.getPageSize(),
				ReseauPaginationSort.toSortParam(sorts));
		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public Visite postVisite(VisiteRequestBody body) {
		return _backend.create(body);
	}

	@Override
	public Visite getVisite(Long visiteId) {
		return _backend.getById(visiteId);
	}

	@Override
	public Page<Visite> getVisitesTempsReel() {
		return Page.of(_backend.tempsReel());
	}

	@Override
	public Page<Visite> getCommercialVisitesPage(Long commercialId) {
		return Page.of(_backend.listByCommercial(commercialId));
	}

	@Override
	public Page<Visite> getCommercialVisitesPlanningPage(Long commercialId) {
		return Page.of(_backend.planning(commercialId));
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Visite>,
					UnsafeFunction<Visite, Visite, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	private static String toIso(Date d) {
		if (d == null) return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.format(d);
	}

	@Reference
	private BackendVisiteService _backend;
}
