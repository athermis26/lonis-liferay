package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.TerminalSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class Terminal implements Cloneable, Serializable {

	public static Terminal toDTO(String json) {
		return TerminalSerDes.toDTO(json);
	}

	public String getCodeTerminal() {
		return codeTerminal;
	}

	public void setCodeTerminal(String codeTerminal) {
		this.codeTerminal = codeTerminal;
	}

	public void setCodeTerminal(
		UnsafeSupplier<String, Exception> codeTerminalUnsafeSupplier) {

		try {
			codeTerminal = codeTerminalUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String codeTerminal;

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

	public String getConcessionnaireNomPrenom() {
		return concessionnaireNomPrenom;
	}

	public void setConcessionnaireNomPrenom(String concessionnaireNomPrenom) {
		this.concessionnaireNomPrenom = concessionnaireNomPrenom;
	}

	public void setConcessionnaireNomPrenom(
		UnsafeSupplier<String, Exception>
			concessionnaireNomPrenomUnsafeSupplier) {

		try {
			concessionnaireNomPrenom =
				concessionnaireNomPrenomUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String concessionnaireNomPrenom;

	public String getConcessionnaireProduitCode() {
		return concessionnaireProduitCode;
	}

	public void setConcessionnaireProduitCode(
		String concessionnaireProduitCode) {

		this.concessionnaireProduitCode = concessionnaireProduitCode;
	}

	public void setConcessionnaireProduitCode(
		UnsafeSupplier<String, Exception>
			concessionnaireProduitCodeUnsafeSupplier) {

		try {
			concessionnaireProduitCode =
				concessionnaireProduitCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String concessionnaireProduitCode;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setCreatedAt(
		UnsafeSupplier<Date, Exception> createdAtUnsafeSupplier) {

		try {
			createdAt = createdAtUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date createdAt;

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

	public String getProduitType() {
		return produitType;
	}

	public void setProduitType(String produitType) {
		this.produitType = produitType;
	}

	public void setProduitType(
		UnsafeSupplier<String, Exception> produitTypeUnsafeSupplier) {

		try {
			produitType = produitTypeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String produitType;

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

	public String getSiteLibelle() {
		return siteLibelle;
	}

	public void setSiteLibelle(String siteLibelle) {
		this.siteLibelle = siteLibelle;
	}

	public void setSiteLibelle(
		UnsafeSupplier<String, Exception> siteLibelleUnsafeSupplier) {

		try {
			siteLibelle = siteLibelleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String siteLibelle;

	public Long getSolde() {
		return solde;
	}

	public void setSolde(Long solde) {
		this.solde = solde;
	}

	public void setSolde(UnsafeSupplier<Long, Exception> soldeUnsafeSupplier) {
		try {
			solde = soldeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long solde;

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setUpdatedAt(
		UnsafeSupplier<Date, Exception> updatedAtUnsafeSupplier) {

		try {
			updatedAt = updatedAtUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date updatedAt;

	@Override
	public Terminal clone() throws CloneNotSupportedException {
		return (Terminal)super.clone();
	}

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
		return TerminalSerDes.toJSON(this);
	}

}