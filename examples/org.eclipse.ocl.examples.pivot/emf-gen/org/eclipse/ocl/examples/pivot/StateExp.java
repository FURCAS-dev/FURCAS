/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: StateExp.java,v 1.2 2011/01/24 20:42:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.StateExp#getReferredState <em>Referred State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStateExp()
 * @model
 * @generated
 */
public interface StateExp
		extends OclExpression {

	/**
	 * Returns the value of the '<em><b>Referred State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred State</em>' reference.
	 * @see #setReferredState(State)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getStateExp_ReferredState()
	 * @model ordered="false"
	 * @generated
	 */
	State getReferredState();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.StateExp#getReferredState <em>Referred State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred State</em>' reference.
	 * @see #getReferredState()
	 * @generated
	 */
	void setReferredState(State value);

} // StateExp
