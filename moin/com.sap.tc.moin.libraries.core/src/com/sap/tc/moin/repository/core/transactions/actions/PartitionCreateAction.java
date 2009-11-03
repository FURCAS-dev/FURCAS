package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionCreatingNotPossibleException;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.impl.ModelPartitionImpl;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;

public class PartitionCreateAction extends AbstractAction {

    private PRI pri = null;

    private SpiStage stage = null;

    private Workspace workspace = null;

    public PartitionCreateAction( CoreConnection aConnection, PRI aPri, SpiStage aStage, Workspace aWorkspace, boolean anIsReadOnly ) {

        super( aConnection );
        pri = aPri;
        stage = aStage;
        workspace = aWorkspace;
    }

    @Override
    public void execute( ) {

        ModelPartitionImpl partition = new ModelPartitionImpl( pri, stage, workspace );
        // check if there is an existing partition that is deleted and to be
        // recreated

        CoreModelPartition existingPartition = getPartitionManager( ).getPartitionConsideringDeleted( connection.getSession( ), pri, true );
        if ( existingPartition == null ) {
            getPartitionManager( ).addPartition( connection, partition );
        } else if ( !existingPartition.isAlive( ) ) {
            getPartitionManager( ).removePartition( existingPartition.getPri( ) );
            getPartitionManager( ).addPartition( connection, partition );
            if ( existingPartition.isPersisted( ) ) {
                partition.markPersisted( );
            }
        } else {
            throw new RecoverableExecutionException( new PartitionCreatingNotPossibleException( RepositoryCoreMessages.PARTITIONALREADYEXISTS, pri ) );
        }
    }

    @Override
    public void revert( ) {

        CoreModelPartition partition = getPartitionManager( ).getPartition( connection.getSession( ), pri, true );
        partition.___delete( );
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof PartitionCreateAction ) ) {
            return false;
        } else {
            result = pri.equals( ( (PartitionCreateAction) obj ).pri );
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return pri.hashCode( );
    }
}
