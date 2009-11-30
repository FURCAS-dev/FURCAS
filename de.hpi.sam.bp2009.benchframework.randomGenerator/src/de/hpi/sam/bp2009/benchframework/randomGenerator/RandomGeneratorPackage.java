/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorFactory
 * @model kind="package"
 * @generated
 */
public interface RandomGeneratorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "randomGenerator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.randomGenerator";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework.randomGenerator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RandomGeneratorPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl <em>Random Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl
	 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorPackageImpl#getRandomGenerator()
	 * @generated
	 */
	int RANDOM_GENERATOR = 0;

	/**
	 * The feature id for the '<em><b>Default Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_GENERATOR__DEFAULT_OPTION = BenchframeworkPackage.GENERATOR__DEFAULT_OPTION;

	/**
	 * The number of structural features of the '<em>Random Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_GENERATOR_FEATURE_COUNT = BenchframeworkPackage.GENERATOR_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGenerator <em>Random Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Generator</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGenerator
	 * @generated
	 */
	EClass getRandomGenerator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RandomGeneratorFactory getRandomGeneratorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl <em>Random Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorImpl
		 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorPackageImpl#getRandomGenerator()
		 * @generated
		 */
		EClass RANDOM_GENERATOR = eINSTANCE.getRandomGenerator();

	}

} //RandomGeneratorPackage
