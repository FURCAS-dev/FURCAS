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
package org.eclipse.ocl.examples.eventmanager.framework;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.filters.EventFilter;


/**
 * A scalable implementation of the {@link EventManager} interface, using hash tables to quickly dispatch
 * incoming {@link Notification}s to the sets of registered {@link Adapter event listeners}. Uses a single
 * {@link EContentAdapter} to listen to all changes in those {@link ResourceSet}s for which it is responsible.
 * 
 * @author Daniel Vocke (D044825)
 * @author Axel Uhl (D043530)
 */

public class EventManagerTableBased implements EventManager {
    private Logger logger = Logger.getLogger(EventManagerTableBased.class.getName());
    
    private boolean active = true;
    
    /**
     * the EventAdapter instance for the EventManager
     */
    private final EventAdapter adapter = new EventAdapter(this);

    /**
     * Toogle the {@link EventManager} off, on given <code>false</code> and no {@link Notification}s will be delivered
     * @param doFireEventsValue <code>false</code> to disable {@link Notification}delivery, <code>true</code> to enable
     */
    public void setFireEvents(boolean doFireEventsValue) {
        doFireEvents = doFireEventsValue;
    }

    private boolean doFireEvents = true;

    /**
     * listeners are not notified directly. The notification process is done by the appropriate AdapterCapsule. This Map provides
     * the associated AdapterCapsule for a Listener. For each type of Listener there is a separate AdapterCapsule (That's why
     * there might be multiple AdapterCapsules for one Listener instance (the instance could have been registered multiple times))
     */
    protected WeakHashMap<Adapter, Collection<AdapterCapsule>> notifierByListener = new WeakHashMap<Adapter, Collection<AdapterCapsule>>();

    /**
     * this is needed for performance reasons mainly
     */
    private Collection<AdapterCapsule> allNotifiers = new LinkedList<AdapterCapsule>();

    /**
     * The RegistrationManager does the main work when finding out which listeners are affected by an event.
     */
    private RegistrationManagerTableBased registrationManager = null;

    private final WeakHashMap<ResourceSet, Object> resourceSets;

    public EventManagerTableBased(ResourceSet set) {
        this();
        addToObservedResourceSets(set);
    }
    
    public EventManagerTableBased() {
        resourceSets = new WeakHashMap<ResourceSet, Object>();
        registrationManager = new RegistrationManagerTableBased();
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }

    /* Methods from EventRegistry interface */

    /*
     * @see EventRegistry#registerListener(ChangeListener, MoinEventFilter)
     */
    public void subscribe(
            org.eclipse.ocl.examples.eventmanager.filters.EventFilter eventFilterTree, Adapter listener) {
        register(listener, eventFilterTree, ListenerTypeEnum.postChange);
    }

    /*
     * @see EventRegistry#registerPreChangeListener(PreChangeListener, MoinEventFilter)
     */
    public void registerPreChangeListener(Adapter listener, EventFilter eventFilterTree) {
        register(listener, eventFilterTree, ListenerTypeEnum.preChange);
    }

    public void registerCommitListener(Adapter listener, EventFilter eventFilterTree) {
        register(listener, eventFilterTree, ListenerTypeEnum.postCommit);
    }

    public void registerPreCommitListener(Adapter listener, EventFilter eventFilterTree) {
        register(listener, eventFilterTree, ListenerTypeEnum.preCommit);
    }

    /*
     * the following 2 constants define the types of listeners that get a Notifier or DeferringNotifier
     */
    private static final ListenerTypeEnum listenersForNotifier = new ListenerTypeEnum(ListenerTypeEnum.postChange,
            ListenerTypeEnum.preChange);
    private static final ListenerTypeEnum listenersForDeferringNotifier = new ListenerTypeEnum(ListenerTypeEnum.postCommit,
            ListenerTypeEnum.preCommit);

    private void register(Adapter listener, EventFilter eventFilterTree, ListenerTypeEnum listenerType) {
        // Check preconditions for parameters
        if (listener == null) {
            throw new IllegalArgumentException("Event listener must not be null");
        }
        if (eventFilterTree == null) {
            throw new IllegalArgumentException("Event filter must not be null");
        }
        // Use WeakReference to avoid dangling registrations
        WeakReference<Adapter> listenerRef = new WeakReference<Adapter>(listener);
        // delegate registration to RegistrationManager
        // The event filter is cloned, because the calculation of the DNF will modify the filter tree
        registrationManager.register(eventFilterTree.clone(), listenerRef, listenerType);
        // instantiate and associate notifier
        AdapterCapsule notifier = null;
        if (listenerType.matches(listenersForNotifier)) {
            notifier = new AdapterCapsule(listenerRef, listenerType, this);
        } else if (listenerType.matches(listenersForDeferringNotifier)) {
            notifier = new DeferringNotifier(listenerRef, listenerType, this);
        } else {
            logger.warning("Unkown listenerType "+listenerType);
        }
        addNotifierForListener(notifier);
    }

