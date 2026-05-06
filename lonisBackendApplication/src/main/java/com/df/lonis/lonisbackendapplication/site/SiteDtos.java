package com.df.lonis.lonisbackendapplication.site;

import java.time.Instant;

public final class SiteDtos {

	private SiteDtos() {}

	public record SiteResponse(
			Long id,
			String libelle,
			Integer type,
			Long parentId,
			String code,
			String codeProvince,
			Boolean status,
			Instant createdAt,
			Instant updatedAt
	) {
		public static SiteResponse from(Site s) {
			return new SiteResponse(
					s.getId(), s.getLibelle(), s.getType(), s.getParentId(),
					s.getCode(), s.getCodeProvinov(), s.isStatus(),
					s.getCreatedAt(), s.getUpdatedAt()
			);
		}
	}
}
