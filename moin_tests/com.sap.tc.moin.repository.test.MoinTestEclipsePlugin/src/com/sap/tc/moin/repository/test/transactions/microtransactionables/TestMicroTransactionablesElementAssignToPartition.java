/*
 * Created on 21.01.2005
 */
package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

import com.sap.junit.MoinParameterizedRunner;
import com.sap.junit.MoinParameterizedRunner.ParametersDescription;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;
import com.sap.tc.moin.repository.transactions.Transactionable;
import com.sap.tc.moin.testcases.case006.B6;
import com.sap.tc.moin.testcases.case006.C6;
import com.sap.tc.moin.testcases.case006.Case006Package;

/**
 * Tests the explicit partitioning APIs.
 * 
 * @author d044711
 */
@RunWith( MoinParameterizedRunner.class )
@SuppressWarnings( value = "nls" )
public class TestMicroTransactionablesElementAssignToPartition extends BaseMicroTransactionablesTest {

    private final boolean paramViaModelPartition;

    public TestMicroTransactionablesElementAssignToPartition( boolean viaModelPartition ) {

        this.paramViaModelPartition = viaModelPartition;
    }

    @Parameters
    public static List<Object[]> data( ) {

        return Arrays.asList( new Object[][] { { true }, { false } } );

    }

    @ParametersDescription
    public static List<String> dataDescriptions( ) {

        return Arrays.asList( new String[] { "assign via partition", "assign via element" } );

    }

    private class ElementAssignToPartitionTestTransactionable implements Transactionable {

        private boolean viaModelPartition;

        private Partitionable elementToAssign;

        private ModelPartition partitionToAssign;

        private boolean includeChildren;

        public ElementAssignToPartitionTestTransactionable( boolean viaModelPartition, ModelPartition partitionToAssign, Partitionable elementToAssign, boolean includeChildren ) {

            this.viaModelPartition = viaModelPartition;
            this.partitionToAssign = partitionToAssign;
            this.elementToAssign = elementToAssign;
            this.includeChildren = includeChildren;
        }

        public void runInTransaction( ) {

            if ( viaModelPartition ) {
                if ( includeChildren ) {
                    partitionToAssign.assignElementIncludingChildren( elementToAssign );
                } else {
                    partitionToAssign.assignElement( elementToAssign );
                }
            } else {
                if ( includeChildren ) {
                    elementToAssign.assign___PartitionIncludingChildren( partitionToAssign );
                } else {
                    elementToAssign.assign___Partition( partitionToAssign );
                }
            }
        }

        public CoreConnection getConnection( ) {

            return coreConnection;
        }
    }

    private Partitionable a1;

    private Partitionable a2;

    private Partitionable b1;

    private Partitionable b2;

    private Partitionable b3;

    private Partitionable c1;

    private Partitionable c2;

    private Partitionable c3;

    private Partitionable c4;

    private ModelPartition partitionA;

    private ModelPartition partitionB;

    private ModelPartition partitionC;

    private Partitionable parentWithoutStorage;

    private Partitionable childWithStorage1;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        partitionA = getPartitionOne( );
        partitionB = getPartitionTwo( );
        partitionC = getPartitionThree( );

        a1 = nullPartition.createElement( MofPackage.class );
        a2 = nullPartition.createElement( MofPackage.class );
        b1 = nullPartition.createElement( MofPackage.class );
        b2 = nullPartition.createElement( MofPackage.class );
        b3 = nullPartition.createElement( MofPackage.class );
        c1 = nullPartition.createElement( MofPackage.class );
        c2 = nullPartition.createElement( MofPackage.class );
        c3 = nullPartition.createElement( MofPackage.class );
        c4 = nullPartition.createElement( MofPackage.class );

        // a1 has no parent
        // a2 has no parent and no children
        // a1 is parent of b1 and b2
        // b1 is parent of c1 and c2
        // b2 is parent of c3 and c4
        ( (MofPackage) a1 ).setName( "a1" );
        ( (MofPackage) a1 ).setContainer( null );
        assertNull( ( (MofPackage) a1 ).getContainer( ) );

