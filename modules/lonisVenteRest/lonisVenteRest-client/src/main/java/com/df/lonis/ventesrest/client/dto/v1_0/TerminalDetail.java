package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.TerminalDetailSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class TerminalDetail implements Cloneable, Serializable {

	public static TerminalDetail toDTO(String json) {
		return TerminalDetailSerDes.toDTO(json);
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

	public String getConcessionnaireProduitCode() {
		return concessionnaireProduitCode;
	}

	public void setConcessionnaireProduitCode(
		String concessionnaireProduitCode) {

		this.concessionnaireProduitCode = concessionnaireProduitCode;
	}

	public void setConcessionnaireProduitCode(
		UnsafeSupplier<String, Exception>
			concessionnaireProduitCodeUnsafeSupplier) {

		try {
			concessionnaireProduitCode =
				concessionnaireProduitCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String concessionnaireProduitCode;

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

	public Long getSolde() {
		return solde;
	}

	public void setSolde(Long solde) {
		this.solde = solde;
	}

	public void setSolde(UnsafeSupplier<Long, Exception> soldeUnsafeSupplier) {
		try {
			solde = soldeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long solde;

	public Long getTotalOperations() {
		return totalOperations;
	}

	public void setTotalOperations(Long totalOperations) {
		this.totalOperations = totalOperations;
	}

	public void setTotalOperations(
		UnsafeSupplier<Long, Exception> totalOperationsUnsafeSupplier) {

		try {
			totalOperations = totalOperationsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long totalOperations;

	public Long getTotalPaiements() {
		return totalPaiements;
	}

	public void setTotalPaiements(Long totalPaiements) {
		this.totalPaiements = totalPaiements;
	}

	public void setTotalPaiements(
		UnsafeSupplier<Long, Exception> totalPaiementsUnsafeSupplier) {

		try {
			totalPaiements = totalPaiementsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long totalPaiements;

	@Override
	public TerminalDetail clone() throws CloneNotSupportedException {
		return (TerminalDetail)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TerminalDetail)) {
			return false;
		}

		TerminalDetail terminalDetail = (TerminalDetail)object;

		return Objects.equals(toString(), terminalDetail.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return TerminalDetailSerDes.toJSON(this);
	}

}