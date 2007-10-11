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
 * $Id: DefExpressionCS.java,v 1.1 2007/10/11 23:04:54 cdamus Exp $
 */
package org.eclipse.ocl.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Def Expression CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.DefExpressionCS#getOperationCS <em>Operation CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.DefExpressionCS#getVariableCS <em>Variable CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.DefExpressionCS#getExpressionCS <em>Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getDefExpressionCS()
 * @model
 * @generated
 */
public interface DefExpressionCS extends CSTNode {
	/**
     * Returns the value of the '<em><b>Operation CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Operation CS</em>' containment reference.
     * @see #setOperationCS(OperationCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getDefExpressionCS_OperationCS()
     * @model containment="true"
     * @generated
     */
	OperationCS getOperationCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.DefExpressionCS#getOperationCS <em>Operation CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation CS</em>' containment reference.
     * @see #getOperationCS()
     * @generated
     */
	void setOperationCS(OperationCS value);

	/**
     * Returns the value of the '<em><b>Variable CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Variable CS</em>' containment reference.
     * @see #setVariableCS(VariableCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getDefExpressionCS_VariableCS()
     * @model containment="true"
     * @generated
     */
	VariableCS getVariableCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.DefExpressionCS#getVariableCS <em>Variable CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Variable CS</em>' containment reference.
     * @see #getVariableCS()
     * @generated
     */
	void setVariableCS(VariableCS value);

	/**
     * Returns the value of the '<em><b>Expression CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Expression CS</em>' containment reference.
     * @see #setExpressionCS(OCLExpressionCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getDefExpressionCS_ExpressionCS()
     * @model containment="true"
     *        extendedMetaData="name='oclExpressionCS'"
     * @generated
     */
	OCLExpressionCS getExpressionCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.DefExpressionCS#getExpressionCS <em>Expression CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression CS</em>' containment reference.
     * @see #getExpressionCS()
     * @generated
     */
	void setExpressionCS(OCLExpressionCS value);

} // DefExpressionCS
