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
 * Exception is thrown when the formulated query requires unsupported
 * functionality.
 */
public class QueryNotSupportedException extends LocalizedBaseRuntimeException {

	private static final long serialVersionUID = 5538595882536186923L;

	/**
	 * Instantiates a new MQL not supported exception.
	 * 
	 * @param message
	 * @param args
	 */
	public QueryNotSupportedException(LocalizedString message, Object... args) {

		super(message, args);
	}
}
