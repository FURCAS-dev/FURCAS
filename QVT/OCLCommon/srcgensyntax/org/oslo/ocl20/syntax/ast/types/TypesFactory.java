/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.types;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.oslo.ocl20.syntax.ast.types.TypesPackage
 * @generated
 */
public interface TypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypesFactory eINSTANCE = org.oslo.ocl20.syntax.ast.types.impl.TypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bag Type AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bag Type AS</em>'.
	 * @generated
	 */
	BagTypeAS createBagTypeAS();

	/**
	 * Returns a new object of class '<em>Classifier AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Classifier AS</em>'.
	 * @generated
	 */
	ClassifierAS createClassifierAS();

	/**
	 * Returns a new object of class '<em>Collection Type AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Type AS</em>'.
	 * @generated
	 */
	CollectionTypeAS createCollectionTypeAS();

	/**
	 * Returns a new object of class '<em>Ordered Set Type AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ordered Set Type AS</em>'.
	 * @generated
	 */
	OrderedSetTypeAS createOrderedSetTypeAS();

	/**
	 * Returns a new object of class '<em>Sequence Type AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Type AS</em>'.
	 * @generated
	 */
	SequenceTypeAS createSequenceTypeAS();

	/**
	 * Returns a new object of class '<em>Set Type AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Type AS</em>'.
	 * @generated
	 */
	SetTypeAS createSetTypeAS();

	/**
	 * Returns a new object of class '<em>Tuple Type AS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tuple Type AS</em>'.
	 * @generated
	 */
	TupleTypeAS createTupleTypeAS();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TypesPackage getTypesPackage();

} //TypesFactory
