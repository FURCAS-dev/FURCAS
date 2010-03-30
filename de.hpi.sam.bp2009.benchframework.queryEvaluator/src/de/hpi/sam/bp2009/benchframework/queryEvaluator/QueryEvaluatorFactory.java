/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.queryEvaluator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.queryEvaluator.QueryEvaluatorPackage
 * @generated
 */
public interface QueryEvaluatorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QueryEvaluatorFactory eINSTANCE = de.hpi.sam.bp2009.benchframework.queryEvaluator.impl.QueryEvaluatorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Embed QE Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Embed QE Operator</em>'.
	 * @generated
	 */
	EmbedQEOperator createEmbedQEOperator();

	/**
	 * Returns a new object of class '<em>Query Evaluator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query Evaluator</em>'.
	 * @generated
	 */
	QueryEvaluator createQueryEvaluator();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QueryEvaluatorPackage getQueryEvaluatorPackage();

} //QueryEvaluatorFactory
