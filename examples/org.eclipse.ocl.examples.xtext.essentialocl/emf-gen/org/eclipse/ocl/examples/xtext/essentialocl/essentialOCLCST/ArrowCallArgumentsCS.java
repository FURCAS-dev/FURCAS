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
 * $Id: ArrowCallArgumentsCS.java,v 1.1 2010/04/13 06:32:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arrow Call Arguments CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS#getVariable1 <em>Variable1</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS#getVariable2 <em>Variable2</em>}</li>
 *   <li>{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getArrowCallArgumentsCS()
 * @model
 * @generated
 */
public interface ArrowCallArgumentsCS extends CallArgumentsCS {
	/**
	 * Returns the value of the '<em><b>Variable1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable1</em>' containment reference.
	 * @see #setVariable1(VariableCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getArrowCallArgumentsCS_Variable1()
	 * @model containment="true"
	 * @generated
	 */
	VariableCS getVariable1();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS#getVariable1 <em>Variable1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable1</em>' containment reference.
	 * @see #getVariable1()
	 * @generated
	 */
	void setVariable1(VariableCS value);

	/**
	 * Returns the value of the '<em><b>Variable2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable2</em>' containment reference.
	 * @see #setVariable2(VariableCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getArrowCallArgumentsCS_Variable2()
	 * @model containment="true"
	 * @generated
	 */
	VariableCS getVariable2();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS#getVariable2 <em>Variable2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable2</em>' containment reference.
	 * @see #getVariable2()
	 * @generated
	 */
	void setVariable2(VariableCS value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(OclExpressionCS)
	 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getArrowCallArgumentsCS_Body()
	 * @model containment="true"
	 * @generated
	 */
	OclExpressionCS getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowCallArgumentsCS#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OclExpressionCS value);

} // ArrowCallArgumentsCS
