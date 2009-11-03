package com.sap.tc.moin.repository;

import java.util.Collection;


/**
 * Client API for locking.
 * <p>
 * Locks have the following qualities:
 * <ul>
 * <li>A lock has a {@link com.sap.tc.moin.repository.Connection} as owner, only
 * instances of {@link com.sap.tc.moin.repository.PRI} which represent the
 * {@link com.sap.tc.moin.repository.ModelPartition} to be locked, are supported
 * as lock argument.</li>
 * <li>A lock is always "exclusive". Other lock modes (shared, optimistic) are
 * not supported.</li>
 * <li>A lock is cumulative, i.e. it has a lock counter (integer). Initially the
 * counter is one, and it increases with each
 * {@link #obtainApplicationLock(PRI, Connection) lock} operation and decreases
 * with each {@link #releaseApplicationLock(PRI, Connection) unlock} operation.
 * When the counter is below one, then the lock is removed.</li>
 * </ul>
 * the following usage scencario of the locking is recommended:
 * <p>
 * <ol>
 * <li>Set a lock with {@link #obtainApplicationLock(PRI, Connection)} on the
 * {@link com.sap.tc.moin.repository.ModelPartition partition} on behalf of the
 * {@link com.sap.tc.moin.repository.Connection owner}. If no
 * {@link com.sap.tc.moin.repository.LockingException} is thrown, the specified
 * owner gets the lock and no other owner can get this lock.</li>
 * <li>Read your data, manipulate it or do something else.</li>
 * <li>To ensure the lock is still existing, call
 * {@link #checkApplicationLock(PRI, Connection)}. If no exception is thrown,
 * the specified owner still owns the lock.</li>
 * <li>Update your data.</li>
 * <li>If the lock is not required any longer it is released with
 * {@link #releaseApplicationLock(PRI, Connection)}. Remember that you have to
 * call {@link #releaseApplicationLock(PRI, Connection)} as often as
 * {@link #obtainApplicationLock(PRI, Connection)} in order to have the lock
 * completely removed. If a {@link com.sap.tc.moin.repository.Connection
 * connection} is closed, all locks which are still held by that connection will
 * be released automatically.</li>
 * </ol>
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface LockManager {

    /**
     * Tries to obtain a lock on the resource represented by the passed
     * {@link PRI mri} on behalf of the passed {@link Connection connection}.
     * This method should be called first before the resource represented by the
     * mri. This method is cumulative, i.e. every subsequent call of the method
     * increases an internal lock counter and no exception is raised. You must
     * make sure to call {@link #releaseApplicationLock(PRI, Connection)}
     * exactly as often as you have called this method in order to finally
     * release the lock.
     * 
     * @param pri Represents the resource on which the connection would like to
     * obtain a lock.
     * @param owner The owner of the requested lock.
     * @throws LockedException is thrown if the resource is locked by a
     * different owner.
     * @throws LockingException is thrown if for any reason (other than the
     * resource is already locked by a different owner) no lock on the resource
     * for the specified owner can be obtained.
     */
    public void obtainApplicationLock( PRI pri, Connection owner ) throws LockingException;

    /**
     * Checks whether a lock exists for the passed resource and owner. If not,
     * an exception will be thrown.
     * 
     * @param pri Represents the resource to be checked if there is a lock
     * existing on it which is owned by the passed owner.
     * @param owner The owner to be checked if it owns a lock on the passed
     * resource.
     * @throws LockedException is thrown if the resource is locked by a
     * different owner.
     * @throws LockingException is thrown if there is no lock on the passed
     * resource or if for any reason (other than the resource is already locked
     * by a different owner) it couldn't be determined if there is a lock
     * existing for the passed resource and owner.
     */
    public void checkApplicationLock( PRI pri, Connection owner ) throws LockingException;

    /**
     * Releases the lock on the resource represented by the passed {@link PRI}
     * that the passed owner currently holds according to its internal lock
     * counter. This method is decreasing the internal lock counter, i.e. you
     * must call it as often as you have invoked
     * {@link #obtainApplicationLock(PRI, Connection)} in order to finally
     * release the lock. If the relevant resource is not locked at all, this
     * method will have no effect, especially no exception will be thrown.
     * 
     * @param pri Represents the resource for which the lock is to be released.
     * @param owner The owner of the lock which is to be released.
     * @throws LockedException is thrown if the resource is locked by a
     * different owner.
     * @throws LockingException is thrown if there is a lock existing on the
     * passed resource for the passed owner, but for any reason, the lock could
     * not be released.
     */
    public void releaseApplicationLock( PRI pri, Connection owner ) throws LockingException;

    /**
     * Tries to obtain the "transient lock" for a given partition. Transient
     * locks are automatically released after transient changes of a partition
     * have been saved.
     * 
     * @param pri the partition on which the connection would like to obtain a
     * lock.
     * @param owner The connection which is the owner of the requested lock.
     * @throws LockingException thrown if for any reason (other than the
     * resource is already locked by a different owner) no lock on the resource
     * for the specified owner can be obtained.
     */
    public void obtainTransientLock( PRI pri, Connection owner ) throws LockingException;

    /**
     * Gets the connection which currently holds a lock on the given partition.
     * 
     * @param pri the partition of which the connection holding the lock is
     * requested.
     * @return the connection that owns the (transient or application) lock for
     * the given partition, <code>null</code> if the partition is not locked at
     * all.
     */
    public Connection getLockOwner( PRI pri );

    /**
     * Gets all the partitions which are currently locked by the given
     * connection.
     * 
     * @param owner the connection for which to retrieve all currently held
     * locks.
     * @return a collection of PRIs the given connection currently has locks
     * for, an empty collection if the connection has no locks at all, never
     * <code>null</code>.
     */
    public Collection<PRI> getLockedPartitions( Connection owner );

}