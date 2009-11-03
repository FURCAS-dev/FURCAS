package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

import javax.management.openmbean.CompositeData;

/**
 * The JMX instrumentation of the index.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IndexMBean {

    /**
     * The INDEX_ADD notification.
     */
    public static final String INDEX_ADD = "INDEX_ADD"; //$NON-NLS-1$

    /**
     * The INDEX_UPDATE notification.
     */
    public static final String INDEX_UPDATE = "INDEX_UPDATE"; //$NON-NLS-1$

    /**
     * The INDEX_DELETE notification.
     */
    public static final String INDEX_DELETE = "INDEX_DELETE"; //$NON-NLS-1$

    /**
     * The INDEX_ERROR notification.
     */
    public static final String INDEX_ERROR = "INDEX_ERROR"; //$NON-NLS-1$

    /**
     * All available notifications of this MBean.
     */
    public static final String[] ALL_NOTIFICATION_TYPES = new String[] { INDEX_ADD, INDEX_UPDATE, INDEX_DELETE, INDEX_ERROR };

    /**
     * Starts the index trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Starts the index trace." )
    public void startNotifications( ) throws IOException;

    /**
     * Returns whether the index trace is currently started.
     * 
     * @return whether the index trace is currently started
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns whether the index trace is currently started." )
    public boolean notificationsStarted( ) throws IOException;

    /**
     * Stops the index trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Stops the index trace." )
    public void stopNotifications( ) throws IOException;

    /**
     * Triggers a full consistency check.
     * 
     * @return whether the consistency checks actually has been performed or not
     * @throws IllegalStateException in case of inconsistencies
     * @throws IOException in case of network communication issues
     */
    @Description( "Triggers a full consistency check." )
    public boolean doSanityCheck( ) throws IOException;

    /**
     * Returns all currently indexed model partitions.
     * 
     * @return all currently indexed model partitions as an array of PRI Strings
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns information about all partitions currently contained in the index." )
    public String[] getIndexedPartitions( ) throws IOException;

    /**
     * Returns the current number of indexed model elements.
     * 
     * @return the current number of indexed model elements
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the current number of indexed model elements." )
    public int getNumberOfIndexedModelElements( ) throws IOException;

    /**
     * Returns the current number of indexed links.
     * 
     * @return the current number of indexed links
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the current number of indexed links." )
    public int getNumberOfIndexedLinkRecords( ) throws IOException;

    /**
     * Returns detail information about the given partition.
     * 
     * @param priString the PRI String of the partition in question
     * @return a CompositeData instance containing the numbers of indexed model
     * elements and links for the given partition
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns detail information about the given partition." )
    public CompositeData getIndexedPartitionDetails( @ParameterName( "priString" ) String priString ) throws IOException; //$NON-NLS$

    /**
     * Returns all indexed model elements in the given partition.
     * 
     * @param priString the PRI String of the partition in question
     * @return an array of MRI Strings of all indexed model elements in the
     * given partition
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns all indexed model elements in the given partition." )
    public String[] getIndexedModelElements( @ParameterName( "priString" ) String priString ) throws IOException; //$NON-NLS$

    /**
     * Returns all indexed links in the given partition.
     * 
     * @param priString the PRI String of the partition in question
     * @return an array of String representations of all indexed links in the
     * given partition
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns all indexed links in the given partition." )
    public String[] getIndexedLinks( @ParameterName( "priString" ) String priString ) throws IOException; //$NON-NLS$
}
