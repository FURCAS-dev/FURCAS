package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.InconsistentModelException;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CompoundClientSpecWorkspace;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.transactions.RecoverableExecutionException;

public class PartitionableAssignPartitionAction extends AbstractAction {

    private MRI partitionableMri = null;

    private PRI oldModelPartitionPri = null;

    private PRI newModelPartitionPri = null;

    public PartitionableAssignPartitionAction( CoreConnection aConnection, MRI aPartitionableMri, PRI anOldModelPartitionPri, PRI aNewModelPartitionPri ) {

        super( aConnection );
        partitionableMri = aPartitionableMri;
        oldModelPartitionPri = anOldModelPartitionPri;
        newModelPartitionPri = aNewModelPartitionPri;
    }

    @Override
    public void execute( ) {

        if ( !oldModelPartitionPri.equals( newModelPartitionPri ) ) {
            CorePartitionable partitionable = getElement( partitionableMri );
            CoreModelPartition oldPartition = getPartition( oldModelPartitionPri );
            CoreModelPartition newPartition = getPartition( newModelPartitionPri );
            assert !( oldPartition.getWorkspace( ) instanceof CompoundClientSpecWorkspace ) && !( newPartition.getWorkspace( ) instanceof CompoundClientSpecWorkspace ) : "Illegal modification of CompoundClientSpecWorkspace!"; //$NON-NLS-1$
            CorePartitionable existingInstance = newPartition.getWorkspace( ).getInstanceManager( ).getInstance( newModelPartitionPri.createMri( partitionableMri.getMofId( ) ) );
            if ( existingInstance != null ) {
                // The element already exists in the new partition (duplicate element inconsistency),
                // therefore repartitioning is not allowed!
                throw new RecoverableExecutionException( new InconsistentModelException( RepositoryCoreMessages.INSTANCE_ALREADY_HOSTED, existingInstance.toString( ) ) );
            }
            getLogicalLinkManager( ).elementRelocated( connection, oldPartition, newPartition, partitionable );
            getReferenceManager( ).elementRelocated( connection, oldPartition, newPartition, partitionable.refMofId( ) );
            connection.getSession( ).getWorkspace( ).getQueryLinkManager( ).elementRelocated( partitionableMri, newPartition );
            // after telling the news to the link manager and reference manager
            partitionable.set___PartitionAssignment( newPartition );
            getPartitionChangeRecorder( ).elementAssigned( oldPartition, newPartition, partitionable );
            connection.getSession( ).getConsistencyViolationRegistry( ).elementRelocated( connection, newModelPartitionPri, partitionableMri );
        }
    }

    @Override
    public void revert( ) {

        if ( !oldModelPartitionPri.equals( newModelPartitionPri ) ) {
            // can not use MRI because it has changed after repartitioning
            CorePartitionable partitionable = getElement( partitionableMri.getLri( ) );
            CoreModelPartition oldPartition = getPartition( oldModelPartitionPri );
            CoreModelPartition newPartition = getPartition( newModelPartitionPri );
            getLogicalLinkManager( ).elementRelocated( connection, newPartition, oldPartition, partitionable );
            getReferenceManager( ).elementRelocated( connection, newPartition, oldPartition, partitionable.refMofId( ) );
            connection.getSession( ).getWorkspace( ).getQueryLinkManager( ).elementRelocated( partitionable.get___Mri( ), oldPartition );
            partitionable.set___PartitionAssignment( oldPartition );
            getPartitionChangeRecorder( ).elementAssigned( newPartition, oldPartition, partitionable );
        }
    }

    @Override
    public boolean equals( Object obj ) {

        boolean result = false;
        if ( obj == this ) {
            return true;
        } else if ( !( obj instanceof PartitionableAssignPartitionAction ) ) {
            return false;
        } else {
            PartitionableAssignPartitionAction action = (PartitionableAssignPartitionAction) obj;
            result = partitionableMri.equals( action.partitionableMri ) && oldModelPartitionPri.equals( action.oldModelPartitionPri ) && newModelPartitionPri.equals( action.newModelPartitionPri );
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return 41 * ( partitionableMri.hashCode( ) + oldModelPartitionPri.hashCode( ) + newModelPartitionPri.hashCode( ) );
    }
}
