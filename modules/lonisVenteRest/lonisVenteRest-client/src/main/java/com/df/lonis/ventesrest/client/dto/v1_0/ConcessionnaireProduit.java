package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.ConcessionnaireProduitSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class ConcessionnaireProduit implements Cloneable, Serializable {

	public static ConcessionnaireProduit toDTO(String json) {
		return ConcessionnaireProduitSerDes.toDTO(json);
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setActive(
		UnsafeSupplier<Boolean, Exception> activeUnsafeSupplier) {

		try {
			active = activeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean active;

	public Long getChiffreAffaires() {
		return chiffreAffaires;
	}

	public void setChiffreAffaires(Long chiffreAffaires) {
		this.chiffreAffaires = chiffreAffaires;
	}

	public void setChiffreAffaires(
		UnsafeSupplier<Long, Exception> chiffreAffairesUnsafeSupplier) {

		try {
			chiffreAffaires = chiffreAffairesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long chiffreAffaires;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCode(UnsafeSupplier<String, Exception> codeUnsafeSupplier) {
		try {
			code = codeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String code;

	public String getConcessionnaireCode() {
		return concessionnaireCode;
	}

	public void setConcessionnaireCode(String concessionnaireCode) {
		this.concessionnaireCode = concessionnaireCode;
	}

	public void setConcessionnaireCode(
		UnsafeSupplier<String, Exception> concessionnaireCodeUnsafeSupplier) {

		try {
			concessionnaireCode = concessionnaireCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String concessionnaireCode;

	public Long getConcessionnaireId() {
		return concessionnaireId;
	}

	public void setConcessionnaireId(Long concessionnaireId) {
		this.concessionnaireId = concessionnaireId;
	}

	public void setConcessionnaireId(
		UnsafeSupplier<Long, Exception> concessionnaireIdUnsafeSupplier) {

		try {
			concessionnaireId = concessionnaireIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long concessionnaireId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Long, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long id;

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public void setProduit(
		UnsafeSupplier<Produit, Exception> produitUnsafeSupplier) {

		try {
			produit = produitUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Produit produit;

	public Long getProduitId() {
		return produitId;
	}

	public void setProduitId(Long produitId) {
		this.produitId = produitId;
	}

	public void setProduitId(
		UnsafeSupplier<Long, Exception> produitIdUnsafeSupplier) {

		try {
			produitId = produitIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long produitId;

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public void setSite(UnsafeSupplier<Site, Exception> siteUnsafeSupplier) {
		try {
			site = siteUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Site site;

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public void setSiteId(
		UnsafeSupplier<Long, Exception> siteIdUnsafeSupplier) {

		try {
			siteId = siteIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long siteId;

	@Override
	public ConcessionnaireProduit clone() throws CloneNotSupportedException {
		return (ConcessionnaireProduit)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConcessionnaireProduit)) {
			return false;
		}

		ConcessionnaireProduit concessionnaireProduit =
			(ConcessionnaireProduit)object;

		return Objects.equals(toString(), concessionnaireProduit.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ConcessionnaireProduitSerDes.toJSON(this);
	}

}