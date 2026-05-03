package com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata;

import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.filter.FilterParser;
import com.liferay.portal.odata.filter.FilterParserProvider;
import com.liferay.portal.odata.filter.expression.Expression;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.UriInfo;

/**
 * Helper de plus haut niveau: extrait la string filter de l UriInfo, parse,
 * visite et retourne la liste de criteres.
 *
 * @author HP
 */
public final class ODataFilterUtil {

	public static List<GenericODataFilterVisitor.Criterion> extractCriteria(
			UriInfo uriInfo, FilterParserProvider filterParserProvider,
			EntityModel entityModel)
		throws Exception {

		if (uriInfo == null) {
			return Collections.emptyList();
		}

		String filterString = uriInfo.getQueryParameters().getFirst("filter");

		if ((filterString == null) || filterString.isEmpty()) {
			return Collections.emptyList();
		}

		FilterParser parser = filterParserProvider.provide(entityModel);
		Expression expression = parser.parse(filterString);

		if (expression == null) {
			return Collections.emptyList();
		}

		GenericODataFilterVisitor visitor = new GenericODataFilterVisitor();
		expression.accept(visitor);

		return visitor.getCriteria();
	}

	private ODataFilterUtil() {
	}

}
