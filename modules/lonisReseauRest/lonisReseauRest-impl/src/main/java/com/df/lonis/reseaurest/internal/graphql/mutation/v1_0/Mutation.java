package com.df.lonis.reseaurest.internal.graphql.mutation.v1_0;

import com.df.lonis.reseaurest.dto.v1_0.Commercial;
import com.df.lonis.reseaurest.dto.v1_0.CommercialRequestBody;
import com.df.lonis.reseaurest.dto.v1_0.Objectif;
import com.df.lonis.reseaurest.dto.v1_0.SiteCommercial;
import com.df.lonis.reseaurest.dto.v1_0.Terminal;
import com.df.lonis.reseaurest.dto.v1_0.TerminalRequestBody;
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
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.constraints.NotEmpty;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class Mutation {

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

	@GraphQLField(description = "Ajouter un commercial")
	public Commercial createCommercial(
			@GraphQLName("commercialRequestBody") CommercialRequestBody
				commercialRequestBody)
		throws Exception {

		return _applyComponentServiceObjects(
			_commercialResourceComponentServiceObjects,
			this::_populateResourceContext,
			commercialResource -> commercialResource.postCommercial(
				commercialRequestBody));
	}

	@GraphQLField
	public Response createCommercialBatch(
			@GraphQLName("commercialRequestBody") CommercialRequestBody
				commercialRequestBody,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_commercialResourceComponentServiceObjects,
			this::_populateResourceContext,
			commercialResource -> commercialResource.postCommercialBatch(
				commercialRequestBody, callbackURL, object));
	}

	@GraphQLField(description = "Supprimer un commercial")
	public Response deleteCommercial(
			@GraphQLName("commercialId") Long commercialId)
		throws Exception {

		return _applyComponentServiceObjects(
			_commercialResourceComponentServiceObjects,
			this::_populateResourceContext,
			commercialResource -> commercialResource.deleteCommercial(
				commercialId));
	}

	@GraphQLField
	public Response deleteCommercialBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_commercialResourceComponentServiceObjects,
			this::_populateResourceContext,
			commercialResource -> commercialResource.deleteCommercialBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Modifier un commercial")
	public Commercial updateCommercial(
			@GraphQLName("commercialId") Long commercialId,
			@GraphQLName("commercial") Commercial commercial)
		throws Exception {

		return _applyComponentServiceObjects(
			_commercialResourceComponentServiceObjects,
			this::_populateResourceContext,
			commercialResource -> commercialResource.putCommercial(
				commercialId, commercial));
	}

	@GraphQLField
	public Response updateCommercialBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_commercialResourceComponentServiceObjects,
			this::_populateResourceContext,
			commercialResource -> commercialResource.putCommercialBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "déclencher le calcul (batch)")
	public Response createEvaluationsGenerer(
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_evaluationResourceComponentServiceObjects,
			this::_populateResourceContext,
			evaluationResource -> evaluationResource.postEvaluationsGenerer(
				object));
	}

	@GraphQLField(description = "créer (superviseur)")
	public Objectif createObjectif(@GraphQLName("objectif") Objectif objectif)
		throws Exception {

		return _applyComponentServiceObjects(
			_objectifResourceComponentServiceObjects,
			this::_populateResourceContext,
			objectifResource -> objectifResource.postObjectif(objectif));
	}

	@GraphQLField
	public Response createObjectifBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_objectifResourceComponentServiceObjects,
			this::_populateResourceContext,
			objectifResource -> objectifResource.postObjectifBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Modifier un objectif")
	public Objectif updateObjectif(
			@GraphQLName("objectifId") Long objectifId,
			@GraphQLName("objectif") Objectif objectif)
		throws Exception {

		return _applyComponentServiceObjects(
			_objectifResourceComponentServiceObjects,
			this::_populateResourceContext,
			objectifResource -> objectifResource.putObjectif(
				objectifId, objectif));
	}

	@GraphQLField
	public Response updateObjectifBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_objectifResourceComponentServiceObjects,
			this::_populateResourceContext,
			objectifResource -> objectifResource.putObjectifBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Association Commercial zones")
	public SiteCommercial createCommercialSite(
			@GraphQLName("commercialId") Long commercialId,
			@GraphQLName("siteCommercial") SiteCommercial siteCommercial)
		throws Exception {

		return _applyComponentServiceObjects(
			_siteCommercialResourceComponentServiceObjects,
			this::_populateResourceContext,
			siteCommercialResource -> siteCommercialResource.postCommercialSite(
				commercialId, siteCommercial));
	}

	@GraphQLField(description = "Rétirer une affectation")
	public Response deleteCommercialSite(
			@GraphQLName("commercialId") Long commercialId,
			@GraphQLName("siteKey") @NotEmpty String siteKey)
		throws Exception {

		return _applyComponentServiceObjects(
			_siteCommercialResourceComponentServiceObjects,
			this::_populateResourceContext,
			siteCommercialResource ->
				siteCommercialResource.deleteCommercialSite(
					commercialId, Long.valueOf(siteKey)));
	}

	@GraphQLField(description = "Ajouter un Terminal (PDV)")
	public Terminal createTerminal(
			@GraphQLName("terminalRequestBody") TerminalRequestBody
				terminalRequestBody)
		throws Exception {

		return _applyComponentServiceObjects(
			_terminalResourceComponentServiceObjects,
			this::_populateResourceContext,
			terminalResource -> terminalResource.postTerminal(
				terminalRequestBody));
	}

	@GraphQLField
	public Response createTerminalBatch(
			@GraphQLName("terminalRequestBody") TerminalRequestBody
				terminalRequestBody,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_terminalResourceComponentServiceObjects,
			this::_populateResourceContext,
			terminalResource -> terminalResource.postTerminalBatch(
				terminalRequestBody, callbackURL, object));
	}

	@GraphQLField(description = "Modifier un Terminal (PDV) par son ID")
	public Terminal updateTerminal(
			@GraphQLName("terminalId") Long terminalId,
			@GraphQLName("terminal") Terminal terminal)
		throws Exception {

		return _applyComponentServiceObjects(
			_terminalResourceComponentServiceObjects,
			this::_populateResourceContext,
			terminalResource -> terminalResource.putTerminal(
				terminalId, terminal));
	}

	@GraphQLField
	public Response updateTerminalBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_terminalResourceComponentServiceObjects,
			this::_populateResourceContext,
			terminalResource -> terminalResource.putTerminalBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "valider l'enrôlement du Terminal (PDV)")
	public Terminal patchTerminalValider(
			@GraphQLName("terminalId") Long terminalId)
		throws Exception {

		return _applyComponentServiceObjects(
			_terminalResourceComponentServiceObjects,
			this::_populateResourceContext,
			terminalResource -> terminalResource.patchTerminalValider(
				terminalId));
	}

	@GraphQLField(description = "Rejeter un terminal (PDV)")
	public Terminal patchTerminalRejeter(
			@GraphQLName("terminalId") Long terminalId,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_terminalResourceComponentServiceObjects,
			this::_populateResourceContext,
			terminalResource -> terminalResource.patchTerminalRejeter(
				terminalId, object));
	}

	@GraphQLField(
		description = "Marquer une visite (GPS + contrôle proximité terminal)"
	)
	public Visite createVisite(
			@GraphQLName("visiteRequestBody") VisiteRequestBody
				visiteRequestBody)
		throws Exception {

		return _applyComponentServiceObjects(
			_visiteResourceComponentServiceObjects,
			this::_populateResourceContext,
			visiteResource -> visiteResource.postVisite(visiteRequestBody));
	}

	@GraphQLField
	public Response createVisiteBatch(
			@GraphQLName("visiteRequestBody") VisiteRequestBody
				visiteRequestBody,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_visiteResourceComponentServiceObjects,
			this::_populateResourceContext,
			visiteResource -> visiteResource.postVisiteBatch(
				visiteRequestBody, callbackURL, object));
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}