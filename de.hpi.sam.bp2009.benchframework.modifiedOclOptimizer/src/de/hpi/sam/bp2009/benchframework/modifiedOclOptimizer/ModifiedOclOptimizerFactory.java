/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.ModifiedOclOptimizerPackage
 * @generated
 */
public interface ModifiedOclOptimizerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifiedOclOptimizerFactory eINSTANCE = de.hpi.sam.bp2009.benchframework.modifiedOclOptimizer.impl.ModifiedOclOptimizerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Modified Ocl Optimizer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modified Ocl Optimizer</em>'.
	 * @generated
	 */
	ModifiedOclOptimizer createModifiedOclOptimizer();

	/**
	 * Returns a new object of class '<em>Embed Modified Ocl Opt Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Embed Modified Ocl Opt Operator</em>'.
	 * @generated
	 */
	EmbedModifiedOclOptOperator createEmbedModifiedOclOptOperator();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModifiedOclOptimizerPackage getModifiedOclOptimizerPackage();

} //ModifiedOclOptimizerFactory
