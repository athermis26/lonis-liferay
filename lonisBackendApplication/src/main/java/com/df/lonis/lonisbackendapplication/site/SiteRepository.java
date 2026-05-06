package com.df.lonis.lonisbackendapplication.site;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {

	Page<Site> findByLibelleContainingIgnoreCaseOrCodeContainingIgnoreCase(
			String libelle, String code, Pageable pageable);
}
