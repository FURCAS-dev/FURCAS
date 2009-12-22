/**
 * <copyright>
 *
 * Copyright (c) 2008 Zeligsoft Inc. and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Zeligsoft - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: OCLDocumentCS.java,v 1.2 2009/12/22 18:42:30 ewillink Exp $
 */
package org.eclipse.ocl.cst;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OCL Document CS</b></em>'.
 * @since 1.3
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.OCLDocumentCS#getPackageDeclarations <em>Package Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getOCLDocumentCS()
 * @model
 * @generated
 */
public interface OCLDocumentCS
		extends CSTNode {

	/**
	 * Returns the value of the '<em><b>Package Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.cst.PackageDeclarationCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Declarations</em>' containment reference list.
	 * @see org.eclipse.ocl.cst.CSTPackage#getOCLDocumentCS_PackageDeclarations()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PackageDeclarationCS> getPackageDeclarations();

} // OCLDocumentCS
