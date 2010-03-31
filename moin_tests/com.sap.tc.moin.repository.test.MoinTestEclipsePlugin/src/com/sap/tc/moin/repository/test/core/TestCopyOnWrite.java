package com.sap.tc.moin.repository.test.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionManager;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.LriReference;
import com.sap.tc.moin.repository.core.SessionWorkspace;
import com.sap.tc.moin.repository.core.SynchronizationManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.impl.CheckResult;
import com.sap.tc.moin.repository.core.impl.MoinCoreConsistencyChecker;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.testcases.case004.A4;
import com.sap.tc.moin.testcases.case026.A26;

/**
 * Tests the copy-on-write behaviour for client-specific workspaces and
 * partitions.
 */
public class TestCopyOnWrite extends CoreMoinTest {

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

    /**
     * Tests partition Java identity after making dirty / saving / reverting.
     */
    @Test
    public void testPartitionIdentity( ) throws Exception {

        getMOINConnection( ).save( ); // Start from a saved state, otherwise partitionOne|Two|Three are dirty!

        Connection conn1 = getMOINConnection( );
        Connection conn2 = getSecondMOINConnection( );
        PRI pri = getPartitionOne( ).getPri( );

        CoreModelPartition partition1_conn1 = getTestHelper( ).getCoreModelPartition( conn1.getPartition( pri ) );
        CoreModelPartition partition1_conn2 = getTestHelper( ).getCoreModelPartition( conn2.getPartition( pri ) );

        assertSame( "Expected partitionOne to be shared by both connections", partition1_conn1, partition1_conn2 );

        CoreModelPartition sharedPartition = partition1_conn2;
        getPartitionOne( ).createElement( MofClass.class );

        partition1_conn1 = getTestHelper( ).getCoreModelPartition( conn1.getPartition( pri ) );
        partition1_conn2 = getTestHelper( ).getCoreModelPartition( conn2.getPartition( pri ) );

        assertNotSame( "Expected connection1 to point to a copy of partitionOne", partition1_conn1, sharedPartition );
        assertSame( "Expected connection2 to still point to the shared partitionOne", partition1_conn2, sharedPartition );

        getMOINConnection( ).save( );
        // Make sure that partitionOne was evicted
        assertFalse( getTestHelper( ).getCoreConnection( conn1 ).getSession( ).getCompoundClientSpecWorkspace( ).getPartitionManager( ).isPartitionLoaded( pri ) );

        partition1_conn1 = getTestHelper( ).getCoreModelPartition( conn1.getPartition( pri ) );
        partition1_conn2 = getTestHelper( ).getCoreModelPartition( conn2.getPartition( pri ) );

        assertSame( "Expected partitionOne to be shared by both connections", partition1_conn1, partition1_conn2 );

        getPartitionOne( ).createElement( MofClass.class );

        partition1_conn1 = getTestHelper( ).getCoreModelPartition( conn1.getPartition( pri ) );
        partition1_conn2 = getTestHelper( ).getCoreModelPartition( conn2.getPartition( pri ) );

        assertNotSame( "Expected connection1 and connection2 to point to different instances of partitionOne", partition1_conn1, partition1_conn2 );

        getMOINConnection( ).revert( );

        partition1_conn1 = getTestHelper( ).getCoreModelPartition( conn1.getPartition( pri ) );
        partition1_conn2 = getTestHelper( ).getCoreModelPartition( conn2.getPartition( pri ) );

        assertSame( "Expected partitionOne to be shared by both connections", partition1_conn1, partition1_conn2 );
    }

    /**
     * Tests model element Java identity after making dirty / saving /
     * reverting.
     */
    @Test
    public void testElementIdentity( ) throws Exception {

        getMOINConnection( ).save( ); // Start from a saved state, otherwise partitionOne|Two|Three are dirty!

        Connection conn1 = getMOINConnection( );
        Connection conn2 = getSecondMOINConnection( );

        // Prepare partitionOne for the test by assigning one element to it, saving and evicting it.
        LRI lri = ( (Partitionable) getPartitionOne( ).createElement( MofClass.class ) ).get___Mri( ).getLri( );
        getMOINConnection( ).save( );
        getTestHelper( ).getCoreConnection( conn1 ).getSession( ).getWorkspace( ).getPartitionManager( ).evictPartitionForced( getTestHelper( ).getCoreModelPartition( getPartitionOne( ) ) );

        MofClass mofClass_conn1 = (MofClass) getTestHelper( ).getCorePartitionable( conn1.getElement( lri ) );
        MofClass mofClass_conn2 = (MofClass) getTestHelper( ).getCorePartitionable( conn2.getElement( lri ) );

        assertSame( "Expected the MofClass instance to be shared by both connections", mofClass_conn1, mofClass_conn2 );

        MofClass sharedMofClass = mofClass_conn1;

        MofClass mofClassWrapper = (MofClass) getMOINConnection( ).getElement( lri );
        mofClassWrapper.setName( "mofClass1" );

        mofClass_conn1 = (MofClass) getTestHelper( ).getCorePartitionable( conn1.getElement( lri ) );
        mofClass_conn2 = (MofClass) getTestHelper( ).getCorePartitionable( conn2.getElement( lri ) );

        assertNotSame( "Expected connection1 to point to a copy of the MofClass instance", mofClass_conn1, sharedMofClass );
        assertSame( "Expected connection2 to still point to the shared MofClass instance", mofClass_conn2, sharedMofClass );

        getMOINConnection( ).save( );
        // Make sure that partitionOne was evicted
        assertFalse( getTestHelper( ).getCoreConnection( conn1 ).getSession( ).getCompoundClientSpecWorkspace( ).getPartitionManager( ).isPartitionLoaded( getPartitionOne( ).getPri( ) ) );

        mofClass_conn1 = (MofClass) getTestHelper( ).getCorePartitionable( conn1.getElement( lri ) );
        mofClass_conn2 = (MofClass) getTestHelper( ).getCorePartitionable( conn2.getElement( lri ) );

        assertSame( "Expected the MofClass instance to be shared by both connections", mofClass_conn1, mofClass_conn2 );
    }

    @Test
    public void testPriReferences( ) throws Exception {

        getMOINConnection( ).save( );

        // Request wrappers for partitionOne in the context of two connections.
        ModelPartition partitionOne_1 = getPartitionOne( );
        ModelPartition partitionOne_2 = getSecondMOINConnection( ).getPartition( partitionOne_1.getPri( ) );

        assertSame( getTestHelper( ).getCoreModelPartition( partitionOne_1 ), getTestHelper( ).getCoreModelPartition( partitionOne_2 ) );

        partitionOne_1.createElement( MofPackage.class );

        assertNotSame( getTestHelper( ).getCoreModelPartition( partitionOne_1 ), getTestHelper( ).getCoreModelPartition( partitionOne_2 ) );

        getMOINConnection( ).save( );

        assertSame( getTestHelper( ).getCoreModelPartition( partitionOne_1 ), getTestHelper( ).getCoreModelPartition( partitionOne_2 ) );

        partitionOne_1.createElement( MofPackage.class );

        assertNotSame( getTestHelper( ).getCoreModelPartition( partitionOne_1 ), getTestHelper( ).getCoreModelPartition( partitionOne_2 ) );

        getMOINConnection( ).revert( );

        assertSame( getTestHelper( ).getCoreModelPartition( partitionOne_1 ), getTestHelper( ).getCoreModelPartition( partitionOne_2 ) );
    }

