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
 * $Id: ParserException.java,v 1.2 2007/10/11 23:05:04 cdamus Exp $
 */

package org.eclipse.ocl;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.OCLStatusCodes;


/**
 * Exception indicating a failure to parse or validate OCL constraints.
 * Since the 1.2 release, the parser exception includes also a {@link Diagnostic}
 * carrying details of the one or more parse problems.
 * 
 * @author Christian Vogt (cvogt)
 */
public class ParserException extends Exception {

	private static final long serialVersionUID = -4457105668114213310L;

	private final Diagnostic diagnostic;
	
	/**
	 * Initializes me with a user-friendly message describing the nature of
     * the parse failure.
	 * 
	 * @param msg the exception message
	 */
	public ParserException(String msg) {
		super(msg);
		
		diagnostic = createDiagnostic(msg);
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
		
		diagnostic = createDiagnostic(msg);
	}
	
	/**
	 * Initializes me with a diagnostic obtained from a problem handler.
	 * 
	 * @param problem the diagnostic
	 * 
	 * @since 1.2
	 */
	public ParserException(Diagnostic problem) {
		super(problem.getMessage());
		
		this.diagnostic = problem;
	}
	
	/**
	 * Obtains the diagnostic describing one or more parse problems that I
	 * signal.
	 * 
	 * @return the diagnostic, which may be a chain of multiple problems or
	 * even just an "OK" diagnostic indicating an absence of parse problems
	 * 
	 * @since 1.2
	 */
	public Diagnostic getDiagnostic() {
		return diagnostic;
	}
	
	/**
	 * Creates a default diagnostic for construction of an exception with just
	 * a message.
	 * 
	 * @param message the message
	 * @return a diagnostic
	 */
	private Diagnostic createDiagnostic(String message) {
		return new BasicDiagnostic(Diagnostic.ERROR, OCLPlugin.getPluginId(),
			OCLStatusCodes.ERROR, message, null);
	}
}
