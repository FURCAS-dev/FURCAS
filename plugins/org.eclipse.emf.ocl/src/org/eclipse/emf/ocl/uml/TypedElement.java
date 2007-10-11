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
 * $Id: TypedElement.java,v 1.4 2007/10/11 23:05:17 cdamus Exp $
 */
package org.eclipse.emf.ocl.uml;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.ocl.uml.TypedElement#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @deprecated Use the {@link org.eclipse.ocl.utilities.TypedElement} interface,
 * instead.
 * 
 * @see org.eclipse.emf.ocl.uml.UMLPackage#getTypedElement()
 * @model abstract="true"
 * @generated
 */
@Deprecated
public interface TypedElement extends ENamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = ""; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClassifier)
	 * @see org.eclipse.emf.ocl.uml.UMLPackage#getTypedElement_Type()
	 * @model
	 * @generated
	 */
	EClassifier getType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ocl.uml.TypedElement#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClassifier value);

} // TypedElement
