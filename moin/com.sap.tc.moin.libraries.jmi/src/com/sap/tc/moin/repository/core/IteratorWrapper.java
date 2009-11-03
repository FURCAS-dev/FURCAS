package com.sap.tc.moin.repository.core;

import java.util.Iterator;

public class IteratorWrapper extends AbstractConnectionAwareWrapper implements Iterator {

    protected Iterator iterator;

    public IteratorWrapper( CoreConnection connection, Iterator iterator ) {

        super( connection, connection.getSession( ).getWorkspaceSet( ).getSynchronizationManager( ) );
        this.iterator = iterator;
    }

    public boolean hasNext( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return iterator.hasNext( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public Object next( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return iterator.next( );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public void remove( ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            iterator.remove( );
        }
    }

    public Iterator unwrap( ) {

        return iterator;
    }

}