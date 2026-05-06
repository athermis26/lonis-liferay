package com.df.lonis.lonisbackendapplication.visite;

import com.df.lonis.lonisbackendapplication.common.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "visites")
@Getter
@Setter
public class Visite extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "commercial_id", nullable = false)
	private Long commercialId;

	@Column(name = "terminal_id", nullable = false)
	private Long terminalId;

	private Double latitude;

	private Double longitude;

	@Column(nullable = false)
	private String statut = "PLANIFIEE";

	@Column(name = "type_controle")
	private String typeControle;

	@Column(name = "date_visite", nullable = false)
	private Instant dateVisite;

	@Column(name = "compte_rendu", columnDefinition = "TEXT")
	private String compteRendu;
}
