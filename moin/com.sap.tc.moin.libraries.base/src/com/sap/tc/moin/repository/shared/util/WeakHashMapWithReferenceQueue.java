package com.sap.tc.moin.repository.shared.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;

/**
 * A map whose keys are weakly referenced and for which clients can specify a
 * {@link ReferenceQueue} into which the keys wrapped by weak references are to
 * be inserted when made finalizable. The weak references inserted into the
 * queue are of type {@link KeyWeakReference} and wrap the key objects passed to
 * this map and additionally point to this map as well as their values. Clients
 * can use this reference to remove the corresponding entry from this map
 * because the {@link #remove} method treats {@link KeyWeakReference} objects
 * specially and removes them as if their referent has been passed.
 * <p>
 * Note that when keys become finalizable, they will be nulled out in the
 * references maintained in this structure. It is guaranteed that the enclosing
 * {@link KeyWeakReference} instances are already entered into the registered
 * queue. Until they get removed from this map, the iterator and any other
 * access operation will return them as <tt>null</tt> keys.
 * <p>
 * The <tt>null</tt> key is allowed and is not wrapped as a weak reference.
 * <p>
 */
public class WeakHashMapWithReferenceQueue<K, V> extends AbstractMap<K, V> {

    /**
     * HashMap is serializable
     */
    private static final long serialVersionUID = 1L;

    static final int DEFAULT_INITIAL_CAPACITY = 16;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private final HashMap<KeyWeakReference, V> map;

    /**
     * Constructs an empty <tt>NotifyingWeakHashMap</tt> with the specified
     * initial capacity and load factor.
     * 
     * @param initialCapacity The initial capacity.
     * @param loadFactor The load factor.
     * @throws IllegalArgumentException if the initial capacity is negative or
     * the load factor is nonpositive.
     */
    public WeakHashMapWithReferenceQueue( int initialCapacity, float loadFactor ) {

        map = new HashMap<KeyWeakReference, V>( initialCapacity, loadFactor );
    }

    /**
     * Constructs an empty <tt>NotifyingWeakHashMap</tt> with the specified
     * initial capacity and the default load factor (0.75).
     * 
     * @param initialCapacity the initial capacity.
     * @throws IllegalArgumentException if the initial capacity is negative.
     */
    public WeakHashMapWithReferenceQueue( int initialCapacity ) {

        map = new HashMap<KeyWeakReference, V>( initialCapacity );
    }

    /**
     * Constructs an empty <tt>HashMap</tt> with the default initial capacity
     * (16) and the default load factor (0.75).
     */
    public WeakHashMapWithReferenceQueue( ) {

        map = new HashMap<KeyWeakReference, V>( );
    }

    /**
     * Constructs a new <tt>HashMap</tt> with the same mappings as the specified
     * <tt>Map</tt>. The <tt>HashMap</tt> is created with default load factor
     * (0.75) and an initial capacity sufficient to hold the mappings in the
     * specified <tt>Map</tt>.
     * 
     * @param m the map whose mappings are to be placed in this map.
     * @throws NullPointerException if the specified map is null.
     */
    public WeakHashMapWithReferenceQueue( Map<? extends K, ? extends V> m ) {

        map = new HashMap<KeyWeakReference, V>( Math.max( (int) ( m.size( ) / DEFAULT_LOAD_FACTOR ) + 1, DEFAULT_INITIAL_CAPACITY ), DEFAULT_LOAD_FACTOR );
        this.putAll( m );
    }

    /**
     * Constructs an empty <tt>NotifyingWeakHashMap</tt> with the specified
     * initial capacity and load factor.
     * 
     * @param initialCapacity The initial capacity.
     * @param loadFactor The load factor.
     * @param queue The queue into which to put Elements that got removed
     * because they are no longer strongly referenced and have been removed from
     * this map.
     * @throws IllegalArgumentException if the initial capacity is negative or
     * the load factor is nonpositive.
     */
    public WeakHashMapWithReferenceQueue( int initialCapacity, float loadFactor, ReferenceQueue<K> queue ) {

        this( initialCapacity, loadFactor );
        this.queue = queue;
    }

    /**
     * Constructs an empty <tt>NotifyingWeakHashMap</tt> with the specified
     * initial capacity and the default load factor (0.75).
     * 
     * @param initialCapacity the initial capacity.
     * @param queue the reference queue
     * @throws IllegalArgumentException if the initial capacity is negative.
     */
    public WeakHashMapWithReferenceQueue( int initialCapacity, ReferenceQueue<K> queue ) {

        this( initialCapacity );
        this.queue = queue;
    }

    /**
     * Constructs an empty <tt>HashMap</tt> with the default initial capacity
     * (16) and the default load factor (0.75).
     * 
     * @param queue the reference queue
     */
    public WeakHashMapWithReferenceQueue( ReferenceQueue<K> queue ) {

        this( );
        this.queue = queue;
    }

