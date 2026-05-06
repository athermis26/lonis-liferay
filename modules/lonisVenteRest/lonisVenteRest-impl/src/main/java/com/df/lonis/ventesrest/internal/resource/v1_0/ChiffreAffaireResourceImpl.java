package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.ChiffreAffaire;
import com.df.lonis.ventesrest.internal.backend.BackendJsonUtil;
import com.df.lonis.ventesrest.internal.backend.service.BackendChiffreAffairesService;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportColumn;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportResponseUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0.ChiffreAffaireEntityModel;
import com.df.lonis.ventesrest.resource.v1_0.ChiffreAffaireResource;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * Implémentation {@link ChiffreAffaireResource} en proxy vers le backend Spring Boot.
 *
 * <p>Les exports CSV/PDF/XLSX restent côté Liferay : on fetch la liste depuis le
 * backend (sans pagination), puis on délègue au {@link ExportResponseUtil}.</p>
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/chiffre-affaire.properties",
		scope = ServiceScope.PROTOTYPE,
		service = ChiffreAffaireResource.class
)
public class ChiffreAffaireResourceImpl extends BaseChiffreAffaireResourceImpl {

	private static final int EXPORT_PAGE_SIZE = 10_000;

	@Override
	public Page<ChiffreAffaire> getChiffresAffairesPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts) {

		BackendJsonUtil.Page<ChiffreAffaire> result = _backend.list(
				search,
				pagination.getPage() - 1,
				pagination.getPageSize(),
				PaginationSort.toSortParam(sorts));

		return Page.of(result.items(), pagination, result.total());
	}

	@Override
	public Response exportChiffresAffaires(String format, Filter filter) throws Exception {
		// On rapatrie tout depuis le backend (cap à EXPORT_PAGE_SIZE) puis on formate.
		List<ChiffreAffaire> entries = _backend.list(null, 0, EXPORT_PAGE_SIZE, null).items();

		List<ExportColumn<ChiffreAffaire>> columns = Arrays.asList(
				new ExportColumn<>("Code Terminal",   ChiffreAffaire::getCodeTerminal),
				new ExportColumn<>("Concessionnaire", ChiffreAffaire::getConcessionnaireNomPrenom),
				new ExportColumn<>("Produit",         ChiffreAffaire::getProduitType),
				new ExportColumn<>("Site",            ChiffreAffaire::getSite),
				new ExportColumn<>("Brut",            ChiffreAffaire::getBrut),
				new ExportColumn<>("Ventes",          ChiffreAffaire::getVentes),
				new ExportColumn<>("CA",              ChiffreAffaire::getChiffreAffaire));

		return ExportResponseUtil.build(
				format, "chiffres-affaires", "Chiffres d'affaires", entries, columns);
	}

	@Override
	public EntityModel getEntityModel(Map<String, List<String>> multivaluedMap) {
		return _entityModel;
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<ChiffreAffaire>,
					UnsafeFunction<ChiffreAffaire, ChiffreAffaire, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	private final EntityModel _entityModel = new ChiffreAffaireEntityModel();

	@Reference
	private BackendChiffreAffairesService _backend;
}
