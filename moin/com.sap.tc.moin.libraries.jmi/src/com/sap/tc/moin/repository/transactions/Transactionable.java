/**
 * 
 */
package com.sap.tc.moin.repository.transactions;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;

/**
 * Contains JMI code to be run in a Transaction.
 * 
 * @author D045996
 */
public interface Transactionable {

    public void runInTransaction( ) throws UnrecoverableExecutionException, ExecutionRollbackFailedException, ExecutionCancelledException, JmiException, NullPointerException;

    public CoreConnection getConnection( );
}
