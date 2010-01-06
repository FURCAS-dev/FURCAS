/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.solution.SolutionPackage
 * @generated
 */
public interface SolutionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SolutionFactory eINSTANCE = de.hpi.sam.bp2009.solution.impl.SolutionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Expression Supplier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Supplier</em>'.
	 * @generated
	 */
	ExpressionSupplier createExpressionSupplier();

	/**
	 * Returns a new object of class '<em>Impact Analyzer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Impact Analyzer</em>'.
	 * @generated
	 */
	ImpactAnalyzer createImpactAnalyzer();

	/**
	 * Returns a new object of class '<em>Ocl Evaluator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Evaluator</em>'.
	 * @generated
	 */
	OclEvaluator createOclEvaluator();

	/**
	 * Returns a new object of class '<em>Persistenz</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Persistenz</em>'.
	 * @generated
	 */
	Persistenz createPersistenz();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SolutionPackage getSolutionPackage();

} //SolutionFactory
