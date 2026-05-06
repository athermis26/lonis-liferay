package com.df.lonis.lonisbackendapplication.commission;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommissionRepository extends JpaRepository<Commission, Long> {

	List<Commission> findByTerminalId(Long terminalId);

	Page<Commission> findByTerminalIdIn(List<Long> terminalIds, Pageable pageable);

	Page<Commission> findByCodeContainingIgnoreCaseOrLibelleContainingIgnoreCase(
			String code, String libelle, Pageable pageable);
}
