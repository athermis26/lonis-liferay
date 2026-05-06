package com.df.lonis.lonisbackendapplication.concessionnaire;

import com.df.lonis.lonisbackendapplication.common.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
		name = "concessionnaire_produit",
		uniqueConstraints = @UniqueConstraint(
				name = "uq_conc_prod",
				columnNames = {"concessionnaire_id", "produit_id"}
		)
)
@Getter
@Setter
public class ConcessionnaireProduit extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "concessionnaire_id", nullable = false)
	private Long concessionnaireId;

	@Column(name = "produit_id", nullable = false)
	private Long produitId;

	@Column(name = "site_id")
	private Long siteId;

	@Column(unique = true)
	private String code;

	@Column(name = "concessionnaire_code")
	private String concessionnaireCode;

	@Column(nullable = false)
	private boolean active = true;
}
