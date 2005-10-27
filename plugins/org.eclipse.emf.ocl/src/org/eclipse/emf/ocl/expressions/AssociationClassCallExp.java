/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.emf.ocl.expressions;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Class Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.expressions.AssociationClassCallExp#getReferredAssociationClass <em>Referred Association Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getAssociationClassCallExp()
 * @model
 * @generated
 */
public interface AssociationClassCallExp extends NavigationCallExp{
	/**
	 * Returns the value of the '<em><b>Referred Association Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Association Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Association Class</em>' reference.
	 * @see #setReferredAssociationClass(EClass)
	 * @see org.eclipse.emf.ocl.expressions.ExpressionsPackage#getAssociationClassCallExp_ReferredAssociationClass()
	 * @model
	 * @generated
	 */
	EClass getReferredAssociationClass();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.expressions.AssociationClassCallExp#getReferredAssociationClass <em>Referred Association Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Association Class</em>' reference.
	 * @see #getReferredAssociationClass()
	 * @generated
	 */
	void setReferredAssociationClass(EClass value);

} // AssociationClassCallExp
