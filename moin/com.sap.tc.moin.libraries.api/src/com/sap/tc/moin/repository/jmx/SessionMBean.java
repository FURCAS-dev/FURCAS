package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.ocl.OclRegistryService;

/**
 * The JMX instrumentation of {@link Session} instances.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface SessionMBean {

    /**
     * The CONSISTENCY_VIOLATION_OCCURED notification.
     */
    public static final String CONSISTENCY_VIOLATION_OCCURED = "CONSISTENCY_VIOLATION_OCCURED"; //$NON-NLS-1$

    /**
     * The CONSISTENCY_VIOLATION_FIXED notification.
     */
    public static final String CONSISTENCY_VIOLATION_FIXED = "CONSISTENCY_VIOLATION_FIXED"; //$NON-NLS-1$

    /**
     * All available notifications of this MBean.
     */
    public static final String[] ALL_NOTIFICATION_TYPES = new String[] { CONSISTENCY_VIOLATION_OCCURED, CONSISTENCY_VIOLATION_FIXED };

    /**
     * Returns the PRI Strings of all partitions currently loaded in this
     * session.
     * 
     * @return an array of PRI Strings of all partitions currently loaded in
     * this session
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns the PRI Strings of all partitions currently loaded in this session." )
    public String[] getLoadedPartitions( ) throws IOException;

    /**
     * Returns a summary of all currently loaded partitions in this session and
     * details about them.
     * 
     * @return a String containing a summary of all currently loaded partitions
     * in this session and details about them
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns a summary of all currently loaded partitions in this session and details about them." )
    public String showSummaryOfLoadedPartitions( ) throws IOException;

    /**
     * Returns the current list of consistency violations.
     * 
     * @return an array of String representations of the current consistency
     * violations
     * @throws IOException in case of network communication issues
     */
    @Description( "The current list of consistency violations." )
    public String[] getAllConsistencyViolations( ) throws IOException;

    /**
     * Returns the current list of consistency listeners.
     * 
     * @return an array of String representations of the current consistency
     * listeners
     * @throws IOException in case of network communication issues
     */
    @Description( "The current list of consistency listeners." )
    public String[] getAllConsistencyListeners( ) throws IOException;

    /**
     * Initializes the {@link OclRegistryService} of the session (if not already
     * done), which in turn results in the creation of the corresponding
     * {@link OclRegistryServiceMBean}.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Initializes the OclRegistryService of the session, if not already done." )
    public void initializeOclRegistryService( ) throws IOException;

    /**
     * Starts the consistency violation trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Starts the consistency violation trace." )
    public void startNotifications( ) throws IOException;

    /**
     * Returns whether the consistency violation trace is currently started.
     * 
     * @return whether the consistency violation trace is currently started
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns whether the consistency violation trace is currently started." )
    public boolean notificationsStarted( ) throws IOException;

    /**
     * Stops the consistency violation trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Stops the consistency violation trace." )
    public void stopNotifications( ) throws IOException;
}