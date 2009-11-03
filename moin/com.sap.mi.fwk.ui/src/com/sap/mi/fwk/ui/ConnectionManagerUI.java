package com.sap.mi.fwk.ui;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.IRunnableWithConnection;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.editor.IModelEditor;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.fwk.ui.internal.AssignElementsDialog;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.NullPartitionNotEmptyException;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionsNotSavedException;
import com.sap.tc.moin.repository.ReferencedTransientElementsException;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Facility to <b>create</b> or <b>save</b> MOIN connections from the <b>UI
 * thread</b>. The methods will throw an {@link IllegalStateException} if
 * accessed from the wrong thread.<br>
 * <ul>
 * <li><b>Creating</b> and <b>saving</b> Connections from the <b>NON-UI
 * thread</b> have to be performed using {@link ConnectionManager}. This class
 * provides other helpful connection related services that could be accessed
 * from any thread.</li>
 * </ul>
 * <p/>
 * The current assumption is that connections always have a project scope, so an
 * {@link IProject} is required to created them. This allows for a resolution of
 * a tool's current project context out of any given connection.
 * <p/>
 * By now for each new connection a new {@link Session} is created, limiting the
 * visibility of transient changes in the connection to this session.
 * 
 * @author d031150, d022960
 */
public final class ConnectionManagerUI {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_CONNECTIONS);
	private static ConnectionManagerUI sInstance;

	/**
	 * @return the singleton instance
	 */
	public static synchronized ConnectionManagerUI getInstance() {
		if (sInstance == null)
			sInstance = new ConnectionManagerUI();
		return sInstance;
	}

	/**
	 * Saves the connection and potentially checks if there is no editor open to
	 * carry the dirty state. This usually happens when the connection is used
	 * by a view, e.g. ProjectExplorer. The method can be used when the calling
	 * context is not known at design time. <br>
	 * E.g. An action handler that will be used in a view (immediate save after
	 * command execution) and in an editor (manual save by the user).
	 * <p/>
	 * <b>Note:</b><br>
	 * This method must be called from the <b>UI thread</b>, otherwise an
	 * <code>InvalidStateException</code> is thrown.
	 * 
	 * @param connection
	 *            The current connection
	 * @param monitor
	 *            the current monitor or null
	 * 
	 * @exception IllegalStateException
	 *                if this method is called from a <b>NON-UI thread</b>
	 * @see #save(Connection, IProgressMonitor)
	 * @see #save(Connection, IProject, IProgressMonitor)
	 */
	public IStatus saveIfNecessary(Connection connection, IProgressMonitor monitor) {
		if (Display.getCurrent() == null) {
			throw new IllegalStateException("Must be called from UI thread"); //$NON-NLS-1$
		}
		Collection<IModelEditor> editors = ModelEditorManager.getInstance().getAllActiveModelEditors(connection);
		if (editors.isEmpty()) {
			IProject project = ModelAdapterUI.getInstance().getProject(connection);
			return save(connection, project, monitor);
		}
		return Status.CANCEL_STATUS;
	}

	/**
	 * Creates a connection for the given project asynchronously in separate
	 * thread. Subsequent actions using the connection can be provided as a
	 * runnable. To be used e.g. in editors initialization that issue the
	 * connection creation, show a pending UI and later-on create the actual UI.
	 * <p/>
	 * <b>Note:</b><br>
	 * This method must be called from the <b>UI thread</b>, otherwise an
	 * <code>InvalidStateException</code> is thrown.
	 * 
	 * @param project
	 *            the project to create the connection for
	 * @param followUp
	 *            a subsequent action
	 * 
	 * @exception IllegalStateException
	 *                if this method is called from a <b>NON-UI thread</b>
	 * @see #getOrCreateDefaultConnectionAsync(IProject,
	 *      IRunnableWithConnection)
	 */
	public void createConnectionAsync(final IProject project, final IRunnableWithConnection followUp) {
		if (project == null || !project.isAccessible()) {
			sTracer.warning("Project is not accesible or null. not creating a connection. project:" + project); //$NON-NLS-1$
			return;
		}

		Job job = new CreateConnectionJob(MiFwkUiMessages.bind(
				MiFwkUiMessages.ConnectionManagerUI_createDefaultConnection_jobLabel, MiFwkUIPlugin
						.getProjectLabel(project)), followUp) {
			@Override
			protected Connection doRun(IProgressMonitor monitor) {
				if (sTracer.info()) {
					sTracer.info("Creating connection in thread " + Thread.currentThread().getName()); //$NON-NLS-1$
				}
				Connection connection = ConnectionManager.getInstance().createConnection(project);
				return connection;
			}
		};
		job.schedule();
	}

	/**
	 * Returns an existing default connection for the given project immediately
	 * or creates such a connection asynchronously in separate thread.
	 * Subsequent actions using the connection can be provided as a runnable. To
	 * be used e.g. in tree content providers hat issue the connection creation,
	 * show a pending UI and later-on create the actual UI.
	 * <p/>
	 * <b>Note:</b><br>
	 * This method must be called from the <b>UI thread</b>, otherwise an
	 * <code>InvalidStateException</code> is thrown.
	 * 
	 * @param project
	 *            the project to create the connection for
	 * @param followUp
	 *            a subsequent action
	 * 
	 * @return The created connection
	 * 
	 * @exception IllegalStateException
	 *                if this method is called from a <b>NON-UI thread</b>
	 * @see #createConnectionAsync(IProject, IRunnableWithConnection)
	 * @see ConnectionManager#getExistingDefaultConnection(IProject)
	 */
	public Connection getOrCreateDefaultConnectionAsync(final IProject project, final IRunnableWithConnection followUp) {
		Connection connection = ConnectionManager.getInstance().getExistingDefaultConnection(project);
		if (connection != null) {
			return connection;
		}
		String msg = MiFwkUiMessages.bind(MiFwkUiMessages.ConnectionManagerUI_createConnection_jobLabel, MiFwkUIPlugin
				.getProjectLabel(project));
		Job job = new CreateConnectionJob(msg, followUp) {
			@Override
			protected Connection doRun(IProgressMonitor monitor) {
				if (sTracer.info()) {
					sTracer.info("Creating default connection in thread " + Thread.currentThread().getName()); //$NON-NLS-1$
				}
				Connection connection = ConnectionManager.getInstance().getOrCreateDefaultConnection(project);
				return connection;
			}
		};
		job.schedule();
		return null;
	}

	/**
	 * Performs a safeguarded save operation by raising a dialog in case the
	 * null partition is not empty or any
	 * {@link Connection#getReferencedTransientElements() referenced transient
	 * elements} exist, so that the user can assign these elements to a
	 * partition. In case of any other errors, an error dialog is shown. This
	 * method must be called from the UI thread.
	 * <p/>
	 * <b>Note:</b><br>
	 * This method must be called from the <b>UI thread</b>, otherwise an
	 * <code>InvalidStateException</code> is thrown.
	 * 
	 * @param connection
	 *            the connection to save. Must not be <code>null</code>. Must be
	 *            one with project scope, i.e. created by
	 *            {@link ConnectionManager#createConnection(IProject)}.
	 * @param monitor
	 *            a progress monitor, currently not supported
	 * @return a status indicating whether save was successful
	 * @exception IllegalStateException
	 *                if this method is called from a <b>NON-UI thread</b>
	 * 
	 * @see #save(Connection, IProject, IProgressMonitor)
	 */
	public IStatus save(Connection connection, IProgressMonitor monitor) {
		if (Display.getCurrent() == null) {
			throw new IllegalStateException("Must be called from the UI thread. Use ConnectionManager otherwise."); //$NON-NLS-1$
		}
		IProject project = ModelAdapterUI.getInstance().getProject(connection);
		if (project == null) {
			throw new IllegalArgumentException("No project available for connection " + connection //$NON-NLS-1$
					+ ". Use save(Connection, IProject) instead."); //$NON-NLS-1$
		}
		return save(connection, project, monitor);
	}

	/**
	 * Performs a safeguarded save operation by raising a dialog in case the
	 * null partition is not empty or any
	 * {@link Connection#getReferencedTransientElements() referenced transient
	 * elements} exist, so that the user can assign these elements to a
	 * partition. In case of any other errors, an error dialog is shown. This
	 * method must be called from the UI thread.
	 * <p/>
	 * <b>Note:</b><br>
	 * This method must be called from the <b>UI thread</b>, otherwise an
	 * <code>InvalidStateException</code> is thrown.
	 * 
	 * @param connection
	 *            the connection to save. Must not be <code>null</code>.
	 * @param project
	 *            the current project. Must not be <code>null</code>.
	 * @param monitor
	 *            a progress monitor, currently not supported
	 * @return a status indicating whether save was successful
	 * 
	 * @exception IllegalStateException
	 *                if this method is called from a <b>NON-UI thread</b>
	 * @see #save(Connection, IProgressMonitor)
	 */
	public IStatus save(final Connection connection, IProject project, IProgressMonitor monitor) {
		if (Display.getCurrent() == null) {
			throw new IllegalStateException("Must be called from the UI thread. Use ConnectionManager otherwise."); //$NON-NLS-1$
		}
		if (project == null) {
			throw new IllegalArgumentException("Project must not be null " //$NON-NLS-1$
					+ ". Consider using save(Connection) instead."); //$NON-NLS-1$
		}
		if (!project.isAccessible()) {
			String message = "The project '" + project.getName() + "' is already closed. Save cannot be performed."; //$NON-NLS-1$ //$NON-NLS-2$
			IStatus status = MiFwkUIPlugin.createStatus(IStatus.ERROR, message, new Exception(message));
			return MiFwkUIPlugin.showErrorDialog(status, "Error on Save", sTracer); //$NON-NLS-1$
		}
		// process versioning for the partitions to be saved to ensure that they
		// are writable. reason: it might occur that the user reverts a checked
		// out model partition before saving versioning is only required for
		// partitions already existing on disc
		Collection<PartitionOperation> affectedPartitions = ConnectionManager.getInstance().getPartitionsToBeSaved(
				connection, true);
		IStatus versioningResult = MiFwkUIPlugin.getIdeCompoundDataAreaManager()
				.prepareModification(affectedPartitions);
		if (!versioningResult.isOK()) {
			return MiFwkUIPlugin.showErrorDialog(versioningResult.getException(), null,
					"prepareModification failed", sTracer); //$NON-NLS-1$
		}
		// 
		try {
			ModelManager.getConnectionManager().save(connection);
		} catch (NullPartitionNotEmptyException e) { // $JL-EXC$
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			IStatus result = handleNullAndReferencedTransientElements(connection, project, shell);
			if (result.isOK()) {
				try {
					ModelManager.getConnectionManager().save(connection);
					return Status.OK_STATUS;
				} catch (Exception e1) {
					return MiFwkUIPlugin.showErrorDialog(e1, null, "Error on Save", sTracer); //$NON-NLS-1$
				}
			} else {
				return result;
			}
		} catch (ReferencedTransientElementsException e) { // $JL-EXC$
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			IStatus result = handleNullAndReferencedTransientElements(connection, project, shell);
			if (result.isOK()) {
				try {
					ModelManager.getConnectionManager().save(connection);
					return Status.OK_STATUS;
				} catch (Exception e1) {
					return MiFwkUIPlugin.showErrorDialog(e1, null, "Error on Save", sTracer); //$NON-NLS-1$
				}
			} else {
				return result;
			}
		} catch (PartitionsNotSavedException e) {
			StringBuilder msg = new StringBuilder("The following partitions could not be saved:\n"); //$NON-NLS-1$
			Collection<PRI> pris = e.getPartitions();
			for (PRI pri : pris) {
				msg.append(pri.toString());
				msg.append(System.getProperty("line.separator")); //$NON-NLS-1$
			}
			return MiFwkUIPlugin.showErrorDialog(e, msg.toString(), "Error on Save", sTracer); //$NON-NLS-1$

		} catch (Exception e) {
			return MiFwkUIPlugin.showErrorDialog(e, null, "Error on Save", sTracer); //$NON-NLS-1$
		}
		return Status.OK_STATUS;
	}

	/**
	 * Performs a safeguarded save operation of all connections in the given
	 * project, which corresponds to a "save all" operation for the project. See
	 * {@link #save(Connection, IProgressMonitor)} for details. This method must
	 * be called from the UI thread.
	 * <p/>
	 * <b>Note:</b><br>
	 * This method must be called from the <b>UI thread</b>, otherwise an
	 * <code>IllegalStateException</code> is thrown.
	 * 
	 * @param project
	 *            the project to save
	 * @param monitor
	 *            a progress monitor
	 * @return a status indicating whether save was successful
	 * @exception IllegalStateException
	 *                if this method is called from a <b>NON-UI thread</b>
	 */
	public IStatus saveAll(IProject project, IProgressMonitor monitor) {
		Collection<Connection> connections = ModelManager.getConnectionManager().getConnections(project);
		return saveAll(connections, monitor);
	}

	/**
	 * Performs a safeguarded save operation of the given connections, which
	 * corresponds to a "save all" operation for the project. See
	 * {@link #save(Connection, IProgressMonitor)} for details. This method must
	 * be called from the UI thread.
	 * <p/>
	 * <b>Note:</b><br>
	 * This method must be called from the <b>UI thread</b>, otherwise an
	 * <code>IllegalStateException</code> is thrown.
	 * 
	 * @param connections
	 *            the connections to save
	 * @param monitor
	 *            a progress monitor
	 * @return a status indicating whether save was successful
	 * @exception IllegalStateException
	 *                if this method is called from a <b>NON-UI thread</b>
	 */
	public IStatus saveAll(Collection<Connection> connections, IProgressMonitor monitor) {
		if (Display.getCurrent() == null) {
			throw new IllegalStateException(
					"Must be called from the UI thread. Use ConnectionManager.save() otherwise."); //$NON-NLS-1$
		}

		ModelEditorManager editorManager = ModelManagerUI.getEditorManager();
		ConnectionManager connectionManager = ModelManager.getConnectionManager();

		Collection<IModelEditor> editors = editorManager.getAllActiveModelEditors(connections);
		if (!editors.isEmpty()) {
			boolean success = editorManager.saveDirtyModelEditors(editors, true);
			if (!success)
				return Status.CANCEL_STATUS; // user has cancelled
		}

		// TODO [Connections] improve to only show one dialog for multiple
		// connections
		for (Connection connection : connections) {
			if (!connection.isAlive() || !connectionManager.isDirty(connection))
				continue;
			IProject project = ModelAdapterUI.getInstance().getProject(connection);
			IStatus result = save(connection, project, monitor);
			if (!result.isOK())
				return result;
		}
		return Status.OK_STATUS;
	}

	/**
	 * Tries to recover from any referenced transient elements and/or the null
	 * partition not being empty by raising a dialog where the user can assign
	 * the null contents to a real partition. Also, in rarer cases, handles
	 * elements from transient partitions that are referenced from the
	 * partitions to save ({@link ReferencedTransientElementsException}).
	 * 
	 * @return a status indicating the success of the operation, e.g.
	 *         <code>IStatus.CANCEL</code> if the user canceled
	 */
	private IStatus handleNullAndReferencedTransientElements(Connection connection, IProject project, Shell shell) {
		AssignElementsDialog dialog = new AssignElementsDialog(connection, project, shell);
		int returnCode = dialog.open();
		if (!connection.isAlive()) {
			return MiFwkUIPlugin.createStatus(IStatus.ERROR, "Connection no longer valid: " + connection, null); //$NON-NLS-1$
		}
		PartitionService partitionService = PartitionService.getInstance();
		if (Window.OK == returnCode) {
			ModelPartition partition = dialog.getSelectedPartition();
			partitionService.clearNullPartition(connection, partition);
			partitionService.clearReferencedTransientElements(connection, partition);
			return Status.OK_STATUS;
		} else if (AssignElementsDialog.CLEAR == returnCode) {
			partitionService.clearNullPartition(connection, null);
			partitionService.clearReferencedTransientElements(connection, null);
			return Status.OK_STATUS;
		} else {
			return Status.CANCEL_STATUS;
		}
	}

	private ConnectionManagerUI() {
	}

	private static abstract class CreateConnectionJob extends Job {
		private final IRunnableWithConnection followUp;

		private CreateConnectionJob(String name, IRunnableWithConnection followUp) {
			super(name);
			this.followUp = followUp;
		}

		protected abstract Connection doRun(IProgressMonitor monitor);

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			final Connection connection = doRun(monitor);

			if (this.followUp != null) {
				Job uiUpdateJob = new UIJob(MiFwkUiMessages.ConnectionManagerUI_Message_UI_Update) {
					@Override
					public IStatus runInUIThread(IProgressMonitor monitor) {
						if (sTracer.info()) {
							sTracer.info("Running UI update in thread " + Thread.currentThread().getName()); //$NON-NLS-1$
						}
						followUp.run(connection, monitor);
						monitor.done();
						return Status.OK_STATUS;
					}
				};
				uiUpdateJob.schedule();
			}
			monitor.done();
			return Status.OK_STATUS;
		}
	}

}
