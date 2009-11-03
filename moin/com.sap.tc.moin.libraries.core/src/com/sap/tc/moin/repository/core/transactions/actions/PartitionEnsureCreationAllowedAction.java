package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;

public class PartitionEnsureCreationAllowedAction extends PartitionEnsureActivityAllowedAction {

    public PartitionEnsureCreationAllowedAction( CoreConnection aConnection, PRI partition ) {

        super( aConnection, partition );
    }

    @Override
    protected void doExecute( ) {

        getFacility( ).getLifecycleManagement( ).ensureCreatingAllowed( this.partitionPri, (SpiClientSpec) this.connection.getSession( ).getCompoundClientSpec( ).getClientSpec( this.partitionPri.getDataAreaDescriptor( ) ) );
    }

    @Override
    public void revert( ) {

        // do nothing, as changes done by the facility cannot be reverted currently

        // ATTENTION:
        // if this is implemented, also an "inverse" Action must be implemented and integrated within "undo" of
        // microtransactionables
    }

}
