package com.df.lonis.lonisbackendapplication.produit;

import com.df.lonis.lonisbackendapplication.common.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produits")
@Getter
@Setter
public class Produit extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String code;

	@Column(nullable = false)
	private String libelle;

	private String abreviation;

	@Column(nullable = false)
	private boolean active = true;
}
