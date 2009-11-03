package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;

public class CommandStackWrapper extends AbstractConnectionAwareWrapper<CommandStack> implements CommandStack {

    private final CoreCommandStack commandStack;

    public CommandStackWrapper( CoreConnection connection ) {

        super( connection, connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.commandStack = connection.getCommandStack( );
    }

    public boolean canRedo( ) {

        assertConnectionAlive( );
        // No connection attaching is required.
        return commandStack.canRedo( );
    }

    public boolean canUndo( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            // No connection attaching is required.
            return commandStack.canUndo( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    public void clear( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            // No connection attaching is required.
            commandStack.clear( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public CommandHandle closeGroup( ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return commandStack.closeGroup( );
        }
    }

    public void cancelGroup( ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            commandStack.cancelGroup( );
        }
    }

    public CommandHandle execute( Command command ) throws ExecutionCancelledException, UnrecoverableExecutionException {

        if ( !commandStack.getState( ).isRunning( ) ) {
            Collection<PartitionOperation> affectedPartitions = null;
            if ( command != null ) {
                affectedPartitions = command.getAffectedPartitions( );
            }
            commandStack.notifyBeforeRootCommandExecution( command, affectedPartitions );
        }

        // acquires the big lock
        // ATTENTION: all facility locks have to be acquired before the Thread obtains this monitor.
        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return commandStack.executeInternal( command );
        }
    }



    public int getMaxUndoStackSize( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            // No connection attaching is required.
            return commandStack.getMaxUndoStackSize( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public List<CommandHandle> getRedoStack( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            // No connection attaching is required.
            return commandStack.getRedoStack( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public List<CommandHandle> getUndoStack( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            // No connection attaching is required.
            return commandStack.getUndoStack( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean isGroupOpen( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            // No connection attaching is required.
            return commandStack.isGroupOpen( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean isCommandRunning( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            // No connection attaching is required.
            return commandStack.isCommandRunning( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public void openGroup( String groupDescription ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            commandStack.openGroup( groupDescription );
        }
    }

    public void setGroupDescription( String groupDescription ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            commandStack.setGroupDescription( groupDescription );
        }
    }

    public void redo( ) throws ExecutionCancelledException, UnrecoverableExecutionException {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            commandStack.redo( );
        }
    }

    public void setMaxUndoStackSize( int maxSize ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            // No connection attaching is required.
            commandStack.setMaxUndoStackSize( maxSize );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public void undo( ) throws ExecutionCancelledException, UnrecoverableExecutionException {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            commandStack.undo( );
        }
    }

    public void reportProgress( int worked ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            // No connection attaching is required.
            commandStack.reportProgress( worked );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public CoreCommandStack unwrap( ) {

        return commandStack;
    }



}