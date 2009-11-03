package com.sap.mi.gfw.eclipse.internal.editor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.mi.fwk.ui.CommandManager;
import com.sap.mi.gfw.GfwTestConfiguration;
import com.sap.mi.gfw.IDescription;
import com.sap.mi.gfw.IReadOnlyProvider;
import com.sap.mi.gfw.command.CommandContainer;
import com.sap.mi.gfw.command.FeatureCommand;
import com.sap.mi.gfw.command.ICommand;
import com.sap.mi.gfw.eclipse.Messages;
import com.sap.mi.gfw.eclipse.internal.command.CreateConnectionCommand;
import com.sap.mi.gfw.eclipse.internal.command.EclipseProgress;
import com.sap.mi.gfw.eclipse.internal.command.GFWCommand;
import com.sap.mi.gfw.eclipse.internal.command.GefCommandWrapper;
import com.sap.mi.gfw.ei.DefaultExecutionInfo;
import com.sap.mi.gfw.features.DefaultFeatureAndContext;
import com.sap.mi.gfw.features.IContextHolder;
import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.IFeatureAndContext;
import com.sap.mi.gfw.features.IFeatureHolder;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.features.ILongRunning;
import com.sap.mi.gfw.features.IProgressProvider;
import com.sap.mi.gfw.features.context.IContext;
import com.sap.mi.gfw.tb.IToolBehaviorProvider;
import com.sap.mi.gfw.util.T;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * The Class GFWCommandStack.
 */
public class GFWCommandStack extends CommandStack {

	private static final String AND_MORE = "..."; //$NON-NLS-1$

	private final class MyRunnable implements Runnable {
		private final Command command;

		private final boolean groupOpen;

		private final DefaultExecutionInfo executionInfo;

		private final String description;

		private final IToolBehaviorProvider currentToolBehaviorProvider;

		private MyRunnable(Command command, boolean groupOpen, DefaultExecutionInfo executionInfo, String description,
				IToolBehaviorProvider currentToolBehaviorProvider) {
			this.command = command;
			this.groupOpen = groupOpen;
			this.executionInfo = executionInfo;
			this.description = description;
			this.currentToolBehaviorProvider = currentToolBehaviorProvider;
		}

		public void run() {
			executeIt(command, groupOpen, executionInfo, description, currentToolBehaviorProvider);
		}
	}

	private final class RunnableForCommandExecution implements IRunnableWithProgress {
		GFWCommandStack comStack;

		Command command;

		IToolBehaviorProvider currentToolBehaviorProvider;

		DefaultExecutionInfo executionInfo;

		boolean groupOpen;

		String description;

		public RunnableForCommandExecution(GFWCommandStack comStack, Command command, IToolBehaviorProvider currentToolBehaviorProvider,
				DefaultExecutionInfo executionInfo, final boolean groupOpen, String description) {
			this.comStack = comStack;
			this.command = command;
			this.currentToolBehaviorProvider = currentToolBehaviorProvider;
			this.executionInfo = executionInfo;
			this.groupOpen = groupOpen;
			this.description = description;
		}

		public void run(IProgressMonitor monitor) {
			IFeatureAndContext[] featureAndContexts = executionInfo.getExecutionList();

			// calculate the total amount of the work to be done by this
			// operation
			int totalWork = 0;
			for (IFeatureAndContext featureAndContext : featureAndContexts) {
				IFeature tmpFeature = featureAndContext.getFeature();
				IContext tmpContext = featureAndContext.getContext();
				if (tmpFeature instanceof ILongRunning) {
					totalWork += ((ILongRunning) tmpFeature).getRunningSteps(tmpContext);
				} else {
					totalWork++;
				}
			}

			// create a platform-dependent progress callback -
			// initialization of the corresponding progress monitor is done by
			// the constructor
			EclipseProgress myEclipseProgress = new EclipseProgress(monitor, totalWork);

			// set the progress callback for each feature that implements
			// ILongRunning
			for (IFeatureAndContext featureAndContext : featureAndContexts) {
				IFeature tmpFeature = featureAndContext.getFeature();
				if (tmpFeature instanceof IProgressProvider) {
					((IProgressProvider) tmpFeature).setProgressCallback(myEclipseProgress);
				}
			}

			// start the execution of the commands/features
			executeIt(command, groupOpen, executionInfo, description, currentToolBehaviorProvider);
		}
	}

