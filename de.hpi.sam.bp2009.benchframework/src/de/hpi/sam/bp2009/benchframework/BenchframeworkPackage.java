/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkFactory
 * @model kind="package"
 * @generated
 */
public interface BenchframeworkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "benchframework";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.benchframework";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "benchframework";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BenchframeworkPackage eINSTANCE = de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.impl.EngineImpl <em>Engine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.impl.EngineImpl
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getEngine()
	 * @generated
	 */
	int ENGINE = 0;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__OPERATORS = 0;

	/**
	 * The feature id for the '<em><b>Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__RESULTS = 1;

	/**
	 * The feature id for the '<em><b>Generators</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__GENERATORS = 2;

	/**
	 * The feature id for the '<em><b>Bench Markers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE__BENCH_MARKERS = 3;

	/**
	 * The number of structural features of the '<em>Engine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.impl.OperatorImpl
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 1;

	/**
	 * The feature id for the '<em><b>Default Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR__DEFAULT_OPTION = 0;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.impl.GeneratorImpl <em>Generator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.impl.GeneratorImpl
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getGenerator()
	 * @generated
	 */
	int GENERATOR = 2;

	/**
	 * The feature id for the '<em><b>Default Option</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR__DEFAULT_OPTION = 0;

	/**
	 * The number of structural features of the '<em>Generator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.impl.ResultProcessorImpl <em>Result Processor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.impl.ResultProcessorImpl
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getResultProcessor()
	 * @generated
	 */
	int RESULT_PROCESSOR = 3;

	/**
	 * The number of structural features of the '<em>Result Processor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_PROCESSOR_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.impl.OptionObjectImpl <em>Option Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.impl.OptionObjectImpl
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getOptionObject()
	 * @generated
	 */
	int OPTION_OBJECT = 4;

	/**
	 * The number of structural features of the '<em>Option Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_OBJECT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl <em>Result Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getResultObject()
	 * @generated
	 */
	int RESULT_OBJECT = 5;

	/**
	 * The number of structural features of the '<em>Result Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESULT_OBJECT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.benchframework.impl.BenchMarkerImpl <em>Bench Marker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchMarkerImpl
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getBenchMarker()
	 * @generated
	 */
	int BENCH_MARKER = 6;

	/**
	 * The feature id for the '<em><b>Result</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENCH_MARKER__RESULT = 0;

	/**
	 * The number of structural features of the '<em>Bench Marker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BENCH_MARKER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '<em>Output Stream</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.io.OutputStream
	 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getOutputStream()
	 * @generated
	 */
	int OUTPUT_STREAM = 7;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.Engine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Engine</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Engine
	 * @generated
	 */
	EClass getEngine();

	/**
	 * Returns the meta object for the reference list '{@link de.hpi.sam.bp2009.benchframework.Engine#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Operators</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Engine#getOperators()
	 * @see #getEngine()
	 * @generated
	 */
	EReference getEngine_Operators();

	/**
	 * Returns the meta object for the reference list '{@link de.hpi.sam.bp2009.benchframework.Engine#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Results</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Engine#getResults()
	 * @see #getEngine()
	 * @generated
	 */
	EReference getEngine_Results();

	/**
	 * Returns the meta object for the reference list '{@link de.hpi.sam.bp2009.benchframework.Engine#getGenerators <em>Generators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Generators</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Engine#getGenerators()
	 * @see #getEngine()
	 * @generated
	 */
	EReference getEngine_Generators();

	/**
	 * Returns the meta object for the reference list '{@link de.hpi.sam.bp2009.benchframework.Engine#getBenchMarkers <em>Bench Markers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Bench Markers</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Engine#getBenchMarkers()
	 * @see #getEngine()
	 * @generated
	 */
	EReference getEngine_BenchMarkers();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.benchframework.Operator#getDefaultOption <em>Default Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Option</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Operator#getDefaultOption()
	 * @see #getOperator()
	 * @generated
	 */
	EReference getOperator_DefaultOption();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.Generator <em>Generator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generator</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Generator
	 * @generated
	 */
	EClass getGenerator();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.benchframework.Generator#getDefaultOption <em>Default Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Default Option</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.Generator#getDefaultOption()
	 * @see #getGenerator()
	 * @generated
	 */
	EReference getGenerator_DefaultOption();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.ResultProcessor <em>Result Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Processor</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.ResultProcessor
	 * @generated
	 */
	EClass getResultProcessor();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.OptionObject <em>Option Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option Object</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.OptionObject
	 * @generated
	 */
	EClass getOptionObject();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.ResultObject <em>Result Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result Object</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.ResultObject
	 * @generated
	 */
	EClass getResultObject();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.benchframework.BenchMarker <em>Bench Marker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bench Marker</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.BenchMarker
	 * @generated
	 */
	EClass getBenchMarker();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.benchframework.BenchMarker#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result</em>'.
	 * @see de.hpi.sam.bp2009.benchframework.BenchMarker#getResult()
	 * @see #getBenchMarker()
	 * @generated
	 */
	EReference getBenchMarker_Result();

	/**
	 * Returns the meta object for data type '{@link java.io.OutputStream <em>Output Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Output Stream</em>'.
	 * @see java.io.OutputStream
	 * @model instanceClass="java.io.OutputStream"
	 * @generated
	 */
	EDataType getOutputStream();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BenchframeworkFactory getBenchframeworkFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.impl.EngineImpl <em>Engine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.impl.EngineImpl
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getEngine()
		 * @generated
		 */
		EClass ENGINE = eINSTANCE.getEngine();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE__OPERATORS = eINSTANCE.getEngine_Operators();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE__RESULTS = eINSTANCE.getEngine_Results();

		/**
		 * The meta object literal for the '<em><b>Generators</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE__GENERATORS = eINSTANCE.getEngine_Generators();

		/**
		 * The meta object literal for the '<em><b>Bench Markers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENGINE__BENCH_MARKERS = eINSTANCE.getEngine_BenchMarkers();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.impl.OperatorImpl
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em><b>Default Option</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATOR__DEFAULT_OPTION = eINSTANCE.getOperator_DefaultOption();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.impl.GeneratorImpl <em>Generator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.impl.GeneratorImpl
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getGenerator()
		 * @generated
		 */
		EClass GENERATOR = eINSTANCE.getGenerator();

		/**
		 * The meta object literal for the '<em><b>Default Option</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR__DEFAULT_OPTION = eINSTANCE.getGenerator_DefaultOption();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.impl.ResultProcessorImpl <em>Result Processor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.impl.ResultProcessorImpl
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getResultProcessor()
		 * @generated
		 */
		EClass RESULT_PROCESSOR = eINSTANCE.getResultProcessor();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.impl.OptionObjectImpl <em>Option Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.impl.OptionObjectImpl
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getOptionObject()
		 * @generated
		 */
		EClass OPTION_OBJECT = eINSTANCE.getOptionObject();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl <em>Result Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.impl.ResultObjectImpl
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getResultObject()
		 * @generated
		 */
		EClass RESULT_OBJECT = eINSTANCE.getResultObject();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.benchframework.impl.BenchMarkerImpl <em>Bench Marker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchMarkerImpl
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getBenchMarker()
		 * @generated
		 */
		EClass BENCH_MARKER = eINSTANCE.getBenchMarker();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BENCH_MARKER__RESULT = eINSTANCE.getBenchMarker_Result();

		/**
		 * The meta object literal for the '<em>Output Stream</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.io.OutputStream
		 * @see de.hpi.sam.bp2009.benchframework.impl.BenchframeworkPackageImpl#getOutputStream()
		 * @generated
		 */
		EDataType OUTPUT_STREAM = eINSTANCE.getOutputStream();

	}

} //BenchframeworkPackage
