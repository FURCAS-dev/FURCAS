package com.sap.tc.moin.repository.test.transactions.microtransactionables;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionCreatingNotPossibleException;
import com.sap.tc.moin.repository.PartitionDeletingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.Transactionable;
import com.sap.tc.moin.testcases.case004.C4;
import com.sap.tc.moin.testcases.case004.F4;
import com.sap.tc.moin.testcases.case010.B10;

@SuppressWarnings( "nls" )
public class TestMicroTransactionablesPartition extends BaseMicroTransactionablesPartitionTest {

    @Test
    public void testCreatePartition( ) {

        // create a partition
        String dataAreaName = this._testClient1.getClientSpec( ).getDataArea( ).getName( );
        String facilityId = this._testClient1.getFacility( ).getId( );
        String containerName = this._testClient1.getDefaultContainerName( );
        String partitionName = makePartitionName( "src/partitionMMCreated" );
        PRI pri = this.clientSpecificWorkspace.getWorkspaceSet( ).getMoin( ).createPri( facilityId, dataAreaName, containerName, partitionName );
        partitionCreate( pri );
    }

    @Test
    public void testCreateExistingPartition( ) {

        // create a before created partition again
        String dataAreaName = this._testClient1.getClientSpec( ).getDataArea( ).getName( );
        String facilityId = this._testClient1.getFacility( ).getId( );
        String containerName = this._testClient1.getDefaultContainerName( );
        String partitionName = makePartitionName( "src/partitionMMCreatedBefore" );
        PRI pri = this.clientSpecificWorkspace.getWorkspaceSet( ).getMoin( ).createPri( facilityId, dataAreaName, containerName, partitionName );
        getMOINConnection( ).createPartition( pri );
        try {
            partitionCreate( pri );
            errorAndStop( "Creation of a partition, that already exists, should have thrown a PartitionCreatingNotPossibleException" );
        } catch ( PartitionCreatingNotPossibleException partitionCreatingNotPossibleEx ) {
            // partition already exists
        }
    }

    @Test
    public void testDeleteEmptyPartition( ) {

        // delete a before saved partition
        ModelPartition partitionSaved = this._testClient1.getOrCreatePartitionStable( "partitionMMSaved" );
        save( );
        partitionDelete( partitionSaved );
        // detete a before not saved partition
        ModelPartition partitionUnsaved = this._testClient1.createPartition( "partitionMMUnsaved" );
        partitionDelete( partitionUnsaved );
    }

    @Test
    public void testDeleteNotEmptyPartition( ) {

        // delete a before saved partition with one element in it
        ModelPartition partitionSaved = this._testClient1.getOrCreatePartitionStable( "partitionMMSaved" );
        B10 b10 = createB10( );
        partitionSaved.assignElement( b10 );
        save( );
        partitionDelete( partitionSaved );
        // delete a before saved partition with more than one element in it: C4
        // has an attribute of type B4
        partitionSaved = this._testClient1.getOrCreatePartitionStable( "partitionMMSaved" );
        C4 c4 = createC4( );
        partitionSaved.assignElementIncludingChildren( c4 );
        save( );
        partitionDelete( partitionSaved );
        // delete a before saved partition with more than one element in it: F4
        // and C4 are associated via hasCs
        partitionSaved = this._testClient1.getOrCreatePartitionStable( "partitionMMSaved" );
        c4 = (C4) this.c4Class.refCreateInstance( );
        F4 f4 = (F4) this.f4Class.refCreateInstance( );
        this.case004Package.getHasCs( ).add( f4, c4 );
        partitionSaved.assignElement( f4 );
        partitionSaved.assignElement( c4 );
        partitionDelete( partitionSaved );
        // delete a before saved and then changed partition
        partitionSaved = this._testClient1.getOrCreatePartitionStable( "partitionMMSaved" );
        save( );
        b10 = createB10( );
        partitionSaved.assignElementIncludingChildren( b10 );
        partitionDelete( partitionSaved );
        // delete a before not saved partition
        ModelPartition partitionUnsaved = this._testClient1.createPartition( "partitionMMUnsaved" );
        b10 = createB10( );
        partitionUnsaved.assignElementIncludingChildren( b10 );
        partitionDelete( partitionUnsaved );
    }

    @Test
    public void testDeleteNullPartition( ) {

        // delete the null partition
        try {
            partitionDelete( nullPartition );
            errorAndStop( "partition is null partition, should have thrown an PartitionDeletingNotPossibleException" );
        } catch ( PartitionDeletingNotPossibleException partitionDeletingNotPossibleEx ) {
            // null partition can not be deleted
        }
    }

    @Test
    public void testDeleteMetamodelPartition( ) {

        ModelPartition metamodelPartition = ( (Partitionable) this.testcasesPackage ).get___Partition( );
        // delete a metamodel partition
        try {
            partitionDelete( metamodelPartition );
            errorAndStop( "partition is metamodel partition, should have thrown an PartitionDeletingNotPossibleException" );
        } catch ( PartitionDeletingNotPossibleException partitionDeletingNotPossibleEx ) {
            // metamodel partition can not be deleted
        }
    }

