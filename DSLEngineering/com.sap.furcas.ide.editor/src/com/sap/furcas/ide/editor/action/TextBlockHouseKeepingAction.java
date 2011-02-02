package com.sap.furcas.ide.editor.action;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.sap.furcas.ide.editor.commands.TextBlockHouseKeepingCommand;

public class TextBlockHouseKeepingAction implements IObjectActionDelegate {

    private IProject project;

    @Override
    public void run(IAction action) {
        //TODO: create resource set containing all resources of the project
	ResourceSet co = new ResourceSetImpl();
	TextBlockHouseKeepingCommand cmd = new TextBlockHouseKeepingCommand(co, project);
	cmd.execute();
	for (Resource r : co.getResources()) {
            try {
                r.save(null);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
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

    

}
