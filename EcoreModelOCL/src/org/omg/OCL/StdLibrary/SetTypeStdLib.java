/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary;

import com.sap.tc.moin.repository.mmi.Model.Classifier;

import org.omg.OCL.Types.CollectionType;
import org.omg.OCL.Types.SetType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Type Std Lib</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage#getSetTypeStdLib()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.StdLibrary.SetTypeStdLib' metaObjectMofId='45ED2E2983B5E1A17ED545372F4BEB032F90AF7F' isStructureType='false'"
 * @generated
 */
public interface SetTypeStdLib extends CollectionTypeStdLib {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" sUnique="false" sRequired="true" sOrdered="false"
	 * @generated
	 */
	CollectionType union(CollectionType s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" sUnique="false" sRequired="true" sOrdered="false"
	 * @generated
	 */
	boolean equalsStdLib(SetType s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" sUnique="false" sRequired="true" sOrdered="false"
	 * @generated
	 */
	CollectionType intersection(CollectionType s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" sUnique="false" sRequired="true" sOrdered="false"
	 * @generated
	 */
	SetType n(SetType s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	SetType including(Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	SetType excluding(Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" sUnique="false" sRequired="true" sOrdered="false"
	 * @generated
	 */
	SetType symmetricDifference(SetType s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	SetType flatten();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" sUnique="false" sRequired="true" sOrdered="false"
	 * @generated
	 */
	SetType minusStdLib(SetType s);

} // SetTypeStdLib
