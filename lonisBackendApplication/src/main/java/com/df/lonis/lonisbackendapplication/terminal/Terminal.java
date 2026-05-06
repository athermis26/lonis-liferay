package com.df.lonis.lonisbackendapplication.terminal;


import com.df.lonis.lonisbackendapplication.common.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "terminals")
@Getter
@Setter
public class Terminal extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "code_terminal", unique = true, nullable = false)
	private String codeTerminal;

	@Column(name = "concessionnaire_id")
	private Long concessionnaireId;

	@Column(name = "concessionnaire_code")
	private String concessionnaireCode;

	@Column(name = "produit_id")
	private Long produitId;

	@Column(name = "concessionnaire_produit_code")
	private String concessionnaireProduitCode;

	@Column(name = "site_id")
	private Long siteId;

	private Double latitude;

	private Double longitude;

	private String adresse;

	@Column(name = "statut_validation", nullable = false)
	private String statutValidation = "EN_ATTENTE";
}
