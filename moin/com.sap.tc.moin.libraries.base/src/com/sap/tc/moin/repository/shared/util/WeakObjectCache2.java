package com.sap.tc.moin.repository.shared.util;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.sap.tc.moin.repository.shared.util.HousekeepingThread.ActionOnBeingGarbageCollectedProvider;

/**
 * This generic class provides a cache for objects of type <code>V</code>,
 * uniquely identifiable using exactly <em>two</em> key components of types
 * <code>K1, K2</code>.
 * <p>
 * The instances of type <code>T</code> are held weakly.
 */
public class WeakObjectCache2<K1, K2, V> extends AbstractWeakObjectCache {

    private static final ThreadLocal<ObjectKey> threadLocalObjectKey = new ThreadLocal<ObjectKey>( ) {

        @Override
        protected ObjectKey initialValue( ) {

            return new ObjectKey( );
        }
    };

    /**
     * The cache, holding weak references to the cached objects.
     */
    Map<ObjectKey, WeakReferenceWithInfo> cache;

    /**
     * Creates a new instance of {@link WeakObjectCache2} with default values
     * for initial capacity, load factor and concurrency level.
     */
    public WeakObjectCache2( ReferenceQueue refQueue ) {

        this( refQueue, DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL );
    }

    /**
     * Creates a new instance of {@link WeakObjectCache2} with the given initial
     * capacity.
     */
    public WeakObjectCache2( ReferenceQueue refQueue, int initialCapacity ) {

        this( refQueue, initialCapacity, DEFAULT_LOAD_FACTOR, DEFAULT_CONCURRENCY_LEVEL );
    }

    /**
     * Creates a new instance of {@link WeakObjectCache2} with the given initial
     * capacity and load factor.
     */
    public WeakObjectCache2( ReferenceQueue refQueue, int initialCapacity, float loadFactor ) {

        this( refQueue, initialCapacity, loadFactor, DEFAULT_CONCURRENCY_LEVEL );
    }

    /**
     * Creates a new instance of {@link WeakObjectCache2} with the given initial
     * capacity, load factor and concurrency level (see
     * {@link ConcurrentHashMap}} for details).
     */
    public WeakObjectCache2( ReferenceQueue refQueue, int initialCapacity, float loadFactor, int concurrencyLevel ) {

        super( refQueue );
        this.cache = new ConcurrentHashMap<ObjectKey, WeakReferenceWithInfo>( initialCapacity, loadFactor, concurrencyLevel );
    }

    /**
     * Returns an instance of <code>V</code>, identified by the given key
     * components. If the instance can be found in the cache, it is returned.
     * Otherwise, <code>null</code> is returned.
     */
    @SuppressWarnings( "unchecked" )
    public V get( K1 key1, K2 key2 ) {

        ObjectKey<K1, K2> objKey = threadLocalObjectKey.get( );
        objKey.key1 = key1;
        objKey.key2 = key2;
        objKey.computeHashCode( );
        WeakReferenceWithInfo ref = cache.get( objKey );
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
     * Inserts the given instance of <code>V</code> into the cache, under the
     * composite key given by the specified key components.
     */
    public V put( K1 key1, K2 key2, V value ) {

        ObjectKey<K1, K2> objKey = new ObjectKey<K1, K2>( key1, key2 );
        cache.put( objKey, new WeakReferenceWithInfo( value, objKey ) );
        return value;
    }

    /**
     * This generic inner class is used for the keys of all cache entries.
     */
    private static final class ObjectKey<K1, K2> {

        K1 key1;

        K2 key2;

        private int hashCode;

        ObjectKey( ) {

        }

        ObjectKey( K1 key1, K2 key2 ) {

            this.key1 = key1;
            this.key2 = key2;
            computeHashCode( );
        }

        @Override
        public boolean equals( Object obj ) {

            if ( this == obj ) {
                return true;
            }
            if ( obj instanceof ObjectKey ) {
                ObjectKey otherObj = (ObjectKey) obj;
                return key1.equals( otherObj.key1 ) && key2.equals( otherObj.key2 );
            }
            return false;
        }

        @Override
        public int hashCode( ) {

            return hashCode;
        }

        void computeHashCode( ) {

            hashCode = 37 * 17 + key1.hashCode( );
            hashCode = 37 * hashCode + key2.hashCode( );
        }
    }

    /**
     * This generic inner class is used for the values in the cache. The weak
     * references "wrap" the objects of type <code>V</code>, and in addition
     * carry the key, to facilitate the removal of stale entries in the
     * {@link #actionOnBeingGarbageCollected(Reference)} method.
     */
    private final class WeakReferenceWithInfo extends WeakReference<V> implements ActionOnBeingGarbageCollectedProvider {

        final ObjectKey<K1, K2> key;

        @SuppressWarnings( { "unchecked" } )
        WeakReferenceWithInfo( V referent, ObjectKey key ) {

            super( referent, referenceQueue );
            this.key = key;
        }

        public void actionOnBeingGarbageCollected( Reference reference ) {

            ObjectKey<K1, K2> refKey = ( (WeakReferenceWithInfo) reference ).key;
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