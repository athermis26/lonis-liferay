package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.CommissionDetailSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class CommissionDetail implements Cloneable, Serializable {

	public static CommissionDetail toDTO(String json) {
		return CommissionDetailSerDes.toDTO(json);
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

	public Long getCommissionVersee() {
		return commissionVersee;
	}

	public void setCommissionVersee(Long commissionVersee) {
		this.commissionVersee = commissionVersee;
	}

	public void setCommissionVersee(
		UnsafeSupplier<Long, Exception> commissionVerseeUnsafeSupplier) {

		try {
			commissionVersee = commissionVerseeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long commissionVersee;

	public String getCompteReception() {
		return compteReception;
	}

	public void setCompteReception(String compteReception) {
		this.compteReception = compteReception;
	}

	public void setCompteReception(
		UnsafeSupplier<String, Exception> compteReceptionUnsafeSupplier) {

		try {
			compteReception = compteReceptionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String compteReception;

	public Date getDateVersement() {
		return dateVersement;
	}

	public void setDateVersement(Date dateVersement) {
		this.dateVersement = dateVersement;
	}

	public void setDateVersement(
		UnsafeSupplier<Date, Exception> dateVersementUnsafeSupplier) {

		try {
			dateVersement = dateVersementUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dateVersement;

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

	public Boolean getPaye() {
		return paye;
	}

	public void setPaye(Boolean paye) {
		this.paye = paye;
	}

	public void setPaye(UnsafeSupplier<Boolean, Exception> payeUnsafeSupplier) {
		try {
			paye = payeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean paye;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStatus(
		UnsafeSupplier<String, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String status;

	public String getTypeVersement() {
		return typeVersement;
	}

	public void setTypeVersement(String typeVersement) {
		this.typeVersement = typeVersement;
	}

	public void setTypeVersement(
		UnsafeSupplier<String, Exception> typeVersementUnsafeSupplier) {

		try {
			typeVersement = typeVersementUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String typeVersement;

	@Override
	public CommissionDetail clone() throws CloneNotSupportedException {
		return (CommissionDetail)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CommissionDetail)) {
			return false;
		}

		CommissionDetail commissionDetail = (CommissionDetail)object;

		return Objects.equals(toString(), commissionDetail.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CommissionDetailSerDes.toJSON(this);
	}

}