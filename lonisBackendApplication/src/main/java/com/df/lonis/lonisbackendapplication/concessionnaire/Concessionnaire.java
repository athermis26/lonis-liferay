package com.df.lonis.lonisbackendapplication.concessionnaire;

import com.df.lonis.lonisbackendapplication.common.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "concessionnaires")
@Getter
@Setter
public class Concessionnaire extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String uid;

	@Column(nullable = false)
	private String nom;

	private String prenoms;

	private String telephone;

	private String email;
}
