/**
 * <copyright>
 *
 * Copyright (c) 2009 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *
 * </copyright>
 *
 * $Id: EvaluationHaltedException.java,v 1.2 2010/04/08 06:26:42 ewillink Exp $
 */
package org.eclipse.ocl;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ocl.internal.OCLPlugin;
import org.eclipse.ocl.internal.OCLStatusCodes;

/**
 * Exception indicating a managed interruption of evaluation.
 * <p>
 * Other languages that extend OCL may need to stop evaluation at any point. This
 * can be done at expression level granularity by throwing this exception during
 * evaluation. The evaluation visitor and other participants recognizes this
 * exception as a protocol for interrupting its execution and ensure its
 * propagated to the top level caller.
 * </p>
 * <p>
 * A diagnostic object can be attached, so arbitrary information about the
 * current execution context can be carried.
 * </p>
 * 
 * @author radvorak
 * @since 1.3
 */
public class EvaluationHaltedException
		extends RuntimeException {

	private static final long serialVersionUID = -7375617635204485747L;

	private Diagnostic diagnostic;

	/**
	 * Initializes me with a message describing the nature of stopping
	 * evaluation.
	 * 
	 * @param message
	 *            the message text
	 * 
	 */
	public EvaluationHaltedException(String message) {
		this(new BasicDiagnostic(Diagnostic.CANCEL, OCLPlugin.getPluginId(),
			OCLStatusCodes.EVALUATION_HALTED, message, null));
	}

	/**
	 * Initializes me with a diagnostic describing the nature of stopping
	 * evaluation.
	 * 
	 * @param diagnostic
	 *            non-null diagnostic object
	 * 
	 */
	public EvaluationHaltedException(Diagnostic diagnostic) {
		super(diagnostic.getMessage());
		this.diagnostic = diagnostic;
	}

	/**
	 * Initializes me with a message and diagnostic describing the nature of
	 * stopping evaluation.
	 * 
	 * @param message
	 *            a user-friendly message
	 * @param cause
	 *            the cause of the evaluation failure
	 */
	public EvaluationHaltedException(String message, Throwable cause) {
		super(message, cause);
		diagnostic = new BasicDiagnostic(Diagnostic.ERROR, OCLPlugin
			.getPluginId(), OCLStatusCodes.EVALUATION_HALTED, message,
			new Object[]{cause});
	}

	/**
	 * Obtains the diagnostic providing further information about this
	 * exception.
	 * 
	 * @return the diagnostic object
	 */
	public Diagnostic getDiagnostic() {
		return diagnostic;
	}
}
