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
import org.omg.OCL.Types.OrderedSetType;
import org.omg.OCL.Types.SequenceType;
import org.omg.OCL.Types.SetType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type Std Lib</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage#getCollectionTypeStdLib()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.StdLibrary.CollectionTypeStdLib' metaObjectMofId='45ED2E29AA6650B52A0A4C141ACE8E378EC5E936' isStructureType='false'"
 * @generated
 */
public interface CollectionTypeStdLib extends Classifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int size();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	boolean includes(Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	boolean excludes(Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	int count(Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" cUnique="false" cRequired="true" cOrdered="false"
	 * @generated
	 */
	boolean includesAll(CollectionType c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" cUnique="false" cRequired="true" cOrdered="false"
	 * @generated
	 */
	boolean excludesAll(CollectionType c);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isEmpty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean notEmpty();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	Classifier sum();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" cUnique="false" cRequired="true" cOrdered="false"
	 * @generated
	 */
	SetType product(CollectionType c);

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
	BagType asBag();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	OrderedSetType asOrderedSet();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	SequenceType asSequence();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean oclIsUndefined();

} // CollectionTypeStdLib
