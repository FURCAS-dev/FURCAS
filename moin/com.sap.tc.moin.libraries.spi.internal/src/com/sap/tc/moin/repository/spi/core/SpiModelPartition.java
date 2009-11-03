/*
 * Created on 28.06.2006
 */
package com.sap.tc.moin.repository.spi.core;

import java.util.Collection;

import com.sap.tc.moin.repository.ModelPartition;

/**
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 * 
 * @author d044711
 */
public interface SpiModelPartition extends ModelPartition {

    public SpiResourceInfo getResourceInformation( );

    /**
     * Obtains the workspace in which this partition is currently loaded. A
     * precondition for this relation is that the workspace is responsible for
     * this partition. Partitions do not necessarily need to be managed by a
     * responsible workspace. Therefore, this operation may return <tt>null</tt>.
     * <p>
     * Postcondition: <tt>getResponsibleWorkspace() == null ||
     *                getResponsibleWorkspace.getPartitions().contains(this)</tt>
     */
    public SpiWorkspace getWorkspace( );

    public Collection<SpiLink> getLinks( );

    /**
     * Returns whether this partition has been stored to or loaded from the
     * persistence.
     */
    public boolean isPersisted( );

    /**
     * Marks this partition as being stored to or loaded from the persistence.
     */
    public void markPersisted( );

    /**
     * Unmarks this partition as being stored to or loaded from the persistence.
     */
    public void clearPersisted( );

    /**
     * Sets the timestamp of when the partition was persisted
     */
    public void setPersistedTimestamp( long value );

    /**
     * Returns the persistence timestamp of the partition.
     */
    public long getPersistedTimestamp( );
}
