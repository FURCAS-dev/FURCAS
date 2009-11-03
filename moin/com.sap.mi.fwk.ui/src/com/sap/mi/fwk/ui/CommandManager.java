package com.sap.mi.fwk.ui;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Display;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.commands.CommandManagerCore;
import com.sap.mi.fwk.commands.ICommandExecutor;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;

/**
 * Facility for integration of Moin {@link Command Commands} and
 * {@link CommandStack CommandStacks} with Eclipse operation history.
 * <p>
 * By default this class uses UI to perform its tasks if called from the UI
 * thread, and delegates to its counterpart {@link CommandManagerCore} in non-UI
 * threads. If you definitely want to avoid UI, use
 * {@link CommandManagerCore#getInstance()} directly.
 * 
 * @author d024127
 * @author d031150
 * 
 * @see CommandManagerCore
 */
public final class CommandManager implements ICommandExecutor {

	private static CommandManager sInstance;

	/**
	 * @return the instance
	 */
	public static synchronized CommandManager getInstance() {
		if (sInstance == null) {
			sInstance = new CommandManager();
		}
		return sInstance;
	}

	public IStatus prepareExecution(Connection connection) {
		return prepareExecution(connection, null);
	}

	public IStatus prepareExecution(Connection connection, Collection<PartitionOperation> affectedPartitions)
			throws ExecutionCancelledException {
		if (Display.getCurrent() != null) {
			Collection<Connection> connectionsToSave = ConnectionManager.getInstance().getSaveConnections(connection, affectedPartitions);
			IStatus result = ConnectionManagerUI.getInstance().saveAll(connectionsToSave, null);
			if (!result.isOK()) {
				return result;
			}
			return prepareModification(connection, affectedPartitions);
		}
		return Status.OK_STATUS;
	}

	private IStatus prepareModification(Connection connection, Collection<PartitionOperation> affectedPartitions) {
		// don't do versioning for transient connections
		if (ConnectionManager.getInstance().isTransient(connection)) {
			return Status.OK_STATUS;
		}

		IdeCompoundDataAreaManager dispatcher = MiFwkUIPlugin.getIdeCompoundDataAreaManager();
		IStatus result;
		if (affectedPartitions != null) {
			Collection<PartitionOperation> filteredAffectedPartitions = new HashSet<PartitionOperation>(affectedPartitions);
			for (Iterator iterator = filteredAffectedPartitions.iterator(); iterator.hasNext();) {
				PartitionOperation partitionOperation = (PartitionOperation) iterator.next();
				// remove NullPartitions and TransientPartitions from
				// partition set
				if (partitionOperation.getPartitionPri().isNullPartition() || partitionOperation.getPartitionPri().isVolatilePartition()) {
					iterator.remove();
				}
			}
			result = dispatcher.prepareModification(filteredAffectedPartitions);
		} else {
			IProject project = ModelAdapter.getInstance().getProject(connection);
			result = dispatcher.prepareModificationInProject(project);
		}
		return result;
	}

	/**
	 * For internal use only. Use {@link #getInstance()}.
	 */
	protected CommandManager() {
	}

}