package com.sap.tc.moin.facility.primary.query.index.memory;

/**
 * In contrast to {@link IndexHashSetSingle} this table accepts a list of
 * elements having the same key.
 * 
 * @author D048997
 * @param <E>
 */
public class IndexHashSetLists<E extends IndexHashSetElement> extends IndexHashSetBase<E> {

    private IndexArrayList<E> indexArray;

    public IndexHashSetLists( int keyNr, Object[] table, int size ) {

        super( keyNr, table, size );
        this.init( );
    }

    public IndexHashSetLists( int keyNr, int capacity ) {

        super( keyNr );
        int cap = this.capacity( capacity );
        this.growLoadFactor = DEFAULT_GROW_LOAD_FACTOR;
        this.shrinkLoadFactor = DEFAULT_SHRINK_LOAD_FACTOR;
        this.growThreshold = (int) ( cap * DEFAULT_GROW_LOAD_FACTOR );
        this.shrinkThreshold = (int) ( cap * DEFAULT_SHRINK_LOAD_FACTOR );
        this.table = new Object[cap];
        this.init( );
    }

    private void init( ) {

        this.indexArray = new IndexArrayList<E>( this );
    }

    /**
     * Adds the given element to the table. No uniqueness test is performed, so
     * double adding is possible.
     */
    @Override
    public void put( E element ) {

        if ( element == null ) {
            return;
        }
        int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        Object keyElem = element.getKeyElement( keyNr );
        int i = hash( keyElem, len );

        Object item;
        while ( ( item = tab[i] ) != null ) {
            E[] ihses = (E[]) item;
            if ( ihses[0].getKeyElement( keyNr ) == keyElem ) {
                E[] newArray = (E[]) new IndexHashSetElement[ihses.length + 1];
                System.arraycopy( ihses, 0, newArray, 0, ihses.length );
                newArray[newArray.length - 1] = element;
                tab[i] = newArray;
                return;
            }
            i = ++i % len;
        }
        // else add single Element
        E[] newArray = (E[]) new IndexHashSetElement[1];
        newArray[0] = element;

        this.addToTable( i, newArray, false );
    }

