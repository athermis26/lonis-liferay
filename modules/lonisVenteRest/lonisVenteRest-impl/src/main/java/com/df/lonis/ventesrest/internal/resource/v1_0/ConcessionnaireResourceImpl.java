package com.df.lonis.ventesrest.internal.resource.v1_0;

import com.df.lonis.ventesrest.dto.v1_0.Concessionnaire;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireActivite;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireDetail;
import com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireProduit;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.mapper.ConcessionnaireMapper;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.mapper.ConcessionnaireProduitMapper;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.mapper.TerminalMapper;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.GenericODataFilterVisitor;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.ODataFilterApplier;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.ODataFilterUtil;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0.ChiffreAffaireEntityModel;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.entity.v1_0.ConcessionnaireEntityModel;
import com.df.lonis.ventesrest.resource.v1_0.ConcessionnaireResource;

import com.df.lonis.ventesservice.model.Terminal;
import com.df.lonis.ventesservice.service.*;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.filter.FilterParserProvider;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.*;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author HP
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/concessionnaire.properties",
		scope = ServiceScope.PROTOTYPE,
		service = ConcessionnaireResource.class
)
public class ConcessionnaireResourceImpl extends BaseConcessionnaireResourceImpl {

	@Override
	public Page<Concessionnaire> getConcessionnairesPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		List<GenericODataFilterVisitor.Criterion> criteria =
				ODataFilterUtil.extractCriteria(
						contextUriInfo, _filterParserProvider, _entityModel);

		DynamicQuery dq = _concessionnaireLocalService.dynamicQuery();
		ODataFilterApplier.apply(dq, criteria, _FIELD_TYPES);
		dq.setLimit(
				pagination.getStartPosition(), pagination.getEndPosition());

		List<com.df.lonis.ventesservice.model.Concessionnaire> entries =
				_concessionnaireLocalService.dynamicQuery(dq);

		DynamicQuery countDq = _concessionnaireLocalService.dynamicQuery();
		ODataFilterApplier.apply(countDq, criteria, _FIELD_TYPES);
		long total = _concessionnaireLocalService.dynamicQueryCount(countDq);

