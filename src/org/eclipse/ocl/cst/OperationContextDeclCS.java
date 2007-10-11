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
 * $Id: OperationContextDeclCS.java,v 1.1 2007/10/11 23:04:54 cdamus Exp $
 */
package org.eclipse.ocl.cst;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.OperationContextDeclCS#getOperationCS <em>Operation CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.OperationContextDeclCS#getPrePostOrBodyDecls <em>Pre Post Or Body Decls</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getOperationContextDeclCS()
 * @model
 * @generated
 */
public interface OperationContextDeclCS extends ContextDeclCS {
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
     * @see org.eclipse.ocl.cst.CSTPackage#getOperationContextDeclCS_OperationCS()
     * @model containment="true"
     * @generated
     */
	OperationCS getOperationCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.cst.OperationContextDeclCS#getOperationCS <em>Operation CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Operation CS</em>' containment reference.
     * @see #getOperationCS()
     * @generated
     */
	void setOperationCS(OperationCS value);

	/**
     * Returns the value of the '<em><b>Pre Post Or Body Decls</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.ocl.cst.PrePostOrBodyDeclCS}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Post Or Body Decls</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Pre Post Or Body Decls</em>' containment reference list.
     * @see org.eclipse.ocl.cst.CSTPackage#getOperationContextDeclCS_PrePostOrBodyDecls()
     * @model containment="true" required="true"
     * @generated
     */
	EList<PrePostOrBodyDeclCS> getPrePostOrBodyDecls();

} // OperationContextDeclCS
