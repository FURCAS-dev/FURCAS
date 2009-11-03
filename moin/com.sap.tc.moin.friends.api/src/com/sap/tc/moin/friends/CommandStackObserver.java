package com.sap.tc.moin.friends;

import java.util.Collection;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;

/**
 * To be used for integration with platform specific Undo Stacks. <BR>
 * A CommandStackObserver will be notified at the following time points: <BR>
 * <ul>
 * <li>Each time a Top Level {@link Command} is to be execute </li>
 * <li>Each time a new undoable {@link CommandHandle} has been inserted in the
 * top level undo stack. This happens
 * <ul>
 * <li> when a top level Command Group is closed</li>
 * <li> when a top level {@link Command} has been successfully executed </li>
 * <li> when a mutating JMI call has been successfully executed outside a
 * Command and a Command Group</li>
 * </ul>
 * </ul> *
 * 
 * @author d045996
 */
public interface CommandStackObserver {

    /**
     * Called by the CommandStack each time a root {@link Command} is going to
     * be executed. If necessary, the execution can be canceled (vetoed) by
     * throwing a runtime exception, as for example
     * {@link ExecutionCancelledException}. Note that no repository
     * modification is allowed in this call using the same connection. i.e. No
     * command execution neither modifying JMI call.
     * 
     * @param cmd The {@link Command} going to be executed
     * @param affectedPartitions The affected Partitions of the command
     */
    public void notifyBeforeRootCommandExecution( Command cmd, Collection<PartitionOperation> affectedPartitions );

    /**
     * Called by the CommandStack to determine the set of connections which
     * could be saved prior to command execution. The partitions returned by
     * {@link Connection#getPartitionsToBeSaved()} are expected to be an
     * intersection with partitions returned by
     * {@link Command#getAffectedPartitions()}
     * 
     * @param cmd The {@link Command} going to be executed
     * @param affectedPartitions The affected Partitions of the command
     * @return The partitions that are are going to be saved during
     * {@link #notifyBeforeRootCommandExecution(Command, Collection)}
     */
    public Collection<Connection> getConnectionsToBeSaved( Command cmd, Collection<PartitionOperation> affectedPartitions );

    /**
     * Called by the CommandStack whenever a <B>new</B> undoable
     * {@link CommandHandle} is pushed in the top level undo stack (no group
     * open). Note that cmdHnd can be null, when closing an empty CommandGroup!
     * 
     * @param cmdHnd the new {@link CommandHandle}
     * @param con
     */
    public void notifyTopLevelCommandExecuted( CommandHandle cmdHnd, Connection con );

    /**
     * Called by the CommandStack whenever a top level command was undone, i.e.
     * pushed in the top level redo stack (no group open).
     * 
     * @param cmdHnd the undone {@link CommandHandle}
     * @param con
     */
    public void notifyTopLevelCommandUndone( CommandHandle cmdHnd, Connection con );

    /**
     * Called by the CommandStack whenever a top level command is redone, i.e.
     * pushed in the top level undo stack (no group open).
     * 
     * @param cmdHnd the redone {@link CommandHandle}
     * @param con
     */
    public void notifyTopLevelCommandRedone( CommandHandle cmdHnd, Connection con );

    /**
     * Called by the CommandStack whenever undo and redo stacks has been
     * cleaned, either explicit, or as a consequence of
     * {@link Connection#save()} or {@link Connection#revert()}.
     * 
     * @param con
     */
    public void notifyTopLevelStacksCleared( Connection con );

}
