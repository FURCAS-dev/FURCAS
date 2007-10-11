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
 * @deprecated Use the {@link org.eclipse.ocl.expressions.LoopExp} interface,
 * instead.
 * 
 * @author Edith Schonberg (edith)
 */
@Deprecated
public interface LoopExp  extends CallExp {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * @model containment="true"
	 */
    public OCLExpression getBody();


	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.LoopExp#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>Iterator</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ocl.expressions.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator</em>' containment reference list.
	 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getLoopExp_Iterator()
	 * @model type="org.eclipse.emf.ocl.expressions.Variable" containment="true"
	 * @generated
	 */
	EList getIterator();

}
