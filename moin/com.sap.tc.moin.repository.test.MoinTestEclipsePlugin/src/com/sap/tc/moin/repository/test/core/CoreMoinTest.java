/*
 * Created on 08.06.2006
 */
package com.sap.tc.moin.repository.test.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.core.LogicalLinkManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.impl.CheckResult;
import com.sap.tc.moin.repository.core.impl.MoinCoreConsistencyChecker;
import com.sap.tc.moin.repository.core.impl.MoinImpl;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.TransactionManager;
import com.sap.tc.moin.repository.transactions.Transactionable;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.testcase.MoinTestCase;

public class CoreMoinTest extends MoinTestCase {

    protected TestClient _testClient1;

    protected TestClient _testClient2;

    private ModelPartition _partitionOne;

    private ModelPartition _partitionTwo;

    private ModelPartition _partitionThree;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        _testClient1 = getTestHelper( ).getDefaultTestClient( 1, 0, true );
        _testClient2 = getTestHelper( ).getDefaultTestClient( 2, 0, true );

        _testClient1.setAsCurrentClient( );

        _partitionOne = _testClient1.getOrCreatePartition( "partition_1" );
        _partitionTwo = _testClient1.getOrCreatePartition( "partition_2" );
        _partitionThree = _testClient1.getOrCreatePartition( "partition_3" );

        boolean needsSaving = false;

        if ( !_partitionOne.getElements( ).isEmpty( ) ) {
            _partitionOne.deleteElements( );
            needsSaving = true;
        }

        if ( !_partitionTwo.getElements( ).isEmpty( ) ) {
            _partitionTwo.deleteElements( );
            needsSaving = true;
        }

        if ( !_partitionThree.getElements( ).isEmpty( ) ) {
            _partitionThree.deleteElements( );
            needsSaving = true;
        }

        if ( needsSaving ) {
            _testClient1.getConnection( ).save( );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        if ( MoinImpl.MOIN_CORE_CONSISTENCY_CHECKS ) {
            MoinCoreConsistencyChecker checker = new MoinCoreConsistencyChecker( getTestHelper( ).getCoreMoin( ), false /* withoutLocks */);
            CheckResult checkResult = checker.performAllChecks( );
            assertTrue( checkResult.toString( ), checkResult.isEmpty( ) );
        }

        _partitionOne = null;
        _partitionTwo = null;
        _partitionThree = null;

        if ( _testClient1 != null ) {
            _testClient1.delete( );
//            _testClient1.clear( );
//            _testClient1 = null;
        }

        if ( _testClient2 != null ) {
            _testClient2.delete( );
//            _testClient2.clear( );
//            _testClient2 = null;
        }

        // clean handling of Moin reset.
        super.afterTestMethod( );
    }

    public Connection getMOINConnection( ) {

        _testClient1.setAsCurrentClient( );
        return _testClient1.getConnection( );
    }

    public Connection getSecondMOINConnection( ) {

        _testClient2.setAsCurrentClient( );
        return _testClient2.getConnection( );
    }

    protected LogicalLinkManager getLinkActionManager( Connection connection ) {

        return getTestHelper( ).getCoreSession( connection.getSession( ) ).getWorkspaceSet( ).getLogicalLinkManager( );
    }

    protected Workspace getClientSpecificWorkspace( Connection connection ) {

        return getTestHelper( ).getCoreConnection( connection ).getSession( ).getWorkspace( );
    }

    public ModelPartition getPartitionOne( ) {

        return _partitionOne;
    }

    public ModelPartition getPartitionTwo( ) {

        return _partitionTwo;
    }

    public ModelPartition getPartitionThree( ) {

        return _partitionThree;
    }

    protected void runDoUndoRedoTest( Command command, DoUndoRedoTestAsserter asserter ) throws Exception {

        this.runDoUndoRedoTest( command.getConnection( ), command, asserter );
    }

    protected void runDoUndoRedoTest( Connection connection, Command command, DoUndoRedoTestAsserter asserter ) throws Exception {

        this.runDoUndoRedoTest( connection, (Object) command, asserter );
    }

