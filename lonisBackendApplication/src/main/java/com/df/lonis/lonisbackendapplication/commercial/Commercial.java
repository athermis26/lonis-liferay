package com.df.lonis.lonisbackendapplication.commercial;

import com.df.lonis.lonisbackendapplication.common.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "commerciaux")
@Getter
@Setter
public class Commercial extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nom;

	private String prenoms;
	private String telephone;
	private String email;

	@Column(unique = true)
	private String matricule;

	@Column(nullable = false)
	private String statut = "ACTIF";

	@Column(name = "superviseur_id")
	private Long superviseurId;

	@Column(name = "site_id")
	private Long agenceId;
}
