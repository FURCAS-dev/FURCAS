package com.sap.tc.moin.repository.core;

import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.mof.OclMofConstraintRegistry;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclConstraintManagerException;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationCategory;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * The {@link OclMofConstraintRegistry} wrapper
 */
public class OclMofConstraintRegistryWrapper extends AbstractConnectionAwareWrapper<CoreOclMofConstraintRegistry> implements OclMofConstraintRegistry {

    private CoreOclMofConstraintRegistry oclMofConstraintRegistry;

    private final static MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_CORE_OCL, OclMofConstraintRegistryWrapper.class );

    /**
     * @param oclRegistryService the service
     * @param actConnection the connection
     * @throws OclManagerException internal
     */
    public OclMofConstraintRegistryWrapper( CoreOclRegistryService oclRegistryService, CoreConnection actConnection ) throws OclManagerException {

        super( actConnection, actConnection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.oclMofConstraintRegistry = oclRegistryService.getCoreOclMofConstraintRegistry( actConnection );
    }

    public void analyzeCollectedEvents( OclRegistrationCategory... category ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            this.oclMofConstraintRegistry.analyzeCollectedEvents( this.connection, category );
        }
    }

    public DeferredConstraintViolationStatus analyzeMetamodelPartitions( Set<PRI> partitionPris, OclRegistrationCategory... category ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMofConstraintRegistry.analyzeMetamodelPartitions( this.connection, partitionPris, category );
        }
    }

    public DeferredConstraintViolationStatus verifyConstraints( Set<PRI> pris, Set<OclRegistrationCategory> categories ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMofConstraintRegistry.verifyConstraints( this.connection, pris, categories );
        }
    }

    public Set<OclMetaModelConstraintRegistration> getAvailableMofConstraints( ) throws OclConstraintManagerException {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return wrapSet( this.oclMofConstraintRegistry.getAvailableMofConstraints( this.connection ) );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public boolean registerDeferredConstraintViolationListenerForEvents( DeferredConstraintViolationListener listener, OclRegistrationCategory... category ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            try {
                return this.oclMofConstraintRegistry.registerDeferredConstraintViolationListenerForEvents( this.connection, listener, category );
            } catch ( OclManagerException e ) {
                LOGGER.trace( e, MoinSeverity.ERROR );
                return false;
            }
        }
    }

    public void resetEvents( OclRegistrationCategory... category ) throws OclManagerException {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            this.oclMofConstraintRegistry.resetEvents( this.connection, category );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }

    }

    public boolean unregisterDeferredConstraintViolationListener( DeferredConstraintViolationListener listener ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMofConstraintRegistry.unregisterDeferredConstraintViolationListener( this.connection, listener );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public CoreOclMofConstraintRegistry unwrap( ) {

        return this.oclMofConstraintRegistry;
    }

    private Set<OclMetaModelConstraintRegistration> wrapSet( Set<OclMetaModelConstraintRegistration> registrations ) {

        Set<OclMetaModelConstraintRegistration> result = new HashSet<OclMetaModelConstraintRegistration>( );
        for ( OclMetaModelConstraintRegistration registration : registrations ) {
            result.add( new OclMetaModelConstraintRegistrationWrapper( registration, this.connection ) );
        }
        return result;
    }

    public boolean registerImmediateConstraintViolationListener( ImmediateConstraintViolationListener listener ) {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            try {
                return this.oclMofConstraintRegistry.registerImmediateConstraintViolationListener( this.connection, listener );
            } catch ( OclManagerException e ) {
                LOGGER.trace( e, MoinSeverity.ERROR );
                return false;
            }
        }
    }

    public boolean unregisterImmediateConstraintViolationListener( ImmediateConstraintViolationListener listener ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMofConstraintRegistry.unregisterImmediateConstraintViolationListener( this.connection, listener );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }
}
