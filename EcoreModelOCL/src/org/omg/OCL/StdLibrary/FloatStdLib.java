/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Float Std Lib</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage#getFloatStdLib()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.StdLibrary.FloatStdLib' metaObjectMofId='45ED2E29FDD74AB18360422C3730F6CE5E13D54C' isStructureType='false'"
 * @generated
 */
public interface FloatStdLib extends OclAnyStdLib {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" rUnique="false" rRequired="true" rOrdered="false"
	 * @generated
	 */
	float plusStdLib(float r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" rUnique="false" rRequired="true" rOrdered="false"
	 * @generated
	 */
	float minusStdLib(float r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" rUnique="false" rRequired="true" rOrdered="false"
	 * @generated
	 */
	float multStdLib(float r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" rUnique="false" rRequired="true" rOrdered="false"
	 * @generated
	 */
	float divStdLib(float r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	float abs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int floor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int round();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" rUnique="false" rRequired="true" rOrdered="false"
	 * @generated
	 */
	float max(float r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" rUnique="false" rRequired="true" rOrdered="false"
	 * @generated
	 */
	float min(float r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" rUnique="false" rRequired="true" rOrdered="false"
	 * @generated
	 */
	boolean ltStdLib(float r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" rUnique="false" rRequired="true" rOrdered="false"
	 * @generated
	 */
	boolean gtStdLib(float r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" rUnique="false" rRequired="true" rOrdered="false"
	 * @generated
	 */
	boolean lteqStdLib(float r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" rUnique="false" rRequired="true" rOrdered="false"
	 * @generated
	 */
	boolean gteqStdLib(float r);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	float negStdLib();

} // FloatStdLib
