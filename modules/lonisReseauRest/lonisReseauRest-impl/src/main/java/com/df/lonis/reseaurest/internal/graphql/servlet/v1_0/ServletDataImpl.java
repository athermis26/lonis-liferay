package com.df.lonis.reseaurest.internal.graphql.servlet.v1_0;

import com.df.lonis.reseaurest.internal.graphql.mutation.v1_0.Mutation;
import com.df.lonis.reseaurest.internal.graphql.query.v1_0.Query;
import com.df.lonis.reseaurest.resource.v1_0.CommercialResource;
import com.df.lonis.reseaurest.resource.v1_0.EvaluationResource;
import com.df.lonis.reseaurest.resource.v1_0.ObjectifResource;
import com.df.lonis.reseaurest.resource.v1_0.SiteCommercialResource;
import com.df.lonis.reseaurest.resource.v1_0.TerminalResource;
import com.df.lonis.reseaurest.resource.v1_0.VisiteResource;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author HP
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setCommercialResourceComponentServiceObjects(
			_commercialResourceComponentServiceObjects);
		Mutation.setEvaluationResourceComponentServiceObjects(
			_evaluationResourceComponentServiceObjects);
		Mutation.setObjectifResourceComponentServiceObjects(
			_objectifResourceComponentServiceObjects);
		Mutation.setSiteCommercialResourceComponentServiceObjects(
			_siteCommercialResourceComponentServiceObjects);
		Mutation.setTerminalResourceComponentServiceObjects(
			_terminalResourceComponentServiceObjects);
		Mutation.setVisiteResourceComponentServiceObjects(
			_visiteResourceComponentServiceObjects);

		Query.setCommercialResourceComponentServiceObjects(
			_commercialResourceComponentServiceObjects);
		Query.setEvaluationResourceComponentServiceObjects(
			_evaluationResourceComponentServiceObjects);
		Query.setObjectifResourceComponentServiceObjects(
			_objectifResourceComponentServiceObjects);
		Query.setSiteCommercialResourceComponentServiceObjects(
			_siteCommercialResourceComponentServiceObjects);
		Query.setTerminalResourceComponentServiceObjects(
			_terminalResourceComponentServiceObjects);
		Query.setVisiteResourceComponentServiceObjects(
			_visiteResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/lonisReseauRest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CommercialResource>
		_commercialResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<EvaluationResource>
		_evaluationResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<ObjectifResource>
		_objectifResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<SiteCommercialResource>
		_siteCommercialResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<TerminalResource>
		_terminalResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<VisiteResource>
		_visiteResourceComponentServiceObjects;

}