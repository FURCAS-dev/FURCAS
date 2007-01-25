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
 * $Id: DefCS.java,v 1.1 2007/01/25 18:24:34 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Def CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.DefCS#getDefExpressionCS <em>Def Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.internal.cst.CSTPackage#getDefCS()
 * @model
 * @generated
 */
public interface DefCS extends InvOrDefCS {
	/**
     * Returns the value of the '<em><b>Def Expression CS</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Def Expression CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Def Expression CS</em>' reference.
     * @see #setDefExpressionCS(DefExpressionCS)
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getDefCS_DefExpressionCS()
     * @model
     * @generated
     */
	DefExpressionCS getDefExpressionCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.DefCS#getDefExpressionCS <em>Def Expression CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Def Expression CS</em>' reference.
     * @see #getDefExpressionCS()
     * @generated
     */
	void setDefExpressionCS(DefExpressionCS value);

} // DefCS
