/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.impl;

import com.df.lonis.ventesservice.model.ChiffreAffaires;
import com.df.lonis.ventesservice.service.base.ChiffreAffairesLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
		property = "model.class.name=com.df.lonis.ventesservice.model.ChiffreAffaires",
		service = AopService.class
)
public class ChiffreAffairesLocalServiceImpl
		extends ChiffreAffairesLocalServiceBaseImpl {

	public List<ChiffreAffaires> findByTerminalId(long terminalId) {
		return chiffreAffairesPersistence.findByTerminalId(terminalId);
	}

	/**
	 * Tous les CA dans une plage de dates.
	 * dateDebut et/ou dateFin peuvent etre null (pas de borne).
	 */
	public List<ChiffreAffaires> findByDateRange(Date dateDebut, Date dateFin) {
		DynamicQuery dq = dynamicQuery();

		if (dateDebut != null) {
			dq.add(PropertyFactoryUtil.forName("date").ge(dateDebut));
		}
		if (dateFin != null) {
			dq.add(PropertyFactoryUtil.forName("date").le(dateFin));
		}

		return dynamicQuery(dq);
	}

	/**
	 * CA d un terminal sur une plage de dates.
	 */
	public List<ChiffreAffaires> findByTerminalIdAndDateRange(
			long terminalId, Date dateDebut, Date dateFin) {

		DynamicQuery dq = dynamicQuery();

		dq.add(PropertyFactoryUtil.forName("terminalId").eq(terminalId));

		if (dateDebut != null) {
			dq.add(PropertyFactoryUtil.forName("date").ge(dateDebut));
		}
		if (dateFin != null) {
			dq.add(PropertyFactoryUtil.forName("date").le(dateFin));
		}

		return dynamicQuery(dq);
	}

	/**
	 * CA de plusieurs terminaux sur une plage de dates (utile pour un concessionnaire).
	 */
	public List<ChiffreAffaires> findByTerminalIdsAndDateRange(
			List<Long> terminalIds, Date dateDebut, Date dateFin) {

		if ((terminalIds == null) || terminalIds.isEmpty()) {
			return java.util.Collections.emptyList();
		}

		DynamicQuery dq = dynamicQuery();

		dq.add(PropertyFactoryUtil.forName("terminalId").in(terminalIds));

		if (dateDebut != null) {
			dq.add(PropertyFactoryUtil.forName("date").ge(dateDebut));
		}
		if (dateFin != null) {
			dq.add(PropertyFactoryUtil.forName("date").le(dateFin));
		}

		return dynamicQuery(dq);
	}

}