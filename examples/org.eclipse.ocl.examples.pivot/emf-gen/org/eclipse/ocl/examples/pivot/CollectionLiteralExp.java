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
 * $Id: CollectionLiteralExp.java,v 1.2 2011/01/24 20:42:35 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp#getParts <em>Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCollectionLiteralExp()
 * @model
 * @generated
 */
public interface CollectionLiteralExp
		extends LiteralExp {

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.ocl.examples.pivot.CollectionKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.ocl.examples.pivot.CollectionKind
	 * @see #setKind(CollectionKind)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCollectionLiteralExp_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CollectionKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.CollectionLiteralExp#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.ocl.examples.pivot.CollectionKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(CollectionKind value);

	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.CollectionLiteralPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getCollectionLiteralExp_Part()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<CollectionLiteralPart> getParts();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.CollectionLiteralPart} and appends it to the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.CollectionLiteralPart} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.CollectionLiteralPart}.
	 * @see #getParts()
	 * @generated
	 */
	CollectionLiteralPart createPart(EClass eClass);

} // CollectionLiteralExp
