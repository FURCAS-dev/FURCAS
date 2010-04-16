/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;


import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventListener;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventMapper;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;

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
	private class EventAdapter extends EContentAdapter{
		@Override
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			handleEMFEvent(notification);	
		}
	}
	/**
	 * The cached value of the '{@link #getEventMapper() <em>Event Mapper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventMapper()
	 * @generated
	 * @ordered
	 */
	
	protected EventMapper eventMapper;
	private Map<EventFilter, EventListener> rootFilterToListenerMap = new HashMap<EventFilter, EventListener>();
	private EventAdapter adapter = new EventAdapter();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected EventManagerImpl() {
		super();
		this.setEventMapper(EventManagerFactory.eINSTANCE.createEventMapper());
		this.adapter= new EventAdapter();
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventMapper basicGetEventMapper() {
		return eventMapper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventMapper(EventMapper newEventMapper) {
		EventMapper oldEventMapper = eventMapper;
		eventMapper = newEventMapper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EventManagerPackage.EVENT_MANAGER__EVENT_MAPPER, oldEventMapper, eventMapper));
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EventManagerPackage.EVENT_MANAGER__EVENT_MAPPER:
				return eventMapper != null;
		}
		return super.eIsSet(featureID);
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
				setEventMapper((EventMapper)newValue);
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
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.EVENT_MANAGER;
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
				setEventMapper((EventMapper)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventMapper getEventMapper() {
		if (eventMapper != null && eventMapper.eIsProxy()) {
			InternalEObject oldEventMapper = (InternalEObject)eventMapper;
			eventMapper = (EventMapper)eResolveProxy(oldEventMapper);
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
	 * @generated NOT
	 */
	public void handleEMFEvent(Notification notification) {
		System.out.println(notification);
		for(ModelChangeEvent event:getEventMapper().mapNotificationToEvent(notification) ){
			System.out.println("Mapped Event:----"+event);
			for(EventFilter filter: getFilters(event)){
				EventListener app= getEventListenerForFilter(filter);
				if(app!=null)
					notifyApplication( app, event, filter);
			}
		}
	}

	private EventListener getEventListenerForFilter(EventFilter filter) {
		return rootFilterToListenerMap.get(filter); 		
	}

	private Collection<? extends EventFilter> getFilters(ModelChangeEvent event) {
		HashSet<EventFilter> result = new HashSet<EventFilter>();
		for(EventFilter filter:rootFilterToListenerMap.keySet())
			if(filter.matchesFor(event))
					result.add(filter);
		return result ;
		
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void notifyApplication(EventListener application, ModelChangeEvent event, EventFilter matchingFilter) {
		application.handleEvent(event, matchingFilter);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void subscribe(EList<Notifier> root, EventFilter filter, EventListener caller) {
		for(Notifier noti: root){
			subscribe(noti, filter, caller);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void subscribe(Notifier root, EventFilter filter, EventListener caller) {
		root.eAdapters().add(adapter);
		rootFilterToListenerMap.put(filter, caller);
		
		
		
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void subscribeTransactional(EList<Notifier> root, EventFilter filter, EventListener caller) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean unsubscribe(EventListener caller) {
		Set<EventFilter> filters = new HashSet<EventFilter>();
		for(Entry<EventFilter, EventListener> entry: rootFilterToListenerMap.entrySet())
			if(entry.getValue().equals(caller))
				filters.add(entry.getKey());
		for(EventFilter e: filters)
			rootFilterToListenerMap.remove(e);
		
		return filters.isEmpty();
	}

} //EventManagerImpl
