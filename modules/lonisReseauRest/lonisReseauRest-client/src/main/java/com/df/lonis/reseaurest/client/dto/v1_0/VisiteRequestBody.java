package com.df.lonis.reseaurest.client.dto.v1_0;

import com.df.lonis.reseaurest.client.function.UnsafeSupplier;
import com.df.lonis.reseaurest.client.serdes.v1_0.VisiteRequestBodySerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class VisiteRequestBody implements Cloneable, Serializable {

	public static VisiteRequestBody toDTO(String json) {
		return VisiteRequestBodySerDes.toDTO(json);
	}

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

	public String getCompteRendu() {
		return compteRendu;
	}

	public void setCompteRendu(String compteRendu) {
		this.compteRendu = compteRendu;
	}

	public void setCompteRendu(
		UnsafeSupplier<String, Exception> compteRenduUnsafeSupplier) {

		try {
			compteRendu = compteRenduUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String compteRendu;

	public Date getDateVisite() {
		return dateVisite;
	}

	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}

	public void setDateVisite(
		UnsafeSupplier<Date, Exception> dateVisiteUnsafeSupplier) {

		try {
			dateVisite = dateVisiteUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dateVisite;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public void setLatitude(
		UnsafeSupplier<Double, Exception> latitudeUnsafeSupplier) {

		try {
			latitude = latitudeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double latitude;

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public void setLongitude(
		UnsafeSupplier<Double, Exception> longitudeUnsafeSupplier) {

		try {
			longitude = longitudeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double longitude;

	public Statut getStatut() {
		return statut;
	}

	public String getStatutAsString() {
		if (statut == null) {
			return null;
		}

		return statut.toString();
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public void setStatut(
		UnsafeSupplier<Statut, Exception> statutUnsafeSupplier) {

		try {
			statut = statutUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Statut statut;

	public Long getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(Long terminalId) {
		this.terminalId = terminalId;
	}

	public void setTerminalId(
		UnsafeSupplier<Long, Exception> terminalIdUnsafeSupplier) {

		try {
			terminalId = terminalIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long terminalId;

	public TypeControle getTypeControle() {
		return typeControle;
	}

	public String getTypeControleAsString() {
		if (typeControle == null) {
			return null;
		}

		return typeControle.toString();
	}

	public void setTypeControle(TypeControle typeControle) {
		this.typeControle = typeControle;
	}

	public void setTypeControle(
		UnsafeSupplier<TypeControle, Exception> typeControleUnsafeSupplier) {

		try {
			typeControle = typeControleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected TypeControle typeControle;

	@Override
	public VisiteRequestBody clone() throws CloneNotSupportedException {
		return (VisiteRequestBody)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VisiteRequestBody)) {
			return false;
		}

		VisiteRequestBody visiteRequestBody = (VisiteRequestBody)object;

		return Objects.equals(toString(), visiteRequestBody.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return VisiteRequestBodySerDes.toJSON(this);
	}

	public static enum Statut {

		PLANIFIEE("PLANIFIEE"), EFFECTUEE("EFFECTUEE"), MANQUEE("MANQUEE");

		public static Statut create(String value) {
			for (Statut statut : values()) {
				if (Objects.equals(statut.getValue(), value) ||
					Objects.equals(statut.name(), value)) {

					return statut;
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

		private Statut(String value) {
			_value = value;
		}

		private final String _value;

	}

	public static enum TypeControle {

		GPS("GPS"), RFID("RFID"), TAG("TAG");

		public static TypeControle create(String value) {
			for (TypeControle typeControle : values()) {
				if (Objects.equals(typeControle.getValue(), value) ||
					Objects.equals(typeControle.name(), value)) {

					return typeControle;
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

		private TypeControle(String value) {
			_value = value;
		}

		private final String _value;

	}

}