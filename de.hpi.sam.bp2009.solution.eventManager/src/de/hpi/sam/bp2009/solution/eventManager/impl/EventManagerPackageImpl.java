/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import de.hpi.sam.bp2009.solution.eventListener.EventListenerPackage;
import de.hpi.sam.bp2009.solution.eventListener.impl.EventListenerPackageImpl;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;

import de.hpi.sam.bp2009.solution.events.EventsPackage;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventManagerPackageImpl extends EPackageImpl implements EventManagerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventManagerEClass = null;

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
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EventManagerPackageImpl() {
		super(eNS_URI, EventManagerFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EventManagerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EventManagerPackage init() {
		if (isInited) return (EventManagerPackage)EPackage.Registry.INSTANCE.getEPackage(EventManagerPackage.eNS_URI);

		// Obtain or create and register package
		EventManagerPackageImpl theEventManagerPackage = (EventManagerPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EventManagerPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EventManagerPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EventsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		EventListenerPackageImpl theEventListenerPackage = (EventListenerPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventListenerPackage.eNS_URI) instanceof EventListenerPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventListenerPackage.eNS_URI) : EventListenerPackage.eINSTANCE);

		// Create package meta-data objects
		theEventManagerPackage.createPackageContents();
		theEventListenerPackage.createPackageContents();

		// Initialize created meta-data
		theEventManagerPackage.initializePackageContents();
		theEventListenerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEventManagerPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EventManagerPackage.eNS_URI, theEventManagerPackage);
		return theEventManagerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventManager() {
		return eventManagerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventManagerFactory getEventManagerFactory() {
		return (EventManagerFactory)getEFactoryInstance();
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
		eventManagerEClass = createEClass(EVENT_MANAGER);
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
		EventListenerPackage theEventListenerPackage = (EventListenerPackage)EPackage.Registry.INSTANCE.getEPackage(EventListenerPackage.eNS_URI);
		EventsPackage theEventsPackage = (EventsPackage)EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(eventManagerEClass, EventManager.class, "EventManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(eventManagerEClass, null, "subscribe", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEventListenerPackage.getEventListener(), "caller", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEventsPackage.getModelChangeEvent(), "modelChangeEvent", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //EventManagerPackageImpl
