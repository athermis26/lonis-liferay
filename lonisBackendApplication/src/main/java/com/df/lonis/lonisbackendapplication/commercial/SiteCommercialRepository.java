package com.df.lonis.lonisbackendapplication.commercial;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SiteCommercialRepository extends JpaRepository<SiteCommercial, Long> {

	List<SiteCommercial> findByCommercialId(Long commercialId);

	Page<SiteCommercial> findBySiteId(Long siteId, Pageable pageable);

	Optional<SiteCommercial> findBySiteIdAndCommercialId(Long siteId, Long commercialId);
}
