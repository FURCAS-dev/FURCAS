/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.expressions;


/**
 * author edith
 */

/**
 * @model
 */
public interface IfExp extends OclExpression{
	/**
	 * @model containment="true"
	 */
	public OclExpression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.IfExp#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(OclExpression value);

	/**
	 * @model containment="true"
	 */
	public OclExpression getThenExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.IfExp#getThenExpression <em>Then Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Expression</em>' containment reference.
	 * @see #getThenExpression()
	 * @generated
	 */
	void setThenExpression(OclExpression value);

	/**
	 * @model containment="true"
	 */
	public OclExpression getElseExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.IfExp#getElseExpression <em>Else Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Expression</em>' containment reference.
	 * @see #getElseExpression()
	 * @generated
	 */
	void setElseExpression(OclExpression value);

}
