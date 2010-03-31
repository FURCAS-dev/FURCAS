/*
 * Created on 16.12.2005
 */
package com.sap.tc.moin.repository.test.core;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.AttributeValueAddEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.AttributeValueRemoveEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionContentChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionCreateEvent;
import com.sap.tc.moin.repository.events.type.PartitionDeleteEvent;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionSaveEvent;
import com.sap.tc.moin.repository.test.core.EventFrameworkTest.DummyEvent;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * Class to test the MOF ROM with activated event framework
 * 
 * @author d024032
 */
public class TestEventFrameworkCrossSession extends CoreMoinTest {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        // Delete partitions from previous tests
        ModelPartition partition = this._testClient1.getOrCreatePartitionStable( "P1" );
        partition.delete( );
        partition = this._testClient1.getOrCreatePartitionStable( "P2" );
        partition.delete( );
        partition = this._testClient1.getOrCreatePartitionStable( "Step6" );
        partition.delete( );
        this._testClient1.getConnection( ).save( );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Test
    public void testCrossSessionEvents( ) throws Exception {

        ModelPackage mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        // PCL = PreChangeListener        
        // CL = ChangeListener
        this.partitionPCL = createAndRegisterTestPreChangeListener( new EventTypeFilter( PartitionChangeEvent.class ), getMOINConnection( ) );
        this.partitionCL = createAndRegisterTestChangeListener( new EventTypeFilter( PartitionChangeEvent.class ), this.getMOINConnection( ) );
        this.partitionPCL2 = createAndRegisterTestPreChangeListener( new EventTypeFilter( PartitionChangeEvent.class ), getSecondMOINConnection( ) );
        this.partitionCL2 = createAndRegisterTestChangeListener( new EventTypeFilter( PartitionChangeEvent.class ), this.getSecondMOINConnection( ) );

        // --- BEGIN SECTION
        // Step 1: Create Partition in Session1
        this.partitionPCL.expectedPartitionCreateEvents = 1;
        this.partitionCL.expectedPartitionCreateEvents = 1;

        ModelPartition p1 = this._testClient1.getOrCreatePartitionStable( "P1" );
        PRI p1_PRI = p1.getPri( );

        // p1 must not be visible in other Session
        ModelPartition p1_Session2 = getSecondMOINConnection( ).getPartition( p1_PRI );
        assertNull( p1_Session2 );

        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Step 2: Save the created partition
        this.partitionPCL.expectedPartitionSaveEvents = 1;
        this.partitionCL.expectedPartitionSaveEvents = 1;
        this.partitionCL2.expectedPartitionCreateEvents = 1;

        getMOINConnection( ).save( );

        // After "save" p1 must be visible in other Session
        p1_Session2 = getSecondMOINConnection( ).getPartition( p1_PRI );
        assertNotNull( p1_Session2 );

        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Step 3: Make partition dirty by adding an element and save the partition
        this.partitionPCL.expectedPartitionSaveEvents = 1;
        this.partitionCL.expectedPartitionSaveEvents = 1;
        this.partitionCL2.expectedPartitionContentChangeEvents = 1;

        MofPackage mofPackage = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        p1.assignElement( (Partitionable) mofPackage );
        getMOINConnection( ).save( );

        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Step 4: Delete the created partition
        this.partitionPCL.expectedPartitionDeleteEvents = 1;
        this.partitionCL.expectedPartitionDeleteEvents = 1;

        p1.delete( );

        // p1 has been deleted, but must still be visible in other Session
        p1_Session2 = getSecondMOINConnection( ).getPartition( p1_PRI );
        assertNotNull( p1_Session2 );

        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Step 5: Save the deleted partition
        this.partitionPCL.expectedPartitionSaveEvents = 1;
        this.partitionCL.expectedPartitionSaveEvents = 1;
        this.partitionCL2.expectedPartitionDeleteEvents = 1;

        this.getMOINConnection( ).save( );

        // p1 has been deleted, after the save if must be gone in the Session, too
        p1_Session2 = getSecondMOINConnection( ).getPartition( p1_PRI );
        assertNull( p1_Session2 );

        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Step 6: 
        ModelPartition p6 = this._testClient1.getOrCreatePartitionStable( "Step6" );
        MofPackage mofPackage6 = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        p6.assignElement( mofPackage6 );
        getMOINConnection( ).save( );

        MofPackage mofPackageViaSession1 = (MofPackage) getMOINConnection( ).getElement( ( (Partitionable) mofPackage6 ).get___Mri( ) );
        MofPackage mofPackageViaSession2 = (MofPackage) getSecondMOINConnection( ).getElement( ( (Partitionable) mofPackage6 ).get___Mri( ) );

        MofPackage mofPackage6_2 = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        p6.assignElement( mofPackage6_2 );
        getMOINConnection( ).save( );

        mofPackageViaSession2.hashCode( );
        mofPackageViaSession1.hashCode( );

        // --- END SECTION

        // Cleanup: Deregister event listener
        getMOINConnection( ).getEventRegistry( ).deregister( this.partitionPCL );
        getMOINConnection( ).getEventRegistry( ).deregister( this.partitionCL );
        getSecondMOINConnection( ).getEventRegistry( ).deregister( this.partitionPCL2 );
        getSecondMOINConnection( ).getEventRegistry( ).deregister( this.partitionCL2 );
    }

