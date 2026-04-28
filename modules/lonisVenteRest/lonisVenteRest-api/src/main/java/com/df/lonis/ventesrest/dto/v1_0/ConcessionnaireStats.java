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
@GraphQLName("ConcessionnaireStats")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "ConcessionnaireStats")
public class ConcessionnaireStats implements Serializable {

	public static ConcessionnaireStats toDTO(String json) {
		return ObjectMapperUtil.readValue(ConcessionnaireStats.class, json);
	}

	public static ConcessionnaireStats unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(
			ConcessionnaireStats.class, json);
	}

	@Schema
	public Long getChiffreAffaires() {
		return chiffreAffaires;
	}

	public void setChiffreAffaires(Long chiffreAffaires) {
		this.chiffreAffaires = chiffreAffaires;
	}

	@JsonIgnore
	public void setChiffreAffaires(
		UnsafeSupplier<Long, Exception> chiffreAffairesUnsafeSupplier) {

		try {
			chiffreAffaires = chiffreAffairesUnsafeSupplier.get();
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
	protected Long chiffreAffaires;

	@Schema
	public Long getTotalOperations() {
		return totalOperations;
	}

	public void setTotalOperations(Long totalOperations) {
		this.totalOperations = totalOperations;
	}

	@JsonIgnore
	public void setTotalOperations(
		UnsafeSupplier<Long, Exception> totalOperationsUnsafeSupplier) {

		try {
			totalOperations = totalOperationsUnsafeSupplier.get();
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
	protected Long totalOperations;

	@Schema
	public Long getTotalPaiements() {
		return totalPaiements;
	}

	public void setTotalPaiements(Long totalPaiements) {
		this.totalPaiements = totalPaiements;
	}

	@JsonIgnore
	public void setTotalPaiements(
		UnsafeSupplier<Long, Exception> totalPaiementsUnsafeSupplier) {

		try {
			totalPaiements = totalPaiementsUnsafeSupplier.get();
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
	protected Long totalPaiements;

	@Schema
	public Integer getTotalProduits() {
		return totalProduits;
	}

	public void setTotalProduits(Integer totalProduits) {
		this.totalProduits = totalProduits;
	}

	@JsonIgnore
	public void setTotalProduits(
		UnsafeSupplier<Integer, Exception> totalProduitsUnsafeSupplier) {

		try {
			totalProduits = totalProduitsUnsafeSupplier.get();
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
	protected Integer totalProduits;

	@Schema
	public Integer getTotalTerminaux() {
		return totalTerminaux;
	}

	public void setTotalTerminaux(Integer totalTerminaux) {
		this.totalTerminaux = totalTerminaux;
	}

	@JsonIgnore
	public void setTotalTerminaux(
		UnsafeSupplier<Integer, Exception> totalTerminauxUnsafeSupplier) {

		try {
			totalTerminaux = totalTerminauxUnsafeSupplier.get();
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
	protected Integer totalTerminaux;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConcessionnaireStats)) {
			return false;
		}

		ConcessionnaireStats concessionnaireStats =
			(ConcessionnaireStats)object;

		return Objects.equals(toString(), concessionnaireStats.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (chiffreAffaires != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chiffreAffaires\": ");

			sb.append(chiffreAffaires);
		}

		if (totalOperations != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalOperations\": ");

			sb.append(totalOperations);
		}

		if (totalPaiements != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalPaiements\": ");

			sb.append(totalPaiements);
		}

		if (totalProduits != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalProduits\": ");

			sb.append(totalProduits);
		}

		if (totalTerminaux != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalTerminaux\": ");

			sb.append(totalTerminaux);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.df.lonis.ventesrest.dto.v1_0.ConcessionnaireStats",
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