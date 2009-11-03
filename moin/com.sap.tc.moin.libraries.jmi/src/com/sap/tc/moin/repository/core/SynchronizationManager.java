package com.sap.tc.moin.repository.core;

import java.util.Map;

import com.sap.tc.moin.repository.spi.facility.SpiFacility;

public interface SynchronizationManager {

    /**
     * Acquires the read lock of the enclosing {@link WorkspaceSet}.
     */
    public void acquireReadLock( );

    /**
     * Releases the read lock of the enclosing {@link WorkspaceSet}.
     */
    public void releaseReadLock( );


    public Object getProhibitWriteSyncObject( );

    public Object getProhibitSaveSyncObject( );

    public void releaseMicroWriteLock( );

    public void acquireMicroWriteLock( );

    public Map<SpiFacility, Object> acquireFacilityLocks( Map<SpiFacility, PartitionsSaveRecord> facilityToPartitionOperations );

    public void releaseFacilityLocks( Map<SpiFacility, Object> lockHandle );

    /**
     * For monitoring purposes only, not to be used for functional stuff.
     */
    public boolean isLockHeldByCurrentThread( );

    /**
     * For monitoring purposes only. Tells weather monitoring is enabled or not.
     */
    public boolean checkLockHolding( );

}