/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.randomModelModifier;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierFactory
 * @model kind="package"
 * @generated
 */
public interface RandomModelModifierPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "randomModelModifier";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.randomModelModifier";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework.randomModelModifier";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RandomModelModifierPackage eINSTANCE = de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl <em>Random Model Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl
	 * @see de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierPackageImpl#getRandomModelModifier()
	 * @generated
	 */
	int RANDOM_MODEL_MODIFIER = 0;

	/**
	 * The feature id for the '<em><b>Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL_MODIFIER__OPTION = BenchframeworkPackage.OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL_MODIFIER__RESULT = BenchframeworkPackage.OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL_MODIFIER__TEST_RUN = BenchframeworkPackage.OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL_MODIFIER__NAME = BenchframeworkPackage.OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL_MODIFIER__DESCRIPTION = BenchframeworkPackage.OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Random Number Generator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL_MODIFIER__RANDOM_NUMBER_GENERATOR = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Random Model Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL_MODIFIER_FEATURE_COUNT = BenchframeworkPackage.OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierOptionObjectImpl <em>Option Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierOptionObjectImpl
	 * @see de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierPackageImpl#getRandomModelModifierOptionObject()
	 * @generated
	 */
	int RANDOM_MODEL_MODIFIER_OPTION_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Wizard Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL_MODIFIER_OPTION_OBJECT__WIZARD_PAGE = BenchframeworkPackage.OPTION_OBJECT__WIZARD_PAGE;

	/**
	 * The feature id for the '<em><b>Times</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TIMES = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Task</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TASK = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Option Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANDOM_MODEL_MODIFIER_OPTION_OBJECT_FEATURE_COUNT = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.randomModelModifier.Task <em>Task</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.randomModelModifier.Task
	 * @see de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierPackageImpl#getTask()
	 * @generated
	 */
	int TASK = 2;

	/**
	 * The meta object id for the '<em>Random</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Random
	 * @see de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierPackageImpl#getRandom()
	 * @generated
	 */
	int RANDOM = 3;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.randomModelModifier.RandomModelModifier <em>Random Model Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Random Model Modifier</em>'.
	 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifier
	 * @generated
	 */
	EClass getRandomModelModifier();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.randomModelModifier.RandomModelModifier#getRandomNumberGenerator <em>Random Number Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Random Number Generator</em>'.
	 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifier#getRandomNumberGenerator()
	 * @see #getRandomModelModifier()
	 * @generated
	 */
	EAttribute getRandomModelModifier_RandomNumberGenerator();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject <em>Option Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option Object</em>'.
	 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject
	 * @generated
	 */
	EClass getRandomModelModifierOptionObject();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject#getTimes <em>Times</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Times</em>'.
	 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject#getTimes()
	 * @see #getRandomModelModifierOptionObject()
	 * @generated
	 */
	EAttribute getRandomModelModifierOptionObject_Times();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject#getTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Task</em>'.
	 * @see de.hpi.sam.bp2009.randomModelModifier.RandomModelModifierOptionObject#getTask()
	 * @see #getRandomModelModifierOptionObject()
	 * @generated
	 */
	EAttribute getRandomModelModifierOptionObject_Task();

	/**
	 * Returns the meta object for enum '{@link de.hpi.sam.bp2009.randomModelModifier.Task <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Task</em>'.
	 * @see de.hpi.sam.bp2009.randomModelModifier.Task
	 * @generated
	 */
	EEnum getTask();

	/**
	 * Returns the meta object for data type '{@link java.util.Random <em>Random</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Random</em>'.
	 * @see java.util.Random
	 * @model instanceClass="java.util.Random"
	 * @generated
	 */
	EDataType getRandom();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RandomModelModifierFactory getRandomModelModifierFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl <em>Random Model Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierImpl
		 * @see de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierPackageImpl#getRandomModelModifier()
		 * @generated
		 */
		EClass RANDOM_MODEL_MODIFIER = eINSTANCE.getRandomModelModifier();

		/**
		 * The meta object literal for the '<em><b>Random Number Generator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_MODEL_MODIFIER__RANDOM_NUMBER_GENERATOR = eINSTANCE.getRandomModelModifier_RandomNumberGenerator();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierOptionObjectImpl <em>Option Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierOptionObjectImpl
		 * @see de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierPackageImpl#getRandomModelModifierOptionObject()
		 * @generated
		 */
		EClass RANDOM_MODEL_MODIFIER_OPTION_OBJECT = eINSTANCE.getRandomModelModifierOptionObject();

		/**
		 * The meta object literal for the '<em><b>Times</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TIMES = eINSTANCE.getRandomModelModifierOptionObject_Times();

		/**
		 * The meta object literal for the '<em><b>Task</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANDOM_MODEL_MODIFIER_OPTION_OBJECT__TASK = eINSTANCE.getRandomModelModifierOptionObject_Task();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.randomModelModifier.Task <em>Task</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.randomModelModifier.Task
		 * @see de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierPackageImpl#getTask()
		 * @generated
		 */
		EEnum TASK = eINSTANCE.getTask();

		/**
		 * The meta object literal for the '<em>Random</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Random
		 * @see de.hpi.sam.bp2009.randomModelModifier.impl.RandomModelModifierPackageImpl#getRandom()
		 * @generated
		 */
		EDataType RANDOM = eINSTANCE.getRandom();

	}

} //RandomModelModifierPackage
