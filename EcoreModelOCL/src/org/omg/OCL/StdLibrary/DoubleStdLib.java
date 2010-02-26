/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Std Lib</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage#getDoubleStdLib()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.StdLibrary.DoubleStdLib' metaObjectMofId='45ED2E2A639716B339E648510C3BC4DC46A17FC2' isStructureType='false'"
 * @generated
 */
public interface DoubleStdLib extends OclAnyStdLib {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" dUnique="false" dRequired="true" dOrdered="false"
	 * @generated
	 */
	double plusStdLib(double d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" dUnique="false" dRequired="true" dOrdered="false"
	 * @generated
	 */
	double minusStdLib(double d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" dUnique="false" dRequired="true" dOrdered="false"
	 * @generated
	 */
	double multStdLib(double d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" dUnique="false" dRequired="true" dOrdered="false"
	 * @generated
	 */
	double divStdLib(double d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	double abs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	long floor();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	long round();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" dUnique="false" dRequired="true" dOrdered="false"
	 * @generated
	 */
	double max(double d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" dUnique="false" dRequired="true" dOrdered="false"
	 * @generated
	 */
	double min(double d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" dUnique="false" dRequired="true" dOrdered="false"
	 * @generated
	 */
	boolean ltStdLib(double d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" dUnique="false" dRequired="true" dOrdered="false"
	 * @generated
	 */
	boolean gtStdLib(double d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" dUnique="false" dRequired="true" dOrdered="false"
	 * @generated
	 */
	boolean lteqStdLib(double d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" dUnique="false" dRequired="true" dOrdered="false"
	 * @generated
	 */
	boolean gteqStdLib(double d);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	double negStdLib();

} // DoubleStdLib
