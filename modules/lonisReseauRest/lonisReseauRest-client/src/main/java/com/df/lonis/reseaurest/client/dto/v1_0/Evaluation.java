package com.df.lonis.reseaurest.client.dto.v1_0;

import com.df.lonis.reseaurest.client.function.UnsafeSupplier;
import com.df.lonis.reseaurest.client.serdes.v1_0.EvaluationSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class Evaluation implements Cloneable, Serializable {

	public static Evaluation toDTO(String json) {
		return EvaluationSerDes.toDTO(json);
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

	public Integer getNbVisitesEffectuees() {
		return nbVisitesEffectuees;
	}

	public void setNbVisitesEffectuees(Integer nbVisitesEffectuees) {
		this.nbVisitesEffectuees = nbVisitesEffectuees;
	}

	public void setNbVisitesEffectuees(
		UnsafeSupplier<Integer, Exception> nbVisitesEffectueesUnsafeSupplier) {

		try {
			nbVisitesEffectuees = nbVisitesEffectueesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer nbVisitesEffectuees;

	public Integer getNbVisitesPrevues() {
		return nbVisitesPrevues;
	}

	public void setNbVisitesPrevues(Integer nbVisitesPrevues) {
		this.nbVisitesPrevues = nbVisitesPrevues;
	}

	public void setNbVisitesPrevues(
		UnsafeSupplier<Integer, Exception> nbVisitesPrevuesUnsafeSupplier) {

		try {
			nbVisitesPrevues = nbVisitesPrevuesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer nbVisitesPrevues;

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

	public Integer getRang() {
		return rang;
	}

	public void setRang(Integer rang) {
		this.rang = rang;
	}

	public void setRang(UnsafeSupplier<Integer, Exception> rangUnsafeSupplier) {
		try {
			rang = rangUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer rang;

	public Double getTauxRealisation() {
		return tauxRealisation;
	}

	public void setTauxRealisation(Double tauxRealisation) {
		this.tauxRealisation = tauxRealisation;
	}

	public void setTauxRealisation(
		UnsafeSupplier<Double, Exception> tauxRealisationUnsafeSupplier) {

		try {
			tauxRealisation = tauxRealisationUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double tauxRealisation;

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

	@Override
	public Evaluation clone() throws CloneNotSupportedException {
		return (Evaluation)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Evaluation)) {
			return false;
		}

		Evaluation evaluation = (Evaluation)object;

		return Objects.equals(toString(), evaluation.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return EvaluationSerDes.toJSON(this);
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

}