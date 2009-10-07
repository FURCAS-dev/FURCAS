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
 * A representation of the model object '<em><b>B10</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.B10#getOneAChangeable <em>One AChangeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.B10#getOneANotChangeable <em>One ANot Changeable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getB10()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case010.B10' metaObjectMofId='45F120A5CAEC34922D274DA126BDB01534160893' isStructureType='false'"
 * @generated
 */
public interface B10 extends EObject {
	/**
	 * Returns the value of the '<em><b>One AChangeable</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.query2.test.mm.testcases.case010.A10#getManyBsChangeable <em>Many Bs Changeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One AChangeable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One AChangeable</em>' reference.
	 * @see #setOneAChangeable(A10)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getB10_OneAChangeable()
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.A10#getManyBsChangeable
	 * @model opposite="manyBsChangeable" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case010.oneToManyChangeable' metaObjectMofId='45F120A549F4BCE8C69B48AB095DC5A6D9B1DA5D' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	A10 getOneAChangeable();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.B10#getOneAChangeable <em>One AChangeable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One AChangeable</em>' reference.
	 * @see #getOneAChangeable()
	 * @generated
	 */
	void setOneAChangeable(A10 value);

	/**
	 * Returns the value of the '<em><b>One ANot Changeable</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.query2.test.mm.testcases.case010.A10#getManyBsNotChangeable <em>Many Bs Not Changeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One ANot Changeable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One ANot Changeable</em>' reference.
	 * @see #setOneANotChangeable(A10)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getB10_OneANotChangeable()
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.A10#getManyBsNotChangeable
	 * @model opposite="manyBsNotChangeable" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case010.oneToManyNotChangeable' metaObjectMofId='45F120A57A9FDF827396478901AEA0B83950C8A5' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	A10 getOneANotChangeable();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.B10#getOneANotChangeable <em>One ANot Changeable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One ANot Changeable</em>' reference.
	 * @see #getOneANotChangeable()
	 * @generated
	 */
	void setOneANotChangeable(A10 value);

} // B10
