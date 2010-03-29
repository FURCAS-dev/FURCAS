/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.common.notify.Adapter;
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
	 * @see #setEventMapper(EventMappper)
	 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventManager_EventMapper()
	 * @model required="true"
	 * @generated
	 */
	EventMappper getEventMapper();

	/**
	 * Sets the value of the '{@link de.hpi.sam.bp2009.solution.eventManager.EventManager#getEventMapper <em>Event Mapper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Mapper</em>' reference.
	 * @see #getEventMapper()
	 * @generated
	 */
	void setEventMapper(EventMappper value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model rootDataType="de.hpi.sam.bp2009.solution.eventManager.Notifier" rootRequired="true" rootMany="true" filterRequired="true" callerDataType="de.hpi.sam.bp2009.solution.eventManager.Adapter" callerRequired="true"
	 * @generated
	 */
	void subscribe(EList<Notifier> root, EventFilter filter, Adapter caller);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model rootDataType="de.hpi.sam.bp2009.solution.eventManager.Notifier" rootRequired="true" rootMany="true" filterRequired="true" callerDataType="de.hpi.sam.bp2009.solution.eventManager.Adapter" callerRequired="true"
	 * @generated
	 */
	void subscribeTransactional(EList<Notifier> root, EventFilter filter, Adapter caller);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model applicationDataType="de.hpi.sam.bp2009.solution.eventManager.Adapter" applicationRequired="true" msgRequired="true"
	 * @generated
	 */
	void notifyApplication(Adapter application, EventNotification msg);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model callerDataType="de.hpi.sam.bp2009.solution.eventManager.Adapter" callerRequired="true" notificationDataType="de.hpi.sam.bp2009.solution.eventManager.Notification" notificationRequired="true" filterRequired="true"
	 * @generated
	 */
	void handleEMFEvent(Adapter caller, Notification notification, EventFilter filter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model callerDataType="de.hpi.sam.bp2009.solution.eventManager.Adapter" callerRequired="true"
	 * @generated
	 */
	boolean unsubscribe(Adapter caller);

} // EventManager
