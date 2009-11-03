package com.sap.tc.moin.repository.jmx;

import java.io.IOException;

import com.sap.tc.moin.repository.commands.CommandStack;

/**
 * The JMX instrumentation of {@link CommandStack} instances in MOIN.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface CommandStackMBean {

    /**
     * The COMMAND_GROUP_OPEN notification.
     */
    public static final String COMMAND_GROUP_OPEN = "COMMAND_GROUP_OPEN"; //$NON-NLS-1$

    /**
     * The COMMAND_GROUP_CLOSE notification.
     */
    public static final String COMMAND_GROUP_CLOSE = "COMMAND_GROUP_CLOSE"; //$NON-NLS-1$

    /**
     * The COMMAND_EXECUTE_START notification.
     */
    public static final String COMMAND_EXECUTE_START = "COMMAND_EXECUTE_START"; //$NON-NLS-1$

    /**
     * The COMMAND_EXECUTE_END notification.
     */
    public static final String COMMAND_EXECUTE_END = "COMMAND_EXECUTE_END"; //$NON-NLS-1$

    /**
     * The COMMAND_UNDO_START notification.
     */
    public static final String COMMAND_UNDO_START = "COMMAND_UNDO_START"; //$NON-NLS-1$

    /**
     * The COMMAND_UNDO_END notification.
     */
    public static final String COMMAND_UNDO_END = "COMMAND_UNDO_END"; //$NON-NLS-1$

    /**
     * The COMMAND_REDO_START notification.
     */
    public static final String COMMAND_REDO_START = "COMMAND_REDO_START"; //$NON-NLS-1$

    /**
     * The COMMAND_REDO_END notification.
     */
    public static final String COMMAND_REDO_END = "COMMAND_REDO_END"; //$NON-NLS-1$

    /**
     * All available notifications of this MBean.
     */
    public static final String[] ALL_NOTIFICATION_TYPES = new String[] { COMMAND_GROUP_OPEN, COMMAND_GROUP_CLOSE, COMMAND_EXECUTE_START, COMMAND_EXECUTE_END, COMMAND_UNDO_START, COMMAND_UNDO_END, COMMAND_REDO_START, COMMAND_REDO_END };

    /**
     * Shows the stack of currently open command groups (latest entry on top).
     * 
     * @return an array of command group descriptions
     * @throws IOException in case of network communication issues
     */
    @Description( "Shows the stack of currently open command groups (latest entry on top)." )
    public String[] getCommandGroupStack( ) throws IOException;

    /**
     * Shows the commands currently on the undo stack (latest entry on top).
     * 
     * @return an array of command descriptions
     * @throws IOException in case of network communication issues
     */
    @Description( "Shows the commands currently on the undo stack (latest entry on top)." )
    public String[] getCommandsOnUndoStack( ) throws IOException;

    /**
     * Shows the commands currently on the redo stack (latest entry on top).
     * 
     * @return an array of command descriptions
     * @throws IOException in case of network communication issues
     */
    @Description( "Shows the commands currently on the redo stack (latest entry on top)." )
    public String[] getCommandsOnRedoStack( ) throws IOException;

    /**
     * Starts the command trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Starts the command trace." )
    public void startNotifications( ) throws IOException;

    /**
     * Returns whether the command trace is currently started.
     * 
     * @return whether the command trace is currently started
     * @throws IOException in case of network communication issues
     */
    @Description( "Returns whether the command trace is currently started." )
    public boolean notificationsStarted( ) throws IOException;

    /**
     * Stops the command trace.
     * 
     * @throws IOException in case of network communication issues
     */
    @Description( "Stops the command trace." )
    public void stopNotifications( ) throws IOException;
}