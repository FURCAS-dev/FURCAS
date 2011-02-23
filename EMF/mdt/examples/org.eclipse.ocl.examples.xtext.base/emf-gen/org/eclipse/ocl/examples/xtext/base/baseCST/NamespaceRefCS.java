/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: NamespaceRefCS.java,v 1.1 2011/02/15 10:36:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.ocl.examples.pivot.Namespace;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Namespace Ref CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceRefCS#getRef <em>Ref</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceRefCS#getOwnedTemplateBinding <em>Owned Template Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getNamespaceRefCS()
 * @model
 * @generated
 */
public interface NamespaceRefCS extends ElementCS
{
	/**
	 * Returns the value of the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref</em>' reference.
	 * @see #setRef(Namespace)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getNamespaceRefCS_Ref()
	 * @model
	 * @generated
	 */
	Namespace getRef();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceRefCS#getRef <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref</em>' reference.
	 * @see #getRef()
	 * @generated
	 */
	void setRef(Namespace value);

	/**
	 * Returns the value of the '<em><b>Owned Template Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Template Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Template Binding</em>' containment reference.
	 * @see #setOwnedTemplateBinding(TemplateBindingCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getNamespaceRefCS_OwnedTemplateBinding()
	 * @model containment="true"
	 * @generated
	 */
	TemplateBindingCS getOwnedTemplateBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceRefCS#getOwnedTemplateBinding <em>Owned Template Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Template Binding</em>' containment reference.
	 * @see #getOwnedTemplateBinding()
	 * @generated
	 */
	void setOwnedTemplateBinding(TemplateBindingCS value);

} // NamespaceRefCS
