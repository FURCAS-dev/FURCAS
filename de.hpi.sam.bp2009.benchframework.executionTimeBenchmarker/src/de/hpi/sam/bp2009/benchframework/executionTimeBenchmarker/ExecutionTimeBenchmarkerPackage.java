/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerFactory
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
	String eNS_PREFIX = "benchframework.executionTimeBenchmarker";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionTimeBenchmarkerPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerStartImpl <em>Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerStartImpl
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getExecutionTimeBenchmarkerStart()
	 * @generated
	 */
	int EXECUTION_TIME_BENCHMARKER_START = 0;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_START__OPTION = BenchframeworkPackage.START_OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_START__RESULT = BenchframeworkPackage.START_OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_START__TEST_RUN = BenchframeworkPackage.START_OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_START__NAME = BenchframeworkPackage.START_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_START__DESCRIPTION = BenchframeworkPackage.START_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>End Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_START__END_OPERATOR = BenchframeworkPackage.START_OPERATOR__END_OPERATOR;

	/**
	 * The feature id for the '<em><b>Monitor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_START__MONITOR = BenchframeworkPackage.START_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_START__POINT = BenchframeworkPackage.START_OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>String To Point</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_START__STRING_TO_POINT = BenchframeworkPackage.START_OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_START_FEATURE_COUNT = BenchframeworkPackage.START_OPERATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerEndImpl <em>End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerEndImpl
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getExecutionTimeBenchmarkerEnd()
	 * @generated
	 */
	int EXECUTION_TIME_BENCHMARKER_END = 1;

	/**
	 * The feature id for the '<em><b>Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_END__OPTION = BenchframeworkPackage.END_OPERATOR__OPTION;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_END__RESULT = BenchframeworkPackage.END_OPERATOR__RESULT;

	/**
	 * The feature id for the '<em><b>Test Run</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_END__TEST_RUN = BenchframeworkPackage.END_OPERATOR__TEST_RUN;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_END__NAME = BenchframeworkPackage.END_OPERATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_END__DESCRIPTION = BenchframeworkPackage.END_OPERATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Start Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_END__START_OPERATOR = BenchframeworkPackage.END_OPERATOR__START_OPERATOR;

	/**
	 * The number of structural features of the '<em>End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_END_FEATURE_COUNT = BenchframeworkPackage.END_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.JETMResultObjectImpl <em>JETM Result Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.JETMResultObjectImpl
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getJETMResultObject()
	 * @generated
	 */
	int JETM_RESULT_OBJECT = 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JETM_RESULT_OBJECT__STATUS = BenchframeworkPackage.RESULT_OBJECT__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JETM_RESULT_OBJECT__MESSAGE = BenchframeworkPackage.RESULT_OBJECT__MESSAGE;

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
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerOptionObjectImpl <em>Option Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerOptionObjectImpl
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getExecutionTimeBenchmarkerOptionObject()
	 * @generated
	 */
	int EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT = 3;

	/**
	 * The feature id for the '<em><b>Wizard Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__WIZARD_PAGE = BenchframeworkPackage.OPTION_OBJECT__WIZARD_PAGE;

	/**
	 * The feature id for the '<em><b>Start Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__START_LITERAL = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__CLASS_LITERAL = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>End Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__END_LITERAL = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Option Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT_FEATURE_COUNT = BenchframeworkPackage.OPTION_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.JETMMultiResultObjectImpl <em>JETM Multi Result Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.JETMMultiResultObjectImpl
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getJETMMultiResultObject()
	 * @generated
	 */
	int JETM_MULTI_RESULT_OBJECT = 4;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JETM_MULTI_RESULT_OBJECT__STATUS = BenchframeworkPackage.RESULT_OBJECT__STATUS;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JETM_MULTI_RESULT_OBJECT__MESSAGE = BenchframeworkPackage.RESULT_OBJECT__MESSAGE;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JETM_MULTI_RESULT_OBJECT__RESULTS = BenchframeworkPackage.RESULT_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JETM Multi Result Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JETM_MULTI_RESULT_OBJECT_FEATURE_COUNT = BenchframeworkPackage.RESULT_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.EStringToETMPointMapImpl <em>EString To ETM Point Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.EStringToETMPointMapImpl
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getEStringToETMPointMap()
	 * @generated
	 */
	int ESTRING_TO_ETM_POINT_MAP = 5;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ETM_POINT_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ETM_POINT_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>EString To ETM Point Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_ETM_POINT_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.MeasurableClassLiterals <em>Measurable Class Literals</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.MeasurableClassLiterals
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getMeasurableClassLiterals()
	 * @generated
	 */
	int MEASURABLE_CLASS_LITERALS = 6;

	/**
	 * The meta object id for the '<em>ETM Monitor</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see etm.core.monitor.EtmMonitor
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getETMMonitor()
	 * @generated
	 */
	int ETM_MONITOR = 7;


	/**
	 * The meta object id for the '<em>ETM Point</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see etm.core.monitor.EtmPoint
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getETMPoint()
	 * @generated
	 */
	int ETM_POINT = 8;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart
	 * @generated
	 */
	EClass getExecutionTimeBenchmarkerStart();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getMonitor <em>Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Monitor</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getMonitor()
	 * @see #getExecutionTimeBenchmarkerStart()
	 * @generated
	 */
	EAttribute getExecutionTimeBenchmarkerStart_Monitor();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Point</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getPoint()
	 * @see #getExecutionTimeBenchmarkerStart()
	 * @generated
	 */
	EAttribute getExecutionTimeBenchmarkerStart_Point();

	/**
	 * Returns the meta object for the map '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getStringToPoint <em>String To Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>String To Point</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart#getStringToPoint()
	 * @see #getExecutionTimeBenchmarkerStart()
	 * @generated
	 */
	EReference getExecutionTimeBenchmarkerStart_StringToPoint();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd
	 * @generated
	 */
	EClass getExecutionTimeBenchmarkerEnd();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject <em>JETM Result Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JETM Result Object</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject
	 * @generated
	 */
	EClass getJETMResultObject();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Time</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject#getStartTime()
	 * @see #getJETMResultObject()
	 * @generated
	 */
	EAttribute getJETMResultObject_StartTime();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Time</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject#getEndTime()
	 * @see #getJETMResultObject()
	 * @generated
	 */
	EAttribute getJETMResultObject_EndTime();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject#getTicks <em>Ticks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ticks</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject#getTicks()
	 * @see #getJETMResultObject()
	 * @generated
	 */
	EAttribute getJETMResultObject_Ticks();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject#getTransactionTime <em>Transaction Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Time</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject#getTransactionTime()
	 * @see #getJETMResultObject()
	 * @generated
	 */
	EAttribute getJETMResultObject_TransactionTime();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject <em>Option Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option Object</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject
	 * @generated
	 */
	EClass getExecutionTimeBenchmarkerOptionObject();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject#getStartLiteral <em>Start Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Literal</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject#getStartLiteral()
	 * @see #getExecutionTimeBenchmarkerOptionObject()
	 * @generated
	 */
	EAttribute getExecutionTimeBenchmarkerOptionObject_StartLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject#getClassLiteral <em>Class Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Literal</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject#getClassLiteral()
	 * @see #getExecutionTimeBenchmarkerOptionObject()
	 * @generated
	 */
	EAttribute getExecutionTimeBenchmarkerOptionObject_ClassLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject#getEndLiteral <em>End Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Literal</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerOptionObject#getEndLiteral()
	 * @see #getExecutionTimeBenchmarkerOptionObject()
	 * @generated
	 */
	EAttribute getExecutionTimeBenchmarkerOptionObject_EndLiteral();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMMultiResultObject <em>JETM Multi Result Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JETM Multi Result Object</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMMultiResultObject
	 * @generated
	 */
	EClass getJETMMultiResultObject();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMMultiResultObject#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMMultiResultObject#getResults()
	 * @see #getJETMMultiResultObject()
	 * @generated
	 */
	EReference getJETMMultiResultObject_Results();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To ETM Point Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To ETM Point Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyDataType="org.eclipse.emf.ecore.EString"
	 *        valueDataType="de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ETMPoint"
	 * @generated
	 */
	EClass getEStringToETMPointMap();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToETMPointMap()
	 * @generated
	 */
	EAttribute getEStringToETMPointMap_Key();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToETMPointMap()
	 * @generated
	 */
	EAttribute getEStringToETMPointMap_Value();

	/**
	 * Returns the meta object for enum '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.MeasurableClassLiterals <em>Measurable Class Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Measurable Class Literals</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.MeasurableClassLiterals
	 * @generated
	 */
	EEnum getMeasurableClassLiterals();

	/**
	 * Returns the meta object for data type '{@link etm.core.monitor.EtmMonitor <em>ETM Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ETM Monitor</em>'.
	 * @see etm.core.monitor.EtmMonitor
	 * @model instanceClass="etm.core.monitor.EtmMonitor"
	 * @generated
	 */
	EDataType getETMMonitor();

	/**
	 * Returns the meta object for data type '{@link etm.core.monitor.EtmPoint <em>ETM Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>ETM Point</em>'.
	 * @see etm.core.monitor.EtmPoint
	 * @model instanceClass="etm.core.monitor.EtmPoint"
	 * @generated
	 */
	EDataType getETMPoint();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerStartImpl <em>Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerStartImpl
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getExecutionTimeBenchmarkerStart()
		 * @generated
		 */
		EClass EXECUTION_TIME_BENCHMARKER_START = eINSTANCE.getExecutionTimeBenchmarkerStart();

		/**
		 * The meta object literal for the '<em><b>Monitor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_TIME_BENCHMARKER_START__MONITOR = eINSTANCE.getExecutionTimeBenchmarkerStart_Monitor();

		/**
		 * The meta object literal for the '<em><b>Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_TIME_BENCHMARKER_START__POINT = eINSTANCE.getExecutionTimeBenchmarkerStart_Point();

		/**
		 * The meta object literal for the '<em><b>String To Point</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_TIME_BENCHMARKER_START__STRING_TO_POINT = eINSTANCE.getExecutionTimeBenchmarkerStart_StringToPoint();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerEndImpl <em>End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerEndImpl
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getExecutionTimeBenchmarkerEnd()
		 * @generated
		 */
		EClass EXECUTION_TIME_BENCHMARKER_END = eINSTANCE.getExecutionTimeBenchmarkerEnd();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.JETMResultObjectImpl <em>JETM Result Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.JETMResultObjectImpl
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getJETMResultObject()
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

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerOptionObjectImpl <em>Option Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerOptionObjectImpl
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getExecutionTimeBenchmarkerOptionObject()
		 * @generated
		 */
		EClass EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT = eINSTANCE.getExecutionTimeBenchmarkerOptionObject();

		/**
		 * The meta object literal for the '<em><b>Start Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__START_LITERAL = eINSTANCE.getExecutionTimeBenchmarkerOptionObject_StartLiteral();

		/**
		 * The meta object literal for the '<em><b>Class Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__CLASS_LITERAL = eINSTANCE.getExecutionTimeBenchmarkerOptionObject_ClassLiteral();

		/**
		 * The meta object literal for the '<em><b>End Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_TIME_BENCHMARKER_OPTION_OBJECT__END_LITERAL = eINSTANCE.getExecutionTimeBenchmarkerOptionObject_EndLiteral();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.JETMMultiResultObjectImpl <em>JETM Multi Result Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.JETMMultiResultObjectImpl
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getJETMMultiResultObject()
		 * @generated
		 */
		EClass JETM_MULTI_RESULT_OBJECT = eINSTANCE.getJETMMultiResultObject();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JETM_MULTI_RESULT_OBJECT__RESULTS = eINSTANCE.getJETMMultiResultObject_Results();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.EStringToETMPointMapImpl <em>EString To ETM Point Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.EStringToETMPointMapImpl
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getEStringToETMPointMap()
		 * @generated
		 */
		EClass ESTRING_TO_ETM_POINT_MAP = eINSTANCE.getEStringToETMPointMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_ETM_POINT_MAP__KEY = eINSTANCE.getEStringToETMPointMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESTRING_TO_ETM_POINT_MAP__VALUE = eINSTANCE.getEStringToETMPointMap_Value();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.MeasurableClassLiterals <em>Measurable Class Literals</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.MeasurableClassLiterals
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getMeasurableClassLiterals()
		 * @generated
		 */
		EEnum MEASURABLE_CLASS_LITERALS = eINSTANCE.getMeasurableClassLiterals();

		/**
		 * The meta object literal for the '<em>ETM Monitor</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see etm.core.monitor.EtmMonitor
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getETMMonitor()
		 * @generated
		 */
		EDataType ETM_MONITOR = eINSTANCE.getETMMonitor();

		/**
		 * The meta object literal for the '<em>ETM Point</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see etm.core.monitor.EtmPoint
		 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl.ExecutionTimeBenchmarkerPackageImpl#getETMPoint()
		 * @generated
		 */
		EDataType ETM_POINT = eINSTANCE.getETMPoint();

	}

} //ExecutionTimeBenchmarkerPackage
