/*******************************************************************************
 *
 *******************************************************************************/
package com.sap.furcas.ide.dslproject.projectwizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.progress.UIJob;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.ide.dslproject.conf.IProjectMetaRefConf;

public class TCSProjectsWizard extends Wizard implements INewWizard {

    private TCSProjectsWizardPage page;
    private ISelection selection;
    private TCSProjectsWizardMetaModelPage page2;

    public TCSProjectsWizard() {
	super();
	setNeedsProgressMonitor(true);
    }

    @Override
    public void addPages() {
	page = new TCSProjectsWizardPage(selection);
	addPage(page);

	page2 = new TCSProjectsWizardMetaModelPage(selection);
	addPage(page2);
    }

    @Override
    public boolean performFinish() {
	final ProjectInfo pi = page.getProjectInfo();

	if (page2.isValidSelection()) {

	    IRunnableWithProgress op = new IRunnableWithProgress() {
		@Override
		public void run(IProgressMonitor monitor) throws InvocationTargetException {
		    try {

			doFinish(pi, monitor);

		    } finally {
			monitor.done();
		    }
		}
	    };

	    try {
		getContainer().run(true, false, op);
	    } catch (InterruptedException e) {
		return false;
	    } catch (InvocationTargetException e) {
		Throwable realException = e.getTargetException();
		MessageDialog.openError(getShell(), "Error", realException.getMessage());
		return false;
	    }
	    return true;
	} else {
	    return false;
	}
    }

    void doFinish(final ProjectInfo pi, IProgressMonitor monitor) {
	new UIJob("creating FURCAS projects...") {
	    @Override
	    public IStatus runInUIThread(IProgressMonitor monitor) {
		try {
		    IProjectMetaRefConf conf = page2.getCurrentlySelectedMMConf();
		    new ProjectCreator(pi, conf, getShell()).run(monitor);

		} catch (InvocationTargetException e) {
		    Activator.logger.logError("", e);
		} catch (InterruptedException e) {
		    Activator.logger.logError("", e);
		}
		return Status.OK_STATUS;
	    }

	}.schedule();

    }

    /**
     * We will accept the selection in the workbench to see if we can initialize
     * from it.
     * 
     * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
     */
    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
	this.selection = selection;
    }
}