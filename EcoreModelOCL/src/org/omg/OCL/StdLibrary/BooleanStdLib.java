/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Std Lib</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage#getBooleanStdLib()
 * @model annotation="http://sap.com/MOIN metamodels='sap.com/tc/moin/mof_1.4[1.0]' metaObject='OCL.StdLibrary.BooleanStdLib' metaObjectMofId='45ED2E29936A1B7BC643426C1D8E826FC8CA8D7B' isStructureType='false'"
 * @generated
 */
public interface BooleanStdLib extends OclAnyStdLib {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" bUnique="false" bRequired="true" bOrdered="false"
	 * @generated
	 */
	boolean or(boolean b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" bUnique="false" bRequired="true" bOrdered="false"
	 * @generated
	 */
	boolean and(boolean b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" bUnique="false" bRequired="true" bOrdered="false"
	 * @generated
	 */
	boolean xor(boolean b);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean not();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" required="true" ordered="false" bUnique="false" bRequired="true" bOrdered="false"
	 * @generated
	 */
	boolean implies(boolean b);

} // BooleanStdLib
