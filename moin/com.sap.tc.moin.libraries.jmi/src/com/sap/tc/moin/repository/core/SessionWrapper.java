package com.sap.tc.moin.repository.core;

import java.util.Collection;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.InvalidSessionException;
import com.sap.tc.moin.repository.LockManager;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.events.EventRegistry;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * The SessionWrapper
 */
public final class SessionWrapper implements Session, Wrapper<CoreSession> {

    private final CoreSession session;

    private final Moin moin;

    private final LockManager lockManager;

    private EventRegistry eventRegistry;

    public SessionWrapper( WorkspaceSet workspaceSet, CoreSession session ) {

        this.session = session;
        this.moin = this.session.getMoin( ).getWrapper( );
        this.lockManager = ( (CoreLockManager) this.session.getLockManager( ) ).getWrapper( );
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof SessionWrapper ) {
            return this.session.equals( ( (SessionWrapper) obj ).session );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return this.session.hashCode( );
    }

    @Override
    public String toString( ) {

        return this.session.toString( );
    }

    public boolean isAlive( ) {

        // Don't use assertAlive() here, because isAlive() must not throw an exception.
        return this.session.isAlive( );
    }

    public CompoundClientSpec getCompoundClientSpec( ) {

        assertAlive( );
        return this.session.getCompoundClientSpec( );
    }

    public EventRegistry getEventRegistry( ) {

        assertAlive( );
        if ( eventRegistry == null ) {
            eventRegistry = new EventRegistryWrapperForSession( session );
        }
        return eventRegistry;
    }

    public LockManager getLockManager( ) {

        assertAlive( );
        return this.lockManager;
    }

    public Connection createConnection( String label ) {

        assertAlive( );
        return ( (CoreConnection) this.session.createConnection( label ) ).getWrapper( );
    }

    public Connection createConnection( ) {

        assertAlive( );
        return ( (CoreConnection) this.session.createConnection( ) ).getWrapper( );
    }

    public Moin getMoin( ) {

        assertAlive( );
        return this.moin;
    }

    public Collection<PRI> getInnerPartitions( CRI cri ) {

        session.getWorkspaceSet( ).getSynchronizationManager( ).acquireReadLock( );
        try {
            return session.getInnerPartitions( cri );
        } finally {
            session.getWorkspaceSet( ).getSynchronizationManager( ).releaseReadLock( );
        }
    }

    public Collection<PRI> getOuterPartitions( CRI cri ) {

        session.getWorkspaceSet( ).getSynchronizationManager( ).acquireReadLock( );
        try {
            return session.getOuterPartitions( cri );
        } finally {
            session.getWorkspaceSet( ).getSynchronizationManager( ).releaseReadLock( );
        }
    }

    public Collection<CRI> getReferencedContainers( CRI cri ) {

        session.getWorkspaceSet( ).getSynchronizationManager( ).acquireReadLock( );
        try {
            return session.getReferencedContainers( cri );
        } finally {
            session.getWorkspaceSet( ).getSynchronizationManager( ).releaseReadLock( );
        }
    }

    public boolean hasCrossPartitionLinks( PRI priOne, PRI... otherPris ) {

        assertAlive( );
        return this.session.hasCrossPartitionLinks( priOne, otherPris );
    }


    public CoreSession unwrap( ) {

        return this.session;
    }

    public boolean isContainerModifiable( CRI cri ) {

        session.getWorkspaceSet( ).getSynchronizationManager( ).acquireReadLock( );
        try {
            return session.isContainerModifiable( cri );
        } finally {
            session.getWorkspaceSet( ).getSynchronizationManager( ).releaseReadLock( );
        }
    }

    private void assertAlive( ) {

        if ( !this.session.isAlive( ) ) {
            throw new InvalidSessionException( JmiCoreMessages.SESSIONISINVALID );
        }
    }
}