/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.utilities;

import org.eclipse.ocl.expressions.OppositePropertyCallExp;

/**
 * Adds the {@link #createOppositePropertyCallExp()} method to {@link OCLFactory} so that
 * existing factory implementations and in particular the UML factory implementation doesn't
 * need to know about {@link OppositePropertyCallExp}.
 * 
 * @author Axel Uhl
 * @since 3.1
 */
public interface OCLFactoryWithHiddenOpposite extends OCLFactory {
	/**
	 * Returns a new object of class '<em>Opposite Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * @since 3.1
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Opposite Property Call Exp</em>'.
	 * @generated
	 */
	<C, P> OppositePropertyCallExp<C, P> createOppositePropertyCallExp();
}
