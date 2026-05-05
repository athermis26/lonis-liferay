package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.SiteCommercial;
import com.df.lonis.reseaurest.internal.resource.v1_0.internal.mapper.SiteCommercialMapper;
import com.df.lonis.reseaurest.resource.v1_0.SiteCommercialResource;

import com.df.lonis.ventesservice.service.SiteCommercialLocalService;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/site-commercial.properties",
	scope = ServiceScope.PROTOTYPE, service = SiteCommercialResource.class
)
public class SiteCommercialResourceImpl
	extends BaseSiteCommercialResourceImpl {

	@Override
	public Page<SiteCommercial> getCommercialSitesPage(Long commercialId)
		throws Exception {

		List<com.df.lonis.ventesservice.model.SiteCommercial> entries =
			_siteCommercialLocalService.findByCommercialId(commercialId);

		return Page.of(
			entries.stream(
			).map(
				_siteCommercialMapper::toDto
			).collect(
				Collectors.toList()
			));
	}

	@Override
	public SiteCommercial postCommercialSite(
			Long commercialId, SiteCommercial body)
		throws Exception {

		long siteId = (body.getSiteId() == null) ? 0L : body.getSiteId();

		com.df.lonis.ventesservice.model.SiteCommercial existing =
			_siteCommercialLocalService.fetchByS_C(siteId, commercialId);

		if ((existing != null) && (existing.getDateFin() == null)) {
			throw new WebApplicationException(
				"Affectation deja active", Response.Status.CONFLICT);
		}

		com.df.lonis.ventesservice.model.SiteCommercial entry =
			_siteCommercialLocalService.createSiteCommercial(0);

		entry.setCommercialId(commercialId);
		entry.setSiteId(siteId);
		entry.setDateDebut(
			(body.getDateDebut() != null) ? body.getDateDebut() : new Date());
		entry.setDateFin(body.getDateFin());
		entry.setIsPrincipal(
			(body.getIsPrincipal() != null) && body.getIsPrincipal());
		entry.setCreatedAt(new Date());

		entry = _siteCommercialLocalService.addSiteCommercial(entry);

		return _siteCommercialMapper.toDto(entry);
	}

	@Override
	public Response deleteCommercialSite(Long commercialId, Long siteId)
		throws Exception {

		com.df.lonis.ventesservice.model.SiteCommercial entry =
			_siteCommercialLocalService.fetchByS_C(siteId, commercialId);

		if (entry == null) {
			throw new NotFoundException("Affectation introuvable");
		}

		// Soft delete: dateFin = NOW
		entry.setDateFin(new Date());
		_siteCommercialLocalService.updateSiteCommercial(entry);

		return Response.noContent().build();
	}

	@Override
	public Page<SiteCommercial> getSiteCommerciauxPage(
			Long siteId, String search, Filter filter, Pagination pagination,
			Sort[] sorts)
		throws Exception {

		List<com.df.lonis.ventesservice.model.SiteCommercial> entries =
			_siteCommercialLocalService.findBySiteId(siteId);

		return Page.of(
			entries.stream(
			).map(
				_siteCommercialMapper::toDto
			).collect(
				Collectors.toList()
			));
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
		UnsafeBiConsumer
			<Collection<SiteCommercial>,
			 UnsafeFunction<SiteCommercial, SiteCommercial, Exception>,
			 Exception> contextBatchUnsafeBiConsumer) {
	}

	@Reference
	private SiteCommercialLocalService _siteCommercialLocalService;

	@Reference
	private SiteCommercialMapper _siteCommercialMapper;

}
