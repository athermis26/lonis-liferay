package com.df.lonis.ventesrest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author HP
 * @generated
 */
@Generated("")
@GraphQLName("DashboardKpis")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "DashboardKpis")
public class DashboardKpis implements Serializable {

	public static DashboardKpis toDTO(String json) {
		return ObjectMapperUtil.readValue(DashboardKpis.class, json);
	}

	public static DashboardKpis unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(DashboardKpis.class, json);
	}

	@Schema
	public Long getChiffreAffairesTotal() {
		return chiffreAffairesTotal;
	}

	public void setChiffreAffairesTotal(Long chiffreAffairesTotal) {
		this.chiffreAffairesTotal = chiffreAffairesTotal;
	}

	@JsonIgnore
	public void setChiffreAffairesTotal(
		UnsafeSupplier<Long, Exception> chiffreAffairesTotalUnsafeSupplier) {

		try {
			chiffreAffairesTotal = chiffreAffairesTotalUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long chiffreAffairesTotal;

	@Schema
	public Long getPaiementsTotal() {
		return paiementsTotal;
	}

	public void setPaiementsTotal(Long paiementsTotal) {
		this.paiementsTotal = paiementsTotal;
	}

	@JsonIgnore
	public void setPaiementsTotal(
		UnsafeSupplier<Long, Exception> paiementsTotalUnsafeSupplier) {

		try {
			paiementsTotal = paiementsTotalUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long paiementsTotal;

	@Schema
	public Long getTotalConcessionnaires() {
		return totalConcessionnaires;
	}

	public void setTotalConcessionnaires(Long totalConcessionnaires) {
		this.totalConcessionnaires = totalConcessionnaires;
	}

	@JsonIgnore
	public void setTotalConcessionnaires(
		UnsafeSupplier<Long, Exception> totalConcessionnairesUnsafeSupplier) {

		try {
			totalConcessionnaires = totalConcessionnairesUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long totalConcessionnaires;

	@Schema
	public Long getTotalPointsDeVente() {
		return totalPointsDeVente;
	}

	public void setTotalPointsDeVente(Long totalPointsDeVente) {
		this.totalPointsDeVente = totalPointsDeVente;
	}

	@JsonIgnore
	public void setTotalPointsDeVente(
		UnsafeSupplier<Long, Exception> totalPointsDeVenteUnsafeSupplier) {

		try {
			totalPointsDeVente = totalPointsDeVenteUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long totalPointsDeVente;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DashboardKpis)) {
			return false;
		}

		DashboardKpis dashboardKpis = (DashboardKpis)object;

		return Objects.equals(toString(), dashboardKpis.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (chiffreAffairesTotal != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chiffreAffairesTotal\": ");

			sb.append(chiffreAffairesTotal);
		}

		if (paiementsTotal != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"paiementsTotal\": ");

			sb.append(paiementsTotal);
		}

		if (totalConcessionnaires != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalConcessionnaires\": ");

			sb.append(totalConcessionnaires);
		}

		if (totalPointsDeVente != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalPointsDeVente\": ");

			sb.append(totalPointsDeVente);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.df.lonis.ventesrest.dto.v1_0.DashboardKpis",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}