/**
 * 
 */
package com.sap.tc.moin.facility.primary.query.index.memory;

public class IndexArrayDuplicates<E extends IndexHashSetElement> {

    /**
     * 
     */
    private final IndexHashSetBase<E> indexHashSetBase;

    boolean newAdded = false;

    private int elemPosInTable;

    private int newArrayPos;

    private int currentSize;

    private E[] oldArray;

    private final E[] newArray;

    public IndexArrayDuplicates( IndexHashSetBase<E> indexHashSetBase ) {

        this.indexHashSetBase = indexHashSetBase;
        this.newArray = (E[]) new IndexHashSetElement[1000];
    }

    public void init( int posInTable, E[] a ) {

        this.currentSize = a.length;
        this.newArrayPos = 0;
        this.elemPosInTable = posInTable;
        this.oldArray = a;
    }

    public E get( int pos ) {

        return this.oldArray[pos];
    }

    public void add( E elem ) {

        this.newAdded = true;
        this.newArray[this.newArrayPos++] = elem;
        ++this.currentSize;
        if ( this.newArrayPos == this.newArray.length ) {
            this.store( );
        }
    }

    public void store( ) {

        IndexHashSetBase<E> base = this.indexHashSetBase;

        if ( this.newAdded ) {
            E[] newA = (E[]) new IndexHashSetElement[this.oldArray.length + this.newArrayPos];
            System.arraycopy( this.newArray, 0, newA, 0, this.newArrayPos );
            System.arraycopy( this.oldArray, 0, newA, this.newArrayPos, this.oldArray.length );
            this.elemPosInTable = base.addToTable( this.elemPosInTable, newA, true );
            this.oldArray = newA;
            this.newAdded = false;
            this.newArrayPos = 0;
        }
    }

    public int arraySize( ) {

        return this.oldArray.length;
    }

}