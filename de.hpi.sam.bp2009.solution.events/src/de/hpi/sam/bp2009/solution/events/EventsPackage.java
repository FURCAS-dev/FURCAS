/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.events;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

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
 * @see de.hpi.sam.bp2009.solution.events.EventsFactory
 * @model kind="package"
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
	String eNS_URI = "http://de.hpi.sam.bp2009.solution.events";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "events";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventsPackage eINSTANCE = de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.events.impl.ModelChangeEventImpl <em>Model Change Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.events.impl.ModelChangeEventImpl
	 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getModelChangeEvent()
	 * @generated
	 */
	int MODEL_CHANGE_EVENT = 0;

	/**
	 * The feature id for the '<em><b>Source Resource Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_EVENT__SOURCE_RESOURCE_SET = 0;

	/**
	 * The number of structural features of the '<em>Model Change Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_EVENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.events.impl.ElementChangeEventImpl <em>Element Change Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.events.impl.ElementChangeEventImpl
	 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getElementChangeEvent()
	 * @generated
	 */
	int ELEMENT_CHANGE_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Source Resource Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CHANGE_EVENT__SOURCE_RESOURCE_SET = MODEL_CHANGE_EVENT__SOURCE_RESOURCE_SET;

	/**
	 * The number of structural features of the '<em>Element Change Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CHANGE_EVENT_FEATURE_COUNT = MODEL_CHANGE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.events.impl.AttributeValueChangeEventImpl <em>Attribute Value Change Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.events.impl.AttributeValueChangeEventImpl
	 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getAttributeValueChangeEvent()
	 * @generated
	 */
	int ATTRIBUTE_VALUE_CHANGE_EVENT = 2;

	/**
	 * The feature id for the '<em><b>Source Resource Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CHANGE_EVENT__SOURCE_RESOURCE_SET = ELEMENT_CHANGE_EVENT__SOURCE_RESOURCE_SET;

	/**
	 * The number of structural features of the '<em>Attribute Value Change Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CHANGE_EVENT_FEATURE_COUNT = ELEMENT_CHANGE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.events.impl.LinkLifeCycleEventImpl <em>Link Life Cycle Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.events.impl.LinkLifeCycleEventImpl
	 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getLinkLifeCycleEvent()
	 * @generated
	 */
	int LINK_LIFE_CYCLE_EVENT = 4;

	/**
	 * The feature id for the '<em><b>Source Resource Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LIFE_CYCLE_EVENT__SOURCE_RESOURCE_SET = MODEL_CHANGE_EVENT__SOURCE_RESOURCE_SET;

	/**
	 * The number of structural features of the '<em>Link Life Cycle Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LIFE_CYCLE_EVENT_FEATURE_COUNT = MODEL_CHANGE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.events.impl.ElementLifeCycleEventImpl <em>Element Life Cycle Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.events.impl.ElementLifeCycleEventImpl
	 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getElementLifeCycleEvent()
	 * @generated
	 */
	int ELEMENT_LIFE_CYCLE_EVENT = 3;

	/**
	 * The feature id for the '<em><b>Source Resource Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIFE_CYCLE_EVENT__SOURCE_RESOURCE_SET = LINK_LIFE_CYCLE_EVENT__SOURCE_RESOURCE_SET;

	/**
	 * The number of structural features of the '<em>Element Life Cycle Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIFE_CYCLE_EVENT_FEATURE_COUNT = LINK_LIFE_CYCLE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.events.impl.ElementCreateEventImpl <em>Element Create Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.events.impl.ElementCreateEventImpl
	 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getElementCreateEvent()
	 * @generated
	 */
	int ELEMENT_CREATE_EVENT = 5;

	/**
	 * The feature id for the '<em><b>Source Resource Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CREATE_EVENT__SOURCE_RESOURCE_SET = ELEMENT_LIFE_CYCLE_EVENT__SOURCE_RESOURCE_SET;

	/**
	 * The number of structural features of the '<em>Element Create Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CREATE_EVENT_FEATURE_COUNT = ELEMENT_LIFE_CYCLE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.events.impl.ElementDeleteEventImpl <em>Element Delete Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.events.impl.ElementDeleteEventImpl
	 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getElementDeleteEvent()
	 * @generated
	 */
	int ELEMENT_DELETE_EVENT = 6;

	/**
	 * The feature id for the '<em><b>Source Resource Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DELETE_EVENT__SOURCE_RESOURCE_SET = ELEMENT_LIFE_CYCLE_EVENT__SOURCE_RESOURCE_SET;

	/**
	 * The number of structural features of the '<em>Element Delete Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DELETE_EVENT_FEATURE_COUNT = ELEMENT_LIFE_CYCLE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.events.impl.LinkCreateEventImpl <em>Link Create Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.events.impl.LinkCreateEventImpl
	 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getLinkCreateEvent()
	 * @generated
	 */
	int LINK_CREATE_EVENT = 7;

	/**
	 * The feature id for the '<em><b>Source Resource Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_CREATE_EVENT__SOURCE_RESOURCE_SET = LINK_LIFE_CYCLE_EVENT__SOURCE_RESOURCE_SET;

	/**
	 * The number of structural features of the '<em>Link Create Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_CREATE_EVENT_FEATURE_COUNT = LINK_LIFE_CYCLE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.events.impl.LinkDeleteEventImpl <em>Link Delete Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.events.impl.LinkDeleteEventImpl
	 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getLinkDeleteEvent()
	 * @generated
	 */
	int LINK_DELETE_EVENT = 8;

	/**
	 * The feature id for the '<em><b>Source Resource Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DELETE_EVENT__SOURCE_RESOURCE_SET = LINK_LIFE_CYCLE_EVENT__SOURCE_RESOURCE_SET;

	/**
	 * The number of structural features of the '<em>Link Delete Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DELETE_EVENT_FEATURE_COUNT = LINK_LIFE_CYCLE_EVENT_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.events.ModelChangeEvent <em>Model Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Change Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.events.ModelChangeEvent
	 * @generated
	 */
	EClass getModelChangeEvent();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.events.ModelChangeEvent#getSourceResourceSet <em>Source Resource Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Resource Set</em>'.
	 * @see de.hpi.sam.bp2009.solution.events.ModelChangeEvent#getSourceResourceSet()
	 * @see #getModelChangeEvent()
	 * @generated
	 */
	EAttribute getModelChangeEvent_SourceResourceSet();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.events.ElementChangeEvent <em>Element Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Change Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.events.ElementChangeEvent
	 * @generated
	 */
	EClass getElementChangeEvent();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.events.AttributeValueChangeEvent <em>Attribute Value Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Value Change Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.events.AttributeValueChangeEvent
	 * @generated
	 */
	EClass getAttributeValueChangeEvent();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.events.ElementLifeCycleEvent <em>Element Life Cycle Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Life Cycle Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.events.ElementLifeCycleEvent
	 * @generated
	 */
	EClass getElementLifeCycleEvent();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.events.LinkLifeCycleEvent <em>Link Life Cycle Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Life Cycle Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.events.LinkLifeCycleEvent
	 * @generated
	 */
	EClass getLinkLifeCycleEvent();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.events.ElementCreateEvent <em>Element Create Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Create Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.events.ElementCreateEvent
	 * @generated
	 */
	EClass getElementCreateEvent();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.events.ElementDeleteEvent <em>Element Delete Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Delete Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.events.ElementDeleteEvent
	 * @generated
	 */
	EClass getElementDeleteEvent();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.events.LinkCreateEvent <em>Link Create Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Create Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.events.LinkCreateEvent
	 * @generated
	 */
	EClass getLinkCreateEvent();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.events.LinkDeleteEvent <em>Link Delete Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Delete Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.events.LinkDeleteEvent
	 * @generated
	 */
	EClass getLinkDeleteEvent();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.events.impl.ModelChangeEventImpl <em>Model Change Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.events.impl.ModelChangeEventImpl
		 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getModelChangeEvent()
		 * @generated
		 */
		EClass MODEL_CHANGE_EVENT = eINSTANCE.getModelChangeEvent();

		/**
		 * The meta object literal for the '<em><b>Source Resource Set</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_CHANGE_EVENT__SOURCE_RESOURCE_SET = eINSTANCE.getModelChangeEvent_SourceResourceSet();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.events.impl.ElementChangeEventImpl <em>Element Change Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.events.impl.ElementChangeEventImpl
		 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getElementChangeEvent()
		 * @generated
		 */
		EClass ELEMENT_CHANGE_EVENT = eINSTANCE.getElementChangeEvent();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.events.impl.AttributeValueChangeEventImpl <em>Attribute Value Change Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.events.impl.AttributeValueChangeEventImpl
		 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getAttributeValueChangeEvent()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE_CHANGE_EVENT = eINSTANCE.getAttributeValueChangeEvent();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.events.impl.ElementLifeCycleEventImpl <em>Element Life Cycle Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.events.impl.ElementLifeCycleEventImpl
		 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getElementLifeCycleEvent()
		 * @generated
		 */
		EClass ELEMENT_LIFE_CYCLE_EVENT = eINSTANCE.getElementLifeCycleEvent();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.events.impl.LinkLifeCycleEventImpl <em>Link Life Cycle Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.events.impl.LinkLifeCycleEventImpl
		 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getLinkLifeCycleEvent()
		 * @generated
		 */
		EClass LINK_LIFE_CYCLE_EVENT = eINSTANCE.getLinkLifeCycleEvent();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.events.impl.ElementCreateEventImpl <em>Element Create Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.events.impl.ElementCreateEventImpl
		 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getElementCreateEvent()
		 * @generated
		 */
		EClass ELEMENT_CREATE_EVENT = eINSTANCE.getElementCreateEvent();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.events.impl.ElementDeleteEventImpl <em>Element Delete Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.events.impl.ElementDeleteEventImpl
		 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getElementDeleteEvent()
		 * @generated
		 */
		EClass ELEMENT_DELETE_EVENT = eINSTANCE.getElementDeleteEvent();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.events.impl.LinkCreateEventImpl <em>Link Create Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.events.impl.LinkCreateEventImpl
		 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getLinkCreateEvent()
		 * @generated
		 */
		EClass LINK_CREATE_EVENT = eINSTANCE.getLinkCreateEvent();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.events.impl.LinkDeleteEventImpl <em>Link Delete Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.events.impl.LinkDeleteEventImpl
		 * @see de.hpi.sam.bp2009.solution.events.impl.EventsPackageImpl#getLinkDeleteEvent()
		 * @generated
		 */
		EClass LINK_DELETE_EVENT = eINSTANCE.getLinkDeleteEvent();

	}

} //EventsPackage
