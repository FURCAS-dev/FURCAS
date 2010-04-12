/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Notification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventNotification#getEvent <em>Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventNotification()
 * @model
 * @generated
 */
public interface EventNotification extends EObject {

	/**
	 * Returns the value of the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' reference.
	 * @see #setEvent(ModelChangeEvent)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventNotification_Event()
	 * @model
	 * @generated
	 */
	ModelChangeEvent getEvent();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.EventNotification#getEvent <em>Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(ModelChangeEvent value);
} // EventNotification
