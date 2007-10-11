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
 * $Id: CallExpCS.java,v 1.1 2007/10/11 23:04:54 cdamus Exp $
 */
package org.eclipse.ocl.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.CallExpCS#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.CallExpCS#getAccessor <em>Accessor</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.CallExpCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getCallExpCS()
 * @model
 * @generated
 */
public interface CallExpCS extends OCLExpressionCS {
	/**
     * Returns the value of the '<em><b>Source</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' containment reference.
     * @see #setSource(OCLExpressionCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getCallExpCS_Source()
     * @model containment="true"
     * @generated
     */
	OCLExpressionCS getSource();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.CallExpCS#getSource <em>Source</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' containment reference.
     * @see #getSource()
     * @generated
     */
	void setSource(OCLExpressionCS value);

	/**
     * Returns the value of the '<em><b>Accessor</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.ocl.cst.DotOrArrowEnum}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accessor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Accessor</em>' attribute.
     * @see org.eclipse.ocl.cst.DotOrArrowEnum
     * @see #setAccessor(DotOrArrowEnum)
     * @see org.eclipse.ocl.cst.CSTPackage#getCallExpCS_Accessor()
     * @model
     * @generated
     */
	DotOrArrowEnum getAccessor();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.CallExpCS#getAccessor <em>Accessor</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Accessor</em>' attribute.
     * @see org.eclipse.ocl.cst.DotOrArrowEnum
     * @see #getAccessor()
     * @generated
     */
	void setAccessor(DotOrArrowEnum value);

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
     * @see org.eclipse.ocl.cst.CSTPackage#getCallExpCS_SimpleNameCS()
     * @model containment="true"
     * @generated
     */
	SimpleNameCS getSimpleNameCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.CallExpCS#getSimpleNameCS <em>Simple Name CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Simple Name CS</em>' containment reference.
     * @see #getSimpleNameCS()
     * @generated
     */
	void setSimpleNameCS(SimpleNameCS value);

} // CallExpCS
