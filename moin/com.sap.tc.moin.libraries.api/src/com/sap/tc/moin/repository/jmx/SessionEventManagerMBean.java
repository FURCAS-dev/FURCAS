package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

import javax.management.openmbean.TabularData;

/**
 * The JMX instrumentation of the MOIN event framework.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface SessionEventManagerMBean {

    /**
     * The PRE_ATTRIBUTE_VALUE_ADD notification.
     */
    public static final String PRE_ATTRIBUTE_VALUE_ADD_EVENT = "PRE_ATTRIBUTE_VALUE_ADD"; //$NON-NLS-1$

    /**
     * The ATTRIBUTE_VALUE_ADD notification.
     */
    public static final String ATTRIBUTE_VALUE_ADD_EVENT = "ATTRIBUTE_VALUE_ADD"; //$NON-NLS-1$

    /**
     * The PRE_ATTRIBUTE_VALUE_REMOVE notification.
     */
    public static final String PRE_ATTRIBUTE_VALUE_REMOVE_EVENT = "PRE_ATTRIBUTE_VALUE_REMOVE"; //$NON-NLS-1$

    /**
     * The ATTRIBUTE_VALUE_REMOVE notification.
     */
    public static final String ATTRIBUTE_VALUE_REMOVE_EVENT = "ATTRIBUTE_VALUE_REMOVE"; //$NON-NLS-1$

    /**
     * The PRE_ATTRIBUTE_VALUE_CHANGE notification.
     */
    public static final String PRE_ATTRIBUTE_VALUE_CHANGE_EVENT = "PRE_ATTRIBUTE_VALUE_CHANGE"; //$NON-NLS-1$

    /**
     * The ATTRIBUTE_VALUE_CHANGE notification.
     */
    public static final String ATTRIBUTE_VALUE_CHANGE_EVENT = "ATTRIBUTE_VALUE_CHANGE"; //$NON-NLS-1$

    /**
     * The PRE_ELEMENT_CREATE notification.
     */
    public static final String PRE_ELEMENT_CREATE_EVENT = "PRE_ELEMENT_CREATE"; //$NON-NLS-1$

    /**
     * The ELEMENT_CREATE notification.
     */
    public static final String ELEMENT_CREATE_EVENT = "ELEMENT_CREATE"; //$NON-NLS-1$

    /**
     * The PRE_ELEMENT_DELETE notification.
     */
    public static final String PRE_ELEMENT_DELETE_EVENT = "PRE_ELEMENT_DELETE"; //$NON-NLS-1$

    /**
     * The ELEMENT_DELETE notification.
     */
    public static final String ELEMENT_DELETE_EVENT = "ELEMENT_DELETE"; //$NON-NLS-1$

    /**
     * The PRE_LINK_ADD notification.
     */
    public static final String PRE_LINK_ADD_EVENT = "PRE_LINK_ADD"; //$NON-NLS-1$

    /**
     * The LINK_ADD notification.
     */
    public static final String LINK_ADD_EVENT = "LINK_ADD"; //$NON-NLS-1$

    /**
     * The PRE_LINK_REMOVE notification.
     */
    public static final String PRE_LINK_REMOVE_EVENT = "PRE_LINK_REMOVE"; //$NON-NLS-1$

    /**
     * The LINK_REMOVE notification.
     */
    public static final String LINK_REMOVE_EVENT = "LINK_REMOVE"; //$NON-NLS-1$

    /**
     * The PRE_PARTITION_MEMBERSHIP_CHANGE notification.
     */
    public static final String PRE_PARTITION_MEMBERSHIP_CHANGE_EVENT = "PRE_PARTITION_MEMBERSHIP_CHANGE"; //$NON-NLS-1$

    /**
     * The PARTITION_MEMBERSHIP_CHANGE notification.
     */
    public static final String PARTITION_MEMBERSHIP_CHANGE_EVENT = "PARTITION_MEMBERSHIP_CHANGE"; //$NON-NLS-1$

    /**
     * The PRE_PARTITION_CONTENT_CHANGE notification.
     */
    public static final String PRE_PARTITION_CONTENT_CHANGE_EVENT = "PRE_PARTITION_CONTENT_CHANGE"; //$NON-NLS-1$

    /**
     * The PARTITION_CONTENT_CHANGE notification.
     */
    public static final String PARTITION_CONTENT_CHANGE_EVENT = "PARTITION_CONTENT_CHANGE"; //$NON-NLS-1$

    /**
     * The PRE_PARTITION_CREATE notification.
     */
    public static final String PRE_PARTITION_CREATE_EVENT = "PRE_PARTITION_CREATE"; //$NON-NLS-1$

    /**
     * The PARTITION_CREATE notification.
     */
    public static final String PARTITION_CREATE_EVENT = "PARTITION_CREATE"; //$NON-NLS-1$

    /**
     * The PRE_PARTITION_DELETE notification.
     */
    public static final String PRE_PARTITION_DELETE_EVENT = "PRE_PARTITION_DELETE"; //$NON-NLS-1$

    /**
     * The PARTITION_DELETE notification.
     */
    public static final String PARTITION_DELETE_EVENT = "PARTITION_DELETE"; //$NON-NLS-1$

    /**
     * The PRE_PARTITION_PROPERTY_CHANGE notification.
     */
    public static final String PRE_PARTITION_PROPERTY_CHANGE_EVENT = "PRE_PARTITION_PROPERTY_CHANGE"; //$NON-NLS-1$

    /**
     * The PARTITION_PROPERTY_CHANGE notification.
     */
    public static final String PARTITION_PROPERTY_CHANGE_EVENT = "PARTITION_PROPERTY_CHANGE"; //$NON-NLS-1$

    /**
     * The PRE_PARTITION_SAVE notification.
     */
    public static final String PRE_PARTITION_SAVE_EVENT = "PRE_PARTITION_SAVE"; //$NON-NLS-1$

    /**
     * The PARTITION_SAVE notification.
     */
    public static final String PARTITION_SAVE_EVENT = "PARTITION_SAVE"; //$NON-NLS-1$

    /**
     * All available notifications of this MBean.
     */
    public static final String[] ALL_NOTIFICATION_TYPES = new String[] {
        PRE_ATTRIBUTE_VALUE_ADD_EVENT,
        ATTRIBUTE_VALUE_ADD_EVENT,
        PRE_ATTRIBUTE_VALUE_REMOVE_EVENT,
        ATTRIBUTE_VALUE_REMOVE_EVENT,
        PRE_ATTRIBUTE_VALUE_CHANGE_EVENT,
        ATTRIBUTE_VALUE_CHANGE_EVENT,
        PRE_ELEMENT_CREATE_EVENT,
        ELEMENT_CREATE_EVENT,
        PRE_ELEMENT_DELETE_EVENT,
        ELEMENT_DELETE_EVENT,
        PRE_LINK_ADD_EVENT,
        LINK_ADD_EVENT,
        PRE_LINK_REMOVE_EVENT,
        LINK_REMOVE_EVENT,
        PRE_PARTITION_MEMBERSHIP_CHANGE_EVENT,
        PARTITION_MEMBERSHIP_CHANGE_EVENT,
        PRE_PARTITION_CONTENT_CHANGE_EVENT,
        PARTITION_CONTENT_CHANGE_EVENT,
        PRE_PARTITION_CREATE_EVENT,
        PARTITION_CREATE_EVENT,
        PRE_PARTITION_DELETE_EVENT,
        PARTITION_DELETE_EVENT,
        PRE_PARTITION_PROPERTY_CHANGE_EVENT,
        PARTITION_PROPERTY_CHANGE_EVENT,
        PRE_PARTITION_SAVE_EVENT,
        PARTITION_SAVE_EVENT };

    /**
     * Returns whether eventing is currently turned on for this session.
     * 
     * @return Whether eventing is currently turned on for this session
     * @throws IOException in case of network communication issues
     */
    @Description( "Whether eventing is currently turned on for this session." )
    public boolean getFireEvents( ) throws IOException;

    /**
     * Turn the firing of events on or off for this session.
     * 
     * @param fireEvents whether eventing should be turned on or off
     * @throws IOException in case of network communication issues
     */
    @Description( "Turn the firing of events on or off for this session." )
    public void setFireEvents( boolean fireEvents ) throws IOException;

    /**
     * Returns the current monitoring level. The higher the level, the more
     * information is collected.
     * <p>
     * 0: No info is collected. 1: Basic info about listeners. 2: Count each
     * fired event. 3: Measure listener runtimes.
     * 
     * @return the current monitoring level
     * @throws IOException in case of network communication issues
     */
    @Description( "0: No info is collected. 1: Basic info about listeners. 2: Count each fired event. 3: Measure listener runtimes." )
    public int getMonitoringLevel( ) throws IOException;

    /**
     * Sets the current monitoring level. The higher the level, the more
     * information is collected.
     * <p>
     * 0: No info is collected. 1: Basic info about listeners. 2: Count each
     * fired event. 3: Measure listener runtimes.
     * 
     * @param monitoringLevel the monitoring level to set
     * @throws IOException in case of network communication issues
     */
    @Description( "0: No info is collected. 1: Basic info about listeners. 2: Count each fired event. 3: Measure listener runtimes." )
    public void setMonitoringLevel( int monitoringLevel ) throws IOException;

    /**
     * Returns whether pre-events should be logged as well. Enabling this option
     * approximately doubles the number of logged events.
     * 
     * @return whether pre-events should be logged as well
     * @throws IOException in case of network communication issues
     */
    @Description( "Whether pre-events should be logged as well. Enabling this option approximately doubles the number of logged events." )
    public boolean getLogPreEvents( ) throws IOException;

    /**
     * Sets whether pre-events should be logged as well. Enabling this option
     * approximately doubles the number of logged events.
     * 
     * @param logPreEvents whether pre-events should be logged as well
     * @throws IOException in case of network communication issues
     */
    @Description( "Whether pre-events should be logged as well. Enabling this option approximately doubles the number of logged events." )
    public void setLogPreEvents( boolean logPreEvents ) throws IOException;

    /**
     * Returns the total number of fired events of type AttributeValueAddEvent
     * since the last reset call.
     * 
     * @return the total number of fired events of type AttributeValueAddEvent
     * since the last reset call
     * @throws IOException in case of network communication issues
     */
    @Description( "The total number of fired events of type AttributeValueAddEvent since the last reset call." )
    public int getNumAttributeValueAddEvents( ) throws IOException;

    /**
     * Returns the total number of fired events of type AttributeValueRemove
     * since the last reset call.
     * 
     * @return the total number of fired events of type AttributeValueRemove
     * since the last reset call
     * @throws IOException in case of network communication issues
     */
    @Description( "The total number of fired events of type AttributeValueRemove since the last reset call." )
    public int getNumAttributeValueRemoveEvents( ) throws IOException;

    /**
     * Returns the total number of fired events of type
     * AttributeValueChangeEvent since the last reset call.
     * 
     * @return the total number of fired events of type
     * AttributeValueChangeEvent since the last reset call
     * @throws IOException in case of network communication issues
     */
    @Description( "The total number of fired events of type AttributeValueChangeEvent since the last reset call." )
    public int getNumAttributeValueChangeEvents( ) throws IOException;

    /**
     * Returns the total number of fired events of type ElementCreateEvent since
     * the last reset call.
     * 
     * @return the total number of fired events of type ElementCreateEvent since
     * the last reset call
     * @throws IOException in case of network communication issues
     */
    @Description( "The total number of fired events of type ElementCreateEvent since the last reset call." )
    public int getNumElementCreateEvents( ) throws IOException;

    /**
     * Returns the total number of fired events of type ElementDeleteEvent since
     * the last reset call.
     * 
     * @return the total number of fired events of type ElementDeleteEvent since
     * the last reset call
     * @throws IOException in case of network communication issues
     */
    @Description( "The total number of fired events of type ElementDeleteEvent since the last reset call." )
    public int getNumElementDeleteEvents( ) throws IOException;

    /**
     * Returns the total number of fired events of type LinkAddEvent since the
     * last reset call.
     * 
     * @return the total number of fired events of type LinkAddEvent since the
     * last reset call
     * @throws IOException in case of network communication issues
     */
    @Description( "The total number of fired events of type LinkAddEvent since the last reset call." )
    public int getNumLinkAddEvents( ) throws IOException;

    /**
     * Returns the total number of fired events of type LinkRemoveEvent since
     * the last reset call.
     * 
     * @return the total number of fired events of type LinkRemoveEvent since
     * the last reset call
     * @throws IOException in case of network communication issues
     */
    @Description( "The total number of fired events of type LinkRemoveEvent since the last reset call." )
    public int getNumLinkRemoveEvents( ) throws IOException;

    /**
     * Returns the total number of fired events of type
     * PartitionMembershipChangeEvent since the last reset call.
     * 
     * @return the total number of fired events of type
     * PartitionMembershipChangeEvent since the last reset call
     * @throws IOException in case of network communication issues
     */
    @Description( "The total number of fired events of type PartitionMembershipChangeEvent since the last reset call." )
    public int getNumPartitionMembershipChangeEvents( ) throws IOException;

    /**
     * Returns the total number of fired events of type
     * PartitionContentChangeEvent since the last reset call.
     * 
     * @return the total number of fired events of type
     * PartitionContentChangeEvent since the last reset call
     * @throws IOException in case of network communication issues
     */
    @Description( "The total number of fired events of type PartitionContentChangeEvent since the last reset call." )
    public int getNumPartitionContentChangeEvents( ) throws IOException;

    /**
     * Returns the total number of fired events of type PartitionCreateEvent
     * since the last reset call.
     * 
     * @return the total number of fired events of type PartitionCreateEvent
     * since the last reset call
     * @throws IOException in case of network communication issues
     */
    @Description( "The total number of fired events of type PartitionCreateEvent since the last reset call." )
    public int getNumPartitionCreateEvents( ) throws IOException;

    /**
     * Returns the total number of fired events of type PartitionRemoveEvent
     * since the last reset call.
     * 
     * @return the total number of fired events of type PartitionRemoveEvent
     * since the last reset call
     * @throws IOException in case of network communication issues
     */
    @Description( "The total number of fired events of type PartitionRemoveEvent since the last reset call." )
    public int getNumPartitionRemoveEvents( ) throws IOException;

    /**
     * Returns the total number of fired events of type
     * PartitionPropertyChangeEvent since the last reset call.
     * 
     * @return the total number of fired events of type
     * PartitionPropertyChangeEvent since the last reset call
     * @throws IOException in case of network communication issues
     */
    @Description( "The total number of fired events of type PartitionPropertyChangeEvent since the last reset call." )
    public int getNumPartitionPropertyChangeEvents( ) throws IOException;

    /**
     * Returns the total number of fired events of type PartitionSaveEvent since
     * the last reset call.
     * 
     * @return the total number of fired events of type PartitionSaveEvent since
     * the last reset call
     * @throws IOException in case of network communication issues
     */
    @Description( "The total number of fired events of type PartitionSaveEvent since the last reset call." )
    public int getNumPartitionSaveEvents( ) throws IOException;

    /**
     * Returns various information about all currently registered event
     * listeners.
     * 
     * @return various information about all currently registered event
     * listeners
     * @throws IOException in case of network communication issues
     */
    @Description( "Shows various information about all currently registered event listeners." )
    public TabularData showEventListeners( ) throws IOException;

    /**
     * Resets all event counters.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Resets all event counters." )
    public void resetEventCounters( ) throws IOException;

    /**
     * Starts the translation of MOIN events into JMX notifications.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Starts the translation of MOIN events into JMX notifications." )
    public void startNotifications( ) throws IOException;

    /**
     * Returns whether the event trace is currently started.
     * 
     * @return whether the event trace is currently started
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns whether the event trace is currently started." )
    public boolean notificationsStarted( ) throws IOException;

    /**
     * Stops the translation of MOIN events into JMX notifications.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Stops the translation of MOIN events into JMX notifications." )
    public void stopNotifications( ) throws IOException;
}