		return Page.of(
				entries.stream().map(_concessionnaireMapper::toDto).collect(Collectors.toList()),
				pagination, total);
	}

	@Override
	public EntityModel getEntityModel(
		Map<String, List<String>> multivaluedMap) {

		return _entityModel;
	}

	@Override
	public ConcessionnaireDetail getConcessionnaireById(Long id) {

		com.df.lonis.ventesservice.model.Concessionnaire entry = _concessionnaireLocalService.fetchConcessionnaire(id);

		if (entry == null) {
			throw new NotFoundException("Concessionnaire introuvable: " + id);
		}

		List<com.df.lonis.ventesservice.model.ConcessionnaireProduit> cps =
				_concessionnaireProduitLocalService.findByConcessionnaireId(
						entry.getId());

		List<Terminal> terminaux = _terminalLocalService.findByConcessionnaireId(entry.getId());

		ConcessionnaireProduit[] cpDtos = cps.stream()
				.map(_concessionnaireProduitMapper::toDtoProduit)
				.toArray(ConcessionnaireProduit[]::new);

		com.df.lonis.ventesrest.dto.v1_0.Terminal[] terminauxDtos = terminaux.stream().map(_terminalMapper::toDto).toArray(com.df.lonis.ventesrest.dto.v1_0.Terminal[]::new);

		return _concessionnaireMapper.toDtoDetail(entry, cps, cpDtos, terminauxDtos);
	}

	@Override
	public Page<ConcessionnaireProduit> getConcessionnaireProduits(Long uid)
			throws Exception {

		com.df.lonis.ventesservice.model.Concessionnaire entry = _concessionnaireLocalService.fetchConcessionnaire(uid);

		if (entry == null) {
			throw new NotFoundException("Concessionnaire introuvable: " + uid);
		}

		List<com.df.lonis.ventesservice.model.ConcessionnaireProduit> cps =
				_concessionnaireProduitLocalService.findByConcessionnaireId(
						entry.getId());

		return Page.of(
				cps.stream().map(_concessionnaireProduitMapper::toDtoProduit).collect(Collectors.toList()));
	}

	@Override
	public Page<ConcessionnaireActivite> getTopConcessionnairesActifs(
			Integer limit, Filter filter)
			throws Exception {

		int topN = (limit == null || limit <= 0) ? 10 : limit;

		// 1) Filtre OData (sur les chiffres affaires : date)
		List<GenericODataFilterVisitor.Criterion> criteria =
				ODataFilterUtil.extractCriteria(
						contextUriInfo, _filterParserProvider,
						new ChiffreAffaireEntityModel());

		// 2) Tous les chiffres affaires de la periode
		DynamicQuery caDq = _chiffreAffairesLocalService.dynamicQuery();
		Map<String, Class<?>> caTypes = new HashMap<>();
		caTypes.put("date", Date.class);
		caTypes.put("terminalId", Long.class);
		ODataFilterApplier.apply(caDq, criteria, caTypes);

		List<com.df.lonis.ventesservice.model.ChiffreAffaires> cas =
				_chiffreAffairesLocalService.dynamicQuery(caDq);

		// 3) Pre-charger tous les terminaux pour mapping terminalId -> concessionnaireId
		List<com.df.lonis.ventesservice.model.Terminal> terminaux =
				_terminalLocalService.getTerminals(-1, -1);

		Map<Long, Long> terminalToConcess = new HashMap<>();
		Map<Long, List<Long>> concessToTerminals = new HashMap<>();

		for (com.df.lonis.ventesservice.model.Terminal t : terminaux) {
			terminalToConcess.put(t.getId(), t.getConcessionnaireId());
			concessToTerminals
					.computeIfAbsent(t.getConcessionnaireId(), k -> new ArrayList<>())
					.add(t.getId());
		}

		// 4) Agreger les CA par concessionnaire
		Map<Long, long[]> stats = new HashMap<>();  // [chiffreAffaires, soldeTotal]

		for (com.df.lonis.ventesservice.model.ChiffreAffaires ca : cas) {
			Long concessId = terminalToConcess.get(ca.getTerminalId());
			if (concessId == null) {
				continue;
			}
			long[] arr = stats.computeIfAbsent(concessId, k -> new long[2]);
			arr[0] += ca.getVentes();
			arr[1] += ca.getBalance();
		}

		// 5) Compter operations par concessionnaire (1 query par terminal — TODO optim)
		// Pour faire simple ici, on les compte via DynamicQuery groupant par terminal
		// OU en parcourant les terminaux du top final uniquement (lazy)

		// 6) Trier par CA decroissant et limiter
		List<Map.Entry<Long, long[]>> sorted = stats.entrySet().stream()
				.sorted((a, b) -> Long.compare(b.getValue()[0], a.getValue()[0]))
				.limit(topN)
				.collect(Collectors.toList());

		// 7) Construire les DTO (load lazy de chaque concessionnaire + count operations)
		List<ConcessionnaireActivite> result = new ArrayList<>();

		for (Map.Entry<Long, long[]> e : sorted) {
			Long concessId = e.getKey();
			long[] arr = e.getValue();

			com.df.lonis.ventesservice.model.Concessionnaire c =
					_concessionnaireLocalService.fetchConcessionnaire(concessId);
			if (c == null) {
				continue;
			}

			ConcessionnaireActivite dto = new ConcessionnaireActivite();
			dto.setConcessionnaireId(concessId);
			dto.setUid(c.getUid());
			dto.setNom(c.getNom());
			dto.setPrenoms(c.getPrenoms());
			dto.setTelephone(c.getTelephone());

			List<Long> tIds = concessToTerminals.getOrDefault(
					concessId, java.util.Collections.emptyList());
			dto.setNombreTerminaux(tIds.size());

			// Count operations sur les terminaux du concessionnaire (sur la periode)
			long nbOps = 0;
			for (Long tId : tIds) {
				nbOps += _operationLocalService.countByTerminalId(tId);
			}
			dto.setNombreOperations(nbOps);
			dto.setChiffreAffaires(arr[0]);
			dto.setSoldeTotal(arr[1]);

			// Codes des ConcessionnaireProduit du concessionnaire
			List<com.df.lonis.ventesservice.model.ConcessionnaireProduit> cps =
					_concessionnaireProduitLocalService.findByConcessionnaireId(
							concessId);

			String[] codes = cps.stream()
					.map(com.df.lonis.ventesservice.model.ConcessionnaireProduit::getConcessionnaireCode)
					.filter(Objects::nonNull)
					.distinct()
					.toArray(String[]::new);

			dto.setConcessionnaireCodes(codes);

			result.add(dto);
		}

		return Page.of(result);
	}

	@Override
	public void setContextBatchUnsafeBiConsumer(
			UnsafeBiConsumer<Collection<Concessionnaire>,
					UnsafeFunction<Concessionnaire, Concessionnaire, Exception>,
					Exception> contextBatchUnsafeBiConsumer) {
	}

	private static final Map<String, Class<?>> _FIELD_TYPES = new HashMap<>();

	static {
		_FIELD_TYPES.put("id", Long.class);
		_FIELD_TYPES.put("uid", String.class);
		_FIELD_TYPES.put("nom", String.class);
		_FIELD_TYPES.put("prenoms", String.class);
		_FIELD_TYPES.put("telephone", String.class);
		_FIELD_TYPES.put("email", String.class);
	}

	private final EntityModel _entityModel = new ConcessionnaireEntityModel();

	@Reference
	private FilterParserProvider _filterParserProvider;

//	Les Mappers
	@Reference
	private ConcessionnaireMapper _concessionnaireMapper;

	@Reference
	private ConcessionnaireProduitMapper _concessionnaireProduitMapper;

	@Reference
	private TerminalMapper _terminalMapper;

//	Les Services
	@Reference
	private ConcessionnaireLocalService _concessionnaireLocalService;

	@Reference
	private ConcessionnaireProduitLocalService _concessionnaireProduitLocalService;

	@Reference
	private TerminalLocalService _terminalLocalService;

	@Reference
	private OperationLocalService _operationLocalService;

	@Reference
	private ChiffreAffairesLocalService _chiffreAffairesLocalService;

}