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
@GraphQLName("Evaluation")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Evaluation")
public class Evaluation implements Serializable {

	public static Evaluation toDTO(String json) {
		return ObjectMapperUtil.readValue(Evaluation.class, json);
	}

	public static Evaluation unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Evaluation.class, json);
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
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@JsonIgnore
	public void setCreatedAt(
		UnsafeSupplier<Date, Exception> createdAtUnsafeSupplier) {

		try {
			createdAt = createdAtUnsafeSupplier.get();
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
	protected Date createdAt;

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
	public Integer getNbVisitesEffectuees() {
		return nbVisitesEffectuees;
	}

	public void setNbVisitesEffectuees(Integer nbVisitesEffectuees) {
		this.nbVisitesEffectuees = nbVisitesEffectuees;
	}

	@JsonIgnore
	public void setNbVisitesEffectuees(
		UnsafeSupplier<Integer, Exception> nbVisitesEffectueesUnsafeSupplier) {

		try {
			nbVisitesEffectuees = nbVisitesEffectueesUnsafeSupplier.get();
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
	protected Integer nbVisitesEffectuees;

	@Schema
	public Integer getNbVisitesPrevues() {
		return nbVisitesPrevues;
	}

	public void setNbVisitesPrevues(Integer nbVisitesPrevues) {
		this.nbVisitesPrevues = nbVisitesPrevues;
	}

	@JsonIgnore
	public void setNbVisitesPrevues(
		UnsafeSupplier<Integer, Exception> nbVisitesPrevuesUnsafeSupplier) {

		try {
			nbVisitesPrevues = nbVisitesPrevuesUnsafeSupplier.get();
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
	protected Integer nbVisitesPrevues;

	@Schema
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@JsonIgnore
	public void setNom(UnsafeSupplier<String, Exception> nomUnsafeSupplier) {
		try {
			nom = nomUnsafeSupplier.get();
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
	protected String nom;

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
	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	@JsonIgnore
	public void setPrenoms(
		UnsafeSupplier<String, Exception> prenomsUnsafeSupplier) {

		try {
			prenoms = prenomsUnsafeSupplier.get();
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
	protected String prenoms;

	@Schema
	public Integer getRang() {
		return rang;
	}

	public void setRang(Integer rang) {
		this.rang = rang;
	}

	@JsonIgnore
	public void setRang(UnsafeSupplier<Integer, Exception> rangUnsafeSupplier) {
		try {
			rang = rangUnsafeSupplier.get();
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
	protected Integer rang;

	@Schema
	public Double getTauxRealisation() {
		return tauxRealisation;
	}

	public void setTauxRealisation(Double tauxRealisation) {
		this.tauxRealisation = tauxRealisation;
	}

	@JsonIgnore
	public void setTauxRealisation(
		UnsafeSupplier<Double, Exception> tauxRealisationUnsafeSupplier) {

		try {
			tauxRealisation = tauxRealisationUnsafeSupplier.get();
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
	protected Double tauxRealisation;

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

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Evaluation)) {
			return false;
		}

		Evaluation evaluation = (Evaluation)object;

		return Objects.equals(toString(), evaluation.toString());
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

		if (createdAt != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"createdAt\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(createdAt));

			sb.append("\"");
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

		if (nbVisitesEffectuees != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nbVisitesEffectuees\": ");

			sb.append(nbVisitesEffectuees);
		}

		if (nbVisitesPrevues != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nbVisitesPrevues\": ");

			sb.append(nbVisitesPrevues);
		}

		if (nom != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nom\": ");

			sb.append("\"");

			sb.append(_escape(nom));

			sb.append("\"");
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

		if (prenoms != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"prenoms\": ");

			sb.append("\"");

			sb.append(_escape(prenoms));

			sb.append("\"");
		}

		if (rang != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"rang\": ");

			sb.append(rang);
		}

		if (tauxRealisation != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tauxRealisation\": ");

			sb.append(tauxRealisation);
		}

		if (trimestre != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"trimestre\": ");

			sb.append(trimestre);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.df.lonis.reseaurest.dto.v1_0.Evaluation",
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