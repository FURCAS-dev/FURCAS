/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 Eclipse Modeling Project.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: UnresolvedClass.java,v 1.1 2010/03/11 11:54:56 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.unresolved;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass#getUnresolvedAttribute <em>Unresolved Attribute</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass#getUnresolvedReference <em>Unresolved Reference</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass#getUnresolvedProperty <em>Unresolved Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedPackage#getUnresolvedClass()
 * @model
 * @generated
 */
public interface UnresolvedClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Unresolved Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unresolved Attribute</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unresolved Attribute</em>' attribute.
	 * @see #setUnresolvedAttribute(String)
	 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedPackage#getUnresolvedClass_UnresolvedAttribute()
	 * @model dataType="org.eclipse.ocl.examples.parser.unresolved.UnresolvedDataType"
	 * @generated
	 */
	String getUnresolvedAttribute();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass#getUnresolvedAttribute <em>Unresolved Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unresolved Attribute</em>' attribute.
	 * @see #getUnresolvedAttribute()
	 * @generated
	 */
	void setUnresolvedAttribute(String value);

	/**
	 * Returns the value of the '<em><b>Unresolved Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unresolved Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unresolved Reference</em>' reference.
	 * @see #setUnresolvedReference(UnresolvedClass)
	 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedPackage#getUnresolvedClass_UnresolvedReference()
	 * @model
	 * @generated
	 */
	UnresolvedClass getUnresolvedReference();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass#getUnresolvedReference <em>Unresolved Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unresolved Reference</em>' reference.
	 * @see #getUnresolvedReference()
	 * @generated
	 */
	void setUnresolvedReference(UnresolvedClass value);

	/**
	 * Returns the value of the '<em><b>Unresolved Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unresolved Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unresolved Property</em>' reference.
	 * @see #setUnresolvedProperty(UnresolvedClassifier)
	 * @see org.eclipse.ocl.examples.parser.unresolved.UnresolvedPackage#getUnresolvedClass_UnresolvedProperty()
	 * @model
	 * @generated
	 */
	UnresolvedClassifier getUnresolvedProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.parser.unresolved.UnresolvedClass#getUnresolvedProperty <em>Unresolved Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unresolved Property</em>' reference.
	 * @see #getUnresolvedProperty()
	 * @generated
	 */
	void setUnresolvedProperty(UnresolvedClassifier value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void unresolvedOperation();

} // UnresolvedClass
