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
 * $Id: PackageDeclarationCS.java,v 1.3 2007/04/30 12:38:59 cdamus Exp $
 */
package org.eclipse.ocl.internal.cst;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.internal.cst.PackageDeclarationCS#getPathNameCS <em>Path Name CS</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.PackageDeclarationCS#getContextDecls <em>Context Decls</em>}</li>
 *   <li>{@link org.eclipse.ocl.internal.cst.PackageDeclarationCS#getPackageDeclarationCS <em>Package Declaration CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.internal.cst.CSTPackage#getPackageDeclarationCS()
 * @model
 * @generated
 */
public interface PackageDeclarationCS extends CSTNode {
	/**
     * Returns the value of the '<em><b>Path Name CS</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Name CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Path Name CS</em>' containment reference.
     * @see #setPathNameCS(PathNameCS)
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getPackageDeclarationCS_PathNameCS()
     * @model containment="true"
     * @generated
     */
	PathNameCS getPathNameCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.PackageDeclarationCS#getPathNameCS <em>Path Name CS</em>}' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Path Name CS</em>' containment reference.
     * @see #getPathNameCS()
     * @generated
     */
	void setPathNameCS(PathNameCS value);

	/**
     * Returns the value of the '<em><b>Context Decls</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.ocl.internal.cst.ContextDeclCS}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Decls</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Context Decls</em>' containment reference list.
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getPackageDeclarationCS_ContextDecls()
     * @model type="org.eclipse.ocl.internal.cst.ContextDeclCS" containment="true"
     * @generated
     */
	EList<ContextDeclCS> getContextDecls();

	/**
     * Returns the value of the '<em><b>Package Declaration CS</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Declaration CS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Package Declaration CS</em>' reference.
     * @see #setPackageDeclarationCS(PackageDeclarationCS)
     * @see org.eclipse.ocl.internal.cst.CSTPackage#getPackageDeclarationCS_PackageDeclarationCS()
     * @model
     * @generated
     */
	PackageDeclarationCS getPackageDeclarationCS();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.internal.cst.PackageDeclarationCS#getPackageDeclarationCS <em>Package Declaration CS</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Package Declaration CS</em>' reference.
     * @see #getPackageDeclarationCS()
     * @generated
     */
	void setPackageDeclarationCS(PackageDeclarationCS value);

} // PackageDeclarationCS
