package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.InvalidSessionException;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.PreCommitListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.spi.core.Wrapper;


public class EventRegistryWrapperForSession implements EventRegistry, Wrapper<EventRegistry> {

    private EventRegistry eventRegistry;

    private CoreSession session;

    public EventRegistryWrapperForSession( CoreSession session ) {

        this.session = session;
        eventRegistry = session.getEventRegistry( );
    }

    public void deregister( EventListener listener ) {

        // De-registration on a dead session is a no-op
        if ( this.session.isAlive( ) ) {
            eventRegistry.deregister( listener );
        }

    }

    public void registerCommitListener( CommitListener listener, EventFilter eventFilterTree ) {

        assertAlive( );
        eventRegistry.registerCommitListener( listener, eventFilterTree );

    }

    public void registerListener( ChangeListener listener, EventFilter eventFilterTree ) {

        assertAlive( );
        eventRegistry.registerListener( listener, eventFilterTree );

    }

    public void registerPreChangeListener( PreChangeListener listener, EventFilter eventFilterTree ) {

        assertAlive( );
        eventRegistry.registerPreChangeListener( listener, eventFilterTree );
    }

    public void registerPreCommitListener( PreCommitListener listener, EventFilter eventFilterTree ) {

        assertAlive( );
        eventRegistry.registerPreCommitListener( listener, eventFilterTree );
    }

    public void registerUpdateListener( UpdateListener listener, EventFilter eventFilterTree ) {

        assertAlive( );
        eventRegistry.registerUpdateListener( listener, eventFilterTree );
    }

    public EventRegistry unwrap( ) {

        assertAlive( );
        return eventRegistry;
    }

    private void assertAlive( ) {

        if ( !this.session.isAlive( ) ) {
            throw new InvalidSessionException( JmiCoreMessages.SESSIONISINVALID );
        }
    }
}
