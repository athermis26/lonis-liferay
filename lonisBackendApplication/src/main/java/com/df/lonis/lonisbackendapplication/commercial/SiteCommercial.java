package com.df.lonis.lonisbackendapplication.commercial;

import com.df.lonis.lonisbackendapplication.common.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(
		name = "site_commerciaux",
		uniqueConstraints = @UniqueConstraint(
				name = "uq_site_commercial_actif",
				columnNames = {"site_id", "commercial_id"}
		)
)
@Getter
@Setter
public class SiteCommercial extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "site_id", nullable = false)
	private Long siteId;

	@Column(name = "commercial_id", nullable = false)
	private Long commercialId;

	@Column(name = "date_debut", nullable = false)
	private LocalDate dateDebut;

	@Column(name = "date_fin")
	private LocalDate dateFin;

	@Column(name = "is_principal", nullable = false)
	private boolean isPrincipal = false;
}
