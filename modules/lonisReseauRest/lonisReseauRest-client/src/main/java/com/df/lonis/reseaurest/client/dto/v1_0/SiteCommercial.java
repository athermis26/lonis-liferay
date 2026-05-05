package com.df.lonis.reseaurest.client.dto.v1_0;

import com.df.lonis.reseaurest.client.function.UnsafeSupplier;
import com.df.lonis.reseaurest.client.serdes.v1_0.SiteCommercialSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class SiteCommercial implements Cloneable, Serializable {

	public static SiteCommercial toDTO(String json) {
		return SiteCommercialSerDes.toDTO(json);
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

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public void setDateDebut(
		UnsafeSupplier<Date, Exception> dateDebutUnsafeSupplier) {

		try {
			dateDebut = dateDebutUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dateDebut;

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public void setDateFin(
		UnsafeSupplier<Date, Exception> dateFinUnsafeSupplier) {

		try {
			dateFin = dateFinUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dateFin;

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

	public Boolean getIsPrincipal() {
		return isPrincipal;
	}

	public void setIsPrincipal(Boolean isPrincipal) {
		this.isPrincipal = isPrincipal;
	}

	public void setIsPrincipal(
		UnsafeSupplier<Boolean, Exception> isPrincipalUnsafeSupplier) {

		try {
			isPrincipal = isPrincipalUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean isPrincipal;

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
	public SiteCommercial clone() throws CloneNotSupportedException {
		return (SiteCommercial)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SiteCommercial)) {
			return false;
		}

		SiteCommercial siteCommercial = (SiteCommercial)object;

		return Objects.equals(toString(), siteCommercial.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return SiteCommercialSerDes.toJSON(this);
	}

}