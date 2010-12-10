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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>A1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case001.A1#getBs <em>Bs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case001.Case001Package#getA1()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case001.A1' metaObjectMofId='45F120A5F0623F45C23A4B101DF7DEF019BC78EC' isStructureType='false' ova='bs'"
 * @generated
 */
public interface A1 extends Super {
	/**
	 * Returns the value of the '<em><b>Bs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case001.B1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bs</em>' containment reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case001.Case001Package#getA1_Bs()
	 * @model containment="true" resolveProxies="true"
	 *        annotation="http://sap.com/MOIN ovaMofId='45F120A55832B44EB2E2426E2EF7BB03980CD710'"
	 * @generated
	 */
	EList<B1> getBs();

} // A1