        ( (MofPackage) a2 ).setName( "a2" );
        ( (MofPackage) a2 ).setContainer( null );
        assertNull( ( (MofPackage) a2 ).getContainer( ) );

        ( (MofPackage) b1 ).setName( "b1" );
        ( (MofPackage) b1 ).setContainer( (MofPackage) a1 );
        assertEquals( a1, ( (MofPackage) b1 ).getContainer( ) );

        ( (MofPackage) b2 ).setName( "b2" );
        ( (MofPackage) b2 ).setContainer( (MofPackage) a1 );
        assertEquals( a1, ( (MofPackage) b2 ).getContainer( ) );

        ( (MofPackage) b3 ).setName( "b3" );

        ( (MofPackage) c1 ).setName( "c1" );
        ( (MofPackage) c1 ).setContainer( (MofPackage) b1 );
        assertEquals( b1, ( (MofPackage) c1 ).getContainer( ) );

        ( (MofPackage) c2 ).setName( "c2" );
        ( (MofPackage) c2 ).setContainer( (MofPackage) b1 );
        assertEquals( b1, ( (MofPackage) c2 ).getContainer( ) );

        ( (MofPackage) c3 ).setName( "c3" );
        ( (MofPackage) c3 ).setContainer( (MofPackage) b2 );
        assertEquals( b2, ( (MofPackage) c3 ).getContainer( ) );

        ( (MofPackage) c4 ).setName( "c4" );
        ( (MofPackage) c4 ).setContainer( (MofPackage) b2 );
        assertEquals( b2, ( (MofPackage) c4 ).getContainer( ) );

