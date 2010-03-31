/*
 * Created on 21.01.2005
 */
package com.sap.tc.moin.repository.test.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.junit.Staged;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.IllegalRelocateToDataAreaException;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.UnresolvableException;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcases.TestcasesPackage;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case004.B4;
import com.sap.tc.moin.testcases.case004.Case004Package;
import com.sap.tc.moin.testcases.case004.F4;
import com.sap.tc.moin.testcases.case005.Case005Package;
import com.sap.tc.moin.testcases.case005.p1.A5;
import com.sap.tc.moin.testcases.case005.p1.p2.B5;
import com.sap.tc.moin.testcases.case006.B6;
import com.sap.tc.moin.testcases.case006.C6;
import com.sap.tc.moin.testcases.case006.Case006Package;
import com.sap.tc.moin.testcases.case006.D6;

/**
 * Tests the explicit partitioning APIs as well as the implicit partitioning
 * behaviour which occurs when a composite link between two elements is
 * established and one element is in a real partition and the other element is
 * in a transient partition. In this case, the element in the transient
 * partition is automatically moved to the partition of its new parent.
 * 
 * @author d044711
 */
public class TestPartitionAssignment extends CoreMoinTest {

    TestcasesPackage testcasesPackage = null;

    private Partitionable motherOfAllTestElements;

    private Partitionable a1;

    private Partitionable a2;

    private Partitionable b1;

    private Partitionable b2;

    private Partitionable b3;

    private Partitionable c1;

    private Partitionable c2;

    private Partitionable c3;

    private Partitionable c4;

    private Partitionable c004F4;

    private Partitionable c004B4;

    private ModelPartition partitionA;

    private ModelPartition partitionB;

    private ModelPartition partitionC;

    private ModelPartition nullPartition;

    private Partitionable parentWithoutStorage;

    private Partitionable childWithStorage1;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        partitionA = getPartitionOne( );
        partitionB = getPartitionTwo( );
        partitionC = getPartitionThree( );
        nullPartition = getMOINConnection( ).getNullPartition( );

        a1 = (Partitionable) nullPartition.createElement( MofPackage.class );
        a2 = (Partitionable) nullPartition.createElement( MofPackage.class );
        b1 = (Partitionable) nullPartition.createElement( MofPackage.class );
        b2 = (Partitionable) nullPartition.createElement( MofPackage.class );
        b3 = (Partitionable) nullPartition.createElement( MofPackage.class );
        c1 = (Partitionable) nullPartition.createElement( MofPackage.class );
        c2 = (Partitionable) nullPartition.createElement( MofPackage.class );
        c3 = (Partitionable) nullPartition.createElement( MofPackage.class );
        c4 = (Partitionable) nullPartition.createElement( MofPackage.class );
        motherOfAllTestElements = (Partitionable) nullPartition.createElement( MofPackage.class );

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

        testcasesPackage = (TestcasesPackage) getMOINConnection( ).getPackage( TestMetaModels.TESTCASES_CN, TestMetaModels.TESTCASES_TPE );
        Case006Package case006Package = testcasesPackage.getCase006( );
        Case004Package case004Package = testcasesPackage.getCase004( );
        c004F4 = (Partitionable) getMOINConnection( ).createElementInPartition( F4.class, null );
        c004B4 = (Partitionable) getMOINConnection( ).createElementInPartition( B4.class, null );
        this.parentWithoutStorage = (Partitionable) getMOINConnection( ).createElementInPartition( B6.class, null );
        this.childWithStorage1 = (Partitionable) getMOINConnection( ).createElementInPartition( C6.class, null );

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

        this.motherOfAllTestElements = null;
        this.partitionA = null;
        this.partitionB = null;
        this.partitionC = null;
        this.nullPartition = null;

        this.childWithStorage1 = null;
        this.parentWithoutStorage = null;

