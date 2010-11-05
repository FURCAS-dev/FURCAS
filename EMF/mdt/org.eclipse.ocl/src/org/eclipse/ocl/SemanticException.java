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
 * $Id: SemanticException.java,v 1.2 2007/10/11 23:05:04 cdamus Exp $
 */

package org.eclipse.ocl;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * Exception indicating a semantic error in parsing or validating OCL
 * expressions.
 * 
 * @author Christian Vogt (cvogt)
 */
public class SemanticException
	extends ParserException {

	private static final long serialVersionUID = -7995837682564930748L;

    /**
     * Initializes me with a user-friendly message describing the nature of
     * the parse failure.
     * 
     * @param msg the exception message
     */
	public SemanticException(String msg) {
		super(msg);
	}
	
    /**
     * Initializes me with a message and an exception that caused the parse
     * failure.
     * 
     * @param msg my user-friendly message
     * @param cause the cause of the parse failure
     */
	public SemanticException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	/**
	 * Initializes me with a diagnostic obtained from a problem handler.
	 * 
	 * @param problem the diagnostic
	 * 
	 * @since 1.2
	 */
	public SemanticException(Diagnostic problem) {
		super(problem);
	}
}
