/**
 * <copyright>
 * </copyright>
 *
 * $Id: EventsPackage.java,v 1.1 2011/02/07 17:17:58 auhl Exp $
 */
package behavioral.events;

import modelmanagement.ModelmanagementPackage;

import org.eclipse.emf.ecore.EClass;
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
 * <!-- begin-model-doc -->
 * Talks about types of (business) events that may occur, may need to be communicated / signalled and which can be consumed by event listeners (which most likely should be an action with suitable signature). Rules (see rules package) may be used to filter for relevant events.
 * 
 * From Holger's slides:
 * 
 * Business Event:
 * A meaningful change of the state of the enterprise (inside or outside)
 * A key source of business events are business objects; there are other sources like unstructured documents, analytical sources, RSS feeds, embedded software etc.
 * The term “business event” is often used interchangeably to refer to both the specification (type) of the event, and each individual occurrence (instance) of the event
 * Characterized by its type, modeled in Enterprise Repository*:
 * Name and/or significance
 * The data that is provided with each occurrence (aka attributes or context)
 * Modeled as data type
 * Relationship to other event types (to be clarified)
 * Like causality or aggregation
 * Can carry additional pre-defined data at execution time
 * Like unique occurance ID, timestamp, identification of event producer
 * Must be interpretable outside the “local processing context” that produced it
 * Logically self-contained in representing all the information pertinent to the situation causing the event
 * May either directly contain relevant details or may enable consumers to access the relevant details (via links or subsequent service calls or other means)
 * Even if it contains relevant details that doesn’t rule out the need for accessing additional data, business rules, etc. for the purposes of processing and acting upon the event
 * 
 * 
 * <!-- end-model-doc -->
 * @see behavioral.events.EventsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface EventsPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "events";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/behavioral/events.ecore";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "behavioral.events";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	EventsPackage eINSTANCE = behavioral.events.impl.EventsPackageImpl.init();

	/**
     * The meta object id for the '{@link behavioral.events.impl.SubscriptionImpl <em>Subscription</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.events.impl.SubscriptionImpl
     * @see behavioral.events.impl.EventsPackageImpl#getSubscription()
     * @generated
     */
	int SUBSCRIPTION = 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUBSCRIPTION__NAME = ModelmanagementPackage.NAMED_ELEMENT__NAME;

	/**
     * The feature id for the '<em><b>Description</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUBSCRIPTION__DESCRIPTION = ModelmanagementPackage.NAMED_ELEMENT__DESCRIPTION;

	/**
     * The feature id for the '<em><b>Producer</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUBSCRIPTION__PRODUCER = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Filters</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUBSCRIPTION__FILTERS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Subscribing Class</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUBSCRIPTION__SUBSCRIBING_CLASS = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The number of structural features of the '<em>Subscription</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SUBSCRIPTION_FEATURE_COUNT = ModelmanagementPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The meta object id for the '{@link behavioral.events.impl.EventProducerImpl <em>Event Producer</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.events.impl.EventProducerImpl
     * @see behavioral.events.impl.EventsPackageImpl#getEventProducer()
     * @generated
     */
	int EVENT_PRODUCER = 1;

	/**
     * The feature id for the '<em><b>Subscriptions</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_PRODUCER__SUBSCRIPTIONS = 0;

	/**
     * The feature id for the '<em><b>Notification Signatures</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_PRODUCER__NOTIFICATION_SIGNATURES = 1;

	/**
     * The number of structural features of the '<em>Event Producer</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_PRODUCER_FEATURE_COUNT = 2;

	/**
     * The meta object id for the '{@link behavioral.events.impl.EventFilterImpl <em>Event Filter</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see behavioral.events.impl.EventFilterImpl
     * @see behavioral.events.impl.EventsPackageImpl#getEventFilter()
     * @generated
     */
	int EVENT_FILTER = 2;

	/**
     * The feature id for the '<em><b>Subscription</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_FILTER__SUBSCRIPTION = 0;

	/**
     * The feature id for the '<em><b>Test</b></em>' containment reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_FILTER__TEST = 1;

	/**
     * The number of structural features of the '<em>Event Filter</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EVENT_FILTER_FEATURE_COUNT = 2;


	/**
     * Returns the meta object for class '{@link behavioral.events.Subscription <em>Subscription</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Subscription</em>'.
     * @see behavioral.events.Subscription
     * @generated
     */
	EClass getSubscription();

	/**
     * Returns the meta object for the reference '{@link behavioral.events.Subscription#getProducer <em>Producer</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Producer</em>'.
     * @see behavioral.events.Subscription#getProducer()
     * @see #getSubscription()
     * @generated
     */
	EReference getSubscription_Producer();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.events.Subscription#getFilters <em>Filters</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Filters</em>'.
     * @see behavioral.events.Subscription#getFilters()
     * @see #getSubscription()
     * @generated
     */
	EReference getSubscription_Filters();

	/**
     * Returns the meta object for the container reference '{@link behavioral.events.Subscription#getSubscribingClass <em>Subscribing Class</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Subscribing Class</em>'.
     * @see behavioral.events.Subscription#getSubscribingClass()
     * @see #getSubscription()
     * @generated
     */
	EReference getSubscription_SubscribingClass();

	/**
     * Returns the meta object for class '{@link behavioral.events.EventProducer <em>Event Producer</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Producer</em>'.
     * @see behavioral.events.EventProducer
     * @generated
     */
	EClass getEventProducer();

	/**
     * Returns the meta object for the reference list '{@link behavioral.events.EventProducer#getSubscriptions <em>Subscriptions</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Subscriptions</em>'.
     * @see behavioral.events.EventProducer#getSubscriptions()
     * @see #getEventProducer()
     * @generated
     */
	EReference getEventProducer_Subscriptions();

	/**
     * Returns the meta object for the containment reference list '{@link behavioral.events.EventProducer#getNotificationSignatures <em>Notification Signatures</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Notification Signatures</em>'.
     * @see behavioral.events.EventProducer#getNotificationSignatures()
     * @see #getEventProducer()
     * @generated
     */
	EReference getEventProducer_NotificationSignatures();

	/**
     * Returns the meta object for class '{@link behavioral.events.EventFilter <em>Event Filter</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Event Filter</em>'.
     * @see behavioral.events.EventFilter
     * @generated
     */
	EClass getEventFilter();

	/**
     * Returns the meta object for the container reference '{@link behavioral.events.EventFilter#getSubscription <em>Subscription</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Subscription</em>'.
     * @see behavioral.events.EventFilter#getSubscription()
     * @see #getEventFilter()
     * @generated
     */
	EReference getEventFilter_Subscription();

	/**
     * Returns the meta object for the containment reference '{@link behavioral.events.EventFilter#getTest <em>Test</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Test</em>'.
     * @see behavioral.events.EventFilter#getTest()
     * @see #getEventFilter()
     * @generated
     */
	EReference getEventFilter_Test();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	EventsFactory getEventsFactory();

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
         * The meta object literal for the '{@link behavioral.events.impl.SubscriptionImpl <em>Subscription</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.events.impl.SubscriptionImpl
         * @see behavioral.events.impl.EventsPackageImpl#getSubscription()
         * @generated
         */
		EClass SUBSCRIPTION = eINSTANCE.getSubscription();

		/**
         * The meta object literal for the '<em><b>Producer</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SUBSCRIPTION__PRODUCER = eINSTANCE.getSubscription_Producer();

		/**
         * The meta object literal for the '<em><b>Filters</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SUBSCRIPTION__FILTERS = eINSTANCE.getSubscription_Filters();

		/**
         * The meta object literal for the '<em><b>Subscribing Class</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference SUBSCRIPTION__SUBSCRIBING_CLASS = eINSTANCE.getSubscription_SubscribingClass();

		/**
         * The meta object literal for the '{@link behavioral.events.impl.EventProducerImpl <em>Event Producer</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.events.impl.EventProducerImpl
         * @see behavioral.events.impl.EventsPackageImpl#getEventProducer()
         * @generated
         */
		EClass EVENT_PRODUCER = eINSTANCE.getEventProducer();

		/**
         * The meta object literal for the '<em><b>Subscriptions</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EVENT_PRODUCER__SUBSCRIPTIONS = eINSTANCE.getEventProducer_Subscriptions();

		/**
         * The meta object literal for the '<em><b>Notification Signatures</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EVENT_PRODUCER__NOTIFICATION_SIGNATURES = eINSTANCE.getEventProducer_NotificationSignatures();

		/**
         * The meta object literal for the '{@link behavioral.events.impl.EventFilterImpl <em>Event Filter</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see behavioral.events.impl.EventFilterImpl
         * @see behavioral.events.impl.EventsPackageImpl#getEventFilter()
         * @generated
         */
		EClass EVENT_FILTER = eINSTANCE.getEventFilter();

		/**
         * The meta object literal for the '<em><b>Subscription</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EVENT_FILTER__SUBSCRIPTION = eINSTANCE.getEventFilter_Subscription();

		/**
         * The meta object literal for the '<em><b>Test</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EVENT_FILTER__TEST = eINSTANCE.getEventFilter_Test();

	}

} //EventsPackage
