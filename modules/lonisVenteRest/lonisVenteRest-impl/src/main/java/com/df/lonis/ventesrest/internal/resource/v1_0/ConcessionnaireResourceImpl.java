package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Concessionnaire;
import com.df.lonis.ventesrest.resource.v1_0.ConcessionnaireResource;

import com.df.lonis.ventesservice.service.ConcessionnaireLocalService;
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
import java.util.stream.Collectors;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/concessionnaire.properties",
	scope = ServiceScope.PROTOTYPE, service = ConcessionnaireResource.class
)
public class ConcessionnaireResourceImpl extends BaseConcessionnaireResourceImpl {
	@Override
	public Page<Concessionnaire> getConcessionnairesPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		List<com.df.lonis.ventesservice.model.Concessionnaire> entries = _concessionnaireLocalService.getConcessionnaires(pagination.getStartPosition(), pagination.getEndPosition());

		int total = _concessionnaireLocalService.getConcessionnairesCount();

		return Page.of(
				entries.stream().map(this::_toDto).collect(Collectors.toList()), pagination, total
		);
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Concessionnaire>, UnsafeFunction<Concessionnaire, Concessionnaire, Exception>, Exception> contextBatchUnsafeBiConsumer) {

	}

	private Concessionnaire _toDto(com.df.lonis.ventesservice.model.Concessionnaire entry) {
		Concessionnaire dto = new Concessionnaire();
		dto.setId(entry.getId());
		dto.setUid(entry.getUid());
		dto.setNom(entry.getNom());
		dto.setPrenoms(entry.getPrenoms());
		dto.setTelephone(entry.getTelephone());
		dto.setEmail(entry.getEmail());
		return dto;
	}

	@Reference
	private ConcessionnaireLocalService _concessionnaireLocalService;
}