package com.sap.mi.fwk.ui.handler;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.CommandManager;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.mi.fwk.ui.internal.monitor.ProgressMonitor;
import com.sap.tc.moin.friends.ConnectionUtil;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * This class is used as basis for command handlers which execute MOIN commands.
 * It features methods to get a MOIN connection synchronously
 * {@link #getOrCreateDefaultConnection(IProject)} presenting a progress dialog
 * as long as the connection is not available and {@link #execute(Command)} a
 * command.
 * 
 * <code><pre>
 * 	try {
 * 		Connection connection = null;
 * 		try {
 * 			// retrieve connection synchronously and present progress dialog
 * 			// while waiting
 * 			connection = getOrCreateDefaultConnection(project);
 * 		} catch (ExecutionCancelledException e) {
 * 			// user canceled so do not present a dialog ...
 * 			return;
 * 		} catch (Exception e) {
 * 			// something went wrong ... let the user know
 * 			return;
 * 		}
 * 
 * 		Command command = new MyCommand(connection, ...);
 * 
 * 		// execute the command and open a progress dialog
 * 		try {
 * 			execute(command);
 * 		} catch (ExecutionCancelledException e) {
 * 			// user canceled command execution, undo not necessary since command has been rolled back
 * 			// do not inform user since he/she knows that he/she pressed cancel
 * 		} catch (Exception e) {
 * 			// something went wrong, inform the user
 * 		}
 * </pre></code>
 * 
 * @author d024127
 * @see Command
 * 
 */
public abstract class AbstractCommandHandler extends AbstractHandler {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_COMMANDS);

	/**
	 * DEPRECATED API Undoes a given command and shows a progress bar while
	 * running the command. Before undoing the command, the method checks
	 * whether conflicting editors are open using
	 * {@link CommandManager#prepareExecution(Connection, Collection)}. This
	 * method must be run in the UI thread.
	 * 
	 * @see IProgressService#busyCursorWhile(IRunnableWithProgress)
	 * @param command
	 *            The current command
	 * @deprecated Commands will be undone automatically when user presses
	 *             cancel. Please referre to the class' javadoc for usage
	 *             patterns
	 */
	protected final void undo(final Command command) {

		Exception ex = new RuntimeException("DEPRECATED API: DO NOT USE. see javadoc of this method for details"); //$NON-NLS-1$

		// usage is deprecated since it is superflous
		if (true) {
			throw new RuntimeException(ex);
		}

		/*
		 * final Connection connection = command.getConnection();
		 * 
		 * IRunnableWithProgress operation = new IRunnableWithProgress() {
		 * public void run(IProgressMonitor monitor) { String msg =
		 * MiFwkUiMessages.bind(MiFwkUiMessages.AbstractCommandHandler_undoing,
		 * command.getDescription()); monitor.beginTask(msg, 1);
		 * connection.getCommandStack().undo(); monitor.worked(1);
		 * monitor.done(); } };
		 * 
		 * IProgressService ps = PlatformUI.getWorkbench().getProgressService();
		 * try { ps.busyCursorWhile(operation); } catch (Exception e) {
		 * sTracer.error("Command could not be undone", e); //$NON-NLS-1$ throw
		 * new RuntimeException(e); }
		 */
	}

	/**
	 * Executes a given command and shows a progress bar while running the
	 * command. Before running the command, the method checks whether
	 * conflicting editors are open using
	 * {@link CommandManager#prepareExecution(Connection, Collection)}. This
	 * method must be run in the UI thread.
	 * 
	 * @see IProgressService#busyCursorWhile(IRunnableWithProgress)
	 * @param command
	 *            The current command
	 * @return true, if execution succeeded, will be deprecated and changed to
	 *         return type void
	 */
	protected final boolean execute(final Command command) {

		Connection connection = command.getConnection();
		Collection<PartitionOperation> affectedPartitions = command.getAffectedPartitions();
		IStatus status = CommandManager.getInstance().prepareExecution(connection, affectedPartitions);
		if (!status.isOK()) {
			sTracer.debug("User cancelled command preparation either by cancelling check-out or conflicting editor save"); //$NON-NLS-1$
			throw new ExecutionCancelledException();
		}

		IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InterruptedException {
				ProgressMonitor mon = new ProgressMonitor(monitor);
				ConnectionUtil util = UtilitiesFactory.getConnectionUtil();
				Connection connection = command.getConnection();
				util.setProgressMonitor(connection, mon);
				try {
					command.execute();
				} catch (ExecutionCancelledException e) {
					// busyCursorWhile only allows InterruptedException
					// so it must be converted and reconverted later on
					throw new InterruptedException("User cancelled"); //$NON-NLS-1$
				}
			}
		};

		IProgressService ps = PlatformUI.getWorkbench().getProgressService();
		try {
			ps.busyCursorWhile(operation);
		} catch (InterruptedException e) {
			sTracer.debug("User canceled. Command has been executed and should be undone by calling handler:" + command.getDescription()); //$NON-NLS-1$
			throw new ExecutionCancelledException();
		} catch (Exception e) {
			sTracer.error("Command could not be executed", e); //$NON-NLS-1$
			throw new RuntimeException(e);
		}
		return true;
	}

	/**
	 * Returns the default connection for a given project <b>synchronously</b>.
	 * As long as the connection is being created an hour glass cursor blocks
	 * the UI and will be replaced by a progress dialog if execution takes
	 * longer than a specific timeframe. Throws a RuntimeException if something
	 * goes wrong.
	 * 
	 * @see IProgressService#busyCursorWhile(IRunnableWithProgress)
	 * @param project
	 *            The current project
	 * @return The default connection or null, if user canceled the creation
	 *         process
	 */
	protected final Connection getOrCreateDefaultConnection(final IProject project) {

		// try it the easy way ... but do not create one if it doesn't exist
		Connection connection = ConnectionManager.getInstance().getExistingDefaultConnection(project);
		if (connection != null) {
			return connection;
		}

		// connection has to be created
		final Connection[] connections = new Connection[1];

		// create runnable
		IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				// running in non UI thread
				String msg = MiFwkUiMessages.bind(MiFwkUiMessages.AbstractCommandHandler_creating, project.getName());
				monitor.beginTask(msg, 1);
				connections[0] = ConnectionManager.getInstance().getOrCreateDefaultConnection(project);
				if (monitor.isCanceled()) {
					throw new InterruptedException();
				}
				monitor.worked(1);
				monitor.done();
			}
		};

		IProgressService ps = PlatformUI.getWorkbench().getProgressService();
		try {
			ps.busyCursorWhile(operation);
		} catch (InterruptedException e) {
			sTracer.debug("User canceled connection creation"); //$NON-NLS-1$
			throw new ExecutionCancelledException();
		} catch (Exception e) {
			sTracer.error("Connection could not be created", e); //$NON-NLS-1$
			throw new RuntimeException(e);
		}
		return connections[0];
	}

	/**
	 * Sets a given progress monitor for this connection. This monitor is used
	 * when a command is executed in this connection for reporting progress via
	 * Command.reportProgress and for checking cancellation requests by the
	 * user.
	 * 
	 * @see Command#getTotalWork()
	 * 
	 * @param connection
	 *            the current connection
	 * @param monitor
	 *            the progress monitor to be used when running commands in this
	 *            connection
	 */
	protected final void setProgressMonitor(final Connection connection, final IProgressMonitor monitor) {
		ProgressMonitor mon = new ProgressMonitor(monitor);
		ConnectionUtil util = UtilitiesFactory.getConnectionUtil();
		util.setProgressMonitor(connection, mon);
	}

}
