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
package org.eclipse.emf.query2.test.mm.testcases.case009;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Throws Exception</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case009.Case009Package#getClassThrowsException()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case009.ClassThrowsException' metaObjectMofId='45F120A57D450A94A44B409139D1DCBB942EF1EE' isStructureType='false'"
 * @generated
 */
public interface ClassThrowsException extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String operationThrowsEx9();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model throwEx9Unique="false" throwEx9Required="true" throwEx9Ordered="false" throwFx9Unique="false" throwFx9Required="true" throwFx9Ordered="false"
	 * @generated
	 */
	void operationThrowsEx9AndFx9(boolean throwEx9, boolean throwFx9);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model throwEx9Unique="false" throwEx9Required="true" throwEx9Ordered="false" throwFx9Unique="false" throwFx9Required="true" throwFx9Ordered="false"
	 * @generated
	 */
	void changingOperationThrowsEx9AndFx9(boolean throwEx9, boolean throwFx9);

} // ClassThrowsException
