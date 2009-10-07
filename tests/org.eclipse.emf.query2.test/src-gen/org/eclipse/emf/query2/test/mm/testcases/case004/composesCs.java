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
package org.eclipse.emf.query2.test.mm.testcases.case004;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>composes Cs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesCs#getMyF <em>My F</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesCs#getMyCs <em>My Cs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getcomposesCs()
 * @model
 * @generated
 */
public interface composesCs extends EObject {
	/**
	 * Returns the value of the '<em><b>My F</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My F</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>My F</em>' containment reference.
	 * @see #setMyF(F4)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getcomposesCs_MyF()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case004.composesCs' metaObjectMofId='45F5408B488ADA49AEFE4ECB2315B0BC92517FC7' storedEnd='0' compositeEnd='0' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	F4 getMyF();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesCs#getMyF <em>My F</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>My F</em>' containment reference.
	 * @see #getMyF()
	 * @generated
	 */
	void setMyF(F4 value);

	/**
	 * Returns the value of the '<em><b>My Cs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case004.C4}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My Cs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>My Cs</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getcomposesCs_MyCs()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case004.composesCs' metaObjectMofId='45F5408B488ADA49AEFE4ECB2315B0BC92517FC7' storedEnd='0' compositeEnd='0' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<C4> getMyCs();

} // composesCs
