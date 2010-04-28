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
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter <em>Event Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getEventFilter()
	 * @generated
	 */
	int EVENT_FILTER = 1;

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
	int EVENT_TYPE_FILTER = 2;

	/**
	 * The feature id for the '<em><b>Matching Notification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TYPE_FILTER__MATCHING_NOTIFICATION = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Event Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TYPE_FILTER__EVENT_TYPE = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event Type Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_TYPE_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AndFilterImpl <em>And Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AndFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAndFilter()
	 * @generated
	 */
	int AND_FILTER = 3;

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
	int OR_FILTER = 4;

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
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ClassFilterImpl <em>Class Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ClassFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getClassFilter()
	 * @generated
	 */
	int CLASS_FILTER = 5;

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
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.StructuralFeatureFilterImpl <em>Structural Feature Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.StructuralFeatureFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getStructuralFeatureFilter()
	 * @generated
	 */
	int STRUCTURAL_FEATURE_FILTER = 12;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_FILTER__FEATURE = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Structural Feature Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeFilterImpl <em>Attribute Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AttributeFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAttributeFilter()
	 * @generated
	 */
	int ATTRIBUTE_FILTER = 6;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FILTER__FEATURE = STRUCTURAL_FEATURE_FILTER__FEATURE;

	/**
	 * The number of structural features of the '<em>Attribute Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FILTER_FEATURE_COUNT = STRUCTURAL_FEATURE_FILTER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.PackageFilterImpl <em>Package Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.PackageFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getPackageFilter()
	 * @generated
	 */
	int PACKAGE_FILTER = 7;

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
	int ASSOCIATION_FILTER = 8;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FILTER__FEATURE = STRUCTURAL_FEATURE_FILTER__FEATURE;

	/**
	 * The number of structural features of the '<em>Association Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FILTER_FEATURE_COUNT = STRUCTURAL_FEATURE_FILTER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.OldValueClassFilterImpl <em>Old Value Class Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.OldValueClassFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getOldValueClassFilter()
	 * @generated
	 */
	int OLD_VALUE_CLASS_FILTER = 9;

	/**
	 * The feature id for the '<em><b>Affected Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_VALUE_CLASS_FILTER__AFFECTED_CLASS = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Old Value Class Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OLD_VALUE_CLASS_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ContainmentFilterImpl <em>Containment Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ContainmentFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getContainmentFilter()
	 * @generated
	 */
	int CONTAINMENT_FILTER = 10;

	/**
	 * The number of structural features of the '<em>Containment Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINMENT_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.NewValueClassFilterImpl <em>New Value Class Filter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.NewValueClassFilterImpl
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getNewValueClassFilter()
	 * @generated
	 */
	int NEW_VALUE_CLASS_FILTER = 11;

	/**
	 * The feature id for the '<em><b>Affected Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_VALUE_CLASS_FILTER__AFFECTED_CLASS = EVENT_FILTER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>New Value Class Filter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_VALUE_CLASS_FILTER_FEATURE_COUNT = EVENT_FILTER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>Adapter</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Adapter
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAdapter()
	 * @generated
	 */
	int ADAPTER = 13;


	/**
	 * The meta object id for the '<em>Notification</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Notification
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getNotification()
	 * @generated
	 */
	int NOTIFICATION = 14;


	/**
	 * The meta object id for the '<em>Notifier</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.notify.Notifier
	 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getNotifier()
	 * @generated
	 */
	int NOTIFIER = 15;


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
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter#getMatchingNotification <em>Matching Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matching Notification</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter#getMatchingNotification()
	 * @see #getEventTypeFilter()
	 * @generated
	 */
	EAttribute getEventTypeFilter_MatchingNotification();

	/**
	 * Returns the meta object for the attribute '{@link de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter#getEventType <em>Event Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Event Type</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter#getEventType()
	 * @see #getEventTypeFilter()
	 * @generated
	 */
	EAttribute getEventTypeFilter_EventType();

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
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeFilter <em>Attribute Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AttributeFilter
	 * @generated
	 */
	EClass getAttributeFilter();

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
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.OldValueClassFilter <em>Old Value Class Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Old Value Class Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.OldValueClassFilter
	 * @generated
	 */
	EClass getOldValueClassFilter();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.OldValueClassFilter#getAffectedClass <em>Affected Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Affected Class</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.OldValueClassFilter#getAffectedClass()
	 * @see #getOldValueClassFilter()
	 * @generated
	 */
	EReference getOldValueClassFilter_AffectedClass();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.ContainmentFilter <em>Containment Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Containment Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ContainmentFilter
	 * @generated
	 */
	EClass getContainmentFilter();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.NewValueClassFilter <em>New Value Class Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Value Class Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.NewValueClassFilter
	 * @generated
	 */
	EClass getNewValueClassFilter();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.NewValueClassFilter#getAffectedClass <em>Affected Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Affected Class</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.NewValueClassFilter#getAffectedClass()
	 * @see #getNewValueClassFilter()
	 * @generated
	 */
	EReference getNewValueClassFilter_AffectedClass();

	/**
	 * Returns the meta object for class '{@link de.hpi.sam.bp2009.solution.eventManager.StructuralFeatureFilter <em>Structural Feature Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Feature Filter</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.StructuralFeatureFilter
	 * @generated
	 */
	EClass getStructuralFeatureFilter();

	/**
	 * Returns the meta object for the reference '{@link de.hpi.sam.bp2009.solution.eventManager.StructuralFeatureFilter#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see de.hpi.sam.bp2009.solution.eventManager.StructuralFeatureFilter#getFeature()
	 * @see #getStructuralFeatureFilter()
	 * @generated
	 */
	EReference getStructuralFeatureFilter_Feature();

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
		 * The meta object literal for the '<em><b>Matching Notification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_TYPE_FILTER__MATCHING_NOTIFICATION = eINSTANCE.getEventTypeFilter_MatchingNotification();

		/**
		 * The meta object literal for the '<em><b>Event Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_TYPE_FILTER__EVENT_TYPE = eINSTANCE.getEventTypeFilter_EventType();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.AttributeFilterImpl <em>Attribute Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.AttributeFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getAttributeFilter()
		 * @generated
		 */
		EClass ATTRIBUTE_FILTER = eINSTANCE.getAttributeFilter();

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
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.OldValueClassFilterImpl <em>Old Value Class Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.OldValueClassFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getOldValueClassFilter()
		 * @generated
		 */
		EClass OLD_VALUE_CLASS_FILTER = eINSTANCE.getOldValueClassFilter();

		/**
		 * The meta object literal for the '<em><b>Affected Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OLD_VALUE_CLASS_FILTER__AFFECTED_CLASS = eINSTANCE.getOldValueClassFilter_AffectedClass();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.ContainmentFilterImpl <em>Containment Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.ContainmentFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getContainmentFilter()
		 * @generated
		 */
		EClass CONTAINMENT_FILTER = eINSTANCE.getContainmentFilter();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.NewValueClassFilterImpl <em>New Value Class Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.NewValueClassFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getNewValueClassFilter()
		 * @generated
		 */
		EClass NEW_VALUE_CLASS_FILTER = eINSTANCE.getNewValueClassFilter();

		/**
		 * The meta object literal for the '<em><b>Affected Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_VALUE_CLASS_FILTER__AFFECTED_CLASS = eINSTANCE.getNewValueClassFilter_AffectedClass();

		/**
		 * The meta object literal for the '{@link de.hpi.sam.bp2009.solution.eventManager.impl.StructuralFeatureFilterImpl <em>Structural Feature Filter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.StructuralFeatureFilterImpl
		 * @see de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerPackageImpl#getStructuralFeatureFilter()
		 * @generated
		 */
		EClass STRUCTURAL_FEATURE_FILTER = eINSTANCE.getStructuralFeatureFilter();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURAL_FEATURE_FILTER__FEATURE = eINSTANCE.getStructuralFeatureFilter_Feature();

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
