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
package org.eclipse.emf.query2.test.mm.testcases.case004;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>has Cs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.hasCs#getF <em>F</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case004.hasCs#getC <em>C</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#gethasCs()
 * @model
 * @generated
 */
public interface hasCs extends EObject {
	/**
	 * Returns the value of the '<em><b>F</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>F</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>F</em>' reference.
	 * @see #setF(F4)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#gethasCs_F()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case004.hasCs' metaObjectMofId='45F120A5E076DC0D97AA4A8F163B8EF194C6281F' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	F4 getF();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case004.hasCs#getF <em>F</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>F</em>' reference.
	 * @see #getF()
	 * @generated
	 */
	void setF(F4 value);

	/**
	 * Returns the value of the '<em><b>C</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case004.C4}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>C</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>C</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case004.Case004Package#gethasCs_C()
	 * @model required="true" ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case004.hasCs' metaObjectMofId='45F120A5E076DC0D97AA4A8F163B8EF194C6281F' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<C4> getC();

} // hasCs
