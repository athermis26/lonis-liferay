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

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author HP
 * @generated
 */
@Generated("")
@GraphQLName("Terminal")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Terminal")
public class Terminal implements Serializable {

	public static Terminal toDTO(String json) {
		return ObjectMapperUtil.readValue(Terminal.class, json);
	}

	public static Terminal unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Terminal.class, json);
	}

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
	public String getConcessionnaireCode() {
		return concessionnaireCode;
	}

	public void setConcessionnaireCode(String concessionnaireCode) {
		this.concessionnaireCode = concessionnaireCode;
	}

	@JsonIgnore
	public void setConcessionnaireCode(
		UnsafeSupplier<String, Exception> concessionnaireCodeUnsafeSupplier) {

		try {
			concessionnaireCode = concessionnaireCodeUnsafeSupplier.get();
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
	protected String concessionnaireCode;

	@Schema
	public Long getConcessionnaireId() {
		return concessionnaireId;
	}

	public void setConcessionnaireId(Long concessionnaireId) {
		this.concessionnaireId = concessionnaireId;
	}

	@JsonIgnore
	public void setConcessionnaireId(
		UnsafeSupplier<Long, Exception> concessionnaireIdUnsafeSupplier) {

		try {
			concessionnaireId = concessionnaireIdUnsafeSupplier.get();
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
	protected Long concessionnaireId;

	@Schema
	public String getConcessionnaireNomPrenom() {
		return concessionnaireNomPrenom;
	}

	public void setConcessionnaireNomPrenom(String concessionnaireNomPrenom) {
		this.concessionnaireNomPrenom = concessionnaireNomPrenom;
	}

	@JsonIgnore
	public void setConcessionnaireNomPrenom(
		UnsafeSupplier<String, Exception>
			concessionnaireNomPrenomUnsafeSupplier) {

		try {
			concessionnaireNomPrenom =
				concessionnaireNomPrenomUnsafeSupplier.get();
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
	protected String concessionnaireNomPrenom;

	@Schema
	public String getConcessionnaireProduitCode() {
		return concessionnaireProduitCode;
	}

	public void setConcessionnaireProduitCode(
		String concessionnaireProduitCode) {

		this.concessionnaireProduitCode = concessionnaireProduitCode;
	}

	@JsonIgnore
	public void setConcessionnaireProduitCode(
		UnsafeSupplier<String, Exception>
			concessionnaireProduitCodeUnsafeSupplier) {

		try {
			concessionnaireProduitCode =
				concessionnaireProduitCodeUnsafeSupplier.get();
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
	protected String concessionnaireProduitCode;

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
	@Valid
	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@JsonIgnore
	public void setProduit(
		UnsafeSupplier<Produit, Exception> produitUnsafeSupplier) {

		try {
			produit = produitUnsafeSupplier.get();
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
	protected Produit produit;

	@Schema
	public Long getProduitId() {
		return produitId;
	}

	public void setProduitId(Long produitId) {
		this.produitId = produitId;
	}

	@JsonIgnore
	public void setProduitId(
		UnsafeSupplier<Long, Exception> produitIdUnsafeSupplier) {

		try {
			produitId = produitIdUnsafeSupplier.get();
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
	protected Long produitId;

	@Schema
	public String getProduitType() {
		return produitType;
	}

	public void setProduitType(String produitType) {
		this.produitType = produitType;
	}

	@JsonIgnore
	public void setProduitType(
		UnsafeSupplier<String, Exception> produitTypeUnsafeSupplier) {

		try {
			produitType = produitTypeUnsafeSupplier.get();
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
	protected String produitType;

	@Schema
	@Valid
	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	@JsonIgnore
	public void setSite(UnsafeSupplier<Site, Exception> siteUnsafeSupplier) {
		try {
			site = siteUnsafeSupplier.get();
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
	protected Site site;

	@Schema
	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	@JsonIgnore
	public void setSiteId(
		UnsafeSupplier<Long, Exception> siteIdUnsafeSupplier) {

		try {
			siteId = siteIdUnsafeSupplier.get();
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
	protected Long siteId;

	@Schema
	public String getSiteLibelle() {
		return siteLibelle;
	}

	public void setSiteLibelle(String siteLibelle) {
		this.siteLibelle = siteLibelle;
	}

	@JsonIgnore
	public void setSiteLibelle(
		UnsafeSupplier<String, Exception> siteLibelleUnsafeSupplier) {

		try {
			siteLibelle = siteLibelleUnsafeSupplier.get();
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
	protected String siteLibelle;

	@Schema
	public Long getSolde() {
		return solde;
	}

	public void setSolde(Long solde) {
		this.solde = solde;
	}

	@JsonIgnore
	public void setSolde(UnsafeSupplier<Long, Exception> soldeUnsafeSupplier) {
		try {
			solde = soldeUnsafeSupplier.get();
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
	protected Long solde;

	@Schema
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@JsonIgnore
	public void setUpdatedAt(
		UnsafeSupplier<Date, Exception> updatedAtUnsafeSupplier) {

		try {
			updatedAt = updatedAtUnsafeSupplier.get();
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
	protected Date updatedAt;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Terminal)) {
			return false;
		}

		Terminal terminal = (Terminal)object;

		return Objects.equals(toString(), terminal.toString());
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

		if (codeTerminal != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeTerminal\": ");

			sb.append("\"");

			sb.append(_escape(codeTerminal));

			sb.append("\"");
		}

		if (concessionnaireCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireCode\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireCode));

			sb.append("\"");
		}

		if (concessionnaireId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireId\": ");

			sb.append(concessionnaireId);
		}

		if (concessionnaireNomPrenom != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireNomPrenom\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireNomPrenom));

			sb.append("\"");
		}

		if (concessionnaireProduitCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireProduitCode\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireProduitCode));

			sb.append("\"");
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

		if (produit != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"produit\": ");

			sb.append(String.valueOf(produit));
		}

		if (produitId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"produitId\": ");

			sb.append(produitId);
		}

		if (produitType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"produitType\": ");

			sb.append("\"");

			sb.append(_escape(produitType));

			sb.append("\"");
		}

		if (site != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"site\": ");

			sb.append(String.valueOf(site));
		}

		if (siteId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"siteId\": ");

			sb.append(siteId);
		}

		if (siteLibelle != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"siteLibelle\": ");

			sb.append("\"");

			sb.append(_escape(siteLibelle));

			sb.append("\"");
		}

		if (solde != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"solde\": ");

			sb.append(solde);
		}

		if (updatedAt != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"updatedAt\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(updatedAt));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.df.lonis.ventesrest.dto.v1_0.Terminal",
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