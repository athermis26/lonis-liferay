package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.ChiffreAffaireSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class ChiffreAffaire implements Cloneable, Serializable {

	public static ChiffreAffaire toDTO(String json) {
		return ChiffreAffaireSerDes.toDTO(json);
	}

	public Long getAnnulation() {
		return annulation;
	}

	public void setAnnulation(Long annulation) {
		this.annulation = annulation;
	}

	public void setAnnulation(
		UnsafeSupplier<Long, Exception> annulationUnsafeSupplier) {

		try {
			annulation = annulationUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long annulation;

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public void setBalance(
		UnsafeSupplier<Long, Exception> balanceUnsafeSupplier) {

		try {
			balance = balanceUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long balance;

	public Long getBrut() {
		return brut;
	}

	public void setBrut(Long brut) {
		this.brut = brut;
	}

	public void setBrut(UnsafeSupplier<Long, Exception> brutUnsafeSupplier) {
		try {
			brut = brutUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long brut;

	public Long getChiffreAffaire() {
		return chiffreAffaire;
	}

	public void setChiffreAffaire(Long chiffreAffaire) {
		this.chiffreAffaire = chiffreAffaire;
	}

	public void setChiffreAffaire(
		UnsafeSupplier<Long, Exception> chiffreAffaireUnsafeSupplier) {

		try {
			chiffreAffaire = chiffreAffaireUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long chiffreAffaire;

	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public void setCodeProduit(
		UnsafeSupplier<String, Exception> codeProduitUnsafeSupplier) {

		try {
			codeProduit = codeProduitUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String codeProduit;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDate(UnsafeSupplier<Date, Exception> dateUnsafeSupplier) {
		try {
			date = dateUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date date;

	public Long getDeposite() {
		return deposite;
	}

	public void setDeposite(Long deposite) {
		this.deposite = deposite;
	}

	public void setDeposite(
		UnsafeSupplier<Long, Exception> depositeUnsafeSupplier) {

		try {
			deposite = depositeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long deposite;

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

	public Long getPaiement() {
		return paiement;
	}

	public void setPaiement(Long paiement) {
		this.paiement = paiement;
	}

	public void setPaiement(
		UnsafeSupplier<Long, Exception> paiementUnsafeSupplier) {

		try {
			paiement = paiementUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long paiement;

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

	public Long getRembourcement() {
		return rembourcement;
	}

	public void setRembourcement(Long rembourcement) {
		this.rembourcement = rembourcement;
	}

	public void setRembourcement(
		UnsafeSupplier<Long, Exception> rembourcementUnsafeSupplier) {

		try {
			rembourcement = rembourcementUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long rembourcement;

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public void setSite(UnsafeSupplier<String, Exception> siteUnsafeSupplier) {
		try {
			site = siteUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String site;

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

	public Long getVentes() {
		return ventes;
	}

	public void setVentes(Long ventes) {
		this.ventes = ventes;
	}

	public void setVentes(
		UnsafeSupplier<Long, Exception> ventesUnsafeSupplier) {

		try {
			ventes = ventesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long ventes;

	@Override
	public ChiffreAffaire clone() throws CloneNotSupportedException {
		return (ChiffreAffaire)super.clone();
	}

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
		return ChiffreAffaireSerDes.toJSON(this);
	}

}