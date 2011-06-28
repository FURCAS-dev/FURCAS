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
 * $Id: LetVariableCS.java,v 1.2 2011/01/24 21:31:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS#getLetExpression <em>Let Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getLetVariableCS()
 * @model
 * @generated
 */
public interface LetVariableCS extends VariableCS, ExpCS {

	/**
	 * Returns the value of the '<em><b>Let Expression</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Let Expression</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Let Expression</em>' container reference.
	 * @see #setLetExpression(LetExpCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getLetVariableCS_LetExpression()
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS#getVariable
	 * @model opposite="variable" transient="false"
	 * @generated
	 */
	LetExpCS getLetExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetVariableCS#getLetExpression <em>Let Expression</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Let Expression</em>' container reference.
	 * @see #getLetExpression()
	 * @generated
	 */
	void setLetExpression(LetExpCS value);

} // VariableCS
