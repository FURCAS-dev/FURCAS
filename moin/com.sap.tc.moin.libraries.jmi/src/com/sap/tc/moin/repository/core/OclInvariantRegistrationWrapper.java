package com.sap.tc.moin.repository.core;

import java.util.Set;

import com.sap.tc.moin.repository.ocl.freestyle.OclInvariantRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclRegistrationType;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

/**
 * the {@link OclInvariantRegistration} wrapper
 */
public class OclInvariantRegistrationWrapper extends AbstractConnectionAwareWrapper<OclInvariantRegistration> implements OclInvariantRegistration {

    private final OclInvariantRegistration oclInvariantRegistration;

    /**
     * @param actRegistration the {@link OclInvariantRegistration}
     * @param actConnection the connection
     */
    public OclInvariantRegistrationWrapper( OclInvariantRegistration actRegistration, CoreConnection actConnection ) {

        super( actConnection, actConnection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.oclInvariantRegistration = actRegistration;
    }

    public Set<String> getCategories( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclInvariantRegistration.getCategories( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public String getName( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclInvariantRegistration.getName( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public String getOclExpression( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclInvariantRegistration.getOclExpression( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclRegistrationSeverity getSeverity( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclInvariantRegistration.getSeverity( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclRegistrationType getType( ) {

        this.synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return this.oclInvariantRegistration.getType( );
        } finally {
            this.synchronizationManager.releaseReadLock( );
        }
    }

    public OclInvariantRegistration unwrap( ) {

        return this.oclInvariantRegistration;
    }

}