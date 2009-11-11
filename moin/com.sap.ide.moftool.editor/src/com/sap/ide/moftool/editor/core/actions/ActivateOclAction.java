package com.sap.ide.moftool.editor.core.actions;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.IProgressService;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.core.ocl.OclConstraintActivator;
import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ui.ModelManagerUI;
import com.sap.tc.moin.repository.Connection;

public class ActivateOclAction implements IObjectActionDelegate {

	private IProject mProject = null;

	public ActivateOclAction() {
		super();
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// Nothing to do
	}

	public void run(IAction action) {
		
		Connection connection = MofService.createConnectionWithBusyCursorWhile(mProject); 
		if (connection == null) {
			return;
		}
		// Do forced activation
		OclConstraintActivator activator = new OclConstraintActivator(connection);
		activator.forcedActivate();
		
        // Save changes
       	ModelManagerUI.getConnectionManagerUI().save(connection, mProject, null);
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IProject) {
			mProject = (IProject)selection;
		}
		else if (selection instanceof StructuredSelection) {
			StructuredSelection strSel = (StructuredSelection)selection;
			Object object = strSel.getFirstElement();
			if (object instanceof IProject) {
				mProject = (IProject)object;
			}
		}
	}

}