        Case006Package case006Package = testcasesPackage.getCase006( );
        this.parentWithoutStorage = case006Package.getB6( ).refCreateInstance( );
        this.childWithStorage1 = case006Package.getC6( ).refCreateInstance( );
        ( (C6) childWithStorage1 ).setX( (B6) this.parentWithoutStorage );
        assertEquals( parentWithoutStorage, ( (C6) childWithStorage1 ).getX( ) );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.a1 = null;
        this.b1 = null;
        this.b2 = null;
        this.c1 = null;
        this.c2 = null;
        this.c3 = null;
        this.c4 = null;
        this.partitionA = null;
        this.partitionB = null;
        this.partitionC = null;
        this.nullPartition = null;
        super.afterTestMethod( );
    }

    /**
     * An element is moved across partitions. It's component children are
     * expected to always stay where they were at the beginning.
     */
    @Test
    public void testExplicitPartitionAssignmentExcludingChildren( ) throws Exception {

        // a1 has no parent
        // a1 is parent of b1 and b2
        // b1 is parent of c1 and c2
        // b2 is parent of c3 and c4

        assertCompositeParent( null, a1 );
        assertCompositeParent( a1, b1 );
        assertCompositeParent( a1, b2 );
        assertCompositeParent( b1, c1 );
        assertCompositeParent( b1, c2 );
        assertCompositeParent( b2, c3 );
        assertCompositeParent( b2, c4 );

        // assign a1 to partition A without children
        ElementAssignToPartitionTestTransactionable transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionA, a1, false );

        DoUndoRedoTestAsserter asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionA );
                assertPartitionAssignment( b1, nullPartition );
                assertPartitionAssignment( b2, nullPartition );
                assertPartitionAssignment( c1, nullPartition );
                assertPartitionAssignment( c2, nullPartition );
                assertPartitionAssignment( c3, nullPartition );
                assertPartitionAssignment( c4, nullPartition );
            }

            @Override
            public void assertAfterUndo( ) {

                // assert that all elements are null partition
                assertPartitionAssignment( a1, nullPartition );
                assertPartitionAssignment( b1, nullPartition );
                assertPartitionAssignment( b2, nullPartition );
                assertPartitionAssignment( c1, nullPartition );
                assertPartitionAssignment( c2, nullPartition );
                assertPartitionAssignment( c3, nullPartition );
                assertPartitionAssignment( c4, nullPartition );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 1, receivedEvents.size( ) );
                assertPartitionMembershipChangeEvent( receivedEvents.get( 0 ), a1.refMofId( ), nullPartition.getPri( ), partitionA.getPri( ) );
                this.receivedEventsAfterDo = receivedEvents;
            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertUndoPartitionMembershipChangeEvents( receivedEventsAfterDo, receivedEvents );
            }

        };
        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );

        // -----------------------------------------------------------------------------------------

        // assign a1 to partition B without children
        transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionB, a1, false );

        asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( b1, nullPartition );
                assertPartitionAssignment( b2, nullPartition );
                assertPartitionAssignment( c1, nullPartition );
                assertPartitionAssignment( c2, nullPartition );
                assertPartitionAssignment( c3, nullPartition );
                assertPartitionAssignment( c4, nullPartition );

            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionA );
                assertPartitionAssignment( b1, nullPartition );
                assertPartitionAssignment( b2, nullPartition );
                assertPartitionAssignment( c1, nullPartition );
                assertPartitionAssignment( c2, nullPartition );
                assertPartitionAssignment( c3, nullPartition );
                assertPartitionAssignment( c4, nullPartition );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 1, receivedEvents.size( ) );
                assertPartitionMembershipChangeEvent( receivedEvents.get( 0 ), a1.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                this.receivedEventsAfterDo = receivedEvents;

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertUndoPartitionMembershipChangeEvents( receivedEventsAfterDo, receivedEvents );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );

        // -----------------------------------------------------------------------------------------

        // assign a1 to partition A without children
        transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionA, a1, false );

        asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionA );
                assertPartitionAssignment( b1, nullPartition );
                assertPartitionAssignment( b2, nullPartition );
                assertPartitionAssignment( c1, nullPartition );
                assertPartitionAssignment( c2, nullPartition );
                assertPartitionAssignment( c3, nullPartition );
                assertPartitionAssignment( c4, nullPartition );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( b1, nullPartition );
                assertPartitionAssignment( b2, nullPartition );
                assertPartitionAssignment( c1, nullPartition );
                assertPartitionAssignment( c2, nullPartition );
                assertPartitionAssignment( c3, nullPartition );
                assertPartitionAssignment( c4, nullPartition );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 1, receivedEvents.size( ) );
                assertPartitionMembershipChangeEvent( receivedEvents.get( 0 ), a1.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );
                this.receivedEventsAfterDo = receivedEvents;

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertUndoPartitionMembershipChangeEvents( receivedEventsAfterDo, receivedEvents );
            }
        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );

        // -----------------------------------------------------------------------------------------

        // assign a1 to partition B without children
        transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionB, a1, false );

        asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( b1, nullPartition );
                assertPartitionAssignment( b2, nullPartition );
                assertPartitionAssignment( c1, nullPartition );
                assertPartitionAssignment( c2, nullPartition );
                assertPartitionAssignment( c3, nullPartition );
                assertPartitionAssignment( c4, nullPartition );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionA );
                assertPartitionAssignment( b1, nullPartition );
                assertPartitionAssignment( b2, nullPartition );
                assertPartitionAssignment( c1, nullPartition );
                assertPartitionAssignment( c2, nullPartition );
                assertPartitionAssignment( c3, nullPartition );
                assertPartitionAssignment( c4, nullPartition );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 1, receivedEvents.size( ) );
                assertPartitionMembershipChangeEvent( receivedEvents.get( 0 ), a1.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                this.receivedEventsAfterDo = receivedEvents;

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertUndoPartitionMembershipChangeEvents( receivedEventsAfterDo, receivedEvents );
            }
        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );
    }

    /**
     * An element is moved from partition A to partition B. It's component
     * children (which are also in A) are expected to come along to partition B.
     * Transitive component children are expected to come along as long as they
     * are not assigned to some different partition (includes transient
     * partition).
     */
    @Test
    public void testExplicitPartitionAssignmentIncludingChildren( ) throws Exception {

        // a1 has no parent
        // a1 is parent of b1 and b2
        // b1 is parent of c1 and c2
        // b2 is parent of c3 and c4

        assertCompositeParent( null, a1 );
        assertCompositeParent( a1, b1 );
        assertCompositeParent( a1, b2 );
        assertCompositeParent( b1, c1 );
        assertCompositeParent( b1, c2 );
        assertCompositeParent( b2, c3 );
        assertCompositeParent( b2, c4 );

        assertPartitionAssignment( a1, nullPartition );
        assertPartitionAssignment( b1, nullPartition );
        assertPartitionAssignment( b2, nullPartition );
        assertPartitionAssignment( c1, nullPartition );
        assertPartitionAssignment( c2, nullPartition );
        assertPartitionAssignment( c3, nullPartition );
        assertPartitionAssignment( c4, nullPartition );

        // ------------------------------------------------------------------------------
        ElementAssignToPartitionTestTransactionable transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionA, a1, true );

        DoUndoRedoTestAsserter asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionA );
                assertPartitionAssignment( b1, partitionA );
                assertPartitionAssignment( b2, partitionA );
                assertPartitionAssignment( c1, partitionA );
                assertPartitionAssignment( c2, partitionA );
                assertPartitionAssignment( c3, partitionA );
                assertPartitionAssignment( c4, partitionA );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, nullPartition );
                assertPartitionAssignment( b1, nullPartition );
                assertPartitionAssignment( b2, nullPartition );
                assertPartitionAssignment( c1, nullPartition );
                assertPartitionAssignment( c2, nullPartition );
                assertPartitionAssignment( c3, nullPartition );
                assertPartitionAssignment( c4, nullPartition );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 7, receivedEvents.size( ) );
                assertPartitionMembershipChangeEvent( receivedEvents.get( 0 ), a1.refMofId( ), nullPartition.getPri( ), partitionA.getPri( ) );
                List<? extends ChangeEvent> remainingEvents = assertPartitionMembershipChangeEvent( receivedEvents, b1.refMofId( ), nullPartition.getPri( ), partitionA.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, b2.refMofId( ), nullPartition.getPri( ), partitionA.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c1.refMofId( ), nullPartition.getPri( ), partitionA.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c2.refMofId( ), nullPartition.getPri( ), partitionA.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c3.refMofId( ), nullPartition.getPri( ), partitionA.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c4.refMofId( ), nullPartition.getPri( ), partitionA.getPri( ) );
                this.receivedEventsAfterDo = receivedEvents;
            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertUndoPartitionMembershipChangeEvents( receivedEventsAfterDo, receivedEvents );
            }
        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );

        // ---------------------------------------------------------------------------------------------

        transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionB, a1, true );

        asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( b1, partitionB );
                assertPartitionAssignment( b2, partitionB );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
                assertPartitionAssignment( c3, partitionB );
                assertPartitionAssignment( c4, partitionB );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionA );
                assertPartitionAssignment( b1, partitionA );
                assertPartitionAssignment( b2, partitionA );
                assertPartitionAssignment( c1, partitionA );
                assertPartitionAssignment( c2, partitionA );
                assertPartitionAssignment( c3, partitionA );
                assertPartitionAssignment( c4, partitionA );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 7, receivedEvents.size( ) );
                assertPartitionMembershipChangeEvent( receivedEvents.get( 0 ), a1.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                List<? extends ChangeEvent> remainingEvents = assertPartitionMembershipChangeEvent( receivedEvents, b1.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, b2.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c1.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c2.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c3.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c4.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                this.receivedEventsAfterDo = receivedEvents;

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertUndoPartitionMembershipChangeEvents( receivedEventsAfterDo, receivedEvents );
            }
        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );

        // ---------------------------------------------------------------------------------------------

        transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionA, a1, true );

        asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionA );
                assertPartitionAssignment( b1, partitionA );
                assertPartitionAssignment( b2, partitionA );
                assertPartitionAssignment( c1, partitionA );
                assertPartitionAssignment( c2, partitionA );
                assertPartitionAssignment( c3, partitionA );
                assertPartitionAssignment( c4, partitionA );

            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( b1, partitionB );
                assertPartitionAssignment( b2, partitionB );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
                assertPartitionAssignment( c3, partitionB );
                assertPartitionAssignment( c4, partitionB );

            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 7, receivedEvents.size( ) );
                assertPartitionMembershipChangeEvent( receivedEvents.get( 0 ), a1.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );
                List<? extends ChangeEvent> remainingEvents = assertPartitionMembershipChangeEvent( receivedEvents, b1.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, b2.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c1.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c2.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c3.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c4.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );
                this.receivedEventsAfterDo = receivedEvents;

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertUndoPartitionMembershipChangeEvents( receivedEventsAfterDo, receivedEvents );

            }
        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );

        // ---------------------------------------------------------------------------------------------

        transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionB, a1, true );

        asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( b1, partitionB );
                assertPartitionAssignment( b2, partitionB );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
                assertPartitionAssignment( c3, partitionB );
                assertPartitionAssignment( c4, partitionB );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionA );
                assertPartitionAssignment( b1, partitionA );
                assertPartitionAssignment( b2, partitionA );
                assertPartitionAssignment( c1, partitionA );
                assertPartitionAssignment( c2, partitionA );
                assertPartitionAssignment( c3, partitionA );
                assertPartitionAssignment( c4, partitionA );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 7, receivedEvents.size( ) );
                assertPartitionMembershipChangeEvent( receivedEvents.get( 0 ), a1.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                List<? extends ChangeEvent> remainingEvents = assertPartitionMembershipChangeEvent( receivedEvents, b1.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, b2.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c1.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c2.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c3.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c4.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                this.receivedEventsAfterDo = receivedEvents;

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertUndoPartitionMembershipChangeEvents( receivedEventsAfterDo, receivedEvents );

            }
        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );

        // ---------------------------------------------------------------------------------------------

        transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionC, b1, false );

        asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( b1, partitionC );
                assertPartitionAssignment( b2, partitionB );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
                assertPartitionAssignment( c3, partitionB );
                assertPartitionAssignment( c4, partitionB );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( b1, partitionB );
                assertPartitionAssignment( b2, partitionB );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
                assertPartitionAssignment( c3, partitionB );
                assertPartitionAssignment( c4, partitionB );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 1, receivedEvents.size( ) );
                assertPartitionMembershipChangeEvent( receivedEvents.get( 0 ), b1.refMofId( ), partitionB.getPri( ), partitionC.getPri( ) );
                this.receivedEventsAfterDo = receivedEvents;
            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertUndoPartitionMembershipChangeEvents( receivedEventsAfterDo, receivedEvents );

            }
        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );

        // ---------------------------------------------------------------------------------------------

        transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionA, a1, true );

        asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionA );
                assertPartitionAssignment( b1, partitionC );
                assertPartitionAssignment( b2, partitionA );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
                assertPartitionAssignment( c3, partitionA );
                assertPartitionAssignment( c4, partitionA );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( b1, partitionC );
                assertPartitionAssignment( b2, partitionB );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
                assertPartitionAssignment( c3, partitionB );
                assertPartitionAssignment( c4, partitionB );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 4, receivedEvents.size( ) );
                assertPartitionMembershipChangeEvent( receivedEvents.get( 0 ), a1.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );
                List<? extends ChangeEvent> remainingEvents = assertPartitionMembershipChangeEvent( receivedEvents, b2.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c3.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c4.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );

                this.receivedEventsAfterDo = receivedEvents;

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertUndoPartitionMembershipChangeEvents( receivedEventsAfterDo, receivedEvents );
            }
        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );

        // ---------------------------------------------------------------------------------------------

        transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionB, a1, true );

        asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( b1, partitionC );
                assertPartitionAssignment( b2, partitionB );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
                assertPartitionAssignment( c3, partitionB );
                assertPartitionAssignment( c4, partitionB );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionA );
                assertPartitionAssignment( b1, partitionC );
                assertPartitionAssignment( b2, partitionA );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
                assertPartitionAssignment( c3, partitionA );
                assertPartitionAssignment( c4, partitionA );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 4, receivedEvents.size( ) );
                assertPartitionMembershipChangeEvent( receivedEvents.get( 0 ), a1.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                List<? extends ChangeEvent> remainingEvents = assertPartitionMembershipChangeEvent( receivedEvents, b2.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c3.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );
                remainingEvents = assertPartitionMembershipChangeEvent( remainingEvents, c4.refMofId( ), partitionA.getPri( ), partitionB.getPri( ) );

                this.receivedEventsAfterDo = receivedEvents;

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertUndoPartitionMembershipChangeEvents( receivedEventsAfterDo, receivedEvents );
            }
        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );

        // ---------------------------------------------------------------------------------------------

        transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionA, b2, false );

        asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( b1, partitionC );
                assertPartitionAssignment( b2, partitionA );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
                assertPartitionAssignment( c3, partitionB );
                assertPartitionAssignment( c4, partitionB );

            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( b1, partitionC );
                assertPartitionAssignment( b2, partitionB );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
                assertPartitionAssignment( c3, partitionB );
                assertPartitionAssignment( c4, partitionB );

            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 1, receivedEvents.size( ) );
                assertPartitionMembershipChangeEvent( receivedEvents.get( 0 ), b2.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );
                this.receivedEventsAfterDo = receivedEvents;

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertUndoPartitionMembershipChangeEvents( receivedEventsAfterDo, receivedEvents );
            }
        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );

        // ---------------------------------------------------------------------------------------------

        transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionA, a1, true );

        asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionA );
                assertPartitionAssignment( b1, partitionC );
                assertPartitionAssignment( b2, partitionA );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
                assertPartitionAssignment( c3, partitionB );
                assertPartitionAssignment( c4, partitionB );

            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( b1, partitionC );
                assertPartitionAssignment( b2, partitionA );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
                assertPartitionAssignment( c3, partitionB );
                assertPartitionAssignment( c4, partitionB );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( 1, receivedEvents.size( ) );
                assertPartitionMembershipChangeEvent( receivedEvents.get( 0 ), a1.refMofId( ), partitionB.getPri( ), partitionA.getPri( ) );
                this.receivedEventsAfterDo = receivedEvents;

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertUndoPartitionMembershipChangeEvents( receivedEventsAfterDo, receivedEvents );
            }
        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );

        // ---------------------------------------------------------------------------------------------

        assertPartitionAssignment( parentWithoutStorage, nullPartition );
        assertPartitionAssignment( childWithStorage1, nullPartition );
        assertCompositeParent( parentWithoutStorage, childWithStorage1 );

        transactionable = new ElementAssignToPartitionTestTransactionable( this.paramViaModelPartition, partitionA, parentWithoutStorage, true );

        asserter = new EnhancedDoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( parentWithoutStorage, partitionA );
                assertPartitionAssignment( childWithStorage1, partitionA );

            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( parentWithoutStorage, nullPartition );
                assertPartitionAssignment( childWithStorage1, nullPartition );

            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

            }
        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), transactionable, asserter );

    }

    private static void assertPartitionAssignment( Partitionable element, ModelPartition partition ) {

        assertEquals( partition, element.get___Partition( ) );
    }

    private void assertCompositeParent( Partitionable parent, Partitionable child ) throws Exception {

        CorePartitionable coreChild = getTestHelper( ).getCorePartitionable( child );
        EndStorageLink compositeParentLink = coreChild.get___Workspace( ).getWorkspaceSet( ).getLogicalLinkManager( ).getCompositeParentLink( coreConnection.getSession( ), coreChild );

        if ( parent == null ) {
            assertNull( compositeParentLink );
            return;
        }

        int componentEnd = compositeParentLink.getComponentEnd( );
        int compositeEnd = compositeParentLink.getCompositeEnd( );

        MoinReference component = compositeParentLink.getEnd( componentEnd );
        MoinReference composite = compositeParentLink.getEnd( compositeEnd );

        assertEquals( getTestHelper( ).getCorePartitionable( child ), component.get( coreConnection.getSession( ) ) );
        assertEquals( getTestHelper( ).getCorePartitionable( parent ), composite.get( coreConnection.getSession( ) ) );

    }

    private static void assertPartitionMembershipChangeEvent( ChangeEvent event, String mofId, PRI oldPartition, PRI newPartition ) {

        MRI newMri = newPartition.createMri( mofId );
        MRI oldMri = oldPartition.createMri( mofId );
        PartitionMembershipChangeEvent partitionMembershipChangeEvent = (PartitionMembershipChangeEvent) event;
        assertEquals( newMri, partitionMembershipChangeEvent.getAffectedElementNewMri( ) );
        assertEquals( oldMri, partitionMembershipChangeEvent.getAffectedElementOldMri( ) );
        assertEquals( newPartition, partitionMembershipChangeEvent.getNewPartitionPri( ) );
        assertEquals( oldPartition, partitionMembershipChangeEvent.getOldPartitionPri( ) );
    }

    /**
     * The events on undo are the "reversed" events which were received on do.
     * 
     * @param eventsReceivedOnDo the events which were received during do.
     * @param eventsReceivedOnUndo the events which were received during undo.
     */
    private static void assertUndoPartitionMembershipChangeEvents( List<? extends ChangeEvent> eventsReceivedOnDo, List<? extends ChangeEvent> eventsReceivedOnUndo ) {

        assertSame( "Expected same number of events", eventsReceivedOnDo.size( ), eventsReceivedOnUndo.size( ) );
        int size = eventsReceivedOnUndo.size( );
        for ( int i = 0; i < size; i++ ) {
            PartitionMembershipChangeEvent partitionMembershipChangeEvent = (PartitionMembershipChangeEvent) eventsReceivedOnDo.get( size - 1 - i );
            String mofId = partitionMembershipChangeEvent.getAffectedElementNewMri( ).getMofId( );
            PRI oldPartition = partitionMembershipChangeEvent.getNewPartitionPri( );
            PRI newPartition = partitionMembershipChangeEvent.getOldPartitionPri( );
            assertPartitionMembershipChangeEvent( eventsReceivedOnUndo.get( i ), mofId, oldPartition, newPartition );
        }
    }

    /**
     * As the order of events for repartitioning "includingChildren" cannot be
     * predetermined, a collection of events must be analysed in order to find a
     * specificly expected single event. If it is found, a copy of the passed in
     * collection minus the found event is returned. If the expected event is
     * not found, an assertion error is thrown.
     * 
     * @param events the events were the expected one must be included.
     * @param mofId the mof id of the affected element.
     * @param oldPartition the old partition of the affected element.
     * @param newPartition the new partition of the affected element.
     * @return a copy of the specified collection of events minus the expected
     * event.
     */
    private static List<? extends ChangeEvent> assertPartitionMembershipChangeEvent( List<? extends ChangeEvent> events, String mofId, PRI oldPartition, PRI newPartition ) {

        List<? extends ChangeEvent> result = new ArrayList<ChangeEvent>( events );
        boolean found = false;
        MRI newMri = newPartition.createMri( mofId );
        MRI oldMri = oldPartition.createMri( mofId );

        Iterator<? extends ChangeEvent> eventsIterator = result.iterator( );
        while ( eventsIterator.hasNext( ) ) {
            ChangeEvent event = eventsIterator.next( );
            if ( event instanceof PartitionMembershipChangeEvent ) {
                PartitionMembershipChangeEvent partitionMembershipChangeEvent = (PartitionMembershipChangeEvent) event;
                if ( newMri.equals( partitionMembershipChangeEvent.getAffectedElementNewMri( ) ) ) {
                    if ( oldMri.equals( partitionMembershipChangeEvent.getAffectedElementOldMri( ) ) ) {
                        if ( newPartition.equals( partitionMembershipChangeEvent.getNewPartitionPri( ) ) ) {
                            if ( oldPartition.equals( partitionMembershipChangeEvent.getOldPartitionPri( ) ) ) {
                                found = true;
                                eventsIterator.remove( );
                            }
                        }

                    }
                }
            }
        }

        assertTrue( "Didn't get expected event", found );

        return result;
    }

    private abstract static class EnhancedDoUndoRedoTestAsserter extends EmptyAsserter {

        protected List<? extends ChangeEvent> receivedEventsAfterDo = null;
    }

}
