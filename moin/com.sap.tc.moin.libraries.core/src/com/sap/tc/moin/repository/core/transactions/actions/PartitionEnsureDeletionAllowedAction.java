package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionChangingNotPossibleException;
import com.sap.tc.moin.repository.PartitionDeletingNotPossibleException;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;

public class PartitionEnsureDeletionAllowedAction extends PartitionEnsureChangeAllowedAction {

    public PartitionEnsureDeletionAllowedAction( CoreConnection aConnection, PRI partition ) {

        super( aConnection, partition );
    }

    @Override
    protected void doExecute( CoreModelPartition partition ) {

        if ( partition.isDirty( ) && !partition.isPersisted( ) ) {
            // dirty created partitions can currently deleted without ensuring this action concerning life cycle management
            // (name reserving for creation of objects in life cycle management is not yet available in any LM system)
            return;
        }
        getFacility( ).getLifecycleManagement( ).ensureDeletingAllowed( partition.getPri( ), (SpiClientSpec) this.connection.getSession( ).getCompoundClientSpec( ).getClientSpec( partition.getPri( ).getDataAreaDescriptor( ) ) );
    }

    @Override
    public void revert( ) {

        // do nothing, as changes done by the facility cannot be reverted currently

        // ATTENTION:
        // if this is implemented, also an "inverse" Action must be implemented and integrated within "undo" of
        // microtransactionables
    }

    @Override
    protected PartitionChangingNotPossibleException createException( MoinLocalizedString message ) {

        return new PartitionDeletingNotPossibleException( message, this.partitionPri );
    }

}
