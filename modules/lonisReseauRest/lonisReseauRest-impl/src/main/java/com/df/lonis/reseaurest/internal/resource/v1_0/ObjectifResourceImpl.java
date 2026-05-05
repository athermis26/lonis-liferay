package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Objectif;
import com.df.lonis.reseaurest.internal.resource.v1_0.internal.mapper.ObjectifMapper;
import com.df.lonis.reseaurest.resource.v1_0.ObjectifResource;

import com.df.lonis.ventesservice.service.ObjectifLocalService;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
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
	properties = "OSGI-INF/liferay/rest/v1_0/objectif.properties",
	scope = ServiceScope.PROTOTYPE, service = ObjectifResource.class
)
public class ObjectifResourceImpl extends BaseObjectifResourceImpl {

	@Override
	public Page<Objectif> getObjectifsPage(
			Long commercialId, Integer annee, Integer mois, String search,
			Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		DynamicQuery dq = _objectifLocalService.dynamicQuery();
		_applyFilters(dq, commercialId, annee, mois);
		dq.setLimit(
			pagination.getStartPosition(), pagination.getEndPosition());

		List<com.df.lonis.ventesservice.model.Objectif> entries =
			_objectifLocalService.dynamicQuery(dq);

		DynamicQuery countDq = _objectifLocalService.dynamicQuery();
		_applyFilters(countDq, commercialId, annee, mois);
		long total = _objectifLocalService.dynamicQueryCount(countDq);

		return Page.of(
			entries.stream(
			).map(
				_objectifMapper::toDto
			).collect(
				Collectors.toList()
			),
			pagination, total);
	}

	@Override
	public Objectif postObjectif(Objectif body) throws Exception {
		// Verifier unicite via finder C_A_M (commercial + annee + mois)
		if ((body.getCommercialId() != null) && (body.getAnnee() != null) &&
			(body.getMois() != null)) {

			com.df.lonis.ventesservice.model.Objectif existing =
				_objectifLocalService.fetchByC_A_M(
					body.getCommercialId(), body.getAnnee(),
					body.getMois());

			if (existing != null) {
				throw new WebApplicationException(
					"Objectif deja existant pour ce commercial et cette periode",
					Response.Status.CONFLICT);
			}
		}

		com.df.lonis.ventesservice.model.Objectif entry =
			_objectifLocalService.createObjectif(0);

		_objectifMapper.apply(entry, body);
		entry.setCreatedAt(new Date());
		entry.setUpdatedAt(new Date());

		entry = _objectifLocalService.addObjectif(entry);

		return _objectifMapper.toDto(entry);
	}

	@Override
	public Objectif putObjectif(Long objectifId, Objectif body)
		throws Exception {

		com.df.lonis.ventesservice.model.Objectif entry =
			_objectifLocalService.fetchObjectif(objectifId);

		if (entry == null) {
			throw new NotFoundException("Objectif introuvable: " + objectifId);
		}

		_objectifMapper.apply(entry, body);
		entry.setUpdatedAt(new Date());

		entry = _objectifLocalService.updateObjectif(entry);

		return _objectifMapper.toDto(entry);
	}

	@Override
	public Page<Objectif> getCommercialObjectifsPage(Long commercialId)
		throws Exception {

		List<com.df.lonis.ventesservice.model.Objectif> entries =
			_objectifLocalService.findByCommercialId(commercialId);

		return Page.of(
			entries.stream(
			).map(
				_objectifMapper::toDto
			).collect(
				Collectors.toList()
			));
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
		UnsafeBiConsumer
			<Collection<Objectif>,
			 UnsafeFunction<Objectif, Objectif, Exception>,
			 Exception> contextBatchUnsafeBiConsumer) {
	}

	private void _applyFilters(
		DynamicQuery dq, Long commercialId, Integer annee, Integer mois) {

		if (commercialId != null) {
			dq.add(
				PropertyFactoryUtil.forName(
					"commercialId"
				).eq(
					commercialId
				));
		}
		if (annee != null) {
			dq.add(PropertyFactoryUtil.forName("annee").eq(annee));
		}
		if (mois != null) {
			dq.add(PropertyFactoryUtil.forName("mois").eq(mois));
		}
	}

	@Reference
	private ObjectifLocalService _objectifLocalService;

	@Reference
	private ObjectifMapper _objectifMapper;

}
