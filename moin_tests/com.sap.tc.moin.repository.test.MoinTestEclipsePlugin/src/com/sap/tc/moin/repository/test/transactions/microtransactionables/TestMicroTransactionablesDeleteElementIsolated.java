package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AttachesTo;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Contains;
import com.sap.tc.moin.repository.mmi.model.IsOfType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.Test;

import com.sap.tc.moin.friends.RefObjectUtil;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.consistency.DanglingLinkConsistencyViolation;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case004.C4;
import com.sap.tc.moin.testcases.case004.ComposesB;
import com.sap.tc.moin.testcases.case004.ComposesCs;
import com.sap.tc.moin.testcases.case004.ComposesCsOrdered;
import com.sap.tc.moin.testcases.case004.F4;
import com.sap.tc.moin.testcases.case004.HasCs;
import com.sap.tc.moin.testcases.case005.p1.A5;
import com.sap.tc.moin.testcases.case005.p1.Association1;
import com.sap.tc.moin.testcases.case005.p1.p2.B5;

@SuppressWarnings( "nls" )
public class TestMicroTransactionablesDeleteElementIsolated extends BaseMicroTransactionablesTest {

    private void assertElementDeleted( RefBaseObject elementToDelete ) {

        assertFalse( "Element is still alive", ( (Partitionable) elementToDelete ).is___Alive( ) );
        assertNull( "Element still found", getMOINConnection( ).getElement( ( (Partitionable) elementToDelete ).get___Mri( ) ) );
    }

    private void assertElementExisting( RefBaseObject element ) {

        assertTrue( "Element is not alive", ( (Partitionable) element ).is___Alive( ) );
        assertNotNull( "Element not found", getMOINConnection( ).getElement( ( (Partitionable) element ).get___Mri( ) ) );
    }

