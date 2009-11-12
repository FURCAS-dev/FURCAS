package com.sap.ide.moftool.editor.core.actions;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

public class CreateJaProPluginProjectAction implements IObjectActionDelegate {

	IProject mProject = null;

	public CreateJaProPluginProjectAction() {
		super();
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

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// Nothing to do
	}

	public void run(IAction action) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		//CreateJaProPluginProjectWizard wizard = new CreateJaProPluginProjectWizard(mProject);
//		WizardDialog dialog = new WizardDialog(shell, wizard);
//		dialog.open();
	}
}
