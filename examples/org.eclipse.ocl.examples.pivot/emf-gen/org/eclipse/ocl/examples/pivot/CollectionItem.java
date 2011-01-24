/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CollectionItem.java,v 1.3 2011/01/24 20:49:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CollectionItem#getItem <em>Item</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCollectionItem()
 * @model
 * @generated
 */
public interface CollectionItem
		extends CollectionLiteralPart {

	/**
	 * Returns the value of the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Item</em>' containment reference.
	 * @see #setItem(OclExpression)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCollectionItem_Item()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getItem();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CollectionItem#getItem <em>Item</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Item</em>' containment reference.
	 * @see #getItem()
	 * @generated
	 */
	void setItem(OclExpression value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.OclExpression} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getItem()
	 * @generated
	 */
	OclExpression createItem(EClass eClass);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.OclExpression} and sets the '<em><b>Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.OclExpression}.
	 * @see #getItem()
	 * @generated
	 */
	OclExpression createItem();

} // CollectionItem
