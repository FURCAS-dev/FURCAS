package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

/**
 * The JMX instrumentation of coding that evicts model partitions from memory.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface EvictionMBean {

    /**
     * The PARTITIONS_EVICTED notification.
     */
    public static final String PARTITIONS_EVICTED = "PARTITIONS_EVICTED"; //$NON-NLS-1$

    /**
     * The EVICT_PARTITION_START notification.
     */
    public static final String EVICT_PARTITION_START = "EVICT_PARTITION_START"; //$NON-NLS-1$

    /**
     * The EVICT_PARTITION_END notification.
     */
    public static final String EVICT_PARTITION_END = "EVICT_PARTITION_END"; //$NON-NLS-1$

    /**
     * All available notifications of this MBean.
     */
    public static final String[] ALL_NOTIFICATION_TYPES = new String[] { PARTITIONS_EVICTED, EVICT_PARTITION_START, EVICT_PARTITION_END };

    /**
     * Starts the eviction trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Starts the eviction trace." )
    public void startNotifications( ) throws IOException;

    /**
     * Returns whether the eviction trace is currently started.
     * 
     * @return whether the eviction trace is currently started
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns whether the eviction trace is currently started." )
    public boolean notificationsStarted( ) throws IOException;

    /**
     * Stops the eviction trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Stops the eviction trace." )
    public void stopNotifications( ) throws IOException;

    /**
     * Triggers an immediate eviction using the current eviction parameters.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Triggers an immediate eviction using the current eviction parameters." )
    public void runEviction( ) throws IOException;

    /**
     * Triggers an immediate eviction using the given maximum age.
     * 
     * @param maximumAge The maximum age of model partitions in milliseconds to
     * use for the eviction run. Must be greater than zero.
     * @throws IllegalArgumentException if the maximum age is negative or zero
     * @throws IOException in case of network communication issues
     */
    @Description( "Triggers an immediate eviction using the given maximum age." )
    public void runEviction( @ParameterName( "maximumAge" ) long maximumAge ) throws IOException; //$NON-NLS$

    /**
     * Returns the interval of periodic eviction runs in milliseconds.
     * 
     * @return the interval of periodic eviction runs in milliseconds
     * @throws IOException in case of network communication issues
     */
    @Description( "The interval of periodic eviction runs, given as milliseconds." )
    public long getEvictionInterval( ) throws IOException;

    /**
     * Sets the interval of periodic eviction runs in milliseconds.
     * 
     * @param evictionInterval the interval of periodic eviction runs in
     * milliseconds
     * @throws IllegalArgumentException if the eviction interval is negative
     * @throws IOException in case of network communication issues
     */
    @Description( "The interval of periodic eviction runs, given as milliseconds." )
    public void setEvictionInterval( @ParameterName( "evictionInterval" ) long evictionInterval ) throws IOException; //$NON-NLS$

    /**
     * Returns the maximum age of a partition in milliseconds. Unmodified
     * partitions older than this are candidates for eviction.
     * 
     * @return the maximum age of a partition in milliseconds
     * @throws IOException in case of network communication issues
     */
    @Description( "The maximum age of a partition in milliseconds. Unmodified partitions older than this are candidates for eviction." )
    public long getMaximumAge( ) throws IOException;

    /**
     * Sets the maximum age of a partition in milliseconds.
     * 
     * @param maximumAge The maximum age of a partition in milliseconds. Must be
     * greater than zero.
     * @throws IllegalArgumentException if the maximum age is negative
     * @throws IOException in case of network communication issues
     */
    @Description( "The maximum age of a partition in milliseconds. Unmodified partitions older than this are candidates for eviction." )
    public void setMaximumAge( @ParameterName( "maximumAge" ) long maximumAge ) throws IOException; //$NON-NLS$
}
