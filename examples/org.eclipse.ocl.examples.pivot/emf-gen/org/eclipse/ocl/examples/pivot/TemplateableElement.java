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
 * $Id: TemplateableElement.java,v 1.4 2011/05/19 16:55:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Templateable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A templateable element is an element that can optionally be defined as a template and bound to other templates.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TemplateableElement#getTemplateBindings <em>Template Binding</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TemplateableElement#getOwnedTemplateSignature <em>Owned Template Signature</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TemplateableElement#getUnspecializedElement <em>Unspecialized Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTemplateableElement()
 * @model abstract="true"
 * @generated
 */
public interface TemplateableElement
		extends MonikeredElement {

	/**
	 * Returns the value of the '<em><b>Template Binding</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.TemplateBinding}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.TemplateBinding#getBoundElement <em>Bound Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The optional bindings from this element to templates.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Template Binding</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTemplateableElement_TemplateBinding()
	 * @see org.eclipse.ocl.examples.pivot.TemplateBinding#getBoundElement
	 * @model opposite="boundElement" containment="true" ordered="false"
	 * @generated
	 */
	EList<TemplateBinding> getTemplateBindings();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.TemplateBinding} and appends it to the '<em><b>Template Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.TemplateBinding}.
	 * @see #getTemplateBindings()
	 * @generated
	 */
	TemplateBinding createTemplateBinding();

	/**
	 * Returns the value of the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.TemplateSignature#getTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The optional template signature specifying the formal template parameters.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Template Signature</em>' containment reference.
	 * @see #setOwnedTemplateSignature(TemplateSignature)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTemplateableElement_OwnedTemplateSignature()
	 * @see org.eclipse.ocl.examples.pivot.TemplateSignature#getTemplate
	 * @model opposite="template" containment="true" ordered="false"
	 * @generated
	 */
	TemplateSignature getOwnedTemplateSignature();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.TemplateableElement#getOwnedTemplateSignature <em>Owned Template Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Template Signature</em>' containment reference.
	 * @see #getOwnedTemplateSignature()
	 * @generated
	 */
	void setOwnedTemplateSignature(TemplateSignature value);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.TemplateSignature} and sets the '<em><b>Owned Template Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.TemplateSignature}.
	 * @see #getOwnedTemplateSignature()
	 * @generated
	 */
	TemplateSignature createOwnedTemplateSignature();

	/**
	 * Returns the value of the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unspecialized Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unspecialized Element</em>' reference.
	 * @see #setUnspecializedElement(TemplateableElement)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTemplateableElement_UnspecializedElement()
	 * @model resolveProxies="false" transient="true" ordered="false"
	 * @generated
	 */
	TemplateableElement getUnspecializedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.TemplateableElement#getUnspecializedElement <em>Unspecialized Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unspecialized Element</em>' reference.
	 * @see #getUnspecializedElement()
	 * @generated
	 */
	void setUnspecializedElement(TemplateableElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query parameterableElements() returns the set of elements that may be used as the parametered elements for a template parameter of this templateable element. By default, this set includes all the owned elements. Subclasses may override this operation if they choose to restrict the set of parameterable elements.
	 * result = allOwnedElements->select(oclIsKindOf(ParameterableElement))
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<ParameterableElement> parameterableElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query isTemplate() returns whether this templateable element is actually a template.
	 * result = ownedTemplateSignature->notEmpty()
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.eclipse.ocl.examples.pivot.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isTemplate();

} // TemplateableElement
