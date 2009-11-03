package com.sap.tc.moin.repository.core.events.framework.simple;

import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;

/**
 * The DeferringNotifier is responsible for queuing all events that are fired
 * within a command. Is is assumed, that all events that are fired from a
 * connection with an open command belong to that command.
 * 
 * @author Martin Kolb
 */
public class CommitNotifier extends DeferringNotifierSimple {

    /**
     * Constructs a DeferringNotifierSimple object
     */
    public CommitNotifier( ListenerHelper _listenerHelper, EventListener listener, EventFilter filter ) {

        super( _listenerHelper, listener, filter );
    }

    @Override
    protected void deliverEventChain( EventChain eventChain, EventListener listener ) {

        CommitListener l = (CommitListener) listener;
        l.notifyCommit( eventChain );
    }

}