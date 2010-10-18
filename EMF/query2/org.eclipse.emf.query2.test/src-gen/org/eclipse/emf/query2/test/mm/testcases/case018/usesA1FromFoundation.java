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
package org.eclipse.emf.query2.test.mm.testcases.case018;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.test.mm.testcasesfoundation.case001f.A1f;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>uses A1 From Foundation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case018.usesA1FromFoundation#getA1FromFoundation <em>A1 From Foundation</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case018.usesA1FromFoundation#getA18 <em>A18</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case018.Case018Package#getusesA1FromFoundation()
 * @model
 * @generated
 */
public interface usesA1FromFoundation extends EObject {
	/**
	 * Returns the value of the '<em><b>A1 From Foundation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>A1 From Foundation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>A1 From Foundation</em>' reference.
	 * @see #setA1FromFoundation(A1f)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.Case018Package#getusesA1FromFoundation_A1FromFoundation()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case018.usesA1FromFoundation' metaObjectMofId='45F120A5BFCE758B84224C283FB196BD8E598E69' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	A1f getA1FromFoundation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case018.usesA1FromFoundation#getA1FromFoundation <em>A1 From Foundation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>A1 From Foundation</em>' reference.
	 * @see #getA1FromFoundation()
	 * @generated
	 */
	void setA1FromFoundation(A1f value);

	/**
	 * Returns the value of the '<em><b>A18</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>A18</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>A18</em>' reference.
	 * @see #setA18(A18)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case018.Case018Package#getusesA1FromFoundation_A18()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case018.usesA1FromFoundation' metaObjectMofId='45F120A5BFCE758B84224C283FB196BD8E598E69' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	A18 getA18();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case018.usesA1FromFoundation#getA18 <em>A18</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>A18</em>' reference.
	 * @see #getA18()
	 * @generated
	 */
	void setA18(A18 value);

} // usesA1FromFoundation
