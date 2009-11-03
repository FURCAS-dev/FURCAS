package com.sap.tc.moin.repository.core.transactions;

import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.Transactionable;

/**
 * Responsible for the execution of a {@link Transactionable} code, uses the
 * {@link RecordOfMicroTx} to roll back partial modifications in case of errors.
 * 
 * @author d045996
 */
public class CompositeTransaction extends AbstractTransaction {

    Transactionable code;

    int mark;

    public CompositeTransaction( TransactionManagerImpl txManager, Transactionable code ) {

        super( txManager );
        this.code = code;
    }

    @Override
    protected void doExecute( ) throws UnrecoverableExecutionException, ExecutionCancelledException, JmiException {

        mark = txManager.getRecord( ).getActualMark( );
        code.runInTransaction( );
    }

    @Override
    protected void rollbackExecute( ) {

        txManager.getRecord( ).rollbackToMark( mark );
    }

    @Override
    public CoreConnection getConnection( ) {

        return code.getConnection( );
    }
}
