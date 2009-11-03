/**
 * 
 */
package com.sap.tc.moin.repository.commands;

import java.util.List;

import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.exception.ExecutionRollbackFailedException;
import com.sap.tc.moin.repository.exception.UnrecoverableExecutionException;

/**
 * Executes, undoes and redoes {@link Command}s and command groups. Command
 * stacks are related to a {@link com.sap.tc.moin.repository.Connection}, and
 * can be obtained with the
 * {@link com.sap.tc.moin.repository.Connection#getCommandStack()}. Note that
 * event though the command stack is used to execute sub commands, only top
 * level commands are stored in the undo and redo stack. Note that saving and
 * reverting a {@link com.sap.tc.moin.repository.Connection} produces a cleaning
 * of the undo and redo stacks.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author D045996
 */
public interface CommandStack {

    /**
     * Executes the given command, and puts their corresponding
     * {@link CommandHandle} in the undo stack after cleaning the redo stack. If
     * during the execution of the command a RuntimeException is thrown, partial
     * modifications will be rolled back, and the exception will be re-thrown.
     * If the rollback can not be completed, then an
     * {@link ExecutionRollbackFailedException} will be thrown.
     * 
     * @return a CommandHandle that represents the executed command
     * @param command
     * @throws UnrecoverableExecutionException
     * @throws ExecutionCancelledException
     * @throws RuntimeException with rollback semantic
     */
    public CommandHandle execute( Command command ) throws ExecutionCancelledException, UnrecoverableExecutionException, RuntimeException;

    /**
     * @return true if there is at least one command in the undo stack
     */
    public boolean canUndo( );

    /**
     * Performs an undo operation of the command on top of the undo stack, and
     * puts it in the redo stack. If during the execution of the undo a
     * RuntimeException is thrown, partial modifications will be rolled back,
     * and the exception will be re-thrown. If the rollback can not be
     * completed, then an {@link ExecutionRollbackFailedException} will be
     * thrown.
     * 
     * @throws UnrecoverableExecutionException
     * @throws ExecutionCancelledException
     * @throws RuntimeException with rollback semantic
     */
    public void undo( ) throws ExecutionCancelledException, UnrecoverableExecutionException, RuntimeException;

    /**
     * @return true if there is at least one command in the redo stack
     */
    public boolean canRedo( );

    /**
     * Performs a redo operation of the command on the top of the redo stack,
     * and puts it back in the undo stack. If during the execution of the undo a
     * RuntimeException is thrown, partial moddifications will be rolledback,
     * and the exception will be re-thrown. If the rollback can not be
     * completed, then an {@link ExecutionRollbackFailedException} will be
     * thrown.
     * 
     * @throws UnrecoverableExecutionException
     * @throws ExecutionCancelledException
     * @throws RuntimeException with rollback semantic
     */
    public void redo( ) throws ExecutionCancelledException, UnrecoverableExecutionException, RuntimeException;

    /**
     * @return the undo stack, which contains a list of {@link CommandHandle}s
     * that can be undone.
     */
    List<CommandHandle> getUndoStack( );

    /**
     * @return the redo stack, which contains a list of {@link CommandHandle}s
     * that can be redone.
     */
    List<CommandHandle> getRedoStack( );

    /**
     * Clear the undo and the redo stacks. If there is an open group, then it
     * clears the undo stack of the group.
     */
    public void clear( );

    /**
     * @return The actual maximal undo stack size.
     */
    public int getMaxUndoStackSize( );

    /**
     * Sets the maximal undo stack size
     * 
     * @param maxSize The maximal undo stack size.
     */
    public void setMaxUndoStackSize( int maxSize );

    /**
     * Creates a new command group, and puts it in an internal open group stack.
     * For the new group, a new temporal undo stack is created, and the global
     * redo stack is cleared.
     * 
     * @param groupDescription
     */
    public void openGroup( String groupDescription );

    /**
     * Closes an open group.
     * 
     * @return the {@link CommandHandle} that represents the command group or
     * <code>null</code> if the group is empty. This means, no modification has
     * been performed.
     */
    public CommandHandle closeGroup( );

    /**
     * Cancels an open group, by closing it and undoing any performed change in
     * the group. Note that canceling a group will still fire update change. <br>
     * As cancelGroup has a rollback semantics, any Exception during the undo
     * leads to an UnrecoverableExecutionException.
     * 
     * @throws UnrecoverableExecutionException
     */
    public void cancelGroup( );

    /**
     * Changes the group description originally set by
     * {@link #openGroup(String)}
     * 
     * @param groupDescription The group description.
     */
    public void setGroupDescription( String groupDescription );

    /**
     * returns true if there is at least one open group
     * 
     * @return true if there is at least one open group
     */
    public boolean isGroupOpen( );

    /**
     * returns true if a Command is being executed
     * 
     * @return true if a Command is being executed
     */
    public boolean isCommandRunning( );

    /**
     * Can be used by Commands to report progress as a given number of work
     * units, that have been completed since the last report. Note that this
     * amount represents an installment, as opposed to a cumulative amount of
     * work done to date. If the Execution has been cancelled by the end user,
     * then an ExecutionCancelledException will be thrown.
     * 
     * @param worked a non-negative number of work units just completed
     * @throws ExecutionCancelledException
     */
    public void reportProgress( int worked ) throws ExecutionCancelledException;

}
