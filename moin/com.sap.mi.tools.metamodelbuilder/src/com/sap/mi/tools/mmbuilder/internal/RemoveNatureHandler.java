package com.sap.mi.tools.mmbuilder.internal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.progress.IProgressService;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * For internal use only, not intended to be used by external clients.
 */
public final class RemoveNatureHandler extends AbstractHandler {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_METAMODELBUILDER);

	public Object execute(ExecutionEvent arg0) throws ExecutionException {

		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(arg0);
		final Object[] objs = selection.toArray();

		IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InterruptedException {
				monitor.beginTask(MMBuilderMessages.RemoveNatureHandler_removing, objs.length);
				for (Object object : objs) {

					MMBuilderHelper.checkCancellation(monitor);

					IProject project = MMBuilderHelper.getProject(object);
					if (project != null) {
						if (project.isAccessible() && MetamodelBuildNature.hasMetamodelBuilderNature(project)) {
							String msg = MMBuilderMessages.bind(MMBuilderMessages.RemoveNatureHandler_project, project.getName());
							monitor.subTask(msg);
							try {
								removeNature(project, monitor);
							} catch (OperationCanceledException e) {
								throw new InterruptedException();
							} catch (CoreException e) {
								sTracer.error("Error removing nature for project: " + project.getName(), e); //$NON-NLS-1$
							}
						}
					}
				}
				monitor.done();
			}
		};

		try {
			IProgressService ps = PlatformUI.getWorkbench().getProgressService();
			ps.busyCursorWhile(operation);
		} catch (InterruptedException e) {
			// $JL-EXC$
			// do nothing if user or eclipse cancels
			sTracer.debug("Operation canceled by user"); //$NON-NLS-1$
		} catch (Exception e) {
			sTracer.error("Exception during nature removal", e); //$NON-NLS-1$
			final Shell shell = HandlerUtil.getActiveShellChecked(arg0);
			MessageDialog
					.openError(shell, MMBuilderMessages.RemoveNatureHandler_errorTitle, MMBuilderMessages.RemoveNatureHandler_errorMsg);
		}
		return null;
	}

	/**
	 * Toggles sample nature on a project
	 * 
	 * @param project
	 *            to have sample nature added or removed
	 * @throws CoreException
	 *             , OperationCanceledException
	 */
	private void removeNature(IProject project, IProgressMonitor monitor) throws CoreException, OperationCanceledException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();

		Set<String> naturesSet = new HashSet<String>(natures.length);
		naturesSet.addAll(Arrays.asList(natures));
		naturesSet.remove(MMBuilderConstants.NATURE_ID);

		description.setNatureIds(naturesSet.toArray(new String[naturesSet.size()]));
		IProgressMonitor subMon = new SubProgressMonitor(monitor, 1);
		project.setDescription(description, subMon);
	}
}