    @Override
    public E get( Object keyElem ) {

        if ( keyElem == null ) {
            return null;
        }
        int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                return null;
            }
            if ( ( (E[]) item )[0].getKeyElement( keyNr ) == keyElem ) {
                return ( (E[]) item )[0];
            }
            i = ++i % len;
        }
    }

    /**
     * Returns the list of elements having the same key. Changes to the returned
     * list will change the state of the table!
     * 
     * @param keyElem
     * @return
     */
    public E[] getUnderlyingForRead( Object keyElem ) {

        if ( keyElem == null ) {
            return null;
        }
        int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                return null;
            }
            if ( ( (E[]) item )[0].getKeyElement( keyNr ) == keyElem ) {
                return ( (E[]) item );
            }
            i = ++i % len;
        }
    }

    /**
     * Returns a wrapper for the list of elements having the same key. Use it
     * for bulk operations to avoid unnecessary lookups.
     * 
     * @param keyElem
     * @return an {@link IndexArrayList} wrapper for a found list,
     * <code>null</code> otherwise
     */
    public IndexArrayList<E> getUnderlyingForChange( Object keyElem ) {

        if ( keyElem == null ) {
            return null;
        }
        int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                return null;
            }
            if ( ( (E[]) item )[0].getKeyElement( keyNr ) == keyElem ) {
                this.indexArray.init( i, (E[]) item );
                return this.indexArray;
            }
            i = ++i % len;
        }
    }

    /**
     * Returns a wrapper for a list of elements having the same key. Use it for
     * bulk operations to avoid unnecessary lookups. If no list is found for the
     * given key, a wrapper with an empty list is returned. This list will just
     * be added to the table if {@link IndexArrayList#store()} is called.
     * 
     * @param keyElem The key identifying the list to change or add.
     * @return an {@link IndexArrayList} wrapper for a found list or a new list
     * of elements with the same key.
     */
    public IndexArrayList<E> getUnderlyingForChangeOrCreate( Object keyElem ) {

        if ( keyElem == null ) {
            return null;
        }
        int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                E[] lst = (E[]) new IndexHashSetElement[0];
                this.indexArray.init( i, lst );
                return this.indexArray;
            }
            if ( ( (E[]) item )[0].getKeyElement( keyNr ) == keyElem ) {
                this.indexArray.init( i, (E[]) item );
                return this.indexArray;
            }
            i = ++i % len;
        }
    }

    /**
     * Removes all elements with the same key.
     * 
     * @param keyElem
     */
    public void removeAllElements( Object keyElem ) {

        if ( keyElem == null ) {
            return;
        }
        int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                return;
            }
            if ( ( (E[]) item )[0].getKeyElement( keyNr ) == keyElem ) {
                this.removeFromTable( i );
                return;
            }
            i = ++i % len;
        }

    }

    /**
     * Removes the given element from the table (if contained).
     * 
     * @param element
     */
    public void removeElement( E element ) {

        if ( element == null ) {
            return;
        }
        int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        Object keyElem = element.getKeyElement( keyNr );
        int i = hash( keyElem, len );

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                return;
            }
            if ( ( (E[]) item )[0].getKeyElement( keyNr ) == keyElem ) {
                E[] elems = (E[]) item;
                for ( int j = 0; j < elems.length; j++ ) {
                    if ( elems[j] == element ) {
                        if ( elems.length == 1 ) {
                            this.removeFromTable( i );
                        } else {
                            E[] newArray = (E[]) new IndexHashSetElement[elems.length - 1];
                            System.arraycopy( elems, 0, newArray, 0, j );
                            System.arraycopy( elems, j + 1, newArray, j, elems.length - j - 1 );
                            tab[i] = newArray;
                        }
                        return;
                    }
                }
            }
            i = ++i % len;
        }
    }

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
            keyElem = ( (E[]) item )[0].getKeyElement( keyNr );
            int r = hash( keyElem, len );
            if ( ( i < r && ( r <= d || d <= i ) ) || ( r <= d && d <= i ) ) {
                tab[d] = item;
                tab[i] = null;
                d = i;
            }
        }
    }

    @Override
    protected void transfer( Object[] newTable ) {

        Object[] src = this.table;
        int keyNr = this.keyNr;
        int newCapacity = newTable.length;
        for ( int j = 0; j < src.length; j++ ) {
            E[] e = (E[]) src[j];
            if ( e != null ) {
                src[j] = null;
                int i = hash( e[0].getKeyElement( keyNr ), newCapacity );
                while ( newTable[i] != null ) {
                    i = ++i % newCapacity;
                }
                newTable[i] = e;
            }
        }
    }

    /**
     * Calculates the total number of elements in the table. It does not
     * recognize duplicates.
     * <p>
     * Slow! Don't use it or optimize (somehow).
     * 
     * @return
     */
    public int totalSize( ) {

        Object[] table = this.table;
        int ret = 0;
        for ( int i = 0; i < table.length; i++ ) {
            if ( table[i] != null ) {
                ret += ( (E[]) table[i] ).length;
            }
        }
        return ret;
    }

    /**
     * {@inheritDoc}
     * <p>
     * Slow! Don't use it.
     * 
     * @return
     */
    @Override
    public Object[] keys( ) {

        Object[] table = this.table;
        int keyNr = this.keyNr;
        Object[] ret = new Object[this.size( )];
        int pos = 0;
        for ( int i = 0; i < table.length; i++ ) {
            if ( table[i] != null ) {
                ret[pos++] = ( (E[]) table[i] )[0].getKeyElement( keyNr );
            }
        }
        return ret;
    }

    @Override
    public int getPositionInTable( Object obj ) {

        if ( obj == null ) {
            throw new IndexBugException( IndexMessages.PARAMETER_MUST_NOT_BE_NULL );
        }
        int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        Object keyElem = ( (E[]) obj )[0].getKeyElement( keyNr );
        int i = hash( keyElem, len );

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                throw new IndexBugException( IndexMessages.KEY_ELEMENT_NOT_FOUND, keyElem, obj );
            }
            if ( ( (E[]) item )[0].getKeyElement( keyNr ) == keyElem ) {
                return i;
            }
            i = ++i % len;
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
     * For testing only!
     */
    @Override
    public boolean equals( Object obj ) {

        if ( !( obj instanceof IndexHashSetLists ) ) {
            return false;
        }
        Object[] table = this.table;
        Object[] otherTable = ( (IndexHashSetLists<E>) obj ).table;

        if ( table.length != otherTable.length ) {
            return false;
        }

        Object[] item;
        Object[] otherItem;
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
                item = (Object[]) table[i];
                otherItem = (Object[]) otherTable[i];

                if ( item.length != otherItem.length ) {
                    return false;
                }

                for ( int j = 0; j < item.length; j++ ) {
                    if ( !( (E) item[j] ).equals( otherItem[j] ) ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
