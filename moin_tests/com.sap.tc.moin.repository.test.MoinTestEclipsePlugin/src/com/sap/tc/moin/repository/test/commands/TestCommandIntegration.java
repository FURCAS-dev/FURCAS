/**
 * 
 */
package com.sap.tc.moin.repository.test.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.friends.CommandStackObserver;
import com.sap.tc.moin.friends.ProgressMonitor;
import com.sap.tc.moin.friends.core.CoreUtilitiesFactory;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.commands.PartitionOperation.Operation;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.commands.CommandStackImpl;
import com.sap.tc.moin.repository.core.commands.InternalCommand;
import com.sap.tc.moin.repository.core.events.VetoException;
import com.sap.tc.moin.repository.core.transactions.TransactionManagerImpl;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.CommitListener;
import com.sap.tc.moin.repository.events.EventChain;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.events.PreChangeListener;
import com.sap.tc.moin.repository.events.PreCommitListener;
import com.sap.tc.moin.repository.events.UpdateListener;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.spi.core.SpiEventManager;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.test.core.CoreMoinTest;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * @author d045996
 */
public class TestCommandIntegration extends CoreMoinTest {

    protected CommandStack stack;

    protected CommandStackImpl stackImpl;

    protected TransactionManagerImpl txManager;

    protected SpiEventManager evManager;

    protected EventRegistry eventRegistry = null;

