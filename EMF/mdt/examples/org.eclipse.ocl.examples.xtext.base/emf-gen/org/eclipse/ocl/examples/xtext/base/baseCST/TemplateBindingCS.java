/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: TemplateBindingCS.java,v 1.3 2011/02/15 10:36:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Binding CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS#getOwningTemplateBindableElement <em>Owning Template Bindable Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS#getOwnedParameterSubstitution <em>Owned Parameter Substitution</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTemplateBindingCS()
 * @model
 * @generated
 */
public interface TemplateBindingCS extends ModelElementCS {
	/**
	 * Returns the value of the '<em><b>Owning Template Bindable Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS#getOwnedTemplateBinding <em>Owned Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Template Bindable Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Template Bindable Element</em>' container reference.
	 * @see #setOwningTemplateBindableElement(TypedTypeRefCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTemplateBindingCS_OwningTemplateBindableElement()
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS#getOwnedTemplateBinding
	 * @model opposite="ownedTemplateBinding" transient="false"
	 * @generated
	 */
	TypedTypeRefCS getOwningTemplateBindableElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS#getOwningTemplateBindableElement <em>Owning Template Bindable Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Template Bindable Element</em>' container reference.
	 * @see #getOwningTemplateBindableElement()
	 * @generated
	 */
	void setOwningTemplateBindableElement(TypedTypeRefCS value);

	/**
	 * Returns the value of the '<em><b>Owned Parameter Substitution</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS#getOwningTemplateBinding <em>Owning Template Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Parameter Substitution</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Parameter Substitution</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTemplateBindingCS_OwnedParameterSubstitution()
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS#getOwningTemplateBinding
	 * @model opposite="owningTemplateBinding" containment="true"
	 * @generated
	 */
	EList<TemplateParameterSubstitutionCS> getOwnedParameterSubstitution();

} // TemplateBindingCS
