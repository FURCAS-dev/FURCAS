package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.impl.ModelPartitionImpl;
import com.sap.tc.moin.repository.spi.core.SpiResourceInfo;

public class PartitionDeleteAction extends AbstractAction {

    private PRI pri = null;

    private Workspace workspace = null;

    private SpiResourceInfo resourceInfo = null;

    public PartitionDeleteAction( CoreConnection aConnection, PRI aPri ) {

        super( aConnection );
        CoreModelPartition partition = connection.getPartition( aPri );
        pri = aPri;
        workspace = partition.getWorkspace( );
        resourceInfo = partition.getResourceInformation( );
    }

    @Override
    public void execute( ) {

        assert !( workspace instanceof CompoundClientSpecWorkspace ) : "Illegal modification of CompoundClientSpecWorkspace!"; //$NON-NLS-1$
        CoreModelPartition partition = getPartitionManager( ).getPartition( connection.getSession( ), pri, true );
        partition.___delete( );
    }

    @Override
    public void revert( ) {

        ModelPartitionImpl partition = new ModelPartitionImpl( pri, resourceInfo.getStage( ), workspace );
        partition.setWorkspace( workspace );
        CoreModelPartition existingPartition = getPartitionManager( ).getPartitionConsideringDeleted( connection.getSession( ), pri, true );
        getPartitionManager( ).removePartition( existingPartition.getPri( ) );
        getPartitionManager( ).addPartition( connection, partition );
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof PartitionDeleteAction ) ) {
            return false;
        } else {
            result = pri.equals( ( (PartitionDeleteAction) obj ).pri );
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return pri.hashCode( );
    }
}