    public void deregister(Adapter listener) {
        // TODO what if a listener is being removed that has pending events?? -> EventDeferring
        registrationManager.deregister(listener);
        // remove Notifier(s) for listener
        removeListener(listener);
    }

    /* Methods from EventManager interface */

    // private static final ListenerTypeEnum listenerTypesToReceiveChangeEvents = new
    // ListenerTypeEnum(ListenerTypeEnum.postChange,ListenerTypeEnum.preCommit,ListenerTypeEnum.postCommit);
    public void fireChangeEvent(Notification event) {
        if (!doFireEvents)
            return;

        // ((ChangeEventImpl) event).setDedicatedListenerType(listenerTypesToReceiveChangeEvents);
        fireEvent(event);

        // After the "PostEvent" has been fired, the cached information for the pre/post cycle can be deleted
        // If this is not done, the event could not be used for another Session
        // TODO currently not supported
        // ((ChangeEventImpl) event).registrations = null;

    }

    public void firePreChangeEvent(Notification event) {
        if (!doFireEvents)
            return;

        // ((ChangeEventImpl) event).setDedicatedListenerType(ListenerTypeEnum.preChange);
        fireEvent(event);
    }

    public void beginCommand() {
        if (!doFireEvents)
            return;

        for (AdapterCapsule notifier : allNotifiers)
            notifier.deferNotification();
    }

    public void postCommitCommand() {
        if (!doFireEvents)
            return;

        for (AdapterCapsule notifier : allNotifiers)
            if (notifier.getListenerType().matches(ListenerTypeEnum.postCommit))
                notifier.deliverDeferredEvents();

    }

    public void preCommitCommand() {
        if (!doFireEvents)
            return;

        for (AdapterCapsule notifier : allNotifiers)
            if (notifier.getListenerType().matches(ListenerTypeEnum.preCommit))
                notifier.deliverDeferredEvents();

    }

    private static final ListenerTypeEnum allCommitListenerTypes = new ListenerTypeEnum(ListenerTypeEnum.preCommit,
            ListenerTypeEnum.postCommit);

    public void cancelCommand() {
        if (!doFireEvents)
            return;

        for (AdapterCapsule notifier : allNotifiers)
            if (notifier.getListenerType().matches(allCommitListenerTypes))
                notifier.cancelDeferment();

    }

    /**
     * This method notifies all interested listeners by invoking the fireEvent() method on their associated Notifier.
     * 
     * @param event
     *            the event that will be delivered to clients
     */
    private void fireEvent(Notification event) {
        Collection<WeakReference<? extends Adapter>> listeners = registrationManager.getListenersFor(event);
        for (WeakReference<? extends Adapter> listenerRef : listeners) {
            AdapterCapsule notifier = getNotifierForListener(listenerRef, ListenerTypeEnum.postChange);
            if (notifier != null) {
                notifier.fireEvent(event);
            }
        }
    }

    /*
     * ************************************************************************* The following 3 methods
     * (addNotifierForListener,removeListener,getNotifierForListener) are private convenience methods only! They are needed
     * because a listener that implements both ( PreChangeListener and ChangeListener) has to have a seperate Notifier for each
     * role. (several registrations as e.g. PreChangeListener result in only one Notifier) In order to achieve this, a collection
     * of Notifiers is stored for each listener and the notifiers can then be rejected from the Collection if they don't match the
     * required ListenerType. *************************************************************************
     */

    private void addNotifierForListener(AdapterCapsule notifier) {
        Adapter adapter = notifier.getListener().get();
        if (adapter == null) {
            logger.warning("listener "+notifier.getListener()+" got GCed; AdapterCapsule: "+notifier);
        } else {
            Collection<AdapterCapsule> notifiers = notifierByListener.get(adapter);
            if (notifiers == null) {
                notifiers = new LinkedList<AdapterCapsule>();
                notifierByListener.put(adapter, notifiers);
            }
            notifiers.add(notifier);
            allNotifiers.add(notifier);
        }
    }

