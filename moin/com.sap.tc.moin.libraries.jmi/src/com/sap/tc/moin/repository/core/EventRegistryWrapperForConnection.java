package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.PreCommitListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;


public class EventRegistryWrapperForConnection extends AbstractConnectionAwareWrapper<EventRegistry> implements EventRegistry {

    private EventRegistry eventRegistry;

    public EventRegistryWrapperForConnection( CoreConnection connection ) {

        super( connection, connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );

        eventRegistry = connection.getEventRegistry( );
    }

    public void deregister( EventListener listener ) {

        assertConnectionAlive( );
        eventRegistry.deregister( listener );
    }

    public void registerCommitListener( CommitListener listener, EventFilter eventFilterTree ) {

        assertConnectionAlive( );
        eventRegistry.registerCommitListener( listener, eventFilterTree );
    }

    public void registerListener( ChangeListener listener, EventFilter eventFilterTree ) {

        assertConnectionAlive( );
        eventRegistry.registerListener( listener, eventFilterTree );

    }

    public void registerPreChangeListener( PreChangeListener listener, EventFilter eventFilterTree ) {

        assertConnectionAlive( );
        eventRegistry.registerPreChangeListener( listener, eventFilterTree );
    }

    public void registerPreCommitListener( PreCommitListener listener, EventFilter eventFilterTree ) {

        assertConnectionAlive( );
        eventRegistry.registerPreCommitListener( listener, eventFilterTree );
    }

    public void registerUpdateListener( UpdateListener listener, EventFilter eventFilterTree ) {

        assertConnectionAlive( );
        eventRegistry.registerUpdateListener( listener, eventFilterTree );
    }

    public EventRegistry unwrap( ) {

        assertConnectionAlive( );
        return eventRegistry;
    }
}
