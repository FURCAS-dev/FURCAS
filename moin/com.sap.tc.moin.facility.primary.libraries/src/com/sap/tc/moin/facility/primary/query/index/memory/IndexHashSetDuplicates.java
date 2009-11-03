package com.sap.tc.moin.facility.primary.query.index.memory;

import java.lang.ref.ReferenceQueue;

public class IndexHashSetDuplicates<E extends IndexHashSetElement, T> extends IndexHashSetBase<E> {

    private ReferenceQueue<T> refQueue = null;

    private IndexArrayDuplicates<E> indexArray;

    public IndexHashSetDuplicates( int keyNr, Object[] table, int size ) {

        super( keyNr, table, size );
        this.init( );
    }

    public IndexHashSetDuplicates( int keyNr, int capacity ) {

        super( keyNr );
        int cap = this.capacity( capacity );
        this.growLoadFactor = DEFAULT_GROW_LOAD_FACTOR;
        this.shrinkLoadFactor = DEFAULT_SHRINK_LOAD_FACTOR;
        this.growThreshold = (int) ( cap * DEFAULT_GROW_LOAD_FACTOR );
        this.shrinkThreshold = (int) ( cap * DEFAULT_SHRINK_LOAD_FACTOR );
        this.table = new Object[cap];
        this.init( );
    }

    public ReferenceQueue<T> getReferenceQueue( ) {

        return this.refQueue;
    }

    private void init( ) {

        this.indexArray = new IndexArrayDuplicates<E>( this );
        this.refQueue = new ReferenceQueue<T>( );
    }

    @Override
    public void put( E element ) {

        if ( element == null ) {
            return;
        }
        Object[] tab = this.table;
        int keyNr = this.keyNr;
        int len = tab.length;
        Object keyElem = element.getKeyElement( keyNr );
        int i = hash( keyElem, len );

        Object item;
        while ( ( item = tab[i] ) != null ) {
            if ( item instanceof IndexHashSetElement ) {
                E ihse = (E) item;
                if ( ihse.getKeyElement( keyNr ) == keyElem ) {
                    E[] elemArray = (E[]) new IndexHashSetElement[2];
                    elemArray[0] = ihse;
                    elemArray[1] = element;
                    tab[i] = elemArray;
                    return;
                }
            } else if ( item instanceof Object[] ) { // Array
                E[] ihses = (E[]) item;
                if ( ihses[0].getKeyElement( keyNr ) == keyElem ) {
                    E[] newArray = (E[]) new IndexHashSetElement[ihses.length + 1];
                    System.arraycopy( ihses, 0, newArray, 0, ihses.length );
                    newArray[newArray.length - 1] = element;
                    tab[i] = newArray;
                    return;
                }
            } else {
                /*
                 * Check if the T instance equals the key element of the E
                 * instance to add. DO NOT add the element to this position if t
                 * == null. Since it is a WeakReference, it may be possible that
                 * the referent of a reference is null, but the right T instance
                 * is at one of the up-coming array positions.
                 */
                T t = ( (IndexWeakHashReference<T>) item ).get( );
                if ( t == keyElem ) {
                    tab[i] = element;
                    return;
                }
            }
            i = nextKeyIndex( i, len );
        }
        // else add single Element
        this.addToTable( i, element, false );
    }

    public T putOrGetExistingKey( T key, boolean addToCache ) {

        if ( key == null ) {
            return null;
        }
        Object[] tab = this.table;
        int keyNr = this.keyNr;
        int len = tab.length;
        Object keyElem = key;
        int i = hash( keyElem, len );

        Object item;
        while ( ( item = tab[i] ) != null ) {
            if ( item instanceof IndexHashSetElement ) {
                T itemKey = (T) ( (E) item ).getKeyElement( keyNr );
                if ( itemKey.equals( keyElem ) ) {
                    return itemKey;
                }
            } else if ( item instanceof Object[] ) { // Array
                T itemKey = (T) ( (E[]) item )[0].getKeyElement( keyNr );
                if ( itemKey.equals( keyElem ) ) {
                    return itemKey;
                }
            } else {
                /*
                 * DO NOT add 'key' to this position if t == null. Since it is a
                 * WeakReference, it may be possible that the referent of the
                 * reference is null, but the right T instance is at one of the
                 * up-coming array positions.
                 */
                T t = ( (IndexWeakHashReference<T>) item ).get( );
                if ( t != null && t.equals( keyElem ) ) {
                    return t;
                }
            }
            i = nextKeyIndex( i, len );
        }

        if ( addToCache ) {
            // else add single Element
            IndexWeakHashReference<T> ref = new IndexWeakHashReference<T>( key, this.refQueue, i );
            this.addToTable( i, ref, false );
            return key;
        }
        return null;
    }

