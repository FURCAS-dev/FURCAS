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
 * $Id: ClassifierContextDeclCS.java,v 1.2 2007/02/14 14:46:02 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.ClassifierContextDeclCS#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.ClassifierContextDeclCS#getInvOrDefCS <em>Inv Or Def CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.internal.cst.CSTPackage#getClassifierContextDeclCS()
 * @model
 * @generated
 */
public interface ClassifierContextDeclCS extends ContextDeclCS {
	/**
     * Returns the value of the '<em><b>Path Name CS</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Path Name CS</em>' reference.
     * @see #setPathNameCS(PathNameCS)
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getClassifierContextDeclCS_PathNameCS()
     * @model
     * @generated
     */
	PathNameCS getPathNameCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.ClassifierContextDeclCS#getPathNameCS <em>Path Name CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Path Name CS</em>' reference.
     * @see #getPathNameCS()
     * @generated
     */
	void setPathNameCS(PathNameCS value);

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
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getClassifierContextDeclCS_InvOrDefCS()
     * @model
     * @generated
     */
	InvOrDefCS getInvOrDefCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.ClassifierContextDeclCS#getInvOrDefCS <em>Inv Or Def CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inv Or Def CS</em>' reference.
     * @see #getInvOrDefCS()
     * @generated
     */
	void setInvOrDefCS(InvOrDefCS value);

} // ClassifierContextDeclCS
