/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.common.notify.Notification;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Type Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter#getMatchingNotification <em>Matching Notification</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter#getEventType <em>Event Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventTypeFilter()
 * @model
 * @generated
 */
public interface EventTypeFilter extends EventFilter {

	/**
     * Returns the value of the '<em><b>Matching Notification</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Matching Notification</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Matching Notification</em>' attribute.
     * @see #setMatchingNotification(Notification)
     * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventTypeFilter_MatchingNotification()
     * @model dataType="de.hpi.sam.bp2009.solution.eventManager.Notification"
     * @generated
     */
	Notification getMatchingNotification();

	/**
     * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter#getMatchingNotification <em>Matching Notification</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Matching Notification</em>' attribute.
     * @see #getMatchingNotification()
     * @generated
     */
	void setMatchingNotification(Notification value);

	/**
     * Returns the value of the '<em><b>Event Type</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Event Type</em>' attribute.
     * @see #setEventType(Integer)
     * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventTypeFilter_EventType()
     * @model
     * @generated
     */
	Integer getEventType();

	/**
     * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter#getEventType <em>Event Type</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Event Type</em>' attribute.
     * @see #getEventType()
     * @generated
     */
	void setEventType(Integer value);
} // EventTypeFilter