    @Test
    public void testCrossSessionUpdateEvents( ) throws Exception {

        ModelPackage mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        // UL = UpdateListener
        this.partitionUL = createAndRegisterTestUpdateListener( new EventTypeFilter( PartitionChangeEvent.class ), getMOINConnection( ) );
        this.partitionUL2 = createAndRegisterTestUpdateListener( new EventTypeFilter( ChangeEvent.class ), getSecondMOINConnection( ) );

        // --- BEGIN SECTION
        // Step 1: Create Partition in Session1
        this.partitionUL.expectedPartitionCreateEvents = 1;

        ModelPartition p1 = this._testClient1.getOrCreatePartitionStable( "P1" );
        PRI p1_PRI = p1.getPri( );

        // p1 must not be visible in other Session
        ModelPartition p1_Session2 = getSecondMOINConnection( ).getPartition( p1_PRI );
        assertNull( p1_Session2 );

        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Step 2: Save the created partition
        this.partitionUL.expectedPartitionSaveEvents = 1;
        this.partitionUL2.expectedPartitionCreateEvents = 1;

        getMOINConnection( ).save( );

        // After "save" p1 must be visible in other Session
        p1_Session2 = getSecondMOINConnection( ).getPartition( p1_PRI );
        assertNotNull( p1_Session2 );

        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Step 3: Make partition dirty by adding an element and save the partition
        this.partitionUL.expectedPartitionSaveEvents = 1;
        this.partitionUL2.expectedPartitionContentChangeEvents = 1;

        MofPackage mofPackage = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        p1.assignElement( (Partitionable) mofPackage );
        getMOINConnection( ).save( );

        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Step 4: Delete the created partition
        this.partitionUL.expectedPartitionDeleteEvents = 1;

        p1.delete( );

        // p1 has been deleted, but must still be visible in other Session
        p1_Session2 = getSecondMOINConnection( ).getPartition( p1_PRI );
        assertNotNull( p1_Session2 );

        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Step 5: Save the deleted partition
        this.partitionUL.expectedPartitionSaveEvents = 1;
        this.partitionUL2.expectedPartitionDeleteEvents = 1;

        this.getMOINConnection( ).save( );

        // p1 has been deleted, after the save if must be gone in the Session, too
        p1_Session2 = getSecondMOINConnection( ).getPartition( p1_PRI );
        assertNull( p1_Session2 );

        checkReceivedEvents( );
        // --- END SECTION

        // --- BEGIN SECTION
        // Step 6: 
        ModelPartition p6 = this._testClient1.getOrCreatePartitionStable( "Step6" );
        MofPackage mofPackage6 = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        p6.assignElement( mofPackage6 );
        getMOINConnection( ).save( );

        MofPackage mofPackageViaSession1 = (MofPackage) getMOINConnection( ).getElement( ( (Partitionable) mofPackage6 ).get___Mri( ) );
        MofPackage mofPackageViaSession2 = (MofPackage) getSecondMOINConnection( ).getElement( ( (Partitionable) mofPackage6 ).get___Mri( ) );

        MofPackage mofPackage6_2 = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        p6.assignElement( mofPackage6_2 );
        getMOINConnection( ).save( );

        mofPackageViaSession2.hashCode( );
        mofPackageViaSession1.hashCode( );

        // --- END SECTION

        // Cleanup: Deregister event listener
        getMOINConnection( ).getEventRegistry( ).deregister( this.partitionUL );
        getSecondMOINConnection( ).getEventRegistry( ).deregister( this.partitionUL2 );
    }

