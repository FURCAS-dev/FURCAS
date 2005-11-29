/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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

/**
 * @author Edith Schonberg (edith)
 *
 * @model abstract="true"
 */
public interface ModelPropertyCallExp
	extends PropertyCallExp{
	/**
	 * Returns the value of the '<em><b>Marked Pre</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Marked Pre</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Marked Pre</em>' attribute.
	 * @see #setMarkedPre(boolean)
	 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getModelPropertyCallExp_MarkedPre()
	 *
	 * @generated
	 */
	boolean isMarkedPre();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.ModelPropertyCallExp#isMarkedPre <em>Marked Pre</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Marked Pre</em>' attribute.
	 * @see #isMarkedPre()
	 * @generated
	 */
	void setMarkedPre(boolean value);

}