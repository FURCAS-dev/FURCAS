package com.sap.mi.fwk.ui.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.progress.IProgressService;
import org.eclipse.ui.progress.IWorkbenchSiteProgressService;

import com.sap.mi.fwk.ModelAdapter;
import com.tssap.util.trace.TracerI;

/**
 * Contains utility methods for {@link IHandler command handlers}
 * 
 * @author d031150
 */
public final class HandlerService {

	/**
	 * Returns the selected projects out of the given event
	 */
	public static List<IProject> getSelectedProjects(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection selection = getSelection(event);
		ModelAdapter adapter = ModelAdapter.getInstance();

		Object[] selectionElements = selection.toArray();
		final List<IProject> projects = new ArrayList<IProject>(selectionElements.length);
		for (Object element : selectionElements) {
			IProject project = adapter.adaptObject(element, IProject.class);
			if (project != null)
				projects.add(project);
		}
		return projects;
	}

	/**
	 * Returns the selection out of the given event
	 */
	public static IStructuredSelection getSelection(ExecutionEvent event) throws ExecutionException {
		return (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
	}

	/**
	 * Returns the active part out of the given event
	 */
	public static IWorkbenchPart getActivePart(ExecutionEvent event) throws ExecutionException {
		return HandlerUtil.getActivePartChecked(event);
	}

	/**
	 * Returns the progress service of the given part
	 */
	public static IProgressService getProgressService(IWorkbenchPart part) {
		IProgressService siteService = (IProgressService) part.getSite()
				.getAdapter(IWorkbenchSiteProgressService.class);
		if (siteService != null)
			return siteService;
		return part.getSite().getWorkbenchWindow().getWorkbench().getProgressService();
	}

	/**
	 * Runs the given operation. In case of errors a dialog is raised.
	 * 
	 * @param op
	 *            the operation to execute
	 * @param fork
	 *            <code>true</code> if the operation should be run in a
	 *            separate thread, and <code>false</code> to run in the same
	 *            thread
	 * @param cancelable
	 *            <code>true</code> to enable the cancelation, and
	 *            <code>false</code> to make the operation uncancellable
	 * @param event
	 *            the execution event
	 * @param tracer
	 *            the tracer to log errors to.
	 */
	public static void run(IRunnableWithProgress op, boolean fork, boolean cancelable, ExecutionEvent event,
			TracerI tracer) {
		try {
			IWorkbenchPart targetPart = getActivePart(event);
			if (fork && cancelable) {
				getProgressService(targetPart).busyCursorWhile(op);
			} else {
				targetPart.getSite().getWorkbenchWindow().run(fork, cancelable, op);
			}
		} catch (InvocationTargetException e) { // $JL-EXC$
			String title = "An Error Occured"; //$NON-NLS-1$
			Throwable cause = e.getCause();
			if (cause instanceof CoreException) {
				CoreException ce = (CoreException) cause;
				MiFwkUIPlugin.showErrorDialog(ce.getStatus(), title, tracer);
			} else {
				MiFwkUIPlugin.showErrorDialog(cause, cause.getMessage(), title, tracer);
			}
		} catch (ExecutionException e) {
			String title = "An Error Occured"; //$NON-NLS-1$
			MiFwkUIPlugin.showErrorDialog(e, e.getMessage(), title, tracer);
		} catch (InterruptedException e) { // $JL-EXC$
		} catch (OperationCanceledException e) { // $JL-EXC$
		}
	}

	/**
	 * Returns the current time. To be used as start time to measure the
	 * operation.
	 */
	public static long startTimer(TracerI tracer) {
		long time = 0L;
		if (tracer.debug())
			time = System.currentTimeMillis();
		return time;
	}

	/**
	 * Logs a message with duration of the executed operation
	 * 
	 * @param startTime
	 *            the time returned by {@link #startTimer(TracerI)}
	 * @param taskName
	 *            the name of the operation
	 * @param tracer
	 *            the tracer for logging
	 */
	public static void stopTimer(long startTime, String taskName, TracerI tracer) {
		if (tracer.debug()) {
			long duration = System.currentTimeMillis() - startTime;
			tracer.debug(taskName + " took " + duration + "ms"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

}
