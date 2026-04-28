package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.SiteSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class Site implements Cloneable, Serializable {

	public static Site toDTO(String json) {
		return SiteSerDes.toDTO(json);
	}

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

	public String getCodeProvince() {
		return codeProvince;
	}

	public void setCodeProvince(String codeProvince) {
		this.codeProvince = codeProvince;
	}

	public void setCodeProvince(
		UnsafeSupplier<String, Exception> codeProvinceUnsafeSupplier) {

		try {
			codeProvince = codeProvinceUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String codeProvince;

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public void setParentId(
		UnsafeSupplier<Long, Exception> parentIdUnsafeSupplier) {

		try {
			parentId = parentIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long parentId;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setStatus(
		UnsafeSupplier<Boolean, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean status;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setType(UnsafeSupplier<Integer, Exception> typeUnsafeSupplier) {
		try {
			type = typeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer type;

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
	public Site clone() throws CloneNotSupportedException {
		return (Site)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Site)) {
			return false;
		}

		Site site = (Site)object;

		return Objects.equals(toString(), site.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return SiteSerDes.toJSON(this);
	}

}