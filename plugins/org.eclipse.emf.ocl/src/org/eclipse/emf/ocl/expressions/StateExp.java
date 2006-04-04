/**
 * <copyright>
 *
 * Copyright (c) 2006 IBM Corporation and others.
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
 * $Id: StateExp.java,v 1.1 2006/04/04 18:09:06 cdamus Exp $
 */
package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.StateExp#getReferredState <em>Referred State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getStateExp()
 * @model
 * @generated
 */
public interface StateExp extends OCLExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Referred State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred State</em>' reference.
	 * @see #setReferredState(EObject)
	 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getStateExp_ReferredState()
	 * @model
	 * @generated
	 */
	EObject getReferredState();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.StateExp#getReferredState <em>Referred State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred State</em>' reference.
	 * @see #getReferredState()
	 * @generated
	 */
	void setReferredState(EObject value);

} // StateExp
