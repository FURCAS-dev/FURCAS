package com.sap.tc.moin.repository.spi.facility;

import java.util.Collection;

import com.sap.tc.moin.repository.PRI;


/**
 * SPI interface for the integration of MOIN external locking mechanism.
 * <p>
 * The implementor should implement the external save protocol.
 * <p>
 * <img src="doc-files/SaveLockingParticipantStates.gif" alt="External save
 * locking participant states">
 * <p>
 * The implementation of this interface enables a facility implementor to
 * acquire locks needed for save operations in a specific environment before
 * internal MOIN locks are acquired (and release them vice versa).
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 * 
 * @see SpiFacility
 * @see SpiPersistence#savePartitions(Collection, Collection, Collection,
 * Object)
 * @author d047015
 * @author d046220
 */
public interface SpiExternalSaveLocking {

    /**
     * Acquires a lock on this facility based on the parameters which correlate
     * with an upcoming save operation. The lock will be acquired, before the
     * MOIN core starts its locking cycle.
     * <p>
     * Returns a lock handle needed to release the acquired lock or
     * <code>null</code> if no lock could be acquired.
     * 
     * @param partitionsToBeEdited A {@link Collection} of partitions which will
     * be edited during the subsequent save cycle.
     * @param partitionsToBeCreated A {@link Collection} of partitions which
     * will be created during the subsequent save cycle.
     * @param partitionsToBeDeleted A {@link Collection} of partitions which
     * will be deleted during the subsequent save cycle.
     * @return A lock handle needed to release the acquired lock or
     * <code>null</code> if no lock could be acquired.
     * @see #releaseLock(Object)
     */
    public Object acquireLock( Collection<PRI> partitionsToBeEdited, Collection<PRI> partitionsToBeCreated, Collection<PRI> partitionsToBeDeleted );

    /**
     * Releases a previously acquired lock identified by its handle.
     * 
     * @param lockHandle A handle of the lock to release.
     * @see #acquireLock(Collection, Collection, Collection)
     */
    public void releaseLock( Object lockHandle );


}
