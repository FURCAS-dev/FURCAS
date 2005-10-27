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

package org.eclipse.emf.ocl.uml;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.uml.Qualifier#getAssociationEnd <em>Association End</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.uml.UmlPackage#getQualifier()
 * @model
 * @generated
 */
public interface Qualifier extends EObject, ETypedElement {
	/**
	 * Returns the value of the '<em><b>Association End</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.ocl.uml.AssociationEnd#getQualifiers <em>Qualifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association End</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association End</em>' container reference.
	 * @see #setAssociationEnd(AssociationEnd)
	 * @see org.eclipse.emf.ocl.uml.UmlPackage#getQualifier_AssociationEnd()
	 * @see org.eclipse.emf.ocl.uml.AssociationEnd#getQualifiers
	 * @model opposite="qualifiers" required="true"
	 * @generated
	 */
	AssociationEnd getAssociationEnd();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.uml.Qualifier#getAssociationEnd <em>Association End</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association End</em>' container reference.
	 * @see #getAssociationEnd()
	 * @generated
	 */
	void setAssociationEnd(AssociationEnd value);

} // Qualifier
