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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>U8</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case008.U8#isSubField1 <em>Sub Field1</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getU8()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case008.U8' metaObjectMofId='49675BF2EEC91721DE5711DD94A10019993BAD15' isStructureType='true'"
 * @generated
 */
public interface U8 extends T8 {
	/**
	 * Returns the value of the '<em><b>Sub Field1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Field1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Field1</em>' attribute.
	 * @see #setSubField1(boolean)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case008.Case008Package#getU8_SubField1()
	 * @model required="true"
	 * @generated
	 */
	boolean isSubField1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case008.U8#isSubField1 <em>Sub Field1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Field1</em>' attribute.
	 * @see #isSubField1()
	 * @generated
	 */
	void setSubField1(boolean value);

} // U8
