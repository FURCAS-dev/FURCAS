package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.core.transactions.actions.PartitionLockObtainAction;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.actions.Action;
import com.sap.tc.moin.repository.transactions.microtransactionables.ObtainTransientLockMicroTransactionable;

public class ObtainTransientLockMicroTransactionableImpl extends AbstractMicroTransactionable implements ObtainTransientLockMicroTransactionable {

    private PRI priToLock;

    private PartitionLockObtainAction partitionLockAction;

    private Connection owner;

    /**
     * Creates a Micro Transactionable that obtains the transient lock for a
     * partition.
     */
    public ObtainTransientLockMicroTransactionableImpl( CoreConnection aConnection, PRI aPri, Connection owner ) {

        super( aConnection );
        this.priToLock = aPri;
        this.owner = owner;
    }

    @Override
    public void assertDoPreConstraints( ) {

        super.assertDoPreConstraints( );
        assertParameterIsNotNull( owner );
        assertParameterIsNotNull( priToLock );
    }

    private void assertParameterIsNotNull( Object pCheckedObject ) throws IllegalArgumentException {

        if ( pCheckedObject == null ) {
            RecoverableExecutionException exception = new RecoverableExecutionException( RepositoryCoreMessages.PARAM_IS_NULL );
            log.preConstraintCheckException( exception );
            throw exception;
        }
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        // partition lock action
        this.partitionLockAction = ActionFactory.createPartitionLockAction( this.connection, this.priToLock, this.owner );
        getOrCreateDoActions( ).add( partitionLockAction );

    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        // a lock must only be reverted if it wasn't already obtained before!
        // Otherwise we would release a lock which
        // was originally obtained by some other microtransaction
        if ( this.partitionLockAction.getLockWasAlreadyObtained( ) == false ) {
            // partition lock release action
            Action partitionLockReleaseAction = ActionFactory.createPartitionLockReleaseAction( this.connection, this.priToLock, this.owner );
            getOrCreateUndoActions( ).add( partitionLockReleaseAction );
        }
    }
}
