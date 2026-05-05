package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Visite;
import com.df.lonis.reseaurest.dto.v1_0.VisiteRequestBody;
import com.df.lonis.reseaurest.internal.resource.v1_0.internal.mapper.VisiteMapper;
import com.df.lonis.reseaurest.internal.resource.v1_0.internal.util.GpsUtil;
import com.df.lonis.reseaurest.resource.v1_0.VisiteResource;

import com.df.lonis.ventesservice.service.TerminalLocalService;
import com.df.lonis.ventesservice.service.VisiteLocalService;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/visite.properties",
	scope = ServiceScope.PROTOTYPE, service = VisiteResource.class
)
public class VisiteResourceImpl extends BaseVisiteResourceImpl {

	@Override
	public Page<Visite> getVisitesPage(
			Long commercialId, Long terminalId, String statut, Date dateDebut,
			Date dateFin, String search, Filter filter, Pagination pagination,
			Sort[] sorts)
		throws Exception {

		DynamicQuery dq = _visiteLocalService.dynamicQuery();
		_applyFilters(
			dq, commercialId, terminalId, statut, dateDebut, dateFin);
		dq.setLimit(
			pagination.getStartPosition(), pagination.getEndPosition());

		List<com.df.lonis.ventesservice.model.Visite> entries =
			_visiteLocalService.dynamicQuery(dq);

		DynamicQuery countDq = _visiteLocalService.dynamicQuery();
		_applyFilters(
			countDq, commercialId, terminalId, statut, dateDebut, dateFin);
		long total = _visiteLocalService.dynamicQueryCount(countDq);

		return Page.of(
			entries.stream(
			).map(
				_visiteMapper::toDto
			).collect(
				Collectors.toList()
			),
			pagination, total);
	}

	/**
	 * Cree une visite avec controle de proximite GPS:
	 * la position du commercial doit etre a moins de _GPS_THRESHOLD_METERS
	 * du terminal.
	 */
	@Override
	public Visite postVisite(VisiteRequestBody body) throws Exception {
		if ((body.getTerminalId() == null) || (body.getLatitude() == null) ||
			(body.getLongitude() == null)) {

			throw new BadRequestException(
				"terminalId, latitude et longitude sont requis");
		}

		com.df.lonis.ventesservice.model.Terminal terminal =
			_terminalLocalService.fetchTerminal(body.getTerminalId());

		if (terminal == null) {
			throw new NotFoundException(
				"Terminal introuvable: " + body.getTerminalId());
		}

		// Controle proximite seulement si le terminal a des coordonnees
		if ((terminal.getLatitude() != null) &&
			(terminal.getLongitude() != null)) {

			double distance = GpsUtil.distanceMeters(
				body.getLatitude(), body.getLongitude(),
				terminal.getLatitude(), terminal.getLongitude());

			if (distance > _GPS_THRESHOLD_METERS) {
				throw new BadRequestException(
					"Commercial trop loin du point de vente (" +
						(int)distance + "m)");
			}
		}

		com.df.lonis.ventesservice.model.Visite entry =
			_visiteLocalService.createVisite(0);

		_visiteMapper.applyRequestBody(entry, body);

		if (entry.getDateVisite() == null) {
			entry.setDateVisite(new Date());
		}
		entry.setCreatedAt(new Date());
		entry.setUpdatedAt(new Date());

		entry = _visiteLocalService.addVisite(entry);

		return _visiteMapper.toDto(entry);
	}

	@Override
	public Visite getVisite(Long visiteId) throws Exception {
		com.df.lonis.ventesservice.model.Visite entry =
			_visiteLocalService.fetchVisite(visiteId);

		if (entry == null) {
			throw new NotFoundException("Visite introuvable: " + visiteId);
		}

		return _visiteMapper.toDto(entry);
	}

