package com.sap.tc.moin.repository.shared.util;

public final class IndexedElement<T> implements Comparable<IndexedElement<T>> {

    public int index = 0;

    public T element = null;

    public IndexedElement( int anIndex, T anElement ) {

        index = anIndex;
        element = anElement;
    }

    public int compareTo( IndexedElement<T> object ) {

        return ( (Integer) index ).compareTo( object.index );
    }

    @Override
    public boolean equals( Object object ) {

        if ( object == this ) {
            return true;
        }
        if ( !( object instanceof IndexedElement ) ) {
            return false;
        }
        IndexedElement<?> ie = (IndexedElement<?>) object;
        return ie.index == index && ie.element.equals( element );
    }

    @Override
    public int hashCode( ) {

        return index ^ element.hashCode( );
    }
}
