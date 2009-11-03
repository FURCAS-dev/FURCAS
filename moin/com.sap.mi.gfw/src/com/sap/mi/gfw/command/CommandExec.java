package com.sap.mi.gfw.command;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.IStatus;

import com.sap.mi.fwk.ui.CommandManager;
import com.sap.mi.gfw.GfwTestConfiguration;
import com.sap.mi.gfw.IReadOnlyProvider;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.util.T;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * The Class CommandExec.
 */
public class CommandExec {

	private static int commandExecutionDepth2 = 0;

	private static CommandExec singleton = null;

	private CommandExec() {
		super();
	}

	/**
	 * Execute command.
	 * 
	 * @param command
	 *            the command
	 * @param connection
	 *            the connection
	 * @return true, if successful
	 */
	public boolean executeCommand(ICommand command, Connection connection) {
		commandExecutionDepth2++;
		long start = System.currentTimeMillis();

		String indent = ""; //$NON-NLS-1$

		final boolean reallyTraceIt = GfwTestConfiguration.isCPUProfilingTraceActive() && commandExecutionDepth2 < 4;

		if (reallyTraceIt && T.racer().info()) {
			for (int i = 1; i < commandExecutionDepth2; i++) {
				indent = indent + "  "; //$NON-NLS-1$
			}
			if (commandExecutionDepth2 == 1) {
				T.racer().info("\n"); //$NON-NLS-1$
			}
			T.racer().info(indent + ">start CommandExec.executeCommand(command, connection) => openCommandGroup => " //$NON-NLS-1$
					+ command.getDescription() + " >"); //$NON-NLS-1$
		}

		String description = command.getDescription();
		boolean ret;
		CommandStack commandStack = connection.getCommandStack();
		if (!commandStack.isGroupOpen()) {
			Collection<PartitionOperation> affectedPartitionsForModification = Collections.EMPTY_LIST;
			if (!(command instanceof IReadOnlyProvider) || !((IReadOnlyProvider) command).isReadOnly()) {
				IFeatureProvider fp = command.getFeatureProvider();
				affectedPartitionsForModification = fp.getAffectedPartitionsForModification();
			}
			IStatus prepareExecution = CommandManager.getInstance().prepareExecution(connection, affectedPartitionsForModification);
			if (!prepareExecution.isOK()) {
				return false;
			}
		}

		if (!commandStack.isGroupOpen()) {
			if (T.racer().info()) {
				T.racer().info("CommandExec.executeCommand()"); //$NON-NLS-1$
			}
		}

		boolean isRoot = !(commandStack.isGroupOpen() || commandStack.isCommandRunning());
		try {
			if (isRoot) {
				commandStack.openGroup(description);
			}
			ret = command.execute();
			if (isRoot) {
				commandStack.closeGroup();
			}

		} catch (Exception ex) {
			T.racer().error("CommandExec.executeCommand() " + ex, ex); //$NON-NLS-1$
			if (isRoot) {
				commandStack.closeGroup();
				commandStack.undo();
			}
			ret = true;
		}

		long stop = System.currentTimeMillis();

		if (reallyTraceIt && T.racer().info()) {
			T.racer().info(indent + "<stop (" + (stop - start) + " ms) " //$NON-NLS-1$ //$NON-NLS-2$
					+ "CommandExec.executeCommand(command, connection) => closeCommandGroup => " + command.getDescription() + " <"); //$NON-NLS-1$ //$NON-NLS-2$
			if (commandExecutionDepth2 == 1) {
				T.racer().info("\n"); //$NON-NLS-1$
			}
		}
		commandExecutionDepth2--;

		return ret;
	}

	/**
	 * Gets the singleton.
	 * 
	 * @return the singleton
	 */
	public static CommandExec getSingleton() {
		if (singleton == null) {
			singleton = new CommandExec();
		}
		return singleton;
	}

	/**
	 * Execute feature with context.
	 * 
	 * @param feature
	 *            the feature
	 * @param context
	 *            the context
	 */
	public static void executeFeatureWithContext(IFeature feature, IContext context) {
		GenericFeatureCommandWithContext genericFeatureCommandWithContext = new GenericFeatureCommandWithContext(feature, context);
		Connection connection = feature.getFeatureProvider().getConnection();
		CommandExec.getSingleton().executeCommand(genericFeatureCommandWithContext, connection);
	}

}
