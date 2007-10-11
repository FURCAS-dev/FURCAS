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
 * $Id: LoopExpCS.java,v 1.1 2007/10/11 23:04:55 cdamus Exp $
 */
package org.eclipse.ocl.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.LoopExpCS#getVariable1 <em>Variable1</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.LoopExpCS#getVariable2 <em>Variable2</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.LoopExpCS#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getLoopExpCS()
 * @model
 * @generated
 */
public interface LoopExpCS extends CallExpCS {
	/**
     * Returns the value of the '<em><b>Variable1</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Variable1</em>' containment reference.
     * @see #setVariable1(VariableCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getLoopExpCS_Variable1()
     * @model containment="true"
     * @generated
     */
	VariableCS getVariable1();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.LoopExpCS#getVariable1 <em>Variable1</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Variable1</em>' containment reference.
     * @see #getVariable1()
     * @generated
     */
	void setVariable1(VariableCS value);

	/**
     * Returns the value of the '<em><b>Variable2</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Variable2</em>' containment reference.
     * @see #setVariable2(VariableCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getLoopExpCS_Variable2()
     * @model containment="true"
     * @generated
     */
	VariableCS getVariable2();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.LoopExpCS#getVariable2 <em>Variable2</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Variable2</em>' containment reference.
     * @see #getVariable2()
     * @generated
     */
	void setVariable2(VariableCS value);

	/**
     * Returns the value of the '<em><b>Body</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Body</em>' containment reference.
     * @see #setBody(OCLExpressionCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getLoopExpCS_Body()
     * @model containment="true"
     * @generated
     */
	OCLExpressionCS getBody();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.LoopExpCS#getBody <em>Body</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Body</em>' containment reference.
     * @see #getBody()
     * @generated
     */
	void setBody(OCLExpressionCS value);

} // LoopExpCS
