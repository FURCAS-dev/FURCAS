package com.sap.tc.moin.repository.core;

import java.util.Set;

import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclFreestyleRegistry;
import com.sap.tc.moin.repository.ocl.freestyle.OclInvariantRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.ImmediateConstraintViolationListener;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * The {@link OclFreestyleRegistry} wrapper
 */
public class OclFreestyleRegistryWrapper extends AbstractConnectionAwareWrapper<OclFreestyleRegistry> implements OclFreestyleRegistry {

    private final OclFreestyleRegistry oclFreestyleRegistry;

    /**
     * @param oclRegistryService the {@link CoreOclRegistryService}
     * @param actConnection the connection
     */
    public OclFreestyleRegistryWrapper( CoreOclRegistryService oclRegistryService, CoreConnection actConnection ) {

        super( actConnection, actConnection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.oclFreestyleRegistry = oclRegistryService.getFreestyleRegistry( actConnection );
    }

    public OclExpressionRegistration createExpressionRegistration( String name, String oclExpression, OclRegistrationSeverity severity, String[] categories, RefClass parsingContext, RefPackage[] typesPackages ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            RefClass unwrappedContext = ( (Wrapper<RefClass>) parsingContext ).unwrap( );
            RefPackage[] unwrappedPackages = new RefPackage[typesPackages.length];
            for ( int i = 0; i < typesPackages.length; i++ ) {
                unwrappedPackages[i] = ( (Wrapper<RefPackage>) typesPackages[i] ).unwrap( );
            }
            return new OclExpressionRegistrationWrapper( this.oclFreestyleRegistry.createExpressionRegistration( name, oclExpression, severity, categories, unwrappedContext, unwrappedPackages ), this.connection );
        }
    }
    
    public OclExpressionRegistration createExpressionRegistration( String name, String oclExpression, OclRegistrationSeverity severity, String[] categories, RefObject parsingContextMetaClass, RefPackage[] typesPackages ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            RefObject unwrappedContext = ( (Wrapper<RefObject>) parsingContextMetaClass ).unwrap( );
            RefPackage[] unwrappedPackages = new RefPackage[typesPackages.length];
            for ( int i = 0; i < typesPackages.length; i++ ) {
                unwrappedPackages[i] = ( (Wrapper<RefPackage>) typesPackages[i] ).unwrap( );
            }
            return new OclExpressionRegistrationWrapper( this.oclFreestyleRegistry.createExpressionRegistration( name, oclExpression, severity, categories, unwrappedContext, unwrappedPackages ), this.connection );
        }
    }
    
    public OclExpressionRegistration createExpressionRegistration( String name, String oclExpression, OclRegistrationSeverity severity, String[] categories, RefObject contextMetaClass, MofPackage[] typesPackages) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            RefObject unwrappedContext = ( (Wrapper<RefObject>) contextMetaClass ).unwrap( );
            MofPackage[] unwrappedPackages = new MofPackage[typesPackages.length];
            for ( int i = 0; i < typesPackages.length; i++ ) {
                unwrappedPackages[i] = ( (Wrapper<MofPackage>) typesPackages[i] ).unwrap( );
            }
            return new OclExpressionRegistrationWrapper( this.oclFreestyleRegistry.createExpressionRegistration( name, oclExpression, severity, categories, unwrappedContext, unwrappedPackages), this.connection );
        }
    }

    public OclInvariantRegistration createInvariantRegistration( String name, String oclExpression, OclRegistrationSeverity severity, String[] categories, RefClass parsingContext, RefPackage[] typesPackages ) throws OclManagerException {

        synchronized ( this.synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            RefClass unwrappedContext = ( (Wrapper<RefClass>) parsingContext ).unwrap( );
            RefPackage[] unwrappedPackages = new RefPackage[typesPackages.length];
            for ( int i = 0; i < typesPackages.length; i++ ) {
                unwrappedPackages[i] = ( (Wrapper<RefPackage>) typesPackages[i] ).unwrap( );
            }
            return new OclInvariantRegistrationWrapper( this.oclFreestyleRegistry.createInvariantRegistration( name, oclExpression, severity, categories, unwrappedContext, unwrappedPackages ), this.connection );
        }
    }

    public boolean deleteRegistration( String name ) throws OclManagerException {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclFreestyleRegistry.deleteRegistration( name );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclRegistration getRegistration( String name ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            OclRegistration registration = this.oclFreestyleRegistry.getRegistration( name );
            if ( registration == null ) {
                return null;
            }
            if ( registration instanceof OclInvariantRegistration ) {
                return new OclInvariantRegistrationWrapper( (OclInvariantRegistration) registration, this.connection );
            } else if ( registration instanceof OclExpressionRegistration ) {
                return new OclExpressionRegistrationWrapper( (OclExpressionRegistration) registration, this.connection );
            } else if ( registration instanceof OclMetaModelConstraintRegistration ) {
                return new OclMetaModelConstraintRegistrationWrapper( (OclMetaModelConstraintRegistration) registration, this.connection );
            } else {
                throw new MoinIllegalStateException( JmiCoreMessages.UNEXPECTEDOCLREGISTRYTIONTYPE );
            }
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public Set<String> getRegistrationNames( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclFreestyleRegistry.getRegistrationNames( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }

    }

    public boolean registerDeferredConstraintViolationListenerForEvents( String category, DeferredConstraintViolationListener listener ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclFreestyleRegistry.registerDeferredConstraintViolationListenerForEvents( category, listener );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public boolean registerDeferredConstraintViolationListenerForPartitions( String category, DeferredConstraintViolationListener listener ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclFreestyleRegistry.registerDeferredConstraintViolationListenerForPartitions( category, listener );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public boolean registerImmediateConstraintViolationListener( String category, ImmediateConstraintViolationListener listener ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclFreestyleRegistry.registerImmediateConstraintViolationListener( category, listener );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public boolean unregisterDeferredConstraintViolationListener( DeferredConstraintViolationListener listener ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclFreestyleRegistry.unregisterDeferredConstraintViolationListener( listener );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public boolean unregisterImmediateConstraintViolationListener( ImmediateConstraintViolationListener listener ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclFreestyleRegistry.unregisterImmediateConstraintViolationListener( listener );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclFreestyleRegistry unwrap( ) {

        return this.oclFreestyleRegistry;
    }
}