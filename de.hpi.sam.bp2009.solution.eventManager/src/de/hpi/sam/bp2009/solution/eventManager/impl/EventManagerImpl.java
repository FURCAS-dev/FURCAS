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
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
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
	private Map<EventFilter, Adapter> rootFilterToListenerMap = new HashMap<EventFilter, Adapter>();
	private EventAdapter adapter = new EventAdapter();
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected EventManagerImpl() {
		super();
		this.adapter= new EventAdapter();
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
	 * @generated NOT
	 */
	public void handleEMFEvent(Notification notification) {
		System.out.println(notification);
			System.out.println("Mapped Event:----"+notification);
			for(EventFilter filter: getFilters(notification)){
				Adapter app= getAdapterForFilter(filter);
				if(app!=null)
					notifyApplication( app, notification, filter);
			}
		
	}

	private Adapter getAdapterForFilter(EventFilter filter) {
		return rootFilterToListenerMap.get(filter); 		
	}

	private Collection<? extends EventFilter> getFilters(Notification event) {
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
	public void notifyApplication(Adapter application, Notification event, EventFilter matchingFilter) {
		application.notifyChanged(event);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void subscribe(EList<Notifier> root, EventFilter filter, Adapter caller) {
		for(Notifier noti: root){
			subscribe(noti, filter, caller);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void subscribe(Notifier root, EventFilter filter, Adapter caller) {
		root.eAdapters().add(adapter);
		rootFilterToListenerMap.put(filter, caller);
		
		
		
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean unsubscribe(Adapter caller) {
		Set<EventFilter> filters = new HashSet<EventFilter>();
		for(Entry<EventFilter, Adapter> entry: rootFilterToListenerMap.entrySet())
			if(entry.getValue().equals(caller))
				filters.add(entry.getKey());
		for(EventFilter e: filters)
			rootFilterToListenerMap.remove(e);
		
		return filters.isEmpty();
	}
	
	@Override
	@Deprecated
	public void subscribeTransactional(EList<Notifier> root,
			EventFilter filter, Adapter caller) {
		// TODO Auto-generated methodsubscribeTransactional stub
		System.out.println("subscribeTransactional");
		
	}

} //EventManagerImpl
