package com.sap.mi.fwk.dcfwk.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.mi.fwk.dcfwk.MoinDcOptions;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.mi.fwk.dcfwk.internal.messages.DcFwkMessages;

/**
 * Aligns the DC's public parts with the ones specified in the DC type
 * implementation
 * 
 * @author d031150
 * 
 * @see MoinProject#repairDc(IDevelopmentComponent, MoinDcOptions,
 *      IProgressMonitor)
 */
public final class RepairDcAction extends AbstractHandler {

	private static final Logger stracer = Logger.getLogger(RepairDcAction.class.getName());

	public RepairDcAction() {
		super();
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPart targetPart = HandlerUtil.getActivePartChecked(event);
		IWorkbench workbench = targetPart.getSite().getWorkbenchWindow().getWorkbench();
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);

		Object[] selectionElements = selection.toArray();
		final List<IProject> projects = new ArrayList<IProject>(selectionElements.length);
		for (Object element : selectionElements) {
			if (element instanceof IProject)
				projects.add((IProject) element);
		}

		long tm = 0L;
		if (stracer.isLoggable(Level.FINE))
			tm = System.currentTimeMillis();

		final IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				if (monitor == null)
					monitor = new NullProgressMonitor();
				try {
					monitor.beginTask(DcFwkMessages.RepairDcAction_repairing, projects.size());
					for (IProject project : projects) {
						if (monitor.isCanceled())
							throw new InterruptedException();
						IDevelopmentComponent dc = DiiResourceService.getDevelopmentComponent(project);
						if (dc == null)
							continue;
						MoinProject.repairDc(dc, null, monitor);
						monitor.worked(1);
					}
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};

		try {
			// We can only cancel in between multiple projects to repair. In
			// case of a single project, explicitly disable cancel button.
			if (projects.size() < 2)
				workbench.getProgressService().run(true, false, op);
			else
				workbench.getProgressService().busyCursorWhile(op);
		} catch (InvocationTargetException e) { // $JL-EXC$
			Throwable cause = e.getCause();
			DcFwkPlugin.showErrorDialog(cause, "Repair could not be performed", "Error on Repair", sTracer); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (InterruptedException e) { // $JL-EXC$
		} catch (OperationCanceledException e) { // $JL-EXC$
		}

		if (stracer.isLoggable(Level.FINE)) {
			tm = System.currentTimeMillis() - tm;
			stracer.log(Level.FINE, "Repair took " + tm + "ms"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return null;
	}

}
