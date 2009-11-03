package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;
import com.sap.tc.moin.repository.transactions.microtransactionables.TransientPartitionCreateMicroTransactionable;

public class TransientPartitionCreateMicroTransactionableImpl extends AbstractMicroTransactionable implements TransientPartitionCreateMicroTransactionable {

    private PRI partitionCreatedPri = null;

    private String partitionCreatedName = null;

    private SpiStage partitionCreatedStage = null;

    private Workspace partitionCreatedWorkspace = null;

    public TransientPartitionCreateMicroTransactionableImpl( CoreConnection aConnection, PRI aPri, SpiStage aStage, Workspace aWorkspace, String partitionName ) {

        super( aConnection );
        this.partitionCreatedPri = aPri;
        this.partitionCreatedStage = aStage;
        this.partitionCreatedWorkspace = aWorkspace;
        this.partitionCreatedName = partitionName;
    }

    @Override
    public void assertDoPreConstraints( ) {

        super.assertDoPreConstraints( );
        try {
            this.partitionCreatedWorkspace.getPartitionManager( ).assertLegalPartitionNameForTransientPartition( partitionCreatedName );
        } catch ( RuntimeException e ) {
            RecoverableExecutionException exception = new RecoverableExecutionException( e, RepositoryCoreMessages.NOLEGALNAMEFORTRANSIENTPARTITION, partitionCreatedName );
            log.preConstraintCheckException( exception );
            throw exception;
        }
        if ( this.partitionCreatedStage == null ) {
            RecoverableExecutionException exception = new RecoverableExecutionException( RepositoryCoreMessages.COULDNTGETSTAGE, this.partitionCreatedPri.getDataAreaDescriptor( ), partitionCreatedWorkspace );
            log.preConstraintCheckException( exception );
            throw exception;
        }
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        // Creation and changes on transient partitions must not be ensured by the facility.
        // partition create action
        getOrCreateDoActions( ).add( ActionFactory.createTransientPartitionCreateAction( connection, partitionCreatedPri, partitionCreatedStage, partitionCreatedWorkspace ) );
        // partition create event
        if ( eventCreationNeeded( ) ) {
            getOrCreateDoEvents( ).add( getEventFactory( ).createPartitionCreatedEvent( connection, partitionCreatedPri ) );
        }
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        // partition delete action
        getOrCreateUndoActions( ).add( ActionFactory.createTransientPartitionDeleteAction( connection, partitionCreatedPri ) );
        // partition delete event
        if ( eventCreationNeeded( ) ) {
            getOrCreateUndoEvents( ).add( getEventFactory( ).createPartitionRemovedEvent( connection, partitionCreatedPri ) );
        }
    }

    public CoreModelPartition getPartitionCreated( ) {

        return getExistingPartition( partitionCreatedPri );
    }
}
