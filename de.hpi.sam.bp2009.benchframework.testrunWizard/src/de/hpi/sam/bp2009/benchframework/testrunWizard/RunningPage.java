package de.hpi.sam.bp2009.benchframework.testrunWizard;


import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

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
				TestframeworkWizard wiz=((TestframeworkWizard)getWizard());
				wiz.getIntImpl().getEngine().getTestRuns().add(wiz.run);
				wiz.getIntImpl().getEngine().benchmark();
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
		return false;
	}
}