    private void removeListener(Adapter listener) {
        // maintain allNotifiers-member
        Collection<AdapterCapsule> removedNotifiers = notifierByListener.get(listener);
        if (removedNotifiers != null) {
            allNotifiers.removeAll(removedNotifiers);
        }
        // maintain Map
        notifierByListener.remove(listener);
    }

    private AdapterCapsule getNotifierForListener(WeakReference<? extends Adapter> listener, ListenerTypeEnum listenerType) {
        Adapter adapter = listener.get();
        if (adapter == null) {
            logger.warning("No notifier found for listener "+listener);
        } else {
            Collection<AdapterCapsule> notifiers = notifierByListener.get(adapter);
            if (notifiers == null) {
                logger.warning("No notifiers found");
                return null;
            }
            for (AdapterCapsule notifier : notifiers) {
                if (notifier.isResponsibleFor(adapter, listenerType)) {
                    return notifier;
                }
            }
        }
        logger.warning("No notifier found");
        return null;
    }

    public void handleEMFEvent(Notification notification) {
        if (active) {
            if (!notifierByListener.isEmpty()) {
                for (Notification n : EventManagerFactory.eINSTANCE.createNotificationForComposites(notification)) {
                    fireChangeEvent(n);
                }
            }
        }
    }

    public boolean unsubscribe(Adapter caller) {
        deregister(caller);
        return true;

    }

    @Override
    protected void finalize() throws Throwable {
        for (ResourceSet rs : resourceSets.keySet()) {
            if (rs != null && adapter != null) {
                rs.eAdapters().remove(adapter);
            }
        }
        super.finalize();
    }
    /*
     * EventDeferment will not be implemented yet:
     */

    /*
     * This method switches session scoped event deferment. This will result in the deferment of all events if the {@link
     * deferEvents} flag is set true. No listeners that are currently connected to the SessionEventManager will receive events.
     * The queued events are delivered when the operation is called and the {@link deferEvents} flag is set to false. If the
     * session scoped deferment overrides a client scoped deferment, the previous setting will be restored afterwards. @param
     * deferEvents - a flag indicating whether event deferring is switched on or off
     */
    /*
     * public void setEventDeferring(boolean deferEvents) { for (Iterator it = notifierByListener.values().iterator();
     * it.hasNext();) { Object notifier = it.next(); if (notifier instanceof DeferrableNotifier) { ((DeferrableNotifier) notifier)
     * .setGlobalEventDeferring(deferEvents); } } }
     */
    /*
     * This method switches client specific event deferment. If the {@link deferEvents} flag is set to true, no events will be
     * delivered to the specified listener. The {@link notificationTrigger} set is used to specify event types that trigger the
     * delivery of all currently queued events. The deferment will stay active in that case. When the operation is called and the
     * {@link deferEvents} flag is set to false, the deferment will be turned off and all pending events will be delivered to the
     * listener. @param listener - the affected listener @param deferEvents - a flag indicating whether the event deferment is
     * switched on or off @param notificationTrigger - a set of event types that trigger the automatic delivery of queued events.
     * The type of the contained elements is {@link java.lang.Class}
     */

    /*
     * public void setEventDeferring(ChangeListener listener, boolean deferEvents, Set notificationTrigger) { /* TODO move
     * exception-message to xlf-file (but probably this method will be removed anyway) //only (post)ChangeListeners can be
     * deferred... DeferrableNotifier notifier = (DeferrableNotifier) getNotifierForListener( listener,
     * ChangeEvent.NOTIFICATIONTIME_AFTER_CHANGE); if (notifier == null) throw new IllegalStateException( "Cannot switch
     * EventDeferring on listener that is not registered yet."); notifier.setEventDeferment(deferEvents);
     * notifier.setNotificationTrigger(notificationTrigger); }
     */
    
    public String toString() {
        return registrationManager.toString();
    }

    public void addToObservedResourceSets(ResourceSet resourceSet) {
        if (!resourceSet.eAdapters().contains(adapter)) {
            resourceSet.eAdapters().add(adapter);
        }
        resourceSets.put(resourceSet, null);
    }

    public void removeFromObservedResourceSets(ResourceSet resourceSet) {
        resourceSet.eAdapters().remove(adapter);
        resourceSets.remove(resourceSet);
    }
}
