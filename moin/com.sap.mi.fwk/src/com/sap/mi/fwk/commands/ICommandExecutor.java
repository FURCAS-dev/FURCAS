package com.sap.mi.fwk.commands;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * Protocol for operations on commands and command stacks. Used as callback in
 * {@link CommandManagerCore} to honor different execution strategies (e.g.
 * headless or UI command execution).
 * <p/>
 * Not intended to be implemented by clients.
 * 
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 *              Clients should instead subclass one of the classes that
 *              implement this interface. Note that direct implementers of this
 *              interface outside of the framework will be broken in future
 *              releases when methods are added to this interface.
 * 
 * @author d031150
 * @see CommandManagerCore
 * @see CommandManagerCore#getInstance()
 */
public interface ICommandExecutor {

	/**
	 * Prepares the execution of a command or command group in the given
	 * connection. If executed in the UI (main) thread the implementation asks
	 * the user to save conflicting editors. An editor is conflicting if it is
	 * dirty and modifies a partition listed in affectedPartitions. <br>
	 * Additionally the affected partitions are prepared for modification
	 * (checked-out for edit if the project is under source control).
	 * 
	 * @param connection
	 *            The given connection
	 * @param affectedPartitions
	 *            The affected partition operations
	 * @return Status indicating whether the preparation succeeded (OK), the
	 *         user canceled (CANCEL), or an error occurred (ERROR)
	 * @see IStatus
	 * @see ICommandExecutor#prepareExecution(Connection)
	 */
	IStatus prepareExecution(Connection connection, Collection<PartitionOperation> affectedPartitions);

	/**
	 * Prepares the execution of a command or command group in the given
	 * connection. If executed in the UI (main) thread the implementation should
	 * ask the user to save conflicting editors. An editor is conflicting if it
	 * is dirty and modifies a partition listed in affectedPartitions. <br>
	 * This method is equivalent to calling
	 * {@link #prepareExecution(Connection, Collection)} with <code>null</code>
	 * as second parameter
	 * 
	 * @param connection
	 *            The given connection
	 * @return Status indicating whether the preparation succeeded (OK), the
	 *         user canceled (CANCEL), or an error occured (ERROR)
	 * @see IStatus
	 * @see #prepareExecution(Connection, Collection)
	 */
	IStatus prepareExecution(Connection connection);
}
