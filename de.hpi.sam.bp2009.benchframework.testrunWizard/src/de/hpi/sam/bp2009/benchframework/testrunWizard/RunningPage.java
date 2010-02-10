package de.hpi.sam.bp2009.benchframework.testrunWizard;


import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.hpi.sam.bp2009.benchframework.Engine;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.ResultObject;

public class RunningPage extends WizardPage {
	final static String NEW_LINE = System.getProperty("line.separator");
	protected static final String RUNSUCCEED = "Yeah, benchmark complete!!";
	private boolean benchmarked=false;
	private Label error;
	private Composite composite;
	private ScrolledComposite scrolledComposite;
	
	protected RunningPage(String pageName) {
		super(pageName);
		setTitle("Running Page");
		setDescription("Start the Testrun.");
		setPageComplete(false);
	}
	public void createControl(Composite parent) {
		//create the widgets for the page
		scrolledComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		composite = new Composite(scrolledComposite, SWT.NONE);
		scrolledComposite.setContent(composite);
		GridLayout layout = new GridLayout(1, false);
		composite.setLayout(layout);
		
		Label label = new Label(composite, SWT.CENTER);
		label.setText("Click Run to Start the Run.");
		Button btn = new Button(composite, SWT.CENTER);
		error = new Label(composite, SWT.LEFT |SWT.H_SCROLL|SWT.V_SCROLL);    
		btn.setText("START");
		btn.pack();
		btn.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Button bt = (Button)e.getSource();
				bt.setEnabled(false);
				TestframeworkWizard wiz=((TestframeworkWizard)getWizard());
				Engine engine = wiz.getIntImpl().getEngine();
				engine.getTestRuns().add(wiz.getRun());
				try{
					engine.benchmark();
					scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				}catch(java.lang.Throwable e1){
					error.setText(e1.getMessage()+"\n");
					composite.layout();
					scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
					return;
				}
				if(engine.getExeptionsDuringLastRun()!=null){
					StringBuilder sb= new StringBuilder();
					if(engine.getExeptionsDuringLastRun().size()>0)
						for(Exception ex: engine.getExeptionsDuringLastRun())
							sb.append(getCustomStackTrace(ex));
					else
						sb.append(RUNSUCCEED);
					error.setText(sb.toString());
				}else{
					error.setText(RUNSUCCEED);
				}
				error.pack();
				EList<ResultObject> results= new BasicEList<ResultObject>();
				for(Operator op:wiz.getRun().getOperators())
					results.add(op.getResult());
				if(wiz.getIntImpl().getResultProcessor()!=null)
					wiz.getIntImpl().getResultProcessor().getResultPage();
				bt.setEnabled(true);
				benchmarked=true;
				composite.layout();
				scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
				wiz.getContainer().updateButtons();

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do

			}


		});
		//ProgressBar bar = new ProgressBar(composite, SWT.CENTER);
	    setControl(scrolledComposite);

	}
	
	@Override
	public boolean canFlipToNextPage() {
		return benchmarked;
	}
	
	@Override
	public IWizardPage getNextPage() {
		IWizardPage page=super.getNextPage();
		if(page==null)
			((TestframeworkWizard)getWizard()).couldBeFinished();
		else if(page.getControl()!=null)
			page.getControl().update();
		return page;
	}
	public static String getCustomStackTrace(Throwable aThrowable) {
		//add the class name and any message passed to constructor
		final StringBuilder result = new StringBuilder();
		result.append(aThrowable.toString());
		result.append(NEW_LINE);

		//add each element of the stack trace
		for (StackTraceElement element : aThrowable.getStackTrace() ){
		result.append( element );
		result.append( NEW_LINE );
		}
		return result.toString();
		}

}
