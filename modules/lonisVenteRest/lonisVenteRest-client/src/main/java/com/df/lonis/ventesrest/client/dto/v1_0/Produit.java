package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.ProduitSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class Produit implements Cloneable, Serializable {

	public static Produit toDTO(String json) {
		return ProduitSerDes.toDTO(json);
	}

	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	public void setAbreviation(
		UnsafeSupplier<String, Exception> abreviationUnsafeSupplier) {

		try {
			abreviation = abreviationUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String abreviation;

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

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setLibelle(
		UnsafeSupplier<String, Exception> libelleUnsafeSupplier) {

		try {
			libelle = libelleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String libelle;

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
	public Produit clone() throws CloneNotSupportedException {
		return (Produit)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Produit)) {
			return false;
		}

		Produit produit = (Produit)object;

		return Objects.equals(toString(), produit.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ProduitSerDes.toJSON(this);
	}

}