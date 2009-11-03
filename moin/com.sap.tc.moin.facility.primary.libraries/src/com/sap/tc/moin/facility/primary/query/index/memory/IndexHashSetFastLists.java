package com.sap.tc.moin.facility.primary.query.index.memory;


/**
 * This hash set implementation is basically designed for the use of the mapping
 * "type to elements". It is able to contain multiple instances of E per key
 * element (see {@link IndexHashSetElement}). It does not guarantee the
 * uniqueness of elements added but only the uniqueness of the used key
 * elements.
 * 
 * <pre>
 * The design of this implementation has following assumptions to the typeToInstances
 * mapping:
 * 
 *  1. There will be a lot of elements per key.
 *  2. Elements will be added and removed randomly, i.e. elements are not grouped by 
 *     their type before they get added to or removed from the set.
 *  3. A changing action (index partition or remove partition) will either add or 
 *     remove elements. Not both.
 *  4. All actions are synchronized, i.e. manipulation of this hash set is only done 
 *     by one thread at the same time.
 *  5. Many elements with the same key will be added or removed in one changing action. 
 * </pre>
 * 
 * Memory consumption is critical, so it is necessary, that the list of elements
 * per key must not have empty cells. So the list of elements has to be resized
 * after each add or remove. Holding that list in a standard array means, that,
 * to resize the array, a new array is created, the content is copied and the
 * old array is thrown away. This has several disadvantages:
 * <ul>
 * <li>A lot garbage is produced if many elements are added or removed.</li>
 * <li>The bigger the array the longer it takes to allocate a new one and to
 * copy the content.</li>
 * </ul>
 * Standard arrays are therefore not suitable for our use case.
 * <p>
 * A solution is provided by {@link http://www.javalution.org}. A list can also
 * be represented in a multi-dimensional array, e.g. two-dimensional. Such an
 * array can be imagined as an y-dimension array that points to x-dimension
 * arrays. The X-dimension must have an own, fixed size of a power of two (e.g.
 * 2^3=8). This constraint enables a fast calculation of a cell in the field via
 * bit-shifting. For example a two-dimensional field as used in the
 * implementation here:
 * 
 * <pre>
 *            x 0               4           7 
 *   y |---|  |---|---|---|---|---|---|---|---|
 *   0 |   |->| 0 | 1 | 2 |...|   |   |   | 7 |
 *     |---|  |---|---|---|---|---|---|---|---|
 *   1 |   |->| 8 |...|   |   | 12|   |   | 15|
 *     |---|  |---|---|---|---|---|---|---|---|
 *   2 |   |->| 16|   |   | 19|
 *     |---|  |---|---|---|---|
 *   3 |   |
 *     |---|
 *   
 *   General: pos = y * 8 + x
 *   Example: 12 = 1 * 8 + 4
 * </pre>
 * Groups of bits in the binary representation of the position number:
 * 
 * <pre>
 *   Example: 12 = 00001100
 *                 [-y-][x]
 * </pre>
 * <p>
 * In our example dimension x has 8=2^3 cells. The last three bits represent the
 * position in x-dimension and all bits before represent the position in the y
 * dimension. example: 12 = 00001100 [-y-][x] The field can be implemented as
 * <code>Object[y][x]</code>. If you delete the last entry in the list, you have
 * to delete cell 19 and resize the field. But instead of creating the whole
 * field again you only need to create the affected x-dimension array. If
 * changes to the size of the y-dimension array are necessary, only the pointers
 * to the x-dimension arrays needs to be copied. No x-dimension array is
 * affected.
 * <p>
 * This technique helps to avoid creation of big arrays and mass copying.
 * <p>
 * Changing and reading the multi-dimensional list is encapsulated in
 * {@link IndexArrayFastList}.
 * 
 * @author D048997
 * @param <E> needs to implement the {@link IndexHashSetElement} interface that
 * enables instances of E to expose the key used for hashing in this hash set
 * (i.e. the type MofId).
 */
public class IndexHashSetFastLists<E extends IndexHashSetElement> extends IndexHashSetBase<E> {

    // Defines the maximal size of the X-dimension: 2^6 = 64. To get Y the position has to be shifted 6 bits to the right.
    protected static final int X_SHIFT = 6;

