/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: StateExp.java,v 1.4 2007/10/11 23:05:03 cdamus Exp $
 */
package org.eclipse.ocl.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.StateExp#getReferredState <em>Referred State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getStateExp()
 * @model
 * @generated
 */
public interface StateExp<C, S> extends OCLExpression<C> {
	/**
     * Returns the value of the '<em><b>Referred State</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Referred State</em>' reference.
     * @see #setReferredState(Object)
     * @see org.eclipse.ocl.expressions.ExpressionsPackage#getStateExp_ReferredState()
     * @model kind="reference"
     * @generated
     */
	S getReferredState();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.expressions.StateExp#getReferredState <em>Referred State</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Referred State</em>' reference.
     * @see #getReferredState()
     * @generated
     */
	void setReferredState(S value);

} // StateExp
