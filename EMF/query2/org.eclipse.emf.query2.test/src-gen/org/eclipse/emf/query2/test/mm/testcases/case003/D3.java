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
package org.eclipse.emf.query2.test.mm.testcases.case003;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>D3</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case003.D3#getRefD3ToY <em>Ref D3 To Y</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case003.Case003Package#getD3()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case003.D3' metaObjectMofId='45F120A51189C4009D3C491B0FA49159EAD37E6F' isStructureType='false'"
 * @generated
 */
public interface D3 extends A3 {
	/**
	 * Returns the value of the '<em><b>Ref D3 To Y</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case003.B3}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ref D3 To Y</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref D3 To Y</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.Case003Package#getD3_RefD3ToY()
	 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case003.OrderedReferences' metaObjectMofId='45F120A534B5066DF8B84556310F8C169E30DDE2' storedEnd='1' compositeEnd='-1' orderedEnd='0' exposedEndNumber='1'"
	 * @generated
	 */
	EList<B3> getRefD3ToY();

} // D3
