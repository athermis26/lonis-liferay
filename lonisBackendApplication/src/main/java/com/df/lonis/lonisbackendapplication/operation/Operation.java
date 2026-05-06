package com.df.lonis.lonisbackendapplication.operation;

import com.df.lonis.lonisbackendapplication.common.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "operations")
@Getter
@Setter
public class Operation extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String code;

	private String libelle;

	@Column(unique = true)
	private String reference;

	@Column(nullable = false)
	private long montant;

	@Column(name = "montant_reel", nullable = false)
	private long montantReel;

	@Column(nullable = false)
	private String statut = "EN_ATTENTE";

	@Column(name = "terminal_id", nullable = false)
	private Long terminalId;

	private String guichet;

	@Column(name = "date_operation", nullable = false)
	private Instant dateOperation;
}
