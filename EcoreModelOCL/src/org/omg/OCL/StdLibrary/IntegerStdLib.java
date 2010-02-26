/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Std Lib</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage#getIntegerStdLib()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.StdLibrary.IntegerStdLib' metaObjectMofId='45ED2E29E0380D2A55C54D502E3AE01FDDF9CA6C' isStructureType='false'"
 * @generated
 */
public interface IntegerStdLib extends OclAnyStdLib {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false"
	 * @generated
	 */
	int plusStdLib(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false"
	 * @generated
	 */
	int minusStdLib(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false"
	 * @generated
	 */
	int multStdLib(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false"
	 * @generated
	 */
	float divStdLib(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int abs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false"
	 * @generated
	 */
	int intDivStdLib(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false"
	 * @generated
	 */
	int mod(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false"
	 * @generated
	 */
	int max(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false"
	 * @generated
	 */
	int min(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false"
	 * @generated
	 */
	boolean ltStdLib(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false"
	 * @generated
	 */
	boolean gtStdLib(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false"
	 * @generated
	 */
	boolean lteqStdLib(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false"
	 * @generated
	 */
	boolean gteqStdLib(int i);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int negStdLib();

} // IntegerStdLib