    /*
     * The growth of the Y dimension. The Y dimension grows by 2 if it needs to
     * expand (new Object[Y][] -> new Object[Y+2][]). So you may create two
     * X-dimension arrays instead of only one, when it grows by 1.
     */
    private static final int Y_GROWTH = 2;

    // initial size of Y-dimension array
    private static final int DEFAULT_Y_SIZE = 1 << 2;

    // initial size of X-dimension arrays
    protected static final int DEFAULT_X_SIZE = 1 << X_SHIFT;

    // mask to get position in dimX
    protected static final int X_MASK = DEFAULT_X_SIZE - 1;

    /*
     * sizes[i] holds the actual number of elements existing in the list at
     * super.table[i]. This value is used to resize the list after a set of
     * manipulations in the condense() method. This prevents resizing of even
     * the small X-dimension arrays during indexing or removing of a partition.
     * If the length of the list equals the number of stored elements, sizes[i]
     * will be zero! (Empty lists are not allowed anyway.) Setting sizes[i]=0 is
     * necessary to speed up condense() by avoiding size calculation of lists
     * that already fits to content amount.
     */
    protected int[] sizes;

    /*
     * The wrapper for the multi-dimensional array list; used only for changing
     * the list. Due to assumption 4 (see above) it is only necessary to hold
     * one instance and reinitialize it when needed again.
     */
    private IndexArrayFastList<E> indexArray;

    public IndexHashSetFastLists( int keyNr ) {

        this( keyNr, DEFAULT_INITIAL_CAPACITY );
    }

    /**
     * Constructor used in {@link IndexDumpHandler}
     * 
     * @param keyNr
     * @param table
     * @param size
     */
    public IndexHashSetFastLists( int keyNr, Object[] table, int size ) {

        super( keyNr, table, size );
        this.init( );
    }

    public IndexHashSetFastLists( int keyNr, int capacity ) {

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

        this.sizes = new int[this.table.length];
        this.indexArray = new IndexArrayFastList<E>( this );
    }

