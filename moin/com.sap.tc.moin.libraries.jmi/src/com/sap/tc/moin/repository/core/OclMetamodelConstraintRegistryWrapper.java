package com.sap.tc.moin.repository.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetamodelConstraintRegistry;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;

/**
 * The {@link OclMetamodelConstraintRegistry} wrapper
 */
public class OclMetamodelConstraintRegistryWrapper extends AbstractConnectionAwareWrapper<CoreOclMetamodelConstraintRegistry> implements OclMetamodelConstraintRegistry {

    private CoreOclMetamodelConstraintRegistry oclMetamodelConstraintRegistry;

    /**
     * @param actRegistryService the {@link CoreOclRegistryService}
     * @param actConnection the connection
     */
    public OclMetamodelConstraintRegistryWrapper( CoreOclRegistryService actRegistryService, CoreConnection actConnection ) {

        super( actConnection, actConnection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.oclMetamodelConstraintRegistry = actRegistryService.getMetamodelConstraintRegistry( actConnection );
    }

    public Set<OclMetaModelConstraintRegistration> getAvailableMetamodelConstraints( ) throws OclConstraintManagerException {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return wrapSet( this.oclMetamodelConstraintRegistry.getAvailableMetamodelConstraints( this.connection ) );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    private Set<OclMetaModelConstraintRegistration> wrapSet( Set<OclMetaModelConstraintRegistration> registrations ) {

        Set<OclMetaModelConstraintRegistration> result = new HashSet<OclMetaModelConstraintRegistration>( );
        for ( OclMetaModelConstraintRegistration registration : registrations ) {
            result.add( new OclMetaModelConstraintRegistrationWrapper( registration, this.connection ) );
        }
        return result;
    }

    public Map<String, Set<OclMetaModelConstraintRegistration>> getRegistry( ) throws OclManagerException {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            Map<String, Set<OclMetaModelConstraintRegistration>> result = new HashMap<String, Set<OclMetaModelConstraintRegistration>>( );
            for ( Entry<String, Set<OclMetaModelConstraintRegistration>> entry : this.oclMetamodelConstraintRegistry.getRegistry( this.connection ).entrySet( ) ) {
                result.put( entry.getKey( ), wrapSet( entry.getValue( ) ) );
            }
            return result;
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public boolean registerDeferredConstraintViolationListenerForEvents( String category, DeferredConstraintViolationListener listener ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMetamodelConstraintRegistry.registerDeferredConstraintViolationListenerForEvents( this.connection, category, listener );
        }
    }

    public boolean registerImmediateConstraintViolationListener( String category, ImmediateConstraintViolationListener listener ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMetamodelConstraintRegistry.registerImmediateConstraintViolationListener( this.connection, category, listener );
        }
    }

    public boolean registerPartitionBasedConstraintViolationListener( String category, DeferredConstraintViolationListener listener ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMetamodelConstraintRegistry.registerPartitionBasedConstraintViolationListener( this.connection, category, listener );
        }
    }

    public boolean unregisterDeferredListener( DeferredConstraintViolationListener listener ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMetamodelConstraintRegistry.unregisterDeferredListener( this.connection, listener );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }

    }

    public boolean unregisterImmediateListener( ImmediateConstraintViolationListener listener ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMetamodelConstraintRegistry.unregisterImmediateListener( this.connection, listener );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }

    }

    public DeferredConstraintViolationStatus verifyConstraints( Set<PRI> pris, Set<String> categories ) throws OclManagerException {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMetamodelConstraintRegistry.verifyConstraints( this.connection, pris, categories );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public CoreOclMetamodelConstraintRegistry unwrap( ) {

        return this.oclMetamodelConstraintRegistry;
    }

}