    protected void runDoUndoRedoTest( Connection connection, Transactionable transactionable, DoUndoRedoTestAsserter asserter ) throws ExecutionCancelledException, UnrecoverableExecutionException, ExecutionRollbackFailedException, RuntimeException {

        this.runDoUndoRedoTest( connection, (Object) transactionable, asserter );
    }

    private void runDoUndoRedoTest( Connection connection, Object transactionableOrCommand, DoUndoRedoTestAsserter asserter ) throws ExecutionCancelledException, UnrecoverableExecutionException, ExecutionRollbackFailedException, RuntimeException {

        boolean isCommand = false;
        if ( transactionableOrCommand instanceof Command ) {
            isCommand = true;
        } else if ( transactionableOrCommand instanceof Transactionable ) {
            isCommand = false;
        } else {
            fail( "Expected either Command or Transactionable, but was " + transactionableOrCommand.getClass( ) );
        }

        TransactionManager transactionManager = getTestHelper( ).getCoreConnection( connection ).getSession( ).getTransactionManager( );

        DoUndoRedoPreChangeListener eventListener = new DoUndoRedoPreChangeListener( );
        EventFilter filter = asserter.getEventFilter( );
        connection.getSession( ).getEventRegistry( ).registerListener( eventListener, filter );
        connection.getSession( ).getEventRegistry( ).registerPreChangeListener( eventListener, filter );

        // do
        try {
            if ( isCommand ) {
                connection.getCommandStack( ).execute( (Command) transactionableOrCommand );
            } else {
                transactionManager.runInTransaction( (Transactionable) transactionableOrCommand );
            }
        } catch ( ExecutionRollbackFailedException executionRollbackFailedEx ) {
            throw executionRollbackFailedEx;
        } catch ( UnrecoverableExecutionException unrecoverableExecutionEx ) {
            throw unrecoverableExecutionEx;
        } catch ( RuntimeException runtimeEx ) {
            // recoverable exception occurred, check initial state
            asserter.assertBeforeDo( );
            throw runtimeEx;
        }

        // check state after do
        asserter.assertAfterDo( );

        // check pre events after do
        asserter.assertExpectedPreEventsAfterDo( eventListener.getReceivedPreEvents( ) );

        // check post events after do
        asserter.assertExpectedPostEventsAfterDo( eventListener.getReceivedPostEvents( ) );

        // clear the events after do
        eventListener.clearReceivedPreEvents( );
        eventListener.clearReceivedPostEvents( );

        // undo
        connection.getCommandStack( ).undo( );

        // check state after undo
        asserter.assertAfterUndo( );

        // check pre events after undo
        asserter.assertExpectedPreEventsAfterUndo( eventListener.getReceivedPreEvents( ) );

        // check post events after undo
        asserter.assertExpectedPostEventsAfterUndo( eventListener.getReceivedPostEvents( ) );

        // clear the events after undo
        eventListener.clearReceivedPreEvents( );
        eventListener.clearReceivedPostEvents( );

        // redo
        connection.getCommandStack( ).redo( );

        // check state after redo
        asserter.assertAfterRedo( );

        // check pre events after redo
        asserter.assertExpectedPreEventsAfterRedo( eventListener.getReceivedPreEvents( ) );

        // check post events after redo
        asserter.assertExpectedPostEventsAfterRedo( eventListener.getReceivedPostEvents( ) );

        // clear the events after redo
        eventListener.clearReceivedPreEvents( );
        eventListener.clearReceivedPostEvents( );

        // undoRedo
        connection.getCommandStack( ).undo( );

        // check state after undoRedo
        asserter.assertAfterUndoRedo( );

        // check pre events after undoRedo
        asserter.assertExpectedPreEventsAfterUndoRedo( eventListener.getReceivedPreEvents( ) );

        // check post events after undoRedo
        asserter.assertExpectedPostEventsAfterUndoRedo( eventListener.getReceivedPostEvents( ) );

        // clear the events after undoRedo
        eventListener.clearReceivedPreEvents( );
        eventListener.clearReceivedPostEvents( );

        // redoUndoRedo
        connection.getCommandStack( ).redo( );

        // check state after redoUndoRedo
        asserter.assertAfterRedoUndoRedo( );

        // check pre events after redoUndoRedo
        asserter.assertExpectedPreEventsAfterRedoUndoRedo( eventListener.getReceivedPreEvents( ) );

        // check post events after redoUndoRedo
        asserter.assertExpectedPostEventsAfterRedoUndoRedo( eventListener.getReceivedPostEvents( ) );

        // clear the events after redoUndoRedo
        eventListener.clearReceivedPreEvents( );
        eventListener.clearReceivedPostEvents( );

        connection.getSession( ).getEventRegistry( ).deregister( eventListener );

    }

