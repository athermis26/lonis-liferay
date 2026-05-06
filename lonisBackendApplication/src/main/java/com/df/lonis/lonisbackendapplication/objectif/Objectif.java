package com.df.lonis.lonisbackendapplication.objectif;

import com.df.lonis.lonisbackendapplication.common.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "objectifs")
@Getter
@Setter
public class Objectif extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "commercial_id", nullable = false)
	private Long commercialId;

	@Column(nullable = false)
	private String type;        // VISITE | VENTE

	@Column(nullable = false)
	private String periode;     // MENSUEL | TRIMESTRIEL

	@Column(name = "valeur_cible", nullable = false)
	private int valeurCible;

	@Column(name = "valeur_reelle", nullable = false)
	private int valeurReelle = 0;

	private Integer mois;
	private Integer trimestre;

	@Column(nullable = false)
	private int annee;
}
