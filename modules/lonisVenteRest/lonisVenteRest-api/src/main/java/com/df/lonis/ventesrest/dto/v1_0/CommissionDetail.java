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

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
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
@GraphQLName("CommissionDetail")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "CommissionDetail")
public class CommissionDetail implements Serializable {

	public static CommissionDetail toDTO(String json) {
		return ObjectMapperUtil.readValue(CommissionDetail.class, json);
	}

	public static CommissionDetail unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(CommissionDetail.class, json);
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
	public String getCodeTerminal() {
		return codeTerminal;
	}

	public void setCodeTerminal(String codeTerminal) {
		this.codeTerminal = codeTerminal;
	}

	@JsonIgnore
	public void setCodeTerminal(
		UnsafeSupplier<String, Exception> codeTerminalUnsafeSupplier) {

		try {
			codeTerminal = codeTerminalUnsafeSupplier.get();
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
	protected String codeTerminal;

	@Schema
	public Long getCommissionVersee() {
		return commissionVersee;
	}

	public void setCommissionVersee(Long commissionVersee) {
		this.commissionVersee = commissionVersee;
	}

	@JsonIgnore
	public void setCommissionVersee(
		UnsafeSupplier<Long, Exception> commissionVerseeUnsafeSupplier) {

		try {
			commissionVersee = commissionVerseeUnsafeSupplier.get();
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
	protected Long commissionVersee;

	@Schema
	public String getCompteReception() {
		return compteReception;
	}

	public void setCompteReception(String compteReception) {
		this.compteReception = compteReception;
	}

	@JsonIgnore
	public void setCompteReception(
		UnsafeSupplier<String, Exception> compteReceptionUnsafeSupplier) {

		try {
			compteReception = compteReceptionUnsafeSupplier.get();
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
	protected String compteReception;

	@Schema
	public Date getDateVersement() {
		return dateVersement;
	}

	public void setDateVersement(Date dateVersement) {
		this.dateVersement = dateVersement;
	}

	@JsonIgnore
	public void setDateVersement(
		UnsafeSupplier<Date, Exception> dateVersementUnsafeSupplier) {

		try {
			dateVersement = dateVersementUnsafeSupplier.get();
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
	protected Date dateVersement;

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
	public Boolean getPaye() {
		return paye;
	}

	public void setPaye(Boolean paye) {
		this.paye = paye;
	}

	@JsonIgnore
	public void setPaye(UnsafeSupplier<Boolean, Exception> payeUnsafeSupplier) {
		try {
			paye = payeUnsafeSupplier.get();
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
	protected Boolean paye;

	@Schema
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@JsonIgnore
	public void setStatus(
		UnsafeSupplier<String, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
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
	protected String status;

	@Schema
	public String getTypeVersement() {
		return typeVersement;
	}

	public void setTypeVersement(String typeVersement) {
		this.typeVersement = typeVersement;
	}

	@JsonIgnore
	public void setTypeVersement(
		UnsafeSupplier<String, Exception> typeVersementUnsafeSupplier) {

		try {
			typeVersement = typeVersementUnsafeSupplier.get();
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
	protected String typeVersement;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CommissionDetail)) {
			return false;
		}

		CommissionDetail commissionDetail = (CommissionDetail)object;

		return Objects.equals(toString(), commissionDetail.toString());
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

		if (chiffreAffaires != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chiffreAffaires\": ");

			sb.append(chiffreAffaires);
		}

		if (codeTerminal != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeTerminal\": ");

			sb.append("\"");

			sb.append(_escape(codeTerminal));

			sb.append("\"");
		}

		if (commissionVersee != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"commissionVersee\": ");

			sb.append(commissionVersee);
		}

		if (compteReception != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"compteReception\": ");

			sb.append("\"");

			sb.append(_escape(compteReception));

			sb.append("\"");
		}

		if (dateVersement != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"dateVersement\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(dateVersement));

			sb.append("\"");
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (paye != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"paye\": ");

			sb.append(paye);
		}

		if (status != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(status));

			sb.append("\"");
		}

		if (typeVersement != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"typeVersement\": ");

			sb.append("\"");

			sb.append(_escape(typeVersement));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.df.lonis.ventesrest.dto.v1_0.CommissionDetail",
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