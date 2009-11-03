package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.InvalidModelPartitionException;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.spi.core.Wrapper;

public final class ModelPartitionWrapper extends AbstractConnectionAwareWrapper<CoreModelPartition> implements ModelPartition {

    private PriReference priReference;

    public ModelPartitionWrapper( WorkspaceSet workspaceSet, CoreConnection connection, PriReference priReference ) {

        super( connection, workspaceSet.getSynchronizationManager( ) );
        this.priReference = priReference;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof ModelPartitionWrapper ) {
            return priReference.equals( ( (ModelPartitionWrapper) obj ).priReference );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return priReference.hashCode( );
    }

    @Override
    public String toString( ) {

        if ( priReference.isCached( ) ) {
            return unwrapInternal( ).toString( );
        }
        return priReference.toString( );
    }

    public PRI getPri( ) {

        return priReference.getPri( );
    }

    public boolean isDirty( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertModelPartitionValid( );
            attachConnectionIfRequired( );
            return unwrapInternal( ).isDirty( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    @SuppressWarnings( "unchecked" )
    public void assignElement( Partitionable element ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertModelPartitionValid( );
            attachConnectionIfRequired( );
            CoreModelPartition partition = unwrapInternal( );
            if ( element != null ) {
                partition.assignElement( connection, ( (Wrapper<Partitionable>) element ).unwrap( ) );
            } else {
                partition.assignElement( connection, (Partitionable) null );
            }
        }
    }

    @SuppressWarnings( "unchecked" )
    public void assignElementIncludingChildren( Partitionable element ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertModelPartitionValid( );
            attachConnectionIfRequired( );
            CoreModelPartition partition = unwrapInternal( );
            if ( element != null ) {
                partition.assignElementIncludingChildren( connection, ( (Wrapper<Partitionable>) element ).unwrap( ) );
            } else {
                partition.assignElementIncludingChildren( connection, (Partitionable) null );
            }
        }
    }

    public Collection<Partitionable> getElements( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertModelPartitionValid( );
            attachConnectionIfRequired( );
            CoreModelPartition partition = unwrapInternal( );
            if ( partition.isExtentPartition( ) ) {
                synchronized ( partition ) {
                    return getElementsInternal( partition );
                }
            } else {
                return getElementsInternal( partition );
            }
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    private Collection<Partitionable> getElementsInternal( CoreModelPartition partition ) {

        Collection<Partitionable> unwrapped = partition.getElements( );
        Collection<Partitionable> result = new LinkedHashSet<Partitionable>( unwrapped.size( ) );
        for ( Partitionable partitionable : unwrapped ) {
            result.add( connection.getWrapperForJmiObject( (RefBaseObject) partitionable ) );
        }
        return result;
    }

    public void delete( ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertModelPartitionValid( );
            attachConnectionIfRequired( );
            unwrapInternal( ).delete( connection );
        }
    }

    public void deleteElements( ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertModelPartitionValid( );
            attachConnectionIfRequired( );
            unwrapInternal( ).deleteElements( connection );
        }
    }

    public <T extends RefObject> T createElement( ClassDescriptor<? extends RefClass, T> classDescriptor ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertModelPartitionValid( );
            attachConnectionIfRequired( );
            return connection.getWrapperForJmiObject( unwrapInternal( ).createElement( connection, classDescriptor ) );
        }
    }

    public <T extends RefObject> T createElement( Class<T> clazz ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertModelPartitionValid( );
            attachConnectionIfRequired( );
            return connection.getWrapperForJmiObject( unwrapInternal( ).createElement( connection, clazz ) );
        }
    }

    public CoreModelPartition unwrap( ) {

        synchronizationManager.acquireReadLock( );
        try {
            if ( priReference.isCached( ) ) {
                return priReference.get( connection );
            }
            attachConnectionIfRequired( );
            return priReference.get( connection );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean isAlive( ) {

        synchronizationManager.acquireReadLock( );
        try {
            if ( this.connection.isAlive( ) ) {
                attachConnectionIfRequired( );
                // Don't use unwrap() here in order to avoid program flow with
                // exception.
                CoreModelPartition result = priReference.getWithoutException( connection );
                if ( result != null ) {
                    return result.isAlive( );
                }
                return false;
            }
            return false;
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean isMemoryStateDifferentFromPersistentStateAfterLoad( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertModelPartitionValid( );
            attachConnectionIfRequired( );
            return unwrapInternal( ).isMemoryStateDifferentFromPersistentStateAfterLoad( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean hadUnhandledErrorsDuringLoad( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertModelPartitionValid( );
            attachConnectionIfRequired( );
            return unwrapInternal( ).hadUnhandledErrorsDuringLoad( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public Map<CRI, String> getUsedMetamodels( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertModelPartitionValid( );
            attachConnectionIfRequired( );
            return unwrapInternal( ).getUsedMetamodels( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    private CoreModelPartition unwrapInternal( ) {

        CoreModelPartition result = priReference.getWithoutException( connection );
        if ( result == null ) {
            throw new InvalidModelPartitionException( JmiCoreMessages.PARTITIONRETRIEVENULL, priReference.getPri( ) );
        }
        if ( !result.isAlive( ) ) {
            throw new InvalidModelPartitionException( JmiCoreMessages.PARTITIONISINVALID, priReference.getPri( ) );
        }
        return result;
    }

    private final void assertModelPartitionValid( ) {

        if ( connection == null || !connection.isAlive( ) ) {
            throw new InvalidModelPartitionException( JmiCoreMessages.PARTITIONCONNECTIONNULL, priReference.getPri( ) );
        }
    }

    @Override
    protected CoreModelPartition resolveWrappedElement( CoreConnection conn ) {

        PRI pri = this.priReference.getPri( );
        CoreModelPartition result = conn.getPartition( pri );
        if ( result == null ) {
            throw new UnresolvableException( JmiCoreMessages.PARTITIONNOTRESOLVEDFROMSESSION, pri, this.connection.getSession( ) );
        }
        return result;
    }

    public void setPriReference( PriReference priReference ) {

        this.priReference = priReference;
    }
}