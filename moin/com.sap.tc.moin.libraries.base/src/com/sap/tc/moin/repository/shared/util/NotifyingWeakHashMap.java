/*
 * Created on 31.08.2005
 */
package com.sap.tc.moin.repository.shared.util;

import java.lang.ref.Reference;
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
import com.sap.tc.moin.repository.shared.util.HousekeepingThread.ActionOnBeingGarbageCollectedProvider;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;

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
public class NotifyingWeakHashMap<K, V> extends AbstractMap<K, V> {

    /**
     * HashMap is serializable
     */
    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // ---------------- attributes ----------------

    /**
     * The queue that is used for creating the weak references. If not passed to
     * a constructor, then a new queue is created for a new instance of this
     * class.
     */
    private ReferenceQueue queue;

    /**
     * The key set of this map; <tt>null</tt> until requested for the first time
     * by calling {@link #keySet}.
     */
    private KeySet<K> keySet;

    private HashMap<KeyWeakReference, V> valueMap;

    private HashMap<KeyWeakReference, ListMap<Notifyee<K, V>, Object /* context */>> registrationMap;

    /**
     * An extended weak reference that keeps a little more state that, when
     * inserted into the {@link #queue}, reveals its origin (this hash map) and
     * the value to which the object referenced by the weak reference has been
     * key.
     * <p>
     * Equality and hash code are defined based on the key object wrapped by the
     * reference.
     */
    private class KeyWeakReference<E> extends WeakReference<E> implements ActionOnBeingGarbageCollectedProvider {

        // ---------- attributes of inner class KeyWeakReference ---------

        /**
         * The hash code of the referenced key, cached upon creation. This is
         * important in order to preserve this object's hash code beyond
         * clearing of the reference. Otherwise it would no longer be possible
         * to find the object in the keys of the map.
         */
        private int hashCode;

        /**
         * Creates a new weak reference that refers to the given object and
         * value but is not registered with any queue.
         * 
         * @param key the key
         */
        public KeyWeakReference( E key ) {

            super( key, NotifyingWeakHashMap.this.queue );
            this.hashCode = key.hashCode( );
        }

