package com.sap.mi.textual.epi.builder;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.sap.furcas.parsergenerator.tcs.generator.errorhandling.EclipseMarkerUtil;
import com.sap.mi.textual.epi.Activator;
import com.sap.mi.textual.epi.Messages;
import com.sap.mi.textual.epi.conf.ProjectMetaRefConfFactory;
import com.sap.mi.textual.epi.ui.AddSyntaxNatureWizard;

/**
 * The Class ToggleNatureAction.
 */
public class ToggleNatureAction implements IObjectActionDelegate {

    /** The selection. */
    private ISelection selection;

    /** The target part. */
    private IWorkbenchPart targetPart;

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    @Override
    public void run(IAction action) {
	if (selection instanceof IStructuredSelection) {
	    for (Iterator<?> it = ((IStructuredSelection) selection).iterator(); it.hasNext();) {
		Object element = it.next();
		IProject project = null;
		if (element instanceof IProject) {
		    project = (IProject) element;
		} else if (element instanceof IAdaptable) {
		    project = (IProject) ((IAdaptable) element).getAdapter(IProject.class);
		}
		if (project != null) {
		    Shell shell = targetPart.getSite().getShell();
		    // Add the nature, first let the user select a Metamodel
		    // Reference configuration, then set it
		    toggleNature(project, shell);
		    EclipseProjectBuildStarter.buildProject(project, shell);
		}
	    }
	}
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action
     * .IAction, org.eclipse.jface.viewers.ISelection)
     */
    @Override
    public void selectionChanged(IAction action, ISelection selection) {
	// if (selection instanceof IProject) {
	// IProject project = (IProject) selection;
	// if (SyntaxGenerationNature.getNatureFromProject(project) != null) {
	// action.setEnabled(false);
	// }
	// }
	this.selection = selection;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.
     * action.IAction, org.eclipse.ui.IWorkbenchPart)
     */
    @Override
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	this.targetPart = targetPart;
    }

    /**
     * Toggles sample nature on a project.
     * 
     * @param project
     *            to have sample nature added or removed
     */
    public static void toggleNature(IProject project, org.eclipse.swt.widgets.Shell shell) {
	try {
	    IProjectDescription description = project.getDescription();
	    String[] natures = description.getNatureIds();

	    for (int i = 0; i < natures.length; ++i) {
		if (SyntaxGenerationNature.NATURE_ID.equals(natures[i])) {
		    MessageBox questionDiag = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
		    questionDiag.setText(Messages.ToggleNatureAction_RemoveNatureConfirmTitle);
		    questionDiag.setMessage(Messages.ToggleNatureAction_RemoveNatureConfirmText);
		    if (questionDiag.open() == SWT.YES) {

			EclipseMarkerUtil.deleteAllSyntaxMarkers(project, shell);
			// Remove the nature
			String[] newNatures = new String[natures.length - 1];
			System.arraycopy(natures, 0, newNatures, 0, i);
			System.arraycopy(natures, i + 1, newNatures, i, natures.length - i - 1);
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
			ProjectMetaRefConfFactory.removeConfiguration(project);
			MessageBox confirmationDiag = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
			confirmationDiag.setText(Messages.Success);
			confirmationDiag.setMessage(Messages.RemoveNatureSuccessMessage);
			confirmationDiag.open();
		    }
		    return;
		}
	    }
	    AddSyntaxNatureWizard wizard = new AddSyntaxNatureWizard(project);
	    WizardDialog wizardDialog = new WizardDialog(shell, wizard);
	    wizardDialog.setHelpAvailable(false);

	    if (wizardDialog.open() == WizardDialog.OK) {

		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = SyntaxGenerationNature.NATURE_ID;
		// newNatures[natures.length] = "syntaxGenerationNature;";
		description.setNatureIds(newNatures);
		project.setDescription(description, null);
		ProjectMetaRefConfFactory.configure(project, wizard.getSelectedReferenceConf());
	    }
	} catch (CoreException e) {
	    Activator.logger.logError("Failed to toggle nature", e);
	}
    }
}
