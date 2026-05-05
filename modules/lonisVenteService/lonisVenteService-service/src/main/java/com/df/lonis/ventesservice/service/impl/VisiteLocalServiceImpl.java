/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.impl;

import com.df.lonis.ventesservice.model.Visite;
import com.df.lonis.ventesservice.service.base.VisiteLocalServiceBaseImpl;

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
	property = "model.class.name=com.df.lonis.ventesservice.model.Visite",
	service = AopService.class
)
public class VisiteLocalServiceImpl extends VisiteLocalServiceBaseImpl {

	public List<Visite> findByTerminalId(long terminalId) {
		return visitePersistence.findByTerminalId(terminalId);
	}

	public List<Visite> findByTerminalId(
		long terminalId, int start, int end) {

		return visitePersistence.findByTerminalId(terminalId, start, end);
	}

	public int countByTerminalId(long terminalId) {
		return visitePersistence.countByTerminalId(terminalId);
	}

	public List<Visite> findByCommercialId(long commercialId) {
		return visitePersistence.findByCommercialId(commercialId);
	}

	public int countByCommercialId(long commercialId) {
		return visitePersistence.countByCommercialId(commercialId);
	}

	public int countByCommercialIdAndPeriode(
		long commercialId, String statut, Date debut, Date fin) {

		DynamicQuery dq = dynamicQuery();

		dq.add(
			PropertyFactoryUtil.forName("commercialId").eq(commercialId));

		if (statut != null) {
			dq.add(PropertyFactoryUtil.forName("statut").eq(statut));
		}
		if (debut != null) {
			dq.add(PropertyFactoryUtil.forName("dateVisite").ge(debut));
		}
		if (fin != null) {
			dq.add(PropertyFactoryUtil.forName("dateVisite").le(fin));
		}

		return (int)dynamicQueryCount(dq);
	}

	public List<Visite> findByCommercialIdAndPeriode(
		long commercialId, String statut, Date debut, Date fin) {

		DynamicQuery dq = dynamicQuery();

		dq.add(
			PropertyFactoryUtil.forName("commercialId").eq(commercialId));

		if (statut != null) {
			dq.add(PropertyFactoryUtil.forName("statut").eq(statut));
		}
		if (debut != null) {
			dq.add(PropertyFactoryUtil.forName("dateVisite").ge(debut));
		}
		if (fin != null) {
			dq.add(PropertyFactoryUtil.forName("dateVisite").le(fin));
		}

		return dynamicQuery(dq);
	}

}
