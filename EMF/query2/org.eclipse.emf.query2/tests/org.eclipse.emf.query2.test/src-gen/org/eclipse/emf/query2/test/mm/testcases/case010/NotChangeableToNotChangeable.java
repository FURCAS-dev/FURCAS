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
 * A representation of the model object '<em><b>Not Changeable To Not Changeable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableToNotChangeable#getNotChangeableFromB <em>Not Changeable From B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableToNotChangeable#getNotChangeableFromA <em>Not Changeable From A</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getNotChangeableToNotChangeable()
 * @model
 * @generated
 */
public interface NotChangeableToNotChangeable extends EObject {
	/**
	 * Returns the value of the '<em><b>Not Changeable From B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Changeable From B</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Changeable From B</em>' reference.
	 * @see #setNotChangeableFromB(A10)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getNotChangeableToNotChangeable_NotChangeableFromB()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case010.NotChangeableToNotChangeable' metaObjectMofId='45F120A5720DC72ADA074DBA33AA80125E198126' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	A10 getNotChangeableFromB();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableToNotChangeable#getNotChangeableFromB <em>Not Changeable From B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Changeable From B</em>' reference.
	 * @see #getNotChangeableFromB()
	 * @generated
	 */
	void setNotChangeableFromB(A10 value);

	/**
	 * Returns the value of the '<em><b>Not Changeable From A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Not Changeable From A</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Not Changeable From A</em>' reference.
	 * @see #setNotChangeableFromA(B10)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getNotChangeableToNotChangeable_NotChangeableFromA()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case010.NotChangeableToNotChangeable' metaObjectMofId='45F120A5720DC72ADA074DBA33AA80125E198126' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	B10 getNotChangeableFromA();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.NotChangeableToNotChangeable#getNotChangeableFromA <em>Not Changeable From A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Not Changeable From A</em>' reference.
	 * @see #getNotChangeableFromA()
	 * @generated
	 */
	void setNotChangeableFromA(B10 value);

} // NotChangeableToNotChangeable
