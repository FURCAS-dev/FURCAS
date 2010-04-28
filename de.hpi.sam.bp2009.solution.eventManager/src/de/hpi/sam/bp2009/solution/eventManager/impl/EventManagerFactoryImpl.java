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
			case EventManagerPackage.EVENT_TYPE_FILTER: return createEventTypeFilter();
			case EventManagerPackage.AND_FILTER: return createAndFilter();
			case EventManagerPackage.OR_FILTER: return createOrFilter();
			case EventManagerPackage.CLASS_FILTER: return createClassFilter();
			case EventManagerPackage.ATTRIBUTE_FILTER: return createAttributeFilter();
			case EventManagerPackage.PACKAGE_FILTER: return createPackageFilter();
			case EventManagerPackage.ASSOCIATION_FILTER: return createAssociationFilter();
			case EventManagerPackage.OLD_VALUE_CLASS_FILTER: return createOldValueClassFilter();
			case EventManagerPackage.CONTAINMENT_FILTER: return createContainmentFilter();
			case EventManagerPackage.NEW_VALUE_CLASS_FILTER: return createNewValueClassFilter();
			case EventManagerPackage.STRUCTURAL_FEATURE_FILTER: return createStructuralFeatureFilter();
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
	public ClassFilter createClassFilter() {
		ClassFilterImpl classFilter = new ClassFilterImpl();
		return classFilter;
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
	public OldValueClassFilter createOldValueClassFilter() {
		OldValueClassFilterImpl oldValueClassFilter = new OldValueClassFilterImpl();
		return oldValueClassFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainmentFilter createContainmentFilter() {
		ContainmentFilterImpl containmentFilter = new ContainmentFilterImpl();
		return containmentFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewValueClassFilter createNewValueClassFilter() {
		NewValueClassFilterImpl newValueClassFilter = new NewValueClassFilterImpl();
		return newValueClassFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructuralFeatureFilter createStructuralFeatureFilter() {
		StructuralFeatureFilterImpl structuralFeatureFilter = new StructuralFeatureFilterImpl();
		return structuralFeatureFilter;
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
