/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManager;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerPackage;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.NotifyLiterals;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventNotification;
import de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerImpl;

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
		eNotify(new ENotificationImpl(this,NotifyLiterals.START_SUBSCRIBTION_VALUE, Notification.NO_FEATURE_ID, null, caller));
		super.subscribe(root, filter, caller);
		eNotify(new ENotificationImpl(this,NotifyLiterals.END_SUBSCRIBTION_VALUE, Notification.NO_FEATURE_ID, null, caller));

	}
	
	@Override
	public void handleEMFEvent(Adapter caller, Notification notification,
			EventFilter filter) {
		eNotify(new ENotificationImpl(this,NotifyLiterals.START_EMF_EVENT_HANDLING_VALUE, Notification.NO_FEATURE_ID, null, caller));
		super.handleEMFEvent(caller, notification, filter);
		eNotify(new ENotificationImpl(this,NotifyLiterals.END_EMF_EVENT_HANDLING_VALUE, Notification.NO_FEATURE_ID, null, caller));

	}
	
	@Override
	public void notifyApplication(Adapter application, EventNotification msg) {
		eNotify(new ENotificationImpl(this,NotifyLiterals.START_APPLICATION_NOTIFICATION_VALUE, Notification.NO_FEATURE_ID, null, application));
		super.notifyApplication(application, msg);
		eNotify(new ENotificationImpl(this,NotifyLiterals.END_APPLICATION_NOTIFICATION_VALUE, Notification.NO_FEATURE_ID, null, application));

	}
	
	

} //ModifiedEventManagerImpl
