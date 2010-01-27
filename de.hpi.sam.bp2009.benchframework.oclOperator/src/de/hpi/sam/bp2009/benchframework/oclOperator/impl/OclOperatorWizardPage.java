package de.hpi.sam.bp2009.benchframework.oclOperator.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import de.hpi.sam.bp2009.benchframework.oclOperator.OclOptionObject;

public class OclOperatorWizardPage extends WizardPage {
	
	private OclOptionObject option;
	ArrayList<Text> textareas;
	
	protected OclOperatorWizardPage(String pageName) {
		super(pageName);
		setTitle("OCL Operator Configuration");
		setDescription("Set the options for the OCL Operator.");
		setPageComplete(false);
	}
	protected OclOperatorWizardPage(String pageName, OclOptionObject option) {
		this(pageName);
		this.option = option;
	}
	public void createControl(Composite parent) {
		//create the widgets for the page
		final Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
		
		Text textarea = new Text(composite, SWT.NONE);
		textarea.setSize(400, 10);
		textareas.add(textarea);
		
		Button addButton = new Button(composite, SWT.PUSH);
		addButton.setText("+");
		addButton.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// add another textarea to the page
				Text txt = new Text(composite, SWT.NONE);
				textareas.add(txt);
			}
		});
	    //setControl(composite);
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return true;
	}
	
	@Override
	public IWizardPage getNextPage() {
		// TODO create an EList with all constraints and pass it to the option object
		EList<String> constraints = new BasicEList<String>();
		for (Text tb: textareas){
			constraints.add(tb.getText());
		}
		option.setConstraints(constraints);
		return super.getNextPage();
	}
}
