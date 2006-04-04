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
 * $Id: PackageDeclarationCS.java,v 1.1 2006/04/04 18:09:03 cdamus Exp $
 */
package org.eclipse.emf.ocl.internal.cst;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.PackageDeclarationCS#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.emf.ocl.internal.cst.PackageDeclarationCS#getContextDecls <em>Context Decls</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getPackageDeclarationCS()
 * @model
 * @generated
 */
public interface PackageDeclarationCS extends CSTNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

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
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getPackageDeclarationCS_PathNameCS()
	 * @model
	 * @generated
	 */
	PathNameCS getPathNameCS();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.internal.cst.PackageDeclarationCS#getPathNameCS <em>Path Name CS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Name CS</em>' reference.
	 * @see #getPathNameCS()
	 * @generated
	 */
	void setPathNameCS(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Context Decls</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ocl.internal.cst.ContextDeclCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Decls</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Decls</em>' reference list.
	 * @see org.eclipse.emf.ocl.internal.cst.CSTPackage#getPackageDeclarationCS_ContextDecls()
	 * @model type="org.eclipse.emf.ocl.internal.cst.ContextDeclCS"
	 * @generated
	 */
	EList getContextDecls();

} // PackageDeclarationCS
