package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;


import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class RandomGeneratorWizardPage extends WizardPage {

	private static final String[] FILTER_NAMES = {"Ecore Model (*.ecore)"};
	private static final String[] FILTER_EXTS = {"*.ecore"};
	
	Text fileName;
	
	protected RandomGeneratorWizardPage(String pageName) {
		super(pageName);
		setTitle("Random Generator Configuration");
		setDescription("Set the options for the Random Generator.");
		setPageComplete(false);
	}

	public void createControl(Composite parent) {
		//create the widgets for the page
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
		fileName = new Text(composite, SWT.BORDER);
		Button open = new Button(composite, SWT.PUSH);
	    open.setText("Open...");
	    open.addSelectionListener(new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent event) {
	        // User has selected to open a single file
	        FileDialog dlg = new FileDialog(new Shell(), SWT.OPEN);
	        dlg.setFilterNames(FILTER_NAMES);
	        dlg.setFilterExtensions(FILTER_EXTS);
	        String fn = dlg.open();
	        if (fn != null) {
	          fileName.setText(fn);
	        }
	      }
	    });
	    //setControl(composite);
	}
	
	@Override
	public boolean canFlipToNextPage() {
		// TODO Auto-generated method stub
		if ("".equals(fileName.getText())){
				return false;
		}
		return true;
	}
}
