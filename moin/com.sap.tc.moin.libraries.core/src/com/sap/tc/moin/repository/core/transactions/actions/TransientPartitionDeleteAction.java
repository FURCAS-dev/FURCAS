package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.impl.TransientPartition;
import com.sap.tc.moin.repository.spi.core.SpiStage;

public class TransientPartitionDeleteAction extends AbstractAction {

    private PRI pri = null;

    private SpiStage stage = null;

    private Workspace workspace = null;

    public TransientPartitionDeleteAction( CoreConnection aConnection, PRI aPri ) {

        super( aConnection );
        CoreModelPartition partition = connection.getPartition( aPri );
        pri = aPri;
        workspace = partition.getWorkspace( );
        stage = partition.getResourceInformation( ).getStage( );
    }

    @Override
    public void execute( ) {

        CoreModelPartition partition = connection.getPartition( pri );
        partition.___delete( );
        workspace.getPartitionManager( ).removePartition( pri );
    }

    @Override
    public void revert( ) {

        TransientPartition partition = new TransientPartition( connection, workspace, pri, stage );
        workspace.getPartitionManager( ).addPartition( connection, partition );
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof TransientPartitionDeleteAction ) ) {
            return false;
        } else {
            result = pri.equals( ( (TransientPartitionDeleteAction) obj ).pri );
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return pri.hashCode( );
    }
}
