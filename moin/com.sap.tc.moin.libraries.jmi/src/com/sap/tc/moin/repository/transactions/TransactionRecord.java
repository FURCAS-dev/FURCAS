/**
 * 
 */
package com.sap.tc.moin.repository.transactions;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;

/**
 * The result of executing model changing code inside a transaction. An object
 * implementing this interface is returned by the method runInTransaction() of
 * the {@link TransactionManager TransactionManager}.
 * 
 * @author D045996
 */
public interface TransactionRecord {

    /**
     * @return true if the transaction can be undone. Only outermost
     * transactions that committed successfully can be undone.
     */
    public boolean canUndo( );

    /**
     * Reverts all modifications performed during the transaction. Note that the
     * {@link TransactionManager TransactionManager} does not mantain a stack of
     * transactions. This means, that the user of UndoableTransaction is
     * responsible for undoing transactions in the right sequence.
     */
    public void undo( ) throws UnrecoverableExecutionException, ExecutionCancelledException;

    public boolean canRedo( );

    public void redo( ) throws UnrecoverableExecutionException, ExecutionCancelledException;

    public CoreConnection getConnection( );
}
