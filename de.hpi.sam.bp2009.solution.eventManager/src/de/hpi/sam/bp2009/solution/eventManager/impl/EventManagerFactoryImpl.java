/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import de.hpi.sam.bp2009.solution.eventManager.*;

import org.eclipse.emf.common.notify.Adapter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EventManagerFactoryImpl extends EFactoryImpl implements EventManagerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventManagerFactory init() {
		try {
			EventManagerFactory theEventManagerFactory = (EventManagerFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.solution.eventManager"); 
			if (theEventManagerFactory != null) {
				return theEventManagerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EventManagerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventManagerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EventManagerPackage.EVENT_MANAGER: return createEventManager();
			case EventManagerPackage.MODEL_CHANGE_EVENT: return createModelChangeEvent();
			case EventManagerPackage.ELEMENT_CHANGE_EVENT: return createElementChangeEvent();
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT: return createAttributeValueChangeEvent();
			case EventManagerPackage.ELEMENT_LIFE_CYCLE_EVENT: return createElementLifeCycleEvent();
			case EventManagerPackage.LINK_LIFE_CYCLE_EVENT: return createLinkLifeCycleEvent();
			case EventManagerPackage.ELEMENT_CREATE_EVENT: return createElementCreateEvent();
			case EventManagerPackage.ELEMENT_DELETE_EVENT: return createElementDeleteEvent();
			case EventManagerPackage.LINK_CREATE_EVENT: return createLinkCreateEvent();
			case EventManagerPackage.LINK_DELETE_EVENT: return createLinkDeleteEvent();
			case EventManagerPackage.EVENT_TYPE_FILTER: return createEventTypeFilter();
			case EventManagerPackage.AND_FILTER: return createAndFilter();
			case EventManagerPackage.OR_FILTER: return createOrFilter();
			case EventManagerPackage.NOT_FILTER: return createNotFilter();
			case EventManagerPackage.CLASS_FILTER: return createClassFilter();
			case EventManagerPackage.INSTANCE_FILTER: return createInstanceFilter();
			case EventManagerPackage.ATTRIBUTE_FILTER: return createAttributeFilter();
			case EventManagerPackage.CONTAINER_FILTER: return createContainerFilter();
			case EventManagerPackage.COMPOSITION_HIERARCHY_FILTER: return createCompositionHierarchyFilter();
			case EventManagerPackage.PACKAGE_FILTER: return createPackageFilter();
			case EventManagerPackage.ASSOCIATION_FILTER: return createAssociationFilter();
			case EventManagerPackage.EVENT_NOTIFICATION: return createEventNotification();
			case EventManagerPackage.EVENT_MAPPPER: return createEventMappper();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case EventManagerPackage.ADAPTER:
				return createAdapterFromString(eDataType, initialValue);
			case EventManagerPackage.NOTIFICATION:
				return createNotificationFromString(eDataType, initialValue);
			case EventManagerPackage.NOTIFIER:
				return createNotifierFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case EventManagerPackage.ADAPTER:
				return convertAdapterToString(eDataType, instanceValue);
			case EventManagerPackage.NOTIFICATION:
				return convertNotificationToString(eDataType, instanceValue);
			case EventManagerPackage.NOTIFIER:
				return convertNotifierToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventManager createEventManager() {
		EventManagerImpl eventManager = new EventManagerImpl();
		return eventManager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelChangeEvent createModelChangeEvent() {
		ModelChangeEventImpl modelChangeEvent = new ModelChangeEventImpl();
		return modelChangeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementChangeEvent createElementChangeEvent() {
		ElementChangeEventImpl elementChangeEvent = new ElementChangeEventImpl();
		return elementChangeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeValueChangeEvent createAttributeValueChangeEvent() {
		AttributeValueChangeEventImpl attributeValueChangeEvent = new AttributeValueChangeEventImpl();
		return attributeValueChangeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementLifeCycleEvent createElementLifeCycleEvent() {
		ElementLifeCycleEventImpl elementLifeCycleEvent = new ElementLifeCycleEventImpl();
		return elementLifeCycleEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkLifeCycleEvent createLinkLifeCycleEvent() {
		LinkLifeCycleEventImpl linkLifeCycleEvent = new LinkLifeCycleEventImpl();
		return linkLifeCycleEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementCreateEvent createElementCreateEvent() {
		ElementCreateEventImpl elementCreateEvent = new ElementCreateEventImpl();
		return elementCreateEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementDeleteEvent createElementDeleteEvent() {
		ElementDeleteEventImpl elementDeleteEvent = new ElementDeleteEventImpl();
		return elementDeleteEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkCreateEvent createLinkCreateEvent() {
		LinkCreateEventImpl linkCreateEvent = new LinkCreateEventImpl();
		return linkCreateEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkDeleteEvent createLinkDeleteEvent() {
		LinkDeleteEventImpl linkDeleteEvent = new LinkDeleteEventImpl();
		return linkDeleteEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventTypeFilter createEventTypeFilter() {
		EventTypeFilterImpl eventTypeFilter = new EventTypeFilterImpl();
		return eventTypeFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndFilter createAndFilter() {
		AndFilterImpl andFilter = new AndFilterImpl();
		return andFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrFilter createOrFilter() {
		OrFilterImpl orFilter = new OrFilterImpl();
		return orFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotFilter createNotFilter() {
		NotFilterImpl notFilter = new NotFilterImpl();
		return notFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassFilter createClassFilter() {
		ClassFilterImpl classFilter = new ClassFilterImpl();
		return classFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceFilter createInstanceFilter() {
		InstanceFilterImpl instanceFilter = new InstanceFilterImpl();
		return instanceFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeFilter createAttributeFilter() {
		AttributeFilterImpl attributeFilter = new AttributeFilterImpl();
		return attributeFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerFilter createContainerFilter() {
		ContainerFilterImpl containerFilter = new ContainerFilterImpl();
		return containerFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionHierarchyFilter createCompositionHierarchyFilter() {
		CompositionHierarchyFilterImpl compositionHierarchyFilter = new CompositionHierarchyFilterImpl();
		return compositionHierarchyFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageFilter createPackageFilter() {
		PackageFilterImpl packageFilter = new PackageFilterImpl();
		return packageFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationFilter createAssociationFilter() {
		AssociationFilterImpl associationFilter = new AssociationFilterImpl();
		return associationFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventNotification createEventNotification() {
		EventNotificationImpl eventNotification = new EventNotificationImpl();
		return eventNotification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventMappper createEventMappper() {
		EventMappperImpl eventMappper = new EventMappperImpl();
		return eventMappper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Adapter createAdapterFromString(EDataType eDataType, String initialValue) {
		return (Adapter)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAdapterToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Notification createNotificationFromString(EDataType eDataType, String initialValue) {
		return (Notification)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNotificationToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Notifier createNotifierFromString(EDataType eDataType, String initialValue) {
		return (Notifier)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNotifierToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventManagerPackage getEventManagerPackage() {
		return (EventManagerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EventManagerPackage getPackage() {
		return EventManagerPackage.eINSTANCE;
	}

} //EventManagerFactoryImpl
