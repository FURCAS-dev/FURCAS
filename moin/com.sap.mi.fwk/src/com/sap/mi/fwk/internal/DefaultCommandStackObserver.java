package com.sap.mi.fwk.internal;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.commands.CommandManagerCore;
import com.sap.mi.fwk.commands.ICommandExecutor;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.tc.moin.friends.CommandStackObserver;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;

/**
 * Handles MOIN command notifications and updates Eclipse undo stack if
 * necessary
 * 
 * @author d024127
 */
public final class DefaultCommandStackObserver implements CommandStackObserver {

	private static final IUndoableOperation[] EMPTY_ARRAY = new IUndoableOperation[0];
	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_COMMANDS);

	private static final String EXT_POINT_ELEMENT_CMDEXECUTOR = "commandExecutor"; //$NON-NLS-1$
	private static final String EXT_POINT_ATT_CMDEXECUTOR_CLASS = "class"; //$NON-NLS-1$

	private ICommandExecutor executor = null;

	public Collection<Connection> getConnectionsToBeSaved(Command cmd, Collection<PartitionOperation> affectedPartitions) {
		return ConnectionManager.getInstance().getSaveConnections(cmd, affectedPartitions);
	}

	public void notifyTopLevelStacksCleared(Connection con) {
		IUndoContext undoContext = ModelManager.getConnectionManager().getUndoContext(con);
		if (sTracer.isLoggable(Level.FINE)) {
			sTracer.logp(Level.FINE, DefaultCommandStackObserver.class.getName(), "notifyTopLevelStacksCleared", "Cleared top level stacks"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (undoContext != null) {
			OperationHistoryFactory.getOperationHistory().dispose(undoContext, true, true, false);
		}
	}

	public void notifyBeforeRootCommandExecution(Command cmd, Collection<PartitionOperation> affectedPartitions) {
		ICommandExecutor executor = getExecutor();
		if (executor == null) {
			// can only happen if FWK UI plugin is not installed!
			return;
		}
		IStatus result = executor.prepareExecution(cmd.getConnection(), affectedPartitions);
		if (sTracer.isLoggable(Level.FINE)) {
			sTracer.logp(Level.FINE, DefaultCommandStackObserver.class.getName(), "notifyBeforeRootCommandExecution", "starting cmd: " + cmd //$NON-NLS-1$ //$NON-NLS-2$
					+ ", result:" + result); //$NON-NLS-1$
		}
		if (!result.isOK()) {
			throw new ExecutionCancelledException();
		}
	}

	public void notifyTopLevelCommandExecuted(CommandHandle cmdHnd, Connection con) {
		if (cmdHnd == null || con == null) {
			sTracer.logp(Level.WARNING, DefaultCommandStackObserver.class.getName(), "notifyTopLevelCommandExecuted", //$NON-NLS-1$
					"CommandHandle or Connection was null: cmdHnd=" + cmdHnd + ", connection=" + con); //$NON-NLS-1$ //$NON-NLS-2$
			return;
		}
		// - create the operation wrapper for the command
		// - an undo context only exists for ModelEditors
		IUndoContext undoContext = ModelManager.getConnectionManager().getUndoContext(con);
		if (undoContext != null) {
			// connection came from an editor
			String desc = cmdHnd.getDescription();
			if (desc == null || "".equals(desc)) { //$NON-NLS-1$
				desc = cmdHnd.toString();
			}
			if (sTracer.isLoggable(Level.FINE)) {
				sTracer.logp(Level.FINE, DefaultCommandStackObserver.class.getName(), "notifyTopLevelCommandExecuted", //$NON-NLS-1$
						"Command on Eclipse undo stack: " + desc); //$NON-NLS-1$
			}

			CommandStack cmdStack = con.getCommandStack();
			IUndoableOperation operation = new MoinOperation(desc, cmdStack);

			int maxStackSize = cmdStack.getMaxUndoStackSize();
			OperationHistoryFactory.getOperationHistory().setLimit(undoContext, maxStackSize);

			operation.addContext(undoContext);
			OperationHistoryFactory.getOperationHistory().add(operation);
			// editors are notified via IOperationHistoryListener protocol
		} else if (sTracer.isLoggable(Level.FINE)) {
			sTracer.logp(Level.FINE, DefaultCommandStackObserver.class.getName(), "notifyTopLevelCommandExecuted", //$NON-NLS-1$
					"No editor found for connection. Operation called from view."); //$NON-NLS-1$
		}
	}

	public void notifyTopLevelCommandRedone(CommandHandle cmdHnd, Connection con) {
		IUndoContext undoContext = ModelManager.getConnectionManager().getUndoContext(con);
		if (undoContext != null) {
			IUndoableOperation operation = OperationHistoryFactory.getOperationHistory().getRedoOperation(undoContext);
			if (operation instanceof MoinOperation) {
				if (sTracer.isLoggable(Level.FINE)) {
					sTracer.logp(Level.FINE, DefaultCommandStackObserver.class.getName(), "notifyTopLevelCommandRedone", //$NON-NLS-1$
							"Command removed from Eclipse redo stack: " + cmdHnd.getDescription()); //$NON-NLS-1$
				}
				OperationHistoryFactory.getOperationHistory().replaceOperation(operation, EMPTY_ARRAY);
			}
		}
	}

	public void notifyTopLevelCommandUndone(CommandHandle cmdHnd, Connection con) {
		IUndoContext undoContext = ModelManager.getConnectionManager().getUndoContext(con);
		if (undoContext != null) {
			IUndoableOperation operation = OperationHistoryFactory.getOperationHistory().getUndoOperation(undoContext);
			if (operation instanceof MoinOperation) {
				if (sTracer.isLoggable(Level.FINE)) {
					sTracer.logp(Level.FINE, DefaultCommandStackObserver.class.getName(), "notifyTopLevelCommandUndone", //$NON-NLS-1$
							"Command removed from Eclipse undo stack: " + cmdHnd.getDescription()); //$NON-NLS-1$
				}
				OperationHistoryFactory.getOperationHistory().replaceOperation(operation, EMPTY_ARRAY);
			}
		}
	}

	/**
	 * Maybe <code>null</code> in case FWK UI plugin is not installed! But this
	 * is currently a not supported scenario.
	 * 
	 * @return
	 */
	private synchronized ICommandExecutor getExecutor() {
		if (executor == null)
			executor = createExecutor();
		return executor;
	}

	/**
	 * Creates an executor via the <code>uiHook</code> extension point or
	 * defaults to {@link CommandManagerCore#getInstance()}.
	 * 
	 * @return an executor
	 */
	private static ICommandExecutor createExecutor() {
		IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(MiFwkPlugin.EXT_POINT_ID_UIHOOK).getExtensions();
		if (extensions.length > 0) {
			IConfigurationElement[] elements = extensions[0].getConfigurationElements();
			for (IConfigurationElement element : elements) {
				if (EXT_POINT_ELEMENT_CMDEXECUTOR.equals(element.getName())) {
					try {
						Object exec = element.createExecutableExtension(EXT_POINT_ATT_CMDEXECUTOR_CLASS);
						if (exec instanceof ICommandExecutor)
							return (ICommandExecutor) exec;
						MiFwkPlugin.logError("Class is not an instance of ICommandExecutor: " + exec, null, sTracer); //$NON-NLS-1$
					} catch (CoreException e) {
						MiFwkPlugin.logError("Unable to create command executor for extension " //$NON-NLS-1$
								+ extensions[0].getContributor().getName(), e, sTracer);
					}
				}
			}
		}

		if (sTracer.isLoggable(Level.INFO)) {
			sTracer.info("No command executor extension found."); //$NON-NLS-1$
		}
		return null;
	}

}