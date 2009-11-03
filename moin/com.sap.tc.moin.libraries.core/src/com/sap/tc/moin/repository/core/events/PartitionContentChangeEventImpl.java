package com.sap.tc.moin.repository.core.events;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.PartitionContentChangeEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.PartitionContentChangeEvent}
 * 
 * @author Daniel Vocke (D044825)
 */
public class PartitionContentChangeEventImpl extends PartitionChangeEventImpl implements PartitionContentChangeEvent {

    /**
     * @param affectedPartitionMri the {@link PRI} of the partition with the
     * changed content
     */
    public PartitionContentChangeEventImpl( CoreConnection triggeringConnection, PRI affectedPartitionPri ) {

        super( triggeringConnection, affectedPartitionPri );
    }

    /**
     * @param affectedPartition the partition with the changed content
     */
    public PartitionContentChangeEventImpl( CoreConnection triggeringConnection, ModelPartition affectedPartition ) {

        super( triggeringConnection, affectedPartition );
    }

    @Override
    protected String getTypeString( ) {

        return "PartitionContentChangeEvent"; //$NON-NLS-1$
    }
}
