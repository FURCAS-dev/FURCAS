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
 * A representation of the model object '<em><b>composes Cs Ordered</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesCsOrdered#getMyF <em>My F</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesCsOrdered#getMyCsOrdered <em>My Cs Ordered</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getcomposesCsOrdered()
 * @model
 * @generated
 */
public interface composesCsOrdered extends EObject {
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
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getcomposesCsOrdered_MyF()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case004.composesCsOrdered' metaObjectMofId='45F56B677CF18E3395C244F203B9EB5C2158434A' storedEnd='0' compositeEnd='0' orderedEnd='1' exposedEndNumber='0'"
	 * @generated
	 */
	F4 getMyF();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.composesCsOrdered#getMyF <em>My F</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>My F</em>' containment reference.
	 * @see #getMyF()
	 * @generated
	 */
	void setMyF(F4 value);

	/**
	 * Returns the value of the '<em><b>My Cs Ordered</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case004.C4}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My Cs Ordered</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>My Cs Ordered</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#getcomposesCsOrdered_MyCsOrdered()
	 * @model required="true"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case004.composesCsOrdered' metaObjectMofId='45F56B677CF18E3395C244F203B9EB5C2158434A' storedEnd='0' compositeEnd='0' orderedEnd='1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<C4> getMyCsOrdered();

} // composesCsOrdered
