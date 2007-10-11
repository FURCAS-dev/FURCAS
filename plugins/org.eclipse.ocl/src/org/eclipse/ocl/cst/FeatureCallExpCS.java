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
 * $Id: FeatureCallExpCS.java,v 1.1 2007/10/11 23:04:54 cdamus Exp $
 */
package org.eclipse.ocl.cst;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.FeatureCallExpCS#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.FeatureCallExpCS#getIsMarkedPreCS <em>Is Marked Pre CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getFeatureCallExpCS()
 * @model
 * @generated
 */
public interface FeatureCallExpCS extends CallExpCS {
	/**
     * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.ocl.cst.OCLExpressionCS}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Arguments</em>' containment reference list.
     * @see org.eclipse.ocl.cst.CSTPackage#getFeatureCallExpCS_Arguments()
     * @model containment="true"
     * @generated
     */
	EList<OCLExpressionCS> getArguments();

	/**
     * Returns the value of the '<em><b>Is Marked Pre CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Marked Pre CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Is Marked Pre CS</em>' containment reference.
     * @see #setIsMarkedPreCS(IsMarkedPreCS)
     * @see org.eclipse.ocl.cst.CSTPackage#getFeatureCallExpCS_IsMarkedPreCS()
     * @model containment="true"
     * @generated
     */
	IsMarkedPreCS getIsMarkedPreCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.FeatureCallExpCS#getIsMarkedPreCS <em>Is Marked Pre CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Is Marked Pre CS</em>' containment reference.
     * @see #getIsMarkedPreCS()
     * @generated
     */
	void setIsMarkedPreCS(IsMarkedPreCS value);

} // FeatureCallExpCS
