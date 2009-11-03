package com.sap.tc.moin.facility.primary.query.index.memory;

public abstract class IndexHashSetBase<E extends IndexHashSetElement> {

    /**
     * The default initial capacity - MUST be a power of two.
     */
    static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * The maximum capacity, used if a higher value is implicitly specified by
     * either of the constructors with arguments. MUST be a power of two <=
     * 1<<30.
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * The load factor used when none specified in constructor.
     */
    static final float DEFAULT_GROW_LOAD_FACTOR = 0.5f;

    /**
     * The load factor where the table gets shrunken
     */
    static final float DEFAULT_SHRINK_LOAD_FACTOR = 0.1f;

    /**
     * The table, resized as necessary. Length MUST Always be a power of two.
     */
    // FIXME remove public, think about delegation pattern, where dumper calls hashtable that calls the dumper injecting the table, or something..
    public Object[] table;

    /**
     * The number of elements contained in this identity hash map.
     */
    private int size;

    /**
     * The next size values at which to resize (capacity * load factor).
     * 
     * @serial
     */
    protected int growThreshold;

    protected int shrinkThreshold;

    /**
     * The load factor for the hash table.
     * 
     * @serial
     */
    protected float growLoadFactor;

    protected float shrinkLoadFactor;

    protected final int keyNr;

    protected IndexHashSetBase( int keyNr ) {

        this.keyNr = keyNr;
    }

    protected IndexHashSetBase( int keyNr, Object[] table, int size ) {

        this( keyNr );
        this.table = table;
        this.size = size;
        this.growLoadFactor = DEFAULT_GROW_LOAD_FACTOR;
        this.shrinkLoadFactor = DEFAULT_SHRINK_LOAD_FACTOR;
        this.growThreshold = (int) ( table.length * this.growLoadFactor );
        this.shrinkThreshold = (int) ( table.length * this.shrinkLoadFactor );
    }

    protected static int nextKeyIndex( int i, int len ) {

        return ( i + 1 < len ? i + 1 : 0 );
    }

    protected static int hash( Object element, int length ) {

        int h = element.hashCode( );
        //        int h = System.identityHashCode(element);
        return ( ( h << 1 ) - ( h << 8 ) ) & ( length - 1 );
    }

    protected void resize( int newCapacity ) {

        Object[] oldTable = this.table;
        int oldCapacity = oldTable.length;
        if ( oldCapacity == MAXIMUM_CAPACITY ) {
            this.growThreshold = Integer.MAX_VALUE;
            return;
        }

        Object[] newTable = new Object[newCapacity];
        this.transfer( newTable );
        this.table = newTable;
        this.growThreshold = (int) ( newCapacity * this.growLoadFactor );
        this.shrinkThreshold = (int) ( newCapacity * this.shrinkLoadFactor );
    }

    protected int capacity( int expectedMaxSize ) {

        // Compute min capacity for expectedMaxSize given a load factor of 2/3
        int minCapacity = ( 3 * expectedMaxSize ) / 2;

        // Compute the appropriate capacity
        int result;
        if ( minCapacity > MAXIMUM_CAPACITY || minCapacity < 0 ) {
            result = MAXIMUM_CAPACITY;
        } else {
            result = DEFAULT_INITIAL_CAPACITY;
            while ( result < minCapacity ) {
                result <<= 1;
            }
        }
        return result;
    }

    public int size( ) {

        return this.size;
    }

    /**
     * Allows to rehash the table (e.g. if it is build up with gaps from dump)
     */
    protected void rehash( ) {

        Object[] table = this.table;
        int s = 0;
        for ( int i = 0; i < table.length; i++ ) {
            if ( table[i] != null ) {
                s++;
            }
        }
        this.size = s;
        int newCapacity = this.capacity( s );
        this.resize( newCapacity );
    }

    protected void decSize( ) {

        --this.size;
    }

    /**
     * Adds or replaces an element to the table and triggers resizing of the
     * table if necessary.
     * 
     * @param pos Position where to add in the table
     * @param elem Element to add
     * @param needNewPosition Specifies if the new position in the table is to
     * be returned in case the table got resized.
     * @return The new position in the table if the table got resized and
     * parameter <code>needNewPosition</code> is <code>true</code>. Otherwise it
     * returns the value of <code>pos</code>
     */
    protected int addToTable( int pos, Object elem, boolean needNewPosition ) {

        assert elem != null : IndexMessages.PARAMETER_MUST_NOT_BE_NULL;

        // only increment size if it is a new add but no replace
        if ( this.table[pos] == null ) {
            ++this.size;
        }
        this.table[pos] = elem;

        if ( this.size >= this.growThreshold ) {
            this.resize( this.table.length << 1 );
            if ( needNewPosition ) {
                return this.getPositionInTable( elem );
            }
        }
        return pos;
    }

    protected void removeFromTable( int pos ) {

        this.removeFromTableWithoutResize( pos );
        if ( this.size < this.shrinkThreshold ) {
            this.resize( this.table.length >> 1 );
        }
    }

    /**
     * Introduced to allow removing elements during resizing (e.g. for a
     * cleanup). Avoids infinite recursive calling of resize() if the table
     * would shrink during the operation.
     * 
     * @param pos
     */
    protected void removeFromTableWithoutResize( int pos ) {

        if ( this.table[pos] == null ) {
            throw new IndexBugException( IndexMessages.NO_ELEMENT_FOUND_TO_REMOVE, pos );
        }
        this.table[pos] = null;
        --this.size;
        this.closeDeletion( pos );
    }

    /**
     * Checks if the size counter {@link #size} is in sync with the actual
     * number of entries in the table.
     */
    protected void checkSize( ) {

        int count = 0;
        Object[] tab = this.table;
        for ( int i = 0; i < tab.length; i++ ) {
            if ( tab[i] != null ) {
                count++;
            }
        }
        if ( count != this.size ) {
            throw new IndexBugException( IndexMessages.SIZE_COUNTER_DIFFERENT, count, this.size );
        }
    }

    /**
     * Required in {@link IndexArrayList#store()} when returned from
     * {@link IndexHashSetLists#getUnderlyingForChangeOrCreate(Object)}. It may
     * add a new entry to the table by calling store() in
     * {@link IndexArrayList#add(IndexHashSetElement)} and requires the correct
     * position of the entry after a resize for another call of store().
     * <p>
     * Possible improvement: Introduce a addToTableWithoutResize() to
     * {@link IndexHashSetBase} and call it in {@link IndexArrayList#store()}.
     * 
     * @param obj
     * @return
     */
    abstract public int getPositionInTable( Object obj );

    abstract public void put( E element );

    /**
     * Transfers all elements of {@link #table} to the new table via rehashing.
     * 
     * @param newTable
     */
    abstract protected void transfer( Object[] newTable );

    /**
     * @return all keys of the table
     */
    abstract public Object[] keys( );

    /**
     * Get any element from the table having the given key.
     * 
     * @param keyElem
     * @return
     */
    abstract public E get( Object keyElem );

    /**
     * Since the tables use no overflow buckets but store colliding elements at
     * the next free position in the table, removing an element requires to
     * close the gap in the table that may be left behind to ensure that a
     * position in the table that is <code>null</code> is a valid break
     * condition for search.
     * 
     * @param d
     */
    abstract protected void closeDeletion( int d );

    public boolean containsKey( Object keyElem ) {

        return this.get( keyElem ) != null;
    }

}
