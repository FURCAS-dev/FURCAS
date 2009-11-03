package com.sap.tc.moin.repository.performance.test.events;

import com.sap.tc.moin.repository.mmi.model.MofClass;

import org.eclipse.test.performance.PerformanceMeter;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.test.performance.TestPerfBase;


public class TestPerfEvents extends TestPerfBase {

    @Test
    public void testCreateAndRegisterChangeListeners( ) throws Exception {

        PerformanceMeter m = createPerformanceMeter( "EVENT_REGISTRATION", false, "Tests how long it takes to register event listeners" );

        Connection conn = createConnection( );
        EventFilter filter = new EventTypeFilter( ElementChangeEvent.class );
        EventRegistry eventRegistry = conn.getEventRegistry( );
        int numberOfListeners = 1000;
        ChangeListener listeners[] = new ChangeListener[numberOfListeners];

        try {
            for ( int i = 0; i < 100; i++ ) {
                m.start( );
                for ( int j = 0; j < numberOfListeners; j++ ) {
                    listeners[j] = new TestChangeListener( );
                    eventRegistry.registerListener( listeners[j], filter );
                }
                m.stop( );

                // De-register listeners again
                for ( int j = 0; j < numberOfListeners; j++ ) {
                    eventRegistry.deregister( listeners[j] );
                    listeners[j] = null;
                }
            }
            m.commit( );
        } finally {
            m.dispose( );
        }
    }

    @Test
    public void testCreateInstanceWithoutListeners( ) throws Exception {

        PerformanceMeter m = createPerformanceMeter( "EVENT_CREATE_INSTANCE_NO_LISTENERS", false, "Tests how long it takes to create elements without event listeners" );

        Connection conn = createConnection( );

        try {
            for ( int samples = 0; samples < 10; samples++ ) {
                m.start( );
                for ( int i = 0; i < 1000; i++ ) {
                    conn.createElementInPartition( MofClass.class, null );
                }
                m.stop( );
                conn.revert( );
            }
            m.commit( );
        } finally {
            m.dispose( );
        }
    }

    @Test
    public void testCreateInstanceWith500UpdateListeners( ) throws Exception {

        PerformanceMeter m = createPerformanceMeter( "EVT_CREATE_5H_ULISTENERS", false, "Tests how long it takes to create elements with 500 update listeners" );

        Connection conn = createConnection( );
        EventFilter filter = new EventTypeFilter( ElementChangeEvent.class );
        EventRegistry eventRegistry = conn.getEventRegistry( );
        int numberOfListeners = 500;
        UpdateListener listeners[] = new TestUpdateListener[numberOfListeners];

        for ( int j = 0; j < numberOfListeners; j++ ) {
            listeners[j] = new TestUpdateListener( );
            eventRegistry.registerUpdateListener( listeners[j], filter );
        }

        try {

            // Do the test loop
            for ( int samples = 0; samples < 10; samples++ ) {
                m.start( );
                for ( int i = 0; i < 1000; i++ ) {
                    conn.createElementInPartition( MofClass.class, null );
                }
                m.stop( );
                conn.revert( );
            }

            // De-register listeners again
            for ( int i = 0; i < numberOfListeners; i++ ) {
                eventRegistry.deregister( listeners[i] );
                listeners[i] = null;
            }

            m.commit( );
        } finally {
            m.dispose( );
        }
    }

    @Test
    public void testCreateInstanceWith1000UpdateListeners( ) throws Exception {

        PerformanceMeter m = createPerformanceMeter( "EVT_CREATE_1K_ULISTENERS", false, "Tests how long it takes to create elements with 1000 update listeners" );

        Connection conn = createConnection( );
        EventFilter filter = new EventTypeFilter( ElementChangeEvent.class );
        EventRegistry eventRegistry = conn.getEventRegistry( );
        int numberOfListeners = 1000;
        UpdateListener listeners[] = new UpdateListener[numberOfListeners];

        for ( int j = 0; j < numberOfListeners; j++ ) {
            listeners[j] = new TestUpdateListener( );
            eventRegistry.registerUpdateListener( listeners[j], filter );
        }

        try {

            // Do the test loop
            for ( int samples = 0; samples < 10; samples++ ) {
                m.start( );
                for ( int i = 0; i < 1000; i++ ) {
                    conn.createElementInPartition( MofClass.class, null );
                }
                m.stop( );
                conn.revert( );
            }

            // De-register listeners again
            for ( int i = 0; i < numberOfListeners; i++ ) {
                eventRegistry.deregister( listeners[i] );
                listeners[i] = null;
            }

            m.commit( );
        } finally {
            m.dispose( );
        }
    }


    @Test
    public void testCreateInstanceWith500Listeners( ) throws Exception {

        PerformanceMeter m = createPerformanceMeter( "EVENT_CREATE_INSTANCE_5H_LISTENERS", false, "Tests how long it takes to create elements with 10005 event listeners" );

        Connection conn = createConnection( );
        EventFilter filter = new EventTypeFilter( ElementChangeEvent.class );
        EventRegistry eventRegistry = conn.getEventRegistry( );
        int numberOfListeners = 500;
        ChangeListener listeners[] = new ChangeListener[numberOfListeners];

        for ( int j = 0; j < numberOfListeners; j++ ) {
            listeners[j] = new TestChangeListener( );
            eventRegistry.registerListener( listeners[j], filter );
        }

        try {

            // Do the test loop
            for ( int samples = 0; samples < 10; samples++ ) {
                m.start( );
                for ( int i = 0; i < 1000; i++ ) {
                    conn.createElementInPartition( MofClass.class, null );
                }
                m.stop( );
                conn.revert( );
            }

            // De-register listeners again
            for ( int i = 0; i < numberOfListeners; i++ ) {
                eventRegistry.deregister( listeners[i] );
                listeners[i] = null;
            }

            m.commit( );
        } finally {
            m.dispose( );
        }
    }

    @Test
    public void testCreateInstanceWith1000Listeners( ) throws Exception {

        PerformanceMeter m = createPerformanceMeter( "EVENT_CREATE_INSTANCE_1K_LISTENERS", false, "Tests how long it takes to create elements with 10005 event listeners" );

        Connection conn = createConnection( );
        EventFilter filter = new EventTypeFilter( ElementChangeEvent.class );
        EventRegistry eventRegistry = conn.getEventRegistry( );
        int numberOfListeners = 1000;
        ChangeListener listeners[] = new ChangeListener[numberOfListeners];

        for ( int j = 0; j < numberOfListeners; j++ ) {
            listeners[j] = new TestChangeListener( );
            eventRegistry.registerListener( listeners[j], filter );
        }

        try {

            // Do the test loop
            for ( int samples = 0; samples < 10; samples++ ) {
                m.start( );
                for ( int i = 0; i < 1000; i++ ) {
                    conn.createElementInPartition( MofClass.class, null );
                }
                m.stop( );
                conn.revert( );
            }

            // De-register listeners again
            for ( int i = 0; i < numberOfListeners; i++ ) {
                eventRegistry.deregister( listeners[i] );
                listeners[i] = null;
            }

            m.commit( );
        } finally {
            m.dispose( );
        }
    }

    private static class TestChangeListener implements ChangeListener {

        public void notify( ChangeEvent event ) {

        }
    }

    private static class TestUpdateListener implements UpdateListener {

        public void notifyUpdate( EventChain events ) {

        }
    }
}
