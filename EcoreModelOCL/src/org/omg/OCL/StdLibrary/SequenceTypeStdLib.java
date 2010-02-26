/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary;

import com.sap.tc.moin.repository.mmi.Model.Classifier;

import org.omg.OCL.Types.SequenceType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Type Std Lib</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage#getSequenceTypeStdLib()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.StdLibrary.SequenceTypeStdLib' metaObjectMofId='45ED2E29F46B14105FFE42971C70B643565ADCEB' isStructureType='false'"
 * @generated
 */
public interface SequenceTypeStdLib extends CollectionTypeStdLib {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" sUnique="false" sRequired="true" sOrdered="false"
	 * @generated
	 */
	boolean equalsStdLib(SequenceType s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" sUnique="false" sRequired="true" sOrdered="false"
	 * @generated
	 */
	SequenceType union(SequenceType s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	SequenceType flatten();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	SequenceType append(Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	SequenceType prepend(Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" iUnique="false" iRequired="true" iOrdered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	SequenceType insertAt(int i, Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lowerUnique="false" lowerRequired="true" lowerOrdered="false" upperUnique="false" upperRequired="true" upperOrdered="false"
	 * @generated
	 */
	SequenceType subSequence(int lower, int upper);

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
	SequenceType including(Classifier o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" oUnique="false" oRequired="true" oOrdered="false"
	 * @generated
	 */
	SequenceType excluding(Classifier o);

} // SequenceTypeStdLib
