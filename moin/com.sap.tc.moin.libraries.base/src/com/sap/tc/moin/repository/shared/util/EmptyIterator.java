package com.sap.tc.moin.repository.shared.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator class for empty collections. {@link #hasNext()} always returns
 * <code>false</code>, {@link #next()} always throws a
 * {@link NoSuchElementException} and {@link #remove()} always throws an
 * {@link IllegalStateException}. The mentioned exceptions are created with the
 * specified "name" passed to the constructor.
 */
public class EmptyIterator implements Iterator<Object> {

    private String name = null;

    /**
     * @param name the name to be used in the Exceptions
     */
    public EmptyIterator( String name ) {

        this.name = name;
    }

    public boolean hasNext( ) {

        return false;
    }

    public Object next( ) {

        throw new NoSuchElementException( this.name );
    }

    public void remove( ) {

        throw new IllegalStateException( this.name );
    }

}