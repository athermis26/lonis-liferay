/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.df.lonis.ventesservice.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchChiffreAffairesException extends NoSuchModelException {

	public NoSuchChiffreAffairesException() {
	}

	public NoSuchChiffreAffairesException(String msg) {
		super(msg);
	}

	public NoSuchChiffreAffairesException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchChiffreAffairesException(Throwable throwable) {
		super(throwable);
	}

}