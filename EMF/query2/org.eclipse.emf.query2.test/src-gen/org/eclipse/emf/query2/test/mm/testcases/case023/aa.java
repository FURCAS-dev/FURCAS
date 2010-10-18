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
 * A representation of the model object '<em><b>aa</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.aa#getADown <em>ADown</em>}</li>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case023.aa#getAUp <em>AUp</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package#getaa()
 * @model
 * @generated
 */
public interface aa extends EObject {
	/**
	 * Returns the value of the '<em><b>ADown</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case023.A23}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ADown</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ADown</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package#getaa_ADown()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case023.aa' metaObjectMofId='481EF2C469CDD0861A9811DDBC7C00199904B925' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='0'"
	 * @generated
	 */
	EList<A23> getADown();

	/**
	 * Returns the value of the '<em><b>AUp</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case023.A23}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>AUp</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>AUp</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package#getaa_AUp()
	 * @model ordered="false"
	 *        annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case023.aa' metaObjectMofId='481EF2C469CDD0861A9811DDBC7C00199904B925' storedEnd='0' compositeEnd='-1' orderedEnd='-1' exposedEndNumber='1'"
	 * @generated
	 */
	EList<A23> getAUp();

} // aa
