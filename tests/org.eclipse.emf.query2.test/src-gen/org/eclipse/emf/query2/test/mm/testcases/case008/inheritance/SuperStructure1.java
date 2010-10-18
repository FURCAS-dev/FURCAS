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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Super Structure1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure1#getSuperField1From1 <em>Super Field1 From1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure1#getSuperField2From1 <em>Super Field2 From1</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage#getSuperStructure1()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case008.inheritance.SuperStructure1' metaObjectMofId='487756D5CABCDC324F4711DDA9D3D7DB0A126A9B' isStructureType='true'"
 * @generated
 */
public interface SuperStructure1 extends EObject {
	/**
	 * Returns the value of the '<em><b>Super Field1 From1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Field1 From1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Field1 From1</em>' attribute.
	 * @see #setSuperField1From1(int)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage#getSuperStructure1_SuperField1From1()
	 * @model required="true"
	 * @generated
	 */
	int getSuperField1From1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure1#getSuperField1From1 <em>Super Field1 From1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Field1 From1</em>' attribute.
	 * @see #getSuperField1From1()
	 * @generated
	 */
	void setSuperField1From1(int value);

	/**
	 * Returns the value of the '<em><b>Super Field2 From1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Field2 From1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Field2 From1</em>' attribute.
	 * @see #setSuperField2From1(int)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage#getSuperStructure1_SuperField2From1()
	 * @model required="true"
	 * @generated
	 */
	int getSuperField2From1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SuperStructure1#getSuperField2From1 <em>Super Field2 From1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Field2 From1</em>' attribute.
	 * @see #getSuperField2From1()
	 * @generated
	 */
	void setSuperField2From1(int value);

} // SuperStructure1
