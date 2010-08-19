package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;
import java.util.WeakHashMap;
import java.util.logging.Logger;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

/**
 * The SessionEventManager implements 2 roles: <br>
 * It acts as a <code>EventRegistry</code> to clients and as <code>EventManager</code> to the repository core which will trigger
 * the events using the {@link com.EventManagerTableBased.tc.moin.repository.spi.core.EventManager} interface. After the method
 * was called, the SessionEventManager will ask its RegistrationManager for all affected listeners and notify them using the
 * associated Notifier.
 * 
 * @author Daniel Vocke (D044825)
 */

public class EventManagerTableBased implements EventManager {
    private Logger logger = Logger.getLogger(EventManagerTableBased.class.getName());
    
    private boolean active = true;
    
    /**
     * the EventAdapter instance for the EventManager
     */
    EventAdapter adapter = new EventAdapter(this);

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
     * the associated AdapterCapsule for a Listener. For each type of Listener there is a seperate AdapterCapsule (That's why
     * there might be multiply AdapterCapsules for one Listener instance (the instance could have been registered multiple times))
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

    private WeakReference<ResourceSet> resourceSet;

    public EventManagerTableBased(ResourceSet set) {
        registrationManager = new RegistrationManagerTableBased();
        set.eAdapters().add(adapter);
        this.resourceSet= new WeakReference<ResourceSet>(set);
    }
    @Override
    public ResourceSet getResourceSet() {
        return resourceSet.get();
    }
    
    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    /* Methods from EventRegistry interface */

    /*
     * @see EventRegistry#registerListener(ChangeListener, MoinEventFilter)
     */
    @Override
    public void subscribe(
            de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter eventFilterTree, Adapter listener) {
        register(listener, eventFilterTree, ListenerTypeEnum.postChange);
    }

    /*
     * @see EventRegistry#registerPreChangeListener(PreChangeListener, MoinEventFilter)
     */
    public void registerPreChangeListener(Adapter listener, EventFilter eventFilterTree) {
        register(listener, eventFilterTree, ListenerTypeEnum.preChange);
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.EventRegistry#registerCommitListener(com.sap.tc.moin.repository.events.CommitListener,
     * com.sap.tc.moin.repository.events.filter.MoinEventFilter)
     */
    public void registerCommitListener(Adapter listener, EventFilter eventFilterTree) {
        register(listener, eventFilterTree, ListenerTypeEnum.postCommit);
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.EventRegistry#registerPreCommitListener(com.sap.tc.moin.repository.events.PreCommitListener
     * , com.sap.tc.moin.repository.events.filter.MoinEventFilter)
     */
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

    /*
     * @see com.sap.tc.moin.repository.events.EventRegistry#deregister(com.sap.tc.moin.repository.events.MoinChangeListener)
     */
    public void deregister(Adapter listener) {
        // TODO what if a listener is being removed that has pending events?? -> EventDeferring
        registrationManager.deregister(listener);
        // remove Notifier(s) for listener
        removeListener(listener);
    }

    /* Methods from EventManager interface */

    // private static final ListenerTypeEnum listenerTypesToReceiveChangeEvents = new
    // ListenerTypeEnum(ListenerTypeEnum.postChange,ListenerTypeEnum.preCommit,ListenerTypeEnum.postCommit);
    /*
     * @see com.sap.tc.moin.repository.events.EventManager
     */
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

    /*
     * @see com.sap.tc.moin.repository.events.EventManager
     */
    public void firePreChangeEvent(Notification event) {
        if (!doFireEvents)
            return;

        // ((ChangeEventImpl) event).setDedicatedListenerType(ListenerTypeEnum.preChange);
        fireEvent(event);
    }

    /*
     * @see com.sap.tc.moin.repository.events.EventManager#beginCommand(com.sap.tc.moin.repository.commands.MoinCommand)
     */
    public void beginCommand() {
        if (!doFireEvents)
            return;

        for (AdapterCapsule notifier : allNotifiers)
            notifier.deferNotification();
    }

    /*
     * @see com.sap.tc.moin.repository.events.EventManager#postCommitCommand(com.sap.tc.moin.repository.commands.MoinCommand)
     */
    public void postCommitCommand() {
        if (!doFireEvents)
            return;

        for (AdapterCapsule notifier : allNotifiers)
            if (notifier.getListenerType().matches(ListenerTypeEnum.postCommit))
                notifier.deliverDeferredEvents();

    }

    /*
     * @see com.sap.tc.moin.repository.events.EventManager#preCommitCommand(com.sap.tc.moin.repository.commands.MoinCommand)
     */
    public void preCommitCommand() {
        if (!doFireEvents)
            return;

        for (AdapterCapsule notifier : allNotifiers)
            if (notifier.getListenerType().matches(ListenerTypeEnum.preCommit))
                notifier.deliverDeferredEvents();

    }

    /*
     * @see com.sap.tc.moin.repository.events.EventManager#cancelCommand(com.sap.tc.moin.repository.commands.MoinCommand)
     */
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

    @Override
    public void handleEMFEvent(Notification notification) {
        if (active) {
            if (!notifierByListener.isEmpty()) {
                for (Notification n : EventManagerFactory.eINSTANCE.createNotificationForComposites(notification)) {
                    fireChangeEvent(n);
                }
            }
        }
    }

    @Override
    public boolean unsubscribe(Adapter caller) {
        deregister(caller);
        return true;

    }

    @Override
    protected void finalize() throws Throwable {
        if(this.getResourceSet()!=null && adapter!=null){
            getResourceSet().eAdapters().remove(adapter);
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
}
