package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.sap.tc.moin.repository.mmi.reflect.InvalidObjectException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.tc.moin.repository.PRI;

@SuppressWarnings( "unchecked" )
public class JmiListWrapper<E> extends AbstractConnectionAwareWrapper<JmiList> implements Collection<E> {

    protected JmiList jmiList;

    public JmiListWrapper( CoreConnection connection, SynchronizationManager synchronizationManager, JmiList jmiList ) {

        super( connection, synchronizationManager );
        this.jmiList = jmiList;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof List || obj instanceof JmiListWrapper ) {
            Object arg;
            try {
                arg = unwrapArg( obj );
            } catch ( RuntimeException e ) {
                return false;
            }

            return getJmiList( false /* modification */).equals( connection, arg );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return getJmiList( false /* modification */).hashCode( connection );
    }

    @Override
    public String toString( ) {

        if ( getJmiList( false /* modification */) == null ) {
            return "null"; //$NON-NLS-1$
        }

        return getJmiList( false /* modification */).toString( );
    }

    public JmiList unwrap( ) {

        return getJmiList( false /* modification */);
    }

    public boolean add( Object o ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return getJmiList( true /* modification */).add( connection, unwrapArg( o ) );
        }
    }

    public boolean addAll( Collection c ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return getJmiList( true /* modification */).addAll( connection, unwrapArg( c ) );
        }
    }

    public void clear( ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            getJmiList( true /* modification */).clear( connection );
            return;
        }
    }

    public boolean contains( Object o ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return getJmiList( false /* modification */).contains( connection, unwrapArg( o ) );
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    public boolean containsAll( Collection c ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return getJmiList( false /* modification */).containsAll( connection, unwrapArg( c ) );
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    public boolean isEmpty( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return getJmiList( false /* modification */).isEmpty( connection.getSession( ) );
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    public Iterator iterator( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return new Itr( getJmiList( false /* modification */).iterator( connection ) );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public boolean remove( Object o ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return getJmiList( true /* modification */).remove( connection, unwrapArg( o ) );
        }
    }

    public boolean removeAll( Collection c ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return getJmiList( true /* modification */).removeAll( connection, unwrapArg( c ) );
        }
    }

    public boolean retainAll( Collection c ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return getJmiList( true /* modification */).retainAll( connection, unwrapArg( c ) );
        }
    }

    public int size( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return getJmiList( false /* modification */).size( connection.getSession( ) );
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    public Object[] toArray( ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            Object[] result = getJmiList( false /* modification */).toArray( connection );
            for ( int i = 0; i < result.length; i++ ) {
                result[i] = connection.getWrapperForJmiObject( (RefBaseObject) result[i] );
            }
            return result;
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    public <T> T[] toArray( T[] a ) {

        if ( a == null ) {
            throw new NullPointerException( );
        }
        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return toArrayInternal( a );
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    private <T> T[] toArrayInternal( T[] a ) {

        int origSize = getJmiList( false /* modification */).size( connection.getSession( ) );
        Object[] tmp = new Object[origSize];
        getJmiList( false /* modification */).toArray( connection, tmp );
        T[] result = a;
        if ( a.length < origSize ) {
            result = (T[]) java.lang.reflect.Array.newInstance( a.getClass( ).getComponentType( ), origSize );
        }
        for ( int i = 0; i < origSize; i++ ) {
            result[i] = (T) connection.getWrapperForJmiObject( (RefBaseObject) tmp[i] );
        }
        return result;
    }

    protected final <T> T wrapResult( T result ) {

        if ( result instanceof RefBaseObject ) {
            return (T) connection.getWrapperForJmiObject( (RefBaseObject) result );
        }
        return result;
    }

    protected class Itr implements Iterator {

        protected Iterator wrappedIterator;

        /**
         * The number of times that next() has been called up to now.
         */
        protected int nextCalls;

        protected Boolean lastNavigationWasNext;

        /**
         * The number of times that remove() has been called up to now.
         */
        private int removeCalls;

        public Itr( Iterator wrappedIterator ) {

            this.wrappedIterator = wrappedIterator;
            this.nextCalls = 0;
            this.removeCalls = 0;
        }

        public boolean hasNext( ) {

            synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return wrappedIterator.hasNext( );
            } finally {
                synchronizationManager.releaseReadLock( );
            }

        }

        public Object next( ) {

            synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                RefBaseObject result = connection.getWrapperForJmiObject( (RefBaseObject) wrappedIterator.next( ) );
                if ( lastNavigationWasNext != Boolean.FALSE ) {
                    nextCalls++;
                }
                lastNavigationWasNext = Boolean.TRUE;
                return result;
            } finally {
                synchronizationManager.releaseReadLock( );
            }

        }

        public void remove( ) {

            synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                JmiList jmiListBeforePotentialPrivateCopy = jmiList;
                JmiList jmiListAfterPotentialPrivateCopy = getJmiList( true /* modification */);
                if ( jmiListBeforePotentialPrivateCopy != jmiListAfterPotentialPrivateCopy ) {
                    if ( wrappedIterator instanceof ListIterator ) {
                        wrappedIterator = jmiListAfterPotentialPrivateCopy.listIterator( connection );
                    } else {
                        wrappedIterator = jmiListAfterPotentialPrivateCopy.iterator( connection );
                    }
                    fastForward( );
                }
                wrappedIterator.remove( );
                removeCalls++;
            }
        }

        protected final void fastForward( ) {

            for ( int i = 0; i < nextCalls - removeCalls; i++ ) {
                wrappedIterator.next( );
            }
        }
    }

    protected final JmiList getJmiList( boolean modification ) {

        if ( modification ) {
            copyOnWrite( );
        }
        if ( !jmiList.isValid( ) ) {
            CorePartitionable elementAtEnd = (CorePartitionable) connection.getElement( jmiList.getFromEnd( ) );
            if ( elementAtEnd != null ) {
                EndStorageLinkManager linkManager;
                if ( jmiList.isDistributed( ) ) {
                    linkManager = jmiList.getLinkManager( connection );
                } else {
                    linkManager = elementAtEnd.get___Workspace( ).getMemoryLinkManager( );
                }
                jmiList = linkManager.getElementsForEndAndMetaobject( connection, jmiList.getEndAndMetaObject( ), elementAtEnd );

            } else {
                throw new InvalidObjectException( null, JmiCoreMessages.COLLECTIONINVALID, jmiList.getFromEnd( ).toString( ), connection.toString( ) );
            }
        }
        return jmiList;
    }

    private void copyOnWrite( ) {

        if ( !jmiList.isDistributed( ) && jmiList.getWorkspace( ) == connection.getSession( ).getCompoundClientSpecWorkspace( ) ) {
            PRI pri = jmiList.getFromEnd( ).getPri( );
            connection.getSession( ).createPrivateCopyOfPartition( pri );
        }
    }

    public boolean isValid( ) {

        return jmiList.isValid( );
    }

    public void setJmiList( JmiList<CorePartitionable> jmiList ) {

        this.jmiList = jmiList;
    }
}
