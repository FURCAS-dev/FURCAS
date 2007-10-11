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
 * $Id: InvOrDefCS.java,v 1.1 2007/10/11 23:04:54 cdamus Exp $
 */
package org.eclipse.ocl.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inv Or Def CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.InvOrDefCS#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.InvOrDefCS#getInvOrDefCS <em>Inv Or Def CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getInvOrDefCS()
 * @model abstract="true"
 * @generated
 */
public interface InvOrDefCS extends CSTNode {
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
     * @see org.eclipse.ocl.cst.CSTPackage#getInvOrDefCS_SimpleNameCS()
     * @model containment="true"
     * @generated
     */
	SimpleNameCS getSimpleNameCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.InvOrDefCS#getSimpleNameCS <em>Simple Name CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Simple Name CS</em>' containment reference.
     * @see #getSimpleNameCS()
     * @generated
     */
	void setSimpleNameCS(SimpleNameCS value);

	/**
     * Returns the value of the '<em><b>Inv Or Def CS</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inv Or Def CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Inv Or Def CS</em>' reference.
     * @see #setInvOrDefCS(InvOrDefCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getInvOrDefCS_InvOrDefCS()
     * @model
     * @generated
     */
	InvOrDefCS getInvOrDefCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.InvOrDefCS#getInvOrDefCS <em>Inv Or Def CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inv Or Def CS</em>' reference.
     * @see #getInvOrDefCS()
     * @generated
     */
	void setInvOrDefCS(InvOrDefCS value);

} // InvOrDefCS
