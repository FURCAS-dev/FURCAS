package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.spi.facility.SpiPartitionChangeRecorder;

/**
 * The {@link PartitionChangeRecorder} interface provides methods that are called by the MOIN Core for reporting model
 * changes and resetting the recorder's internal state (usually after {@link Connection#save()} or {@link Connection#revert()}}).
 */
public interface PartitionChangeRecorder extends SpiPartitionChangeRecorder {

    /**
     * Notifies the PartitionChangeRecorder of a changed attribute value.
     */
    public void attributeValueChanged( CorePartitionable element, String attributeName, Object oldValue );

    /**
     * Notifies the PartitionChangeRecorder of a changed partition assignment.
     */
    public void elementAssigned( CoreModelPartition oldPartition, CoreModelPartition newPartition, CorePartitionable element );

    /**
     * Notifies the PartitionChangeRecorder of the creation of a model element.
     */
    public void elementCreated( CorePartitionable element );

    /**
     * Tells the PartitionChangeRecorder to undo the creation of a model element.
     */
    public void undoElementCreated( CorePartitionable element );

    /**
     * Notifies the PartitionChangeRecorder of the deletion of a model element.
     */
    public void elementDeleted( CorePartitionable element );

    /**
     * Tells the PartitionChangeRecorder to undo the deletion of a model element.
     */
    public void undoElementDeleted( CorePartitionable element );

    /**
     * Notifies the PartitionChangeRecorder of the addition of a link.
     */
    public void linkAdded( EndStorageLink link );

    /**
     * Tells the PartitionChangeRecorder to undo the addition of a link.
     */
    public void undoLinkAdded( EndStorageLink link );

    /**
     * Notifies the PartitionChangeRecorder of the removal of a link.
     */
    public void linkRemoved( EndStorageLink link );

    /**
     * Tells the PartitionChangeRecorder to undo the removal of a link.
     */
    public void undoLinkRemoved( EndStorageLink link );

    /**
     * Notifies the PartitionChangeRecorder of the forced eviction of a dirty model partition.
     */
    public void dirtyPartitionEvicted( CoreModelPartition partition );

    /**
     * Tells the PartitionChangeRecorder to reset its internal state.
     */
    public void clear( );
}