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
package org.eclipse.emf.query2.test.mm.testcases.case010;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Navigable To Not Navigable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotNavigableToNotNavigable#getNotNavigableFrom <em>Not Navigable From</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotNavigableToNotNavigable#getNotNavigableTo <em>Not Navigable To</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getNotNavigableToNotNavigable()
 * @model
 * @generated
 */
public interface NotNavigableToNotNavigable extends EObject {
	/**
	 * Returns the value of the '<em><b>Not Navigable From</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Navigable From</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Navigable From</em>' reference.
	 * @see #setNotNavigableFrom(A10)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getNotNavigableToNotNavigable_NotNavigableFrom()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case010.NotNavigableToNotNavigable' metaObjectMofId='45F120A5113EF389521140D4152CAF747D4BED0B' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	A10 getNotNavigableFrom();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotNavigableToNotNavigable#getNotNavigableFrom <em>Not Navigable From</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Navigable From</em>' reference.
	 * @see #getNotNavigableFrom()
	 * @generated
	 */
	void setNotNavigableFrom(A10 value);

	/**
	 * Returns the value of the '<em><b>Not Navigable To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Navigable To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Navigable To</em>' reference.
	 * @see #setNotNavigableTo(B10)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getNotNavigableToNotNavigable_NotNavigableTo()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case010.NotNavigableToNotNavigable' metaObjectMofId='45F120A5113EF389521140D4152CAF747D4BED0B' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	B10 getNotNavigableTo();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotNavigableToNotNavigable#getNotNavigableTo <em>Not Navigable To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Navigable To</em>' reference.
	 * @see #getNotNavigableTo()
	 * @generated
	 */
	void setNotNavigableTo(B10 value);

} // NotNavigableToNotNavigable
