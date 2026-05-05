package com.df.lonis.reseaurest.internal.graphql.query.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Commercial;
import com.df.lonis.reseaurest.dto.v1_0.Evaluation;
import com.df.lonis.reseaurest.dto.v1_0.Objectif;
import com.df.lonis.reseaurest.dto.v1_0.SiteCommercial;
import com.df.lonis.reseaurest.dto.v1_0.Terminal;
import com.df.lonis.reseaurest.dto.v1_0.Visite;
import com.df.lonis.reseaurest.dto.v1_0.VisiteRequestBody;
import com.df.lonis.reseaurest.resource.v1_0.CommercialResource;
import com.df.lonis.reseaurest.resource.v1_0.EvaluationResource;
import com.df.lonis.reseaurest.resource.v1_0.ObjectifResource;
import com.df.lonis.reseaurest.resource.v1_0.SiteCommercialResource;
import com.df.lonis.reseaurest.resource.v1_0.TerminalResource;
import com.df.lonis.reseaurest.resource.v1_0.VisiteResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Date;
import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.constraints.NotEmpty;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class Query {

	public static void setCommercialResourceComponentServiceObjects(
		ComponentServiceObjects<CommercialResource>
			commercialResourceComponentServiceObjects) {

		_commercialResourceComponentServiceObjects =
			commercialResourceComponentServiceObjects;
	}

	public static void setEvaluationResourceComponentServiceObjects(
		ComponentServiceObjects<EvaluationResource>
			evaluationResourceComponentServiceObjects) {

		_evaluationResourceComponentServiceObjects =
			evaluationResourceComponentServiceObjects;
	}

	public static void setObjectifResourceComponentServiceObjects(
		ComponentServiceObjects<ObjectifResource>
			objectifResourceComponentServiceObjects) {

		_objectifResourceComponentServiceObjects =
			objectifResourceComponentServiceObjects;
	}

	public static void setSiteCommercialResourceComponentServiceObjects(
		ComponentServiceObjects<SiteCommercialResource>
			siteCommercialResourceComponentServiceObjects) {

		_siteCommercialResourceComponentServiceObjects =
			siteCommercialResourceComponentServiceObjects;
	}

	public static void setTerminalResourceComponentServiceObjects(
		ComponentServiceObjects<TerminalResource>
			terminalResourceComponentServiceObjects) {

		_terminalResourceComponentServiceObjects =
			terminalResourceComponentServiceObjects;
	}

	public static void setVisiteResourceComponentServiceObjects(
		ComponentServiceObjects<VisiteResource>
			visiteResourceComponentServiceObjects) {

		_visiteResourceComponentServiceObjects =
			visiteResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {commerciaux(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___, superviseurId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Liste des commerciaux")
	public CommercialPage commerciaux(
			@GraphQLName("superviseurId") Long superviseurId,
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_commercialResourceComponentServiceObjects,
			this::_populateResourceContext,
			commercialResource -> new CommercialPage(
				commercialResource.getCommerciauxPage(
					superviseurId, search,
					_filterBiFunction.apply(commercialResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(commercialResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {commercial(commercialId: ___){id, nom, prenoms, telephone, email, matricule, statut, superviseurId, agenceId}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Récupérer un commercial par sont ID")
	public Commercial commercial(@GraphQLName("commercialId") Long commercialId)
		throws Exception {

		return _applyComponentServiceObjects(
			_commercialResourceComponentServiceObjects,
			this::_populateResourceContext,
			commercialResource -> commercialResource.getCommercial(
				commercialId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {evaluationsClassement(annee: ___, mois: ___, periode: ___, trimestre: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "classement des commerciaux")
	public EvaluationPage evaluationsClassement(
			@GraphQLName("annee") Integer annee,
			@GraphQLName("mois") Integer mois,
			@GraphQLName("trimestre") Integer trimestre,
			@GraphQLName("periode") String periode)
		throws Exception {

		return _applyComponentServiceObjects(
			_evaluationResourceComponentServiceObjects,
			this::_populateResourceContext,
			evaluationResource -> new EvaluationPage(
				evaluationResource.getEvaluationsClassementPage(
					annee, mois, trimestre, periode)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {commercialEvaluations(annee: ___, commercialId: ___, mois: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "évaluations d'un commercial")
	public EvaluationPage commercialEvaluations(
			@GraphQLName("commercialId") Long commercialId,
			@GraphQLName("annee") Integer annee,
			@GraphQLName("mois") Integer mois)
		throws Exception {

		return _applyComponentServiceObjects(
			_evaluationResourceComponentServiceObjects,
			this::_populateResourceContext,
			evaluationResource -> new EvaluationPage(
				evaluationResource.getCommercialEvaluationsPage(
					commercialId, annee, mois)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {objectifs(annee: ___, commercialId: ___, filter: ___, mois: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "liste (filtre: commercial, période)")
	public ObjectifPage objectifs(
			@GraphQLName("commercialId") Long commercialId,
			@GraphQLName("annee") Integer annee,
			@GraphQLName("mois") Integer mois,
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_objectifResourceComponentServiceObjects,
			this::_populateResourceContext,
			objectifResource -> new ObjectifPage(
				objectifResource.getObjectifsPage(
					commercialId, annee, mois, search,
					_filterBiFunction.apply(objectifResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(objectifResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {commercialObjectifs(commercialId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "objectifs d'un commercial")
	public ObjectifPage commercialObjectifs(
			@GraphQLName("commercialId") Long commercialId)
		throws Exception {

		return _applyComponentServiceObjects(
			_objectifResourceComponentServiceObjects,
			this::_populateResourceContext,
			objectifResource -> new ObjectifPage(
				objectifResource.getCommercialObjectifsPage(commercialId)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {commercialSites(commercialId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Liste des affectations")
	public SiteCommercialPage commercialSites(
			@GraphQLName("commercialId") Long commercialId)
		throws Exception {

		return _applyComponentServiceObjects(
			_siteCommercialResourceComponentServiceObjects,
			this::_populateResourceContext,
			siteCommercialResource -> new SiteCommercialPage(
				siteCommercialResource.getCommercialSitesPage(commercialId)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {siteCommerciaux(filter: ___, page: ___, pageSize: ___, search: ___, siteKey: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Liste des commerciaux affectés à un site")
	public SiteCommercialPage siteCommerciaux(
			@GraphQLName("siteKey") @NotEmpty String siteKey,
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_siteCommercialResourceComponentServiceObjects,
			this::_populateResourceContext,
			siteCommercialResource -> new SiteCommercialPage(
				siteCommercialResource.getSiteCommerciauxPage(
					Long.valueOf(siteKey), search,
					_filterBiFunction.apply(
						siteCommercialResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(
						siteCommercialResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {terminals(filter: ___, page: ___, pageSize: ___, search: ___, siteKey: ___, sorts: ___, statutValidation: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Liste des Terminaux (PDV)")
	public TerminalPage terminals(
			@GraphQLName("siteKey") @NotEmpty String siteKey,
			@GraphQLName("statutValidation") String statutValidation,
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_terminalResourceComponentServiceObjects,
			this::_populateResourceContext,
			terminalResource -> new TerminalPage(
				terminalResource.getTerminalsPage(
					Long.valueOf(siteKey), statutValidation, search,
					_filterBiFunction.apply(terminalResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(terminalResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {terminal(terminalId: ___){id, codeTerminal, concessionnaireId, siteId, latitude, longitude, adresse, statutValidation}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Récupérer un Terminal (PDV) par son ID")
	public Terminal terminal(@GraphQLName("terminalId") Long terminalId)
		throws Exception {

		return _applyComponentServiceObjects(
			_terminalResourceComponentServiceObjects,
			this::_populateResourceContext,
			terminalResource -> terminalResource.getTerminal(terminalId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {terminalsAValider(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Les points de ventes à valider")
	public TerminalPage terminalsAValider(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_terminalResourceComponentServiceObjects,
			this::_populateResourceContext,
			terminalResource -> new TerminalPage(
				terminalResource.getTerminalsAValiderPage(
					search,
					_filterBiFunction.apply(terminalResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(terminalResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {terminalsCartographie(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Cartographie des points de vente")
	public TerminalPage terminalsCartographie(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_terminalResourceComponentServiceObjects,
			this::_populateResourceContext,
			terminalResource -> new TerminalPage(
				terminalResource.getTerminalsCartographie(
					search,
					_filterBiFunction.apply(terminalResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(terminalResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {terminalsCartographieTop20(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Cartographie des top 20 points de vente")
	public TerminalPage terminalsCartographieTop20(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_terminalResourceComponentServiceObjects,
			this::_populateResourceContext,
			terminalResource -> new TerminalPage(
				terminalResource.getTerminalsCartographieTop20(
					search,
					_filterBiFunction.apply(terminalResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(terminalResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {terminalVisites(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___, terminalId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Les vistes d'un terminal (PDV)")
	public TerminalPage terminalVisites(
			@GraphQLName("terminalId") Long terminalId,
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_terminalResourceComponentServiceObjects,
			this::_populateResourceContext,
			terminalResource -> new TerminalPage(
				terminalResource.getTerminalVisitesPage(
					terminalId, search,
					_filterBiFunction.apply(terminalResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(terminalResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {visites(commercialId: ___, dateDebut: ___, dateFin: ___, filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___, statut: ___, terminalId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Liste des visites")
	public VisitePage visites(
			@GraphQLName("commercialId") Long commercialId,
			@GraphQLName("terminalId") Long terminalId,
			@GraphQLName("statut") String statut,
			@GraphQLName("dateDebut") Date dateDebut,
			@GraphQLName("dateFin") Date dateFin,
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_visiteResourceComponentServiceObjects,
			this::_populateResourceContext,
			visiteResource -> new VisitePage(
				visiteResource.getVisitesPage(
					commercialId, terminalId, statut, dateDebut, dateFin,
					search,
					_filterBiFunction.apply(visiteResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(visiteResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {visite(visiteKey: ___){id, commercialId, terminalId, latitude, longitude, statut, typeControle, dateVisite, compteRendu}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Détail d'une visite")
	public Visite visite(@GraphQLName("visiteId") Long visiteId)
		throws Exception {

		return _applyComponentServiceObjects(
			_visiteResourceComponentServiceObjects,
			this::_populateResourceContext,
			visiteResource -> visiteResource.getVisite(visiteId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {visitesTempsReel{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "positions actuelles des commerciaux")
	public VisitePage visitesTempsReel() throws Exception {
		return _applyComponentServiceObjects(
			_visiteResourceComponentServiceObjects,
			this::_populateResourceContext,
			visiteResource -> new VisitePage(
				visiteResource.getVisitesTempsReel()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {commercialVisites(commercialId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "historique d'un commercial")
	public VisitePage commercialVisites(
			@GraphQLName("commercialId") Long commercialId)
		throws Exception {

		return _applyComponentServiceObjects(
			_visiteResourceComponentServiceObjects,
			this::_populateResourceContext,
			visiteResource -> new VisitePage(
				visiteResource.getCommercialVisitesPage(commercialId)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {commercialVisitesPlanning(commercialId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "planning prévu vs réalisé")
	public VisitePage commercialVisitesPlanning(
			@GraphQLName("commercialId") Long commercialId)
		throws Exception {

		return _applyComponentServiceObjects(
			_visiteResourceComponentServiceObjects,
			this::_populateResourceContext,
			visiteResource -> new VisitePage(
				visiteResource.getCommercialVisitesPlanningPage(commercialId)));
	}

	@GraphQLTypeExtension(Commercial.class)
	public class GetObjectifsPageTypeExtension {

		public GetObjectifsPageTypeExtension(Commercial commercial) {
			_commercial = commercial;
		}

		@GraphQLField(description = "liste (filtre: commercial, période)")
		public ObjectifPage objectifs(
				@GraphQLName("annee") Integer annee,
				@GraphQLName("mois") Integer mois,
				@GraphQLName("search") String search,
				@GraphQLName("filter") String filterString,
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page,
				@GraphQLName("sort") String sortsString)
			throws Exception {

			return _applyComponentServiceObjects(
				_objectifResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				objectifResource -> new ObjectifPage(
					objectifResource.getObjectifsPage(
						_commercial.getId(), annee, mois, search,
						_filterBiFunction.apply(objectifResource, filterString),
						Pagination.of(page, pageSize),
						_sortsBiFunction.apply(
							objectifResource, sortsString))));
		}

		private Commercial _commercial;

	}

	@GraphQLTypeExtension(Commercial.class)
	public class GetVisitesPageTypeExtension {

		public GetVisitesPageTypeExtension(Commercial commercial) {
			_commercial = commercial;
		}

		@GraphQLField(description = "Liste des visites")
		public VisitePage visites(
				@GraphQLName("terminalId") Long terminalId,
				@GraphQLName("statut") String statut,
				@GraphQLName("dateDebut") Date dateDebut,
				@GraphQLName("dateFin") Date dateFin,
				@GraphQLName("search") String search,
				@GraphQLName("filter") String filterString,
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page,
				@GraphQLName("sort") String sortsString)
			throws Exception {

			return _applyComponentServiceObjects(
				_visiteResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				visiteResource -> new VisitePage(
					visiteResource.getVisitesPage(
						_commercial.getId(), terminalId, statut, dateDebut,
						dateFin, search,
						_filterBiFunction.apply(visiteResource, filterString),
						Pagination.of(page, pageSize),
						_sortsBiFunction.apply(visiteResource, sortsString))));
		}

		private Commercial _commercial;

	}

	@GraphQLTypeExtension(Commercial.class)
	public class GetCommercialVisitesPlanningPageTypeExtension {

		public GetCommercialVisitesPlanningPageTypeExtension(
			Commercial commercial) {

			_commercial = commercial;
		}

		@GraphQLField(description = "planning prévu vs réalisé")
		public VisitePage visitesPlanning() throws Exception {
			return _applyComponentServiceObjects(
				_visiteResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				visiteResource -> new VisitePage(
					visiteResource.getCommercialVisitesPlanningPage(
						_commercial.getId())));
		}

		private Commercial _commercial;

	}

	@GraphQLTypeExtension(VisiteRequestBody.class)
	public class GetTerminalTypeExtension {

		public GetTerminalTypeExtension(VisiteRequestBody visiteRequestBody) {
			_visiteRequestBody = visiteRequestBody;
		}

		@GraphQLField(description = "Récupérer un Terminal (PDV) par son ID")
		public Terminal terminal() throws Exception {
			return _applyComponentServiceObjects(
				_terminalResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				terminalResource -> terminalResource.getTerminal(
					_visiteRequestBody.getTerminalId()));
		}

		private VisiteRequestBody _visiteRequestBody;

	}

	@GraphQLTypeExtension(Commercial.class)
	public class GetCommercialVisitesPageTypeExtension {

		public GetCommercialVisitesPageTypeExtension(Commercial commercial) {
			_commercial = commercial;
		}

		@GraphQLField(description = "historique d'un commercial")
		public VisitePage visites() throws Exception {
			return _applyComponentServiceObjects(
				_visiteResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				visiteResource -> new VisitePage(
					visiteResource.getCommercialVisitesPage(
						_commercial.getId())));
		}

		private Commercial _commercial;

	}

	@GraphQLTypeExtension(Commercial.class)
	public class GetCommercialObjectifsPageTypeExtension {

		public GetCommercialObjectifsPageTypeExtension(Commercial commercial) {
			_commercial = commercial;
		}

		@GraphQLField(description = "objectifs d'un commercial")
		public ObjectifPage objectifs() throws Exception {
			return _applyComponentServiceObjects(
				_objectifResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				objectifResource -> new ObjectifPage(
					objectifResource.getCommercialObjectifsPage(
						_commercial.getId())));
		}

		private Commercial _commercial;

	}

	@GraphQLTypeExtension(VisiteRequestBody.class)
	public class GetCommercialTypeExtension {

		public GetCommercialTypeExtension(VisiteRequestBody visiteRequestBody) {
			_visiteRequestBody = visiteRequestBody;
		}

		@GraphQLField(description = "Récupérer un commercial par sont ID")
		public Commercial commercial() throws Exception {
			return _applyComponentServiceObjects(
				_commercialResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				commercialResource -> commercialResource.getCommercial(
					_visiteRequestBody.getCommercialId()));
		}

		private VisiteRequestBody _visiteRequestBody;

	}

	@GraphQLTypeExtension(Commercial.class)
	public class GetCommercialSitesPageTypeExtension {

		public GetCommercialSitesPageTypeExtension(Commercial commercial) {
			_commercial = commercial;
		}

		@GraphQLField(description = "Liste des affectations")
		public SiteCommercialPage sites() throws Exception {
			return _applyComponentServiceObjects(
				_siteCommercialResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				siteCommercialResource -> new SiteCommercialPage(
					siteCommercialResource.getCommercialSitesPage(
						_commercial.getId())));
		}

		private Commercial _commercial;

	}

	@GraphQLTypeExtension(Terminal.class)
	public class GetTerminalVisitesPageTypeExtension {

		public GetTerminalVisitesPageTypeExtension(Terminal terminal) {
			_terminal = terminal;
		}

		@GraphQLField(description = "Les vistes d'un terminal (PDV)")
		public TerminalPage visites(
				@GraphQLName("search") String search,
				@GraphQLName("filter") String filterString,
				@GraphQLName("pageSize") int pageSize,
				@GraphQLName("page") int page,
				@GraphQLName("sort") String sortsString)
			throws Exception {

			return _applyComponentServiceObjects(
				_terminalResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				terminalResource -> new TerminalPage(
					terminalResource.getTerminalVisitesPage(
						_terminal.getId(), search,
						_filterBiFunction.apply(terminalResource, filterString),
						Pagination.of(page, pageSize),
						_sortsBiFunction.apply(
							terminalResource, sortsString))));
		}

		private Terminal _terminal;

	}

	@GraphQLTypeExtension(Commercial.class)
	public class GetCommercialEvaluationsPageTypeExtension {

		public GetCommercialEvaluationsPageTypeExtension(
			Commercial commercial) {

			_commercial = commercial;
		}

		@GraphQLField(description = "évaluations d'un commercial")
		public EvaluationPage evaluations(
				@GraphQLName("annee") Integer annee,
				@GraphQLName("mois") Integer mois)
			throws Exception {

			return _applyComponentServiceObjects(
				_evaluationResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				evaluationResource -> new EvaluationPage(
					evaluationResource.getCommercialEvaluationsPage(
						_commercial.getId(), annee, mois)));
		}

		private Commercial _commercial;

	}

	@GraphQLName("CommercialPage")
	public class CommercialPage {

		public CommercialPage(Page commercialPage) {
			actions = commercialPage.getActions();

			items = commercialPage.getItems();
			lastPage = commercialPage.getLastPage();
			page = commercialPage.getPage();
			pageSize = commercialPage.getPageSize();
			totalCount = commercialPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Commercial> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("EvaluationPage")
	public class EvaluationPage {

		public EvaluationPage(Page evaluationPage) {
			actions = evaluationPage.getActions();

			items = evaluationPage.getItems();
			lastPage = evaluationPage.getLastPage();
			page = evaluationPage.getPage();
			pageSize = evaluationPage.getPageSize();
			totalCount = evaluationPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Evaluation> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("ObjectifPage")
	public class ObjectifPage {

		public ObjectifPage(Page objectifPage) {
			actions = objectifPage.getActions();

			items = objectifPage.getItems();
			lastPage = objectifPage.getLastPage();
			page = objectifPage.getPage();
			pageSize = objectifPage.getPageSize();
			totalCount = objectifPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Objectif> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("SiteCommercialPage")
	public class SiteCommercialPage {

		public SiteCommercialPage(Page siteCommercialPage) {
			actions = siteCommercialPage.getActions();

			items = siteCommercialPage.getItems();
			lastPage = siteCommercialPage.getLastPage();
			page = siteCommercialPage.getPage();
			pageSize = siteCommercialPage.getPageSize();
			totalCount = siteCommercialPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<SiteCommercial> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("TerminalPage")
	public class TerminalPage {

		public TerminalPage(Page terminalPage) {
			actions = terminalPage.getActions();

			items = terminalPage.getItems();
			lastPage = terminalPage.getLastPage();
			page = terminalPage.getPage();
			pageSize = terminalPage.getPageSize();
			totalCount = terminalPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Terminal> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("VisitePage")
	public class VisitePage {

		public VisitePage(Page visitePage) {
			actions = visitePage.getActions();

			items = visitePage.getItems();
			lastPage = visitePage.getLastPage();
			page = visitePage.getPage();
			pageSize = visitePage.getPageSize();
			totalCount = visitePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Visite> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(CommercialResource commercialResource)
		throws Exception {

		commercialResource.setContextAcceptLanguage(_acceptLanguage);
		commercialResource.setContextCompany(_company);
		commercialResource.setContextHttpServletRequest(_httpServletRequest);
		commercialResource.setContextHttpServletResponse(_httpServletResponse);
		commercialResource.setContextUriInfo(_uriInfo);
		commercialResource.setContextUser(_user);
		commercialResource.setGroupLocalService(_groupLocalService);
		commercialResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(EvaluationResource evaluationResource)
		throws Exception {

		evaluationResource.setContextAcceptLanguage(_acceptLanguage);
		evaluationResource.setContextCompany(_company);
		evaluationResource.setContextHttpServletRequest(_httpServletRequest);
		evaluationResource.setContextHttpServletResponse(_httpServletResponse);
		evaluationResource.setContextUriInfo(_uriInfo);
		evaluationResource.setContextUser(_user);
		evaluationResource.setGroupLocalService(_groupLocalService);
		evaluationResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(ObjectifResource objectifResource)
		throws Exception {

		objectifResource.setContextAcceptLanguage(_acceptLanguage);
		objectifResource.setContextCompany(_company);
		objectifResource.setContextHttpServletRequest(_httpServletRequest);
		objectifResource.setContextHttpServletResponse(_httpServletResponse);
		objectifResource.setContextUriInfo(_uriInfo);
		objectifResource.setContextUser(_user);
		objectifResource.setGroupLocalService(_groupLocalService);
		objectifResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			SiteCommercialResource siteCommercialResource)
		throws Exception {

		siteCommercialResource.setContextAcceptLanguage(_acceptLanguage);
		siteCommercialResource.setContextCompany(_company);
		siteCommercialResource.setContextHttpServletRequest(
			_httpServletRequest);
		siteCommercialResource.setContextHttpServletResponse(
			_httpServletResponse);
		siteCommercialResource.setContextUriInfo(_uriInfo);
		siteCommercialResource.setContextUser(_user);
		siteCommercialResource.setGroupLocalService(_groupLocalService);
		siteCommercialResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(TerminalResource terminalResource)
		throws Exception {

		terminalResource.setContextAcceptLanguage(_acceptLanguage);
		terminalResource.setContextCompany(_company);
		terminalResource.setContextHttpServletRequest(_httpServletRequest);
		terminalResource.setContextHttpServletResponse(_httpServletResponse);
		terminalResource.setContextUriInfo(_uriInfo);
		terminalResource.setContextUser(_user);
		terminalResource.setGroupLocalService(_groupLocalService);
		terminalResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(VisiteResource visiteResource)
		throws Exception {

		visiteResource.setContextAcceptLanguage(_acceptLanguage);
		visiteResource.setContextCompany(_company);
		visiteResource.setContextHttpServletRequest(_httpServletRequest);
		visiteResource.setContextHttpServletResponse(_httpServletResponse);
		visiteResource.setContextUriInfo(_uriInfo);
		visiteResource.setContextUser(_user);
		visiteResource.setGroupLocalService(_groupLocalService);
		visiteResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<CommercialResource>
		_commercialResourceComponentServiceObjects;
	private static ComponentServiceObjects<EvaluationResource>
		_evaluationResourceComponentServiceObjects;
	private static ComponentServiceObjects<ObjectifResource>
		_objectifResourceComponentServiceObjects;
	private static ComponentServiceObjects<SiteCommercialResource>
		_siteCommercialResourceComponentServiceObjects;
	private static ComponentServiceObjects<TerminalResource>
		_terminalResourceComponentServiceObjects;
	private static ComponentServiceObjects<VisiteResource>
		_visiteResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}