/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Std Lib</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage#getStringStdLib()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.StdLibrary.StringStdLib' metaObjectMofId='45ED2E291763650F53494A340D609041A1E4C024' isStructureType='false'"
 * @generated
 */
public interface StringStdLib extends OclAnyStdLib {
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
	 * @model unique="false" required="true" ordered="false" sUnique="false" sRequired="true" sOrdered="false"
	 * @generated
	 */
	String concat(String s);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" lowerUnique="false" lowerRequired="true" lowerOrdered="false" upperUnique="false" upperRequired="true" upperOrdered="false"
	 * @generated
	 */
	String subString(int lower, int upper);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	int toInteger();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	float toFloat();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	long toLong();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	double toDouble();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" regexUnique="false" regexRequired="true" regexOrdered="false"
	 * @generated
	 */
	boolean matches(String regex);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String toUpperCase();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String toLowerCase();

} // StringStdLib
