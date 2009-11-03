package com.sap.tc.moin.repository.spi.facility;

import java.util.Collection;

import com.sap.tc.moin.repository.LockedException;
import com.sap.tc.moin.repository.LockingException;
import com.sap.tc.moin.repository.PRI;

/**
 * SPI interface for the MOIN internal dirty lock handling within a facility.
 * <p>
 * The methods in this interface allow distributed dirty state locking over
 * multiple MOIN instances. The facility has to realize the locking mechanism
 * for a specific environment.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 */
public interface SpiInternalDistributedDirtyLocking {

    /**
     * Tries to obtain a lock for the passed resource on behalf of the passed
     * owner. This method is idempotent, i.e. repeated calls with the same
     * parameters have the same effect as calling it once.
     * 
     * @param pResInfo The resource for which the owner wants to obtain a lock.
     * @param owner The owner of the requested lock on the resource.
     * @throws LockedException is thrown if the resource is locked by a
     * different owner.
     * @throws LockingException is thrown if for any reason (other than the
     * resource is already locked by a different owner) no lock on the resource
     * for the specified owner can be obtained.
     */
    public void obtainLock( PRI pResInfo, Object owner ) throws LockingException;

    /**
     * Checks whether a lock exists for the passed resource and owner. If not,
     * an exception will be thrown.
     * 
     * @param pResInfo The resource to be checked if there is a lock existing on
     * it which is owned by the passed owner.
     * @param owner The owner to be checked if it owns a lock on the passed
     * resource.
     * @throws LockedException is thrown if the resource is locked by a
     * different owner.
     * @throws LockingException is thrown if there is no lock on the passed
     * resource or if for any reason (other than the resource is already locked
     * by a different owner) it couldn't be determined if there is a lock
     * existing for the passed resource and owner.
     */
    public void checkLock( PRI pResInfo, Object owner ) throws LockingException;

    /**
     * Releases all locks that are currently held by the passed owner. If there
     * are no locks existing for the passed owner, this method will have no
     * effect, especially no exception will be thrown.
     * 
     * @param owner The owner whose locks should all be released.
     * @throws LockingException is thrown if for any reason not all of the
     * existing locks held by the passed owner could be released.
     */
    public void releaseAllLocks( Object owner ) throws LockingException;

    /**
     * Releases the lock on the passed resource that the passed owner currently
     * holds. If the passed resource is not locked at all, this method will have
     * no effect, especially no exception will be thrown.
     * 
     * @param pResInfo The resource for which the lock is to be released.
     * @param owner The owner whose lock on the resource is to be released.
     * @throws LockedException is thrown if the resource is locked by a
     * different owner.
     * @throws LockingException is thrown if there is a lock existing on the
     * passed resource for the passed owner, but for any reason, the lock could
     * not be released.
     */
    public void releaseLock( PRI pResInfo, Object owner ) throws LockingException;

    /**
     * Returns the owner which currently holds the lock on the given resource.
     * 
     * @param pResInfo the resource for which the lock owner is to be
     * determined.
     * @return the owner which currently holds the lock on the given resource,
     * <code>null</code> if the resource is not locked at all.
     */
    public Object getLockOwner( PRI pResInfo );

    /**
     * Returns the resources the given owner has currently locked.
     * 
     * @param owner The owner whose locked resources will be returned.
     * @return the locked resources of the given owner, an empty collection if
     * there are no locked resources, never <code>null</code>.
     */
    public Collection<PRI> getLockedResources( Object owner );

}