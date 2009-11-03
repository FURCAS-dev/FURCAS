package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

/**
 * The JMX instrumentation of the MOIN logger.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MoinLoggerMBean {

    /**
     * The FATAL notification.
     */
    public static final String LOG_ENTRY_FATAL = "FATAL"; //$NON-NLS-1$

    /**
     * The ERROR notification.
     */
    public static final String LOG_ENTRY_ERROR = "ERROR"; //$NON-NLS-1$

    /**
     * The WARNING notification.
     */
    public static final String LOG_ENTRY_WARNING = "WARNING"; //$NON-NLS-1$

    /**
     * The INFO notification.
     */
    public static final String LOG_ENTRY_INFO = "INFO"; //$NON-NLS-1$

    /**
     * The PATH notification.
     */
    public static final String LOG_ENTRY_PATH = "PATH"; //$NON-NLS-1$

    /**
     * The DEBUG notification.
     */
    public static final String LOG_ENTRY_DEBUG = "DEBUG"; //$NON-NLS-1$

    /**
     * All available notifications of this MBean.
     */
    public static final String[] ALL_NOTIFICATION_TYPES = new String[] { LOG_ENTRY_FATAL, LOG_ENTRY_ERROR, LOG_ENTRY_WARNING, LOG_ENTRY_INFO, LOG_ENTRY_PATH, LOG_ENTRY_DEBUG };

    /**
     * Returns all logging categories currently in use.
     * 
     * @return all logging categories currently in use
     * @throws IOException in case of network communication issues
     */
    @Description( "All logging categories currently in use." )
    public String[] getCategories( ) throws IOException;

    /**
     * Returns all logging locations currently in use.
     * 
     * @return all logging locations currently in use
     * @throws IOException in case of network communication issues
     */
    @Description( "All logging locations currently in use." )
    public String[] getLocations( ) throws IOException;

    /**
     * Starts the logger trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Starts the logger trace." )
    public void startNotifications( ) throws IOException;

    /**
     * Returns whether the logger trace is currently started.
     * 
     * @return whether the logger trace is currently started
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns whether the logger trace is currently started." )
    public boolean notificationsStarted( ) throws IOException;

    /**
     * Stops the logger trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Stops the logger trace." )
    public void stopNotifications( ) throws IOException;
}