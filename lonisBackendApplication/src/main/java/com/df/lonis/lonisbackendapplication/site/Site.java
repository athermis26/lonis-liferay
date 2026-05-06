package com.df.lonis.lonisbackendapplication.site;

import com.df.lonis.lonisbackendapplication.common.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sites")
@Getter
@Setter
public class Site extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String libelle;

	@Column(nullable = false)
	private int type;

	@Column(name = "parent_id")
	private Long parentId;

	@Column(unique = true)
	private String code;

	@Column(name = "code_provinov")
	private String codeProvinov;

	@Column(nullable = false)
	private boolean status = true;
}
