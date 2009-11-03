package com.sap.tc.moin.repository.events;

import com.sap.tc.moin.repository.events.filter.EventFilter;

/**
 * The EventRegistry interface is the central entry point for clients that want
 * to use the event framework. It provides operations for registration and
 * deregistration of the different listener types.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author Daniel Vocke (D044825)
 */
public interface EventRegistry {

    /**
     * This method is used to register <code>PreChangeListeners</code> to the
     * event framework. The registered listener will receive pre change events
     * when the filter expression that is passed as object tree matches an
     * event. The registered <code>PreChangeListener</code> will be notified
     * synchronously <b>before a change has occurred</b>. <br>
     * See {@link PreChangeListener} for details on the behavior.
     * 
     * @param listener the listener to be registered
     * @param eventFilterTree a tree containing <code>MoinEventFilter</code>s
     * which represent an expression that determines which events the client
     * wants to receive
     */
    public void registerPreChangeListener( PreChangeListener listener, EventFilter eventFilterTree );

    /**
     * This method is used to register <code>ChangeListeners</code> to the event
     * framework. The registred listener will receive change events when the
     * filter expression that is passed as object tree matches an event. The
     * registered <code>ChangeListener</code> will be notified synchronously
     * <b>after a change has occurred</b>.
     * 
     * @param listener the listener that will be notified each time a matching
     * event is fired.
     * @param eventFilterTree a tree containing <code>MoinEventFilter</code> s
     * which represent an expression that determines which events the client
     * wants to receive
     */
    public void registerListener( ChangeListener listener, EventFilter eventFilterTree );

    /**
     * This method is used to register <code>PreCommitListeners</code> to the
     * event framework. The registered listener will receive events when the
     * filter expression that is passed as object tree matches an event. The
     * registered <code>PreCommitListener</code> will be notified synchronously
     * <b>before a commit is committed</b>. <br>
     * See {@link PreCommitListener} for details on the behavior.
     * 
     * @param listener the listener to be registered
     * @param eventFilterTree a tree containing <code>MoinEventFilter</code> s
     * which represent an expression that determines which events the client
     * wants to receive
     */
    public void registerPreCommitListener( PreCommitListener listener, EventFilter eventFilterTree );

    /**
     * DO NOT USE!
     * 
     * @param listener
     * @param eventFilterTree
     */
    @Deprecated
    public void registerCommitListener( CommitListener listener, EventFilter eventFilterTree );

    /**
     * This method is used to register <code>UpdateListener</code> to the event
     * framework. The registered listener will receive events when the filter
     * expression that is passed as object tree matches an event. <br>
     * See {@link UpdateListener} for details on the behavior.
     * 
     * @param listener the listener to be registered
     * @param eventFilterTree a tree containing <code>MoinEventFilter</code> s
     * which represent an expression that determines which events the client
     * wants to receive
     */
    public void registerUpdateListener( UpdateListener listener, EventFilter eventFilterTree );

    /**
     * This method undos all registration calls which registered the passed
     * listener. It is guaranteed, that no reference is stored to the listener
     * any more.
     * 
     * @param listener the listener to remove
     */
    public void deregister( EventListener listener );

}