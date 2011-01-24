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
 * $Id: TemplateParameterSubstitutionCS.java,v 1.2 2011/01/24 20:59:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameter Substitution CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS#getOwningTemplateBinding <em>Owning Template Binding</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS#getOwnedActualParameter <em>Owned Actual Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTemplateParameterSubstitutionCS()
 * @model
 * @generated
 */
public interface TemplateParameterSubstitutionCS extends ModelElementCS {
	/**
	 * Returns the value of the '<em><b>Owning Template Binding</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS#getOwnedParameterSubstitution <em>Owned Parameter Substitution</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Template Binding</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Template Binding</em>' container reference.
	 * @see #setOwningTemplateBinding(TemplateBindingCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTemplateParameterSubstitutionCS_OwningTemplateBinding()
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS#getOwnedParameterSubstitution
	 * @model opposite="ownedParameterSubstitution" transient="false"
	 * @generated
	 */
	TemplateBindingCS getOwningTemplateBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS#getOwningTemplateBinding <em>Owning Template Binding</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Template Binding</em>' container reference.
	 * @see #getOwningTemplateBinding()
	 * @generated
	 */
	void setOwningTemplateBinding(TemplateBindingCS value);

	/**
	 * Returns the value of the '<em><b>Formal Template Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Formal Template Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Formal Template Parameter</em>' reference.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTemplateParameterSubstitutionCS_FormalTemplateParameter()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
//	TemplateParameterCS getFormalTemplateParameter();

	/**
	 * Returns the value of the '<em><b>Owned Actual Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Actual Parameter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Actual Parameter</em>' containment reference.
	 * @see #setOwnedActualParameter(ParameterableElementCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTemplateParameterSubstitutionCS_OwnedActualParameter()
	 * @model containment="true"
	 * @generated
	 */
	ParameterableElementCS getOwnedActualParameter();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS#getOwnedActualParameter <em>Owned Actual Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Actual Parameter</em>' containment reference.
	 * @see #getOwnedActualParameter()
	 * @generated
	 */
	void setOwnedActualParameter(ParameterableElementCS value);

} // TemplateParameterSubstitutionCS
