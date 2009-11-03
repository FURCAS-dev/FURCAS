package com.sap.tc.moin.repository.core;

import com.sap.tc.moin.repository.PRI;



public interface EvictionThread extends Runnable {

    public void register( CorePartitionManager partitionManager );

    public void unregister( CorePartitionManager partitionManager );

    public void setJmxTraceEnabled( boolean enabled );

    public boolean isJmxTraceEnabled( );

    public long getEvictionInterval( );

    public long getMaximumAge( );

    /**
     * Sets the value of <code>evictionInterval</code>.
     */
    public void setEvictionInterval( long evictionInterval );

    /**
     * Sets the value of <code>maximumAge</code>.
     */
    public void setMaximumAge( long maximumAge );

    public void runEviction( );

    public void runEviction( long maxAge );

    /**
     * Forwards the information about the end of an eviction run to our MBean,
     * which in turn emits a JMX notification.
     */
    public void tracePartitionsEvicted( EvictionInfo[] partitionsEvicted, boolean triggeredExplicitly, long duration );

    /**
     * Forwards the information about the start of the eviction of a partition
     * to our MBean, which in turn emits a JMX notification.
     */
    public void traceEvictPartitionStart( PRI pri, String sessionId, StackTraceElement[] stackTrace );

    /**
     * Forwards the information about the start of the eviction of a partition
     * to our MBean, which in turn emits a JMX notification.
     */
    public void traceEvictPartitionEnd( PRI pri, String sessionId, int elements, int links, long duration );

    public void requestShutdown( );

    public static final class EvictionInfo {

        public final PRI pri;

        public final String sessionId;

        public final int elements;

        public final int links;

        public EvictionInfo( PRI pri, String sessionId, int elements, int links ) {

            this.pri = pri;
            this.sessionId = sessionId;
            this.elements = elements;
            this.links = links;
        }
    }

}