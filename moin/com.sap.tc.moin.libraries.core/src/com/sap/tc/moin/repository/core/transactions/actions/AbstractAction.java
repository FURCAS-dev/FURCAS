package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreInstanceManager;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionManager;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.JmiCoreMessages;
import com.sap.tc.moin.repository.core.LogicalLinkManager;
import com.sap.tc.moin.repository.core.PartitionChangeRecorder;
import com.sap.tc.moin.repository.core.ReferenceManager;
import com.sap.tc.moin.repository.core.UnresolvableException;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.actions.Action;

public abstract class AbstractAction implements Action {

    protected CoreConnection connection = null;

    protected AbstractAction( CoreConnection aConnection ) {

        connection = aConnection;
    }

    public abstract void execute( ) throws UnrecoverableExecutionException, RecoverableExecutionException;

    public abstract void revert( ) throws UnrecoverableExecutionException;

    protected WorkspaceSet getWorkspaceSet( ) {

        return connection.getSession( ).getWorkspaceSet( );
    }

    protected LogicalLinkManager getLogicalLinkManager( ) {

        return connection.getSession( ).getWorkspaceSet( ).getLogicalLinkManager( );
    }

    protected ReferenceManager getReferenceManager( ) {

        return connection.getSession( ).getWorkspaceSet( ).getReferenceManager( );
    }

    protected PartitionChangeRecorder getPartitionChangeRecorder( ) {

        return connection.getPartitionChangeRecorder( );
    }

    protected CoreInstanceManager getInstanceManager( ) {

        return connection.getSession( ).getWorkspace( ).getInstanceManager( );
    }

    protected CorePartitionManager getPartitionManager( ) {

        return connection.getSession( ).getWorkspace( ).getPartitionManager( );
    }

    protected CoreModelPartition getPartition( PRI pri ) throws RecoverableExecutionException {

        CoreModelPartition partition = connection.getPartition( pri );
        if ( partition == null ) {
            throw new RecoverableExecutionException( JmiCoreMessages.PRINOTRESOLVED, pri );
        }
        return partition;
    }

    protected CorePartitionable getElement( MRI mri ) throws RecoverableExecutionException {

        CorePartitionable partitionable = (CorePartitionable) connection.getElement( mri );
        if ( partitionable == null ) {
            throw new RecoverableExecutionException( new UnresolvableException( JmiCoreMessages.MRINOTRESOLVED, mri ) );
        }
        return partitionable;
    }

    protected CorePartitionable getElement( LRI lri ) throws RecoverableExecutionException {

        CorePartitionable partitionable = (CorePartitionable) connection.getElement( lri );
        if ( partitionable == null ) {
            throw new RecoverableExecutionException( new UnresolvableException( JmiCoreMessages.LRINOTRESOLVED, lri ) );
        }
        return partitionable;
    }
}