    /**
     * Constructs a new <tt>HashMap</tt> with the same mappings as the specified
     * <tt>Map</tt>. The <tt>HashMap</tt> is created with default load factor
     * (0.75) and an initial capacity sufficient to hold the mappings in the
     * specified <tt>Map</tt>.
     * 
     * @param m the map whose mappings are to be placed in this map.
     * @param queue the reference queue
     * @throws NullPointerException if the specified map is null.
     */
    public WeakHashMapWithReferenceQueue( Map<? extends K, ? extends V> m, ReferenceQueue<K> queue ) {

        this( m );
        this.queue = queue;
    }

    /**
     * Wraps the <tt>key</tt> with a weak reference of type
     * {@link KeyWeakReference} and adds that reference as key with the
     * <tt>value</tt> as value to this map.
     */
    public V put( K key, V value ) {

        KeyWeakReference<K> insertKey = null;
        if ( key != null ) {
            if ( this.queue != null ) {
                insertKey = new KeyWeakReference<K>( key, value, this.queue );
            } else {
                insertKey = new KeyWeakReference<K>( key, value );
            }
        }
        V result = map.put( insertKey, value );
        return result;
    }

    /**
     * Fetches the value for the <tt>key</tt> passed.
     */
    public V get( Object key ) {

        Object getKey = null;
        if ( key != null ) {
            getKey = new KeyWeakReference( key );
        }
        V result = map.get( getKey );
        return result;
    }

    /**
     * Wraps the <tt>key</tt> with a {@link KeyWeakReference} and checks if this
     * map contains an equal reference as key.
     */
    public boolean containsKey( Object key ) {

        Object containsKey = null;
        if ( key != null ) {
            containsKey = new KeyWeakReference( key );
        }
        boolean result = map.containsKey( containsKey );
        return result;
    }

    /**
     * Wraps the <tt>key</tt> passed with a {@link KeyWeakReference} before
     * passing it to the superclass implementation. However, if the <tt>key</tt>
     * is instance of {@link KeyWeakReference}, no wrapping takes place as it is
     * assumed that the caller has received this reference from the
     * {@link #queue} in which finalizable and cleared references from this map
     * are enqueued and now wants to remove the respective entry from this map.
     */
    public V remove( Object key ) {

        Object removeKey = key;
        if ( key != null && !( key instanceof WeakHashMapWithReferenceQueue.KeyWeakReference ) ) {
            removeKey = new KeyWeakReference( key );
        }
        V result = map.remove( removeKey );
        return result;

    }

    /**
     * Not supported. That's why
     * 
     * @throws UnsupportedOperationException on every invocation.
     */
    public Set<Entry<K, V>> entrySet( ) {

        throw new MoinUnsupportedOperationException( "WeakHashMapWithReferenceQueue.entrySet()" ); //$NON-NLS-1$
    }

    /**
     * Delegates to the {@link #map backing} HashMap.
     */
    public int size( ) {

        return map.size( );
    }

    /**
     * Delegates to the {@link #map backing} HashMap.
     */
    public boolean containsValue( Object value ) {

        return map.containsValue( value );
    }

    /**
     * Delegates to the {@link #map backing} HashMap.
     */
    public void clear( ) {

        map.clear( );
    }

    /**
     * Delegates to the {@link #map backing} HashMap.
     */
    public Collection<V> values( ) {

        return map.values( );
    }

    /**
     * Delegates to the {@link #map backing} HashMap.
     */
    public boolean equals( Object o ) {

        return map.equals( o );
    }

    /**
     * Delegates to the {@link #map backing} HashMap.
     */
    public int hashCode( ) {

        return map.hashCode( );
    }

    /**
     * Delegates to the {@link #map backing} HashMap.
     */
    public String toString( ) {

        return map.toString( );
    }

    /**
     * The specific aspect about this key set is that the keys of the underlying
     * map are {@link KeyWeakReference} which wrap the actual keys. Therefore,
     * the key set returned by this operation "unwraps" those keys before
     * returning them.
     */
    public Set<K> keySet( ) {

        return ( this.keySet != null ? this.keySet : ( this.keySet = new KeySet<K>( ) ) );
    }

    private class KeySet<T> extends AbstractSet<T> {

        /**
         * Note that a key returned by this iterator may have been nulled out
         * because the key has become finalizable (not strongly referenced
         * anymore) and the {@link KeyWeakReference} has not been removed from
         * the map.
         */
        public Iterator<T> iterator( ) {

            Iterator<KeyWeakReference> keySetIterator = map.keySet( ).iterator( );
            return new KeySetIterator<T>( keySetIterator );
        }

        public int size( ) {

            return WeakHashMapWithReferenceQueue.this.size( );
        }

        public boolean contains( Object o ) {

            return WeakHashMapWithReferenceQueue.this.containsKey( o );
        }

