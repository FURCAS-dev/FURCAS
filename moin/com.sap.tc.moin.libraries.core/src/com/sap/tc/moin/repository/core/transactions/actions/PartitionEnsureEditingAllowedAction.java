package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionChangingNotPossibleException;
import com.sap.tc.moin.repository.PartitionEditingNotPossibleException;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;

public class PartitionEnsureEditingAllowedAction extends PartitionEnsureChangeAllowedAction {

    public PartitionEnsureEditingAllowedAction( CoreConnection aConnection, PRI partition ) {

        super( aConnection, partition );
    }

    @Override
    protected void doExecute( CoreModelPartition partition ) {

        getFacility( ).getLifecycleManagement( ).ensureEditingAllowed( partition.getPri( ), (SpiClientSpec) this.connection.getSession( ).getCompoundClientSpec( ).getClientSpec( partition.getPri( ).getDataAreaDescriptor( ) ) );
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

        return new PartitionEditingNotPossibleException( message, this.partitionPri );
    }

}