    @Test
    public void testMriReferences( ) throws Exception {

        getPartitionOne( ).createElement( MofPackage.class );

        getMOINConnection( ).save( );

        // Request wrappers for the created MofPackage in the context of two connections.
        MofPackage mofPackage_1 = (MofPackage) getPartitionOne( ).getElements( ).iterator( ).next( );
        MofPackage mofPackage_2 = (MofPackage) getSecondMOINConnection( ).getPartition( getPartitionOne( ).getPri( ) ).getElements( ).iterator( ).next( );

        assertSame( getTestHelper( ).getCorePartitionable( mofPackage_1 ), getTestHelper( ).getCorePartitionable( mofPackage_2 ) );

        mofPackage_1.setName( "mofPackage1" );

        assertNotSame( getTestHelper( ).getCorePartitionable( mofPackage_1 ), getTestHelper( ).getCorePartitionable( mofPackage_2 ) );

        getMOINConnection( ).save( );

        mofPackage_1 = (MofPackage) getMOINConnection( ).getElement( mofPackage_1.get___Mri( ) );
        mofPackage_2 = (MofPackage) getSecondMOINConnection( ).getElement( mofPackage_2.get___Mri( ) );

        assertSame( getTestHelper( ).getCorePartitionable( mofPackage_1 ), getTestHelper( ).getCorePartitionable( mofPackage_2 ) );

        mofPackage_1.setName( "mofPackage1 new" );

        assertNotSame( getTestHelper( ).getCorePartitionable( mofPackage_1 ), getTestHelper( ).getCorePartitionable( mofPackage_2 ) );

        getMOINConnection( ).revert( );

        assertSame( getTestHelper( ).getCorePartitionable( mofPackage_1 ), getTestHelper( ).getCorePartitionable( mofPackage_2 ) );
    }

    @Test
    public void testUndoRedoOfInstanceCreation( ) throws Exception {

        ModelPartition partition = _testClient1.getOrCreatePartitionStable( "testUndoRedoOfInstanceCreation" );
        CommandStack commandStack = getMOINConnection( ).getCommandStack( );
        commandStack.openGroup( "TestCopyOnWrite" );
        partition.createElement( MofClass.class );
        commandStack.closeGroup( );

        MoinCoreConsistencyChecker checker = new MoinCoreConsistencyChecker( getTestHelper( ).getCoreMoin( ), false /* withoutLocks */);
        checkMoinCoreConsistency( checker );

        commandStack.undo( );
        checkMoinCoreConsistency( checker );

        commandStack.redo( );
        checkMoinCoreConsistency( checker );

        commandStack.undo( );
        checkMoinCoreConsistency( checker );

        commandStack.redo( );
        checkMoinCoreConsistency( checker );
    }

    @Test
    public void testLinkResolution( ) throws Exception {

        Connection connection1 = getMOINConnection( );
        Connection connection2 = getSecondMOINConnection( );

        Workspace sessionWorkspace = getTestHelper( ).getCoreConnection( connection1 ).getSession( ).getWorkspace( );
        Workspace compoundClientSpecWorkspace = getTestHelper( ).getCoreConnection( connection1 ).getSession( ).getCompoundClientSpecWorkspace( );

        ModelPartition partitionOne = getPartitionOne( );
        ModelPartition partitionTwo = getPartitionTwo( );

        MofClass mofClass = partitionOne.createElement( MofClass.CLASS_DESCRIPTOR );
        Tag tag = partitionTwo.createElement( Tag.CLASS_DESCRIPTOR );
        tag.getElements( ).add( mofClass );

        Partitionable linkTargetConnection1 = tag.getElements( ).iterator( ).next( );
        LRI linkTargetLri = linkTargetConnection1.get___Mri( ).getLri( );
        assertSame( sessionWorkspace, getTestHelper( ).getCorePartitionable( linkTargetConnection1 ).get___Workspace( ) );
        connection1.save( );

        linkTargetConnection1 = tag.getElements( ).iterator( ).next( );
        assertSame( compoundClientSpecWorkspace, getTestHelper( ).getCorePartitionable( linkTargetConnection1 ).get___Workspace( ) );

        Tag tagConn2 = (Tag) connection2.getElement( ( (Partitionable) tag ).get___Mri( ) );
        assertSame( compoundClientSpecWorkspace, getTestHelper( ).getCorePartitionable( tagConn2 ).get___Workspace( ) );
        Partitionable linkTargetConnection2 = tagConn2.getElements( ).iterator( ).next( );
        assertSame( compoundClientSpecWorkspace, getTestHelper( ).getCorePartitionable( linkTargetConnection2 ).get___Workspace( ) );

        // trigger private copy of partitionOne
        mofClass.setName( "hugo" );

        linkTargetConnection1 = tag.getElements( ).iterator( ).next( );
        assertSame( sessionWorkspace, getTestHelper( ).getCorePartitionable( linkTargetConnection1 ).get___Workspace( ) );

        linkTargetConnection2 = tagConn2.getElements( ).iterator( ).next( );
        assertSame( compoundClientSpecWorkspace, getTestHelper( ).getCorePartitionable( linkTargetConnection2 ).get___Workspace( ) );

        //simulate eviction thread
        CorePartitionManager compoundClientSpecPartitionManager = compoundClientSpecWorkspace.getPartitionManager( );
        SynchronizationManager syncManager = compoundClientSpecWorkspace.getWorkspaceSet( ).getSynchronizationManager( );
        synchronized ( syncManager.getProhibitWriteSyncObject( ) ) {
            // Now make sure that no one is reading.
            syncManager.acquireMicroWriteLock( );
            try {
                compoundClientSpecPartitionManager.evictPartition( getTestHelper( ).getCoreModelPartition( partitionTwo ) );
            } finally {
                syncManager.releaseMicroWriteLock( );
            }
        }
        LriReference lriReference = compoundClientSpecWorkspace.getWorkspaceSet( ).getReferenceManager( ).getLriReference( linkTargetLri );
        linkTargetConnection1 = tag.getElements( ).iterator( ).next( );
        assertSame( sessionWorkspace, getTestHelper( ).getCorePartitionable( linkTargetConnection1 ).get___Workspace( ) );

        linkTargetConnection2 = tagConn2.getElements( ).iterator( ).next( );
        assertSame( compoundClientSpecWorkspace, getTestHelper( ).getCorePartitionable( linkTargetConnection2 ).get___Workspace( ) );
    }

