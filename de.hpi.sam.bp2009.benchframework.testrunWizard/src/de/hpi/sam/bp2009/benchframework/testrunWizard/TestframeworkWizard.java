package de.hpi.sam.bp2009.benchframework.testrunWizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class TestframeworkWizard extends Wizard implements INewWizard {
	FirstPage firstPage;
	
	public void addPages() {
        firstPage = new FirstPage("Personal Information Page");
        addPage(firstPage);
	}
	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean canFinish() {
		// TODO Do something useful here!
		return false;		
	}
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub
		
	}

}
