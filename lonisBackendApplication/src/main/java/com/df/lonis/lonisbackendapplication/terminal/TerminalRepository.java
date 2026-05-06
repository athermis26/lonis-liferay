package com.df.lonis.lonisbackendapplication.terminal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TerminalRepository extends JpaRepository<Terminal, Long> {

	Optional<Terminal> findByCodeTerminal(String codeTerminal);

	List<Terminal> findByConcessionnaireId(Long concessionnaireId);

	List<Terminal> findBySiteId(Long siteId);

	Page<Terminal> findByStatutValidation(String statutValidation, Pageable pageable);

	Page<Terminal> findByCodeTerminalContainingIgnoreCase(String codeTerminal, Pageable pageable);
}
