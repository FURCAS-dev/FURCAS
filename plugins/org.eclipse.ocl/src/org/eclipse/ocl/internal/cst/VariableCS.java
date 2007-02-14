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
 * $Id: VariableCS.java,v 1.2 2007/02/14 14:46:03 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.VariableCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.VariableCS#getTypeCS <em>Type CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.VariableCS#getInitExpression <em>Init Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.internal.cst.CSTPackage#getVariableCS()
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
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getVariableCS_Name()
     * @model
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.VariableCS#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

	/**
     * Returns the value of the '<em><b>Type CS</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Type CS</em>' reference.
     * @see #setTypeCS(TypeCS)
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getVariableCS_TypeCS()
     * @model
     * @generated
     */
	TypeCS getTypeCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.VariableCS#getTypeCS <em>Type CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type CS</em>' reference.
     * @see #getTypeCS()
     * @generated
     */
	void setTypeCS(TypeCS value);

	/**
     * Returns the value of the '<em><b>Init Expression</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Init Expression</em>' reference.
     * @see #setInitExpression(OCLExpressionCS)
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getVariableCS_InitExpression()
     * @model
     * @generated
     */
	OCLExpressionCS getInitExpression();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.VariableCS#getInitExpression <em>Init Expression</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Init Expression</em>' reference.
     * @see #getInitExpression()
     * @generated
     */
	void setInitExpression(OCLExpressionCS value);

} // VariableDeclarationCS
