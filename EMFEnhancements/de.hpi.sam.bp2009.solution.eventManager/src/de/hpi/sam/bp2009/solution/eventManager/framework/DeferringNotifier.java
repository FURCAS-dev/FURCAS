package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.lang.ref.WeakReference;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;

/**
 * The DeferringNotifier is responsible for queuing all events that are fired within a command.
 * Is is assumed, that all events that are fired from a connection with an open command belong 
 * to that command.
 * 
 * @author Daniel Vocke (d044825)
 */
public class DeferringNotifier extends AdapterCapsule {

    /**
     * contains the queued events by each connection that has an open command. The queued events are stored in an {@link EventChain}
     * in order to simplyfy the notification of multiple events and to improve performance.
     */
    protected HashSet<Notification> deferredEvents = new HashSet<Notification>();
    
    public DeferringNotifier(WeakReference<? extends Adapter> _listenerRef,ListenerTypeEnum _listenerType, EventManager _manager){
        super(_listenerRef,_listenerType, _manager);
    }

    @Override
    /**
     * starts the event queuing for the passed connection
     */
    public void deferNotification() {
        
        deferredEvents.clear();
    }

    @Override
    /**
     * delivers the queued <code>EventChain</code> to the listener.
     */
    public void deliverDeferredEvents() {
        if (getListenerType().matches(ListenerTypeEnum.preCommit)){
            for(Notification n:deferredEvents){
                _listener.get().notifyChanged(n);
            }
        }else if (getListenerType().matches(ListenerTypeEnum.postCommit)){
            for(Notification n:deferredEvents){
                _listener.get().notifyChanged(n);
            }           
        }else{
            //may not happen
            //TODO log, throw exception?
        }
    }

    @Override
    /**
     * throws away all queued events and marks the connection as "no command open"
     */
    public void cancelDeferment() {
        deferredEvents.clear();
    }

    @Override
    /**
     * checks if a command was opened on the connection that triggered the event and queues it if yes
     */
    public void fireEvent(Notification event) {
        deferredEvents.add(event);

    }
    
    
}
