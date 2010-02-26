/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary;

import com.sap.tc.moin.repository.mmi.Model.Classifier;

import org.omg.OCL.Types.OrderedSetType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ordered Set Type Std Lib</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage#getOrderedSetTypeStdLib()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.StdLibrary.OrderedSetTypeStdLib' metaObjectMofId='45ED2E290E6B723558384B7209B4C045EF349EE6' isStructureType='false'"
 * @generated
 */
public interface OrderedSetTypeStdLib extends CollectionTypeStdLib {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	OrderedSetType append(Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	OrderedSetType prepend(Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" indexUnique="false" indexRequired="true" indexOrdered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	OrderedSetType insertAt(int index, Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lowerUnique="false" lowerRequired="true" lowerOrdered="false" upperUnique="false" upperRequired="true" upperOrdered="false"
	 * @generated
	 */
	OrderedSetType subOrderedSet(int lower, int upper);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false"
	 * @generated
	 */
	Classifier at(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	int indexOf(Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	Classifier first();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	Classifier last();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	boolean equalsStdLib(OrderedSetType o);

} // OrderedSetTypeStdLib
