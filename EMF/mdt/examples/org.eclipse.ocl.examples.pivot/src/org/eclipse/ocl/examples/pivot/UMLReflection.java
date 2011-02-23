/**
 * <copyright>
 *
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *	 E.D.Willink Bug 298128
 *
 * </copyright>
 *
 * $Id: UMLReflection.java,v 1.3 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;


/**
 * An interface providing reflection service for the metaclasses that the
 * OCL borrows from UML.
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this interface. 
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface UMLReflection {

    /**
     * Stereotype applied to classifier invariant constraints.
     * 
     * @see #getStereotype
     */
    String INVARIANT = "invariant"; //$NON-NLS-1$

    /**
     * Stereotype applied to operation precondition constraints.
     * 
     * @see #getStereotype
     */
    String PRECONDITION = "precondition"; //$NON-NLS-1$

    /**
     * Stereotype applied to operation postcondition constraints.
     * 
     * @see #getStereotype
     */
    String POSTCONDITION = "postcondition"; //$NON-NLS-1$

    /**
     * Stereotype applied to operation body conditions.
     * 
     * @see #getStereotype
     */
    String BODY = "body"; //$NON-NLS-1$

    /**
     * Stereotype applied definition expressions.
     * 
     * @see #getStereotype
     */
    String DEFINITION = "definition"; //$NON-NLS-1$

    /**
     * Stereotype applied initial value expressions.
     * 
     * @see #getStereotype
     */
    String INITIAL = "initial"; //$NON-NLS-1$

    /**
     * Stereotype applied derived value expressions.
     * 
     * @see #getStereotype
     */
    String DERIVATION = "derivation"; //$NON-NLS-1$
}
