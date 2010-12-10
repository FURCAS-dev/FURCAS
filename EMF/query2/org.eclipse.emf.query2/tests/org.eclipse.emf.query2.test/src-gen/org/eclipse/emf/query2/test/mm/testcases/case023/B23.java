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
 * A representation of the model object '<em><b>B23</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case023.Case023Package#getB23()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case023.B23' metaObjectMofId='481EF2C469CDD0751A9811DDACB400199904B925' isStructureType='false'"
 * @generated
 */
public interface B23 extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" source1Many="true" source1Ordered="false" source2Many="true" source2Ordered="false"
	 * @generated
	 */
	EList<A23> collectA(EList<A23> source1, EList<A23> source2);

} // B23
