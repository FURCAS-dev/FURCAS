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
 * This exception may occur during query execution, for instance, when the
 * requested data is larger than the provided threshold. It also wraps
 * exceptions from the facility-dependent query implementation. This exception
 * should not occur under normal operation.
 */
public class QueryExecutionException extends LocalizedBaseRuntimeException {

	private static final long serialVersionUID = -1196470979072864388L;

	/**
	 * @param rootCause
	 * @param message
	 * @param args
	 */
	public QueryExecutionException(Throwable rootCause, LocalizedString message, Object... args) {

		super(rootCause, message, args);
	}

	/**
	 * Instantiates a new mQL execution exception.
	 * 
	 * @param message
	 *            the message
	 * @param args
	 */
	public QueryExecutionException(LocalizedString message, Object... args) {

		super(message, args);
	}
}
