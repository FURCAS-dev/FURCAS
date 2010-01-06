/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.events.util;

import de.hpi.sam.bp2009.solution.events.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
 * @see de.hpi.sam.bp2009.solution.events.EventsPackage
 * @generated
 */
public class EventsSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EventsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventsSwitch() {
		if (modelPackage == null) {
			modelPackage = EventsPackage.eINSTANCE;
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
			case EventsPackage.MODEL_CHANGE_EVENT: {
				ModelChangeEvent modelChangeEvent = (ModelChangeEvent)theEObject;
				T result = caseModelChangeEvent(modelChangeEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.ELEMENT_CHANGE_EVENT: {
				ElementChangeEvent elementChangeEvent = (ElementChangeEvent)theEObject;
				T result = caseElementChangeEvent(elementChangeEvent);
				if (result == null) result = caseModelChangeEvent(elementChangeEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.ATTRIBUTE_VALUE_CHANGE_EVENT: {
				AttributeValueChangeEvent attributeValueChangeEvent = (AttributeValueChangeEvent)theEObject;
				T result = caseAttributeValueChangeEvent(attributeValueChangeEvent);
				if (result == null) result = caseElementChangeEvent(attributeValueChangeEvent);
				if (result == null) result = caseModelChangeEvent(attributeValueChangeEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.ELEMENT_LIFE_CYCLE_EVENT: {
				ElementLifeCycleEvent elementLifeCycleEvent = (ElementLifeCycleEvent)theEObject;
				T result = caseElementLifeCycleEvent(elementLifeCycleEvent);
				if (result == null) result = caseLinkLifeCycleEvent(elementLifeCycleEvent);
				if (result == null) result = caseModelChangeEvent(elementLifeCycleEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.LINK_LIFE_CYCLE_EVENT: {
				LinkLifeCycleEvent linkLifeCycleEvent = (LinkLifeCycleEvent)theEObject;
				T result = caseLinkLifeCycleEvent(linkLifeCycleEvent);
				if (result == null) result = caseModelChangeEvent(linkLifeCycleEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.ELEMENT_CREATE_EVENT: {
				ElementCreateEvent elementCreateEvent = (ElementCreateEvent)theEObject;
				T result = caseElementCreateEvent(elementCreateEvent);
				if (result == null) result = caseElementLifeCycleEvent(elementCreateEvent);
				if (result == null) result = caseLinkLifeCycleEvent(elementCreateEvent);
				if (result == null) result = caseModelChangeEvent(elementCreateEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.ELEMENT_DELETE_EVENT: {
				ElementDeleteEvent elementDeleteEvent = (ElementDeleteEvent)theEObject;
				T result = caseElementDeleteEvent(elementDeleteEvent);
				if (result == null) result = caseElementLifeCycleEvent(elementDeleteEvent);
				if (result == null) result = caseLinkLifeCycleEvent(elementDeleteEvent);
				if (result == null) result = caseModelChangeEvent(elementDeleteEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.LINK_CREATE_EVENT: {
				LinkCreateEvent linkCreateEvent = (LinkCreateEvent)theEObject;
				T result = caseLinkCreateEvent(linkCreateEvent);
				if (result == null) result = caseLinkLifeCycleEvent(linkCreateEvent);
				if (result == null) result = caseModelChangeEvent(linkCreateEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventsPackage.LINK_DELETE_EVENT: {
				LinkDeleteEvent linkDeleteEvent = (LinkDeleteEvent)theEObject;
				T result = caseLinkDeleteEvent(linkDeleteEvent);
				if (result == null) result = caseLinkLifeCycleEvent(linkDeleteEvent);
				if (result == null) result = caseModelChangeEvent(linkDeleteEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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

} //EventsSwitch
