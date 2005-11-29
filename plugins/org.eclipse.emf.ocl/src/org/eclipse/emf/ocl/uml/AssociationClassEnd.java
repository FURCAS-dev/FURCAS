/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.uml;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Class End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.uml.AssociationClassEnd#getAssociationClass <em>Association Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.uml.UmlPackage#getAssociationClassEnd()
 *
 * @generated
 */
public interface AssociationClassEnd extends EObject, EReference {
	/**
	 * Returns the value of the '<em><b>Association Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association Class</em>' reference.
	 * @see #setAssociationClass(EClass)
	 * @see org.eclipse.emf.ocl.uml.UmlPackage#getAssociationClassEnd_AssociationClass()
	 * @model required="true"
	 * @generated
	 */
	EClass getAssociationClass();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.uml.AssociationClassEnd#getAssociationClass <em>Association Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association Class</em>' reference.
	 * @see #getAssociationClass()
	 * @generated
	 */
	void setAssociationClass(EClass value);

} // AssociationClassEnd
