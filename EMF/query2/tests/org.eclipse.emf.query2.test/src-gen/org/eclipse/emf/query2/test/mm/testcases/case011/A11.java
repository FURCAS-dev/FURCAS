/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.query2.test.mm.testcases.case011;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A11</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case011.A11#getAttribute1 <em>Attribute1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case011.A11#getAttribute2 <em>Attribute2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case011.Case011Package#getA11()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case011.A11' metaObjectMofId='45F120A5D1F668EE896C43F632C9C2ECBCFC42B8' isStructureType='false'"
 * @generated
 */
public interface A11 extends EObject {
	/**
	 * Returns the value of the '<em><b>Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute1</em>' attribute.
	 * @see #setAttribute1(String)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case011.Case011Package#getA11_Attribute1()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getAttribute1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case011.A11#getAttribute1 <em>Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute1</em>' attribute.
	 * @see #getAttribute1()
	 * @generated
	 */
	void setAttribute1(String value);

	/**
	 * Returns the value of the '<em><b>Attribute2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute2</em>' attribute.
	 * @see #setAttribute2(String)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case011.Case011Package#getA11_Attribute2()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getAttribute2();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case011.A11#getAttribute2 <em>Attribute2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute2</em>' attribute.
	 * @see #getAttribute2()
	 * @generated
	 */
	void setAttribute2(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model throwRuntimeExceptionBetweenTheCallsUnique="false" throwRuntimeExceptionBetweenTheCallsRequired="true" throwRuntimeExceptionBetweenTheCallsOrdered="false" attribute1Unique="false" attribute1Required="true" attribute1Ordered="false" attribute2Unique="false" attribute2Required="true" attribute2Ordered="false"
	 * @generated
	 */
	void callMultipleSetter(boolean throwRuntimeExceptionBetweenTheCalls, String attribute1, String attribute2);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String callMultipleGetter();

} // A11
