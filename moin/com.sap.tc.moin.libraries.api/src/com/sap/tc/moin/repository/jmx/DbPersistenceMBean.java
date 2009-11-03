package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

/**
 * The JMX instrumentation of the database persistence.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface DbPersistenceMBean {

    /**
     * The SELECT notification.
     */
    public static final String SELECT = "SELECT"; //$NON-NLS-1$

    /**
     * The UPDATE notification.
     */
    public static final String UPDATE = "UPDATE"; //$NON-NLS-1$

    /**
     * The INSERT notification.
     */
    public static final String INSERT = "INSERT"; //$NON-NLS-1$

    /**
     * The DELETE notification.
     */
    public static final String DELETE = "DELETE"; //$NON-NLS-1$

    /**
     * The BATCH_ADD notification.
     */
    public static final String BATCH_ADDITION = "BATCH_ADD"; //$NON-NLS-1$

    /**
     * The BATCH_EXECUTE notification.
     */
    public static final String BATCH_EXECUTE = "BATCH_EXECUTE"; //$NON-NLS-1$

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
     * The REMOVE_PARTITION_START notification.
     */
    public static final String REMOVE_PARTITION_START = "REMOVE_PARTITION_START"; //$NON-NLS-1$

    /**
     * The REMOVE_PARTITION_END notification.
     */
    public static final String REMOVE_PARTITION_END = "REMOVE_PARTITION_END"; //$NON-NLS-1$

    /**
     * The COPY_PARTITION_START notification.
     */
    public static final String COPY_PARTITION_START = "COPY_PARTITION_START"; //$NON-NLS-1$

    /**
     * The COPY_PARTITION_END notification.
     */
    public static final String COPY_PARTITION_END = "COPY_PARTITION_END"; //$NON-NLS-1$

    /**
     * The MOVE_PARTITION_START notification.
     */
    public static final String MOVE_PARTITION_START = "MOVE_PARTITION_START"; //$NON-NLS-1$

    /**
     * The MOVE_PARTITION_END notification.
     */
    public static final String MOVE_PARTITION_END = "MOVE_PARTITION_END"; //$NON-NLS-1$

    /**
     * All available notifications of this MBean.
     */
    public static final String[] ALL_NOTIFICATION_TYPES = new String[] {
        SELECT,
        UPDATE,
        INSERT,
        DELETE,
        BATCH_ADDITION,
        BATCH_EXECUTE,
        LOAD_PARTITION_START,
        LOAD_PARTITION_END,
        STORE_PARTITION_START,
        STORE_PARTITION_END,
        REMOVE_PARTITION_START,
        REMOVE_PARTITION_END,
        COPY_PARTITION_START,
        COPY_PARTITION_END,
        MOVE_PARTITION_START,
        MOVE_PARTITION_END };

    /**
     * Returns whether batch additions should be traced as well. Setting this to
     * true will result in much more notifications being sent.
     * 
     * @return whether batch additions should be traced as well
     */
    @Description( "Whether batch additions should be traced as well. Setting this to true will result in much more notifications being sent." )
    public boolean getTraceBatchAdditions( );

    /**
     * Returns the type of the database.
     * 
     * @return the type of the database
     */
    @Description( "The type of the database." )
    public String getDatabaseType( );

    /**
     * Returns the database user.
     * 
     * @return the database user
     */
    @Description( "The database user." )
    public String getDatabaseUser( );

    /**
     * Returns the database user's password.
     * 
     * @return the database user's password
     */
    @Description( "The database user's password." )
    public String getDatabasePassword( );

    /**
     * Returns the JDBC driver class.
     * 
     * @return the JDBC driver class
     */
    @Description( "The JDBC driver class." )
    public String getJdbcDriver( );

    /**
     * Returns the JDBC URL used for connections.
     * 
     * @return the JDBC URL used for connections
     */
    @Description( "The JDBC URL used for connections." )
    public String getJdbcUrl( );

    /**
     * Toggles whether batch additions should be traced as well. Setting this to
     * true will result in much more notifications being sent.
     * 
     * @param traceBatchAdditions whether batch additions should be traced as
     * well
     */
    @Description( "Whether batch additions should be traced as well. Setting this to true will result in much more notifications being sent." )
    public void setTraceBatchAdditions( boolean traceBatchAdditions );

    /**
     * Returns the configuration properties of this DbPersistence instance.
     * 
     * @return the configuration properties of this DbPersistence instance
     * @throws IOException in case of network communication issues
     */
    @Description( "Shows the configuration properties of this DbPersistence instance." )
    public String showConfiguration( ) throws IOException;

    /**
     * Starts the translation of SQL statements and partition events into JMX
     * notifications.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Starts the translation of SQL statements and partition events into JMX notifications." )
    public void startNotifications( ) throws IOException;

    /**
     * Returns whether the SQL trace is currently started.
     * 
     * @return Returns whether the SQL trace is currently started
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns whether the SQL trace is currently started." )
    public boolean notificationsStarted( ) throws IOException;

    /**
     * Stops the translation of SQL statements and partition events into JMX
     * notifications.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Stops the translation of SQL statements and partition events into JMX notifications." )
    public void stopNotifications( ) throws IOException;
}