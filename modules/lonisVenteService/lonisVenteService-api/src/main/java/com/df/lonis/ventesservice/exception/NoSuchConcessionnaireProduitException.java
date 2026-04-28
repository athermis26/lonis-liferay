/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.df.lonis.ventesservice.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchConcessionnaireProduitException extends NoSuchModelException {

	public NoSuchConcessionnaireProduitException() {
	}

	public NoSuchConcessionnaireProduitException(String msg) {
		super(msg);
	}

	public NoSuchConcessionnaireProduitException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchConcessionnaireProduitException(Throwable throwable) {
		super(throwable);
	}

}