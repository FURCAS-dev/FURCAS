package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;

public class PartitionClearDirtyAction extends PartitionDirtyAction {

    public PartitionClearDirtyAction( CoreConnection aConnection, PRI aPartitionPri ) {

        super( aConnection, aPartitionPri );
    }

    public void execute( ) {

        super.clearDirty( );
    }

    public void revert( ) {

        super.markDirty( );
    }

    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof PartitionClearDirtyAction ) ) {
            return false;
        } else {
            PartitionClearDirtyAction action = (PartitionClearDirtyAction) obj;
            result = partitionPri.equals( action.partitionPri );
        }
        return result;
    }

    public int hashCode( ) {

        return partitionPri.hashCode( );
    }
}
