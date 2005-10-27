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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.uml.AssociationEnd#getQualifiers <em>Qualifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.ocl.uml.UmlPackage#getAssociationEnd()
 * @model
 * @generated
 */
public interface AssociationEnd extends EObject, EReference {
	/**
	 * Returns the value of the '<em><b>Qualifiers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ocl.uml.Qualifier}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.ocl.uml.Qualifier#getAssociationEnd <em>Association End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifiers</em>' containment reference list.
	 * @see org.eclipse.emf.ocl.uml.UmlPackage#getAssociationEnd_Qualifiers()
	 * @see org.eclipse.emf.ocl.uml.Qualifier#getAssociationEnd
	 * @model type="org.eclipse.emf.ocl.uml.Qualifier" opposite="associationEnd" containment="true"
	 * @generated
	 */
	EList getQualifiers();

} // AssociationEnd
