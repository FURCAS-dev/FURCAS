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
package org.eclipse.emf.query2.test.mm.testcases.case012;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>C12</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.emf.query2.test.mm.testcases.case012.Case012Package#getC12()
 * @model annotation="http://sap.com/MOIN metamodels='test.sap.com/tc/moin/metamodel/testcases[1.0.0]' metaObject='testcases.case012.C12' metaObjectMofId='45F120A53D0DB73BB01C473B0FF4960E7A1C2DB4' isStructureType='false'"
 * @generated
 */
public interface C12 extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inIntegerUnique="false" inIntegerRequired="true" inIntegerOrdered="false"
	 * @generated
	 */
	void operationInInteger(int inInteger);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inDUnique="false" inDRequired="true" inDOrdered="false"
	 * @generated
	 */
	void operationInD(D12 inD);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inManyBooleanUnique="false" inManyBooleanRequired="true" inManyBooleanMany="true" inManyBooleanOrdered="false"
	 * @generated
	 */
	void operationInManyBoolean(EList<Boolean> inManyBoolean);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inManyDsUnique="false" inManyDsRequired="true" inManyDsMany="true" inManyDsOrdered="false"
	 * @generated
	 */
	void operationInManyDs(EList<D12> inManyDs);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model outDoubleUnique="false" outDoubleRequired="true" outDoubleOrdered="false"
	 * @generated
	 */
	void operationOutDouble(double outDouble);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model outDUnique="false" outDRequired="true" outDOrdered="false"
	 * @generated
	 */
	void operationOutD(D12 outD);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model outManyFloatUnique="false" outManyFloatRequired="true" outManyFloatMany="true" outManyFloatOrdered="false"
	 * @generated
	 */
	void operationOutManyFloat(EList<Float> outManyFloat);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model manyDsUnique="false" manyDsRequired="true" manyDsMany="true" manyDsOrdered="false"
	 * @generated
	 */
	void operationOutManyDs(EList<D12> manyDs);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inoutLongUnique="false" inoutLongRequired="true" inoutLongOrdered="false"
	 * @generated
	 */
	void operationInoutLong(long inoutLong);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inoutLongOptionalUnique="false" inoutLongOptionalOrdered="false"
	 * @generated
	 */
	void operationInoutLongOptional(long inoutLongOptional);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inoutManyLongsUnique="false" inoutManyLongsMany="true" inoutManyLongsOrdered="false"
	 * @generated
	 */
	void operationInoutManyLongs(EList<Long> inoutManyLongs);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inoutManyLongsOrderedUnique="false" inoutManyLongsOrderedRequired="true" inoutManyLongsOrderedMany="true"
	 * @generated
	 */
	void operationInoutManyLongsOrdered(EList<Long> inoutManyLongsOrdered);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inoutDUnique="false" inoutDRequired="true" inoutDOrdered="false"
	 * @generated
	 */
	void operationInoutD(D12 inoutD);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model inoutManyDsUnique="false" inoutManyDsRequired="true" inoutManyDsMany="true" inoutManyDsOrdered="false"
	 * @generated
	 */
	void operationInoutManyDs(EList<D12> inoutManyDs);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int operationReturnInteger();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	D12 operationReturnD();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	EList<Integer> operationReturnManyInteger();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	EList<D12> operationReturnManyDs();

} // C12
