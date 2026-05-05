/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.impl;

import com.df.lonis.ventesservice.model.Objectif;
import com.df.lonis.ventesservice.service.base.ObjectifLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.df.lonis.ventesservice.model.Objectif",
	service = AopService.class
)
public class ObjectifLocalServiceImpl extends ObjectifLocalServiceBaseImpl {

	public List<Objectif> findByCommercialId(long commercialId) {
		return objectifPersistence.findByCommercialId(commercialId);
	}

	public List<Objectif> findByC_A(long commercialId, int annee) {
		return objectifPersistence.findByC_A(commercialId, annee);
	}

	public Objectif fetchByC_A_M(long commercialId, int annee, int mois) {
		return objectifPersistence.fetchByC_A_M(commercialId, annee, mois);
	}

}
