/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclEvaluator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.solution.oclEvaluator.OclEvaluatorPackage
 * @generated
 */
public interface OclEvaluatorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OclEvaluatorFactory eINSTANCE = de.hpi.sam.bp2009.solution.oclEvaluator.impl.OclEvaluatorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>OCL Evaluator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OCL Evaluator</em>'.
	 * @generated
	 */
	OCLEvaluator createOCLEvaluator();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	OclEvaluatorPackage getOclEvaluatorPackage();

} //OclEvaluatorFactory
