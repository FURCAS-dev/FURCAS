/**
 * 
 */
package com.sap.tc.moin.repository.shared.util;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * A non-synchronized Stack, based on ArrayList instead of Vector. (Code based
 * on the java.util.Stack class)
 * 
 * @author d045996
 * @param <E>
 */
public class FastStack<E> extends ArrayList<E> {

    private static final long serialVersionUID = 2829201697921775571L;

    /**
     * Creates an empty Stack with initial capacity 10.
     */
    public FastStack( ) {

    }

    /**
     * Creates an empty Stack with the given initial capacity.
     */
    public FastStack( int initialCapacity ) {

        super( initialCapacity );
    }

    /**
     * Pushes an item onto the top of this stack.
     * 
     * @param item the item to be pushed onto this stack.
     * @return the <code>item</code> argument.
     */
    public E push( E item ) {

        add( item );
        return item;
    }

    /**
     * Removes the object at the top of this stack and returns that object as
     * the value of this function.
     * 
     * @return The object at the top of this stack (the last item of the
     * <tt>ArrayList</tt> object).
     * @exception EmptyStackException if this stack is empty.
     */
    public E pop( ) {

        int len = size( );
        if ( len == 0 ) {
            throw new EmptyStackException( );
        }
        return remove( len - 1 );
    }

    /**
     * Looks at the object at the top of this stack without removing it from the
     * stack.
     * 
     * @return the object at the top of this stack (the last item of the
     * <tt>ArrayList</tt> object).
     * @exception EmptyStackException if this stack is empty.
     */
    public E peek( ) {

        int len = size( );
        if ( len == 0 ) {
            throw new EmptyStackException( );
        }
        return get( len - 1 );
    }
}