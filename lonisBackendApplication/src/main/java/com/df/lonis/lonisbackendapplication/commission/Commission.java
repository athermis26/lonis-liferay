package com.df.lonis.lonisbackendapplication.commission;

import com.df.lonis.lonisbackendapplication.common.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "commissions")
@Getter
@Setter
public class Commission extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String code;

	@Column(name = "terminal_id", nullable = false)
	private Long terminalId;

	@Column(name = "nombre_terminal", nullable = false)
	private int nombreTerminal = 1;

	@Column(nullable = false)
	private boolean paye = false;

	private String libelle;

	@Column(nullable = false)
	private String status = "EN_ATTENTE";
}
