/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.eventCounter.impl;

import de.hpi.sam.bp2009.benchframework.BenchframeworkPackage;

import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterEnd;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterFactory;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterOptionObject;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterResultObject;
import de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterStart;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventCounterPackageImpl extends EPackageImpl implements EventCounterPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventCounterStartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventCounterEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventCounterOptionObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventCounterResultObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType adapterEDataType = null;

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
	 * @see de.hpi.sam.bp2009.benchframework.eventCounter.EventCounterPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EventCounterPackageImpl() {
		super(eNS_URI, EventCounterFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EventCounterPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EventCounterPackage init() {
		if (isInited) return (EventCounterPackage)EPackage.Registry.INSTANCE.getEPackage(EventCounterPackage.eNS_URI);

		// Obtain or create and register package
		EventCounterPackageImpl theEventCounterPackage = (EventCounterPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EventCounterPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EventCounterPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BenchframeworkPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEventCounterPackage.createPackageContents();

		// Initialize created meta-data
		theEventCounterPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEventCounterPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EventCounterPackage.eNS_URI, theEventCounterPackage);
		return theEventCounterPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventCounterStart() {
		return eventCounterStartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventCounterStart_EndPoint() {
		return (EReference)eventCounterStartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventCounterStart_Adapter() {
		return (EAttribute)eventCounterStartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventCounterEnd() {
		return eventCounterEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventCounterEnd_StartPoint() {
		return (EReference)eventCounterEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventCounterOptionObject() {
		return eventCounterOptionObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventCounterResultObject() {
		return eventCounterResultObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventCounterResultObject_EventCounts() {
		return (EAttribute)eventCounterResultObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getAdapter() {
		return adapterEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventCounterFactory getEventCounterFactory() {
		return (EventCounterFactory)getEFactoryInstance();
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
		eventCounterStartEClass = createEClass(EVENT_COUNTER_START);
		createEReference(eventCounterStartEClass, EVENT_COUNTER_START__END_POINT);
		createEAttribute(eventCounterStartEClass, EVENT_COUNTER_START__ADAPTER);

		eventCounterEndEClass = createEClass(EVENT_COUNTER_END);
		createEReference(eventCounterEndEClass, EVENT_COUNTER_END__START_POINT);

		eventCounterOptionObjectEClass = createEClass(EVENT_COUNTER_OPTION_OBJECT);

		eventCounterResultObjectEClass = createEClass(EVENT_COUNTER_RESULT_OBJECT);
		createEAttribute(eventCounterResultObjectEClass, EVENT_COUNTER_RESULT_OBJECT__EVENT_COUNTS);

		// Create data types
		adapterEDataType = createEDataType(ADAPTER);
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
		eventCounterStartEClass.getESuperTypes().add(theBenchframeworkPackage.getOperator());
		eventCounterEndEClass.getESuperTypes().add(theBenchframeworkPackage.getOperator());
		eventCounterResultObjectEClass.getESuperTypes().add(theBenchframeworkPackage.getResultObject());

		// Initialize classes and features; add operations and parameters
		initEClass(eventCounterStartEClass, EventCounterStart.class, "EventCounterStart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventCounterStart_EndPoint(), this.getEventCounterEnd(), this.getEventCounterEnd_StartPoint(), "endPoint", null, 0, 1, EventCounterStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventCounterStart_Adapter(), this.getAdapter(), "adapter", null, 0, 1, EventCounterStart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventCounterEndEClass, EventCounterEnd.class, "EventCounterEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventCounterEnd_StartPoint(), this.getEventCounterStart(), this.getEventCounterStart_EndPoint(), "startPoint", null, 0, 1, EventCounterEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventCounterOptionObjectEClass, EventCounterOptionObject.class, "EventCounterOptionObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventCounterResultObjectEClass, EventCounterResultObject.class, "EventCounterResultObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEIntegerObject());
		g1.getETypeArguments().add(g2);
		initEAttribute(getEventCounterResultObject_EventCounts(), g1, "eventCounts", null, 0, 1, EventCounterResultObject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(adapterEDataType, Adapter.class, "Adapter", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EventCounterPackageImpl
