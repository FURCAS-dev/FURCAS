package com.sap.tc.moin.repository.test.core;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.events.ChangeEventImpl;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventListener;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.PreCommitListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.AttributeValueAddEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueRemoveEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.events.type.PartitionCreateEvent;
import com.sap.tc.moin.repository.events.type.PartitionDeleteEvent;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;

public abstract class EventFrameworkTest extends CoreMoinTest {

    protected EventRegistry eventRegistry = null;

    protected Connection connection = null;

    protected List<TestListener> allListeners = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        this.connection = getMOINConnection( );

        this.eventRegistry = this.connection.getSession( ).getEventRegistry( );

        this.allListeners = new ArrayList<TestListener>( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( this.allListeners != null && this.eventRegistry != null ) {
            for ( TestListener listener : this.allListeners ) {
                this.eventRegistry.deregister( (EventListener) listener );
            }
            this.allListeners.clear( );
            this.allListeners = null;
            this.eventRegistry = null;
        }
        super.afterTestMethod( );
        this.connection = null;
    }

    protected abstract class TestListener {

        public int expectedAttributeValueAddEvents = 0;

        public int expectedAttributeValueChangeEvents = 0;

        public int expectedAttributeValueRemoveEvents = 0;

        public int expectedElementCreateEvents = 0;

        public int expectedElementDeleteEvents = 0;

        public int expectedLinkAddEvents = 0;

        public int expectedLinkRemoveEvents = 0;

        public int expectedPartitionMembershipChangeEvents = 0;

        public int expectedPartitionCreateEvents = 0;

        public int expectedPartitionDeleteEvents = 0;

        public int expectedDummyEvents = 0;

        public void receiveEvent( ChangeEvent event, String methodName ) {

            if ( event instanceof AttributeValueAddEvent ) {
                this.expectedAttributeValueAddEvents--;
            } else if ( event instanceof AttributeValueChangeEvent ) {
                this.expectedAttributeValueChangeEvents--;
            } else if ( event instanceof AttributeValueRemoveEvent ) {
                this.expectedAttributeValueRemoveEvents--;
            } else if ( event instanceof ElementCreateEvent ) {
                this.expectedElementCreateEvents--;
            } else if ( event instanceof ElementDeleteEvent ) {
                this.expectedElementDeleteEvents--;
            } else if ( event instanceof LinkAddEvent ) {
                this.expectedLinkAddEvents--;
            } else if ( event instanceof LinkRemoveEvent ) {
                this.expectedLinkRemoveEvents--;
                LinkRemoveEvent lre = (LinkRemoveEvent) event;
                try {
                    lre.getFirstLinkEnd( EventFrameworkTest.this.connection );
                    lre.getSecondLinkEnd( EventFrameworkTest.this.connection );
                } catch ( Exception e ) {
                    fail( "getting LinkEnds should always succeed" );
                }
            } else if ( event instanceof PartitionMembershipChangeEvent ) {
                this.expectedPartitionMembershipChangeEvents--;
            } else if ( event instanceof DummyEvent ) {
                this.expectedDummyEvents--;
            } else if ( event instanceof PartitionCreateEvent ) {
                this.expectedPartitionCreateEvents--;
            } else if ( event instanceof PartitionDeleteEvent ) {
                this.expectedPartitionDeleteEvents--;
            } else if ( event == null ) {
                fail( "delivered event was null!" );
            } else {
                fail( "Unknown event received in '" + methodName + "':" + event.getClass( ) );
            }
        }

