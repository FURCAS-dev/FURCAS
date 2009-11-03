package com.sap.tc.moin.repository.core.events;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.PartitionDeleteEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.PartitionDeleteEvent}
 * 
 * @author Daniel Vocke (D044825)
 */
public class PartitionDeleteEventImpl extends PartitionChangeEventImpl implements PartitionDeleteEvent {

    /**
     * @param affectedPartitionMri the {@link PRI} of the removed partition
     */
    public PartitionDeleteEventImpl( CoreConnection triggeringConnection, PRI affectedPartitionMri ) {

        super( triggeringConnection, affectedPartitionMri );
    }

    /**
     * @param affectedPartition the partition that will be removed
     */
    public PartitionDeleteEventImpl( CoreConnection triggeringConnection, ModelPartition affectedPartition ) {

        super( triggeringConnection, affectedPartition );
    }

    @Override
    protected String getTypeString( ) {

        return "PartitionRemoveEvent"; //$NON-NLS-1$
    }
}