    public abstract static class EmptyAsserter extends DoUndoRedoTestAsserter {


        @Override
        public void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

        }

        @Override
        public void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

        }
    }

    protected abstract static class DoUndoRedoTestAsserter {

        public abstract void assertAfterDo( );

        public abstract void assertAfterUndo( );

        public abstract void assertExpectedPreEventsAfterUndo( List<? extends ChangeEvent> receivedEvents );

        public abstract void assertExpectedPreEventsAfterDo( List<? extends ChangeEvent> receivedEvents );


        public void assertBeforeDo( ) {

            this.assertAfterUndo( );
        }

        public void assertAfterRedo( ) {

            this.assertAfterDo( );
        }

        public void assertAfterUndoRedo( ) {

            this.assertAfterUndo( );
        }

        public void assertAfterRedoUndoRedo( ) {

            this.assertAfterDo( );
        }

        public void assertExpectedPostEventsAfterDo( List<? extends ChangeEvent> receivedEvents ) {

            this.assertExpectedPreEventsAfterDo( receivedEvents );
        }

        public void assertExpectedPostEventsAfterUndo( List<? extends ChangeEvent> receivedEvents ) {

            this.assertExpectedPreEventsAfterUndo( receivedEvents );
        }

        public void assertExpectedPostEventsAfterRedo( List<? extends ChangeEvent> receivedEvents ) {

            this.assertExpectedPostEventsAfterDo( receivedEvents );
        }

        public void assertExpectedPostEventsAfterRedoUndoRedo( List<? extends ChangeEvent> receivedEvents ) {

            this.assertExpectedPostEventsAfterDo( receivedEvents );
        }

        public void assertExpectedPostEventsAfterUndoRedo( List<? extends ChangeEvent> receivedEvents ) {

            this.assertExpectedPostEventsAfterUndo( receivedEvents );
        }

        public void assertExpectedPreEventsAfterUndoRedo( List<? extends ChangeEvent> receivedEvents ) {

            this.assertExpectedPreEventsAfterUndo( receivedEvents );
        }

        public void assertExpectedPreEventsAfterRedo( List<? extends ChangeEvent> receivedEvents ) {

            this.assertExpectedPreEventsAfterDo( receivedEvents );
        }

        public void assertExpectedPreEventsAfterRedoUndoRedo( List<? extends ChangeEvent> receivedEvents ) {

            this.assertExpectedPreEventsAfterDo( receivedEvents );
        }

        public EventFilter getEventFilter( ) {

            return new EventTypeFilter( ChangeEvent.class );
        }
    }

    protected abstract static class TestCommand extends Command {

        protected TestCommand( Connection connection ) {

            super( connection );
        }


        @Override
        public boolean canExecute( ) {

            return true;
        }


        @Override
        public Collection<PartitionOperation> getAffectedPartitions( ) {

            return null;
        }

    }

    private static class DoUndoRedoPreChangeListener implements PreChangeListener, ChangeListener {

        private List<ChangeEvent> receivedPostEvents = new ArrayList<ChangeEvent>( );

        private List<ChangeEvent> receivedPreEvents = new ArrayList<ChangeEvent>( );

        public void prepare( ChangeEvent event ) {

            receivedPreEvents.add( event );
        }

        public void notify( ChangeEvent event ) {

            receivedPostEvents.add( event );
        }

        public List<? extends ChangeEvent> getReceivedPostEvents( ) {

            return new ArrayList<ChangeEvent>( receivedPostEvents );
        }

        public List<? extends ChangeEvent> getReceivedPreEvents( ) {

            return new ArrayList<ChangeEvent>( receivedPreEvents );
        }

        public void clearReceivedPostEvents( ) {

            receivedPostEvents.clear( );
        }

        public void clearReceivedPreEvents( ) {

            receivedPreEvents.clear( );
        }
    }
}
