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
package org.eclipse.emf.query2.test.mm.testcases.case017;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A17</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case017.A17#getToEnd <em>To End</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case017.A17#getFromEnd <em>From End</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case017.Case017Package#getA17()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case017.A17' metaObjectMofId='45F120A5262EE936B46A48E038C5DC113D1AFB10' isStructureType='false'"
 * @generated
 */
public interface A17 extends EObject {
	/**
	 * Returns the value of the '<em><b>To End</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case017.A17}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To End</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To End</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case017.Case017Package#getA17_ToEnd()
	 * @model containment="true" resolveProxies="true" required="true" upper="4" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case017.Composition' metaObjectMofId='45F120A51501A7CDF32B42880969CB0C3C2848E5' storedEnd='0' compositeEnd='0' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<A17> getToEnd();

	/**
	 * Returns the value of the '<em><b>From End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From End</em>' reference.
	 * @see #setFromEnd(A17)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case017.Case017Package#getA17_FromEnd()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case017.Composition' metaObjectMofId='45F120A51501A7CDF32B42880969CB0C3C2848E5' storedEnd='0' compositeEnd='0' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	A17 getFromEnd();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case017.A17#getFromEnd <em>From End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From End</em>' reference.
	 * @see #getFromEnd()
	 * @generated
	 */
	void setFromEnd(A17 value);

} // A17
