/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#getEventMapper <em>Event Mapper</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventManager()
 * @model
 * @generated
 */
public interface EventManager extends EObject {
	/**
	 * Returns the value of the '<em><b>Event Mapper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Mapper</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Mapper</em>' reference.
	 * @see #setEventMapper(EventMapper)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventManager_EventMapper()
	 * @model required="true"
	 * @generated
	 */
	EventMapper getEventMapper();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#getEventMapper <em>Event Mapper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Mapper</em>' reference.
	 * @see #getEventMapper()
	 * @generated
	 */
	void setEventMapper(EventMapper value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model rootDataType="de.hpi.sam.bp2009.solution.eventManager.Notifier" rootRequired="true" rootMany="true" filterRequired="true" callerRequired="true"
	 * @generated
	 */
	void subscribe(EList<Notifier> root, EventFilter filter, EventListener caller);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model rootDataType="de.hpi.sam.bp2009.solution.eventManager.Notifier" rootRequired="true" rootMany="true" filterRequired="true" callerRequired="true"
	 * @generated
	 */
	void subscribeTransactional(EList<Notifier> root, EventFilter filter, EventListener caller);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model applicationRequired="true" msgRequired="true"
	 * @generated
	 */
	void notifyApplication(EventListener application, ModelChangeEvent msg, EventFilter matchingFilter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model notificationDataType="de.hpi.sam.bp2009.solution.eventManager.Notification" notificationRequired="true"
	 * @generated
	 */
	void handleEMFEvent(Notification notification);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model callerRequired="true"
	 * @generated
	 */
	boolean unsubscribe(EventListener caller);

} // EventManager
