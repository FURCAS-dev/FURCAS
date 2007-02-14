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
 * $Id: CollectionLiteralExp.java,v 1.2 2007/02/14 13:42:15 cdamus Exp $
 */
package org.eclipse.ocl.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionLiteralExp#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionLiteralExp#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.ocl.expressions.CollectionLiteralExp#isSimpleRange <em>Simple Range</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionLiteralExp()
 * @model
 * @generated
 */
public interface CollectionLiteralExp<C> extends LiteralExp<C> {
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
	 * @see #setKind(CollectionKind)
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionLiteralExp_Kind()
	 * @model extendedMetaData="name='kind'"
	 * @generated
	 */
	CollectionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.expressions.CollectionLiteralExp#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.ocl.expressions.CollectionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(CollectionKind value);

	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.expressions.CollectionLiteralPart<C>}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionLiteralExp_Part()
	 * @model type="org.eclipse.ocl.expressions.CollectionLiteralPart" containment="true"
	 * @generated
	 */
	EList<CollectionLiteralPart<C>> getPart();

	/**
	 * Returns the value of the '<em><b>Simple Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Range</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Range</em>' attribute.
	 * @see org.eclipse.ocl.expressions.ExpressionsPackage#getCollectionLiteralExp_SimpleRange()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	boolean isSimpleRange();

} // CollectionLiteralExp
