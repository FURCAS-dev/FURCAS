package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

import javax.management.openmbean.TabularData;

/**
 * The JMX instrumentation of the OCL infrastructure.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface OclRegistryServiceMBean {

    /**
     * The VERIFY_MOF_CONSTRAINTS_START notification.
     */
    public static final String VERIFY_MOF_CONSTRAINTS_START = "VERIFY_MOF_CONSTRAINTS_START"; //$NON-NLS-1$

    /**
     * The VERIFY_MOF_CONSTRAINTS_END notification.
     */
    public static final String VERIFY_MOF_CONSTRAINTS_END = "VERIFY_MOF_CONSTRAINTS_END"; //$NON-NLS-1$

    /**
     * The VERIFY_CONSTRAINTS_START notification.
     */
    public static final String VERIFY_CONSTRAINTS_START = "VERIFY_CONSTRAINTS_START"; //$NON-NLS-1$

    /**
     * The VERIFY_CONSTRAINTS_END notification.
     */
    public static final String VERIFY_CONSTRAINTS_END = "VERIFY_CONSTRAINTS_END"; //$NON-NLS-1$

    /**
     * The RESET_COLLECTED_EVENTS notification.
     */
    public static final String RESET_COLLECTED_EVENTS = "RESET_COLLECTED_EVENTS"; //$NON-NLS-1$

    /**
     * The ANALYZE_COLLECTED_EVENTS_START notification.
     */
    public static final String ANALYZE_COLLECTED_EVENTS_START = "ANALYZE_COLLECTED_EVENTS_START"; //$NON-NLS-1$

    /**
     * The ANALYZE_COLLECTED_EVENTS_END notification.
     */
    public static final String ANALYZE_COLLECTED_EVENTS_END = "ANALYZE_COLLECTED_EVENTS_END"; //$NON-NLS-1$

    /**
     * The ANALYZE_PARTITIONS_START notification.
     */
    public static final String ANALYZE_PARTITIONS_START = "ANALYZE_PARTITIONS_START"; //$NON-NLS-1$

    /**
     * The ANALYZE_PARTITIONS_END notification.
     */
    public static final String ANALYZE_PARTITIONS_END = "ANALYZE_PARTITIONS_END"; //$NON-NLS-1$

    /**
     * The CONSTRAINT_VIOLATIONS_DETECTED notification.
     */
    public static final String CONSTRAINT_VIOLATIONS_DETECTED = "CONSTRAINT_VIOLATIONS_DETECTED"; //$NON-NLS-1$

    /**
     * All available notifications of this MBean.
     */
    public static final String[] ALL_NOTIFICATION_TYPES = new String[] {
        VERIFY_MOF_CONSTRAINTS_START,
        VERIFY_MOF_CONSTRAINTS_END,
        VERIFY_CONSTRAINTS_START,
        VERIFY_CONSTRAINTS_END,
        RESET_COLLECTED_EVENTS,
        ANALYZE_COLLECTED_EVENTS_START,
        ANALYZE_COLLECTED_EVENTS_END,
        ANALYZE_PARTITIONS_START,
        ANALYZE_PARTITIONS_END,
        CONSTRAINT_VIOLATIONS_DETECTED };

    /**
     * Starts the OCL trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Starts the OCL trace." )
    public void startNotifications( ) throws IOException;

    /**
     * Returns whether the OCL trace is currently started.
     * 
     * @return whether the OCL trace is currently started
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns whether the OCL trace is currently started." )
    public boolean notificationsStarted( ) throws IOException;

    /**
     * Stops the OCL trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Stops the OCL trace." )
    public void stopNotifications( ) throws IOException;

    /**
     * Returns detailed information about all available MOF constraints.
     * 
     * @return detailed information about all available MOF constraints
     * @throws IOException in case of network communication issues
     */
    @Description( "Detailed information about all available MOF constraints." )
    public TabularData getAvailableMofConstraints( ) throws IOException;

    /**
     * Returns a summary of all available MOF constraints and details about
     * them.
     * 
     * @return a summary of all available MOF constraints and details about them
     * @throws IOException in case of network communication issues
     */
    @Description( "Displays a summary of all available MOF constraints and details about them." )
    public String showSummaryOfAvailableMofConstraints( ) throws IOException;

    /**
     * Returns detailed information about all available metamodel constraints.
     * 
     * @return detailed information about all available metamodel constraints
     * @throws IOException in case of network communication issues
     */
    @Description( "Detailed information about all available metamodel constraints." )
    public TabularData getAvailableMetamodelConstraints( ) throws IOException;

    /**
     * Returns a summary of all available metamodel constraints and details
     * about them.
     * 
     * @return a summary of all available metamodel constraints and details
     * about them
     * @throws IOException in case of network communication issues
     */
    @Description( "Displays a summary of all available metamodel constraints and details about them." )
    public String showSummaryOfAvailableMetamodelConstraints( ) throws IOException;

    /**
     * Returns the number of collected change events relevant for immediate
     * constraints.
     * 
     * @return the number of collected change events relevant for immediate
     * constraints
     */
    @Description( "The number of collected change events relevant for immediate constraints." )
    public int getMofConstraintsCollectedEventsImmediate( );

    /**
     * Returns the number of collected change events relevant for deferred
     * constraints.
     * 
     * @return the number of collected change events relevant for deferred
     * constraints
     */
    @Description( "The number of collected change events relevant for deferred constraints." )
    public int getMofConstraintsCollectedEventsDeferred( );

    /**
     * Returns the collected change events relevant for immediate constraints.
     * 
     * @return the collected change events relevant for immediate constraints
     */
    @Description( "Displays the collected change events relevant for immediate constraints." )
    public String showMofConstraintsCollectedEventsImmediate( );

    /**
     * Returns the collected change events relevant for deferred constraints.
     * 
     * @return the collected change events relevant for deferred constraints
     */
    @Description( "Displays the collected change events relevant for deferred constraints." )
    public String showMofConstraintsCollectedEventsDeferred( );

//  @Description( "Returns all registered constraint violation listeners in the OclFreestyleRegistry for immediate constraints." )
//  public TabularData getFreestyleImmediateListeners( );

//  @Description( "Returns all registered partition-based constraint violation listeners in the OclFreestyleRegistry for deferred constraints." )
//  public TabularData getFreestylePartitionListeners( );

//  @Description( "Returns all registered event-based constraint violation listeners in the OclFreestyleRegistry for deferred constraints." )
//  public TabularData getFreestyleEventListeners( );
}