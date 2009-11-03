package com.sap.tc.moin.repository.core.events;

import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.PartitionSaveEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.PartitionSaveEvent}
 * 
 * @author Daniel Vocke (d044825)
 */
public class PartitionSaveEventImpl extends PartitionChangeEventImpl implements PartitionSaveEvent {

    /**
     * @param partition the partition which was / shall be saved
     */
    public PartitionSaveEventImpl( CoreConnection triggeringConnection, ModelPartition partition ) {

        super( triggeringConnection, partition );
    }

    @Override
    protected String getParameterString( ) {

        return "PRI=" + getAffectedPartitionPri( ); //$NON-NLS-1$
    }

    @Override
    protected String getTypeString( ) {

        return "SaveEvent"; //$NON-NLS-1$
    }
}