    @Test
    public void testConcurrentUpdates( ) throws Exception {

        // UL = UpdateListener
        this.partitionUL = createAndRegisterTestUpdateListener( new EventTypeFilter( ChangeEvent.class ), getMOINConnection( ) );

        // Start command group
        getMOINConnection( ).getCommandStack( ).openGroup( "MyGroup" );

        // Create partition
        ModelPartition p1 = this._testClient1.getOrCreatePartitionStable( "P1" );

        // Check if no events have been delivered (command group still open)
        checkReceivedEvents( );

        // now do something in second connection and save the changes
        ModelPackage mofModelPackage2 = (ModelPackage) getSecondMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MofPackage mofPackage2 = (MofPackage) mofModelPackage2.getMofPackage( ).refCreateInstance( );
        ModelPartition p2 = this._testClient2.getOrCreatePartitionStable( "P2" );
        p2.assignElement( mofPackage2 );

        this.partitionUL.expectedPartitionCreateEvents = 1;
        getSecondMOINConnection( ).save( );
        checkReceivedEvents( );

        // now do something more with the partition created in connection #1
        ModelPackage mofModelPackage1 = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        MofPackage mofPackage1 = (MofPackage) mofModelPackage1.getMofPackage( ).refCreateInstance( );
        p1.assignElement( mofPackage1 );

        // check if all expected event come after "closeGruop"
        this.partitionUL.expectedPartitionCreateEvents = 1;
        this.partitionUL.expectedElementCreateEvents = 1;
        this.partitionUL.expectedPartitionMembershipChangeEvents = 1;

        getMOINConnection( ).getCommandStack( ).closeGroup( );
        checkReceivedEvents( );

        // Cleanup: De-register event listener
        getMOINConnection( ).getEventRegistry( ).deregister( this.partitionUL );
    }

    protected static abstract class TestListener {

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

        public int expectedPartitionContentChangeEvents = 0;

        public int expectedPartitionSaveEvents = 0;

        public int expectedDummyEvents = 0;

        public int expectedCustomEvents = 0;

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
            } else if ( event instanceof PartitionMembershipChangeEvent ) {
                this.expectedPartitionMembershipChangeEvents--;
            } else if ( event instanceof DummyEvent ) {
                this.expectedDummyEvents--;
            } else if ( event instanceof PartitionCreateEvent ) {
                this.expectedPartitionCreateEvents--;
            } else if ( event instanceof PartitionDeleteEvent ) {
                this.expectedPartitionDeleteEvents--;
            } else if ( event instanceof PartitionContentChangeEvent ) {
                this.expectedPartitionContentChangeEvents--;
            } else if ( event instanceof PartitionSaveEvent ) {
                this.expectedPartitionSaveEvents--;
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

            assertEquals( this.expectedPartitionContentChangeEvents + " PartitionContentChangeEvents have not been delivered!", this.expectedPartitionContentChangeEvents, 0 );

            assertEquals( this.expectedPartitionSaveEvents + " PartitionContentChangeEvents have not been delivered!", this.expectedPartitionSaveEvents, 0 );

            assertEquals( this.expectedCustomEvents + " CustomEvents have not been delivered!", this.expectedCustomEvents, 0 );

            assertEquals( this.expectedAttributeValueRemoveEvents + " AttributeValueRemoveEvents have not been delivered!", this.expectedAttributeValueRemoveEvents, 0 );
        }
    }

    /**
     * PreChangeListener
     */
    protected static class TestPreChangeListener extends TestListener implements PreChangeListener {

        public void prepare( ChangeEvent event ) {

            receiveEvent( event, "prepare" );
        }
    }

    /**
     * ChangeListener
     */
    protected static class TestChangeListener extends TestListener implements ChangeListener {

        public void notify( ChangeEvent event ) {

            receiveEvent( event, "notify" );
        }
    }

    /**
     * ChangeListener
     */
    protected static class TestUpdateListener extends TestListener implements UpdateListener {

        public void notifyUpdate( EventChain events ) {

            for ( ChangeEvent event : events.getEvents( ) ) {
                receiveEvent( event, "notifyUpdate" );
            }
        }
    }

    private static TestChangeListener createAndRegisterTestChangeListener( EventFilter filter, Connection connection ) {

        TestChangeListener listener = new TestChangeListener( );
        connection.getEventRegistry( ).registerListener( listener, filter );
        return listener;
    }

    private static TestPreChangeListener createAndRegisterTestPreChangeListener( EventFilter filter, Connection connection ) {

        TestPreChangeListener listener = new TestPreChangeListener( );
        connection.getEventRegistry( ).registerPreChangeListener( listener, filter );
        return listener;
    }

    private static TestUpdateListener createAndRegisterTestUpdateListener( EventFilter filter, Connection connection ) {

        TestUpdateListener listener = new TestUpdateListener( );
        connection.getEventRegistry( ).registerUpdateListener( listener, filter );
        return listener;
    }

    private void checkReceivedEvents( ) {

        if ( this.partitionPCL != null ) {
            this.partitionPCL.checkAllEventsReceived( );
            this.partitionCL.checkAllEventsReceived( );
            this.partitionPCL2.checkAllEventsReceived( );
            this.partitionCL2.checkAllEventsReceived( );
        }

        if ( this.partitionUL != null ) {
            this.partitionUL.checkAllEventsReceived( );
        }

        if ( this.partitionUL2 != null ) {
            this.partitionUL2.checkAllEventsReceived( );
        }
    }

    TestPreChangeListener partitionPCL;

    TestChangeListener partitionCL;

    TestPreChangeListener partitionPCL2;

    TestChangeListener partitionCL2;

    TestUpdateListener partitionUL;

    TestUpdateListener partitionUL2;

}
