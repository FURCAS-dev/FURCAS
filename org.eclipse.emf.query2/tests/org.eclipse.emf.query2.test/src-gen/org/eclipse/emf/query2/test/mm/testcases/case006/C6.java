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
package org.eclipse.emf.query2.test.mm.testcases.case006;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>C6</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case006.C6#getX <em>X</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case006.C6#getW <em>W</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case006.Case006Package#getC6()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case006.C6' metaObjectMofId='45F120A588CB3F92067140110417D26E5B59CBB5' isStructureType='false'"
 * @generated
 */
public interface C6 extends EObject {
	/**
	 * Returns the value of the '<em><b>X</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' reference.
	 * @see #setX(B6)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case006.Case006Package#getC6_X()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case006.ReferenceAtComponent' metaObjectMofId='45F120A5ABFF703758D84FAB0AC9D0A6EE99728A' storedEnd='0' compositeEnd='1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	B6 getX();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case006.C6#getX <em>X</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' reference.
	 * @see #getX()
	 * @generated
	 */
	void setX(B6 value);

	/**
	 * Returns the value of the '<em><b>W</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>W</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>W</em>' containment reference.
	 * @see #setW(D6)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case006.Case006Package#getC6_W()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case006.ReferenceAtComposite' metaObjectMofId='45F120A51C4C3CE81D87441F1FD2B9F5C91CC80F' storedEnd='1' compositeEnd='1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	D6 getW();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case006.C6#getW <em>W</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>W</em>' containment reference.
	 * @see #getW()
	 * @generated
	 */
	void setW(D6 value);

} // C6
