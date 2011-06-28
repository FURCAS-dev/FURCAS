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
 * $Id: TemplateParameterCS.java,v 1.2 2011/01/24 20:59:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.baseCST;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Parameter CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS#getOwningTemplateSignature <em>Owning Template Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTemplateParameterCS()
 * @model abstract="true"
 * @generated
 */
public interface TemplateParameterCS extends NamedElementCS {
	/**
	 * Returns the value of the '<em><b>Owning Template Signature</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS#getOwnedTemplateParameter <em>Owned Template Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Template Signature</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Template Signature</em>' container reference.
	 * @see #setOwningTemplateSignature(TemplateSignatureCS)
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#getTemplateParameterCS_OwningTemplateSignature()
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS#getOwnedTemplateParameter
	 * @model opposite="ownedTemplateParameter" required="true" transient="false"
	 * @generated
	 */
	TemplateSignatureCS getOwningTemplateSignature();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS#getOwningTemplateSignature <em>Owning Template Signature</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Template Signature</em>' container reference.
	 * @see #getOwningTemplateSignature()
	 * @generated
	 */
	void setOwningTemplateSignature(TemplateSignatureCS value);

} // TemplateParameterCS
