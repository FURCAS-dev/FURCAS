package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.LockingException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionDeletingNotPossibleException;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;

public class PartitionLockObtainAction extends PartitionLockAction {

    public static final int PARTITION_CHANGE_MODE_EDIT = 0;

    public static final int PARTITION_CHANGE_MODE_DELETE = 1;

    private boolean lockObtained = false;

    private boolean lockWasAlreadyObtained = false;

    private int partitionChangeMode = -1;

    public PartitionLockObtainAction( CoreConnection aConnection, PRI aPartitionPri, Object anOwner, int aPartitionChangeMode ) {

        super( aConnection, aPartitionPri, anOwner );
        partitionChangeMode = aPartitionChangeMode;
    }

    public PartitionLockObtainAction( CoreConnection aConnection, PRI aPartitionPri, Object owner ) {

        this( aConnection, aPartitionPri, owner, -1 );
    }

    @Override
    public void execute( ) {

        CoreModelPartition partition = this.getPartition( this.partitionPri );
        lockObtained = false;
        lockWasAlreadyObtained = false;
        try {
            lockWasAlreadyObtained = !connection.getPartitionLockManager( ).obtainLock( partition.getPri( ), this.owner );
            lockObtained = true;
        } catch ( LockingException lockingEx ) {
            // exception during locking attempt, the lock wasn't obtained, i.e. that the action wasn't performed
            MoinLocalizedBaseRuntimeException exceptionForClient = null;
            if ( partitionChangeMode == PARTITION_CHANGE_MODE_EDIT ) {
                exceptionForClient = new PartitionEditingNotPossibleException( lockingEx, RepositoryCoreMessages.LOCKINGEXCEPTIONENCOUNTERED, partitionPri );
            } else if ( partitionChangeMode == PARTITION_CHANGE_MODE_DELETE ) {
                exceptionForClient = new PartitionDeletingNotPossibleException( lockingEx, RepositoryCoreMessages.LOCKINGEXCEPTIONENCOUNTERED, partitionPri );
            } else {// no partition change mode set
                exceptionForClient = lockingEx;
            }
            throw new RecoverableExecutionException( exceptionForClient );
        }
    }

    @Override
    public void revert( ) {

        CoreModelPartition partition = this.getPartition( this.partitionPri );
        // we only try to rollback if the action was executed successfully (lockObtained == true) and the lock wasn't
        // obtained already before (lockWasAlreadyObtained == false), otherwise we would change something (take away the
        // lock) that we didn't do (obtaining the lock was done by some other action before)
        if ( lockObtained && !lockWasAlreadyObtained ) {
            try {
                connection.getPartitionLockManager( ).releaseLock( partition.getPri( ), this.owner );
            } catch ( LockingException lockingEx ) {
                throw new UnrecoverableExecutionException( lockingEx );
            }
        }
    }

    public boolean getLockWasAlreadyObtained( ) {

        return this.lockWasAlreadyObtained;
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof PartitionLockObtainAction ) ) {
            return false;
        } else {
            PartitionLockObtainAction action = (PartitionLockObtainAction) obj;
            result = partitionPri.equals( action.partitionPri ) && owner.equals( action.owner ) && partitionChangeMode == action.partitionChangeMode;
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return 41 * ( partitionPri.hashCode( ) + owner.hashCode( ) + partitionChangeMode );
    }
}
