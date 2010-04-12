/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedEventManager.impl;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManager;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerNotifyLiterals;
import de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventListener;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;
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
	public void subscribe(EList<Notifier> root, EventFilter filter,
			EventListener caller) {
		UUID id = UUID.randomUUID();
		eNotify(new ENotificationImpl(this,ModifiedEventManagerNotifyLiterals.START_SUBSCRIPTION_VALUE, Notification.NO_FEATURE_ID, id, ModifiedEventManagerNotifyLiterals.START_SUBSCRIPTION.getName()));
		super.subscribe(root, filter, caller);
		eNotify(new ENotificationImpl(this,ModifiedEventManagerNotifyLiterals.END_SUBSCRIPTION_VALUE, Notification.NO_FEATURE_ID, id, ModifiedEventManagerNotifyLiterals.END_SUBSCRIPTION.getName()));

	}
	
	@Override
	public void handleEMFEvent(Notification notification) {
		UUID id = UUID.randomUUID();
		eNotify(new ENotificationImpl(this,ModifiedEventManagerNotifyLiterals.START_EMF_EVENT_HANDLING_VALUE, Notification.NO_FEATURE_ID, id, ModifiedEventManagerNotifyLiterals.START_EMF_EVENT_HANDLING.getName()));
		System.out.println(notification);
		super.handleEMFEvent( notification);
		eNotify(new ENotificationImpl(this,ModifiedEventManagerNotifyLiterals.END_EMF_EVENT_HANDLING_VALUE, Notification.NO_FEATURE_ID, id, ModifiedEventManagerNotifyLiterals.END_EMF_EVENT_HANDLING.getName()));

	}
	@Override
	public void notifyApplication(EventListener application,
			ModelChangeEvent event, EventFilter matchingFilter) {
		UUID id = UUID.randomUUID();
		eNotify(new ENotificationImpl(this,ModifiedEventManagerNotifyLiterals.START_APPLICATION_NOTIFICATION_VALUE, Notification.NO_FEATURE_ID, id, ModifiedEventManagerNotifyLiterals.START_APPLICATION_NOTIFICATION.getName()));
		super.notifyApplication(application, event, matchingFilter);
		eNotify(new ENotificationImpl(this,ModifiedEventManagerNotifyLiterals.END_APPLICATION_NOTIFICATION_VALUE, Notification.NO_FEATURE_ID, id, ModifiedEventManagerNotifyLiterals.END_APPLICATION_NOTIFICATION.getName()));

	}
	
	

} //ModifiedEventManagerImpl