        public boolean remove( Object o ) {

            return WeakHashMapWithReferenceQueue.this.remove( o ) != null;
        }

        public void clear( ) {

            WeakHashMapWithReferenceQueue.this.clear( );
        }

        private class KeySetIterator<E> implements Iterator<E> {

            /**
             * Internal usage
             * 
             * @param i the iterator
             */
            public KeySetIterator( Iterator<KeyWeakReference> i ) {

                this.i = i;
            }

            /**
             * Note that a key returned by this operation may have been nulled
             * out because the key has become finalizable (not strongly
             * referenced anymore) and the {@link KeyWeakReference} has not been
             * removed from the map.
             */
            public E next( ) {

                KeyWeakReference next = this.i.next( );
                E result = null;
                if ( next != null ) {
                    result = (E) next.get( );
                }
                return result;
            }

            public boolean hasNext( ) {

                return this.i.hasNext( );
            }

            public void remove( ) {

                this.i.remove( );
            }

            private Iterator<KeyWeakReference> i;
        }
    }

    // ---------------- attributes ----------------
    /**
     * The queue that is used for creating the weak references. If not passed to
     * a constructor, then a new queue is created for a new instance of this
     * class.
     */
    private ReferenceQueue<K> queue;

    /**
     * The key set of this map; <tt>null</tt> until requested for the first time
     * by calling {@link #keySet}.
     */
    private KeySet<K> keySet;

    /**
     * An extended weak reference that keeps a little more state that, when
     * inserted into the {@link #queue}, reveals its origin (this hash map) and
     * the value to which the object referenced by the weak reference has been
     * key.
     * <p>
     * Equality and hash code are defined based on the key object wrapped by the
     * reference.
     */
    public class KeyWeakReference<E> extends WeakReference<E> {

        /**
         * Creates a new weak reference that refers to the given object and is
         * registered with the given queue.
         * 
         * @param key the key
         * @param value the value
         * @param q queue the weak reference is registered with
         * @throws NullPointerException If the <code>queue</code> argument is
         * <code>null</code>
         */
        public KeyWeakReference( E key, Object value, ReferenceQueue<? super E> q ) {

            super( key, q );
            this.hashCode = key.hashCode( );
            this.value = value;
        }

        /**
         * Creates a new weak reference that refers to the given object and
         * value but is not registered with any queue.
         * 
         * @param key the key
         * @param value the value
         */
        public KeyWeakReference( E key, Object value ) {

            super( key );
            this.hashCode = key.hashCode( );
            this.value = value;
        }

        /**
         * Creates a new weak reference just for comparison reasons. The
         * reference is not registered with any queue.
         * 
         * @param key the key to wrap by the reference
         */
        public KeyWeakReference( E key ) {

            this( key, /* value */null );
        }

        /**
         * Retrieves the value for the key wrapped by this reference
         * 
         * @return the value
         */
        public Object getValue( ) {

            return this.value;
        }

        /**
         * Retrieves the map owning the reference
         * 
         * @return the map
         */
        public WeakHashMapWithReferenceQueue<K, V> getMap( ) {

            return WeakHashMapWithReferenceQueue.this;
        }

        /**
         * If the object <tt>o</tt> is an instance of {@link KeyWeakReference},
         * the comparison is done between the objects referenced by this and the
         * passed reference. If <tt>o</tt> is of another type, the comparison is
         * done between <tt>o</tt> and the object referenced by this reference.
         * If this object and <tt>o</tt> are identical, <tt>true</tt> is
         * returned immediately. With this, it becomes possible to compare
         * cleared references based on their identity.
         */
        public boolean equals( Object o ) {

            boolean result = this == o;
            if ( !result ) {
                if ( o instanceof WeakHashMapWithReferenceQueue.KeyWeakReference ) {
                    if ( get( ) == null ) {
                        // default to equality of the references instead of
                        // the referenced objects if cleared
                        result = super.equals( o );
                    } else {
                        result = get( ).equals( ( (KeyWeakReference) o ).get( ) );
                    }
                } else {
                    if ( get( ) == null ) {
                        result = super.equals( o );
                    } else {
                        result = get( ).equals( o );
                    }
                }
            }
            return result;
        }

        /**
         * The hash code is based on the key wrapped by this reference which is
         * cached at the time this reference is created. This maintains the hash
         * code beyond the point where the reference is cleared.
         */
        public int hashCode( ) {

            return this.hashCode;
        }

        // ---------- attributes of inner class KeyWeakReference ---------
        /**
         * The value associated with the key that is references / was referenced
         * by this weak reference.
         */
        private Object value;

        /**
         * The hash code of the referenced key, cached upon creation. This is
         * important in order to preserve this object's hash code beyond
         * clearing of the reference. Otherwise it would no longer be possible
         * to find the object in the keys of the map.
         */
        private int hashCode;
    }

}