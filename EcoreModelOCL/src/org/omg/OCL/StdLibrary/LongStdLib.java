/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Long Std Lib</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage#getLongStdLib()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.StdLibrary.LongStdLib' metaObjectMofId='45ED2E2A39277D849526407A280AFC94661884F2' isStructureType='false'"
 * @generated
 */
public interface LongStdLib extends OclAnyStdLib {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lUnique="false" lRequired="true" lOrdered="false"
	 * @generated
	 */
	long plusStdLib(long l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lUnique="false" lRequired="true" lOrdered="false"
	 * @generated
	 */
	long minusStdLib(long l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lUnique="false" lRequired="true" lOrdered="false"
	 * @generated
	 */
	long multStdLib(long l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lUnique="false" lRequired="true" lOrdered="false"
	 * @generated
	 */
	double divStdLib(long l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	long abs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lUnique="false" lRequired="true" lOrdered="false"
	 * @generated
	 */
	long longDivStdLib(long l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lUnique="false" lRequired="true" lOrdered="false"
	 * @generated
	 */
	long mod(long l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lUnique="false" lRequired="true" lOrdered="false"
	 * @generated
	 */
	long max(long l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lUnique="false" lRequired="true" lOrdered="false"
	 * @generated
	 */
	long min(long l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lUnique="false" lRequired="true" lOrdered="false"
	 * @generated
	 */
	boolean ltStdLib(long l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lUnique="false" lRequired="true" lOrdered="false"
	 * @generated
	 */
	boolean gtStdLib(long l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lUnique="false" lRequired="true" lOrdered="false"
	 * @generated
	 */
	boolean lteqStdLib(long l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lUnique="false" lRequired="true" lOrdered="false"
	 * @generated
	 */
	boolean gteqStdLib(long l);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	long negStdLib();

} // LongStdLib
