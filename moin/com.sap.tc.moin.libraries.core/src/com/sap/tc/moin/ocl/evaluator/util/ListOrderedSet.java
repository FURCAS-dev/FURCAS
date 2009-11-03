package com.sap.tc.moin.ocl.evaluator.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

/**
 * {@link OrderedSet} implementation that uses an ArrayList internally to track
 * the order that elements are added. This implementation does not allow
 * <code>null</code> elements to be added.
 */
public class ListOrderedSet extends HashSet<OclAny> implements OrderedSet {

    // $JL-CLONE$
    private static final long serialVersionUID = 1L;

    /**
     * List that contains the same elements as this HashSet, in the order that
     * they were added Non-private due to read-access in inner class
     */
    final List<OclAny> elementList = new ArrayList<OclAny>( );

    /**
     * Default constructor - creates an empty OrderedSet.
     */
    public ListOrderedSet( ) {

        // No additional initialisation required
    }

    /**
     * Create a new OrderedSet that contains the elements from the supplied
     * <code>collection</code> in the order that they are returned from the
     * collection's iterator.
     * 
     * @param collection the collection to be wrapped
     */
    public ListOrderedSet( Collection<OclAny> collection ) {

        addAll( collection );
    }

    /**
     * Add <code>element</code> to the end of this OrderedSet. If the element
     * already exists, the OrderedSet does not change, and this method returns
     * <code>false</code>.
     * 
     * @return <code>true</code> if the collection changes.
     * @throws NullPointerException Thrown if <code>element</code> is
     * <code>null</code>.
     */
    @Override
    public boolean add( OclAny element ) {

        return add( size( ), element );
    }

    /* Specified by interface */
    public boolean add( int index, OclAny element ) {

        if ( element == null ) {
            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.NONULLINLISTORDEREDSET );
        }
        if ( index < 0 || index > size( ) ) {
            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.LISTORDEREDSETINDEXOUTOFBOUNDS, Integer.valueOf( index ), Integer.valueOf( size( ) ) );
        }
        boolean added = super.add( element );
        if ( added ) {
            this.elementList.add( index, element );
        }
        return added;
    }

    /**
     * Removes all elements from this OrderedSet.
     */
    @Override
    public void clear( ) {

        super.clear( );
        this.elementList.clear( );
    }

    /**
     * Removes the supplied <code>element</code> from this OrderedSet, or
     * returns <code>false</code> if the element doesn't exist in the set.
     * 
     * @return <code>true</code> if the collection changes.
     */
    @Override
    public boolean remove( Object element ) {

        boolean removed = super.remove( element );
        if ( removed ) {
            this.elementList.remove( element );
        }
        return removed;
    }

    /* Specified by interface */
    public OclAny get( int index ) {

        return this.elementList.get( index );
    }

    /* Specified by interface */
    public int indexOf( Object element ) {

        return this.elementList.indexOf( element );
    }

    /* Specified by interface */
    public OrderedSet subOrderedSet( int fromIndex, int toIndex ) {

        return new ListOrderedSet( this.elementList.subList( fromIndex, toIndex ) );
    }

    /* Specified by interface */
    @Override
    public Iterator<OclAny> iterator( ) {

        return new ListOrderedSetIterator( );
    }

    /**
     * This iterator wraps the elementList iterator so that we can remove
     * elements from both the list and set as well when the {@link #remove()}
     * method is called.
     */
    private class ListOrderedSetIterator implements Iterator<OclAny> {

        /** The underlying List iterator */
        private final Iterator<OclAny> it;

        /** The most recent element returned by {@link #next()} */
        private OclAny currentElement;

        /**
         * Create a new Iterator that wraps the elementList iterator
         */
        public ListOrderedSetIterator( ) {

            this.it = ListOrderedSet.this.elementList.iterator( );
        }

        /* Specified by interface */
        public boolean hasNext( ) {

            return this.it.hasNext( );
        }

        /* Specified by interface */
        public OclAny next( ) {

            this.currentElement = this.it.next( );
            return this.currentElement;
        }

        /* Specified by interface */
        public void remove( ) {

            this.it.remove( );
            ListOrderedSet.this.remove( this.currentElement );
        }
    }
}
