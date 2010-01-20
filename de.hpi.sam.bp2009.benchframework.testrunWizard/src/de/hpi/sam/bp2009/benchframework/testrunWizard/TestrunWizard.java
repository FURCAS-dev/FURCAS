package de.hpi.sam.bp2009.benchframework.testrunWizard;
import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class TestrunWizard extends Wizard implements INewWizard
{

//	StartPage startPage;
//	OptionPage optionPage;
//	FinalPage finalPage;
//	
//	TestrunModel model;
	
	protected IStructuredSelection selection;
	
	protected IWorkbench workbench;

	public TestrunWizard() {
		super();
//		model = new TestrunModel();
	}
	
	public void addPages()
	{
//		startPage = new StartPage(workbench, selection);
//		addPage(startPage);
//		optionPage = new OptionPage("Option Page");
//		addPage(optionPage);
//		finalPage = new FinalPage("Final Page");
//		addPage(finalPage);
	}

	/**
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) 
	{
		//TODO implementieren
		this.workbench = workbench;
		this.selection = selection;
	}

	public boolean canFinish()
	{
		//TODO implementieren
		return true;
	}
	
	public boolean performFinish() 
	{
		//TODO implementieren
		return true;
	}
}
