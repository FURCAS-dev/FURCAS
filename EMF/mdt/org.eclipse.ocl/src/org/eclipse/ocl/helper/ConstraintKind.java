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
 * $Id: ConstraintKind.java,v 1.1 2007/01/25 18:24:38 cdamus Exp $
 */
package org.eclipse.ocl.helper;


/**
 * An enumeration of OCL constraint types, primarily for determining the
 * appropriate choices for syntax completion and for generic helper-based
 * parsing.
 *
 * @see OCLHelper#getSyntaxHelp(ConstraintKind, String)
 * @see OCLHelper#createConstraint(ConstraintKind, String)
 * 
 * @author Christian W. Damus (cdamus)
 */
public enum ConstraintKind {

	/**
     * Indicates an invariant constraint context.
     * This is also an appropriate value for syntax-completion of query
     * expressions.
     */
	INVARIANT,
	
	/** Indicates an operation precondition context. */
	PRECONDITION,

    /** Indicates an operation body condition context. */
	BODYCONDITION,

    /** Indicates an operation postcondition context. */
	POSTCONDITION,

    /** Indicates an attribute initial-value constraint context. */
    INITIAL,

    /** Indicates an attribute derived-value constraint context. */
    DERIVATION,

    /** Indicates an additional attribute operation definition context. */
    DEFINITION;

}