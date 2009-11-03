package com.sap.tc.moin.repository.spi.core;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.events.type.PartitionContentChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionCreateEvent;
import com.sap.tc.moin.repository.events.type.PartitionDeleteEvent;

/**
 * @author d024032
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 */
public interface SpiEventFactory {

    /*
     * PartitionEvents
     */
    public PartitionContentChangeEvent createPartitionContentChangedEvent( Connection triggeringConnection, PRI affectedPartition );

    public PartitionCreateEvent createPartitionCreatedEvent( Connection triggeringConnection, PRI affectedPartition );

    public PartitionDeleteEvent createPartitionRemovedEvent( Connection triggeringConnection, PRI affectedPartition );
}
