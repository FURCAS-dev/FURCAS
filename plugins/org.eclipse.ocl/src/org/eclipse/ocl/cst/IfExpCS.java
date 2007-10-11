/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: IfExpCS.java,v 1.1 2007/10/11 23:04:54 cdamus Exp $
 */
package org.eclipse.ocl.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.IfExpCS#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.IfExpCS#getElseExpression <em>Else Expression</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.IfExpCS#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getIfExpCS()
 * @model
 * @generated
 */
public interface IfExpCS extends OCLExpressionCS {
	/**
     * Returns the value of the '<em><b>Then Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Then Expression</em>' containment reference.
     * @see #setThenExpression(OCLExpressionCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getIfExpCS_ThenExpression()
     * @model containment="true" required="true"
     * @generated
     */
	OCLExpressionCS getThenExpression();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.IfExpCS#getThenExpression <em>Then Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Then Expression</em>' containment reference.
     * @see #getThenExpression()
     * @generated
     */
	void setThenExpression(OCLExpressionCS value);

	/**
     * Returns the value of the '<em><b>Else Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Else Expression</em>' containment reference.
     * @see #setElseExpression(OCLExpressionCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getIfExpCS_ElseExpression()
     * @model containment="true" required="true"
     * @generated
     */
	OCLExpressionCS getElseExpression();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.IfExpCS#getElseExpression <em>Else Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Else Expression</em>' containment reference.
     * @see #getElseExpression()
     * @generated
     */
	void setElseExpression(OCLExpressionCS value);

	/**
     * Returns the value of the '<em><b>Condition</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Condition</em>' containment reference.
     * @see #setCondition(OCLExpressionCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getIfExpCS_Condition()
     * @model containment="true" required="true"
     * @generated
     */
	OCLExpressionCS getCondition();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.IfExpCS#getCondition <em>Condition</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Condition</em>' containment reference.
     * @see #getCondition()
     * @generated
     */
	void setCondition(OCLExpressionCS value);

} // IfExpCS
