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
 * $Id: TemplateSignatureCS.java,v 1.2 2011/01/24 20:59:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Signature CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS#getOwningTemplateElement <em>Owning Template Element</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS#getOwnedTemplateParameter <em>Owned Template Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTemplateSignatureCS()
 * @model
 * @generated
 */
public interface TemplateSignatureCS extends MonikeredElementCS {
	/**
	 * Returns the value of the '<em><b>Owning Template Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS#getOwnedTemplateSignature <em>Owned Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Template Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Template Element</em>' container reference.
	 * @see #setOwningTemplateElement(TemplateableElementCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTemplateSignatureCS_OwningTemplateElement()
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS#getOwnedTemplateSignature
	 * @model opposite="ownedTemplateSignature" transient="false"
	 * @generated
	 */
	TemplateableElementCS getOwningTemplateElement();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS#getOwningTemplateElement <em>Owning Template Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Template Element</em>' container reference.
	 * @see #getOwningTemplateElement()
	 * @generated
	 */
	void setOwningTemplateElement(TemplateableElementCS value);

	/**
	 * Returns the value of the '<em><b>Owned Template Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS#getOwningTemplateSignature <em>Owning Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Template Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Template Parameter</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTemplateSignatureCS_OwnedTemplateParameter()
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS#getOwningTemplateSignature
	 * @model opposite="owningTemplateSignature" containment="true"
	 * @generated
	 */
	EList<TemplateParameterCS> getOwnedTemplateParameter();

} // TemplateSignatureCS
