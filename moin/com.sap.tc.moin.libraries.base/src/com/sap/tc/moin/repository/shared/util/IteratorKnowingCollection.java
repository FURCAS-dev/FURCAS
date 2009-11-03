/*
 * Created on 14.09.2006
 */
package com.sap.tc.moin.repository.shared.util;

import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

public class IteratorKnowingCollection<E> implements Iterator<E> {

    Iterator<E> backingIterator = null;

    Collection<E> collectionOfIterator = null;

    public IteratorKnowingCollection( Iterator<E> iterator, Collection<E> collectionOfIterator ) {

        this.backingIterator = iterator;
        this.collectionOfIterator = collectionOfIterator;
    }

    public boolean hasNext( ) {

        return this.backingIterator.hasNext( );
    }

    public E next( ) {

        return this.backingIterator.next( );
    }

    public void remove( ) {

        this.backingIterator.remove( );
    }

    public Collection<E> getCollection( ) {

        return this.collectionOfIterator;
    }

    public Iterator<E> getBackingIterator( ) {

        return this.backingIterator;
    }

    /**
     * Returns an iterator over the collection of this iterator that is not able
     * to change the collection.
     */
    public ReadOnlyIterator getOtherIterator( ) {

        return new ReadOnlyIterator( this.collectionOfIterator );
    }

    /**
     * An iterator over a collection that does not support the change of the
     * collection, i.e. the remove method throws an
     * UnsupportedOperationException
     */
    private class ReadOnlyIterator implements Iterator<E> {

        Iterator<E> backingIterator = null;

        private ReadOnlyIterator( Collection<E> collection ) {

            this.backingIterator = collection.iterator( );
        }

        public boolean hasNext( ) {

            return this.backingIterator.hasNext( );
        }

        public E next( ) {

            return this.backingIterator.next( );
        }

        public void remove( ) {

            throw new MoinUnsupportedOperationException( "remove" ); //$NON-NLS-1$
        }
    }
}
