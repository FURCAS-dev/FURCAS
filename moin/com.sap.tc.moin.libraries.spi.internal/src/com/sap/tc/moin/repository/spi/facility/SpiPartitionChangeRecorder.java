package com.sap.tc.moin.repository.spi.facility;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.spi.core.SpiModelPartition;

/**
 * The {@link SpiPartitionChangeRecorder} is responsible for recording all model
 * changes without exception. Based on the collected data, it is able to compute
 * and return a partition-wise delta between the in-memory state and the
 * persistent state of a partition.
 * <p>
 * This delta information can for example be used by {@link SpiPersistence}
 * implementations for more efficient, fine-grained storage of partition
 * modifications during {@link Connection#save()}.
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 * 
 * @see SpiAbstractPersistence#storePartition(Connection, SpiModelPartition,
 * SpiPartitionDelta)
 * @see SpiPartitionDelta
 */
public interface SpiPartitionChangeRecorder {

    /**
     * Returns the delta for the given partition.
     * 
     * @param partition The partition for which the delta is requested.
     * @return The delta for the given partition.
     * @see SpiPartitionDelta
     */
    public SpiPartitionDelta getDeltaForPartition( SpiModelPartition partition );
}
