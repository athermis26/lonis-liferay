/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.df.lonis.ventesservice.service.impl;

import com.df.lonis.ventesservice.model.SiteCommercial;
import com.df.lonis.ventesservice.service.base.SiteCommercialLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.df.lonis.ventesservice.model.SiteCommercial",
	service = AopService.class
)
public class SiteCommercialLocalServiceImpl
	extends SiteCommercialLocalServiceBaseImpl {

	public List<SiteCommercial> findByCommercialId(long commercialId) {
		return siteCommercialPersistence.findByCommercialId(commercialId);
	}

	public List<SiteCommercial> findBySiteId(long siteId) {
		return siteCommercialPersistence.findBySiteId(siteId);
	}

	public SiteCommercial fetchByS_C(long siteId, long commercialId) {
		return siteCommercialPersistence.fetchByS_C(siteId, commercialId);
	}

}
