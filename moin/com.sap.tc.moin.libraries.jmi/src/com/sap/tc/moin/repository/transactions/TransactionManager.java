/**
 * 
 */
package com.sap.tc.moin.repository.transactions;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;

/**
 * @author D045996
 */
public interface TransactionManager {

    public TransactionRecord runInMicroTransaction( MicroTransactionable code ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, JmiException;

    public TransactionRecord runInTransaction( Transactionable code ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException;

    public void undo( TransactionRecord tx ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException;

    public void redo( TransactionRecord tx ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException;
}
