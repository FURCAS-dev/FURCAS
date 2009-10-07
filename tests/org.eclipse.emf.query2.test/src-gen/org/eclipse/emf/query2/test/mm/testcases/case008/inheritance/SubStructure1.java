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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Structure1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure1#getSubField1 <em>Sub Field1</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage#getSubStructure1()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case008.inheritance.SubStructure1' metaObjectMofId='487756D5CABCDC364F4711DD962FD7DB0A126A9B' isStructureType='true'"
 * @generated
 */
public interface SubStructure1 extends SuperStructure1 {
	/**
	 * Returns the value of the '<em><b>Sub Field1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Field1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Field1</em>' attribute.
	 * @see #setSubField1(float)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.InheritancePackage#getSubStructure1_SubField1()
	 * @model required="true"
	 * @generated
	 */
	float getSubField1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.inheritance.SubStructure1#getSubField1 <em>Sub Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Field1</em>' attribute.
	 * @see #getSubField1()
	 * @generated
	 */
	void setSubField1(float value);

} // SubStructure1
