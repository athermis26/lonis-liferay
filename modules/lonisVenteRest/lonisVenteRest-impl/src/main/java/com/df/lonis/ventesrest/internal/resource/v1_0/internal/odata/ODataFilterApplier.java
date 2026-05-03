package com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata;

import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.GenericODataFilterVisitor.Criterion;
import com.df.lonis.ventesrest.internal.resource.v1_0.internal.odata.GenericODataFilterVisitor.Op;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Applique les criteres OData captures par {@link GenericODataFilterVisitor}
 * a un {@link DynamicQuery}. Effectue les conversions de types selon la
 * map field -> Class.
 *
 * @author HP
 */
public class ODataFilterApplier {

	public static void apply(
		DynamicQuery dq, List<Criterion> criteria,
		Map<String, Class<?>> fieldTypes) {

		if ((criteria == null) || criteria.isEmpty()) {
			return;
		}

		for (Criterion c : criteria) {
			Class<?> type = fieldTypes.get(c.field);

			if (type == null) {
				continue;
			}

			Object value = _convert(c.rawValue, type);

			if (value == null) {
				continue;
			}

			Property prop = PropertyFactoryUtil.forName(c.field);

			switch (c.op) {
				case EQ:
					dq.add(prop.eq(value));
					break;
				case NE:
					dq.add(prop.ne(value));
					break;
				case GE:
					dq.add(prop.ge(value));
					break;
				case GT:
					dq.add(prop.gt(value));
					break;
				case LE:
					dq.add(prop.le(value));
					break;
				case LT:
					dq.add(prop.lt(value));
					break;
				case CONTAINS:
					dq.add(
						RestrictionsFactoryUtil.ilike(
							c.field, "%" + value + "%"));
					break;
				case STARTSWITH:
					dq.add(
						RestrictionsFactoryUtil.ilike(c.field, value + "%"));
					break;
			}
		}
	}

	private static Object _convert(String raw, Class<?> type) {
		if (raw == null) {
			return null;
		}

		String clean = raw;
		if ((clean.length() >= 2) && clean.startsWith("'") &&
			clean.endsWith("'")) {

			clean = clean.substring(1, clean.length() - 1);
		}

		try {
			if (type == String.class) {
				return clean;
			}
			if (type == Long.class) {
				return Long.valueOf(clean);
			}
			if (type == Integer.class) {
				return Integer.valueOf(clean);
			}
			if (type == Boolean.class) {
				return Boolean.valueOf(clean);
			}
			if (type == Date.class) {
				try {
					return _ISO.parse(clean);
				}
				catch (Exception e) {
					return _SHORT.parse(clean);
				}
			}
		}
		catch (Exception e) {
			return null;
		}

		return null;
	}

	private static final SimpleDateFormat _ISO = new SimpleDateFormat(
		"yyyy-MM-dd'T'HH:mm:ss'Z'");
	private static final SimpleDateFormat _SHORT = new SimpleDateFormat(
		"yyyy-MM-dd");

}
