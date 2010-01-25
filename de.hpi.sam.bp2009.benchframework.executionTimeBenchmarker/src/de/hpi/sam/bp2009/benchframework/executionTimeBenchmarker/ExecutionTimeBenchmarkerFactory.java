/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage
 * @generated
 */
public interface ExecutionTimeBenchmarkerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionTimeBenchmarkerFactory eINSTANCE = de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Start</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start</em>'.
	 * @generated
	 */
	ExecutionTimeBenchmarkerStart createExecutionTimeBenchmarkerStart();

	/**
	 * Returns a new object of class '<em>End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End</em>'.
	 * @generated
	 */
	ExecutionTimeBenchmarkerEnd createExecutionTimeBenchmarkerEnd();

	/**
	 * Returns a new object of class '<em>JETM Result Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JETM Result Object</em>'.
	 * @generated
	 */
	JETMResultObject createJETMResultObject();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExecutionTimeBenchmarkerPackage getExecutionTimeBenchmarkerPackage();

} //ExecutionTimeBenchmarkerFactory
