package com.sap.tc.moin.repository.core;

import java.util.Collection;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LockManager;
import com.sap.tc.moin.repository.LockedException;
import com.sap.tc.moin.repository.LockingException;
import com.sap.tc.moin.repository.PRI;

/**
 * Internal API for locking.
 * <p>
 * The locking functionality supports explicit locking by external clients via
 * the {@link com.sap.tc.moin.repository.LockManager} API and implicit locking
 * by this API.<br>
 * Both the client applications and the MOIN core (usually) use the
 * {@link Connection} as lock owner. It is allowed that both an application and
 * the MOIN core lock the same object for the same connection at the same time.
 * An instance of this class acts as a lock cache that keeps track of all locks
 * that were retrieved by the MOIN core or the application.<br>
 * {@link com.sap.tc.moin.repository.core.Facility Facilities} that have their
 * own locking (which is typically the case) can plug it into a partition lock
 * manger by implementing the
 * {@link com.sap.tc.moin.repository.spi.SpiInternalDistributedDirtyLocking} SPI. Provided that
 * such a facility locking exists, the partition lock manager delegates to that
 * facility's locking implementation in all important steps, e.g. when
 * {@link #obtainLock(PRI, Object) retrieving} a lock for the first time,
 * {@link #releaseLock(PRI, Object) releasing} a lock or
 * {@link #checkLock(PRI, Object) checking} the lock explicitly.<br>
 * The {@link #obtainLock(PRI, Object) obtaining} of locks via a partition lock
 * manager is idempotent, i.e. you can call {@link #obtainLock(PRI, Object)} as
 * often as you want with the same effect as calling it only once (given that
 * {@link #releaseLock(PRI, Object)} was not called in between).<br>
 * A lock will only be removed if it is not also locked by an application when
 * {@link #releaseLock(PRI, Object)} is called. However,
 * {@link #releaseAllLocks(Object)} will remove all locks for the respective
 * owner regardless if locked by an application or not. Usually, a lock is owned
 * by a {@link com.sap.tc.moin.repository.core.Connection connection}. If a
 * connection is closed correctly, all locks still held by that connection have
 * to be {@link #releaseAllLocks(Object) removed}. If a connection is not
 * closed, but dropped and after some time destroyed by the garbage collector, a
 * notification mechanism informs the relevant partition lock manager instances
 * which then will remove all remaining locks for that owner. The same holds
 * true for any other lock owner (which needs not necessarily be a connection)
 * when it is garbage collected.
 * <p>
 * Please also see the overview document for more detailed information on the
 * locking architecture.
 * 
 * @see com.sap.tc.moin.repository.LockManager
 * @see com.sap.tc.moin.repository.spi.SpiInternalDistributedDirtyLocking
 */
public interface PartitionLockManager extends LockManager {

    /**
     * Tries to obtain a lock for the passed resource on behalf of the passed
     * owner. This method should be called first before the resource is
     * modified. This method is idempotent, i.e. repeated calls with the same
     * parameters have the same effect as calling it once. By the return value
     * it can be determined if the owner already held that lock or obtained it
     * for the first time.
     * 
     * @param resInfo The resource for which the owner wants to obtain a lock.
     * @param owner The owner of the requested lock on the resource.
     * @throws LockedException is thrown if the resource is locked by a
     * different owner.
     * @throws LockingException is thrown if for any reason (other than the
     * resource is already locked by a different owner) no lock on the resource
     * for the specified owner can be obtained.
     * @throws
     * com.sap.tc.moin.repository.exception.wrapped.IllegalArgumentException is
     * thrown if resource or owner is <code>null</code>
     * @return <code>true</code> if the lock was obtained for the first time,
     * <code>false</code> otherwise.
     */
    public boolean obtainLock( PRI resInfo, Object owner ) throws LockingException;

    /**
     * Checks whether a lock exists for the passed resource and owner. If not,
     * an exception will be thrown.
     * 
     * @param resInfo The resource to be checked if there is a lock existing on
     * it which is owned by the passed owner.
     * @param owner The owner to be checked if it owns a lock on the passed
     * resource.
     * @throws LockedException is thrown if the resource is locked by a
     * different owner.
     * @throws LockingException is thrown if there is no lock on the passed
     * resource or if for any reason (other than the resource is already locked
     * by a different owner) it couldn't be determined if there is a lock
     * existing for the passed resource and owner.
     * @throws
     * com.sap.tc.moin.repository.exception.wrapped.IllegalArgumentException is
     * thrown if resource or owner is <code>null</code>
     */
    public void checkLock( PRI resInfo, Object owner ) throws LockingException;

    /**
     * Releases all locks that are currently held by the passed owner. If there
     * are no locks existing for the passed owner, this method will have no
     * effect, especially no exception will be thrown.
     * 
     * @param owner The owner whose locks should all be released.
     * @throws LockingException is thrown if for any reason not all of the
     * existing locks held by the passed owner could be released.
     * @throws
     * com.sap.tc.moin.repository.exception.wrapped.IllegalArgumentException is
     * thrown if owner is <code>null</code>
     */
    public void releaseAllLocks( Object owner ) throws LockingException;

    /**
     * Releases the lock on the passed resource that the passed owner currently
     * holds. If the passed resource is not locked at all, this method will have
     * no effect, especially no exception will be thrown.
     * 
     * @param resInfo The resource for which the lock is to be released.
     * @param owner The owner whose lock on the resource is to be released.
     * @throws LockedException is thrown if the resource is locked by a
     * different owner.
     * @throws LockingException is thrown if there is a lock existing on the
     * passed resource for the passed owner, but for any reason, the lock could
     * not be released.
     * @throws
     * com.sap.tc.moin.repository.exception.wrapped.IllegalArgumentException is
     * thrown if resource or owner is <code>null</code>
     */
    public void releaseLock( PRI resInfo, Object owner ) throws LockingException;

    public Collection<PRI> getLockedResources( Object owner );

    public boolean isLockedByConnection( PRI pri, Connection connection );

}