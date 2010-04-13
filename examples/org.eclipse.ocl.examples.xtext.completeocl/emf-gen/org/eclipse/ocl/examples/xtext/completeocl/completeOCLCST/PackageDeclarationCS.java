/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: PackageDeclarationCS.java,v 1.1 2010/04/13 06:38:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Declaration CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS#getContexts <em>Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getPackageDeclarationCS()
 * @model
 * @generated
 */
public interface PackageDeclarationCS extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' containment reference.
	 * @see #setName(PathNameCS)
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getPackageDeclarationCS_Name()
	 * @model containment="true"
	 * @generated
	 */
	PathNameCS getName();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PackageDeclarationCS#getName <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' containment reference.
	 * @see #getName()
	 * @generated
	 */
	void setName(PathNameCS value);

	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contexts</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getPackageDeclarationCS_Contexts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ContextDeclCS> getContexts();

} // PackageDeclarationCS
