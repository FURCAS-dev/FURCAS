package com.sap.tc.moin.repository.core.transactions.actions;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionChangingNotPossibleException;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.impl.TransientPartition;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.messages.core.RepositoryCoreMessages;
import com.sap.tc.moin.repository.spi.facility.SpiFacilityException;

public abstract class PartitionEnsureChangeAllowedAction extends PartitionEnsureActivityAllowedAction {

    public PartitionEnsureChangeAllowedAction( CoreConnection aConnection, PRI partition ) {

        super( aConnection, partition );
    }

    @Override
    protected final void doExecute( ) throws PartitionChangingNotPossibleException {

        CoreModelPartition partition = this.getWorkspaceSet( ).resolvePri( this.connection.getSession( ), this.partitionPri, true );
        if ( partition == null ) {
            throw createException( RepositoryCoreMessages.COULDNTGETPARTITIONFORPRI );
        }

        if ( !partition.isAlive( ) ) {
            throw createException( RepositoryCoreMessages.PARTITIONISINVALID );
        }

        if ( partition.getPri( ).isVolatilePartition( ) ) {
            TransientPartition transientPartition = (TransientPartition) partition;
            if ( transientPartition.isExtentPartition( ) ) {
                // TODO only allow during setup, not by a client. But how??
                return;
            }

            if ( this.connection != transientPartition.getOwningConnection( ) ) {
                throw createException( RepositoryCoreMessages.TRANSIENTPARTITIONCANNOTCHANGEDBYOTHERCONN );
            } else {
                return;
            }
        }

        if ( this.getWorkspaceSet( ).getMoin( ).getMetamodelWorkspace( ) == partition.getWorkspace( ) ) {
            throw createException( RepositoryCoreMessages.MMPARTITIONCANNOTBECHANGED );
        } else {
            if ( !connection.isMemoryChangeOnlyEnabled( ) ) {
                //do the facility checks only if connection is not in "memory change only" mode
                this.doExecute( partition );
            }
        }

    }

    protected abstract void doExecute( CoreModelPartition partition ) throws SpiFacilityException;

    protected abstract PartitionChangingNotPossibleException createException( MoinLocalizedString message );
}
