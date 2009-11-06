package com.sap.mi.fwk.ui.wizard;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.IRunnableWithConnection;
import com.sap.mi.fwk.commands.NavigationCommand;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.CommandHandle;
import com.sap.tc.moin.repository.commands.CommandStack;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

/**
 * Convenience base class for wizards that do their work within a command group.
 * The group begins on opening the wizard and is closed / discarded on finish /
 * cancel.
 * 
 * @author d023588
 * @author d031150
 */
public abstract class CommandGroupWizard extends Wizard implements IWorkbenchWizard {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_COMMANDS);

	private Connection mConnection = null;
	private IProject mProject = null;
	private IStructuredSelection mSelection;
	/**
	 * If <code>true</code>, we have created the connection, we control it.
	 */
	private boolean mOwnConnection = false;

	/**
	 * Creates a new wizard
	 */
	public CommandGroupWizard() {
		String description = getDescription();
		if (description == null || description.length() == 0)
			throw new IllegalArgumentException("Must provide a description for the wizard"); //$NON-NLS-1$

		setWindowTitle(description);
	}

	/**
	 * @return a brief description of the wizard
	 */
	protected abstract String getDescription();

	/**
	 * @return a command to be executed on {@link #performFinish()}, or
	 *         <code>null</code>
	 */
	protected abstract Command getFinishCommand();

	/**
	 * Initializes this wizard with the passed selection. The implementation
	 * assumes that either
	 * <ul>
	 * <li> or a {@link Connection} can be inferred out of the selection. The
	 * wizard works with this connection,</li>
	 * <li> or an {@link IProject} context can be inferred out of the selection.
	 * The wizard works with new {@link Connection} of this scope.</li>
	 * </ul>
	 * 
	 * @see #init(IWorkbench, Connection)
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		mSelection = selection;
		ModelAdapterUI adapter = ModelAdapterUI.getInstance();
		RefBaseObject object = adapter.getRefBaseObject(selection);
		if (object != null) {
			init(workbench, adapter.getConnection(object));
		} else {
			IProject project = adapter.getProject(selection);
			init(workbench, project);
		}
	}

	/**
	 * Initializes this wizard with the passed project. The wizard creates a
	 * {@link Connection connection} of this scope, which will be closed if this
	 * wizard finishes.
	 * 
	 * @param workbench
	 *            The current workbench
	 * @param project
	 *            The current project
	 * @return The status of the initialization
	 * 
	 * @see #init(IWorkbench, Connection)
	 */
	public IStatus init(final IWorkbench workbench, final IProject project) {
		final String description = getDescription();
		IRunnableWithConnection runnable = new IRunnableWithConnection() {
			public void run(Connection connection, IProgressMonitor monitor) {
				mOwnConnection = true;
				if (description != null) {
					connection.setLabel(description);
				}
				// Initialize the wizard and set the connection internally
				init(workbench, connection);
			}
		};
		ConnectionManagerUI.getInstance().createConnectionAsync(project, runnable);

		// Wait for asynchronous connection initialization
		while (mConnection == null) {
			Display.getDefault().readAndDispatch();
		}

		return Status.OK_STATUS;
	}

	/**
	 * Initializes this wizard with the passed connection. Note that the wizard
	 * will neither save, revert nor close this connection since it is up to the
	 * creator of the connection to control its lifecycle.
	 * 
	 * @param workbench
	 *            The current workbench
	 * @param connection
	 *            The current connection
	 * @return The status of the initialization
	 * 
	 * @see #init(IWorkbench, IProject)
	 */
	public IStatus init(IWorkbench workbench, Connection connection) {
		mConnection = connection;
		mProject = ModelAdapterUI.getInstance().getProject(connection);
		String description = getDescription();
		mConnection.getCommandStack().openGroup(description);

		return Status.OK_STATUS;
	}

	/**
	 * Sets the given selection to the wizard
	 * 
	 * @param selection
	 *            the selection to set
	 */
	public void setSelection(IStructuredSelection selection) {
		mSelection = selection;
	}

	/**
	 * Executes any command given by {@link #getFinishCommand()}, closes this
	 * wizard's command group and saves its connection.
	 * 
	 * @see IWizard#performFinish()
	 */
	public boolean performFinish() {
		try {
			Command finishCommand = getFinishCommand();
			if (finishCommand != null) {
				IStatus status = executeCommand(finishCommand);
				if (status != null && !status.isOK()) {
					showStatus(status);
					if (mOwnConnection) {
						mConnection.revert();
					}
					return true;
				}
			}

			mConnection.getCommandStack().closeGroup();

			if (mOwnConnection) {
				// save
				IStatus status = ConnectionManagerUI.getInstance().save(mConnection, mProject, null);
				if (status.isOK()) {
					openDefaultEditor(finishCommand);
				}
				// else: error handling inside save method
			} else {
				openDefaultEditor(finishCommand);
			}
			return true;
		} finally {
			if (mOwnConnection) {
				mConnection.close();
				mConnection = null;
			}
		}
	}

	/**
	 * Cancels this wizard's command group and reverts its connection, thus
	 * undoing all changes of the wizard.
	 * 
	 * @see IWizard#performCancel()
	 */
	@Override
	public boolean performCancel() {
		if (mConnection != null) {
			if (mOwnConnection) {
				mConnection.revert();
				mConnection.close();
				mConnection = null;
			} else {
				if (mConnection.isAlive()) {
					CommandStack commandStack = mConnection.getCommandStack();
					if (commandStack.isGroupOpen()) {
						if (commandStack.getUndoStack().size() > 0)
							commandStack.cancelGroup();
						else
							commandStack.closeGroup();
					}
				}
			}
		}

		return true;
	}

	/**
	 * Creates a connection for the given project using the given description
	 * 
	 * @param project
	 *            the project for the connection
	 * @param description
	 *            the connection's description
	 * @return the new connection
	 * @deprecated This method should not be called anymore since the connection
	 *             creation for this wizard happens during the initialization
	 *             phase, additional connections should not be needed, in case
	 *             they are needed use the respective methods from
	 *             {@link ConnectionManager} or {@link ConnectionManagerUI} to
	 *             create one.
	 */
	protected Connection createConnection(IProject project, String description) {
		Connection connection = ConnectionManager.getInstance().createConnection(project);
		mOwnConnection = true;
		if (description != null)
			connection.setLabel(description);
		return connection;
	}

	/**
	 * @return this wizard's connection
	 */
	protected Connection getConnection() {
		return mConnection;
	}

	/**
	 * @return this wizard's project
	 */
	protected final IProject getProject() {
		return mProject;
	}

	/**
	 * @return the selection this wizard was initialized with. Is
	 *         <code>null</code> if
	 *         {@link #init(IWorkbench, IStructuredSelection)} was not called.
	 */
	protected final IStructuredSelection getSelection() {
		return mSelection;
	}

	/**
	 * Executes the given command
	 * 
	 * @param cmd
	 *            the command to execute
	 * @return the execution result
	 */
	protected IStatus executeCommand(Command cmd) {
		try {
			CommandHandle handle = cmd.getConnection().getCommandStack().execute(cmd);
			return (handle != null ? Status.OK_STATUS : Status.CANCEL_STATUS);
		} catch (ExecutionCancelledException ecEx) { // $JL-EXC$
			return Status.CANCEL_STATUS;
		} catch (Exception e) {
			return MiFwkUIPlugin.createStatus(Status.ERROR, "Command failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * Called on successful finish. If the command returned by
	 * {@link #getFinishCommand()} is a {@link NavigationCommand}, the default
	 * editor for the command's
	 * {@link NavigationCommand#getNavigationObject() navigation object} is
	 * opend.
	 */
	protected void openDefaultEditor(Command finishCommand) {
		if (finishCommand instanceof NavigationCommand) {
			NavigationCommand wfc = (NavigationCommand) finishCommand;
			RefBaseObject navigationObject = wfc.getNavigationObject();
			if (navigationObject != null) {
				try {
					ModelManagerUI.getEditorManager().openEditor(navigationObject);
				} catch (PartInitException e) {
					MiFwkUIPlugin.showErrorDialog(e, "Cannot open editor", null, sTracer); //$NON-NLS-1$
				}
			}
		}
	}

	/**
	 * Raises a UI to show the given status if it is erroneous. Does nothing if
	 * it's a cancellation status.
	 */
	protected void showStatus(IStatus status) {
		if (status != null && !status.isOK() && IStatus.CANCEL != status.getSeverity())
			MiFwkUIPlugin.showErrorDialog(status, "Cannot perform operation", sTracer); //$NON-NLS-1$
	}

	/**
	 * Gets the status
	 * 
	 * @return The status
	 */
	public IStatus getStatus() {
		return null;
	}

}
