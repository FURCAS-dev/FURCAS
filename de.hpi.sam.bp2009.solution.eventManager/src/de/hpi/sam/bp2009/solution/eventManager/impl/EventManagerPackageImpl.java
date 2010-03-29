/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.hpi.sam.bp2009.solution.eventManager.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.AssociationFilter;
import de.hpi.sam.bp2009.solution.eventManager.AttributeFilter;
import de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.CompositionHierarchyFilter;
import de.hpi.sam.bp2009.solution.eventManager.ContainerFilter;
import de.hpi.sam.bp2009.solution.eventManager.ElementChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementCreateEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementDeleteEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementLifeCycleEvent;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventMappper;
import de.hpi.sam.bp2009.solution.eventManager.EventNotification;
import de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter;
import de.hpi.sam.bp2009.solution.eventManager.InstanceFilter;
import de.hpi.sam.bp2009.solution.eventManager.LinkCreateEvent;
import de.hpi.sam.bp2009.solution.eventManager.LinkDeleteEvent;
import de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.NotFilter;
import de.hpi.sam.bp2009.solution.eventManager.OrFilter;
import de.hpi.sam.bp2009.solution.eventManager.PackageFilter;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelChangeEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementChangeEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeValueChangeEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementLifeCycleEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkLifeCycleEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementCreateEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementDeleteEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkCreateEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkDeleteEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventTypeFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositionHierarchyFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventNotificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventMappperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType adapterEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType notificationEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType notifierEDataType = null;

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
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEventManagerPackage.createPackageContents();

		// Initialize created meta-data
		theEventManagerPackage.initializePackageContents();

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
	public EReference getEventManager_EventMapper() {
		return (EReference)eventManagerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelChangeEvent() {
		return modelChangeEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelChangeEvent_SourceObject() {
		return (EReference)modelChangeEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementChangeEvent() {
		return elementChangeEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeValueChangeEvent() {
		return attributeValueChangeEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementLifeCycleEvent() {
		return elementLifeCycleEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkLifeCycleEvent() {
		return linkLifeCycleEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementCreateEvent() {
		return elementCreateEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementDeleteEvent() {
		return elementDeleteEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkCreateEvent() {
		return linkCreateEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkDeleteEvent() {
		return linkDeleteEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventFilter() {
		return eventFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventTypeFilter() {
		return eventTypeFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventTypeFilter_EventEClass() {
		return (EReference)eventTypeFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndFilter() {
		return andFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAndFilter_Filters() {
		return (EReference)andFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrFilter() {
		return orFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrFilter_Filters() {
		return (EReference)orFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotFilter() {
		return notFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNotFilter_Filter() {
		return (EReference)notFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassFilter() {
		return classFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassFilter_WantedClass() {
		return (EReference)classFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceFilter() {
		return instanceFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceFilter_Instance() {
		return (EReference)instanceFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeFilter() {
		return attributeFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeFilter_Attribute() {
		return (EReference)attributeFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerFilter() {
		return containerFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainerFilter_Container() {
		return (EReference)containerFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositionHierarchyFilter() {
		return compositionHierarchyFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositionHierarchyFilter_Root() {
		return (EReference)compositionHierarchyFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageFilter() {
		return packageFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageFilter_WantedPackage() {
		return (EReference)packageFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationFilter() {
		return associationFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationFilter_Reference() {
		return (EReference)associationFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventNotification() {
		return eventNotificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEventNotification_Event() {
		return (EReference)eventNotificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventNotification_Notification() {
		return (EAttribute)eventNotificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventMappper() {
		return eventMappperEClass;
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
	public EDataType getNotification() {
		return notificationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNotifier() {
		return notifierEDataType;
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
		createEReference(eventManagerEClass, EVENT_MANAGER__EVENT_MAPPER);

		modelChangeEventEClass = createEClass(MODEL_CHANGE_EVENT);
		createEReference(modelChangeEventEClass, MODEL_CHANGE_EVENT__SOURCE_OBJECT);

		elementChangeEventEClass = createEClass(ELEMENT_CHANGE_EVENT);

		attributeValueChangeEventEClass = createEClass(ATTRIBUTE_VALUE_CHANGE_EVENT);

		elementLifeCycleEventEClass = createEClass(ELEMENT_LIFE_CYCLE_EVENT);

		linkLifeCycleEventEClass = createEClass(LINK_LIFE_CYCLE_EVENT);

		elementCreateEventEClass = createEClass(ELEMENT_CREATE_EVENT);

		elementDeleteEventEClass = createEClass(ELEMENT_DELETE_EVENT);

		linkCreateEventEClass = createEClass(LINK_CREATE_EVENT);

		linkDeleteEventEClass = createEClass(LINK_DELETE_EVENT);

		eventFilterEClass = createEClass(EVENT_FILTER);

		eventTypeFilterEClass = createEClass(EVENT_TYPE_FILTER);
		createEReference(eventTypeFilterEClass, EVENT_TYPE_FILTER__EVENT_ECLASS);

		andFilterEClass = createEClass(AND_FILTER);
		createEReference(andFilterEClass, AND_FILTER__FILTERS);

		orFilterEClass = createEClass(OR_FILTER);
		createEReference(orFilterEClass, OR_FILTER__FILTERS);

		notFilterEClass = createEClass(NOT_FILTER);
		createEReference(notFilterEClass, NOT_FILTER__FILTER);

		classFilterEClass = createEClass(CLASS_FILTER);
		createEReference(classFilterEClass, CLASS_FILTER__WANTED_CLASS);

		instanceFilterEClass = createEClass(INSTANCE_FILTER);
		createEReference(instanceFilterEClass, INSTANCE_FILTER__INSTANCE);

		attributeFilterEClass = createEClass(ATTRIBUTE_FILTER);
		createEReference(attributeFilterEClass, ATTRIBUTE_FILTER__ATTRIBUTE);

		containerFilterEClass = createEClass(CONTAINER_FILTER);
		createEReference(containerFilterEClass, CONTAINER_FILTER__CONTAINER);

		compositionHierarchyFilterEClass = createEClass(COMPOSITION_HIERARCHY_FILTER);
		createEReference(compositionHierarchyFilterEClass, COMPOSITION_HIERARCHY_FILTER__ROOT);

		packageFilterEClass = createEClass(PACKAGE_FILTER);
		createEReference(packageFilterEClass, PACKAGE_FILTER__WANTED_PACKAGE);

		associationFilterEClass = createEClass(ASSOCIATION_FILTER);
		createEReference(associationFilterEClass, ASSOCIATION_FILTER__REFERENCE);

		eventNotificationEClass = createEClass(EVENT_NOTIFICATION);
		createEReference(eventNotificationEClass, EVENT_NOTIFICATION__EVENT);
		createEAttribute(eventNotificationEClass, EVENT_NOTIFICATION__NOTIFICATION);

		eventMappperEClass = createEClass(EVENT_MAPPPER);

		// Create data types
		adapterEDataType = createEDataType(ADAPTER);
		notificationEDataType = createEDataType(NOTIFICATION);
		notifierEDataType = createEDataType(NOTIFIER);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		elementChangeEventEClass.getESuperTypes().add(this.getModelChangeEvent());
		attributeValueChangeEventEClass.getESuperTypes().add(this.getElementChangeEvent());
		elementLifeCycleEventEClass.getESuperTypes().add(this.getElementChangeEvent());
		linkLifeCycleEventEClass.getESuperTypes().add(this.getElementChangeEvent());
		elementCreateEventEClass.getESuperTypes().add(this.getElementLifeCycleEvent());
		elementDeleteEventEClass.getESuperTypes().add(this.getElementLifeCycleEvent());
		linkCreateEventEClass.getESuperTypes().add(this.getLinkLifeCycleEvent());
		linkDeleteEventEClass.getESuperTypes().add(this.getLinkLifeCycleEvent());
		eventTypeFilterEClass.getESuperTypes().add(this.getEventFilter());
		andFilterEClass.getESuperTypes().add(this.getEventFilter());
		orFilterEClass.getESuperTypes().add(this.getEventFilter());
		notFilterEClass.getESuperTypes().add(this.getEventFilter());
		classFilterEClass.getESuperTypes().add(this.getEventFilter());
		instanceFilterEClass.getESuperTypes().add(this.getEventFilter());
		attributeFilterEClass.getESuperTypes().add(this.getEventFilter());
		containerFilterEClass.getESuperTypes().add(this.getEventFilter());
		compositionHierarchyFilterEClass.getESuperTypes().add(this.getEventFilter());
		packageFilterEClass.getESuperTypes().add(this.getEventFilter());
		associationFilterEClass.getESuperTypes().add(this.getEventFilter());

		// Initialize classes and features; add operations and parameters
		initEClass(eventManagerEClass, EventManager.class, "EventManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventManager_EventMapper(), this.getEventMappper(), null, "eventMapper", null, 1, 1, EventManager.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(eventManagerEClass, null, "subscribe", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNotifier(), "root", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventFilter(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAdapter(), "caller", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eventManagerEClass, null, "subscribe", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNotifier(), "root", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventFilter(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAdapter(), "caller", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eventManagerEClass, null, "subscribeTransactional", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNotifier(), "root", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventFilter(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAdapter(), "caller", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eventManagerEClass, null, "subscribeTransactional", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNotifier(), "root", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventFilter(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAdapter(), "caller", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eventManagerEClass, null, "notifyApplication", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAdapter(), "application", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventNotification(), "msg", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eventManagerEClass, null, "handleEMFEvent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAdapter(), "caller", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNotification(), "notification", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventFilter(), "filter", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eventManagerEClass, theEcorePackage.getEBoolean(), "unsubscribe", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAdapter(), "caller", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(modelChangeEventEClass, ModelChangeEvent.class, "ModelChangeEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelChangeEvent_SourceObject(), ecorePackage.getEObject(), null, "sourceObject", null, 0, 1, ModelChangeEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementChangeEventEClass, ElementChangeEvent.class, "ElementChangeEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeValueChangeEventEClass, AttributeValueChangeEvent.class, "AttributeValueChangeEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elementLifeCycleEventEClass, ElementLifeCycleEvent.class, "ElementLifeCycleEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(linkLifeCycleEventEClass, LinkLifeCycleEvent.class, "LinkLifeCycleEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elementCreateEventEClass, ElementCreateEvent.class, "ElementCreateEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elementDeleteEventEClass, ElementDeleteEvent.class, "ElementDeleteEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(linkCreateEventEClass, LinkCreateEvent.class, "LinkCreateEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(linkDeleteEventEClass, LinkDeleteEvent.class, "LinkDeleteEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventFilterEClass, EventFilter.class, "EventFilter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(eventFilterEClass, ecorePackage.getEBoolean(), "matchesFor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelChangeEvent(), "event", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eventTypeFilterEClass, EventTypeFilter.class, "EventTypeFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventTypeFilter_EventEClass(), theEcorePackage.getEClass(), null, "eventEClass", null, 0, 1, EventTypeFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andFilterEClass, AndFilter.class, "AndFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAndFilter_Filters(), this.getEventFilter(), null, "filters", null, 0, -1, AndFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orFilterEClass, OrFilter.class, "OrFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOrFilter_Filters(), this.getEventFilter(), null, "filters", null, 0, -1, OrFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notFilterEClass, NotFilter.class, "NotFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNotFilter_Filter(), this.getEventFilter(), null, "filter", null, 0, 1, NotFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classFilterEClass, ClassFilter.class, "ClassFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassFilter_WantedClass(), theEcorePackage.getEClass(), null, "wantedClass", null, 0, 1, ClassFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instanceFilterEClass, InstanceFilter.class, "InstanceFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceFilter_Instance(), theEcorePackage.getEObject(), null, "instance", null, 0, 1, InstanceFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeFilterEClass, AttributeFilter.class, "AttributeFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeFilter_Attribute(), theEcorePackage.getEAttribute(), null, "attribute", null, 0, 1, AttributeFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(containerFilterEClass, ContainerFilter.class, "ContainerFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainerFilter_Container(), theEcorePackage.getEObject(), null, "container", null, 0, 1, ContainerFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositionHierarchyFilterEClass, CompositionHierarchyFilter.class, "CompositionHierarchyFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositionHierarchyFilter_Root(), theEcorePackage.getEObject(), null, "root", null, 0, 1, CompositionHierarchyFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageFilterEClass, PackageFilter.class, "PackageFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackageFilter_WantedPackage(), theEcorePackage.getEPackage(), null, "wantedPackage", null, 0, 1, PackageFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(associationFilterEClass, AssociationFilter.class, "AssociationFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociationFilter_Reference(), theEcorePackage.getEReference(), null, "reference", null, 0, 1, AssociationFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventNotificationEClass, EventNotification.class, "EventNotification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventNotification_Event(), this.getModelChangeEvent(), null, "event", null, 0, 1, EventNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventNotification_Notification(), this.getNotification(), "notification", null, 0, 1, EventNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventMappperEClass, EventMappper.class, "EventMappper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(eventMappperEClass, this.getModelChangeEvent(), "mapNotificationToEvent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNotification(), "notification", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(adapterEDataType, Adapter.class, "Adapter", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(notificationEDataType, Notification.class, "Notification", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(notifierEDataType, Notifier.class, "Notifier", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EventManagerPackageImpl
