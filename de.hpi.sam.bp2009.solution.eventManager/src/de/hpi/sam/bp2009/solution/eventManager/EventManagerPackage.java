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
	 * The number of structural features of the '<em>Event Manager</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_MANAGER_FEATURE_COUNT = 0;

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
	 * The number of structural features of the '<em>Element Change Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_CHANGE_EVENT_FEATURE_COUNT = MODEL_CHANGE_EVENT_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>Attribute Value Change Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_VALUE_CHANGE_EVENT_FEATURE_COUNT = ELEMENT_CHANGE_EVENT_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Source Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LIFE_CYCLE_EVENT__SOURCE_OBJECT = MODEL_CHANGE_EVENT__SOURCE_OBJECT;

	/**
	 * The number of structural features of the '<em>Link Life Cycle Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_LIFE_CYCLE_EVENT_FEATURE_COUNT = MODEL_CHANGE_EVENT_FEATURE_COUNT + 0;

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
	int ELEMENT_LIFE_CYCLE_EVENT__SOURCE_OBJECT = LINK_LIFE_CYCLE_EVENT__SOURCE_OBJECT;

	/**
	 * The number of structural features of the '<em>Element Life Cycle Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_LIFE_CYCLE_EVENT_FEATURE_COUNT = LINK_LIFE_CYCLE_EVENT_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>Link Delete Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_DELETE_EVENT_FEATURE_COUNT = LINK_LIFE_CYCLE_EVENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventFilterImpl <em>Event Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventFilter()
	 * @generated
	 */
	int EVENT_FILTER = 10;

	/**
	 * The feature id for the '<em><b>Filter Matcher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FILTER__FILTER_MATCHER = 0;

	/**
	 * The feature id for the '<em><b>Filter Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FILTER__FILTER_CRITERION = 1;

	/**
	 * The number of structural features of the '<em>Event Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FILTER_FEATURE_COUNT = 2;

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
	 * The feature id for the '<em><b>Filter Matcher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TYPE_FILTER__FILTER_MATCHER = EVENT_FILTER__FILTER_MATCHER;

	/**
	 * The feature id for the '<em><b>Filter Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TYPE_FILTER__FILTER_CRITERION = EVENT_FILTER__FILTER_CRITERION;

	/**
	 * The number of structural features of the '<em>Event Type Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TYPE_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Filter Matcher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FILTER__FILTER_MATCHER = EVENT_FILTER__FILTER_MATCHER;

	/**
	 * The feature id for the '<em><b>Filter Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FILTER__FILTER_CRITERION = EVENT_FILTER__FILTER_CRITERION;

	/**
	 * The number of structural features of the '<em>And Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Filter Matcher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FILTER__FILTER_MATCHER = EVENT_FILTER__FILTER_MATCHER;

	/**
	 * The feature id for the '<em><b>Filter Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FILTER__FILTER_CRITERION = EVENT_FILTER__FILTER_CRITERION;

	/**
	 * The number of structural features of the '<em>Or Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Filter Matcher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FILTER__FILTER_MATCHER = EVENT_FILTER__FILTER_MATCHER;

	/**
	 * The feature id for the '<em><b>Filter Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FILTER__FILTER_CRITERION = EVENT_FILTER__FILTER_CRITERION;

	/**
	 * The number of structural features of the '<em>Not Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Filter Matcher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FILTER__FILTER_MATCHER = EVENT_FILTER__FILTER_MATCHER;

	/**
	 * The feature id for the '<em><b>Filter Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FILTER__FILTER_CRITERION = EVENT_FILTER__FILTER_CRITERION;

	/**
	 * The number of structural features of the '<em>Class Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Filter Matcher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FILTER__FILTER_MATCHER = EVENT_FILTER__FILTER_MATCHER;

	/**
	 * The feature id for the '<em><b>Filter Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FILTER__FILTER_CRITERION = EVENT_FILTER__FILTER_CRITERION;

	/**
	 * The number of structural features of the '<em>Instance Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Filter Matcher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FILTER__FILTER_MATCHER = EVENT_FILTER__FILTER_MATCHER;

	/**
	 * The feature id for the '<em><b>Filter Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FILTER__FILTER_CRITERION = EVENT_FILTER__FILTER_CRITERION;

	/**
	 * The number of structural features of the '<em>Attribute Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Filter Matcher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FILTER__FILTER_MATCHER = EVENT_FILTER__FILTER_MATCHER;

	/**
	 * The feature id for the '<em><b>Filter Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FILTER__FILTER_CRITERION = EVENT_FILTER__FILTER_CRITERION;

	/**
	 * The number of structural features of the '<em>Container Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Filter Matcher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_HIERARCHY_FILTER__FILTER_MATCHER = EVENT_FILTER__FILTER_MATCHER;

	/**
	 * The feature id for the '<em><b>Filter Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_HIERARCHY_FILTER__FILTER_CRITERION = EVENT_FILTER__FILTER_CRITERION;

	/**
	 * The number of structural features of the '<em>Composition Hierarchy Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_HIERARCHY_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Filter Matcher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FILTER__FILTER_MATCHER = EVENT_FILTER__FILTER_MATCHER;

	/**
	 * The feature id for the '<em><b>Filter Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FILTER__FILTER_CRITERION = EVENT_FILTER__FILTER_CRITERION;

	/**
	 * The number of structural features of the '<em>Package Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Filter Matcher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FILTER__FILTER_MATCHER = EVENT_FILTER__FILTER_MATCHER;

	/**
	 * The feature id for the '<em><b>Filter Criterion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FILTER__FILTER_CRITERION = EVENT_FILTER__FILTER_CRITERION;

	/**
	 * The number of structural features of the '<em>Association Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.FilterMatcher <em>Filter Matcher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.FilterMatcher
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getFilterMatcher()
	 * @generated
	 */
	int FILTER_MATCHER = 22;

	/**
	 * The number of structural features of the '<em>Filter Matcher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILTER_MATCHER_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventNotificationImpl <em>Event Notification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventNotificationImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventNotification()
	 * @generated
	 */
	int EVENT_NOTIFICATION = 23;

	/**
	 * The number of structural features of the '<em>Event Notification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_NOTIFICATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '<em>Adapter</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAdapter()
	 * @generated
	 */
	int ADAPTER = 24;


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
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent <em>Attribute Value Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Value Change Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent
	 * @generated
	 */
	EClass getAttributeValueChangeEvent();

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
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent <em>Link Life Cycle Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Life Cycle Event</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent
	 * @generated
	 */
	EClass getLinkLifeCycleEvent();

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
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#getFilterMatcher <em>Filter Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Filter Matcher</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter#getFilterMatcher()
	 * @see #getEventFilter()
	 * @generated
	 */
	EReference getEventFilter_FilterMatcher();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter#getFilterCriterion <em>Filter Criterion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter Criterion</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter#getFilterCriterion()
	 * @see #getEventFilter()
	 * @generated
	 */
	EAttribute getEventFilter_FilterCriterion();

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
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.AndFilter <em>And Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AndFilter
	 * @generated
	 */
	EClass getAndFilter();

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
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.NotFilter <em>Not Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.NotFilter
	 * @generated
	 */
	EClass getNotFilter();

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
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.InstanceFilter <em>Instance Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.InstanceFilter
	 * @generated
	 */
	EClass getInstanceFilter();

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
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.ContainerFilter <em>Container Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ContainerFilter
	 * @generated
	 */
	EClass getContainerFilter();

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
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.PackageFilter <em>Package Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.PackageFilter
	 * @generated
	 */
	EClass getPackageFilter();

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
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.FilterMatcher <em>Filter Matcher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filter Matcher</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.FilterMatcher
	 * @generated
	 */
	EClass getFilterMatcher();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.EventNotification <em>Event Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Notification</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventNotification
	 * @generated
	 */
	EClass getEventNotification();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeValueChangeEventImpl <em>Attribute Value Change Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AttributeValueChangeEventImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAttributeValueChangeEvent()
		 * @generated
		 */
		EClass ATTRIBUTE_VALUE_CHANGE_EVENT = eINSTANCE.getAttributeValueChangeEvent();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.LinkLifeCycleEventImpl <em>Link Life Cycle Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.LinkLifeCycleEventImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getLinkLifeCycleEvent()
		 * @generated
		 */
		EClass LINK_LIFE_CYCLE_EVENT = eINSTANCE.getLinkLifeCycleEvent();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventFilterImpl <em>Event Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventFilter()
		 * @generated
		 */
		EClass EVENT_FILTER = eINSTANCE.getEventFilter();

		/**
		 * The meta object literal for the '<em><b>Filter Matcher</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_FILTER__FILTER_MATCHER = eINSTANCE.getEventFilter_FilterMatcher();

		/**
		 * The meta object literal for the '<em><b>Filter Criterion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_FILTER__FILTER_CRITERION = eINSTANCE.getEventFilter_FilterCriterion();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AndFilterImpl <em>And Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AndFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAndFilter()
		 * @generated
		 */
		EClass AND_FILTER = eINSTANCE.getAndFilter();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.NotFilterImpl <em>Not Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.NotFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getNotFilter()
		 * @generated
		 */
		EClass NOT_FILTER = eINSTANCE.getNotFilter();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.InstanceFilterImpl <em>Instance Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.InstanceFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getInstanceFilter()
		 * @generated
		 */
		EClass INSTANCE_FILTER = eINSTANCE.getInstanceFilter();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ContainerFilterImpl <em>Container Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ContainerFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getContainerFilter()
		 * @generated
		 */
		EClass CONTAINER_FILTER = eINSTANCE.getContainerFilter();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.PackageFilterImpl <em>Package Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.PackageFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getPackageFilter()
		 * @generated
		 */
		EClass PACKAGE_FILTER = eINSTANCE.getPackageFilter();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.FilterMatcher <em>Filter Matcher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.FilterMatcher
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getFilterMatcher()
		 * @generated
		 */
		EClass FILTER_MATCHER = eINSTANCE.getFilterMatcher();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventNotificationImpl <em>Event Notification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventNotificationImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventNotification()
		 * @generated
		 */
		EClass EVENT_NOTIFICATION = eINSTANCE.getEventNotification();

		/**
		 * The meta object literal for the '<em>Adapter</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.notify.Adapter
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAdapter()
		 * @generated
		 */
		EDataType ADAPTER = eINSTANCE.getAdapter();

	}

} //EventManagerPackage
