/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator2;

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
 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOperator2Factory
 * @model kind="package"
 * @generated
 */
public interface LoopOperator2Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "loopOperator2";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.loopOperator2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework.loopOperator2";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LoopOperator2Package eINSTANCE = de.hpi.sam.bp2009.benchframework.loopOperator2.impl.LoopOperator2PackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.impl.StartLoopImpl <em>Start Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.impl.StartLoopImpl
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.impl.LoopOperator2PackageImpl#getStartLoop()
	 * @generated
	 */
	int START_LOOP = 0;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_LOOP__OPTION = BenchframeworkPackage.START_OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_LOOP__RESULT = BenchframeworkPackage.START_OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_LOOP__TEST_RUN = BenchframeworkPackage.START_OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_LOOP__NAME = BenchframeworkPackage.START_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_LOOP__DESCRIPTION = BenchframeworkPackage.START_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>End Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_LOOP__END_OPERATOR = BenchframeworkPackage.START_OPERATOR__END_OPERATOR;

	/**
	 * The number of structural features of the '<em>Start Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_LOOP_FEATURE_COUNT = BenchframeworkPackage.START_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.impl.EndLoopImpl <em>End Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.impl.EndLoopImpl
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.impl.LoopOperator2PackageImpl#getEndLoop()
	 * @generated
	 */
	int END_LOOP = 1;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_LOOP__OPTION = BenchframeworkPackage.END_OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_LOOP__RESULT = BenchframeworkPackage.END_OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_LOOP__TEST_RUN = BenchframeworkPackage.END_OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_LOOP__NAME = BenchframeworkPackage.END_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_LOOP__DESCRIPTION = BenchframeworkPackage.END_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Start Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_LOOP__START_OPERATOR = BenchframeworkPackage.END_OPERATOR__START_OPERATOR;

	/**
	 * The number of structural features of the '<em>End Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_LOOP_FEATURE_COUNT = BenchframeworkPackage.END_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.impl.LoopOptionImpl <em>Loop Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.impl.LoopOptionImpl
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.impl.LoopOperator2PackageImpl#getLoopOption()
	 * @generated
	 */
	int LOOP_OPTION = 2;

	/**
	 * The feature id for the '<em><b>Wizard Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPTION__WIZARD_PAGE = BenchframeworkPackage.OPTION_OBJECT__WIZARD_PAGE;

	/**
	 * The feature id for the '<em><b>Repetitions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPTION__REPETITIONS = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loop Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPTION_FEATURE_COUNT = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.StartLoop <em>Start Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Loop</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.StartLoop
	 * @generated
	 */
	EClass getStartLoop();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.EndLoop <em>End Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Loop</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.EndLoop
	 * @generated
	 */
	EClass getEndLoop();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOption <em>Loop Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Option</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOption
	 * @generated
	 */
	EClass getLoopOption();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOption#getRepetitions <em>Repetitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repetitions</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.LoopOption#getRepetitions()
	 * @see #getLoopOption()
	 * @generated
	 */
	EAttribute getLoopOption_Repetitions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LoopOperator2Factory getLoopOperator2Factory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.impl.StartLoopImpl <em>Start Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.impl.StartLoopImpl
		 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.impl.LoopOperator2PackageImpl#getStartLoop()
		 * @generated
		 */
		EClass START_LOOP = eINSTANCE.getStartLoop();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.impl.EndLoopImpl <em>End Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.impl.EndLoopImpl
		 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.impl.LoopOperator2PackageImpl#getEndLoop()
		 * @generated
		 */
		EClass END_LOOP = eINSTANCE.getEndLoop();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.loopOperator2.impl.LoopOptionImpl <em>Loop Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.impl.LoopOptionImpl
		 * @see de.hpi.sam.bp2009.benchframework.loopOperator2.impl.LoopOperator2PackageImpl#getLoopOption()
		 * @generated
		 */
		EClass LOOP_OPTION = eINSTANCE.getLoopOption();

		/**
		 * The meta object literal for the '<em><b>Repetitions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP_OPTION__REPETITIONS = eINSTANCE.getLoopOption_Repetitions();

	}

} //LoopOperator2Package
