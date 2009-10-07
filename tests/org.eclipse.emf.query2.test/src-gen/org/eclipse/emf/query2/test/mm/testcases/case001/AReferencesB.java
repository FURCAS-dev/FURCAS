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
package org.eclipse.emf.query2.test.mm.testcases.case001;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AReferences B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case001.AReferencesB#getB <em>B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case001.AReferencesB#getA <em>A</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case001.Case001Package#getAReferencesB()
 * @model
 * @generated
 */
public interface AReferencesB extends EObject {
	/**
	 * Returns the value of the '<em><b>B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>B</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>B</em>' reference.
	 * @see #setB(B1)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.Case001Package#getAReferencesB_B()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case001.AReferencesB' metaObjectMofId='45F120A59095EA91E9D94B3D2EFEDEC0AC372B5E' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	B1 getB();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case001.AReferencesB#getB <em>B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>B</em>' reference.
	 * @see #getB()
	 * @generated
	 */
	void setB(B1 value);

	/**
	 * Returns the value of the '<em><b>A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>A</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>A</em>' reference.
	 * @see #setA(A1)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.Case001Package#getAReferencesB_A()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case001.AReferencesB' metaObjectMofId='45F120A59095EA91E9D94B3D2EFEDEC0AC372B5E' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	A1 getA();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case001.AReferencesB#getA <em>A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>A</em>' reference.
	 * @see #getA()
	 * @generated
	 */
	void setA(A1 value);

} // AReferencesB
