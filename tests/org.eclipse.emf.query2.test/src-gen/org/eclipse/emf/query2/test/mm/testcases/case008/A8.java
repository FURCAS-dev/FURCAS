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
package org.eclipse.emf.query2.test.mm.testcases.case008;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A8</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneEnumerationE <em>One Enumeration E</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneStructureS <em>One Structure S</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneStructureT <em>One Structure T</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneStructureV <em>One Structure V</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getManyEnumerationE <em>Many Enumeration E</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getManyStructureS <em>Many Structure S</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getA8()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case008.A8' metaObjectMofId='45F120A5127A94999671491413379870E97DF87B' isStructureType='false'"
 * @generated
 */
public interface A8 extends EObject {
	/**
	 * Returns the value of the '<em><b>One Enumeration E</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.query2.test.mm.testcases.case008.E8}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Enumeration E</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Enumeration E</em>' attribute.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.E8
	 * @see #setOneEnumerationE(E8)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getA8_OneEnumerationE()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	E8 getOneEnumerationE();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneEnumerationE <em>One Enumeration E</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Enumeration E</em>' attribute.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.E8
	 * @see #getOneEnumerationE()
	 * @generated
	 */
	void setOneEnumerationE(E8 value);

	/**
	 * Returns the value of the '<em><b>One Structure S</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Structure S</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Structure S</em>' containment reference.
	 * @see #setOneStructureS(S8)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getA8_OneStructureS()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A53075DF5D05334C0022C69986A32037AD'"
	 * @generated
	 */
	S8 getOneStructureS();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneStructureS <em>One Structure S</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Structure S</em>' containment reference.
	 * @see #getOneStructureS()
	 * @generated
	 */
	void setOneStructureS(S8 value);

	/**
	 * Returns the value of the '<em><b>One Structure T</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Structure T</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Structure T</em>' containment reference.
	 * @see #setOneStructureT(T8)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getA8_OneStructureT()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A5BAB50092ECBE47273671E48FAC25CD5C'"
	 * @generated
	 */
	T8 getOneStructureT();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneStructureT <em>One Structure T</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Structure T</em>' containment reference.
	 * @see #getOneStructureT()
	 * @generated
	 */
	void setOneStructureT(T8 value);

	/**
	 * Returns the value of the '<em><b>One Structure V</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Structure V</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Structure V</em>' containment reference.
	 * @see #setOneStructureV(V8)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getA8_OneStructureV()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='49675D0592F59800DE5811DDBD570019993BAD15'"
	 * @generated
	 */
	V8 getOneStructureV();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.A8#getOneStructureV <em>One Structure V</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Structure V</em>' containment reference.
	 * @see #getOneStructureV()
	 * @generated
	 */
	void setOneStructureV(V8 value);

	/**
	 * Returns the value of the '<em><b>Many Enumeration E</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case008.E8}.
	 * The literals are from the enumeration {@link org.eclipse.emf.query2.test.mm.testcases.case008.E8}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Enumeration E</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Enumeration E</em>' attribute list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.E8
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getA8_ManyEnumerationE()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	EList<E8> getManyEnumerationE();

	/**
	 * Returns the value of the '<em><b>Many Structure S</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case008.S8}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Structure S</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Structure S</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getA8_ManyStructureS()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='462F149F243C2A365E8B45CB384FCA031B1ACAB1'"
	 * @generated
	 */
	EList<S8> getManyStructureS();

} // A8
