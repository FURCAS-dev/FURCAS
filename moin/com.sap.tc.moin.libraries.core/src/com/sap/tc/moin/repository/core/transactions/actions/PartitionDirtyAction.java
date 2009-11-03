package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;

public abstract class PartitionDirtyAction extends AbstractAction {

    protected PRI partitionPri = null;

    public PartitionDirtyAction( CoreConnection aConnection, PRI aPartitionPri ) {

        super( aConnection );
        partitionPri = aPartitionPri;
    }

    public boolean markDirty( ) {

        CoreModelPartition partition = getPartition( partitionPri );
        assert !( partition.getWorkspace( ) instanceof CompoundClientSpecWorkspace ) : "Illegal modification of CompoundClientSpecWorkspace!"; //$NON-NLS-1$
        return partition.markDirty( connection );
    }

    public void clearDirty( ) {

        CoreModelPartition partition = getPartition( partitionPri );
        assert !( partition.getWorkspace( ) instanceof CompoundClientSpecWorkspace ) : "Illegal modification of CompoundClientSpecWorkspace!"; //$NON-NLS-1$
        partition.clearDirty( connection );
    }
}
