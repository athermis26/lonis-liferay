/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.impl;

import com.df.lonis.ventesservice.model.ConcessionnaireProduit;
import com.df.lonis.ventesservice.service.base.ConcessionnaireProduitLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.df.lonis.ventesservice.model.ConcessionnaireProduit",
	service = AopService.class
)
public class ConcessionnaireProduitLocalServiceImpl
	extends ConcessionnaireProduitLocalServiceBaseImpl {
	public List<ConcessionnaireProduit> findByConcessionnaireId(long concessionnaireId) {
		return concessionnaireProduitPersistence.findByConcessionnaireId(concessionnaireId);
	}
}