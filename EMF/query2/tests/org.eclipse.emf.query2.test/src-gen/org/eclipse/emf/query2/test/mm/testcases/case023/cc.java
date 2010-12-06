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
package org.eclipse.emf.query2.test.mm.testcases.case023;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>cc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.cc#getDependents <em>Dependents</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.cc#getC23 <em>C23</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package#getcc()
 * @model
 * @generated
 */
public interface cc extends EObject {
	/**
	 * Returns the value of the '<em><b>Dependents</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case023.C23}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependents</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package#getcc_Dependents()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case023.cc' metaObjectMofId='481F32A47C77B0321ABE11DD8EE800199904B925' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<C23> getDependents();

	/**
	 * Returns the value of the '<em><b>C23</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>C23</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>C23</em>' reference.
	 * @see #setC23(C23)
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package#getcc_C23()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case023.cc' metaObjectMofId='481F32A47C77B0321ABE11DD8EE800199904B925' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	C23 getC23();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.query2.test.mm.testcases.case023.cc#getC23 <em>C23</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>C23</em>' reference.
	 * @see #getC23()
	 * @generated
	 */
	void setC23(C23 value);

} // cc
