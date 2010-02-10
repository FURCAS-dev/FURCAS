/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage
 * @generated
 */
public class EventManagerSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EventManagerPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventManagerSwitch() {
		if (modelPackage == null) {
			modelPackage = EventManagerPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EventManagerPackage.EVENT_MANAGER: {
				EventManager eventManager = (EventManager)theEObject;
				T result = caseEventManager(eventManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.MODEL_CHANGE_EVENT: {
				ModelChangeEvent modelChangeEvent = (ModelChangeEvent)theEObject;
				T result = caseModelChangeEvent(modelChangeEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.ELEMENT_CHANGE_EVENT: {
				ElementChangeEvent elementChangeEvent = (ElementChangeEvent)theEObject;
				T result = caseElementChangeEvent(elementChangeEvent);
				if (result == null) result = caseModelChangeEvent(elementChangeEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.ATTRIBUTE_VALUE_CHANGE_EVENT: {
				AttributeValueChangeEvent attributeValueChangeEvent = (AttributeValueChangeEvent)theEObject;
				T result = caseAttributeValueChangeEvent(attributeValueChangeEvent);
				if (result == null) result = caseElementChangeEvent(attributeValueChangeEvent);
				if (result == null) result = caseModelChangeEvent(attributeValueChangeEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.ELEMENT_LIFE_CYCLE_EVENT: {
				ElementLifeCycleEvent elementLifeCycleEvent = (ElementLifeCycleEvent)theEObject;
				T result = caseElementLifeCycleEvent(elementLifeCycleEvent);
				if (result == null) result = caseElementChangeEvent(elementLifeCycleEvent);
				if (result == null) result = caseModelChangeEvent(elementLifeCycleEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.LINK_LIFE_CYCLE_EVENT: {
				LinkLifeCycleEvent linkLifeCycleEvent = (LinkLifeCycleEvent)theEObject;
				T result = caseLinkLifeCycleEvent(linkLifeCycleEvent);
				if (result == null) result = caseElementChangeEvent(linkLifeCycleEvent);
				if (result == null) result = caseModelChangeEvent(linkLifeCycleEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.ELEMENT_CREATE_EVENT: {
				ElementCreateEvent elementCreateEvent = (ElementCreateEvent)theEObject;
				T result = caseElementCreateEvent(elementCreateEvent);
				if (result == null) result = caseElementLifeCycleEvent(elementCreateEvent);
				if (result == null) result = caseElementChangeEvent(elementCreateEvent);
				if (result == null) result = caseModelChangeEvent(elementCreateEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.ELEMENT_DELETE_EVENT: {
				ElementDeleteEvent elementDeleteEvent = (ElementDeleteEvent)theEObject;
				T result = caseElementDeleteEvent(elementDeleteEvent);
				if (result == null) result = caseElementLifeCycleEvent(elementDeleteEvent);
				if (result == null) result = caseElementChangeEvent(elementDeleteEvent);
				if (result == null) result = caseModelChangeEvent(elementDeleteEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.LINK_CREATE_EVENT: {
				LinkCreateEvent linkCreateEvent = (LinkCreateEvent)theEObject;
				T result = caseLinkCreateEvent(linkCreateEvent);
				if (result == null) result = caseLinkLifeCycleEvent(linkCreateEvent);
				if (result == null) result = caseElementChangeEvent(linkCreateEvent);
				if (result == null) result = caseModelChangeEvent(linkCreateEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.LINK_DELETE_EVENT: {
				LinkDeleteEvent linkDeleteEvent = (LinkDeleteEvent)theEObject;
				T result = caseLinkDeleteEvent(linkDeleteEvent);
				if (result == null) result = caseLinkLifeCycleEvent(linkDeleteEvent);
				if (result == null) result = caseElementChangeEvent(linkDeleteEvent);
				if (result == null) result = caseModelChangeEvent(linkDeleteEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.EVENT_FILTER: {
				EventFilter eventFilter = (EventFilter)theEObject;
				T result = caseEventFilter(eventFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.EVENT_TYPE_FILTER: {
				EventTypeFilter eventTypeFilter = (EventTypeFilter)theEObject;
				T result = caseEventTypeFilter(eventTypeFilter);
				if (result == null) result = caseEventFilter(eventTypeFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.AND_FILTER: {
				AndFilter andFilter = (AndFilter)theEObject;
				T result = caseAndFilter(andFilter);
				if (result == null) result = caseEventFilter(andFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.OR_FILTER: {
				OrFilter orFilter = (OrFilter)theEObject;
				T result = caseOrFilter(orFilter);
				if (result == null) result = caseEventFilter(orFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.NOT_FILTER: {
				NotFilter notFilter = (NotFilter)theEObject;
				T result = caseNotFilter(notFilter);
				if (result == null) result = caseEventFilter(notFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.CLASS_FILTER: {
				ClassFilter classFilter = (ClassFilter)theEObject;
				T result = caseClassFilter(classFilter);
				if (result == null) result = caseEventFilter(classFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.INSTANCE_FILTER: {
				InstanceFilter instanceFilter = (InstanceFilter)theEObject;
				T result = caseInstanceFilter(instanceFilter);
				if (result == null) result = caseEventFilter(instanceFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.ATTRIBUTE_FILTER: {
				AttributeFilter attributeFilter = (AttributeFilter)theEObject;
				T result = caseAttributeFilter(attributeFilter);
				if (result == null) result = caseEventFilter(attributeFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.CONTAINER_FILTER: {
				ContainerFilter containerFilter = (ContainerFilter)theEObject;
				T result = caseContainerFilter(containerFilter);
				if (result == null) result = caseEventFilter(containerFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.COMPOSITION_HIERARCHY_FILTER: {
				CompositionHierarchyFilter compositionHierarchyFilter = (CompositionHierarchyFilter)theEObject;
				T result = caseCompositionHierarchyFilter(compositionHierarchyFilter);
				if (result == null) result = caseEventFilter(compositionHierarchyFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.PACKAGE_FILTER: {
				PackageFilter packageFilter = (PackageFilter)theEObject;
				T result = casePackageFilter(packageFilter);
				if (result == null) result = caseEventFilter(packageFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.ASSOCIATION_FILTER: {
				AssociationFilter associationFilter = (AssociationFilter)theEObject;
				T result = caseAssociationFilter(associationFilter);
				if (result == null) result = caseEventFilter(associationFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.EVENT_NOTIFICATION: {
				EventNotification eventNotification = (EventNotification)theEObject;
				T result = caseEventNotification(eventNotification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.EVENT_MAPPPER: {
				EventMappper eventMappper = (EventMappper)theEObject;
				T result = caseEventMappper(eventMappper);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventManager(EventManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Change Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Change Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelChangeEvent(ModelChangeEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Change Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Change Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementChangeEvent(ElementChangeEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Value Change Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Value Change Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeValueChangeEvent(AttributeValueChangeEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Life Cycle Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Life Cycle Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementLifeCycleEvent(ElementLifeCycleEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Life Cycle Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Life Cycle Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkLifeCycleEvent(LinkLifeCycleEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Create Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Create Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementCreateEvent(ElementCreateEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element Delete Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element Delete Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElementDeleteEvent(ElementDeleteEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Create Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Create Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkCreateEvent(LinkCreateEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Link Delete Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Delete Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkDeleteEvent(LinkDeleteEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventFilter(EventFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Type Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Type Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventTypeFilter(EventTypeFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndFilter(AndFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrFilter(OrFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotFilter(NotFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassFilter(ClassFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceFilter(InstanceFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeFilter(AttributeFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Container Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Container Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainerFilter(ContainerFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composition Hierarchy Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composition Hierarchy Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositionHierarchyFilter(CompositionHierarchyFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageFilter(PackageFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociationFilter(AssociationFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Notification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Notification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventNotification(EventNotification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Mappper</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Mappper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventMappper(EventMappper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //EventManagerSwitch
