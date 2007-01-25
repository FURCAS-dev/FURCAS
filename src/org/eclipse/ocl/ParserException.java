/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ParserException.java,v 1.1 2007/01/25 18:24:37 cdamus Exp $
 */

package org.eclipse.ocl;


/**
 * Exception indicating a failure to parse or validate OCL constraints.
 * 
 * @author Christian Vogt (cvogt)
 */
public class ParserException extends Exception {

	private static final long serialVersionUID = -4457105668114213310L;

	/**
	 * Initializes me with a user-friendly message describing the nature of
     * the parse failure.
	 * 
	 * @param msg the exception message
	 */
	public ParserException(String msg) {
		super(msg);
	}

    /**
     * Initializes me with a message and an exception that caused the parse
     * failure.
     * 
     * @param msg my user-friendly message
     * @param cause the cause of the parse failure
     */
	public ParserException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
