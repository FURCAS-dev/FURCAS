/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.eventmanager;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.eventmanager.filters.EventFilter;


/**
 * Common interface for all Implementations of an EMF EventManager
 * 
 * @author Philipp Berger, Axel Uhl
 * 
 */
public interface EventManager {
    final static int CONTAINMENT_EVENT_TYPE = 666;

    /**
     * Register an {@link Adapter} on the {@link EventManager} which will be notified for any {@link Notification} which matches
     * the given filter. If an equal or the same <code>caller</code> registers multiple times using equal <code>filter</code>s,
     * the <code>caller</code> will get notified as many times as it subscribed.
     * 
     * @param filter
     *            the {@link EventFilter} which is used to filter events for the given {@link Adapter}
     * @param listener
     *            the adapter which should receive event which matches the filter. This event manager will only
     *            maintain weak references to the listener which means that the client should hold a strong reference
     *            in order to make sure that notifications will be received. This is a good idea anyhow since for
     *            de-registration using {@link #unsubscribe(Adapter)} the listener is required as well.
     */
    void subscribe(EventFilter filter, Adapter listener);

    /**
     * Removes the given {@link Adapter} from the {@link EventManager} and the linked {@link EventFilter}, so that the given
     * {@link Adapter} will not be notified anymore
     * 
     * @param listener
     *            the {@link Adapter} to unsubscribe
     * @return <code>true</code> if the adapter was registered
     */
    boolean unsubscribe(Adapter listener);

    /**
     * Initialize the filtering process for a given {@link Notification}, all {@link Adapter} registered with a matching filter
     * will be notified. Normally, clients don't have to call this method explicitly. It will be called by the
     * event manager automatically when an event has been received from any elements in the {@link ResourceSet}
     * for which the event manager has been obtained (see {@link EventManagerFactory#getEventManagerFor(ResourceSet)}).
     * However, for testing purposes and in case clients want to explicitly send events that have not emerged
     * from the {@link ResourceSet} to registered clients, they may use this method.
     * 
     * @param notification
     *            {@link Notification} to send to clients whose event filter matches the notification
     */
    void handleEMFEvent(Notification notification);
    
    /**
     * Adds <code>resourceSet</code> to the resource sets from which this event manager receives notifications
     * that it dispatches to adapters subscribed to this event manager. If this event manager already
     * does receive notifications from <code>resourceSet</code> it is not registered a second time. In
     * particular, it won't receive the same notifications multiple times.
     * 
     * @see #removeFromObservedResourceSets(ResourceSet)
     */
    void addToObservedResourceSets(ResourceSet resourceSet);
    
    /**
     * Stops receiving and dispatching notifications coming from <code>resourceSet</code>.
     * 
     * @see #addToObservedResourceSets(ResourceSet)
     */
    void removeFromObservedResourceSets(ResourceSet resourceSet);
    
    /**
     * Sometimes it can be convenient to temporarily stop the flow of events. For example, if a particular event manager
     * receives a particular set of events for a certain reason, and that reason temporarily doesn't apply, instead of
     * completely removing the event manager from the underlying {@link ResourceSet} and thus removing the
     * adapter from all objects in the resource set, it is more efficient to just block forwarding the events to the
     * {@link Adapter}s subscribed with this event manager.<p>
     * 
     * Calling this method with <code>active==false</code> will stop this event manager from forwarding events to
     * the {@link Adapter}s subscribed. Calling it with <code>active==true</code> again will forward events received
     * after the call again. Events that arrived in between are <em>not</em> forwarded and therefore "lost" for the
     * subscribers to this event manager.<p>
     * 
     * By default, an event manager starts in the "active" state.
     */
    void setActive(boolean active);
} // EventManager
