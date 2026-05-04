package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.ConcessionnaireActiviteSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class ConcessionnaireActivite implements Cloneable, Serializable {

	public static ConcessionnaireActivite toDTO(String json) {
		return ConcessionnaireActiviteSerDes.toDTO(json);
	}

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

	public String[] getConcessionnaireCodes() {
		return concessionnaireCodes;
	}

	public void setConcessionnaireCodes(String[] concessionnaireCodes) {
		this.concessionnaireCodes = concessionnaireCodes;
	}

	public void setConcessionnaireCodes(
		UnsafeSupplier<String[], Exception>
			concessionnaireCodesUnsafeSupplier) {

		try {
			concessionnaireCodes = concessionnaireCodesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String[] concessionnaireCodes;

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

	public Long getNombreOperations() {
		return nombreOperations;
	}

	public void setNombreOperations(Long nombreOperations) {
		this.nombreOperations = nombreOperations;
	}

	public void setNombreOperations(
		UnsafeSupplier<Long, Exception> nombreOperationsUnsafeSupplier) {

		try {
			nombreOperations = nombreOperationsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long nombreOperations;

	public Integer getNombreTerminaux() {
		return nombreTerminaux;
	}

	public void setNombreTerminaux(Integer nombreTerminaux) {
		this.nombreTerminaux = nombreTerminaux;
	}

	public void setNombreTerminaux(
		UnsafeSupplier<Integer, Exception> nombreTerminauxUnsafeSupplier) {

		try {
			nombreTerminaux = nombreTerminauxUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer nombreTerminaux;

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
	public ConcessionnaireActivite clone() throws CloneNotSupportedException {
		return (ConcessionnaireActivite)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConcessionnaireActivite)) {
			return false;
		}

		ConcessionnaireActivite concessionnaireActivite =
			(ConcessionnaireActivite)object;

		return Objects.equals(toString(), concessionnaireActivite.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ConcessionnaireActiviteSerDes.toJSON(this);
	}

}