package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionFactory;
import com.sap.tc.moin.repository.core.CorePartitionManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.transactions.TransactionManager;
import com.sap.tc.moin.repository.transactions.microtransactionables.MicroTransactionableFactory;
import com.sap.tc.moin.repository.transactions.microtransactionables.PartitionCreateMicroTransactionable;
import com.sap.tc.moin.repository.transactions.microtransactionables.TransientPartitionCreateMicroTransactionable;

public class PartitionFactoryImpl implements CorePartitionFactory {

    private Workspace workspace;

    public PartitionFactoryImpl( Workspace aWorkspace ) {

        workspace = aWorkspace;
    }

    public CoreModelPartition ___createModelPartition( CoreConnection connection, PRI pri ) {

        SpiStage clientSpecificStage = ( (SpiClientSpec) connection.getSession( ).getCompoundClientSpec( ).getClientSpec( pri.getDataAreaDescriptor( ) ) ).getClientSpecificStage( );

        return ___createModelPartition( connection, pri, clientSpecificStage, workspace );
    }

    public CoreModelPartition ___createModelPartition( CoreConnection connection, PRI pri, SpiStage stage, Workspace workspace ) {

        CoreModelPartition newPartition = createModelPartition( pri, stage, workspace );
        CorePartitionManager partitionManager = workspace.getPartitionManager( );
        partitionManager.addPartition( connection, newPartition );
        return newPartition;
    }

    public CoreModelPartition createModelPartition( PRI pri, SpiStage stage, Workspace workspace ) {

        return new ModelPartitionImpl( pri, stage, workspace );
    }

    public CoreModelPartition createTransientPartition( CoreConnection connection, PRI pri, SpiStage stage, String partitionName ) {

        MicroTransactionableFactory microTxFactory = workspace.getWorkspaceSet( ).getMoin( ).getMicroTransactionableFactory( );
        TransactionManager transactionManager = connection.getSession( ).getTransactionManager( );
        TransientPartitionCreateMicroTransactionable pcmtx = microTxFactory.createTransientPartitionCreateMicroTransactionable( connection, pri, stage, workspace, partitionName );
        transactionManager.runInMicroTransaction( pcmtx );
        return (CoreModelPartition) pcmtx.getPartitionCreated( );
    }

    public CoreModelPartition createTransientPartitionNonTransactional( CoreConnection connection, PRI pri, SpiStage stage ) {

        TransientPartition partition = new TransientPartition( connection, workspace, pri, stage );
        workspace.getPartitionManager( ).addPartition( connection, partition );
        return partition;
    }

    public CoreModelPartition createExtentPartition( PRI pri, SpiStage metaModelStage ) {

        return new ExtentPartition( pri, workspace, metaModelStage );
    }

    public CoreModelPartition createModelPartition( CoreConnection connection, PRI pri ) {

        MicroTransactionableFactory microTxFactory = workspace.getWorkspaceSet( ).getMoin( ).getMicroTransactionableFactory( );
        TransactionManager transactionManager = connection.getSession( ).getTransactionManager( );
        PartitionCreateMicroTransactionable pcmtx = microTxFactory.createPartitionCreateMicroTransactionable( connection, pri );
        transactionManager.runInMicroTransaction( pcmtx );
        return (CoreModelPartition) pcmtx.getPartitionCreated( );
    }
}
