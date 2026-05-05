/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.df.lonis.ventesservice.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEvaluationException extends NoSuchModelException {

	public NoSuchEvaluationException() {
	}

	public NoSuchEvaluationException(String msg) {
		super(msg);
	}

	public NoSuchEvaluationException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchEvaluationException(Throwable throwable) {
		super(throwable);
	}

}