/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary;

import com.sap.tc.moin.repository.mmi.Model.Classifier;

import org.omg.OCL.Types.SetType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Any Std Lib</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage#getOclAnyStdLib()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.StdLibrary.OclAnyStdLib' metaObjectMofId='45ED2E29626779E1E17D496F14C3D2ED6DDD2C4B' isStructureType='false'"
 * @generated
 */
public interface OclAnyStdLib extends Classifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" o2Unique="false" o2Required="true" o2Ordered="false"
	 * @generated
	 */
	boolean equalsStdLib(Classifier o2);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" o2Unique="false" o2Required="true" o2Ordered="false"
	 * @generated
	 */
	boolean notEqualsStdLib(Classifier o2);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean oclIsNew();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean oclIsUndefined();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean oclIsInvalid();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" tUnique="false" tRequired="true" tOrdered="false"
	 * @generated
	 */
	Classifier oclAsType(Classifier t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" tUnique="false" tRequired="true" tOrdered="false"
	 * @generated
	 */
	boolean oclIsTypeOf(Classifier t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" tUnique="false" tRequired="true" tOrdered="false"
	 * @generated
	 */
	boolean oclIsKindOf(Classifier t);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	SetType asSet();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String toString();

} // OclAnyStdLib
