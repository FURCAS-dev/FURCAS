package com.sap.tc.moin.repository.core.locking;

import java.util.Collection;
import java.util.HashSet;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LockingException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.cdam.CompoundDataArea;
import com.sap.tc.moin.repository.core.CoreCommandStack;
import com.sap.tc.moin.repository.core.CoreLockManager;
import com.sap.tc.moin.repository.core.LockManagerWrapper;
import com.sap.tc.moin.repository.core.PartitionLockManager;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;

/**
 * The compound partition lock manager delegates to the partition lock manager
 * responsible for a given data area.
 * 
 * @author d026715
 */
public final class CompoundPartitionLockManagerImpl implements PartitionLockManager, CoreLockManager {

    private LockManagerRegistry registry;

    private CompoundDataArea compoundDataArea;

    private LockManagerWrapper wrapper;

    public CompoundPartitionLockManagerImpl( LockManagerRegistry registry, CompoundDataArea compDataArea ) {

        this.registry = registry;
        this.compoundDataArea = compDataArea;
        this.wrapper = new LockManagerWrapper( this, registry.getWorkspaceSet( ) );
    }

    public final Connection getLockOwner( PRI pri ) {

        // the following is only input validation
        checkParameterIsNotNull( pri );

        PartitionLockManager lockManager = this.getResponsibleLockManager( pri );
        return lockManager.getLockOwner( pri );
    }

    public final boolean isLockedByConnection( PRI pri, Connection connection ) {

        checkParameterIsNotNull( pri );

        PartitionLockManager lockManager = this.getResponsibleLockManager( pri );
        return lockManager.isLockedByConnection( pri, connection );
    }

    public final Collection<PRI> getLockedPartitions( Connection owner ) {

        // the following is only input validation
        checkParameterIsNotNull( owner );

        Collection<PRI> result = new HashSet<PRI>( );
        for ( PartitionLockManager lockManager : this.registry.getAllPartitionLockManagers( ) ) {
            result.addAll( lockManager.getLockedPartitions( owner ) );
        }

        return result;
    }

    public final Collection<PRI> getLockedResources( Object owner ) {

        // the following is only input validation
        checkParameterIsNotNull( owner );

        Collection<PRI> result = new HashSet<PRI>( );
        for ( PartitionLockManager lockManager : this.registry.getAllPartitionLockManagers( ) ) {
            result.addAll( lockManager.getLockedResources( owner ) );
        }

        return result;
    }

    public final void obtainTransientLock( PRI pri, Connection owner ) throws LockingException {

        // the following is only input validation
        checkParameterIsNotNull( pri );
        checkParameterIsNotNull( owner );

        PartitionLockManager lockManager = this.getResponsibleLockManager( pri );
        lockManager.obtainTransientLock( pri, owner );

    }

    public final boolean obtainLock( PRI pri, Object owner ) throws LockingException {

        // the following is only input validation
        checkParameterIsNotNull( pri );
        checkParameterIsNotNull( owner );

        PartitionLockManager lockManager = this.getResponsibleLockManager( pri );
        return lockManager.obtainLock( pri, owner );
    }

    public final void checkLock( PRI pri, Object owner ) throws LockingException {

        // the following is only input validation
        checkParameterIsNotNull( pri );
        checkParameterIsNotNull( owner );

        PartitionLockManager lockManager = this.getResponsibleLockManager( pri );
        lockManager.checkLock( pri, owner );
    }

    public final void releaseAllLocks( Object owner ) throws LockingException {

        checkParameterIsNotNull( owner );

        for ( PartitionLockManager lockManager : this.registry.getAllPartitionLockManagers( ) ) {
            lockManager.releaseAllLocks( owner );
        }
    }

    public final void releaseLock( PRI pri1, Object owner ) throws LockingException {

        // the following is only input validation
        checkParameterIsNotNull( pri1 );
        checkParameterIsNotNull( owner );

        PartitionLockManager lockManager = this.getResponsibleLockManager( pri1 );
        lockManager.releaseLock( pri1, owner );
    }

    public final void obtainApplicationLock( PRI pri, Connection owner ) throws LockingException {

        // the following is only input validation
        checkParameterIsNotNull( pri );
        checkParameterIsNotNull( owner );

        // Check if no command is running
        if ( ( (CoreCommandStack) owner.getCommandStack( ) ).getState( ).isRunning( ) ) {
            throw new MoinIllegalStateException( CoreLockingMessages.APPLOCKNOTALLOWEDDURINGCOMMAND );
        }

        PartitionLockManager lockManager = this.getResponsibleLockManager( pri );
        lockManager.obtainApplicationLock( pri, owner );
    }

    /**
     * Checks if the parameter is <code>null</code>. If so, a
     * {@link IllegalArgumentException} is thrown.
     */
    private static void checkParameterIsNotNull( Object pCheckedObject ) throws IllegalArgumentException {

        if ( pCheckedObject == null ) {
            throw new MoinIllegalArgumentException( CoreLockingMessages.LOCKARGISNULL );
        }
    }

    public final void checkApplicationLock( PRI pri, Connection owner ) throws LockingException {

        // the following is only input validation
        checkParameterIsNotNull( pri );
        checkParameterIsNotNull( owner );

        PartitionLockManager lockManager = this.getResponsibleLockManager( pri );
        lockManager.checkApplicationLock( pri, owner );
    }


    public final void releaseApplicationLock( PRI pri, Connection owner ) throws LockingException {

        // the following is only input validation
        checkParameterIsNotNull( pri );
        checkParameterIsNotNull( owner );

        // Check if no command is running
        if ( ( (CoreCommandStack) owner.getCommandStack( ) ).getState( ).isRunning( ) ) {
            throw new MoinIllegalStateException( CoreLockingMessages.APPLOCKRELNOTALLOWEDDURINGCOMMAND );
        }

        PartitionLockManager lockManager = this.getResponsibleLockManager( pri );
        lockManager.releaseApplicationLock( pri, owner );
    }

    /**
     * Gets the partition lock manager responsible for the given PRI.
     * 
     * @param pri
     * @return
     * @throws LockingException
     */
    private PartitionLockManager getResponsibleLockManager( PRI pri ) {

        return this.registry.getPartitionLockManager( this.compoundDataArea.getDataArea( pri.getDataAreaDescriptor( ) ) );
    }

    public final LockManagerWrapper getWrapper( ) {

        return wrapper;
    }
}