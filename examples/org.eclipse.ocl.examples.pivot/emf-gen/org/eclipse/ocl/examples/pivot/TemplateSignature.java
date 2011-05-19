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
 * $Id: TemplateSignature.java,v 1.3 2011/05/19 16:55:39 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Signature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A template signature bundles the set of formal template parameters for a templated element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TemplateSignature#getParameters <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TemplateSignature#getOwnedParameters <em>Owned Parameter</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.pivot.TemplateSignature#getTemplate <em>Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTemplateSignature()
 * @model
 * @generated
 */
public interface TemplateSignature
		extends MonikeredElement {

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.TemplateParameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ordered set of all formal template parameters for this template signature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameter</em>' reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTemplateSignature_Parameter()
	 * @model required="true"
	 * @generated
	 */
	EList<TemplateParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Template</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.TemplateableElement#getOwnedTemplateSignature <em>Owned Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The element that owns this template signature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Template</em>' container reference.
	 * @see #setTemplate(TemplateableElement)
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTemplateSignature_Template()
	 * @see org.eclipse.ocl.examples.pivot.TemplateableElement#getOwnedTemplateSignature
	 * @model opposite="ownedTemplateSignature" required="true" transient="false" ordered="false"
	 * @generated
	 */
	TemplateableElement getTemplate();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.pivot.TemplateSignature#getTemplate <em>Template</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' container reference.
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(TemplateableElement value);

	/**
	 * Returns the value of the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.pivot.TemplateParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.pivot.TemplateParameter#getSignature <em>Signature</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.eclipse.ocl.examples.pivot.TemplateSignature#getParameters() <em>Parameter</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The formal template parameters that are owned by this template signature.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Parameter</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.pivot.PivotPackage#getTemplateSignature_OwnedParameter()
	 * @see org.eclipse.ocl.examples.pivot.TemplateParameter#getSignature
	 * @model opposite="signature" containment="true"
	 * @generated
	 */
	EList<TemplateParameter> getOwnedParameters();

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.TemplateParameter} and appends it to the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.eclipse.ocl.examples.pivot.TemplateParameter} to create.
	 * @return The new {@link org.eclipse.ocl.examples.pivot.TemplateParameter}.
	 * @see #getOwnedParameters()
	 * @generated
	 */
	TemplateParameter createOwnedParameter(EClass eClass);

	/**
	 * Creates a new {@link org.eclipse.ocl.examples.pivot.TemplateParameter} and appends it to the '<em><b>Owned Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.ocl.examples.pivot.TemplateParameter}.
	 * @see #getOwnedParameters()
	 * @generated
	 */
	TemplateParameter createOwnedParameter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Parameters must own the elements they parameter or those elements must be owned by the element being templated.
	 * templatedElement.ownedElement->includesAll(parameter.parameteredElement - parameter.ownedParameteredElement)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateOwnElements(DiagnosticChain diagnostics,
			Map<Object, Object> context);

} // TemplateSignature
