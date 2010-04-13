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
package org.eclipse.emf.query2;

import org.eclipse.emf.query2.exception.LocalizedBaseRuntimeException;
import org.eclipse.emf.query2.exception.LocalizedString;

/**
 * This exception is thrown when a result set is not handled properly. For
 * Example, if an attempt is made to fetch a row beyond the size of the result
 * set.
 */
public class QueryResultException extends LocalizedBaseRuntimeException {

	private static final long serialVersionUID = -2934371245271900771L;

	/**
	 * @param message
	 * @param args
	 */
	public QueryResultException(LocalizedString message, Object... args) {

		super(message, args);
	}

	/**
	 * @param rootCause
	 * @param message
	 * @param args
	 */
	public QueryResultException(Throwable rootCause, LocalizedString message, Object... args) {

		super(rootCause, message, args);
	}

}
