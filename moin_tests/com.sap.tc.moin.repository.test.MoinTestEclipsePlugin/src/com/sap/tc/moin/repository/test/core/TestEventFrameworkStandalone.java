package com.sap.tc.moin.repository.test.core;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.core.events.ElementCreateEventImpl;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.spi.core.SpiEventManager;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;

/**
 * This class contains tests of the EventFramework that can be executed without
 * a MOF-repository.
 * 
 * @author Daniel Vocke (D044825)
 */
public class TestEventFrameworkStandalone extends EventFrameworkTest {

    private SpiEventManager eventManager = null;

    private Connection secondConnection = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        eventRegistry = this.getMOINConnection( ).getEventRegistry( );
        eventManager = (SpiEventManager) ( (Wrapper) getMOINConnection( ).getSession( ).getEventRegistry( ) ).unwrap( );
        connection = this.getMOINConnection( );
        secondConnection = this.getSecondMOINConnection( );
        allListeners = new ArrayList<TestListener>( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        for ( TestListener l : allListeners ) {
            // l.checkAllEventsReceived();
            eventRegistry.deregister( (EventListener) l );
        }
        allListeners.clear( );
        eventManager = null;
        eventRegistry = null;
        connection = null;
        secondConnection = null;
        super.afterTestMethod( );
    }

    /**
     * This test covers the parallel firing of events from different connections
     * and the deferment of events for certain listeners when commands are used.
     */
    @Test
    public void testCommands( ) {

        ChangeEvent event_c1 = new ElementCreateEventImpl( getTestHelper( ).getCoreConnection( getMOINConnection( ) ), new DummyMri( "Hello1" ), new DummyMri( "Hello3" ), new DummyMri( "Hello3" ) );
        ChangeEvent event_c2 = new ElementCreateEventImpl( getTestHelper( ).getCoreConnection( getMOINConnection( ) ), new DummyMri( "Hello4" ), new DummyMri( "Hello5" ), new DummyMri( "Hello6" ) );

        TestListener normalPCL = createAndRegisterTestPreChangeListener( new EventTypeFilter( DummyEvent.class ) );
        TestListener normalCL = createAndRegisterTestChangeListener( new EventTypeFilter( DummyEvent.class ) );
        TestListener precommitL = createAndRegisterTestPreCommitListener( new EventTypeFilter( DummyEvent.class ) );
        TestListener commitL = createAndRegisterTestCommitListener( new EventTypeFilter( DummyEvent.class ) );

        // Test firing 2 events from different connections without commands
        normalCL.expectedDummyEvents = 2;
        normalPCL.expectedDummyEvents = 2;
        precommitL.expectedDummyEvents = 0;
        commitL.expectedDummyEvents = 0;

        event_c1 = new DummyEventImpl( this.getTestHelper( ).getCoreConnection( connection ) );
        event_c2 = new DummyEventImpl( this.getTestHelper( ).getCoreConnection( secondConnection ) );
        eventManager.firePreChangeEvent( event_c1 );
        eventManager.fireChangeEvent( event_c1 );
        eventManager.firePreChangeEvent( event_c2 );
        eventManager.fireChangeEvent( event_c2 );
        checkReceivedEvents( );

        // Test parallel usage of (Pre-)ChangeListeners and
        // (Pre-)CommitListeners on 1 connection
        normalCL.expectedDummyEvents = 1;
        normalPCL.expectedDummyEvents = 1;
        precommitL.expectedDummyEvents = 0;
        commitL.expectedDummyEvents = 0;

        eventManager.beginCommand( this.getTestHelper( ).getCoreConnection( connection ) );

        event_c1 = new DummyEventImpl( this.getTestHelper( ).getCoreConnection( connection ) );
        eventManager.firePreChangeEvent( event_c1 );
        eventManager.fireChangeEvent( event_c1 );
        checkReceivedEvents( );

        // events may not be delivered before the command is committed!

        precommitL.expectedDummyEvents = 1;
        eventManager.preCommitCommand( this.getTestHelper( ).getCoreConnection( connection ) );
        checkReceivedEvents( );
        commitL.expectedDummyEvents = 1;
        eventManager.postCommitCommand( this.getTestHelper( ).getCoreConnection( connection ) );
        checkReceivedEvents( );

        // Test 1 command and fired events from another connection (which may
        // not be received by commitListeners)
        event_c1 = new DummyEventImpl( this.getTestHelper( ).getCoreConnection( connection ) );
        event_c2 = new DummyEventImpl( this.getTestHelper( ).getCoreConnection( secondConnection ) );

        normalCL.expectedDummyEvents = 2;
        normalPCL.expectedDummyEvents = 2;

        eventManager.firePreChangeEvent( event_c1 );
        eventManager.fireChangeEvent( event_c1 );
        eventManager.firePreChangeEvent( event_c2 );
        eventManager.fireChangeEvent( event_c2 );
        checkReceivedEvents( );

        event_c1 = new DummyEventImpl( getTestHelper( ).getCoreConnection( connection ) );
        event_c2 = new DummyEventImpl( getTestHelper( ).getCoreConnection( secondConnection ) );

        normalCL.expectedDummyEvents = 2;
        normalPCL.expectedDummyEvents = 2;
        precommitL.expectedDummyEvents = 1;
        commitL.expectedDummyEvents = 1;

        eventManager.beginCommand( this.getTestHelper( ).getCoreConnection( connection ) );

        eventManager.firePreChangeEvent( event_c1 );
        eventManager.fireChangeEvent( event_c1 );
        eventManager.firePreChangeEvent( event_c2 );
        eventManager.fireChangeEvent( event_c2 );
        eventManager.preCommitCommand( this.getTestHelper( ).getCoreConnection( connection ) );
        eventManager.postCommitCommand( this.getTestHelper( ).getCoreConnection( connection ) );
        checkReceivedEvents( );

        // Test 2 parallel commands on different connections
        event_c1 = new DummyEventImpl( getTestHelper( ).getCoreConnection( connection ) );
        DummyEvent event2_c1 = new DummyEventImpl( getTestHelper( ).getCoreConnection( connection ) );
        DummyEvent event3_c1 = new DummyEventImpl( getTestHelper( ).getCoreConnection( connection ) );
        event_c2 = new DummyEventImpl( getTestHelper( ).getCoreConnection( secondConnection ) );

        normalCL.expectedDummyEvents = 4;
        normalPCL.expectedDummyEvents = 4;
        precommitL.expectedDummyEvents = 3;
        commitL.expectedDummyEvents = 3;

        eventManager.beginCommand( this.getTestHelper( ).getCoreConnection( secondConnection ) );

        eventManager.firePreChangeEvent( event_c1 );
        eventManager.fireChangeEvent( event_c1 );
        eventManager.beginCommand( this.getTestHelper( ).getCoreConnection( connection ) );
        eventManager.firePreChangeEvent( event2_c1 );
        eventManager.fireChangeEvent( event2_c1 );
        eventManager.firePreChangeEvent( event3_c1 );
        eventManager.fireChangeEvent( event3_c1 );
        eventManager.firePreChangeEvent( event_c2 );
        eventManager.fireChangeEvent( event_c2 );

        eventManager.preCommitCommand( this.getTestHelper( ).getCoreConnection( connection ) );
        eventManager.postCommitCommand( this.getTestHelper( ).getCoreConnection( connection ) );
        eventManager.preCommitCommand( this.getTestHelper( ).getCoreConnection( secondConnection ) );
        eventManager.postCommitCommand( this.getTestHelper( ).getCoreConnection( secondConnection ) );

        checkReceivedEvents( );

        // Test 2 parallel commands on different connections, but only one
        // command is committed - the other one is canceled
        event_c1 = new DummyEventImpl( getTestHelper( ).getCoreConnection( connection ) );
        event_c2 = new DummyEventImpl( getTestHelper( ).getCoreConnection( secondConnection ) );

        normalCL.expectedDummyEvents = 2;
        normalPCL.expectedDummyEvents = 2;
        precommitL.expectedDummyEvents = 1;
        commitL.expectedDummyEvents = 1;

        eventManager.beginCommand( this.getTestHelper( ).getCoreConnection( connection ) );
        eventManager.beginCommand( this.getTestHelper( ).getCoreConnection( secondConnection ) );

        eventManager.firePreChangeEvent( event_c1 );
        eventManager.fireChangeEvent( event_c1 );
        eventManager.firePreChangeEvent( event_c2 );
        eventManager.fireChangeEvent( event_c2 );

        eventManager.preCommitCommand( this.getTestHelper( ).getCoreConnection( connection ) );
        eventManager.postCommitCommand( this.getTestHelper( ).getCoreConnection( connection ) );
        eventManager.cancelCommand( this.getTestHelper( ).getCoreConnection( secondConnection ) );

        checkReceivedEvents( );
    }

