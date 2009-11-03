package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

@SuppressWarnings( "unchecked" )
public class OrderedJmiListWrapper<E> extends JmiListWrapper<E> implements List<E> {

    public OrderedJmiListWrapper( CoreConnection connection, SynchronizationManager synchronizationManager, JmiList jmiList ) {

        super( connection, synchronizationManager, jmiList );
    }

    public void add( int index, Object element ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            getJmiList( true /* modification */).add( connection, index, unwrapArg( element ) );
            return;
        }
    }

    public boolean addAll( int index, Collection c ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return getJmiList( true /* modification */).addAll( connection, index, unwrapArg( c ) );
        }
    }

    public E get( int index ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return (E) connection.getWrapperForJmiObject( (RefBaseObject) getJmiList( false /* modification */).get( connection.getSession( ), index ) );
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    public int indexOf( Object o ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return getJmiList( false /* modification */).indexOf( connection, unwrapArg( o ) );
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    public int lastIndexOf( Object o ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return getJmiList( false /* modification */).lastIndexOf( connection, unwrapArg( o ) );
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    public ListIterator listIterator( ) {

        return listIterator( 0 );
    }

    public ListIterator listIterator( int index ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return new Itr( getJmiList( false /* modification */).listIterator( connection, index ) );
        } finally {
            synchronizationManager.releaseReadLock( );
        }
    }

    public E remove( int index ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return (E) connection.getWrapperForJmiObject( (RefBaseObject) getJmiList( true /* modification */).remove( connection, index ) );
        }
    }

    public Object set( int index, Object element ) {

        synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return connection.getWrapperForJmiObject( (RefBaseObject) getJmiList( true /* modification */).set( connection, index, unwrapArg( element ) ) );
        }
    }

    public List subList( int fromIndex, int toIndex ) {

        synchronizationManager.acquireReadLock( );
        try {
            assertConnectionAlive( );
            attachConnectionIfRequired( );
            return (List) connection.getWrapperForJmiList( getJmiList( false /* modification */).subList( connection, fromIndex, toIndex ) );
        } finally {
            synchronizationManager.releaseReadLock( );
        }

    }

    private class Itr extends JmiListWrapper.Itr implements ListIterator {

        public Itr( ListIterator wrappedIterator ) {

            super( wrappedIterator );
        }

        public void add( Object o ) {

            synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                JmiList jmiListBeforePotentialPrivateCopy = jmiList;
                JmiList jmiListAfterPotentialPrivateCopy = getJmiList( true /* modification */);
                if ( jmiListBeforePotentialPrivateCopy != jmiListAfterPotentialPrivateCopy ) {
                    wrappedIterator = jmiListAfterPotentialPrivateCopy.listIterator( connection );
                    fastForward( );
                }
                ( (ListIterator) wrappedIterator ).add( unwrapArg( o ) );
            }
        }

        public boolean hasPrevious( ) {

            synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return ( (ListIterator) wrappedIterator ).hasPrevious( );
            } finally {
                synchronizationManager.releaseReadLock( );
            }

        }

        public int nextIndex( ) {

            synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return ( (ListIterator) wrappedIterator ).nextIndex( );
            } finally {
                synchronizationManager.releaseReadLock( );
            }

        }

        public Object previous( ) {

            synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                RefBaseObject result = connection.getWrapperForJmiObject( (RefBaseObject) ( (ListIterator) wrappedIterator ).previous( ) );
                if ( lastNavigationWasNext != Boolean.TRUE ) {
                    nextCalls--;
                }
                lastNavigationWasNext = Boolean.FALSE;
                return result;
            } finally {
                synchronizationManager.releaseReadLock( );
            }

        }

        public int previousIndex( ) {

            synchronizationManager.acquireReadLock( );
            try {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                return ( (ListIterator) wrappedIterator ).previousIndex( );
            } finally {
                synchronizationManager.releaseReadLock( );
            }

        }

        public void set( Object o ) {

            synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                assertConnectionAlive( );
                attachConnectionIfRequired( );
                JmiList jmiListBeforePotentialPrivateCopy = jmiList;
                JmiList jmiListAfterPotentialPrivateCopy = getJmiList( true /* modification */);
                if ( jmiListBeforePotentialPrivateCopy != jmiListAfterPotentialPrivateCopy ) {
                    wrappedIterator = jmiListAfterPotentialPrivateCopy.listIterator( connection );
                    fastForward( );
                }
                ( (ListIterator) wrappedIterator ).set( unwrapArg( o ) );
            }
        }
    }
}