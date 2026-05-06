package com.df.lonis.lonisbackendapplication.operation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

	Optional<Operation> findByReference(String reference);

	List<Operation> findByTerminalId(Long terminalId);

	long countByTerminalId(Long terminalId);

	Page<Operation> findByReferenceContainingIgnoreCaseOrCodeContainingIgnoreCaseOrLibelleContainingIgnoreCase(
			String reference, String code, String libelle, Pageable pageable);
}
