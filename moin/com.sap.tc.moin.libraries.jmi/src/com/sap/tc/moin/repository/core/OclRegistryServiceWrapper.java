package com.sap.tc.moin.repository.core;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.freestyle.OclFreestyleRegistry;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetamodelConstraintRegistry;
import com.sap.tc.moin.repository.ocl.mof.OclMofConstraintRegistry;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatus;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * The {@link OclRegistryService} wrapper
 */
public class OclRegistryServiceWrapper extends AbstractConnectionAwareWrapper<CoreOclRegistryService> implements OclRegistryService {

    private final CoreOclRegistryService oclRegistryService;

    private OclFreestyleRegistryWrapper oclFreestyleRegistry;

    private OclMetamodelConstraintRegistryWrapper oclMetamodelConstraintRegistry;

    private OclMofConstraintRegistry oclMofConstraintRegistry;

    /**
     * @param registryService the {@link CoreOclRegistryService}
     * @param actConnection the connection
     */
    public OclRegistryServiceWrapper( CoreOclRegistryService registryService, CoreConnection actConnection ) {

        super( actConnection, actConnection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.oclRegistryService = registryService;
    }

    /**
     * @param connection the connection
     * @return the wrapper
     */
    public static OclRegistryServiceWrapper create( CoreConnection connection ) {

        CoreOclRegistryService registryService = connection.getSession( ).getCoreOclRegistryService( );
        if ( registryService == null ) {
            return null;
        }
        return new OclRegistryServiceWrapper( registryService, connection );
    }

    public boolean analyzeCollectedEvents( String category ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclRegistryService.analyzeCollectedEvents( this.connection, category );
        }
    }

    public boolean analyzeModelPartitions( String category, Set<PRI> partitions ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclRegistryService.analyzeModelPartitions( this.connection, category, partitions );
        }
    }

    public OclFreestyleRegistry getFreestyleRegistry( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            if ( this.oclFreestyleRegistry == null ) {
                this.oclFreestyleRegistry = new OclFreestyleRegistryWrapper( this.oclRegistryService, this.connection );
            }
            return this.oclFreestyleRegistry;
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclMetamodelConstraintRegistry getMetamodelConstraintRegistry( ) {

        if ( this.oclMetamodelConstraintRegistry == null ) {
            assertConnectionAlive( );
            synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
                this.synchronizationManager.acquireMicroWriteLock( );
                try {
                    this.oclMetamodelConstraintRegistry = new OclMetamodelConstraintRegistryWrapper( this.oclRegistryService, this.connection );
                } finally {
                    this.synchronizationManager.releaseMicroWriteLock( );
                }
            }
            if ( this.oclMetamodelConstraintRegistry == null ) {
                throw new MoinIllegalStateException( JmiCoreMessages.OCLMMCONSTRAINTREGISTRYINITERROR );
            }
        }
        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            return this.oclMetamodelConstraintRegistry;
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public void resetEvents( String category ) throws OclManagerException {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            this.oclRegistryService.resetEvents( this.connection, category );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclMofConstraintRegistry getMofConstraintRegistry( ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            if ( this.oclMofConstraintRegistry == null ) {
                // constructor needs to write
                this.synchronizationManager.acquireMicroWriteLock( );
                try {
                    attachConnectionIfRequired( );
                    this.oclMofConstraintRegistry = new OclMofConstraintRegistryWrapper( this.oclRegistryService, this.connection );
                } finally {
                    this.synchronizationManager.releaseMicroWriteLock( );
                }
            }
            return this.oclMofConstraintRegistry;
        }
    }

    public CoreOclRegistryService unwrap( ) {

        return this.oclRegistryService;
    }

    public DeferredConstraintViolationStatus verifyConstraints( RefObject object ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            return this.oclRegistryService.verifyConstraints( this.connection, ( (Wrapper<RefObject>) object ).unwrap( ) );
        }
    }

}