    @Test
    public void testDeleteElements( ) {

        // empty partition: delete elements
        ModelPartition partition = getPartitionOne( );
        partitionDeleteElements( partition );
        // C4: has an attribute of type B4
        C4 c4 = createC4( );
        partition.assignElementIncludingChildren( c4 );
        partitionDeleteElements( partition );
        partition.deleteElements( );
        // F4 and C4: associated via hasCs
        c4 = (C4) this.c4Class.refCreateInstance( );
        F4 f4 = (F4) this.f4Class.refCreateInstance( );
        this.case004Package.getHasCs( ).add( f4, c4 );
        partition.assignElement( f4 );
        partition.assignElement( c4 );
        partitionDeleteElements( partition );
    }

    @Test
    public void testAlreadyExistingTransientLock( ) throws Exception {

        final PRI pri = getPartitionThree( ).getPri( );
        final Connection owner = getMOINConnection( );
        // get the lock before the actual test logic
        this.lockManager.obtainTransientLock( pri, owner );

        // make sure lock already existing
        assertLocked( this.lockManager, pri, owner );

        ObtainTransientLockTestTransaction obtainTransientLockTransaction = new ObtainTransientLockTestTransaction( this.lockManager, owner, pri );

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // must be locked after do
                assertLocked( TestMicroTransactionablesPartition.this.lockManager, pri, owner );
            }

            @Override
            public void assertAfterUndo( ) {

                // undo must NOT release the lock as it was locked before
                assertLocked( TestMicroTransactionablesPartition.this.lockManager, pri, owner );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( "Didn't expect any events", 0, receivedEvents.size( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( "Didn't expect any events", 0, receivedEvents.size( ) );
            }

        };

        runDoUndoRedoTest( getMOINConnection( ), obtainTransientLockTransaction, asserter );

    }

    @Test
    public void testNonExistingTransientLock( ) throws Exception {

        getMOINConnection( ).save( ); // in order to make sure that all locks are released
        final Connection owner = getMOINConnection( );
        final PRI pri = getPartitionOne( ).getPri( );
        // make sure not already locked
        assertNotLocked( this.lockManager, pri );

        ObtainTransientLockTestTransaction obtainTransientLockTransactionable = new ObtainTransientLockTestTransaction( this.lockManager, owner, pri );

        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // do must lock it as it was NOT locked before
                assertLocked( TestMicroTransactionablesPartition.this.lockManager, pri, owner );
            }

            @Override
            public void assertAfterUndo( ) {

                // undo must release the lock as it was NOT locked before
                assertNotLocked( TestMicroTransactionablesPartition.this.lockManager, pri );
            }

            @Override
            public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( "Didn't expect any events", 0, receivedEvents.size( ) );
            }

            @Override
            public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

                assertSame( "Didn't expect any events", 0, receivedEvents.size( ) );
            }

        };

        runDoUndoRedoTest( getMOINConnection( ), obtainTransientLockTransactionable, asserter );

    }

    @Test
    public void testAlreadyDirtyPartition( ) throws Exception {

        final ModelPartition partition = getPartitionOne( );
        B10 b10 = createB10( );
        // make partition dirty before test begins
        partition.assignElement( b10 );
        assertDirty( partition );
        Transactionable transactionable = new Transactionable( ) {

            public void runInTransaction( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException, NullPointerException {

                // assign an element to the partition, this action makes the partition dirty if it wasn't dirty before
                B10 b10 = createB10( );
                partition.assignElement( b10 );
            }

            public CoreConnection getConnection( ) {

                return coreConnection;
            }
        };
        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // partition is still dirty
                assertDirty( partition );
            }

            @Override
            public void assertAfterUndo( ) {

                // partition is still dirty because it was already dirty before the transaction
                assertDirty( partition );
            }
        };
        runDoUndoRedoTest( getMOINConnection( ), transactionable, asserter );
    }

    @Test
    public void testNotDirtyPartition( ) throws Exception {

        getMOINConnection( ).save( ); // in order to make sure that no partition is dirty
        final ModelPartition partition = getPartitionOne( );
        assertNotDirty( partition );
        Transactionable transactionable = new Transactionable( ) {

            public void runInTransaction( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException, NullPointerException {

                // assign an element to the partition, this action makes the partition dirty if it wasn't dirty before
                B10 b10 = createB10( );
                partition.assignElement( b10 );
            }

            public CoreConnection getConnection( ) {

                return coreConnection;
            }
        };
        DoUndoRedoTestAsserter asserter = new EmptyAsserter( ) {

            @Override
            public void assertAfterDo( ) {

                // partition is dirty now
                assertDirty( partition );
            }

            @Override
            public void assertAfterUndo( ) {

                // partition should not be dirty after undo, because it wasn't dirty before, too
                assertNotDirty( partition );
            }
        };
        runDoUndoRedoTest( getMOINConnection( ), transactionable, asserter );
    }

    private void save( ) {

        try {
            getMOINConnection( ).save( );
        } catch ( PartitionsNotSavedException partitionsNotSavedEx ) {
            errorAndStop( "Error during partition save", partitionsNotSavedEx );
        }
    }

}