	private static final int INDENT = 2;

	private final com.sap.tc.moin.repository.commands.CommandStack commandStack;

	private IFeatureProvider fp;

	private final Connection connection;

	/**
	 * Instantiates a new gFW command stack.
	 * 
	 * @param cs
	 *            the cs
	 * @param fp
	 *            the fp
	 * @param connection
	 *            the connection
	 */
	public GFWCommandStack(com.sap.tc.moin.repository.commands.CommandStack cs, IFeatureProvider fp, Connection connection) {
		commandStack = cs;
		this.setFeatureProvider(fp);
		this.connection = connection;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.CommandStack#execute(org.eclipse.gef.commands.Command)
	 */
	@Override
	public void execute(Command command) {
		if (T.racer().info()) {
			T.racer().info("GFWCommandStack", "execute", "command " + command + describeGefCommand(command)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		if (command == null || getFeatureProvider() == null || connection == null)
			return;

		final boolean groupOpen = commandStack.isGroupOpen();
		DefaultExecutionInfo executionInfo = new DefaultExecutionInfo();
		if (!groupOpen) {
			Collection<PartitionOperation> affectedPartitionsForModification = Collections.EMPTY_LIST;
			if (!commandIsReadonly(command)) {
				affectedPartitionsForModification = getFeatureProvider().getAffectedPartitionsForModification();
			}
			IStatus prepareExecution = CommandManager.getInstance().prepareExecution(connection, affectedPartitionsForModification);
			if (!prepareExecution.isOK()) {
				T.racer().warning(GFWCommandStack.class, "execute", prepareExecution.getMessage()); //$NON-NLS-1$
				return;
			}
		}

		String description = null;
		if (command instanceof CompoundCommand) {
			CompoundCommand compoundCommand = (CompoundCommand) command;
			final List commands = compoundCommand.getCommands();
			if (commands.size() > 0) {
				List<String> textList = new ArrayList<String>();
				for (Object c : commands) {
					final String t = getTextForObject(c);
					if (t != null) {
						textList.add(t);
					}
				}
				description = combineText(textList);
			}
		} else {
			description = command.getLabel();
		}

		final IToolBehaviorProvider currentToolBehaviorProvider = getFeatureProvider().getDiagramTypeProvider()
				.getCurrentToolBehaviorProvider();

		if (!groupOpen) {
			completeExecutionInfo(executionInfo, command);

			// deactivated due to threading issues
			// (problem occurred upon dragging more than 20 MOF-Classes in
			// MOF-Editor
			// at a single blow, so that isLongRunningOperation(.) returns true
			// =>
			// DiagramEditor.RefreshDiagramJob.runInUIThread(IProgressMonitor
			// monitor)
			// seems to interferes with ps.run(true, false, runnable) (see
			// below)
			if (GfwTestConfiguration.isProgressDialogActive() && currentToolBehaviorProvider.isLongRunningOperation(executionInfo)) {
				if (T.racer().info()) {
					T.racer().info("GFWCommandStack.execute()"); //$NON-NLS-1$
				}

				IWorkbench wb = PlatformUI.getWorkbench();
				IProgressService ps = wb.getProgressService();
				IRunnableWithProgress runnable = new RunnableForCommandExecution(this, command, currentToolBehaviorProvider, executionInfo,
						groupOpen, description);

				try {
					ps.run(true, false, runnable);
					// ps.busyCursorWhile(runnable);
				} catch (InvocationTargetException e) {
					T.racer().warning("IProgressService.run()", e); //$NON-NLS-1$
				} catch (InterruptedException e) {
					T.racer().warning("IProgressService.run()", e); //$NON-NLS-1$
				}

				return;
			}
		}

		/* change the cursor to indicate running operation */
		BusyIndicator.showWhile(null, new MyRunnable(command, groupOpen, executionInfo, description, currentToolBehaviorProvider));

		// executeIt(command, groupOpen, executionInfo, description,
		// currentToolBehaviorProvider);
	}

	private void executeIt(Command command, final boolean groupOpen, DefaultExecutionInfo executionInfo, String description,
			final IToolBehaviorProvider currentToolBehaviorProvider) {
		if (!groupOpen) {
			currentToolBehaviorProvider.preExecute(executionInfo);
		}

		commandStack.openGroup(description);
		super.execute(command);
		commandStack.closeGroup();

		if (!groupOpen) {
			currentToolBehaviorProvider.postExecute(executionInfo);
		}
	}

	private DefaultExecutionInfo completeExecutionInfo(DefaultExecutionInfo executionInfo, Command command) {
		if (command instanceof CompoundCommand) {
			CompoundCommand compoundCommand = (CompoundCommand) command;
			final List commands = compoundCommand.getCommands();
			for (Object o : commands) {
				if (o instanceof Command) {
					Command childCommand = (Command) o;
					completeExecutionInfo(executionInfo, childCommand);
				}
			}
		}
		if (command instanceof CreateConnectionCommand) {
			CreateConnectionCommand createConnectionCommand = (CreateConnectionCommand) command;
			final IFeature[] features = createConnectionCommand.getFeatures();
			for (IFeature feature : features) {
				executionInfo.addFeatureAndContext(new DefaultFeatureAndContext(feature, null));
			}
		}
		if (command instanceof GefCommandWrapper) {
			GefCommandWrapper gefCommandWrapper = (GefCommandWrapper) command;
			final ICommand gfwCommand = gefCommandWrapper.getCommand();
			completeExecutionInfo(executionInfo, gfwCommand);
		}
		if (command instanceof GFWCommand) {
			final GFWCommand gfwCommand = (GFWCommand) command;
			executionInfo.addFeatureAndContext(new DefaultFeatureAndContext(gfwCommand.getFeature(), gfwCommand.getContext()));
		}

		return executionInfo;
	}

	private DefaultExecutionInfo completeExecutionInfo(DefaultExecutionInfo executionInfo, ICommand gfwCommand) {
		if (gfwCommand instanceof CommandContainer) {
			CommandContainer cc = (CommandContainer) gfwCommand;
			final ICommand[] childCommands = cc.getCommands();
			for (int i = 0; i < childCommands.length; i++) {
				ICommand childCommand = childCommands[i];
				completeExecutionInfo(executionInfo, childCommand);
			}
		}

		else {
			IContext context = null;
			IFeature feature = null;
			if (gfwCommand instanceof IFeatureHolder) {
				IFeatureHolder featureHolder = (IFeatureHolder) gfwCommand;
				feature = featureHolder.getFeature();
			}
			if (gfwCommand instanceof IContextHolder) {
				IContextHolder contextHolder = (IContextHolder) gfwCommand;
				context = contextHolder.getContext();
			}
			if (feature == null) {
				if (T.racer().info()) {
					T.racer().info("GFWCommandStack.completeExecutionInfo(): no feature for command " + gfwCommand); //$NON-NLS-1$
				}
			}
			executionInfo.addFeatureAndContext(new DefaultFeatureAndContext(feature, context));
		}

		return executionInfo;
	}

	private String describeGefCommand(Command command) {
		return describeGefCommand(command, 0);
	}

	private String describeGefCommand(Command command, int indent) {
		String ret = spaces(indent);
		if (command != null) {
			ret = ret + command.toString();
			if (command instanceof GefCommandWrapper) {
				GefCommandWrapper gefCommandWrapper = (GefCommandWrapper) command;
				final ICommand gfwCommand = gefCommandWrapper.getCommand();
				final String d = describeGfwCommand(gfwCommand, indent);
				ret = ret + "\n" + d; //$NON-NLS-1$
			}
			if (command instanceof CompoundCommand) {
				CompoundCommand compoundCommand = (CompoundCommand) command;
				final List childCommands = compoundCommand.getCommands();
				for (Object child : childCommands) {
					if (child instanceof Command) {
						final String d = describeGefCommand((Command) child, indent + INDENT);
						ret = ret + "\n" + d; //$NON-NLS-1$
					}
				}
			}
		}
		return ret;
	}

	private String spaces(int indent) {
		String ret = ""; //$NON-NLS-1$
		int i = 0;
		while (i < indent) {
			ret = ret + " "; //$NON-NLS-1$
			i++;
		}
		return ret;
	}

	private String describeGfwCommand(ICommand gfwCommand, int indent) {
		String ret = spaces(indent);
		if (gfwCommand instanceof FeatureCommand) {
			FeatureCommand featureCommand = (FeatureCommand) gfwCommand;
			final IFeature feature = featureCommand.getFeature();
			ret = ret + Messages.GFWCommandStack_0_xfld + ": " + feature; //$NON-NLS-1$
		}
		if (gfwCommand instanceof CommandContainer) {
			CommandContainer commandContainer = (CommandContainer) gfwCommand;
			final ICommand[] childCommands = commandContainer.getCommands();
			for (ICommand child : childCommands) {
				final String d = describeGfwCommand(child, indent + INDENT);
				ret = ret + "\n" + d; //$NON-NLS-1$
			}
		}
		return ret;
	}

	private String combineText(List<String> textList) {
		if (textList.size() < 1) {
			return ""; //$NON-NLS-1$
		} else {
			String ret = textList.get(0);
			for (String text : textList) {
				if (!ret.equals(text)) {
					ret = ret + AND_MORE;
					break;
				}
			}
			return ret;
		}
	}

	private String getTextForObject(final Object object) {
		String ret = null;
		if (object instanceof IDescription) {
			IDescription d = (IDescription) object;
			ret = d.getDescription();
		} else if (object instanceof Command) {
			Command gefCommand = (Command) object;
			ret = gefCommand.getLabel();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.CommandStack#redo()
	 */
	@Override
	public void redo() {
		super.redo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.commands.CommandStack#undo()
	 */
	@Override
	public void undo() {
		super.undo();
	}

	private void setFeatureProvider(IFeatureProvider fp) {
		this.fp = fp;
	}

	private IFeatureProvider getFeatureProvider() {
		return fp;
	}

	/**
	 * Checks whether the GEF command is read only. Currently the check is done only for commands created via the CustomAction, i.e. the
	 * command is a GefCommandWrapper holding a CommandContainer which contains exactly one GenericFeatureCommandWithContext which
	 * implements IReadOnlyProvider.
	 * 
	 * @param command
	 *            the GEF command
	 */
	private boolean commandIsReadonly(Command command) {
		if (command != null && command instanceof GefCommandWrapper) {
			// this is the case for all commands created via CustomAction
			GefCommandWrapper gefCommandWrapper = (GefCommandWrapper) command;
			if (gefCommandWrapper.getCommand() instanceof CommandContainer) {
				// unpack the CommandContainer
				CommandContainer commandContainer = (CommandContainer) gefCommandWrapper.getCommand();
				ICommand[] commands = commandContainer.getCommands();

				// check whether all commands are IReadOnlyProvider otherwise return false
				for (int i = 0; i < commands.length; i++) {
					ICommand c = commands[i];
					if (!(c instanceof IReadOnlyProvider)) {
						return false;
					}
				}

				// examine all IReadOnlyProvider commands: all features must be IReadOnly otherwise return false
				for (int i = 0; i < commands.length; i++) {
					ICommand c = commands[i];
					boolean readOnly = ((IReadOnlyProvider) c).isReadOnly();
					if (!readOnly) {
						return false;
					}

				}

				return true;

			}
		}
		return false;
	}
}