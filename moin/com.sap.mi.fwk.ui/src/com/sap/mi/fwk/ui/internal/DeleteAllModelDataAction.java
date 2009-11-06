package com.sap.mi.fwk.ui.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.PRI;

/**
 * Deletes all model partitions in the selected projects
 * 
 * @author d031150
 */
public final class DeleteAllModelDataAction extends AbstractHandler {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_MODELHANDLING);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart targetPart = HandlerUtil.getActivePartChecked(event);

		final List<IProject> projects = HandlerService.getSelectedProjects(event);
		if (projects.isEmpty())
			return null;

		long startTime = HandlerService.startTimer(sTracer);

		String lineSep = System.getProperty("line.separator"); //$NON-NLS-1$
		StringBuilder projectNames = new StringBuilder(lineSep);
		for (IProject project : projects) {
			projectNames.append("\t"); //$NON-NLS-1$
			projectNames.append(MiFwkUIPlugin.getProjectLabel(project));
			projectNames.append(lineSep);
		}

		Shell shell = targetPart.getSite().getShell();
		boolean proceed = MessageDialog.openQuestion(shell, MiFwkUiMessages.DeleteModelData_confirmDialog_title,
				MiFwkUiMessages.bind(MiFwkUiMessages.DeleteModelData_confirmDialog_text, projectNames));
		if (!proceed)
			return null;

		final Collection<PRI> deleted = new HashSet<PRI>();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				IStatus result = PartitionService.getInstance().deletePartitions(projects, deleted, monitor);
				if (IStatus.CANCEL == result.getSeverity())
					throw new InterruptedException();
				if (!result.isOK())
					throw new InvocationTargetException(new CoreException(result));
			}
		};

		HandlerService.run(op, true, projects.size() > 1, event, sTracer);

		HandlerService.stopTimer(startTime, "Deletion of " + deleted.size() + " partition(s)", sTracer); //$NON-NLS-1$ //$NON-NLS-2$

		return null;
	}
}