        public void checkAllEventsReceived( ) {

            assertEquals( this.expectedAttributeValueAddEvents + " AttributeValueAddEvents have not been delivered!", this.expectedAttributeValueAddEvents, 0 );

            assertEquals( this.expectedAttributeValueChangeEvents + " AttributeValueChangeEvents have not been delivered!", this.expectedAttributeValueChangeEvents, 0 );

            assertEquals( this.expectedElementCreateEvents + " ElementCreateEvents have not been delivered!", this.expectedElementCreateEvents, 0 );

            assertEquals( this.expectedElementDeleteEvents + " ElementDeleteEvents have not been delivered!", this.expectedElementDeleteEvents, 0 );

            assertEquals( this.expectedPartitionMembershipChangeEvents + " PartitionMembershipChangeEvents have not been delivered!", this.expectedPartitionMembershipChangeEvents, 0 );

            assertEquals( this.expectedLinkAddEvents + " LinkAddEvents have not been delivered!", this.expectedLinkAddEvents, 0 );

            assertEquals( this.expectedLinkRemoveEvents + " LinkRemoveEvents have not been delivered!", this.expectedLinkRemoveEvents, 0 );

            assertEquals( this.expectedPartitionCreateEvents + " PartitionCreateEvents have not been delivered!", this.expectedPartitionCreateEvents, 0 );

            assertEquals( this.expectedPartitionDeleteEvents + " PartitionDeleteEvents have not been delivered!", this.expectedPartitionDeleteEvents, 0 );

            assertEquals( this.expectedAttributeValueRemoveEvents + " AttributeValueRemoveEvents have not been delivered!", this.expectedAttributeValueRemoveEvents, 0 );

            assertEquals( this.expectedDummyEvents + " DummyEvents have not been delivered!", this.expectedDummyEvents, 0 );
        }
    }

    /**
     * PreChangeListener
     */
    protected class TestPreChangeListener extends TestListener implements PreChangeListener {

        public void prepare( ChangeEvent event ) {

            receiveEvent( event, "prepare" );
        }
    }

    /**
     * ChangeListener
     */
    protected class TestChangeListener extends TestListener implements ChangeListener {

        public void notify( ChangeEvent event ) {

            receiveEvent( event, "notify" );
        }
    }

    /**
     * PreCommitListener
     */
    protected class TestPreCommitListener extends TestListener implements PreCommitListener {

        public void prepareCommit( EventChain events ) {

            for ( ChangeEvent event : events.getEvents( ) ) {
                receiveEvent( event, "prepareCommit" );
            }
        }
    }

    /**
     * CommitListener
     */
    protected class TestCommitListener extends TestListener implements CommitListener {

        public void notifyCommit( EventChain events ) {

            for ( ChangeEvent event : events.getEvents( ) ) {
                receiveEvent( event, "notifyCommit" );
            }
        }

    }

    /**
     * CommitListener
     */
    protected class TestUpdateUserInterfaceListener extends TestListener implements UpdateListener {

        public void notifyUpdate( EventChain events ) {

            for ( ChangeEvent event : events.getEvents( ) ) {
                receiveEvent( event, "notifyUpdate" );
            }
        }

    }

    protected class TestCombinedListener extends TestListener implements PreCommitListener, CommitListener, UpdateListener {

        public int prepareCommitCalls = 0;

        public int notifyCommitCalls = 0;

        public int notifyUpdateCalls = 0;

        public void prepareCommit( EventChain events ) {

            for ( ChangeEvent event : events.getEvents( ) ) {
                receiveEvent( event, "prepareCommit" );
            }
            this.prepareCommitCalls++;
        }

        public void notifyCommit( EventChain events ) {

            for ( ChangeEvent event : events.getEvents( ) ) {
                receiveEvent( event, "notifyCommit" );
            }
            this.notifyCommitCalls++;
        }

        public void notifyUpdate( EventChain events ) {

            for ( ChangeEvent event : events.getEvents( ) ) {
                receiveEvent( event, "notifyUpdate" );
            }
            this.notifyUpdateCalls++;
        }

    }

    protected interface DummyEvent extends ChangeEvent {
    }

    /**
     * Dummy Event used in TestEventFrameworkStandalone
     */
    protected class DummyEventImpl extends ChangeEventImpl implements DummyEvent {

        public DummyEventImpl( CoreConnection c ) {

            super( c );
            this.eventTriggerConnection = c;
        }

