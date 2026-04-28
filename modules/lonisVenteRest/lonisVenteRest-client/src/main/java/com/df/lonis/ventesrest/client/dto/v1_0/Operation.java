package com.df.lonis.ventesrest.client.dto.v1_0;

import com.df.lonis.ventesrest.client.function.UnsafeSupplier;
import com.df.lonis.ventesrest.client.serdes.v1_0.OperationSerDes;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author HP
 * @generated
 */
@Generated("")
public class Operation implements Cloneable, Serializable {

	public static Operation toDTO(String json) {
		return OperationSerDes.toDTO(json);
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

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public void setDateOperation(
		UnsafeSupplier<Date, Exception> dateOperationUnsafeSupplier) {

		try {
			dateOperation = dateOperationUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Date dateOperation;

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

	public Long getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(Long terminalId) {
		this.terminalId = terminalId;
	}

	public void setTerminalId(
		UnsafeSupplier<Long, Exception> terminalIdUnsafeSupplier) {

		try {
			terminalId = terminalIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long terminalId;

	@Override
	public Operation clone() throws CloneNotSupportedException {
		return (Operation)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Operation)) {
			return false;
		}

		Operation operation = (Operation)object;

		return Objects.equals(toString(), operation.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return OperationSerDes.toJSON(this);
	}

}