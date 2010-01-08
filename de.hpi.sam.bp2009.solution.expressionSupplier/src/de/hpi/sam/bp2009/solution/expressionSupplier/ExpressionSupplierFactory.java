/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.expressionSupplier;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.solution.expressionSupplier.ExpressionSupplierPackage
 * @generated
 */
public interface ExpressionSupplierFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionSupplierFactory eINSTANCE = de.hpi.sam.bp2009.solution.expressionSupplier.impl.ExpressionSupplierFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Expression Supplier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Supplier</em>'.
	 * @generated
	 */
	ExpressionSupplier createExpressionSupplier();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExpressionSupplierPackage getExpressionSupplierPackage();

} //ExpressionSupplierFactory
