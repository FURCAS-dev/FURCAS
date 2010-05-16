/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: TypedTypeRefCS.java,v 1.2 2010/05/16 19:18:01 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Type Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTypedTypeRefCS()
 * @model
 * @generated
 */
public interface TypedTypeRefCS extends ParameterizedTypeRefCS {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(TypeCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTypedTypeRefCS_Type()
	 * @model
	 * @generated
	 */
	TypeCS getType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeCS value);

} // TypedTypeRefCS
