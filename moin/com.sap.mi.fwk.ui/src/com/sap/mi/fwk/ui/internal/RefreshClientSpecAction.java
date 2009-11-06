package com.sap.mi.fwk.ui.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.cdam.ide.internal.IdeFacilityDispatcherInternal;

/**
 * Refreshes the {@link ClientSpec} of the given project(s)
 * 
 * @author d031150
 */
public class RefreshClientSpecAction extends AbstractHandler {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_MODELHANDLING);
	public static final String PREF_KEY_SUPPRESS_SAVE_DIALOG_ON_REFRESH = MiFwkUIPlugin.PLUGIN_ID + ".suppressSaveDialogOnRefresh"; //$NON-NLS-1$

	public RefreshClientSpecAction() {
		super();
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart targetPart = HandlerService.getActivePart(event);
		IWorkbenchPartSite targetSite = targetPart.getSite();

		Object[] selectionElements = HandlerService.getSelection(event).toArray();
		final List<IProject> projects = HandlerService.getSelectedProjects(event);
		if (projects.isEmpty()) {
			return null;
		}

		long startTime = HandlerService.startTimer(sTracer);

		// Raise dialog to inform user about editors to save (if not
		// suppressed).
		// Technically we save connections, however, for matters of simplicity
		// we only mention editors since unsaved views should never happen.
		IPreferenceStore prefStore = MiFwkUIPlugin.getDefault().getPreferenceStore();
		boolean suppress = prefStore.getBoolean(PREF_KEY_SUPPRESS_SAVE_DIALOG_ON_REFRESH);
		if (!suppress) {
			ConnectionManager connectionManager = ModelManager.getConnectionManager();
			for (IProject project : projects) {
				if (!connectionManager.getDirtyConnections(project).isEmpty()) {
					MessageDialogWithToggle dialog = createSaveDialog(targetSite.getShell(), prefStore);
					Boolean toggleState = showSaveDialog(dialog);
					if (toggleState == null) {
						return null;
					}
					break;
				}
			}
		}

		// first save all dirty connections of project in UI thread
		IRunnableWithProgress saveOp = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				if (monitor == null) {
					monitor = new NullProgressMonitor();
				}
				try {
					monitor.beginTask(MiFwkUiMessages.RefreshModelData_monitor_saving, projects.size());
					for (IProject project : projects) {
						if (monitor.isCanceled()) {
							throw new InterruptedException();
						}
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
				if (monitor == null) {
					monitor = new NullProgressMonitor();
				}
				try {
					monitor.beginTask(MiFwkUiMessages.RefreshModelData_monitor_refreshing, projects.size());
					for (IProject project : projects) {
						if (monitor.isCanceled()) {
							throw new InterruptedException();
						}
						String projectName = MiFwkUIPlugin.getProjectLabel(project);
						monitor.subTask(projectName);

						doRefresh(project);

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

		HandlerService.stopTimer(startTime, "Refreshing ClientSpec", sTracer); //$NON-NLS-1$

		return null;
	}

	private void refreshVisual(IWorkbenchPart part, Object[] elements) {
		if (part instanceof CommonNavigator) {
			CommonNavigator nav = (CommonNavigator) part;
			CommonViewer viewer = nav.getCommonViewer();
			Control control = viewer.getControl();
			if (control.isDisposed()) {
				return;
			}
			control.setRedraw(false);
			try {
				// It would be more efficient to only refresh the selected
				// elements, however, as long as we experience issues with stale
				// UI (double nodes etc.), we refresh the whole tree.
				viewer.refresh();
			} finally {
				if (!control.isDisposed()) {
					control.setRedraw(true);
				}
			}
		}
	}

	protected Boolean showSaveDialog(MessageDialogWithToggle dialog) {
		if (dialog.open() != Window.OK) {
			return null;
		}
		return dialog.getToggleState();
	}

	protected MessageDialogWithToggle createSaveDialog(Shell shell, IPreferenceStore prefStore) {
		MessageDialogWithToggle dialog = new MessageDialogWithToggle(shell, MiFwkUiMessages.RefreshModelData_saveDialog_title, null,
				MiFwkUiMessages.RefreshModelData_saveDialog_text, MessageDialogWithToggle.QUESTION, new String[] {
						IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL }, 0,
				MiFwkUiMessages.RefreshModelData_saveDialog_text_askAgain, false);
		dialog.setPrefStore(prefStore);
		dialog.setPrefKey(PREF_KEY_SUPPRESS_SAVE_DIALOG_ON_REFRESH);
		return dialog;
	}

	protected void doRefresh(IProject project) {
		IdeFacilityDispatcherInternal dispatcher = (IdeFacilityDispatcherInternal) MiFwkUIPlugin.getIdeCompoundDataAreaManager();
		dispatcher.refreshClientSpecFromFileSystem(project);
	}

}
