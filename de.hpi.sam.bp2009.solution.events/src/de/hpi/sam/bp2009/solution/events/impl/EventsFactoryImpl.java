/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.events.impl;

import de.hpi.sam.bp2009.solution.events.*;

import org.eclipse.emf.ecore.EClass;
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
public class EventsFactoryImpl extends EFactoryImpl implements EventsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EventsFactory init() {
		try {
			EventsFactory theEventsFactory = (EventsFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.solution.events"); 
			if (theEventsFactory != null) {
				return theEventsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EventsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsFactoryImpl() {
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
			case EventsPackage.MODEL_CHANGE_EVENT: return createModelChangeEvent();
			case EventsPackage.ELEMENT_CHANGE_EVENT: return createElementChangeEvent();
			case EventsPackage.ATTRIBUTE_VALUE_CHANGE_EVENT: return createAttributeValueChangeEvent();
			case EventsPackage.ELEMENT_LIFE_CYCLE_EVENT: return createElementLifeCycleEvent();
			case EventsPackage.LINK_LIFE_CYCLE_EVENT: return createLinkLifeCycleEvent();
			case EventsPackage.ELEMENT_CREATE_EVENT: return createElementCreateEvent();
			case EventsPackage.ELEMENT_DELETE_EVENT: return createElementDeleteEvent();
			case EventsPackage.LINK_CREATE_EVENT: return createLinkCreateEvent();
			case EventsPackage.LINK_DELETE_EVENT: return createLinkDeleteEvent();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
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
	public EventsPackage getEventsPackage() {
		return (EventsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EventsPackage getPackage() {
		return EventsPackage.eINSTANCE;
	}

} //EventsFactoryImpl
