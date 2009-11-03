package com.sap.tc.moin.repository.core;

import java.util.Collection;

import com.sap.tc.moin.friends.CommandStackObserver;
import com.sap.tc.moin.friends.ProgressMonitor;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;

public interface CoreCommandStack extends CommandStack {

    public enum StackState {
        // States that are not running
        WAITING( false ),
        ERROR( false ),

        // States that considered as running
        EXECUTING( true ),
        UNDOING( true ),
        REDOING( true ),
        WRAPPING( true );

        private boolean isRunning;

        private StackState( boolean isRunning ) {

            this.isRunning = isRunning;
        }

        public boolean isRunning( ) {

            return isRunning;
        }
    };

    public StackState getState( );

    public CommandStackObserver getCommandStackObserver( );

    public CommandHandle executeInternal( Command command ) throws ExecutionCancelledException, UnrecoverableExecutionException, RuntimeException;

    public void destroy( );

    public void setCommandStackObserver( CommandStackObserver observer );

    public void setProgressMonitor( ProgressMonitor progressMonitor );

    public void notifyBeforeRootCommandExecution( Command cmd, Collection<PartitionOperation> affectedPartitions );
}
