package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.impl.TransientPartition;
import com.sap.tc.moin.repository.spi.core.SpiStage;

public class TransientPartitionCreateAction extends AbstractAction {

    private PRI pri = null;

    private SpiStage stage = null;

    private Workspace workspace = null;

    public TransientPartitionCreateAction( CoreConnection aConnection, PRI aPri, SpiStage aStage, Workspace aWorkspace ) {

        super( aConnection );
        pri = aPri;
        stage = aStage;
        workspace = aWorkspace;
    }

    @Override
    public void execute( ) {

        TransientPartition partition = new TransientPartition( connection, workspace, pri, stage );
        workspace.getPartitionManager( ).addPartition( connection, partition );
    }

    @Override
    public void revert( ) {

        CoreModelPartition partition = connection.getPartition( pri );
        partition.___delete( );
        workspace.getPartitionManager( ).removePartition( pri );
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof TransientPartitionCreateAction ) ) {
            return false;
        } else {
            result = pri.equals( ( (TransientPartitionCreateAction) obj ).pri );
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return pri.hashCode( );
    }
}
