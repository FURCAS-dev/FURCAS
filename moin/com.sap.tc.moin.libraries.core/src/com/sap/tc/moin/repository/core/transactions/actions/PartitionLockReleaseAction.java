package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.LockingException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;

public class PartitionLockReleaseAction extends PartitionLockAction {

    public PartitionLockReleaseAction( CoreConnection aConnection, PRI aPartitionPri, Object anOwner ) {

        super( aConnection, aPartitionPri, anOwner );
    }

    @Override
    public void execute( ) {

        CoreModelPartition partition = this.getPartition( this.partitionPri );
        try {
            this.connection.getPartitionLockManager( ).releaseLock( partition.getPri( ), this.owner );
        } catch ( LockingException lockingEx ) {
            // exception during locking attempt, the lock couldn't be released
            throw new RecoverableExecutionException( lockingEx );
        }
    }

    @Override
    public void revert( ) {

        CoreModelPartition partition = this.getPartition( this.partitionPri );
        try {
            this.connection.getPartitionLockManager( ).obtainLock( partition.getPri( ), this.connection );
        } catch ( LockingException e ) {
            throw new UnrecoverableExecutionException( e );
        }
    }
}
