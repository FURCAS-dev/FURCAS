package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.util.List;

import org.eclipse.jface.wizard.IWizardPage;

import de.hpi.sam.bp2009.benchframework.BenchframeworkFactory;
import de.hpi.sam.bp2009.benchframework.ResultProcessor;
import de.hpi.sam.bp2009.benchframework.TestRun;

/**
 * @author Philipp Berger
 *
 */
public class TestframeworkWizard extends AdvancedWizard {
	
	private ListPage listPage;
	private TestRun run;
	private RunningPage runningPage;
	private WizardUserInterfaceImpl intImpl;
	private ResultProcessor resultProcessor;
	private boolean couldBeFinished;

	public TestframeworkWizard() {
		setListPage(new ListPage("Module List"));
		getListPage().setWizard(this);
		
		setRunningPage(new RunningPage("RunningPage"));
		getRunningPage().setWizard(this);
		
		setRun(BenchframeworkFactory.eINSTANCE.createTestRun());
		
		setIntImpl(new WizardUserInterfaceImpl());
		getIntImpl().setEngine(BenchframeworkFactory.eINSTANCE.createEngine());
	}

	public void couldBeFinished() {
		couldBeFinished=false;
	}

	public WizardUserInterfaceImpl getIntImpl() {
		return intImpl;
	}

	@Override
	public IWizardPage getLastPage() {
		return getRunningPage();
	}
	@Override
	public IWizardPage getLeastPage() {
		if (resultProcessor == null)
			return null;
		resultProcessor.getResultPage().dispose();
		return resultProcessor.getResultPage();
	}
	private ListPage getListPage() {
		return listPage;
	}

	public List<ResultProcessor> getRegisteredResultProcessors() {
		// returns the first registered processor
		return this.getIntImpl().getEngine().getRegisteredResultProcessors();

	}

	public TestRun getRun() {
		return run;
	}

	RunningPage getRunningPage() {
		return runningPage;
	}

	@Override
	public IWizardPage getStartingPage() {
		return getListPage();
	}

	@Override
	public boolean performCancel() {
		this.setRun(BenchframeworkFactory.eINSTANCE.createTestRun());
		return super.performCancel();
	}

	@Override
	public boolean performFinish() {
		return couldBeFinished;
	}

	public void setIntImpl(WizardUserInterfaceImpl intImpl) {
		this.intImpl = intImpl;
	}

	private void setListPage(ListPage listPage) {
		this.listPage = listPage;
	}

	public void setResultProcessor(ResultProcessor obj) {
		if (resultProcessor != null)
			resultProcessor.getResultPage().setVisible(false);
		resultProcessor = obj;
		resultProcessor.getResultPage().setWizard(this);
		;
	}

	void setRun(TestRun run) {
		this.run = run;
	}

	void setRunningPage(RunningPage runningPage) {
		this.runningPage = runningPage;
	}

}
