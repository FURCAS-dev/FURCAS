/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.oslo.ocl20.semantics.SemanticsPackage
 * @generated
 */
public interface SemanticsFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	SemanticsFactory eINSTANCE = org.oslo.ocl20.semantics.impl.SemanticsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Visitable</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Visitable</em>'.
	 * @generated
	 */
	SemanticsVisitable createSemanticsVisitable();

	/**
	 * Returns a new object of class '<em>Visitor</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Visitor</em>'.
	 * @generated
	 */
	SemanticsVisitor createSemanticsVisitor();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	SemanticsPackage getSemanticsPackage();

} // SemanticsFactory
