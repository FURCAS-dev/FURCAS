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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>T8</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.T8#getField1 <em>Field1</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.T8#getField2 <em>Field2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getT8()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case008.T8' metaObjectMofId='48201D2241442DE61B4A11DD94EC00199904B925' isStructureType='true'"
 * @generated
 */
public interface T8 extends EObject {
	/**
	 * Returns the value of the '<em><b>Field1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field1</em>' attribute.
	 * @see #setField1(int)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getT8_Field1()
	 * @model required="true"
	 * @generated
	 */
	int getField1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.T8#getField1 <em>Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field1</em>' attribute.
	 * @see #getField1()
	 * @generated
	 */
	void setField1(int value);

	/**
	 * Returns the value of the '<em><b>Field2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field2</em>' attribute.
	 * @see #setField2(String)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getT8_Field2()
	 * @model required="true"
	 * @generated
	 */
	String getField2();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.T8#getField2 <em>Field2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field2</em>' attribute.
	 * @see #getField2()
	 * @generated
	 */
	void setField2(String value);

} // T8
