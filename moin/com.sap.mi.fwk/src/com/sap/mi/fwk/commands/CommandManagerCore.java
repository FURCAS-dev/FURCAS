package com.sap.mi.fwk.commands;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.PartitionAlreadyModifiedException;
import com.sap.mi.fwk.SourceControlException;
import com.sap.mi.fwk.internal.MiFwkPlugin;
import com.sap.mi.fwk.internal.messages.MiFwkMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * Facility for integration of Moin {@link Command Commands} and
 * {@link CommandStack command stacks} with Eclipse operation history.
 * <p>
 * In opposition to <code>com.sap.mi.fwk.ui.CommandManager</code>,
 * {@link #getInstance()} performs operations synchronously and UI free.
 * 
 * @author d031150
 */
public class CommandManagerCore {

	// private static final TracerI sTracer =
	// TracingManager.getTracer(MiLocations.MI_COMMANDS);

	private static CommandManagerCore sMgr;

	/**
	 * @return a default instance that operates on commands without UI
	 */
	public static synchronized CommandManagerCore getInstance() {
		if (sMgr == null) {
			sMgr = new CommandManagerCore();
		}
		return sMgr;
	}

	/**
	 * The method prepares the execution of a command on the affected
	 * partitions. First it is checked if there are other connections that
	 * modify the affected partitions. In this case a
	 * <code>PartitionAlreadyModifiedException</code> is thrown. Then the
	 * required source repository operations are performed on the model
	 * partition files. The preparation is done in a head less way - no checkout
	 * pop up is shown. Nevertheless the source repository client will show a
	 * select activity pop up if the default activity mode is not enabled. <br>
	 * <b>Precondition</b>: the user must be logged in the source repository
	 * when working in a shared project.
	 * 
	 * @param connection
	 *            The connection to be used for the command execution
	 * @param affectedPartitions
	 *            The partitions the command will modify. <code>null</code>
	 *            denotes that the affected partitions are unknown. In this case
	 *            all partitions in the project are checked out.
	 * @throws PartitionAlreadyModifiedException
	 * <br>
	 *             <code>affectedPartitions != null</code>: The exception is
	 *             thrown if there is another connection that modifies one of
	 *             the affected partitions.<br>
	 *             <code>affectedPartitions == null</code>: The exception is
	 *             thrown if there is any dirty connection
	 * @throws SourceControlException
	 *             The exception is thrown if source repository operations fail
	 */
	public void prepareExecutionHeadless(Connection connection, Collection<PartitionOperation> affectedPartitions)
			throws PartitionAlreadyModifiedException, SourceControlException {
		// check if there are already connections that lock the affected
		// partitions
		Collection<Connection> connectionsToSave = ConnectionManager.getInstance().getSaveConnections(connection, affectedPartitions);
		if (!connectionsToSave.isEmpty()) {
			IStatus status = getStatusForConflictingConnections(connectionsToSave);
			throw new PartitionAlreadyModifiedException(connectionsToSave, status);
		}
		// do the source repository stuff
		IdeCompoundDataAreaManager manager = MiFwkPlugin.getIdeCompoundDataAreaManager();
		IStatus preparationStatus;
		if (affectedPartitions == null) {
			IProject project = ModelAdapter.getInstance().getProject(connection);
			preparationStatus = manager.prepareModificationInProjectHeadless(project);
		} else {
			preparationStatus = manager.prepareModificationHeadless(affectedPartitions);
		}
		if (!preparationStatus.isOK()) {
			throw new SourceControlException(preparationStatus);
		}
	}

	private IStatus getStatusForConflictingConnections(Collection<Connection> connections) {
		String pluginId = MiFwkPlugin.PLUGIN_ID;
		String message = MiFwkMessages.CommandManagerCore_conflictingConnections;
		MultiStatus result = new MultiStatus(pluginId, 0, message, null);
		for (Connection connection : connections) {
			String connectionMessage = NLS.bind(MiFwkMessages.CommandManagerCore_connectionLocksModelPartitions, connection.getLabel());
			IStatus status = new Status(IStatus.ERROR, pluginId, connectionMessage, null);
			result.add(status);
		}
		return result;
	}

	private CommandManagerCore() {
		// needed by Eclipse extension instantiation
	}

}
