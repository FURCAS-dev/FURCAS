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
 * A representation of the model object '<em><b>A23</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package#getA23()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case023.A23' metaObjectMofId='481EF2C469CDD0731A9811DDCC8D00199904B925' isStructureType='false'"
 * @generated
 */
public interface A23 extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" alreadyFoundMany="true" alreadyFoundOrdered="false"
	 * @generated
	 */
	EList<C23> getCRecursive(EList<C23> alreadyFound);

} // A23
