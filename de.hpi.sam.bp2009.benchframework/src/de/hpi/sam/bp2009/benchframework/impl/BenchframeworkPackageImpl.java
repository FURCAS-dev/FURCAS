/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.impl;

import de.hpi.sam.bp2009.benchframework.BenchMarker;
import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;
import de.hpi.sam.bp2009.benchframework.Engine;
import de.hpi.sam.bp2009.benchframework.Generator;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.OptionObject;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.ResultProcessor;

import java.io.OutputStream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BenchframeworkPackageImpl extends EPackageImpl implements BenchframeworkPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass engineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resultProcessorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optionObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resultObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass benchMarkerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType outputStreamEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.hpi.sam.bp2009.benchframework.BenchframeworkPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BenchframeworkPackageImpl() {
		super(eNS_URI, BenchframeworkFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link BenchframeworkPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BenchframeworkPackage init() {
		if (isInited) return (BenchframeworkPackage)EPackage.Registry.INSTANCE.getEPackage(BenchframeworkPackage.eNS_URI);

		// Obtain or create and register package
		BenchframeworkPackageImpl theBenchframeworkPackage = (BenchframeworkPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BenchframeworkPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BenchframeworkPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theBenchframeworkPackage.createPackageContents();

		// Initialize created meta-data
		theBenchframeworkPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBenchframeworkPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BenchframeworkPackage.eNS_URI, theBenchframeworkPackage);
		return theBenchframeworkPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEngine() {
		return engineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEngine_Operators() {
		return (EReference)engineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEngine_Results() {
		return (EReference)engineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEngine_Generators() {
		return (EReference)engineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEngine_BenchMarkers() {
		return (EReference)engineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperator() {
		return operatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperator_DefaultOption() {
		return (EReference)operatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenerator() {
		return generatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGenerator_DefaultOption() {
		return (EReference)generatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResultProcessor() {
		return resultProcessorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOptionObject() {
		return optionObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResultObject() {
		return resultObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBenchMarker() {
		return benchMarkerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBenchMarker_Result() {
		return (EReference)benchMarkerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getOutputStream() {
		return outputStreamEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BenchframeworkFactory getBenchframeworkFactory() {
		return (BenchframeworkFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		engineEClass = createEClass(ENGINE);
		createEReference(engineEClass, ENGINE__OPERATORS);
		createEReference(engineEClass, ENGINE__RESULTS);
		createEReference(engineEClass, ENGINE__GENERATORS);
		createEReference(engineEClass, ENGINE__BENCH_MARKERS);

		operatorEClass = createEClass(OPERATOR);
		createEReference(operatorEClass, OPERATOR__DEFAULT_OPTION);

		generatorEClass = createEClass(GENERATOR);
		createEReference(generatorEClass, GENERATOR__DEFAULT_OPTION);

		resultProcessorEClass = createEClass(RESULT_PROCESSOR);

		optionObjectEClass = createEClass(OPTION_OBJECT);

		resultObjectEClass = createEClass(RESULT_OBJECT);

		benchMarkerEClass = createEClass(BENCH_MARKER);
		createEReference(benchMarkerEClass, BENCH_MARKER__RESULT);

		// Create data types
		outputStreamEDataType = createEDataType(OUTPUT_STREAM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(engineEClass, Engine.class, "Engine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEngine_Operators(), this.getOperator(), null, "operators", null, 0, -1, Engine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEngine_Results(), this.getResultProcessor(), null, "results", null, 0, -1, Engine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEngine_Generators(), this.getGenerator(), null, "generators", null, 0, -1, Engine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEngine_BenchMarkers(), this.getBenchMarker(), null, "benchMarkers", null, 0, -1, Engine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(engineEClass, null, "benchmark", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOutputStream(), "outputStream", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(operatorEClass, Operator.class, "Operator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperator_DefaultOption(), this.getOptionObject(), null, "defaultOption", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(operatorEClass, null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEResource(), "resource", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOptionObject(), "option", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(generatorEClass, Generator.class, "Generator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGenerator_DefaultOption(), this.getOptionObject(), null, "defaultOption", null, 0, 1, Generator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(generatorEClass, ecorePackage.getEResource(), "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOptionObject(), "option", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(resultProcessorEClass, ResultProcessor.class, "ResultProcessor", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(resultProcessorEClass, ecorePackage.getEBoolean(), "add", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEResource(), "resource", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOptionObject(), "generatorOption", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOptionObject(), "operatorOption", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getResultObject(), "result", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBenchMarker(), "benchmarker", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(resultProcessorEClass, null, "show", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOutputStream(), "out", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(optionObjectEClass, OptionObject.class, "OptionObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resultObjectEClass, ResultObject.class, "ResultObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(benchMarkerEClass, BenchMarker.class, "BenchMarker", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBenchMarker_Result(), this.getResultObject(), null, "result", null, 0, 1, BenchMarker.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(benchMarkerEClass, null, "start", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(benchMarkerEClass, null, "end", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(outputStreamEDataType, OutputStream.class, "OutputStream", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //BenchframeworkPackageImpl
