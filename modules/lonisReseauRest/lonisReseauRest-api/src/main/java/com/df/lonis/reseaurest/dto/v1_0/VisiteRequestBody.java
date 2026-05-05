package com.df.lonis.reseaurest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author HP
 * @generated
 */
@Generated("")
@GraphQLName("VisiteRequestBody")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "VisiteRequestBody")
public class VisiteRequestBody implements Serializable {

	public static VisiteRequestBody toDTO(String json) {
		return ObjectMapperUtil.readValue(VisiteRequestBody.class, json);
	}

	public static VisiteRequestBody unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(VisiteRequestBody.class, json);
	}

	@Schema
	public Long getCommercialId() {
		return commercialId;
	}

	public void setCommercialId(Long commercialId) {
		this.commercialId = commercialId;
	}

	@JsonIgnore
	public void setCommercialId(
		UnsafeSupplier<Long, Exception> commercialIdUnsafeSupplier) {

		try {
			commercialId = commercialIdUnsafeSupplier.get();
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
	protected Long commercialId;

	@Schema
	public String getCompteRendu() {
		return compteRendu;
	}

	public void setCompteRendu(String compteRendu) {
		this.compteRendu = compteRendu;
	}

	@JsonIgnore
	public void setCompteRendu(
		UnsafeSupplier<String, Exception> compteRenduUnsafeSupplier) {

		try {
			compteRendu = compteRenduUnsafeSupplier.get();
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
	protected String compteRendu;

	@Schema
	public Date getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	@JsonIgnore
	public void setDateVisite(
		UnsafeSupplier<Date, Exception> dateVisiteUnsafeSupplier) {

		try {
			dateVisite = dateVisiteUnsafeSupplier.get();
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
	protected Date dateVisite;

	@Schema
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	@JsonIgnore
	public void setLatitude(
		UnsafeSupplier<Double, Exception> latitudeUnsafeSupplier) {

		try {
			latitude = latitudeUnsafeSupplier.get();
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
	protected Double latitude;

	@Schema
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@JsonIgnore
	public void setLongitude(
		UnsafeSupplier<Double, Exception> longitudeUnsafeSupplier) {

		try {
			longitude = longitudeUnsafeSupplier.get();
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
	protected Double longitude;

	@Schema
	@Valid
	public Statut getStatut() {
		return statut;
	}

	@JsonIgnore
	public String getStatutAsString() {
		if (statut == null) {
			return null;
		}

		return statut.toString();
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	@JsonIgnore
	public void setStatut(
		UnsafeSupplier<Statut, Exception> statutUnsafeSupplier) {

		try {
			statut = statutUnsafeSupplier.get();
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
	protected Statut statut;

	@Schema
	public Long getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(Long terminalId) {
		this.terminalId = terminalId;
	}

	@JsonIgnore
	public void setTerminalId(
		UnsafeSupplier<Long, Exception> terminalIdUnsafeSupplier) {

		try {
			terminalId = terminalIdUnsafeSupplier.get();
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
	protected Long terminalId;

	@Schema
	@Valid
	public TypeControle getTypeControle() {
		return typeControle;
	}

	@JsonIgnore
	public String getTypeControleAsString() {
		if (typeControle == null) {
			return null;
		}

		return typeControle.toString();
	}

	public void setTypeControle(TypeControle typeControle) {
		this.typeControle = typeControle;
	}

	@JsonIgnore
	public void setTypeControle(
		UnsafeSupplier<TypeControle, Exception> typeControleUnsafeSupplier) {

		try {
			typeControle = typeControleUnsafeSupplier.get();
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
	protected TypeControle typeControle;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VisiteRequestBody)) {
			return false;
		}

		VisiteRequestBody visiteRequestBody = (VisiteRequestBody)object;

		return Objects.equals(toString(), visiteRequestBody.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (commercialId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commercialId\": ");

			sb.append(commercialId);
		}

		if (compteRendu != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"compteRendu\": ");

			sb.append("\"");

			sb.append(_escape(compteRendu));

			sb.append("\"");
		}

		if (dateVisite != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateVisite\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dateVisite));

			sb.append("\"");
		}

		if (latitude != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"latitude\": ");

			sb.append(latitude);
		}

		if (longitude != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"longitude\": ");

			sb.append(longitude);
		}

		if (statut != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statut\": ");

			sb.append("\"");

			sb.append(statut);

			sb.append("\"");
		}

		if (terminalId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"terminalId\": ");

			sb.append(terminalId);
		}

		if (typeControle != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"typeControle\": ");

			sb.append("\"");

			sb.append(typeControle);

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.df.lonis.reseaurest.dto.v1_0.VisiteRequestBody",
		name = "x-class-name"
	)
	public String xClassName;

	@GraphQLName("Statut")
	public static enum Statut {

		PLANIFIEE("PLANIFIEE"), EFFECTUEE("EFFECTUEE"), MANQUEE("MANQUEE");

		@JsonCreator
		public static Statut create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (Statut statut : values()) {
				if (Objects.equals(statut.getValue(), value)) {
					return statut;
				}
			}

			throw new IllegalArgumentException("Invalid enum value: " + value);
		}

		@JsonValue
		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Statut(String value) {
			_value = value;
		}

		private final String _value;

	}

	@GraphQLName("TypeControle")
	public static enum TypeControle {

		GPS("GPS"), RFID("RFID"), TAG("TAG");

		@JsonCreator
		public static TypeControle create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (TypeControle typeControle : values()) {
				if (Objects.equals(typeControle.getValue(), value)) {
					return typeControle;
				}
			}

			throw new IllegalArgumentException("Invalid enum value: " + value);
		}

		@JsonValue
		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private TypeControle(String value) {
			_value = value;
		}

		private final String _value;

	}

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