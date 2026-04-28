/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.df.lonis.ventesservice.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchProduitException extends NoSuchModelException {

	public NoSuchProduitException() {
	}

	public NoSuchProduitException(String msg) {
		super(msg);
	}

	public NoSuchProduitException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchProduitException(Throwable throwable) {
		super(throwable);
	}

}