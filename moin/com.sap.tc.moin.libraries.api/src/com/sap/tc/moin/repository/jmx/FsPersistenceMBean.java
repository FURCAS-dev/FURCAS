package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

import javax.management.openmbean.TabularData;

/**
 * The JMX instrumentation of the filesystem persistence.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface FsPersistenceMBean {

    /**
     * The LOAD_PARTITION_START notification.
     */
    public static final String LOAD_PARTITION_START = "LOAD_PARTITION_START"; //$NON-NLS-1$

    /**
     * The LOAD_PARTITION_END notification.
     */
    public static final String LOAD_PARTITION_END = "LOAD_PARTITION_END"; //$NON-NLS-1$

    /**
     * The STORE_PARTITION_START notification.
     */
    public static final String STORE_PARTITION_START = "STORE_PARTITION_START"; //$NON-NLS-1$

    /**
     * The STORE_PARTITION_END notification.
     */
    public static final String STORE_PARTITION_END = "STORE_PARTITION_END"; //$NON-NLS-1$

    /**
     * The LOAD_TEXT_FILE_START notification.
     */
    public static final String LOAD_TEXT_FILE_START = "LOAD_TEXT_FILE_START"; //$NON-NLS-1$

    /**
     * The LOAD_TEXT_FILE_END notification.
     */
    public static final String LOAD_TEXT_FILE_END = "LOAD_TEXT_FILE_END"; //$NON-NLS-1$

    /**
     * The STORE_TEXT_FILE_START notification.
     */
    public static final String STORE_TEXT_FILE_START = "STORE_TEXT_FILE_START"; //$NON-NLS-1$

    /**
     * The STORE_TEXT_FILE_END notification.
     */
    public static final String STORE_TEXT_FILE_END = "STORE_TEXT_FILE_END"; //$NON-NLS-1$

    /**
     * All available notifications of this MBean.
     */
    public static final String[] ALL_NOTIFICATION_TYPES = new String[] { LOAD_PARTITION_START, //
        LOAD_PARTITION_END,
        STORE_PARTITION_START,
        STORE_PARTITION_END,
        LOAD_TEXT_FILE_START,
        LOAD_TEXT_FILE_END,
        STORE_TEXT_FILE_START,
        STORE_TEXT_FILE_END };

    /**
     * Returns the currently registered storages.
     * 
     * @return the currently registered storages
     * @throws IOException in case of network communication issues
     */
    @Description( "The currently registered storages." )
    public TabularData getStorages( ) throws IOException;

    /**
     * Returns the content of a given partition.
     * 
     * @param priString the PRI String of the partition
     * @return the content of the given partition as {@link String}
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns detail information about the given partition." )
    public String getPartitionContent( @ParameterName( "priString" ) String priString ) throws IOException; //$NON-NLS$

    /**
     * Returns the content of the file containing the translatable texts of the
     * given partition.
     * 
     * @param priString the PRI String of the partition
     * @return the content of the file containing the translatable texts of the
     * given partition as {@link String}
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the content of the file containing the translatable texts of the given partition." )
    public String getPartitionTexts( @ParameterName( "priString" ) String priString ) throws IOException; //$NON-NLS$

    /**
     * Starts the filesystem trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Starts the filesystem trace." )
    public void startNotifications( ) throws IOException;

    /**
     * Returns whether the filesystem trace is currently started.
     * 
     * @return whether the filesystem trace is currently started
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns whether the filesystem trace is currently started." )
    public boolean notificationsStarted( ) throws IOException;

    /**
     * Stops the filesystem trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Stops the filesystem trace." )
    public void stopNotifications( ) throws IOException;
}