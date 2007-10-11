/**
 * <copyright>
 * 
 * Copyright (c) 2006, 2007 IBM Corporation and others.
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
 * $Id: CollectionType.java,v 1.4 2007/10/11 23:04:57 cdamus Exp $
 */
package org.eclipse.ocl.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.TypedASTNode;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.types.CollectionType#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.types.CollectionType#getKind <em>Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.types.TypesPackage#getCollectionType()
 * @model
 * @generated
 */
public interface CollectionType<C, O> extends PredefinedType<O>, TypedASTNode {
	String SINGLETON_NAME = "Collection"; //$NON-NLS-1$
    
	/**
     * Returns the value of the '<em><b>Element Type</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Element Type</em>' reference.
     * @see #setElementType(Object)
     * @see org.eclipse.ocl.types.TypesPackage#getCollectionType_ElementType()
     * @model kind="reference"
     * @generated
     */
	C getElementType();

	/**
     * Sets the value of the '{@link org.eclipse.ocl.types.CollectionType#getElementType <em>Element Type</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Element Type</em>' reference.
     * @see #getElementType()
     * @generated
     */
	void setElementType(C value);

	/**
     * Returns the value of the '<em><b>Kind</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.ocl.expressions.CollectionKind}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Kind</em>' attribute.
     * @see org.eclipse.ocl.expressions.CollectionKind
     * @see org.eclipse.ocl.types.TypesPackage#getCollectionType_Kind()
     * @model required="true" transient="true" changeable="false" volatile="true"
     * @generated
     */
	CollectionKind getKind();

	/**
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @model
     * @generated
     */
	EList<O> oclIterators();

} // CollectionType