        public void actionOnBeingGarbageCollected( Reference referenceToObjectWhichHasBeenGarbageCollected ) {

            KeyWeakReference kwr = (KeyWeakReference) referenceToObjectWhichHasBeenGarbageCollected;
            Pair<V, ListMap<Notifyee<K, V>, Object>> resultAndNotifyees;
            synchronized ( NotifyingWeakHashMap.this ) {
                resultAndNotifyees = removeInternal( kwr );
            }
            ListMap<Notifyee<K, V>, Object> notifyees = resultAndNotifyees.getB( );

            //notification MUST happen outside the synchronized block
            notifyNotifyees( notifyees, true /* garbageCollected */);
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
        @Override
        public boolean equals( Object o ) {

            boolean result = this == o;
            if ( !result ) {
                if ( o instanceof NotifyingWeakHashMap.KeyWeakReference ) {
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
        @Override
        public int hashCode( ) {

            return this.hashCode;
        }

    }

    private class KeySet<T> extends AbstractSet<T> {

        /**
         * Note that a key returned by this iterator may have been nulled out
         * because the key has become finalizable (not strongly referenced
         * anymore) and the {@link KeyWeakReference} has not been removed from
         * the map.
         */
        @Override
        public Iterator<T> iterator( ) {

            Iterator<KeyWeakReference> keySetIterator = valueMap.keySet( ).iterator( );
            return new KeySetIterator<T>( keySetIterator );
        }

        @Override
        public int size( ) {

            return NotifyingWeakHashMap.this.size( );
        }

        @Override
        public boolean contains( Object o ) {

            return NotifyingWeakHashMap.this.containsKey( o );
        }

        @Override
        public boolean remove( Object o ) {

            return NotifyingWeakHashMap.this.remove( o ) != null;
        }

        @Override
        public void clear( ) {

            NotifyingWeakHashMap.this.clear( );
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

    /**
     * Constructs an empty <tt>NotifyingWeakHashMap</tt> with the specified
     * initial capacity and load factor.
     * 
     * @param initialCapacity The initial capacity.
     * @param loadFactor The load factor.
     * @throws IllegalArgumentException if the initial capacity is negative or
     * the load factor is nonpositive.
     */
    public NotifyingWeakHashMap( ReferenceQueue refQueue, int initialCapacity, float loadFactor ) {

        this.valueMap = new HashMap<KeyWeakReference, V>( initialCapacity, loadFactor );
        this.registrationMap = new HashMap( );
        this.queue = refQueue;
    }

    /**
     * Constructs an empty <tt>NotifyingWeakHashMap</tt> with the specified
     * initial capacity and the default load factor (0.75).
     * 
     * @param initialCapacity the initial capacity.
     * @throws IllegalArgumentException if the initial capacity is negative.
     */
    public NotifyingWeakHashMap( ReferenceQueue refQueue, int initialCapacity ) {

        this.valueMap = new HashMap<KeyWeakReference, V>( initialCapacity );
        this.registrationMap = new HashMap<KeyWeakReference, ListMap<Notifyee<K, V>, Object /* context */>>( initialCapacity );
        this.queue = refQueue;
    }

    /**
     * Constructs an empty <tt>HashMap</tt> with the default initial capacity
     * (16) and the default load factor (0.75).
     */
    public NotifyingWeakHashMap( ReferenceQueue refQueue ) {

        this.valueMap = new HashMap<KeyWeakReference, V>( );
        this.registrationMap = new HashMap<KeyWeakReference, ListMap<Notifyee<K, V>, Object /* context */>>( );
        this.queue = refQueue;
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
    public NotifyingWeakHashMap( ReferenceQueue refQueue, Map<? extends K, ? extends V> m ) {

        int size = Math.max( (int) ( m.size( ) / DEFAULT_LOAD_FACTOR ) + 1, DEFAULT_INITIAL_CAPACITY ), DEFAULT_LOAD_FACTOR;
        this.valueMap = new HashMap<KeyWeakReference, V>( size );
        this.registrationMap = new HashMap<KeyWeakReference, ListMap<Notifyee<K, V>, Object /* context */>>( size );
        this.queue = refQueue;
        this.putAll( m );
    }

    /**
     * The method to register for being notified on the garbage-collecting or
     * explicit removal of a key from the map.
     * 
     * @param key the key which the client registers for
     * @param context the context which identifies the key in the view of a
     * client or {@link Notifyee}
     * @param notifyee the to be called {@link Notifyee}
     */
    public void register( Object key, Object context, Notifyee<K, V> notifyee ) {

        synchronized ( this ) {
            // register the notifyee by adding him to the end of the to be notified
            register( key, context, notifyee, Integer.MAX_VALUE );
        }
    }

    /**
     * The method to register for being notified on the garbage-collecting or
     * explicit removal of a key from the map. With the index the order of the
     * notification can be controlled. This is the order of the to be notified
     * for a single key and this instance of {@link NotifyingWeakHashMap}. If
     * the index is greater than the number of existing Notifyees, the new
     * Notifyee is put at the end of the notification list. If the index is less
     * than or equal to 0, the Notifyee is put at the begin of the notification
     * list.
     * 
     * @param key the key which the client registers for
     * @param context the context which identifies the key in the view of a
     * client or {@link Notifyee}
     * @param notifyee the to be called {@link Notifyee}
     * @param index The position in the notification list. If the index is
     * greater than the number of existing Notifyees, the new Notifyee is put at
     * the end of the notification list. If the index is less than or equal to
     * 0, the Notifyee is put at the begin of the notification list.
     */
    public void register( Object key, Object context, Notifyee<K, V> notifyee, int index ) {

        if ( notifyee == null ) {
            return;
        }
        KeyWeakReference kwr = null;
        if ( key != null ) {
            kwr = new KeyWeakReference( key );
        }
        synchronized ( this ) {
            ListMap<Notifyee<K, V>, Object> notifyees = this.registrationMap.get( kwr );
            if ( notifyees == null ) {
                notifyees = new ListMap<Notifyee<K, V>, Object>( );
                this.registrationMap.put( kwr, notifyees );
            }
            int newPos = 0;
            if ( index < 0 ) {
                newPos = 0;
            } else if ( index > notifyees.size( ) ) {
                newPos = notifyees.size( );
            }
            notifyees.put( newPos, notifyee, context );
        }
    }

    /**
     * The method to deregister for the garbage-collecting or explicit removal
     * of a key from the map.
     * 
     * @param key the key which the client registered for
     * @param notifyee the to be called {@link Notifyee}
     */
    public void deregister( Object key, Notifyee<K, V> notifyee ) {

        if ( notifyee == null ) {
            return;
        }
        KeyWeakReference kwr = null;
        if ( key != null ) {
            kwr = new KeyWeakReference( key );
        }
        synchronized ( this ) {
            ListMap<Notifyee<K, V>, Object> notifyees = this.registrationMap.get( kwr );
            if ( notifyees != null ) {
                notifyees.remove( notifyee );
                if ( notifyees.size( ) == 0 ) {
                    this.registrationMap.remove( kwr );
                }
            }
        }
    }

    /**
     * Wraps the <tt>key</tt> with a weak reference of type
     * {@link KeyWeakReference} and adds that reference as key with the
     * <tt>value</tt> as value to this map.
     */
    @Override
    public synchronized V put( K key, V value ) {

        KeyWeakReference<K> insertKey = null;
        if ( key != null ) {
            insertKey = new KeyWeakReference<K>( key );
        }
        V result = valueMap.put( insertKey, value );
        return result;
    }

    /**
     * This method is a convenience method and equivalent to call
     * {@link #put(Object, Object)} and
     * {@link #register(Object, Object, Notifyee)} in sequence.
     * 
     * @param key key with which the specified value is to be associated.
     * @param value value to be associated with the specified key.
     * @param context the context which identifies the key in the view of a
     * client or {@link Notifyee}
     * @param notifyee the to be called {@link Notifyee}
     * @return previous value associated with specified key, or <tt>null</tt> if
     * there was no mapping for key. A <tt>null</tt> return can also indicate
     * that the HashMap previously associated <tt>null</tt> with the specified
     * key.
     */
    public synchronized V put( K key, V value, Object context, Notifyee<K, V> notifyee ) {

        register( key, context, notifyee );
        return put( key, value );
    }

    /**
     * Fetches the value for the <tt>key</tt> passed.
     */
    @Override
    public synchronized V get( Object key ) {

        Object getKey = null;
        if ( key != null ) {
            getKey = new KeyWeakReference( key );
        }
        V result = valueMap.get( getKey );
        return result;
    }

    /**
     * Wraps the <tt>key</tt> with a {@link KeyWeakReference} and checks if this
     * map contains an equal reference as key.
     */
    @Override
    public synchronized boolean containsKey( Object key ) {

        Object containsKey = null;
        if ( key != null ) {
            containsKey = new KeyWeakReference( key );
        }
        boolean result = valueMap.containsKey( containsKey );
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
    @Override
    public V remove( Object key ) {

        V result;
        ListMap<Notifyee<K, V>, Object> notifyees;
        synchronized ( this ) {
            KeyWeakReference removeKey;
            if ( !( key instanceof KeyWeakReference ) ) {
                removeKey = new KeyWeakReference( key );
            } else {
                //key can be null, but null can be casted to everything
                removeKey = (KeyWeakReference) key;
            }
            Pair<V, ListMap<Notifyee<K, V>, Object>> resultAndNotifyees = removeInternal( removeKey );
            result = resultAndNotifyees.getA( );
            notifyees = resultAndNotifyees.getB( );
        }
        //notification MUST happen outside the synchronized block
        notifyNotifyees( notifyees, false /* garbageCollected */);
        return result;
    }

    /**
     * Not supported. That's why
     * 
     * @throws UnsupportedOperationException on every invocation.
     */
    @Override
    public Set<Entry<K, V>> entrySet( ) {

        throw new MoinUnsupportedOperationException( "WeakHashMapWithReferenceQueue.entrySet()" ); //$NON-NLS-1$
    }

    /**
     * Delegates to the {@link #valueMap backing} HashMap.
     */
    @Override
    public synchronized int size( ) {

        return valueMap.size( );
    }

    /**
     * Delegates to the {@link #valueMap backing} HashMap.
     */
    @Override
    public synchronized boolean containsValue( Object value ) {

        return valueMap.containsValue( value );
    }

    /**
     * Delegates to the {@link #valueMap backing} HashMap.
     */
    @Override
    public void clear( ) {

        HashMap<KeyWeakReference, ListMap<Notifyee<K, V>, Object /* context */>> tempRegistrationMap;
        synchronized ( this ) {
            valueMap.clear( );
            tempRegistrationMap = new HashMap<KeyWeakReference, ListMap<Notifyee<K, V>, Object /* context */>>( );
            for ( Entry<KeyWeakReference, ListMap<Notifyee<K, V>, Object>> entry : registrationMap.entrySet( ) ) {
                tempRegistrationMap.put( entry.getKey( ), entry.getValue( ) );
            }
            registrationMap.clear( );
        }

        for ( Entry<KeyWeakReference, ListMap<Notifyee<K, V>, Object>> entry : tempRegistrationMap.entrySet( ) ) {
            notifyNotifyees( entry.getValue( ), false /* garbageCollected */);
        }
    }

    /**
     * Delegates to the {@link #valueMap backing} HashMap.
     */
    @Override
    public synchronized Collection<V> values( ) {

        return valueMap.values( );
    }

    /**
     * Delegates to the {@link #valueMap backing} HashMap.
     */
    @Override
    public synchronized boolean equals( Object o ) {

        return valueMap.equals( o );
    }

    /**
     * Delegates to the {@link #valueMap backing} HashMap.
     */
    @Override
    public synchronized int hashCode( ) {

        return valueMap.hashCode( );
    }

    /**
     * Delegates to the {@link #valueMap backing} HashMap.
     */
    @Override
    public synchronized String toString( ) {

        return valueMap.toString( );
    }

    /**
     * The specific aspect about this key set is that the keys of the underlying
     * map are {@link KeyWeakReference} which wrap the actual keys. Therefore,
     * the key set returned by this operation "unwraps" those keys before
     * returning them.
     */
    @Override
    public synchronized Set<K> keySet( ) {

        return ( this.keySet != null ? this.keySet : ( this.keySet = new KeySet<K>( ) ) );
    }

    // private methods

    private Tuple.Pair<V, ListMap<Notifyee<K, V>, Object /* context */>> removeInternal( KeyWeakReference kwr ) {

        ListMap<Notifyee<K, V>, Object /* context */> notifyeesToContext = registrationMap.get( kwr );
        if ( notifyeesToContext != null ) {
            registrationMap.remove( kwr );
        }

        V result = valueMap.remove( kwr );
        return new Tuple.Pair<V, ListMap<Notifyee<K, V>, Object>>( result, notifyeesToContext );
    }

    private void notifyNotifyees( ListMap<Notifyee<K, V>, Object /* context */> notifyees, boolean garbageCollected ) {

        if ( notifyees != null ) {
            for ( Notifyee notifyee : notifyees.keyList( ) ) {
                notifyee.notifyOnObjectRemoved( garbageCollected, notifyees.get( notifyee ) /* context */);
            }
        }
    }
}
