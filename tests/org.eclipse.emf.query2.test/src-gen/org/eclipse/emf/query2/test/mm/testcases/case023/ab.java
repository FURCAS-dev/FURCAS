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
 * A representation of the model object '<em><b>ab</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.ab#getAToB <em>ATo B</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.ab#getBToA <em>BTo A</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package#getab()
 * @model
 * @generated
 */
public interface ab extends EObject {
	/**
	 * Returns the value of the '<em><b>ATo B</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case023.B23}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ATo B</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ATo B</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package#getab_AToB()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case023.ab' metaObjectMofId='481EF2C469CDD0791A9811DD989100199904B925' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<B23> getAToB();

	/**
	 * Returns the value of the '<em><b>BTo A</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case023.A23}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BTo A</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BTo A</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package#getab_BToA()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case023.ab' metaObjectMofId='481EF2C469CDD0791A9811DD989100199904B925' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<A23> getBToA();

} // ab
