/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.loopOperator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

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
 * <!-- begin-model-doc -->
 * Package contains Start and EndPointOperator to define a loop for a test run.
 * All Operators that are located between start and end in the operator list of the test run will be duplicated and queued to the testrun
 * 
 * Note: Duplicate means that new instances of the same Type are created and option object are shared
 * <!-- end-model-doc -->
 * @see de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorFactory
 * @model kind="package"
 * @generated
 */
public interface LoopOperatorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "loopOperator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.loopOperator";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework.loopOperator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LoopOperatorPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorStartImpl <em>Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorStartImpl
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorPackageImpl#getLoopOperatorStart()
	 * @generated
	 */
	int LOOP_OPERATOR_START = 0;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_START__OPTION = BenchframeworkPackage.START_OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_START__RESULT = BenchframeworkPackage.START_OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_START__TEST_RUN = BenchframeworkPackage.START_OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_START__NAME = BenchframeworkPackage.START_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_START__DESCRIPTION = BenchframeworkPackage.START_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>End Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_START__END_OPERATOR = BenchframeworkPackage.START_OPERATOR__END_OPERATOR;

	/**
	 * The number of structural features of the '<em>Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_START_FEATURE_COUNT = BenchframeworkPackage.START_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorEndImpl <em>End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorEndImpl
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorPackageImpl#getLoopOperatorEnd()
	 * @generated
	 */
	int LOOP_OPERATOR_END = 1;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_END__OPTION = BenchframeworkPackage.END_OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_END__RESULT = BenchframeworkPackage.END_OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_END__TEST_RUN = BenchframeworkPackage.END_OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_END__NAME = BenchframeworkPackage.END_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_END__DESCRIPTION = BenchframeworkPackage.END_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Start Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_END__START_OPERATOR = BenchframeworkPackage.END_OPERATOR__START_OPERATOR;

	/**
	 * The number of structural features of the '<em>End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_END_FEATURE_COUNT = BenchframeworkPackage.END_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorOptionObjectImpl <em>Option Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorOptionObjectImpl
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorPackageImpl#getLoopOperatorOptionObject()
	 * @generated
	 */
	int LOOP_OPERATOR_OPTION_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Wizard Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_OPTION_OBJECT__WIZARD_PAGE = BenchframeworkPackage.OPTION_OBJECT__WIZARD_PAGE;

	/**
	 * The feature id for the '<em><b>Loop Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_OPTION_OBJECT__LOOP_COUNT = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Option Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_OPERATOR_OPTION_OBJECT_FEATURE_COUNT = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorStart
	 * @generated
	 */
	EClass getLoopOperatorStart();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorEnd
	 * @generated
	 */
	EClass getLoopOperatorEnd();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorOptionObject <em>Option Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option Object</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorOptionObject
	 * @generated
	 */
	EClass getLoopOperatorOptionObject();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorOptionObject#getLoopCount <em>Loop Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loop Count</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.loopOperator.LoopOperatorOptionObject#getLoopCount()
	 * @see #getLoopOperatorOptionObject()
	 * @generated
	 */
	EAttribute getLoopOperatorOptionObject_LoopCount();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LoopOperatorFactory getLoopOperatorFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorStartImpl <em>Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorStartImpl
		 * @see de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorPackageImpl#getLoopOperatorStart()
		 * @generated
		 */
		EClass LOOP_OPERATOR_START = eINSTANCE.getLoopOperatorStart();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorEndImpl <em>End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorEndImpl
		 * @see de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorPackageImpl#getLoopOperatorEnd()
		 * @generated
		 */
		EClass LOOP_OPERATOR_END = eINSTANCE.getLoopOperatorEnd();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorOptionObjectImpl <em>Option Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorOptionObjectImpl
		 * @see de.hpi.sam.bp2009.benchframework.loopOperator.impl.LoopOperatorPackageImpl#getLoopOperatorOptionObject()
		 * @generated
		 */
		EClass LOOP_OPERATOR_OPTION_OBJECT = eINSTANCE.getLoopOperatorOptionObject();

		/**
		 * The meta object literal for the '<em><b>Loop Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP_OPERATOR_OPTION_OBJECT__LOOP_COUNT = eINSTANCE.getLoopOperatorOptionObject_LoopCount();

	}

} //LoopOperatorPackage