        @Override
        public Object getAffectedPartitionsPRIs( ) {

            return null;
        }

        @Override
        protected String getParameterString( ) {

            return "";
        }

        @Override
        protected String getTypeString( ) {

            return "DummyEvent";
        }

    }

    // for DummyMri
    private static URI uri = null;
    static {
        try {
            uri = new URI( "http://bla.falsel.de" );
        } catch ( Exception e ) {
            e.printStackTrace( );
        }
    }

    protected class DummyMri extends MockMriImpl implements LRI {

        private String name = null;

        @Override
        public LRI getLri( ) {

            return this;
        }

        public DummyMri( String name ) {

            super( uri );
            this.name = name;

        }

        @Override
        public String toString( ) {

            return this.name;
        }

        @Override
        public boolean equals( Object obj ) {

            if ( obj instanceof DummyMri ) {
                return this.name.equals( ( (DummyMri) obj ).name );
            }
            return false;
        }

    }

    protected class DummyPri implements PRI {

        private String name = null;

        public DummyPri( String name ) {

            this.name = name;
        }

        @Override
        public boolean equals( Object obj ) {

            if ( obj instanceof DummyPri ) {
                return this.name.equals( ( (DummyPri) obj ).name );
            }
            return false;
        }

        @Override
        public String toString( ) {

            return this.name;
        }

        public DataAreaDescriptor getDataAreaDescriptor( ) {

            return null;
        }

        public MRI createMri( String mofId ) {

            return null;
        }

        public boolean isMetaModelPartition( ) {

            throw new UnsupportedOperationException( );
        }

        public boolean isNullPartition( ) {

            throw new UnsupportedOperationException( );
        }

        public boolean isTransientPartition( ) {

            throw new UnsupportedOperationException( );
        }

        public boolean isVolatilePartition( ) {

            throw new UnsupportedOperationException( );
        }

        public CRI getCri( ) {

            throw new UnsupportedOperationException( );
        }

        public String getContainerName( ) {

            return null;
        }

        public String getPartitionName( ) {

            return null;
        }
    }

    protected TestChangeListener createAndRegisterTestChangeListener( EventFilter filter ) {

        TestChangeListener listener = new TestChangeListener( );
        this.eventRegistry.registerListener( listener, filter );
        this.allListeners.add( listener );
        return listener;
    }

    protected TestPreChangeListener createAndRegisterTestPreChangeListener( EventFilter filter ) {

        TestPreChangeListener listener = new TestPreChangeListener( );
        this.eventRegistry.registerPreChangeListener( listener, filter );
        this.allListeners.add( listener );
        return listener;
    }

    protected TestPreCommitListener createAndRegisterTestPreCommitListener( EventFilter filter ) {

        TestPreCommitListener listener = new TestPreCommitListener( );
        this.eventRegistry.registerPreCommitListener( listener, filter );
        this.allListeners.add( listener );
        return listener;
    }

    protected TestCommitListener createAndRegisterTestCommitListener( EventFilter filter ) {

        TestCommitListener listener = new TestCommitListener( );
        this.eventRegistry.registerCommitListener( listener, filter );
        this.allListeners.add( listener );
        return listener;
    }

    protected TestUpdateUserInterfaceListener createAndRegisterTestUpdateUserInterfaceListener( EventFilter filter ) {

        TestUpdateUserInterfaceListener listener = new TestUpdateUserInterfaceListener( );
        this.eventRegistry.registerUpdateListener( listener, filter );
        this.allListeners.add( listener );
        return listener;
    }

    protected void deregisterListener( EventListener listener ) {

        ( (TestListener) listener ).checkAllEventsReceived( );
        this.eventRegistry.deregister( listener );
        this.allListeners.remove( listener );
    }

    protected void checkReceivedEvents( ) {

        for ( TestListener listener : this.allListeners ) {
            listener.checkAllEventsReceived( );
        }
    }
}
