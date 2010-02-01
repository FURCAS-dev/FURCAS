package de.hpi.sam.bp2009.benchframework.testrunWizard;


import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.ResultProcessor;

public class RunningPage extends WizardPage {
	
	private boolean benchmarked=false;
	
	protected RunningPage(String pageName) {
		super(pageName);
		setTitle("Running Page");
		setDescription("Start the Testrun.");
		setPageComplete(false);
	}
	public void createControl(Composite parent) {
		//create the widgets for the page
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		composite.setLayout(layout);
		
		Label label = new Label(composite, SWT.CENTER);
		label.setText("Click Run to Start the Run.");
		Button btn = new Button(composite, SWT.CENTER);
		btn.setText("START");
		btn.pack();
		btn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Button bt = (Button)e.getSource();
				bt.setEnabled(false);
				TestframeworkWizard wiz=((TestframeworkWizard)getWizard());
				wiz.getIntImpl().getEngine().getTestRuns().add(wiz.run);
				wiz.getIntImpl().getEngine().benchmark();
				EList<ResultObject> results= new BasicEList<ResultObject>();
				for(Operator op:wiz.run.getOperators())
					results.add(op.getResult());
				if(wiz.getIntImpl().getResultProcessor()!=null)
					wiz.getIntImpl().getResultProcessor().getResultPage();
				bt.setEnabled(true);
				benchmarked=true;

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}


		});
		//ProgressBar bar = new ProgressBar(composite, SWT.CENTER);
	    setControl(composite);
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return benchmarked;
	}
	@Override
	public IWizardPage getNextPage() {
		ResultProcessor rp = ((TestframeworkWizard)getWizard()).getIntImpl().getResultProcessor();
		if(rp!=null && rp.getResultPage()!=null )
			return rp.getResultPage();
		return super.getNextPage();
	}
}
