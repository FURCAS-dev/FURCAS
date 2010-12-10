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
package org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query2.test.mm.testcases.case005.p1.A5;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.Association2#getY <em>Y</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.Association2#getD5 <em>D5</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.P4Package#getAssociation2()
 * @model
 * @generated
 */
public interface Association2 extends EObject {
	/**
	 * Returns the value of the '<em><b>Y</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' reference.
	 * @see #setY(A5)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.P4Package#getAssociation2_Y()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case005.p3.p4.Association2' metaObjectMofId='45F120A5F42E369C47F94BF235129C103A6B5A13' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	A5 getY();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.Association2#getY <em>Y</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' reference.
	 * @see #getY()
	 * @generated
	 */
	void setY(A5 value);

	/**
	 * Returns the value of the '<em><b>D5</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>D5</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>D5</em>' reference.
	 * @see #setD5(D5)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.P4Package#getAssociation2_D5()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case005.p3.p4.Association2' metaObjectMofId='45F120A5F42E369C47F94BF235129C103A6B5A13' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	D5 getD5();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case005.p3.p4.Association2#getD5 <em>D5</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>D5</em>' reference.
	 * @see #getD5()
	 * @generated
	 */
	void setD5(D5 value);

} // Association2
