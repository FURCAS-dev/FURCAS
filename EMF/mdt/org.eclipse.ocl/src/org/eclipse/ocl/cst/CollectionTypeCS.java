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
 * $Id: CollectionTypeCS.java,v 1.5 2009/12/22 18:42:30 ewillink Exp $
 */
package org.eclipse.ocl.cst;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.cst.CollectionTypeCS#getCollectionTypeIdentifier <em>Collection Type Identifier</em>}</li>
 *   <li>{@link org.eclipse.ocl.cst.CollectionTypeCS#getTypeCS <em>Type CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.cst.CSTPackage#getCollectionTypeCS()
 * @model
 * @generated
 */
public interface CollectionTypeCS
		extends SimpleNameCS, TypeCS {

	/**
	 * Returns the value of the '<em><b>Collection Type Identifier</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.ocl.cst.CollectionTypeIdentifierEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Type Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Type Identifier</em>' attribute.
	 * @see org.eclipse.ocl.cst.CollectionTypeIdentifierEnum
	 * @see #setCollectionTypeIdentifier(CollectionTypeIdentifierEnum)
	 * @see org.eclipse.ocl.cst.CSTPackage#getCollectionTypeCS_CollectionTypeIdentifier()
	 * @model
	 * @generated
	 */
	CollectionTypeIdentifierEnum getCollectionTypeIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.cst.CollectionTypeCS#getCollectionTypeIdentifier <em>Collection Type Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Type Identifier</em>' attribute.
	 * @see org.eclipse.ocl.cst.CollectionTypeIdentifierEnum
	 * @see #getCollectionTypeIdentifier()
	 * @generated
	 */
	void setCollectionTypeIdentifier(CollectionTypeIdentifierEnum value);

	/**
	 * Returns the value of the '<em><b>Type CS</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type CS</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type CS</em>' containment reference.
	 * @see #setTypeCS(TypeCS)
	 * @see org.eclipse.ocl.cst.CSTPackage#getCollectionTypeCS_TypeCS()
	 * @model containment="true"
	 * @generated
	 */
	TypeCS getTypeCS();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.cst.CollectionTypeCS#getTypeCS <em>Type CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type CS</em>' containment reference.
	 * @see #getTypeCS()
	 * @generated
	 */
	void setTypeCS(TypeCS value);

} // CollectionTypeCS
