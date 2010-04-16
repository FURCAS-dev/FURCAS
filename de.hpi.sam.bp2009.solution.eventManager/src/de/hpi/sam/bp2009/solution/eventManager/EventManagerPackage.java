/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory
 * @model kind="package"
 * @generated
 */
public interface EventManagerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "eventManager";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.hpi.sam.bp2009.solution.eventManager";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "solution.eventManager";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EventManagerPackage eINSTANCE = de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerImpl <em>Event Manager</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventManager()
	 * @generated
	 */
	int EVENT_MANAGER = 0;

	/**
	 * The feature id for the '<em><b>Event Mapper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MANAGER__EVENT_MAPPER = 0;

	/**
	 * The number of structural features of the '<em>Event Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MANAGER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ModelChangeEventImpl <em>Model Change Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ModelChangeEventImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getModelChangeEvent()
	 * @generated
	 */
	int MODEL_CHANGE_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_EVENT__SOURCE_OBJECT = 0;

	/**
	 * The number of structural features of the '<em>Model Change Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_EVENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ElementChangeEventImpl <em>Element Change Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ElementChangeEventImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getElementChangeEvent()
	 * @generated
	 */
	int ELEMENT_CHANGE_EVENT = 2;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CHANGE_EVENT__SOURCE_OBJECT = MODEL_CHANGE_EVENT__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Changed Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CHANGE_EVENT__CHANGED_CLASS = MODEL_CHANGE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Element Change Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CHANGE_EVENT_FEATURE_COUNT = MODEL_CHANGE_EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeValueChangeEventImpl <em>Attribute Value Change Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AttributeValueChangeEventImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAttributeValueChangeEvent()
	 * @generated
	 */
	int ATTRIBUTE_VALUE_CHANGE_EVENT = 3;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CHANGE_EVENT__SOURCE_OBJECT = ELEMENT_CHANGE_EVENT__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Changed Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CHANGE_EVENT__CHANGED_CLASS = ELEMENT_CHANGE_EVENT__CHANGED_CLASS;

	/**
	 * The feature id for the '<em><b>Changed Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CHANGE_EVENT__CHANGED_ATTRIBUTE = ELEMENT_CHANGE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CHANGE_EVENT__BEFORE = ELEMENT_CHANGE_EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>After</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CHANGE_EVENT__AFTER = ELEMENT_CHANGE_EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute Value Change Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CHANGE_EVENT_FEATURE_COUNT = ELEMENT_CHANGE_EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.LinkLifeCycleEventImpl <em>Link Life Cycle Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.LinkLifeCycleEventImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getLinkLifeCycleEvent()
	 * @generated
	 */
	int LINK_LIFE_CYCLE_EVENT = 5;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ElementLifeCycleEventImpl <em>Element Life Cycle Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ElementLifeCycleEventImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getElementLifeCycleEvent()
	 * @generated
	 */
	int ELEMENT_LIFE_CYCLE_EVENT = 4;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIFE_CYCLE_EVENT__SOURCE_OBJECT = ELEMENT_CHANGE_EVENT__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Changed Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIFE_CYCLE_EVENT__CHANGED_CLASS = ELEMENT_CHANGE_EVENT__CHANGED_CLASS;

	/**
	 * The feature id for the '<em><b>Containing Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIFE_CYCLE_EVENT__CONTAINING_ELEMENT = ELEMENT_CHANGE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Element Life Cycle Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIFE_CYCLE_EVENT_FEATURE_COUNT = ELEMENT_CHANGE_EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LIFE_CYCLE_EVENT__SOURCE_OBJECT = ELEMENT_CHANGE_EVENT__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Changed Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LIFE_CYCLE_EVENT__CHANGED_CLASS = ELEMENT_CHANGE_EVENT__CHANGED_CLASS;

	/**
	 * The feature id for the '<em><b>Changed Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LIFE_CYCLE_EVENT__CHANGED_REFERENCE = ELEMENT_CHANGE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Corresponding Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LIFE_CYCLE_EVENT__CORRESPONDING_OBJECT = ELEMENT_CHANGE_EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Link Life Cycle Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LIFE_CYCLE_EVENT_FEATURE_COUNT = ELEMENT_CHANGE_EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ElementCreateEventImpl <em>Element Create Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ElementCreateEventImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getElementCreateEvent()
	 * @generated
	 */
	int ELEMENT_CREATE_EVENT = 6;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CREATE_EVENT__SOURCE_OBJECT = ELEMENT_LIFE_CYCLE_EVENT__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Changed Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CREATE_EVENT__CHANGED_CLASS = ELEMENT_LIFE_CYCLE_EVENT__CHANGED_CLASS;

	/**
	 * The feature id for the '<em><b>Containing Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CREATE_EVENT__CONTAINING_ELEMENT = ELEMENT_LIFE_CYCLE_EVENT__CONTAINING_ELEMENT;

	/**
	 * The number of structural features of the '<em>Element Create Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CREATE_EVENT_FEATURE_COUNT = ELEMENT_LIFE_CYCLE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ElementDeleteEventImpl <em>Element Delete Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ElementDeleteEventImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getElementDeleteEvent()
	 * @generated
	 */
	int ELEMENT_DELETE_EVENT = 7;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DELETE_EVENT__SOURCE_OBJECT = ELEMENT_LIFE_CYCLE_EVENT__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Changed Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DELETE_EVENT__CHANGED_CLASS = ELEMENT_LIFE_CYCLE_EVENT__CHANGED_CLASS;

	/**
	 * The feature id for the '<em><b>Containing Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DELETE_EVENT__CONTAINING_ELEMENT = ELEMENT_LIFE_CYCLE_EVENT__CONTAINING_ELEMENT;

	/**
	 * The number of structural features of the '<em>Element Delete Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_DELETE_EVENT_FEATURE_COUNT = ELEMENT_LIFE_CYCLE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.LinkCreateEventImpl <em>Link Create Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.LinkCreateEventImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getLinkCreateEvent()
	 * @generated
	 */
	int LINK_CREATE_EVENT = 8;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_CREATE_EVENT__SOURCE_OBJECT = LINK_LIFE_CYCLE_EVENT__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Changed Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_CREATE_EVENT__CHANGED_CLASS = LINK_LIFE_CYCLE_EVENT__CHANGED_CLASS;

	/**
	 * The feature id for the '<em><b>Changed Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_CREATE_EVENT__CHANGED_REFERENCE = LINK_LIFE_CYCLE_EVENT__CHANGED_REFERENCE;

	/**
	 * The feature id for the '<em><b>Corresponding Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_CREATE_EVENT__CORRESPONDING_OBJECT = LINK_LIFE_CYCLE_EVENT__CORRESPONDING_OBJECT;

	/**
	 * The number of structural features of the '<em>Link Create Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_CREATE_EVENT_FEATURE_COUNT = LINK_LIFE_CYCLE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.LinkDeleteEventImpl <em>Link Delete Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.LinkDeleteEventImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getLinkDeleteEvent()
	 * @generated
	 */
	int LINK_DELETE_EVENT = 9;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DELETE_EVENT__SOURCE_OBJECT = LINK_LIFE_CYCLE_EVENT__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Changed Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DELETE_EVENT__CHANGED_CLASS = LINK_LIFE_CYCLE_EVENT__CHANGED_CLASS;

	/**
	 * The feature id for the '<em><b>Changed Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DELETE_EVENT__CHANGED_REFERENCE = LINK_LIFE_CYCLE_EVENT__CHANGED_REFERENCE;

	/**
	 * The feature id for the '<em><b>Corresponding Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DELETE_EVENT__CORRESPONDING_OBJECT = LINK_LIFE_CYCLE_EVENT__CORRESPONDING_OBJECT;

	/**
	 * The number of structural features of the '<em>Link Delete Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DELETE_EVENT_FEATURE_COUNT = LINK_LIFE_CYCLE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter <em>Event Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventFilter()
	 * @generated
	 */
	int EVENT_FILTER = 10;

	/**
	 * The number of structural features of the '<em>Event Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FILTER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventTypeFilterImpl <em>Event Type Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventTypeFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventTypeFilter()
	 * @generated
	 */
	int EVENT_TYPE_FILTER = 11;

	/**
	 * The feature id for the '<em><b>Event EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TYPE_FILTER__EVENT_ECLASS = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event Type Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TYPE_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AndFilterImpl <em>And Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AndFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAndFilter()
	 * @generated
	 */
	int AND_FILTER = 12;

	/**
	 * The feature id for the '<em><b>Filters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FILTER__FILTERS = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>And Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.OrFilterImpl <em>Or Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.OrFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getOrFilter()
	 * @generated
	 */
	int OR_FILTER = 13;

	/**
	 * The feature id for the '<em><b>Filters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FILTER__FILTERS = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Or Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.NotFilterImpl <em>Not Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.NotFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getNotFilter()
	 * @generated
	 */
	int NOT_FILTER = 14;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FILTER__FILTER = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Not Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ClassFilterImpl <em>Class Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ClassFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getClassFilter()
	 * @generated
	 */
	int CLASS_FILTER = 15;

	/**
	 * The feature id for the '<em><b>Wanted Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FILTER__WANTED_CLASS = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Class Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.InstanceFilterImpl <em>Instance Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.InstanceFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getInstanceFilter()
	 * @generated
	 */
	int INSTANCE_FILTER = 16;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FILTER__INSTANCE = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Instance Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeFilterImpl <em>Attribute Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AttributeFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAttributeFilter()
	 * @generated
	 */
	int ATTRIBUTE_FILTER = 17;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FILTER__ATTRIBUTE = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ContainerFilterImpl <em>Container Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ContainerFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getContainerFilter()
	 * @generated
	 */
	int CONTAINER_FILTER = 18;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FILTER__CONTAINER = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Container Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.CompositionHierarchyFilterImpl <em>Composition Hierarchy Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.CompositionHierarchyFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getCompositionHierarchyFilter()
	 * @generated
	 */
	int COMPOSITION_HIERARCHY_FILTER = 19;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_HIERARCHY_FILTER__ROOT = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composition Hierarchy Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_HIERARCHY_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.PackageFilterImpl <em>Package Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.PackageFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getPackageFilter()
	 * @generated
	 */
	int PACKAGE_FILTER = 20;

	/**
	 * The feature id for the '<em><b>Wanted Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FILTER__WANTED_PACKAGE = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Package Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AssociationFilterImpl <em>Association Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AssociationFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAssociationFilter()
	 * @generated
	 */
	int ASSOCIATION_FILTER = 21;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FILTER__REFERENCE = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Association Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventMapperImpl <em>Event Mapper</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventMapperImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventMapper()
	 * @generated
	 */
	int EVENT_MAPPER = 22;

	/**
	 * The number of structural features of the '<em>Event Mapper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MAPPER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventListenerImpl <em>Event Listener</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventListenerImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventListener()
	 * @generated
	 */
	int EVENT_LISTENER = 23;

	/**
	 * The number of structural features of the '<em>Event Listener</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_LISTENER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeMultiValueChangeEventImpl <em>Attribute Multi Value Change Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AttributeMultiValueChangeEventImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAttributeMultiValueChangeEvent()
	 * @generated
	 */
	int ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT = 24;

	/**
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT__SOURCE_OBJECT = ATTRIBUTE_VALUE_CHANGE_EVENT__SOURCE_OBJECT;

	/**
	 * The feature id for the '<em><b>Changed Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT__CHANGED_CLASS = ATTRIBUTE_VALUE_CHANGE_EVENT__CHANGED_CLASS;

	/**
	 * The feature id for the '<em><b>Changed Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT__CHANGED_ATTRIBUTE = ATTRIBUTE_VALUE_CHANGE_EVENT__CHANGED_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT__BEFORE = ATTRIBUTE_VALUE_CHANGE_EVENT__BEFORE;

	/**
	 * The feature id for the '<em><b>After</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT__AFTER = ATTRIBUTE_VALUE_CHANGE_EVENT__AFTER;

	/**
	 * The feature id for the '<em><b>Add</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT__ADD = ATTRIBUTE_VALUE_CHANGE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Multi Value Change Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT_FEATURE_COUNT = ATTRIBUTE_VALUE_CHANGE_EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>Adapter</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAdapter()
	 * @generated
	 */
	int ADAPTER = 25;


	/**
	 * The meta object id for the '<em>Notification</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Notification
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getNotification()
	 * @generated
	 */
	int NOTIFICATION = 26;


	/**
	 * The meta object id for the '<em>Notifier</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Notifier
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getNotifier()
	 * @generated
	 */
	int NOTIFIER = 27;


	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.EventManager <em>Event Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Manager</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManager
	 * @generated
	 */
	EClass getEventManager();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#getEventMapper <em>Event Mapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Mapper</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManager#getEventMapper()
	 * @see #getEventManager()
	 * @generated
	 */
	EReference getEventManager_EventMapper();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent <em>Model Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Change Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent
	 * @generated
	 */
	EClass getModelChangeEvent();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent#getSourceObject <em>Source Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Object</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent#getSourceObject()
	 * @see #getModelChangeEvent()
	 * @generated
	 */
	EReference getModelChangeEvent_SourceObject();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.ElementChangeEvent <em>Element Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Change Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ElementChangeEvent
	 * @generated
	 */
	EClass getElementChangeEvent();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.ElementChangeEvent#getChangedClass <em>Changed Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Changed Class</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ElementChangeEvent#getChangedClass()
	 * @see #getElementChangeEvent()
	 * @generated
	 */
	EReference getElementChangeEvent_ChangedClass();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent <em>Attribute Value Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Value Change Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent
	 * @generated
	 */
	EClass getAttributeValueChangeEvent();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent#getChangedAttribute <em>Changed Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Changed Attribute</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent#getChangedAttribute()
	 * @see #getAttributeValueChangeEvent()
	 * @generated
	 */
	EReference getAttributeValueChangeEvent_ChangedAttribute();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent#getBefore <em>Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Before</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent#getBefore()
	 * @see #getAttributeValueChangeEvent()
	 * @generated
	 */
	EAttribute getAttributeValueChangeEvent_Before();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent#getAfter <em>After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>After</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent#getAfter()
	 * @see #getAttributeValueChangeEvent()
	 * @generated
	 */
	EAttribute getAttributeValueChangeEvent_After();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.ElementLifeCycleEvent <em>Element Life Cycle Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Life Cycle Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ElementLifeCycleEvent
	 * @generated
	 */
	EClass getElementLifeCycleEvent();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.ElementLifeCycleEvent#getContainingElement <em>Containing Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Containing Element</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ElementLifeCycleEvent#getContainingElement()
	 * @see #getElementLifeCycleEvent()
	 * @generated
	 */
	EReference getElementLifeCycleEvent_ContainingElement();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent <em>Link Life Cycle Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Life Cycle Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent
	 * @generated
	 */
	EClass getLinkLifeCycleEvent();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent#getChangedReference <em>Changed Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Changed Reference</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent#getChangedReference()
	 * @see #getLinkLifeCycleEvent()
	 * @generated
	 */
	EReference getLinkLifeCycleEvent_ChangedReference();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent#getCorrespondingObject <em>Corresponding Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Corresponding Object</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent#getCorrespondingObject()
	 * @see #getLinkLifeCycleEvent()
	 * @generated
	 */
	EReference getLinkLifeCycleEvent_CorrespondingObject();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.ElementCreateEvent <em>Element Create Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Create Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ElementCreateEvent
	 * @generated
	 */
	EClass getElementCreateEvent();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.ElementDeleteEvent <em>Element Delete Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Delete Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ElementDeleteEvent
	 * @generated
	 */
	EClass getElementDeleteEvent();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.LinkCreateEvent <em>Link Create Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Create Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.LinkCreateEvent
	 * @generated
	 */
	EClass getLinkCreateEvent();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.LinkDeleteEvent <em>Link Delete Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Delete Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.LinkDeleteEvent
	 * @generated
	 */
	EClass getLinkDeleteEvent();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter <em>Event Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter
	 * @generated
	 */
	EClass getEventFilter();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter <em>Event Type Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Type Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter
	 * @generated
	 */
	EClass getEventTypeFilter();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter#getEventEClass <em>Event EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event EClass</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter#getEventEClass()
	 * @see #getEventTypeFilter()
	 * @generated
	 */
	EReference getEventTypeFilter_EventEClass();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.AndFilter <em>And Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AndFilter
	 * @generated
	 */
	EClass getAndFilter();

	/**
	 * Returns the meta object for the reference list '{@link de.hpi.sam.bp2009.solution.eventManager.AndFilter#getFilters <em>Filters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Filters</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AndFilter#getFilters()
	 * @see #getAndFilter()
	 * @generated
	 */
	EReference getAndFilter_Filters();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.OrFilter <em>Or Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.OrFilter
	 * @generated
	 */
	EClass getOrFilter();

	/**
	 * Returns the meta object for the reference list '{@link de.hpi.sam.bp2009.solution.eventManager.OrFilter#getFilters <em>Filters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Filters</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.OrFilter#getFilters()
	 * @see #getOrFilter()
	 * @generated
	 */
	EReference getOrFilter_Filters();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.NotFilter <em>Not Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.NotFilter
	 * @generated
	 */
	EClass getNotFilter();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.NotFilter#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.NotFilter#getFilter()
	 * @see #getNotFilter()
	 * @generated
	 */
	EReference getNotFilter_Filter();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.ClassFilter <em>Class Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ClassFilter
	 * @generated
	 */
	EClass getClassFilter();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.ClassFilter#getWantedClass <em>Wanted Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wanted Class</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ClassFilter#getWantedClass()
	 * @see #getClassFilter()
	 * @generated
	 */
	EReference getClassFilter_WantedClass();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.InstanceFilter <em>Instance Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.InstanceFilter
	 * @generated
	 */
	EClass getInstanceFilter();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.InstanceFilter#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Instance</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.InstanceFilter#getInstance()
	 * @see #getInstanceFilter()
	 * @generated
	 */
	EReference getInstanceFilter_Instance();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeFilter <em>Attribute Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AttributeFilter
	 * @generated
	 */
	EClass getAttributeFilter();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeFilter#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AttributeFilter#getAttribute()
	 * @see #getAttributeFilter()
	 * @generated
	 */
	EReference getAttributeFilter_Attribute();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.ContainerFilter <em>Container Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ContainerFilter
	 * @generated
	 */
	EClass getContainerFilter();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.ContainerFilter#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ContainerFilter#getContainer()
	 * @see #getContainerFilter()
	 * @generated
	 */
	EReference getContainerFilter_Container();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.CompositionHierarchyFilter <em>Composition Hierarchy Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composition Hierarchy Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.CompositionHierarchyFilter
	 * @generated
	 */
	EClass getCompositionHierarchyFilter();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.CompositionHierarchyFilter#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.CompositionHierarchyFilter#getRoot()
	 * @see #getCompositionHierarchyFilter()
	 * @generated
	 */
	EReference getCompositionHierarchyFilter_Root();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.PackageFilter <em>Package Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.PackageFilter
	 * @generated
	 */
	EClass getPackageFilter();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.PackageFilter#getWantedPackage <em>Wanted Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Wanted Package</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.PackageFilter#getWantedPackage()
	 * @see #getPackageFilter()
	 * @generated
	 */
	EReference getPackageFilter_WantedPackage();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.AssociationFilter <em>Association Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AssociationFilter
	 * @generated
	 */
	EClass getAssociationFilter();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.AssociationFilter#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AssociationFilter#getReference()
	 * @see #getAssociationFilter()
	 * @generated
	 */
	EReference getAssociationFilter_Reference();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.EventMapper <em>Event Mapper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Mapper</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventMapper
	 * @generated
	 */
	EClass getEventMapper();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.EventListener <em>Event Listener</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Listener</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventListener
	 * @generated
	 */
	EClass getEventListener();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeMultiValueChangeEvent <em>Attribute Multi Value Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Multi Value Change Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AttributeMultiValueChangeEvent
	 * @generated
	 */
	EClass getAttributeMultiValueChangeEvent();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeMultiValueChangeEvent#isAdd <em>Add</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AttributeMultiValueChangeEvent#isAdd()
	 * @see #getAttributeMultiValueChangeEvent()
	 * @generated
	 */
	EAttribute getAttributeMultiValueChangeEvent_Add();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.notify.Adapter <em>Adapter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Adapter</em>'.
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @model instanceClass="org.eclipse.emf.common.notify.Adapter"
	 * @generated
	 */
	EDataType getAdapter();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.notify.Notification <em>Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Notification</em>'.
	 * @see org.eclipse.emf.common.notify.Notification
	 * @model instanceClass="org.eclipse.emf.common.notify.Notification"
	 * @generated
	 */
	EDataType getNotification();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.notify.Notifier <em>Notifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Notifier</em>'.
	 * @see org.eclipse.emf.common.notify.Notifier
	 * @model instanceClass="org.eclipse.emf.common.notify.Notifier"
	 * @generated
	 */
	EDataType getNotifier();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EventManagerFactory getEventManagerFactory();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerImpl <em>Event Manager</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventManager()
		 * @generated
		 */
		EClass EVENT_MANAGER = eINSTANCE.getEventManager();

		/**
		 * The meta object literal for the '<em><b>Event Mapper</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_MANAGER__EVENT_MAPPER = eINSTANCE.getEventManager_EventMapper();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ModelChangeEventImpl <em>Model Change Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ModelChangeEventImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getModelChangeEvent()
		 * @generated
		 */
		EClass MODEL_CHANGE_EVENT = eINSTANCE.getModelChangeEvent();

		/**
		 * The meta object literal for the '<em><b>Source Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CHANGE_EVENT__SOURCE_OBJECT = eINSTANCE.getModelChangeEvent_SourceObject();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ElementChangeEventImpl <em>Element Change Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ElementChangeEventImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getElementChangeEvent()
		 * @generated
		 */
		EClass ELEMENT_CHANGE_EVENT = eINSTANCE.getElementChangeEvent();

		/**
		 * The meta object literal for the '<em><b>Changed Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_CHANGE_EVENT__CHANGED_CLASS = eINSTANCE.getElementChangeEvent_ChangedClass();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeValueChangeEventImpl <em>Attribute Value Change Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AttributeValueChangeEventImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAttributeValueChangeEvent()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE_CHANGE_EVENT = eINSTANCE.getAttributeValueChangeEvent();

		/**
		 * The meta object literal for the '<em><b>Changed Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_VALUE_CHANGE_EVENT__CHANGED_ATTRIBUTE = eINSTANCE.getAttributeValueChangeEvent_ChangedAttribute();

		/**
		 * The meta object literal for the '<em><b>Before</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_VALUE_CHANGE_EVENT__BEFORE = eINSTANCE.getAttributeValueChangeEvent_Before();

		/**
		 * The meta object literal for the '<em><b>After</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_VALUE_CHANGE_EVENT__AFTER = eINSTANCE.getAttributeValueChangeEvent_After();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ElementLifeCycleEventImpl <em>Element Life Cycle Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ElementLifeCycleEventImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getElementLifeCycleEvent()
		 * @generated
		 */
		EClass ELEMENT_LIFE_CYCLE_EVENT = eINSTANCE.getElementLifeCycleEvent();

		/**
		 * The meta object literal for the '<em><b>Containing Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_LIFE_CYCLE_EVENT__CONTAINING_ELEMENT = eINSTANCE.getElementLifeCycleEvent_ContainingElement();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.LinkLifeCycleEventImpl <em>Link Life Cycle Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.LinkLifeCycleEventImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getLinkLifeCycleEvent()
		 * @generated
		 */
		EClass LINK_LIFE_CYCLE_EVENT = eINSTANCE.getLinkLifeCycleEvent();

		/**
		 * The meta object literal for the '<em><b>Changed Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_LIFE_CYCLE_EVENT__CHANGED_REFERENCE = eINSTANCE.getLinkLifeCycleEvent_ChangedReference();

		/**
		 * The meta object literal for the '<em><b>Corresponding Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LINK_LIFE_CYCLE_EVENT__CORRESPONDING_OBJECT = eINSTANCE.getLinkLifeCycleEvent_CorrespondingObject();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ElementCreateEventImpl <em>Element Create Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ElementCreateEventImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getElementCreateEvent()
		 * @generated
		 */
		EClass ELEMENT_CREATE_EVENT = eINSTANCE.getElementCreateEvent();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ElementDeleteEventImpl <em>Element Delete Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ElementDeleteEventImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getElementDeleteEvent()
		 * @generated
		 */
		EClass ELEMENT_DELETE_EVENT = eINSTANCE.getElementDeleteEvent();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.LinkCreateEventImpl <em>Link Create Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.LinkCreateEventImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getLinkCreateEvent()
		 * @generated
		 */
		EClass LINK_CREATE_EVENT = eINSTANCE.getLinkCreateEvent();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.LinkDeleteEventImpl <em>Link Delete Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.LinkDeleteEventImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getLinkDeleteEvent()
		 * @generated
		 */
		EClass LINK_DELETE_EVENT = eINSTANCE.getLinkDeleteEvent();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter <em>Event Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventFilter()
		 * @generated
		 */
		EClass EVENT_FILTER = eINSTANCE.getEventFilter();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventTypeFilterImpl <em>Event Type Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventTypeFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventTypeFilter()
		 * @generated
		 */
		EClass EVENT_TYPE_FILTER = eINSTANCE.getEventTypeFilter();

		/**
		 * The meta object literal for the '<em><b>Event EClass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_TYPE_FILTER__EVENT_ECLASS = eINSTANCE.getEventTypeFilter_EventEClass();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AndFilterImpl <em>And Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AndFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAndFilter()
		 * @generated
		 */
		EClass AND_FILTER = eINSTANCE.getAndFilter();

		/**
		 * The meta object literal for the '<em><b>Filters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AND_FILTER__FILTERS = eINSTANCE.getAndFilter_Filters();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.OrFilterImpl <em>Or Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.OrFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getOrFilter()
		 * @generated
		 */
		EClass OR_FILTER = eINSTANCE.getOrFilter();

		/**
		 * The meta object literal for the '<em><b>Filters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OR_FILTER__FILTERS = eINSTANCE.getOrFilter_Filters();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.NotFilterImpl <em>Not Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.NotFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getNotFilter()
		 * @generated
		 */
		EClass NOT_FILTER = eINSTANCE.getNotFilter();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_FILTER__FILTER = eINSTANCE.getNotFilter_Filter();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ClassFilterImpl <em>Class Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ClassFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getClassFilter()
		 * @generated
		 */
		EClass CLASS_FILTER = eINSTANCE.getClassFilter();

		/**
		 * The meta object literal for the '<em><b>Wanted Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_FILTER__WANTED_CLASS = eINSTANCE.getClassFilter_WantedClass();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.InstanceFilterImpl <em>Instance Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.InstanceFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getInstanceFilter()
		 * @generated
		 */
		EClass INSTANCE_FILTER = eINSTANCE.getInstanceFilter();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_FILTER__INSTANCE = eINSTANCE.getInstanceFilter_Instance();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeFilterImpl <em>Attribute Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AttributeFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAttributeFilter()
		 * @generated
		 */
		EClass ATTRIBUTE_FILTER = eINSTANCE.getAttributeFilter();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_FILTER__ATTRIBUTE = eINSTANCE.getAttributeFilter_Attribute();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ContainerFilterImpl <em>Container Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ContainerFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getContainerFilter()
		 * @generated
		 */
		EClass CONTAINER_FILTER = eINSTANCE.getContainerFilter();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER_FILTER__CONTAINER = eINSTANCE.getContainerFilter_Container();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.CompositionHierarchyFilterImpl <em>Composition Hierarchy Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.CompositionHierarchyFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getCompositionHierarchyFilter()
		 * @generated
		 */
		EClass COMPOSITION_HIERARCHY_FILTER = eINSTANCE.getCompositionHierarchyFilter();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_HIERARCHY_FILTER__ROOT = eINSTANCE.getCompositionHierarchyFilter_Root();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.PackageFilterImpl <em>Package Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.PackageFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getPackageFilter()
		 * @generated
		 */
		EClass PACKAGE_FILTER = eINSTANCE.getPackageFilter();

		/**
		 * The meta object literal for the '<em><b>Wanted Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_FILTER__WANTED_PACKAGE = eINSTANCE.getPackageFilter_WantedPackage();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AssociationFilterImpl <em>Association Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AssociationFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAssociationFilter()
		 * @generated
		 */
		EClass ASSOCIATION_FILTER = eINSTANCE.getAssociationFilter();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_FILTER__REFERENCE = eINSTANCE.getAssociationFilter_Reference();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventMapperImpl <em>Event Mapper</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventMapperImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventMapper()
		 * @generated
		 */
		EClass EVENT_MAPPER = eINSTANCE.getEventMapper();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventListenerImpl <em>Event Listener</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventListenerImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventListener()
		 * @generated
		 */
		EClass EVENT_LISTENER = eINSTANCE.getEventListener();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeMultiValueChangeEventImpl <em>Attribute Multi Value Change Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AttributeMultiValueChangeEventImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAttributeMultiValueChangeEvent()
		 * @generated
		 */
		EClass ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT = eINSTANCE.getAttributeMultiValueChangeEvent();

		/**
		 * The meta object literal for the '<em><b>Add</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_MULTI_VALUE_CHANGE_EVENT__ADD = eINSTANCE.getAttributeMultiValueChangeEvent_Add();

		/**
		 * The meta object literal for the '<em>Adapter</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.notify.Adapter
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAdapter()
		 * @generated
		 */
		EDataType ADAPTER = eINSTANCE.getAdapter();

		/**
		 * The meta object literal for the '<em>Notification</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.notify.Notification
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getNotification()
		 * @generated
		 */
		EDataType NOTIFICATION = eINSTANCE.getNotification();

		/**
		 * The meta object literal for the '<em>Notifier</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.notify.Notifier
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getNotifier()
		 * @generated
		 */
		EDataType NOTIFIER = eINSTANCE.getNotifier();

	}

} //EventManagerPackage
