package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.DashboardKpisSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class DashboardKpis implements Cloneable, Serializable {

	public static DashboardKpis toDTO(String json) {
		return DashboardKpisSerDes.toDTO(json);
	}

	public Long getChiffreAffairesTotal() {
		return chiffreAffairesTotal;
	}

	public void setChiffreAffairesTotal(Long chiffreAffairesTotal) {
		this.chiffreAffairesTotal = chiffreAffairesTotal;
	}

	public void setChiffreAffairesTotal(
		UnsafeSupplier<Long, Exception> chiffreAffairesTotalUnsafeSupplier) {

		try {
			chiffreAffairesTotal = chiffreAffairesTotalUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long chiffreAffairesTotal;

	public Long getPaiementsTotal() {
		return paiementsTotal;
	}

	public void setPaiementsTotal(Long paiementsTotal) {
		this.paiementsTotal = paiementsTotal;
	}

	public void setPaiementsTotal(
		UnsafeSupplier<Long, Exception> paiementsTotalUnsafeSupplier) {

		try {
			paiementsTotal = paiementsTotalUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long paiementsTotal;

	public Long getTotalConcessionnaires() {
		return totalConcessionnaires;
	}

	public void setTotalConcessionnaires(Long totalConcessionnaires) {
		this.totalConcessionnaires = totalConcessionnaires;
	}

	public void setTotalConcessionnaires(
		UnsafeSupplier<Long, Exception> totalConcessionnairesUnsafeSupplier) {

		try {
			totalConcessionnaires = totalConcessionnairesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long totalConcessionnaires;

	public Long getTotalPointsDeVente() {
		return totalPointsDeVente;
	}

	public void setTotalPointsDeVente(Long totalPointsDeVente) {
		this.totalPointsDeVente = totalPointsDeVente;
	}

	public void setTotalPointsDeVente(
		UnsafeSupplier<Long, Exception> totalPointsDeVenteUnsafeSupplier) {

		try {
			totalPointsDeVente = totalPointsDeVenteUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long totalPointsDeVente;

	@Override
	public DashboardKpis clone() throws CloneNotSupportedException {
		return (DashboardKpis)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DashboardKpis)) {
			return false;
		}

		DashboardKpis dashboardKpis = (DashboardKpis)object;

		return Objects.equals(toString(), dashboardKpis.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return DashboardKpisSerDes.toJSON(this);
	}

}