    public void cleanup( ) {

        ReferenceQueue<T> q = this.refQueue;
        IndexWeakHashReference<T> ref = null;
        for ( ;; ) {
            ref = (IndexWeakHashReference<T>) q.poll( );
            if ( ref == null ) {
                return;
            }
            if ( ref.hashPos == -1 ) { // already deleted during transfer() in resize
                continue;
            }
            if ( this.table[ref.hashPos] == ref ) {
                this.removeFromTableWithoutResize( ref.hashPos );
            } else {
                throw new IndexBugException( IndexMessages.WEAK_REF_EXPECTED_AT_POS, ref.hashPos );
            }
        }
    }

    @Override
    protected void resize( int newCapacity ) {

        this.cleanup( );
        if ( this.size( ) < this.growThreshold ) {
            // check again if resize is still necessary
            return;
        }
        super.resize( newCapacity );
    }

    @Override
    public E get( Object keyElem ) {

        if ( keyElem == null ) {
            return null;
        }
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );
        int keyNr = this.keyNr;

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                return null;
            }
            if ( item instanceof IndexHashSetElement ) {
                if ( ( (E) item ).getKeyElement( keyNr ) == keyElem ) {
                    return (E) item;
                }
            } else if ( item instanceof Object[] ) {
                if ( ( (E[]) item )[0].getKeyElement( keyNr ) == keyElem ) {
                    return ( (E[]) item )[0];
                }
            }
            i = nextKeyIndex( i, len );
        }
    }

    public Object getUnderlyingForRead( Object keyElem ) {

        if ( keyElem == null ) {
            return null;
        }
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );
        int keyNr = this.keyNr;

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                return null;
            }
            if ( item instanceof IndexHashSetElement ) {
                if ( ( (E) item ).getKeyElement( keyNr ) == keyElem ) {
                    return item;
                }
            } else if ( item instanceof Object[] ) {
                if ( ( (E[]) item )[0].getKeyElement( keyNr ) == keyElem ) {
                    return item;
                }
            }
            i = nextKeyIndex( i, len );
        }
    }

    public Object getUnderlyingForChange( Object keyElem ) {

        if ( keyElem == null ) {
            return null;
        }
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );
        int keyNr = this.keyNr;

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                return null;
            }
            if ( item instanceof IndexHashSetElement ) {
                if ( ( (E) item ).getKeyElement( keyNr ) == keyElem ) {
                    return item;
                }
            } else if ( item instanceof Object[] ) {
                if ( ( (E[]) item )[0].getKeyElement( keyNr ) == keyElem ) {
                    this.indexArray.init( i, (E[]) item );
                    return this.indexArray;
                }
            }
            i = nextKeyIndex( i, len );
        }

    }

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
            if ( item instanceof IndexHashSetElement ) {
                if ( ( (E) item ).getKeyElement( keyNr ) == keyElem ) {
                    this.convertToWeakRef( i, keyElem );
                    return;
                }
            } else if ( item instanceof Object[] ) {
                if ( ( (E[]) item )[0].getKeyElement( keyNr ) == keyElem ) {
                    E[] elems = (E[]) item;
                    for ( int j = 0; j < elems.length; j++ ) {
                        if ( elems[j] == element ) {
                            if ( elems.length == 2 ) {
                                if ( j == 0 ) {
                                    tab[i] = elems[1];
                                } else {
                                    tab[i] = elems[0];
                                }
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
            }
            i = nextKeyIndex( i, len );
        }
    }

    private void convertToWeakRef( int tablePos, Object keyElem ) {

        IndexWeakHashReference<T> ref = new IndexWeakHashReference<T>( (T) keyElem, this.refQueue, tablePos );
        this.table[tablePos] = ref;
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
            if ( item instanceof IndexHashSetElement ) {
                keyElem = ( (E) item ).getKeyElement( keyNr );
            } else if ( item instanceof Object[] ) { // array
                keyElem = ( (E[]) item )[0].getKeyElement( keyNr );
            } else {
                keyElem = ( (IndexWeakHashReference<T>) item ).get( );
                if ( keyElem == null || keyElem.hashCode( ) == -1 ) {
                    ( (IndexWeakHashReference<T>) item ).hashPos = -1;
                    this.removeFromTableWithoutResize( i );
                    --i;
                    continue;
                }
            }
            int r = hash( keyElem, len );
            if ( ( i < r && ( r <= d || d <= i ) ) || ( r <= d && d <= i ) ) {
                tab[d] = item;
                if ( item instanceof IndexWeakHashReference ) {
                    ( (IndexWeakHashReference<T>) item ).hashPos = d;
                }
                tab[i] = null;
                d = i;
            }
        }
    }

    @Override
    protected void transfer( Object[] newTable ) {

        Object[] src = this.table;
        int newCapacity = newTable.length;
        int keyNr = this.keyNr;

        for ( int j = 0; j < src.length; j++ ) {
            Object e = src[j];
            if ( e != null ) {
                src[j] = null;
                Object keyElem = null;
                if ( e instanceof IndexHashSetElement ) {
                    keyElem = ( (E) e ).getKeyElement( keyNr );
                } else if ( e instanceof Object[] ) { // Array
                    keyElem = ( (E[]) e )[0].getKeyElement( keyNr );
                } else {
                    keyElem = ( (IndexWeakHashReference<T>) e ).get( );
                    if ( keyElem == null || keyElem.hashCode( ) == -1 ) {
                        ( (IndexWeakHashReference<T>) e ).hashPos = -1;
                        this.decSize( );
                        continue;
                    }
                }
                int i = hash( keyElem, newCapacity );
                while ( newTable[i] != null ) {
                    i = nextKeyIndex( i, newCapacity );
                }
                newTable[i] = e;
                if ( e instanceof IndexWeakHashReference ) {
                    ( (IndexWeakHashReference<T>) e ).hashPos = i;
                }
            }
        }
    }

    @Override
    public Object[] keys( ) {

        Object[] table = this.table;
        int keyNr = this.keyNr;
        Object[] collec = new Object[this.size( )];
        int pos = 0;
        Object item;
        for ( int i = 0; i < table.length; i++ ) {
            if ( ( item = table[i] ) != null ) {
                if ( item instanceof IndexHashSetElement ) {
                    collec[pos++] = ( (E) item ).getKeyElement( keyNr );
                } else if ( item instanceof Object[] ) {
                    collec[pos++] = ( (E[]) table[i] )[0].getKeyElement( keyNr );
                }
            }
        }
        Object[] ret = new Object[pos];
        System.arraycopy( collec, 0, ret, 0, pos );
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
        Object keyElem;
        if ( obj instanceof IndexHashSetElement ) {
            keyElem = ( (E) obj ).getKeyElement( keyNr );
        } else if ( obj instanceof Object[] ) {
            keyElem = ( (E[]) obj )[0].getKeyElement( keyNr );
        } else {
            keyElem = obj;
        }

        int i = hash( keyElem, len );

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                throw new IndexBugException( IndexMessages.KEY_ELEMENT_NOT_FOUND, keyElem, obj );
            }
            if ( item instanceof IndexHashSetElement ) {
                if ( ( (E) item ).getKeyElement( keyNr ) == keyElem ) {
                    return i;
                }
            } else if ( item instanceof Object[] ) {
                if ( ( (E[]) item )[0].getKeyElement( keyNr ) == keyElem ) {
                    return i;
                }
            } else {
                if ( ( (IndexWeakHashReference<T>) item ).get( ) == keyElem ) {
                    return i;
                }
            }
            i = nextKeyIndex( i, len );
        }
    }

    /**
     * Encodes the position in the table in a long value
     * 
     * <pre>
     *    |-------------|-------------| (long)
     *        pos in Tab|pos in subTab
     * </pre>
     */
    public long getCorrectElementPosition( E obj ) {

        if ( obj == null ) {
            throw new IndexBugException( IndexMessages.PARAMETER_MUST_NOT_BE_NULL );
        }
        int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        Object keyElem = ( obj ).getKeyElement( keyNr );

        int i = hash( keyElem, len );

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                throw new IndexBugException( IndexMessages.KEY_ELEMENT_NOT_FOUND, keyElem, obj );
            }
            if ( item instanceof IndexHashSetElement ) {
                if ( item == obj ) {
                    return ( (long) i ) << 32;
                }
            } else if ( item instanceof Object[] ) {
                if ( ( (E[]) item )[0].getKeyElement( keyNr ) == keyElem ) {
                    E[] e = (E[]) item;
                    for ( int j = 0; j < e.length; ++j ) {
                        if ( e[j] == obj ) {
                            return ( ( (long) i ) << 32 ) | j;
                        }
                    }
                }
            }
            i = nextKeyIndex( i, len );
        }
    }

    @Override
    public int hashCode( ) {

        assert false : IndexMessages.HASH_CODE_NOT_DESIGNED;
        return -1;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( !( obj instanceof IndexHashSetDuplicates ) ) {
            return false;
        }
        IndexHashSetDuplicates<E, T> other = (IndexHashSetDuplicates<E, T>) obj;
        Object[] table = this.table;
        Object[] otherTable = other.table;

        if ( table.length != otherTable.length ) {
            return false;
        }

        Object item = null;
        Object otherItem = null;
        Object[] array = null;
        Object[] otherArray = null;
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
                item = table[i];
                otherItem = otherTable[i];

                if ( item instanceof IndexHashSetElement ) {
                    if ( !( otherItem instanceof IndexHashSetElement ) ) {
                        return false;
                    }
                    if ( !( (E) item ).equals( otherItem ) ) {
                        return false;
                    }
                } else if ( item instanceof Object[] ) {
                    if ( !( otherItem instanceof Object[] ) ) {
                        return false;
                    }
                    array = (Object[]) item;
                    otherArray = (Object[]) otherItem;

                    if ( array.length != otherArray.length ) {
                        return false;
                    }

                    for ( int j = 0; j < array.length; j++ ) {
                        if ( !( (E) array[j] ).equals( otherArray[j] ) ) {
                            return false;
                        }
                    }
                } else if ( item instanceof IndexWeakHashReference ) {
                    if ( !( otherItem instanceof IndexWeakHashReference ) ) {
                        return false;
                    }
                    if ( !( (IndexWeakHashReference<T>) item ).equals( ( otherItem ) ) ) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
