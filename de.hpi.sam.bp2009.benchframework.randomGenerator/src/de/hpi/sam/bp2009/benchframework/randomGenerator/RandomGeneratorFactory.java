/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorPackage
 * @generated
 */
public interface RandomGeneratorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RandomGeneratorFactory eINSTANCE = de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Random Generator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Random Generator</em>'.
	 * @generated
	 */
	RandomGenerator createRandomGenerator();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	RandomGeneratorPackage getRandomGeneratorPackage();

} //RandomGeneratorFactory
