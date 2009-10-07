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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A10</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.A10#getManyBsNotChangeable <em>Many Bs Not Changeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.A10#getManyBsOrdered <em>Many Bs Ordered</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.A10#getManyBsChangeable <em>Many Bs Changeable</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case010.A10#getNavigable <em>Navigable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getA10()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case010.A10' metaObjectMofId='45F120A5D3E548702DE84018177382797E661C28' isStructureType='false'"
 * @generated
 */
public interface A10 extends EObject {
	/**
	 * Returns the value of the '<em><b>Many Bs Not Changeable</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case010.B10}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.query2.test.mm.testcases.case010.B10#getOneANotChangeable <em>One ANot Changeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Bs Not Changeable</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Bs Not Changeable</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getA10_ManyBsNotChangeable()
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.B10#getOneANotChangeable
	 * @model opposite="oneANotChangeable" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case010.oneToManyNotChangeable' metaObjectMofId='45F120A57A9FDF827396478901AEA0B83950C8A5' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<B10> getManyBsNotChangeable();

	/**
	 * Returns the value of the '<em><b>Many Bs Ordered</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case010.B10}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Bs Ordered</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Bs Ordered</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getA10_ManyBsOrdered()
	 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case010.oneToManyOrdered' metaObjectMofId='45F120A55B2570009EB141D11715BD866BAB797D' storedEnd='1' compositeEnd='-1' orderedEnd='0' exposedEndNumber='1'"
	 * @generated
	 */
	EList<B10> getManyBsOrdered();

	/**
	 * Returns the value of the '<em><b>Many Bs Changeable</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case010.B10}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.query2.test.mm.testcases.case010.B10#getOneAChangeable <em>One AChangeable</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Bs Changeable</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Bs Changeable</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getA10_ManyBsChangeable()
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.B10#getOneAChangeable
	 * @model opposite="oneAChangeable" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case010.oneToManyChangeable' metaObjectMofId='45F120A549F4BCE8C69B48AB095DC5A6D9B1DA5D' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<B10> getManyBsChangeable();

	/**
	 * Returns the value of the '<em><b>Navigable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Navigable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Navigable</em>' reference.
	 * @see #setNavigable(B10)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case010.Case010Package#getA10_Navigable()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case010.NotNavigableToNavigable' metaObjectMofId='45F120A504F13285A2584A761006BBCC154790E8' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	B10 getNavigable();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case010.A10#getNavigable <em>Navigable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Navigable</em>' reference.
	 * @see #getNavigable()
	 * @generated
	 */
	void setNavigable(B10 value);

} // A10
