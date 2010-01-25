/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerEnd;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerFactory;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerStart;
import de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.JETMResultObject;

import etm.core.monitor.EtmMonitor;
import etm.core.monitor.EtmPoint;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionTimeBenchmarkerPackageImpl extends EPackageImpl implements ExecutionTimeBenchmarkerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionTimeBenchmarkerStartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionTimeBenchmarkerEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jetmResultObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType etmMonitorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType etmPointEDataType = null;

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
	 * @see de.hpi.sam.bp2009.benchframework.executionTimeBenchmarker.ExecutionTimeBenchmarkerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExecutionTimeBenchmarkerPackageImpl() {
		super(eNS_URI, ExecutionTimeBenchmarkerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ExecutionTimeBenchmarkerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExecutionTimeBenchmarkerPackage init() {
		if (isInited) return (ExecutionTimeBenchmarkerPackage)EPackage.Registry.INSTANCE.getEPackage(ExecutionTimeBenchmarkerPackage.eNS_URI);

		// Obtain or create and register package
		ExecutionTimeBenchmarkerPackageImpl theExecutionTimeBenchmarkerPackage = (ExecutionTimeBenchmarkerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExecutionTimeBenchmarkerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExecutionTimeBenchmarkerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BenchframeworkPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theExecutionTimeBenchmarkerPackage.createPackageContents();

		// Initialize created meta-data
		theExecutionTimeBenchmarkerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExecutionTimeBenchmarkerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ExecutionTimeBenchmarkerPackage.eNS_URI, theExecutionTimeBenchmarkerPackage);
		return theExecutionTimeBenchmarkerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionTimeBenchmarkerStart() {
		return executionTimeBenchmarkerStartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionTimeBenchmarkerStart_EndPoint() {
		return (EReference)executionTimeBenchmarkerStartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionTimeBenchmarkerStart_Monitor() {
		return (EAttribute)executionTimeBenchmarkerStartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionTimeBenchmarkerStart_Point() {
		return (EAttribute)executionTimeBenchmarkerStartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionTimeBenchmarkerEnd() {
		return executionTimeBenchmarkerEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExecutionTimeBenchmarkerEnd_StartPoint() {
		return (EReference)executionTimeBenchmarkerEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJETMResultObject() {
		return jetmResultObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJETMResultObject_StartTime() {
		return (EAttribute)jetmResultObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJETMResultObject_EndTime() {
		return (EAttribute)jetmResultObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJETMResultObject_Ticks() {
		return (EAttribute)jetmResultObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getJETMResultObject_TransactionTime() {
		return (EAttribute)jetmResultObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getETMMonitor() {
		return etmMonitorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getETMPoint() {
		return etmPointEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionTimeBenchmarkerFactory getExecutionTimeBenchmarkerFactory() {
		return (ExecutionTimeBenchmarkerFactory)getEFactoryInstance();
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
		executionTimeBenchmarkerStartEClass = createEClass(EXECUTION_TIME_BENCHMARKER_START);
		createEReference(executionTimeBenchmarkerStartEClass, EXECUTION_TIME_BENCHMARKER_START__END_POINT);
		createEAttribute(executionTimeBenchmarkerStartEClass, EXECUTION_TIME_BENCHMARKER_START__MONITOR);
		createEAttribute(executionTimeBenchmarkerStartEClass, EXECUTION_TIME_BENCHMARKER_START__POINT);

		executionTimeBenchmarkerEndEClass = createEClass(EXECUTION_TIME_BENCHMARKER_END);
		createEReference(executionTimeBenchmarkerEndEClass, EXECUTION_TIME_BENCHMARKER_END__START_POINT);

		jetmResultObjectEClass = createEClass(JETM_RESULT_OBJECT);
		createEAttribute(jetmResultObjectEClass, JETM_RESULT_OBJECT__START_TIME);
		createEAttribute(jetmResultObjectEClass, JETM_RESULT_OBJECT__END_TIME);
		createEAttribute(jetmResultObjectEClass, JETM_RESULT_OBJECT__TICKS);
		createEAttribute(jetmResultObjectEClass, JETM_RESULT_OBJECT__TRANSACTION_TIME);

		// Create data types
		etmMonitorEDataType = createEDataType(ETM_MONITOR);
		etmPointEDataType = createEDataType(ETM_POINT);
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

		// Obtain other dependent packages
		BenchframeworkPackage theBenchframeworkPackage = (BenchframeworkPackage)EPackage.Registry.INSTANCE.getEPackage(BenchframeworkPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		executionTimeBenchmarkerStartEClass.getESuperTypes().add(theBenchframeworkPackage.getOperator());
		executionTimeBenchmarkerEndEClass.getESuperTypes().add(theBenchframeworkPackage.getOperator());
		jetmResultObjectEClass.getESuperTypes().add(theBenchframeworkPackage.getResultObject());

		// Initialize classes and features; add operations and parameters
		initEClass(executionTimeBenchmarkerStartEClass, ExecutionTimeBenchmarkerStart.class, "ExecutionTimeBenchmarkerStart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionTimeBenchmarkerStart_EndPoint(), this.getExecutionTimeBenchmarkerEnd(), null, "endPoint", null, 0, 1, ExecutionTimeBenchmarkerStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionTimeBenchmarkerStart_Monitor(), this.getETMMonitor(), "monitor", null, 0, 1, ExecutionTimeBenchmarkerStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExecutionTimeBenchmarkerStart_Point(), this.getETMPoint(), "point", null, 0, 1, ExecutionTimeBenchmarkerStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(executionTimeBenchmarkerEndEClass, ExecutionTimeBenchmarkerEnd.class, "ExecutionTimeBenchmarkerEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExecutionTimeBenchmarkerEnd_StartPoint(), this.getExecutionTimeBenchmarkerStart(), null, "startPoint", null, 0, 1, ExecutionTimeBenchmarkerEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jetmResultObjectEClass, JETMResultObject.class, "JETMResultObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJETMResultObject_StartTime(), ecorePackage.getELong(), "startTime", null, 0, 1, JETMResultObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJETMResultObject_EndTime(), ecorePackage.getELong(), "endTime", null, 0, 1, JETMResultObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJETMResultObject_Ticks(), ecorePackage.getELong(), "ticks", null, 0, 1, JETMResultObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJETMResultObject_TransactionTime(), ecorePackage.getEDouble(), "transactionTime", null, 0, 1, JETMResultObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(jetmResultObjectEClass, ecorePackage.getELong(), "getDuration", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(etmMonitorEDataType, EtmMonitor.class, "ETMMonitor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(etmPointEDataType, EtmPoint.class, "ETMPoint", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ExecutionTimeBenchmarkerPackageImpl
