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
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventManager()
 * @model
 * @generated
 */
public interface EventManager extends EObject {
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
     * @model applicationDataType="de.hpi.sam.bp2009.solution.eventManager.Adapter" applicationRequired="true" msgDataType="de.hpi.sam.bp2009.solution.eventManager.Notification" msgRequired="true"
     * @generated
     */
	void notifyApplication(Adapter application, Notification msg, EventFilter matchingFilter);

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
     * @model callerDataType="de.hpi.sam.bp2009.solution.eventManager.Adapter" callerRequired="true"
     * @generated
     */
	boolean unsubscribe(Adapter caller);

} // EventManager
