package com.sap.tc.moin.repository.core;

import java.util.Collection;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LockManager;
import com.sap.tc.moin.repository.LockedException;
import com.sap.tc.moin.repository.LockingException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.repository.spi.core.Wrapper;

public final class LockManagerWrapper implements LockManager, Wrapper<CoreLockManager> {

    private final CoreLockManager lockManager;

    private final SynchronizationManager synchronizationManager;

    public LockManagerWrapper( CoreLockManager lockManager, WorkspaceSet workspaceSet ) {

        this.lockManager = lockManager;
        this.synchronizationManager = workspaceSet.getSynchronizationManager( );
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof LockManagerWrapper ) {
            return lockManager.equals( ( (LockManagerWrapper) obj ).lockManager );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return lockManager.hashCode( );
    }

    @Override
    public String toString( ) {

        return lockManager.toString( );
    }

    public void obtainApplicationLock( PRI pri, Connection owner ) throws LockingException {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            CoreConnection _owner = null;
            if ( owner != null ) {
                _owner = ( (Wrapper<CoreConnection>) owner ).unwrap( );
            }
            try {
                lockManager.obtainApplicationLock( pri, _owner );
            } catch ( LockedException e ) {
                wrapLockedByAndRethrow( e );
            }
        }

    }

    public void checkApplicationLock( PRI pri, Connection owner ) throws LockingException {

        CoreConnection _owner = null;
        if ( owner != null ) {
            _owner = ( (Wrapper<CoreConnection>) owner ).unwrap( );
        }
        try {
            lockManager.checkApplicationLock( pri, _owner );
        } catch ( LockedException e ) {
            wrapLockedByAndRethrow( e );
        }

    }

    public void releaseApplicationLock( PRI pri, Connection owner ) throws LockingException {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            CoreConnection _owner = null;
            if ( owner != null ) {
                _owner = ( (Wrapper<CoreConnection>) owner ).unwrap( );
            }
            try {
                lockManager.releaseApplicationLock( pri, _owner );
            } catch ( LockedException e ) {
                wrapLockedByAndRethrow( e );
            }
        }
    }

    public void obtainTransientLock( PRI pri, Connection owner ) throws LockingException {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            CoreConnection _owner = null;
            if ( owner != null ) {
                _owner = ( (Wrapper<CoreConnection>) owner ).unwrap( );
            }
            try {
                lockManager.obtainTransientLock( pri, _owner );
            } catch ( LockedException e ) {
                wrapLockedByAndRethrow( e );
            } catch ( MoinBaseRuntimeException e ) {
                LockedException lockedEception = getNestedLockedException( e );
                if ( lockedEception != null ) {
                    wrapLockedBy( lockedEception );
                }
                throw e;
            }
        }
    }

    private LockedException getNestedLockedException( MoinBaseRuntimeException e ) {

        Throwable currentThrowable = e;
        while ( currentThrowable != null ) {
            currentThrowable = currentThrowable.getCause( );
            if ( currentThrowable instanceof LockedException ) {
                return (LockedException) currentThrowable;
            }
        }

        return null;
    }

    public Connection getLockOwner( PRI pri ) {

        Connection result = lockManager.getLockOwner( pri );
        if ( result != null ) {
            result = ( (CoreConnection) result ).getWrapper( );
        }
        return result;
    }

    public Collection<PRI> getLockedPartitions( Connection owner ) {

        CoreConnection _owner = null;
        if ( owner != null ) {
            _owner = ( (Wrapper<CoreConnection>) owner ).unwrap( );
        }
        return lockManager.getLockedPartitions( _owner );
    }

    public CoreLockManager unwrap( ) {

        return lockManager;
    }

    private void wrapLockedByAndRethrow( LockedException e ) {

        this.wrapLockedBy( e );
        throw e;
    }

    private void wrapLockedBy( LockedException e ) {

        Object lockedBy = e.getLockedBy( );
        if ( lockedBy instanceof CoreConnection ) {
            Object currentOwner = ( (CoreConnection) lockedBy ).getWrapper( );
            e.setLockedBy( currentOwner );
        }
    }

}