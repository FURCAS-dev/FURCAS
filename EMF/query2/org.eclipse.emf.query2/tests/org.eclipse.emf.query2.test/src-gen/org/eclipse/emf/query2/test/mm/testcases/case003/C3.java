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
 * A representation of the model object '<em><b>C3</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.query2.test.mm.testcases.case003.C3#getY <em>Y</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case003.Case003Package#getC3()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case003.C3' metaObjectMofId='45F120A55FB34719251A43E81161B826F8EE9DF5' isStructureType='false'"
 * @generated
 */
public interface C3 extends A3 {
	/**
	 * Returns the value of the '<em><b>Y</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.query2.test.mm.testcases.case003.B3}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' reference list.
	 * @see org.eclipse.emf.query2.test.mm.testcases.case003.Case003Package#getC3_Y()
	 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case003.OrderedReferences' metaObjectMofId='45F120A534B5066DF8B84556310F8C169E30DDE2' storedEnd='1' compositeEnd='-1' orderedEnd='0' exposedEndNumber='1'"
	 * @generated
	 */
	EList<B3> getY();

} // C3
