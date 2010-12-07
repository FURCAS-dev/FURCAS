/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 SAP AG and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Axel Uhl - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.ecore.utilities;

import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.utilities.OCLFactory;


/**
 * Adds the {@link #createOppositePropertyCallExp()} method to {@link OCLFactory} so that
 * existing factory implementations and in particular the UML factory implementation doesn't
 * need to know about {@link OppositePropertyCallExp}.
 * 
 * @author Axel Uhl
 * @since 3.1
 */
public interface OCLFactoryWithHiddenOpposite {
	/**
	 * Returns a new object of class '<em>Opposite Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * @since 3.1
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opposite Property Call Exp</em>'.
	 * @generated
	 */
	OppositePropertyCallExp createOppositePropertyCallExp();
}
