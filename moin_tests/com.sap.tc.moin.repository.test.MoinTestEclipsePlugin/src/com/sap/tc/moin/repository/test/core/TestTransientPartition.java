/*
 * Created on 20.02.2006
 */
package com.sap.tc.moin.repository.test.core;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionCreatingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.core.CorePartitionFactory;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.PartitionCreateEvent;
import com.sap.tc.moin.repository.events.type.PartitionDeleteEvent;

/**
 * Tests transient partitions.
 * 
 * @author d044711
 */
public class TestTransientPartition extends CoreMoinTest {

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Test
    public void testDeletion( ) throws Exception {

        final Connection connection = getMOINConnection( );
        final String partitionName = "myTransient";
        final ModelPartition myTransientPartition = connection.getOrCreateTransientPartition( partitionName );
        final PRI myTransientPartitionPri = myTransientPartition.getPri( );

        Command command = new Command( connection ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                myTransientPartition.delete( );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertNull( connection.getPartition( myTransientPartitionPri ) );
            }

            @Override
            public void assertAfterUndo( ) {

                ModelPartition transientPartition = connection.getPartition( myTransientPartitionPri );
                assertNotSame( null, transientPartition );
                assertEquals( myTransientPartitionPri, transientPartition.getPri( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 1, receivedEvents.size( ) );
                ChangeEvent event = receivedEvents.get( 0 );
                assertTrue( event instanceof PartitionDeleteEvent );
                PartitionDeleteEvent deleteEvent = (PartitionDeleteEvent) event;
                assertEquals( myTransientPartitionPri, deleteEvent.getAffectedPartitionPri( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 1, receivedEvents.size( ) );
                ChangeEvent event = receivedEvents.get( 0 );
                assertTrue( event instanceof PartitionCreateEvent );
                PartitionCreateEvent createEvent = (PartitionCreateEvent) event;
                assertEquals( myTransientPartitionPri, createEvent.getAffectedPartitionPri( ) );
            }

        };
        this.runDoUndoRedoTest( connection, command, asserter );

    }

    @Test
    public void testDeletionOfNonEmptyTransientPartition( ) throws Exception {

        final Connection connection = getMOINConnection( );
        final String partitionName = "myTransient";
        final ModelPartition myTransientPartition = connection.getOrCreateTransientPartition( partitionName );
        final PRI myTransientPartitionPri = myTransientPartition.getPri( );
        final Partitionable element = getSomeElement( );
        myTransientPartition.assignElement( element );
        final MRI elementMri = element.get___Mri( );

        Command command = new Command( connection ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                myTransientPartition.delete( );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertNull( connection.getPartition( myTransientPartitionPri ) );
                assertFalse( element.is___Alive( ) );
            }

            @Override
            public void assertAfterUndo( ) {

                ModelPartition transientPartition = connection.getPartition( myTransientPartitionPri );
                assertNotSame( null, transientPartition );
                assertEquals( myTransientPartitionPri, transientPartition.getPri( ) );
                assertSame( 1, transientPartition.getElements( ).size( ) );
                assertEquals( element, transientPartition.getElements( ).iterator( ).next( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 2, receivedEvents.size( ) );
                ChangeEvent event1 = receivedEvents.get( 0 );
                ChangeEvent event2 = receivedEvents.get( 1 );

                assertTrue( event1 instanceof ElementDeleteEvent );
                ElementDeleteEvent elementDeleteEvent = (ElementDeleteEvent) event1;
                assertEquals( elementMri, elementDeleteEvent.getAffectedElementMri( ) );

                assertTrue( event2 instanceof PartitionDeleteEvent );
                PartitionDeleteEvent deleteEvent = (PartitionDeleteEvent) event2;
                assertEquals( myTransientPartitionPri, deleteEvent.getAffectedPartitionPri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 2, receivedEvents.size( ) );
                ChangeEvent event1 = receivedEvents.get( 0 );
                ChangeEvent event2 = receivedEvents.get( 1 );

                assertTrue( event1 instanceof PartitionCreateEvent );
                PartitionCreateEvent createEvent = (PartitionCreateEvent) event1;
                assertEquals( myTransientPartitionPri, createEvent.getAffectedPartitionPri( ) );

                assertTrue( event2 instanceof ElementCreateEvent );
                ElementCreateEvent elementCreateEvent = (ElementCreateEvent) event2;
                assertEquals( elementMri, elementCreateEvent.getAffectedElementMri( ) );
            }

        };
        this.runDoUndoRedoTest( connection, command, asserter );
    }

    @Test
    public void testCreation( ) throws Exception {

        // first, make sure it doesn't exist already by creating it and then immediately deleting it
        final Connection connection = getMOINConnection( );
        final String partitionName = "myTransient";
        ModelPartition myTemporaryTransientPartition = connection.getOrCreateTransientPartition( partitionName );
        final PRI myTransientPartitionPri = myTemporaryTransientPartition.getPri( );
        myTemporaryTransientPartition.delete( );
        assertNull( connection.getPartition( myTransientPartitionPri ) );

        Command command = new Command( connection ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                connection.getOrCreateTransientPartition( partitionName );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                ModelPartition transientPartition = connection.getPartition( myTransientPartitionPri );
                assertNotSame( null, transientPartition );
                assertEquals( myTransientPartitionPri, transientPartition.getPri( ) );
                assertTrue( "Expected passed String to be part of the PRI", transientPartition.getPri( ).toString( ).indexOf( partitionName ) != -1 );

            }

            @Override
            public void assertAfterUndo( ) {

                assertNull( connection.getPartition( myTransientPartitionPri ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 1, receivedEvents.size( ) );
                ChangeEvent event = receivedEvents.get( 0 );
                assertTrue( event instanceof PartitionCreateEvent );
                PartitionCreateEvent createEvent = (PartitionCreateEvent) event;
                assertEquals( myTransientPartitionPri, createEvent.getAffectedPartitionPri( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 1, receivedEvents.size( ) );
                ChangeEvent event = receivedEvents.get( 0 );
                assertTrue( event instanceof PartitionDeleteEvent );
                PartitionDeleteEvent deleteEvent = (PartitionDeleteEvent) event;
                assertEquals( myTransientPartitionPri, deleteEvent.getAffectedPartitionPri( ) );
            }

        };
        this.runDoUndoRedoTest( connection, command, asserter );

        // getOrCreate it again after it is already existing
        ModelPartition myTransientPartition2 = connection.getOrCreateTransientPartition( partitionName );
        assertEquals( myTemporaryTransientPartition, myTransientPartition2 );

        // getOrCreate it in the "regular" way (with the PRI)
        try {
            connection.createPartition( myTransientPartitionPri );
            fail( "Expected exception" );
        } catch ( PartitionCreatingNotPossibleException e ) {
            // expected
        }

        Connection foreignConnection = getSecondMOINConnection( );

        // with just the String fragment it must also work with a foreign connection
        ModelPartition foreignTransientPartitionWithSameName = foreignConnection.getOrCreateTransientPartition( partitionName );
        assertNotSame( foreignTransientPartitionWithSameName, null );

        assertFalse( "Expected different transient partitions with different connections", myTemporaryTransientPartition.equals( foreignTransientPartitionWithSameName ) );

        assertFalse( "Expected the PRIs to be different", myTemporaryTransientPartition.getPri( ).equals( foreignTransientPartitionWithSameName.getPri( ) ) );
    }

    @Test
    public void testResolving( ) throws Exception {

        Connection connection = getMOINConnection( );
        String partitionName = "myTransient";
        ModelPartition myTransientPartition = connection.getOrCreateTransientPartition( partitionName );
        PRI myTransientPartitionPri = myTransientPartition.getPri( );

        // the PRI must be resolvable like a "regular" partition
        assertNotSame( connection.getPartition( myTransientPartitionPri ), null );

        Connection foreignConnection = getSecondMOINConnection( );
        // the PRI must NOT be resolvable with a "foreign" (i.e. from another session) connection
        assertNull( "Expected that resolving of transient partition PRI of other connection would fail", foreignConnection.getPartition( myTransientPartitionPri ) );

    }

    @Test
    public void testWillNotBeSaved( ) throws Exception {

        Connection connection = getMOINConnection( );
        String partitionName = "myTransient";
        ModelPartition myTransientPartition = connection.getOrCreateTransientPartition( partitionName );
        Partitionable element = getSomeElement( );
        myTransientPartition.assignElement( element );
        Collection<ModelPartition> partitionsToBeSaved = connection.getPartitionsToBeSaved( );
        assertFalse( "Expected transient partition not to be part of the partitions to be saved", partitionsToBeSaved.contains( myTransientPartition ) );
    }

    @Test
    public void testPartitionName( ) throws Exception {

        Connection connection = getMOINConnection( );

        String partitionName = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789_";
        assertTrue( connection.isLegalNameForTransientPartition( partitionName ) );
        assertNotSame( null, connection.getOrCreateTransientPartition( partitionName ) );

        try {
            partitionName = null;
            assertFalse( connection.isLegalNameForTransientPartition( partitionName ) );
            connection.getOrCreateTransientPartition( partitionName );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            partitionName = "";
            assertFalse( connection.isLegalNameForTransientPartition( partitionName ) );
            connection.getOrCreateTransientPartition( partitionName );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            partitionName = CorePartitionFactory.EXTENT_PARTITION_NAME;
            assertFalse( connection.isLegalNameForTransientPartition( partitionName ) );
            connection.getOrCreateTransientPartition( partitionName );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            partitionName = "@";
            assertFalse( connection.isLegalNameForTransientPartition( partitionName ) );
            connection.getOrCreateTransientPartition( partitionName );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            partitionName = "[";
            assertFalse( connection.isLegalNameForTransientPartition( partitionName ) );
            connection.getOrCreateTransientPartition( partitionName );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            partitionName = "{";
            assertFalse( connection.isLegalNameForTransientPartition( partitionName ) );
            connection.getOrCreateTransientPartition( partitionName );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            partitionName = "'";
            assertFalse( connection.isLegalNameForTransientPartition( partitionName ) );
            connection.getOrCreateTransientPartition( partitionName );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            partitionName = "myPärtition";
            assertFalse( connection.isLegalNameForTransientPartition( partitionName ) );
            connection.getOrCreateTransientPartition( partitionName );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            partitionName = "normal.xmi";
            assertFalse( connection.isLegalNameForTransientPartition( partitionName ) );
            connection.getOrCreateTransientPartition( partitionName );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }
    }

    @Test
    public void testNoMoreReferenceOnSave( ) throws Exception {

        Connection connection = getMOINConnection( );
        ModelPartition nonTransientPartition = getPartitionOne( );
        assertFalse( connection.hasReferencedTransientElements( ) );

        MofPackage alreadySavedNonTransientElement = (MofPackage) createMofPackage( );
        nonTransientPartition.assignElement( alreadySavedNonTransientElement );
        connection.save( );

        String partitionName = "myTransient";
        ModelPartition myTransientPartition = connection.getOrCreateTransientPartition( partitionName );
        Partitionable transientElement1 = createMofClass( );
        Partitionable transientElement2 = createMofClass( );
        Partitionable transientElement3 = createMofClass( );
        Partitionable transientElement4 = createMofClass( );

        myTransientPartition.assignElement( transientElement1 );
        myTransientPartition.assignElement( transientElement2 );
        myTransientPartition.assignElement( transientElement3 );
        myTransientPartition.assignElement( transientElement4 );

        MofPackage notYetSavedNonTransientElement = (MofPackage) createMofPackage( );
        nonTransientPartition.assignElement( notYetSavedNonTransientElement );
        notYetSavedNonTransientElement.getContents( ).add( (MofClass) transientElement1 );
        notYetSavedNonTransientElement.getContents( ).add( (MofClass) transientElement2 );

        alreadySavedNonTransientElement.getContents( ).add( (MofClass) transientElement3 );
        alreadySavedNonTransientElement.getContents( ).add( (MofClass) transientElement4 );

        assertTrue( connection.hasReferencedTransientElements( ) );

        try {
            connection.save( );
            fail( "Expected exception" );
        } catch ( ReferencedTransientElementsException e ) {
            // expected
        }

        Collection<MRI> referencedTransientElements = connection.getReferencedTransientElements( );
        assertSame( 4, referencedTransientElements.size( ) );
        assertTrue( referencedTransientElements.contains( transientElement1.get___Mri( ) ) );
        assertTrue( referencedTransientElements.contains( transientElement2.get___Mri( ) ) );
        assertTrue( referencedTransientElements.contains( transientElement3.get___Mri( ) ) );
        assertTrue( referencedTransientElements.contains( transientElement4.get___Mri( ) ) );

        nonTransientPartition.assignElement( transientElement1 );
        nonTransientPartition.assignElement( transientElement2 );
        nonTransientPartition.assignElement( transientElement3 );
        nonTransientPartition.assignElement( transientElement4 );

        assertFalse( connection.hasReferencedTransientElements( ) );
        assertTrue( connection.getReferencedTransientElements( ).isEmpty( ) );
    }

    @Test
    public void testGetAllTransientPartitions( ) throws Exception {

        Connection connection = getMOINConnection( );

        // at the beginning, only the null partition is part of that collection
        assertSame( 1, connection.getTransientPartitions( ).size( ) );
        ModelPartition transientPartition = connection.getTransientPartitions( ).iterator( ).next( );
        assertEquals( transientPartition, connection.getNullPartition( ) );

        String partitionName1 = "myTransient1";
        String partitionName2 = "myTransient2";
        String partitionName3 = "myTransient3";
        String partitionName4 = "myTransient4";

        ModelPartition myTransientPartition1 = connection.getOrCreateTransientPartition( partitionName1 );
        ModelPartition myTransientPartition2 = connection.getOrCreateTransientPartition( partitionName2 );
        ModelPartition myTransientPartition3 = connection.getOrCreateTransientPartition( partitionName3 );
        ModelPartition myTransientPartition4 = connection.getOrCreateTransientPartition( partitionName4 );

        Collection<ModelPartition> transientPartitions = connection.getTransientPartitions( );

        assertTrue( "Expected partition to be part of the transient partitions", transientPartitions.contains( myTransientPartition1 ) );
        assertTrue( "Expected partition to be part of the transient partitions", transientPartitions.contains( myTransientPartition2 ) );
        assertTrue( "Expected partition to be part of the transient partitions", transientPartitions.contains( myTransientPartition3 ) );
        assertTrue( "Expected partition to be part of the transient partitions", transientPartitions.contains( myTransientPartition4 ) );

    }

    @Test
    public void testAnswers( ) throws Exception {

        Connection connection = getMOINConnection( );
        String partitionName = "myTransient";
        ModelPartition myTransientPartition = connection.getOrCreateTransientPartition( partitionName );
        assertTrue( "Expected transient partition to be transient :-)", myTransientPartition.getPri( ).isVolatilePartition( ) );
        assertFalse( "Expected some transient partition not to consider itself as NullPartition", myTransientPartition.getPri( ).isNullPartition( ) );
        assertFalse( "Expected empty transient partition to be not dirty", myTransientPartition.isDirty( ) );
        Partitionable element = getSomeElement( );
        myTransientPartition.assignElement( element );
        assertTrue( "Expected non-empty transient partition to be dirty", myTransientPartition.isDirty( ) );
    }

    @Test
    public void testSavePossibleWithNonEmptyTransientPartitions( ) throws Exception {

        Connection connection = getMOINConnection( );
        String partitionName = "myTransient";
        ModelPartition myTransientPartition = connection.getOrCreateTransientPartition( partitionName );

        Partitionable element = getSomeElement( );
        myTransientPartition.assignElement( element );

        connection.save( ); // must work despite a transient partition which is not empty
    }

    @Test( expected = PartitionCreatingNotPossibleException.class )
    public void testCreatePartitionWithTransientPriInSameConnection( ) throws Exception {

        ModelPartition myTransientPartition = getMOINConnection( ).getOrCreateTransientPartition( "CreatePartitionWithTransientPri" );
        PRI pri = myTransientPartition.getPri( );
        getMOINConnection( ).createPartition( pri );
    }

    @Test( expected = PartitionCreatingNotPossibleException.class )
    public void testCreatePartitionWithTransientPriInOtherConnection( ) throws Exception {

        ModelPartition myTransientPartition = getMOINConnection( ).getOrCreateTransientPartition( "CreatePartitionWithTransientPri" );
        PRI pri = myTransientPartition.getPri( );
        getSecondMOINConnection( ).createPartition( pri );
    }

    private Partitionable getSomeElement( ) {

        return createMofClass( );
    }

    private Partitionable createMofClass( ) {

        return (Partitionable) getMOINConnection( ).createElementInPartition( MofClass.class, null );
    }

    private Partitionable createMofPackage( ) {

        return (Partitionable) getMOINConnection( ).createElementInPartition( MofPackage.class, null );
    }
}