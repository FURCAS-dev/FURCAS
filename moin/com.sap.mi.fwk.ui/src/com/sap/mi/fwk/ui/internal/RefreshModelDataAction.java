package com.sap.mi.fwk.ui.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * Aligns the MOIN in-memory state with the filesystem persistence for a number
 * of projects
 * 
 * @see ModelManager#refreshFromFileSystem(IProject)
 * 
 * @author d031150
 */
public final class RefreshModelDataAction extends AbstractHandler {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_MODELHANDLING);
	private static final String PREF_KEY_SAVE_CONNECTIONS_ON_REFRESH = "saveConnectionsOnRefresh"; //$NON-NLS-1$

	public RefreshModelDataAction() {
		super();
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart targetPart = HandlerService.getActivePart(event);
		IWorkbenchPartSite targetSite = targetPart.getSite();

		Object[] selectionElements = HandlerService.getSelection(event).toArray();
		final List<IProject> projects = HandlerService.getSelectedProjects(event);
		if (projects.isEmpty())
			return null;

		long startTime = HandlerService.startTimer(sTracer);

		// Raise dialog to inform user about editors to save (if not
		// suppressed).
		// Technically we save connections, however, for matters of simplicity
		// we only mention editors since unsaved views should never happen.
		IPreferenceStore prefStore = MiFwkUIPlugin.getDefault().getPreferenceStore();
		boolean suppress = prefStore.getBoolean(PREF_KEY_SAVE_CONNECTIONS_ON_REFRESH);
		if (!suppress) {
			ConnectionManager connectionManager = ModelManager.getConnectionManager();
			for (IProject project : projects) {
				if (!connectionManager.getDirtyConnections(project).isEmpty()) {
					MessageDialogWithToggle dialog = MessageDialogWithToggle.openOkCancelConfirm(targetSite.getShell(),
							MiFwkUiMessages.RefreshModelData_saveDialog_title, MiFwkUiMessages.RefreshModelData_saveDialog_text,
							MiFwkUiMessages.RefreshModelData_saveDialog_text_askAgain, suppress, null, null);
					if (dialog.getReturnCode() != Window.OK)
						return null;
					suppress = dialog.getToggleState();
					prefStore.setValue(PREF_KEY_SAVE_CONNECTIONS_ON_REFRESH, suppress);
					break;
				}
			}
		}

		// first save all dirty connections of project in UI thread
		IRunnableWithProgress saveOp = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				if (monitor == null)
					monitor = new NullProgressMonitor();
				try {
					monitor.beginTask(MiFwkUiMessages.RefreshModelData_monitor_saving, projects.size());
					for (IProject project : projects) {
						if (monitor.isCanceled())
							throw new InterruptedException();
						String projectName = MiFwkUIPlugin.getProjectLabel(project);
						monitor.subTask(projectName);
						ConnectionManagerUI ui = ConnectionManagerUI.getInstance();
						IStatus result = ui.saveAll(project, monitor);
						monitor.worked(1);
						if (!result.isOK()) {
							// error was already shown, just stop here
							throw new InterruptedException();
						}
					}
				} finally {
					monitor.done();
				}
			}
		};

		// We can only cancel in between multiple projects to refresh. In
		// case of a single project, explicitly disable cancel button.
		HandlerService.run(saveOp, false, projects.size() > 1, event, sTracer);

		// trigger refresh in background with blocking dialog
		final IRunnableWithProgress refreshOp = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				if (monitor == null)
					monitor = new NullProgressMonitor();
				try {
					monitor.beginTask(MiFwkUiMessages.RefreshModelData_monitor_refreshing, projects.size());
					ModelManager modelManager = ModelManager.getInstance();
					for (IProject project : projects) {
						if (monitor.isCanceled())
							throw new InterruptedException();
						String projectName = MiFwkUIPlugin.getProjectLabel(project);
						monitor.subTask(projectName);
						IStatus result = modelManager.refreshFromFileSystem(project, monitor);
						if (!result.isOK()) {
							if (IStatus.CANCEL == result.getSeverity())
								throw new InterruptedException();
							else
								throw new InvocationTargetException(new CoreException(result));
						}
						monitor.worked(1);
					}
				} finally {
					monitor.done();
				}
			}
		};

		// We can only cancel in between multiple projects to refresh. In
		// case of a single project, explicitly disable cancel button.
		HandlerService.run(refreshOp, true, projects.size() > 1, event, sTracer);

		refreshVisual(targetPart, selectionElements);

		HandlerService.stopTimer(startTime, "Refreshing model data", sTracer); //$NON-NLS-1$

		return null;
	}

	private void refreshVisual(IWorkbenchPart part, Object[] elements) {
		if (part instanceof CommonNavigator) {
			CommonNavigator nav = (CommonNavigator) part;
			CommonViewer viewer = nav.getCommonViewer();
			Control control = viewer.getControl();
			if (control.isDisposed())
				return;
			control.setRedraw(false);
			try {
				// It would be more efficient to only refresh the selected
				// elements, however, as long as we experience issues with stale
				// UI (double nodes etc.), we refresh the whole tree.
				viewer.refresh();
			} finally {
				if (!control.isDisposed())
					control.setRedraw(true);
			}
		}
	}

}
