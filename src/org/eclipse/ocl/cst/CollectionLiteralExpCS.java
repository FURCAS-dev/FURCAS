/**
 * <copyright>
 * 
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 243976
 *
 * </copyright>
 *
 * $Id: CollectionLiteralExpCS.java,v 1.3 2008/11/30 22:11:38 cdamus Exp $
 */
package org.eclipse.ocl.cst;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.CollectionLiteralExpCS#getCollectionType <em>Collection Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.CollectionLiteralExpCS#getCollectionLiteralParts <em>Collection Literal Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getCollectionLiteralExpCS()
 * @model
 * @generated
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
public interface CollectionLiteralExpCS
		extends LiteralExpCS {

	/**
	 * Returns the value of the '<em><b>Collection Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.ocl.cst.CollectionTypeIdentifierEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Type</em>' attribute.
	 * @see org.eclipse.ocl.cst.CollectionTypeIdentifierEnum
	 * @see #setCollectionType(CollectionTypeIdentifierEnum)
	 * @see org.eclipse.ocl.cst.CSTPackage#getCollectionLiteralExpCS_CollectionType()
	 * @model
	 * @generated
	 */
	CollectionTypeIdentifierEnum getCollectionType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.cst.CollectionLiteralExpCS#getCollectionType <em>Collection Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Type</em>' attribute.
	 * @see org.eclipse.ocl.cst.CollectionTypeIdentifierEnum
	 * @see #getCollectionType()
	 * @generated
	 */
	void setCollectionType(CollectionTypeIdentifierEnum value);

	/**
	 * Returns the value of the '<em><b>Collection Literal Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.cst.CollectionLiteralPartCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Literal Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Literal Parts</em>' containment reference list.
	 * @see org.eclipse.ocl.cst.CSTPackage#getCollectionLiteralExpCS_CollectionLiteralParts()
	 * @model containment="true"
	 * @generated
	 */
	EList<CollectionLiteralPartCS> getCollectionLiteralParts();

} // CollectionLiteralExpCS
