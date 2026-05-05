package com.df.lonis.reseaurest.client.dto.v1_0;

import com.df.lonis.reseaurest.client.function.UnsafeSupplier;
import com.df.lonis.reseaurest.client.serdes.v1_0.TerminalSerDes;

import java.io.Serializable;

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

	public StatutValidation getStatutValidation() {
		return statutValidation;
	}

	public String getStatutValidationAsString() {
		if (statutValidation == null) {
			return null;
		}

		return statutValidation.toString();
	}

	public void setStatutValidation(StatutValidation statutValidation) {
		this.statutValidation = statutValidation;
	}

	public void setStatutValidation(
		UnsafeSupplier<StatutValidation, Exception>
			statutValidationUnsafeSupplier) {

		try {
			statutValidation = statutValidationUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected StatutValidation statutValidation;

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

	public static enum StatutValidation {

		EN_ATTENTE("EN_ATTENTE"), VALIDE("VALIDE"), REJETE("REJETE");

		public static StatutValidation create(String value) {
			for (StatutValidation statutValidation : values()) {
				if (Objects.equals(statutValidation.getValue(), value) ||
					Objects.equals(statutValidation.name(), value)) {

					return statutValidation;
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

		private StatutValidation(String value) {
			_value = value;
		}

		private final String _value;

	}

}