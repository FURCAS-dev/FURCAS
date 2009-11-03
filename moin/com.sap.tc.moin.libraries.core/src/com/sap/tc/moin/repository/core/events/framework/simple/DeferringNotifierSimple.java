package com.sap.tc.moin.repository.core.events.framework.simple;

import java.util.IdentityHashMap;
import java.util.Map;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.events.ChangeEventImpl;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;

/**
 * The DeferringNotifier is responsible for queuing all events that are fired
 * within a command. Is is assumed, that all events that are fired from a
 * connection with an open command belong to that command.
 * 
 * @author Martin Kolb
 */
public abstract class DeferringNotifierSimple extends NotifierSimple {

    /**
     * Constructs a DeferringNotifierSimple object
     */
    public DeferringNotifierSimple( ListenerHelper _listenerHelper, EventListener listener, EventFilter filter ) {

        super( _listenerHelper, listener, filter );
    }

    /**
     * starts the event queuing for the passed connection
     */
    public void deferNotificationFor( Connection connection ) {

        if ( activeConnection == null ) {
            activeConnection = connection;
        } else {
            additionalChainsForConnections = new IdentityHashMap<Connection, EventChainSimple>( );
            additionalChainsForConnections.put( connection, null );
        }
    }

    /**
     * This method prepares the delivery of deferred events. The events that
     * have been collected in the "deferment bucket" are put into a "delivery
     * bucket". From now on new deferred events can be fired and deferred. This
     * strategy is necessary to enable mutating event handlers.
     * 
     * @param connection
     */
    public EventChainSimple prepareDeliveryOfDeferredEvents( Connection connection ) {

        EventChainSimple result = null;
        if ( connection == activeConnection ) {
            result = chain;
            chain = null;
            activeConnection = null;
        }

        // Check if other connections are active
        if ( result == null && additionalChainsForConnections != null ) {
            result = additionalChainsForConnections.remove( connection );
        }

        return result;
    }

    /**
     * delivers the queued <code>EventChain</code> to the listener.
     */
    public void deliverDeferredEventsFor( EventChain eventChain ) {

        if ( eventChain.getEvents( ) == null ) {
            return;
        }

        EventListener listener = getListener( );
        if ( listener != null ) {
            deliverEventChain( eventChain, listener );
        }
    }

    /**
     * delivers the events
     */
    protected abstract void deliverEventChain( EventChain eventChain, EventListener listener );

    /**
     * throws away all queued events and marks the connection as "no command
     * open"
     */
    public void cancelDefermentFor( Connection connection ) {

        if ( activeConnection == connection ) {
            activeConnection = null;
            chain = null;
        } else {
            if ( additionalChainsForConnections != null ) {
                additionalChainsForConnections.remove( connection );
                if ( additionalChainsForConnections.size( ) == 0 ) {
                    additionalChainsForConnections = null;
                }
            }
        }
    }

    @Override
    /**
     * checks if a command was opened on the connection that triggered the event
     * and queues it if yes
     */
    public void fireEvent( ChangeEvent event ) {

        Connection eventTriggerConnection = ( (ChangeEventImpl) event ).eventTriggerConnection;
        if ( eventTriggerConnection == activeConnection ) {
            if ( chain == null ) {
                chain = new EventChainSimple( this );
            }
            chain.addEvent( event );
        } else {
            // Check if more Connections are active
            if ( additionalChainsForConnections != null ) {
                if ( additionalChainsForConnections.containsKey( eventTriggerConnection ) ) {
                    EventChainSimple additionalChain = additionalChainsForConnections.get( eventTriggerConnection );
                    if ( additionalChain == null ) {
                        additionalChain = new EventChainSimple( this );
                        additionalChainsForConnections.put( eventTriggerConnection, additionalChain );
                    }
                    additionalChain.addEvent( event );
                }

            }
        }
    }

    /**
     * Contains the connection we are currently deferring events for. Can be
     * null.
     */
    private Connection activeConnection;

    /**
     * The queued events are stored in an {@link EventChain} in order to
     * simplify the notification of multiple events and to improve performance.
     */
    private EventChainSimple chain;

    /**
     * Is used if more than one concurrent Connections are active
     */
    private Map<Connection, EventChainSimple> additionalChainsForConnections = null;

}