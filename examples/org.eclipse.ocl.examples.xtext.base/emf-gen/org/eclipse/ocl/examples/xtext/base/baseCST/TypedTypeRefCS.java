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
 * $Id: TypedTypeRefCS.java,v 1.4 2011/02/15 10:36:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Type Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS#getOwnedTemplateBinding <em>Owned Template Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTypedTypeRefCS()
 * @model
 * @generated
 */
public interface TypedTypeRefCS extends TypedRefCS {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.Namespace}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTypedTypeRefCS_Namespace()
	 * @model
	 * @generated
	 */
	EList<Namespace> getNamespace();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTypedTypeRefCS_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

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
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTypedTypeRefCS_OwnedTemplateBinding()
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS#getOwningTemplateBindableElement
	 * @model opposite="owningTemplateBindableElement" containment="true"
	 * @generated
	 */
	TemplateBindingCS getOwnedTemplateBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS#getOwnedTemplateBinding <em>Owned Template Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Template Binding</em>' containment reference.
	 * @see #getOwnedTemplateBinding()
	 * @generated
	 */
	void setOwnedTemplateBinding(TemplateBindingCS value);

} // TypedTypeRefCS
