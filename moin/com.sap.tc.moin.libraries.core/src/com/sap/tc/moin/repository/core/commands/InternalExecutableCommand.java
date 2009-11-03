package com.sap.tc.moin.repository.core.commands;

import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.Transactionable;

/**
 * Internal representation of the execution of an ExecutableCommand. This class
 * is both responsible for the actual execution of the command, and afterwards,
 * for the undo / redo, based on the transaction record.
 * 
 * @author d045996
 */
public class InternalExecutableCommand extends InternalCommand {

    /**
     * MOIN Connection used not only for the execution of the command, but also
     * for the operations {@link #canExecute} and {@link #getAfectedPartitions}
     */

    protected Command baseMC;

    /**
     * @param bmc
     */
    public InternalExecutableCommand( Command bmc ) {

        super( bmc.getConnection( ), bmc.getDescription( ) );
        this.baseMC = bmc;
    }

    /**
     * Internal method used by the {@link CommandStack} to execute the command.
     * The state of the command is handled, and the code in the method
     * {@link doExecute} is run in a transaction. If any exception occurs during
     * this call, the actual transaction is rolled-back, and the exception is
     * thrown further to the caller. The command then will be in the INITIALIZED
     * state, and a new execution can be tried. In the case the roll-back is not
     * possible, a {@link ExecutionRollbackFailedException} will be thrown, and
     * the command will be set in ROLLBACK_ERROR state
     * 
     * @throws Exception
     */
    protected void _execute( ) throws ExecutionCancelledException, ExecutionRollbackFailedException, UnrecoverableExecutionException {

        // TODO: If necessary, check that the command is not being executed twice
        if ( this.state != InternalCommand.CommandState.INITIALIZED ) {
            throw new CommandBugException( CommandsExceptionMessages.ILLEGALCALLWITHSTATE, "_execute()", this.state ); //$NON-NLS-1$
        }
        this.state = InternalCommand.CommandState.EXECUTING;
        try {
            this.txRecord = this.txManager.runInTransaction( new Transactionable( ) {

                public void runInTransaction( ) {

                    InternalExecutableCommand.this.baseMC.doExecute( );
                }

                public CoreConnection getConnection( ) {

                    return InternalExecutableCommand.this.connection;
                }
            } );
            this.baseMC = null;
            this.state = InternalCommand.CommandState.DONE;
        } catch ( UnrecoverableExecutionException rbe ) {
            this.state = InternalCommand.CommandState.ROLLBACK_ERROR;
            throw rbe;
        } catch ( RuntimeException ex ) {
            this.state = InternalCommand.CommandState.INITIALIZED;
            throw ex;
        }
    }
}