        super.afterTestMethod( );
    }

    /**
     * A composite link between two elements (which both reside in different
     * real partitions) is established. The elements are expected to stay where
     * they were before.
     */
    @Test
    public void testNoImplicitPartitionAssignmentOnCreatingCompositeLink( ) throws Exception {

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

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                partitionA.assignElementIncludingChildren( a1 );
                // establish a new composite parent for a1 which is in
                // nullPartition -> as children are also in nullPartition, they
                // have to come along
                motherOfAllTestElements.assign___Partition( partitionC );
                ( (MofPackage) a1 ).setContainer( (MofPackage) motherOfAllTestElements );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertCompositeParent( null, motherOfAllTestElements );
                assertPartitionAssignment( motherOfAllTestElements, partitionC );

                assertCompositeParent( motherOfAllTestElements, a1 );

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
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );
    }

    /**
     * A composite link between two elements (where the new parent resides in a
     * real partition whereas the child resides in the transient partition) is
     * established. It is expected, that the child element (including further
     * transitive children which are in the transient partition) will be
     * assigned to the partition of its new parent.
     */
    @Test
    public void testImplicitPartitionAssignmentOnCreatingCompositeLink( ) throws Exception {

        // a1 has no parent
        // a1 is parent of b1 and b2
        // b1 is parent of c1 and c2
        // b2 is parent of c3 and c4
        // c004F4 has no parent and is in partition A
        // c004B4 has no parent

        c004F4.assign___Partition( partitionA );

        assertCompositeParent( null, a1 );
        assertCompositeParent( a1, b1 );
        assertCompositeParent( a1, b2 );
        assertCompositeParent( b1, c1 );
        assertCompositeParent( b1, c2 );
        assertCompositeParent( b2, c3 );
        assertCompositeParent( b2, c4 );
        assertCompositeParent( null, c004F4 );
        assertCompositeParent( null, c004B4 );

        assertPartitionAssignment( a1, nullPartition );
        assertPartitionAssignment( b1, nullPartition );
        assertPartitionAssignment( b2, nullPartition );
        assertPartitionAssignment( c1, nullPartition );
        assertPartitionAssignment( c2, nullPartition );
        assertPartitionAssignment( c3, nullPartition );
        assertPartitionAssignment( c4, nullPartition );
        assertPartitionAssignment( c004F4, partitionA );
        assertPartitionAssignment( c004B4, nullPartition );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // establish a new composite parent for a1 which is in
                // partitionA -> as children are in a transient partition,
                // they have to come along
                motherOfAllTestElements.assign___Partition( partitionA );
                ( (MofPackage) a1 ).setContainer( (MofPackage) motherOfAllTestElements );

            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertCompositeParent( null, motherOfAllTestElements );
                assertPartitionAssignment( motherOfAllTestElements, partitionA );
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

                assertCompositeParent( null, a1 );
                assertCompositeParent( a1, b1 );
                assertCompositeParent( a1, b2 );
                assertCompositeParent( b1, c1 );
                assertCompositeParent( b1, c2 );
                assertCompositeParent( b2, c3 );
                assertCompositeParent( b2, c4 );
                assertCompositeParent( null, c004F4 );
                assertCompositeParent( null, c004B4 );

                assertPartitionAssignment( a1, nullPartition );
                assertPartitionAssignment( b1, nullPartition );
                assertPartitionAssignment( b2, nullPartition );
                assertPartitionAssignment( c1, nullPartition );
                assertPartitionAssignment( c2, nullPartition );
                assertPartitionAssignment( c3, nullPartition );
                assertPartitionAssignment( c4, nullPartition );
                assertPartitionAssignment( c004F4, partitionA );
                assertPartitionAssignment( c004B4, nullPartition );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

        // -----------------next test-----------------------------

        assertPartitionAssignment( c004F4, partitionA );
        assertPartitionAssignment( c004B4, nullPartition );

        command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // establish a new composite link between c004F4 and c004B4 ->
                // as c004B4
                // was in the null partition,
                // it has to come along
                testcasesPackage.getCase004( ).getComposesB( ).add( (B4) c004B4, (F4) c004F4 );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( c004F4, partitionA );
                assertPartitionAssignment( c004B4, partitionA );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( c004F4, partitionA );
                assertPartitionAssignment( c004B4, nullPartition );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );
    }

    @Test
    public void testImplicitPartitionAssignmentOnDeletingCompositeLink( ) throws Exception {

        partitionA.assignElementIncludingChildren( a1 );
        assertPartitionAssignment( a1, partitionA );
        assertPartitionAssignment( b1, partitionA );
        assertPartitionAssignment( b2, partitionA );
        assertPartitionAssignment( c1, partitionA );
        assertPartitionAssignment( c2, partitionA );
        assertPartitionAssignment( c3, partitionA );
        assertPartitionAssignment( c4, partitionA );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // delete the composite link between a1 and b1
                ( (MofPackage) b1 ).setContainer( null );
                assertCompositeParent( null, b1 );

            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // now b1 and its children (c1,c2) should have gone back to the
                // null partition
                assertPartitionAssignment( a1, partitionA );
                assertPartitionAssignment( b1, nullPartition );
                assertPartitionAssignment( b2, partitionA );
                assertPartitionAssignment( c1, nullPartition );
                assertPartitionAssignment( c2, nullPartition );
                assertPartitionAssignment( c3, partitionA );
                assertPartitionAssignment( c4, partitionA );
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

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

    }

    @Test
    public void testImplicitPartitionAssignmentOnChangingCompositeLink( ) throws Exception {

        partitionB.assignElementIncludingChildren( a2 );
        assertPartitionAssignment( a1, nullPartition );
        assertPartitionAssignment( a2, partitionB );
        assertPartitionAssignment( b1, nullPartition );
        assertPartitionAssignment( c1, nullPartition );
        assertPartitionAssignment( c2, nullPartition );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // change the composite link of b1 to a2
                ( (MofPackage) b1 ).setContainer( (MofPackage) a2 );
                assertCompositeParent( a2, b1 );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // b1 and its children (c1,c2) should go to partition B because
                // they were in the null partition before
                assertPartitionAssignment( a1, nullPartition );
                assertPartitionAssignment( a2, partitionB );
                assertPartitionAssignment( b1, partitionB );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, nullPartition );
                assertPartitionAssignment( a2, partitionB );
                assertPartitionAssignment( b1, nullPartition );
                assertPartitionAssignment( c1, nullPartition );
                assertPartitionAssignment( c2, nullPartition );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

    }

    @Test
    public void testImplicitPartitionAssignmentOnChangingCompositeLinkTwoStep( ) throws Exception {

        partitionB.assignElementIncludingChildren( a2 );
        assertPartitionAssignment( a1, nullPartition );
        assertPartitionAssignment( a2, partitionB );
        assertPartitionAssignment( b1, nullPartition );
        assertPartitionAssignment( c1, nullPartition );
        assertPartitionAssignment( c2, nullPartition );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // change the composite link of b1 to a2
                ( (MofPackage) b1 ).setContainer( null );
                ( (MofPackage) b1 ).setContainer( (MofPackage) a2 );
                assertCompositeParent( a2, b1 );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // b1 and its children (c1,c2) should go to partition B because
                // they were in the null partition before
                assertPartitionAssignment( a1, nullPartition );
                assertPartitionAssignment( a2, partitionB );
                assertPartitionAssignment( b1, partitionB );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, nullPartition );
                assertPartitionAssignment( a2, partitionB );
                assertPartitionAssignment( b1, nullPartition );
                assertPartitionAssignment( c1, nullPartition );
                assertPartitionAssignment( c2, nullPartition );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

    }

    @Test
    public void testImplicitPartitionAssignmentOnChangingCompositeLinkBetweenTwoRealPartitions( ) throws Exception {

        partitionA.assignElementIncludingChildren( a2 );
        partitionB.assignElementIncludingChildren( a1 );
        assertPartitionAssignment( a2, partitionA );
        assertPartitionAssignment( a1, partitionB );
        assertPartitionAssignment( b1, partitionB );
        assertPartitionAssignment( c1, partitionB );
        assertPartitionAssignment( c2, partitionB );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // change the composite link of b1 to a2
                ( (MofPackage) b1 ).setContainer( (MofPackage) a2 );
                assertCompositeParent( a2, b1 );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {


                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( a2, partitionA );
                assertPartitionAssignment( b1, partitionA );
                assertPartitionAssignment( c1, partitionA );
                assertPartitionAssignment( c2, partitionA );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( a2, partitionA );
                assertPartitionAssignment( b1, partitionB );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

    }

    @Test
    @Staged
    //FIXME: partition magic: enable once it is fixed. Until then, it is supposed to fail and to be a pain in the ass as constant reminder that this issue must be fixed!
    public void testAssociationGoingBackToNullPartitionOnLosingParentInSamePartition( ) throws Exception {

        final C6 parent = getMOINConnection( ).createElement( C6.class );
        final D6 childOld = getMOINConnection( ).createElement( D6.class );
        final D6 childNew = getMOINConnection( ).createElement( D6.class );

        //that's the precondition, "magic" only happens if storage is at parent
        Reference reference = getMOINConnection( ).getJmiHelper( ).getReferenceByName( (MofClass) parent.refMetaObject( ), "W", true );
        assertTrue( getMOINConnection( ).getJmiHelper( ).isEndStored( reference.getExposedEnd( ) ) );

        parent.setW( childOld );
        parent.assign___Partition( getPartitionOne( ) );
        childOld.assign___Partition( getPartitionOne( ) );
        assertEquals( getMOINConnection( ).getNullPartition( ), childNew.get___Partition( ) );

        Command command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                parent.setW( childNew );

            }
        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertEquals( childNew, parent.getW( ) );
                assertEquals( null, childOld.refImmediateComposite( ) );
                assertEquals( getPartitionOne( ), childNew.get___Partition( ) );

                //oldChild must now be in the NullPartition
                assertEquals( getMOINConnection( ).getNullPartition( ), childOld.get___Partition( ) );

            }

            @Override
            public void assertAfterUndo( ) {

                assertEquals( childOld, parent.getW( ) );
                assertEquals( null, childNew.refImmediateComposite( ) );
                assertEquals( getMOINConnection( ).getNullPartition( ), childNew.get___Partition( ) );

                assertEquals( getPartitionOne( ), childOld.get___Partition( ) );

            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );
    }

    @Test
    public void testAttributeGoingBackToNullPartitionOnLosingParentInSamePartition( ) throws Exception {

        final A4 parent = getMOINConnection( ).createElement( A4.class );

        final B4 childOld = getMOINConnection( ).createElement( B4.class );
        final B4 childNew = getMOINConnection( ).createElement( B4.class );

        parent.setOneBchangeable( childOld );
        parent.assign___Partition( getPartitionOne( ) );
        childOld.assign___Partition( getPartitionOne( ) );
        assertEquals( getMOINConnection( ).getNullPartition( ), childNew.get___Partition( ) );

        Command command = new TestCommand( getMOINConnection( ) ) {

            @Override
            public void doExecute( ) {

                parent.setOneBchangeable( childNew );

            }
        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertEquals( childNew, parent.getOneBchangeable( ) );
                assertEquals( null, childOld.refImmediateComposite( ) );
                assertEquals( getPartitionOne( ), childNew.get___Partition( ) );

                //oldChild must now be in the NullPartition
                assertEquals( getMOINConnection( ).getNullPartition( ), childOld.get___Partition( ) );

            }

            @Override
            public void assertAfterUndo( ) {

                assertEquals( childOld, parent.getOneBchangeable( ) );
                assertEquals( null, childNew.refImmediateComposite( ) );
                assertEquals( getMOINConnection( ).getNullPartition( ), childNew.get___Partition( ) );

                assertEquals( getPartitionOne( ), childOld.get___Partition( ) );

            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );


    }


    @Test
    public void testImplicitPartitionAssignmentOnChangingCompositeLinkBetweenTwoRealPartitionsTwoStep( ) throws Exception {

        partitionA.assignElementIncludingChildren( a2 );
        partitionB.assignElementIncludingChildren( a1 );
        assertPartitionAssignment( a2, partitionA );
        assertPartitionAssignment( a1, partitionB );
        assertPartitionAssignment( b1, partitionB );
        assertPartitionAssignment( c1, partitionB );
        assertPartitionAssignment( c2, partitionB );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // change the composite link of b1 to a2
                ( (MofPackage) b1 ).setContainer( null );
                ( (MofPackage) b1 ).setContainer( (MofPackage) a2 );
                assertCompositeParent( a2, b1 );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // b1 and its children (c1,c2) should go to partition B because
                // they were in the null partition before
                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( a2, partitionA );
                assertPartitionAssignment( b1, partitionA );
                assertPartitionAssignment( c1, partitionA );
                assertPartitionAssignment( c2, partitionA );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionB );
                assertPartitionAssignment( a2, partitionA );
                assertPartitionAssignment( b1, partitionB );
                assertPartitionAssignment( c1, partitionB );
                assertPartitionAssignment( c2, partitionB );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

    }

    @Test
    public void testImplicitPartitionAssignmentOnChangingCompositeAttributeLinkBetweenTwoRealPartitions1( ) throws Exception {

        final A4 a4 = partitionA.createElement( A4.class );
        final B4 b4 = partitionB.createElement( B4.class );
        final B4 b4_nullPartition = getMOINConnection( ).createElementInPartition( B4.class, null );
        a4.setOneBoptional( b4 );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                a4.setOneBoptional( b4_nullPartition );

            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a4, partitionA );
                assertPartitionAssignment( b4, partitionB );
                assertPartitionAssignment( b4_nullPartition, partitionA );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a4, partitionA );
                assertPartitionAssignment( b4, partitionB );
                assertPartitionAssignment( b4_nullPartition, getMOINConnection( ).getNullPartition( ) );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

    }

    @Test
    public void testImplicitPartitionAssignmentOnChangingCompositeAttributeLinkBetweenTwoRealPartitions2( ) throws Exception {

        final A4 a4 = partitionA.createElement( A4.class );
        final B4 b4 = partitionA.createElement( B4.class );
        final B4 b4_nullPartition = getMOINConnection( ).createElementInPartition( B4.class, null );
        a4.setOneBoptional( b4 );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                a4.setOneBoptional( b4_nullPartition );

            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a4, partitionA );
                assertPartitionAssignment( b4, getMOINConnection( ).getNullPartition( ) );
                assertPartitionAssignment( b4_nullPartition, partitionA );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a4, partitionA );
                assertPartitionAssignment( b4, partitionA );
                assertPartitionAssignment( b4_nullPartition, getMOINConnection( ).getNullPartition( ) );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

    }

    @Test
    public void testNoImplicitPartitionAssignmentOnChangingCompositeLink( ) throws Exception {

        partitionA.assignElementIncludingChildren( a1 );
        partitionB.assignElementIncludingChildren( a2 );
        partitionC.assignElement( a1 );
        assertPartitionAssignment( a1, partitionC );
        assertPartitionAssignment( a2, partitionB );
        assertPartitionAssignment( b1, partitionA );
        assertPartitionAssignment( c1, partitionA );
        assertPartitionAssignment( c2, partitionA );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // change the composite link of b1 to a2
                ( (MofPackage) b1 ).setContainer( (MofPackage) a2 );
                assertCompositeParent( a2, b1 );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionC );
                assertPartitionAssignment( a2, partitionB );
                assertPartitionAssignment( b1, partitionA );
                assertPartitionAssignment( c1, partitionA );
                assertPartitionAssignment( c2, partitionA );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionC );
                assertPartitionAssignment( a2, partitionB );
                assertPartitionAssignment( b1, partitionA );
                assertPartitionAssignment( c1, partitionA );
                assertPartitionAssignment( c2, partitionA );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

    }

    @Test
    public void testNoImplicitPartitionAssignmentOnChangingCompositeLinkTwoStep( ) throws Exception {

        partitionA.assignElementIncludingChildren( a1 );
        partitionB.assignElementIncludingChildren( a2 );
        partitionC.assignElement( a1 );
        assertPartitionAssignment( a1, partitionC );
        assertPartitionAssignment( a2, partitionB );
        assertPartitionAssignment( b1, partitionA );
        assertPartitionAssignment( c1, partitionA );
        assertPartitionAssignment( c2, partitionA );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // change the composite link of b1 to a2
                ( (MofPackage) b1 ).setContainer( null );
                ( (MofPackage) b1 ).setContainer( (MofPackage) a2 );
                assertCompositeParent( a2, b1 );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertPartitionAssignment( a1, partitionC );
                assertPartitionAssignment( a2, partitionB );
                assertPartitionAssignment( b1, partitionA );
                assertPartitionAssignment( c1, partitionA );
                assertPartitionAssignment( c2, partitionA );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionC );
                assertPartitionAssignment( a2, partitionB );
                assertPartitionAssignment( b1, partitionA );
                assertPartitionAssignment( c1, partitionA );
                assertPartitionAssignment( c2, partitionA );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

    }

    @Test
    public void testIllegalRelocation( ) throws Exception {

        RefObject refObjectA1 = (RefObject) a1;
        RefObject objectFromMetaModelWorkspace = refObjectA1.refMetaObject( );

        try {
            partitionA.assignElement( objectFromMetaModelWorkspace );
            fail( "Expected exception" );
        } catch ( IllegalRelocateToDataAreaException e ) {
            assertEquals( ( (Partitionable) objectFromMetaModelWorkspace ).get___Mri( ), e.getObjectToRelocate( ) );
        }

    }

    @Test
    public void testInputValidationAndNoOp( ) throws Exception {

        // test null as input parameter starting from partition
        try {
            partitionA.assignElement( (Partitionable) null );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            partitionA.assignElementIncludingChildren( (Partitionable) null );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            partitionA.assignElement( (RefObject) null );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            partitionA.assignElementIncludingChildren( (RefObject) null );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        // test null as input parameter starting from element
        try {
            a1.assign___Partition( null );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

        try {
            a1.assign___PartitionIncludingChildren( null );
            fail( "Expected exception" );
        } catch ( IllegalArgumentException e ) {
            // expected
        }

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

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // test assignment to partition which is already assigned
                nullPartition.assignElement( a1 );
                nullPartition.assignElementIncludingChildren( a1 );
                a1.assign___Partition( nullPartition );
                a1.assign___PartitionIncludingChildren( nullPartition );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

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
            }

            @Override
            public void assertAfterUndo( ) {

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
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

    }

    @Test
    public void testImplicitPartitionAssignmentOnAddingElement( ) throws Exception {

        partitionA.assignElementIncludingChildren( a1 );
        assertPartitionAssignment( a1, partitionA );
        assertPartitionAssignment( b3, nullPartition );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // add an element to the list of a1
                ( (MofPackage) a1 ).getContents( ).add( (ModelElement) b3 );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // b3 should now be in the same partition as a1
                assertPartitionAssignment( b3, partitionA );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( a1, partitionA );
                assertPartitionAssignment( b3, nullPartition );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

    }

    @Test
    public void testNoImplicitPartitionAssignmentIfStorageOnlyOnChild( ) throws Exception {

        assertPartitionAssignment( parentWithoutStorage, nullPartition );
        assertPartitionAssignment( childWithStorage1, nullPartition );
        parentWithoutStorage.assign___Partition( partitionA );
        assertPartitionAssignment( parentWithoutStorage, partitionA );
        assertPartitionAssignment( childWithStorage1, nullPartition );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // establish the composite link, the child must not come along
                // as
                // storage is only on the child's side
                ( (C6) childWithStorage1 ).setX( (B6) parentWithoutStorage );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertEquals( parentWithoutStorage, ( (C6) childWithStorage1 ).getX( ) );
                assertCompositeParent( null, parentWithoutStorage );
                assertCompositeParent( parentWithoutStorage, childWithStorage1 );

                // must still be as it was before
                assertPartitionAssignment( parentWithoutStorage, partitionA );
                assertPartitionAssignment( childWithStorage1, nullPartition );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( parentWithoutStorage, partitionA );
                assertPartitionAssignment( childWithStorage1, nullPartition );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

        // test the inverse case: deletion of a composite link with only storage
        // at child side -> child must not go to
        // the null partition

        partitionA.assignElement( childWithStorage1 );
        assertPartitionAssignment( parentWithoutStorage, partitionA );
        assertPartitionAssignment( childWithStorage1, partitionA );

        command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                // delete the composite link, the child must not go to the null
                // partition as storage is only on the child's side
                ( (C6) childWithStorage1 ).setX( null );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertCompositeParent( null, childWithStorage1 );
                assertCompositeParent( null, parentWithoutStorage );
                assertPartitionAssignment( parentWithoutStorage, partitionA );
                assertPartitionAssignment( childWithStorage1, partitionA );
            }

            @Override
            public void assertAfterUndo( ) {

                assertPartitionAssignment( parentWithoutStorage, partitionA );
                assertPartitionAssignment( childWithStorage1, partitionA );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );

    }

    @Test
    public void testPartitionAssignmentMixedSessions( ) throws Exception {

        // two connections of different sessions, but the same clientspec
        Connection connection1 = getMOINConnection( );
        Connection connection2 = getSecondMOINConnection( );

        // create new element in connection2, is assigned to NullPartition of
        // connection2
        Partitionable newElementConnection2 = (Partitionable) connection2.getNullPartition( ).createElement( MofClass.class );
        try {
            // partitionA is in connection1, connection1 can't see the
            // NullPartition of connection2
            partitionA.assignElement( newElementConnection2 );
            fail( "Expected exception" );
        } catch ( PartitionEditingNotPossibleException e ) {
            // expected, as we cannot edit the null partition of conn
        }

        // make sure that assignment didn't happen
        assertFalse( newElementConnection2.get___Partition( ).equals( partitionA ) );

        // try the other way round: try to assign a partition which is only
        // existing in memory for connection1
        ModelPartition newPartitionConnection1 = _testClient1.getOrCreatePartition( "temporaryNew_" + System.currentTimeMillis( ) );
        try {
            newElementConnection2.assign___Partition( newPartitionConnection1 );
            fail( "Expected exception" );
        } catch ( UnresolvableException e ) {
            // expected, as the partition is only visible in connection1 and
            // can't be seen by connection2
        }

        // make sure that assignment didn't happen
        assertFalse( newElementConnection2.get___Partition( ).equals( newPartitionConnection1 ) );

        // make sure that partitionB and partitionB are empty so that it is
        // easier to retrieve a model element which
        // will be explicitly assigned to that partitions later on in the test
        partitionA.deleteElements( );
        partitionB.deleteElements( );

        a1.assign___Partition( partitionA );
        assertEquals( partitionA, a1.get___Partition( ) );
        assertEquals( connection1, a1.get___Connection( ) );

        // make sure the partition of connection1 are persisted so that element
        // a1 can also be resolved in connection2
        // (as they share the persistence)
        connection1.getNullPartition( ).deleteElements( ); // get rid of other
        // elements created
        // by
        // beforeTestMethod
        connection1.save( );

        // make sure that save() hasn't changed anything on the expected
        // situation
        assertEquals( partitionA, a1.get___Partition( ) );
        assertEquals( connection1, a1.get___Connection( ) );

        ModelPartition partitionBInContextOfSecondConnection = connection2.getPartition( partitionB.getPri( ) );

        // partition "belongs" to connection2, a1 "belongs" to connection1
        partitionBInContextOfSecondConnection.assignElement( a1 );

        Collection<Partitionable> elementsInPartitionBInContextOfSecondConnection = partitionBInContextOfSecondConnection.getElements( );
        assertSame( 1, elementsInPartitionBInContextOfSecondConnection.size( ) ); // only
        // a1
        // is
        // assigned

        Partitionable a1InContextOfSecondConnection = elementsInPartitionBInContextOfSecondConnection.iterator( ).next( );

        // we are talking the same element here
        assertEquals( a1.refMofId( ), a1InContextOfSecondConnection.refMofId( ) );

        // but (as long as not saved) the wrapper for a1 in connection1 has
        // still the "old" partition
        assertEquals( partitionA, a1.get___Partition( ) );
        assertEquals( a1, partitionA.getElements( ).iterator( ).next( ) );

        // and the wrapper for a1 in connection2 has the "new" partition
        assertEquals( partitionBInContextOfSecondConnection, a1InContextOfSecondConnection.get___Partition( ) );

        // now we save the second connection and a1 in connection1 must be
        // informed that its partition changed
        connection2.getNullPartition( ).deleteElements( ); // remove remaining
        // transient
        // elements so save
        // is possible
        connection2.save( );

        // a1 no longer in partitionA but in partitionB, also in connection1
        assertEquals( 0, partitionA.getElements( ).size( ) );
        assertEquals( partitionB, a1.get___Partition( ) );
        assertEquals( 1, partitionB.getElements( ).size( ) );
        assertEquals( a1, partitionB.getElements( ).iterator( ).next( ) );

        // same for connection2, nothing should have change there
        assertEquals( partitionBInContextOfSecondConnection, a1InContextOfSecondConnection.get___Partition( ) );

    }

    @Test
    public void testPartitionLinksAfterAssignment( ) throws Exception {

        Case005Package case005Package = testcasesPackage.getCase005( );
        final A5 a5 = getMOINConnection( ).createElementInPartition( A5.class, null );
        final B5 b5 = getMOINConnection( ).createElementInPartition( B5.class, null );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                a5.setX( b5 );
                getPartitionTwo( ).assignElement( b5 );
                getPartitionOne( ).assignElement( a5 );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                SpiModelPartition p1 = getTestHelper( ).getCoreModelPartition( getPartitionOne( ) );
                SpiModelPartition p2 = getTestHelper( ).getCoreModelPartition( getPartitionTwo( ) );
                assertTrue( "Expected partitionOne to host one link", p1.getLinks( ).size( ) == 1 );
                assertTrue( "Expected partitionTwo to host no links", p2.getLinks( ).isEmpty( ) );
            }

            @Override
            public void assertAfterUndo( ) {

                SpiModelPartition p1 = getTestHelper( ).getCoreModelPartition( getPartitionOne( ) );
                SpiModelPartition p2 = getTestHelper( ).getCoreModelPartition( getPartitionTwo( ) );
                assertTrue( "Expected partitionOne to host no link", p1.getLinks( ).isEmpty( ) );
                assertTrue( "Expected partitionTwo to host no links", p2.getLinks( ).isEmpty( ) );
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );
    }

    @Test
    public void testCreateInstanceInPartition( ) throws Exception {

        final Case005Package case005Package = testcasesPackage.getCase005( );
        final List<RefObject> createdElements = new ArrayList<RefObject>( );

        Command command = new Command( this.getMOINConnection( ) ) {

            @Override
            public boolean canExecute( ) {

                return true;
            }

            @Override
            public void doExecute( ) {

                A5 a5 = getConnection( ).createElementInPartition( A5.class, getPartitionOne( ) );
                B5 b5 = getConnection( ).createElementInPartition( B5.class, getPartitionOne( ) );
                createdElements.add( a5 );
                createdElements.add( b5 );
            }

            @Override
            public Collection<PartitionOperation> getAffectedPartitions( ) {

                return null;
            }

        };

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                assertTrue( getPartitionOne( ).getElements( ).containsAll( createdElements ) );
            }

            @Override
            public void assertAfterUndo( ) {

                for ( RefObject refObject : createdElements ) {
                    assertFalse( getPartitionOne( ).getElements( ).contains( refObject ) );
                }
            }

        };

        this.runDoUndoRedoTest( this.getMOINConnection( ), command, asserter );
    }

    @Test
    public void testEqualsAfterRepartitioning( ) throws Exception {

        Collection<Partitionable> elementsInNullPartition = getMOINConnection( ).getNullPartition( ).getElements( );
        for ( Partitionable partitionable : elementsInNullPartition ) {
            partitionable.assign___Partition( partitionA );
        }
        getMOINConnection( ).save( );

        // Check before re-partitioning
        // Elements are from different Connections, but have same MRI
        RefBaseObject a1FromConn2 = getSecondMOINConnection( ).getElement( a1.get___Mri( ) );
        assertEquals( a1, a1FromConn2 );
        assertTrue( a1.hashCode( ) == a1FromConn2.hashCode( ) );

        // Check after re-partitioning
        // Elements have different MRI, but same LRI -> equals should be "true"
        a1.assign___Partition( partitionB );
        assertEquals( a1, a1FromConn2 );
        assertTrue( a1.hashCode( ) == a1FromConn2.hashCode( ) );
    }

    private void assertPartitionAssignment( Partitionable element, ModelPartition partition ) {

        assertEquals( partition, element.get___Partition( ) );
    }

    private void assertPartitionAssignment( RefBaseObject element, ModelPartition partition ) {

        assertEquals( partition, ( (Partitionable) element ).get___Partition( ) );
    }

    private void assertCompositeParent( Partitionable parent, Partitionable child ) {

        CorePartitionable coreChild = getTestHelper( ).getCorePartitionable( child );
        EndStorageLink compositeParentLink = coreChild.get___Workspace( ).getWorkspaceSet( ).getLogicalLinkManager( ).getCompositeParentLink( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), coreChild );

        if ( parent == null ) {
            assertNull( compositeParentLink );
            return;
        }

        assertEquals( parent, ( (RefObject) child ).refImmediateComposite( ) );

        int componentEnd = compositeParentLink.getComponentEnd( );
        int compositeEnd = compositeParentLink.getCompositeEnd( );

        MoinReference component = compositeParentLink.getEnd( componentEnd );
        MoinReference composite = compositeParentLink.getEnd( compositeEnd );

        assertEquals( getTestHelper( ).getCorePartitionable( child ), component.get( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ) ) );
        assertEquals( getTestHelper( ).getCorePartitionable( parent ), composite.get( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ) ) );

    }
}