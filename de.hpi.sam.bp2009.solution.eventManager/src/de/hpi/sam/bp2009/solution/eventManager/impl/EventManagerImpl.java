/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;


import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventMappper;
import de.hpi.sam.bp2009.solution.eventManager.EventNotification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.eventManager.impl.EventManagerImpl#getEventMapper <em>Event Mapper</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventManagerImpl extends EObjectImpl implements EventManager {
	/**
	 * The cached value of the '{@link #getEventMapper() <em>Event Mapper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventMapper()
	 * @generated
	 * @ordered
	 */
	protected EventMappper eventMapper;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected EventManagerImpl() {
		super();
		this.setEventMapper(EventManagerFactory.eINSTANCE.createEventMappper());
	}
	
	private class EventAdapter extends EContentAdapter{
		Adapter caller;
		EventFilter filter;
		//EventMappper mapper;

		public EventAdapter(Adapter listener, EventFilter filter, EventMappper mapper) {
			this.caller = listener;
			this.filter = filter;
			//this.mapper = mapper;
		}
		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			handleEMFEvent(caller, notification, filter);	
		}
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.EVENT_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventMappper getEventMapper() {
		if (eventMapper != null && eventMapper.eIsProxy()) {
			InternalEObject oldEventMapper = (InternalEObject)eventMapper;
			eventMapper = (EventMappper)eResolveProxy(oldEventMapper);
			if (eventMapper != oldEventMapper) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EventManagerPackage.EVENT_MANAGER__EVENT_MAPPER, oldEventMapper, eventMapper));
			}
		}
		return eventMapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventMappper basicGetEventMapper() {
		return eventMapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventMapper(EventMappper newEventMapper) {
		EventMappper oldEventMapper = eventMapper;
		eventMapper = newEventMapper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.EVENT_MANAGER__EVENT_MAPPER, oldEventMapper, eventMapper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void subscribe(Notifier root, EventFilter filter, Adapter caller) {
		root.eAdapters().add(new EventAdapter(caller, filter, getEventMapper()));
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void subscribe(EList<Notifier> root, EventFilter filter, Adapter caller) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void subscribeTransactional(EList<Notifier> root, EventFilter filter, Adapter caller) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void notifyApplication(Adapter application, EventNotification msg) {
		application.notifyChanged(msg);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void handleEMFEvent(Adapter caller, Notification notification, EventFilter filter) {
		EventNotification noti = EventManagerFactory.eINSTANCE.createEventNotification();
		noti.setNotification(notification);
		noti.setEvent(getEventMapper().mapNotificationToEvent(notification));
		if(filter.matchesFor(noti.getEvent()))
			notifyApplication(caller, noti);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean unsubscribe(Adapter caller) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EventManagerPackage.EVENT_MANAGER__EVENT_MAPPER:
				if (resolve) return getEventMapper();
				return basicGetEventMapper();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EventManagerPackage.EVENT_MANAGER__EVENT_MAPPER:
				setEventMapper((EventMappper)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EventManagerPackage.EVENT_MANAGER__EVENT_MAPPER:
				setEventMapper((EventMappper)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EventManagerPackage.EVENT_MANAGER__EVENT_MAPPER:
				return eventMapper != null;
		}
		return super.eIsSet(featureID);
	}

} //EventManagerImpl
