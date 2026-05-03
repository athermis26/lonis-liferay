package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.ChiffreAffaire;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportColumn;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.export.ExportResponseUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.mapper.ChiffreAffaireMapper;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.GenericODataFilterVisitor;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.ODataFilterApplier;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.ODataFilterUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0.ChiffreAffaireEntityModel;
import com.df.lonis.ventesrest.resource.v1_0.ChiffreAffaireResource;

import com.df.lonis.ventesservice.model.ChiffreAffaires;
import com.df.lonis.ventesservice.service.ChiffreAffairesLocalService;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.filter.FilterParserProvider;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author HP
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/chiffre-affaire.properties",
	scope = ServiceScope.PROTOTYPE, service = ChiffreAffaireResource.class
)
public class ChiffreAffaireResourceImpl
	extends BaseChiffreAffaireResourceImpl {

	@Override
	public Page<ChiffreAffaire> getChiffresAffairesPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		// 1) Extraire les criteres OData
		List<GenericODataFilterVisitor.Criterion> criteria =
			ODataFilterUtil.extractCriteria(
				contextUriInfo, _filterParserProvider, _entityModel);

		// 2) DynamicQuery + application des criteres
		DynamicQuery dq = _chiffreAffairesLocalService.dynamicQuery();
		ODataFilterApplier.apply(dq, criteria, _FIELD_TYPES);

		List<ChiffreAffaires> entries =
			_chiffreAffairesLocalService.dynamicQuery(dq);

		// 3) Agregation par terminal
		List<ChiffreAffaire> agreges = _chiffreAffaireMapper.toDtoAggrege(
			entries);

		// 4) Filtre search libre (sur les champs du DTO post-agregation)
		if ((search != null) && !search.isEmpty()) {
			String needle = search.toLowerCase();

			agreges = agreges.stream(
			).filter(
				d -> _contains(d.getCodeTerminal(), needle) ||
					 _contains(d.getConcessionnaireNomPrenom(), needle)
			).collect(
				Collectors.toList()
			);
		}

		// 5) Pagination en memoire (post-agregation)
		int total = agreges.size();
		int start = pagination.getStartPosition();
		int end = Math.min(pagination.getEndPosition(), total);

		if (start >= total) {
			return Page.of(new ArrayList<>(), pagination, total);
		}

		return Page.of(agreges.subList(start, end), pagination, total);
	}

	@Override
	public Response exportChiffresAffaires(String format, Filter filter)
		throws Exception {

		List<GenericODataFilterVisitor.Criterion> criteria =
			ODataFilterUtil.extractCriteria(
				contextUriInfo, _filterParserProvider, _entityModel);

		DynamicQuery dq = _chiffreAffairesLocalService.dynamicQuery();
		ODataFilterApplier.apply(dq, criteria, _FIELD_TYPES);

		List<ChiffreAffaires> entries =
			_chiffreAffairesLocalService.dynamicQuery(dq);

		// Agrege par terminal pour l export aussi
		List<ChiffreAffaire> agreges = _chiffreAffaireMapper.toDtoAggrege(
			entries);

//		List<ExportColumn<ChiffreAffaire>> columns = Arrays.asList(
//			new ExportColumn<>(
//				"Code Terminal ", ChiffreAffaire::getCodeTerminal),
//			new ExportColumn<>(
//				"Concessionnaire ",
//				ChiffreAffaire::getConcessionnaireNomPrenom),
//			new ExportColumn<>("Produit ", ChiffreAffaire::getProduitType),
//			new ExportColumn<>("Site ", ChiffreAffaire::getSite),
//			new ExportColumn<>("Brut ", ChiffreAffaire::getBrut),
//			new ExportColumn<>("Paiement ", ChiffreAffaire::getPaiement),
//			new ExportColumn<>("Annulation ", ChiffreAffaire::getAnnulation),
//			new ExportColumn<>(
//				"Remboursement ", ChiffreAffaire::getRembourcement),
//			new ExportColumn<>("Ventes ", ChiffreAffaire::getVentes),
//			new ExportColumn<>("Balance ", ChiffreAffaire::getBalance),
//			new ExportColumn<>(
//				"Chiffre d'affaires ", ChiffreAffaire::getChiffreAffaire));

		List<ExportColumn<ChiffreAffaire>> columns = Arrays.asList(
				new ExportColumn<>("Code Terminal", ChiffreAffaire::getCodeTerminal),
				new ExportColumn<>("Concessionnaire", ChiffreAffaire::getConcessionnaireNomPrenom),
				new ExportColumn<>("Produit", ChiffreAffaire::getProduitType),
				new ExportColumn<>("Site", ChiffreAffaire::getSite),
				new ExportColumn<>("Brut", ChiffreAffaire::getBrut),
				new ExportColumn<>("Ventes", ChiffreAffaire::getVentes),
				new ExportColumn<>("CA", ChiffreAffaire::getChiffreAffaire));

		return ExportResponseUtil.build(
			format, "chiffres-affaires", "Chiffres d'affaires", agreges,
			columns);
	}

	@Override
	public EntityModel getEntityModel(
		Map<String, List<String>> multivaluedMap) {

		return _entityModel;
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
		UnsafeBiConsumer
			<Collection<ChiffreAffaire>,
			 UnsafeFunction<ChiffreAffaire, ChiffreAffaire, Exception>,
			 Exception> contextBatchUnsafeBiConsumer) {
	}

	private boolean _contains(String s, String needle) {
		return (s != null) && s.toLowerCase().contains(needle);
	}

	private static final Map<String, Class<?>> _FIELD_TYPES = new HashMap<>();

	static {
		_FIELD_TYPES.put("date", Date.class);
		_FIELD_TYPES.put("terminalId", Long.class);
	}

	private final EntityModel _entityModel = new ChiffreAffaireEntityModel();

	@Reference
	private ChiffreAffaireMapper _chiffreAffaireMapper;

	@Reference
	private ChiffreAffairesLocalService _chiffreAffairesLocalService;

	@Reference
	private FilterParserProvider _filterParserProvider;

}
