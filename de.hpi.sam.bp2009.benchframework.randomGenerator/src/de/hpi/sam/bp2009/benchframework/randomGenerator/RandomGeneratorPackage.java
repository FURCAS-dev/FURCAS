/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.randomGenerator;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import org.eclipse.emf.ecore.EAttribute;
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
	 * The feature id for the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_GENERATOR__OPTION = BenchframeworkPackage.OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_GENERATOR__RESULT = BenchframeworkPackage.OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_GENERATOR__TEST_RUN = BenchframeworkPackage.OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_GENERATOR__NAME = BenchframeworkPackage.OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_GENERATOR__DESCRIPTION = BenchframeworkPackage.OPERATOR__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Random Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_GENERATOR_FEATURE_COUNT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorOptionObjectImpl <em>Option Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorOptionObjectImpl
	 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorPackageImpl#getRandomGeneratorOptionObject()
	 * @generated
	 */
	int RANDOM_GENERATOR_OPTION_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Wizard Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_GENERATOR_OPTION_OBJECT__WIZARD_PAGE = BenchframeworkPackage.OPTION_OBJECT__WIZARD_PAGE;

	/**
	 * The feature id for the '<em><b>Meta Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Option Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_GENERATOR_OPTION_OBJECT_FEATURE_COUNT = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 1;


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
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject <em>Option Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option Object</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject
	 * @generated
	 */
	EClass getRandomGeneratorOptionObject();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject#getMetaModel <em>Meta Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Meta Model</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject#getMetaModel()
	 * @see #getRandomGeneratorOptionObject()
	 * @generated
	 */
	EAttribute getRandomGeneratorOptionObject_MetaModel();

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
		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorOptionObjectImpl <em>Option Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorOptionObjectImpl
		 * @see de.hpi.sam.bp2009.benchframework.randomGenerator.impl.RandomGeneratorPackageImpl#getRandomGeneratorOptionObject()
		 * @generated
		 */
		EClass RANDOM_GENERATOR_OPTION_OBJECT = eINSTANCE.getRandomGeneratorOptionObject();
		/**
		 * The meta object literal for the '<em><b>Meta Model</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_GENERATOR_OPTION_OBJECT__META_MODEL = eINSTANCE.getRandomGeneratorOptionObject_MetaModel();

	}

} //RandomGeneratorPackage