    private void checkMoinCoreConsistency( MoinCoreConsistencyChecker checker ) {

        CheckResult checkResult = checker.performAllChecks( );
        assertTrue( checkResult.toString( ), checkResult.isEmpty( ) );
    }

    void assertNoPrivateCopy( ModelPartition partition ) {

        CoreModelPartition coreModelPartition = getTestHelper( ).getCoreModelPartition( partition );
        assertFalse( "Expected workspace to be a non-SessionWorkspace", coreModelPartition.getWorkspace( ) instanceof SessionWorkspace );

    }

    private void assertSameUnderlyingCoreModelPartition( ModelPartition expected, ModelPartition actual ) {

        assertSame( getTestHelper( ).getCoreModelPartition( expected ), getTestHelper( ).getCoreModelPartition( actual ) );
    }

    void assertPrivateCopy( Session session, ModelPartition partition ) {

        CoreSession coreSession = getTestHelper( ).getCoreSession( session );
        CoreModelPartition coreModelPartition = getTestHelper( ).getCoreModelPartition( partition );
        assertTrue( coreModelPartition.getWorkspace( ) instanceof SessionWorkspace );
        assertSame( coreSession.getWorkspace( ), coreModelPartition.getWorkspace( ) );

    }

    @Test
    public void testDataTypeAttributeAddElement( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        final A4 elementConnection1 = connection1.createElementInPartition( A4.class, partitionFromConnection1 );
        //save to make sure partition can also be seen in connection2 and no private copy exists
        connection1.save( );

        final Collection<String> manyPrimitiveCollectionFromConnection1 = elementConnection1.getManyPrimitive( );
        assertNoPrivateCopy( partitionFromConnection1 );
        final ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        assertNotNull( partitionFromConnection2 ); //partition must be visible in connection2
        assertNoPrivateCopy( partitionFromConnection2 );
        final A4 elementConnection2 = (A4) connection2.getElement( elementConnection1.get___Mri( ) );
        final Collection<String> manyPrimitiveCollectionFromConnection2 = elementConnection2.getManyPrimitive( );
        final String value = "COW";

        Command command = new TestCommand( connection1 ) {

            @Override
            public void doExecute( ) {

                manyPrimitiveCollectionFromConnection1.add( value );
            }
        };

        DoUndoRedoTestAsserter asserter = new DoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //connection1
                assertEquals( 1, manyPrimitiveCollectionFromConnection1.size( ) );
                assertEquals( value, manyPrimitiveCollectionFromConnection1.iterator( ).next( ) );
                assertSame( partitionFromConnection1, elementConnection1.get___Partition( ) );
                assertPrivateCopy( connection1.getSession( ), elementConnection1.get___Partition( ) );

                //connection2
                assertEquals( 0, manyPrimitiveCollectionFromConnection2.size( ) );
                assertSame( partitionFromConnection2, elementConnection2.get___Partition( ) );
                assertNoPrivateCopy( partitionFromConnection2 );
            }

