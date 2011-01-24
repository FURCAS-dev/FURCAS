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
 * $Id: ParameterizedTypeRefCS.java,v 1.3 2011/01/24 20:59:31 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.ocl.examples.pivot.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameterized Type Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS#getOwnedTemplateBinding <em>Owned Template Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getParameterizedTypeRefCS()
 * @model abstract="true"
 * @generated
 */
public interface ParameterizedTypeRefCS extends TypedRefCS {
	/**
	 * Returns the value of the '<em><b>Owned Template Binding</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS#getOwningTemplateBindableElement <em>Owning Template Bindable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Template Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Template Binding</em>' containment reference.
	 * @see #setOwnedTemplateBinding(TemplateBindingCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getParameterizedTypeRefCS_OwnedTemplateBinding()
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS#getOwningTemplateBindableElement
	 * @model opposite="owningTemplateBindableElement" containment="true"
	 * @generated
	 */
	TemplateBindingCS getOwnedTemplateBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS#getOwnedTemplateBinding <em>Owned Template Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Template Binding</em>' containment reference.
	 * @see #getOwnedTemplateBinding()
	 * @generated
	 */
	void setOwnedTemplateBinding(TemplateBindingCS value);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Type getType();

	Type getPivot();
} // ParameterizedTypeRefCS
