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
@GraphQLName("TerminalActivite")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "TerminalActivite")
public class TerminalActivite implements Serializable {

	public static TerminalActivite toDTO(String json) {
		return ObjectMapperUtil.readValue(TerminalActivite.class, json);
	}

	public static TerminalActivite unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(TerminalActivite.class, json);
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
	public Long getNombreOperations() {
		return nombreOperations;
	}

	public void setNombreOperations(Long nombreOperations) {
		this.nombreOperations = nombreOperations;
	}

	@JsonIgnore
	public void setNombreOperations(
		UnsafeSupplier<Long, Exception> nombreOperationsUnsafeSupplier) {

		try {
			nombreOperations = nombreOperationsUnsafeSupplier.get();
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
	protected Long nombreOperations;

	@Schema
	public Long getNombreRechargements() {
		return nombreRechargements;
	}

	public void setNombreRechargements(Long nombreRechargements) {
		this.nombreRechargements = nombreRechargements;
	}

	@JsonIgnore
	public void setNombreRechargements(
		UnsafeSupplier<Long, Exception> nombreRechargementsUnsafeSupplier) {

		try {
			nombreRechargements = nombreRechargementsUnsafeSupplier.get();
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
	protected Long nombreRechargements;

	@Schema
	public String getProduitCode() {
		return produitCode;
	}

	public void setProduitCode(String produitCode) {
		this.produitCode = produitCode;
	}

	@JsonIgnore
	public void setProduitCode(
		UnsafeSupplier<String, Exception> produitCodeUnsafeSupplier) {

		try {
			produitCode = produitCodeUnsafeSupplier.get();
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
	protected String produitCode;

	@Schema
	public String getProduitLibelle() {
		return produitLibelle;
	}

	public void setProduitLibelle(String produitLibelle) {
		this.produitLibelle = produitLibelle;
	}

	@JsonIgnore
	public void setProduitLibelle(
		UnsafeSupplier<String, Exception> produitLibelleUnsafeSupplier) {

		try {
			produitLibelle = produitLibelleUnsafeSupplier.get();
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
	protected String produitLibelle;

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

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TerminalActivite)) {
			return false;
		}

		TerminalActivite terminalActivite = (TerminalActivite)object;

		return Objects.equals(toString(), terminalActivite.toString());
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

		if (codeTerminal != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeTerminal\": ");

			sb.append("\"");

			sb.append(_escape(codeTerminal));

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

		if (nombreOperations != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nombreOperations\": ");

			sb.append(nombreOperations);
		}

		if (nombreRechargements != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"nombreRechargements\": ");

			sb.append(nombreRechargements);
		}

		if (produitCode != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"produitCode\": ");

			sb.append("\"");

			sb.append(_escape(produitCode));

			sb.append("\"");
		}

		if (produitLibelle != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"produitLibelle\": ");

			sb.append("\"");

			sb.append(_escape(produitLibelle));

			sb.append("\"");
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

		if (terminalId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"terminalId\": ");

			sb.append(terminalId);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.df.lonis.ventesrest.dto.v1_0.TerminalActivite",
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