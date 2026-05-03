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
@GraphQLName("ChiffreAffaire")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "ChiffreAffaire")
public class ChiffreAffaire implements Serializable {

	public static ChiffreAffaire toDTO(String json) {
		return ObjectMapperUtil.readValue(ChiffreAffaire.class, json);
	}

	public static ChiffreAffaire unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(ChiffreAffaire.class, json);
	}

	@Schema
	public Long getAnnulation() {
		return annulation;
	}

	public void setAnnulation(Long annulation) {
		this.annulation = annulation;
	}

	@JsonIgnore
	public void setAnnulation(
		UnsafeSupplier<Long, Exception> annulationUnsafeSupplier) {

		try {
			annulation = annulationUnsafeSupplier.get();
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
	protected Long annulation;

	@Schema
	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	@JsonIgnore
	public void setBalance(
		UnsafeSupplier<Long, Exception> balanceUnsafeSupplier) {

		try {
			balance = balanceUnsafeSupplier.get();
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
	protected Long balance;

	@Schema
	public Long getBrut() {
		return brut;
	}

	public void setBrut(Long brut) {
		this.brut = brut;
	}

	@JsonIgnore
	public void setBrut(UnsafeSupplier<Long, Exception> brutUnsafeSupplier) {
		try {
			brut = brutUnsafeSupplier.get();
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
	protected Long brut;

	@Schema
	public Long getChiffreAffaire() {
		return chiffreAffaire;
	}

	public void setChiffreAffaire(Long chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
	}

	@JsonIgnore
	public void setChiffreAffaire(
		UnsafeSupplier<Long, Exception> chiffreAffaireUnsafeSupplier) {

		try {
			chiffreAffaire = chiffreAffaireUnsafeSupplier.get();
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
	protected Long chiffreAffaire;

	@Schema
	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	@JsonIgnore
	public void setCodeProduit(
		UnsafeSupplier<String, Exception> codeProduitUnsafeSupplier) {

		try {
			codeProduit = codeProduitUnsafeSupplier.get();
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
	protected String codeProduit;

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
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@JsonIgnore
	public void setDate(UnsafeSupplier<Date, Exception> dateUnsafeSupplier) {
		try {
			date = dateUnsafeSupplier.get();
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
	protected Date date;

	@Schema
	public Long getDeposite() {
		return deposite;
	}

	public void setDeposite(Long deposite) {
		this.deposite = deposite;
	}

	@JsonIgnore
	public void setDeposite(
		UnsafeSupplier<Long, Exception> depositeUnsafeSupplier) {

		try {
			deposite = depositeUnsafeSupplier.get();
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
	protected Long deposite;

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
	public Long getPaiement() {
		return paiement;
	}

	public void setPaiement(Long paiement) {
		this.paiement = paiement;
	}

	@JsonIgnore
	public void setPaiement(
		UnsafeSupplier<Long, Exception> paiementUnsafeSupplier) {

		try {
			paiement = paiementUnsafeSupplier.get();
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
	protected Long paiement;

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
	public Long getRembourcement() {
		return rembourcement;
	}

	public void setRembourcement(Long rembourcement) {
		this.rembourcement = rembourcement;
	}

	@JsonIgnore
	public void setRembourcement(
		UnsafeSupplier<Long, Exception> rembourcementUnsafeSupplier) {

		try {
			rembourcement = rembourcementUnsafeSupplier.get();
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
	protected Long rembourcement;

	@Schema
	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@JsonIgnore
	public void setSite(UnsafeSupplier<String, Exception> siteUnsafeSupplier) {
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
	protected String site;

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

	@Schema
	public Long getVentes() {
		return ventes;
	}

	public void setVentes(Long ventes) {
		this.ventes = ventes;
	}

	@JsonIgnore
	public void setVentes(
		UnsafeSupplier<Long, Exception> ventesUnsafeSupplier) {

		try {
			ventes = ventesUnsafeSupplier.get();
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
	protected Long ventes;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChiffreAffaire)) {
			return false;
		}

		ChiffreAffaire chiffreAffaire = (ChiffreAffaire)object;

		return Objects.equals(toString(), chiffreAffaire.toString());
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

		if (annulation != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"annulation\": ");

			sb.append(annulation);
		}

		if (balance != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"balance\": ");

			sb.append(balance);
		}

		if (brut != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"brut\": ");

			sb.append(brut);
		}

		if (chiffreAffaire != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"chiffreAffaire\": ");

			sb.append(chiffreAffaire);
		}

		if (codeProduit != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"codeProduit\": ");

			sb.append("\"");

			sb.append(_escape(codeProduit));

			sb.append("\"");
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

		if (concessionnaireNomPrenom != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"concessionnaireNomPrenom\": ");

			sb.append("\"");

			sb.append(_escape(concessionnaireNomPrenom));

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

		if (date != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"date\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(date));

			sb.append("\"");
		}

		if (deposite != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"deposite\": ");

			sb.append(deposite);
		}

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (paiement != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"paiement\": ");

			sb.append(paiement);
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

		if (rembourcement != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"rembourcement\": ");

			sb.append(rembourcement);
		}

		if (site != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"site\": ");

			sb.append("\"");

			sb.append(_escape(site));

			sb.append("\"");
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

		if (ventes != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ventes\": ");

			sb.append(ventes);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.df.lonis.ventesrest.dto.v1_0.ChiffreAffaire",
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