    protected static long sequence = 0;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        stack = getMOINConnection( ).getCommandStack( );
        stackImpl = ( (Wrapper<CommandStackImpl>) stack ).unwrap( );
        CoreSession session = getTestHelper( ).getCoreSession( getMOINConnection( ).getSession( ) );
        txManager = (TransactionManagerImpl) session.getTransactionManager( );
        evManager = session.getEventManager( );
        eventRegistry = session.getEventRegistry( );

    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        stack = null;
        stackImpl = null;
        txManager = null;
        evManager = null;
        eventRegistry = null;
        myNewPackage = null;
    }

    @Test
    public void testCancelGroup( ) {

        stack.clear( );
        CreateMofPackageWithClass cmd1 = new CreateMofPackageWithClass( this.getMOINConnection( ), "MyFirstPackage", "MyFirstClass" );
        CreateMofPackageWithClass cmd2 = new CreateMofPackageWithClass( this.getMOINConnection( ), "MyCancelledPackage", "MycancelledClass" );

        InternalCommand ic1 = (InternalCommand) stack.execute( cmd1 );

        stack.openGroup( "TestGroup" );
        {
            cmd2.execute( );
        }
        stack.cancelGroup( );

        assertEqualsAndContinue( "UndoStack.size()", 1, stack.getUndoStack( ).size( ) );
        assertEqualsAndContinue( "First Command not undone", ic1, stack.getUndoStack( ).iterator( ).next( ) );
        assertFalseAndContinue( "New Package inside cancelled group not alive", ( (Partitionable) cmd2.getNewPackage( ) ).is___Alive( ) );

        // Clean up
        cmd1.getNewPackage( ).refDelete( );
    }

    private static class CancelGroupListener implements ChangeListener {

        public void notify( ChangeEvent event ) {

            event.veto( "Stop it!" );
        }

    }

    @Test
    public void testExceptionInCancelGroup( ) {

        stack.clear( );
        CreateMofPackageWithClass cmd1 = new CreateMofPackageWithClass( this.getMOINConnection( ), "MyFirstPackage", "MyFirstClass" );


        stack.openGroup( "TestGroup" );
        cmd1.execute( );

        CancelGroupListener listener = new CancelGroupListener( );
        getMOINConnection( ).getSession( ).getEventRegistry( ).registerListener( listener, null );
        try {
            stack.cancelGroup( );
            fail( "cancel Group must throw UnrecoverableExecutionException" );
        } catch ( UnrecoverableExecutionException e ) {
            // OK, expected
        }
        getMOINConnection( ).getSession( ).getEventRegistry( ).deregister( listener );
    }

    @Test
    public void testCommitEventsForCompositeCommand( ) {

        TestCommitListener listener1 = new TestCommitListener( );
        TestCommitListener listener2 = listener1;
        eventRegistry.registerPreCommitListener( listener1, new EventTypeFilter( ElementChangeEvent.class ) );
        eventRegistry.registerCommitListener( listener2, new EventTypeFilter( ElementChangeEvent.class ) );

        stack.clear( );
        CreateMofPackageWithClass cmd1 = new CreateMofPackageWithClass( this.getMOINConnection( ), "MyPackage", "MyClass" );
        stack.execute( cmd1 );

        assertEqualsAndContinue( "PreCommit Listener number of calls", 1, listener1.prepareCommitCalls );
        // TODO: Test more preciselly which events actually are being fired!
        assertEqualsAndContinue( "PreCommit Listener number of events", 4, listener1.prepareEventChains.get( 0 ).getEvents( ).size( ) );
        assertEqualsAndContinue( "PostCommit Listener number of calls", 1, listener2.notifyCommitCalls );
        // TODO: Test more preciselly which events actually are being fired!
        assertEqualsAndContinue( "PostCommit Listener number of events", 4, listener2.notifyEventChains.get( 0 ).getEvents( ).size( ) );

        // Clean up
        cmd1.getNewPackage( ).refDelete( );

        eventRegistry.deregister( listener1 );
        eventRegistry.deregister( listener2 );

    }

    MofPackage myNewPackage;

    @Test
    public void testCommitEventsForDirectJMICall( ) {

        ModelPackage myModel = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        // Register Listeners
        TestCommitListener listener1 = new TestCommitListener( );
        TestCommitListener listener2 = new TestCommitListener( );
        eventRegistry.registerPreCommitListener( listener1, new EventTypeFilter( ElementChangeEvent.class ) );
        eventRegistry.registerCommitListener( listener2, new EventTypeFilter( ElementChangeEvent.class ) );

        // Perform JMI calls
        myNewPackage = (MofPackage) myModel.getMofPackage( ).refCreateInstance( );
        myNewPackage.setName( "MyPackageName" );

        // Check
        assertEqualsAndContinue( "PreCommit Listener number of calls for direct JMI call", 2, listener1.prepareCommitCalls );
        assertEqualsAndContinue( "PreCommit Listener number of events for direct JMI call", 1, listener1.prepareEventChains.get( 0 ).getEvents( ).size( ) );
        assertEqualsAndContinue( "PostCommit Listener number of calls for direct JMI call", 2, listener2.notifyCommitCalls );
        assertEqualsAndContinue( "PostCommit Listener number of events for direct JMI call", 1, listener2.notifyEventChains.get( 0 ).getEvents( ).size( ) );

        // Clean up
        myNewPackage.refDelete( );

        eventRegistry.deregister( listener1 );
        eventRegistry.deregister( listener2 );

    }

    @Test
    public void testUpdateEventsForCompositeCommand( ) {

        TestUpdateListener uListener = new TestUpdateListener( );
        eventRegistry.registerUpdateListener( uListener, new EventTypeFilter( ElementChangeEvent.class ) );
        TestCommitListener cListener = new TestCommitListener( );
        eventRegistry.registerCommitListener( cListener, new EventTypeFilter( ElementChangeEvent.class ) );

        stack.clear( );
        CreateMofPackageWithClass cmd1 = new CreateMofPackageWithClass( this.getMOINConnection( ), "MyPackage", "MyClass" );
        stack.execute( cmd1 );

        assertEqualsAndContinue( "Update Listener number of calls", 1, uListener.notifyUpdateCalls );
        assertTrueAndContinue( "Update Listener must be called after Commit Listener", uListener.lastUpdateTime > cListener.lastCommitTime );

        // Clean up
        cmd1.getNewPackage( ).refDelete( );

        eventRegistry.deregister( uListener );
        eventRegistry.deregister( cListener );
    }

    @Test
    public void testUpdateEventsForCommandGroups( ) {

        TestUpdateListener uListener = new TestUpdateListener( );
        eventRegistry.registerUpdateListener( uListener, new EventTypeFilter( ElementChangeEvent.class ) );
        TestCommitListener cListener = new TestCommitListener( );
        eventRegistry.registerCommitListener( cListener, new EventTypeFilter( ElementChangeEvent.class ) );

        CreateMofPackageWithClass cmd1 = new CreateMofPackageWithClass( this.getMOINConnection( ), "MyPackage", "MyClass" );
        stack.clear( );
        stack.openGroup( "level0 Group" );
        {
            stack.openGroup( "level1 Group" );

            {
                stack.execute( cmd1 );

                assertEqualsAndContinue( "Update Listener number of calls before closing Group", 0, uListener.notifyUpdateCalls );
                stack.setGroupDescription( "new level1 Group" );
            }
            CommandHandle cgh2 = stack.closeGroup( );
            assertTrueAndContinue( "Group Description correctly modified", "new level1 Group".equals( cgh2.getDescription( ) ) );

            cmd1.myNewPackage.setName( "MyPackageName2" );
            assertEqualsAndContinue( "Update Listener number of calls before closing level-0 Group", 0, uListener.notifyUpdateCalls );
        }
        CommandHandle cgh1 = stack.closeGroup( );
        assertTrueAndContinue( "Group Description correctly modified", "level0 Group".equals( cgh1.getDescription( ) ) );

        assertEqualsAndContinue( "Update Listener number of calls", 1, uListener.notifyUpdateCalls );
        assertTrueAndContinue( "Update Listener must be called after Commit Listener", uListener.lastUpdateTime > cListener.lastCommitTime );

        // Clean up
        cmd1.getNewPackage( ).refDelete( );

        eventRegistry.deregister( uListener );
        eventRegistry.deregister( cListener );
    }

    @Test
    public void testUpdateEventsForDirectJMICall( ) {

        ModelPackage myModel = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        // register listeners
        TestUpdateListener uListener = new TestUpdateListener( );
        eventRegistry.registerUpdateListener( uListener, new EventTypeFilter( ElementChangeEvent.class ) );
        TestCommitListener cListener = new TestCommitListener( );
        eventRegistry.registerCommitListener( cListener, new EventTypeFilter( ElementChangeEvent.class ) );

        // perform JMI calls
        myNewPackage = (MofPackage) myModel.getMofPackage( ).refCreateInstance( );
        assertEqualsAndContinue( "Update Listener number of calls", 1, uListener.notifyUpdateCalls );
        assertTrueAndContinue( "Update Listener must be called after Commit Listener", uListener.lastUpdateTime > cListener.lastCommitTime );

        myNewPackage.setName( "MyPackageName" );
        assertEqualsAndContinue( "Update Listener number of calls", 2, uListener.notifyUpdateCalls );
        assertTrueAndContinue( "Update Listener must be called after Commit Listener", uListener.lastUpdateTime > cListener.lastCommitTime );

        // Clean up
        myNewPackage.refDelete( );
        myNewPackage = null;

        eventRegistry.deregister( uListener );
        eventRegistry.deregister( cListener );
    }

    @Test
    public void testVetoingPreCommitEventForCompositeCommand( ) {

        TestCommitListener listener1 = new TestCommitListener( );
        TestCommitListener listener2 = new TestCommitListener( );
        listener1.doVeto = true;

        eventRegistry.registerPreCommitListener( listener1, new EventTypeFilter( ElementChangeEvent.class ) );
        eventRegistry.registerCommitListener( listener2, new EventTypeFilter( ElementChangeEvent.class ) );

        stack.clear( );
        CreateMofPackageWithClass cmd1 = new CreateMofPackageWithClass( this.getMOINConnection( ), "MyPackage", "MyClass" );
        CommandHandle cmd1h = null;
        try {
            cmd1h = stack.execute( cmd1 );
            assertTrue( "CommandCancelledException thrown executing Command w/vetoing preCommitListener.", false );
        } catch ( RuntimeException ex ) {
            // OK
        }

        assertEquals( "Handle after executing Command w/vetoing listener", cmd1h, null );

        assertEquals( "PreCommit Listener number of calls w/vetoing listener", 1, listener1.prepareCommitCalls );
        // TODO: Test more preciselly which events actually are being fired!
        assertEquals( "PreCommit Listener number of events w/vetoing listener", 4, listener1.prepareEventChains.get( 0 ).getEvents( ).size( ) );
        assertEquals( "PostCommit Listener number of calls w/vetoing listener", 0, listener2.notifyCommitCalls );
        assertEquals( "PostCommit Listener number of events w/vetoing listener", 0, listener2.notifyEventChains.size( ) );

        assertFalse( "canUndo() after executing Command w/vetoing listener", stack.canUndo( ) );
        assertFalse( "canRedo() after executing Command w/vetoing listener", stack.canRedo( ) );

        // Clean up

        // Necessary until rollback works
        // rollback works now, lines disabled (MM)
        // if (cmd1.getNewPackage()!=null) {
        // cmd1.getNewPackage().refDelete();
        // }

        eventRegistry.deregister( listener1 );
        eventRegistry.deregister( listener2 );

    }

    @Test
    public void testCommandWithWrongProxy( ) {

        // -------------------------------------------
        // Detect attachToThread() in JmiProxy
        // -------------------------------------------

        // Create Element with second connection
        ModelPackage myModel = (ModelPackage) getSecondMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        myNewPackage = (MofPackage) myModel.getMofPackage( ).refCreateInstance( );

        CreateMofClassInContainer myCommand = new CreateMofClassInContainer( this.getMOINConnection( ), myNewPackage, "TestClass" );
        try {
            stack.execute( myCommand );
            fail( "Command with Wrong Proxy not detected (no Exception)" );
        } catch ( Exception ex ) {
            assertTrue( "Command with Wrong Proxy not detected!", ( ex instanceof IllegalStateException ) );
        }

        // cleanup
        if ( myCommand.myNewClass != null && ( (Partitionable) myCommand.myNewClass ).is___Alive( ) ) {
            myCommand.myNewClass.refDelete( );
        }
        myNewPackage.refDelete( );
    }

    @Test
    public void testMutatingCommitEventForCompositeCommand( ) {

        TestCommitListener listener1 = new TestCommitListener( );
        TestCommitListener listener2 = new TestCommitListener( );
        listener2.doMutation = true;
        eventRegistry.registerPreCommitListener( listener1, new EventTypeFilter( ElementChangeEvent.class ) );
        eventRegistry.registerCommitListener( listener2, new EventTypeFilter( ElementChangeEvent.class ) );

        stack.clear( );
        CreateMofPackageWithClass cmd1 = new CreateMofPackageWithClass( this.getMOINConnection( ), "MyPackage", "MyClass" );
        CommandHandle cmd1h = null;
        cmd1h = stack.execute( cmd1 );

        assertNotEqualsAndContinue( "Handle after executing Command w/mutating listener", cmd1h, null );

        assertEqualsAndContinue( "PreCommit Listener number of calls w/mutating listener", 2, listener1.prepareCommitCalls );
        // TODO: Test more precisely which events actually are being fired!
        assertEqualsAndContinue( "PreCommit Listener number of events w/mutating listener", 4, listener1.prepareEventChains.get( 0 ).getEvents( ).size( ) );
        assertEqualsAndContinue( "PreCommit Listener number of events w/mutating listener", 2, listener1.prepareEventChains.get( 1 ).getEvents( ).size( ) );
        assertEqualsAndContinue( "PostCommit Listener number of calls w/mutating listener", 2, listener2.notifyCommitCalls );
        // TODO: Test more precisely which events actually are being fired!
        assertEqualsAndContinue( "PostCommit Listener number of events w/mutating listener", 4, listener2.notifyEventChains.get( 0 ).getEvents( ).size( ) );
        assertEqualsAndContinue( "PostCommit Listener number of events w/mutating listener", 2, listener2.notifyEventChains.get( 1 ).getEvents( ).size( ) );

        assertTrueAndContinue( "canUndo() after executing Command w/mutating listener", stack.canUndo( ) );
        assertFalseAndContinue( "canRedo() after executing Command w/mutating listener", stack.canRedo( ) );

        assertEqualsAndContinue( "undo stack size after executing Command w/mutating listener", 2, stackImpl.getUndoStackContent( ).size( ) );
        // Clean up

        if ( cmd1.getNewPackage( ) != null ) {
            cmd1.getNewPackage( ).refDelete( );
        }

        eventRegistry.deregister( listener1 );
        eventRegistry.deregister( listener2 );

    }

    @Test
    public void testVetosInPreCommitListener( ) {

        TestCommitListener listener1 = new TestCommitListener( );
        listener1.doVeto = true;
        eventRegistry.registerPreCommitListener( listener1, new EventTypeFilter( ElementChangeEvent.class ) );

        stack.clear( );
        CreateMofPackageWithClass cmd1 = new CreateMofPackageWithClass( this.getMOINConnection( ), "MyPackage", "MyClass" );
        CommandHandle cmd1h = null;

        try {
            cmd1h = stack.execute( cmd1 );
            fail( "VetoException expected, but no Exception ocurred" );
        } catch ( VetoException ve ) {
            //OK
        }

        assertEquals( "Null partition must be empty", 0, this.getMOINConnection( ).getNullPartition( ).getElements( ).size( ) );
        listener1.doVeto = false;
        try {
            cmd1h = stack.execute( cmd1 );
        } catch ( RuntimeException re ) {
            fail( "No exception expected but " + re.toString( ) );
        }
        eventRegistry.deregister( listener1 );


    }

    @Test
    public void testVetosInPrechangeListener( ) {

        TestCommitListener listener1 = new TestCommitListener( );
        listener1.doVeto = true;
        eventRegistry.registerPreChangeListener( listener1, new EventTypeFilter( ElementChangeEvent.class ) );

        stack.clear( );
        CreateMofPackageWithClass cmd1 = new CreateMofPackageWithClass( this.getMOINConnection( ), "MyPackage", "MyClass" );
        CommandHandle cmd1h = null;

        try {
            cmd1h = stack.execute( cmd1 );
            fail( "VetoException expected, but no Exception ocurred" );
        } catch ( VetoException ve ) {
            //OK;
        }
        assertEquals( "Null partition must be empty", 0, this.getMOINConnection( ).getNullPartition( ).getElements( ).size( ) );
        listener1.doVeto = false;
        try {
            cmd1h = stack.execute( cmd1 );
        } catch ( RuntimeException re ) {
            fail( "No exception expected but " + re.toString( ) );
        }
        eventRegistry.deregister( listener1 );

    }



    /***************************************************************************
     * COMMIT EVENTs LISTENER
     */

    /**
     * PreCommitListener
     */
    protected class TestCommitListener implements PreChangeListener, PreCommitListener, CommitListener {

        public boolean doVeto = false;

        public boolean doMutation = false;

        public int prepareCommitCalls = 0;

        public int notifyCommitCalls = 0;

        public long lastPrepareTime = 0;

        public long lastCommitTime = 0;

        public List<EventChain> prepareEventChains = new ArrayList<EventChain>( );

        public List<EventChain> notifyEventChains = new ArrayList<EventChain>( );

        public void prepareCommit( EventChain events ) {

            prepareCommitCalls++;
            prepareEventChains.add( events );
            lastPrepareTime = sequence++;
            if ( doVeto ) {
                throw new VetoException( "Veto!" );
            }
        }

        CreateMofPackage mutation = null;

        public void notifyCommit( EventChain events ) {

            notifyCommitCalls++;
            notifyEventChains.add( events );
            lastCommitTime = sequence++;
            if ( doMutation ) {
                if ( mutation == null ) {
                    mutation = new CreateMofPackage( getMOINConnection( ), "MySeccondPackage" );
                    stack.execute( mutation );
                }
            }
        }

        public void prepare( ChangeEvent event ) {

            if ( doVeto ) {
                throw new VetoException( "Veto!" );
            }
        }
    }

    /***************************************************************************
     * UPDATE UI EVENTs LISTENER
     */

    protected class TestCommandStackListener implements CommandStackObserver {

        public int beofreRootCommandExecutionCalls = 0;

        public List<Command> commandsToBeExecuted = new ArrayList<Command>( );

        public int afterTopLevelCommandExecutionCalls = 0;

        public List<CommandHandle> executedHandles = new ArrayList<CommandHandle>( );

        public int topLevelCommandUndoneCalls = 0;

        public List<CommandHandle> undoneHandles = new ArrayList<CommandHandle>( );

        public int topLevelCommandRedoneCalls = 0;

        public List<CommandHandle> redoneHandles = new ArrayList<CommandHandle>( );

        public int topLevelStacksClearedCalls = 0;

        public void notifyBeforeRootCommandExecution( Command cmd, Collection<PartitionOperation> affectedPartitions ) {

            beofreRootCommandExecutionCalls++;
            commandsToBeExecuted.add( cmd );
        }

        public void notifyTopLevelCommandExecuted( CommandHandle cmdHnd, Connection con ) {

            afterTopLevelCommandExecutionCalls++;
            executedHandles.add( cmdHnd );
        }

        public void notifyTopLevelCommandUndone( CommandHandle cmdHnd, Connection con ) {

            topLevelCommandUndoneCalls++;
            undoneHandles.add( cmdHnd );
        }

        public void notifyTopLevelCommandRedone( CommandHandle cmdHnd, Connection con ) {

            topLevelCommandRedoneCalls++;
            redoneHandles.add( cmdHnd );
        }

        public void notifyTopLevelStacksCleared( Connection con ) {

            topLevelStacksClearedCalls++;
        }

        public Collection<Connection> getConnectionsToBeSaved( Command cmd, Collection<PartitionOperation> affectedPartitions ) {

            return Collections.emptyList( );
        }

    }

    /**
     * PreCommitListener
     */
    protected class TestUpdateListener implements UpdateListener {

        public boolean doMutation = false;

        public int notifyUpdateCalls = 0;

        public long lastUpdateTime = 0;

        public List<EventChain> notifyEventChains = new ArrayList<EventChain>( );

        CreateMofPackage mutation = null;

        public void notifyUpdate( EventChain events ) {

            notifyUpdateCalls++;
            notifyEventChains.add( events );
            lastUpdateTime = sequence++;
            if ( doMutation ) {
                if ( mutation == null ) {
                    mutation = new CreateMofPackage( getMOINConnection( ), "MySeccondPackage" );
                    stack.execute( mutation );
                }
            }

        }
    }

    /***************************************************************************
     * Command Stack Listeners
     */

    /**
     * Test CommandStackListener methods
     */
    // TODO:
    // Test "mutating" listeners
    // -> avoidance of mutation on before execution
    // -> allowing mutations on execution completed
    // Test listener (de-)registration
    // 
    @Test
    public void testCommandStackListenerForCompositeCommand( ) {

        TestCommandStackListener csListener = new TestCommandStackListener( );
        stackImpl.setCommandStackObserver( csListener );

        stack.clear( );
        CreateMofPackageWithClass cmd1 = new CreateMofPackageWithClass( this.getMOINConnection( ), "MyPackage", "MyClass" );
        CommandHandle cHndl = stack.execute( cmd1 );

        assertEquals( "CommandStack Listener number of before calls", 1, csListener.beofreRootCommandExecutionCalls );
        assertEquals( "CommandStack Listener notified Command", cmd1, csListener.commandsToBeExecuted.get( 0 ) );

        assertEquals( "CommandStack Listener number of executed calls", 1, csListener.afterTopLevelCommandExecutionCalls );
        assertEquals( "CommandStack Listener notified CommandHandle", cHndl, csListener.executedHandles.get( 0 ) );

        // Clean up
        cmd1.getNewPackage( ).refDelete( );

        stackImpl.setCommandStackObserver( csListener );
    }

    @Test
    public void testCommandStackListenerForCommandGroups( ) {

        TestCommandStackListener csListener = new TestCommandStackListener( );
        stackImpl.setCommandStackObserver( csListener );

        CreateMofPackageWithClass cmd1 = new CreateMofPackageWithClass( this.getMOINConnection( ), "MyPackage", "MyClass" );
        stack.clear( );
        assertEqualsAndContinue( "CommandStack Listener number of cleared calls", 1, csListener.topLevelStacksClearedCalls );
        stack.openGroup( "level0 Group" );
        {
            stack.openGroup( "level1 Group" );

            {
                stack.clear( );
                stack.execute( cmd1 );
                stack.undo( );
                stack.redo( );

                assertEquals( "CommandStack Listener number of cleared calls", 1, csListener.topLevelStacksClearedCalls );

                assertEquals( "CommandStack Listener number of undone calls", 0, csListener.topLevelCommandUndoneCalls );

                assertEquals( "CommandStack Listener number of redone calls", 0, csListener.topLevelCommandRedoneCalls );
            }
            CommandHandle cgh2 = stack.closeGroup( );
            cmd1.myNewPackage.setName( "MyPackageName2" );
        }
        CommandHandle cgh1 = stack.closeGroup( );
        assertTrue( "Group Description correctly modified", "level0 Group".equals( cgh1.getDescription( ) ) );

        assertEquals( "CommandStack Listener number of before calls", 1, csListener.beofreRootCommandExecutionCalls );
        assertEquals( "CommandStack Listener notified Command", cmd1, csListener.commandsToBeExecuted.get( 0 ) );

        assertEquals( "CommandStack Listener number of executed calls", 1, csListener.afterTopLevelCommandExecutionCalls );
        assertEquals( "CommandStack Listener notified CommandHandle", cgh1, csListener.executedHandles.get( 0 ) );

        stack.undo( );
        assertEquals( "CommandStack Listener number of undone calls", 1, csListener.topLevelCommandUndoneCalls );
        assertEquals( "CommandStack Listener number of redone calls", 0, csListener.topLevelCommandRedoneCalls );

        stack.redo( );
        assertEqualsAndContinue( "CommandStack Listener number of undone calls", 1, csListener.topLevelCommandUndoneCalls );
        assertEqualsAndContinue( "CommandStack Listener number of redone calls", 1, csListener.topLevelCommandRedoneCalls );

        // Clean up
        cmd1.getNewPackage( ).refDelete( );

        stackImpl.setCommandStackObserver( null );
    }

    @Test
    public void testCommandStackListenerForDirectJMICall( ) {

        ModelPackage myModel = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        // register listeners
        TestCommandStackListener csListener = new TestCommandStackListener( );
        stackImpl.setCommandStackObserver( csListener );

        // perform JMI calls
        myNewPackage = (MofPackage) myModel.getMofPackage( ).refCreateInstance( );

        myNewPackage.setName( "MyPackageName" );

        assertEqualsAndContinue( "CommandStack Listener number of before calls", 0, csListener.beofreRootCommandExecutionCalls );

        assertEqualsAndContinue( "CommandStack Listener number of executed calls", 2, csListener.afterTopLevelCommandExecutionCalls );

        // Clean up
        myNewPackage.refDelete( );
        myNewPackage = null;

        stackImpl.setCommandStackObserver( null );
    }

    @Test
    public void testGetAffectedPartitionsShouldOnlyBeCalledOnce( ) {

        CommandCountingCallsToGetAffectedPartition cmd = new CommandCountingCallsToGetAffectedPartition( getMOINConnection( ) );
        cmd.execute( );
        assertEquals( 1, cmd.numberOfCallsToGetAffectedPartitions );

    }

    @Test
    public void testProgressReport( ) {

        MyProgressMonitor mpm = new MyProgressMonitor( );
        CoreUtilitiesFactory.getConnectionUtil( ).setProgressMonitor( getMOINConnection( ), mpm );
        ProgressReportingCommand cmd = new ProgressReportingCommand( getMOINConnection( ), 50 );
        cmd.execute( );
        assertEquals( 50, mpm.totalWork );
        assertEquals( 50, mpm.totalWorked );
        assertEquals( 1, mpm.nODoneCalls );
        assertEquals( "ReportingProgressCommand with 50 steps", mpm.name );

    }

    public class MyProgressMonitor extends ProgressMonitor {

        public String name;

        public int totalWork;

        public int nODoneCalls;

        public boolean cancelled = false;

        public int totalWorked = 0;

        @Override
        public void beginTask( String name, int totalWork ) {

            this.name = name;
            this.totalWork = totalWork;
        }

        @Override
        public void done( ) {

            nODoneCalls++;
        }

        @Override
        public boolean isCanceled( ) {

            return cancelled;
        }

        @Override
        public void worked( int work ) {

            totalWorked = totalWorked + work;

        }

    }


    /***************************************************************************
     * COMMANDS
     */

    public class CreateMofPackage extends Command {

        // Input Parameter
        String name = "TestPackage";

        // Output Parameter
        MofPackage myNewPackage;

        public CreateMofPackage( Connection connection, String name ) {

            super( connection, "Create Mof Package" );
            this.name = name;
        }

        @Override
        public Collection<PartitionOperation> getAffectedPartitions( ) {

            return null;
        }

        @Override
        public boolean canExecute( ) {

            return true;
        }

        @Override
        public void doExecute( ) {

            ModelPackage myModel = (ModelPackage) getConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
            myNewPackage = (MofPackage) myModel.getMofPackage( ).refCreateInstance( );
            myNewPackage.setName( name );
        }

        public MofPackage getNewPackage( ) {

            return myNewPackage;
        }
    }

    public class CreateMofClassInContainer extends Command {

        // Input Parameter
        Namespace container;

        String name = "TestClass";

        // Output Parameter
        MofClass myNewClass;

        public CreateMofClassInContainer( Connection connection, Namespace container, String className ) {

            super( connection, "CreateMofClassInContainer" );
            this.container = container;
            this.name = className;
        }

        @Override
        public Collection<PartitionOperation> getAffectedPartitions( ) {

            return null;
        }

        @Override
        public boolean canExecute( ) {

            return ( ( container != null ) && ( ( container instanceof MofPackage ) || ( container instanceof MofClass ) ) );
        }

        @Override
        public void doExecute( ) {

            ModelPackage myModel = (ModelPackage) getConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
            myNewClass = (MofClass) myModel.getMofClass( ).refCreateInstance( );
            // Do not change this, as this is used to test CommandsWithWrongProxies
            container.setName( "Should not work" );
        }

        public MofClass getNewClass( ) {

            return myNewClass;
        }
    }

    // Command Composition
    public class CreateMofPackageWithClass extends Command {

        // Input Parameter
        String className;

        // Output Parameter
        MofPackage myNewPackage;

        CreateMofPackage cmp;

        public CreateMofPackageWithClass( Connection connection, String packageName, String className ) {

            super( connection, "Create Mof Package with class" );
            cmp = new CreateMofPackage( connection, packageName );
            this.className = className;
            // Note that the command CreateMofClassInContainer cannot be instantiated as
            // is needs the result of the first command
        }

        @Override
        public Collection<PartitionOperation> getAffectedPartitions( ) {

            return null;
        }

        @Override
        public boolean canExecute( ) {

            // note that this is incomplete, as we cannot use the
            // second command here.
            return cmp.canExecute( );
        }

        @Override
        public void doExecute( ) {

            CommandStack stack = getConnection( ).getCommandStack( );

            // CreateMofPackage
            stack.execute( cmp );
            myNewPackage = cmp.getNewPackage( );

            // CreateMofClassInContainer
            CreateMofClassInContainer cmc = new CreateMofClassInContainer( getConnection( ), myNewPackage, className );
            stack.execute( cmc );
        }

        public MofPackage getNewPackage( ) {

            return myNewPackage;
        }
    }

    public class TwoConnectionsCommand extends Command {

        // Output Parameter
        Connection secondCon;

        public TwoConnectionsCommand( Connection connection, Connection secondConnection ) {

            super( connection, "Two Connections Command" );
            this.secondCon = secondConnection;
        }

        @Override
        public Collection<PartitionOperation> getAffectedPartitions( ) {

            return null;
        }

        @Override
        public boolean canExecute( ) {

            return true;
        }

        @Override
        public void doExecute( ) {

            // This will produce an attachToThread to the second connection
            secondCon.getPackage( null, null );
        }

    }

    public class CommandCountingCallsToGetAffectedPartition extends Command {

        public int numberOfCallsToGetAffectedPartitions;

        public CommandCountingCallsToGetAffectedPartition( Connection connection ) {

            super( connection, "CommandCountingCallsToGetAffectedPartition" );
        }

        @Override
        public Collection<PartitionOperation> getAffectedPartitions( ) {

            numberOfCallsToGetAffectedPartitions++;
            return Collections.singletonList( new PartitionOperation( Operation.EDIT, getPartitionOne( ).getPri( ) ) );
        }

        @Override
        public boolean canExecute( ) {

            return true;
        }

        @Override
        public void doExecute( ) {

        }
    }

    public class ProgressReportingCommand extends Command {

        int totalSteps = 0;

        public ProgressReportingCommand( Connection con, int totalSteps ) {

            super( con, "ReportingProgressCommand with " + totalSteps + " steps" );
            this.totalSteps = totalSteps;

        }

        @Override
        public boolean canExecute( ) {

            return true;
        }

        @Override
        public void doExecute( ) {

            for ( int i = 0; i < totalSteps; i++ ) {
                this.reportProgress( 1 );
            }
        }

        @Override
        public Collection<PartitionOperation> getAffectedPartitions( ) {

            return null;
        }

        @Override
        public int getTotalWork( ) {

            return totalSteps;
        }

    }


}
