package com.df.lonis.lonisbackendapplication.chiffreaffaires;

import com.df.lonis.lonisbackendapplication.common.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "chiffre_affaires")
@Getter
@Setter
public class ChiffreAffaires extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "terminal_id", nullable = false)
	private Long terminalId;

	@Column(nullable = false)
	private long brut;

	@Column(nullable = false)
	private long paiement;

	@Column(nullable = false)
	private long annulation;

	@Column(nullable = false)
	private long remboursement;

	@Column(nullable = false)
	private long ventes;

	@Column(nullable = false)
	private long balance;

	@Column(nullable = false)
	private long deposit;

	@Column(nullable = false)
	private Instant date;
}
