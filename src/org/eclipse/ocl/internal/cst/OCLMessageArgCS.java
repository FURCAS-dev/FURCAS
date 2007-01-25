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
 * $Id: OCLMessageArgCS.java,v 1.1 2007/01/25 18:24:34 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OCL Message Arg CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.OCLMessageArgCS#getTypeCS <em>Type CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.OCLMessageArgCS#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.internal.cst.CSTPackage#getOCLMessageArgCS()
 * @model extendedMetaData="name='OclMessageArgCS'"
 * @generated
 */
public interface OCLMessageArgCS extends CSTNode {
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
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getOCLMessageArgCS_TypeCS()
     * @model
     * @generated
     */
	TypeCS getTypeCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.OCLMessageArgCS#getTypeCS <em>Type CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Type CS</em>' reference.
     * @see #getTypeCS()
     * @generated
     */
	void setTypeCS(TypeCS value);

	/**
     * Returns the value of the '<em><b>Expression</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Expression</em>' reference.
     * @see #setExpression(OCLExpressionCS)
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getOCLMessageArgCS_Expression()
     * @model extendedMetaData="name='oclExpression'"
     * @generated
     */
	OCLExpressionCS getExpression();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.OCLMessageArgCS#getExpression <em>Expression</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression</em>' reference.
     * @see #getExpression()
     * @generated
     */
	void setExpression(OCLExpressionCS value);

} // OCLMessageArgCS
