package com.sap.tc.moin.facility.primary.query.index.memory;

import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * This table enables a two-staged hierarchical lookup for data objects.
 * Therefore the objects expose two keys K1 and K2. The first key in the lookup
 * is always K1 and K2 is only looked up in the result set from the lookup with
 * K2. Due to the KPIs of the IDE slim index (count(K1) >> count(K2|K1)), this
 * table only hashes K1 and sequentially looks up K2 in a list to reduce memory
 * consumption.
 * <p>
 * Keys are compared by identity. The data structure can contain multiple
 * instances of data objects exposing the same keys K1 and K2. Uniqueness of
 * added data objects is not guaranteed.
 * <p>
 * As in all tables, keys are not stored separately but exposed by an element.
 * All elements with the same key K1 are grouped into a 2-dimensional array
 * "array[x][y]" (with x- and y-dimension). K1 is exposed by the element at
 * position array[0][0]. All elements with the same K2 are arranged in one
 * x-dimension list. K2 is exposed by the first element of each list in the
 * x-dimension (i.e. array[x][0]). To reduce memory consumption the length of
 * each x-dimension list is exactly the number of contained elements and the
 * x-dimension is exactly the number of different K2 keys.
 * <p>
 * TODO Improvements: Reduce code duplication by using
 * {@link #getUnderlyingForRead(Object)} to retrieve array field.
 * 
 * @author D048997
 * @param <E>
 */
public class IndexHashSetTwoKey<E extends IndexHashSetElement> extends IndexHashSetBase<E> {

    /**
     * The key number of the second key exposed by the instances of type E
     */
    private final int keyNr2;

    /**
     * A wrapper for adding and removing elements to the array structure in bulk
     * operations.
     */
    private IndexArrayTwoKey<E> indexArray;

    public IndexHashSetTwoKey( int keyNr, int keyNr2 ) {

        this( keyNr, keyNr2, DEFAULT_INITIAL_CAPACITY );
    }

    public IndexHashSetTwoKey( int keyNr, int keyNr2, Object[] table, int size ) {

        super( keyNr, table, size );
        this.keyNr2 = keyNr2;
        this.indexArray = new IndexArrayTwoKey<E>( this );
    }

    public IndexHashSetTwoKey( int keyNr, int keyNr2, int capacity ) {

        super( keyNr );
        int cap = this.capacity( capacity );
        this.growLoadFactor = DEFAULT_GROW_LOAD_FACTOR;
        this.shrinkLoadFactor = DEFAULT_SHRINK_LOAD_FACTOR;
        this.growThreshold = (int) ( cap * DEFAULT_GROW_LOAD_FACTOR );
        this.shrinkThreshold = (int) ( cap * DEFAULT_SHRINK_LOAD_FACTOR );
        this.table = new Object[cap];
        this.keyNr2 = keyNr2;
        this.indexArray = new IndexArrayTwoKey<E>( this );
    }

    /**
     * The deletion of an element in the table is simply done by moving the
     * successors to the empty position.
     */
    @Override
    protected void closeDeletion( int d ) {

        // Adapted from Knuth Section 6.4 Algorithm R
        Object[] tab = this.table;
        int len = tab.length;
        int keyNr = this.keyNr;

        // Look for items to swap into newly vacated slot
        // starting at index immediately following deletion,
        // and continuing until a null slot is seen, indicating
        // the end of a run of possibly-colliding keys.
        Object item;
        Object keyElem;
        for ( int i = nextKeyIndex( d, len ); ( item = tab[i] ) != null; i = nextKeyIndex( i, len ) ) {
            // The following test triggers if the item at slot i (which
            // hashes to be at slot r) should take the spot vacated by d.
            // If so, we swap it in, and then continue with d now at the
            // newly vacated i.  This process will terminate when we hit
            // the null slot at the end of this run.
            // The test is messy because we are using a circular table.
            keyElem = ( (E[][]) item )[0][0].getKeyElement( keyNr );
            int r = hash( keyElem, len );
            if ( ( i < r && ( r <= d || d <= i ) ) || ( r <= d && d <= i ) ) {
                tab[d] = item;
                tab[i] = null;
                d = i;
            }
        }
    }

    @Override
    public void put( E element ) {

        if ( element == null ) {
            return;
        }
        final int keyNr = this.keyNr;
        final int keyNr2 = this.keyNr2;
        Object[] tab = this.table;
        int len = tab.length;
        final Object keyElem = element.getKeyElement( keyNr );
        final Object keyElem2 = element.getKeyElement( keyNr2 );
        int i = hash( keyElem, len );

        Object item;
        while ( ( item = tab[i] ) != null ) {
            E[][] ihses = (E[][]) item;

            if ( ihses[0][0].getKeyElement( keyNr ) == keyElem ) {
                // check if element is to append to existing list
                for ( int j = 0; j < ihses.length; j++ ) {
                    if ( ihses[j][0].getKeyElement( keyNr2 ) == keyElem2 ) {
                        E[] oldE = ihses[j];
                        E[] newE = (E[]) new IndexHashSetElement[oldE.length + 1];
                        System.arraycopy( oldE, 0, newE, 0, oldE.length );
                        newE[newE.length - 1] = element;
                        ihses[j] = newE;
                        return;
                    }
                }

                // else extend first dimension and add new list
                E[][] newIhses = (E[][]) new IndexHashSetElement[ihses.length + 1][];
                System.arraycopy( ihses, 0, newIhses, 0, ihses.length );
                E[] newE = (E[]) new IndexHashSetElement[1];
                newE[0] = element;
                newIhses[newIhses.length - 1] = newE;
                tab[i] = newIhses;
                return;
            }
            i = ++i % len;
        }

        // else add single Element
        E[][] newArray = (E[][]) new IndexHashSetElement[1][1];
        newArray[0][0] = element;

        this.addToTable( i, newArray, false );
    }

    /**
     * Unsupported.
     */
    @Override
    public E get( Object keyElem ) {

        throw new MoinUnsupportedOperationException( IndexMessages.HASH_CODE_NOT_DESIGNED );
    }

    /**
     * Returns a list of elements with the given keys. It exposes a part of the
     * array structure for performance reasons. Be careful when using the array
     * since it is the original stored in the hash table.
     * 
     * @param keyElem
     * @param keyElem2
     * @return
     */
    public E[] getUnderlyingForRead( Object keyElem, Object keyElem2 ) {

        if ( keyElem == null || keyElem2 == null ) {
            return null;
        }
        final int keyNr = this.keyNr;
        final int keyNr2 = this.keyNr2;
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );

        Object item;
        while ( ( item = tab[i] ) != null ) {
            E[][] ihses = (E[][]) item;

            if ( ihses[0][0].getKeyElement( keyNr ) == keyElem ) {
                // check if element is to append to existing list
                for ( int j = 0; j < ihses.length; j++ ) {
                    if ( ihses[j][0].getKeyElement( keyNr2 ) == keyElem2 ) {
                        return ihses[j];
                    }
                }
                return null;
            }
            i = ++i % len;
        }
        return null;
    }

    /**
     * Returns the original 2-dimensional array structure containing elements
     * with the given key (K1). This is done for performance reasons but exposes
     * internals of this data structures to the caller.
     * 
     * @param keyElem
     * @return
     */
    public E[][] getUnderlyingForRead( Object keyElem ) {

        if ( keyElem == null ) {
            return null;
        }
        final int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );

        Object item;
        while ( ( item = tab[i] ) != null ) {
            E[][] ihses = (E[][]) item;
            if ( ihses[0][0].getKeyElement( keyNr ) == keyElem ) {
                return ihses;
            }
            i = ++i % len;
        }
        return null;

    }

    /**
     * Returns a wrapper for an array (x-dimension list) that contains all
     * elements having the given keys K1 and K2. This wrapper is to be used for
     * bulk changes to avoid unnecessary lookups.
     * <p>
     * Caution: Operations on the IndexArrayTwo key instance are not
     * synchronized with operations on IndexHashSetTwoKey!
     * 
     * @param keyElem K1
     * @param keyElem2 K2
     * @return
     */
    public IndexArrayTwoKey<E> getUnderlyingForChange( Object keyElem, Object keyElem2 ) {

        if ( keyElem == null || keyElem2 == null ) {
            return null;
        }

        // cannot call getUnderlyingForRead(Object) because we need the position of the 2-dimension array
        final int keyNr = this.keyNr;
        final int keyNr2 = this.keyNr2;
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );

        Object item;
        while ( ( item = tab[i] ) != null ) {
            E[][] ihses = (E[][]) item;

            if ( ihses[0][0].getKeyElement( keyNr ) == keyElem ) {
                for ( int j = 0; j < ihses.length; j++ ) {
                    if ( ihses[j][0].getKeyElement( keyNr2 ) == keyElem2 ) {
                        this.indexArray.init( i, j, ihses[j] );
                        return this.indexArray;
                    }
                }
                return null;
            }
            i = ++i % len;
        }
        return null;
    }

    /**
     * Removes a given element from the table (if contained)
     * 
     * @param element
     */
    public void removeElement( E element ) {

        if ( element == null ) {
            return;
        }
        final int keyNr = this.keyNr;
        final int keyNr2 = this.keyNr2;
        Object[] tab = this.table;
        int len = tab.length;
        final Object keyElem = element.getKeyElement( keyNr );
        final Object keyElem2 = element.getKeyElement( keyNr2 );
        int i = hash( keyElem, len );

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                return;
            }
            if ( ( (E[][]) item )[0][0].getKeyElement( keyNr ) == keyElem ) {
                E[][] elems = (E[][]) item;
                for ( int j = 0; j < elems.length; j++ ) {
                    if ( elems[j][0].getKeyElement( keyNr2 ) == keyElem2 ) {
                        E[] els = elems[j];
                        if ( els.length == 1 ) {
                            if ( elems.length == 1 ) {
                                this.removeFromTable( i );
                            } else {
                                elems[j] = elems[elems.length - 1];
                                E[][] newEs = (E[][]) new IndexHashSetElement[elems.length - 1][];
                                System.arraycopy( elems, 0, newEs, 0, elems.length - 1 );
                                tab[i] = newEs;
                            }
                            return;
                        }
                        int last = els.length;
                        for ( int k = 0; k < last; ) {
                            if ( els[k] == element ) {
                                if ( k == --last ) {
                                    els[k] = null;
                                } else {
                                    els[k] = els[last];
                                    els[last] = null;
                                }
                                break;
                            } else {
                                ++k;
                            }
                        }
                        if ( last == 0 ) {
                            this.removeFromTable( i );
                        } else {
                            E[] newE = (E[]) new IndexHashSetElement[last];
                            System.arraycopy( els, 0, newE, 0, last );
                            elems[j] = newE;
                        }
                        return;
                    }
                }
            }
            i = ++i % len;
        }
    }

    @Override
    public Object[] keys( ) {

        throw new UnsupportedOperationException( );
    }

    @Override
    protected void transfer( Object[] newTable ) {

        Object[] src = this.table;
        int keyNr = this.keyNr;
        int newCapacity = newTable.length;
        for ( int j = 0; j < src.length; j++ ) {
            E[][] e = (E[][]) src[j];
            if ( e != null ) {
                src[j] = null;
                int i = hash( e[0][0].getKeyElement( keyNr ), newCapacity );
                while ( newTable[i] != null ) {
                    i = ++i % newCapacity;
                }
                newTable[i] = e;
            }
        }
    }

    /**
     * Calculates the number of elements contained in the table. It does not
     * recognize duplications.
     * 
     * @return
     */
    public int totalSize( ) {

        int sum = 0;
        for ( int i = 0; i < this.table.length; ++i ) {
            if ( this.table[i] != null ) {
                E[][] elems = (E[][]) this.table[i];
                for ( int j = 0; j < elems.length; ++j ) {
                    sum += elems[j].length;
                }
            }
        }
        return sum;
    }

    @Override
    public boolean containsKey( Object keyElem ) {

        if ( keyElem == null ) {
            return false;
        }
        final int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );

        Object item;
        while ( ( item = tab[i] ) != null ) {
            E[][] ihses = (E[][]) item;

            if ( ihses[0][0].getKeyElement( keyNr ) == keyElem ) {
                return true;
            }
            i = ++i % len;
        }
        return false;
    }

    @Override
    public int getPositionInTable( Object obj ) {

        if ( obj == null ) {
            throw new IndexBugException( IndexMessages.PARAMETER_MUST_NOT_BE_NULL );
        }
        int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        Object keyElem = ( (E[][]) obj )[0][0].getKeyElement( keyNr );
        int i = hash( keyElem, len );

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                throw new IndexBugException( IndexMessages.KEY_ELEMENT_NOT_FOUND, keyElem, obj );
            }
            if ( ( (E[][]) item )[0][0].getKeyElement( keyNr ) == keyElem ) {
                return i;
            }
            i = ++i % len;
        }
    }

    /**
     * Returns the position triple of the given element. Required in index dump.
     * <p>
     * int[0] = position in table (K1)<br>
     * int[1] = x-position in 2-dimensional array (K2 list position)<br>
     * int[2] = y-position in 2-dimensional array<br>
     * 
     * @param elem the element to look for
     * @param returnValue Must be at least of size 3
     * @return <code>true</code> if position could be determined,
     * <code>false</code> otherwise
     */
    public boolean getCorrectElementPosition( E elem, int[] returnValue ) {

        int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        Object keyElem = elem.getKeyElement( keyNr );
        Object keyElem2 = elem.getKeyElement( this.keyNr2 );
        int i = hash( keyElem, len );

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                return false;
            }
            if ( ( (E[][]) item )[0][0].getKeyElement( keyNr ) == keyElem ) {
                E[][] itemTable = (E[][]) item;
                for ( int j = 0; j < itemTable.length; ++j ) {
                    if ( itemTable[j][0].getKeyElement( this.keyNr2 ) == keyElem2 ) {
                        for ( int k = 0; k < itemTable[j].length; ++k ) {
                            if ( itemTable[j][k] == elem ) {
                                returnValue[0] = i;
                                returnValue[1] = j;
                                returnValue[2] = k;
                                return true;
                            }
                        }
                    }
                }
            }
            i = nextKeyIndex( i, len );
        }
    }

    /**
     * Not designed!
     */
    @Override
    public int hashCode( ) {

        assert false : IndexMessages.HASH_CODE_NOT_DESIGNED;
        return -1;
    }

    /**
     * Just for testing!
     */
    @Override
    public boolean equals( Object obj ) {

        if ( !( obj instanceof IndexHashSetTwoKey ) ) {
            return false;
        }
        Object[] table = this.table;
        Object[] otherTable = ( (IndexHashSetTwoKey<E>) obj ).table;

        if ( table.length != otherTable.length ) {
            return false;
        }

        Object[][] item;
        Object[][] otherItem;
        for ( int i = 0; i < table.length; i++ ) {
            if ( otherTable[i] != null ) {
                if ( table[i] == null ) {
                    return false;
                }
            }
            if ( table[i] == null ) {
                if ( otherTable[i] != null ) {
                    return false;
                }
            } else {
                item = (Object[][]) table[i];
                otherItem = (Object[][]) otherTable[i];

                if ( item.length != otherItem.length ) {
                    return false;
                }

                for ( int j = 0; j < item.length; j++ ) {
                    if ( item[j].length != otherItem[j].length ) {
                        return false;
                    }

                    for ( int j2 = 0; j2 < item[j].length; j2++ ) {
                        if ( !( (E) item[j][j2] ).equals( otherItem[j][j2] ) ) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
