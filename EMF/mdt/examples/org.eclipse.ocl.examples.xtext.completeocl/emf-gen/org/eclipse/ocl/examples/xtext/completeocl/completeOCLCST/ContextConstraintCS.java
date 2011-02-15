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
 * $Id: ContextConstraintCS.java,v 1.1 2011/02/08 17:53:05 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST;

import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpConstraintCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS#getContextDecl <em>Context Decl</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getContextConstraintCS()
 * @model abstract="true"
 * @generated
 */
public interface ContextConstraintCS extends ExpConstraintCS
{
	/**
	 * Returns the value of the '<em><b>Context Decl</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Decl</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Decl</em>' container reference.
	 * @see #setContextDecl(ContextDeclCS)
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLCSTPackage#getContextConstraintCS_ContextDecl()
	 * @see org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextDeclCS#getRules
	 * @model opposite="rules" transient="false"
	 * @generated
	 */
	ContextDeclCS getContextDecl();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ContextConstraintCS#getContextDecl <em>Context Decl</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Decl</em>' container reference.
	 * @see #getContextDecl()
	 * @generated
	 */
	void setContextDecl(ContextDeclCS value);

} // ContextConstraintCS
