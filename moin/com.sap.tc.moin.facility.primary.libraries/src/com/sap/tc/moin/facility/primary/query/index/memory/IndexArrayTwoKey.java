package com.sap.tc.moin.facility.primary.query.index.memory;

/**
 * The wrapper for a list of elements in {@link IndexHashSetTwoKey} that have
 * the same keys K1 and K2.
 * <p>
 * Caution: All operations here are not synchronized with the operations in
 * {@link IndexHashSetTwoKey}. Do either use the wrapper or the table's
 * operations. Call always {@link #store()} to submit changes.
 * 
 * @author D048997
 * @param <T>
 */
public class IndexArrayTwoKey<T extends IndexHashSetElement> {

    private final IndexHashSetTwoKey<T> indexHashSetTwoKey;

    private boolean isChanged = false;

    /**
     * The position of the 2-dimensional array in the table of
     * {@link IndexHashSetTwoKey}
     */
    private int elemPosInTable1;

    /**
     * The position in the x-dimension of the 2D array where the wrapped list is
     * located.
     */
    private int elemPosInTable2;

    private int currentSize;

    private T[] arrayList;

    public IndexArrayTwoKey( IndexHashSetTwoKey<T> indexHashSetTwoKey ) {

        this.indexHashSetTwoKey = indexHashSetTwoKey;
    }

    public void init( int posInTable1, int posInTable2, T[] a ) {

        this.currentSize = a.length;
        this.elemPosInTable1 = posInTable1;
        this.elemPosInTable2 = posInTable2;
        this.arrayList = a;
    }

    public T get( int pos ) {

        return this.arrayList[pos];
    }

    /**
     * Removes the element at the given position and moves the last element in
     * the list to this position to avoid empty spaces.
     * 
     * @param pos
     */
    public void remove( int pos ) {

        this.isChanged = true;
        int size = this.currentSize;
        if ( pos < --size ) {
            this.arrayList[pos] = this.arrayList[size];
            this.arrayList[size] = null;
        } else {
            this.arrayList[pos] = null;
        }
        --this.currentSize;
    }

    public void store( ) {

        if ( this.isChanged ) {
            IndexHashSetTwoKey<T> base = this.indexHashSetTwoKey;
            T[] locArray = this.arrayList;
            int last = this.currentSize;
            if ( last != 0 ) {
                T[] newA = (T[]) new IndexHashSetElement[last];
                System.arraycopy( locArray, 0, newA, 0, last );
                ( (Object[][]) base.table[this.elemPosInTable1] )[this.elemPosInTable2] = newA;
            } else {
                T[][] tab = (T[][]) base.table[this.elemPosInTable1];
                if ( tab.length == 1 ) {
                    base.removeFromTable( this.elemPosInTable1 );
                } else {
                    tab[this.elemPosInTable2] = tab[tab.length - 1];
                    T[][] newTab = (T[][]) new IndexHashSetElement[tab.length - 1][];
                    System.arraycopy( tab, 0, newTab, 0, tab.length - 1 );
                    base.table[this.elemPosInTable1] = newTab;
                }
            }
            this.isChanged = false;
        }
    }

    public int size( ) {

        return this.currentSize;
    }
}