	/**
	 * Visites du jour ou planifiees (vue temps-reel pour superviseur).
	 */
	@Override
	public Page<Visite> getVisitesTempsReel() throws Exception {
		Calendar startOfDay = Calendar.getInstance();
		startOfDay.set(Calendar.HOUR_OF_DAY, 0);
		startOfDay.set(Calendar.MINUTE, 0);
		startOfDay.set(Calendar.SECOND, 0);
		startOfDay.set(Calendar.MILLISECOND, 0);

		Calendar endOfDay = Calendar.getInstance();
		endOfDay.set(Calendar.HOUR_OF_DAY, 23);
		endOfDay.set(Calendar.MINUTE, 59);
		endOfDay.set(Calendar.SECOND, 59);

		DynamicQuery dq = _visiteLocalService.dynamicQuery();

		dq.add(
			com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil.or(
				PropertyFactoryUtil.forName("statut").eq(_STATUT_PLANIFIEE),
				com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil.and(
					PropertyFactoryUtil.forName("dateVisite").ge(
						startOfDay.getTime()),
					PropertyFactoryUtil.forName("dateVisite").le(
						endOfDay.getTime()))));

		List<com.df.lonis.ventesservice.model.Visite> entries =
			_visiteLocalService.dynamicQuery(dq);

		return Page.of(
			entries.stream(
			).map(
				_visiteMapper::toDto
			).collect(
				Collectors.toList()
			));
	}

	@Override
	public Page<Visite> getCommercialVisitesPage(Long commercialId)
		throws Exception {

		List<com.df.lonis.ventesservice.model.Visite> entries =
			_visiteLocalService.findByCommercialId(commercialId);

		return Page.of(
			entries.stream(
			).map(
				_visiteMapper::toDto
			).collect(
				Collectors.toList()
			));
	}

	/**
	 * Planning : visites futures (PLANIFIEE) + retour des effectives
	 * du mois courant.
	 */
	@Override
	public Page<Visite> getCommercialVisitesPlanningPage(Long commercialId)
		throws Exception {

		Calendar startOfMonth = Calendar.getInstance();
		startOfMonth.set(Calendar.DAY_OF_MONTH, 1);
		startOfMonth.set(Calendar.HOUR_OF_DAY, 0);
		startOfMonth.set(Calendar.MINUTE, 0);
		startOfMonth.set(Calendar.SECOND, 0);
		startOfMonth.set(Calendar.MILLISECOND, 0);

		Calendar endOfMonth = (Calendar)startOfMonth.clone();
		endOfMonth.add(Calendar.MONTH, 1);
		endOfMonth.add(Calendar.MILLISECOND, -1);

		DynamicQuery dq = _visiteLocalService.dynamicQuery();
		dq.add(
			PropertyFactoryUtil.forName("commercialId").eq(commercialId));
		dq.add(
			PropertyFactoryUtil.forName("dateVisite").ge(
				startOfMonth.getTime()));
		dq.add(
			PropertyFactoryUtil.forName("dateVisite").le(
				endOfMonth.getTime()));

		List<com.df.lonis.ventesservice.model.Visite> entries =
			_visiteLocalService.dynamicQuery(dq);

		return Page.of(
			entries.stream(
			).map(
				_visiteMapper::toDto
			).collect(
				Collectors.toList()
			));
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
		UnsafeBiConsumer
			<Collection<Visite>,
			 UnsafeFunction<Visite, Visite, Exception>,
			 Exception> contextBatchUnsafeBiConsumer) {
	}

	private void _applyFilters(
		DynamicQuery dq, Long commercialId, Long terminalId, String statut,
		Date dateDebut, Date dateFin) {

		if (commercialId != null) {
			dq.add(
				PropertyFactoryUtil.forName(
					"commercialId"
				).eq(
					commercialId
				));
		}
		if (terminalId != null) {
			dq.add(
				PropertyFactoryUtil.forName("terminalId").eq(terminalId));
		}
		if ((statut != null) && !statut.isEmpty()) {
			dq.add(PropertyFactoryUtil.forName("statut").eq(statut));
		}
		if (dateDebut != null) {
			dq.add(PropertyFactoryUtil.forName("dateVisite").ge(dateDebut));
		}
		if (dateFin != null) {
			dq.add(PropertyFactoryUtil.forName("dateVisite").le(dateFin));
		}
	}

	private static final int _GPS_THRESHOLD_METERS = 100;
	private static final String _STATUT_PLANIFIEE = "PLANIFIEE";

	@Reference
	private TerminalLocalService _terminalLocalService;

	@Reference
	private VisiteLocalService _visiteLocalService;

	@Reference
	private VisiteMapper _visiteMapper;

}
