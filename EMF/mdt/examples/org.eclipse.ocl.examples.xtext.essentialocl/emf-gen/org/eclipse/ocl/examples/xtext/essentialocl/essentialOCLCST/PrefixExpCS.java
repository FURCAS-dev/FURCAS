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
 * $Id: PrefixExpCS.java,v 1.2 2011/01/24 21:31:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS#getOwnedOperator <em>Owned Operator</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS#getOwnedExpression <em>Owned Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getPrefixExpCS()
 * @model
 * @generated
 */
public interface PrefixExpCS extends ExpCS {

	/**
	 * Returns the value of the '<em><b>Owned Operator</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.UnaryOperatorCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Operator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Operator</em>' containment reference list.
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getPrefixExpCS_OwnedOperator()
	 * @model containment="true"
	 * @generated
	 */
	EList<UnaryOperatorCS> getOwnedOperator();

	/**
	 * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Expression</em>' containment reference.
	 * @see #setOwnedExpression(ExpCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getPrefixExpCS_OwnedExpression()
	 * @model containment="true"
	 * @generated
	 */
	ExpCS getOwnedExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PrefixExpCS#getOwnedExpression <em>Owned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Expression</em>' containment reference.
	 * @see #getOwnedExpression()
	 * @generated
	 */
	void setOwnedExpression(ExpCS value);

} // UnaryExpressionCS
