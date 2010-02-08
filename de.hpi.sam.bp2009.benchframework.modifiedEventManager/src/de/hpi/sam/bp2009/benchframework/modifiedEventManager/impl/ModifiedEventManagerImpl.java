/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl;

import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManager;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerPackage;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventNotification;
import de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerImpl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modified Event Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ModifiedEventManagerImpl extends EventManagerImpl implements ModifiedEventManager {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifiedEventManagerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifiedEventManagerPackage.Literals.MODIFIED_EVENT_MANAGER;
	}
	
	@Override
	public void subscribe(Notifier root, EventFilter filter, Adapter caller) {
		sendBenchmarkNotification(caller, true);
		super.subscribe(root, filter, caller);
	}
	
	@Override
	public void handleEMFEvent(Adapter caller, Notification notification,
			EventFilter filter) {
		sendBenchmarkNotification(caller, true);
		super.handleEMFEvent(caller, notification, filter);
	}
	
	@Override
	public void notifyApplication(Adapter application, EventNotification msg) {
		sendBenchmarkNotification(application, false);
		super.notifyApplication(application, msg);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void sendBenchmarkNotification(Object communicationPartner, boolean incoming) {
		//TODO: think about adding the method that caused the notification as a parameter
		ENotificationImpl n;
		if (incoming)
			n = new ENotificationImpl(this, 1, null, null, communicationPartner);
		else
			n = new ENotificationImpl(this, 0, null, null, communicationPartner);

		for (Adapter a : eAdapters){
			a.notifyChanged(n);
		}
	}
	

} //ModifiedEventManagerImpl
