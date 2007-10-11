/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling 
 *
 * </copyright>
 *
 * $Id: SyntaxException.java,v 1.1 2007/10/11 23:05:04 cdamus Exp $
 */

package org.eclipse.ocl;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * Exception indicating a syntax error in parsing OCL expressions.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class SyntaxException
	extends ParserException {

   private static final long serialVersionUID = -2386296449957566297L;

	/**
     * Initializes me with a user-friendly message describing the nature of
     * the parse failure.
     * 
     * @param msg the exception message
     */
	public SyntaxException(String msg) {
		super(msg);
	}
	
    /**
     * Initializes me with a message and an exception that caused the parse
     * failure.
     * 
     * @param msg my user-friendly message
     * @param cause the cause of the parse failure
     */
	public SyntaxException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	/**
	 * Initializes me with a diagnostic obtained from a problem handler.
	 * 
	 * @param problem the diagnostic
	 * 
	 * @since 1.2
	 */
	public SyntaxException(Diagnostic problem) {
		super(problem);
	}
}