            @Override
            public void assertAfterUndo( ) {

                //connection1
                assertEquals( 0, manyPrimitiveCollectionFromConnection1.size( ) );
                assertSame( partitionFromConnection1, elementConnection1.get___Partition( ) );
                //private copy still exists
                assertPrivateCopy( connection1.getSession( ), elementConnection1.get___Partition( ) );

                //connection2
                assertEquals( 0, manyPrimitiveCollectionFromConnection2.size( ) );
                assertSame( partitionFromConnection2, elementConnection2.get___Partition( ) );
                assertNoPrivateCopy( partitionFromConnection2 );

            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

            }
        };


        runDoUndoRedoTest( command, asserter );

        //no more private copy must exist after save
        connection1.save( );

        assertSame( partitionFromConnection1, elementConnection1.get___Partition( ) );
        assertNoPrivateCopy( elementConnection1.get___Partition( ) );

        assertSame( partitionFromConnection2, elementConnection2.get___Partition( ) );
        assertNoPrivateCopy( partitionFromConnection2 );

        //how are things in connection1
        assertEquals( 1, partitionFromConnection1.getElements( ).size( ) );
        assertEquals( elementConnection1, partitionFromConnection1.getElements( ).iterator( ).next( ) );
        assertEquals( 1, manyPrimitiveCollectionFromConnection1.size( ) );
        assertEquals( value, manyPrimitiveCollectionFromConnection1.iterator( ).next( ) );

        //how are things in connection2
        assertEquals( 1, partitionFromConnection2.getElements( ).size( ) );
        assertEquals( elementConnection2, partitionFromConnection2.getElements( ).iterator( ).next( ) );
        assertEquals( 1, manyPrimitiveCollectionFromConnection2.size( ) );
        assertEquals( value, manyPrimitiveCollectionFromConnection2.iterator( ).next( ) );
    }

    @Test
    public void testDataTypeAttributeAddElementCopyOnWriteRedo( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        final A4 elementConnection1 = connection1.createElementInPartition( A4.class, partitionFromConnection1 );
        //save to make sure partition can also be seen in connection2 and no private copy exists
        connection1.save( );

        //do
        String stringValue = "testStringValueForCow";
        Collection<String> manyStringValues = elementConnection1.getManyPrimitive( );
        manyStringValues.add( stringValue );
        assertEquals( 1, manyStringValues.size( ) );
        assertEquals( stringValue, manyStringValues.iterator( ).next( ) );

        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertEquals( 0, manyStringValues.size( ) );


        //change affected partition in other session and save
        ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        partitionFromConnection2.createElement( MofClass.class );
        connection2.save( );

        //redo
        commandStack.redo( );
        assertEquals( 1, manyStringValues.size( ) );
        assertEquals( stringValue, manyStringValues.iterator( ).next( ) );

    }

    @Test
    public void testDataTypeAttributeChange( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        final A4 elementConnection1 = connection1.createElementInPartition( A4.class, partitionFromConnection1 );
        assertNull( elementConnection1.getOnePrimitive( ) );

        //save to make sure partition can also be seen in connection2 and no private copy exists
        connection1.save( );

        assertNoPrivateCopy( partitionFromConnection1 );
        final ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        assertNotNull( partitionFromConnection2 ); //partition must be visible in connection2
        assertNoPrivateCopy( partitionFromConnection2 );
        final A4 elementConnection2 = (A4) connection2.getElement( elementConnection1.get___Mri( ) );
        assertNotNull( elementConnection2 );

        final String value = "COW";
        Command command = new TestCommand( connection1 ) {

            @Override
            public void doExecute( ) {

                elementConnection1.setOnePrimitive( value );

            }
        };

        DoUndoRedoTestAsserter asserter = new DoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //connection1
                assertEquals( value, elementConnection1.getOnePrimitive( ) );
                assertSame( partitionFromConnection1, elementConnection1.get___Partition( ) );
                assertPrivateCopy( connection1.getSession( ), elementConnection1.get___Partition( ) );

                //connection2
                assertNull( elementConnection2.getOnePrimitive( ) );
                assertSame( partitionFromConnection2, elementConnection2.get___Partition( ) );
                assertNoPrivateCopy( partitionFromConnection2 );
            }

            @Override
            public void assertAfterUndo( ) {

                //connection1
                assertSame( partitionFromConnection1, elementConnection1.get___Partition( ) );
                //private copy still exists, but setting of value must be undone
                assertPrivateCopy( connection1.getSession( ), partitionFromConnection1 );
                assertNull( elementConnection2.getOnePrimitive( ) );
                assertNull( elementConnection1.getOnePrimitive( ) );

                //connection2
                assertSame( partitionFromConnection2, elementConnection2.get___Partition( ) );
                assertNoPrivateCopy( partitionFromConnection2 );
                assertNull( elementConnection2.getOnePrimitive( ) );

            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

            }
        };

        runDoUndoRedoTest( command, asserter );


        //no more private copy must exist after save
        connection1.save( );

        assertSame( partitionFromConnection1, elementConnection1.get___Partition( ) );
        assertNoPrivateCopy( elementConnection1.get___Partition( ) );

        assertSame( partitionFromConnection2, elementConnection2.get___Partition( ) );
        assertNoPrivateCopy( partitionFromConnection2 );

        //how are things in connection1
        assertEquals( 1, partitionFromConnection1.getElements( ).size( ) );
        assertEquals( elementConnection1, partitionFromConnection1.getElements( ).iterator( ).next( ) );
        assertEquals( value, elementConnection1.getOnePrimitive( ) );

        //how are things in connection2
        assertEquals( 1, partitionFromConnection2.getElements( ).size( ) );
        assertEquals( elementConnection2, partitionFromConnection2.getElements( ).iterator( ).next( ) );
        assertEquals( value, elementConnection2.getOnePrimitive( ) );
    }


    @Test
    public void testDataTypeAttributeChangeCopyOnWriteRedo( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        final A4 elementConnection1 = connection1.createElementInPartition( A4.class, partitionFromConnection1 );
        assertNull( elementConnection1.getOnePrimitive( ) );

        //save to make sure partition can also be seen in connection2 and no private copy exists
        connection1.save( );

        assertNoPrivateCopy( partitionFromConnection1 );
        final ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        assertNotNull( partitionFromConnection2 ); //partition must be visible in connection2
        assertNoPrivateCopy( partitionFromConnection2 );

        //do
        String value = "someTestValue";
        elementConnection1.setOnePrimitive( value );
        assertEquals( value, elementConnection1.getOnePrimitive( ) );

        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertNull( elementConnection1.getOnePrimitive( ) );

        //change the affected partition in other session
        partitionFromConnection2.createElement( MofClass.class );
        connection2.save( );

        //redo
        commandStack.redo( );
        assertEquals( value, elementConnection1.getOnePrimitive( ) );

    }


    @Test
    public void testDataTypeAttributeRemoveElement( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        final A4 elementConnection1 = connection1.createElementInPartition( A4.class, partitionFromConnection1 );
        assertEquals( 0, elementConnection1.getManyPrimitive( ).size( ) );
        final String value = "COW";
        elementConnection1.getManyPrimitive( ).add( value );
        assertEquals( 1, elementConnection1.getManyPrimitive( ).size( ) );

        //save to make sure partition can also be seen in connection2 and no private copy exists
        connection1.save( );

        assertNoPrivateCopy( partitionFromConnection1 );
        final ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        assertNotNull( partitionFromConnection2 ); //partition must be visible in connection2
        assertNoPrivateCopy( partitionFromConnection2 );
        final A4 elementConnection2 = (A4) connection2.getElement( elementConnection1.get___Mri( ) );
        Command command = new TestCommand( connection1 ) {

            @Override
            public void doExecute( ) {

                Iterator<String> iterator = elementConnection1.getManyPrimitive( ).iterator( );
                String foundValue = iterator.next( );
                assertEquals( value, foundValue );
                iterator.remove( );

            }
        };

        DoUndoRedoTestAsserter asserter = new DoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //connection1
                assertEquals( 1, partitionFromConnection1.getElements( ).size( ) );
                assertEquals( elementConnection1, partitionFromConnection1.getElements( ).iterator( ).next( ) );
                assertEquals( 0, elementConnection1.getManyPrimitive( ).size( ) );
                assertPrivateCopy( connection1.getSession( ), partitionFromConnection1 );

                //connection2
                assertEquals( 1, partitionFromConnection2.getElements( ).size( ) );
                assertEquals( elementConnection2, partitionFromConnection2.getElements( ).iterator( ).next( ) );
                assertEquals( 1, elementConnection2.getManyPrimitive( ).size( ) );
                assertEquals( value, elementConnection2.getManyPrimitive( ).iterator( ).next( ) );
                assertNoPrivateCopy( partitionFromConnection2 );
            }

            @Override
            public void assertAfterUndo( ) {

                //connection1
                assertEquals( 1, partitionFromConnection1.getElements( ).size( ) );
                assertEquals( elementConnection1, partitionFromConnection1.getElements( ).iterator( ).next( ) );
                assertEquals( 1, elementConnection1.getManyPrimitive( ).size( ) );
                assertEquals( value, elementConnection1.getManyPrimitive( ).iterator( ).next( ) );

                //connection2
                assertEquals( 1, partitionFromConnection2.getElements( ).size( ) );
                assertEquals( elementConnection2, partitionFromConnection2.getElements( ).iterator( ).next( ) );
                assertEquals( 1, elementConnection2.getManyPrimitive( ).size( ) );
                assertEquals( value, elementConnection2.getManyPrimitive( ).iterator( ).next( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

            }

        };

        runDoUndoRedoTest( command, asserter );


        //no more private copy must exist after save
        connection1.save( );

        assertSame( partitionFromConnection1, elementConnection1.get___Partition( ) );
        assertNoPrivateCopy( elementConnection1.get___Partition( ) );

        assertSame( partitionFromConnection2, elementConnection2.get___Partition( ) );
        assertNoPrivateCopy( partitionFromConnection2 );

        //how are things in connection1
        assertEquals( 1, partitionFromConnection1.getElements( ).size( ) );
        assertEquals( elementConnection1, partitionFromConnection1.getElements( ).iterator( ).next( ) );
        assertEquals( 0, elementConnection1.getManyPrimitive( ).size( ) );

        //how are things in connection2
        assertEquals( 1, partitionFromConnection2.getElements( ).size( ) );
        assertEquals( elementConnection2, partitionFromConnection2.getElements( ).iterator( ).next( ) );
        assertEquals( 0, elementConnection2.getManyPrimitive( ).size( ) );
    }

    @Test
    public void testDataTypeAttributeRemoveElementCopyOnWriteRedo( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        final A4 elementConnection1 = connection1.createElementInPartition( A4.class, partitionFromConnection1 );
        assertEquals( 0, elementConnection1.getManyPrimitive( ).size( ) );
        final String value = "COW";
        Collection<String> manyPrimitiveCollection = elementConnection1.getManyPrimitive( );
        manyPrimitiveCollection.add( value );
        assertEquals( 1, manyPrimitiveCollection.size( ) );

        //save to make sure partition can also be seen in connection2 and no private copy exists
        connection1.save( );

        final ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        assertNotNull( partitionFromConnection2 ); //partition must be visible in connection2
        assertNoPrivateCopy( partitionFromConnection2 );

        //do
        Iterator<String> iterator = elementConnection1.getManyPrimitive( ).iterator( );
        String foundValue = iterator.next( );
        assertEquals( value, foundValue );
        iterator.remove( );
        assertEquals( 0, manyPrimitiveCollection.size( ) );


        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertEquals( 1, manyPrimitiveCollection.size( ) );
        assertEquals( value, manyPrimitiveCollection.iterator( ).next( ) );

        //change affected partition with other session
        partitionFromConnection2.createElement( MofClass.class );
        connection2.save( );

        //redo
        commandStack.redo( );
        assertEquals( 0, manyPrimitiveCollection.size( ) );


    }

    @Test
    public void testDataTypeAttributeSetElement( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        final A4 elementConnection1 = connection1.createElementInPartition( A4.class, partitionFromConnection1 );
        assertEquals( 0, elementConnection1.getManyPrimitiveOrdered( ).size( ) );
        final String value = "COW";
        final String newValue = "NEW";
        elementConnection1.getManyPrimitiveOrdered( ).add( value );
        assertEquals( 1, elementConnection1.getManyPrimitiveOrdered( ).size( ) );

        //save to make sure partition can also be seen in connection2 and no private copy exists
        connection1.save( );

        assertNoPrivateCopy( partitionFromConnection1 );
        final ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        assertNotNull( partitionFromConnection2 ); //partition must be visible in connection2
        assertNoPrivateCopy( partitionFromConnection2 );
        final A4 elementConnection2 = (A4) connection2.getElement( elementConnection1.get___Mri( ) );
        Command command = new TestCommand( connection1 ) {

            @Override
            public void doExecute( ) {

                elementConnection1.getManyPrimitiveOrdered( ).set( 0, newValue );

            }
        };

        DoUndoRedoTestAsserter asserter = new DoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //connection1
                assertEquals( 1, partitionFromConnection1.getElements( ).size( ) );
                assertEquals( elementConnection1, partitionFromConnection1.getElements( ).iterator( ).next( ) );
                assertEquals( 1, elementConnection1.getManyPrimitiveOrdered( ).size( ) );
                assertEquals( newValue, elementConnection1.getManyPrimitiveOrdered( ).get( 0 ) );
                assertPrivateCopy( connection1.getSession( ), partitionFromConnection1 );

                //connection2
                assertEquals( 1, partitionFromConnection2.getElements( ).size( ) );
                assertEquals( elementConnection2, partitionFromConnection2.getElements( ).iterator( ).next( ) );
                assertEquals( 1, elementConnection2.getManyPrimitiveOrdered( ).size( ) );
                assertEquals( value, elementConnection2.getManyPrimitiveOrdered( ).get( 0 ) );
                assertNoPrivateCopy( partitionFromConnection2 );
            }

            @Override
            public void assertAfterUndo( ) {

                //connection1
                assertEquals( 1, partitionFromConnection1.getElements( ).size( ) );
                assertEquals( elementConnection1, partitionFromConnection1.getElements( ).iterator( ).next( ) );
                assertEquals( 1, elementConnection1.getManyPrimitiveOrdered( ).size( ) );
                assertEquals( value, elementConnection1.getManyPrimitiveOrdered( ).get( 0 ) );

                //connection2
                assertEquals( 1, partitionFromConnection2.getElements( ).size( ) );
                assertEquals( elementConnection2, partitionFromConnection2.getElements( ).iterator( ).next( ) );
                assertEquals( 1, elementConnection2.getManyPrimitiveOrdered( ).size( ) );
                assertEquals( value, elementConnection2.getManyPrimitiveOrdered( ).iterator( ).next( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

            }

        };

        runDoUndoRedoTest( command, asserter );


        //no more private copy must exist after save
        connection1.save( );

        assertSame( partitionFromConnection1, elementConnection1.get___Partition( ) );
        assertNoPrivateCopy( elementConnection1.get___Partition( ) );

        assertSame( partitionFromConnection2, elementConnection2.get___Partition( ) );
        assertNoPrivateCopy( partitionFromConnection2 );

        //connection1
        assertEquals( 1, partitionFromConnection1.getElements( ).size( ) );
        assertEquals( elementConnection1, partitionFromConnection1.getElements( ).iterator( ).next( ) );
        assertEquals( 1, elementConnection1.getManyPrimitiveOrdered( ).size( ) );
        assertEquals( newValue, elementConnection1.getManyPrimitiveOrdered( ).get( 0 ) );

        //connection2
        assertEquals( 1, partitionFromConnection2.getElements( ).size( ) );
        assertEquals( elementConnection2, partitionFromConnection2.getElements( ).iterator( ).next( ) );
        assertEquals( 1, elementConnection2.getManyPrimitiveOrdered( ).size( ) );
        assertEquals( newValue, elementConnection2.getManyPrimitiveOrdered( ).get( 0 ) );
    }


    @Test
    public void testDataTypeAttributeSetElementCopyOnWriteRedo( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        final A4 elementConnection1 = connection1.createElementInPartition( A4.class, partitionFromConnection1 );
        assertEquals( 0, elementConnection1.getManyPrimitiveOrdered( ).size( ) );
        final String value = "COW";
        final String newValue = "NEW";
        List<String> manyPrimitiveOrderedList = elementConnection1.getManyPrimitiveOrdered( );
        manyPrimitiveOrderedList.add( value );
        assertEquals( 1, manyPrimitiveOrderedList.size( ) );
        assertEquals( value, manyPrimitiveOrderedList.get( 0 ) );

        //save to make sure partition can also be seen in connection2 and no private copy exists
        connection1.save( );

        assertNoPrivateCopy( partitionFromConnection1 );
        final ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        assertNotNull( partitionFromConnection2 ); //partition must be visible in connection2
        assertNoPrivateCopy( partitionFromConnection2 );

        //do
        manyPrimitiveOrderedList.set( 0, newValue );
        assertEquals( 1, manyPrimitiveOrderedList.size( ) );
        assertEquals( newValue, manyPrimitiveOrderedList.get( 0 ) );

        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertEquals( 1, manyPrimitiveOrderedList.size( ) );
        assertEquals( value, manyPrimitiveOrderedList.get( 0 ) );

        //change affected partition with other session
        partitionFromConnection2.createElement( MofClass.class );
        connection2.save( );

        //redo
        commandStack.redo( );
        assertEquals( 1, manyPrimitiveOrderedList.size( ) );
        assertEquals( newValue, manyPrimitiveOrderedList.get( 0 ) );
    }


    @Test
    public void testElementAssignToPartition( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        final A4 elementConnection1 = connection1.createElementInPartition( A4.class, partitionFromConnection1 );

        //save to make sure partition can also be seen in connection2 and no private copy exists
        connection1.save( );
        final ModelPartition newPartitionConnection1 = getPartitionTwo( );
        final ModelPartition newPartitionConnection2 = connection2.getPartition( newPartitionConnection1.getPri( ) );
        assertNoPrivateCopy( newPartitionConnection1 );
        assertNoPrivateCopy( newPartitionConnection2 );


        assertNoPrivateCopy( partitionFromConnection1 );
        final ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        assertNotNull( partitionFromConnection2 ); //partition must be visible in connection2
        assertNoPrivateCopy( partitionFromConnection2 );
        final A4 elementConnection2 = (A4) connection2.getElement( elementConnection1.get___Mri( ) );

        Command command = new TestCommand( connection1 ) {

            @Override
            public void doExecute( ) {

                elementConnection1.assign___Partition( newPartitionConnection1 );
            }
        };

        DoUndoRedoTestAsserter asserter = new DoUndoRedoTestAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                //connection1
                assertEquals( newPartitionConnection1, elementConnection1.get___Partition( ) );
                assertPrivateCopy( connection1.getSession( ), newPartitionConnection1 );
                //connection2
                assertEquals( partitionFromConnection2, elementConnection2.get___Partition( ) );
                assertNoPrivateCopy( newPartitionConnection2 );
                assertNoPrivateCopy( partitionFromConnection2 );

            }

            @Override
            public void assertAfterUndo( ) {

                //connection1
                assertEquals( partitionFromConnection1, elementConnection1.get___Partition( ) );

                //connection2
                assertEquals( partitionFromConnection2, elementConnection2.get___Partition( ) );
                assertNoPrivateCopy( newPartitionConnection2 );
                assertNoPrivateCopy( partitionFromConnection2 );

            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

            }

        };

        runDoUndoRedoTest( command, asserter );


        //no more private copy must exist after save
        connection1.save( );

        //connection1
        assertEquals( newPartitionConnection1, elementConnection1.get___Partition( ) );
        assertNoPrivateCopy( newPartitionConnection1 );
        //connection2
        assertEquals( newPartitionConnection2, elementConnection2.get___Partition( ) );
        assertNoPrivateCopy( newPartitionConnection2 );
        assertSameUnderlyingCoreModelPartition( newPartitionConnection1, newPartitionConnection2 );

    }

    @Test
    public void testElementAssignToPartitionCopyOnWriteRedo( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        final A4 elementConnection1 = connection1.createElementInPartition( A4.class, partitionFromConnection1 );


        //save to make sure partition can also be seen in connection2 and no private copy exists
        connection1.save( );
        final ModelPartition newPartitionConnection1 = getPartitionTwo( );
        final ModelPartition newPartitionConnection2 = connection2.getPartition( newPartitionConnection1.getPri( ) );
        assertNoPrivateCopy( newPartitionConnection1 );
        assertNoPrivateCopy( newPartitionConnection2 );


        assertNoPrivateCopy( partitionFromConnection1 );
        final ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        assertNotNull( partitionFromConnection2 ); //partition must be visible in connection2
        assertNoPrivateCopy( partitionFromConnection2 );
        final A4 elementConnection2 = (A4) connection2.getElement( elementConnection1.get___Mri( ) );

        Command command = new TestCommand( connection1 ) {

            @Override
            public void doExecute( ) {

                elementConnection1.assign___Partition( newPartitionConnection1 );
            }
        };

        //more advanced test: 
        //Do assignment in one session, then undo it
        //Do something with same partitions in other session and save
        //Redo action in first session
        command = new TestCommand( connection1 ) {

            @Override
            public void doExecute( ) {

                elementConnection1.assign___Partition( newPartitionConnection1 );
            }
        };

        command.execute( );
        assertEquals( newPartitionConnection1, elementConnection1.get___Partition( ) );
        connection1.getCommandStack( ).undo( );
        assertEquals( partitionFromConnection1, elementConnection1.get___Partition( ) );

        //change the involved partitions by creating elements
        partitionFromConnection2.createElement( MofClass.class );
        newPartitionConnection2.createElement( MofClass.class );
        connection2.save( );

        //connection1
        assertEquals( partitionFromConnection1, elementConnection1.get___Partition( ) );

        connection1.getCommandStack( ).redo( );

        assertEquals( newPartitionConnection1, elementConnection1.get___Partition( ) );

        connection1.save( );
        assertEquals( newPartitionConnection1, elementConnection1.get___Partition( ) );
        assertEquals( newPartitionConnection2, elementConnection2.get___Partition( ) );

    }

    @Test
    public void testInstanceCreate( ) throws Exception {

    }

    @Test
    public void testInstanceCreateCopyOnWriteRedo( ) throws Exception {

        Connection connection1 = getMOINConnection( );
        Connection connection2 = getSecondMOINConnection( );
        ModelPartition partitionFromConnection1 = getPartitionOne( );

        connection1.save( );

        //do
        MofClass createdElement = partitionFromConnection1.createElement( MofClass.class );
        assertEquals( 1, partitionFromConnection1.getElements( ).size( ) );
        assertEquals( createdElement, partitionFromConnection1.getElements( ).iterator( ).next( ) );

        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertEquals( 0, partitionFromConnection1.getElements( ).size( ) );
        assertFalse( createdElement.is___Alive( ) );

        //change partition in other session
        ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        partitionFromConnection2.createElement( MofPackage.class );
        connection2.save( );

        //redo
        commandStack.redo( );
        Collection<Partitionable> elements = partitionFromConnection1.getElements( );
        assertEquals( 2, elements.size( ) );
        assertTrue( elements.contains( createdElement ) );
    }

    @Test
    public void testInstanceDelete( ) throws Exception {

    }

    @Test
    public void testInstanceDeleteCopyOnWriteRedo( ) throws Exception {

        Connection connection1 = getMOINConnection( );
        Connection connection2 = getSecondMOINConnection( );
        ModelPartition partitionFromConnection1 = getPartitionOne( );
        MofClass elementToDelete = partitionFromConnection1.createElement( MofClass.class );
        connection1.save( );

        //do
        assertEquals( 1, partitionFromConnection1.getElements( ).size( ) );
        elementToDelete.refDelete( );
        assertFalse( elementToDelete.is___Alive( ) );
        assertEquals( 0, partitionFromConnection1.getElements( ).size( ) );

        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertTrue( elementToDelete.is___Alive( ) );
        assertEquals( 1, partitionFromConnection1.getElements( ).size( ) );

        //change the partition in other session
        ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        MofClass element = (MofClass) partitionFromConnection2.getElements( ).iterator( ).next( );
        element.setName( "someNewName" );
        connection2.save( );

        //redo
        commandStack.redo( );
        assertFalse( elementToDelete.is___Alive( ) );
        assertEquals( 0, partitionFromConnection1.getElements( ).size( ) );
    }

    @Test
    public void testLinkAddElement( ) throws Exception {

    }

    @Test
    public void testLinkAddElementCopyOnWriteRedo( ) throws Exception {

        Connection connection1 = getMOINConnection( );
        ModelPartition partitionOfParentPackage = getPartitionOne( );
        ModelPartition partitionOfNestedPackage = getPartitionTwo( );
        MofPackage parentMofPackage = partitionOfParentPackage.createElement( MofPackage.class );
        parentMofPackage.setName( "parentPackage" );
        MofPackage nestedMofPackage = partitionOfNestedPackage.createElement( MofPackage.class );
        nestedMofPackage.setName( "nestedPackage" );

        connection1.save( );

        assertNull( nestedMofPackage.getContainer( ) );
        assertNoPrivateCopy( partitionOfNestedPackage );
        assertNoPrivateCopy( partitionOfParentPackage );

        parentMofPackage.getContents( ).add( nestedMofPackage );

        //state after do
        assertPrivateCopy( connection1.getSession( ), partitionOfParentPackage );
        assertEquals( nestedMofPackage, parentMofPackage.getContents( ).get( 0 ) );

        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );

        //state after undo
        assertEquals( 0, parentMofPackage.getContents( ).size( ) );

        //change private copy partition with other session
        Connection connection2 = getSecondMOINConnection( );
        ModelPartition partitionOfParentPackageSession2 = connection2.getPartition( partitionOfParentPackage.getPri( ) );
        partitionOfParentPackageSession2.createElement( MofClass.class );
        connection2.save( );

        commandStack.redo( );

        //state after redo
        assertPrivateCopy( connection1.getSession( ), partitionOfParentPackage );
        assertEquals( nestedMofPackage, parentMofPackage.getContents( ).get( 0 ) );

    }

    @Test
    public void testLinkRemoveElement( ) throws Exception {

    }

    @Test
    public void testLinkRemoveElementCopyOnWriteRedo( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );

        MofPackage originallyContainedPackage = partitionFromConnection1.createElement( MofPackage.class );
        MofPackage parentPackage = partitionFromConnection1.createElement( MofPackage.class );

        List<ModelElement> contents = parentPackage.getContents( );

        assertEquals( 0, contents.size( ) );
        contents.add( originallyContainedPackage );
        assertEquals( 1, contents.size( ) );
        assertEquals( originallyContainedPackage, contents.get( 0 ) );

        connection1.save( );
        ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );

        //do
        Iterator<ModelElement> iterator = contents.iterator( );
        iterator.next( );
        iterator.remove( );
        assertEquals( 0, contents.size( ) );

        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertEquals( 1, contents.size( ) );
        assertEquals( originallyContainedPackage, contents.get( 0 ) );

        //change affected partition with other session
        partitionFromConnection2.createElement( MofClass.class );
        connection2.save( );

        //redo
        commandStack.redo( );
        assertEquals( 0, contents.size( ) );
    }

    @Test
    public void testLinkSetElement( ) throws Exception {

    }

    @Test
    public void testLinkSetElementCopyOnWriteRedo( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );

        MofPackage originallyContainedPackage = partitionFromConnection1.createElement( MofPackage.class );
        MofPackage parentPackage = partitionFromConnection1.createElement( MofPackage.class );
        MofPackage newlyContainedPackage = partitionFromConnection1.createElement( MofPackage.class );

        assertEquals( 0, parentPackage.getContents( ).size( ) );
        parentPackage.getContents( ).add( originallyContainedPackage );
        assertEquals( 1, parentPackage.getContents( ).size( ) );
        assertEquals( originallyContainedPackage, parentPackage.getContents( ).get( 0 ) );

        connection1.save( );
        ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );

        //do
        parentPackage.getContents( ).set( 0, newlyContainedPackage );
        assertEquals( 1, parentPackage.getContents( ).size( ) );
        assertEquals( newlyContainedPackage, parentPackage.getContents( ).get( 0 ) );

        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertEquals( 1, parentPackage.getContents( ).size( ) );
        assertEquals( originallyContainedPackage, parentPackage.getContents( ).get( 0 ) );

        //change affected partition with other session
        partitionFromConnection2.createElement( MofClass.class );
        connection2.save( );

        //redo
        commandStack.redo( );
        assertEquals( 1, parentPackage.getContents( ).size( ) );
        assertEquals( newlyContainedPackage, parentPackage.getContents( ).get( 0 ) );
    }

    @Test
    public void testReferenceChange( ) throws Exception {

    }

    @Test
    public void testReferenceChangeCopyOnWriteRedo( ) throws Exception {

        Connection connection1 = getMOINConnection( );
        ModelPartition partitionOfParentPackage = getPartitionOne( );
        ModelPartition partitionOfNestedPackage = getPartitionTwo( );
        MofPackage parentMofPackage = partitionOfParentPackage.createElement( MofPackage.class );
        parentMofPackage.setName( "parentPackage" );
        MofPackage nestedMofPackage = partitionOfNestedPackage.createElement( MofPackage.class );
        nestedMofPackage.setName( "nestedPackage" );

        connection1.save( );

        assertNull( nestedMofPackage.getContainer( ) );
        assertNoPrivateCopy( partitionOfNestedPackage );
        assertNoPrivateCopy( partitionOfParentPackage );

        nestedMofPackage.setContainer( parentMofPackage );

        //state after do
        assertPrivateCopy( connection1.getSession( ), partitionOfParentPackage );
        assertEquals( parentMofPackage, nestedMofPackage.getContainer( ) );

        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );

        //state after undo
        assertNull( nestedMofPackage.getContainer( ) );

        //change private copy partition with other session
        Connection connection2 = getSecondMOINConnection( );
        ModelPartition partitionOfParentPackageSession2 = connection2.getPartition( partitionOfParentPackage.getPri( ) );
        partitionOfParentPackageSession2.createElement( MofClass.class );
        connection2.save( );

        commandStack.redo( );

        //state after redo
        assertPrivateCopy( connection1.getSession( ), partitionOfParentPackage );
        assertEquals( parentMofPackage, nestedMofPackage.getContainer( ) );

    }



    @Test
    public void testObjectAttributeAddElement( ) throws Exception {

    }


    @Test
    public void testObjectAttributeAddElementCopyOnWriteRedo( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        A26 a26_1 = partitionFromConnection1.createElement( A26.class );
        A26 attributeValue = partitionFromConnection1.createElement( A26.class );

        List<RefObject> reflectToManyList = a26_1.getReflectToMany( );

        connection1.save( );
        final ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );


        //do
        reflectToManyList.add( attributeValue );
        assertEquals( 1, reflectToManyList.size( ) );
        assertEquals( attributeValue, reflectToManyList.get( 0 ) );

        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertEquals( 0, reflectToManyList.size( ) );

        //change the affected partition with other session
        partitionFromConnection2.createElement( MofClass.class );
        connection2.save( );

        //redo
        commandStack.redo( );
        assertEquals( 1, reflectToManyList.size( ) );
        assertEquals( attributeValue, reflectToManyList.get( 0 ) );
    }

    @Test
    public void testObjectAttributeChange( ) throws Exception {

    }

    @Test
    public void testObjectAttributeChangeCopyOnWriteRedo( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        A26 a26_1 = partitionFromConnection1.createElement( A26.class );
        A26 attributeValue = partitionFromConnection1.createElement( A26.class );

        connection1.save( );
        final ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        assertEquals( null, a26_1.getReflectToOne( ) );

        //do
        a26_1.setReflectToOne( attributeValue );
        assertEquals( attributeValue, a26_1.getReflectToOne( ) );

        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertEquals( null, a26_1.getReflectToOne( ) );

        //change affected partition with other session
        partitionFromConnection2.createElement( MofClass.class );
        connection2.save( );

        //redo
        commandStack.redo( );
        assertEquals( attributeValue, a26_1.getReflectToOne( ) );


    }



    @Test
    public void testObjectAttributeRemoveElement( ) throws Exception {

    }

    @Test
    public void testObjectAttributeRemoveElementCopyOnWriteRedo( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        A26 a26_1 = partitionFromConnection1.createElement( A26.class );
        A26 originalValue = partitionFromConnection1.createElement( A26.class );

        final ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );

        List<RefObject> reflectToManyList = a26_1.getReflectToMany( );
        reflectToManyList.add( originalValue );
        assertEquals( 1, reflectToManyList.size( ) );
        assertEquals( originalValue, reflectToManyList.get( 0 ) );
        connection1.save( );

        //do
        reflectToManyList.remove( 0 );
        assertEquals( 0, reflectToManyList.size( ) );

        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertEquals( 1, reflectToManyList.size( ) );
        assertEquals( originalValue, reflectToManyList.get( 0 ) );

        //change the affected partition with other session
        partitionFromConnection2.createElement( MofClass.class );
        connection2.save( );

        //redo
        commandStack.redo( );
        assertEquals( 0, reflectToManyList.size( ) );
    }

    @Test
    public void testObjectAttributeSetElement( ) throws Exception {

    }

    @Test
    public void testObjectAttributeSetElementCopyOnWriteRedo( ) throws Exception {

        final Connection connection1 = getMOINConnection( );
        final Connection connection2 = getSecondMOINConnection( );

        final ModelPartition partitionFromConnection1 = getPartitionOne( );
        A26 a26_1 = partitionFromConnection1.createElement( A26.class );
        A26 originalValue = partitionFromConnection1.createElement( A26.class );
        A26 newValue = partitionFromConnection1.createElement( A26.class );


        final ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );

        List<RefObject> reflectToManyList = a26_1.getReflectToMany( );
        reflectToManyList.add( originalValue );
        assertEquals( 1, reflectToManyList.size( ) );
        assertEquals( originalValue, reflectToManyList.get( 0 ) );
        connection1.save( );

        //do
        reflectToManyList.set( 0, newValue );
        assertEquals( 1, reflectToManyList.size( ) );
        assertEquals( newValue, reflectToManyList.get( 0 ) );

        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertEquals( 1, reflectToManyList.size( ) );
        assertEquals( originalValue, reflectToManyList.get( 0 ) );

        //change the affected partition with other session
        partitionFromConnection2.createElement( MofClass.class );
        connection2.save( );

        //redo
        commandStack.redo( );
        assertEquals( 1, reflectToManyList.size( ) );
        assertEquals( newValue, reflectToManyList.get( 0 ) );

    }

    @Test
    public void testPartitionCreate( ) throws Exception {

    }

    @Test
    public void testPartitionDeleteElements( ) throws Exception {

    }

    @Test
    public void testPartitionDeleteElementsCopyOnWriteRedo( ) throws Exception {

        Connection connection1 = getMOINConnection( );
        Connection connection2 = getSecondMOINConnection( );
        ModelPartition partitionFromConnection1 = getPartitionOne( );
        partitionFromConnection1.createElement( MofClass.class );
        partitionFromConnection1.createElement( MofClass.class );
        connection1.save( );
        assertEquals( 2, partitionFromConnection1.getElements( ).size( ) );
        ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        assertNotNull( partitionFromConnection2 );


        //do
        partitionFromConnection1.deleteElements( );
        assertTrue( partitionFromConnection1.isAlive( ) );
        assertTrue( partitionFromConnection1.getElements( ).isEmpty( ) );

        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertEquals( 2, partitionFromConnection1.getElements( ).size( ) );

        //change the affected partition in other session
        Partitionable element = partitionFromConnection2.getElements( ).iterator( ).next( );
        MofClass aMofClass = (MofClass) element;
        aMofClass.setName( "someNewName" );
        connection2.save( );

        //redo
        commandStack.redo( );
        assertTrue( partitionFromConnection1.isAlive( ) );
        assertTrue( partitionFromConnection1.getElements( ).isEmpty( ) );
    }

    @Test
    public void testPartitionDelete( ) throws Exception {

    }

    @Test
    public void testPartitionDeleteCopyOnWriteRedo( ) throws Exception {

        Connection connection1 = getMOINConnection( );
        Connection connection2 = getSecondMOINConnection( );
        ModelPartition partitionFromConnection1 = getPartitionOne( );
        connection1.save( );
        ModelPartition partitionFromConnection2 = connection2.getPartition( partitionFromConnection1.getPri( ) );
        assertNotNull( partitionFromConnection2 );

        //do
        partitionFromConnection1.delete( );
        assertFalse( partitionFromConnection1.isAlive( ) );
        assertEquals( null, connection1.getPartition( partitionFromConnection1.getPri( ) ) );

        //undo
        CommandStack commandStack = connection1.getCommandStack( );
        commandStack.undo( );
        assertNotNull( connection1.getPartition( partitionFromConnection1.getPri( ) ) );
        assertTrue( partitionFromConnection1.isAlive( ) );

        //change partition in other session
        partitionFromConnection2.createElement( MofClass.class );
        connection2.save( );

        //redo
        commandStack.redo( );
        assertFalse( partitionFromConnection1.isAlive( ) );
        assertEquals( null, connection1.getPartition( partitionFromConnection1.getPri( ) ) );
    }

    @Test
    public void testTransientPartitionCreate( ) throws Exception {

    }
}