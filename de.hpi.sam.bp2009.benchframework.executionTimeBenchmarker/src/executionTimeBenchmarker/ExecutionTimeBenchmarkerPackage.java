/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package executionTimeBenchmarker;

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
 * @see executionTimeBenchmarker.ExecutionTimeBenchmarkerFactory
 * @model kind="package"
 * @generated
 */
public interface ExecutionTimeBenchmarkerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "executionTimeBenchmarker";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "executionTimeBenchmarker";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionTimeBenchmarkerPackage eINSTANCE = executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl.init();

	/**
	 * The meta object id for the '{@link executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerImpl <em>Execution Time Benchmarker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerImpl
	 * @see executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getExecutionTimeBenchmarker()
	 * @generated
	 */
	int EXECUTION_TIME_BENCHMARKER = 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER__RESULT = BenchframeworkPackage.BENCH_MARKER__RESULT;

	/**
	 * The number of structural features of the '<em>Execution Time Benchmarker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_FEATURE_COUNT = BenchframeworkPackage.BENCH_MARKER_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link executionTimeBenchmarker.impl.JETMResultObjectImpl <em>JETM Result Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see executionTimeBenchmarker.impl.JETMResultObjectImpl
	 * @see executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getJETMResultObject()
	 * @generated
	 */
	int JETM_RESULT_OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JETM_RESULT_OBJECT__START_TIME = BenchframeworkPackage.RESULT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JETM_RESULT_OBJECT__END_TIME = BenchframeworkPackage.RESULT_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Ticks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JETM_RESULT_OBJECT__TICKS = BenchframeworkPackage.RESULT_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Transaction Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JETM_RESULT_OBJECT__TRANSACTION_TIME = BenchframeworkPackage.RESULT_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>JETM Result Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JETM_RESULT_OBJECT_FEATURE_COUNT = BenchframeworkPackage.RESULT_OBJECT_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link executionTimeBenchmarker.ExecutionTimeBenchmarker <em>Execution Time Benchmarker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Time Benchmarker</em>'.
	 * @see executionTimeBenchmarker.ExecutionTimeBenchmarker
	 * @generated
	 */
	EClass getExecutionTimeBenchmarker();

	/**
	 * Returns the meta object for class '{@link executionTimeBenchmarker.JETMResultObject <em>JETM Result Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JETM Result Object</em>'.
	 * @see executionTimeBenchmarker.JETMResultObject
	 * @generated
	 */
	EClass getJETMResultObject();

	/**
	 * Returns the meta object for the attribute '{@link executionTimeBenchmarker.JETMResultObject#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see executionTimeBenchmarker.JETMResultObject#getStartTime()
	 * @see #getJETMResultObject()
	 * @generated
	 */
	EAttribute getJETMResultObject_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link executionTimeBenchmarker.JETMResultObject#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see executionTimeBenchmarker.JETMResultObject#getEndTime()
	 * @see #getJETMResultObject()
	 * @generated
	 */
	EAttribute getJETMResultObject_EndTime();

	/**
	 * Returns the meta object for the attribute '{@link executionTimeBenchmarker.JETMResultObject#getTicks <em>Ticks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ticks</em>'.
	 * @see executionTimeBenchmarker.JETMResultObject#getTicks()
	 * @see #getJETMResultObject()
	 * @generated
	 */
	EAttribute getJETMResultObject_Ticks();

	/**
	 * Returns the meta object for the attribute '{@link executionTimeBenchmarker.JETMResultObject#getTransactionTime <em>Transaction Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Time</em>'.
	 * @see executionTimeBenchmarker.JETMResultObject#getTransactionTime()
	 * @see #getJETMResultObject()
	 * @generated
	 */
	EAttribute getJETMResultObject_TransactionTime();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExecutionTimeBenchmarkerFactory getExecutionTimeBenchmarkerFactory();

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
		 * The meta object literal for the '{@link executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerImpl <em>Execution Time Benchmarker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerImpl
		 * @see executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getExecutionTimeBenchmarker()
		 * @generated
		 */
		EClass EXECUTION_TIME_BENCHMARKER = eINSTANCE.getExecutionTimeBenchmarker();
		/**
		 * The meta object literal for the '{@link executionTimeBenchmarker.impl.JETMResultObjectImpl <em>JETM Result Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see executionTimeBenchmarker.impl.JETMResultObjectImpl
		 * @see executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getJETMResultObject()
		 * @generated
		 */
		EClass JETM_RESULT_OBJECT = eINSTANCE.getJETMResultObject();
		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JETM_RESULT_OBJECT__START_TIME = eINSTANCE.getJETMResultObject_StartTime();
		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JETM_RESULT_OBJECT__END_TIME = eINSTANCE.getJETMResultObject_EndTime();
		/**
		 * The meta object literal for the '<em><b>Ticks</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JETM_RESULT_OBJECT__TICKS = eINSTANCE.getJETMResultObject_Ticks();
		/**
		 * The meta object literal for the '<em><b>Transaction Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JETM_RESULT_OBJECT__TRANSACTION_TIME = eINSTANCE.getJETMResultObject_TransactionTime();

	}

} //ExecutionTimeBenchmarkerPackage
