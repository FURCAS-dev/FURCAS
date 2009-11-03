/*
 * Created on 30.05.2006
 */
package com.sap.tc.moin.repository.core.locking;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.LockManager;
import com.sap.tc.moin.repository.core.PartitionLockManager;
import com.sap.tc.moin.repository.core.WorkspaceSet;

/**
 * Factory and manager of
 * {@link com.sap.tc.moin.repository.core.impl.PartitionLockManager} and
 * {@link com.sap.tc.moin.repository.LockManager} instances. It's a singleton
 * which takes care that there is exactly one partition lock manager resp.
 * application lock manager instance per data area. Those instances are
 * requested by either {@link #getApplicationLockManager(DataArea)} or
 * {@link #getPartitionLockManager(DataArea)} and are created lazily on the
 * first request. All subsequent requests will hand out the same instance per
 * data area.
 * 
 * @author d044711
 */
public class LockManagerRegistry {


    /**
     * Here the lock manager instances are stored, keyed by the corresponding
     * data area.
     */
    private Map<DataArea, PartitionLockManager> dataArea2LockManager;

    private WorkspaceSet workspaceSet;

    /**
     * Private constructor because of Singleton pattern.
     */
    public LockManagerRegistry( WorkspaceSet workspaceSet ) {

        this.workspaceSet = workspaceSet;
        this.dataArea2LockManager = new HashMap<DataArea, PartitionLockManager>( );
    }

    /**
     * Getter for the application lock manager instance corresponding to the
     * supplied data area.
     * 
     * @param dataArea the data area for which the corresponding application
     * lock manager instance is requested.
     * @return the application lock manager instance corresponding to the
     * supplied data area.
     */
    public LockManager getApplicationLockManager( DataArea dataArea ) {

        return getPartitionLockManager( dataArea );
    }

    /**
     * Getter for the partition lock manager instance corresponding to the
     * supplied data area.
     * 
     * @param dataArea the data area for which the corresponding partition lock
     * manager instance is requested.
     * @return the partition lock manager instance corresponding to the supplied
     * data area.
     */
    public synchronized PartitionLockManager getPartitionLockManager( DataArea dataArea ) {

        PartitionLockManager lockManager = this.dataArea2LockManager.get( dataArea );
        if ( lockManager == null ) {
            lockManager = new PartitionLockManagerImpl( dataArea, this.workspaceSet );
            this.dataArea2LockManager.put( dataArea, lockManager );
        }

        return lockManager;
    }

    Collection<PartitionLockManager> getAllPartitionLockManagers( ) {

        return this.dataArea2LockManager.values( );
    }

    /**
     * Clears the internal mapping from data area to application/partition lock
     * manager instances. This should only be called on shutdown because after
     * this, new lock manager instances will be passed out when requested.<br>
     */
    public void clear( ) {

        // TODO release all locks???
        this.dataArea2LockManager.clear( );
    }

    public WorkspaceSet getWorkspaceSet( ) {

        return workspaceSet;
    }


}
