/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.common.notify.Notification;
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
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventNotification#getNotification <em>Notification</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventNotification()
 * @model
 * @generated NOT
 */
public interface EventNotification extends EObject,Notification {

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

	/**
	 * Returns the value of the '<em><b>Notification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notification</em>' attribute.
	 * @see #setNotification(Notification)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventNotification_Notification()
	 * @model dataType="de.hpi.sam.bp2009.solution.eventManager.Notification"
	 * @generated
	 */
	Notification getNotification();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.EventNotification#getNotification <em>Notification</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notification</em>' attribute.
	 * @see #getNotification()
	 * @generated
	 */
	void setNotification(Notification value);
} // EventNotification
