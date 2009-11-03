/**
 * 
 */
package com.sap.tc.moin.facility.primary.query.index.memory;

public class IndexArrayList<E extends IndexHashSetElement> {

    /**
     * 
     */
    private final IndexHashSetBase<E> indexHashSetBase;

    boolean oldDeleted = false;

    boolean newAdded = false;

    private int elemPosInTable;

    private int newArrayPos;

    private int currentSize;

    private E[] oldArray;

    private final E[] newArray;

    public IndexArrayList( IndexHashSetBase<E> indexHashSetBase ) {

        this.indexHashSetBase = indexHashSetBase;
        this.newArray = (E[]) new IndexHashSetElement[1000];
    }

    public void init( int posInTable, E[] a ) {

        this.currentSize = a.length;
        this.newArrayPos = 0;
        this.elemPosInTable = posInTable;
        this.oldArray = a;
    }

    public boolean remove( E elem ) {

        E[] oldArray = this.oldArray;
        for ( int i = 0; i < oldArray.length; i++ ) {
            if ( elem == oldArray[i] ) {
                oldArray[i] = null;
                --this.currentSize;
                this.oldDeleted = true;
                return true;
            }
        }
        return false;
    }

    public void add( E elem ) {

        this.newAdded = true;
        this.newArray[newArrayPos++] = elem;
        ++this.currentSize;
        if ( newArrayPos == newArray.length ) {
            this.store( );
        }
    }

    public void store( ) {

        IndexHashSetBase<E> base = this.indexHashSetBase;

        if ( this.oldDeleted ) {
            if ( this.currentSize == 0 ) {
                base.removeFromTable( elemPosInTable );
                if ( this.oldDeleted ) {
                    this.oldDeleted = false;
                }
                return;
            }

            E[] oldArray = this.oldArray;
            int last = oldArray.length;
            if ( last != 0 ) {
                while ( oldArray[--last] == null ) {
                    if ( last == 0 ) {
                        base.removeFromTable( elemPosInTable );
                        this.oldDeleted = false;
                        return;
                    }
                }
                for ( int i = 0; i < oldArray.length; i++ ) {
                    if ( i >= last ) {
                        break;
                    }
                    if ( oldArray[i] == null ) {
                        oldArray[i] = oldArray[last];
                        oldArray[last--] = null;
                        while ( last > 0 && oldArray[last] == null ) {
                            --last;
                        }
                    }
                }
                E[] newA = (E[]) new IndexHashSetElement[++last];
                System.arraycopy( oldArray, 0, newA, 0, last );
                base.table[elemPosInTable] = newA;
                this.oldArray = newA;
            } else {
                base.removeFromTable( elemPosInTable );
            }
            this.oldDeleted = false;
        }

        if ( this.newAdded ) {
            E[] newA = (E[]) new IndexHashSetElement[this.oldArray.length + this.newArrayPos];
            System.arraycopy( this.newArray, 0, newA, 0, this.newArrayPos );
            System.arraycopy( this.oldArray, 0, newA, this.newArrayPos, this.oldArray.length );
            this.elemPosInTable = base.addToTable( elemPosInTable, newA, true );
            this.oldArray = newA;
            this.newAdded = false;
            this.newArrayPos = 0;
        }
    }

    public int arraySize( ) {

        return this.oldArray.length;
    }

    public int size( ) {

        return this.currentSize;
    }
}