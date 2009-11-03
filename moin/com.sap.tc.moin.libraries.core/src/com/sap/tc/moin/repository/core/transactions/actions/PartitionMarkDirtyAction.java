package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;

public class PartitionMarkDirtyAction extends PartitionDirtyAction {

    private boolean wasDirty;

    public PartitionMarkDirtyAction( CoreConnection aConnection, PRI aPartitionPri ) {

        super( aConnection, aPartitionPri );
    }

    public void execute( ) {

        wasDirty = super.markDirty( );
    }

    public void revert( ) {

        if ( !wasDirty ) {
            super.clearDirty( );
        }
    }

    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof PartitionMarkDirtyAction ) ) {
            return false;
        } else {
            PartitionMarkDirtyAction action = (PartitionMarkDirtyAction) obj;
            result = partitionPri.equals( action.partitionPri ) && wasDirty == action.wasDirty;
        }
        return result;
    }

    public int hashCode( ) {

        return 41 * ( partitionPri.hashCode( ) + Boolean.valueOf( wasDirty ).hashCode( ) );
    }
}
