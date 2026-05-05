package com.df.lonis.reseaurest.client.dto.v1_0;

import com.df.lonis.reseaurest.client.function.UnsafeSupplier;
import com.df.lonis.reseaurest.client.serdes.v1_0.ObjectifSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class Objectif implements Cloneable, Serializable {

	public static Objectif toDTO(String json) {
		return ObjectifSerDes.toDTO(json);
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public void setAnnee(
		UnsafeSupplier<Integer, Exception> anneeUnsafeSupplier) {

		try {
			annee = anneeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer annee;

	public Long getCommercialId() {
		return commercialId;
	}

	public void setCommercialId(Long commercialId) {
		this.commercialId = commercialId;
	}

	public void setCommercialId(
		UnsafeSupplier<Long, Exception> commercialIdUnsafeSupplier) {

		try {
			commercialId = commercialIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long commercialId;

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

	public Integer getMois() {
		return mois;
	}

	public void setMois(Integer mois) {
		this.mois = mois;
	}

	public void setMois(UnsafeSupplier<Integer, Exception> moisUnsafeSupplier) {
		try {
			mois = moisUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer mois;

	public Periode getPeriode() {
		return periode;
	}

	public String getPeriodeAsString() {
		if (periode == null) {
			return null;
		}

		return periode.toString();
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public void setPeriode(
		UnsafeSupplier<Periode, Exception> periodeUnsafeSupplier) {

		try {
			periode = periodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Periode periode;

	public Integer getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(Integer trimestre) {
		this.trimestre = trimestre;
	}

	public void setTrimestre(
		UnsafeSupplier<Integer, Exception> trimestreUnsafeSupplier) {

		try {
			trimestre = trimestreUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer trimestre;

	public Type getType() {
		return type;
	}

	public String getTypeAsString() {
		if (type == null) {
			return null;
		}

		return type.toString();
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setType(UnsafeSupplier<Type, Exception> typeUnsafeSupplier) {
		try {
			type = typeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Type type;

	public Integer getValeurCible() {
		return valeurCible;
	}

	public void setValeurCible(Integer valeurCible) {
		this.valeurCible = valeurCible;
	}

	public void setValeurCible(
		UnsafeSupplier<Integer, Exception> valeurCibleUnsafeSupplier) {

		try {
			valeurCible = valeurCibleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer valeurCible;

	public Integer getValeurReelle() {
		return valeurReelle;
	}

	public void setValeurReelle(Integer valeurReelle) {
		this.valeurReelle = valeurReelle;
	}

	public void setValeurReelle(
		UnsafeSupplier<Integer, Exception> valeurReelleUnsafeSupplier) {

		try {
			valeurReelle = valeurReelleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer valeurReelle;

	@Override
	public Objectif clone() throws CloneNotSupportedException {
		return (Objectif)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Objectif)) {
			return false;
		}

		Objectif objectif = (Objectif)object;

		return Objects.equals(toString(), objectif.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ObjectifSerDes.toJSON(this);
	}

	public static enum Periode {

		MENSUEL("MENSUEL"), TRIMESTRIEL("TRIMESTRIEL");

		public static Periode create(String value) {
			for (Periode periode : values()) {
				if (Objects.equals(periode.getValue(), value) ||
					Objects.equals(periode.name(), value)) {

					return periode;
				}
			}

			return null;
		}

		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Periode(String value) {
			_value = value;
		}

		private final String _value;

	}

	public static enum Type {

		VISITE("VISITE"), VENTE("VENTE");

		public static Type create(String value) {
			for (Type type : values()) {
				if (Objects.equals(type.getValue(), value) ||
					Objects.equals(type.name(), value)) {

					return type;
				}
			}

			return null;
		}

		public String getValue() {
			return _value;
		}

		@Override
		public String toString() {
			return _value;
		}

		private Type(String value) {
			_value = value;
		}

		private final String _value;

	}

}