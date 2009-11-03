package com.sap.tc.moin.repository.shared.util;

import java.lang.ref.ReferenceQueue;

public abstract class AbstractWeakObjectCache {

    /**
     * The reference queue used for the cleanup of stale cache entries.
     */
    protected final ReferenceQueue referenceQueue;

    /**
     * The cache's default initial capacity.
     */
    protected static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * The cache's default load factor.
     */
    protected static final float DEFAULT_LOAD_FACTOR = 0.9f;

    /**
     * The cache's default concurrency level (see
     * {@link java.util.concurrent.ConcurrentHashMap} for details).
     */
    protected static final int DEFAULT_CONCURRENCY_LEVEL = 16;

    protected AbstractWeakObjectCache( ReferenceQueue refQueue ) {

        this.referenceQueue = refQueue;
    }
}