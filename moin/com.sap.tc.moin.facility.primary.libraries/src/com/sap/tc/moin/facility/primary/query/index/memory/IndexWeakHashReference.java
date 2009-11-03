package com.sap.tc.moin.facility.primary.query.index.memory;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * The weak reference used in {@link IndexHashSetDuplicates} to cache elements (
 * {@link IndexMofId}) for the {@link IndexMofIdFactory]}.
 * 
 * @author D048997
 * @param <T>
 */
public class IndexWeakHashReference<T> extends WeakReference<T> {

    /**
     * The absolute position in the table
     */
    public int hashPos;

    public IndexWeakHashReference( T element, ReferenceQueue<T> queue, int pos ) {

        super( element, queue );
        this.hashPos = pos;
    }

    @Override
    public String toString( ) {

        return "HashPos=" + this.hashPos + ", Referent=" + String.valueOf( this.get( ) ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    public int hashCode( ) {

        throw new MoinUnsupportedOperationException( IndexMessages.HASH_CODE_NOT_DESIGNED );
    }

    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( !( obj instanceof IndexWeakHashReference ) ) {
            return false;
        }
        IndexWeakHashReference<T> other = (IndexWeakHashReference<T>) obj;
        //        return (this.hashPos == other.hashPos && this.get().equals(other.get()));
        return ( this.hashPos == other.hashPos );
    }
}