    @Test
    public void testUpdateUserInterfaceListener( ) {

        this._testClient1.setAsCurrentClient( );

        TestUpdateUserInterfaceListener updateUiListener = createAndRegisterTestUpdateUserInterfaceListener( new EventTypeFilter( ElementCreateEvent.class ) );

        // Test parallel usage of (Pre-)ChangeListeners and
        // (Pre-)CommitListeners on 1 connection
        updateUiListener.expectedElementCreateEvents = 1;

        ChangeEvent event_c1 = new ElementCreateEventImpl( getTestHelper( ).getCoreConnection( getMOINConnection( ) ), new DummyMri( "Hello1" ), new DummyMri( "Hello3" ), new DummyMri( "Hello3" ) );
        ChangeEvent event_c2 = new ElementCreateEventImpl( getTestHelper( ).getCoreConnection( getMOINConnection( ) ), new DummyMri( "Hello4" ), new DummyMri( "Hello5" ), new DummyMri( "Hello6" ) );

        eventManager.beginUpdate( this.getTestHelper( ).getCoreConnection( connection ) );

        eventManager.firePreChangeEvent( event_c1 );
        eventManager.fireChangeEvent( event_c1 );
        eventManager.deliverUpdate( this.getTestHelper( ).getCoreConnection( connection ) );
        checkReceivedEvents( );
    }

    @Test
    public void testAttributeValueChangeEventContainsLRI( ) {

        final A4 a4 = getMOINConnection( ).createElementInPartition( A4.class, null );
        final B4 b4_old = getMOINConnection( ).createElementInPartition( B4.class, null );
        final B4 b4_new = getMOINConnection( ).createElementInPartition( B4.class, null );
        a4.setOneBchangeable( b4_old );
        ChangeListener listener = new ChangeListener( ) {

            public void notify( ChangeEvent event ) {

                assertTrue( ( (AttributeValueChangeEvent) event ).getOldValue( ) instanceof LRI );
                assertTrue( ( (AttributeValueChangeEvent) event ).getNewValue( ) instanceof LRI );
            }

        };

        getMOINConnection( ).getEventRegistry( ).registerListener( listener, null );

        a4.setOneBchangeable( b4_new );
    }

    private void assertEqualsFilterTrees( EventFilter expected, EventFilter transformed ) {

        if ( !expected.equals( transformed ) ) {
            System.out.println( "Transformed:" );
            System.out.println( transformed );
            System.out.println( "=============================================" );
            System.out.println( "Expected:" );
            System.out.println( expected );
            assertTrue( "The transformation into Disjunctive Normal Form (DNF) did not create the expected result! See console output for details.", false );
        }
    }

}
