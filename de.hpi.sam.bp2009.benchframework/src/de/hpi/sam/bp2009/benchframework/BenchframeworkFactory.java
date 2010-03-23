/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage
 * @generated
 */
public interface BenchframeworkFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BenchframeworkFactory eINSTANCE = de.hpi.sam.bp2009.benchframework.impl.BenchframeworkFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Engine</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Engine</em>'.
	 * @generated
	 */
	Engine createEngine();

	/**
	 * Returns a new object of class '<em>Result Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result Object</em>'.
	 * @generated
	 */
	ResultObject createResultObject();

	/**
	 * Returns a new object of class '<em>Test Run</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Run</em>'.
	 * @generated
	 */
	TestRun createTestRun();

	/**
	 * Returns a new object of class '<em>Random Number Option Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Number Option Object</em>'.
	 * @generated
	 */
	RandomNumberOptionObject createRandomNumberOptionObject();

	/**
	 * Returns a new object of class '<em>Start Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Operator</em>'.
	 * @generated
	 */
	StartOperator createStartOperator();

	/**
	 * Returns a new object of class '<em>End Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End Operator</em>'.
	 * @generated
	 */
	EndOperator createEndOperator();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	BenchframeworkPackage getBenchframeworkPackage();

} //BenchframeworkFactory
