package com.sap.tc.moin.repository.core.commands;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.transactions.TransactionManager;
import com.sap.tc.moin.repository.transactions.TransactionRecord;

/**
 * Abstract class that represents an executed command (directly, as group or as
 * JMI wrapper), and that can be undone/redone.
 * 
 * @author d045996
 */
public abstract class InternalCommand implements CommandHandle {

    /**
     * State
     */
    public enum CommandState {
        INITIALIZED, EXECUTING, DONE, UNDOING, UNDONE, REDOING, ROLLBACK_ERROR
    }

    protected InternalCommand.CommandState state = InternalCommand.CommandState.INITIALIZED;

    protected String description;

    protected final CoreConnection connection;

    protected final TransactionManager txManager;

    /**
     * The {@link TransactionRecord} that results from running the code in
     * {@link #doExecute} in a transaction, and used to undo the command.
     */
    protected TransactionRecord txRecord;

    /**
     * @param conn
     * @param descr
     */
    public InternalCommand( Connection conn, String descr ) {

        if ( conn instanceof Wrapper ) {
            this.connection = ( (Wrapper<CoreConnection>) conn ).unwrap( );
        } else {
            this.connection = (CoreConnection) conn;
        }
        this.txManager = this.connection.getSession( ).getTransactionManager( );
        this.description = descr;
    }

    /**
     * @return the state
     */
    public InternalCommand.CommandState getState( ) {

        return this.state;
    }

    public String getDescription( ) {

        return this.description;
    }

    /**
     * @param desc
     */
    public void setDescription( String desc ) {

        this.description = desc;
    }

    /**
     * @return true if the command can be undone
     */
    public boolean canUndo( ) {

        return ( this.state == InternalCommand.CommandState.DONE ) && ( this.txRecord != null ) && ( this.txRecord.canUndo( ) );
    }

    /**
     * @return true if the command can be redone
     */
    public boolean canRedo( ) {

        return ( this.state == InternalCommand.CommandState.UNDONE ) && ( this.txRecord != null ) && ( this.txRecord.canRedo( ) );
    }

    /**
     * Internal method used by the {@link CommandStack} to undo the command. It
     * uses the {@link TransactionRecord} to undo the modifications performed
     * during the command execution.
     * 
     * @throws ExecutionCancelledException
     * @throws UnrecoverableExecutionException
     */
    public void _undo( ) throws ExecutionCancelledException, UnrecoverableExecutionException {

        if ( this.state != InternalCommand.CommandState.DONE ) {
            throw new CommandBugException( CommandsExceptionMessages.ILLEGALCALLWITHSTATE, "_undo()", this.state ); //$NON-NLS-1$
        }
        this.state = InternalCommand.CommandState.UNDOING;
        try {
            this.txManager.undo( this.txRecord );
            this.state = InternalCommand.CommandState.UNDONE;
        } catch ( UnrecoverableExecutionException rbe ) {
            this.state = InternalCommand.CommandState.ROLLBACK_ERROR;
            throw rbe;
        } catch ( RuntimeException ex ) {
            this.state = InternalCommand.CommandState.DONE;
            throw ex;
        }
    }

    /**
     * Internal method used by the {@link CommandStack} to redo the command.
     * 
     * @throws ExecutionCancelledException
     * @throws UnrecoverableExecutionException
     */
    public void _redo( ) throws ExecutionCancelledException, UnrecoverableExecutionException {

        if ( this.state != InternalCommand.CommandState.UNDONE ) {
            throw new CommandBugException( CommandsExceptionMessages.ILLEGALCALLWITHSTATE, "_redo()", this.state ); //$NON-NLS-1$
        }
        this.state = InternalCommand.CommandState.REDOING;
        try {
            this.txManager.redo( this.txRecord );
            this.state = InternalCommand.CommandState.DONE;
        } catch ( UnrecoverableExecutionException rbe ) {
            this.state = InternalCommand.CommandState.ROLLBACK_ERROR;
            throw rbe;
        } catch ( RuntimeException ex ) {
            this.state = InternalCommand.CommandState.UNDONE;
            throw ex;
        }
    }

}
