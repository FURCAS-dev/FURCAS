package com.sap.tc.moin.repository.core;

import java.util.ArrayList;
import java.util.Collection;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.consistency.ConsistencyListener;
import com.sap.tc.moin.repository.consistency.ConsistencyViolation;
import com.sap.tc.moin.repository.consistency.ConsistencyViolationListenerRegistry;
import com.sap.tc.moin.repository.core.consistency.ConsistencyViolationRegistry;

public class ConsistencyViolationRegistryWrapperImpl extends AbstractConnectionAwareWrapper<ConsistencyViolationRegistry> implements ConsistencyViolationListenerRegistry {

    private ConsistencyViolationRegistry registry;

    public ConsistencyViolationRegistryWrapperImpl( CoreConnection connection ) {

        super( connection, connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.registry = connection.getConsistencyViolationRegistry( );
    }

    public void addListener( ConsistencyListener listener ) {

        registry.addListener( listener );
    }

    public void performDcDependencyCheck( PRI partition ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            this.registry.performDcDependencyCheck( partition, this.connection );
        }
    }

    public void performConsistencyCheck( PRI partition ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            this.registry.performConsistencyCheck( partition, this.connection );
        }
    }

    public void removeListener( ConsistencyListener listener ) {

        registry.removeListener( listener );
    }

    public void applyCorrection( String correctionId ) {

        // synchronization and lock handling is done by the corresponding
        // correction handle
        attachConnectionIfRequired( );

        // trigger correction
        registry.applyCorrection( correctionId, this.connection );
    }

    public Collection<ConsistencyViolation> getAllConsistencyViolations( ) {

        return this.registry.getAllConsistencyViolations( );
    }

    public ConsistencyViolation getConsistencyViolation( String id ) {

        return this.registry.getConsistencyViolation( id );
    }

    public ConsistencyViolationRegistry unwrap( ) {

        return this.registry;
    }

    public ConsistencyListener getDefaultListener( ) {

        return this.registry.getDefaultListener( );
    }

    public boolean listenersRegistered( ) {

        return this.registry.listenersRegistered( );
    }

    public void setDefaultListener( ConsistencyListener listener ) {

        this.registry.setDefaultListener( listener );
    }

    public Collection<PartitionOperation> getAffectedPartitions( String correctionId ) {

        Collection<PRI> affectedPartitions = registry.getAffectedPartitions( this.connection, correctionId );
        Collection<PartitionOperation> result = new ArrayList<PartitionOperation>( );

        for ( PRI pri : affectedPartitions ) {
            // the operation to be performed is always "Edit"
            PartitionOperation partitionOperation = new PartitionOperation( PartitionOperation.Operation.EDIT, pri );
            result.add( partitionOperation );
        }

        return result;
    }

}
