/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage
 * @generated
 */
public class EventManagerAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EventManagerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventManagerAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EventManagerPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventManagerSwitch<Adapter> modelSwitch =
		new EventManagerSwitch<Adapter>() {
			@Override
			public Adapter caseEventManager(EventManager object) {
				return createEventManagerAdapter();
			}
			@Override
			public Adapter caseModelChangeEvent(ModelChangeEvent object) {
				return createModelChangeEventAdapter();
			}
			@Override
			public Adapter caseElementChangeEvent(ElementChangeEvent object) {
				return createElementChangeEventAdapter();
			}
			@Override
			public Adapter caseAttributeValueChangeEvent(AttributeValueChangeEvent object) {
				return createAttributeValueChangeEventAdapter();
			}
			@Override
			public Adapter caseElementLifeCycleEvent(ElementLifeCycleEvent object) {
				return createElementLifeCycleEventAdapter();
			}
			@Override
			public Adapter caseLinkLifeCycleEvent(LinkLifeCycleEvent object) {
				return createLinkLifeCycleEventAdapter();
			}
			@Override
			public Adapter caseElementCreateEvent(ElementCreateEvent object) {
				return createElementCreateEventAdapter();
			}
			@Override
			public Adapter caseElementDeleteEvent(ElementDeleteEvent object) {
				return createElementDeleteEventAdapter();
			}
			@Override
			public Adapter caseLinkCreateEvent(LinkCreateEvent object) {
				return createLinkCreateEventAdapter();
			}
			@Override
			public Adapter caseLinkDeleteEvent(LinkDeleteEvent object) {
				return createLinkDeleteEventAdapter();
			}
			@Override
			public Adapter caseEventFilter(EventFilter object) {
				return createEventFilterAdapter();
			}
			@Override
			public Adapter caseEventTypeFilter(EventTypeFilter object) {
				return createEventTypeFilterAdapter();
			}
			@Override
			public Adapter caseAndFilter(AndFilter object) {
				return createAndFilterAdapter();
			}
			@Override
			public Adapter caseOrFilter(OrFilter object) {
				return createOrFilterAdapter();
			}
			@Override
			public Adapter caseNotFilter(NotFilter object) {
				return createNotFilterAdapter();
			}
			@Override
			public Adapter caseClassFilter(ClassFilter object) {
				return createClassFilterAdapter();
			}
			@Override
			public Adapter caseInstanceFilter(InstanceFilter object) {
				return createInstanceFilterAdapter();
			}
			@Override
			public Adapter caseAttributeFilter(AttributeFilter object) {
				return createAttributeFilterAdapter();
			}
			@Override
			public Adapter caseContainerFilter(ContainerFilter object) {
				return createContainerFilterAdapter();
			}
			@Override
			public Adapter caseCompositionHierarchyFilter(CompositionHierarchyFilter object) {
				return createCompositionHierarchyFilterAdapter();
			}
			@Override
			public Adapter casePackageFilter(PackageFilter object) {
				return createPackageFilterAdapter();
			}
			@Override
			public Adapter caseAssociationFilter(AssociationFilter object) {
				return createAssociationFilterAdapter();
			}
			@Override
			public Adapter caseEventNotification(EventNotification object) {
				return createEventNotificationAdapter();
			}
			@Override
			public Adapter caseEventMappper(EventMappper object) {
				return createEventMappperAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.EventManager <em>Event Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManager
	 * @generated
	 */
	public Adapter createEventManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent <em>Model Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent
	 * @generated
	 */
	public Adapter createModelChangeEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.ElementChangeEvent <em>Element Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ElementChangeEvent
	 * @generated
	 */
	public Adapter createElementChangeEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent <em>Attribute Value Change Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent
	 * @generated
	 */
	public Adapter createAttributeValueChangeEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.ElementLifeCycleEvent <em>Element Life Cycle Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ElementLifeCycleEvent
	 * @generated
	 */
	public Adapter createElementLifeCycleEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent <em>Link Life Cycle Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.LinkLifeCycleEvent
	 * @generated
	 */
	public Adapter createLinkLifeCycleEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.ElementCreateEvent <em>Element Create Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ElementCreateEvent
	 * @generated
	 */
	public Adapter createElementCreateEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.ElementDeleteEvent <em>Element Delete Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ElementDeleteEvent
	 * @generated
	 */
	public Adapter createElementDeleteEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.LinkCreateEvent <em>Link Create Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.LinkCreateEvent
	 * @generated
	 */
	public Adapter createLinkCreateEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.LinkDeleteEvent <em>Link Delete Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.LinkDeleteEvent
	 * @generated
	 */
	public Adapter createLinkDeleteEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.EventFilter <em>Event Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventFilter
	 * @generated
	 */
	public Adapter createEventFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter <em>Event Type Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter
	 * @generated
	 */
	public Adapter createEventTypeFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.AndFilter <em>And Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AndFilter
	 * @generated
	 */
	public Adapter createAndFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.OrFilter <em>Or Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.OrFilter
	 * @generated
	 */
	public Adapter createOrFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.NotFilter <em>Not Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.NotFilter
	 * @generated
	 */
	public Adapter createNotFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.ClassFilter <em>Class Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ClassFilter
	 * @generated
	 */
	public Adapter createClassFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.InstanceFilter <em>Instance Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.InstanceFilter
	 * @generated
	 */
	public Adapter createInstanceFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.AttributeFilter <em>Attribute Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AttributeFilter
	 * @generated
	 */
	public Adapter createAttributeFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.ContainerFilter <em>Container Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.ContainerFilter
	 * @generated
	 */
	public Adapter createContainerFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.CompositionHierarchyFilter <em>Composition Hierarchy Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.CompositionHierarchyFilter
	 * @generated
	 */
	public Adapter createCompositionHierarchyFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.PackageFilter <em>Package Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.PackageFilter
	 * @generated
	 */
	public Adapter createPackageFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.AssociationFilter <em>Association Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.AssociationFilter
	 * @generated
	 */
	public Adapter createAssociationFilterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.EventNotification <em>Event Notification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventNotification
	 * @generated
	 */
	public Adapter createEventNotificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hpi.sam.bp2009.solution.eventManager.EventMappper <em>Event Mappper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventMappper
	 * @generated
	 */
	public Adapter createEventMappperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EventManagerAdapterFactory