    /**
     * Adds an element to the table. Note, that no check is performed, whether
     * the element is already in the table.
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
            E[][] ihses = (E[][]) item;
            if ( ihses[0][0].getKeyElement( keyNr ) == keyElem ) {

                // we need to know how many elements are in the list
                // This number is the position at where we can add the next element
                int nextPosition = this.sizes[i];
                if ( nextPosition == 0 ) {
                    // calculate size = elements in list 
                    nextPosition = this.calcSize( ihses );
                }
                int xpos = nextPosition & X_MASK;
                int ypos = nextPosition >> X_SHIFT;

                // check if we can address the Y position of size in the field
                // and expand the Y-dimension otherwise
                if ( ( ypos ) >= ihses.length ) {
                    E[][] newE = (E[][]) new IndexHashSetElement[ihses.length + Y_GROWTH][];
                    System.arraycopy( ihses, 0, newE, 0, ihses.length );
                    ihses = newE;
                    tab[i] = newE;
                }
                /*
                 * If the next element is to be inserted at the beginning at a
                 * X-dimension array we need to create a new one. The last check
                 * ensured that the Y-dimension is big enough.
                 */
                if ( ( xpos ) == 0 ) {
                    // we create an X-dimension array of maximum size, so we do not need
                    // to resize again, if another element is inserted here during the same
                    // changing action. (Assumption 5)
                    // The array gets fitted later in the condense() method
                    ihses[ypos] = (E[]) new IndexHashSetElement[DEFAULT_X_SIZE];
                }
                /*
                 * If we insert somewhere else in the X-dimension array we need
                 * to check if there is enough space and provide it if
                 * necessary.
                 */
                else if ( ( xpos ) == ihses[ypos].length ) {
                    // again, we create a full-size X-dimension array (Assumption 5)
                    E[] newArray = (E[]) new IndexHashSetElement[DEFAULT_X_SIZE];
                    System.arraycopy( ihses[ypos], 0, newArray, 0, ihses[ypos].length );
                    ihses[ypos] = newArray;
                }
                ihses[ypos][xpos] = element;
                // remember the current number of elements in the current list, since
                // its size may be bigger than the number of elements stored
                this.sizes[i] = nextPosition + 1;
                return;
            }
            i = ++i % len;
        }

        // else add single Element
        E[][] newArray = (E[][]) new IndexHashSetElement[DEFAULT_Y_SIZE][];
        newArray[0] = (E[]) new IndexHashSetElement[DEFAULT_X_SIZE];
        newArray[0][0] = element;

        ++this.sizes[i]; // increment zero
        this.addToTable( i, newArray, false );
    }

    @Override
    protected void resize( int newCapacity ) {

        /*
         * Since the sizes array needs to be resized too, there are two options.
         * First, we copy the sizes[i] to the new hash position sizes[j], or we
         * condense the lists (which resets the sizes array) and only do a
         * proper transfer for super.table. The last approach was taken here.
         */
        this.condense( );
        this.sizes = new int[newCapacity];
        super.resize( newCapacity );
    }

    @Override
    protected void removeFromTable( int pos ) {

        this.sizes[pos] = 0;
        super.removeFromTable( pos );
    }

    /**
     * Shrinks the fast-list entries in the table to the minimum size. For
     * example, if you put a new element to the table, the last (x-dimension)
     * bucket of the list is enlarged to its maximum size to avoid recurring
     * adjustment of the length of the list in bulk operations that add a lot of
     * entries to this list. This may cause a lot of empty space in the list
     * that is freed by this method.<br>
     * It should be called after each index-changing operation.
     */
    public void condense( ) {

        E[][] tab;
        Object[] table = this.table;
        int listSize;
        int bucketCount; // the number of x-dimension buckets
        for ( int j = 0; j < this.sizes.length; ++j ) {
            // check if condensation is necessary (sizes[j]=0 signs already condensed
            if ( this.sizes[j] != 0 ) {
                listSize = this.sizes[j];
                tab = (E[][]) table[j];
                if ( tab == null ) {
                    throw new IndexBugException( IndexMessages.HASH_SIZE_TABLES_INCONSISTENT, j );
                }
                // calculate number of x-dimension buckets, it is required to shrink the y-dimension
                for ( bucketCount = tab.length - 1; bucketCount > ( ( listSize - 1 ) >> X_SHIFT ); --bucketCount ) {
                    // bucket needs to be nulled, because the y-dimension might not be resized
                    tab[bucketCount] = null;
                }
                // resize last x-dimension bucket if not completely filled
                if ( ( listSize & X_MASK ) != 0 ) {
                    E[] newA = (E[]) new IndexHashSetElement[listSize & X_MASK];
                    System.arraycopy( tab[listSize >> X_SHIFT], 0, newA, 0, listSize & X_MASK );
                    tab[listSize >> X_SHIFT] = newA;
                    this.sizes[j] = 0;
                }
                // resize y-dimension
                if ( ++bucketCount + Y_GROWTH < tab.length ) {
                    E[][] newTab = (E[][]) new IndexHashSetElement[bucketCount + Y_GROWTH][];
                    System.arraycopy( tab, 0, newTab, 0, bucketCount );
                    table[j] = newTab;
                }
            }

        }
    }

    /**
     * Returns the first element in the list that have the given keyElem as key
     * element.
     */
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
            if ( ( (E[][]) item )[0][0].getKeyElement( keyNr ) == keyElem ) {
                return ( (E[][]) item )[0][0];
            }
            i = ++i % len;
        }
    }

    /**
     * Returns a {@link IndexArrayFastList} that wraps the list of elements that
     * have the given key element. It is intended for bulk operations that
     * EITHER add OR remove elements with the <u>same</u> key element from the
     * table.<br>
     * Caution! The returned instance is reused and invalid after re-invocation
     * of this method. Use {@link IndexArrayFastList#store()} to avoid data
     * loss!
     * 
     * @param keyElem
     * @return Wrapper for the list of elements that have the given key element.
     */
    public IndexArrayFastList<E> getUnderlyingForChange( Object keyElem ) {

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
            E[][] elem = (E[][]) item;
            if ( elem[0][0].getKeyElement( keyNr ) == keyElem ) {
                this.indexArray.init( i, elem, ( this.sizes[i] != 0 ) ? this.sizes[i] : this.calcSize( elem ) );
                return this.indexArray;
            }
            i = ++i % len;
        }
    }

    /**
     * Calculates the length of the two-dimensional list, i.e. the allocated
     * space. It is intended to be used to calculate the number of elements in
     * the list if <code>this.sizes[i] == 0</code>.
     * 
     * @param a A two-dimensional list
     * @return Size of the given list
     */
    public static int calcSize( Object[][] a ) {

        for ( int i = a.length - 1; i >= 0; --i ) {
            if ( a[i] != null ) {
                return ( i << IndexHashSetFastLists.X_SHIFT ) + a[i].length;
            }
        }
        return 0;
    }

    /**
     * Returns the length of the list at the given position in the table. See
     * also {@link #calcSize(IndexHashSetElement[][])}.
     * 
     * @param i Absolute position in the table
     * @return Size of list or -1 if there is not list at the given position.
     */
    public int sizeOfEntryAtPos( int i ) {

        if ( this.table[i] == null ) {
            throw new IndexBugException( IndexMessages.TABLE_POSITION_IS_NULL, i );
        }
        return this.calcSize( (E[][]) this.table[i] );
    }

    /**
     * Returns a wrapper for the list of elements that have the given key
     * element. In contrast to the return of
     * {@link #getUnderlyingForChange(Object)}, the return of this method will
     * not invalidate on re-invocation.
     * 
     * @param keyElem
     * @return
     */
    public IndexArrayFastList<E> getUnderlyingForRead( Object keyElem ) {

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
            E[][] elem = (E[][]) item;
            if ( elem[0][0].getKeyElement( keyNr ) == keyElem ) {
                IndexArrayFastList<E> iArray = new IndexArrayFastList<E>( this );
                iArray.init( i, elem, ( this.sizes[i] != 0 ) ? this.sizes[i] : this.calcSize( elem ) );
                return iArray;
            }
            i = ++i % len;
        }
    }

    /**
     * Removes an element from the table. The array is not resized after remove
     * of the element, but the entry is completely removed if the array is
     * empty. Use {@link #condense()} to shrink it.
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
            if ( ( (E[][]) item )[0][0].getKeyElement( keyNr ) == keyElem ) {
                E[][] elems = (E[][]) item;
                int size = this.sizes[i];
                if ( size == 0 ) { // calculate the size
                    size = this.calcSize( elems );
                }
                for ( int j = 0; j < size; j++ ) {
                    if ( elems[j >> X_SHIFT][j & X_MASK] == element ) {
                        if ( size == 1 ) {
                            this.removeFromTable( i );
                        } else {
                            if ( j < --size ) {
                                elems[j >> X_SHIFT][j & X_MASK] = elems[size >> X_SHIFT][size & X_MASK];
                                elems[size >> X_SHIFT][size & X_MASK] = null;

                            } else {
                                elems[j >> X_SHIFT][j & X_MASK] = null;
                            }
                            this.sizes[i] = size;
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

        Object[] table = this.table;
        int keyNr = this.keyNr;
        Object[] ret = new Object[this.size( )];
        int pos = 0;
        for ( int i = 0; i < table.length; i++ ) {
            if ( table[i] != null ) {
                ret[pos++] = ( (E[][]) table[i] )[0][0].getKeyElement( keyNr );
            }
        }
        return ret;
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

    @Override
    protected void closeDeletion( int d ) {

        // Adapted from Knuth Section 6.4 Algorithm R
        Object[] tab = this.table;
        int[] sizes = this.sizes;
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
                sizes[d] = sizes[i];
                sizes[i] = 0;
                d = i;
            }
        }
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
     * Not designed!
     */
    @Override
    public int hashCode( ) {

        assert false : IndexMessages.HASH_CODE_NOT_DESIGNED;
        return -1;
    }

    /**
     * Compares two IndexHashSetFastLists instances.
     */
    @Override
    public boolean equals( Object obj ) {

        if ( !( obj instanceof IndexHashSetFastLists ) ) {
            return false;
        }
        Object[] table = this.table;
        Object[] otherTable = ( (IndexHashSetFastLists<E>) obj ).table;

        E[][] item;
        E[][] otherItem;
        int size;
        if ( table.length != otherTable.length ) {
            return false;
        }

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
                item = (E[][]) table[i];
                otherItem = (E[][]) otherTable[i];
                size = this.calcSize( item );

                if ( size != this.calcSize( otherItem ) ) {
                    return false;
                }

                for ( int j = 0; j < size; j++ ) {
                    if ( !item[j >> X_SHIFT][j & X_MASK].equals( otherItem[j >> X_SHIFT][j & X_MASK] ) ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
