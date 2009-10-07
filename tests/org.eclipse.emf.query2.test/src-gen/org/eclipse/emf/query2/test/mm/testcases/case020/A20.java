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
package org.eclipse.emf.query2.test.mm.testcases.case020;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A20</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case020.A20#getSuper1 <em>Super1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case020.A20#getSuper2 <em>Super2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case020.A20#getRefSuper1 <em>Ref Super1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case020.A20#getRefSuper2 <em>Ref Super2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case020.Case020Package#getA20()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case020.A20' metaObjectMofId='464D79886658FDAF25754B8B13A4C82F2A4D173E' isStructureType='false' ova='super1,super2'"
 * @generated
 */
public interface A20 extends EObject {
	/**
	 * Returns the value of the '<em><b>Super1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super1</em>' containment reference.
	 * @see #setSuper1(Super1)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.Case020Package#getA20_Super1()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='464D79884FD8FE7BF89C42330CE2E9FD9AA6569F'"
	 * @generated
	 */
	Super1 getSuper1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case020.A20#getSuper1 <em>Super1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super1</em>' containment reference.
	 * @see #getSuper1()
	 * @generated
	 */
	void setSuper1(Super1 value);

	/**
	 * Returns the value of the '<em><b>Super2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super2</em>' containment reference.
	 * @see #setSuper2(Super2)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.Case020Package#getA20_Super2()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='464D798810C112FDF2D84DE93059FD560C181882'"
	 * @generated
	 */
	Super2 getSuper2();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case020.A20#getSuper2 <em>Super2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super2</em>' containment reference.
	 * @see #getSuper2()
	 * @generated
	 */
	void setSuper2(Super2 value);

	/**
	 * Returns the value of the '<em><b>Ref Super1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Super1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Super1</em>' reference.
	 * @see #setRefSuper1(Super1)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.Case020Package#getA20_RefSuper1()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case020.hasSuper1' metaObjectMofId='464D798859A6652ACB3045310C3997BB23520314' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	Super1 getRefSuper1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case020.A20#getRefSuper1 <em>Ref Super1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Super1</em>' reference.
	 * @see #getRefSuper1()
	 * @generated
	 */
	void setRefSuper1(Super1 value);

	/**
	 * Returns the value of the '<em><b>Ref Super2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref Super2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Super2</em>' reference.
	 * @see #setRefSuper2(Super2)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case020.Case020Package#getA20_RefSuper2()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case020.hasSuper2' metaObjectMofId='464D79888083D326422A477635A2E730024DAFD9' storedEnd='1' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	Super2 getRefSuper2();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case020.A20#getRefSuper2 <em>Ref Super2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ref Super2</em>' reference.
	 * @see #getRefSuper2()
	 * @generated
	 */
	void setRefSuper2(Super2 value);

} // A20
