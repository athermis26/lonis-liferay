package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.TerminauxConcessionnaireSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class TerminauxConcessionnaire implements Cloneable, Serializable {

	public static TerminauxConcessionnaire toDTO(String json) {
		return TerminauxConcessionnaireSerDes.toDTO(json);
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

	public Long getSoldeTotal() {
		return soldeTotal;
	}

	public void setSoldeTotal(Long soldeTotal) {
		this.soldeTotal = soldeTotal;
	}

	public void setSoldeTotal(
		UnsafeSupplier<Long, Exception> soldeTotalUnsafeSupplier) {

		try {
			soldeTotal = soldeTotalUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long soldeTotal;

	public TerminalDetail[] getTerminalDetails() {
		return terminalDetails;
	}

	public void setTerminalDetails(TerminalDetail[] terminalDetails) {
		this.terminalDetails = terminalDetails;
	}

	public void setTerminalDetails(
		UnsafeSupplier<TerminalDetail[], Exception>
			terminalDetailsUnsafeSupplier) {

		try {
			terminalDetails = terminalDetailsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected TerminalDetail[] terminalDetails;

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
	public TerminauxConcessionnaire clone() throws CloneNotSupportedException {
		return (TerminauxConcessionnaire)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TerminauxConcessionnaire)) {
			return false;
		}

		TerminauxConcessionnaire terminauxConcessionnaire =
			(TerminauxConcessionnaire)object;

		return Objects.equals(toString(), terminauxConcessionnaire.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return TerminauxConcessionnaireSerDes.toJSON(this);
	}

}