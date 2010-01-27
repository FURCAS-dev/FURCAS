package de.hpi.sam.bp2009.benchframework.testrunWizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.TestRun;
import de.hpi.sam.bp2009.benchframework.oclOperator.impl.OclOperatorImpl;

public class TestframeworkWizard extends Wizard implements INewWizard {

	private ListPage listPage = new ListPage("Module List");
	TestRun run=BenchframeworkFactory.eINSTANCE.createTestRun();
	
	protected IStructuredSelection selection;
	
	protected IWorkbench workbench;
	private WizardUserInterfaceImpl intImpl;
	
	public WizardUserInterfaceImpl getIntImpl() {
		return intImpl;
	}

	public void setIntImpl(WizardUserInterfaceImpl intImpl) {
		this.intImpl = intImpl;
	}

	
	public void addPages() {
		addPage(listPage);
//		for(Operator op:this.getIntImpl().getAvailableOperators())
//			addPage(op.getOption().getWizardPage());
		addPage( new OclOperatorImpl().getOption().getWizardPage());

	}

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		
		this.workbench = workbench;
		this.selection = selection;
		this.intImpl= new WizardUserInterfaceImpl();
		this.intImpl.setEngine(BenchframeworkFactory.eINSTANCE.createEngine());	
		
	}


}
