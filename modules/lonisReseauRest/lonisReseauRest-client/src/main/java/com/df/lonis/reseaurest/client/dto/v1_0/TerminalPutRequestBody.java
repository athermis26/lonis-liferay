package com.df.lonis.reseaurest.client.dto.v1_0;

import com.df.lonis.reseaurest.client.function.UnsafeSupplier;
import com.df.lonis.reseaurest.client.serdes.v1_0.TerminalPutRequestBodySerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class TerminalPutRequestBody implements Cloneable, Serializable {

	public static TerminalPutRequestBody toDTO(String json) {
		return TerminalPutRequestBodySerDes.toDTO(json);
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setAdresse(
		UnsafeSupplier<String, Exception> adresseUnsafeSupplier) {

		try {
			adresse = adresseUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String adresse;

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
	public TerminalPutRequestBody clone() throws CloneNotSupportedException {
		return (TerminalPutRequestBody)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TerminalPutRequestBody)) {
			return false;
		}

		TerminalPutRequestBody terminalPutRequestBody =
			(TerminalPutRequestBody)object;

		return Objects.equals(toString(), terminalPutRequestBody.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return TerminalPutRequestBodySerDes.toJSON(this);
	}

}