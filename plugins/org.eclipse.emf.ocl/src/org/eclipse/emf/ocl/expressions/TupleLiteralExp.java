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
 * $Id$
 */

package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * @deprecated Use the {@link org.eclipse.ocl.expressions.TupleLiteralExp} interface,
 * instead.
 * 
 * @author Edith Schonberg (edith)
 */
public interface TupleLiteralExp extends LiteralExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ocl.expressions.TupleLiteralPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getTupleLiteralExp_Part()
	 * @model type="org.eclipse.emf.ocl.expressions.TupleLiteralPart" containment="true"
	 * @generated
	 */
	EList getPart();

}