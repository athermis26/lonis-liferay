package com.df.lonis.lonisbackendapplication.commission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommissionRepository extends JpaRepository<Commission, Long> {

	List<Commission> findByTerminalId(Long terminalId);

	Page<Commission> findByTerminalIdIn(List<Long> terminalIds, Pageable pageable);

	Page<Commission> findByCodeContainingIgnoreCaseOrLibelleContainingIgnoreCase(
			String code, String libelle, Pageable pageable);
}
