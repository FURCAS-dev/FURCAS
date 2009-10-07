/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.internal.index;

import org.eclipse.emf.query2.exception.LocalizedBaseRuntimeException;
import org.eclipse.emf.query2.exception.LocalizedString;

/**
 * 
 */
public class SpiFacilityQueryServiceException extends LocalizedBaseRuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Occurred error not further specified
	 */
	public static final int ERROR_CODE_UNSPECIFIED = 0;

	/**
	 * The result set of the query is too large.
	 */
	public static final int ERROR_CODE_RESULTSET_TOO_LARGE = 1;

	/**
	 * A query for all instances of Reflect::Element was fired with exclusive
	 * scope
	 */
	public static final int ERROR_CODE_REFLECT_ELEMENT = 2;

	private int errorCode;

	public SpiFacilityQueryServiceException(int errorCode, LocalizedString message, Object... args) {

		super(message, args);
		this.errorCode = errorCode;
	}

	public SpiFacilityQueryServiceException(Throwable cause, int errorCode, LocalizedString message, Object... args) {

		super(cause, message, args);
		this.errorCode = errorCode;
	}

	/**
	 * Gets the error code.
	 * 
	 * @return {@link #ERROR_CODE_REFLECT_ELEMENT},
	 *         {@link #ERROR_CODE_RESULTSET_TOO_LARGE} or
	 *         {@link #ERROR_CODE_UNSPECIFIED}
	 */
	public int getErrorCode() {

		return this.errorCode;
	}
}
