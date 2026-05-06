package com.df.lonis.lonisbackendapplication.commission;

import java.time.Instant;

public final class CommissionDtos {

	private CommissionDtos() {}

	public record CommissionResponse(
			Long id,
			String code,
			Long terminalId,
			String codeTerminal,
			Integer nombreTerminaux,
			Boolean paye,
			String libelle,
			String status,
			Instant createdAt,
			Instant updatedAt
	) {
		public static CommissionResponse from(Commission c, String codeTerminal) {
			return new CommissionResponse(
					c.getId(), c.getCode(), c.getTerminalId(), codeTerminal,
					c.getNombreTerminal(), c.isPaye(), c.getLibelle(),
					c.getStatus(), c.getCreatedAt(), c.getUpdatedAt()
			);
		}
	}

	public record CommissionDetailResponse(
			Long id,
			String codeTerminal,
			Instant dateVersement,
			Long chiffreAffaires,
			Long commissionVersee,
			String typeVersement,
			String compteReception,
			Boolean paye,
			String status
	) {
		public static CommissionDetailResponse from(
				Commission c, String codeTerminal, Long chiffreAffaires) {
			return new CommissionDetailResponse(
					c.getId(), codeTerminal,
					c.getUpdatedAt(),
					chiffreAffaires == null ? 0L : chiffreAffaires,
					0L,           // commissionVersee : à brancher quand on aura la règle métier
					null,         // typeVersement
					null,         // compteReception
					c.isPaye(), c.getStatus()
			);
		}
	}
}
