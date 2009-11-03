package com.sap.tc.moin.repository.core.transactions;

import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.actions.Action;

/**
 * Basis class for Composite and Micro Transactions, containing the code that
 * tries to rollback partial modifications when the execution fails.
 * 
 * @author d045996
 */
public abstract class AbstractTransaction {

    TransactionManagerImpl txManager;

    // List of actions executed during do, undo or redo, used for rollback
    List<Action> executedActions;

    // AbstractTransaction parentTx;

    public AbstractTransaction( TransactionManagerImpl txManager ) {

        this.txManager = txManager;
    }

    public boolean isRoot( ) {

        return txManager.isRootTx( this );
    }

    // execute transaction including rollback in case of failure
    public void execute( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, JmiException, ExecutionCancelledException {

        try {
            begin( );
            doExecute( );
            commit( );
            return;
        } catch ( UnrecoverableExecutionException utex ) {
            // don't try to rollback (is futile!)
            throw utex;
        } catch ( RuntimeException ex ) {
            try {
                rollbackExecute( );
            } catch ( RuntimeException rbex ) {
                throw new ExecutionRollbackFailedException( ex, rbex );
            }
            if ( ex instanceof RecoverableExecutionException ) {
                Throwable cause = ex.getCause( );
                if ( cause != null ) {
                    throw (RuntimeException) cause;
                }
            }
            throw ex;
        }
    }

    protected void begin( ) {

        // if (isRoot()) {
        // // Here begins a Root Tx!
        // // Note that EventManager.beginRootTx(this) is called in TxManager!
        //            
        // }
    }

    protected void commit( ) {

        if ( isRoot( ) ) {
            // Here ends a Root Tx!
            // At this time point, any exception will produce a roll back of the
            // TX!
            txManager.firePreCommitEvents( getConnection( ) );
        }
    }

    protected abstract void rollbackExecute( );

    protected abstract void doExecute( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, RecoverableExecutionException, JmiException, NullPointerException, ExecutionCancelledException;

    protected void cleanUpOnCommit( ) {

        executedActions = null;
    }

    public abstract CoreConnection getConnection( );
}