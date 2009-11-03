package com.sap.tc.moin.repository.shared.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A {@link Map} implementation that remembers the order of insertion, so that
 * key set and values iterators can be requested that iterate in the insertion
 * order. There is even an additional {@link #put(int, Object, Object)} method
 * which takes an index for adding a new element to the ListMap.
 * 
 * @author d024227
 */
public class ListMap<K, V> extends HashMap<K, V> {

    // $JL-CLONE$
    /**
     * HashMap is serializable
     */
    private static final long serialVersionUID = 1L;

    private class ListMapIterator implements Iterator<K> {

        private Iterator<K> backingIterator;

        private K current = null;

        /**
         * Internal use
         */
        public ListMapIterator( ) {

            this.backingIterator = ListMap.this.list.iterator( );
        }

        public boolean hasNext( ) {

            return this.backingIterator.hasNext( );
        }

        public K next( ) {

            this.current = this.backingIterator.next( );
            return this.current;
        }

        public void remove( ) {

            ListMap.this.remove( this.current );
            this.backingIterator.remove( );
        }
    }

    private class KeySet implements Set<K> {

        public boolean add( K o ) {

            return false; // unmodifiableSet !
        }

        public boolean addAll( Collection<? extends K> c ) {

            return false; // unmodifiableSet !
        }

        public void clear( ) {

            // unmodifiableSet !
        }

        public boolean contains( Object o ) {

            return ListMap.super.keySet( ).contains( o );
        }

        public boolean containsAll( Collection<?> c ) {

            return ListMap.super.keySet( ).containsAll( c );
        }

        public boolean isEmpty( ) {

            return ListMap.super.keySet( ).isEmpty( );
        }

        public Iterator<K> iterator( ) {

            return new ListMapIterator( );
        }

        public boolean remove( Object o ) {

            return false; // unmodifiableSet !
        }

        public boolean removeAll( Collection<?> c ) {

            return false; // unmodifiableSet !
        }

        public boolean retainAll( Collection<?> c ) {

            return false; // unmodifiableSet !
        }

        public int size( ) {

            return ListMap.super.keySet( ).size( );
        }

        public Object[] toArray( ) {

            return list.toArray( );
        }

        public <T> T[] toArray( T[] a ) {

            return list.toArray( a );
        }
    }

    private Set<K> keySet;

    private List<K> keyList;

    /**
     * holds the additional {@link List} that keeps track of insertion order of
     * the keys.
     * <p>
     * Not private for performance issues (accessor method)
     */
    List<K> list;

    /**
     * Constructs the list that keeps track of insertion order
     * 
     * @param s the initial size
     */
    private void init( int s ) {

        this.list = new ArrayList<K>( s );
    }

    /**
     * Constructs a new, empty map with the specified initial capacity and the
     * specified load factor.
     * 
     * @param initialCapacity the initial capacity of the ListMap.
     * @param loadFactor the load factor of the ListMap
     * @throws IllegalArgumentException if the initial capacity is less than
     * zero, or if the load factor is nonpositive.
     */
    public ListMap( int initialCapacity, float loadFactor ) {

        super( initialCapacity, loadFactor );
        init( initialCapacity );
    }

    /**
     * Constructs a new, empty map with the specified initial capacity and
     * default load factor, which is <tt>0.75</tt>.
     * 
     * @param initialCapacity the initial capacity of the ListMap.
     * @throws IllegalArgumentException if the initial capacity is less than
     * zero.
     */
    public ListMap( int initialCapacity ) {

        this( initialCapacity, 0.75f );
    }

    /**
     * Constructs a new, empty map with a default capacity and load factor,
     * which is <tt>0.75</tt>.
     */
    public ListMap( ) {

        this( 11, 0.75f );
    }

    /**
     * Constructs a new map with the same mappings as the given map. The map is
     * created with a capacity of twice the number of mappings in the given map
     * or 11 (whichever is greater), and a default load factor, which is
     * <tt>0.75</tt>.
     * 
     * @param t the map whose mappings are to be placed in this map.
     */
    public ListMap( Map<? extends K, ? extends V> t ) {

        this( Math.max( 2 * t.size( ), 11 ), 0.75f );
        putAll( t );
    }

    @Override
    public V put( K key, V value ) {

        V result = super.put( key, value );
        if ( result != null ) {
            this.list.remove( key );
        }
        this.list.add( key );
        return result;
    }

    /**
     * Add an element
     * 
     * @param index index
     * @param key key
     * @param value value
     * @return the object that used to be at the place if any
     */
    public V put( int index, K key, V value ) {

        int oldIndex = -1;
        boolean containsKey = containsKey( key );
        if ( containsKey ) {
            oldIndex = this.list.indexOf( key );
        }
        V result = super.put( key, value );
        if ( result != null ) {
            this.list.remove( key );
        }
        if ( containsKey && index > oldIndex ) {
            this.list.add( index - 1, key );
        } else {
            this.list.add( index, key );
        }
        return result;
    }

    @Override
    public void putAll( Map<? extends K, ? extends V> m ) {

        for ( Map.Entry<? extends K, ? extends V> entry : m.entrySet( ) ) {
            K key = entry.getKey( );
            V value = entry.getValue( );
            V result = super.put( key, value );
            if ( result != null ) {
                this.list.remove( result );
            }
            this.list.add( key );
        }
        super.putAll( m );
    }

    @Override
    public V remove( Object key ) {

        this.list.remove( key );
        return super.remove( key );
    }

    @Override
    public void clear( ) {

        this.list.clear( );
        super.clear( );
    }

    @Override
    public Set<K> keySet( ) {

        if ( this.keySet == null ) {
            this.keySet = Collections.unmodifiableSet( new KeySet( ) );
        }
        return this.keySet;
    }

    @Override
    public List<V> values( ) {
        Set<K> keySet = keySet( );
        List<V> values = new ArrayList<V>( keySet.size( ) );
        for ( K key : keySet ) {
            values.add( get( key ) );
        }
        return Collections.unmodifiableList( values );
    }

    /**
     * @return the keyList
     */
    public List<K> keyList( ) {

        if ( this.keyList == null ) {
            this.keyList = Collections.unmodifiableList( this.list );
        }
        return this.keyList;
    }

}