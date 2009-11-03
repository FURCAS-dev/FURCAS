package com.sap.tc.moin.facility.primary.query.index.memory;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A hash table that accepts only one element per key. I.e. a hash set. Keys are
 * compared as usual by identity.
 * 
 * @author D048997
 * @param <E>
 */
public class IndexHashSetSingle<E extends IndexHashSetElement> extends IndexHashSetBase<E> {

    public IndexHashSetSingle( int keyNr ) {

        this( keyNr, DEFAULT_INITIAL_CAPACITY );
    }

    public IndexHashSetSingle( int keyNr, Object[] table, int size ) {

        super( keyNr, table, size );
    }

    public IndexHashSetSingle( int keyNr, int capacity ) {

        super( keyNr );
        int cap = this.capacity( capacity );
        this.growLoadFactor = DEFAULT_GROW_LOAD_FACTOR;
        this.shrinkLoadFactor = DEFAULT_SHRINK_LOAD_FACTOR;
        this.growThreshold = (int) ( cap * DEFAULT_GROW_LOAD_FACTOR );
        this.shrinkThreshold = (int) ( cap * DEFAULT_SHRINK_LOAD_FACTOR );
        this.table = new IndexHashSetElement[cap];
    }

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

        E item;
        while ( ( item = (E) tab[i] ) != null ) {
            if ( item.getKeyElement( keyNr ) == keyElem ) {
                tab[i] = element;
                return;
            }
            i = ++i % len;
        }
        // else add single Element
        this.addToTable( i, element, false );
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
            E item = (E) tab[i];
            if ( item == null ) {
                return null;
            }
            if ( item.getKeyElement( keyNr ) == keyElem ) {
                return item;
            }
            i = ++i % len;
        }
    }

    public E getViaEquals( Object keyElem ) {

        if ( keyElem == null ) {
            return null;
        }
        int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );

        while ( true ) {
            E item = (E) tab[i];
            if ( item == null ) {
                return null;
            }
            if ( item.getKeyElement( keyNr ).equals( keyElem ) ) {
                return item;
            }
            i = ++i % len;
        }
    }

    public E removeElement( E element ) {

        if ( element == null ) {
            return null;
        }
        Object keyElem = element.getKeyElement( this.keyNr );
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );

        while ( true ) {
            E item = (E) tab[i];
            if ( item == null ) {
                return null;
            }
            if ( item == element ) {
                this.removeFromTable( i );
                return item;
            }
            i = ++i % len;
        }
    }

    public E remove( Object keyElem ) {

        if ( keyElem == null ) {
            return null;
        }
        int keyNr = this.keyNr;
        Object[] tab = this.table;
        int len = tab.length;
        int i = hash( keyElem, len );

        while ( true ) {
            E item = (E) tab[i];
            if ( item == null ) {
                return null;
            }
            if ( item.getKeyElement( keyNr ) == keyElem ) {
                this.removeFromTable( i );
                return item;
            }
            i = ++i % len;
        }

    }

    @Override
    protected void transfer( Object[] newTable ) {

        Object[] src = this.table;
        int newCapacity = newTable.length;
        int keyNr = this.keyNr;
        for ( int j = 0; j < src.length; j++ ) {
            E e = (E) src[j];
            if ( e != null ) {
                src[j] = null;
                int i = hash( e.getKeyElement( keyNr ), newCapacity );
                while ( newTable[i] != null ) {
                    i = ++i % newCapacity;
                }
                newTable[i] = e;
            }
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
                ret[pos++] = ( (E) table[i] ).getKeyElement( keyNr );
            }
        }
        return ret;
    }

    /**
     * Runs over the table and returns a list of all contained elements.
     * 
     * @return
     */
    public Collection<E> values( ) {

        Object[] tab = this.table;
        Collection<E> ret = new ArrayList<E>( this.size( ) );
        for ( int i = 0; i < tab.length; i++ ) {
            if ( tab[i] != null ) {
                ret.add( (E) tab[i] );
            }
        }
        return ret;
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
            keyElem = ( (E) item ).getKeyElement( keyNr );
            int r = hash( keyElem, len );
            if ( ( i < r && ( r <= d || d <= i ) ) || ( r <= d && d <= i ) ) {
                tab[d] = item;
                tab[i] = null;
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
        Object keyElem = ( (E) obj ).getKeyElement( keyNr );
        int i = hash( keyElem, len );

        while ( true ) {
            Object item = tab[i];
            if ( item == null ) {
                throw new IndexBugException( IndexMessages.KEY_ELEMENT_NOT_FOUND, keyElem, obj );
            }
            if ( ( (E) item ).getKeyElement( keyNr ) == keyElem ) {
                return i;
            }
            i = ++i % len;
        }
    }

    @Override
    public int hashCode( ) {

        assert false : IndexMessages.HASH_CODE_NOT_DESIGNED;
        return -1;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( !( obj instanceof IndexHashSetSingle ) ) {
            return false;
        }
        IndexHashSetSingle<E> other = (IndexHashSetSingle<E>) obj;
        Object[] table = this.table;
        Object[] otherTable = other.table;

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
                if ( !( ( (E) table[i] ).equals( otherTable[i] ) ) ) {
                    return false;
                }
            }
        }
        return true;
    }
}
