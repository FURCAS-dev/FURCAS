package com.sap.ide.cts.editor.action;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.ide.cts.editor.commands.TextBlockHouseKeepingCommand;

public class TextBlockHouseKeepingAction implements IObjectActionDelegate {

    private IProject project;

    @Override
    public void run(IAction action) {
	ResourceSet co = getConnection(project);
	TextBlockHouseKeepingCommand cmd = new TextBlockHouseKeepingCommand(co, project);
	cmd.execute();
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
	Object obj = (((IStructuredSelection) selection).getFirstElement());
	this.project = null;
	if (obj != null && obj instanceof IProject) {
	    this.project = ((IProject) obj).getProject();
	}
    }

    @Override
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	// unused
    }

    private ResourceSet getConnection(final IProject project) {
	final ResourceSet[] connection = new ResourceSet[1];
	IRunnableWithProgress operation = new IRunnableWithProgress() {
	    public void run(IProgressMonitor monitor) throws InterruptedException {
		// non UI thread
		try {
		    project.open(/* progress monitor */null);
		} catch (CoreException e) {
		    throw new RuntimeException(e);
		}
		connection[0] = ConnectionManager.getInstance().getOrCreateDefaultConnection(project);
	    }
	};
	IProgressService ps = PlatformUI.getWorkbench().getProgressService();
	try {
	    ps.busyCursorWhile(operation);
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
	return connection[0];
    }

}
