package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.ConcessionnaireDetailSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class ConcessionnaireDetail implements Cloneable, Serializable {

	public static ConcessionnaireDetail toDTO(String json) {
		return ConcessionnaireDetailSerDes.toDTO(json);
	}

	public ConcessionnaireProduit[] getConcessionnaireProduits() {
		return concessionnaireProduits;
	}

	public void setConcessionnaireProduits(
		ConcessionnaireProduit[] concessionnaireProduits) {

		this.concessionnaireProduits = concessionnaireProduits;
	}

	public void setConcessionnaireProduits(
		UnsafeSupplier<ConcessionnaireProduit[], Exception>
			concessionnaireProduitsUnsafeSupplier) {

		try {
			concessionnaireProduits =
				concessionnaireProduitsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected ConcessionnaireProduit[] concessionnaireProduits;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmail(
		UnsafeSupplier<String, Exception> emailUnsafeSupplier) {

		try {
			email = emailUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String email;

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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNom(UnsafeSupplier<String, Exception> nomUnsafeSupplier) {
		try {
			nom = nomUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String nom;

	public String getPrenoms() {
		return prenoms;
	}

	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	public void setPrenoms(
		UnsafeSupplier<String, Exception> prenomsUnsafeSupplier) {

		try {
			prenoms = prenomsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String prenoms;

	public Long getSoldeTotal() {
		return soldeTotal;
	}

	public void setSoldeTotal(Long soldeTotal) {
		this.soldeTotal = soldeTotal;
	}

	public void setSoldeTotal(
		UnsafeSupplier<Long, Exception> soldeTotalUnsafeSupplier) {

		try {
			soldeTotal = soldeTotalUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long soldeTotal;

	public ConcessionnaireStats getStats() {
		return stats;
	}

	public void setStats(ConcessionnaireStats stats) {
		this.stats = stats;
	}

	public void setStats(
		UnsafeSupplier<ConcessionnaireStats, Exception> statsUnsafeSupplier) {

		try {
			stats = statsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected ConcessionnaireStats stats;

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setTelephone(
		UnsafeSupplier<String, Exception> telephoneUnsafeSupplier) {

		try {
			telephone = telephoneUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String telephone;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setUid(UnsafeSupplier<String, Exception> uidUnsafeSupplier) {
		try {
			uid = uidUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String uid;

	@Override
	public ConcessionnaireDetail clone() throws CloneNotSupportedException {
		return (ConcessionnaireDetail)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConcessionnaireDetail)) {
			return false;
		}

		ConcessionnaireDetail concessionnaireDetail =
			(ConcessionnaireDetail)object;

		return Objects.equals(toString(), concessionnaireDetail.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ConcessionnaireDetailSerDes.toJSON(this);
	}

}