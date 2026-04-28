package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.OperationDetailSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class OperationDetail implements Cloneable, Serializable {

	public static OperationDetail toDTO(String json) {
		return OperationDetailSerDes.toDTO(json);
	}

	public String getCodeOperation() {
		return codeOperation;
	}

	public void setCodeOperation(String codeOperation) {
		this.codeOperation = codeOperation;
	}

	public void setCodeOperation(
		UnsafeSupplier<String, Exception> codeOperationUnsafeSupplier) {

		try {
			codeOperation = codeOperationUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String codeOperation;

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

	public Date getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(Date dateHeure) {
		this.dateHeure = dateHeure;
	}

	public void setDateHeure(
		UnsafeSupplier<Date, Exception> dateHeureUnsafeSupplier) {

		try {
			dateHeure = dateHeureUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dateHeure;

	public String getGuichet() {
		return guichet;
	}

	public void setGuichet(String guichet) {
		this.guichet = guichet;
	}

	public void setGuichet(
		UnsafeSupplier<String, Exception> guichetUnsafeSupplier) {

		try {
			guichet = guichetUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String guichet;

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

	public Long getMontant() {
		return montant;
	}

	public void setMontant(Long montant) {
		this.montant = montant;
	}

	public void setMontant(
		UnsafeSupplier<Long, Exception> montantUnsafeSupplier) {

		try {
			montant = montantUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long montant;

	public Long getMontantReel() {
		return montantReel;
	}

	public void setMontantReel(Long montantReel) {
		this.montantReel = montantReel;
	}

	public void setMontantReel(
		UnsafeSupplier<Long, Exception> montantReelUnsafeSupplier) {

		try {
			montantReel = montantReelUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long montantReel;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setReference(
		UnsafeSupplier<String, Exception> referenceUnsafeSupplier) {

		try {
			reference = referenceUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String reference;

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void setStatut(
		UnsafeSupplier<String, Exception> statutUnsafeSupplier) {

		try {
			statut = statutUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String statut;

	@Override
	public OperationDetail clone() throws CloneNotSupportedException {
		return (OperationDetail)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OperationDetail)) {
			return false;
		}

		OperationDetail operationDetail = (OperationDetail)object;

		return Objects.equals(toString(), operationDetail.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return OperationDetailSerDes.toJSON(this);
	}

}