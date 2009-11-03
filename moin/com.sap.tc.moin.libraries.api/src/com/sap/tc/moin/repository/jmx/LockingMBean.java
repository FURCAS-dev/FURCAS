package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

/**
 * The JMX instrumentation of all MOIN coding that acquires and releases locks.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface LockingMBean {

    /**
     * The WRITE_LOCK_OBTAINED notification.
     */
    public static final String WRITE_LOCK_OBTAINED = "WRITE_LOCK_OBTAINED"; //$NON-NLS-1$

    /**
     * The WRITE_LOCK_RELEASED notification.
     */
    public static final String WRITE_LOCK_RELEASED = "WRITE_LOCK_RELEASED"; //$NON-NLS-1$

    /**
     * The READ_LOCK_OBTAINED notification.
     */
    public static final String READ_LOCK_OBTAINED = "READ_LOCK_OBTAINED"; //$NON-NLS-1$

    /**
     * The READ_LOCK_RELEASED notification.
     */
    public static final String READ_LOCK_RELEASED = "READ_LOCK_RELEASED"; //$NON-NLS-1$

    /**
     * The PARTITION_LOCK_OBTAINED notification.
     */
    public static final String PARTITION_LOCK_OBTAINED = "PARTITION_LOCK_OBTAINED"; //$NON-NLS-1$

    /**
     * The PARTITION_LOCK_RELEASED notification.
     */
    public static final String PARTITION_LOCK_RELEASED = "PARTITION_LOCK_RELEASED"; //$NON-NLS-1$

    /**
     * The FACILITIES_LOCK_OBTAINED notification.
     */
    public static final String FACILITIES_LOCK_OBTAINED = "FACILITIES_LOCK_OBTAINED"; //$NON-NLS-1$

    /**
     * The FACILITIES_LOCK_RELEASED notification.
     */
    public static final String FACILITIES_LOCK_RELEASED = "FACILITIES_LOCK_RELEASED"; //$NON-NLS-1$

    /**
     * All available notifications of this MBean.
     */
    public static final String[] ALL_NOTIFICATION_TYPES = new String[] { WRITE_LOCK_OBTAINED, WRITE_LOCK_RELEASED, READ_LOCK_OBTAINED, READ_LOCK_RELEASED, PARTITION_LOCK_OBTAINED, PARTITION_LOCK_RELEASED, FACILITIES_LOCK_OBTAINED, FACILITIES_LOCK_RELEASED };

    /**
     * Starts the lock trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Starts the lock trace." )
    public void startNotifications( ) throws IOException;

    /**
     * Returns whether the lock trace is currently started.
     * 
     * @return whether the lock trace is currently started
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns whether the lock trace is currently started." )
    public boolean notificationsStarted( ) throws IOException;

    /**
     * Stops the lock trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Stops the lock trace." )
    public void stopNotifications( ) throws IOException;
}