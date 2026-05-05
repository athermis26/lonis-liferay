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
@GraphQLName("Objectif")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Objectif")
public class Objectif implements Serializable {

	public static Objectif toDTO(String json) {
		return ObjectMapperUtil.readValue(Objectif.class, json);
	}

	public static Objectif unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Objectif.class, json);
	}

	@Schema
	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	@JsonIgnore
	public void setAnnee(
		UnsafeSupplier<Integer, Exception> anneeUnsafeSupplier) {

		try {
			annee = anneeUnsafeSupplier.get();
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
	protected Integer annee;

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
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
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
	protected Long id;

	@Schema
	public Integer getMois() {
		return mois;
	}

	public void setMois(Integer mois) {
		this.mois = mois;
	}

	@JsonIgnore
	public void setMois(UnsafeSupplier<Integer, Exception> moisUnsafeSupplier) {
		try {
			mois = moisUnsafeSupplier.get();
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
	protected Integer mois;

	@Schema
	@Valid
	public Periode getPeriode() {
		return periode;
	}

	@JsonIgnore
	public String getPeriodeAsString() {
		if (periode == null) {
			return null;
		}

		return periode.toString();
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	@JsonIgnore
	public void setPeriode(
		UnsafeSupplier<Periode, Exception> periodeUnsafeSupplier) {

		try {
			periode = periodeUnsafeSupplier.get();
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
	protected Periode periode;

	@Schema
	public Integer getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(Integer trimestre) {
		this.trimestre = trimestre;
	}

	@JsonIgnore
	public void setTrimestre(
		UnsafeSupplier<Integer, Exception> trimestreUnsafeSupplier) {

		try {
			trimestre = trimestreUnsafeSupplier.get();
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
	protected Integer trimestre;

	@Schema
	@Valid
	public Type getType() {
		return type;
	}

	@JsonIgnore
	public String getTypeAsString() {
		if (type == null) {
			return null;
		}

		return type.toString();
	}

	public void setType(Type type) {
		this.type = type;
	}

	@JsonIgnore
	public void setType(UnsafeSupplier<Type, Exception> typeUnsafeSupplier) {
		try {
			type = typeUnsafeSupplier.get();
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
	protected Type type;

	@Schema
	public Integer getValeurCible() {
		return valeurCible;
	}

	public void setValeurCible(Integer valeurCible) {
		this.valeurCible = valeurCible;
	}

	@JsonIgnore
	public void setValeurCible(
		UnsafeSupplier<Integer, Exception> valeurCibleUnsafeSupplier) {

		try {
			valeurCible = valeurCibleUnsafeSupplier.get();
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
	protected Integer valeurCible;

	@Schema
	public Integer getValeurReelle() {
		return valeurReelle;
	}

	public void setValeurReelle(Integer valeurReelle) {
		this.valeurReelle = valeurReelle;
	}

	@JsonIgnore
	public void setValeurReelle(
		UnsafeSupplier<Integer, Exception> valeurReelleUnsafeSupplier) {

		try {
			valeurReelle = valeurReelleUnsafeSupplier.get();
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
	protected Integer valeurReelle;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Objectif)) {
			return false;
		}

		Objectif objectif = (Objectif)object;

		return Objects.equals(toString(), objectif.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (annee != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"annee\": ");

			sb.append(annee);
		}

		if (commercialId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commercialId\": ");

			sb.append(commercialId);
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (mois != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mois\": ");

			sb.append(mois);
		}

		if (periode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"periode\": ");

			sb.append("\"");

			sb.append(periode);

			sb.append("\"");
		}

		if (trimestre != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"trimestre\": ");

			sb.append(trimestre);
		}

		if (type != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(type);

			sb.append("\"");
		}

		if (valeurCible != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valeurCible\": ");

			sb.append(valeurCible);
		}

		if (valeurReelle != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"valeurReelle\": ");

			sb.append(valeurReelle);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.df.lonis.reseaurest.dto.v1_0.Objectif",
		name = "x-class-name"
	)
	public String xClassName;

	@GraphQLName("Periode")
	public static enum Periode {

		MENSUEL("MENSUEL"), TRIMESTRIEL("TRIMESTRIEL");

		@JsonCreator
		public static Periode create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (Periode periode : values()) {
				if (Objects.equals(periode.getValue(), value)) {
					return periode;
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

		private Periode(String value) {
			_value = value;
		}

		private final String _value;

	}

	@GraphQLName("Type")
	public static enum Type {

		VISITE("VISITE"), VENTE("VENTE");

		@JsonCreator
		public static Type create(String value) {
			if ((value == null) || value.equals("")) {
				return null;
			}

			for (Type type : values()) {
				if (Objects.equals(type.getValue(), value)) {
					return type;
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

		private Type(String value) {
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