    /**
     * Deletion of plain element which has no links.
     */
    @Test
    public void testDeleteElementIsolated1( ) throws Exception {

        final RefObject elementToDelete = getPartitionOne( ).createElement( MofClass.class );
        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );
            }

            @Override
            public void assertAfterUndo( ) {

                assertElementExisting( elementToDelete );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
            }

        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which has a to-1 Attribute link.
     */
    @Test
    public void testDeleteElementIsolated2( ) throws Exception {

        final A4 elementToDelete = getPartitionOne( ).createElement( A4.class );
        final B4 attributeChild = getPartitionOne( ).createElement( B4.class );
        elementToDelete.setOneBchangeable( attributeChild );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //no delete propagation
                assertTrue( ( (Partitionable) attributeChild ).is___Alive( ) );

                //link must be deleted
                assertNull( attributeChild.refImmediateComposite( ) );

                //no partition magic
                assertEquals( getPartitionOne( ), ( (Partitionable) attributeChild ).get___Partition( ) );
            }

            @Override
            public void assertAfterUndo( ) {

                assertEquals( attributeChild, elementToDelete.getOneBchangeable( ) );
                assertEquals( elementToDelete, attributeChild.refImmediateComposite( ) );
                assertElementExisting( elementToDelete );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which is the value of a to-1 Attribute link.
     */
    @Test
    public void testDeleteElementIsolated3( ) throws Exception {

        final B4 elementToDelete = getPartitionOne( ).createElement( B4.class );
        final A4 attributeParent = getPartitionOne( ).createElement( A4.class );
        attributeParent.setOneBchangeable( elementToDelete );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //link must be dangling
                assertNull( attributeParent.getOneBchangeable( ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 1, danglingLinksOfPartition.size( ) );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ).getLri( ), danglingLinksOfPartition.get( 0 ).getMissingElement( ) );
            }

            @Override
            public void assertAfterUndo( ) {

                //element must be existing
                assertElementExisting( elementToDelete );

                //link must be valid
                assertEquals( elementToDelete, attributeParent.getOneBchangeable( ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which has to-n Attribute links.
     */
    @Test
    public void testDeleteElementIsolated4( ) throws Exception {

        final A4 elementToDelete = getPartitionOne( ).createElement( A4.class );
        final B4 attributeChild1 = getPartitionOne( ).createElement( B4.class );
        final B4 attributeChild2 = getPartitionOne( ).createElement( B4.class );
        final B4 attributeChild3 = getPartitionOne( ).createElement( B4.class );
        elementToDelete.getManyBsNotOrdered( ).add( attributeChild1 );
        elementToDelete.getManyBsNotOrdered( ).add( attributeChild2 );
        elementToDelete.getManyBsNotOrdered( ).add( attributeChild3 );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //no delete propagation
                assertElementExisting( attributeChild1 );
                assertElementExisting( attributeChild2 );
                assertElementExisting( attributeChild3 );

                //links must be deleted
                assertNull( attributeChild1.refImmediateComposite( ) );
                assertNull( attributeChild2.refImmediateComposite( ) );
                assertNull( attributeChild3.refImmediateComposite( ) );

                //no partition magic
                assertEquals( getPartitionOne( ), ( (Partitionable) attributeChild1 ).get___Partition( ) );
                assertEquals( getPartitionOne( ), ( (Partitionable) attributeChild2 ).get___Partition( ) );
                assertEquals( getPartitionOne( ), ( (Partitionable) attributeChild3 ).get___Partition( ) );
            }

            @Override
            public void assertAfterUndo( ) {

                assertEquals( 3, elementToDelete.getManyBsNotOrdered( ).size( ) );
                assertTrue( elementToDelete.getManyBsNotOrdered( ).contains( attributeChild1 ) );
                assertTrue( elementToDelete.getManyBsNotOrdered( ).contains( attributeChild2 ) );
                assertTrue( elementToDelete.getManyBsNotOrdered( ).contains( attributeChild3 ) );
                assertEquals( elementToDelete, attributeChild1.refImmediateComposite( ) );
                assertEquals( elementToDelete, attributeChild2.refImmediateComposite( ) );
                assertEquals( elementToDelete, attributeChild3.refImmediateComposite( ) );
                assertElementExisting( elementToDelete );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which has to-n ordered Attribute links.
     */
    @Test
    public void testDeleteElementIsolated4_ordered( ) throws Exception {

        final A4 elementToDelete = getPartitionOne( ).createElement( A4.class );
        final B4 attributeChild1 = getPartitionOne( ).createElement( B4.class );
        final B4 attributeChild2 = getPartitionOne( ).createElement( B4.class );
        final B4 attributeChild3 = getPartitionOne( ).createElement( B4.class );
        elementToDelete.getManyBsOrdered( ).add( attributeChild1 );
        elementToDelete.getManyBsOrdered( ).add( attributeChild2 );
        elementToDelete.getManyBsOrdered( ).add( attributeChild3 );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //no delete propagation
                assertElementExisting( attributeChild1 );
                assertElementExisting( attributeChild2 );
                assertElementExisting( attributeChild3 );

                //links must be deleted
                assertNull( attributeChild1.refImmediateComposite( ) );
                assertNull( attributeChild2.refImmediateComposite( ) );
                assertNull( attributeChild3.refImmediateComposite( ) );

                //no partition magic
                assertEquals( getPartitionOne( ), ( (Partitionable) attributeChild1 ).get___Partition( ) );
                assertEquals( getPartitionOne( ), ( (Partitionable) attributeChild2 ).get___Partition( ) );
                assertEquals( getPartitionOne( ), ( (Partitionable) attributeChild3 ).get___Partition( ) );
            }

            @Override
            public void assertAfterUndo( ) {

                List<B4> manyBsOrdered = elementToDelete.getManyBsOrdered( );
                assertEquals( attributeChild1, manyBsOrdered.get( 0 ) );
                assertEquals( attributeChild2, manyBsOrdered.get( 1 ) );
                assertEquals( attributeChild3, manyBsOrdered.get( 2 ) );
                assertEquals( elementToDelete, attributeChild1.refImmediateComposite( ) );
                assertEquals( elementToDelete, attributeChild2.refImmediateComposite( ) );
                assertEquals( elementToDelete, attributeChild3.refImmediateComposite( ) );
                assertElementExisting( elementToDelete );
                assertElementExisting( attributeChild1 );
                assertElementExisting( attributeChild2 );
                assertElementExisting( attributeChild3 );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which is one value of to-n Attribute links.
     */
    @Test
    public void testDeleteElementIsolated5( ) throws Exception {

        final B4 elementToDelete = getPartitionOne( ).createElement( B4.class );
        final B4 attributeChild1 = getPartitionOne( ).createElement( B4.class );
        final B4 attributeChild3 = getPartitionOne( ).createElement( B4.class );
        final A4 attributeParent = getPartitionOne( ).createElement( A4.class );

        attributeParent.getManyBsNotOrdered( ).add( attributeChild1 );
        attributeParent.getManyBsNotOrdered( ).add( elementToDelete );
        attributeParent.getManyBsNotOrdered( ).add( attributeChild3 );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //link to deleted element must be dangling
                assertEquals( 3, attributeParent.getManyBsNotOrdered( ).size( ) );
                assertTrue( attributeParent.getManyBsNotOrdered( ).contains( null ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 1, danglingLinksOfPartition.size( ) );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ).getLri( ), danglingLinksOfPartition.get( 0 ).getMissingElement( ) );

                //other elements must still be there
                assertElementExisting( attributeChild1 );
                assertElementExisting( attributeChild3 );
                assertTrue( attributeParent.getManyBsNotOrdered( ).contains( attributeChild1 ) );
                assertTrue( attributeParent.getManyBsNotOrdered( ).contains( attributeChild3 ) );

            }

            @Override
            public void assertAfterUndo( ) {

                //element must be existing
                assertElementExisting( elementToDelete );
                assertElementExisting( attributeChild1 );
                assertElementExisting( attributeChild3 );

                //links must be valid
                assertEquals( 3, attributeParent.getManyBsNotOrdered( ).size( ) );
                assertTrue( attributeParent.getManyBsNotOrdered( ).contains( elementToDelete ) );
                assertTrue( attributeParent.getManyBsNotOrdered( ).contains( attributeChild1 ) );
                assertTrue( attributeParent.getManyBsNotOrdered( ).contains( attributeChild3 ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which is one value of to-n Attribute links.
     */
    @Test
    public void testDeleteElementIsolated5_ordered( ) throws Exception {

        final B4 elementToDelete = getPartitionOne( ).createElement( B4.class );
        final B4 attributeChild1 = getPartitionOne( ).createElement( B4.class );
        final B4 attributeChild3 = getPartitionOne( ).createElement( B4.class );
        final A4 attributeParent = getPartitionOne( ).createElement( A4.class );

        attributeParent.getManyBsOrdered( ).add( attributeChild1 );
        attributeParent.getManyBsOrdered( ).add( elementToDelete );
        attributeParent.getManyBsOrdered( ).add( attributeChild3 );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //link to deleted element must be dangling
                List<B4> manyBsOrdered = attributeParent.getManyBsOrdered( );
                Iterator<B4> iterator = manyBsOrdered.iterator( );
                assertEquals( 3, manyBsOrdered.size( ) );
                assertEquals( attributeChild1, manyBsOrdered.get( 0 ) );
                assertEquals( attributeChild1, iterator.next( ) );
                assertNull( iterator.next( ) );
                assertNull( manyBsOrdered.get( 1 ) );
                assertEquals( attributeChild3, manyBsOrdered.get( 2 ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 1, danglingLinksOfPartition.size( ) );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ).getLri( ), danglingLinksOfPartition.get( 0 ).getMissingElement( ) );

                //other elements must still be there
                assertElementExisting( attributeChild1 );
                assertElementExisting( attributeChild3 );

            }

            @Override
            public void assertAfterUndo( ) {

                //element must be existing
                assertElementExisting( elementToDelete );
                assertElementExisting( attributeChild1 );
                assertElementExisting( attributeChild3 );

                //links must be valid
                List<B4> manyBsOrdered = attributeParent.getManyBsOrdered( );
                assertEquals( 3, manyBsOrdered.size( ) );
                assertEquals( attributeChild1, manyBsOrdered.get( 0 ) );
                assertEquals( elementToDelete, manyBsOrdered.get( 1 ) );
                assertEquals( attributeChild3, manyBsOrdered.get( 2 ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which has a to-1 Association link.
     */
    @Test
    public void testDeleteElementIsolated2_SimpleAssoc( ) throws Exception {

        final IsOfType refIsOfTypeAssoc = getMOINConnection( ).getAssociation( IsOfType.ASSOCIATION_DESCRIPTOR );
        final Attribute elementToDelete = getPartitionOne( ).createElement( Attribute.class );
        final MofClass associatedElement = getPartitionOne( ).createElement( MofClass.class );
        elementToDelete.setType( associatedElement );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //no delete propagation
                assertElementExisting( associatedElement );

                //link must be deleted
                assertTrue( refIsOfTypeAssoc.getTypedElements( associatedElement ).isEmpty( ) );

            }

            @Override
            public void assertAfterUndo( ) {

                assertEquals( 1, refIsOfTypeAssoc.getTypedElements( associatedElement ).size( ) );
                assertEquals( elementToDelete, refIsOfTypeAssoc.getTypedElements( associatedElement ).iterator( ).next( ) );
                assertEquals( associatedElement, elementToDelete.getType( ) );
                assertElementExisting( elementToDelete );
                assertElementExisting( associatedElement );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 2, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
                LinkRemoveEvent linkEvent = (LinkRemoveEvent) receivedEvents.get( 1 );
                assertEquals( ( (Partitionable) refIsOfTypeAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 2, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
                LinkAddEvent linkEvent = (LinkAddEvent) receivedEvents.get( 1 );
                assertEquals( ( (Partitionable) refIsOfTypeAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );

            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which is at the non-storage end of a to-1 Association
     * link.
     */
    @Test
    public void testDeleteElementIsolated3_SimpleAssoc( ) throws Exception {

        final Attribute attribute = getPartitionOne( ).createElement( Attribute.class );
        final MofClass elementToDelete = getPartitionOne( ).createElement( MofClass.class );
        attribute.setType( elementToDelete );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //link must be dangling
                assertNull( attribute.getType( ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 1, danglingLinksOfPartition.size( ) );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ).getLri( ), danglingLinksOfPartition.get( 0 ).getMissingElement( ) );
            }

            @Override
            public void assertAfterUndo( ) {

                //element must be existing
                assertElementExisting( elementToDelete );

                //link must be valid
                assertEquals( elementToDelete, attribute.getType( ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which has to-n Association links.
     */
    @Test
    public void testDeleteElementIsolated4_SimpleAssoc( ) throws Exception {

        final AttachesTo attachesToAssoc = getMOINConnection( ).getAssociation( AttachesTo.ASSOCIATION_DESCRIPTOR );
        final Tag elementToDelete = getPartitionOne( ).createElement( Tag.class );
        final MofClass annotatedElement1 = getPartitionOne( ).createElement( MofClass.class );
        final MofClass annotatedElement2 = getPartitionOne( ).createElement( MofClass.class );
        final MofClass annotatedElement3 = getPartitionOne( ).createElement( MofClass.class );
        elementToDelete.getElements( ).add( annotatedElement1 );
        elementToDelete.getElements( ).add( annotatedElement2 );
        elementToDelete.getElements( ).add( annotatedElement3 );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //no delete propagation
                assertElementExisting( annotatedElement1 );
                assertElementExisting( annotatedElement2 );
                assertElementExisting( annotatedElement3 );

                //links must be deleted
                assertTrue( attachesToAssoc.getTag( annotatedElement1 ).isEmpty( ) );
                assertTrue( attachesToAssoc.getTag( annotatedElement2 ).isEmpty( ) );
                assertTrue( attachesToAssoc.getTag( annotatedElement3 ).isEmpty( ) );

            }

            @Override
            public void assertAfterUndo( ) {

                assertEquals( 3, elementToDelete.getElements( ).size( ) );
                assertTrue( elementToDelete.getElements( ).contains( annotatedElement1 ) );
                assertTrue( elementToDelete.getElements( ).contains( annotatedElement2 ) );
                assertTrue( elementToDelete.getElements( ).contains( annotatedElement3 ) );
                assertEquals( 1, attachesToAssoc.getTag( annotatedElement1 ).size( ) );
                assertEquals( elementToDelete, attachesToAssoc.getTag( annotatedElement1 ).iterator( ).next( ) );
                assertEquals( 1, attachesToAssoc.getTag( annotatedElement2 ).size( ) );
                assertEquals( elementToDelete, attachesToAssoc.getTag( annotatedElement2 ).iterator( ).next( ) );
                assertEquals( 1, attachesToAssoc.getTag( annotatedElement3 ).size( ) );
                assertEquals( elementToDelete, attachesToAssoc.getTag( annotatedElement3 ).iterator( ).next( ) );
                assertElementExisting( elementToDelete );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 4, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
                LinkRemoveEvent linkEvent = (LinkRemoveEvent) receivedEvents.get( 1 );
                assertEquals( ( (Partitionable) attachesToAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );
                linkEvent = (LinkRemoveEvent) receivedEvents.get( 2 );
                assertEquals( ( (Partitionable) attachesToAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );
                linkEvent = (LinkRemoveEvent) receivedEvents.get( 3 );
                assertEquals( ( (Partitionable) attachesToAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 4, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
                LinkAddEvent linkEvent = (LinkAddEvent) receivedEvents.get( 1 );
                assertEquals( ( (Partitionable) attachesToAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );
                linkEvent = (LinkAddEvent) receivedEvents.get( 2 );
                assertEquals( ( (Partitionable) attachesToAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );
                linkEvent = (LinkAddEvent) receivedEvents.get( 3 );
                assertEquals( ( (Partitionable) attachesToAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );

            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which is one value of to-n Attribute links.
     */
    @Test
    public void testDeleteElementIsolated5_SimpleAssoc( ) throws Exception {

        final Tag tag = getPartitionOne( ).createElement( Tag.class );
        final MofClass annotatedElement1 = getPartitionOne( ).createElement( MofClass.class );
        final MofClass elementToDelete = getPartitionOne( ).createElement( MofClass.class );
        final MofClass annotatedElement3 = getPartitionOne( ).createElement( MofClass.class );
        tag.getElements( ).add( annotatedElement1 );
        tag.getElements( ).add( elementToDelete );
        tag.getElements( ).add( annotatedElement3 );
        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //link to deleted element must be dangling
                Collection<ModelElement> elements = tag.getElements( );
                assertEquals( 3, elements.size( ) );
                assertTrue( elements.contains( null ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 1, danglingLinksOfPartition.size( ) );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ).getLri( ), danglingLinksOfPartition.get( 0 ).getMissingElement( ) );

                //other elements must still be there
                assertElementExisting( annotatedElement1 );
                assertElementExisting( annotatedElement3 );
                assertTrue( elements.contains( annotatedElement1 ) );
                assertTrue( elements.contains( annotatedElement3 ) );

            }

            @Override
            public void assertAfterUndo( ) {

                //element must be existing
                assertElementExisting( elementToDelete );
                assertElementExisting( annotatedElement1 );
                assertElementExisting( annotatedElement3 );

                //links must be valid
                Collection<ModelElement> elements = tag.getElements( );
                assertEquals( 3, elements.size( ) );
                assertTrue( elements.contains( elementToDelete ) );
                assertTrue( elements.contains( annotatedElement1 ) );
                assertTrue( elements.contains( annotatedElement3 ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which has a to-1 composite Association link.
     */
    @Test
    public void testDeleteElementIsolated2_CompositeAssoc( ) throws Exception {

        final Association1 assoc1 = getMOINConnection( ).getAssociation( Association1.ASSOCIATION_DESCRIPTOR );
        final A5 elementToDelete = getPartitionOne( ).createElement( A5.class );
        final B5 child = getPartitionOne( ).createElement( B5.class );
        elementToDelete.setX( child );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //no delete propagation
                assertTrue( ( (Partitionable) child ).is___Alive( ) );

                //link must be deleted
                assertNull( child.refImmediateComposite( ) );
                assertNull( assoc1.getA5( child ) );

                //no partition magic
                assertEquals( getPartitionOne( ), ( (Partitionable) child ).get___Partition( ) );
            }

            @Override
            public void assertAfterUndo( ) {

                assertEquals( child, elementToDelete.getX( ) );
                assertEquals( elementToDelete, child.refImmediateComposite( ) );
                assertEquals( elementToDelete, assoc1.getA5( child ) );
                assertElementExisting( elementToDelete );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 2, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
                LinkRemoveEvent linkEvent = (LinkRemoveEvent) receivedEvents.get( 1 );
                assertEquals( ( (Partitionable) assoc1.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 2, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
                LinkAddEvent linkEvent = (LinkAddEvent) receivedEvents.get( 1 );
                assertEquals( ( (Partitionable) assoc1.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );

            }

        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which is the value of a to-1 composite Association
     * link.
     */
    @Test
    public void testDeleteElementIsolated3_CompositeAssoc( ) throws Exception {

        final Association1 assoc1 = getMOINConnection( ).getAssociation( Association1.ASSOCIATION_DESCRIPTOR );
        final B5 elementToDelete = getPartitionOne( ).createElement( B5.class );
        final A5 parent = getPartitionOne( ).createElement( A5.class );
        parent.setX( elementToDelete );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //link must be dangling
                assertNull( parent.getX( ) );
                assertNull( assoc1.getX( parent ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 1, danglingLinksOfPartition.size( ) );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ).getLri( ), danglingLinksOfPartition.get( 0 ).getMissingElement( ) );
            }

            @Override
            public void assertAfterUndo( ) {

                //element must be existing
                assertElementExisting( elementToDelete );

                //link must be valid
                assertEquals( elementToDelete, parent.getX( ) );
                assertEquals( elementToDelete, assoc1.getX( parent ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
            }

        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which has to-n composite Association links.
     */
    @Test
    public void testDeleteElementIsolated4_CompositeAssoc( ) throws Exception {

        final ComposesCs composesCs = getMOINConnection( ).getAssociation( ComposesCs.ASSOCIATION_DESCRIPTOR );
        final F4 elementToDelete = getPartitionOne( ).createElement( F4.class );
        final C4 containedElement1 = getPartitionOne( ).createElement( C4.class );
        final C4 containedElement2 = getPartitionOne( ).createElement( C4.class );
        final C4 containedElement3 = getPartitionOne( ).createElement( C4.class );
        composesCs.getMyCs( elementToDelete ).add( containedElement1 );
        composesCs.getMyCs( elementToDelete ).add( containedElement2 );
        composesCs.getMyCs( elementToDelete ).add( containedElement3 );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //no delete propagation
                assertElementExisting( containedElement1 );
                assertElementExisting( containedElement2 );
                assertElementExisting( containedElement3 );

                //links must be deleted
                assertNull( composesCs.getMyF( containedElement1 ) );
                assertNull( composesCs.getMyF( containedElement2 ) );
                assertNull( composesCs.getMyF( containedElement3 ) );
                assertNull( containedElement1.refImmediateComposite( ) );
                assertNull( containedElement2.refImmediateComposite( ) );
                assertNull( containedElement3.refImmediateComposite( ) );

                //no partition magic
                assertEquals( getPartitionOne( ), ( (Partitionable) containedElement1 ).get___Partition( ) );
                assertEquals( getPartitionOne( ), ( (Partitionable) containedElement2 ).get___Partition( ) );
                assertEquals( getPartitionOne( ), ( (Partitionable) containedElement3 ).get___Partition( ) );
            }

            @Override
            public void assertAfterUndo( ) {

                assertElementExisting( elementToDelete );
                Collection<C4> c4s = composesCs.getMyCs( elementToDelete );
                assertEquals( 3, c4s.size( ) );
                assertTrue( c4s.contains( containedElement1 ) );
                assertTrue( c4s.contains( containedElement2 ) );
                assertTrue( c4s.contains( containedElement3 ) );
                assertEquals( elementToDelete, composesCs.getMyF( containedElement1 ) );
                assertEquals( elementToDelete, composesCs.getMyF( containedElement2 ) );
                assertEquals( elementToDelete, composesCs.getMyF( containedElement3 ) );
                assertEquals( elementToDelete, containedElement1.refImmediateComposite( ) );
                assertEquals( elementToDelete, containedElement2.refImmediateComposite( ) );
                assertEquals( elementToDelete, containedElement3.refImmediateComposite( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 4, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
                LinkRemoveEvent linkEvent = (LinkRemoveEvent) receivedEvents.get( 1 );
                assertEquals( ( (Partitionable) composesCs.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );
                linkEvent = (LinkRemoveEvent) receivedEvents.get( 2 );
                assertEquals( ( (Partitionable) composesCs.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );
                linkEvent = (LinkRemoveEvent) receivedEvents.get( 3 );
                assertEquals( ( (Partitionable) composesCs.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 4, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
                LinkAddEvent linkEvent = (LinkAddEvent) receivedEvents.get( 1 );
                assertEquals( ( (Partitionable) composesCs.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );
                linkEvent = (LinkAddEvent) receivedEvents.get( 2 );
                assertEquals( ( (Partitionable) composesCs.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );
                linkEvent = (LinkAddEvent) receivedEvents.get( 3 );
                assertEquals( ( (Partitionable) composesCs.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );

            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which has a to-n ordered composite Association link.
     */
    @Test
    public void testDeleteElementIsolated4_CompositeAssoc_ordered( ) throws Exception {

        final Contains containsAssoc = getMOINConnection( ).getAssociation( Contains.ASSOCIATION_DESCRIPTOR );
        final MofClass elementToDelete = getPartitionOne( ).createElement( MofClass.class );
        final Attribute containedElement1 = getPartitionOne( ).createElement( Attribute.class );
        final Attribute containedElement2 = getPartitionOne( ).createElement( Attribute.class );
        final Attribute containedElement3 = getPartitionOne( ).createElement( Attribute.class );
        containedElement1.setContainer( elementToDelete );
        containedElement2.setContainer( elementToDelete );
        containedElement3.setContainer( elementToDelete );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //no delete propagation
                assertElementExisting( containedElement1 );
                assertElementExisting( containedElement2 );
                assertElementExisting( containedElement3 );

                //links must be deleted
                assertNull( containedElement1.getContainer( ) );
                assertNull( containedElement2.getContainer( ) );
                assertNull( containedElement3.getContainer( ) );

                //no partition magic
                assertEquals( getPartitionOne( ), ( (Partitionable) containedElement1 ).get___Partition( ) );
                assertEquals( getPartitionOne( ), ( (Partitionable) containedElement2 ).get___Partition( ) );
                assertEquals( getPartitionOne( ), ( (Partitionable) containedElement3 ).get___Partition( ) );

            }

            @Override
            public void assertAfterUndo( ) {

                assertElementExisting( elementToDelete );
                assertElementExisting( containedElement1 );
                assertElementExisting( containedElement2 );
                assertElementExisting( containedElement3 );
                assertEquals( elementToDelete, containedElement1.getContainer( ) );
                assertEquals( elementToDelete, containedElement2.getContainer( ) );
                assertEquals( elementToDelete, containedElement3.getContainer( ) );
                List<ModelElement> contents = elementToDelete.getContents( );
                assertEquals( 3, contents.size( ) );
                Iterator<ModelElement> iterator = contents.iterator( );
                assertEquals( containedElement1, iterator.next( ) );
                assertEquals( containedElement1, contents.get( 0 ) );
                assertEquals( containedElement2, iterator.next( ) );
                assertEquals( containedElement2, contents.get( 1 ) );
                assertEquals( containedElement3, iterator.next( ) );
                assertEquals( containedElement3, contents.get( 2 ) );
                assertEquals( elementToDelete, containedElement1.refImmediateComposite( ) );
                assertEquals( elementToDelete, containedElement2.refImmediateComposite( ) );
                assertEquals( elementToDelete, containedElement3.refImmediateComposite( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 4, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
                LinkRemoveEvent linkEvent = (LinkRemoveEvent) receivedEvents.get( 1 );
                assertEquals( ( (Partitionable) containsAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );
                linkEvent = (LinkRemoveEvent) receivedEvents.get( 2 );
                assertEquals( ( (Partitionable) containsAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );
                linkEvent = (LinkRemoveEvent) receivedEvents.get( 3 );
                assertEquals( ( (Partitionable) containsAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 4, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
                LinkAddEvent linkEvent = (LinkAddEvent) receivedEvents.get( 1 );
                assertEquals( ( (Partitionable) containsAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );
                linkEvent = (LinkAddEvent) receivedEvents.get( 2 );
                assertEquals( ( (Partitionable) containsAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );
                linkEvent = (LinkAddEvent) receivedEvents.get( 3 );
                assertEquals( ( (Partitionable) containsAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );

            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which is one value of to-n composite Association
     * links.
     */
    @Test
    public void testDeleteElementIsolated5_CompositeAssoc( ) throws Exception {

        final ComposesCs composesCs = getMOINConnection( ).getAssociation( ComposesCs.ASSOCIATION_DESCRIPTOR );
        final F4 container = getPartitionOne( ).createElement( F4.class );
        final C4 containedElement1 = getPartitionOne( ).createElement( C4.class );
        final C4 elementToDelete = getPartitionOne( ).createElement( C4.class );
        final C4 containedElement3 = getPartitionOne( ).createElement( C4.class );
        composesCs.getMyCs( container ).add( containedElement1 );
        composesCs.getMyCs( container ).add( elementToDelete );
        composesCs.getMyCs( container ).add( containedElement3 );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //link to deleted element must be dangling
                Collection<C4> elements = composesCs.getMyCs( container );
                assertEquals( 3, elements.size( ) );
                assertTrue( elements.contains( null ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 1, danglingLinksOfPartition.size( ) );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ).getLri( ), danglingLinksOfPartition.get( 0 ).getMissingElement( ) );

                //other elements must still be there
                assertElementExisting( containedElement1 );
                assertElementExisting( containedElement3 );
                assertTrue( elements.contains( containedElement1 ) );
                assertTrue( elements.contains( containedElement3 ) );

            }

            @Override
            public void assertAfterUndo( ) {

                //element must be existing
                assertElementExisting( elementToDelete );
                assertElementExisting( containedElement1 );
                assertElementExisting( containedElement3 );

                //links must be valid
                Collection<C4> elements = composesCs.getMyCs( container );
                assertEquals( 3, elements.size( ) );
                assertTrue( elements.contains( elementToDelete ) );
                assertTrue( elements.contains( containedElement1 ) );
                assertTrue( elements.contains( containedElement3 ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    /**
     * Deletion of element which is one value of to-n ordered composite
     * Association links.
     */
    @Test
    public void testDeleteElementIsolated5_CompositeAssoc_ordered( ) throws Exception {

        final Attribute elementToDelete = getPartitionOne( ).createElement( Attribute.class );
        final Attribute containedElement1 = getPartitionOne( ).createElement( Attribute.class );
        final Attribute containedElement3 = getPartitionOne( ).createElement( Attribute.class );
        final MofClass container = getPartitionOne( ).createElement( MofClass.class );

        container.getContents( ).add( containedElement1 );
        container.getContents( ).add( elementToDelete );
        container.getContents( ).add( containedElement3 );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //link to deleted element must be dangling
                List<ModelElement> contents = container.getContents( );
                Iterator<ModelElement> iterator = contents.iterator( );
                assertEquals( 3, contents.size( ) );
                assertEquals( containedElement1, contents.get( 0 ) );
                assertEquals( containedElement1, iterator.next( ) );
                assertNull( iterator.next( ) );
                assertNull( contents.get( 1 ) );
                assertEquals( containedElement3, contents.get( 2 ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 1, danglingLinksOfPartition.size( ) );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ).getLri( ), danglingLinksOfPartition.get( 0 ).getMissingElement( ) );

                //other elements must still be there
                assertElementExisting( containedElement1 );
                assertElementExisting( containedElement3 );

            }

            @Override
            public void assertAfterUndo( ) {

                //element must be existing
                assertElementExisting( elementToDelete );
                assertElementExisting( containedElement1 );
                assertElementExisting( containedElement3 );

                //links must be valid
                List<ModelElement> contents = container.getContents( );
                Iterator<ModelElement> iterator = contents.iterator( );
                assertEquals( 3, contents.size( ) );
                assertEquals( containedElement1, contents.get( 0 ) );
                assertEquals( containedElement1, iterator.next( ) );
                assertEquals( elementToDelete, contents.get( 1 ) );
                assertEquals( elementToDelete, iterator.next( ) );
                assertEquals( containedElement3, contents.get( 2 ) );
                assertEquals( containedElement3, iterator.next( ) );
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 1, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    @Test
    public void testDeleteElementIsolatedOnNonRefObject( ) {

        Contains association = getMOINConnection( ).getAssociation( Contains.ASSOCIATION_DESCRIPTOR );
        CorePartitionable coreAssociation = getTestHelper( ).getCorePartitionable( association );
        try {
            coreAssociation.delete___Isolated( coreConnection );
            fail( "Expected exception" );
        } catch ( UnsupportedOperationException e ) {
            //expected
        }
    }

    @Test
    public void testDeleteElementIsolatedSelfReferencingElement( ) throws Exception {

        final AttachesTo attachesToAssoc = getMOINConnection( ).getAssociation( AttachesTo.ASSOCIATION_DESCRIPTOR );
        final Tag elementToDelete = getPartitionOne( ).createElement( Tag.class );
        elementToDelete.getElements( ).add( elementToDelete );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //no inconsistencies
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );

            }

            @Override
            public void assertAfterUndo( ) {

                //element must be existing
                assertElementExisting( elementToDelete );

                //link must be existing
                assertEquals( 1, elementToDelete.getElements( ).size( ) );
                assertEquals( elementToDelete, elementToDelete.getElements( ).iterator( ).next( ) );
                assertEquals( elementToDelete, attachesToAssoc.refQuery( "tag", elementToDelete ).iterator( ).next( ) );

                //no inconsistencies
                List<DanglingLinkConsistencyViolation> danglingLinksOfPartition = coreConnection.getConsistencyViolationRegistry( ).checkDanglingLinksOfPartition( getPartitionOne( ).getPri( ) );
                assertEquals( 0, danglingLinksOfPartition.size( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 2, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
                LinkRemoveEvent linkEvent = (LinkRemoveEvent) receivedEvents.get( 1 );
                assertEquals( ( (Partitionable) attachesToAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 2, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );
                LinkAddEvent linkEvent = (LinkAddEvent) receivedEvents.get( 1 );
                assertEquals( ( (Partitionable) attachesToAssoc.refMetaObject( ) ).get___Mri( ), linkEvent.getAffectedMetaObjectMri( ) );

            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );

    }

    @Test
    public void testDeleteElementIsolated( ) throws Exception {

        final ComposesCs composesCs = getMOINConnection( ).getAssociation( ComposesCs.ASSOCIATION_DESCRIPTOR );
        final HasCs hasCs = getMOINConnection( ).getAssociation( HasCs.ASSOCIATION_DESCRIPTOR );
        final ComposesCsOrdered composesCsOrdered = getMOINConnection( ).getAssociation( ComposesCsOrdered.ASSOCIATION_DESCRIPTOR );
        final ComposesB composesB = getMOINConnection( ).getAssociation( ComposesB.ASSOCIATION_DESCRIPTOR );

        final F4 elementToDelete = getPartitionOne( ).createElement( F4.class );

        final C4 oneCValue = getPartitionOne( ).createElement( C4.class );

        final C4 manyCs1 = getPartitionOne( ).createElement( C4.class );
        final C4 manyCs2 = getPartitionOne( ).createElement( C4.class );
        final C4 manyCs3 = getPartitionOne( ).createElement( C4.class );

        final C4 manyCsOrdered1 = getPartitionOne( ).createElement( C4.class );
        final C4 manyCsOrdered2 = getPartitionOne( ).createElement( C4.class );
        final C4 manyCsOrdered3 = getPartitionOne( ).createElement( C4.class );

        final C4 composesCsOrdered1 = getPartitionOne( ).createElement( C4.class );
        final C4 composesCsOrdered2 = getPartitionOne( ).createElement( C4.class );
        final C4 composesCsOrdered3 = getPartitionOne( ).createElement( C4.class );

        final C4 hasCs1 = getPartitionOne( ).createElement( C4.class );
        final C4 hasCs2 = getPartitionOne( ).createElement( C4.class );
        final C4 hasCs3 = getPartitionOne( ).createElement( C4.class );

        final C4 composesCs1 = getPartitionOne( ).createElement( C4.class );
        final C4 composesCs2 = getPartitionOne( ).createElement( C4.class );
        final C4 composesCs3 = getPartitionOne( ).createElement( C4.class );

        final B4 composesBValue = getPartitionOne( ).createElement( B4.class );

        elementToDelete.setOneC( oneCValue );
        elementToDelete.getManyCs( ).add( manyCs1 );
        elementToDelete.getManyCs( ).add( manyCs2 );
        elementToDelete.getManyCs( ).add( manyCs3 );
        elementToDelete.getManyCsOrdered( ).add( manyCsOrdered1 );
        elementToDelete.getManyCsOrdered( ).add( manyCsOrdered2 );
        elementToDelete.getManyCsOrdered( ).add( manyCsOrdered3 );

        Collection<C4> myCs = composesCs.getMyCs( elementToDelete );
        myCs.add( composesCs1 );
        myCs.add( composesCs2 );
        myCs.add( composesCs3 );

        List<C4> myCsOrdered = composesCsOrdered.getMyCsOrdered( elementToDelete );
        myCsOrdered.add( composesCsOrdered1 );
        myCsOrdered.add( composesCsOrdered2 );
        myCsOrdered.add( composesCsOrdered3 );

        Collection<C4> myHasCs = hasCs.getC( elementToDelete );
        myHasCs.add( hasCs1 );
        myHasCs.add( hasCs2 );
        myHasCs.add( hasCs3 );

        composesB.add( composesBValue, elementToDelete );

        final RefObjectUtil refObjectUtil = UtilitiesFactory.getRefObjectUtil( );

        EmptyAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //element must be deleted
                assertElementDeleted( elementToDelete );

                //linked elements must be existing
                assertElementExisting( oneCValue );
                assertElementExisting( manyCs1 );
                assertElementExisting( manyCs2 );
                assertElementExisting( manyCs3 );
                assertElementExisting( manyCsOrdered1 );
                assertElementExisting( manyCsOrdered2 );
                assertElementExisting( manyCsOrdered3 );
                assertElementExisting( composesCsOrdered1 );
                assertElementExisting( composesCsOrdered2 );
                assertElementExisting( composesCsOrdered3 );
                assertElementExisting( hasCs1 );
                assertElementExisting( hasCs2 );
                assertElementExisting( hasCs3 );
                assertElementExisting( composesCs1 );
                assertElementExisting( composesCs2 );
                assertElementExisting( composesCs3 );
                assertElementExisting( composesBValue );

            }

            @Override
            public void assertAfterUndo( ) {

                //element must be existing
                assertElementExisting( elementToDelete );

                assertEquals( oneCValue, elementToDelete.getOneC( ) );
                Collection<C4> manyCs = elementToDelete.getManyCs( );
                assertEquals( 3, manyCs.size( ) );
                assertTrue( manyCs.contains( manyCs1 ) );
                assertTrue( manyCs.contains( manyCs2 ) );
                assertTrue( manyCs.contains( manyCs3 ) );

                Collection<C4> manyCsOrdered = elementToDelete.getManyCsOrdered( );
                assertEquals( 3, manyCsOrdered.size( ) );
                assertTrue( manyCsOrdered.contains( manyCsOrdered1 ) );
                assertTrue( manyCsOrdered.contains( manyCsOrdered2 ) );
                assertTrue( manyCsOrdered.contains( manyCsOrdered3 ) );

                Collection<C4> myCs = composesCs.getMyCs( elementToDelete );
                assertEquals( 3, myCs.size( ) );
                myCs.contains( composesCs1 );
                myCs.contains( composesCs2 );
                myCs.contains( composesCs3 );

                List<C4> myCsOrdered = composesCsOrdered.getMyCsOrdered( elementToDelete );

                assertEquals( 3, myCsOrdered.size( ) );
                Iterator<C4> iterator = myCsOrdered.iterator( );
                assertEquals( composesCsOrdered1, myCsOrdered.get( 0 ) );
                assertEquals( composesCsOrdered1, iterator.next( ) );
                assertEquals( composesCsOrdered2, myCsOrdered.get( 1 ) );
                assertEquals( composesCsOrdered2, iterator.next( ) );
                assertEquals( composesCsOrdered3, myCsOrdered.get( 2 ) );
                assertEquals( composesCsOrdered3, iterator.next( ) );

                Collection<C4> myHasCs = hasCs.getC( elementToDelete );
                assertEquals( 3, myHasCs.size( ) );
                myHasCs.contains( hasCs1 );
                myHasCs.contains( hasCs2 );
                myHasCs.contains( hasCs3 );

                assertEquals( composesBValue, composesB.getMyB( elementToDelete ) );

            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 11, receivedEvents.size( ) );
                ElementDeleteEvent event = (ElementDeleteEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertEquals( 11, receivedEvents.size( ) );
                ElementCreateEvent event = (ElementCreateEvent) receivedEvents.get( 0 );
                assertEquals( ( (Partitionable) elementToDelete ).get___Mri( ), event.getAffectedElementMri( ) );

            }
        };

        TestCommand command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                refObjectUtil.deleteIsolated( elementToDelete );

            }
        };
        runDoUndoRedoTest( command, asserter );
    }
}
