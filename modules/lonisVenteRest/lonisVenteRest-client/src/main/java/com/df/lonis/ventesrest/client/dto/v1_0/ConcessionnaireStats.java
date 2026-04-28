package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.ConcessionnaireStatsSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class ConcessionnaireStats implements Cloneable, Serializable {

	public static ConcessionnaireStats toDTO(String json) {
		return ConcessionnaireStatsSerDes.toDTO(json);
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

	public Integer getTotalProduits() {
		return totalProduits;
	}

	public void setTotalProduits(Integer totalProduits) {
		this.totalProduits = totalProduits;
	}

	public void setTotalProduits(
		UnsafeSupplier<Integer, Exception> totalProduitsUnsafeSupplier) {

		try {
			totalProduits = totalProduitsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer totalProduits;

	public Integer getTotalTerminaux() {
		return totalTerminaux;
	}

	public void setTotalTerminaux(Integer totalTerminaux) {
		this.totalTerminaux = totalTerminaux;
	}

	public void setTotalTerminaux(
		UnsafeSupplier<Integer, Exception> totalTerminauxUnsafeSupplier) {

		try {
			totalTerminaux = totalTerminauxUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer totalTerminaux;

	@Override
	public ConcessionnaireStats clone() throws CloneNotSupportedException {
		return (ConcessionnaireStats)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ConcessionnaireStats)) {
			return false;
		}

		ConcessionnaireStats concessionnaireStats =
			(ConcessionnaireStats)object;

		return Objects.equals(toString(), concessionnaireStats.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ConcessionnaireStatsSerDes.toJSON(this);
	}

}