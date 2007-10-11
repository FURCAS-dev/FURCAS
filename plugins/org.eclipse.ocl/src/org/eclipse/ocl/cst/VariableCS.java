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
 * $Id: VariableCS.java,v 1.1 2007/10/11 23:04:54 cdamus Exp $
 */
package org.eclipse.ocl.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.VariableCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.VariableCS#getTypeCS <em>Type CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.VariableCS#getInitExpression <em>Init Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getVariableCS()
 * @model
 * @generated
 */
public interface VariableCS extends CSTNode {
	/**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.ocl.cst.CSTPackage#getVariableCS_Name()
     * @model
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.VariableCS#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

	/**
     * Returns the value of the '<em><b>Type CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type CS</em>' containment reference.
     * @see #setTypeCS(TypeCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getVariableCS_TypeCS()
     * @model containment="true"
     * @generated
     */
	TypeCS getTypeCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.VariableCS#getTypeCS <em>Type CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type CS</em>' containment reference.
     * @see #getTypeCS()
     * @generated
     */
	void setTypeCS(TypeCS value);

	/**
     * Returns the value of the '<em><b>Init Expression</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Init Expression</em>' containment reference.
     * @see #setInitExpression(OCLExpressionCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getVariableCS_InitExpression()
     * @model containment="true"
     * @generated
     */
	OCLExpressionCS getInitExpression();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.VariableCS#getInitExpression <em>Init Expression</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Init Expression</em>' containment reference.
     * @see #getInitExpression()
     * @generated
     */
	void setInitExpression(OCLExpressionCS value);

} // VariableCS
