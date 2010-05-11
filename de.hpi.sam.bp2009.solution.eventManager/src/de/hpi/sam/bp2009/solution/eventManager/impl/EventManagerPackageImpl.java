/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;



import java.util.Set;

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
import de.hpi.sam.bp2009.solution.eventManager.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.ContainmentFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter;
import de.hpi.sam.bp2009.solution.eventManager.NewValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifierBuilder;
import de.hpi.sam.bp2009.solution.eventManager.OldValueClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.OrFilter;
import de.hpi.sam.bp2009.solution.eventManager.StructuralFeatureFilter;

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
	private EClass classFilterEClass = null;

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
	private EClass associationFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oldValueClassFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newValueClassFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralFeatureFilterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notificationIdentifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notificationIdentifierBuilderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containmentFilterEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType notificationIdentifierSetEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriSetEDataType = null;

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
	public EAttribute getEventTypeFilter_MatchingNotification() {
		return (EAttribute)eventTypeFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventTypeFilter_EventType() {
		return (EAttribute)eventTypeFilterEClass.getEStructuralFeatures().get(1);
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
	public EClass getAttributeFilter() {
		return attributeFilterEClass;
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
	public EClass getOldValueClassFilter() {
		return oldValueClassFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOldValueClassFilter_AffectedClass() {
		return (EReference)oldValueClassFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewValueClassFilter() {
		return newValueClassFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNewValueClassFilter_AffectedClass() {
		return (EReference)newValueClassFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuralFeatureFilter() {
		return structuralFeatureFilterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuralFeatureFilter_Feature() {
		return (EReference)structuralFeatureFilterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotificationIdentifier() {
		return notificationIdentifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationIdentifier_NotifierClassURI() {
		return (EAttribute)notificationIdentifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationIdentifier_EventType() {
		return (EAttribute)notificationIdentifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationIdentifier_FeatureURI() {
		return (EAttribute)notificationIdentifierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationIdentifier_OldValueClassURIs() {
		return (EAttribute)notificationIdentifierEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationIdentifier_NewValueClassURIs() {
		return (EAttribute)notificationIdentifierEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationIdentifier_Touch() {
		return (EAttribute)notificationIdentifierEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationIdentifier_Reset() {
		return (EAttribute)notificationIdentifierEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNotificationIdentifier_Containment() {
		return (EAttribute)notificationIdentifierEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNotificationIdentifierBuilder() {
		return notificationIdentifierBuilderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainmentFilter() {
		return containmentFilterEClass;
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
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNotificationIdentifierSet() {
		return notificationIdentifierSetEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURISet() {
		return uriSetEDataType;
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

		eventFilterEClass = createEClass(EVENT_FILTER);

		eventTypeFilterEClass = createEClass(EVENT_TYPE_FILTER);
		createEAttribute(eventTypeFilterEClass, EVENT_TYPE_FILTER__MATCHING_NOTIFICATION);
		createEAttribute(eventTypeFilterEClass, EVENT_TYPE_FILTER__EVENT_TYPE);

		andFilterEClass = createEClass(AND_FILTER);
		createEReference(andFilterEClass, AND_FILTER__FILTERS);

		orFilterEClass = createEClass(OR_FILTER);
		createEReference(orFilterEClass, OR_FILTER__FILTERS);

		classFilterEClass = createEClass(CLASS_FILTER);
		createEReference(classFilterEClass, CLASS_FILTER__WANTED_CLASS);

		attributeFilterEClass = createEClass(ATTRIBUTE_FILTER);

		associationFilterEClass = createEClass(ASSOCIATION_FILTER);

		oldValueClassFilterEClass = createEClass(OLD_VALUE_CLASS_FILTER);
		createEReference(oldValueClassFilterEClass, OLD_VALUE_CLASS_FILTER__AFFECTED_CLASS);

		newValueClassFilterEClass = createEClass(NEW_VALUE_CLASS_FILTER);
		createEReference(newValueClassFilterEClass, NEW_VALUE_CLASS_FILTER__AFFECTED_CLASS);

		structuralFeatureFilterEClass = createEClass(STRUCTURAL_FEATURE_FILTER);
		createEReference(structuralFeatureFilterEClass, STRUCTURAL_FEATURE_FILTER__FEATURE);

		notificationIdentifierEClass = createEClass(NOTIFICATION_IDENTIFIER);
		createEAttribute(notificationIdentifierEClass, NOTIFICATION_IDENTIFIER__NOTIFIER_CLASS_URI);
		createEAttribute(notificationIdentifierEClass, NOTIFICATION_IDENTIFIER__EVENT_TYPE);
		createEAttribute(notificationIdentifierEClass, NOTIFICATION_IDENTIFIER__FEATURE_URI);
		createEAttribute(notificationIdentifierEClass, NOTIFICATION_IDENTIFIER__OLD_VALUE_CLASS_UR_IS);
		createEAttribute(notificationIdentifierEClass, NOTIFICATION_IDENTIFIER__NEW_VALUE_CLASS_UR_IS);
		createEAttribute(notificationIdentifierEClass, NOTIFICATION_IDENTIFIER__TOUCH);
		createEAttribute(notificationIdentifierEClass, NOTIFICATION_IDENTIFIER__RESET);
		createEAttribute(notificationIdentifierEClass, NOTIFICATION_IDENTIFIER__CONTAINMENT);

		notificationIdentifierBuilderEClass = createEClass(NOTIFICATION_IDENTIFIER_BUILDER);

		containmentFilterEClass = createEClass(CONTAINMENT_FILTER);

		// Create data types
		adapterEDataType = createEDataType(ADAPTER);
		notificationEDataType = createEDataType(NOTIFICATION);
		notifierEDataType = createEDataType(NOTIFIER);
		uriEDataType = createEDataType(URI);
		notificationIdentifierSetEDataType = createEDataType(NOTIFICATION_IDENTIFIER_SET);
		uriSetEDataType = createEDataType(URI_SET);
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
		eventTypeFilterEClass.getESuperTypes().add(this.getEventFilter());
		andFilterEClass.getESuperTypes().add(this.getEventFilter());
		orFilterEClass.getESuperTypes().add(this.getEventFilter());
		classFilterEClass.getESuperTypes().add(this.getEventFilter());
		attributeFilterEClass.getESuperTypes().add(this.getStructuralFeatureFilter());
		associationFilterEClass.getESuperTypes().add(this.getStructuralFeatureFilter());
		oldValueClassFilterEClass.getESuperTypes().add(this.getEventFilter());
		newValueClassFilterEClass.getESuperTypes().add(this.getEventFilter());
		structuralFeatureFilterEClass.getESuperTypes().add(this.getEventFilter());
		containmentFilterEClass.getESuperTypes().add(this.getEventFilter());

		// Initialize classes and features; add operations and parameters
		initEClass(eventManagerEClass, EventManager.class, "EventManager", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(eventManagerEClass, null, "subscribe", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNotifier(), "root", 1, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventFilter(), "filter", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAdapter(), "caller", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eventManagerEClass, null, "subscribeTransactional", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNotifier(), "root", 1, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventFilter(), "filter", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAdapter(), "caller", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eventManagerEClass, null, "notifyApplication", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAdapter(), "application", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNotification(), "msg", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getEventFilter(), "matchingFilter", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eventManagerEClass, null, "handleEMFEvent", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNotification(), "notification", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eventManagerEClass, theEcorePackage.getEBoolean(), "unsubscribe", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getAdapter(), "caller", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eventFilterEClass, EventFilter.class, "EventFilter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(eventFilterEClass, ecorePackage.getEBoolean(), "matchesFor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNotification(), "event", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(eventFilterEClass, this.getNotificationIdentifier(), "buildNotificationIdentifiers", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNotificationIdentifier(), "identifier", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eventTypeFilterEClass, EventTypeFilter.class, "EventTypeFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEventTypeFilter_MatchingNotification(), this.getNotification(), "matchingNotification", null, 0, 1, EventTypeFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEventTypeFilter_EventType(), theEcorePackage.getEIntegerObject(), "eventType", null, 0, 1, EventTypeFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andFilterEClass, AndFilter.class, "AndFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAndFilter_Filters(), this.getEventFilter(), null, "filters", null, 0, -1, AndFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orFilterEClass, OrFilter.class, "OrFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOrFilter_Filters(), this.getEventFilter(), null, "filters", null, 0, -1, OrFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classFilterEClass, ClassFilter.class, "ClassFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassFilter_WantedClass(), theEcorePackage.getEClass(), null, "wantedClass", null, 0, 1, ClassFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeFilterEClass, AttributeFilter.class, "AttributeFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(attributeFilterEClass, null, "setAttribute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEAttribute(), "attribute", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(associationFilterEClass, AssociationFilter.class, "AssociationFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(associationFilterEClass, null, "setReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEReference(), "reference", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(oldValueClassFilterEClass, OldValueClassFilter.class, "OldValueClassFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOldValueClassFilter_AffectedClass(), theEcorePackage.getEClass(), null, "affectedClass", null, 0, 1, OldValueClassFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newValueClassFilterEClass, NewValueClassFilter.class, "NewValueClassFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewValueClassFilter_AffectedClass(), theEcorePackage.getEClass(), null, "affectedClass", null, 0, 1, NewValueClassFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuralFeatureFilterEClass, StructuralFeatureFilter.class, "StructuralFeatureFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuralFeatureFilter_Feature(), theEcorePackage.getEStructuralFeature(), null, "feature", null, 0, 1, StructuralFeatureFilter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notificationIdentifierEClass, NotificationIdentifier.class, "NotificationIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNotificationIdentifier_NotifierClassURI(), this.getURI(), "notifierClassURI", null, 0, 1, NotificationIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationIdentifier_EventType(), theEcorePackage.getEInt(), "eventType", null, 0, 1, NotificationIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationIdentifier_FeatureURI(), this.getURI(), "featureURI", null, 0, 1, NotificationIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationIdentifier_OldValueClassURIs(), this.getURISet(), "oldValueClassURIs", "new HashSet<URI>()", 0, 1, NotificationIdentifier.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNotificationIdentifier_NewValueClassURIs(), this.getURISet(), "newValueClassURIs", "new HashSet<URI>()", 0, 1, NotificationIdentifier.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNotificationIdentifier_Touch(), theEcorePackage.getEBoolean(), "touch", null, 0, 1, NotificationIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationIdentifier_Reset(), theEcorePackage.getEBoolean(), "reset", null, 0, 1, NotificationIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNotificationIdentifier_Containment(), theEcorePackage.getEBoolean(), "containment", null, 0, 1, NotificationIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(notificationIdentifierEClass, theEcorePackage.getEInt(), "getHash", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(notificationIdentifierEClass, this.getNotificationIdentifier(), "clone", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(notificationIdentifierBuilderEClass, NotificationIdentifierBuilder.class, "NotificationIdentifierBuilder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(notificationIdentifierBuilderEClass, this.getNotificationIdentifierSet(), "buildFrom", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getNotification(), "noti", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(containmentFilterEClass, ContainmentFilter.class, "ContainmentFilter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize data types
		initEDataType(adapterEDataType, Adapter.class, "Adapter", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(notificationEDataType, Notification.class, "Notification", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(notifierEDataType, Notifier.class, "Notifier", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(notificationIdentifierSetEDataType, Set.class, "NotificationIdentifierSet", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Set<de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier>");
		initEDataType(uriSetEDataType, Set.class, "URISet", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.Set<org.eclipse.emf.common.util.URI>");

		// Create resource
		createResource(eNS_URI);
	}

} //EventManagerPackageImpl
