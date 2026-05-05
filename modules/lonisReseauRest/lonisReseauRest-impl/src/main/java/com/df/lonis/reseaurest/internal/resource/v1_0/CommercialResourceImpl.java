package com.df.lonis.reseaurest.internal.resource.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Commercial;
import com.df.lonis.reseaurest.dto.v1_0.CommercialRequestBody;
import com.df.lonis.reseaurest.internal.resource.v1_0.internal.mapper.CommercialMapper;
import com.df.lonis.reseaurest.resource.v1_0.CommercialResource;

import com.df.lonis.ventesservice.service.CommercialLocalService;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/commercial.properties",
	scope = ServiceScope.PROTOTYPE, service = CommercialResource.class
)
public class CommercialResourceImpl extends BaseCommercialResourceImpl {

	@Override
	public Page<Commercial> getCommerciauxPage(
			Long superviseurId, String search, Filter filter,
			Pagination pagination, Sort[] sorts)
		throws Exception {

		DynamicQuery dq = _commercialLocalService.dynamicQuery();
		_applySearch(dq, superviseurId, search);
		dq.setLimit(
			pagination.getStartPosition(), pagination.getEndPosition());

		List<com.df.lonis.ventesservice.model.Commercial> entries =
			_commercialLocalService.dynamicQuery(dq);

		DynamicQuery countDq = _commercialLocalService.dynamicQuery();
		_applySearch(countDq, superviseurId, search);
		long total = _commercialLocalService.dynamicQueryCount(countDq);

		return Page.of(
			entries.stream(
			).map(
				_commercialMapper::toDto
			).collect(
				Collectors.toList()
			),
			pagination, total);
	}

	@Override
	public Commercial postCommercial(CommercialRequestBody body)
		throws Exception {

		// id-type="identity" => la BDD genere l'ID a l'INSERT
		com.df.lonis.ventesservice.model.Commercial entry =
			_commercialLocalService.createCommercial(0);

		_commercialMapper.applyRequestBody(entry, body);
		entry.setCreatedAt(new Date());
		entry.setUpdatedAt(new Date());

		entry = _commercialLocalService.addCommercial(entry);

		return _commercialMapper.toDto(entry);
	}

	@Override
	public Commercial getCommercial(Long commercialId) throws Exception {
		com.df.lonis.ventesservice.model.Commercial entry =
			_commercialLocalService.fetchCommercial(commercialId);

		if (entry == null) {
			throw new NotFoundException(
				"Commercial introuvable: " + commercialId);
		}

		return _commercialMapper.toDto(entry);
	}

	@Override
	public Commercial putCommercial(Long commercialId, Commercial body)
		throws Exception {

		com.df.lonis.ventesservice.model.Commercial entry =
			_commercialLocalService.fetchCommercial(commercialId);

		if (entry == null) {
			throw new NotFoundException(
				"Commercial introuvable: " + commercialId);
		}

		_commercialMapper.applyDto(entry, body);
		entry.setUpdatedAt(new Date());

		entry = _commercialLocalService.updateCommercial(entry);

		return _commercialMapper.toDto(entry);
	}

	@Override
	public Response deleteCommercial(Long commercialId) throws Exception {
		com.df.lonis.ventesservice.model.Commercial entry =
			_commercialLocalService.fetchCommercial(commercialId);

		if (entry == null) {
			throw new NotFoundException(
				"Commercial introuvable: " + commercialId);
		}

		_commercialLocalService.deleteCommercial(entry);

		return Response.noContent().build();
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
		UnsafeBiConsumer
			<Collection<Commercial>,
			 UnsafeFunction<Commercial, Commercial, Exception>,
			 Exception> contextBatchUnsafeBiConsumer) {
	}

	private void _applySearch(
		DynamicQuery dq, Long superviseurId, String search) {

		if (superviseurId != null) {
			dq.add(
				PropertyFactoryUtil.forName(
					"superviseurId"
				).eq(
					superviseurId
				));
		}
		if ((search != null) && !search.isEmpty()) {
			String like = "%" + search.toLowerCase() + "%";
			dq.add(
				RestrictionsFactoryUtil.disjunction(
				).add(
					RestrictionsFactoryUtil.ilike("nom", like)
				).add(
					RestrictionsFactoryUtil.ilike("prenoms", like)
				).add(
					RestrictionsFactoryUtil.ilike("matricule", like)
				));
		}
	}

	@Reference
	private CommercialLocalService _commercialLocalService;

	@Reference
	private CommercialMapper _commercialMapper;

}
