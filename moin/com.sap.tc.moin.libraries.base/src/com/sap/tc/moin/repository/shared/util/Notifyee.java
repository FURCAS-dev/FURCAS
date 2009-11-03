package com.sap.tc.moin.repository.shared.util;

/**
 * The interface to be implemented by a client in order to be notified when
 * a key is made finalizable or has been explicitly removed from the
 * {@link NotifyingWeakHashMap Map}.
 */
public interface Notifyee<K, V> {

    /**
     * This method is called when a key is made finalizable or has been
     * explicitly removed from the {@link NotifyingWeakHashMap Map}. The
     * boolean flag <code>garbageCollected</code> is set to
     * <code>true</code> if the key specified by <code>context</code>
     * has been garbage-collected, otherwise it is set to <code>false</code>.
     * 
     * @param garbageCollected <code>true</code> if the key specified by
     * <code>context</code> has been garbage-collected, otherwise it is
     * set to <code>false</code>
     * @param context the context which identifies the removed key in the
     * view of the client
     */
    public void notifyOnObjectRemoved( boolean garbageCollected, Object context );
}