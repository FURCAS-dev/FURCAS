package com.sap.tc.moin.repository.core.events;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.PartitionCreateEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.PartitionCreateEvent}
 * 
 * @author Daniel Vocke (D044825)
 */
public class PartitionCreateEventImpl extends PartitionChangeEventImpl implements PartitionCreateEvent {

    /**
     * @param affectedPartitionMri the {@link PRI} of the created partition
     */
    public PartitionCreateEventImpl( CoreConnection triggeringConnection, PRI affectedPartitionPri ) {

        super( triggeringConnection, affectedPartitionPri );
    }

    /**
     * @param affectedPartition the created partition
     */
    public PartitionCreateEventImpl( CoreConnection triggeringConnection, ModelPartition affectedPartition ) {

        super( triggeringConnection, affectedPartition );
    }

    @Override
    protected String getTypeString( ) {

        return "PartitionCreateEvent"; //$NON-NLS-1$
    }
}
