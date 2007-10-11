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
 * $Id: PrePostOrBodyDeclCS.java,v 1.1 2007/10/11 23:04:54 cdamus Exp $
 */
package org.eclipse.ocl.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pre Post Or Body Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.PrePostOrBodyDeclCS#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.PrePostOrBodyDeclCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.PrePostOrBodyDeclCS#getExpressionCS <em>Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getPrePostOrBodyDeclCS()
 * @model
 * @generated
 */
public interface PrePostOrBodyDeclCS extends CSTNode {
	/**
     * Returns the value of the '<em><b>Kind</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.ocl.cst.PrePostOrBodyEnum}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Kind</em>' attribute.
     * @see org.eclipse.ocl.cst.PrePostOrBodyEnum
     * @see #setKind(PrePostOrBodyEnum)
     * @see org.eclipse.ocl.cst.CSTPackage#getPrePostOrBodyDeclCS_Kind()
     * @model
     * @generated
     */
	PrePostOrBodyEnum getKind();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.PrePostOrBodyDeclCS#getKind <em>Kind</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Kind</em>' attribute.
     * @see org.eclipse.ocl.cst.PrePostOrBodyEnum
     * @see #getKind()
     * @generated
     */
	void setKind(PrePostOrBodyEnum value);

	/**
     * Returns the value of the '<em><b>Simple Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Simple Name CS</em>' containment reference.
     * @see #setSimpleNameCS(SimpleNameCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getPrePostOrBodyDeclCS_SimpleNameCS()
     * @model containment="true"
     * @generated
     */
	SimpleNameCS getSimpleNameCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.PrePostOrBodyDeclCS#getSimpleNameCS <em>Simple Name CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Simple Name CS</em>' containment reference.
     * @see #getSimpleNameCS()
     * @generated
     */
	void setSimpleNameCS(SimpleNameCS value);

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
     * @see org.eclipse.ocl.cst.CSTPackage#getPrePostOrBodyDeclCS_ExpressionCS()
     * @model containment="true"
     *        extendedMetaData="name='oclExpressionCS'"
     * @generated
     */
	OCLExpressionCS getExpressionCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.PrePostOrBodyDeclCS#getExpressionCS <em>Expression CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Expression CS</em>' containment reference.
     * @see #getExpressionCS()
     * @generated
     */
	void setExpressionCS(OCLExpressionCS value);

} // PrePostOrBodyDeclCS
