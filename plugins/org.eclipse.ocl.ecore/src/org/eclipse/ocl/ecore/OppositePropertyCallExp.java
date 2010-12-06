/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 SAP AG and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Axel Uhl - Initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.ocl.ecore;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Opposite Property Call Exp</b></em>'.
 * @since 3.1
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.ecore.OppositePropertyCallExp#getReferredOppositeProperty <em>Referred Opposite Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.ecore.EcorePackage#getOppositePropertyCallExp()
 * @model
 * @generated
 */
public interface OppositePropertyCallExp
		extends NavigationCallExp {

	/**
	 * Returns the value of the '<em><b>Referred Opposite Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Opposite Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Opposite Property</em>' reference.
	 * @see #setReferredOppositeProperty(EReference)
	 * @see org.eclipse.ocl.ecore.EcorePackage#getOppositePropertyCallExp_ReferredOppositeProperty()
	 * @model required="true"
	 * @generated
	 */
	EReference getReferredOppositeProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.ecore.OppositePropertyCallExp#getReferredOppositeProperty <em>Referred Opposite Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Opposite Property</em>' reference.
	 * @see #getReferredOppositeProperty()
	 * @generated
	 */
	void setReferredOppositeProperty(EReference value);
} // OppositePropertyCallExp
