package com.sap.tc.moin.repository.shared.util;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.sap.tc.moin.repository.shared.util.HousekeepingThread.ActionOnBeingGarbageCollectedProvider;

/**
 * This generic class provides a cache for objects of type <code>V</code>,
 * uniquely identifiable using exactly <em>one</em> key component of type
 * <code>K</code>.
 * <p>
 * The instances of type <code>V</code> are held weakly.
 */
public class WeakObjectCache<K, V> extends AbstractWeakObjectCache {

    /**
     * The cache, holding weak references to the cached objects.
     */
    Map<K, WeakReferenceWithInfo> cache;

    /**
     * Creates a new instance of {@link WeakObjectCache} with default values for
     * initial capacity, load factor and concurrency level.
     */
    public WeakObjectCache( ReferenceQueue refQueue ) {

        this( refQueue, DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL );
    }

    /**
     * Creates a new instance of {@link WeakObjectCache} with the given initial
     * capacity.
     */
    public WeakObjectCache( ReferenceQueue refQueue, int initialCapacity ) {

        this( refQueue, initialCapacity, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL );
    }

    /**
     * Creates a new instance of {@link WeakObjectCache} with the given initial
     * capacity and load factor.
     */
    public WeakObjectCache( ReferenceQueue refQueue, int initialCapacity, float loadFactor ) {

        this( refQueue, initialCapacity, loadFactor, DEFAULT_CONCURRENCY_LEVEL );
    }

    /**
     * Creates a new instance of {@link WeakObjectCache} with the given initial
     * capacity, load factor and concurrency level (see
     * {@link ConcurrentHashMap}} for details).
     */
    public WeakObjectCache( ReferenceQueue refQueue, int initialCapacity, float loadFactor, int concurrencyLevel ) {

        super( refQueue );
        this.cache = new ConcurrentHashMap<K, WeakReferenceWithInfo>( initialCapacity, loadFactor, concurrencyLevel );
    }

    /**
     * Returns an instance of <code>V</code>, identified by the given key
     * components. If the instance can be found in the cache, it is returned.
     * Otherwise, <code>null</code> is returned.
     */
    public V get( K key ) {

        WeakReferenceWithInfo ref = cache.get( key );
        if ( ref != null ) {
            return ref.get( );
        }
        return null;
    }

    /**
     * Returns the current number of objects in the cache. Note that due to the
     * weak and multi-threaded nature of the cache, this information is only a
     * snapshot.
     */
    public int size( ) {

        return cache.size( );
    }

    /**
     * Returns the keys of all objects currently in the cache. Note that the
     * corresponding values might not be valid any more.
     */
    public Set<K> keySet( ) {

        return cache.keySet( );
    }

    /**
     * Inserts the given instance of <code>V</code> into the cache, under the
     * composite key given by the specified key components.
     */
    public V put( K key, V value ) {

        cache.put( key, new WeakReferenceWithInfo( value, key ) );
        return value;
    }

    /**
     * This generic inner class is used for the values in the cache. The weak
     * references "wrap" the objects of type <code>V</code>, and in addition
     * carry the key, to facilitate the removal of stale entries in the
     * {@link #actionOnBeingGarbageCollected(Reference)} method.
     */
    private final class WeakReferenceWithInfo extends WeakReference<V> implements ActionOnBeingGarbageCollectedProvider {

        final K key;

        @SuppressWarnings( "unchecked" )
        WeakReferenceWithInfo( V referent, K key ) {

            super( referent, referenceQueue );
            this.key = key;
        }

        public void actionOnBeingGarbageCollected( Reference reference ) {

            K refKey = ( (WeakReferenceWithInfo) reference ).key;
            synchronized ( cache ) {
                WeakReferenceWithInfo refInCache = cache.get( refKey );
                if ( refInCache != null ) {
                    V valueInCache = refInCache.get( );
                    if ( valueInCache == null ) {
                        // To make sure that not another weak reference was requested for the same key
                        // in the time span between garbage collection and this call, we have to check 
                        // that the referent is really null. Only if there is no more referent the weak 
                        // reference can be removed from the map.
                        cache.remove( refKey );
                    }
                }
            }
        }
    }
}