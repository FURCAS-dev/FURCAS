/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.omg.OCL.StdLibrary;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.omg.OCL.StdLibrary.StdLibraryPackage
 * @generated
 */
public interface StdLibraryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StdLibraryFactory eINSTANCE = org.omg.OCL.StdLibrary.impl.StdLibraryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ocl Any Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Any Std Lib</em>'.
	 * @generated
	 */
	OclAnyStdLib createOclAnyStdLib();

	/**
	 * Returns a new object of class '<em>String Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Std Lib</em>'.
	 * @generated
	 */
	StringStdLib createStringStdLib();

	/**
	 * Returns a new object of class '<em>Boolean Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Std Lib</em>'.
	 * @generated
	 */
	BooleanStdLib createBooleanStdLib();

	/**
	 * Returns a new object of class '<em>Float Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Float Std Lib</em>'.
	 * @generated
	 */
	FloatStdLib createFloatStdLib();

	/**
	 * Returns a new object of class '<em>Collection Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Type Std Lib</em>'.
	 * @generated
	 */
	CollectionTypeStdLib createCollectionTypeStdLib();

	/**
	 * Returns a new object of class '<em>Set Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Type Std Lib</em>'.
	 * @generated
	 */
	SetTypeStdLib createSetTypeStdLib();

	/**
	 * Returns a new object of class '<em>Sequence Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Type Std Lib</em>'.
	 * @generated
	 */
	SequenceTypeStdLib createSequenceTypeStdLib();

	/**
	 * Returns a new object of class '<em>Bag Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bag Type Std Lib</em>'.
	 * @generated
	 */
	BagTypeStdLib createBagTypeStdLib();

	/**
	 * Returns a new object of class '<em>Ordered Set Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ordered Set Type Std Lib</em>'.
	 * @generated
	 */
	OrderedSetTypeStdLib createOrderedSetTypeStdLib();

	/**
	 * Returns a new object of class '<em>Ocl Void Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Void Std Lib</em>'.
	 * @generated
	 */
	OclVoidStdLib createOclVoidStdLib();

	/**
	 * Returns a new object of class '<em>Integer Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Std Lib</em>'.
	 * @generated
	 */
	IntegerStdLib createIntegerStdLib();

	/**
	 * Returns a new object of class '<em>Ocl Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Type Std Lib</em>'.
	 * @generated
	 */
	OclTypeStdLib createOclTypeStdLib();

	/**
	 * Returns a new object of class '<em>Tuple Type Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Type Std Lib</em>'.
	 * @generated
	 */
	TupleTypeStdLib createTupleTypeStdLib();

	/**
	 * Returns a new object of class '<em>Double Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Std Lib</em>'.
	 * @generated
	 */
	DoubleStdLib createDoubleStdLib();

	/**
	 * Returns a new object of class '<em>Long Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Long Std Lib</em>'.
	 * @generated
	 */
	LongStdLib createLongStdLib();

	/**
	 * Returns a new object of class '<em>Ocl Invalid Std Lib</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Invalid Std Lib</em>'.
	 * @generated
	 */
	OclInvalidStdLib createOclInvalidStdLib();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StdLibraryPackage getStdLibraryPackage();

} //StdLibraryFactory
