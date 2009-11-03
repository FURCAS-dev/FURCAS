package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.core.transactions.actions.ActionFactory;
import com.sap.tc.moin.repository.spi.core.SpiStage;
import com.sap.tc.moin.repository.spi.facility.SpiClientSpec;
import com.sap.tc.moin.repository.transactions.microtransactionables.PartitionCreateMicroTransactionable;

public class PartitionCreateMicroTransactionableImpl extends AbstractMicroTransactionable implements PartitionCreateMicroTransactionable {

    private PRI partitionCreatedPri = null;

    private SpiStage partitionCreatedStage = null;

    private Workspace partitionCreatedWorkspace = null;

    private boolean isReadOnly = false;

    /**
     * Creates a MicroTransactionable that creates a partition with the
     * specified {@link PRI} in the client specific {@link Workspace} with the
     * client specific {@link SpiStage}. The created partition in not
     * read-only.
     */
    public PartitionCreateMicroTransactionableImpl( CoreConnection aConnection, PRI aPri ) {

        super( aConnection );
        partitionCreatedPri = aPri;
        partitionCreatedStage = ( (SpiClientSpec) connection.getSession( ).getCompoundClientSpec( ).getClientSpec( partitionCreatedPri.getDataAreaDescriptor( ) ) ).getClientSpecificStage( );
        isReadOnly = false;
        partitionCreatedWorkspace = connection.getSession( ).getWorkspace( );
    }

    /**
     * Creates a MicroTransactionable that creates a partition with the
     * specified {@link PRI}, {@link SpiStage} and read-only nature in the
     * specified {@link Workspace}
     */
    public PartitionCreateMicroTransactionableImpl( CoreConnection aConnection, PRI aPri, SpiStage aStage, Workspace aWorkspace, boolean anIsReadOnly ) {

        super( aConnection );
        partitionCreatedPri = aPri;
        partitionCreatedStage = aStage;
        partitionCreatedWorkspace = aWorkspace;
        isReadOnly = anIsReadOnly;
    }

    @Override
    public void computeDoActionsAndDoEvents( ) {

        // ensure creation allowed action, only if the partition is not "dirtyDeleted"
        CoreModelPartition partition = this.connection.getSession( ).getWorkspace( ).getPartitionManager( ).getPartitionConsideringDeleted( connection.getSession( ), partitionCreatedPri, false );
        if ( partition == null ) {
            getOrCreateDoActions( ).add( ActionFactory.createEnsureCreationAllowedAction( connection, partitionCreatedPri ) );
        }

        // partition create action
        getOrCreateDoActions( ).add( ActionFactory.createPartitionCreateAction( connection, partitionCreatedPri, partitionCreatedStage, partitionCreatedWorkspace, isReadOnly ) );
        // partition mark dirty action
        getOrCreateDoActions( ).add( ActionFactory.createPartitionMarkDirtyAction( connection, partitionCreatedPri ) );
        // partition lock action
        getOrCreateDoActions( ).add( ActionFactory.createPartitionEditLockAction( connection, partitionCreatedPri ) );
        // partition create event
        if ( eventCreationNeeded( ) ) {
            getOrCreateDoEvents( ).add( getEventFactory( ).createPartitionCreatedEvent( connection, partitionCreatedPri ) );
        }
    }

    @Override
    public void computeUndoActionsAndUndoEvents( ) {

        // the partition wasn't in the persistence yet, therefore the deletion
        // needs not to be saved
        // clear the dirtiness so that the partition is not saved,
        // because the partition is not saved, its lock isn't released neither
        // and it needs to be released here
        // partition clear dirty action
        getOrCreateUndoActions( ).add( ActionFactory.createPartitionClearDirtyAction( connection, partitionCreatedPri ) );
        // partition release lock action
        getOrCreateUndoActions( ).add( ActionFactory.createPartitionLockReleaseAction( connection, partitionCreatedPri ) );
        // partition delete action
        getOrCreateUndoActions( ).add( ActionFactory.createPartitionDeleteAction( connection, partitionCreatedPri ) );
        // partition delete event
        if ( eventCreationNeeded( ) ) {
            getOrCreateUndoEvents( ).add( getEventFactory( ).createPartitionRemovedEvent( connection, partitionCreatedPri ) );
        }
    }

    public CoreModelPartition getPartitionCreated( ) {

        return getExistingPartition( partitionCreatedPri );
    }
}
