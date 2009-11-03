package com.sap.tc.moin.facility.primary.query.index.memory;

import com.sap.tc.moin.repository.exception.MoinIndexOutOfBoundsException;

/**
 * The wrapper for a two-dimensional list from {@link IndexHashSetFastLists} and
 * encapsulates the necessary bit shifting. It allows reading, removing and
 * replacing elements in the list. After altering the list the {@link #store()}
 * method needs to be called to save the changes in the
 * {@link IndexHashSetFastLists} table.<br>
 * It is intended to be used if multiple read or remove operations are to be
 * performed on the same list.
 * 
 * @author D048997
 * @param <T>
 */
public class IndexArrayFastList<T extends IndexHashSetElement> {

    /**
     * The parent table that contains the wrapped list
     */
    private final IndexHashSetFastLists<T> indexHashSetFastLists;

    boolean isChanged = false;

    /**
     * The absolute position in the table array of the parent
     * IndexHashSetFastLists
     */
    private int elemPosInTable;

    /**
     * The number of elements in the list.
     */
    private int currentSize;

    /**
     * The two-dimensional list
     */
    private T[][] arrayList;

    public IndexArrayFastList( IndexHashSetFastLists<T> indexHashSetListsRandomAddAndDelete ) {

        this.indexHashSetFastLists = indexHashSetListsRandomAddAndDelete;
    }

    public void init( int posInTable, T[][] a, int sizeOfA ) {

        this.currentSize = sizeOfA;
        this.elemPosInTable = posInTable;
        this.arrayList = a;
    }

    /**
     * Returns the element at the given position in the list
     * 
     * @param pos
     * @return
     */
    public T get( int pos ) {

        return this.arrayList[pos >> IndexHashSetFastLists.X_SHIFT][pos & IndexHashSetFastLists.X_MASK];
    }

    /**
     * Removes the element at the given position from the list and sets the last
     * element in the list at this position. Therefore you have to check the
     * position again if you iterate over the size of the list to read and
     * following remove an element. Otherwise you skip at least one element.
     * 
     * @param pos
     */
    public void remove( int pos ) {

        int size = this.currentSize;
        if ( pos >= size ) {
            throw new MoinIndexOutOfBoundsException( pos, size );
        }
        this.isChanged = true;
        if ( pos < --size ) {
            this.arrayList[pos >> IndexHashSetFastLists.X_SHIFT][pos & IndexHashSetFastLists.X_MASK] = this.arrayList[( size ) >> IndexHashSetFastLists.X_SHIFT][( size ) & IndexHashSetFastLists.X_MASK];
            this.arrayList[( size ) >> IndexHashSetFastLists.X_SHIFT][( size ) & IndexHashSetFastLists.X_MASK] = null;
        } else {
            this.arrayList[pos >> IndexHashSetFastLists.X_SHIFT][pos & IndexHashSetFastLists.X_MASK] = null;
        }
        --this.currentSize;
    }

    /**
     * Adjusts the size of the list to the number of elements and stores it in
     * the parent IndexHashSetFastLists.
     */
    public void store( ) {

        if ( this.isChanged ) {
            IndexHashSetFastLists<T> base = this.indexHashSetFastLists;
            T[][] locArray = this.arrayList;
            int size = this.currentSize;
            if ( size != 0 ) {
                // remove unnecessary all x-dimension buckets
                for ( int i = locArray.length - 1; i > ( ( size - 1 ) >> IndexHashSetFastLists.X_SHIFT ); --i ) {
                    locArray[i] = null;
                }
                // adjust the last x-dimension bucket (if necessary)
                if ( ( size & IndexHashSetFastLists.X_MASK ) != 0 ) {
                    T[] newA = (T[]) new IndexHashSetElement[size & IndexHashSetFastLists.X_MASK];
                    System.arraycopy( locArray[size >> IndexHashSetFastLists.X_SHIFT], 0, newA, 0, size & IndexHashSetFastLists.X_MASK );
                    this.arrayList[size >> IndexHashSetFastLists.X_SHIFT] = newA;
                }
                // important!! Reset the size information in the sizes table, since length of list == number of elements
                base.sizes[this.elemPosInTable] = 0;
            } else {
                // remove the list from parent if it is empty.
                base.removeFromTable( this.elemPosInTable );
            }
            this.isChanged = false;
        }
    }

    /**
     * @return The number of elements in the list.
     */
    public int size( ) {

        return this.currentSize;
    }
}