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
package org.eclipse.emf.query2.test.mm.testcases.case008.inheritance;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A8 Inheritance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getManySuperStructure1 <em>Many Super Structure1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSuperStructure1 <em>One Super Structure1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSuperStructure2 <em>One Super Structure2</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSubStructure1 <em>One Sub Structure1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSubStructure2 <em>One Sub Structure2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage#getA8Inheritance()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case008.inheritance.A8Inheritance' metaObjectMofId='4884B46A36C0E3F5573F11DD89D2001B776F88F3' isStructureType='false'"
 * @generated
 */
public interface A8Inheritance extends EObject {
	/**
	 * Returns the value of the '<em><b>Many Super Structure1</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Super Structure1</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Super Structure1</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage#getA8Inheritance_ManySuperStructure1()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='4884B46A36C0E3F0573F11DD8E40001B776F88F3'"
	 * @generated
	 */
	EList<SuperStructure1> getManySuperStructure1();

	/**
	 * Returns the value of the '<em><b>One Super Structure1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Super Structure1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Super Structure1</em>' containment reference.
	 * @see #setOneSuperStructure1(SuperStructure1)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage#getA8Inheritance_OneSuperStructure1()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='4884B46A36C0E3F1573F11DDB93F001B776F88F3'"
	 * @generated
	 */
	SuperStructure1 getOneSuperStructure1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSuperStructure1 <em>One Super Structure1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Super Structure1</em>' containment reference.
	 * @see #getOneSuperStructure1()
	 * @generated
	 */
	void setOneSuperStructure1(SuperStructure1 value);

	/**
	 * Returns the value of the '<em><b>One Super Structure2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Super Structure2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Super Structure2</em>' containment reference.
	 * @see #setOneSuperStructure2(SuperStructure2)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage#getA8Inheritance_OneSuperStructure2()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='4884B46A36C0E3F2573F11DD8E85001B776F88F3'"
	 * @generated
	 */
	SuperStructure2 getOneSuperStructure2();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSuperStructure2 <em>One Super Structure2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Super Structure2</em>' containment reference.
	 * @see #getOneSuperStructure2()
	 * @generated
	 */
	void setOneSuperStructure2(SuperStructure2 value);

	/**
	 * Returns the value of the '<em><b>One Sub Structure1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Sub Structure1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Sub Structure1</em>' containment reference.
	 * @see #setOneSubStructure1(SubStructure1)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage#getA8Inheritance_OneSubStructure1()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='4884B46A36C0E3F3573F11DDB9C0001B776F88F3'"
	 * @generated
	 */
	SubStructure1 getOneSubStructure1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSubStructure1 <em>One Sub Structure1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Sub Structure1</em>' containment reference.
	 * @see #getOneSubStructure1()
	 * @generated
	 */
	void setOneSubStructure1(SubStructure1 value);

	/**
	 * Returns the value of the '<em><b>One Sub Structure2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>One Sub Structure2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>One Sub Structure2</em>' containment reference.
	 * @see #setOneSubStructure2(SubStructure2)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage#getA8Inheritance_OneSubStructure2()
	 * @model containment="true" resolveProxies="true" required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN ovaMofId='4884B46A36C0E3F4573F11DD8F3C001B776F88F3'"
	 * @generated
	 */
	SubStructure2 getOneSubStructure2();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.A8Inheritance#getOneSubStructure2 <em>One Sub Structure2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>One Sub Structure2</em>' containment reference.
	 * @see #getOneSubStructure2()
	 * @generated
	 */
	void setOneSubStructure2(SubStructure2 value);

} // A8Inheritance
