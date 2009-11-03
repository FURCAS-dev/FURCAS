package com.sap.tc.moin.repository.core;

import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.ocl.freestyle.OclRegistrationType;
import com.sap.tc.moin.repository.ocl.metamodel.OclMetaModelConstraintRegistration;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

/**
 * The {@link OclMetaModelConstraintRegistration} wrapper
 */
public class OclMetaModelConstraintRegistrationWrapper extends AbstractConnectionAwareWrapper<OclMetaModelConstraintRegistrationWrapper> implements OclMetaModelConstraintRegistration {

    private final OclMetaModelConstraintRegistration oclMetaModelConstraintRegistration;

    /**
     * @param actRegistration the {@link OclMetaModelConstraintRegistration}
     * @param actConnection the connection
     */
    public OclMetaModelConstraintRegistrationWrapper( OclMetaModelConstraintRegistration actRegistration, CoreConnection actConnection ) {

        super( actConnection, actConnection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.oclMetaModelConstraintRegistration = actRegistration;
    }

    public Set<String> getCategories( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMetaModelConstraintRegistration.getCategories( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public String getName( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMetaModelConstraintRegistration.getName( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public String getOclExpression( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMetaModelConstraintRegistration.getOclExpression( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclRegistrationSeverity getSeverity( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMetaModelConstraintRegistration.getSeverity( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclRegistrationType getType( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMetaModelConstraintRegistration.getType( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public Set<String> getConstrainedElements( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMetaModelConstraintRegistration.getConstrainedElements( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public List<String> getQualifiedName( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclMetaModelConstraintRegistration.getQualifiedName( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclMetaModelConstraintRegistrationWrapper unwrap( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return null;
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

}