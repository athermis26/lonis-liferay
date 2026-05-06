package com.df.lonis.lonisbackendapplication.evaluation;

import com.df.lonis.lonisbackendapplication.common.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "evaluations")
@Getter
@Setter
public class Evaluation extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "commercial_id", nullable = false)
	private Long commercialId;

	@Column(name = "nb_visites_prevues", nullable = false)
	private int nbVisitesPrevues = 0;

	@Column(name = "nb_visites_effectuees", nullable = false)
	private int nbVisitesEffectuees = 0;

	@Column(name = "taux_realisation", nullable = false)
	private double tauxRealisation = 0d;

	private Integer rang;

	@Column(nullable = false)
	private String periode;     // MENSUEL | TRIMESTRIEL

	private Integer mois;
	private Integer trimestre;

	@Column(nullable = false)
	private int annee;
}
