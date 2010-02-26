/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary;

import com.sap.tc.moin.repository.mmi.Model.Classifier;

import org.omg.OCL.Types.BagType;
import org.omg.OCL.Types.CollectionType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bag Type Std Lib</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage#getBagTypeStdLib()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.StdLibrary.BagTypeStdLib' metaObjectMofId='45ED2E29AC1A4BFACBA04E8B3C39E3FC1CEFE881' isStructureType='false'"
 * @generated
 */
public interface BagTypeStdLib extends CollectionTypeStdLib {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" bUnique="false" bRequired="true" bOrdered="false"
	 * @generated
	 */
	boolean equalsStdLib(BagType b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" bUnique="false" bRequired="true" bOrdered="false"
	 * @generated
	 */
	BagType union(CollectionType b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" bUnique="false" bRequired="true" bOrdered="false"
	 * @generated
	 */
	CollectionType intersection(CollectionType b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	BagType including(Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	BagType excluding(Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	BagType flatten();

} // BagTypeStdLib
