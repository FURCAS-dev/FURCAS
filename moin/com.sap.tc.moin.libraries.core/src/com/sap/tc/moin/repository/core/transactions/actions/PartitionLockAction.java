package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;

public abstract class PartitionLockAction extends AbstractAction {

    protected PRI partitionPri = null;

    protected Object owner = null;

    public PartitionLockAction( CoreConnection aConnection, PRI aPartitionPri, Object anOwner ) {

        super( aConnection );
        partitionPri = aPartitionPri;
        owner = anOwner;
    }

    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof PartitionLockAction ) {
            PartitionLockAction action = (PartitionLockAction) obj;
            return partitionPri.equals( action.partitionPri ) && owner.equals( action.owner );
        }
        return false;
    }

    public int hashCode( ) {

        return 41 * ( partitionPri.hashCode( ) + owner.hashCode( ) );
    }
}
