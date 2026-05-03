package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.ConcessionnaireBodySerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class ConcessionnaireBody implements Cloneable, Serializable {

	public static ConcessionnaireBody toDTO(String json) {
		return ConcessionnaireBodySerDes.toDTO(json);
	}

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setPrenom(
		UnsafeSupplier<String, Exception> prenomUnsafeSupplier) {

		try {
			prenom = prenomUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String prenom;

	@Override
	public ConcessionnaireBody clone() throws CloneNotSupportedException {
		return (ConcessionnaireBody)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConcessionnaireBody)) {
			return false;
		}

		ConcessionnaireBody concessionnaireBody = (ConcessionnaireBody)object;

		return Objects.equals(toString(), concessionnaireBody.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ConcessionnaireBodySerDes.toJSON(this);
	}

}